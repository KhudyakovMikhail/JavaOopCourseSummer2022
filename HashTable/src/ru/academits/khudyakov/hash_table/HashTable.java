package ru.academits.khudyakov.hash_table;

import java.util.*;

public class HashTable<E> implements Collection<E> {
    private static final int DEFAULT_CAPACITY = 20;

    private final ArrayList<E>[] lists;
    private int modCount;
    private int size;

    public HashTable() {
        //noinspection unchecked
        lists = (ArrayList<E>[]) new ArrayList[DEFAULT_CAPACITY];
    }

    public HashTable(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Вместимость должна быть > 0; вместимость: " + capacity);
        }

        //noinspection unchecked
        lists = (ArrayList<E>[]) new ArrayList[capacity];
    }

    public HashTable(Collection<? extends E> c) {
        //noinspection unchecked
        lists = (ArrayList<E>[]) new ArrayList[c.size()];
        addAll(c);
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
        int index = getIndex(o);

        return lists[index] != null && lists[index].contains(o);
    }

    private int getIndex(Object o) {
        if (o == null) {
            return 0;
        }

        return Math.abs(o.hashCode() % lists.length);
    }

    private class HashtableIterator implements Iterator<E> {
        private int currentListIndex;
        private int currentElementIndex = -1;
        private int passedElementsCount;
        private final int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            return passedElementsCount < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Список закончился");
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Во время прохода было изменение коллекции");
            }

            while (lists[currentListIndex] == null || lists[currentListIndex].size() == 0) {
                currentListIndex++;
            }

            if (lists[currentListIndex].size() - 1 == currentElementIndex) {
                currentListIndex++;
                currentElementIndex = 0;

                while (lists[currentListIndex] == null || lists[currentListIndex].size() == 0) {
                    currentListIndex++;
                }
            } else {
                currentElementIndex++;
            }

            passedElementsCount++;

            return lists[currentListIndex].get(currentElementIndex);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new HashtableIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int insertIndex = 0;

        for (E element : this) {
            array[insertIndex] = element;
            insertIndex++;
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] array = toArray();

        if (a.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(array, size(), a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(array, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(E element) {
        int index = getIndex(element);

        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }

        lists[index].add(element);
        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);

        if (lists[index] == null) {
            return false;
        }

        boolean isRemoved = lists[index].remove(o);

        if (isRemoved) {
            size--;
            modCount++;

            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }

        for (E element : c) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int currentModCount = modCount;

        for (Object o : c) {
            do {
                remove(o);
            } while (remove(o));
        }

        return currentModCount != modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int oldSize = size;
        int newSize = 0;

        for (ArrayList<E> list : lists) {
            if (list == null) {
                continue;
            }

            list.retainAll(c);
            newSize += list.size();
        }

        if (oldSize != newSize) {
            modCount++;
            size = newSize;
        }

        return oldSize != newSize;
    }

    @Override
    public void clear() {
        if (size == 0) {
            return;
        }

        Arrays.fill(lists, null);

        size = 0;
        modCount++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(").append(System.lineSeparator());

        for (ArrayList<E> list : lists) {
            if (list == null) {
                stringBuilder.append("null").append(System.lineSeparator());
            } else if (list.size() == 0) {
                stringBuilder.append("[]").append(System.lineSeparator());
            } else {
                stringBuilder.append("[");

                for (E element : list) {
                    stringBuilder.append(element).append(", ");
                }

                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                stringBuilder.append(']').append(System.lineSeparator());
            }
        }

        stringBuilder.append(")");

        return stringBuilder.toString();
    }
}
