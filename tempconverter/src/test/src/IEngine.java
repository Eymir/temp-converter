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
public interface IEngine extends IUnknown {
    
    public float celsiusToFareinheit(float c);
    
    public float fareinheitToCelsius(float c);
    
}
