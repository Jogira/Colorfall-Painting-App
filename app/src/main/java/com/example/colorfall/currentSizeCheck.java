package com.example.colorfall;

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
