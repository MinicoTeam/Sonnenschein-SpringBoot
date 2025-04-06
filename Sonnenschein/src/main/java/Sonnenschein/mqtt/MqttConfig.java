package Sonnenschein.mqtt;


import org.eclipse.paho.client.mqttv3.MqttClient; import
org.eclipse.paho.client.mqttv3.MqttConnectOptions; import
org.eclipse.paho.client.mqttv3.persist.MemoryPersistence; import
org.springframework.context.annotation.Bean; import
org.springframework.context.annotation.Configuration;

@Configuration public class MqttConfig {

	@Bean
    public MqttClient mqttClient() throws Exception {
        try {
            MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId(), new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            client.connect(options);
            System.out.println("MQTT Client connected");
            return client;
        } catch (Exception e) {
            System.err.println("MQTT Client connection failed: " + e.getMessage());
            throw e;
        }
    }
}

