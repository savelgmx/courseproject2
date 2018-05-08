package fb.fandroid.adv.courseproject2;

/**
 * Created by Administrator on 08.05.2018.
 * предназначен для хранения настроек на предпочитаемую поисковую машину
 * google yandex bing
 */
/*
Код, который отслеживает выбор переключателя и записывает состояние в настройки.


package ru.alexanderklimov.test;

import ...

public class MainActivity extends Activity {

	RadioGroup radioGroup;
	// это будет именем файла настроек
	public static final String APP_PREFERENCES = "mysettings";
	final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		radioGroup
				.setOnCheckedChangeListener(radioGroupOnCheckedChangeListener);

		LoadPreferences();
	}

	OnCheckedChangeListener radioGroupOnCheckedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			RadioButton checkedRadioButton = (RadioButton) radioGroup
					.findViewById(checkedId);
			int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);

			SavePreferences(KEY_RADIOBUTTON_INDEX, checkedIndex);
		}
	};

	private void SavePreferences(String key, int value) {
		SharedPreferences sharedPreferences = getSharedPreferences(
				APP_PREFERENCES, MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.apply();
	}

	private void LoadPreferences() {
		SharedPreferences sharedPreferences = getSharedPreferences(
				APP_PREFERENCES, MODE_PRIVATE);
		int savedRadioIndex = sharedPreferences.getInt(
				KEY_RADIOBUTTON_INDEX, 0);
		RadioButton savedCheckedRadioButton = (RadioButton) radioGroup
				.getChildAt(savedRadioIndex);
		savedCheckedRadioButton.setChecked(true);
	}
}
 */
public class SharedPreferencesHelper {
}
