package fb.fandroid.adv.courseproject2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by andrew on 26.05.2018.
 * Фрагмент для вывода окна браузера
 * Браузеру передается строка поиска для 1 из 3 поисковых машин(Гугл,Яндекс,Бинг)
 * выбранных во фрагменте настроек
 *
 */

public class SearchFragment extends Fragment {

    private Button mbuttonSearch;
    private EditText mEditTextOne;


    public static SearchFragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fr_search, container, false);
        mbuttonSearch = view.findViewById(R.id.buttonSearch);
        mEditTextOne = view.findViewById(R.id.etOne);
        mbuttonSearch.setOnClickListener(buttonSearchListener);
        return view;
    }

    /*

     */
    private int LoadSharedPreferences() {
        int CheckedIndex = SharedPreferencesHelper.getSessionId(getContext());
        return CheckedIndex;
    }

    //ниже 2 вспомогательные функции
    //вывод всплвающей подсказки
    private void showMessage(String string) {
        Toast.makeText(getContext(), string, Toast.LENGTH_LONG).show();
    }

    //проверка на пустоту текста
    private boolean IsEditTextEmpty() {
        return !TextUtils.isEmpty(mEditTextOne.getText());
    }


    /* обработчик события нажатия на экранную кнопку здесь происходит запуск поисковой машины
     в соответствии с сохраненными настройками

    Google  "http://google.com/search?q="+SearchTerm
    Yandex  "https://yandex.ru/search/?text="+SearchTerm
    Bing    "https://www.bing.com/search?q="+SearchTerm

    */

    private final Button.OnClickListener buttonSearchListener = new Button.OnClickListener() {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {

            if (IsEditTextEmpty()) {////если текст в EditText присутсвует то запуск процедуры поиска
                /// иначе выдает подсказку на экран

                switch (LoadSharedPreferences()) {


                    case 0: //Google index

                        Uri uri = Uri.parse("http://google.com/search?q=" + mEditTextOne.getText());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        getActivity().finish();
                        break;
                    case 1: //Yandex index
                         Uri uri1 = Uri.parse("https://yandex.ru/search/?text=" + mEditTextOne.getText());
                        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
                        startActivity(intent1);
                        getActivity().finish();

                        break;

                    case 2: //Bing index
                        Uri uri2 = Uri.parse("https://www.bing.com/search?q=" + mEditTextOne.getText());
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        startActivity(intent2);
                        getActivity().finish();
                        break;
                }


            } else showMessage("текстовое поле  c критерием поиска не должно быть пустым");


        }

        ;
    };
}
