package core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "CUSTOMER")
public class Customer {

    String id;
    String firstName;
    String lastName;
    String street;
    String city;
    
    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }  
   
    public void setID(String id) {
		this.id = id;
	}
    @XmlElement(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
    @XmlElement(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    
    @XmlElement(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String lastName) {
		this.street = lastName;
	}
    
    @XmlElement(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
		this.city = city;
	}

}
