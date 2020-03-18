package ch11.compile;

public class VarString {
    public static void addString(String str1,String str2){
        String str3=str1+str2;
    }
    
    public static void addString2(String ...str1){
        String str3="";
        for(String str:str1){
            str3+=str1;
        }
    }
}
