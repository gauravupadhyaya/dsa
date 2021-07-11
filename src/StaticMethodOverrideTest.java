public class StaticMethodOverrideTest {
    public static void main(String args[]){
        doStuff(null);
    }
    public static void doStuff(Object obj){
        System.out.println("Inside Object");
    }

    public static void doStuff(String str){
        System.out.println("Inside String : "+str);
    }
}
