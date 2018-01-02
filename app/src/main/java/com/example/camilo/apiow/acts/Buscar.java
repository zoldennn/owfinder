package com.example.camilo.apiow.acts;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camilo.apiow.R;

public class Buscar extends AppCompatActivity {

    TextView txtlogo;
    EditText user,n;
    Button btbuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        user = findViewById(R.id.user);
        n = findViewById(R.id.n);
        btbuscar = findViewById(R.id.btbuscar);

        txtlogo = findViewById(R.id.txtLogo);

        final Typeface type = Typeface.createFromAsset(getAssets(),"fonts/noodle.ttf");
        final Typeface t2 = Typeface.createFromAsset(getAssets(),"fonts/koverwatch.ttf");
        final Typeface arial = Typeface.createFromAsset(getAssets(),"fonts/arlan.TTF");

        btbuscar.setTypeface(type);
        txtlogo.setTypeface(type);
        user.setTypeface(t2);
        n.setTypeface(t2);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                typeText(user,arial,t2);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        n.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                typeText(n,arial,t2);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void buscar(View view)
    {
        String nombre = user.getText().toString();
        String num = n.getText().toString();
        if(nombre.equals("") || num.equals("")) {Toast.makeText(this, "Faltan datos por llenar!", Toast.LENGTH_LONG).show();}
        else {
            Intent i = new Intent(this, MainActivity.class);
            Bundle datos = new Bundle();
            datos.putString("nombre",nombre);
            datos.putString("num",num);
            i.putExtras(datos);
            startActivity(i);}
    }

    public void typeText(EditText text, Typeface letraescri, Typeface letravacia)
    {
        text.setAlpha(1);
        text.setTypeface(letraescri);
        if(text.getText().toString().equals("")) {
            text.setAlpha((float) 0.5);
            text.setTypeface(letravacia);}
    }
}
