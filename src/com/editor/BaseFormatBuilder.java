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

package com.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;

/**
 * @author plasma
 */
public class BaseFormatBuilder implements FormatBuilder
{
    private final Environment environment;
    private final StringBuilder format;
    private final Collection<Object> values;

    public BaseFormatBuilder(Environment environment)
    {
        this.environment = environment;
        this.format = new StringBuilder();
        this.values = new ArrayList<>();
    }
    
    @Override
    public int length()
    {
        return format.length();
    }

    @Override
    public char charAt(int index)
    {
        return format.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return format.subSequence(start, end);
    }
    
    @Override
    public BaseFormatBuilder appendPropertySeparator()
    {
        format.append(environment.propertySeparator());
        return this;
    }
    
    @Override
    public BaseFormatBuilder appendString(String value, AppendMode appendMode)
    {
        if (appendMode == AppendMode.SEPARATE_BEFORE || appendMode == AppendMode.SEPARATE_ALL)
            appendPropertySeparator();
        
        format.append(environment.stringFormat());
        
        if (appendMode == AppendMode.SEPARATE_AFTER || appendMode == AppendMode.SEPARATE_ALL)
            appendPropertySeparator();
        
        values.add(value);
        return this;
    }
    
    @Override
    public BaseFormatBuilder appendInteger(int value, AppendMode appendMode)
    {
        if (appendMode == AppendMode.SEPARATE_BEFORE || appendMode == AppendMode.SEPARATE_ALL)
            appendPropertySeparator();
        
        format.append(environment.integerFormat());
        
        if (appendMode == AppendMode.SEPARATE_AFTER || appendMode == AppendMode.SEPARATE_ALL)
            appendPropertySeparator();
        
        values.add(value);
        return this;
    }
    
    @Override
    public BaseFormatBuilder appendFloat(float value, AppendMode appendMode)
    {
        if (appendMode == AppendMode.SEPARATE_BEFORE || appendMode == AppendMode.SEPARATE_ALL)
            appendPropertySeparator();
        
        format.append(environment.floatFormat());
        
        if (appendMode == AppendMode.SEPARATE_AFTER || appendMode == AppendMode.SEPARATE_ALL)
            appendPropertySeparator();
        
        values.add(value);
        return this;
    }
    
    @Override
    public BaseFormatBuilder appendValue(Object value, AppendMode appendMode)
    {
        if (value instanceof String)
            return appendString((String)value, appendMode);
        else if (value instanceof Integer)
            return appendInteger((int)value, appendMode);
        else if (value instanceof Float || value instanceof Double)
            return appendFloat((float)value, appendMode);
        else
            throw new IllegalArgumentException("Invalid value type");
    }
    
    @Override
    public Formatter build()
    {
        return new Formatter(environment.locale()).format(format.toString(), values.toArray());
    }
    
    @Override
    public String toString()
    {
        return build().toString();
    }
}
