/**
 * Copyright (c) 2011 Nuhara, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created Mar 24, 2011
 */
package com.nuhara.commons.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit test for {@link StringUtils}.
 *
 * @author Alistair A. Israel
 */
public final class StringUtilsTest {

	/**
	 *
	 */
	private static final String APPLE = "apple";

	/**
	 * Test for {@link StringUtils#join(String, Object[])} .
	 */
	@Test
	public void testJoinStringObjectArray() {
		assertEquals("", StringUtils.join(","));

		final Object[] nil = null;
		assertEquals("", StringUtils.join(",", nil));

		final Object[] a = { APPLE, null, Integer.valueOf(42) };
		assertEquals("apple,,42", StringUtils.join(",", a));

		assertEquals("apple,,42", StringUtils.join(",", APPLE, null, 42));	}

	/**
	 * Test for {@link StringUtils#join(char, Object[])} .
	 */
	@Ignore
	@Test
	public void testJoinCharObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test for {@link StringUtils#join(StringBuffer, String, Object[])}
	 */
	@Ignore
	@Test
	public void testJoinStringBufferStringObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test for {@link StringUtils#join(StringBuffer, char, Object[])}
	 */
	@Ignore
	@Test
	public void testJoinStringBufferCharObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test for {@link StringUtils#join(StringBuilder, String, Object[])}
	 */
	@Ignore
	@Test
	public void testJoinStringBuilderStringObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test for {@link StringUtils#join(StringBuilder, char, Object[])}
	 */
	@Ignore
	@Test
	public void testJoinStringBuilderCharObjectArray() {
		fail("Not yet implemented");
	}

}
