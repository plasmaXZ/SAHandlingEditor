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

import com.editor.constant.DriveType;
import com.editor.constant.EngineType;
import com.editor.constant.HandlingFlag;
import com.editor.constant.LightSize;
import com.editor.constant.ModelFlag;
import com.editor.file.HandlingFile;
import com.editor.model.BaseVehicleBuilder;
import com.editor.model.BrakeData;
import com.editor.model.SimpleVector;
import com.editor.model.SuspensionData;
import com.editor.model.TractionData;
import com.editor.model.TransmissionData;
import com.editor.model.base.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author plasma.
 */
public class Main
{
    private static final String APP_NAME = "SAHandlingEditor";
    private static final String VERSION = "0.1.0";
    private static final Environment STD_ENVIRONMENT = new StandardEnvironment();
    
    public static void main(String[] args) throws IOException
    {
        HandlingFile handlingFile = new HandlingFile(new File(HandlingFile.DEFAULT_FILE_PATH));
        Map<String, List<String>> content = handlingFile.toMap();
        
        System.out.println("SAHndlingEditor Version " + VERSION + "\n");
        content.forEach((k, v) -> System.out.println(k + " = " + v));
    }
    
    private static void vehicleBuilderTest()
    {
        int modelFlags = ModelFlag.AXLE_F_NOTILT.value() | ModelFlag.AXLE_R_NOTILT.value();
        int handlingFlags = HandlingFlag.BOOST_1G.value() | HandlingFlag.HALOGEN_LIGHTS.value()
                | HandlingFlag.WHEEL_R_WIDE.value();
        
        Vehicle vehicle = new BaseVehicleBuilder()
                .setIdentifier("TEST-VEHICLE")
                .setMass(1500.0f)
                .setTurnMass(1500.0f)
                .setDragMultiplier(1.5f)
                .setCenterOfMass(new SimpleVector(0.0f, 0.35f, 0.1f))
                .setPercentSubmerged(55.0f)
                .setTractionData(new TractionData(0.7f, 0.55f, 0.45f))
                .setTransmissionData(new TransmissionData(4, 250.0f, 15.0f, 90.0f, DriveType.REAR,
                        EngineType.PETROL))
                .setBrakeData(new BrakeData(2.5f, 0.55f, 1))
                .setSteeringLock(35.0f)
                .setSuspensionData(new SuspensionData(0.85f, 0.4f, 5.0f, 0.35f, -0.05f, 0.45f,
                        1.0f))
                .setSeatOffsetDistance(0.35f)
                .setCollisionDamageMultiplier(3.5f)
                .setMonetaryValue(35_000.0f)
                .setModelFlags(modelFlags)
                .setHandlingFlags(handlingFlags)
                .setFrontLights(LightSize.LONG)
                .setRearLights(LightSize.SMALL)
                .build();
        
        System.out.println(vehicle.toLine(STD_ENVIRONMENT));
    }
    
}
