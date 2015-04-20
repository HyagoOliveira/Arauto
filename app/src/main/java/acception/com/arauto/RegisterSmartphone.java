package acception.com.arauto;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hyago on 17/04/15.
 */
public class RegisterSmartphone {

    private String projectNumber;
    private String urlServer;

    private Activity activity;

    private SharedPreferences sharedPref;


    public RegisterSmartphone(Activity activity){
        this.activity=activity;
        sharedPref = this.activity.getPreferences(Context.MODE_PRIVATE);

        loadSavedPreferences();
    }

    private void loadSavedPreferences(){
        projectNumber = sharedPref.getString(
                activity.getResources().getString(R.string.saved_project_number_label),
                activity.getResources().getString(R.string.default_project_number));

        urlServer = sharedPref.getString(
                activity.getResources().getString(R.string.saved_url_server_label),
                activity.getResources().getString(R.string.default_url_server));
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public void setUrlServer(String urlServer) {
        this.urlServer = urlServer;
    }

    public void savePreferences(){
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(activity.getResources().getString(R.string.saved_project_number_label), projectNumber);
        editor.putString(activity.getResources().getString(R.string.saved_url_server_label), urlServer);

        editor.commit();
    }



    public String getProjectNumber() {
        return projectNumber;
    }

    public String getUrlServer() {
        return urlServer;
    }
}
