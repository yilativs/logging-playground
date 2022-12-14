package org.sample.foo.conf;

import org.sample.foo.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BaseConfiguration {

}
