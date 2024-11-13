import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StoreTester {
    Store store = new Store();

    public static void main(String[] args){
        StoreTester s = new StoreTester();
        s.addBookTest();
        s.bookAndPhoneTest();
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
}
