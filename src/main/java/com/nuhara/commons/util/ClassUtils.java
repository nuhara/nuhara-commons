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
public final class ClassUtils {

    /**
     * Utility classes should not have a public or default constructor.
     */
    private ClassUtils() {
        // noop
    }

    /**
     * @param clazz
     *        the {@link Class}
     * @return the 'friendly' class name
     */
    public static String getShortClassName(final Class<?> clazz) {
        Assert.notNull(clazz, "getShortClassName(null)!");
        final String className = clazz.getName();
        int i = className.lastIndexOf('$');
        if (i == -1) {
            i = className.lastIndexOf('.');
        }
        if (i == -1 && i + 1 < className.length()) {
            return className;
        }
        return className.substring(i + 1);
    }

    /**
     * @param o
     *        an object
     * @return the 'friendly' class name of the object
     */
    public static String getShortClassName(final Object o) {
        Assert.notNull(o, "getShortClassName(null)!");
        return getShortClassName(o.getClass());
    }

}
