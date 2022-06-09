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

package com.editor.model.base;

import com.editor.constant.LightSize;
import com.editor.model.base.HandlingData;
import com.editor.model.base.Suspension;
import com.editor.model.base.Traction;
import com.editor.model.base.Transmission;
import com.editor.model.base.Vector;

/**
 * @version 1.0
 * @author plasma
 */
public interface Vehicle extends HandlingData
{
    String identifier();

    float mass();

    float turnMass();

    float dragMultiplier();

    Vector centerOfMass();

    float percentSubmerged();

    Traction tractionData();

    Transmission transmissionData();
    
    Brake brakeData();

    float steeringLock();

    Suspension suspensionData();

    float seatOffsetDistance();

    float collisionDamageMultiplier();

    float monetaryValue();

    int modelFlags();

    int handlingFlags();

    LightSize frontLights();

    LightSize rearLights();

    int animGroup();
}
