package ra.bussinessImp;

import ra.bussiness.IProduct;

import java.util.Scanner;

public class Product implements IProduct, Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private Boolean productStatus;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest() {
        this.interest = exportPrice-importPrice;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter Product Id ");
        setProductId(Integer.parseInt(input.nextLine()));
        System.out.print("Enter product Name ");
        setProductName(input.nextLine());
        System.out.print("Enter product title ");
        setTitle(input.nextLine());
        System.out.print("Enter product description ");
        setDescriptions(input.nextLine());
        System.out.print("Enter import price of product ");
        setImportPrice(input.nextFloat());
        System.out.print("Enter export price of product ");
        setExportPrice(input.nextFloat());
        System.out.println("Enter status of product");
        setProductStatus(input.nextBoolean());
        setInterest();
        System.out.println("Interest of product is "+ getInterest());
    }

    @Override
    public void displayData() {
        System.out.println("Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", title='" + title + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", productStatus=" + (productStatus? "còn hàng": "hết hàng") +
                '}');
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", title='" + title + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", productStatus=" + productStatus +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return (int) (this.interest- product.interest);
    }
}
