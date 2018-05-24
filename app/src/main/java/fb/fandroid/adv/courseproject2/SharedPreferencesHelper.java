package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 08.05.2018.
 * предназначен для хранения настроек на предпочитаемую поисковую машину
 * google yandex bing
JSON {
 "rButtonChecked":true,
 "rButtonId":"1"
 }
 http://hacksmile.com/how-to-create-android-settings-screen-using-preferencefragment/

 https://www.google.ru/search?newwindow=1&q=getsharedpreferences%20in%20fragment&ved=0ahUKEwih2JfLspbbAhUM8RQKHfhtCpkQsKwBCDUoATAA&biw=1920&bih=970

 https://www.google.com/search?q=getActivity.getSharedPreferences&oq=getActivity.getSharedPreferences&aqs=chrome..69i57.7424981j0j7&sourceid=chrome&ie=UTF-8

 https://www.coderefer.com/android-sharedpreferences-example-tutorial/

 */

public class SharedPreferencesHelper {

    public  static SharedPreferences mSharedPreferences;
    final static String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";// это будет именем файла настроек
  //  private static RadioGroup radioGroup;


   /* RadioGroup.OnCheckedChangeListener radioGroupOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);
            int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);

            SavePreferences(KEY_RADIOBUTTON_INDEX, checkedIndex);
        }
    };



    public static void SavePreferences(String key, int value) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

*/
    public static boolean saveSessionId(int FBID , Context context) {

        Log.i("saveSessionID", String.valueOf(FBID));

        SharedPreferences.Editor editor = context.getSharedPreferences(KEY_RADIOBUTTON_INDEX, 0).edit();
        editor.putInt(KEY_RADIOBUTTON_INDEX , FBID);
        return editor.commit();
    }

    public static int getSessionId(Context context) {
        SharedPreferences savedSession = context.getSharedPreferences(KEY_RADIOBUTTON_INDEX, 0);
        return savedSession.getInt(KEY_RADIOBUTTON_INDEX , 0);
    }
}
