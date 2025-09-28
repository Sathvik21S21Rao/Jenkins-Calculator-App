# Use a minimal Java runtime
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the frontend JAR
COPY target/frontend-1.0-SNAPSHOT.jar /app/
COPY static /app/frontend/static

EXPOSE 8080

# Run the frontend server with all dependencies in the classpath
CMD ["java", "-cp", "frontend-1.0-SNAPSHOT.jar", "com.iiitb.frontend.FrontendServer"]