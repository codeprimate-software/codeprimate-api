/*
 * Copyright 2014-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codeprimate.lang;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The StringUtilsTest is a test suite containing test cases for testing the contract and functionality of
 * the StringUtils class.
 * 
 * @author John J. Blum
 * @see org.codeprimate.lang.StringUtils
 * @see org.junit.Test
 * @since 1.0.0
 */
@SuppressWarnings("null")
public class StringUtilsTest {

  @Test
  public void testConcat() {
    assertEquals("", StringUtils.concat((Object[]) null));
    assertEquals("", StringUtils.concat(""));
    assertEquals(" ", StringUtils.concat(" "));
    assertEquals("   ", StringUtils.concat("   "));
    assertEquals("123", StringUtils.concat("123"));
    assertEquals("1 2 3", StringUtils.concat("1 2 3"));
    assertEquals(" 1 2 3 ", StringUtils.concat(" 1 2 3 "));
    assertEquals("trueC13.14159test", StringUtils.concat(true, 'C', 1, 3.14159f, "test"));
    assertEquals("test testing tested", StringUtils.concat("test", " testing", " tested"));
  }

  @Test
  public void testConcatWithDelimiter() {
    assertEquals("", StringUtils.concat(null, null));
    assertEquals("", StringUtils.concat(null, " "));
    assertEquals("", StringUtils.concat(new Object[] { "" }, " "));
    assertEquals(" ", StringUtils.concat(new Object[] { " " }, " "));
    assertEquals("     ", StringUtils.concat(new Object[] { " ", " ", " " }, " "));
    assertEquals(" | | ", StringUtils.concat(new Object[] { " ", " ", " " }, "|"));
    assertEquals("abc", StringUtils.concat(new Object[] { "a", "b", "c" }, null));
    assertEquals("abc", StringUtils.concat(new Object[] { "a", "b", "c" }, ""));
    assertEquals("a b c", StringUtils.concat(new Object[] { "a", "b", "c" }, " "));
    assertEquals("a   b   c", StringUtils.concat(new Object[] { "a", "b", "c" }, "   "));
    assertEquals("a_b_c", StringUtils.concat(new Object[] { "a", "b", "c" }, "_"));
    assertEquals("a|b|c", StringUtils.concat(new Object[] { "a", "b", "c" }, "|"));
    assertEquals("a>b>c", StringUtils.concat(new Object[] { "a", "b", "c" }, ">"));
    assertEquals("a&b&c", StringUtils.concat(new Object[] { "a", "b", "c" }, "&"));
    assertEquals("*", StringUtils.concat(new Object[] { "*" }, "*"));
    assertEquals("***", StringUtils.concat(new Object[] { "*", "*" }, "*"));
    assertEquals("*-*", StringUtils.concat(new Object[] { "*", "*" }, "-"));
  }

  @Test
  public void testDefaultIfBlank() {
    assertNull(StringUtils.defaultIfBlank((String[]) null));
    assertNull(null, StringUtils.defaultIfBlank(null, ""));
    assertNull(null, StringUtils.defaultIfBlank(null, "", " "));
    assertNull(null, StringUtils.defaultIfBlank(null, "", " ", "\0"));
    assertEquals("test", StringUtils.defaultIfBlank("test", null, "", " "));
    assertEquals("test", StringUtils.defaultIfBlank(null, "", " ", "test"));
    assertEquals("test", StringUtils.defaultIfBlank(null, "", "test", " ", null));
    assertEquals("_", StringUtils.defaultIfBlank("_", null, "", " "));
    assertEquals("empty", StringUtils.defaultIfBlank(null, "", "empty", " "));
    assertEquals("blank", StringUtils.defaultIfBlank(null, "", " ", "blank"));
    assertEquals("null", StringUtils.defaultIfBlank("null", null, "", " "));
    assertEquals("null", StringUtils.defaultIfBlank("null", "empty", "blank"));
  }

  @Test
  public void testGetDigitsOnly() {
    assertEquals("", StringUtils.getDigitsOnly(null));
    assertEquals("", StringUtils.getDigitsOnly(""));
    assertEquals("", StringUtils.getDigitsOnly(" "));
    assertEquals("", StringUtils.getDigitsOnly("abc"));
    assertEquals("", StringUtils.getDigitsOnly("abcOneTwoThree"));
    assertEquals("", StringUtils.getDigitsOnly("@$$!"));
    assertEquals("", StringUtils.getDigitsOnly("lOlOl"));
    assertEquals("111", StringUtils.getDigitsOnly("1O1O1"));
    assertEquals("7", StringUtils.getDigitsOnly("OO7"));
    assertEquals("007", StringUtils.getDigitsOnly("007"));
    assertEquals("123456789", StringUtils.getDigitsOnly("123,456.789"));
  }

