package com.example.fortism.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.fortism.Main4Activity;
import com.example.fortism.Main5Activity;
import com.example.fortism.Main6Activity;
import com.example.fortism.Main7Activity;
import com.example.fortism.Main8Activity;
import com.example.fortism.R;

public class SendFragment extends Fragment  implements View.OnClickListener{

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TextView know1,know2,know3,know4,know5;
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        //final TextView textView = root.findViewById(R.id.text_send);
        know1=root.findViewById(R.id.k1);
        know2=root.findViewById(R.id.k2);
        know3=root.findViewById(R.id.k3);
        know4=root.findViewById(R.id.k4);
        know5=root.findViewById(R.id.k5);
        know5.setOnClickListener(this);
        know1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main4Activity.class);
                startActivity(intent);
            }
        });

        know2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main5Activity.class);
                startActivity(intent);
            }
        });
        know3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main6Activity.class);
                startActivity(intent);
            }
        });

        know4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main7Activity.class);
                startActivity(intent);
            }
        });
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Main8Activity.class);
        startActivity(intent);

    }
}