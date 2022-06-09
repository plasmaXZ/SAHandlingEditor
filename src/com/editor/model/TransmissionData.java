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
import com.editor.constant.DriveType;
import com.editor.constant.EngineType;
import com.editor.model.base.Transmission;

/**
 * @version 1.0
 * @author plasma
 */
public final class TransmissionData implements Transmission
{
    public static final int MAX_GEARS = 5;
    
    private final byte numberOfGears;
    private final float maxVelocity;
    private final float engineAcceleration;
    private final float engineInertia;
    private final DriveType driveType;
    private final EngineType engineType;

    public TransmissionData(int numberOfGears, float maxVelocity, float engineAcceleration,
            float engineInertia, DriveType driveType, EngineType engineType)
    {
        if (numberOfGears > MAX_GEARS)
            throw new IllegalArgumentException("The number of gears exceeds it's limit.");
        
        this.numberOfGears = (byte)numberOfGears;
        this.maxVelocity = maxVelocity;
        this.engineAcceleration = engineAcceleration;
        this.engineInertia = engineInertia;
        this.driveType = driveType;
        this.engineType = engineType;
    }

    @Override
    public byte numberOfGears()
    {
        return numberOfGears;
    }

    @Override
    public float maxVelocity()
    {
        return maxVelocity;
    }

    @Override
    public float engineAcceleration()
    {
        return engineAcceleration;
    }

    @Override
    public float engineInertia()
    {
        return engineInertia;
    }
    
    @Override
    public DriveType driveType()
    {
        return driveType;
    }
    
    @Override
    public EngineType engineType()
    {
        return engineType;
    }
    
    @Override
    public String toLine(Environment env)
    {
        String format = env.integerFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.floatFormat() + env.stringFormat()
                + env.stringFormat()+ env.stringFormat()
                + env.stringFormat();
        return String.format(env.locale(),
                format,
                numberOfGears,
                env.propertySeparator(),
                maxVelocity,
                env.propertySeparator(),
                engineAcceleration,
                env.propertySeparator(),
                engineInertia,
                env.propertySeparator(),
                driveType.value(),
                env.propertySeparator(),
                engineType.value());
    }
}
