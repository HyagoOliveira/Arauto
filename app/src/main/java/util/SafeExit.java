package util;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import acception.com.arauto.R;
import networking.VolleyController;

/**
 * Created by hyago on 17/04/15.
 */
public class SafeExit {
    private long lastBackPressTime;
    private Toast toast;
    private Activity activity;

    public SafeExit(Activity activity){
        lastBackPressTime = 0;
        this.activity = activity;
    }

    public void back(){
        if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            showToastMessage(R.string.application_close_press);
            this.lastBackPressTime = System.currentTimeMillis();
        }
        else {
            if(toast != null)
                toast.cancel();

            VolleyController.getInstance().cancelPendingRequests();
            activity.finish();
        }
    }

    public void showToastMessage(String message){
        toast = Toast.makeText(activity.getApplicationContext(),
                message, Toast.LENGTH_LONG);
        toast.show();
        Log.e("Toast", message);
    }

    public void showToastMessage(int rscStringId){
        showToastMessage(activity.getResources().getString(rscStringId));
    }

}
