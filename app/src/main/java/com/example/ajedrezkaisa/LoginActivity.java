package com.example.ajedrezkaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {




    TextView bienvenidoLabel, continuarLabel, nuevoUsuario;
    ImageView LogoImageView;

    EditText edtUsuario,edtPassword;
    Button btnLogin;
    TextView textRegistrar;
    String usuario,password,Correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LogoImageView = findViewById(R.id.LogoImageView);
        bienvenidoLabel = findViewById(R.id.bienvenidoLabel);
        continuarLabel = findViewById(R.id.continuarLabel);
        edtUsuario = findViewById(R.id.edtCorreo);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnIniciarSesion);
        nuevoUsuario = findViewById(R.id.textNuevoUsuario);



        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SingUpActivity.class);
                Pair[] pairs=new Pair[7];
                pairs[0] = new Pair<View, String>(LogoImageView, "logoImageTrans");
                pairs[1] = new Pair<View, String>(bienvenidoLabel, "textTrans");
                pairs[2] = new Pair<View, String>(continuarLabel, "iniciaSesionTextTrans");
                pairs[3] = new Pair<View, String>(edtUsuario, "emailInputTextTrans");
                pairs[4] = new Pair<View, String>(edtPassword, "passwordInputTextTrans");
                pairs[5] = new Pair<View, String>(btnLogin, "buttonSingInTrans");
                pairs[6] = new Pair<View, String>(nuevoUsuario, "newUserTrans");

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                }else{
                    startActivity(intent);
                    finish();
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario=edtUsuario.getText().toString();
                password=edtPassword.getText().toString();
                if(!usuario.isEmpty() && !password.isEmpty()) {


                    ValidarUsuario("http://192.168.0.107/loginMySQL/validar_usuario.php");
                }else{
                   Toast.makeText(LoginActivity.this, "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    private void ValidarUsuario(String URL){
        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override

                    public void onResponse(String response) {
                        //enviar a la otra actividad
                        String respuesta = ""+response;
                        if(respuesta.trim().equalsIgnoreCase("Ingresaste Correctamente") ) {
                            //enviar correo a la otra actividad
                            Correo = edtUsuario.getText().toString();
                            GlobalUsuario.Correo= Correo;
                            Intent intent = new Intent (getApplicationContext(), InicioActivity.class);
                            startActivityForResult(intent, 0);
                            Toast.makeText(LoginActivity.this, "Bienvenido"+respuesta, Toast.LENGTH_SHORT).show();

                            ///

                        } else {
                            Toast.makeText(LoginActivity.this, "Contraseña o Correo incorrecta"+respuesta, Toast.LENGTH_SHORT).show();
                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // En caso de tener algun error en la obtencion de los datos
                Toast.makeText(LoginActivity.this, "ERROR DE CONEXION", Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                // En este metodo se hace el envio de valores de la aplicacion al servidor
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", edtUsuario.getText().toString().trim());
                parametros.put("password", edtPassword.getText().toString().trim() );

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
    }
}