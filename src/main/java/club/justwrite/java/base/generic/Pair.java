package club.justwrite.java.base.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pair<K, V>{
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        add(new Pair(1,2));
        List<? extends Number> list = new ArrayList<>();
        if(list.size() > 0){
            Number number = list.get(0);
            System.out.println("number = " + number);
        }
        System.out.println("list = " + list);
//        list.add(new Integer(1));
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Pair() {
    }

    static void add(Pair<? super Integer, ? super Integer> pair){
        Object key = pair.getKey();
        Object key2 = pair.getValue();

        System.out.println("int2 = " + key);
        System.out.println("int1 = " + key2);
    }

    public boolean s(K o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.equals(pair.key) && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
