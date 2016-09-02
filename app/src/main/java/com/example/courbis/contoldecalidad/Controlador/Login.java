package com.example.courbis.contoldecalidad.Controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.courbis.contoldecalidad.DB.AdminSQLiteOpenHelper;
import com.example.courbis.contoldecalidad.Modelo.modeloUsuario;

/**
 * Created by courbis on 31-08-16.
 */
public class Login {

    modeloUsuario mUsuario=new modeloUsuario();

    public void obtenerUsuario(String usuario, String pass){
        mUsuario.setRut(usuario);
        mUsuario.setPass(pass);

    }

    public void validarUsuario(Context context){

    AdminSQLiteOpenHelper adminSQLiteOpenHelper= new AdminSQLiteOpenHelper(context, "controlDeCalidad", null, 1);
        SQLiteDatabase dbw= adminSQLiteOpenHelper.getWritableDatabase();
        Cursor cursor=dbw.rawQuery("select pass from usuario where rut= '"+mUsuario.getRut()+"'", null);
        if (cursor.moveToFirst()){
            String passReal=cursor.getString(0);
            if (passReal.equals(mUsuario.getPass())){
                Toast.makeText(context, "Bienvenido",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,  "Usuario o contraseña invalido",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(context,"Usuario inexistente",Toast.LENGTH_SHORT).show();
        }


    }

    public void siguienteVentana(){

    }
}
