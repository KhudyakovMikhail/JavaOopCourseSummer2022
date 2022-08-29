package ru.academits.khudyakov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getCount() {
        return count;
    }

    public T getHead() {
        if (head == null) {
            return null;
        }

        return head.getData();
    }

    public T get(int index) {
        checkIndexCorrectness(index);

        ListItem<T> listItem = head;

        for (int i = 0; i < index; i++) {
            listItem = listItem.getNext();
        }

        return listItem.getData();
    }

    public T set(int index, T data) {
        checkIndexCorrectness(index);

        ListItem<T> listItem = head;

        for (int i = 0; i < index; i++) {
            listItem = listItem.getNext();
        }

        T oldValue = listItem.getData();

        listItem.setData(data);

        return oldValue;
    }

    public void add(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        checkIndexCorrectness(index);

        if (index == 0) {
            add(data);
        } else {
            ListItem<T> p = head;

            for (int i = 1; i < index; i++) {
                p = p.getNext();
            }

            ListItem<T> newItem = new ListItem<>(data, p.getNext());
            p.setNext(newItem);
        }
    }

    public T remove(int index) {
        checkIndexCorrectness(index);

        if (index == 0) {
            return removeHead();
        }

        ListItem<T> p = head;

        for (int i = 1; i < index; i++) {
            p = p.getNext();
        }

        ListItem<T> removedItem = p.getNext();
        p.setNext(p.getNext().getNext());

        count--;

        return removedItem.getData();
    }

    public boolean remove(T data) {
        if (data == null) {
            throw new NullPointerException("Нельзя удалить null");
        }

        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (data.equals(p.getData())) {
                if (prev == null) {
                    head = p.getNext();
                } else {
                    prev.setNext(p.getNext());
                }

                count--;

                return true;
            }
        }

        return false;
    }

    public T removeHead() {
        if (head == null) {
            System.out.println("Список пуст");

            return null;
        }

        ListItem<T> removedItem = head;
        head = head.getNext();

        count--;

        return removedItem.getData();
    }

    public void revert() {
        if (count == 0 || count == 1) {
            return;
        }

        for (ListItem<T> p = head, prev = null, next; p != null; prev = p, p = next) {
            next = p.getNext();

            if (next == null) {
                head = p;
            }

            p.setNext(prev);
        }
    }

    public SinglyLinkedList<T> copy() {
        if (count == 0) {
            return null;
        }

        revert();

        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            listCopy.add(p.getData());
        }

        revert();

        return listCopy;
    }

    private void checkIndexCorrectness(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс должен быть > 0 и < " + count);
        }
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');

        return stringBuilder.toString();
    }
}