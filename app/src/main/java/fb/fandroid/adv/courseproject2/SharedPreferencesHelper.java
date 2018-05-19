package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 08.05.2018.
 * предназначен для хранения настроек на предпочитаемую поисковую машину
 * google yandex bing
JSON {
 "rButtonChecked":true,
 "rButtonId":"1"
 }
 */


public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String RBUTTONS_KEY = "RBUTTONS_KEY";
    public static final Type RBUTTONS_TYPE = new TypeToken<List<Rbutton>>() {
    }.getType();

//

    private SharedPreferences mSharedPreferences;
    private Gson mGson = new Gson();

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public List<Rbutton> getRbuttons() {
        List<Rbutton> rbuttons = mGson.fromJson(mSharedPreferences.getString(RBUTTONS_KEY, ""), RBUTTONS_TYPE);
        return rbuttons == null ? new ArrayList<Rbutton>() : rbuttons;
    }

    public boolean addRbutton(Rbutton rbutton) {
        List<Rbutton> rbuttons = getRbuttons();
        rbuttons.add(rbutton);
        mSharedPreferences.edit().putString(RBUTTONS_KEY, mGson.toJson(rbuttons, RBUTTONS_TYPE)).apply();
        return true;
    }


}



/*
    public void SavePreferences(String key, int value) {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

   public void LoadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton) radioGroup
                .getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }

/
}
*/