package com.rp.petroute_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StartFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_fragment);
    }
    // switchWindow = Nos cambia de fragmento
    public void switchWindow(Fragment f){
        FragmentTransaction fTran = getSupportFragmentManager().beginTransaction();
        fTran.replace(R.id.fragmentContainerView,f);
        fTran.commit(); // Confirmación de cambio de vista
    }

}