
package ch10.clshot;


import ch10.findorder.HelloLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * -Xbootclasspath/a:D:/tmp/clz
 * -XBootClasspath 指定 说明判断类是否存在，从app classloader开始
 * @author Administrator
 *
 */
public class SameNameClass {
    public static void main(String args[]) throws Exception {
        ClassLoader cl = SameNameClass.class.getClassLoader();
        byte[] bHelloLoader = loadClassBytes("geym.zbase.ch10.findorder.HelloLoader");
        Method md_defineClass = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
        md_defineClass.setAccessible(true);
        md_defineClass.invoke(cl, bHelloLoader, 0, bHelloLoader.length);
        md_defineClass.setAccessible(false);

        HelloLoader loader = (HelloLoader) cl.getParent().loadClass("geym.zbase.ch10.findorder.HelloLoader")
                .newInstance();
        System.out.println(loader.getClass().getClassLoader());
        loader.print();
    }

    private static String getClassFile(String name) {
        StringBuffer sb = new StringBuffer(".\\bin");
        name = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator + name);
        return sb.toString();
    }

    private static byte[] loadClassBytes(String className) throws ClassNotFoundException {
        try {
            String classFile = getClassFile(className);
            FileInputStream fis = new FileInputStream(classFile);
            FileChannel fileC = fis.getChannel();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableByteChannel outC = Channels.newChannel(baos);
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (true) {
                int i = fileC.read(buffer);
                if (i == 0 || i == -1) {
                    break;
                }
                buffer.flip();
                outC.write(buffer);
                buffer.clear();
            }
            fis.close();
            return baos.toByteArray();
        } catch (IOException fnfe) {
            throw new ClassNotFoundException(className);
        }
    }
}
