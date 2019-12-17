package com.example.work_11;

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
    private ProgressDialog pDialog;
    private static final String userId = "userId";
    private static final String id = "id";
    private static final String title = "title";
    private static final String body = "body";

    private static final String NEW_LINE = "\n\n";
    private String array_url = "https://jsonplaceholder.typicode.com/posts";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);
        Button buttonArray = (Button) findViewById(R.id.btnArray);

        buttonArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLoader();
                loadJsonArray();
            }
        });
    }
    private void displayLoader(){
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }


    private void loadJsonArray() {
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, array_url, null, new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray responseArray) {
                        pDialog.dismiss();
                        try {
                            StringBuilder textViewData = new StringBuilder();
                            //Parse the JSON response array by iterating over it
                            for (int i = 0; i < responseArray.length(); i++) {
                                JSONObject response = null;
                                response = responseArray.getJSONObject(i);

                                Integer UserId = response.getInt(userId);
                                String Id = response.getString(id);
                                String Title = response.getString(title);
                                String Body = response.getString(body);


                                //Create String out of the Parsed JSON

                                textViewData.append("User Id: ")
                                        .append(UserId.toString()).append(NEW_LINE);
                                textViewData.append("id: ").append(Id).append(NEW_LINE);
                                textViewData.append("title: ").append(Title).append(NEW_LINE);
                                textViewData.append("body: ").append(Body).append(NEW_LINE);

                                textViewData.append(NEW_LINE);
                            }

                            //Populate textView with the response
                            mTxtDisplay.setText(textViewData.toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }
}
