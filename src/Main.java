import Arrays.Array;
import Arrays.Students;

public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();

        for(int i=0;i<10;i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);
        arr.addFirst(10);
        arr.addLast(100);
        System.out.println(arr);
//        Array<Students> arr = new Array<>();
//        arr.addLast(new Students("Bob",100));
//        arr.addLast(new Students("Alice",90));
//        arr.addLast(new Students("Lucy",90));
//        System.out.println(arr);
//        arr.removeFist();
//        System.out.println(arr.getCapacity());
//        System.out.println(arr);
    }
}
