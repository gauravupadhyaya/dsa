import java.util.HashMap;
import java.util.Map;

public class Fibonacci_Memoization {
    private Map<Integer,Integer> map = new HashMap<>();
    int i = 0;

    public int fib(int n){

        if(n <=1){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            System.out.println("Counter : "+ (++i));
            int val = fib(n-1)+fib(n-2);
            map.put(n,val);
            return val;
        }
    }

    public static void main(String[] args) {
        Fibonacci_Memoization fibonacci = new Fibonacci_Memoization();
        System.out.println("Result : "+fibonacci.fib(10000));
    }
}
