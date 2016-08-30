package com.example.courbis.contoldecalidad;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.courbis.contoldecalidad.DB.AdminSQLiteOpenHelper;
import com.example.courbis.contoldecalidad.Modelo.modeloUsuario;

public class Controlador extends AppCompatActivity implements View.OnClickListener {
    //courbis ql 
    EditText edtUsuario;
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_login);
        edtUsuario=(EditText)findViewById(R.id.editTextUsuario);
        edtPass=(EditText)findViewById(R.id.editTextPass);
    }


    @Override
    public void onClick(View v) {
        Log.d("pruebaLogin","estoy aca");
        llenaBase();
        Login();
    }

    public void llenaBase(){

        AdminSQLiteOpenHelper adminSQLiteOpenHelper= new AdminSQLiteOpenHelper(this, "controlDeCalidad", null, 1);
        SQLiteDatabase dbw= adminSQLiteOpenHelper.getWritableDatabase();


        Log.d("pruebaBase","Estoy al principio de llenaBase");
        ContentValues registro= new ContentValues();
        registro.put("rut","1234567");
        registro.put("nombre","Julio");
        registro.put("apellido_paterno","Courbis");
        registro.put("apellido_materno","Palma");
        registro.put("pass","1234567");
        dbw.insert("usuario", null, registro);
        Log.d("pruebaBase","Estoy al final de llenaBase");


    }

    public void Login(){

        modeloUsuario mUsuario=new modeloUsuario();
        mUsuario.setRut(edtUsuario.getText().toString());
        mUsuario.setPass(edtPass.getText().toString());
        String compruebaPass = null;


        AdminSQLiteOpenHelper adminSQLiteOpenHelper= new AdminSQLiteOpenHelper(this, "controlDeCalidad", null, 1);
        SQLiteDatabase dbw= adminSQLiteOpenHelper.getWritableDatabase();
        Cursor fila= dbw.rawQuery("select pass from usuario where rut="+mUsuario.getRut(), null);
        if(fila.moveToFirst()){
            compruebaPass=fila.getString(0);

        }else{
            Toast.makeText(this,"usuario inexistente", Toast.LENGTH_SHORT).show();

        }
        dbw.close();


        if(mUsuario.getPass().equals(compruebaPass)){
            setContentView(R.layout.vista_tarea);
        }
    }


}
