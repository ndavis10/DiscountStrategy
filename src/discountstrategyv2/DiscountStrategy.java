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
public interface DiscountStrategy {
    public abstract int getValue();
    public abstract void setValue(int value);
    public abstract boolean isPercent();
    public abstract void setPercent(boolean isPercent);
    public abstract int getDiscount(int qty);
}
