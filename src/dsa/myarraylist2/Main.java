package dsa.myarraylist2;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println(list);

        list.add(2, 99);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(0));

        list.set(0, 888);
        System.out.println(list);

        System.out.println(list.indexOf(888));
    }
}
