package com.example.ajedrezkaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class SingUpActivity extends AppCompatActivity {

    EditText edtPrimer,edtsegundo,edtEd,edtCorre,edtPass;
    Button btnRegistra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        edtPrimer = (EditText)findViewById(R.id.edtPrimerNombre);
        edtsegundo = (EditText)findViewById(R.id.editSegundoNombre);
        edtEd = (EditText)findViewById(R.id.edtEdad);
        edtCorre = (EditText)findViewById(R.id.edtCorreo);
        edtPass = (EditText)findViewById(R.id.edtPassword);
        //evento Click Boton Registrar
        btnRegistra = (Button)findViewById(R.id.btnIniciarSesion);
        btnRegistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServivio("http://192.168.0.3/LoginMySQL/insertar_persona.php");
            }
        });


    }

    private void ejecutarServivio(String Url){
        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //enviar a la otra actividad

                        Toast.makeText(SingUpActivity.this, "Registrado Correctamente", Toast.LENGTH_SHORT).show();

                        //Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                        //startActivityForResult(intent, 0);


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
                parametros.put("PrimerNombre",edtPrimer.getText().toString());
                parametros.put("SegundoNombre",edtsegundo.getText().toString());
                parametros.put("Edad",edtEd.getText().toString());
                parametros.put("Correo",edtCorre.getText().toString());
                parametros.put("Contrasena",edtPass.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(SingUpActivity.this);
        requestQueue.add(stringRequest);
    }


}