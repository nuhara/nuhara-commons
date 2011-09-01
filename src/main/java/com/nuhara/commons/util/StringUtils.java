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

/**
 * If I had a dollar for every time I had to write a {@code StringUtils} class...
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public final class StringUtils {

    /**
     * Utility classes should not have a public or default constructor.
     */
    private StringUtils() {
        // noop
    }

    /**
     * Check if the given string is not {@code null} or empty.
     *
     * @param s
     *        the String to test
     * @return {@code true} if the given string is not {@code null} and has length > 0
     */
    public static boolean hasLength(final String s) {
        return s != null && s.length() > 0;
    }

    /**
     * Check if the given string is not {@code null}, empty and has at least one non-whitespace character.
     *
     * @param s
     *        the String to test
     * @return {@code true} if the given string is not {@code null}, has length > 0, and has at least one non-whitespace
     *         character
     */
    public static boolean hasText(final String s) {
        if (hasLength(s)) {
            for (int i = 0; i < s.length(); ++i) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param delim
     *        the delimiter String, which can be {@code null}
     * @param args
     *        the arguments to join
     * @return the joined string
     */
    public static String join(final String delim, final Object... args) {
        final int delimLength;
        if (delim != null) {
            delimLength = delim.length();
        } else {
            delimLength = 0;
        }
        final StringBuilder sb = new StringBuilder(calculateTotalLength(delimLength, args));
        join(sb, delim, args);
        return sb.toString();
    }

    /**
     * @param delim
     *        the delimiter character
     * @param args
     *        the arguments to join
     * @return the joined string
     */
    public static String join(final char delim, final Object... args) {
        final StringBuilder sb = new StringBuilder(calculateTotalLength(1, args));
        join(sb, delim, args);
        return sb.toString();
    }

    /**
     * @param delimLength
     *        the length of the delimiter
     * @param args
     *        the arguments to join
     * @return the total length of the joined string
     */
    private static int calculateTotalLength(final int delimLength, final Object[] args) {
        if (args != null && args.length > 0) {
            int total = (args.length - 1) * delimLength;
            for (final Object o : args) {
                if (o != null) {
                    total += o.toString().length();
                }
            }
            return total;
        }
        return 0;
    }

    /**
     * @param sb
     *        the {@link StringBuffer} to use
     * @param delim
     *        the delimiter String, which may be {@code null}
     * @param args
     *        the arguments to join
     */
    public static void join(final StringBuffer sb, final String delim, final Object... args) {
        assert sb != null : "StringBuffer is null!";
        if (args != null) {
            final int n = args.length;
            if (n > 0) {
                for (int i = 0; i < n;) {
                    if (args[i] != null) {
                        sb.append(args[i]);
                    }
                    ++i;
                    if (i < n) {
                        sb.append(delim);
                    }
                }
            }
        }
    }

    /**
     * @param sb
     *        the {@link StringBuffer} to use
     * @param delim
     *        the delimiter character
     * @param args
     *        the arguments to join
     */
    public static void join(final StringBuffer sb, final char delim, final Object... args) {
        assert sb != null : "StringBuffer is null!";
        if (args != null) {
            final int n = args.length;
            if (n > 0) {
                for (int i = 0; i < n;) {
                    if (args[i] != null) {
                        sb.append(args[i]);
                    }
                    ++i;
                    if (i < n) {
                        sb.append(delim);
                    }
                }
            }
        }
    }

    /**
     * @param sb
     *        the {@link StringBuilder} to use
     * @param delim
     *        the delimiter String, which may be {@code null}
     * @param args
     *        the arguments to join
     */
    public static void join(final StringBuilder sb, final String delim, final Object... args) {
        assert sb != null : "StringBuilder is null!";
        if (args != null) {
            final int n = args.length;
            if (n > 0) {
                for (int i = 0; i < n;) {
                    if (args[i] != null) {
                        sb.append(args[i]);
                    }
                    ++i;
                    if (i < n && delim != null) {
                        sb.append(delim);
                    }
                }
            }
        }
    }

    /**
     * @param sb
     *        the {@link StringBuilder} to use
     * @param delim
     *        the delimiter character
     * @param args
     *        the arguments to join
     */
    public static void join(final StringBuilder sb, final char delim, final Object... args) {
        assert sb != null : "StringBuilder is null!";
        if (args != null) {
            final int n = args.length;
            if (n > 0) {
                for (int i = 0; i < n;) {
                    if (args[i] != null) {
                        sb.append(args[i]);
                    }
                    ++i;
                    if (i < n) {
                        sb.append(delim);
                    }
                }
            }
        }
    }


}
