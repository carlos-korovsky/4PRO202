/*
 * Copyright (C) 2013 Uhlig e Korovsky Tecnologia Ltda
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.com.uktech.inputs.joystick.components;

import net.java.games.input.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@uktech.com.br>
 */
public abstract class AbstractComponent {
    
    public static class Type {
        public static class Axis extends Type {
            public static final Axis AXIS_X = new Axis("Axis X");
            public static final Axis AXIS_X_ACCELERATION = new Axis("Axis X Aceleration");
            public static final Axis AXIS_X_FORCE = new Axis("Axis X Force");
            public static final Axis AXIS_X_VELOCITY = new Axis("Axis X Velocity");
            public static final Axis AXIS_Y = new Axis("Axis Y");
            public static final Axis AXIS_Y_ACCELERATION = new Axis("Axis Y Aceleration");
            public static final Axis AXIS_Y_FORCE = new Axis("Axis Y Force");
            public static final Axis AXIS_Y_VELOCITY = new Axis("Axis Y Velocity");
            public static final Axis AXIS_Z = new Axis("Axis Z");
            public static final Axis AXIS_Z_ACCELERATION = new Axis("Axis Z Aceleration");
            public static final Axis AXIS_Z_FORCE = new Axis("Axis Z Force");
            public static final Axis AXIS_Z_VELOCITY = new Axis("Axis Z Velocity");
            public static final Axis AXIS_RX = new Axis("Axis RX");
            public static final Axis AXIS_RX_ACCELERATION = new Axis("Axis RX Aceleration");
            public static final Axis AXIS_RX_FORCE = new Axis("Axis RX Force");
            public static final Axis AXIS_RX_VELOCITY = new Axis("Axis RX Velocity");
            public static final Axis AXIS_RY = new Axis("Axis RY");
            public static final Axis AXIS_RY_ACCELERATION = new Axis("Axis RY Aceleration");
            public static final Axis AXIS_RY_FORCE = new Axis("Axis RY Force");
            public static final Axis AXIS_RY_VELOCITY = new Axis("Axis RY Velocity");
            public static final Axis AXIS_RZ = new Axis("Axis RZ");
            public static final Axis AXIS_RZ_ACCELERATION = new Axis("Axis RZ Aceleration");
            public static final Axis AXIS_RZ_FORCE = new Axis("Axis RZ Force");
            public static final Axis AXIS_RZ_VELOCITY = new Axis("Axis RZ Velocity");
            public static final Axis AXIS_SLIDER = new Axis("Axis Slider");
            public static final Axis AXIS_SLIDER_ACCELERATION = new Axis("Axis Slider Acceleration");
            public static final Axis AXIS_SLIDER_FORCE = new Axis("Axis Slider Force");
            public static final Axis AXIS_SLIDER_VELOCITY = new Axis("Axis Velocity");
           
            protected Axis(String name) {
                super(name);
            }
        }
        
