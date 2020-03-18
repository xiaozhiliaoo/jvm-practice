package ch11.inv.dyn;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;

import static org.objectweb.asm.Opcodes.*;


public class DynInvokerSample extends ClassLoader{
    private static final Handle BSM =  
            new Handle(H_INVOKESTATIC,  
             DynBootStrap.class.getName().replace('.', '/'),  
            "bootstrap",  
            MethodType.methodType(  
            CallSite.class, Lookup.class, String.class, MethodType.class,Object.class).toMethodDescriptorString());  
    
    private static final Handle CALL =  
            new Handle(H_INVOKESTATIC,  
             String.class.getName().replace('.', '/'),  
            "valueOf",  
            MethodType.methodType(  
            String.class, Object.class).toMethodDescriptorString());
    
    public Class createClass() throws IOException{
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);  
        cw.visit(V1_7, ACC_PUBLIC | ACC_SUPER, "DynInvokerSampleMain", null, "java/lang/Object", null);
        Method m = Method.getMethod("void <init> ()");
        GeneratorAdapter mg = new GeneratorAdapter(ACC_PUBLIC, m, null, null, cw);
        mg.loadThis();
        mg.invokeConstructor(Type.getType(Object.class), m);
        mg.returnValue();
        mg.endMethod();
        
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, "run", "()V", null, null);
        mv.visitCode();  
        
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitTypeInsn(Opcodes.NEW,"java/lang/Integer");
        mv.visitInsn(Opcodes.DUP);
        mv.visitLdcInsn(100);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/Integer","<init>","(I)V");
        mv.visitInvokeDynamicInsn("substring", "(Ljava/lang/Object;)Ljava/lang/String;", BSM, CALL);  
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        
        mv.visitInsn(RETURN); 
        mv.visitMaxs(0, 0);  
        mv.visitEnd();  
        cw.visitEnd();  
        byte[] bytes=cw.toByteArray();
        
        FileOutputStream fos=new FileOutputStream(new File("D:/DynInvokerSampleMain.class"));
        fos.write(bytes);
        return this.defineClass("DynInvokerSampleMain",bytes, 0, bytes.length);
        
    }
    
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        DynInvokerSample me=new DynInvokerSample();
        Object obj=me.createClass().newInstance();
        obj.getClass().getMethod("run").invoke(null);
    }  
}
