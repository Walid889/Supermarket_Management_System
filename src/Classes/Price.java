package Classes;


public class Price {
    protected double itemPrice;
    protected double packetPrice;
    protected double boxPrice;
    
    
    // Constractor to inialize price to zero
    public Price(){
        itemPrice=0;
        packetPrice=0;
        boxPrice=0;
    }
    
    // Set item Price 
    public void setItemPrice(double price){
        if (price<0){
            System.out.print("You Enter a negative Number");  // will be replaced by alert
        }
        else
       itemPrice=price; 
    }
    
    // Get item Price 
    public double getItemPrice(){
            return itemPrice;
    }
    
     // Set item Price 
    public void setPacketPrice(double price){
         if (price<0){
            System.out.print("You Enter a negative Number");  // will be replaced by alert
        }
        else
       packetPrice=price; 
    }
    
    // Get item Price 
    public double getPacketPrice(){
            return packetPrice;
    }
    
     // Set item Price 
    public void setBoxPrice(double price){
         if (price<0){
            System.out.print("You Enter a negative Number");  // will be replaced by alert
        }
        else
       boxPrice=price; 
    }
    
    // Get item Price 
    public double getBoxPrice(){
            return boxPrice;
    }
 
}
   
    //edit Price 
    /*public void editPrice (double item , double packet,double box){
        if (item <0 || packet <0 || box <0){
            System.out.print("You Enter a negative Number");  // will be replaced by alert  
        }else{
        itemPrice=item;
        packetPrice=packet;
        boxPrice=box;
        }
        
    }*/
    