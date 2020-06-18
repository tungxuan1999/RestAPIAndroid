package com.example.restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapi.Http.APIhttpurlconnect;
import com.example.restapi.Http.InterfaceAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements InterfaceAPI, View.OnClickListener {

    TextView txtResponse;
    EditText edtID,edtKind,edtHeight,edtWeight,edtSex,edtAge;
    Button btPost,btPatch,btPut,btGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Installize();

//        String data = "{\"A37\":{\"ID\":36,\"KIND\":\"ABCABC\",\"WEIGHT\":60,\"HEIGHT\":1.65,\"SEX\":\"Male\",\"AGE\":21}}";
//
//        AnimalClass animalClass = new AnimalClass(36,"ABCABC",5,6,"Male",21);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("A37",new JSONObject(new Gson().toJson(animalClass)));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        Log.d("asdasd",jsonObject.toString());

//        APIhttpurlconnect.HttpAPI(this,"https://demoblockchain.firebaseio.com/.json","PATCH",data);
    }

    void Installize(){
        txtResponse = findViewById(R.id.txt_response);

        edtAge = findViewById(R.id.edt_AGE);
        edtID = findViewById(R.id.edt_id);
        edtHeight = findViewById(R.id.edt_height);
        edtWeight = findViewById(R.id.edt_weight);
        edtSex = findViewById(R.id.edt_sex);
        edtKind = findViewById(R.id.edt_kind);

        btPatch = findViewById(R.id.bt_PATCH);
        btPost = findViewById(R.id.bt_POST);
        btPut = findViewById(R.id.bt_PUT);
        btGet = findViewById(R.id.bt_GET);

        btPost.setOnClickListener(this);
        btPatch.setOnClickListener(this);
        btPut.setOnClickListener(this);
        btGet.setOnClickListener(this);
    }

    String getData ()
    {
        String data = "";
        try{
            AnimalClass animalClass = new AnimalClass(
                    Integer.parseInt(edtID.getText().toString()),edtKind.getText().toString(),
                    Double.parseDouble(edtWeight.getText().toString()),Double.parseDouble(edtHeight.getText().toString()),
                    edtSex.getText().toString(),Integer.parseInt(edtAge.getText().toString())
            );

            JSONObject object = new JSONObject();
            object.put("A"+edtID.getText().toString(),new JSONObject(new Gson().toJson(animalClass)));
            data = object.toString();
        }catch (Exception ex)
        {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return data;
    }

    @Override
    public void ResponseURL(Boolean check, StringBuffer response) {
        if(check)
        {
            Log.d("AAA",response.toString());
            txtResponse.setText(response.toString());
        }
        else {
            Log.d("AAA","False");
            txtResponse.setText("Connect to false");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_PATCH:{
                APIhttpurlconnect.HttpAPI(this,"https://demoblockchain.firebaseio.com/.json","PATCH",getData());
            }break;
            case R.id.bt_PUT:{
                APIhttpurlconnect.HttpAPI(this,"https://demoblockchain.firebaseio.com/.json","PUT",getData());
            }break;
            case R.id.bt_POST:{
                APIhttpurlconnect.HttpAPI(this,"https://demoblockchain.firebaseio.com/.json","POST",getData());
            }break;
            case R.id.bt_GET:{
                APIhttpurlconnect.HttpAPI(this,"https://demoblockchain.firebaseio.com/.json","GET",null);
            }break;
        }
    }
}
