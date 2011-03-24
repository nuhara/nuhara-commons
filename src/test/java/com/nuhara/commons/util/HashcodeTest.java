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

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

/**
 * JUnit test for {@link Hashcode}.
 * 
 * @author Alistair A. Israel
 */
public class HashcodeTest {
	
	/**
	 * 
	 */
	private static final String ALL_YOUR_BASE_ARE_BELONG_TO_US = "All your base are belong to us.";

	/**
	 * Test and illustrate basic usage.
	 */
	@Test
	public void testHashcodeOf() {
		final int hashcode = Hashcode.of(ALL_YOUR_BASE_ARE_BELONG_TO_US, Long.valueOf(-1));
		assertEquals(794092386, hashcode);
	}

	/**
	 * 
	 */
	@Test
	public void testHashcodeOfNothing() {
		assertEquals(0, Hashcode.of());
	}
	
	/**
	 * 
	 */
	@Test
	public void testHashcodeOfObject() {
		final Object[] objects = {
				null,
				Boolean.FALSE,
				new Date(),
				new String(ALL_YOUR_BASE_ARE_BELONG_TO_US),
				HashcodeTest.class
		};
		for (final Object o : objects) {
			if (o == null) {
				assertEquals(0, Hashcode.of(o));
			} else {
				assertEquals(o.hashCode(), Hashcode.of(o));
			}
		}
	}

	/**
	 * 
	 */
	@Test
	public void testHashcodeOfArray() {
		final Object[] a = {
				null,
				Boolean.FALSE,
				new Date(),
				new String(ALL_YOUR_BASE_ARE_BELONG_TO_US),
				HashcodeTest.class
		};
		assertEquals(Arrays.hashCode(a), Hashcode.of(a));
		
		// NPE check
		final Object[] nil = null;
		assertEquals(Arrays.hashCode(nil), Hashcode.of(nil));
	}
}
