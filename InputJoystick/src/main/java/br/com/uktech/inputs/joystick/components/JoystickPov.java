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
public class JoystickPov extends AbstractComponent {
    
    public static class Position {
        
        public static final Position CENTER = new Position("Center", 0.0f);
        public static final Position UP_LEFT = new Position("Up - Left", 0.125f);
        public static final Position UP = new Position("Up", 0.25f);
        public static final Position UP_RIGHT = new Position("Up - Right", 0.375f);
        public static final Position RIGHT = new Position("Right", 0.5f);
        public static final Position DOWN_RIGHT = new Position("Down Right", 0.625f);
        public static final Position DOWN = new Position("Down", 0.75f);
        public static final Position DOWN_LEFT = new Position("Down - Left", 0.875f);
        public static final Position LEFT = new Position("Left", 1.0f);
        
        private final String name;
        private final float value;
        
        protected Position(String name, Float value) {
            this.name = name;
            this.value = value;
        }
        
        public Float getValue() {
            return this.value;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    private static final Logger logger = LoggerFactory.getLogger(JoystickPov.class);

    public JoystickPov(Component component) {
        super(component);
        JoystickPov.logger.debug("Created a new POV component named '{}'", this.getName());
    }
    
    public Position getPosition() {
        if (this.getValue() == Position.CENTER.getValue())  {
            return Position.CENTER;
        } else if (this.getValue() == Position.UP_LEFT.getValue())  {
            return Position.UP_LEFT;
        } else if (this.getValue() == Position.UP.getValue())  {
            return Position.UP;
        } else if (this.getValue() == Position.UP_RIGHT.getValue())  {
            return Position.UP_RIGHT;
        } else if (this.getValue() == Position.RIGHT.getValue())  {
            return Position.RIGHT;
        } else if (this.getValue() == Position.DOWN_RIGHT.getValue())  {
            return Position.DOWN_RIGHT;
        } else if (this.getValue() == Position.DOWN.getValue())  {
            return Position.DOWN;
        } else if (this.getValue() == Position.DOWN_LEFT.getValue())  {
            return Position.DOWN_LEFT;
        } else {
            return Position.LEFT;
        }
    }
}
