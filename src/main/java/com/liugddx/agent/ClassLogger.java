package com.liugddx.agent;

import java.lang.instrument.ClassFileTransformer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.ProtectionDomain;

/**
 * <p>@ClassName transform</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/30 17:58
 */
public class ClassLogger implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        try {
            Path path = Paths.get("classes/" + className + ".class");
            Files.write(path, classfileBuffer);
        } catch (Throwable ignored) { // ignored, don’t do this at home kids
        } finally { return classfileBuffer; }
    }
}

