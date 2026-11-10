
public class Main {
    public static void main(String[] args) {

//         Product validProduct = new Product(
//                 "P101",
//                 "Laptop",
//                 150000.0,
//                 10
//         );
//         validProduct.printInfo();

//         Product invalidProduct = new Product(
//                 "P102",
//                 "",
//                 -15000.0,
//                 -10
//         );
//         invalidProduct.printInfo();


        /* __LOGIC_CHECK__*/

        Product product = new Product(
                "P101",
                "Laptop",
                150000.0,
                10
        );

        //buy over the sufficient quantity
//        product.buyProduct(11);

        //buy sufficient quantity
//        product.buyProduct(5);

        //add stock
//        product.addStock(10);


        /* __SETTER_LOGIC_CHECK__ */

        product.setProductName("");
        product.setProductName("P102");

        product.setPrice(-100000);
        product.setPrice(180000);


        product.printInfo();
    }
}