//: annotations/InterfaceExtractorProcessorFactory.java
// APT-based annotation processing.
package com.zping.lib_thinking_in_java.t20_annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {

    /**
     * 返回注解处理器
     *
     * @param atds
     * @param env
     * @return
     */
    public AnnotationProcessor getProcessorFor(
            Set<AnnotationTypeDeclaration> atds,
            AnnotationProcessorEnvironment env) {

        return new InterfaceExtractorProcessor(env);
    }

    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotations.ExtractInterface");
    }

    /**
     * 返回的string集合中没有你的注解的完整类名，apt就会发出警告信息，然后什么也不做
     *
     * @return
     */
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }
} ///:~
