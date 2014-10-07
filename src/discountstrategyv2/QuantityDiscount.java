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
public class QuantityDiscount implements DiscountStrategy
{
    private int qtyNeeded;
    private int value;
    private boolean isPercent;
    
    public QuantityDiscount(int qytNeeded, int value, boolean isPercent)
    {
        setValue(value);
        setQtyNeeded(qtyNeeded);
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
     * Returns the discount based on the quantity. If the quantity does not meet
     * the required quantity, no discount is given.
     */
    public int getDiscount(int qty) {
        if(!isPercent)
        {
            return value * (qty / qtyNeeded);
        }
        return qty >= qtyNeeded ? value : 0;
    }

    /**
     * Returns the quantity needed for a discount.
     * @return Quantity needed to get discount.
     */
    public int getQtyNeeded() {
        return qtyNeeded;
    }

    /**
     * Sets the quantity needed for a discount. Quantity must be greater than 1.
     * @param qtyNeeded Number of items needed for a discount.
     */
    public void setQtyNeeded(int qtyNeeded) {
        if(qtyNeeded <= 1)
        {
            throw new IllegalArgumentException();
        }
        this.qtyNeeded = qtyNeeded;
    }
    
    
    
}
