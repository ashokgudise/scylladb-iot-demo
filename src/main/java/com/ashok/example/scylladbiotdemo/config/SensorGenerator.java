package com.ashok.example.scylladbiotdemo.config;

import com.ashok.example.scylladbiotdemo.entity.SensorReading;
import com.ashok.example.scylladbiotdemo.repository.SensorReadingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Component
@Slf4j
public class SensorGenerator {

    private final SensorReadingRepository sensorReadingRepository;

    @Autowired
    public SensorGenerator(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }
    private final Random random = new Random();
    public SensorReading generateSensorReading() {

        // Assuming 10 sensors
        String sensorId = "sensor_" + random.nextInt(10);
        // Random value between 10 and 30
        double value = 10 + random.nextDouble() * 20;
        Date timestamp = new Date();

        SensorReading sensorReading = new SensorReading();

        sensorReading.setId(UUID.randomUUID());
        sensorReading.setName(sensorId);
        sensorReading.setValue(value);
        sensorReading.setTimestamp(timestamp);

        return sensorReading;
    }

    public SensorReading saveSensorReading(SensorReading reading){
        SensorReading sensorReading = this.sensorReadingRepository.save(reading);
        log.info("Sensor Reading recorded {}", reading.getName());
        return sensorReading;
    }

}
