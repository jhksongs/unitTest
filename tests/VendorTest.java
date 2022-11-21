import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

//    @Test
//    void addition() {
//        assertEquals(2, 1 + 1);
//    }

    Vender v ;

    @BeforeEach
    void setUp(){
        v = new Vender("bob",2,2);
    }


    @Test
    void AddMoneyA(){
        v.addMoney(10.0);
        assertEquals(v.getBalance(),10.0);
    }

    @Test
    void AddMoneyB(){
        v.addMoney(-10.0);
        assertEquals(v.getBalance(),0);
    }

    @Test
    void AddMoneyC(){
        v.addMoney(0);
        assertEquals(v.getBalance(),0);
    }

    @Test
    void BuyItemA(){
        v.addMoney(1.0);
        v.select("Gum");
        assertEquals(v.getBalance(),0.5);
    }

    @Test
    void BuyItemB(){
        v.addMoney(2);
        v.select("Candy");
        assertEquals(v.getBalance(),0.75);
    }

    @Test
    void BuyItemC_insufficentfunds(){
        v.addMoney(0);
        v.select("Candy");
        assertEquals(v.getItemNumber(v,"Candy"),2);
    }


    @Test
    void RestockItemsA(){
        v.restockItem("Candy",1);
        assertEquals(v.getItemNumber(v,"Candy"),3);
    }

    @Test
    void RestockItemsB(){
        v.emptyVendor();
        v.restockItem("Candy",1);
        assertEquals(v.getItemNumber(v,"Candy"),1);
    }

    @Test
    void RestockandBuy(){

        v.restockItem("Candy",1);
        assertEquals(v.getItemNumber(v,"Candy"),3);
        v.addMoney(2);
        v.select("Candy");
        assertEquals(v.getBalance(),.75);
    }

    @Test
    void changeVendorName(){
        v.setNameOfVendor("jimmy");
        assertEquals(v.getNameOfVendor(),"jimmy");
    }

    @Test
    void ChangeItemName(){

        v.changeNameOfItem("Candy","Twix");
        assertEquals(v.isItemAtVender("Twix"),true);
        assertEquals(v.isItemAtVender("Candy"),false);
    }

    @Test
    void EmptyVendorWithItems(){
        v.emptyVendor();
        assertEquals(v.getItemNumber(v,"Candy"), 0);
        assertEquals(v.getItemNumber(v,"Gum"), 0);
    }

    @Test
    void EmptyVendorWithOuitItems(){
        Vender v = new Vender(0,0);
        v.emptyVendor();
        assertEquals(v.getItemNumber(v,"Candy"), 0);
        assertEquals(v.getItemNumber(v,"Gum"), 0);
    }

    @Test
    void venderSystemTest(){
        String concat = "\nVender: bob\nCandy: 1\nGum: 1" +
                        "\nVender: john\nCandy: 3\nGum: 1" +
                "\nVender: chloe\nCandy: 1\nGum: 5" +
                "\nVender: jimmy\nCandy: 10\nGum: 11"+
                "\nVender: sarah\nCandy: 0\nGum: 5";

        assertEquals(v.vendorSystem(),concat );
    }

    @RepeatedTest(5)
    void ranBalance(){
        Random ran = new Random(100);
        double add = ran.nextDouble();
        v.addMoney(add);
        assertEquals(add,v.getBalance());

    }

    

}