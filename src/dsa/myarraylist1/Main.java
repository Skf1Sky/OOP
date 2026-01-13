package dsa.myarraylist1;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(50);

        System.out.println(list.toString());

        list.add(1, 99);
        System.out.println(list);

        list.set(0, 888);
        System.out.println(list);

        System.out.println(list.get(2));

        System.out.println(list.indexOf(20));
        System.out.println(list.lastIndexOf(20));
        System.out.println(list.indexOf(100));

        list.remove(1);
        System.out.println(list);

        list.removeElement(20);
        System.out.println(list);
    }
}
