package com.lxt.common.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** 
* StringUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 13, 2017</pre> 
* @version 1.0 
*/ 
public class StringUtilsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void testRandomNum() throws Exception {
    String result = StringUtils.randomNum(0);
    assertEquals(6, result.length());

    String result2 = StringUtils.randomNum(3);
    assertEquals(3, result2.length());
}

@Test
public void testRandom() throws Exception {
    String result = StringUtils.random(0);
    assertEquals(6, result.length());

    String result2 = StringUtils.random(8);
    assertEquals(8, result2.length());
}

@Test
public void testRandomLower() throws Exception {
    Pattern pattern = Pattern.compile("^[0-9a-z]+$");

    String result = StringUtils.randomLower(0);
    Matcher m1 = pattern.matcher(result);
    assertEquals(6, result.length());
    assertTrue(m1.matches());

    String result2 = StringUtils.randomLower(9);
    Matcher m2 = pattern.matcher(result2);
    assertEquals(9, result2.length());
    assertTrue(m2.matches());
}

@Test
public void testRandomUpper() throws Exception {
    Pattern pattern = Pattern.compile("^[0-9A-Z]+$");

    String result = StringUtils.randomUpper(0);
    Matcher m1 = pattern.matcher(result);
    assertEquals(6, result.length());
    assertTrue(m1.matches());

    String result2 = StringUtils.randomUpper(9);
    Matcher m2 = pattern.matcher(result2);
    assertEquals(9, result2.length());
    assertTrue(m2.matches());

    String result3 = StringUtils.randomUpper(-1);
    Matcher m3 = pattern.matcher(result3);
    assertEquals(6, result3.length());
    assertTrue(m3.matches());
}

@Test
public void testIsNumber() throws Exception {
    assertTrue(StringUtils.isNumber("383485"));
    assertTrue(StringUtils.isNumber("7463524153212"));
    assertFalse(StringUtils.isNumber("3ufh23234"));
    assertFalse(StringUtils.isNumber("384.3"));
    assertFalse(StringUtils.isNumber(".394"));
    assertFalse(StringUtils.isNumber("9438434h"));
}

@Test
public void testIsFloat() throws Exception {
    assertTrue(StringUtils.isFloat("383458.24"));
    assertTrue(StringUtils.isFloat("34343."));
    assertFalse(StringUtils.isFloat(".3232"));
    assertFalse(StringUtils.isFloat("4242525"));
    assertFalse(StringUtils.isFloat("38444.344.443"));
    assertFalse(StringUtils.isFloat("3434..43"));
    assertFalse(StringUtils.isFloat("38434.ff"));
    assertFalse(StringUtils.isFloat("38h34.3"));
    assertFalse(StringUtils.isFloat("38h34.,3"));
    assertFalse(StringUtils.isFloat("."));
}

@Test
public void testIsLetter() throws Exception {
    assertTrue(StringUtils.isLetter("AfjeuEhfje"));
    assertTrue(StringUtils.isLetter("ASDFEG"));
    assertTrue(StringUtils.isLetter("fjfnvvjv"));
    assertFalse(StringUtils.isLetter("fjhekf3hjfgdF"));
    assertFalse(StringUtils.isLetter("ASCFFGe,fe"));
    assertFalse(StringUtils.isLetter("发斯蒂芬"));
    assertFalse(StringUtils.isLetter(".jwiafjsa"));
    assertFalse(StringUtils.isLetter("jw iafjsa"));
    assertFalse(StringUtils.isLetter(null));
}

@Test
public void testIsChinese() throws Exception {
    assertTrue(StringUtils.isChinese("发神经发送"));
    assertFalse(StringUtils.isChinese("法萨芬，防守打法"));
    assertFalse(StringUtils.isChinese("发多少d发到付"));
    assertFalse(StringUtils.isChinese(null));
    assertFalse(StringUtils.isChinese("2放到发"));
    assertFalse(StringUtils.isChinese(" 方式开发"));
    assertFalse(StringUtils.isChinese("放到 发生的"));
}

} 
