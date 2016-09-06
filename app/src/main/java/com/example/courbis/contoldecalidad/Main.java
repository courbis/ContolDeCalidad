package com.example.courbis.contoldecalidad;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courbis.contoldecalidad.Controlador.Login;
import com.example.courbis.contoldecalidad.DB.AdminSQLiteOpenHelper;
import com.example.courbis.contoldecalidad.Modelo.modeloUsuario;

public class Main extends AppCompatActivity implements View.OnClickListener {

    EditText edtUsuario;
    EditText edtPass;
    Button btnListo;
    TextView textViewUsuario;
    modeloUsuario mUsuario= new modeloUsuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_login);
        textViewUsuario=(TextView)findViewById(R.id.textViewUsuario);
        Typeface face=Typeface.createFromAsset(getAssets(),"Fonts/Roboto-Medium.ttf");
        textViewUsuario.setTypeface(face);
        Log.d("hola","estoy en onCreate");
        edtUsuario=(EditText)findViewById(R.id.editTextUsuario);
        edtPass=(EditText)findViewById(R.id.editTextPass);
        btnListo=(Button)findViewById(R.id.btnListo);
        btnListo.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Login login=new Login();
        login.obtenerUsuario(edtUsuario.getText().toString(),edtPass.getText().toString());
        login.validarUsuario(this);



    }

}