  @Test
  public void testGetLettersOnly() {
    assertEquals("", StringUtils.getLettersOnly(null));
    assertEquals("", StringUtils.getLettersOnly(""));
    assertEquals("", StringUtils.getLettersOnly(" "));
    assertEquals("", StringUtils.getLettersOnly("123"));
    assertEquals("", StringUtils.getLettersOnly("123@$$!"));
    assertEquals("", StringUtils.getLettersOnly("!@$$%#*?"));
    assertEquals("", StringUtils.getLettersOnly("10101"));
    assertEquals("lll", StringUtils.getLettersOnly("l0l0l"));
    assertEquals("", StringUtils.getLettersOnly("007"));
    assertEquals("OO", StringUtils.getLettersOnly("OO7"));
    assertEquals("OOSeven", StringUtils.getLettersOnly("OOSeven"));
  }

  @Test
  public void testGetSpaces() {
    assertEquals("", StringUtils.getSpaces(0));
    assertEquals(" ", StringUtils.getSpaces(1));
    assertEquals("  ", StringUtils.getSpaces(2));
    assertEquals("   ", StringUtils.getSpaces(3));
    assertEquals("    ", StringUtils.getSpaces(4));
    assertEquals("     ", StringUtils.getSpaces(5));
    assertEquals("      ", StringUtils.getSpaces(6));
    assertEquals("       ", StringUtils.getSpaces(7));
    assertEquals("        ", StringUtils.getSpaces(8));
    assertEquals("         ", StringUtils.getSpaces(9));
    assertEquals("          ", StringUtils.getSpaces(10));
    assertEquals("           ", StringUtils.getSpaces(11));
    assertEquals("            ", StringUtils.getSpaces(12));
    assertEquals("             ", StringUtils.getSpaces(13));
    assertEquals("              ", StringUtils.getSpaces(14));
    assertEquals("               ", StringUtils.getSpaces(15));
    assertEquals("                ", StringUtils.getSpaces(16));
    assertEquals("                 ", StringUtils.getSpaces(17));
    assertEquals("                  ", StringUtils.getSpaces(18));
    assertEquals("                   ", StringUtils.getSpaces(19));
    assertEquals("                    ", StringUtils.getSpaces(20));
    assertEquals("                     ", StringUtils.getSpaces(21));
  }

  @Test
  public void testIsBlank() {
    assertTrue(StringUtils.isBlank(null));
    assertTrue(StringUtils.isBlank(""));
    assertTrue(StringUtils.isBlank("\0"));
    assertTrue(StringUtils.isBlank(" "));
    assertTrue(StringUtils.isBlank("   "));
  }

  @Test
  public void testIsNotBlank() {
    assertFalse(StringUtils.isBlank("test"));
    assertFalse(StringUtils.isBlank("null"));
    assertFalse(StringUtils.isBlank("empty"));
    assertFalse(StringUtils.isBlank("_"));
    assertFalse(StringUtils.isBlank("____"));
  }

  @Test
  public void testIsEmpty() {
    assertTrue(StringUtils.isEmpty(""));
  }

  @Test
  public void testIsNotEmpty() {
    assertFalse(StringUtils.isEmpty("test"));
    assertFalse(StringUtils.isEmpty("null"));
    assertFalse(StringUtils.isEmpty("empty"));
    assertFalse(StringUtils.isEmpty(null));
    assertFalse(StringUtils.isEmpty(" "));
    assertFalse(StringUtils.isEmpty("   "));
    assertFalse(StringUtils.isEmpty("_"));
    assertFalse(StringUtils.isEmpty("___"));
  }

  @Test
  public void testPadEnding() {
    assertEquals("", StringUtils.pad("", 'X', 0));
    assertEquals(" ", StringUtils.pad(" ", 'X', 0));
    assertEquals(" ", StringUtils.pad(" ", 'X', 1));
    assertEquals("   ", StringUtils.pad("   ", 'X', 0));
    assertEquals("   ", StringUtils.pad("   ", 'X', 3));
    assertEquals("X", StringUtils.pad("", 'X', 1));
    assertEquals(" X", StringUtils.pad(" ", 'X', 2));
    assertEquals("  XX", StringUtils.pad("  ", 'X', 4));
    assertEquals("test", StringUtils.pad("test", 'X', 0));
    assertEquals("test", StringUtils.pad("test", 'X', 4));
    assertEquals("testX", StringUtils.pad("test", 'X', 5));
    assertEquals("testXXX", StringUtils.pad("test", 'X', 7));
  }

  @Test(expected = NullPointerException.class)
  public void testPadEndingWithNull() {
    try {
      StringUtils.pad(null, 'X', 10);
    }
    catch (NullPointerException expected) {
      assertEquals("The String value to pad cannot be null!", expected.getMessage());
      throw expected;
    }
  }

