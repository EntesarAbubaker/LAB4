public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.addLast(25);
        list1.addLast(30);
        list1.addLast(35);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.addLast(25);
        list2.addLast(30);
        list2.addLast(35);

        System.out.println(list1.equals(list2));

    }
}
