package ch11.agent;


import ch11.aop.timestat.Account;
import ch11.aop.timestat.TimeStatClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;

/**
 * 
Manifest-Version: 1.0 
Agent-Class: geym.zbase.ch11.agent.PreMainAddTimeStatAgent
Premain-Class: geym.zbase.ch11.agent.PreMainAddTimeStatAgent 
 * @author geym
 *
 */
public class PreMainAddTimeStatAgent { 
   public static void premain(String agentArgs, Instrumentation inst) 
           throws ClassNotFoundException, UnmodifiableClassException { 
	   System.out.println("agentArgs:"+agentArgs);
       inst.addTransformer(new ClassFileTransformer(){
        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            if(className.equals("geym/zbase/ch11/aop/timestat/Account")){
                System.out.println("meet geym.zbase.ch11.aop.timestat.Account");
                ClassReader cr = new ClassReader(classfileBuffer); 
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES); 
                TimeStatClassAdapter classAdapter = new TimeStatClassAdapter(cw);
                cr.accept(classAdapter, ClassReader.SKIP_DEBUG); 
                return cw.toByteArray(); 
            }else{
                System.out.println(className);
                return classfileBuffer;
            }
        }
           
       },true);
   }
   
   public static void agentmain (String agentArgs, Instrumentation inst) throws ClassNotFoundException, UnmodifiableClassException{
       System.out.println("Agent Main called");
       System.out.println("agentArgs:"+agentArgs);
       premain(agentArgs,inst);
       inst.retransformClasses(Account.class);
   }
} 
