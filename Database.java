import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Database {
    Set<Notebook> db = new HashSet<>();

    public void fillingDatabase() {
        Notebook n1 = new Notebook();
        n1.fillingWithInformation(1, "MSI", "L2C5", "Windows 10", "Black", "17.3", "CORE i7", "16", "1000", "8");
        db.add(n1);
        Notebook n2 = new Notebook();
        n2.fillingWithInformation(2, "MSI", "L4C5", "Windows 10", "Black", "19.3", "CORE i9", "32", "2000", "16");
        db.add(n2);
        Notebook n3 = new Notebook();
        n3.fillingWithInformation(3, "ACER", "H12G67", "Linux", "White", "15.2", "CORE i5", "8", "250", "4");
        db.add(n3);
        Notebook n4 = new Notebook();
        n4.fillingWithInformation(4, "ACER", "G67Y54", "Linux", "Red", "16.0", "CORE i7", "16", "500", "4");
        db.add(n4);
        Notebook n5 = new Notebook();
        n5.fillingWithInformation(5, "Apple", "MacBook Air", "macOS", "Silver", "13.3", "Apple M1", "8", "256", "4");
        db.add(n5);
        Notebook n6 = new Notebook();
        n6.fillingWithInformation(6, "Apple", "MacBook Air", "macOS", "Silver", "13.6", "Apple M3", "8", "256", "4");
        db.add(n6);
        Notebook n7 = new Notebook();
        n7.fillingWithInformation(7, "HP", "250G9", "None", "Black", "15.6", "CORE i5", "4", "500", "4");
        db.add(n7);
        Notebook n8 = new Notebook();
        n8.fillingWithInformation(8, "HP", "17cn1002ny", "Windown 11", "White", "17.3", "CORE i5", "8", "512", "4");
        db.add(n8);
        Notebook n9 = new Notebook();
        n9.fillingWithInformation(9, "Samsung", "Galaxy Book3", "Windown 11", "Silver", "15.6", "CORE i3", "8", "1000",
                "8");
        db.add(n9);
        Notebook n10 = new Notebook();
        n10.fillingWithInformation(10, "Samsung", "Galaxy Book4", "Windown 11", "Grey", "16.0", "CORE U7", "16", "512",
                "8");
        db.add(n10);
    }

    public void outputDatabase(Set<Notebook> database) {
        for (Notebook elem : database) {
            System.out.println(elem);
        }
    }

    public Set<Notebook> filteringDatabase(Map<String, String> answer) {
        Set<Notebook> filteredDatabase = new HashSet<>();

        boolean flag = true;

        for (Notebook elem : db) {
            for (var mapElem : answer.entrySet()) {
                try {
                    double num = Double.parseDouble(mapElem.getValue());
                    double num1 = Double.parseDouble(elem.parameters.get(mapElem.getKey()));
                    if (num > num1) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    if (!mapElem.getValue().equalsIgnoreCase(elem.parameters.get(mapElem.getKey()))) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                filteredDatabase.add(elem);
            }
            flag = true;
        }
        return filteredDatabase;
    }
}