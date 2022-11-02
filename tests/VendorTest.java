import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    Vender v = new Vender(2,0);

    @Test
    void testOne(){
        v.addMoney(10.0);
        assertEquals(v.getBalance(),10.0);
    }

    @Test
    void testTwo(){
        v.addMoney(1.0);
        v.select("Gum");
        assertEquals(v.getBalance(),0.5);
    }

    @Test
    void testThree(){
        v.addMoney(1.0);
        v.select("Gum");
        assertEquals(v.getBalance(),0.5);
    }


    @Test
    void testFour(){
        Vender v2 = new Vender(2,2);
        v2.restockItem("Candy",1);
        assertEquals(v2.getItemNumber("Candy"),3);
    }

}