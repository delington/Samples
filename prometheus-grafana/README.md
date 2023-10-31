# Spring Boot App with Prometheus and Grafana

This project demonstrates how to set up a Spring Boot application with Prometheus and Grafana for monitoring.

## Prerequisites

Before you begin, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Docker](https://www.docker.com/)
- [Podman](https://podman.io/)
- [Grafana](https://grafana.com/)
- [Prometheus](https://prometheus.io/)

## Getting Started

1. Clone this repository:

   ```shell
   git clone https://github.com/your-username/your-spring-boot-project.git
   cd your-spring-boot-project

2. Start the Spring Boot application:
   - `./mvnw spring-boot:run`
   - you reach Spring Boot app on `localhost:8080`

3. Launch Grafana and Prometheus using Docker or Podman. 

- Here's an example for running Prometheus with Podman:

  - `podman run --net=host -v B:/git/samples/prometheus-grafana/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus`
  - you reach Prometheus on `localhost:9090`

- If you run Grafana with Docker you should also run with `network mode: host`:

  - `podman run --net=host -v grafana/grafana`
  - you reach Grafana on `localhost:3000`