package com.example.colorfall;
//*************************
//Class that performs a size check for tools behind the scenes.
//**************************
public class currentSizeCheck
{
    private float size = 70F;

    public float getSize() { return size;}

    public boolean verifySize(float sizeToCheck)
    {
        if(sizeToCheck == getSize())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
