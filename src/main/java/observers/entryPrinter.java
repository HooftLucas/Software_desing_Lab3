package observers;
import database.Database;
import employee.Employee;

import java.util.Observable;

import java.util.Observer;

public class entryPrinter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Database db = (Database) o;
        System.out.println(db.getEntry((Employee) arg));
    }
}
