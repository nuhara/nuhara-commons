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
package com.nuhara.commons.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;

/**
 * JUnit test for {@link DayOfWeek}
 *
 * @author Alistair A. Israel
 */
public final class DayOfWeekTest {

	/**
	 * Test for {@link DayOfWeek#lookup(int)}
	 */
	@Test
	public void testLookup() {
		for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; ++i) {
			final DayOfWeek dow = DayOfWeek.lookup(i);
			assertNotNull(dow);
			assertEquals(dow.intValue(), i);
		}
	}
}
