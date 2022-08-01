package dev.abhishektiwari.phpapirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    TextView textView;

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    ArrayList<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        models = new ArrayList<>( );

//        textView = findViewById(R.id.textView);

        String url = "http://192.168.72.183/getusers.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray jsonArray = response.getJSONArray("data" );
                            System.out.println("dt " +jsonArray );


                            for(int i = 0; i< jsonArray.length(); i++) {

//                                JSONObject jsonObject = response.getJSONObject(String.valueOf(i));

                                JSONObject jsonObject = jsonArray.getJSONObject(i );

                                String name = jsonObject.getString("name" );
                                String email = jsonObject.getString("email" );
                                String post = jsonObject.getString("post" );

                                System.out.println("name " +name );
                                System.out.println("email " +email );
                                System.out.println("post " +post );

                                Model model = new Model( );
                                model.setId(jsonObject.getString("id"));
                                model.setName(jsonObject.getString("name"));
                                model.setEmail(jsonObject.getString("email"));
                                model.setPost(jsonObject.getString("post"));
                                models.add(model);
                            }

                            mainAdapter = new MainAdapter(MainActivity.this, models);

                            recyclerView.setAdapter(mainAdapter);




                        } catch (Exception e) {
                            e.printStackTrace( );
                        }                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);



    }
}