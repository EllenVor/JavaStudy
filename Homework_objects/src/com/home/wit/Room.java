package com.home.wit;

public class Room {
  private double size;
  private boolean isFurniture;
  private int numWindows;

    public Room (double sz, boolean isF, int num)
    {
     size=sz;
     isFurniture=isF;
     numWindows=num;
    }

    public Room (double sz, boolean isF)
    {
        size=sz;
        isFurniture=isF;
        numWindows=0;
    }

    public Room ()
    {
        size=1;
        isFurniture=false;
        numWindows=0;
    }

    public void setSize(double sz)
    {
        if (sz>0) size=sz;
        else System.out.println("Room size should be >0;");
    }
    public void setIsFurniture(boolean F)
    {
        isFurniture=F;
    }
    public void setNumWindows(int num)
    {
        if (num>=0) numWindows=num;
        else System.out.println("Number of windows cannot be negative");
    }

    public double getSize()
    {return size;}

    public boolean getIsFurniture()
    {return isFurniture;}

    public int getNumWindow()
    {return numWindows;}

    public void printStatus(String name)
    {   String furnitureStatus;
        if (isFurniture) furnitureStatus="has furniture";
        else furnitureStatus="no furniture";
        System.out.println("Room "+name+" has "+size+" square meters, "+furnitureStatus+" ,there are "+numWindows+" windows");
    }

}
