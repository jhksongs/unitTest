import java.util.ArrayList;

class Item {
    double price;
    int stock;

    Item(double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
    }

    void restock(int amount) {
        this.stock = this.stock + amount;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void emptyStock(){
        setStock(0);
    }

    void purchase(int amount) {
        this.stock = this.stock - amount;
    }


}