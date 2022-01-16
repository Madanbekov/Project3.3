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
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class SecondFragment extends Fragment {
    private EditText etTitle2, etText2;
    private Button button_two;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button_two = view.findViewById(R.id.btn_pg2);
        etTitle2 = view.findViewById(R.id.ed_title2);
        etText2 = view.findViewById(R.id.ed_text2);

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity =(MainActivity)requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();
                Fragment fragment = new ThirdFragment();
                if (etTitle2.getText()!=null){
                    bundle.putString(TITLE_KEY,etTitle2.getText().toString());
                }
                if (etText2.getText()!=null){
                    bundle.putString(TEXT_KEY,etText2.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(TITLE_KEY);
            etTitle2.setText(title);
        }
        if (bundle != null) {
            String title = bundle.getString(TEXT_KEY);
            etText2.setText(title);
        }
    }
}