# SPRINGBOOT-RABBITMQ-BASIC
THIS  REPOSITOERY IS  A OVERVIEW OF  HOW WE CAN USE RABBITMQ USING SPRINGBOOT

Instructions for testing the Proof of Concept (POC) with RabbitMQ:

1. Pull the RabbitMQ image from Docker Hub by running the following command:
   docker pull rabbitmq:3.10.25-management

2. Start the RabbitMQ container locally using the following command:
   docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.10.25-management

3. RabbitMQ should now be running. You can monitor it by accessing the RabbitMQ management interface at the following URL:
   http://localhost:15672/

4. Use the following credentials to log in to the RabbitMQ management interface:
   Username: guest
   Password: guest

Please note:
- RabbitMQ version 3.10.25 with the management plugin is being used.
- The container will be removed after it is stopped (--rm option).
- The management interface is available at http://localhost:15672/.
- The default login credentials are provided (guest/guest). In a production environment, it is crucial to change these credentials for security reasons.
