package Sonnenschein.service;


import Sonnenschein.model.SensorData; 
import Sonnenschein.repository.SensorRepository;
import jakarta.annotation.PostConstruct;

import org.eclipse.paho.client.mqttv3.MqttClient; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
  
  @Service
  public class SensorService {

	  @Autowired
	    private MqttClient mqttClient;

	    @Autowired
	    private SensorRepository sensorRepository;

	    @PostConstruct
	    public void init() {
	        try {
	            mqttClient.connect();
	            System.out.println("MQTT Client connected");
	            fetchRoomData();
	        } catch (Exception e) {
	            System.err.println("MQTT Client connection failed: " + e.getMessage());
	        }
	    }

	    public void fetchRoomData() {
	        try {
	            mqttClient.subscribe("shellies/shelly-ht-3D8530/sensor/temperature", (topic, message) -> {
	                String payload = new String(message.getPayload());
	                System.out.println("Received temperature message: " + payload);
	                try {
	                    double temperature = Double.parseDouble(payload);
	                    saveSensorData(temperature, null);
	                } catch (NumberFormatException e) {
	                    System.err.println("Invalid temperature data: " + payload);
	                }
	            });
	            System.out.println("Subscribed to temperature topic");

	            mqttClient.subscribe("shellies/shelly-ht-3D8530/sensor/humidity", (topic, message) -> {
	                String payload = new String(message.getPayload());
	                System.out.println("Received humidity message: " + payload);
	                try {
	                    double humidity = Double.parseDouble(payload);
	                    saveSensorData(null, humidity);
	                } catch (NumberFormatException e) {
	                    System.err.println("Invalid humidity data: " + payload);
	                }
	            });
	            System.out.println("Subscribed to humidity topic");
	        } catch (Exception e) {
	            System.err.println("Error occurred: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    private void saveSensorData(Double temperature, Double humidity) {
	        SensorData sensorData = new SensorData();
	        sensorData.setRoomTemperature(temperature != null ? temperature : 0);
	        sensorData.setHumidity(humidity != null ? humidity : 0);
	        sensorData.setTimestamp(java.time.LocalDateTime.now().toString());
	        sensorRepository.save(sensorData);
	        System.out.println("Sensor data saved: " + sensorData);
	    }
	}