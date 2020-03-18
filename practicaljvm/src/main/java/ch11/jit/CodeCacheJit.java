package ch11.jit;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @author Geym
 *
 */
/**
 * @author Geym
 *
 */
public class CodeCacheJit  implements Opcodes {
    public static void createAndCall(String hellostr,String classname) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_7, ACC_PUBLIC, classname, null, "java/lang/Object", null);
        MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null,
                null);
        mw.visitVarInsn(ALOAD, 0);
        mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mw.visitInsn(RETURN);
        mw.visitMaxs(0, 0);
        mw.visitEnd();
        mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main",
                "([Ljava/lang/String;)V", null, null);
        mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
        mw.visitLdcInsn(hellostr);
        mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V");
        mw.visitInsn(RETURN);
        mw.visitMaxs(0,0);
        mw.visitEnd();
        byte[] code = cw.toByteArray();

        JitClassLoader loader = new JitClassLoader();
        Method m;
        try {
            m = ClassLoader.class.getDeclaredMethod("defineClass", String.class,byte[].class,int.class,int.class);
            m.setAccessible(true);
            Class exampleClass=(Class) m.invoke(loader, classname, code, 0, code.length);
            exampleClass.getMethods()[0].invoke(null, new Object[] { null });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
    public static void main(final String args[]) throws Exception {
        for(int i=0;i<Integer.MAX_VALUE;i++){
            createAndCall("hello,world"+i,"Ex"+i);
            //停止jit后再gc ，jit不会启用了
            if(i>=2000){
                System.gc();
            }
        }
    }
}  