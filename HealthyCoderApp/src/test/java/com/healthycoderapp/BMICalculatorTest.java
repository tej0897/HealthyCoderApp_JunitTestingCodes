package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void should_ReturnTrue_When_Diet_Is_Recommended(){

        // given
        double weight = 80;
        double height = 1.7;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);

        // then
        assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_Diet_Is_Not_Recommended(){

        // given
        double weight = 50;
        double height = 1.8;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);

        // then
        assertFalse(recommended);
    }

    // for exceptions

    @Test
    void should_ThrowException_When_Height_Is_Zero(){

        // given
        double weight = 80;
        double height = 0.0;

        // when
        Executable executable = () -> BMICalculator.isDietRecommended(weight,height);

        // then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_Return_CoderWithWorstBMI_When_CoderList_Is_Not_Empty(){
        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.8, 60));
        coders.add(new Coder(1.8, 90));
        coders.add(new Coder(1.8, 64));

        //when
        Coder coderWithBadBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then
//        assertEquals(1.8, coderWithBadBMI.getHeight());
//        assertEquals(90, coderWithBadBMI.getWeight());

        // if height comparison fails, we will not know if weight passes or fails.
        // so wrap it under assertAll and use lambda for individual assertions.
        // use commas for separation

        assertAll(
                () -> assertEquals(1.8, coderWithBadBMI.getHeight()),
                () -> assertEquals(90, coderWithBadBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNull_When_CoderList_IsEmpty(){
        //given
        List<Coder> coders = new ArrayList<>();

        //when
        Coder badBMICoder = BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertNull(badBMICoder);
    }

    @Test
    void should_Return_correctBMIScoresArray_When_List_IsNotEmpty(){
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] expected = {18.52, 29.59, 19.53};

        // when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        // then
        assertArrayEquals(expected, bmiScores);
    }
}