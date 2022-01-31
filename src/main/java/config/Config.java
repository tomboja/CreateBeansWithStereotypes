package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: CreateBeansWithStereotypes
 * @Author: tdessalegn
 * @Date: 1/31/22
 */

@Configuration
@ComponentScan(basePackages = "domain") // Tells Spring where to look for classes annotated with stereotype annotations
public class Config {
}
