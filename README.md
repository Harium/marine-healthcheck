# web-healthcare
Web module to check server status.
It creates a "/health" route in your server if status

## Maven
```
<dependency>
    <groupId>com.harium.marine</groupId>
    <artifactId>healthcheck</artifactId>
    <version>1.1.0</version>
</dependency>
```

## Usage
Using raw [SparkJava](http://sparkjava.com/)
```
new HealthCheck().init();
```

Using [Harium Web](https://github.com/Harium/web)
```
Web.register(HealthCheck.class);
```

Then, access /health route via GET:
```
http://localhost:8080/health
```
