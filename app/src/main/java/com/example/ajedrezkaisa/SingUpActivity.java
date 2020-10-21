package com.example.ajedrezkaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class SingUpActivity extends AppCompatActivity {

    EditText edtPrimer,edtsegundo,edtEd,edtCorre,edtPass,edtDoc;
    TextView nuevoUsuario;
    Button btnRegistra;
    boolean aux;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        edtPrimer = (EditText)findViewById(R.id.nameTextField);
        edtsegundo = (EditText)findViewById(R.id.lastnameTextField);
        edtEd = (EditText)findViewById(R.id.edad);
        edtDoc = (EditText)findViewById(R.id.docTextField);
        edtCorre = (EditText)findViewById(R.id.correoTextField);
        edtPass = (EditText)findViewById(R.id.contrasenaTextField);
        nuevoUsuario = findViewById(R.id.nuevoUsuario);
        //evento Click Boton Registrar
        btnRegistra = (Button)findViewById(R.id.inicioSesion);
        btnRegistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primero,segundo,edad,correo,password,doc;
                primero= edtPrimer.getText().toString();
                segundo= edtsegundo.getText().toString();
                edad= edtEd.getText().toString();
                correo= edtCorre.getText().toString();
                password= edtPass.getText().toString();
                doc = edtDoc.getText().toString();
                    if(primero.isEmpty() || segundo.isEmpty() || edad.isEmpty() || correo.isEmpty() || password.isEmpty() || doc.isEmpty()){
                        Toast.makeText(SingUpActivity.this, "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
                    }else if(password.length() <7 || password.length() > 10){
                        Toast.makeText(SingUpActivity.this, "La contraseña debe contener de 7 a 10 caracteres", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        ejecutarServivio("http://192.168.1.13/loginMySQL/insertar_persona.php");
                    }


            }
        });
        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingUpActivity.this, LoginActivity.class);

                    startActivity(intent);
                    finish();

            }
        });


    }

    private void ejecutarServivio(String Url){
        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String respuesta = ""+response;
                        if(respuesta.trim().equalsIgnoreCase("Correo Existente") ) {
                            Toast.makeText(SingUpActivity.this, "Correo Existente", Toast.LENGTH_SHORT).show();
                        }else {

                            Toast.makeText(SingUpActivity.this, "Registrado Correctamente", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent (getApplicationContext(), LoginActivity.class);
                            startActivityForResult(intent, 0);
                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SingUpActivity.this,error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("Nombre",edtPrimer.getText().toString());
                parametros.put("Apellido",edtsegundo.getText().toString());
                parametros.put("Edad",edtEd.getText().toString());
                parametros.put("Correo",edtCorre.getText().toString());
                parametros.put("Contrasena",edtPass.getText().toString());
                parametros.put("Documento",edtDoc.getText().toString());
                return parametros;
            }
        };
        requestQueue = Volley.newRequestQueue(SingUpActivity.this);
        requestQueue.add(stringRequest);
    }


}