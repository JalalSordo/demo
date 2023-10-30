# First stage: JDK with GraalVM
FROM ghcr.io/graalvm/graalvm-ce:ol8-java17-22.3.3 as build

# Update package lists and Install Maven
RUN microdnf update -y && microdnf install -y maven

WORKDIR /usr/src/app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

RUN mvn clean install -P native -DskipTests

# Second stage: Lightweight debian-slim image
FROM debian:bookworm-slim

WORKDIR /app

# Copy the native binary from the build stage
COPY --from=build /usr/src/app/target/demo /app/demo

# Run the application
CMD ["/app/demo"]
