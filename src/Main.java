import java.util.*;

public class Main {
    public static void main(String[] args) {
        Product bread = new Product("Bread",4, 1.0);
        Product cheese = new Product("Cheese", 4, 3.0);
        Product fruit = new Product("Fruit", 4, 2.0);
        Product apple = new Product("Apple", 4, 0.3);
        Product orange = new Product("Orange", 4, 0.4);
        Product toiletPaper = new Product("Toilet Paper", 4, 2.5);
        Product shampoo = new Product("Shampoo", 4, 8.7);
        Product meat = new Product("Meat", 4, 4.5);

        ArrayList<Product> productsHalbertEijn = new ArrayList<>();
        productsHalbertEijn.add(bread);
        productsHalbertEijn.add(cheese);
        productsHalbertEijn.add(fruit);
        productsHalbertEijn.add(toiletPaper);

        ArrayList<Product> productsDumbo = new ArrayList<>();
        productsDumbo.add(apple);
        productsDumbo.add(orange);
        productsDumbo.add(bread);
        productsDumbo.add(meat);

        ArrayList<Product> productsCaldi = new ArrayList<>();
        productsCaldi.add(fruit);
        productsCaldi.add(shampoo);
        productsCaldi.add(meat);
        productsCaldi.add(bread);


        SuperMarket halbertEijn = new SuperMarket("Halbert Eijn", productsHalbertEijn);
        SuperMarket dumbo = new SuperMarket("Dumbo", productsDumbo);
        SuperMarket caldi = new SuperMarket("Caldi", productsCaldi);

        Map<String, SuperMarket> superMarketMap = new HashMap<>();
        superMarketMap.put("halbert eijn", halbertEijn);
        superMarketMap.put("dumbo", dumbo);
        superMarketMap.put("caldi", caldi);

        Customer customer = new Customer("Customer");
        Scanner scanner = new Scanner(System.in);

//            Ga shoppen
        while(true){
            System.out.println("\nWhat do you want to do?");
            System.out.println("1 - Pick a supermarket");
            System.out.println("2 - buy a product");
            System.out.println("3 - restock a product");
            System.out.println("4 - exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Which supermarket do you want to go to?");
                    System.out.println("Pick one of the following:");
                    System.out.println("- Halbert Eijn");
                    System.out.println("- Dumbo");
                    System.out.println("- Caldi");
                    String superMarketChoice = scanner.nextLine().toLowerCase();

//                          Haal de juiste supermarkt uit de supermarktmap
//                          Laat de customer vervolgens naar deze supermarkt gaan
                    SuperMarket superMarket = superMarketMap.getOrDefault(superMarketChoice, halbertEijn); // Gebruik .getOrDefault(key, default) methode van Map om een default waarde terug te geven als de get een null returned. Zo krijg je nooit een null waarde. Wanneer je gewoon .get(key) gebruikt, kun je een null krijgen.

                    customer.goToSupermarket(superMarket);
                    break;
                case 2:
                    if(customer.superMarket == null) {
                        System.out.println("Pick a supermarket first.");
                        break;
                    }
                    System.out.println("Which product do you want to buy from "+customer.superMarket.name+"?");
                    String name = scanner.nextLine();
                    System.out.println("How many do you want to buy?");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    customer.buyItem(name, amount);
                    break;
                case 3:
                    System.out.println("Which supermarket do you want to restock?");
                    System.out.println("Pick one of the following:");
                    System.out.println("- Halbert Eijn");
                    System.out.println("- Dumbo");
                    System.out.println("- Caldi");
                    superMarketChoice = scanner.nextLine().toLowerCase();
                    superMarket = superMarketMap.getOrDefault(superMarketChoice, halbertEijn);

                    System.out.println("Which product do you want to restock in "+ superMarket.name+"?");
                     name = scanner.nextLine();
                    System.out.println("How many do you want to add?");
                     amount = scanner.nextInt();
                     scanner.nextLine();
                    superMarket.restockItem(name, amount);
                    break;
                case 4:
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println(choice + " is not a valid option");
                    break;
            }
        }
    }
}
