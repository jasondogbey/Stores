
package mapp;

public class Item {
    private int Item_id;
    private String Item_name;
    private int Unit_price;
    private int Quantity;
    private int Supplier_id;
    
    public Item(int Item_id,String Item_name,int Unit_price,int Quantity,int Supplier_id){
    this.Item_id=Item_id;
    this.Item_name=Item_name;
    this.Unit_price=Unit_price;
    this.Quantity=Quantity;
    this.Supplier_id=Supplier_id;
}

    
    public int getItem_id(){
        return Item_id;
    }
    public String getItem_name(){
        return Item_name;
    }
    public int getUnit_price(){
        return Unit_price;
    }
    public int getQuantity(){
        return Quantity;
    }
    public int getSupplier_id(){
        return Supplier_id;
    }
}
