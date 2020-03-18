package ch11.aop.proxy;

import org.objectweb.asm.*;

import java.lang.reflect.Method;

public class AccountFactory implements Opcodes {
	public static Account newAccount(){
		return new Account();
	}
	
	public static Account newAccount2(){
		byte[] bytes;
		try {
			bytes = createProxyAccount();
			Method md_defineClass=ClassLoader.class.getDeclaredMethod("defineClass", byte[].class,int.class,int.class);
			md_defineClass.setAccessible(true);
			md_defineClass.invoke(AccountFactory.class.getClassLoader(), bytes,0,bytes.length);
			md_defineClass.setAccessible(false);
			
			return (Account) AccountFactory.class.getClassLoader().loadClass("geym.zbase.ch11.aop.proxy.SubAccount").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] createProxyAccount () throws Exception {

		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;
		AnnotationVisitor av0;

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, "geym/zbase/ch11/aop/proxy/SubAccount", null, "geym/zbase/ch11/aop/proxy/Account", null);

		{
		fv = cw.visitField(ACC_PROTECTED, "reslut", "Ljava/lang/String;", null, null);
		fv.visitEnd();
		}
		{
		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "geym/zbase/ch11/aop/proxy/Account", "<init>", "()V", false);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitInsn(ACONST_NULL);
		mv.visitFieldInsn(PUTFIELD, "geym/zbase/ch11/aop/proxy/SubAccount", "reslut", "Ljava/lang/String;");
		mv.visitInsn(RETURN);
		mv.visitMaxs(2, 1);
		mv.visitEnd();
		}
		{
		mv = cw.visitMethod(ACC_PUBLIC, "query", "()Ljava/lang/String;", null, null);
		mv.visitCode();
		mv.visitVarInsn(ALOAD, 0);
		mv.visitFieldInsn(GETFIELD, "geym/zbase/ch11/aop/proxy/SubAccount", "reslut", "Ljava/lang/String;");
		Label l0 = new Label();
		mv.visitJumpInsn(IFNONNULL, l0);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "geym/zbase/ch11/aop/proxy/Account", "query", "()Ljava/lang/String;", false);
		mv.visitFieldInsn(PUTFIELD, "geym/zbase/ch11/aop/proxy/SubAccount", "reslut", "Ljava/lang/String;");
		mv.visitLabel(l0);
		mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitFieldInsn(GETFIELD, "geym/zbase/ch11/aop/proxy/SubAccount", "reslut", "Ljava/lang/String;");
		mv.visitInsn(ARETURN);
		mv.visitMaxs(2, 1);
		mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
		}
}
