package com.example.colorfall;

public class selectedToolCheck
{
    private String tool = "pencil";

    public String getTool() { return tool;}

    public boolean verifyTool(String toolToCheck)
    {
        if(toolToCheck.equals(getTool()))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}
