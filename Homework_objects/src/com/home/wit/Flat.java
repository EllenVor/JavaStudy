package com.home.wit;

public class Flat {

    public static void main(String[] args) {
     Room LivingRoom = new Room(25,true,2);
     Room Kitchen = new Room (12,false,1);
     Room BathRoom = new Room (5,true);
     Room Corridor = new Room();

     LivingRoom.printStatus("Living Room");
     BathRoom.printStatus("Bathroom");
     Corridor.printStatus("Corridor");
     Kitchen.printStatus("Kitchen");
     Kitchen.setIsFurniture(true);
        System.out.println("IsFurniture was updated to: "+Kitchen.getIsFurniture()+";");
     Kitchen.printStatus("Kitchen");
    }
}
