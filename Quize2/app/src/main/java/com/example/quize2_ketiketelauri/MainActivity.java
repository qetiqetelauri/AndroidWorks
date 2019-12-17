package com.example.quize2_ketiketelauri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtDisplay;
    private TextView idtext;
    private ProgressDialog pDialog;
    private static final String userId = "userId";
    private static final String id = "id";
    private static final String title = "title";
    private static final String completed = "completed";

    private static final String NEW_LINE = "\n\n";
    private String array_url = "https://jsonplaceholder.typicode.com/todos";
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);
        Button buttonArray = (Button) findViewById(R.id.btnArray);
        Button buttonArrayAdd = (Button) findViewById(R.id.btnArrayAdd);
        Button buttonAdd = (Button) findViewById(R.id.btnAdd);
        Button buttonGet = (Button) findViewById(R.id.btnGet);
        buttonArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadJsonArray();
            }
        });
        buttonArrayAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddJson();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadJsonArray();
            }
        });
        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Get();
            }
        });
    }
    private void Get() {
        idtext = (TextView) findViewById(R.id.ID_edittext);
        String id = (String) idtext.getText();

    }


    private void AddJson() {
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, array_url, null, new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray responseArray) {
                        pDialog.dismiss();
                        try {
                            StringBuilder textViewData = new StringBuilder();
                            int number=responseArray.length();

                            for (int i = 0; i < responseArray.length(); i++) {
                                JSONObject response = null;
                                response = responseArray.getJSONObject(i);

                                Integer UserId = response.getInt(userId);
                                String Id = response.getString(id);
                                String Title = response.getString(title);
                                String Completed = response.getString(completed);



                                dbManager.insert(Title,Completed,UserId);
                        }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();


                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });




    }



    private void loadJsonArray() {
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, array_url, null, new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray responseArray) {
                        pDialog.dismiss();
                        try {
                            StringBuilder textViewData = new StringBuilder();
                            int number=responseArray.length();
                            if(number>50){
                                number=50;
                            }
                            for (int i = 0; i < number; i++) {
                                JSONObject response = null;
                                response = responseArray.getJSONObject(i);

                                Integer UserId = response.getInt(userId);
                                String Id = response.getString(id);
                                String Title = response.getString(title);
                                String Completed = response.getString(completed);




                                textViewData.append("User Id: ")
                                        .append(UserId.toString()).append(NEW_LINE);
                                textViewData.append("id: ").append(Id).append(NEW_LINE);
                                textViewData.append("title: ").append(Title).append(NEW_LINE);
                                textViewData.append("Completed: ").append(Completed).append(NEW_LINE);

                                textViewData.append(NEW_LINE);
                            }


                            mTxtDisplay.setText(textViewData.toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();


                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }
}
