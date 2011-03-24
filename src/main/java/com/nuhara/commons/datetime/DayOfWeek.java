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

import java.util.Calendar;

/**
 * A Java {@code enum} to represent days of the week in the Gregorian calendar.
 * 
 * @author Alistair A. Israel
 */
public enum DayOfWeek {

	/**
	 * Corresponds to {@link Calendar#SUNDAY}
	 */
	SUNDAY(Calendar.SUNDAY),

	/**
	 * Corresponds to {@link Calendar#MONDAY}
	 */
	MONDAY(Calendar.MONDAY),

	/**
	 * Corresponds to {@link Calendar#TUESDAY}
	 */
	TUESDAY(Calendar.TUESDAY),

	/**
	 * Corresponds to {@link Calendar#WEDNESDAY}
	 */
	WEDNESDAY(Calendar.WEDNESDAY),

	/**
	 * Corresponds to {@link Calendar#THURSDAY}
	 */
	THURSDAY(Calendar.THURSDAY),

	/**
	 * Corresponds to {@link Calendar#FRIDAY}
	 */
	FRIDAY(Calendar.FRIDAY),

	/**
	 * Corresponds to {@link Calendar#SATURDAY}
	 */
	SATURDAY(Calendar.SATURDAY);

	private final int intValue;

	/**
	 * @param intValue
	 *            the corresponding {@code int} constant value from
	 *            {@link java.util.Calendar}
	 */
	private DayOfWeek(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * @return the corresponding {@code int} constant value from
	 *         {@link java.util.Calendar}
	 */
	public int intValue() {
		return this.intValue;
	}

	/**
	 * @param intValue
	 *            the {@code int} constant value from {@link java.util.Calendar}
	 * @return the {@code Month}
	 */
	public static DayOfWeek lookup(final int intValue) {
		if (intValue >= Calendar.SUNDAY && intValue <= Calendar.SATURDAY) {
			// Calendar.SUNDAY == 1
			return DayOfWeek.values()[intValue - 1];
		}
		return null;
	}
}
