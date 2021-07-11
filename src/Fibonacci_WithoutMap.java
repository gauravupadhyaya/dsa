import java.util.HashMap;
import java.util.Map;

public class Fibonacci_WithoutMap {
    public int fib(int n){
        int val1 = 0;
        int val2 = 1;
       for(int i = 2; i<=n; i++){
            int temp = val1 + val2;
            val1 = val2;
            val2 = temp;
        }
       return val2;
    }

    public static void main(String[] args) {
        Fibonacci_WithoutMap fibonacci = new Fibonacci_WithoutMap();
        System.out.println("Result : "+fibonacci.fib(1000));
    }
}
