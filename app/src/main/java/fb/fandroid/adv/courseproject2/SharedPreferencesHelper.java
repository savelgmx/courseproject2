package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.app.PendingIntent.getActivity;
import static android.content.Context.MODE_PRIVATE;

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

    private static SharedPreferences sharedPreferences;
    final static String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";// это будет именем файла настроек
    private static RadioGroup radioGroup;


    public SharedPreferencesHelper(SettingsFragment context) {
        this.radioGroupOnCheckedChangeListener = radioGroupOnCheckedChangeListener;
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void LoadPreferences(SettingsFragment context) {
     //   SharedPreferences sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton) radioGroup
                .getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }


}
