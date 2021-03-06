package domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
        this.name = "no-name"; // default Parrot name
    }

    @PostConstruct
    public void assignName() {
        this.name = "Jamila";
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
