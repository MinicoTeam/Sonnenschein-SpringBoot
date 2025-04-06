package Sonnenschein.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WetterData {

	// parameters for current weather 
	// in index.html - "weatherData"
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String timestamp;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private double windDirection;
    private double precipitation;
    private double rain;
    private double showers;
    private int weatherCode;

    // parameters for daily forecast
    // in index.html forecast
    private String date;
    private double temperatureMax;
    private double temperatureMin;
    private double cloudStatus;
    private double windSpeedMax;
    private double windDirectionDominant;

    // parameters for Hourly forecast
    // in index.html - forecastHourly 
    private String timestamp_hourly;
    private double temperature_2m;
    private double precipitation_probability;
    // private double cloud_cover;
    private double windSpeed_10m;
    private double windSpeed_80m;
    private double windSpeed_120m;
    private double windSpeed_180m;
    
    // Getters and Setters

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }
    
    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getShowers() {
        return showers;
    }

    public void setShowers(double showers) {
        this.showers = showers;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getCloudStatus() {
        return cloudStatus;
    }

    public void setCloudStatus(double cloudStatus) {
        this.cloudStatus = cloudStatus;
    }

    public double getWindSpeedMax() {
        return windSpeedMax;
    }

    public void setWindSpeedMax(double windSpeedMax) {
        this.windSpeedMax = windSpeedMax;
    }

    public double getDirectionDominant() {
        return windDirectionDominant;
    }

    public void setWindDirectionDominant(double windDirectionDominant) {
        this.windDirectionDominant = windDirectionDominant;
    }

    
    // hourly
	public String getTimestamp_hourly() {
		return timestamp_hourly;
	}

	public void setTimestamp_hourly(String timestamp_hourly) {
		this.timestamp_hourly = timestamp_hourly;
	}

	public double getTemperature_2m() {
		return temperature_2m;
	}

	public void setTemperature_2m(double temperature_2m) {
		this.temperature_2m = temperature_2m;
	}

	public double getPrecipitation_probability() {
		return precipitation_probability;
	}

	public void setPrecipitation_probability(double precipitation_probability) {
		this.precipitation_probability = precipitation_probability;
	}

//	public double getCloud_cover() {
//		return cloud_cover;
//	}
//
//	public void setCloud_cover(double cloud_cover) {
//		this.cloud_cover = cloud_cover;
//	}

	public double getWindSpeed_10m() {
		return windSpeed_10m;
	}

	public void setWindSpeed_10m(double windSpeed_10m) {
		this.windSpeed_10m = windSpeed_10m;
	}

	public double getWindSpeed_80m() {
		return windSpeed_80m;
	}

	public void setWindSpeed_80m(double windSpeed_80m) {
		this.windSpeed_80m = windSpeed_80m;
	}

	public double getWindSpeed_120m() {
		return windSpeed_120m;
	}

	public void setWindSpeed_120m(double windSpeed_120m) {
		this.windSpeed_120m = windSpeed_120m;
	}

	public double getWindSpeed_180m() {
		return windSpeed_180m;
	}

	public void setWindSpeed_180m(double windSpeed_180m) {
		this.windSpeed_180m = windSpeed_180m;
	}

	public double getWindDirectionDominant() {
		return windDirectionDominant;
	}
    
    
}