package solid;// 4. Interface Segregation Principle -
// Interface should be made only for what it is intended for.

interface RestaurantEmployee {
    void washDishes();
    void serveCustomers();
    void cookFood();
}

class Waiter implements RestaurantEmployee {
    public void washDishes() {
        // Not my job
    }

    @Override
    public void serveCustomers() {
        System.out.println("Serving customers");
    }

    @Override
    public void cookFood() {
        // Not my job
    }
}

// Below is the interface segmented approach

interface WaiterInterface {
    void serveCustomers();
    void takeOrder();
}

interface ChefInterface {
    void cookFood();
    void decideMenu();
}

class Chef implements ChefInterface {
    @Override
    public void cookFood() {
        System.out.println("Cooking food");
    }

    @Override
    public void decideMenu() {
        System.out.println("Deciding menu");
    }
}