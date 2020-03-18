package ch11.aop.securitycheck;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class AddSecurityCheckMethodAdapter extends MethodVisitor { 
	 public AddSecurityCheckMethodAdapter(MethodVisitor mv) { 
		 super(Opcodes.ASM5,mv); 
	 } 

	 public void visitCode() { 
	     Label continueLabel = new Label(); 
		 visitMethodInsn(Opcodes.INVOKESTATIC, "geym/zbase/ch11/aop/securitycheck/SecurityChecker", 
			"checkSecurity", "()Z"); 
		 visitJumpInsn(Opcodes.IFNE,continueLabel);
		 visitInsn(Opcodes.RETURN);
		 visitLabel(continueLabel);
		 super.visitCode();
	 } 
}