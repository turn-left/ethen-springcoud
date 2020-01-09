package com.ethen.app.config;

import com.ethen.app.bean.MagicBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class BeanHolder {

    /**
     * 条件化配置 MagicBean
     * note 当{@link MagicExistsCondition#matches(ConditionContext, AnnotatedTypeMetadata)}为true则执行装配bean
     *
     * @return
     */
    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        System.err.println("**************************************************************"
                + "\nMagicBean has been created & yiyoyo~~~~~~~~~~" +
                "\n**************************************************************");
        return new MagicBean();
    }
}
