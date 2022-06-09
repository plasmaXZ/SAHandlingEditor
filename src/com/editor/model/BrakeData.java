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
import com.editor.model.base.Brake;

/**
 * @version 1.0
 * @author plasma
 */
public final class BrakeData implements Brake
{
    private final float brakeDeceleration;
    private final float brakeBias;
    private final byte abs;

    public BrakeData(float brakeDeceleration, float brakeBias, int abs)
    {
        this.brakeDeceleration = brakeDeceleration;
        this.brakeBias = brakeBias;
        this.abs = (byte)abs;
    }

    @Override
    public float brakeDeceleration()
    {
        return brakeDeceleration;
    }

    @Override
    public float brakeBias()
    {
        return brakeBias;
    }

    @Override
    public byte abs()
    {
        return abs;
    }

    @Override
    public String toLine(Environment env)
    {
        String format = env.floatFormat() + env.stringFormat() + env.floatFormat()
                + env.stringFormat() + env.integerFormat();
        return String.format(env.locale(),
                format,
                brakeDeceleration,
                env.propertySeparator(),
                brakeBias,
                env.propertySeparator(),
                abs);
    }
}
