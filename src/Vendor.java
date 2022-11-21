import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vender {
    private Map<String, Item> Stock;
    private double balance;
    private String nameOfVendor;
    private Object Key;
    private Object Value;


    Vender(int numCandy, int numGum) {
        Stock = new HashMap<>();
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    Vender(String name,int numCandy, int numGum) {
        Stock = new HashMap<>();
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
        this.nameOfVendor = name;
    }

    void changeNameOfItem(String preName, String newName){
        Item it = Stock.get(preName);
        Stock.remove(preName);
        Stock.put(newName,it);
    }

    boolean isItemAtVender(String name){
        return Stock.get(name) != null;
    }

    void emptyVendor(){
        Stock.entrySet().stream().forEach(e ->{ e.getValue().emptyStock();});
    }

    public void setNameOfVendor(String nameOfVendor) {
        this.nameOfVendor = nameOfVendor;
    }



    public String getNameOfVendor() {
        return nameOfVendor;
    }

    int getItemNumber(Vender v,String name){
        if(v.Stock.get(name)!=null) {
            return Stock.get(name).getStock();
        }else return 0;
    }

    /** resets the Balance to 0 */
    void resetBalance () {
        this.balance = 0;
    }

    void restockItem(String name, int itemQuantity){
        if(Stock.get(name)!=null) {
            Stock.get(name).restock(itemQuantity);
        }
    }

    /** returns the current balance */
    double getBalance () {
        return this.balance;
    }

    /** adds money to the machine's balance
     * @param amt how much money to add
     * */
    void addMoney (double amt) {
        if(amt>0)this.balance = this.balance + amt;
    }



    /** attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            }
            else
                System.out.println("Gimme more money");
        }
        else System.out.println("Sorry, don't know that item");
    }



    String vendorSystem(){
        String concat = "";
        ArrayList<Vender> venders = new ArrayList<>();
        venders.add(new Vender("bob",1,1));
        venders.add(new Vender("john",3,1));
        venders.add(new Vender("chloe",1,5));
        venders.add(new Vender("jimmy",10,11));
        venders.add(new Vender("sarah",0,5));

        for (Vender v: venders) {
            concat += "\nVender: " + v.getNameOfVendor() + "\nCandy: "
                    + v.getItemNumber(v,"Candy") + "\nGum: " + v.getItemNumber(v,"Gum");
        }
        return concat;
    }

}


