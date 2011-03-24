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

import java.util.Arrays;

/**
 * @author Alistair A. Israel
 * @since 0.1
 */
public final class Hashcode {

	/**
	 * Utility classes should not have a public or default constructor.
	 */
	public Hashcode() {
		// noop
	}

	/**
	 * Syntatic sugar for computing hash codes. Returns 0 when given no
	 * arguments or {@code null}. Follows the general contract of
	 * {@link Object#hashCode()} when given a single object. Otherwise, uses
	 * {@link Arrays#hashCode(Object[])} with all the arguments.
	 * 
	 * @param args
	 *            the objects to include in the hash code calculation
	 * @return the hash code
	 * @see Arrays#hashCode(Object[])
	 */
	public static int of(final Object... args) {
		if (args == null || args.length == 0) {
			return 0;
		}
		if (args.length == 1) {
			final Object obj = args[0];
			if (obj == null) {
				return 0;
			}
			return obj.hashCode();
		}
		return Arrays.hashCode(args);
	}
}
