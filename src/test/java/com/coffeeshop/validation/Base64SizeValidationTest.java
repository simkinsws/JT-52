package com.coffeeshop.validation;


import io.leangen.geantyref.TypeFactory;
import org.junit.Before;
import org.junit.Test;
import static com.coffeeshop.validation.IMAGE_TEST_API.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Base64SizeValidationTest {

    private  Base64Size base64SizeAnnotation;
    private Base64SizeValidator validtor;

    @Before
    public void setUp() throws Exception {
        Map<String,Object> annotationsParams = new HashMap<>();
        annotationsParams.put("maxSize",20);
        base64SizeAnnotation = TypeFactory.annotation(Base64Size.class,annotationsParams);
        validtor = new Base64SizeValidator();
        validtor.initialize(base64SizeAnnotation);
    }

    @Test
    public void testEmptyBase64ImageSize(){
        assertTrue(validtor.isValid("",null));
    }

    @Test
    public void testValidBase64ImageSize(){
        assertTrue(validtor.isValid(COFFE_2_15KB,null));
    }

    @Test
    public void testNotValidBase64ImageSize(){
        assertFalse(validtor.isValid(COFFE_1_23KB,null));
    }

    @Test
    public void testNullBase64ImageSize(){ assertTrue(validtor.isValid(null,null)); }

}
