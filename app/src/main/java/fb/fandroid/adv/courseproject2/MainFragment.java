package fb.fandroid.adv.courseproject2;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 07.05.2018.
 */

public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;

    }

    private void showMessage(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }
/*проверка доступности Internet соединения*/
public static boolean isOnline(Context context)
{
    ConnectivityManager cm =
            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnectedOrConnecting())
    {
        return true;
    }
    return false;
}


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       /*Добавляем метод, который берёт данные из ресурсов меню
       и преобразует их в пункты меню на экране.
       По английски "inflate" переводится как надувать,
       т.е. по замыслу разработчиков Android, мы как бы надуваем данными объект, например, меню.
       Но на самом деле слово "inflate" происходит от словосочетания in flat - в квартиру.
       Существует старинная традиция запускать в квартиру первым кота,
       который исследует все закоулки дома и заявляет о своём согласии жить в нём.
       Так и мы запускаем данные из XML-файла в объект MenuInflater.
        */
        inflater.inflate(R.menu.menu_main, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_settings:
               // showMessage("Вы выбрали пункт Настройки");

                //---launch settings fragment----

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, SettingsFragment.newInstance())
                        .addToBackStack(SettingsFragment.class.getName())
                        .commit();
                //----end of launch transaction+-


                return true;
            case R.id.action_search:
                //showMessage("Вы выбрали Поиск");
                    if( isOnline(getContext())) {
                        Uri uri = Uri.parse("http://google.com/search?q=haruhi");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        getActivity().finish();
                    } else showMessage("Доступ в интернет отсутствует");

                return true;
            case R.id.action_exit:
                showMessage("Вы выбрали Выход");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.fr_main, container, false);
        return view;
    }

}
