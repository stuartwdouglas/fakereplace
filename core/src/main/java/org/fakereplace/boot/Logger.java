/*
 *
 *  * Copyright 2012, Stuart Douglas, and individual contributors as indicated
 *  * by the @authors tag.
 *  *
 *  * This is free software; you can redistribute it and/or modify it
 *  * under the terms of the GNU Lesser General Public License as
 *  * published by the Free Software Foundation; either version 2.1 of
 *  * the License, or (at your option) any later version.
 *  *
 *  * This software is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  * Lesser General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU Lesser General Public
 *  * License along with this software; if not, write to the Free
 *  * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *  * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 */

package org.fakereplace.boot;

/**
 * Logging class, at the moment just writes to stdout. Using java.util.logging is problematic from a javaagent,
 * and as fakereplace should never be used in production this is all that is required.
 *
 * @author stuart
 */
public class Logger {

    private static final String TRACE_PROPERTY = "org.fakereplace.trace";

    private static final boolean trace;

    static {
        trace = Boolean.getBoolean(TRACE_PROPERTY);
    }

    public static void log(Object invoker, String message) {
        Class c = null;
        if (invoker.getClass().isAssignableFrom(Class.class)) {
            c = (Class) invoker;
        } else {
            c = invoker.getClass();
        }
        System.out.println("[" + c.getCanonicalName() + "] " + message);
    }

    public static void trace(Object invoker, String message) {
        if(!trace) {
            return;
        }
        Class c = null;
        if (invoker.getClass().isAssignableFrom(Class.class)) {
            c = (Class) invoker;
        } else {
            c = invoker.getClass();
        }
        System.out.println("[" + c.getCanonicalName() + "] TRACE " + message);
    }

    public static void debug(Object invoker, String message) {
        log(invoker, message);
    }

}
