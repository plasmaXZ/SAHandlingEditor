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

package com.editor.file;

/**
 * @version 1.0
 * @author plasma
 */
public class HandlingLine implements CharSequence
{
    private static final String SYMBOLS_TO_IGNORE[] = new String[]
    {
        "[\\(\\[\\;].*", "[0-9].*"
    };
    
    private static final String SPECIAL_SYMBOLS[] = new String[]
    {
        "[\\^\\!\\$\\%].*"
    };
    
    private final String content;

    public HandlingLine(String content)
    {
        this.content = content;
    }
    
    @Override
    public int length()
    {
        return content.length();
    }

    @Override
    public char charAt(int index)
    {
        return content.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return content.subSequence(start, end);
    }
    
    public boolean startsWithSymbolToIgnore()
    {
        for (String s : SYMBOLS_TO_IGNORE)
        {
            if (content.matches(s))
                return true;
        }
        
        return false;
    }
    
    public boolean startsWithSpecialSymbol()
    {
        for (String s : SPECIAL_SYMBOLS)
        {
            if (content.matches(s))
                return true;
        }
        
        return false;
    }
    
    @Override
    public String toString()
    {
        return content;
    }
}
