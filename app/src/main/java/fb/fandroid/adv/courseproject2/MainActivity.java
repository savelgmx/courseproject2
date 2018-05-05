package fb.fandroid.adv.courseproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/*
Задание 1.
Выполнено 02.05.2018
Создать проект.

Добавить в активити меню с 3 пунктами - Настройки, Поиск, Выход.
Добавить в разметку активити FrameLayout, который занимает весь экран.
При нажатии на пункты меню появляется тост с названием нажатого пункта.

Задание 2.

Создать 3 фрагмента.

Эти фрагменты будут меняться в контейнере на экране при нажатии на соответствующие пункты меню.
Так же они должны быть добавлены в backstack FragmentManager'а.

Главный - открывается по умолчанию при запуске приложения. (добавляется в контейнер).
Добавить разметку на ваше усмотрение.
Настройки - открывается по нажатию на пункт меню Настройки.
На разметке находятся RadioButton'ы - три пункта - Google, Яндекс, Bing.
Сохранять выбранный пункт в SharedPreferences. Извлекать из SharedPreferences при запуске экрана.
Поиск - открывается по нажатию на пункт Поиск.
На разметке находится EditText и Кнопка поиск.
При нажатии на кнопку - открывается браузер с поиском введенного текста
в выбранном на экране настроек поисковике.

При нажатии на пункт Выход и при нажатии назад при пустом бэкстеке фрагментов - приложение закрывается.
 */

public class MainActivity extends AppCompatActivity {

    private void showMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /*Добавляем метод, который берёт данные из ресурсов меню
       и преобразует их в пункты меню на экране.
       По английски "inflate" переводится как надувать,
       т.е. по замыслу разработчиков Android, мы как бы надуваем данными объект, например, меню.
       Но на самом деле слово "inflate" происходит от словосочетания in flat - в квартиру.
       Существует старинная традиция запускать в квартиру первым кота,
       который исследует все закоулки дома и заявляет о своём согласии жить в нём.
       Так и мы запускаем данные из XML-файла в объект MenuInflater.
        */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //Для обработки нажатий пунктов меню служит другой метод onOptionsItemSelected()
     @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // получим идентификатор выбранного пункта меню
         int id = item.getItemId();

         // Операции для выбранного пункта меню
         switch (id) {
             case R.id.action_settings:
                 showMessage("Вы выбрали пункт Настройки");

                 return true;
             case R.id.action_search:
                 showMessage("Вы выбрали Поиск");
                 return true;
             case R.id.action_exit:
                 showMessage("Вы выбрали Выход");
                 return true;
             default:
                 return super.onOptionsItemSelected(item);
         }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
