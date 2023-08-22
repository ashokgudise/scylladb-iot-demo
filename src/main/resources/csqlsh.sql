
-- Create the keyspace
CREATE KEYSPACE IF NOT EXISTS sensor_db WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

-- Switch to the keyspace
USE sensor_db;

-- Create the sensor_readings table
CREATE TABLE IF NOT EXISTS sensor_readings (
                                               id UUID PRIMARY KEY,
                                               name TEXT,
                                               value DOUBLE,
                                               timestamp TIMESTAMP
);

-- Create an index on sensorName for efficient queries
CREATE INDEX IF NOT EXISTS sensor_name_idx ON sensor_readings (sensorName;

-- Create an index on timestamp for time-based queries
    CREATE INDEX IF NOT EXISTS timestamp_idx ON sensor_readings (timestamp);TEXT,
                                               value DOUBLE,
                                               timestamp TIMESTAMP
);

-- Create an index on sensorName for efficient queries
CREATE INDEX IF NOT EXISTS sensor_name_idx ON sensor_readings (sensorName;

-- Create an index on timestamp for time-based queries
    CREATE INDEX IF NOT EXISTS timestamp_idx ON sensor_readings (timestamp);