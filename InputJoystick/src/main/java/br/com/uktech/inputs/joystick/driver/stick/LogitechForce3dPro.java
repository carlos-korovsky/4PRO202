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

package br.com.uktech.inputs.joystick.driver.stick;

import br.com.uktech.inputs.joystick.driver.AbstractStick;
import java.util.ArrayList;
import java.util.Arrays;
import net.java.games.input.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@uktech.com.br>
 */
public class LogitechForce3dPro extends AbstractStick {
    private static final Logger logger = LoggerFactory.getLogger(LogitechForce3dPro.class);
    public static final ArrayList<String> names = new ArrayList<>(Arrays.asList("Logitech Force 3D Pro", "Logitech Logitech Force 3D Pro"));
    
    public LogitechForce3dPro(Controller controller) {
        super(controller);
        LogitechForce3dPro.logger.debug("Creating a new LogitchForce3dPro joystick.");
    }
    
}
