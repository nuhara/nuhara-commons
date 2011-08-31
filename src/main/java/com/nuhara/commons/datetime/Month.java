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
 * A Java {@code enum} to represent months in the Gregorian calendar.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public enum Month {

	/**
	 * Corresponds to {@link Calendar#JANUARY}
	 */
	JANUARY(Calendar.JANUARY),

	/**
	 * Corresponds to {@link Calendar#FEBRUARY}
	 */
	FEBRUARY(Calendar.FEBRUARY),

	/**
	 * Corresponds to {@link Calendar#MARCH}
	 */
	MARCH(Calendar.MARCH),

	/**
	 * Corresponds to {@link Calendar#APRIL}
	 */
	APRIL(Calendar.APRIL),

	/**
	 * Corresponds to {@link Calendar#MAY}
	 */
	MAY(Calendar.MAY),

	/**
	 * Corresponds to {@link Calendar#JUNE}
	 */
	JUNE(Calendar.JUNE),

	/**
	 * Corresponds to {@link Calendar#JULY}
	 */
	JULY(Calendar.JULY),

	/**
	 * Corresponds to {@link Calendar#AUGUST}
	 */
	AUGUST(Calendar.AUGUST),

	/**
	 * Corresponds to {@link Calendar#SEPTEMBER}
	 */
	SEPTEMBER(Calendar.SEPTEMBER),

	/**
	 * Corresponds to {@link Calendar#OCTOBER}
	 */
	OCTOBER(Calendar.OCTOBER),

	/**
	 * Corresponds to {@link Calendar#NOVEMBER}
	 */
	NOVEMBER(Calendar.NOVEMBER),

	/**
	 * Corresponds to {@link Calendar#DECEMBER}
	 */
	DECEMBER(Calendar.DECEMBER);

	private final int intValue;

	/**
	 * @param intValue
	 *            the corresponding {@code int} constant value from
	 *            {@link java.util.Calendar}
	 */
	private Month(final int intValue) {
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
	public static Month lookup(final int intValue) {
		if (intValue < Calendar.JANUARY || intValue > Calendar.DECEMBER) {
		    throw new IllegalArgumentException("Invalid month value " + intValue);
		}
		// we only get away with this because Calendar.JANUARY == 0!
		return Month.values()[intValue];
	}
}