  @Test
  public void testToLowerCase() {
    assertNull(StringUtils.toLowerCase(null));
    assertEquals("null", StringUtils.toLowerCase("null"));
    assertEquals("null", StringUtils.toLowerCase("NULL"));
    assertEquals("", StringUtils.toLowerCase(""));
    assertEquals(" ", StringUtils.toLowerCase(" "));
    assertEquals("test", StringUtils.toLowerCase("TEST"));
    assertEquals("1", StringUtils.toLowerCase("1"));
    assertEquals("!", StringUtils.toLowerCase("!"));
    assertEquals("$00", StringUtils.toLowerCase("$00"));
    assertEquals("jon doe", StringUtils.toLowerCase("Jon Doe"));
  }

  @Test
  public void testToUpperCase() {
    assertNull(StringUtils.toUpperCase(null));
    assertEquals("NULL", StringUtils.toUpperCase("NULL"));
    assertEquals("NULL", StringUtils.toUpperCase("null"));
    assertEquals("", StringUtils.toUpperCase(""));
    assertEquals(" ", StringUtils.toUpperCase(" "));
    assertEquals("TEST", StringUtils.toUpperCase("test"));
    assertEquals("2", StringUtils.toUpperCase("2"));
    assertEquals("!", StringUtils.toUpperCase("!"));
    assertEquals("$00", StringUtils.toUpperCase("$00"));
    assertEquals("JON DOE", StringUtils.toUpperCase("Jon Doe"));
  }

  @Test
  public void testTrim() {
    assertNull(StringUtils.trim(null));
    assertEquals("", StringUtils.trim(""));
    assertEquals("", StringUtils.trim(" "));
    assertEquals("", StringUtils.trim("   "));
    assertEquals("null", StringUtils.trim("null"));
    assertEquals("test", StringUtils.trim(" test"));
    assertEquals("test", StringUtils.trim("test "));
    assertEquals("test", StringUtils.trim(" test   "));
    assertEquals("a b  c   d", StringUtils.trim("  a b  c   d "));
  }

  @Test
  public void testTruncate() {
    assertEquals("", StringUtils.truncate("", 0));
    assertEquals("", StringUtils.truncate("", 1));
    assertEquals(" ", StringUtils.truncate(" ", 1));
    assertEquals(" ", StringUtils.truncate(" ", 5));
    assertEquals(" ", StringUtils.truncate("   ", 1));
    assertEquals("XX", StringUtils.truncate("XXX", 2));
    assertEquals("XX", StringUtils.truncate("XX", 4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTruncateWithNegativeLength() {
    try {
      StringUtils.truncate("XX", -1);
    }
    catch (IllegalArgumentException expected) {
      assertEquals("Length must be greater than equal to 0!", expected.getMessage());
      throw expected;
    }
  }

  @Test
  public void testValueOf() {
    assertEquals("null", StringUtils.valueOf(null));
    assertEquals("null", StringUtils.valueOf(null, (String[]) null));
    assertEquals("null", StringUtils.valueOf(null, new String[] { }));
    assertEquals("test", StringUtils.valueOf(null, "test"));
    assertEquals("nil", StringUtils.valueOf(null, "nil", "test"));
    assertEquals("test", StringUtils.valueOf("test", (String[]) null));
    assertEquals("null", StringUtils.valueOf("null", "test"));
    assertEquals("nil", StringUtils.valueOf("nil", "mock", "test"));
    assertEquals("", StringUtils.valueOf("", "test", "mock", "null"));
    assertEquals(" ", StringUtils.valueOf(" ", "test", "mock", "nil"));
    assertEquals("true", StringUtils.valueOf(true, "test", "nil", null));
    assertEquals("1", StringUtils.valueOf(1, "one"));
    assertEquals(String.valueOf(Math.PI), StringUtils.valueOf(Math.PI, "314159"));
  }

  @Test
  public void testWrap() {
    final String line = "The line of text to split for testing purposes!";

    final String expectedLine = "The line of".concat(StringUtils.LINE_SEPARATOR)
      .concat("text to split").concat(StringUtils.LINE_SEPARATOR)
      .concat("for testing").concat(StringUtils.LINE_SEPARATOR)
      .concat("purposes!");

    final String actualLine = StringUtils.wrap(line, 15, null);

    assertNotNull(actualLine);
    assertEquals(expectedLine, actualLine);
  }

  @Test
  public void testWrapWithIndent() {
    final String line = "The line of text to split for testing purposes!";

    final String expectedLine = "The line of".concat(StringUtils.LINE_SEPARATOR)
      .concat("\t").concat("text to split").concat(StringUtils.LINE_SEPARATOR)
      .concat("\t").concat("for testing").concat(StringUtils.LINE_SEPARATOR)
      .concat("\t").concat("purposes!");

    final String actualLine = StringUtils.wrap(line, 15, "\t");

    assertNotNull(actualLine);
    assertEquals(expectedLine, actualLine);
  }

}
