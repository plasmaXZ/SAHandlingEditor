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
import com.editor.model.base.Suspension;

/**
 * @version 1.0
 * @author plasma
 */
public final class SuspensionData implements Suspension
{
    private final float forceLevel;
    private final float dampingLevel;
    private final float highSpdComDamp;
    private final float upperLimit;
    private final float lowerLimit;
    private final float bias;
    private final float antiDiveMultiplier;

    public SuspensionData(float forceLevel, float dampingLevel, float highSpdComDamp,
            float upperLimit, float lowerLimit, float bias, float antiDiveMultiplier)
    {
        this.forceLevel = forceLevel;
        this.dampingLevel = dampingLevel;
        this.highSpdComDamp = highSpdComDamp;
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
        this.bias = bias;
        this.antiDiveMultiplier = antiDiveMultiplier;
    }

    @Override
    public float forceLevel()
    {
        return forceLevel;
    }

    @Override
    public float dampingLevel()
    {
        return dampingLevel;
    }

    @Override
    public float highSpdComDamp()
    {
        return highSpdComDamp;
    }

    @Override
    public float upperLimit()
    {
        return upperLimit;
    }

    @Override
    public float lowerLimit()
    {
        return lowerLimit;
    }

    @Override
    public float bias()
    {
        return bias;
    }

    @Override
    public float antiDiveMultiplier()
    {
        return antiDiveMultiplier;
    }
    
    @Override
    public String toLine(Environment env)
    {
        String format = env.floatFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.floatFormat();
        return String.format(env.locale(),
                format,
                forceLevel,
                env.propertySeparator(),
                dampingLevel,
                env.propertySeparator(),
                highSpdComDamp,
                env.propertySeparator(),
                upperLimit,
                env.propertySeparator(),
                lowerLimit,
                env.propertySeparator(),
                bias,
                env.propertySeparator(),
                antiDiveMultiplier);
    }
}
