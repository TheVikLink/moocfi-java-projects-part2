
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olehenrikvik
 */
public class ShoppingBasket {
    private List<Purchase> purchaseObjects;

    public ShoppingBasket() {
        this.purchaseObjects = new ArrayList<Purchase>();
    }
    
    public void add(String product, int price) {
        boolean alreadyExists = false;
        for (Purchase purchase : purchaseObjects) {
            if (purchase.product().equals(product)) {
                alreadyExists = true;
                purchase.increaseAmount();
            }
        }
        if (alreadyExists != true) {
            Purchase purchase = new Purchase(product, 1, price);
            this.purchaseObjects.add(purchase);
        }
    }
    
    public int price() {
        int totalPrice = 0;
        for (Purchase purchase : purchaseObjects) {
            totalPrice += purchase.price();
        }
        return totalPrice;
    }
    
    public void print() {
        for (Purchase purchase : purchaseObjects) { 
            System.out.println(purchase.toString());
        }
    }
}
