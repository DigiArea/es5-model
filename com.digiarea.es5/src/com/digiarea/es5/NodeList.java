package com.digiarea.es5;

import com.digiarea.es5.Node;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import java.util.ListIterator;
import com.digiarea.es5.JSDocComment;
import com.digiarea.es5.visitor.VoidVisitor;
import com.digiarea.es5.visitor.GenericVisitor;

/** 
 * The Class NodeList.
 *
 * @param <E> the element type
 */
public class NodeList<E extends Node> extends Node implements List<E> {

    /** 
     * The nodes.
     */
    private List<E> nodes = null;

    public Iterator<E> iterator() {
        if (nodes != null) {
            return nodes.iterator();
        }
        return null;
    }

    public int size() {
        return nodes.size();
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public boolean contains(Object o) {
        return nodes.contains(o);
    }

    public Object[] toArray() {
        return nodes.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return nodes.toArray(a);
    }

    public boolean add(E e) {
        return nodes.add(e);
    }

    public boolean remove(Object o) {
        return nodes.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return nodes.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return nodes.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return nodes.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return nodes.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return nodes.retainAll(c);
    }

    public void clear() {
        nodes.clear();
    }

    public E get(int index) {
        return nodes.get(index);
    }

    public E set(int index, E element) {
        return nodes.set(index, element);
    }

    public void add(int index, E element) {
        nodes.add(index, element);
    }

    public E remove(int index) {
        return nodes.remove(index);
    }

    public int indexOf(Object o) {
        return nodes.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return nodes.lastIndexOf(o);
    }

    public ListIterator<E> listIterator() {
        return nodes.listIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return nodes.listIterator(index);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return nodes.subList(fromIndex, toIndex);
    }

    public boolean addNodes(E nodes) {
        boolean res = getNodes().add(nodes);
        if (res) {
        }
        return res;
    }

    public boolean removeNodes(E nodes) {
        boolean res = getNodes().remove(nodes);
        if (res) {
        }
        return res;
    }

    public List<E> getNodes() {
        return nodes;
    }

    public void setNodes(List<E> nodes) {
        this.nodes = nodes;
    }

    NodeList() {
        super();
    }

    NodeList(List<E> nodes, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.nodes = nodes;
    }

    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
