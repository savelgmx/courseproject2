package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
 */

public class SharedPreferencesHelper {

    public  static SharedPreferences mSharedPreferences;
    final static String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";// это будет именем файла настроек
    private static RadioGroup radioGroup;


    public SharedPreferencesHelper(Context context) {
        this.radioGroupOnCheckedChangeListener = radioGroupOnCheckedChangeListener;
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    RadioGroup.OnCheckedChangeListener radioGroupOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

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

    public static void LoadPreferences(Context context) {

        ///SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences();
        int savedRadioIndex = mSharedPreferences.getInt( KEY_RADIOBUTTON_INDEX, 0);
         RadioButton savedCheckedRadioButton = (RadioButton) radioGroup
                .getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }


}
