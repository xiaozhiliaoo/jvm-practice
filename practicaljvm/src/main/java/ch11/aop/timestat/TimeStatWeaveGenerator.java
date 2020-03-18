package ch11.aop.timestat;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

public class TimeStatWeaveGenerator{ 
	 public static void main(String args[]) throws Exception { 
		 String className=Account.class.getName();
		 ClassReader cr = new ClassReader(className); 
		 ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES); 
		 TimeStatClassAdapter classAdapter = new TimeStatClassAdapter(cw); 
		 cr.accept(classAdapter, ClassReader.SKIP_DEBUG); 
		 byte[] data = cw.toByteArray(); 
		 File file = new File("bin/"+className.replaceAll("\\.", "/")+".class"); 
		 FileOutputStream fout = new FileOutputStream(file); 
		 fout.write(data); 
		 fout.close(); 
	 } 
}