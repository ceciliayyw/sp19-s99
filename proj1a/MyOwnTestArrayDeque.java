public class MyOwnTestArrayDeque {

    public static void main(String arg[]) {
        ArrayDeque l = new ArrayDeque();
    l.addLast(0);
    l.removeLast();
    l.addLast(2);
    l.addLast(3);
    l.removeLast();
    l.removeFirst();
    l.addFirst(6);
    l.addLast(7);
    l.addFirst(8);
    l.removeFirst();
    l.addLast(10);
    l.removeFirst();
        l.printDeque();


//        l.addFirst(0);
//        l.addFirst(1);
//        l.addFirst(2);
//        l.addFirst(3);
//        l.removeLast();
//        l.addFirst(5);
//        l.addFirst(6);
//        l.isEmpty();
//        System.out.println (l.removeLast());
    }
}