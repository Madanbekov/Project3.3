package com.example.project33;

import static com.example.project33.MainFragment.TEXT_KEY;
import static com.example.project33.MainFragment.TITLE_KEY;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FourFragment extends Fragment {
    private EditText etTitle4, etText4;
    private Button button_four;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etTitle4 = view.findViewById(R.id.ed_title4);
        etText4 = view.findViewById(R.id.ed_text4);
        button_four = view.findViewById(R.id.btn_pg4);
        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity =(MainActivity)requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();
                Fragment fragment = new FiveFragment();
                if (etTitle4.getText()!=null){
                    bundle.putString(TITLE_KEY,etTitle4.getText().toString());
                }
                if (etText4.getText()!=null){
                    bundle.putString(TEXT_KEY,etText4.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
        Bundle bundle = getArguments();
        if(bundle!=null){
            String title = bundle.getString(TITLE_KEY);
            etTitle4.setText(title);
        }
        if(bundle!=null){
            String title = bundle.getString(TEXT_KEY);
            etText4.setText(title);
        }
    }
}