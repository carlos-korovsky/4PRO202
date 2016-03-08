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

import br.com.uktech.inputs.joystick.exceptions.ControllerNotSupportedException;
import br.com.uktech.inputs.joystick.driver.stick.CarolBoxUSBMoGouG3V45;
import br.com.uktech.inputs.joystick.driver.stick.LogitechForce3dPro;
import java.util.HashMap;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.ControllerEvent;
import net.java.games.input.ControllerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@uktech.com.br>
 */
public final class JoystickFactory implements ControllerListener {
    private static final Logger logger = LoggerFactory.getLogger(JoystickFactory.class);
    private static JoystickFactory instance;
    private HashMap<String, Joystick> joysticks;
    private final ControllerEnvironment controllerenv = ControllerEnvironment.getDefaultEnvironment();
    
    private JoystickFactory() {
        JoystickFactory.logger.debug("Creating a new JoystickFactory");
        this.setJoysticks(new HashMap<>());
        this.createControllersList();
    }
    
    public static JoystickFactory getInstance() {
        if (JoystickFactory.instance == null) {
            JoystickFactory.instance = new JoystickFactory();
        }
        JoystickFactory.logger.debug("Returning a JoystickFactory instance");
        return JoystickFactory.instance;
    }
    
    private void createControllersList() {
        JoystickFactory.logger.debug("Creating controllers list.");
        this.controllerenv.addControllerListener(this);
        this.getJoysticks().clear();
        Controller[] found = this.controllerenv.getControllers();
        for (Controller c : found ) {
            this.createJoystick(c);
        }
    }
    
    private void createJoystick(Controller c) {
        Controller[] subControllers = c.getControllers();
        if (subControllers.length == 0) {         
            Joystick joystick;
            try {
                joystick = this.getJoystickInstance(c);
                this.getJoysticks().put(c.getName(), joystick);
                JoystickFactory.logger.debug("Joystick '{}' mapped.", c.getName());
            }
            catch (ControllerNotSupportedException ex) {
                JoystickFactory.logger.warn("Joystick ('{}') is not supported.", c.getName());
            }
        } else {
            for (Controller sub : subControllers ) {
                createJoystick(sub);
            }
        }
    }
    
    private Joystick getJoystickInstance(Controller controller) throws ControllerNotSupportedException {
        String name = controller.getName();
        Controller.Type type = controller.getType();
        JoystickFactory.logger.debug("Instancing joystick '{}'.", name);
        Joystick joystick = null;
        if (Controller.Type.FINGERSTICK.equals(type)) {
            
        } else if (Controller.Type.GAMEPAD.equals(type)) {
            
        } else if (Controller.Type.HEADTRACKER.equals(type)) {
            
        } else if (Controller.Type.RUDDER.equals(type)) {
            
        } else if (Controller.Type.STICK.equals(type)) {
            if (LogitechForce3dPro.names.contains(name)) {
                joystick = new LogitechForce3dPro(controller);
            } else if (CarolBoxUSBMoGouG3V45.names.contains(name)) {
                joystick = new CarolBoxUSBMoGouG3V45(controller);
            }   
        } else if (Controller.Type.WHEEL.equals(type)) {
            
        }
        if (joystick == null) {
            throw new ControllerNotSupportedException("Joystick " + name + "is not supported.");
        }
        return joystick;
    }

    /**
     * @return the joysticks
     */
    public HashMap<String, Joystick> getJoysticks() {
        return joysticks;
    }

    /**
     * @param joysticks the joysticks to set
     */
    private void setJoysticks(HashMap<String, Joystick> joysticks) {
        this.joysticks = joysticks;
    }

    @Override
    public void controllerRemoved(ControllerEvent ev) {
        String name = ev.getController().getName();
        if (this.joysticks.containsKey(name)) {
            this.joysticks.remove(name);
        }
    }

    @Override
    public void controllerAdded(ControllerEvent ev) {
        String name = ev.getController().getName();
        if (this.joysticks.containsKey(name) == false) {
            this.createJoystick(ev.getController());
        }
    }
}
