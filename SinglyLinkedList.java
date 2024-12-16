public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {

            return element;
        }

        public void setElement(E element) {

            this.element = element;
        }

        public Node<E> getNext() {

            return next;
        }

        public void setNext(Node<E> next) {

            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;

    }

    public boolean isEmpty() {

        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }


    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e)
    {
        Node<E>newest= new Node<>(e,null);
        if (size==0)
            head=newest;
        else
            tail.setNext(newest);
        tail= tail.next;
        size++;
    }
    public E removeFirst()
    {
        if (isEmpty())return null;
        E deleted = head.element;
        head=head.next;
        size--;
        if (size==0)
            tail=null;
        return deleted;
    }
    //1
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        SinglyLinkedList<?> other = (SinglyLinkedList<?>) obj;
        if (size != other.size) return false;

        Node<E> currentA = head;
        Node<?> currentB = other.head;
        while (currentA != null) {
            if (!currentA.getElement().equals(currentB.getElement())) return false;
            currentA = currentA.getNext();
            currentB = currentB.getNext();
        }
        return true;
    }

    //2
    public Node<E> secondToLast() {
        if (isEmpty()) return null;

        Node<E> c1 = head;
        while (c1.getNext().getNext() != null) {
            c1 = c1.getNext();
        }
        return c1;
    }

    //3
    public int calculateSize() {
        int count = 0;
        Node<E> c2 = head;
        while (c2 != null) {
            count++;
            c2 = c2.getNext();
        }
        return count;
    }
    //4
    public void rotate() {
        if (!isEmpty()) {
            Node<E> oldHead = head;
            head = head.getNext();
            oldHead.setNext(null);
            tail.setNext(oldHead);
            tail = oldHead;
        }
    }
    //5
    public void concatenate(SinglyLinkedList<E> M) {
        if (M.isEmpty()) {
            return;
        }
        if (this.isEmpty()) {
            this.head = M.head;
            this.tail = M.tail;
        } else {
            this.tail.setNext(M.head);
            this.tail = M.tail;
        }
        this.size += M.size();
    }

    //6
    public void reverse() {
        Node<E> prev = null;
        Node<E> c3 = head;
        Node<E> next;

        while (c3 != null) {
            next = c3.getNext();
            c3.setNext(prev);
            prev = c3;
            c3 = next;
        }
        tail = head;
        head = prev;
    }



    public String getAll()
    {
        String all="";
        Node<E>p=head;
        while (p!=null)
        {
            all=all+p.element+"   ";
            p=p.next;
        }
        return all;
    }



}
