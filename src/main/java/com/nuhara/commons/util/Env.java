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
 * Created May 25, 2011
 */
package com.nuhara.commons.util;

import static com.nuhara.commons.util.StringUtils.hasLength;

import java.util.logging.Logger;

/**
 * Utility class for retrieving system/environment properties.
 *
 * @author Alistair A. Israel
 */
public final class Env {

    private static final Logger logger = Logger.getLogger(Env.class.getCanonicalName());

    /**
     * Utility classes should not have a public or default constructor.
     */
    private Env() {
        // noop
    }

    /**
     * @param key
     *        the name of the system property
     * @param def
     *        the default value
     * @return {@code true} or {@code false} depending on the value of the system property, or the default if the system
     *         property is not set or cannot be recognized
     */
    public static boolean get(final String key, final boolean def) {
        final String s = System.getProperty(key);
        if (hasLength(s)) {
            if ("true".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s) || "1".equals(s)) {
                return true;
            } else if ("false".equalsIgnoreCase(s) || "no".equalsIgnoreCase(s) || "0".equals(s)) {
                return false;
            }
        }
        return def;
    }

    /**
     * @param key
     *        the name of the system property
     * @param def
     *        the default value
     * @return the value of the system property parsed as an int, or the default if the system property is not set or
     *         throws a NumberFormatException when parsed
     */
    public static int get(final String key, final int def) {
        final String s = System.getProperty(key);
        if (hasLength(s)) {
            try {
                return Integer.parseInt(s);
            } catch (final NumberFormatException e) {
                logger.warning("System.getProperty(\"" + key + "\") returned: " + s
                        + ", which cannot be parsed as an int");
            }
        }
        return def;
    }
}
