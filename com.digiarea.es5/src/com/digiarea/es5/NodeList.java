/*******************************************************************************
 * Copyright (c) 2011 - 2014 DigiArea, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     DigiArea, Inc. - initial API and implementation
 *******************************************************************************/
package com.digiarea.es5;

import com.digiarea.es5.Node;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import java.util.ListIterator;
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

    /* (non-Javadoc)
     * @see java.util.List#iterator()
     */
    public Iterator<E> iterator() {
        if (nodes != null) {
            return nodes.iterator();
        }
        return null;
    }

    /* (non-Javadoc)
     * @see java.util.List#size()
     */
    public int size() {
        return nodes.size();
    }

    /* (non-Javadoc)
     * @see java.util.List#isEmpty()
     */
    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    /* (non-Javadoc)
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Object o) {
        return nodes.contains(o);
    }

    /* (non-Javadoc)
     * @see java.util.List#toArray()
     */
    public Object[] toArray() {
        return nodes.toArray();
    }

    /* (non-Javadoc)
     * @see java.util.List#toArray(java.lang.Object[])
     */
    public <T> T[] toArray(T[] a) {
        return nodes.toArray(a);
    }

    /* (non-Javadoc)
     * @see java.util.List#add(java.lang.Object)
     */
    public boolean add(E e) {
        return nodes.add(e);
    }

    /* (non-Javadoc)
     * @see java.util.List#remove(java.lang.Object)
     */
    public boolean remove(Object o) {
        return nodes.remove(o);
    }

    /* (non-Javadoc)
     * @see java.util.List#containsAll(java.util.Collection)
     */
    public boolean containsAll(Collection<?> c) {
        return nodes.containsAll(c);
    }

    /* (non-Javadoc)
     * @see java.util.List#addAll(java.util.Collection)
     */
    public boolean addAll(Collection<? extends E> c) {
        return nodes.addAll(c);
    }

    /* (non-Javadoc)
     * @see java.util.List#addAll(int, java.util.Collection)
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        return nodes.addAll(index, c);
    }

    /* (non-Javadoc)
     * @see java.util.List#removeAll(java.util.Collection)
     */
    public boolean removeAll(Collection<?> c) {
        return nodes.removeAll(c);
    }

    /* (non-Javadoc)
     * @see java.util.List#retainAll(java.util.Collection)
     */
    public boolean retainAll(Collection<?> c) {
        return nodes.retainAll(c);
    }

    /* (non-Javadoc)
     * @see java.util.List#clear()
     */
    public void clear() {
        nodes.clear();
    }

    /* (non-Javadoc)
     * @see java.util.List#get(int)
     */
    public E get(int index) {
        return nodes.get(index);
    }

    /* (non-Javadoc)
     * @see java.util.List#set(int, java.lang.Object)
     */
    public E set(int index, E element) {
        return nodes.set(index, element);
    }

    /* (non-Javadoc)
     * @see java.util.List#add(int, java.lang.Object)
     */
    public void add(int index, E element) {
        nodes.add(index, element);
    }

    /* (non-Javadoc)
     * @see java.util.List#remove(int)
     */
    public E remove(int index) {
        return nodes.remove(index);
    }

    /* (non-Javadoc)
     * @see java.util.List#indexOf(java.lang.Object)
     */
    public int indexOf(Object o) {
        return nodes.indexOf(o);
    }

    /* (non-Javadoc)
     * @see java.util.List#lastIndexOf(java.lang.Object)
     */
    public int lastIndexOf(Object o) {
        return nodes.lastIndexOf(o);
    }

    /* (non-Javadoc)
     * @see java.util.List#listIterator()
     */
    public ListIterator<E> listIterator() {
        return nodes.listIterator();
    }

    /* (non-Javadoc)
     * @see java.util.List#listIterator(int)
     */
    public ListIterator<E> listIterator(int index) {
        return nodes.listIterator(index);
    }

    /* (non-Javadoc)
     * @see java.util.List#subList(int, int)
     */
    public List<E> subList(int fromIndex, int toIndex) {
        return nodes.subList(fromIndex, toIndex);
    }

    /**
     * Gets the nodes.
     *
     * @return the nodes
     */
    public List<E> getNodes() {
        return nodes;
    }

    /**
     * Sets the nodes.
     *
     * @param nodes the new nodes
     */
    public void setNodes(List<E> nodes) {
        this.nodes = nodes;
    }

    /**
     * Instantiates a new node list.
     */
    NodeList() {
        super();
    }

    /**
     * Instantiates a new node list.
     *
     * @param nodes the nodes
     * @param posBegin the pos begin
     * @param posEnd the pos end
     */
    NodeList(List<E> nodes, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.nodes = nodes;
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.Node#accept(com.digiarea.es5.visitor.VoidVisitor, java.lang.Object)
     */
    @Override
    public <C> void accept(VoidVisitor<C> v, C ctx) throws Exception {
        v.visit(this, ctx);
    }

    /* (non-Javadoc)
     * @see com.digiarea.es5.Node#accept(com.digiarea.es5.visitor.GenericVisitor, java.lang.Object)
     */
    @Override
    public <R, C> R accept(GenericVisitor<R, C> v, C ctx) throws Exception {
        return v.visit(this, ctx);
    }

}
