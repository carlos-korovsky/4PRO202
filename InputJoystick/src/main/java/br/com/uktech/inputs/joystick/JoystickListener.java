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

package br.com.uktech.inputs.joystick;

import br.com.uktech.inputs.joystick.events.JoystickAxisEvent;
import br.com.uktech.inputs.joystick.events.JoystickButtonEvent;
import br.com.uktech.inputs.joystick.events.JoystickPovEvent;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@uktech.com.br>
 */
public interface JoystickListener {
    public void onAxisChange(JoystickAxisEvent event);
    public void onPovChange(JoystickPovEvent event);
    public void onButtonChange(JoystickButtonEvent event);
}
