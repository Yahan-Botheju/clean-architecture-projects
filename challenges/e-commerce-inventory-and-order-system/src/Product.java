public class Product {
    private String productId;
    private String productName;
    private double price;
    private int stockQuantity;

    //create parameterized constructor
    public Product(String productId, String productName, double price, int stockQuantity) {
        this.productId = productId;

        if(productName == null || productName.isEmpty()) {
            System.out.println("+ Product name cannot be null or empty");
        }
        this.productName = (productName == null || productName.isEmpty()) ? "Unknown Product" : productName;

        if(price < 0){
            System.out.println("+ Invalid price! set to 0.0");
        }
        this.price = (price < 0) ? 0.0 : price;

        if(stockQuantity < 0){
            System.out.println("+ Invalid stock quantity");
        }
        this.stockQuantity = (stockQuantity < 0) ? 0 : stockQuantity;
    }

    /* __GETTERS__ */

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }


    /* __SETTERS__ */

    public void setProductName(String productName) {
        if(productName.isEmpty()){
            System.out.println("++ Product name cannot be empty");
            return;
        }
        this.productName = productName;
    }

    public void setPrice(double price) {
        if(price < 0){
            System.out.println("++ Invalid price");
            return;
        }
        this.price = price;
    }

    //price set through the add stock
    private void setStockQuantity(int stockQuantity) {
        this.stockQuantity += stockQuantity;
    }

    /* __STOCK_LOGIC__ */

    //add quantity
    public void addStock(int addQuantity){
        if(addQuantity <= 0){
            System.out.println("++ Quantity to add must be greater than 0");
            return;
        }
        setStockQuantity(addQuantity);
    }

    /* __BUY_PRODUCT__ */

    //buy product
    public void buyProduct(int buyQuantity){
        if(buyQuantity <= 0){
            System.out.println("++ Invalid purchase quantity");
            return;
        }
        if(buyQuantity > stockQuantity){
            System.out.println("++ Insufficient stock! Available stock: " + stockQuantity);
            return;
        }
        this.stockQuantity -= buyQuantity;
        System.out.println("++ Purchase successful!, Total:" + buyQuantity * getPrice());
    }

    /* __PRINT_INFO__ */

    //get print details
    public void printInfo(){
        System.out.println("Product Id: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Stock Quantity: " + stockQuantity);
        System.out.println("_________________________________");
    }
}





































