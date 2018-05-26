package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
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
    private int CheckedRadioButtonIndex;



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


        CheckedRadioButtonIndex=SharedPreferencesHelper.getSessionId(getContext());
        Log.i("GetSessionId",String.valueOf(SharedPreferencesHelper.getSessionId(getContext())));


        View view = inflater.inflate(R.layout.fr_settings, container, false);
         radioGroup =  view.findViewById(R.id.radioGroup);
         radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

         SetSavedRadioButtonChecked(CheckedRadioButtonIndex);


        return view;
    }

    /* устанавливает предпочитаемый RadioButton согласно сохраненному Id
    */

    private void SetSavedRadioButtonChecked(int savedRadioIndex){
        RadioButton savedCheckedRadioButton = (RadioButton) radioGroup
                .getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }


    /**
     * Listener для отслеживания выбора RadioButton
     */
    private final RadioGroup.OnCheckedChangeListener onCheckedChangeListener =
            new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    RadioButton checkedRadioButton = (RadioButton) radioGroup
                            .findViewById(checkedId);
                    int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);

                    Log.i("checkedIndexId",String.valueOf(checkedIndex));

                    SharedPreferencesHelper.saveSessionId(checkedIndex,getContext());

                    Context context = getActivity();


                }
            };

}
