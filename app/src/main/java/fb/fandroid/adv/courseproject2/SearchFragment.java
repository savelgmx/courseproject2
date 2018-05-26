package fb.fandroid.adv.courseproject2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by andrew on 26.05.2018.
 */

public class SearchFragment extends Fragment {

    private Button mbuttonSearch;
    private EditText mEditTextOne;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fr_search, container, false);
    return view;
    }

   // private view.

}
