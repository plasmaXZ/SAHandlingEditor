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

import com.editor.constant.LightSize;
import com.editor.model.base.Brake;
import com.editor.model.base.Suspension;
import com.editor.model.base.Traction;
import com.editor.model.base.Transmission;
import com.editor.model.base.Vector;
import com.editor.model.base.Vehicle;

/**
 * @version 1.0
 * @author plasma
 */
public interface VehicleBuilder
{
    BaseVehicleBuilder setIdentifier(String identifier);
    
    BaseVehicleBuilder setMass(float mass);

    BaseVehicleBuilder setTurnMass(float turnMass);

    BaseVehicleBuilder setDragMultiplier(float dragMultiplier);

    BaseVehicleBuilder setCenterOfMass(Vector centerOfMass);
    
    BaseVehicleBuilder setPercentSubmerged(float percentSubmerged);

    BaseVehicleBuilder setTractionData(Traction tractionData);

    BaseVehicleBuilder setTransmissionData(Transmission transmissionData);

    BaseVehicleBuilder setBrakeData(Brake brakeData);

    BaseVehicleBuilder setSteeringLock(float steeringLock);

    BaseVehicleBuilder setSuspensionData(Suspension suspensionData);

    BaseVehicleBuilder setSeatOffsetDistance(float seatOffsetDistance);

    BaseVehicleBuilder setCollisionDamageMultiplier(float collisionDamageMultiplier);

    BaseVehicleBuilder setMonetaryValue(float monetaryValue);

    BaseVehicleBuilder setModelFlags(int modelFlags);

    BaseVehicleBuilder setHandlingFlags(int handlingFlags);

    BaseVehicleBuilder setFrontLights(LightSize frontLights);

    BaseVehicleBuilder setRearLights(LightSize rearLights);

    BaseVehicleBuilder setAnimGroup(int animGroup);

    Vehicle build();
}
