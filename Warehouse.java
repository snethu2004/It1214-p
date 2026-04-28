import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added!");
    }

    public void removeItem(String id) {
        for (Item i : items) {
            if (i.itemId.equals(id)) {
                items.remove(i);
                System.out.println("Item removed!");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void updateQuantity(String id, int qty) {
        for (Item i : items) {
            if (i.itemId.equals(id)) {
                i.quantity = qty;
                System.out.println("Quantity updated!");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory Items:");
            for (Item i : items) {
                System.out.println(i);
            }
        }
    }

    public void searchItem(String keyword) {
        for (Item i : items) {
            if (i.itemId.equals(keyword) || i.itemName.equalsIgnoreCase(keyword)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("Item not found.");
    }
}



public class Item {
    String itemId;
    String itemName;
    int quantity;
    double price;

    public Item(String itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    
    public String toString() {
        return itemId + " - " + itemName + " | Qty: " + quantity + " | $" + price;
    }
}


import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Warehouse Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display Items");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    inventory.addItem(new Item(id, name, qty, price));
                }
                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    String id = sc.nextLine();
                    inventory.removeItem(id);
                }
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    String id = sc.nextLine();
                    System.out.print("Enter new quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    inventory.updateQuantity(id, qty);
                }
                case 4 -> {
                    System.out.print("Enter ID or Name to search: ");
                    String key = sc.nextLine();
                    inventory.searchItem(key);
                }
                case 5 -> inventory.displayItems();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}