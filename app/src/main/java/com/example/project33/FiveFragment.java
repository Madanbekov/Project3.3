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


public class FiveFragment extends Fragment {
    private EditText etTitle5, etText5;
    private Button button_five;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_five, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etTitle5 = view.findViewById(R.id.ed_title5);
        etText5 = view.findViewById(R.id.ed_text5);
        button_five = view.findViewById(R.id.btn_pg5);
        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity =(MainActivity)requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();
                Fragment fragment = new FiveFragment();
                if (etTitle5.getText()!=null){
                    bundle.putString(TITLE_KEY,etTitle5.getText().toString());
                }
                if (etText5.getText()!=null){
                    bundle.putString(TEXT_KEY,etText5.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
        Bundle bundle = getArguments();
        if(bundle!=null){
            String title = bundle.getString(TITLE_KEY);
            etTitle5.setText(title);
        }
        if(bundle!=null){
            String title = bundle.getString(TEXT_KEY);
            etText5.setText(title);
        }
    }
}