
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olehenrikvik
 */
public class Storehouse {

    private Map<String, Integer> productPrices;
    private Map<String, Integer> productStock;

    public Storehouse() {
        this.productPrices = new HashMap<String, Integer>();
        this.productStock = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        productPrices.put(product, price);
        if (productStock.containsKey(product)) {
            int currentStock = productStock.get(product);
            productStock.put(product, currentStock + stock);
        } else {
            productStock.put(product, stock);
        }
    }

    public int price(String product) {
        if (productPrices.containsKey(product)) {
            return productPrices.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (productStock.containsKey(product)) {
            return productStock.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {
        if (productStock.containsKey(product) && productStock.get(product) > 0) {
            int currentStock = productStock.get(product);
            productStock.put(product, currentStock - 1);
            return true;
        } else {
            return false;
        }
    }
    
    public Set<String> products() {
        return productStock.keySet();
    }
    
    
}
