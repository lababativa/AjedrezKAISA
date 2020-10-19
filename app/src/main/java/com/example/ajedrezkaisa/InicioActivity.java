package com.example.ajedrezkaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class InicioActivity extends AppCompatActivity {

    TextView labelnombre;
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnPlay = findViewById(R.id.btnPlay);
        //Creo instancia de la clase Global
       String email = GlobalUsuario.Correo.toString();

        BuscarSession("http://192.168.0.107/loginMySQL/Buscar_usuario.php?Correo="+email);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), Juego_Activity.class);
                startActivityForResult(intent, 0);
            }

        });
    }
    private void BuscarSession(String url) {
        labelnombre=(TextView)findViewById(R.id.lbPrimerNombre);
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override

            public void onResponse(JSONArray response) {
                JSONObject JsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JsonObject = response.getJSONObject(i);
                        labelnombre.setText(JsonObject.getString("PrimerNombre"));
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
        RequestQueue requestQueue = Volley.newRequestQueue(InicioActivity.this);
        requestQueue.add(jsonArrayRequest);
    }


}