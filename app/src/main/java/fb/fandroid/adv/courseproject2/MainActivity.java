package fb.fandroid.adv.courseproject2;

import android.support.v4.app.Fragment;

/*
Задание 2.

Создать 3 фрагмента.

Эти фрагменты будут меняться в контейнере на экране при нажатии на соответствующие пункты меню.
Так же они должны быть добавлены в backstack FragmentManager'а.

Главный(MainFragment) - открывается по умолчанию при запуске приложения. (добавляется в контейнер).
Настройки(SettingsFragment) - открывается по нажатию на пункт меню Настройки.
На разметке находятся RadioButton'ы - три пункта - Google, Яндекс, Bing.
Сохранять выбранный пункт в SharedPreferences. Извлекать из SharedPreferences при запуске экрана.

Поиск - открывается по нажатию на пункт Поиск.
На разметке находится EditText и Кнопка поиск.
При нажатии на кнопку - открывается браузер с поиском введенного текста
в выбранном на экране настроек поисковике.

При нажатии на пункт Выход и при нажатии назад при пустом бэкстеке фрагментов - приложение закрывается.
 */

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}
