/*
 * Copyright(C) 2021, To Quang Huy
 * J1.L.P0023
 * Fruit Shop
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-01       1.0                HuyTQ            First Implement
 */
package fruitshop;

/**
 * This class contain information of Fruits and some getter and setter.
 *
 * @author HuyTQ
 */
public class Fruit {

    private int fruitId;
    private String name;
    private int quantity;
    private String origin;
    private float price;

    /**
     * no parameter constructor,
     */
    public Fruit() {
    }

    /**
     * Constructs with parameters:
     *
     * @param fruitId
     * @param name
     * @param quantity
     * @param origin
     * @param price
     */
    public Fruit(int fruitId, String name, int quantity, String origin, float price) {
        this.fruitId = fruitId;
        this.name = name;
        this.quantity = quantity;
        this.origin = origin;
        this.price = price;
    }

    /**
     * Getter of FruitId
     *
     * @return id of fruit
     */
    public int getFruitId() {
        return fruitId;
    }

    /**
     * Getter of Name
     *
     * @return String that is fruit name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of Origin
     *
     * @return String that is fruit origin.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Getter of Price
     *
     * @return real number that is fruit price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Getter of Quantity
     *
     * @return an integer number that is fruit quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter of Price
     *
     * @param price price want to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Setter of Quantity
     *
     * @param quantity quantity want to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayFruit() {
        System.out.println(String.format("| %-9d| %-17s| %-13d| %-15s| $%-13.2f|", fruitId, name, quantity, origin, price));
    }
}
