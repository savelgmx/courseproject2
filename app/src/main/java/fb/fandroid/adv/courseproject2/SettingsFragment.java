package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * Created by Administrator on 04.05.2018.
 * необходим для показа экрана с выбром посковой машины
 * fr_settings  и для запоминапния настроек в SharedPreferences
 *
 *
 */

public class SettingsFragment extends Fragment {

    private RadioGroup radioGroup;



    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

       // SharedPreferencesHelper.getSessionId(getContext());


        int CheckedRadioButtonId=SharedPreferencesHelper.LoadPreferences(getContext());

        Log.i("CheckedRadoButtonID", String.valueOf(CheckedRadioButtonId));

        Log.i("GetSessionID",String.valueOf(SharedPreferencesHelper.getSessionId(getContext())));

        View view = inflater.inflate(R.layout.fr_settings, container, false);
         radioGroup =  view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        return view;
    }

    /**
     * Listener для отслеживания выбора RadioButton
     */
    private final RadioGroup.OnCheckedChangeListener onCheckedChangeListener =
            new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.rbGoogle:
                            //todo write preferred search engine
                          /*  boolean isGoogle= mSharedPreferencesHelper.addRbutton(
                                    new Rbutton(
                                            checkedId,
                                            true
                                    ));*/
                     //     SharedPreferencesHelper.SavePreferences("SAVED_RADIO_BUTTON_INDEX",checkedId);

                            Log.i("checkedId", String.valueOf(checkedId));

                            SharedPreferencesHelper.saveSessionId(checkedId,getContext());

                            break;

                        case R.id.rbYandex:
                            //TODO write preferred search engine
                        /*    boolean isYandex= mSharedPreferencesHelper.addRbutton(
                                    new Rbutton(
                                            checkedId,
                                            true
                                    ));
                        */
     //                       SharedPreferencesHelper.SavePreferences("SAVED_RADIO_BUTTON_INDEX",checkedId);

                            break;

                        case R.id.rbBing:
  //                          SharedPreferencesHelper.SavePreferences("SAVED_RADIO_BUTTON_INDEX",checkedId);

                            break;
                        default:
                            throw new IllegalArgumentException("Invalid id: " + checkedId);
                    }

                    Context context = getActivity();


                }
            };

}
