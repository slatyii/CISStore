import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StoreTester {
    static Store store = new Store();

    public static void main(String[] args){
        StoreTester s = new StoreTester();
        s.addBookTest();
        s.bookAndPhoneTest();
        s.phonesTest();
        s.itemsTest();

    }
    void addBookTest(){
        Book b = new Book();
        store.addBook(b);
        assert true;
    }
    void bookAndPhoneTest(){
        Phone p = new Phone();
        Book b = new Book();
        store.addBook(b);
        store.addPhone(p);
        assertTrue(true);
    }
    void phonesTest(){
        Phone p1 = new Phone();
        Phone p2 = new Phone();
        Phone p3 = new Phone();

        store.addPhone(p1);
        store.addPhone(p2);
        store.addPhone(p3);


        store.updatePhones("Room 512");
        for(Phone p : store.getAllPhones()){
            assertEquals(p.getLocation(), "Room 512");
        }


    }

    void itemsTest(){
        for(CISItem i : store.getItems("Phone")) System.out.println("This is " + i.toString());
        for(CISItem i : store.getItems("book")) System.out.println("This is " + i.toString());
        for(CISItem i : store.getItems("ARDUINO")) System.out.println("This is " + i.toString());
    }

    void updateTest(){
        System.out.println();
        store.updateItems("phone", "location", "Room 511");
        for(CISItem i : store.getItems("Phone")) System.out.println("Location is " + i.getLocation());
    }
}
