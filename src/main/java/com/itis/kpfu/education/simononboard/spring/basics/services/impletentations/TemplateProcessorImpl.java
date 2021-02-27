package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.TemplateProcessor;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.TemplateResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.impletentations
 * Date:  26.02.2021
 * Time:  21:56
 */
@Service
public class TemplateProcessorImpl implements TemplateProcessor {
    private TemplateResolver templateResolver;
    private Map<String,String> template;

    public TemplateProcessorImpl(TemplateResolver templateResolver,
                                 // TODO: 27.02.2021 что заинжектится сюда вместо конкретного бина самим спрингом если я не укажу квалифаер
                                 @Qualifier(value = "templateParameters") Map<String, String> templateParameters) {
        this.templateResolver = templateResolver;
        this.template = templateParameters;
    }

    @Override
    public String getProcessedTemplate(Map<String, String> params, String ftl) {
        template.putAll(params);
        return templateResolver.process(ftl, template);
    }
}
