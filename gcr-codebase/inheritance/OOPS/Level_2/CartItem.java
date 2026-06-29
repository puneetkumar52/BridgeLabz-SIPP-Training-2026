class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " items added.");
    }

    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " items removed.");
        } else {
            System.out.println("Not enough items to remove!");
        }
    }

    void displayTotalCost() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem("Shoes", 2000, 2);
        cart.addItem(1);
        cart.removeItem(1);
        cart.displayTotalCost();
    }
}
