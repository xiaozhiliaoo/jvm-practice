package ch3.heap;

import java.nio.ByteBuffer;

/**
 * 直接内存分配较慢
 * @author Geym
 *
 */
public class AllocDirectBuffer {
    public void directAllocate(){
        long starttime=System.currentTimeMillis();
        for(int i=0;i<200000;i++){
            ByteBuffer b=ByteBuffer.allocateDirect(1000);
        }
        long endtime=System.currentTimeMillis();
        System.out.println("directAllocate:"+(endtime-starttime));
    }

    public void bufferAllocate() {
        long starttime=System.currentTimeMillis();
        for(int i=0;i<200000;i++){
            ByteBuffer b=ByteBuffer.allocate(1000);
        }
        long endtime=System.currentTimeMillis();
        System.out.println("bufferAllocate:"+(endtime-starttime));
    }
    
    public static void main(String[] args) {
        AllocDirectBuffer alloc=new AllocDirectBuffer();
        alloc.bufferAllocate();
        alloc.directAllocate();
        
        alloc.bufferAllocate();
        alloc.directAllocate();
    }
}
