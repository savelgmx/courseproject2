package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Administrator on 08.05.2018.
 * предназначен для хранения настроек на предпочитаемую поисковую машину
 * google yandex bing
 */

public class SharedPreferencesHelper {

    public  static SharedPreferences mSharedPreferences;
    final static String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";// это будет именем файла настроек
    public static boolean saveSessionId(int FBID , Context context) {

        Log.i("saveSessionId", String.valueOf(FBID));

        SharedPreferences.Editor editor = context.getSharedPreferences(KEY_RADIOBUTTON_INDEX, 0).edit();
        editor.putInt(KEY_RADIOBUTTON_INDEX , FBID);
        return editor.commit();
    }

    public static int getSessionId(Context context) {
        SharedPreferences savedSession = context.getSharedPreferences(KEY_RADIOBUTTON_INDEX, 0);
        return savedSession.getInt(KEY_RADIOBUTTON_INDEX , 0);
    }
}
