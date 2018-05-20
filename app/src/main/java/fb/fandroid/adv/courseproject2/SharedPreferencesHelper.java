package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    // это будет именем файла настроек
    public static final String APP_PREFERENCES = "mysettings";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    private RadioGroup radioGroup;
    private SharedPreferences sharedPreferences;



    //
    RadioGroup.OnCheckedChangeListener radioGroupOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);
            int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);

            SavePreferences(KEY_RADIOBUTTON_INDEX, checkedIndex);
        }
    };

    public SharedPreferencesHelper(Context context) {

        //new SharedPreferencesHelper(getApplicationContext());
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
    }

    public void SavePreferences(String key, int value) {
       // SharedPreferences sharedPreferences = context.getSharedPreferences(
           //     APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void LoadPreferences() {
     //   SharedPreferences sharedPreferences = getSharedPreferences(
     //           APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton) radioGroup
                .getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }


}
