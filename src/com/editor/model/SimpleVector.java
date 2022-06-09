/*
Copyright 2022 plasma

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.editor.model;

import com.editor.Environment;
import com.editor.model.base.Vector;
import java.util.Locale;

/**
 * @version 1.0
 * @author plasma
 */
public final class SimpleVector implements Vector
{
    private final float x;
    private final float y;
    private final float z;

    public SimpleVector(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public float getX()
    {
        return x;
    }
    
    @Override
    public float getY()
    {
        return y;
    }
    
    @Override
    public float getZ()
    {
        return z;
    }
    
    @Override
    public Vector normalize()
    {
        float localX = getX();
        float localY = getY();
        float localZ = getZ();
        float inverseLength = 1 / (float)Math.sqrt(localX * localX + localY * localY + localZ
                * localZ);
        
        return new SimpleVector(localX * inverseLength, localY * inverseLength, localZ
                * inverseLength);
    }
    
    @Override
    public Vector translate(Vector vec)
    {
        return new SimpleVector(getX() + vec.getX(), getY() + vec.getY(), getZ() + vec.getZ());
    }
    
    @Override
    public String toString()
    {
        return String.format(Locale.US, "%.2f\t%.2f\t%.2f", x, y, z);
    }
    
    @Override
    public String toLine(Environment env)
    {
        String format = env.floatFormat() + env.stringFormat() + env.floatFormat()
                + env.stringFormat() + env.floatFormat();
        return String.format(env.locale(),
                format,
                getX(),
                env.propertySeparator(),
                getY(),
                env.propertySeparator(),
                getZ());
    }
}