        public static class Button extends Type {
            public static final Button BUTTON_00 = new Button("Button #00");
            public static final Button BUTTON_01 = new Button("Button #01");
            public static final Button BUTTON_02 = new Button("Button #02");
            public static final Button BUTTON_03 = new Button("Button #03");
            public static final Button BUTTON_04 = new Button("Button #04");
            public static final Button BUTTON_05 = new Button("Button #05");
            public static final Button BUTTON_06 = new Button("Button #06");
            public static final Button BUTTON_07 = new Button("Button #07");
            public static final Button BUTTON_08 = new Button("Button #08");
            public static final Button BUTTON_09 = new Button("Button #09");
            public static final Button BUTTON_10 = new Button("Button #10");
            public static final Button BUTTON_11 = new Button("Button #11");
            public static final Button BUTTON_12 = new Button("Button #12");
            public static final Button BUTTON_13 = new Button("Button #13");
            public static final Button BUTTON_14 = new Button("Button #14");
            public static final Button BUTTON_15 = new Button("Button #15");
            public static final Button BUTTON_16 = new Button("Button #16");
            public static final Button BUTTON_17 = new Button("Button #17");
            public static final Button BUTTON_18 = new Button("Button #18");
            public static final Button BUTTON_19 = new Button("Button #19");
            public static final Button BUTTON_20 = new Button("Button #20");
            public static final Button BUTTON_21 = new Button("Button #21");
            public static final Button BUTTON_22 = new Button("Button #22");
            public static final Button BUTTON_23 = new Button("Button #23");
            public static final Button BUTTON_24 = new Button("Button #24");
            public static final Button BUTTON_25 = new Button("Button #25");
            public static final Button BUTTON_26 = new Button("Button #26");
            public static final Button BUTTON_27 = new Button("Button #27");
            public static final Button BUTTON_28 = new Button("Button #28");
            public static final Button BUTTON_29 = new Button("Button #29");
            public static final Button BUTTON_30 = new Button("Button #30");
            public static final Button BUTTON_31 = new Button("Button #31");
            public static final Button BUTTON_TRIGGER = new Button("Button Trigger");
            public static final Button BUTTON_THUMB1 = new Button("Button Thumb #01");
            public static final Button BUTTON_THUMB2 = new Button("Button Thumb #02");
            public static final Button BUTTON_TOP1 = new Button("Button Top #01");
            public static final Button BUTTON_TOP2 = new Button("Button Top #02");
            public static final Button BUTTON_PINKIE = new Button("Button Pinkie");
            public static final Button BUTTON_BASE1 = new Button("Button Base #01");
            public static final Button BUTTON_BASE2 = new Button("Button Base #02");
            public static final Button BUTTON_BASE3 = new Button("Button Base #03");
            public static final Button BUTTON_BASE4 = new Button("Button Base #04");
            public static final Button BUTTON_BASE5 = new Button("Button Base #05");
            public static final Button BUTTON_BASE6 = new Button("Button Base #06");
            public static final Button BUTTON_DEAD = new Button("Button Dead");
            public static final Button BUTTON_A = new Button("Button A");
            public static final Button BUTTON_B = new Button("Button B");
            public static final Button BUTTON_C = new Button("Button C");
            public static final Button BUTTON_X = new Button("Button X");
            public static final Button BUTTON_Y = new Button("Button Y");
            public static final Button BUTTON_Z = new Button("Button Z");
            public static final Button BUTTON_LEFT_THUMB1 = new Button("Button Left Thumb #01");
            public static final Button BUTTON_LEFT_THUMB2 = new Button("Button Left Thumb #02");
            public static final Button BUTTON_LEFT_THUMB3 = new Button("Button Left Thumb #03");
            public static final Button BUTTON_RIGHT_THUMB1 = new Button("Button Right Thumb #01");
            public static final Button BUTTON_RIGHT_THUMB2 = new Button("Button Right Thumb #02");
            public static final Button BUTTON_RIGHT_THUMB3 = new Button("Button Right Thumb #03");
            public static final Button BUTTON_SELECT = new Button("Button Select");
            public static final Button BUTTON_MODE = new Button("Button Mode");
            public static final Button BUTTON_TOOL_PEN = new Button("Button Pen");
            public static final Button BUTTON_TOOL_RUBBER = new Button("Button Rubber");
            public static final Button BUTTON_TOOL_BRUSH = new Button("Button Brush");
            public static final Button BUTTON_TOOL_PENCIL = new Button("Button Pencil");
            public static final Button BUTTON_TOOL_AIRBRUSH = new Button("Button Airbrush");
            public static final Button BUTTON_TOOL_FINGER = new Button("Button Finger");
            public static final Button BUTTON_TOOL_MOUSE = new Button("Button Mouse");
            public static final Button BUTTON_TOOL_LENS = new Button("Button Lens");
            public static final Button BUTTON_TOUCH = new Button("Button Touch");
            public static final Button BUTTON_STYLUS1 = new Button("Button Stylus #01");
            public static final Button BUTTON_STYLUS2 = new Button("Button Stylus #02");
            public static final Button BUTTON_BACK = new Button("Button Back");
            public static final Button BUTTON_FORWARD = new Button("Button Forward");
            public static final Button BUTTON_EXTRA = new Button("Button Extra");
            public static final Button BUTTON_LEFT = new Button("Button Left");
            public static final Button BUTTON_MIDDLE = new Button("Button Middle");
            public static final Button BUTTON_RIGHT = new Button("Button Right");
            public static final Button BUTTON_SIDE = new Button("Button Side");     
        
