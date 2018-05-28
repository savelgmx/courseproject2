package fb.fandroid.adv.courseproject2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/*
Абстактный класс базовый для всех трех фрагментов данного приложения
На его основе может быть произвольноее число фрагментов
Инициализирует контейнер для фрагментов в методе OnCreate
Заканчивает работу приложения если Back button pressed и если нет другой активити/фрагмента
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, getFragment())
                    .commit();
        }

    }

    protected abstract Fragment getFragment();

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
         if (fragmentManager.getBackStackEntryCount() == 0) {
            finish();
        } else {
            fragmentManager.popBackStack();

        }
    }

}
