package test.src;

import OpenCOM.ILifeCycle;
import OpenCOM.IOpenCOM;
import OpenCOM.OpenCOM;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    
    private EditText text;
    private Button button;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (EditText) findViewById(R.id.edit_message);
        button = (Button) findViewById(R.id.calculator);
        
    }
    
        
    public void calcAct(View view) {

        float input;
        String aux;

        RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio1);
        RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio2);

        OpenCOM runtime = new OpenCOM();
        IOpenCOM pIOC=(IOpenCOM) runtime.QueryInterface("OpenCOM.IOpenCOM");
        IConversor pConversorIUnk = 
                    (IConversor) pIOC.createInstance("test.src.Conversor",
                                    "conversor");

        IEngine pEngineIUnk = 
                (IEngine) pIOC.createInstance("test.src.Engine", "engine");
        
        
        ILifeCycle pILifeConv = (ILifeCycle)
                pConversorIUnk.QueryInterface("OpenCOM.ILifeCycle");
        ILifeCycle pILifeEng = (ILifeCycle)
                pEngineIUnk.QueryInterface("OpenCOM.ILifeCycle");


        if ( pILifeConv.startup(pIOC) &&
                pILifeEng.startup(pIOC)) {


        long ConnID1 = 
                pIOC.connect(pEngineIUnk, pConversorIUnk, "test.src.IConversor");

        if (celsiusButton.isChecked()) {
            input = (float) Float.parseFloat(text.getText().toString());
            aux = String.valueOf(pEngineIUnk.fareinheitToCelsius(input));
            text.setText(aux, TextView.BufferType.EDITABLE);
        }

        else if (fahrenheitButton.isChecked()) {
            input = (float)Float.parseFloat(text.getText().toString());
            aux = String.valueOf(pEngineIUnk.celsiusToFareinheit(input));
            text.setText(aux, TextView.BufferType.EDITABLE);
            
        }

        pIOC.disconnect(ConnID1);
        pIOC.deleteInstance(pConversorIUnk);
        pIOC.deleteInstance(pEngineIUnk);
        
        }

    }
        
}
