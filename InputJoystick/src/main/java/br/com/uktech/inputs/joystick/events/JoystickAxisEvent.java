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

package br.com.uktech.inputs.joystick.events;

import br.com.uktech.inputs.joystick.components.JoystickAxis;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@uktech.com.br>
 */
public class JoystickAxisEvent extends JoystickEvent {
    private float value;
    
    public JoystickAxisEvent(JoystickAxis source, Float value) {
        super(source);
        this.value = value;
    }
    
    @Override
    public JoystickAxis getSource() {
        return (JoystickAxis) super.getSource();
    }
    
    public Float getValue() {
        return this.value;
    }
}