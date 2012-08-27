/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.src;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 *
 * @author yole
 */
public class Alert {
    
    public static void show(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
	builder.setCancelable(true);
	builder.setTitle("Title");
	builder.setInverseBackgroundForced(true);
	builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

	  public void onClick(DialogInterface dialog, int which) {
	    dialog.dismiss();
	  }
	});
	builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            
	  public void onClick(DialogInterface dialog, int which) {
	    dialog.dismiss();
	  }
	});
	AlertDialog alert = builder.create();
	alert.show();
        
    }
}
