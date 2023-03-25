package ra.run;

import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static ArrayList<Product> productArray = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int option;

        do{
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm [15 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [15 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần [15 điểm]\n" +
                    "4. Xóa sản phẩm theo mã sản phẩm [10 điểm]\n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm [10 điểm]\n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm [10 điểm]\n" +
                    "7. Thoát [05 điểm");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            switch (option){
                case 1: addProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    Collections.sort(productArray);
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:findProductByName();
                    break;
                case 6:changeProductStatus();
                    break;
                case 7:
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    System.exit(0);

                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }

        }while(option !=7);
    }

    //Option 1:
    static void addProduct(){ // thêm sản phẩm
        System.out.println("nhập số lượn sản phẩm muốn thêm: ");
        int quantity = scanner.nextInt();
        for (int i = 0; i < quantity; i++) {
            productArray.add(new Product());
            productArray.get(i).inputData();
        }
    }
    //Option 2:
    static void displayProduct() {
        if(checkProductQuantity()){
            System.out.println("Danh sách hiện có " + productArray.size() + " sản phẩm: ");
            for (int i = 0; i < productArray.size() ; i++) {
                productArray.get(i).displayData();
            }
        }else {
            System.out.println("Danh sách sản phẩm rỗng ");
        }
    }
    static boolean checkProductQuantity(){
        if (productArray.size()==0) {
            return false;
        }else{
            return true;
        }
    }
    //Option 4:
    static void deleteProduct(){
        System.out.println("Enter Product Id you want to delete ");
        int id= scanner.nextInt();
        int i = findIndexById(id);
        if (i == -1) {
            System.out.println("Product you want to delete not exist");
        }else{
            productArray.remove(i);
            System.out.println("Delete Successful product id: "+ id);
        }
    }
    static int findIndexById(int id){
        for (int i = 0; i < productArray.size(); i++) {
            if (id == productArray.get(i).getProductId()) {
                return i;
            }
        }
        return -1;
    }
    //Option 5: Find Product by Name
    static void findProductByName(){
        if (checkProductQuantity()){
            System.out.println("Enter product Name you want to find: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            for (int i = 0; i < productArray.size(); i++) {
                if (name.equalsIgnoreCase(productArray.get(i).getProductName())){
                    productArray.get(i).displayData();
                }
            }
        }else{
            System.out.println("List ko có sản phẩm !!!  ");
        }

    }
    //Option 6: Change Product Status
    static void changeProductStatus(){
            System.out.println("Enter product Id you want to change Status");
            int id= scanner.nextInt();
            int index = findIndexById(id);
            if (index == -1) {
                System.out.println("Product you want to change status is not exist ");
            } else{
                productArray.get(index).setProductStatus(!productArray.get(index).getProductStatus());
            }

    }
    }

