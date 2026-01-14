package app.products;

public class Product {

    private int id;
    private int sku;
    private String name;
    private double price;
    private double weight;
    private String descriptions;
    private int stock;

    public Product(String line) {
        String[] props = line.split(",");
        this.id = Integer.parseInt(props[0]);
        this.sku = Integer.parseInt(props[1]);
        this.name = props[2];
        this.price = Double.parseDouble(props[3]);
        this.weight = Double.parseDouble(props[4]);
        this.descriptions = props[5];
        this.stock = Integer.parseInt(props[6]);
    }
    public Product(int id, int sku, String name, double price, double weight, String descriptions, int stock) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.descriptions = descriptions;
        this.stock = stock;
    }
    public Product() {
        System.out.println("Constructor fara parametri");
    }

    @Override
    public String toString(){
        return this.id+","+this.sku+","+this.name+","+this.price+","+this.weight+","+this.descriptions+","+this.stock;
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        validateID(id);
        this.id = id;
    }
    public int getSKU(){
        return sku;
    }
    public void setSKU(int sku){
        validateSKU(sku);
        this.sku = sku;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        validateName(name);
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        validatePrice(price);
        this.price = price;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        validateWeight(weight);
        this.weight = weight;
    }
    public String getDescriptions(){
        return descriptions;
    }
    public void setDescriptions(String descriptions){
        validateDescriptions(descriptions);
        this.descriptions = descriptions;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        validateStock(stock);
        this.stock = stock;
    }



    private void validateID(int id){
        if(id<0){
            throw new IllegalArgumentException("ID should be greater than 0");
        }
    }
    private void validateSKU(int sku){
        if(sku<0){
            throw new IllegalArgumentException("SKU should be greater than 0");
        }
    }
    private void validateName(String name){
        if(name==null){
            throw new IllegalArgumentException("Name should not be null");
        }
    }
    private void validatePrice(double price){
        if(price<0){
            throw new IllegalArgumentException("Price should be greater than 0");
        }
    }
    private void validateWeight(double weight){
        if(weight<0){
            throw new IllegalArgumentException("Weight should be greater than 0");
        }
    }
    private void validateDescriptions(String descriptions){
        if(descriptions==null){
            throw new IllegalArgumentException("Descriptions should not be null");
        }
    }
    private void validateStock(int stock){
        if(stock<0){
            throw new IllegalArgumentException("Stock should be greater than 0");
        }
    }

}
