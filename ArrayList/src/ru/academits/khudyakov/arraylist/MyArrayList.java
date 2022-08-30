package ru.academits.khudyakov.arraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private int modCount;

    public MyArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[10];
        size = 0;
        modCount = 0;
    }


    public MyArrayList(Collection<? extends E> c) {
        //noinspection unchecked
        items = (E[]) Arrays.copyOf(c.toArray(), c.size());
        size = c.size();
        modCount = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость должна быть >= 0, вместимость: " + capacity);
        } else {
            //noinspection unchecked
            items = (E[]) new Object[capacity];
            size = 0;
            modCount = 0;
        }
    }

    private void increaseCapacity() {
        if (items.length == 0) {
            //noinspection unchecked
            items = (E[]) new Object[10];
        } else {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    private void checkIndexCorrectness(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть >= 0");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("Элемент не существует");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    private class MyListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private final int modCount = MyArrayList.this.modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Список закончился");
            }

            if (modCount != MyArrayList.this.modCount) {
                throw new ConcurrentModificationException("Во время прохода было изменение списка");
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        System.arraycopy(items, 0, array, 0, size);

        return array;
    }

    // я не понял, что этот метод от меня хочет

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, size);
        }

        //noinspection unchecked
        return (T[]) Arrays.copyOf(items, size);
    }

    @Override
    public boolean add(E e) {
        if (size == items.length) {
            increaseCapacity();
        }

        items[size] = e;
        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (o.equals(items[i])) {
                System.arraycopy(items, i + 1, items, i, size - i - 1);
            }
        }

        size--;
        modCount++;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] array = c.toArray();

        for (int i = 0; i < c.size(); i++) {
            if (!contains(array[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] array = c.toArray();

        for (Object o : array) {
            //noinspection unchecked
            add((E) o);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndexCorrectness(index);

        Object[] array = c.toArray();

        for (int i = 0; i < array.length; i++) {
            //noinspection unchecked
            add(index + i, (E) array[i]);
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] array = c.toArray();

        for (Object o : array) {
            while (remove(o)) {
                remove(o);
            }
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] listCopy = Arrays.copyOf(items, size);

        clear();

        for (Object o : listCopy) {
            if (c.contains(o)) {
                //noinspection unchecked
                add((E) o);
            }
        }

        return true;
    }

    @Override
    public void clear() {
        removeAll(this);
    }

    @Override
    public E get(int index) {
        checkIndexCorrectness(index);

        return items[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndexCorrectness(index);

        E oldValue = items[index];
        items[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        checkIndexCorrectness(index);

        System.arraycopy(items, index, items, index + 1, size - index);

        items[index] = element;

        size++;
        modCount++;
    }

    @Override
    public E remove(int index) {
        checkIndexCorrectness(index);

        E oldValue = get(index);

        System.arraycopy(items, index + 1, items, index, size - index - 1);

        size--;
        modCount++;

        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    public void ensureCapacity(int number) {
        if (items.length < number) {
            items = Arrays.copyOf(items, number);
        }
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    // Дальше не надо реализовывать, накидал UnsupportedOperations

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; i < size; i++) {
            stringBuilder.append(get(i)).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');

        return stringBuilder.toString();
    }
}
