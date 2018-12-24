**Account Service**

This project is a demo for a eureka client implemented as a REST controller for accounts.

We need to annotate a @Configuration with either @EnableDiscoveryClient or @EnableEurekaClient – note that this annotation is optional if we have the spring-cloud-starter-netflix-eureka-client dependency on the classpath.

Dependencies:

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-starter</artifactId>
    <version>2.0.2.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>2.0.1.RELEASE</version>
</dependency>
```

Account Controller is a @RestController that manages Account Operations.

Next, we have to set-up an application.yml with a configured Spring application name to uniquely identify our client in the list of registered applications.

We can let Spring Boot choose a random port for us because later we are accessing this service with its name, and finally, we have to tell our client, where it has to locate the registry:

```
spring:
  application:
    name: account-service
server:
  port: 0
eureka:
  client:
    serviceUrl:
      defaultZone: ${EUREKA_URI:http://localhost:8761/eureka}
  instance:
    preferIpAddress: true
```    

Now we will run the client and point our browser to http://localhost:8761 again, to see its registration status on the Eureka Dashboard.