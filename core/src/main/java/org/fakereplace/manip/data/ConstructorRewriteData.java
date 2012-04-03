/*
 * Copyright 2011, Stuart Douglas
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

/**
 *
 */
package org.fakereplace.manip.data;

import org.fakereplace.manip.util.ClassloaderFiltered;
import org.fakereplace.util.DescriptorUtils;

public class ConstructorRewriteData implements ClassloaderFiltered<ConstructorRewriteData> {
    final private String clazz;
    final private String methodDesc;
    final private String[] parameters;
    final private int methodNo;
    final private ClassLoader classLoader;

    public ConstructorRewriteData(String clazz, String methodDesc, int methodNo, ClassLoader classLoader) {
        this.clazz = clazz;
        this.methodDesc = methodDesc;
        this.methodNo = methodNo;
        parameters = DescriptorUtils.descriptorStringToParameterArray(methodDesc);
        this.classLoader = classLoader;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ConstructorRewriteData.class.getName() + " ");
        sb.append(clazz);
        sb.append(" ");
        sb.append(methodDesc);
        sb.append(" ");
        sb.append(methodNo);

        return sb.toString();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String getClazz() {
        return clazz;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public String[] getParameters() {
        return parameters;
    }

    public int getMethodNo() {
        return methodNo;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public ConstructorRewriteData getInstance() {
        return this;
    }
}
