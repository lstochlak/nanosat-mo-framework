/* ----------------------------------------------------------------------------
 * Copyright (C) 2015      European Space Agency
 *                         European Space Operations Centre
 *                         Darmstadt
 *                         Germany
 * ----------------------------------------------------------------------------
 * System                : ESA NanoSat MO Framework
 * ----------------------------------------------------------------------------
 * Licensed under the European Space Agency Public License, Version 2.0
 * You may not use this file except in compliance with the License.
 *
 * Except as expressly set forth in this License, the Software is provided to
 * You on an "as is" basis and without warranties of any kind, including without
 * limitation merchantability, fitness for a particular purpose, absence of
 * defects or errors, accuracy or non-infringement of intellectual property rights.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * ----------------------------------------------------------------------------
 */
package opssat.simulator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Cesar Coelho
 */
public class Magnetometer {
    
    private Orbit orbit;
         
    private static final double B_0 = 3.12E-5; // Tesla
    private static final double R_e = 6370; //km
            
        public Magnetometer(Orbit received) {
               this.orbit = received;
        }
      
        /**
        * Magnetic field on the r axis measured in Tesla
        */
        public double getB_r() {
            // From: http://en.wikipedia.org/wiki/Dipole_model_of_the_Earth%27s_magnetic_field
            Orbit.OrbitParameters param = orbit.getParameters();
            double theta = Math.PI - param.getlatitude() * Math.PI / 180;
            double B_r = -2 * B_0 * Math.pow(R_e/param.geta(), 3) * Math.cos( theta );
            return B_r;
        }

        /**
        * Magnetic field on the theta axis measured in Tesla
        */
        public double getB_theta() {
            // From: http://en.wikipedia.org/wiki/Dipole_model_of_the_Earth%27s_magnetic_field
            Orbit.OrbitParameters param = orbit.getParameters();
            double theta = Math.PI - param.getlatitude() * Math.PI / 180;
            double B_theta = - B_0 * Math.pow(R_e/param.geta(), 3) * Math.sin( theta );
            return B_theta;
        }
        
        
}
