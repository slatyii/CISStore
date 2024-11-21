import java.util.ArrayList;

//import static jdk.internal.org.jline.utils.ExecHelper.exec;

public class Store{
    static ArrayList<CISItem> cisItems;

    Store(){
        cisItems = new ArrayList<CISItem>();
    }

    void addBook(Book book){
        cisItems.add(book);
    }

    void addPhone(Phone phone){
        cisItems.add(phone);
    }

    void addMagazine(Magazine magazine){

    }

    void addArduino(Arduino arduino){

    }

    void updatePhones(String location){
        for(int i = 0; i < getAllPhones().size(); i ++){
            getAllPhones().get(i).location = location;
        }
    }
    ArrayList<Phone> getAllPhones(){
        ArrayList<Phone> all = new ArrayList<>();
        for(CISItem item : cisItems){
            if(item.getClass() == Phone.class) all.add((Phone)item);
        }
        return all;
    }

    ArrayList<CISItem> getItems(String itemType){
        ArrayList<CISItem> all = new ArrayList<>();
        if(itemType.equalsIgnoreCase("Phone")){
            for(CISItem item : cisItems){
                if(item.getClass() == Phone.class) all.add(item);
            }
            return all;
        }else if(itemType.equalsIgnoreCase("Book")){
            for(CISItem item : cisItems){
                if(item.getClass() == Book.class) all.add(item);
            }
            return all;

        }else if(itemType.equalsIgnoreCase("Magazine")){
            for(CISItem item : cisItems){
                if(item.getClass() == Magazine.class) all.add(item);
            }
            return all;

        }else if(itemType.equalsIgnoreCase("Arduino")){
            for(CISItem item : cisItems){
                if(item.getClass() == Arduino.class) all.add(item);
            }
            return all;
        }

        return null;
    }
    void updateItems(String itemType, String property, String value){
        ArrayList<CISItem> items = getItems(itemType);
        for(CISItem i : items){
            if(property.equalsIgnoreCase("name")) i.name = value;
            if(property.equalsIgnoreCase("location")) i.location = value;
            if(property.equalsIgnoreCase("price")) i.price = Integer.parseInt(value);
            if(property.equalsIgnoreCase("description")) i.description = value;
        }
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



