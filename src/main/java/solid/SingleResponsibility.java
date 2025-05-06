package solid;

// 1. Single Responsibility - Class should have one, and only one reason to change.
class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return marker.price * quantity;
    }

    // *****  Below method is not required as it is not part of the single responsibility principle
//    public void printInvoice() {
//        System.out.println("solid.Invoice for " + marker.name + " (" + marker.color + ") for " + quantity + " markers");
//    }
//
//    public void saveToDB(){
//        System.out.println("Saving to DB");
//    }
}

class InvoiceStore {
    private Invoice invoice;

    public InvoiceStore(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        System.out.println("Saving to DB");
    }
}

class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        System.out.println("Printing invoice");
    }
}
