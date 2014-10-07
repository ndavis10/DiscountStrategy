/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyv2;

/**
 *
 * @author viewt_000
 */
public interface Item
{
    public abstract int getID();
    public abstract void setID(int id);
    public abstract ItemType getType();
}
