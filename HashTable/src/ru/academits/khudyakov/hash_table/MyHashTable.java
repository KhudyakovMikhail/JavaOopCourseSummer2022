package ru.academits.khudyakov.hash_table;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private final ArrayList<T>[] lists;
    private int modCount;
    private static final int defaultCapacity = 20;

    public MyHashTable() {
        //noinspection unchecked
        lists = (ArrayList<T>[]) new ArrayList[defaultCapacity];
    }

    public MyHashTable(int capacity) {
        //noinspection unchecked
        lists = (ArrayList<T>[]) new ArrayList[capacity];
    }

    public MyHashTable(Collection<? extends T> c) {
        //noinspection unchecked
        lists = (ArrayList<T>[]) new ArrayList[defaultCapacity];
        addAll(c);
    }

    @Override
    public int size() {
        int size = 0;

        for (ArrayList<T> list : lists) {
            if (list != null) {
                for (T element : list) {
                    size++;
                }
            }
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        for (ArrayList<T> list : lists) {
            if (list != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }

        int index = getHashtableIndex(o);

        if (lists[index] == null) {
            return false;
        }

        return lists[index].contains(o);
    }

    private int getHashtableIndex(Object o) {
        if (o == null) {
            return 0;
        }

        return Math.abs(o.hashCode() % lists.length);
    }

    private class MyHashtableIterator implements Iterator<T> {
        private int currentListIndex = -1;
        private int currentElementIndex = -1;
        private final int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentElementIndex + 1 < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("—писок закончилс€");
            }

            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("¬о врем€ прохода было изменение списка");
            }

            currentListIndex++;

            if (lists[currentListIndex] == null) {
                next();
            } else {
                currentElementIndex++;

                return lists[currentListIndex].get(currentElementIndex);
            }

            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashtableIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int insertIndex = 0;

        for (ArrayList<T> list : lists) {
            if (list != null) {
                System.arraycopy(list.toArray(), 0, array, insertIndex, list.toArray().length);
                insertIndex += list.toArray().length;
            }
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        Object[] hashTableArray = toArray();

        if (a.length < size()) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(hashTableArray, size(), a.getClass());

        }

        return a;
    }

    @Override
    public boolean add(T t) {
        int index = getHashtableIndex(t);

        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }

        lists[index].add(t);
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }

        int index = getHashtableIndex(o);

        if (lists[index] == null) {
            return false;
        }

        if (!lists[index].remove(o)) {
            return false;
        }

        lists[index].remove(o);

        if (lists[index].size() == 0) {
            lists[index] = null;
        }

        modCount++;

        return true;
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
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }

        return true;
    }


    // здесь не работает, пока не разобралс€
    @Override
    public boolean retainAll(Collection<?> c) {
        for (T t : this) {
            if (!c.contains(t)) {
                remove(t);
            }
        }

        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(lists, null);

        modCount++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (ArrayList<T> list : lists) {
            stringBuilder.append("[");

            if (list == null) {
                stringBuilder.append("null").append("]").append(System.lineSeparator());
            } else if (list.size() == 0) {
                stringBuilder.append("]").append(System.lineSeparator());
            } else {
                for (T element : list) {
                    stringBuilder.append(element).append(", ");
                }

                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                stringBuilder.append(']').append(System.lineSeparator());
            }
        }

        return stringBuilder.toString();
    }
}
