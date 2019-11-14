package com.example.colorfall;
//*************************
//Class that performs a check to ensure the tool selected is in fact a tool that can be modified.
//**************************
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
