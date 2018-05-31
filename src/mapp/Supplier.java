
package mapp;

public class Supplier {
    private int Supplier_id;
    private String Supplier_name;
    private String Address;
    private String Contact;
    private String Products;
    
    public Supplier(int Supplier_id,String Supplier_name,String Address,String Contact,String Products){
    this.Supplier_id=Supplier_id;
    this.Supplier_name=Supplier_name;
    this.Address=Address;
    this.Contact=Contact;
    this.Products=Products;
}

    
    public int getSupplier_id(){
        return Supplier_id;
    }
    public String getSupplier_name(){
        return Supplier_name;
    }
    public String getAddress(){
        return Address;
    }
    public String getContact(){
        return Contact;
    }
    public String getProducts(){
        return Products;
    }  
}
