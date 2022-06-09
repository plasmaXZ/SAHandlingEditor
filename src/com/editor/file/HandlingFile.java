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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author plasma
 */
public class HandlingFile
{
    public static final String DEFAULT_FILE_NAME = "handling.cfg";
    public static final String DEFAULT_FILE_PATH = System.getProperty("user.dir") + "\\"
            + DEFAULT_FILE_NAME;
    
    private final File handlingFile;

    public HandlingFile(File handlingFile)
    {
        this.handlingFile = handlingFile;
    }

    public String getRelevantContent() throws IOException
    {
        final BufferedReader reader = new BufferedReader(new FileReader(handlingFile));
        final StringBuilder sb = new StringBuilder();
        String tempLine;

        while ((tempLine = reader.readLine()) != null)  
        {
            HandlingLine line = new HandlingLine(tempLine);
            if (line.startsWithSymbolToIgnore())
                continue;

            sb.append(line);
            sb.append("\n");
        }

        reader.close();
        return sb.toString();
    }

    private List<String> toPropertyList(String[] line)
    {
        List<String> list = new ArrayList<>(line.length);
        for (int i = 1; i < line.length; ++i)
            list.add(line[i].trim());
        
        return list;
    }
    
    public Map<String, List<String>> toMap() throws IOException
    {
        final Map<String, List<String>> vehicles = new LinkedHashMap<>();
        final BufferedReader reader = new BufferedReader(new FileReader(handlingFile));
        String tempLine;

        while ((tempLine = reader.readLine()) != null)  
        {
            HandlingLine line = new HandlingLine(tempLine);
            if (line.startsWithSymbolToIgnore() || line.startsWithSpecialSymbol())
                continue;
            
            String[] separatedLine = line.toString().split("\\s+");
            String vehicleName = separatedLine[0];
            List<String> properties = toPropertyList(separatedLine);
            vehicles.put(vehicleName.trim(), properties);
        }

        reader.close();
        return vehicles;
    }
    
}
