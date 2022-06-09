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
public class BaseVehicleBuilder implements VehicleBuilder
{
    private String identifier;
    private float mass;
    private float turnMass;
    private float dragMultiplier;
    private Vector centerOfMass;
    private float percentSubmerged;
    private Traction tractionData;
    private Transmission transmissionData;
    private Brake brakeData;
    private float steeringLock;
    private Suspension suspensionData;
    private float seatOffsetDistance;
    private float collisionDamageMultiplier;
    private float monetaryValue;
    private int modelFlags;
    private int handlingFlags;
    private LightSize frontLights;
    private LightSize rearLights;
    private int animGroup;

    public BaseVehicleBuilder(){}
    
    public BaseVehicleBuilder(Vehicle template)
    {
        identifier = template.identifier();
        mass = template.mass();
        turnMass = template.turnMass();
        dragMultiplier = template.dragMultiplier();
        centerOfMass = template.centerOfMass();
        percentSubmerged = template.percentSubmerged();
        tractionData = template.tractionData();
        transmissionData = template.transmissionData();
        brakeData = template.brakeData();
        steeringLock = template.steeringLock();
        suspensionData = template.suspensionData();
        seatOffsetDistance = template.seatOffsetDistance();
        collisionDamageMultiplier = template.collisionDamageMultiplier();
        monetaryValue = template.monetaryValue();
        modelFlags = template.modelFlags();
        handlingFlags = template.handlingFlags();
        frontLights = template.frontLights();
        rearLights = template.rearLights();
        animGroup = template.animGroup();
    }

    @Override
    public BaseVehicleBuilder setIdentifier(String identifier)
    {
        this.identifier = identifier;
        return this;
    }

    @Override
    public BaseVehicleBuilder setMass(float mass)
    {
        this.mass = mass;
        return this;
    }

    @Override
    public BaseVehicleBuilder setTurnMass(float turnMass)
    {
        this.turnMass = turnMass;
        return this;
    }

    @Override
    public BaseVehicleBuilder setDragMultiplier(float dragMultiplier)
    {
        this.dragMultiplier = dragMultiplier;
        return this;
    }

    @Override
    public BaseVehicleBuilder setCenterOfMass(Vector centerOfMass)
    {
        this.centerOfMass = centerOfMass;
        return this;
    }

    @Override
    public BaseVehicleBuilder setPercentSubmerged(float percentSubmerged)
    {
        this.percentSubmerged = percentSubmerged;
        return this;
    }

    @Override
    public BaseVehicleBuilder setTractionData(Traction tractionData)
    {
        this.tractionData = tractionData;
        return this;
    }

    @Override
    public BaseVehicleBuilder setTransmissionData(Transmission transmissionData)
    {
        this.transmissionData = transmissionData;
        return this;
    }

    @Override
    public BaseVehicleBuilder setBrakeData(Brake brakeData)
    {
        this.brakeData = brakeData;
        return this;
    }

    @Override
    public BaseVehicleBuilder setSteeringLock(float steeringLock)
    {
        this.steeringLock = steeringLock;
        return this;
    }

    @Override
    public BaseVehicleBuilder setSuspensionData(Suspension suspensionData)
    {
        this.suspensionData = suspensionData;
        return this;
    }

    @Override
    public BaseVehicleBuilder setSeatOffsetDistance(float seatOffsetDistance)
    {
        this.seatOffsetDistance = seatOffsetDistance;
        return this;
    }

    @Override
    public BaseVehicleBuilder setCollisionDamageMultiplier(float collisionDamageMultiplier)
    {
        this.collisionDamageMultiplier = collisionDamageMultiplier;
        return this;
    }

    @Override
    public BaseVehicleBuilder setMonetaryValue(float monetaryValue)
    {
        this.monetaryValue = monetaryValue;
        return this;
    }

    @Override
    public BaseVehicleBuilder setModelFlags(int modelFlags)
    {
        this.modelFlags = modelFlags;
        return this;
    }

    @Override
    public BaseVehicleBuilder setHandlingFlags(int handlingFlags)
    {
        this.handlingFlags = handlingFlags;
        return this;
    }

    @Override
    public BaseVehicleBuilder setFrontLights(LightSize frontLights)
    {
        this.frontLights = frontLights;
        return this;
    }

    @Override
    public BaseVehicleBuilder setRearLights(LightSize rearLights)
    {
        this.rearLights = rearLights;
        return this;
    }

    @Override
    public BaseVehicleBuilder setAnimGroup(int animGroup)
    {
        this.animGroup = animGroup;
        return this;
    }
    
    @Override
    public Vehicle build()
    {
        return new SimpleVehicle(identifier,
                mass,
                turnMass,
                dragMultiplier,
                centerOfMass,
                percentSubmerged,
                tractionData,
                transmissionData,
                brakeData,
                steeringLock,
                suspensionData,
                seatOffsetDistance,
                collisionDamageMultiplier,
                monetaryValue,
                modelFlags,
                handlingFlags,
                frontLights,
                rearLights,
                animGroup);
    }
}
