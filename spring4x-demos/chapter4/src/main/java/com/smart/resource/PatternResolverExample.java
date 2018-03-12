package com.smart.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PatternResolverExample {
    public static void main(String[] args) throws Throwable {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resources[] = resolver.getResources("classpath*:conf/*.txt");
        for (Resource resource :
                resources) {
            System.out.println(resource.getDescription());
        }
    }
}
