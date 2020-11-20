package com.example.ajedrezkaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.ProgressDialog;
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

public class PerfilActivity extends AppCompatActivity {
    TextView docText;
    EditText edtPrimer,edtsegundo,edtEd,edtCorre,edtPass;
    EditText nameText, lastnametext,edadtext, correotext;
    Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        String email = GlobalUsuario.Correo.toString();

        BuscarSession("http://192.168.1.13/loginMySQL/Buscar_usuario.php?Correo="+email);
        //BuscarSession("http://192.168.1.13/loginMySQL/adaptador.php");
        edtPrimer = (EditText)findViewById(R.id.nameTextField);
        edtsegundo = (EditText)findViewById(R.id.lastnameTextField);
        edtEd = (EditText)findViewById(R.id.edad);
        docText = (TextView)findViewById(R.id.docTextField);
        edtCorre = (EditText)findViewById(R.id.correoTextField);
        edtPass = (EditText)findViewById(R.id.contrasenaTextField);

        btnActualizar =(Button)findViewById(R.id.guardarCambio);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String primero,segundo,edad,correo,password,doc;
                 primero= edtPrimer.getText().toString();
                 segundo= edtsegundo.getText().toString();
                 edad= edtEd.getText().toString();
                 correo= edtCorre.getText().toString();
                 doc = docText.getText().toString();
                 if(primero.isEmpty() || segundo.isEmpty() || edad.isEmpty() || correo.isEmpty() || doc.isEmpty()){
                     Toast.makeText(PerfilActivity.this, "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     ejecutarServivio("http://192.168.1.13/loginMySQL/Actualizar_datos.php");
                 }
             }
         }

        );

    }
    private void BuscarSession(String url) {
        docText=(TextView)findViewById(R.id.docTextField);
        nameText=(EditText)findViewById(R.id.nameTextField);
        lastnametext=(EditText)findViewById(R.id.lastnameTextField);
        edadtext=(EditText)findViewById(R.id.edad);
        correotext=(EditText)findViewById(R.id.correoTextField);
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override

            public void onResponse(JSONArray response) {
                JSONObject JsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JsonObject = response.getJSONObject(i);
                        docText.setText(JsonObject.getString("Documento"));
                        nameText.setText(JsonObject.getString("Nombre"));
                        lastnametext.setText(JsonObject.getString("Apellido"));
                        correotext.setText(JsonObject.getString("Correo"));
                        edadtext.setText(JsonObject.getString("Edad"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error De Conexion",Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(PerfilActivity.this);
        requestQueue.add(jsonArrayRequest);
    }

    private void ejecutarServivio(String Url){
        final String nombre = nameText.getText().toString();
        final String apellido = lastnametext.getText().toString();
        final String correo = correotext.getText().toString();
        final String edad = edadtext.getText().toString();
        final String doc = docText.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.13/loginMySQL/Actualizar_datos.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(PerfilActivity.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),InicioActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(PerfilActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("Nombre",nombre);
                parametros.put("Apellido",apellido);
                parametros.put("Edad",edad);
                parametros.put("Correo",correo);
                parametros.put("Documento",doc);


                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(PerfilActivity.this);
        requestQueue.add(request);

    }
}