            protected Button(String name) {
                super(name);
            }
        }
        
        public static final Type POV = new Axis("POV");
        public static final Type UNKNOWN_COMPONENT = new Type("Unknown component");
        
        private final String name;
        
        /**
         *
         * @param name
         */
        protected Type(String name) {
            this.name = name;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    private static final Logger logger = LoggerFactory.getLogger(AbstractComponent.class);
    
    private final Component component;
    private float value;
    private Type type;
        
    public AbstractComponent(Component component) {
        this.component = component;
        this.setType(this.checkType(this.component.getIdentifier()));
    }

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        float oldValue = this.value;
        this.value = value;
        AbstractComponent.logger.debug("Value of "+this.component.getName()+" changed from {} to {}.", oldValue, this.value);
    }
   
    public String getName() {
        return this.component.getName();
    }
    
    private Type checkType(Component.Identifier identifier) {
        if (identifier instanceof Component.Identifier.Axis) {
            if (identifier.equals(Component.Identifier.Axis.X)) {
                return Type.Axis.AXIS_X;
            } else if (identifier.equals(Component.Identifier.Axis.X_ACCELERATION)) {
                return Type.Axis.AXIS_X_ACCELERATION;
            } else if (identifier.equals(Component.Identifier.Axis.X_FORCE)) {
                return Type.Axis.AXIS_X_FORCE;
            } else if (identifier.equals(Component.Identifier.Axis.X_VELOCITY)) {
                return Type.Axis.AXIS_X_VELOCITY;
            } else if (identifier.equals(Component.Identifier.Axis.Y)) {
                return Type.Axis.AXIS_Y;
            } else if (identifier.equals(Component.Identifier.Axis.Y_ACCELERATION)) {
                return Type.Axis.AXIS_Y_ACCELERATION;
            } else if (identifier.equals(Component.Identifier.Axis.Y_FORCE)) {
                return Type.Axis.AXIS_Y_FORCE;
            } else if (identifier.equals(Component.Identifier.Axis.Y_VELOCITY)) {
                return Type.Axis.AXIS_Y_VELOCITY;
            } else if (identifier.equals(Component.Identifier.Axis.Z)) {
                return Type.Axis.AXIS_Z;
            } else if (identifier.equals(Component.Identifier.Axis.Z_ACCELERATION)) {
                return Type.Axis.AXIS_Z_ACCELERATION;
            } else if (identifier.equals(Component.Identifier.Axis.Z_FORCE)) {
                return Type.Axis.AXIS_Z_FORCE;
            } else if (identifier.equals(Component.Identifier.Axis.Z_VELOCITY)) {
                return Type.Axis.AXIS_Z_VELOCITY;
            } else if (identifier.equals(Component.Identifier.Axis.RX)) {
                return Type.Axis.AXIS_RX;
            } else if (identifier.equals(Component.Identifier.Axis.RX_ACCELERATION)) {
                return Type.Axis.AXIS_RX_ACCELERATION;
            } else if (identifier.equals(Component.Identifier.Axis.RX_FORCE)) {
                return Type.Axis.AXIS_RX_FORCE;
            } else if (identifier.equals(Component.Identifier.Axis.RX_VELOCITY)) {
                return Type.Axis.AXIS_RX_VELOCITY;
            } else if (identifier.equals(Component.Identifier.Axis.RY)) {
                return Type.Axis.AXIS_RY;
            } else if (identifier.equals(Component.Identifier.Axis.RY_ACCELERATION)) {
                return Type.Axis.AXIS_RY_ACCELERATION;
            } else if (identifier.equals(Component.Identifier.Axis.RY_FORCE)) {
                return Type.Axis.AXIS_RY_FORCE;
            } else if (identifier.equals(Component.Identifier.Axis.RY_VELOCITY)) {
                return Type.Axis.AXIS_RY_VELOCITY;
            } else if (identifier.equals(Component.Identifier.Axis.RZ)) {
                return Type.Axis.AXIS_RZ;
            } else if (identifier.equals(Component.Identifier.Axis.RZ_ACCELERATION)) {
                return Type.Axis.AXIS_RZ_ACCELERATION;
            } else if (identifier.equals(Component.Identifier.Axis.RZ_FORCE)) {
                return Type.Axis.AXIS_RZ_FORCE;
            } else if (identifier.equals(Component.Identifier.Axis.RZ_VELOCITY)) {
                return Type.Axis.AXIS_RZ_VELOCITY;
            } else if (identifier.equals(Component.Identifier.Axis.SLIDER)) {
                return Type.Axis.AXIS_SLIDER;
            } else if (identifier.equals(Component.Identifier.Axis.SLIDER_ACCELERATION)) {
                return Type.Axis.AXIS_SLIDER_ACCELERATION;
            } else if (identifier.equals(Component.Identifier.Axis.SLIDER_FORCE)) {
                return Type.Axis.AXIS_SLIDER_FORCE;
            } else if (identifier.equals(Component.Identifier.Axis.SLIDER_VELOCITY)) {
                return Type.Axis.AXIS_SLIDER_VELOCITY;
            } else if (identifier.equals(Component.Identifier.Axis.POV)) {
                return Type.POV;
            }
        } else if (identifier instanceof Component.Identifier.Button) {
            if (identifier.equals(Component.Identifier.Button._0)) {
                return Type.Button.BUTTON_00;
            } else if (identifier.equals(Component.Identifier.Button._1)) {
                return Type.Button.BUTTON_01;
            } else if (identifier.equals(Component.Identifier.Button._2)) {
                return Type.Button.BUTTON_02;
            } else if (identifier.equals(Component.Identifier.Button._3)) {
                return Type.Button.BUTTON_03;
            } else if (identifier.equals(Component.Identifier.Button._4)) {
                return Type.Button.BUTTON_04;
            } else if (identifier.equals(Component.Identifier.Button._5)) {
                return Type.Button.BUTTON_05;
            } else if (identifier.equals(Component.Identifier.Button._6)) {
                return Type.Button.BUTTON_06;
            } else if (identifier.equals(Component.Identifier.Button._7)) {
                return Type.Button.BUTTON_07;
            } else if (identifier.equals(Component.Identifier.Button._8)) {
                return Type.Button.BUTTON_08;
            } else if (identifier.equals(Component.Identifier.Button._9)) {
                return Type.Button.BUTTON_09;
            } else if (identifier.equals(Component.Identifier.Button._10)) {
                return Type.Button.BUTTON_10;
            } else if (identifier.equals(Component.Identifier.Button._11)) {
                return Type.Button.BUTTON_11;
            } else if (identifier.equals(Component.Identifier.Button._12)) {
                return Type.Button.BUTTON_12;
            } else if (identifier.equals(Component.Identifier.Button._13)) {
                return Type.Button.BUTTON_13;
            } else if (identifier.equals(Component.Identifier.Button._14)) {
                return Type.Button.BUTTON_14;
            } else if (identifier.equals(Component.Identifier.Button._15)) {
                return Type.Button.BUTTON_15;
            } else if (identifier.equals(Component.Identifier.Button._16)) {
                return Type.Button.BUTTON_16;
            } else if (identifier.equals(Component.Identifier.Button._17)) {
                return Type.Button.BUTTON_17;
            } else if (identifier.equals(Component.Identifier.Button._18)) {
                return Type.Button.BUTTON_18;
            } else if (identifier.equals(Component.Identifier.Button._19)) {
                return Type.Button.BUTTON_19;
            } else if (identifier.equals(Component.Identifier.Button._20)) {
                return Type.Button.BUTTON_20;
            } else if (identifier.equals(Component.Identifier.Button._21)) {
                return Type.Button.BUTTON_21;
            } else if (identifier.equals(Component.Identifier.Button._22)) {
                return Type.Button.BUTTON_22;
            } else if (identifier.equals(Component.Identifier.Button._23)) {
                return Type.Button.BUTTON_23;
            } else if (identifier.equals(Component.Identifier.Button._24)) {
                return Type.Button.BUTTON_24;
            } else if (identifier.equals(Component.Identifier.Button._25)) {
                return Type.Button.BUTTON_25;
            } else if (identifier.equals(Component.Identifier.Button._26)) {
                return Type.Button.BUTTON_26;
            } else if (identifier.equals(Component.Identifier.Button._27)) {
                return Type.Button.BUTTON_27;
            } else if (identifier.equals(Component.Identifier.Button._28)) {
                return Type.Button.BUTTON_28;
            } else if (identifier.equals(Component.Identifier.Button._29)) {
                return Type.Button.BUTTON_29;
            } else if (identifier.equals(Component.Identifier.Button._30)) {
                return Type.Button.BUTTON_30;
            } else if (identifier.equals(Component.Identifier.Button._31)) {
                return Type.Button.BUTTON_31;
            } else if (identifier.equals(Component.Identifier.Button.A)) {
                return Type.Button.BUTTON_A;
            } else if (identifier.equals(Component.Identifier.Button.B)) {
                return Type.Button.BUTTON_B;
            } else if (identifier.equals(Component.Identifier.Button.BACK)) {
                return Type.Button.BUTTON_BACK;
            } else if (identifier.equals(Component.Identifier.Button.BASE)) {
                return Type.Button.BUTTON_BASE1;
            } else if (identifier.equals(Component.Identifier.Button.BASE2)) {
                return Type.Button.BUTTON_BASE2;
            } else if (identifier.equals(Component.Identifier.Button.BASE3)) {
                return Type.Button.BUTTON_BASE3;
            } else if (identifier.equals(Component.Identifier.Button.BASE4)) {
                return Type.Button.BUTTON_BASE4;
            } else if (identifier.equals(Component.Identifier.Button.BASE5)) {
                return Type.Button.BUTTON_BASE5;
            } else if (identifier.equals(Component.Identifier.Button.BASE6)) {
                return Type.Button.BUTTON_BASE6;
            } else if (identifier.equals(Component.Identifier.Button.C)) {
                return Type.Button.BUTTON_C;
            } else if (identifier.equals(Component.Identifier.Button.DEAD)) {
                return Type.Button.BUTTON_DEAD;
            } else if (identifier.equals(Component.Identifier.Button.EXTRA)) {
                return Type.Button.BUTTON_EXTRA;
            } else if (identifier.equals(Component.Identifier.Button.FORWARD)) {
                return Type.Button.BUTTON_FORWARD;
            } else if (identifier.equals(Component.Identifier.Button.LEFT)) {
                return Type.Button.BUTTON_LEFT;
            } else if (identifier.equals(Component.Identifier.Button.LEFT_THUMB)) {
                return Type.Button.BUTTON_LEFT_THUMB1;
            } else if (identifier.equals(Component.Identifier.Button.LEFT_THUMB2)) {
                return Type.Button.BUTTON_LEFT_THUMB2;
            } else if (identifier.equals(Component.Identifier.Button.LEFT_THUMB3)) {
                return Type.Button.BUTTON_LEFT_THUMB3;
            } else if (identifier.equals(Component.Identifier.Button.MIDDLE)) {
                return Type.Button.BUTTON_MIDDLE;
            } else if (identifier.equals(Component.Identifier.Button.MODE)) {
                return Type.Button.BUTTON_MODE;
            } else if (identifier.equals(Component.Identifier.Button.PINKIE)) {
                return Type.Button.BUTTON_PINKIE;
            } else if (identifier.equals(Component.Identifier.Button.RIGHT)) {
                return Type.Button.BUTTON_RIGHT;
            } else if (identifier.equals(Component.Identifier.Button.RIGHT_THUMB)) {
                return Type.Button.BUTTON_RIGHT_THUMB1;
            } else if (identifier.equals(Component.Identifier.Button.RIGHT_THUMB2)) {
                return Type.Button.BUTTON_RIGHT_THUMB2;
            } else if (identifier.equals(Component.Identifier.Button.RIGHT_THUMB3)) {
                return Type.Button.BUTTON_RIGHT_THUMB3;
            } else if (identifier.equals(Component.Identifier.Button.SELECT)) {
                return Type.Button.BUTTON_SELECT;
            } else if (identifier.equals(Component.Identifier.Button.SIDE)) {
                return Type.Button.BUTTON_SIDE;
            } else if (identifier.equals(Component.Identifier.Button.STYLUS)) {
                return Type.Button.BUTTON_STYLUS1;
            } else if (identifier.equals(Component.Identifier.Button.STYLUS2)) {
                return Type.Button.BUTTON_STYLUS2;
            } else if (identifier.equals(Component.Identifier.Button.THUMB)) {
                return Type.Button.BUTTON_THUMB1;
            } else if (identifier.equals(Component.Identifier.Button.THUMB2)) {
                return Type.Button.BUTTON_THUMB2;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_AIRBRUSH)) {
                return Type.Button.BUTTON_TOOL_AIRBRUSH;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_BRUSH)) {
                return Type.Button.BUTTON_TOOL_BRUSH;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_FINGER)) {
                return Type.Button.BUTTON_TOOL_FINGER;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_LENS)) {
                return Type.Button.BUTTON_TOOL_LENS;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_MOUSE)) {
                return Type.Button.BUTTON_TOOL_MOUSE;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_PEN)) {
                return Type.Button.BUTTON_TOOL_PEN;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_PENCIL)) {
                return Type.Button.BUTTON_TOOL_PENCIL;
            } else if (identifier.equals(Component.Identifier.Button.TOOL_RUBBER)) {
                return Type.Button.BUTTON_TOOL_RUBBER;
            } else if (identifier.equals(Component.Identifier.Button.TOP)) {
                return Type.Button.BUTTON_TOP1;
            } else if (identifier.equals(Component.Identifier.Button.TOP2)) {
                return Type.Button.BUTTON_TOP2;
            } else if (identifier.equals(Component.Identifier.Button.TOUCH)) {
                return Type.Button.BUTTON_TOUCH;
            } else if (identifier.equals(Component.Identifier.Button.TRIGGER)) {
                return Type.Button.BUTTON_TRIGGER;
            } else if (identifier.equals(Component.Identifier.Button.X)) {
                return Type.Button.BUTTON_X;
            } else if (identifier.equals(Component.Identifier.Button.Y)) {
                return Type.Button.BUTTON_Y;
            } else if (identifier.equals(Component.Identifier.Button.Z)) {
                return Type.Button.BUTTON_Z;
            }
        }
        AbstractComponent.logger.warn("Unknown component found '{}'.", this.component.getName());
        return Type.UNKNOWN_COMPONENT;
    }
    
    private void setType(Type type) {
        this.type = type;
        AbstractComponent.logger.debug("Component '{}' mapped as '{}'.", this.component.getName(), this.type.getName());
    }
    
    public Type getType() {
        return this.type;
    }
    
}

