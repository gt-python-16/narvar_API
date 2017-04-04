package core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "PRODUCT")
public class Product {

    String id;
    String name;
    String price;
    
    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }  
   
    public void setID(String id) {
		this.id = id;
	}
    @XmlElement(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
		this.name = name;
	}
    
    @XmlElement(name = "PRICE")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
		this.price = price;
	}


}
