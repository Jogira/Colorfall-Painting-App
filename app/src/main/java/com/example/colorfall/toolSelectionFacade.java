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
            System.out.println("\nCOLOR HAS BEEN SWAPPED TO"+ colorToSwapTo);
            drawActivity.drawingView.setColor(colorToSwapTo);
        }
        else
        {
            System.out.println("\n The tool is not a valid tool that can change colors or size.");
        }
    }
}
