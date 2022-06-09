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
public enum HandlingFlag implements NumberFlag
{
    BOOST_1G(0x1),
    BOOST_2G(0x2),
    NPC_ANTI_ROLL(0x4),
    NPC_NEUTRAL_HANDL(0x8),
    NO_HANDBRAKE(0x10),
    STEER_REARWHEELS(0x20),
    HB_REARWHEEL_STEER(0x40),
    ALT_STEER_OPT(0x80),
    WHEEL_F_NARROW2(0x100),
    WHEEL_F_NARROW(0x200),
    WHEEL_F_WIDE(0x400),
    WHEEL_F_WIDE2(0x800),
    WHEEL_R_NARROW2(0x1000),
    WHEEL_R_NARROW(0x2000),
    WHEEL_R_WIDE(0x4000),
    WHEEL_R_WIDE2(0x8000),
    HYDRAULIC_GEOM(0x10000),
    HYDRAULIC_INST(0x20000),
    HYDRAULIC_NONE(0x40000),
    NOS_INST(0x80000),
    OFFROAD_ABILITY(0x100000),
    OFFROAD_ABILITY2(0x200000),
    HALOGEN_LIGHTS(0x400000),
    PROC_REARWHEEL_1ST(0x800000),
    SWINGING_CHASSIS(0x1000000);
    
    private final int value;

    private HandlingFlag(int value)
    {
        this.value = value;
    }
    
    public int value()
    {
        return value;
    }
}
