package com.example.project33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainFragment extends Fragment {

private TextInputEditText etTitle,etText;
public final static String TITLE_KEY ="key_title";
    public final static String TEXT_KEY ="key_text";

private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etText = view.findViewById(R.id.edText);
        etTitle = view.findViewById(R.id.ed_title_main);
        button = view.findViewById(R.id.btn_go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();
                Fragment fragment = new SecondFragment();
                if (etTitle.getText() != null) {
                    bundle.putString(TITLE_KEY, etTitle.getText().toString());
                }
                if (etText.getText() != null) {
                    bundle.putString(TEXT_KEY, etText.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
    }
 }
