package Sonnenschein.service;

import Sonnenschein.model.GeocodingApiResponse;
import Sonnenschein.model.WetterApiResponse;
import Sonnenschein.model.WetterApiResponse.Current;
import Sonnenschein.model.WetterData;
import Sonnenschein.repository.WetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WetterService {

    @Autowired
    private WetterRepository wetterRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL_hourly = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&hourly=temperature_2m,precipitation_probability,cloud_cover,wind_speed_10m,wind_speed_80m,wind_speed_120m,wind_speed_180m";
    private final String API_URL_daily = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&daily=temperature_2m_max,temperature_2m_min,precipitation_sum,wind_speed_10m_max,wind_direction_10m_dominant&timezone=auto";
    private final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&hourly=temperature_2m&current=temperature_2m,relative_humidity_2m,wind_speed_10m,wind_direction_10m,precipitation,rain,showers,weather_code";
    
    private final String GEOCODING_API_URL = "https://nominatim.openstreetmap.org/search?q={location}&format=json";
    
    public WetterData fetchCurrentWeather(String location) {

    	// find the coordinates of the city entered by user
        String geocodingUrl = GEOCODING_API_URL.replace("{location}", location);
        GeocodingApiResponse[] geocodingResponse = restTemplate.getForObject(geocodingUrl, GeocodingApiResponse[].class);

        if (geocodingResponse == null || geocodingResponse.length == 0) {
            throw new RuntimeException("Geocoding API returned no results");
        }
        
        double lat = Double.parseDouble(geocodingResponse[0].getLat());
        double lon = Double.parseDouble(geocodingResponse[0].getLon());
        
        for (GeocodingApiResponse resp : geocodingResponse) {
            System.out.println("Latitude: " + resp.getLat());
        }
        
        System.out.println(lat);
        System.out.println(lon);

        String url = API_URL.replace("{lat}", String.valueOf(lat)).replace("{lon}", String.valueOf(lon));
        WetterApiResponse response = restTemplate.getForObject(url, WetterApiResponse.class);

        System.out.println(url);
        System.out.println(response.getCurrent().getTemperature_2m());
        
        WetterData wetterData = new WetterData();
        if (response != null && response.getCurrent() != null) {
            wetterData.setTemperature(response.getCurrent().getTemperature_2m());
            wetterData.setHumidity(response.getCurrent().getRelativeHumidity_2m());
            wetterData.setWindSpeed(response.getCurrent().getWindSpeed_10m());
            wetterData.setWindDirection(response.getCurrent().getWindDirection_10m());
            wetterData.setPrecipitation(response.getCurrent().getPrecipitation());
            wetterData.setRain(response.getCurrent().getRain());
            wetterData.setShowers(response.getCurrent().getShowers());
            wetterData.setWeatherCode(response.getCurrent().getWeatherCode());
            wetterData.setTimestamp(response.getCurrent().getTime());
            wetterRepository.save(wetterData); // Save in H2 Database
        }
        return wetterData;
    }
    
    
    public List<WetterData> fetchHourlyForecast(String location) {
        double lat = 50.7766; // Beispiel: Aachen
        double lon = 6.0834;

        String url = API_URL_hourly.replace("{lat}", String.valueOf(lat)).replace("{lon}", String.valueOf(lon));
        WetterApiResponse response = restTemplate.getForObject(url, WetterApiResponse.class);

        List<WetterData> forecast = new ArrayList<>();
        if (response != null && response.getHourly() != null) {
            for (int i = 0; i < ((response.getHourly()).getTime().length); i++) {
                WetterData wetterData = new WetterData();
                wetterData.setTimestamp_hourly(response.getHourly().getTime()[i]);
                wetterData.setTemperature_2m(response.getHourly().getTemperature_2m()[i]);
                wetterData.setPrecipitation_probability(response.getHourly().getPrecipitation_probability()[i]);
                //wetterData.setCloud_cover(response.getHourly().getCloud_cover()[i]);
                wetterData.setWindSpeed_10m(response.getHourly().getWind_speed_10m()[i]);
                wetterData.setWindSpeed_80m(response.getHourly().getWind_speed_80m()[i]);
                wetterData.setWindSpeed_120m(response.getHourly().getWind_speed_120m()[i]);
                wetterData.setWindSpeed_180m(response.getHourly().getWind_speed_180m()[i]);
                forecast.add(wetterData);
                wetterRepository.save(wetterData); // Save in H2 Database
            }
        }
        return forecast;
    }

    public List<WetterData> fetchDailyForecast(String location) {
        double lat = 50.7766; // Beispiel: Aachen
        double lon = 6.0834;

        String url = API_URL_daily.replace("{lat}", String.valueOf(lat)).replace("{lon}", String.valueOf(lon));
        WetterApiResponse response = restTemplate.getForObject(url, WetterApiResponse.class);

        List<WetterData> forecast = new ArrayList<>();
        if (response != null && response.getDaily() != null) {
            for (int i = 0; i < ((response.getDaily()).getTime().length); i++) {
                WetterData wetterData = new WetterData();
                wetterData.setDate((response.getDaily()).getTime()[i]);
                wetterData.setTemperature(response.getDaily().getTemperature_2m_max()[i]);
                wetterData.setPrecipitation(response.getDaily().getPrecipitation_sum()[i]);
//                wetterData.setCloudStatus(response.getDaily().getCloudcover_avg()[i]);
                wetterData.setWindSpeed(response.getDaily().getWind_speed_10m_max()[i]);
                wetterData.setWindDirection(response.getDaily().getWind_direction_10m_dominant()[i]);
                forecast.add(wetterData);
                wetterRepository.save(wetterData); // Save in H2 Database
            }
        }
        return forecast;
    }

    public List<WetterData> fetchThreeDayForecast(String location) {
        return fetchDailyForecast(location).subList(0, 3);
    }
}