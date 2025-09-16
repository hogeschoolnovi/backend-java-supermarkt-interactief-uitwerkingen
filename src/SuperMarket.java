import java.util.ArrayList;
import java.util.List;

public class SuperMarket {
    String name;
    List<Product> products;

//        Dit is de simpele constructor zonder null checks
    public SuperMarket(String name, List<Product> products) {
        this.name = name;
        if (products == null){
            this.products = new ArrayList<>();
        } else {
        this.products = products;
        }
    }

//    public void buyBread(int amount){
//        buyItem(this.bread, amount);
//    }
//
//    public void buyFruit(int amount){
//        buyItem(this.fruit, amount);
//    }
//
//    public void buyToiletPaper(int amount){
//        buyItem(this.toiletPaper, amount);
//    }
//
//    public void buyCheese(int amount){
//        buyItem(this.cheese, amount);
//    }


    public void buyItem(Product product, int amount) {
        if (product.amount >= amount) {
            product.amount -= amount;
            System.out.println("You bought " + amount + " " + product.name + " for " +  product.price * amount + " euro.");
        } else {
            System.err.println("You cannot buy " + amount + " " + product.name + ", we have only " + product.amount + " " + product.name + " in stock");
        }
    }


    public void restockItem(String productName, int amount) {
        for(Product product : this.products){
            if(product.name.equalsIgnoreCase(productName)){
                product.amount += amount;
                return;
            }
        }
//        Als er nks gevonden is
        System.out.println(this.name + " does not have " + productName + " in stock");
    }
}
