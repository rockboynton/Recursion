/*
 * CS2852
 * Spring 2018
 * Lab 6 - Recursion
 * Name: Rock Boynton
 * Created: 4/13/2018
 */
package boyntonrl;

import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * A partial implementation of an array-based List to be used
 * to practice implementing recursive methods.
 *
 * @param <E> The type of objects stored in the list
 */
public class ArrayList<E> implements List<E>, RandomAccess {
    private Object[] data;

    /**
     * Constructs a list containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     * @param collection the collection whose elements are to be placed into this list
     * @throws NullPointerException - if the specified collection is null
     */
    public ArrayList(Collection<? extends E> collection) {
        data = new Object[collection.size()];
        int index = 0;
        for(E element : collection) {
            data[index++] = element;
        }
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return data.length;
    }

    /**
     * Returns true if this list contains the specified element.
     * <p></p>
     * More formally, returns <tt>true</tt> if and only if this list
     * contains at least one element <tt>e</tt> such that
     * <tt>(target==null ? e==null : target.equals(e))</tt>.
     * @param target element whose presence in the list is to be tested
     * @return true if the list contains the specified element
     */
    @Override
    public boolean contains(Object target) {
        return contains(target, 0);
    }

    private boolean contains(Object target, int position) {
        boolean found = false;
        if (position < data.length) {
            if (target == data[position] || (target != null && target.equals(data[position]))) {
                found = true;
            } else {
                found = contains(target, position + 1);
            }
        }
        return found;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * <p></p>
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(target==null ? get(i)==null : target.equals(get(i)))</tt>,
     * or <tt>-1</tt> if there is no such index.
     * @param target element to search for
     * @return the index of the first occurrence of the specified element in this
     *         list, or <tt>-1</tt> if this list does not contain the element
     */
    @Override
    public int indexOf(Object target) {
        return indexOf(target, 0);
    }

    private int indexOf(Object target, int currentIndex) {
        int index = -1;
        if (currentIndex < data.length) {
            if (target == data[currentIndex] || (target != null && target.equals(data[currentIndex]))) {
                index = currentIndex;
            } else {
                index = indexOf(target, currentIndex + 1);
            }
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Returns the element at the specified index
     * @param index of the desired element
     * @return element at specified index
     */
    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean add(E element) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean remove(Object target) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not implemented");
    }

}

