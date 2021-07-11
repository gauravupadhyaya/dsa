import java.util.HashMap;
import java.util.Map;

public class Fibonacci_Tabulation {
    private Map<Integer,Integer> map = new HashMap<>();
    public int fib(int n){
        map.put(0,0);
        map.put(1,1);
       for(int i = 2; i<=n; i++){
            map.put(i,map.get(i-1)+map.get(i-2));
        }
       return map.get(n);
    }

    public static void main(String[] args) {
        Fibonacci_Tabulation fibonacci = new Fibonacci_Tabulation();
        System.out.println("Result : "+fibonacci.fib(1000000));
    }
}
