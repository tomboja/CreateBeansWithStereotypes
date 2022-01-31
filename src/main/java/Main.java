import config.Config;
import domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ProjectName: CreateBeansWithStereotypes
 * @Author: tdessalegn
 * @Date: 1/31/22
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Parrot parrot = context.getBean(Parrot.class);
        //parrot.setName("Another name");

        System.out.println("parrot = " + parrot);
    }
}
