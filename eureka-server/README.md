**Demo Project for Eureka Server**

To implement a Eureka Server for using as service registry is as easy as: adding spring-cloud-starter-netflix-eureka-server to the dependencies, enable the Eureka Server in a @SpringBootApplication per annotate it with @EnableEurekaServer and configure some properties.


```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>    
</dependency>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
The main application class:


```@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

An application.yml will be our configuration file:

```
server:
  port: 8761
eureka:
  client:
    registerWithEureka: false
    fetchRegistry: false
```
    
The default application port for Eureka Server is the 8761.

Now we will point our browser to http://localhost:8761 to view the Eureka dashboard, where we will later inspecting the registered instances.




