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

package com.editor.constant;

/**
 * @version 1.0
 * @author plasma
 */
public enum ModelFlag implements NumberFlag
{
    IS_VAN(0x1),
    IS_BUS(0x2),
    IS_LOW(0x4),
    IS_BIG(0x8),
    REVERSE_BONNET(0x10),
    HANGING_BOOT(0x20),
    TAILGATE_BOOT(0x40),
    NOSWING_BOOT(0x80),
    NO_DOORS(0x100),
    TANDEM_SEATS(0x200),
    SIT_IN_BOAT(0x400),
    CONVERTIBLE(0x800),
    NO_EXHAUST(0x1000),
    DOUBLE_EXHAUST(0x2000),
    NO_FIRST_PERSON_LOOK_BEHIND(0x4000),
    FORCE_DOOR_CHECK(0x8000),
    AXLE_F_NOTILT(0x10000),
    AXLE_F_SOLID(0x20000),
    AXLE_F_MCPHERSON(0x40000),
    AXLE_F_REVERSE(0x80000),
    AXLE_R_NOTILT(0x100000),
    AXLE_R_SOLID(0x200000),
    AXLE_R_MCPHERSON(0x400000),
    AXLE_R_REVERSE(0x800000),
    IS_BIKE(0x1000000),
    IS_HELI(0x2000000),
    IS_PLANE(0x4000000),
    IS_BOAT(0x8000000),
    BOUNCE_PANELS(0x10000000),
    DOUBLE_RWHEELS(0x20000000),
    FORCE_GROUND_CLEARANCE(0x40000000),
    IS_HATCHBACK(0x80000000);
    
    private final int value;

    private ModelFlag(int value)
    {
        this.value = value;
    }
    
    public int value()
    {
        return value;
    }
}
