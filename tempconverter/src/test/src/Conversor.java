/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.src;

import OpenCOM.*;

/**
 *
 * @author yole
 */
public class Conversor extends OpenCOMComponent
    implements IConversor, IMetaInterface, ILifeCycle, IUnknown {
    
    public Conversor(IUnknown binder) {
        super(binder);
    }
    
    public float celsiusToFareinheit(float c) {
        return (float)(c*1.8 + 32.0);
    }
    
    public float fareinheitToCelsius(float c) {
        
        return (float)((c-32.0)/1.8);
    }

    public boolean startup(Object o) {
        return true;
    }

    public boolean shutdown() {
        return true;
    }
    
}
