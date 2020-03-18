
package ch11.inst;

public class Inst {
    public static int i = 1000000;

    public void print1() {
        System.out.println(100000.0d);
    }

    public void print2(int i, int j, int k, int z) {
        int b = i + z;
    }

    public void print3(char[] cs, short[] s) {
        System.out.println(s[0]);
        System.out.println(cs[0]);
    }

    public void print4(char[] cs, int[] s) {
        int i, j, k, x;
        x = 99;
        s[0] = 77;
    }

    /**
     * dup
     * pop
     * @param i
     */
    public void print5(int i) {
        Object obj=new Object();
        obj.toString();
    }
    
    public void print6(int i) {
        long l=i;
        float f=l;
        int j=(int)l;
    }
    
    public void print7(byte i) {
        int k=i;
        long l=i;
    }
    
    /**
     * fneg
     */
    public void print8() {
        float i=8;
        float j=-i;
        i=-j;
    }
    
    /**
     * fneg
     */
    public void print9() {
        int d1=1000;
        int d2=2;
        int i=d1%d2;
    }
    
    public void print10() {
        int i=123;
        int j=~i;
    }
    
    public void print11(int j) {
        int i=123;
        i=i+10;
    }
    
    public void print13() {
        int i=123;
        int j=122;
        i=i^j;
    }
    
    public void print14() {
        int[] intarray=new int[10];
        Object[] objarray=new Object[10];
        int[][] mintarray=new int[10][10];
    }
    
    public void getFiled() {
        System.out.println("hello");
    }
    
    public String chackcast(Object obj) {
        if(obj instanceof String)
            return (String)obj;
        else
            return null;
    }
}

