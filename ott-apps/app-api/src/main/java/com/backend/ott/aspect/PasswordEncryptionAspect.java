package com.backend.ott.aspect;

import com.backend.ott.annotation.PasswordEncryption;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Aspect
@Component
public class PasswordEncryptionAspect {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncryptionAspect(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Around("execution(* com.backend.ott.controller..*.*(..))")
    public Object passwordEncryptionAspect(ProceedingJoinPoint pjp) throws Throwable {
        Arrays.stream(pjp.getArgs())
                .forEach(this::fieldEncryption);
        return pjp.proceed();
    }

    public void fieldEncryption(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            return;
        }

        FieldUtils.getAllFieldsList(object.getClass())
                .stream()
                .filter(filter -> !(Modifier.isFinal(filter.getModifiers())) && !(Modifier.isStatic(filter.getModifiers())))
                .forEach(field -> {
                    try {
                        boolean encryptionTarget = field.isAnnotationPresent(PasswordEncryption.class);
                        if (!encryptionTarget) {
                            return;
                        }

                        Object encryptionField = FieldUtils.readField(field, object, true);
                        if (!(encryptionField instanceof String)) {
                            return;
                        }

                        String encrypted = passwordEncoder.encode((String) encryptionField);
                        FieldUtils.writeField(field, object, encrypted);
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                });
    }
}
