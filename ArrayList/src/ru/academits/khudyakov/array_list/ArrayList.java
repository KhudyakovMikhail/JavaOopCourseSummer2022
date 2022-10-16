package ru.academits.khudyakov.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;
    private int size;
    private int modCount;

    public ArrayList() {
        //noinspection unchecked
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(Collection<? extends E> c) {
        //noinspection unchecked
        elements = (E[]) c.toArray();
        size = c.size();
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость должна быть >= 0, вместимость: " + capacity);
        }

        //noinspection unchecked
        elements = (E[]) new Object[capacity];
    }

    private void increaseCapacity() {
        if (elements.length == 0) {
            //noinspection unchecked
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс должен быть >= 0 и < " + size + "; индекс: " + index);
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
        return indexOf(o) >= 0;
    }

    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private final int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Список закончился");
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Во время прохода было изменение списка");
            }

            currentIndex++;
            return elements[currentIndex];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(elements, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(E element) {
        add(size, element);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int elementIndex = indexOf(o);

        if (elementIndex < 0) {
            return false;
        }

        remove(elementIndex);

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс должен быть >= 0 и <= " + size + "; индекс: " + index);
        }

        if (c.isEmpty()) {
            return false;
        }

        ensureCapacity(size + c.size());

        System.arraycopy(elements, index, elements, index + c.size(), size - index);

        int insertIndex = index;

        for (E element : c) {
            elements[insertIndex] = element;

            insertIndex++;
        }

        size += c.size();
        modCount++;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int i = 0;

        int currentModCount = modCount;

        while (i < size) {
            if (c.contains(elements[i])) {
                remove(i);
            } else {
                i++;
            }
        }

        return currentModCount != modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int i = 0;

        int currentModCount = modCount;

        while (i < size) {
            if (!c.contains(elements[i])) {
                remove(i);
            } else {
                i++;
            }
        }

        return currentModCount != modCount;
    }

    @Override
    public void clear() {
        if (size == 0) {
            return;
        }

        Arrays.fill(elements, 0, size, null);

        size = 0;
        modCount++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        E oldElement = elements[index];
        elements[index] = element;

        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс должен быть >= 0 и <= " + size + "; индекс: " + index);
        }

        if (size == elements.length) {
            increaseCapacity();
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);

        elements[index] = element;

        size++;
        modCount++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E removedElement = elements[index];

        System.arraycopy(elements, index + 1, elements, index, size - index - 1);

        size--;
        modCount++;

        elements[size] = null;

        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, elements[i])) {
                return i;
            }
        }

        return -1;
    }

    public void ensureCapacity(int capacity) {
        if (elements.length < capacity) {
            elements = Arrays.copyOf(elements, capacity);
        }
    }

    public void trimToSize() {
        if (elements.length > size) {
            elements = Arrays.copyOf(elements, size);
        }
    }

    // Дальше не надо реализовывать, накидал UnsupportedOperations
    @Override
    public java.util.ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public java.util.ListIterator<E> listIterator(int index) {
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
            stringBuilder.append(elements[i]).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');

        return stringBuilder.toString();
    }
}
