package ch9.asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

public class AsmCreateField extends ClassLoader implements Opcodes {

	public static void main(final String args[]) throws Exception {

		// creates a ClassWriter for the Example public class,
		// which inherits from Object

		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		cw.visit(V1_7, ACC_PUBLIC, "ExampleCreateF", null, "java/lang/Object", null);
		FieldVisitor fv=cw.visitField(ACC_PUBLIC+ACC_STATIC, "myName", "Ljava/lang/String;", null, "hello world!");
		fv.visitEnd();
		
		MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mw.visitVarInsn(ALOAD, 0);
		mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mw.visitInsn(RETURN);
		mw.visitMaxs(0, 0);
		mw.visitEnd();
		mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mw.visitFieldInsn(GETSTATIC,"ExampleCreateF","myName","Ljava/lang/String;");
		mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		mw.visitInsn(RETURN);
		mw.visitMaxs(0, 0);
		mw.visitEnd();
		byte[] code = cw.toByteArray();
		
        FileOutputStream fos=new FileOutputStream(new File("D:/ExampleCreateF.class"));
        fos.write(code);
        fos.close();
        
		AsmCreateField loader = new AsmCreateField();
		Class exampleClass = loader.defineClass("ExampleCreateF", code, 0, code.length);
		exampleClass.getMethods()[0].invoke(null, new Object[] { null });

	}
}