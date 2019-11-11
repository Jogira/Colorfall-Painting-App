package com.example.colorfall;


public class toolSelectionFacade
{
    private String selectedTool;
    private float toolSize;

    selectedToolCheck toolChecker;
    currentSizeCheck sizeChecker;

    public toolSelectionFacade(String newTool, float newToolSize)
    {
        selectedTool = newTool;
        toolSize = newToolSize;

        toolChecker = new selectedToolCheck();
        sizeChecker = new currentSizeCheck();
    }

    public String getSelectedTool() { return selectedTool;}
    public float getSize() { return toolSize;}

    public void verifyToolandSwapColor(String colorToSwapTo)
    {
        if (toolChecker.verifyTool(getSelectedTool()) && sizeChecker.verifySize(getSize()))
        {
            drawActivity.currentColor = colorToSwapTo;
        }
    }
}
