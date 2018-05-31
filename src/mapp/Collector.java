
package mapp;

public class Collector {
    private int Collector_id;
    private String Collector_name;
    private String Address;
    private String Date;
    private String Requisition_id;
    
    public Collector(int Collector_id,String Collector_name,String Address,String Date,String Requisition_id){
    this.Collector_id=Collector_id;
    this.Collector_name=Collector_name;
    this.Address=Address;
    this.Date=Date;
    this.Requisition_id=Requisition_id;
}

    
    public int getCollector_id(){
        return Collector_id;
    }
    public String getCollector_name(){
        return Collector_name;
    }
    public String getAddress(){
        return Address;
    }
    public String getDate(){
        return Date;
    }
    public String getRequisition_id(){
        return Requisition_id;
    }     
}
