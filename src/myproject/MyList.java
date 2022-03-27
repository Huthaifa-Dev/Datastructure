/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author Huthaifa J Salman
 * @param <E>
 */
public interface MyList<E> {
    public int size();
    
    /**
     *
     * @param index
     * @return
     */
    public E get(int index);
}
