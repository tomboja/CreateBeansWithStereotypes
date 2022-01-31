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
   
   1. Check that the bean is added to the spring context like following
   2. 
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
