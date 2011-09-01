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
 * Created Sep 1, 2011
 */
package com.nuhara.commons.util;

/**
 * @author Alistair A. Israel
 * @since 0.1
 */
public final class ObjectUtils {

    /**
     * Utility classes should not have a public or default constructor.
     */
    private ObjectUtils() {
        // noop
    }

    /**
     * @param o1
     *        the first Object
     * @param o2
     *        the second Object
     * @return {@code true} if either both {@code o1} and {@code o2} are {@code null}, or
     */
    public static boolean nullSafeEquals(final Object o1, final Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o2 != null && o1.equals(o2);
    }

}
