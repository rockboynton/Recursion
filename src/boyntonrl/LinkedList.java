/*
 * CS2852
 * Spring 2018
 * Lab 6 - Recursion
 * Name: Rock Boynton
 * Created: 4/13/2018
 */
package boyntonrl;

import java.util.List;
import java.util.ListIterator;
import java.util.Collection;
import java.util.Iterator;

/**
 * A partial implementation of a singly linked list to be used
 * to practice implementing recursive methods.
 *
 * @param <E> The type of objects stored in the list
 */
public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    /**
     * Inner class that describes a node in the singly linked list.
     */
    private static class Node<E> {
        E value;
        Node<E> next;

        /**
         * Constructs a node with a specified value and reference to the next node
         * @param value Value of the element to be stored in the node
         * @param next Reference to the next element in the singly linked list
         */
        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Constructs a node with a specified value
         * @param value Value of the element to be stored in the node
         */
        private Node(E value) {
            this(value, null);
        }
    }

    /**
     * Constructs a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator.
     * @param collection the collection whose elements are to be placed into this list
     * @NullPointerException if the specified collection is <tt>null</tt>
     */
    public LinkedList(Collection<? extends E> collection) {
        Iterator<? extends E> itr = collection.iterator();
        if(itr.hasNext()) {
            head = new Node(itr.next());
            tail = head;
        }
        Node<E> walker = head;
        while(itr.hasNext()) {
            walker.next = new Node(itr.next());
            walker = walker.next;
        }
        tail = walker;
    }

    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size(head);
    }

    private int size(Node<E> head) {
        int size = 0;
        if (head != null) {
            if (head.next != null) {
                size = 1 + size(head.next);
            } else {
                size++;
            }
        }
        return size;
    }

    /**
     * Returns true if this list contains the specified element.
     * <p></p>
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that <tt>(o==null ? e==null : o.equals(e))</tt>.
     * @param target element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object target) {
        return contains(target, head);
    }

    private boolean contains(Object target, Node<E> head) {
        boolean found = false;
        if (head != null) {
            if (target == head.value || (target != null && target.equals(head.value))) {
                found = true;
            } else {
                found = contains(target, head.next);
            }
        }
        return found;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or <tt>-1</tt> if this list does not contain the element.
     * <p></p>
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null ? get(i)==null : o.equals(get(i)))</tt>,
     * or <tt>-1</tt> if there is no such index.
     * @param target element to search for
     * @return the index of the first occurrence of the specified element in this list,
     *         or <tt>-1</tt> if this list does not contain the element
     */
    @Override
    public int indexOf(Object target) {
        return indexOf(target, head, 0);
    }

    private int indexOf(Object target, Node<E> head, int currentIndex) {
        int index = -1;
        if (head != null) {
            if (target == head.value || (target != null && target.equals(head.value))) {
                index = currentIndex;
            } else {
                index = indexOf(target, head.next, currentIndex + 1);
            }
        }
        return index;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index<0 || index>=size())
     */
    @Override
    public E get(int index) {
        if(index<0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        try {
            return get(index, head);
        } catch(NullPointerException e) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    }

    private E get(int index, Node<E> head) {
        E value;
        if (index == 0) {
            value = head.value;
        } else {
            value = get(index - 1, head.next);
        }
        return value;
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
    public boolean remove(Object target) {
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
    public void clear() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Object[] toArray() {
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