# web-healthcare
Web module to check server status

## Maven
```
<dependency>
    <groupId>com.harium.web</groupId>
    <artifactId>healthcare</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage
Using raw [SparkJava](http://sparkjava.com/)
```
new HealthCare().init();
```

Using [Harium Web](https://github.com/Harium/web)
```
Web.register(HealthCare.class);
```

Then, access health route via GET:
```
http://localhost:8080/health
```
