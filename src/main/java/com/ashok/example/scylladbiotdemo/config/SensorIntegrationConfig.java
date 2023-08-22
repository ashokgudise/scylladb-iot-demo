package com.ashok.example.scylladbiotdemo.config;

import com.ashok.example.scylladbiotdemo.repository.SensorReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Pollers;
import org.springframework.messaging.support.GenericMessage;

import java.time.Duration;

@Configuration
public class SensorIntegrationConfig {

    private final SensorReadingRepository sensorReadingRepository;

    private final SensorGenerator sensorGenerator;

    @Autowired
    public SensorIntegrationConfig(SensorReadingRepository sensorReadingRepository,
                           SensorGenerator sensorGenerator) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.sensorGenerator = sensorGenerator;
    }

    @Bean
    public IntegrationFlow sensorFlow(){
        return IntegrationFlow.from(() -> new GenericMessage<>(sensorGenerator.generateSensorReading()),
                        c -> c.poller(Pollers.fixedDelay(Duration.ofSeconds(5)))
                                .autoStartup(true)
                                .id("sensor-iot-flow-demo"))
                .handle("sensorGenerator","saveSensorReading")
                .channel("nullChannel")
                .get();
    }
}
