/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part V
 *
 *  IO.java
 *
 */


public abstract class IO implements UserInterface{
    public static final int GUI_1 = 1;
    public static final int GUI_2 = 2;
    public static final int GUI_3 = 3;

    public void display(String s)
    {

    }

    public String getLine()
    {
        return null;
    }

    public void selectInterface(int i)
    {
        if(i == GUI_1)
            new GUI_1().display();
        else if(i == GUI_2)
            new GUI_1().display();
        else if(i == GUI_3)
            new GUI_1().display();
        else
            System.out.println("Error, No GUI under that name found");
    }

}
