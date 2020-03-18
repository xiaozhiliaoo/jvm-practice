package ch2.localvar;

public class LocalVar {
	public void localvar1(){
		int a=0;
		System.out.println(a);
		int b=0;
	}
	public void localvar2(){
		{
		int a=0;
		System.out.println(a);
		}
		int b=0;
	}
	public static void main(String[] args) {
		
	}

}
