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

import br.com.uktech.inputs.joystick.components.JoystickAxis;
import br.com.uktech.inputs.joystick.components.JoystickButton;
import br.com.uktech.inputs.joystick.components.JoystickPov;
import br.com.uktech.inputs.joystick.events.JoystickAxisEvent;
import br.com.uktech.inputs.joystick.events.JoystickButtonEvent;
import br.com.uktech.inputs.joystick.events.JoystickEvent;
import br.com.uktech.inputs.joystick.events.JoystickPovEvent;
import java.util.ArrayList;
import java.util.HashMap;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import net.java.games.input.Rumbler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@uktech.com.br>
 */
public abstract class Joystick implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Joystick.class);
    
    private final Controller controller;
    private boolean running;
    
    private final HashMap<Component, JoystickAxis> axis;
    private final HashMap<Component, JoystickPov> povs;
    private final HashMap<Component, JoystickButton> buttons;
    private final ArrayList<JoystickEvent> events;
    private final ArrayList<JoystickListener> listeners;
    
    public Joystick(Controller controller) {
        Joystick.logger.debug("Creating a new Joystick: '{}'", controller.getName());
        this.controller = controller;
        this.axis = new HashMap<>();
        this.buttons = new HashMap<>();
        this.povs = new HashMap<>();
        this.events = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.init();
    }
      
    private void init() {
        this.stop();
        Joystick.logger.debug("Mapping '{}' components.", controller.getName());
        Component[] components = this.controller.getComponents();
        Joystick.logger.debug("Found {} components.", components.length);
        for (Component component: components) {
            if ( component.getIdentifier() instanceof Component.Identifier.Button ) {
                Joystick.logger.debug("Found button: '{}' from '{}'.", component.getName(), controller.getName());
                this.buttons.put(component, new JoystickButton(component));
            } else if ( component.getIdentifier().equals(Component.Identifier.Axis.POV) ) {
                Joystick.logger.debug("Found POV: '{}' from '{}'.", component.getName(), controller.getName());
                this.povs.put(component, new JoystickPov(component));
            } else {
                Joystick.logger.debug("Found axis: '{}' from '{}'.", component.getName(), controller.getName());
                this.axis.put(component, new JoystickAxis(component));
            }
        }
        Rumbler[] rumblers = this.controller.getRumblers();
        Joystick.logger.debug("Found {} rumblers.", rumblers.length);
        for (Rumbler rumbler: rumblers) {
            for (Component component: this.axis.keySet()) {
                if (component.getIdentifier().equals(rumbler.getAxisIdentifier())) {
                    JoystickAxis joyAxis = this.axis.get(component);
                    joyAxis.setRumbler(rumbler);
                    Joystick.logger.debug("Found rumbler for '{}'", joyAxis.getName());
                }
            }
        }
        this.controller.poll();
        this.processEvents(this.controller.getEventQueue());
    }
    
    public String getName() {
        return this.controller.getName();
    }
    
    protected Controller getController() {
        return this.controller;
    }

    public void addListener(JoystickListener listener) {
        if (this.listeners.contains(listener) == false) {
            this.listeners.add(listener);
        }
    }
    
    public void removeListener(JoystickListener listener) {
        this.listeners.remove(listener);
    }
    
    private synchronized void updateListeners() {
        for (JoystickEvent event: this.events) {
            for (JoystickListener listener: this.listeners) {
                if (event instanceof JoystickAxisEvent) {
                    listener.onAxisChange((JoystickAxisEvent) event);
                } else if (event instanceof JoystickPovEvent) {
                    listener.onPovChange((JoystickPovEvent) event);
                } else if (event instanceof JoystickButtonEvent) {
                    listener.onButtonChange((JoystickButtonEvent) event);
                }
            }
        }
        this.events.clear();
    }
    
    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }
    
    public void stop() {
        this.running = false;
    }
      
    private void delay() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            this.stop();
        }
    }
    
    @Override
    public void run() {
        Joystick.logger.debug("Starting events pooling of '{}'", controller.getName());
        this.running = true;
        while (this.isRunning()) {
            this.controller.poll();
            this.processEvents(this.controller.getEventQueue());
            this.delay();
        }
        Joystick.logger.debug("Finishing events pooling of '{}'", controller.getName());
    }
    
    private synchronized void processEvents(EventQueue events) {
        Event event = new Event();
        while (events.getNextEvent(event)) {
            Component component = event.getComponent();
            float newValue = event.getValue();
             if (this.axis.containsKey(component)) {
                 JoystickAxis axis = this.axis.get(component);
                 axis.setValue(newValue);
                 this.events.add(new JoystickAxisEvent(axis, axis.getValue()));
            } else if (this.povs.containsKey(component)) {
                 JoystickPov pov = this.povs.get(component);
                 pov.setValue(newValue);
                 this.events.add(new JoystickPovEvent(pov, pov.getPosition()));
            } else  if (this.buttons.containsKey(component)) {
                 JoystickButton button = this.buttons.get(component);
                 button.setValue(newValue);
                 this.events.add(new JoystickButtonEvent(button, button.isPressed()));
            }
        }
        this.updateListeners();
    }
}
