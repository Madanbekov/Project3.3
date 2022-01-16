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


public class ThirdFragment extends Fragment {
    private EditText etTitle3, etText3;
    private Button button_tri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etTitle3 = view.findViewById(R.id.ed_title3);
        etText3 = view.findViewById(R.id.ed_text3);
        button_tri = view.findViewById(R.id.btn_pg3);
        button_tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity =(MainActivity)requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();
                Fragment fragment = new FourFragment();
                if (etTitle3.getText()!=null){
                    bundle.putString(TITLE_KEY,etTitle3.getText().toString());
                }
                if (etText3.getText()!=null){
                    bundle.putString(TEXT_KEY,etText3.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
        Bundle bundle = getArguments();
        if(bundle!=null){
            String title = bundle.getString(TITLE_KEY);
            etTitle3.setText(title);
        }
        if(bundle!=null){
            String title = bundle.getString(TEXT_KEY);
            etText3.setText(title);
        }
    }
}