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
public class Product implements Item
{
    private DiscountStrategy discount;
    private int id;
    private int price;
    
    public Product(int id, DiscountStrategy discount)
    {
        setID(id);
        setDiscount(discount);
    }
    
    public Product(int id)
    {
        setID(id);
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        if(id < 0)
        {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    @Override
    /**
     * Returns the ItemType of the object. All objects of Product are of type
     * PRODUCT.
     */
    public ItemType getType() {
        return ItemType.PRODUCT;
    }
    
    public DiscountStrategy getDiscount()
    {
        return discount;
    }
    
    public void setDiscount(DiscountStrategy discount)
    {
        if(discount == null)
        {
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Set the price of the product. Does not accept non-positive values.
     * @param price The price of the product
     */
    public void setPrice(int price)
    {
        if(price <= 0)
        {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }
}
