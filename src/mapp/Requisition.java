
package mapp;

public class Requisition {
    private String Requisition_id;
    private int Item_id;
    private int Collector_id;
    private int Quantity;
    private int Price;
    private String Username;
    private String Requisition_date;
    
    public Requisition(String Requisition_id,int Item_id,int Collector_id,int Quantity,int Price,String Username,String Requisition_date){
    this.Requisition_id=Requisition_id;
    this.Item_id=Item_id;
    this.Collector_id=Collector_id;
    this.Quantity=Quantity;
    this.Price=Price;
    this.Username=Username;
    this.Requisition_date=Requisition_date;
}

    
    public String getRequisition_id(){
        return Requisition_id;
    }
    public int getItem_id(){
        return Item_id;
    }
    public int getCollector_id(){
        return Collector_id;
    }
    public int getQuantity(){
        return Quantity;
    }
    public int getPrice(){
        return Price;
    }
    public String getUsername(){
        return Username;
    }
    public String getRequisition_date(){
        return Requisition_date;
    }  
}
