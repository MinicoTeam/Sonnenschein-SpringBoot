package Sonnenschein.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WetterApiResponse {
	@JsonProperty("current")
	private Current current;

	@JsonProperty("daily")
	private Daily daily;

	@JsonProperty("hourly")
	private Hourly hourly;

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	public Daily getDaily() {
		return daily;
	}

	public void setDaily(Daily daily) {
		this.daily = daily;
	}


	public Hourly getHourly() {
		return hourly;
	}

	public void setHourly(Hourly hourly) {
		this.hourly = hourly;
	}



	public static class Current {
		@JsonProperty("temperature_2m")
		private double temperature_2m;
		@JsonProperty("relative_humidity_2m")
		private double relativeHumidity_2m;
		@JsonProperty("wind_speed_10m")
		private double windSpeed_10m;
		@JsonProperty("wind_direction_10m")
		private double windDirection_10m;
		@JsonProperty("precipitation")
		private double precipitation;
		@JsonProperty("rain")
		private double rain;
		@JsonProperty("showers")
		private double showers;
		@JsonProperty("weather_code")
		private int weatherCode;
		@JsonProperty("time")
		private String time;
		public double getTemperature_2m() {
			return temperature_2m;
		}
		public void setTemperature_2m(double temperature_2m) {
			this.temperature_2m = temperature_2m;
		}
		public double getRelativeHumidity_2m() {
			return relativeHumidity_2m;
		}
		public void setRelativeHumidity_2m(double relativeHumidity_2m) {
			this.relativeHumidity_2m = relativeHumidity_2m;
		}
		public double getWindSpeed_10m() {
			return windSpeed_10m;
		}
		public void setWindSpeed_10m(double windSpeed_10m) {
			this.windSpeed_10m = windSpeed_10m;
		}
		public double getWindDirection_10m() {
			return windDirection_10m;
		}
		public void setWindDirection_10m(double windDirection_10m) {
			this.windDirection_10m = windDirection_10m;
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
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}


	}

	public static class Daily {
		@JsonProperty("time")
		private String[] time;
		@JsonProperty("temperature_2m_max")
		private double[] temperature_2m_max;
		@JsonProperty("temperature_2m_min")
		private double[] temperature_2m_min;
		@JsonProperty("precipitation_sum")
		private double[] precipitation_sum;
		@JsonProperty("cloudcover_avg")
		private double[] cloudcover_avg;
		@JsonProperty("wind_speed_10m_max")
		private double[] wind_speed_10m_max;
		@JsonProperty("wind_direction_10m_dominant")
		private double[] wind_direction_10m_dominant;
		public String[] getTime() {
			return time;
		}
		public void setTime(String[] time) {
			this.time = time;
		}
		public double[] getTemperature_2m_max() {
			return temperature_2m_max;
		}
		public void setTemperature_2m_max(double[] temperature_2m_max) {
			this.temperature_2m_max = temperature_2m_max;
		}
		public double[] getTemperature_2m_min() {
			return temperature_2m_min;
		}
		public void setTemperature_2m_min(double[] temperature_2m_min) {
			this.temperature_2m_min = temperature_2m_min;
		}
		public double[] getPrecipitation_sum() {
			return precipitation_sum;
		}
		public void setPrecipitation_sum(double[] precipitation_sum) {
			this.precipitation_sum = precipitation_sum;
		}
		public double[] getCloudcover_avg() {
			return cloudcover_avg;
		}
		public void setCloudcover_avg(double[] cloudcover_avg) {
			this.cloudcover_avg = cloudcover_avg;
		}
		public double[] getWind_speed_10m_max() {
			return wind_speed_10m_max;
		}
		public void setWind_speed_10m_max(double[] wind_speed_10m_max) {
			this.wind_speed_10m_max = wind_speed_10m_max;
		}
		public double[] getWind_direction_10m_dominant() {
			return wind_direction_10m_dominant;
		}
		public void setWind_direction_10m_dominant(double[] wind_direction_10m_dominant) {
			this.wind_direction_10m_dominant = wind_direction_10m_dominant;
		}


	}


	public static class Hourly {
		@JsonProperty("time")
		private String[] time;
		@JsonProperty("temperature_2m")
		private double[] temperature_2m;
		@JsonProperty("precipitation_probability")
		private double[] precipitation_probability;
//		@JsonProperty("cloud_cover")
//		private double[] cloud_cover;
		@JsonProperty("wind_speed_10m")
		private double[] wind_speed_10m;
		@JsonProperty("wind_speed_80m")
		private double[] wind_speed_80m;
		@JsonProperty("wind_speed_120m")
		private double[] wind_speed_120m;
		@JsonProperty("wind_speed_180m")
		private double[] wind_speed_180m;
		
		public String[] getTime() {
			return time;
		}
		public void setTime(String[] time) {
			this.time = time;
		}
		public double[] getTemperature_2m() {
			return temperature_2m;
		}
		public void setTemperature_2m(double[] temperature_2m) {
			this.temperature_2m = temperature_2m;
		}
		public double[] getPrecipitation_probability() {
			return precipitation_probability;
		}
		public void setPrecipitation_probability(double[] precipitation_probability) {
			this.precipitation_probability = precipitation_probability;
		}
//		public double[] getCloud_cover() {
//			return cloud_cover;
//		}
//		public void setCloud_cover(double[] cloud_cover) {
//			this.cloud_cover = cloud_cover;
//		}
		public double[] getWind_speed_10m() {
			return wind_speed_10m;
		}
		public void setWind_speed_10m(double[] wind_speed_10m) {
			this.wind_speed_10m = wind_speed_10m;
		}
		public double[] getWind_speed_80m() {
			return wind_speed_80m;
		}
		public void setWind_speed_80m(double[] wind_speed_80m) {
			this.wind_speed_80m = wind_speed_80m;
		}
		public double[] getWind_speed_120m() {
			return wind_speed_120m;
		}
		public void setWind_speed_120m(double[] wind_speed_120m) {
			this.wind_speed_120m = wind_speed_120m;
		}
		public double[] getWind_speed_180m() {
			return wind_speed_180m;
		}
		public void setWind_speed_180m(double[] wind_speed_180m) {
			this.wind_speed_180m = wind_speed_180m;
		}
	}
}