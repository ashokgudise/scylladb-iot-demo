# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file from the host to the container
COPY target/scylladb-iot-demo.jar /app/scylladb-iot-demo.jar

# Define the command to run the application
CMD ["java", "-jar", "scylladb-iot-demo.jar"]

#docker build -t ashok-demos/scylladb-iot-demo .