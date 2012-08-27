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
public class Engine extends OpenCOMComponent
    implements IConnections, IEngine, ILifeCycle, IUnknown, IMetaInterface {

    public OCM_SingleReceptacle<IConversor> m_PSR_IConversor;
    
    public Engine(IUnknown binder) {
        super(binder);
        m_PSR_IConversor = new OCM_SingleReceptacle<IConversor>(IConversor.class);
    }
    
     @Override
    public boolean connect(IUnknown iu, String string, long l) {
        if (string.equalsIgnoreCase("test.src.IConversor")) {
            return m_PSR_IConversor.connectToRecp(iu, string, l);
        }
        else return false;
    }

    @Override
    public boolean disconnect(String string, long l) {
        if (string.equalsIgnoreCase("test.src.IConversor"))  {
            return m_PSR_IConversor.disconnectFromRecp(l);
        }
        else return false;
    }

    public float celsiusToFareinheit(float c) {
        return m_PSR_IConversor.m_pIntf.celsiusToFareinheit(c);
    }

    public float fareinheitToCelsius(float c) {
        return m_PSR_IConversor.m_pIntf.fareinheitToCelsius(c);
    }

    public boolean startup(Object o) {
        return true;
    }

    public boolean shutdown() {
        return true;
    }
    
}
