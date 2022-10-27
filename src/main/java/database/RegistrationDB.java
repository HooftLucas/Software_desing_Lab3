package database;

import employee.Employee;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;

import java.util.HashMap;

public class RegistrationDB extends Database
{
    private final HashMap<Employee, RegisterEntry> db;
    private static RegistrationDB instance;

    public RegistrationDB()
    {

        this.db = new HashMap<>();
    }
    public static RegistrationDB getInstance() {
        if (instance == null){
            instance = new RegistrationDB();
        }
        return instance;
    }

    @Override
    public void addEntry(Employee e, RegisterEntry re)
    {

        this.db.put(e, re);
        instance.setChanged();
        instance.notifyObservers(e);
    }

    @Override
    public RegisterEntry getEntry(Employee e)
    {
        return this.db.getOrDefault(e, new RegisterEntryNull());
    }
}
