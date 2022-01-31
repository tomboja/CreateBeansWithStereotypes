package domain;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: CreateBeansWithStereotypes
 * @Author: tdessalegn
 * @Date: 1/31/22
 */

/**
 * Using @Component stereotype to add Parrot bean to spring context
 */
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
