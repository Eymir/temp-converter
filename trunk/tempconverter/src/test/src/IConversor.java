/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.src;

import OpenCOM.IUnknown;

/**
 *
 * @author yole
 */
public interface IConversor extends IUnknown {
    
    public float celsiusToFareinheit(float c);
    
    public float fareinheitToCelsius(float c);
    
}
