
import java.util.HashMap;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olehenrikvik
 */
public class VehicleRegister {

    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (get(plate) == null) {
            this.owners.put(plate, owner);
            return true;
        }
        return false;
    }

    public String get(RegistrationPlate plate) {
        for (HashMap.Entry<RegistrationPlate, String> entry : this.owners.entrySet()) {
            if (entry.getKey().equals(plate)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean delete(RegistrationPlate plate) {
        if (get(plate) != null) {
            this.owners.remove(plate);
            return true;
        }
        return false;
    }

    public void printRegistrationPlates() {
        for (HashMap.Entry<RegistrationPlate, String> entry : this.owners.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
    
    public void printOwners() {
        HashSet<String> allOwners = new HashSet<String>();
        for (HashMap.Entry<RegistrationPlate, String> entry : this.owners.entrySet()) {
            allOwners.add(entry.getValue());
        }
        for (String owner : allOwners) {
            System.out.println(owner);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.owners != null ? this.owners.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehicleRegister other = (VehicleRegister) obj;
        if (this.owners != other.owners && (this.owners == null || !this.owners.equals(other.owners))) {
            return false;
        }
        return true;
    }
    
    
}
