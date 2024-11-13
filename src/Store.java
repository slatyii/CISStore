import java.util.ArrayList;

public class Store{
    static ArrayList<CISItem> cisItems;

    Store(){
        cisItems = new ArrayList<CISItem>();
    }

    void addBook(Book book){
        cisItems.add(book);
    }

    public void addPhone(Phone phone){
        cisItems.add(phone);
    }

    public void addMagazine(Magazine magazine){

    }

    public void addArduino(Arduino arduino){

    }

    public void updatePhones(String location){
        for(int i = 0; i < getAllPhones().size(); i ++){
            getAllPhones().get(i).location = location;
        }
    }
    public ArrayList<Phone> getAllPhones(){
        ArrayList<Phone> all = new ArrayList<>();
        for(CISItem item : cisItems){
            if(item.getClass() == Phone.class) all.add((Phone)item);
        }
        return all;
    }

}


class CISItem{
    String name;
    String location;
    int price;
    String description;

    String getLocation(){
        return location;
    }
}

class ReadingItem extends CISItem{
    int wordCount;
    String datePublished;
    String author;
}

class ElectronicItem extends CISItem{
    int storageCapacity;
    String model;
    String maker;
    String operatingSystem;
}

class Book extends ReadingItem{
    String isbn, edition, title;
}

class Magazine extends ReadingItem{
    String coverStoryTitle, printDate;
}

class Phone extends ElectronicItem{
    String networkType;
    int screenSize;
}

class Arduino extends ElectronicItem{
    String version;
}



