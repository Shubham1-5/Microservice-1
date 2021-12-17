# Microservice-1

Demo of Microservice-1 up and running along with communicatipon with another Microservice-2

## Installation

- Install Java (minimum requirement is Java 8)
- Setup environment variables for Java configuration
- Install IntellIJ

## Initial step to configure this

- Clone eureka-server repository, config-server repository and start the server
- Clone Microservice-2 and Microservice-1 also respectively and start
- Clone APIGateway repository to hide the microservices from external client

## API calls

- http://127.0.0.1:8761/ (Eureka server system status)
- http://127.0.0.1:8888/config-client/default/master (Config server status)
- http://127.0.0.1:7071/ms1/v1/messages (Microservice-1 response)
- http://127.0.0.1:7072/ms2/v1/messages (Microservice-2 response)
- http://127.0.0.1:7000/ms1/v1/messages (Microservice-1 response through API Gateway)
- http://127.0.0.1:7000/ms2/v1/messages (Microservice-2 response through API Gateway)

## Note :

- This project uses Netfix Eureka Server for service discovery and registration for various microservices
- For time-being we are using currently two microservices taking help of this Eureka server (Microservice-1 and Microservice-2)
