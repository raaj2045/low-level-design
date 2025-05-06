package solid;// 2. Open closed principle - Open for extension, closed for modification.

//class solid.InvoiceDao {
//    private solid.Invoice invoice;
//
//    public solid.InvoiceDao(solid.Invoice invoice) {
//        this.invoice = invoice;
//    }
//
//    public void saveToDB() {
//        System.out.println("Saving to DB");
//    }

// ***** Below method does not follow open closed principle as it is not part of the interface.

// public void saveToCSV() {
//     System.out.println("Saving to CSV");
// }
//    }
//}

interface InvoiceDao {
    public void save(Invoice invoice);
}

class DatabaseInvoiceDao implements InvoiceDao {
    public void save(Invoice invoice) {
        System.out.println("Saving to DB");
    }
}

class FileInvoiceDao implements InvoiceDao {
    public void save(Invoice invoice) {
        System.out.println("Saving to File");
    }
}