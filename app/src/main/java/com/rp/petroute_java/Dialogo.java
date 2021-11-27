package com.rp.petroute_java;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;


public class Dialogo {
    Dialog dialog;
    public boolean answerYes;

    public Dialogo(@Nullable Context context, String titulo, String text, View.OnClickListener onclicOK) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);
        TextView textTitle = dialog.findViewById(R.id.textView);
        TextView textDialog =  dialog.findViewById(R.id.textView2);
        textTitle.setText(titulo);
        textDialog.setText(text);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        Button cancel = dialog.findViewById(R.id.btn_cancel);
        Button okay = dialog.findViewById(R.id.btn_okay);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        okay.setOnClickListener(onclicOK);
        dialog.show();
    }
}

