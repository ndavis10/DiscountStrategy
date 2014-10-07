/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyv2;

/**
 * This class represents a line item on the order and maintains the quantity
 * ordered and any discounts.
 * @author Nathaniel Davis
 * @version 0.8
 */
public class LineItem {
    private Item item;
    private DiscountStrategy[] discounts;
    private int qty;
    
    public LineItem(Item item, int qty)
    {
        setItem(item);
        addQty(qty);
        discounts = new DiscountStrategy[0];
        
        //This is ugly, but it works
        if(this.item.getType() == ItemType.PRODUCT)
        {
            DiscountStrategy discount = ((Product)this.item).getDiscount();
            addDiscount(discount);
        }
    }

    /**
     * Returns the Item contained in the LineItem object
     * @return The Item contained in the LineItem
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the item contained in the LineItem, does not accept nulls
     * @param item 
     */
    public void setItem(Item item)
    {
        if(item == null)
        {
            throw new IllegalArgumentException();
        }
        this.item = item;
    }
    
    /**
     * Adds a DiscountStrategy to the discounts array. Does not accept nulls
     * @param discount Discount to be added
     */
    public void addDiscount(DiscountStrategy discount)
    {
        if(discount == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            DiscountStrategy[] temp = new DiscountStrategy[discounts.length + 1];
            System.arraycopy(discounts, 0, temp, 0, discounts.length);
            temp[discounts.length] = discount;
            discounts = temp;
        }
    }
    
    /**
     * Adds the given quantity to the qty field. Accepts all values, negative
     * values subtract
     * @param qty Quantity to add
     */
    public void addQty(int qty)
    {
        this.qty += qty;
    }
    
    /**
     * Returns the LineItem's total.
     * @return Total price of LineItem, represented as an integer.
     */
    public int getTotal()
    {
        if(item.getType() == ItemType.PRODUCT)
        {
            Product p = (Product)item;
            int sub = p.getPrice();
            return calculateDiscountPrice(sub, p);
        }
        
        return 0;
    }
    
    private int calculateDiscountPrice(int sub, Product p)
    {
            for (DiscountStrategy discount : discounts)
            {
                if(discount.isPercent())
                {
                    sub = sub * discount.getDiscount(qty) / 100;
                }
                else
                {
                    sub -= discount.getDiscount(qty);
                }
            }
            return sub;        
    }
}
