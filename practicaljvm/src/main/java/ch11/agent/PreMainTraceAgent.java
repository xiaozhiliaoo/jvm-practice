package ch11.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;

/**
 * 
Manifest-Version: 1.0 
Agent-Class: geym.zbase.ch11.agent.PreMainTraceAgent
Premain-Class: geym.zbase.ch11.agent.PreMainTraceAgent 
 * @author geym
 *
 */
public class PreMainTraceAgent { 
   public static void premain(String agentArgs, Instrumentation inst) 
           throws ClassNotFoundException, UnmodifiableClassException {
	   System.out.println("agentArgs:"+agentArgs);
       inst.addTransformer(new ClassFileTransformer(){
        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            System.out.println("load Class:"+className); 
            return classfileBuffer;
        } 
       });
   } 
} 
