import java.util.TreeSet;

/**
 *             Gaurav
 *  _______              Gaurav
 *                  _____       Gaurav
 *
 *
 *
 *
 *
 */
public class EqualsAndHashCode implements Comparable{
    public String value;
    public EqualsAndHashCode(String value){
        this.value = value;
    }
    @Override
    public int hashCode() {
        System.out.println("Inside hashcode.");
        if(this.value.equals("Abhay")){
            return 32;
        }
        return 31;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Inside equals.");
        return true;
    }

    @Override
    public String toString() {
        return "EqualsAndHashCode{" +
                "value='" + value + '\'' +
                '}';
    }

    public static void main(String[] args) {
        TreeSet<EqualsAndHashCode> set = new TreeSet<>();

        set.add(new EqualsAndHashCode("Gaurav"));
        set.add(new EqualsAndHashCode("Gaurav"));
        set.add(new EqualsAndHashCode("Abhay"));
        set.add(new EqualsAndHashCode("Pathak"));

        System.out.println(set+" :: "+set.size());
    }

    @Override
    public int compareTo(Object o) {
        EqualsAndHashCode thatInstance = (EqualsAndHashCode)o;
        return this.value.compareTo(thatInstance.value);
    }
}
