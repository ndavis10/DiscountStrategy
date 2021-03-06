/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyv2;

/**
 * This class represents a flat discount on an item, whether a specific amount
 * or percentage.
 * @author Nathaniel Davis
 * @version 0.8
 */
public class FlatDiscount implements DiscountStrategy {
    
    private int value;
    private boolean isPercent;
    
    public FlatDiscount(int value, boolean isPercent)
    {
        setValue(value);
        setPercent(isPercent);
    }

    
    @Override
    /**
     * Returns the discount value. Discount values are held as integers, divide by 100.0
     * and round when decimal values needed.
     */
    public int getValue() 
    {
        return value;
    }

    @Override
    /**
     * This method sets the discount value. Valid values are positive, non-zero
     * integers.
     * @param value The discount value. Assume this value will be divided by 100 at some point in price calculation
     */
    public void setValue(int value) {
        if(value > 0)
        {
            this.value = value;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    @Override
    /**
     * Returns whether or not the discount value should be treated as a percentage.
     */
    public boolean isPercent() {
        return isPercent;
    }

    @Override
    /**
     * Sets whether or not the discount value should be treated as a percentage.
     * @param isPercent Boolean value representing if the discount is a percentage or not.
     */
    public void setPercent(boolean isPercent) {
        this.isPercent = isPercent;
    }

    @Override
    /**
     * Returns the discount based on the quantity.
     * @param qty The quantity ordered so far
     */
    public int getDiscount(int qty) {
        if(!isPercent)
        {
            return value * (qty);
        }
        return value;
    }
}
