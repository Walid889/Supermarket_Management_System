/*
 This class for determine the quantity of product
 Admin and Employee use this class at different place 
 behind each method wrriten who use it and where ?
 */

package Classes;

public class Quantity {
    private int itemsQuantity;   // The Quantity of Items of Product
    private int packetsQuantity; // The Quantity of Packets of Product
    private int boxesQuantity;   // The Quantity of Boxes of Product
    private int itemsInPacket;  // The Number of items in each packet
    private int packetsInBox;   // The Number of Packets in each Box

    public int getItemsQuantity() {
        return itemsQuantity;
    }

    public void setItemsQuantity(int itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    public int getPacketsQuantity() {
        return packetsQuantity;
    }

    public void setPacketsQuantity(int packetsQuantity) {
        this.packetsQuantity = packetsQuantity;
    }

    public int getBoxesQuantity() {
        return boxesQuantity;
    }

    public void setBoxesQuantity(int boxesQuantity) {
        this.boxesQuantity = boxesQuantity;
    }

    public int getItemsInPacket() {
        return itemsInPacket;
    }

    public void setItemsInPacket(int itemsInPacket) {
        this.itemsInPacket = itemsInPacket;
    }

    public int getPacketsInBox() {
        return packetsInBox;
    }

    public void setPacketsInBox(int packetsInBox) {
        this.packetsInBox = packetsInBox;
    }
}





    //Constructor to inialize all of them to be zero
    /*public Quantity(){
        itemsQuantity=0;
        packetsQuantity=0;
        boxesQuantity=0;
        itemsInPacket=0;
        packetsInBox=0;
    }*/
    
   
    /*
    addQuantity 
    Use : To add new quantity 
    who use : Admin at Product page when he press "أضافة"
              ُُEmployee at شراء page 
    */
    /*public void addQuantity(int item,int packet,int box){
       itemsQuantity=itemsQuantity+item; 
       packetsQuantity=packetsQuantity+packet;
       boxesQuantity=boxesQuantity+box;
    }*/
    
    
    /*
    editQuantity 
    Use : To edit  quantity 
    who use : Admin at Product page when he press "تعديل"
             
    */
    
    /* public void editQuantity(int item,int packet,int box){
       itemsQuantity=item; 
       packetsQuantity=packet;
       boxesQuantity=box;
    }*/
    
     
     /*
     itemsInPacketPacketsInBox method
     Use : To Determine the items in each packet and Packets in each box
     who use : Admin in product page 
     */
    /*public void itemsInPacketPacketsInBox(int items,int packets){
        itemsInPacket=items;
        packetsInBox=packets;
    } */
    
    /*
    decreseItems Method
    Use : if a product is sold or damaged or reterned Quantity must be decresed
    how work : it takes the number is sold and decrese it from the the quantity of items
    who use : System
    */
    /*public void decreseItems(int number){
        if(itemsQuantity==0){                       //if itemsQuantity reached to zero 
            itemsQuantity=itemsInPacket;            // Make it = the number of items in packet  and decrese the number of items in packet by 1
            itemsQuantity=itemsQuantity-number;    
            decresePackets(1);
        }
        else
          itemsQuantity=itemsQuantity-number;  
        }*/
    
     /*
    decresePackets Method
    Use : if a product is sold or damaged or reterned Quantity must be decresed
    how work : it takes the number is sold and decrese it from the the quantity of packets
    who use : System
    */     
    /*public boolean decresePackets(int number){
        if(packetsQuantity==0){                         //if packetQuantity reached to zero 
            if (decreseBoxes(1)==true){
            packetsQuantity=packetsInBox;               // Make it = the number of items in packet  and decrese the number of items in packet by 1
            packetsQuantity=packetsQuantity-number;
            return true;
            }
            else 
                return false;
        }
        else
          packetsQuantity=packetsQuantity-number; 
        return true;
        }*/
    
     /*
    decresePackets Method
    Use : if a product is sold or damaged or reterned Quantity must be decresed
    how work : it takes the number is sold and decrese it from the the quantity of boxes
    who use : System
    */ 
    
    /*public boolean decreseBoxes(int number){
        if(packetsQuantity==0){                     //if Quantity reached to zero
           
            System.out.print("You don't Have Required Quantity");  // Alert You Have No Boxes
            return false;
        }
        else
          packetsQuantity=packetsQuantity-number;  
        return true;
        }*/
    
    
    /*public long calcQuantity(JFXTextField box,JFXTextField packet,JFXTextField item){
            return Long.parseLong(box.getText())*
                   Long.parseLong(packet.getText())*
                   Long.parseLong(item.getText());
    }*/