package ch11.compile;

public class CompileOptimization {
	public int time=3600*1000;
	
	public void cirlcle(){
		for(int i=0;i<60*60*24*1000;i++){
			
		}
	}
	
	public static void createString(){
		String info1="select * from test";
		String info2="select * "+"from test";
		String info3="select * ".concat("from test");
		System.out.println(info1==info2);
		System.out.println(info1==info3);
		System.out.println(info2==info3);
		System.out.println(info2==info3.intern());
	}
	
	public void swtich(int i){
	    switch(i){
	        case 1:break;
	        case 2:break;
	        case 5:break;
	        default:
	            System.out.println("");
	    }
	}
	
	public void checkflag(){
		if(FinalFlag.flag){
			System.out.println("flag is true");
		}else{
			System.out.println("flag is false");
		}
	}
	
	public static  void main(String args[]){
	    createString();
	}
}

