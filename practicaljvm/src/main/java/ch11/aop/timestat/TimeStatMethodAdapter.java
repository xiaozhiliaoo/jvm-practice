
package ch11.aop.timestat;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class TimeStatMethodAdapter extends MethodVisitor implements Opcodes {
    public TimeStatMethodAdapter(MethodVisitor mv) {
        super(Opcodes.ASM5, mv);
    }

    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC, "geym/zbase/ch11/aop/timestat/TimeStat", "start", "()V");
        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {
        if ((opcode >= IRETURN && opcode <= RETURN)) {
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitLdcInsn("after");
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
            visitMethodInsn(Opcodes.INVOKESTATIC, "geym/zbase/ch11/aop/timestat/TimeStat", "end", "()V");
        }
        mv.visitInsn(opcode);
    }
}
