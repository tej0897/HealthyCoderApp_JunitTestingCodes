package com.healthycoderapp;

import org.junit.jupiter.api.Test;

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
}