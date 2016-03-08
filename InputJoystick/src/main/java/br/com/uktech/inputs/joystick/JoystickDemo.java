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
import java.util.Map;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@uktech.com.br>
 */
public class JoystickDemo implements JoystickListener {
    private static final Logger logger = LoggerFactory.getLogger(JoystickDemo.class);
    private JoystickFactory joyFactory;
    private static JoystickDemo application;
    
    public static void main( String[] args )
    {
        JoystickDemo.application = new JoystickDemo();
        JoystickDemo.application.start();
    }
    
    private void start() {
        JoystickDemo.logger.debug("Starting JoystickDemo Application.");
        this.joyFactory = JoystickFactory.getInstance();
        ThreadGroup tg = new ThreadGroup("Joysticks pooling");
        Map<String, Joystick> found = this.joyFactory.getJoysticks();
        System.out.println("joysticks found: " + found.size());
        for (Map.Entry<String, Joystick> cursor : found.entrySet()) {
            System.out.println("Found joystick: " + cursor.getKey() + " ( "+ cursor.getValue().getName()+")");
            cursor.getValue().addListener(this);
            Thread th = new Thread(tg, cursor.getValue(), cursor.getKey());
            th.start();
        }
        try {
            Thread.sleep(45000);
        }
        catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(JoystickDemo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        for (Map.Entry<String, Joystick> cursor : found.entrySet()) {
            System.out.println("Stopping: " + cursor.getKey() + " ( "+ cursor.getValue().getName()+")");
            cursor.getValue().stop();
        }
        
        Thread[] list = new Thread[tg.activeCount()];
        int count = tg.enumerate(list);
        for (int i = 0; i < count; i++) {
           System.out.println("Thread " + list[i].getName() + " found");
            try {
                list[i].join();
            }
            catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(JoystickDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public void onAxisChange(JoystickAxisEvent event) {
        System.out.println(event.getSource().getName() + " value: " + event.getValue());
    }

    @Override
    public void onPovChange(JoystickPovEvent event) {
        System.out.println(event.getSource().getName() + " position: " + event.getPosition().getName());
    }

    @Override
    public void onButtonChange(JoystickButtonEvent event) {
        System.out.println(event.getSource().getName() + " is pressed: " + event.isPressed());
    }
}
