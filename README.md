## Using @Component to add beans to spring context

This way of adding beans to Spring Context is ***stereotype annotations***

NOTE: Remember, adding beans to the Spring context is essential because it’s how you make Spring aware of 
the object instances of your application, which need to be managed by the framework.

With stereotype annotations, you add the annotation above the class for which you need to have an instance in the 
Spring context. When doing so, we say that you’ve marked the class as a component. When the app creates the Spring 
context, Spring creates an instance of the class you marked as a component and adds that instance to its context. 

We’ll still have a configuration class when we use this approach to tell Spring where to look for the classes 
annotated with stereotype annotations. Moreover, you can use both the approaches (using @Bean and stereotype 
annotations together)

The steps we need to follow in the process are as follows:

1. Using the ***@Component*** annotation, mark the classes for which you want Spring to add an instance to its context.
2. Using ***@ComponentScan*** annotation over the configuration class, instruct Spring on where to find the classes you marked.


#### Example:
1. Add ***@Component*** annotation to the class you want to add to spring context
    ```
    @Component
    public class Parrot {
        private String name;

        public Parrot() {
            this.name = "Koko"; // default Parrot name
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Parrot{" +
                "name='" + name + '\'' +
                '}';
        }
    }
   ```
   
2. Add ***@ComponentScan*** annotation to the Configuration file and also tell the config where to look for the bean to be added

    ```
    @Configuration
    @ComponentScan(basePackages = "domain") // Tells Spring where to look for classes annotated with stereotype annotations
    public class Config {
    }
   ```
   
3. Check that the bean is added to the spring context like following
 
       ```
       public class Main {
          public static void main(String[] args) {
              AnnotationConfigApplicationContext context =
                 new AnnotationConfigApplicationContext(Config.class);

              Parrot parrot = context.getBean(Parrot.class);

              System.out.println("parrot = " + parrot);
         }
       }
   ```

Using @Bean, we were able to define a name for each of the Parrot instances we added to the 
Spring context, but using @Component, we didn't get a chance to do something after Spring 
called the constructor of the Parrot class. We can do so, by using ***@PostConstruct*** annotation
in the component class to instruct spring execute this code block after bean creation. Thus in the
component class, we can add as follows:

```
   @Component
   public class Parrot {
      private String name;
       
      @PostConstruct
      public void init() {
          this.name = "Tadaa";
      }
  
   }
```

For this to work properly, the following dependency need to be added for JDK version 11 and above.

```
   <dependency>
      <groupId>javax.annotation</groupId>
      <artifactId>javax.annotation-api</artifactId>
      <version>1.2.0</version> // Version maybe different
   </dependency>
```

NOTE: _You don’t need to add this dependency if you use a Java version smaller than Java 11. 
Before Java 11, the Java EE dependencies were part of the JDK. With Java 11, 
the JDK was cleaned of the APIs not related to SE, including the Java EE dependencies._

## Comparing ***@Bean*** vs ***@Component*** ways adding beans to spring context

### <u> 1. Using the @Bean annotation </u>                                                       

1. You have full control over the instance creation you add to the Spring context. 
   It is your responsibility to create and configure the instance in the body of the method 
   annotated with @Bean. Spring only takes that instance and adds it to the context as-is.

2. You can use this method to add more instances of the same type to the Spring context. 

3. You can use the @Bean annotation to add to the Spring context any object instance. 
   The class that defines the instance does not need to be defined in your app. 
   Remember, earlier we added a String and an Integer to the Spring context.

4. You need to write a separate method for each bean you create, 
   which adds boilerplate code to your app. For this reason, 
   we prefer using @Bean as a second option to stereotype annotations in our projects.

### <u> 2. Using stereotype annotations </u>  

1. You only have control over the instance after the framework creates it.

2. This way, you can only add one instance of the class to the context.

3. You can use stereotype annotations only to create beans of the classes 
  your application owns. For example, you could not add a bean of type 
  String or Integer with the @Bean annotation 
  because you don’t own these classes to change them by adding a stereotype annotation.

4. Using stereotype annotations to add beans to the Spring context does not add 
  boilerplate code to your app. You’ll prefer this approach in general for the classes 
  that belong to your app.