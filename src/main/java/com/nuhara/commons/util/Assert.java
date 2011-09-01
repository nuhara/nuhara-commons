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
 * Copycat of Spring's {@code Assert} mechanism.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public final class Assert {

    /**
     * Utility classes should not have a public or default constructor.
     */
    private Assert() {
        // noop
    }

    /**
     * @param o
     *        the object/reference to check
     * @param message
     *        the {@link NullPointerException} message
     */
    public static void notNull(final Object o, final String message) {
        if (o == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * @param condition
     *        the boolean condition to check
     * @param message
     *        the {@link IllegalArgumentException} message
     */
    public static void isTrue(final boolean condition, final String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
