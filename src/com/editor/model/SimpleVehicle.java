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

import com.editor.model.base.Vehicle;
import com.editor.Environment;
import com.editor.FormatBuilder.AppendMode;
import com.editor.constant.LightSize;
import com.editor.model.base.Brake;
import com.editor.model.base.Suspension;
import com.editor.model.base.Traction;
import com.editor.model.base.Transmission;
import com.editor.model.base.Vector;

/**
 * @version 1.0
 * @author plasma
 */
public final class SimpleVehicle implements Vehicle
{
    private final String identifier;
    private final float mass;
    private final float turnMass;
    private final float dragMultiplier;
    private final Vector centerOfMass;
    private final float percentSubmerged;
    private final Traction tractionData;
    private final Transmission transmissionData;
    private final Brake brakeData;
    private final float steeringLock;
    private final Suspension suspensionData;
    private final float seatOffsetDistance;
    private final float collisionDamageMultiplier;
    private final float monetaryValue;
    private final int modelFlags;
    private final int handlingFlags;
    private final LightSize frontLights;
    private final LightSize rearLights;
    private final int animGroup;

    public SimpleVehicle(String identifier, float mass, float turnMass, float dragMultiplier,
            Vector centerOfMass, float percentSubmerged, Traction tractionData,
            Transmission transmissionData, Brake brakeData, float steeringLock,
            Suspension suspensionData, float seatOffsetDistance, float collisionDamageMultiplier,
            float monetaryValue, int modelFlags, int handlingFlags, LightSize frontLights,
            LightSize rearLights, int animGroup)
    {
        this.identifier = identifier;
        this.mass = mass;
        this.turnMass = turnMass;
        this.dragMultiplier = dragMultiplier;
        this.centerOfMass = centerOfMass;
        this.percentSubmerged = percentSubmerged;
        this.tractionData = tractionData;
        this.transmissionData = transmissionData;
        this.steeringLock = steeringLock;
        this.suspensionData = suspensionData;
        this.brakeData = brakeData;
        this.seatOffsetDistance = seatOffsetDistance;
        this.collisionDamageMultiplier = collisionDamageMultiplier;
        this.monetaryValue = monetaryValue;
        this.modelFlags = modelFlags;
        this.handlingFlags = handlingFlags;
        this.frontLights = frontLights;
        this.rearLights = rearLights;
        this.animGroup = animGroup;
    }

    @Override
    public String identifier()
    {
        return identifier;
    }

    @Override
    public float mass()
    {
        return mass;
    }

    @Override
    public float turnMass()
    {
        return turnMass;
    }

    @Override
    public float dragMultiplier()
    {
        return dragMultiplier;
    }

    @Override
    public Vector centerOfMass()
    {
        return centerOfMass;
    }

    @Override
    public float percentSubmerged()
    {
        return percentSubmerged;
    }

    @Override
    public Traction tractionData()
    {
        return tractionData;
    }

    @Override
    public Transmission transmissionData()
    {
        return transmissionData;
    }

    @Override
    public Brake brakeData()
    {
        return brakeData;
    }

    @Override
    public float steeringLock()
    {
        return steeringLock;
    }

    @Override
    public Suspension suspensionData()
    {
        return suspensionData;
    }

    @Override
    public float seatOffsetDistance()
    {
        return seatOffsetDistance;
    }

    @Override
    public float collisionDamageMultiplier()
    {
        return collisionDamageMultiplier;
    }

    @Override
    public float monetaryValue()
    {
        return monetaryValue;
    }

    @Override
    public int modelFlags()
    {
        return modelFlags;
    }

    @Override
    public int handlingFlags()
    {
        return handlingFlags;
    }

    @Override
    public LightSize frontLights()
    {
        return frontLights;
    }

    @Override
    public LightSize rearLights()
    {
        return rearLights;
    }

    @Override
    public int animGroup()
    {
        return animGroup;
    }
    
    @Override
    public String toLine(Environment env)
    {
        String centerOfMassLine = centerOfMass.toLine(env);
        String tractionLine = tractionData.toLine(env);
        String transmissionLine = transmissionData.toLine(env);
        String brakesLine = brakeData.toLine(env);
        String suspensionLine = suspensionData.toLine(env);
        
        return env.formatBuilder()
                .appendString(identifier, AppendMode.SEPARATE_AFTER)
                .appendFloat(mass, AppendMode.SEPARATE_AFTER)
                .appendFloat(turnMass, AppendMode.SEPARATE_AFTER)
                .appendFloat(dragMultiplier, AppendMode.SEPARATE_AFTER)
                .appendString(centerOfMassLine, AppendMode.SEPARATE_AFTER)
                .appendFloat(percentSubmerged, AppendMode.SEPARATE_AFTER)
                .appendString(tractionLine, AppendMode.SEPARATE_AFTER)
                .appendString(transmissionLine, AppendMode.SEPARATE_AFTER)
                .appendString(brakesLine, AppendMode.SEPARATE_AFTER)
                .appendFloat(steeringLock, AppendMode.SEPARATE_AFTER)
                .appendString(suspensionLine, AppendMode.SEPARATE_AFTER)
                .appendFloat(seatOffsetDistance, AppendMode.SEPARATE_AFTER)
                .appendFloat(collisionDamageMultiplier, AppendMode.SEPARATE_AFTER)
                .appendFloat(monetaryValue, AppendMode.SEPARATE_AFTER)
                .appendInteger(modelFlags, AppendMode.SEPARATE_AFTER)
                .appendInteger(handlingFlags, AppendMode.SEPARATE_AFTER)
                .appendInteger(frontLights.value(), AppendMode.SEPARATE_AFTER)
                .appendInteger(rearLights.value(), AppendMode.SEPARATE_AFTER)
                .appendInteger(animGroup, AppendMode.APPEND_ONLY)
                .toString();
    }
    
}
