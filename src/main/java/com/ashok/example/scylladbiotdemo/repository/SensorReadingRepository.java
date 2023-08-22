package com.ashok.example.scylladbiotdemo.repository;

import com.ashok.example.scylladbiotdemo.entity.SensorReading;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface SensorReadingRepository extends CassandraRepository<SensorReading, String> {
}