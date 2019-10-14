package com.example.colorfall;

import android.graphics.Canvas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*********************************************************************************
 * Class Name   - unitTest
 * Description  - use to write JUnit tests.
 *
 * Notes        - we may need more granularity of classes, all unit tests in one
 *                file may be poor organization
 *
 * Author       - Gabe
 * Date         : 10/11/2019
 ********************************************************************************/

public class unitTests {

    /********************************************************************************
     * This test method was autopopulated by Android studio, I am going to leave
     * it for now because it might be a helpful template
     *
     * Author - Gabe
     *******************************************************************************/
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    /*********************************************************************************************
     * Method       : testSpriteCreation
     * Description  : to test if sprites are created (instances of Canvas)
     *
     * Input        : void
     * Output       : void
     *
     * Author       : Gabe
     * Date         : 10/11/2019
     *
     * Notes        : This test currently fails because even though sprite extends canvas, they
     *                  are not the same.
     *                  I would like to compare if a single property of each is the same, but
     *                  I cannot figure out how to do that.
     *                  For example, i would like to see if the alpha value of each obj is equivelent
     *                  when they are implimented, but I cannot find a way to get the alpha channel,
     *                  or any other properties for that matter.
     *                  I cannot find in the api and instances of significant setters or getters.
     *********************************************************************************************/
    //@Test
    //public void testSpriteCreation() {
        //sprite result = new sprite();
        //Canvas expected = new Canvas();
        //assertEquals(result, expected);
    //}

}