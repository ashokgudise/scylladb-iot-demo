package com.ashok.example.scylladbiotdemo.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table("sensor_readings")
@Data
public class SensorReading {

    @PrimaryKey
    private UUID id;
    private String name;
    private double value;
    private Date timestamp;
}
