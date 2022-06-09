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

import java.util.Locale;

/**
 * @version 1.0
 * @author plasma
 */
public final class StandardEnvironment implements Environment
{
    private static final String DEFAULT_PROPERTY_SEPARATOR = "  ";
    private static final String DEFAULT_STRING_FORMAT = "%s";
    private static final String DEFAULT_FLOAT_FORMAT = "%.2f";
    private static final String DEFAULT_INT_FORMAT = "%d";
    
    @Override
    public Locale locale()
    {
        return Locale.US;
    }
    
    @Override
    public String propertySeparator()
    {
        return DEFAULT_PROPERTY_SEPARATOR;
    }
    
    @Override
    public String stringFormat()
    {
        return DEFAULT_STRING_FORMAT;
    }

    @Override
    public String floatFormat()
    {
        return DEFAULT_FLOAT_FORMAT;
    }

    @Override
    public String integerFormat()
    {
        return DEFAULT_INT_FORMAT;
    }

    @Override
    public FormatBuilder formatBuilder()
    {
        return new BaseFormatBuilder(this);
    }
}
