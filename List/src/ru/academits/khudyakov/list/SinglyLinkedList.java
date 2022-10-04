package ru.academits.khudyakov.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getCount() {
        return count;
    }

    public T getFirst() {
        if (count == 0) {
            throw new NoSuchElementException("Список пуст");
        }

        return head.getData();
    }

    public T get(int index) {
        checkIndex(index);

        ListItem<T> listItem = getItemByIndex(index);

        return listItem.getData();
    }

    public T set(int index, T data) {
        checkIndex(index);

        ListItem<T> listItem = getItemByIndex(index);

        T oldData = listItem.getData();
        listItem.setData(data);

        return oldData;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Индекс должен быть >= 0 и <= " + count + "; Индекс = " + index);
        }

        if (index == 0) {
            addFirst(data);

            return;
        }

        ListItem<T> previous = getItemByIndex(index - 1);

        previous.setNext(new ListItem<>(data, previous.getNext()));

        count++;

    }

    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> previous = getItemByIndex(index - 1);

        ListItem<T> removedItem = previous.getNext();
        previous.setNext(previous.getNext().getNext());

        count--;

        return removedItem.getData();
    }

    public boolean remove(T data) {
        for (ListItem<T> current = head, previous = null; current != null; previous = current, current = current.getNext()) {
            if (Objects.equals(data, current.getData())) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }

                count--;

                return true;
            }
        }


        return false;
    }

    public T removeFirst() {
        if (count == 0) {
            throw new NoSuchElementException("Список пуст");
        }

        ListItem<T> removedItem = head;
        head = head.getNext();

        count--;

        return removedItem.getData();
    }

    public void revert() {
        if (count <= 1) {
            return;
        }

        for (ListItem<T> current = head, previous = null, next; current != null; previous = current, current = next) {
            next = current.getNext();

            if (next == null) {
                head = current;
            }

            current.setNext(previous);
        }
    }

    // Не понимаю, как сделать копирование
    // пытаюсь насоздавать новых ListItem и раскидать ссылки, но не получается
    // дайте подсказку пожалуйста

    public SinglyLinkedList<T> copy() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();

        listCopy.head = new ListItem<>(head.getData());
        listCopy.count++;

        return listCopy;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс должен быть >= 0 и < " + count + "; индекс = " + index);
        }
    }

    private ListItem<T> getItemByIndex(int index) {
        ListItem<T> listItem = head;

        for (int i = 0; i < index; i++) {
            listItem = listItem.getNext();
        }

        return listItem;
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
