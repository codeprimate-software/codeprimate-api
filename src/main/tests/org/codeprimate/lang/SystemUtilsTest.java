package org.codeprimate.lang;

import static org.junit.Assert.*;

import java.lang.management.ManagementFactory;

import org.junit.Test;

/**
 * The SystemUtilsTest class is a test suite of test cases for testing the contract and functionality of the SystemUtils
 * class.
 *
 * @author John J. Blum
 * @see org.codeprimate.lang.SystemUtils
 * @see org.junit.Test
 * @since 1.0.0
 */
public class SystemUtilsTest {

  @Test
  public void testIsJavaVersionAtLeast() {
    assertTrue(SystemUtils.isJavaVersionAtLeast("1.6"));
    assertTrue(SystemUtils.isJavaVersionAtLeast("1.6.0_1"));
    // note, the expected version value should be set to the next version of the Java Runtime Environment (JRE)
    // not currently available.
    assertFalse(SystemUtils.isJavaVersionAtLeast("1.7"));
  }

  @Test
  public void testIsHotSpotVM() {
    final boolean expected = ManagementFactory.getRuntimeMXBean().getVmName().contains(SystemUtils.ORACLE_HOTSPOT_JVM_NAME);
    assertEquals(expected, SystemUtils.isHotSpotJVM());
  }

  @Test
  public void testIsJ9VM() {
    final boolean expected = ManagementFactory.getRuntimeMXBean().getVmName().contains(SystemUtils.IBM_J9_JVM_NAME);
    assertEquals(expected, SystemUtils.isJ9JVM());
  }

  @Test
  public void testIsJRockitVM() {
    final boolean expected = ManagementFactory.getRuntimeMXBean().getVmName().contains(SystemUtils.ORACLE_JROCKIT_JVM_NAME);
    assertEquals(expected, SystemUtils.isJRockitJVM());
  }

  @Test
  public void testIsLinux() {
    final boolean expected = ManagementFactory.getOperatingSystemMXBean().getName().contains(SystemUtils.LINUX_OS_NAME);
    assertEquals(expected, SystemUtils.isLinux());
  }
  @Test
  public void testIsMacOSX() {
    final boolean expected = ManagementFactory.getOperatingSystemMXBean().getName().contains(SystemUtils.MAC_OSX_NAME);
    assertEquals(expected, SystemUtils.isMacOSX());
  }

  @Test
  public void testIsWindows() throws Exception {
    final boolean expected = ManagementFactory.getOperatingSystemMXBean().getName().contains(SystemUtils.WINDOWS_OS_NAME);
    assertEquals(expected, SystemUtils.isWindows());
  }

}
