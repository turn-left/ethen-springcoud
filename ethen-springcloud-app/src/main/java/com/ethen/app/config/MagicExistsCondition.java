package com.ethen.app.config;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * 条件化装配示例
 */
public class MagicExistsCondition implements Condition {
    public static final String MAGIC_KEY = "magic";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        Arrays.stream(context.getRegistry().getBeanDefinitionNames()).forEach(System.err::println);

        // 检查是否存在magic属性
        return isMagicEnable(env);
    }


    public boolean isMagicEnable(Environment env) {
        return env == null ? Boolean.FALSE : "Y".equalsIgnoreCase(env.getProperty(MAGIC_KEY));
    }
}
