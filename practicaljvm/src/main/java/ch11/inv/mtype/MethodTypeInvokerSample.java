package ch11.inv.mtype;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
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


public class MethodTypeInvokerSample extends ClassLoader{
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
    
    private static final Type MTYPE =  
            Type.getType("()V");
    
    public Class createClass() throws IOException{
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);  
        cw.visit(V1_7, ACC_PUBLIC | ACC_SUPER, "MethodTypeInvokerSampleMain", null, "java/lang/Object", null);
        Method m = Method.getMethod("void <init> ()");
        GeneratorAdapter mg = new GeneratorAdapter(ACC_PUBLIC, m, null, null, cw);
        mg.loadThis();
        mg.invokeConstructor(Type.getType(Object.class), m);
        mg.returnValue();
        mg.endMethod();
        
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, "run", "()V", null, null);
        mv.visitCode();  
        
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn(2);
        mv.visitInvokeDynamicInsn("substring", "(I)Ljava/lang/String;", BSM, MTYPE);  
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        
        mv.visitInsn(RETURN); 
        mv.visitMaxs(0, 0);  
        mv.visitEnd();  
        cw.visitEnd();  
        byte[] bytes=cw.toByteArray();
        
        FileOutputStream fos=new FileOutputStream(new File("D:/MethodTypeInvokerSampleMain.class"));
        fos.write(bytes);
        return this.defineClass("MethodTypeInvokerSampleMain",bytes, 0, bytes.length);
        
    }
    
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        MethodTypeInvokerSample me=new MethodTypeInvokerSample();
        Object obj=me.createClass().newInstance();
        obj.getClass().getMethod("run").invoke(null);
    }  
}
