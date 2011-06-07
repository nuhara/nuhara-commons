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
 * Created Apr 4, 2011
 */
package com.nuhara.commons.util;

/**
 * @author Alistair A. Israel
 * @since 0.1
 */
public final class Encode {

    /**
     * {@value #EMPTY_STRING}
     */
    private static final String EMPTY_STRING = "";

    /**
     * Utility classes should not have a public or default constructor.
     */
    private Encode() {
        // noop
    }

    private static final String[] HEX;
    static {
        HEX = new String[256];
        for (int i = 0; i < 16; ++i) {
            final String s = Integer.toHexString(i);
            HEX[i] = "0" + s;
        }
        for (int i = 16; i < 256; ++i) {
            final String s = Integer.toHexString(i);
            HEX[i] = s;
        }
    }

    private static final int BYTE_MASK = 0xFF;

    /**
     * @param bytes
     *        the byte array
     * @return the hexadecimal representation of the given bytes
     */
    public static String asHex(final byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return EMPTY_STRING;
        }
        final StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; ++i) {
            final int b = bytes[i] & BYTE_MASK;
            sb.append(HEX[b]);
        }
        return sb.toString();
    }
}
