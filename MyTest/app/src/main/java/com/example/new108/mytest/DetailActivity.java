package com.example.new108.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by new108 on 2015-10-05.
 */
public class DetailActivity extends Activity {
    private TextView txtDtLon;
    private TextView txtDtLat;
    private TextView txtDtname;
    private TextView txtDtCloud;
    private TextView txtDtWind;
    private TextView txtDtTemp;
    private TextView txtDtHumidity;
    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDtLon = (TextView) findViewById(R.id.txtDtLon);
        txtDtLat = (TextView) findViewById(R.id.txtDtLat);
        txtDtname = (TextView) findViewById(R.id.txtDtname);
        txtDtCloud = (TextView) findViewById(R.id.txtDtCloud);
        txtDtWind = (TextView) findViewById(R.id.txtDtWind);
        txtDtTemp = (TextView) findViewById(R.id.txtDtTemp);
        txtDtHumidity = (TextView) findViewById(R.id.txtDtHumidity);
        txtShow = (TextView) findViewById(R.id.txtShow);

        txtShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 상세화면 이동  WebView
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), WebActivity.class);

                startActivity(intent);
            }
        });

        // Bundle에서 값을 얻음
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String strId = bundle.get("id").toString();
        String strName = bundle.get("name").toString();

        txtDtname.setText(strName);

        WeatherAsyncTask weatherAsyncTask = new WeatherAsyncTask();
        weatherAsyncTask.execute("http://api.openweathermap.org/data/2.5/weather?id=" + strId);

    }


    public class WeatherAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;

            String strResponse = null;

            try {
                Log.d("Params", params[0]);

                response = httpClient.execute(new HttpGet(params[0]));

                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    out.close();

                    strResponse = out.toString();
                } else {
                    response.getEntity().getContent().close();
                    throw new Exception(statusLine.getReasonPhrase());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return strResponse;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("MyAsyncTask", "s value is : " + s);
            // JSON object
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                LocationsWeather locationsWeather = objectMapper.readValue(s, LocationsWeather.class);
                Log.d("MyAsyncTask", "getName : " + locationsWeather.getName());
                Log.d("MyAsyncTask", "getWeather.length : " + locationsWeather.getWeather().length);
                Log.d("MyAsyncTask", "getDescription : " + locationsWeather.getWeather()[0].getDescription());
                Log.d("MyAsyncTask", "getSunset : " + locationsWeather.getSys().getSunset());

                // TODO : 화면에 출력
                txtDtLon.setText("Lon : " + locationsWeather.getCoord().getLon());
                txtDtLat.setText("Lat : " + locationsWeather.getCoord().getLat());
                txtDtCloud.setText(locationsWeather.getWeather()[locationsWeather.getWeather().length-1].getMain());
                txtDtWind.setText("Wind : " + locationsWeather.getWind().getSpeed());
                txtDtTemp.setText("Temp : " + locationsWeather.getMain().getTemp());
                txtDtHumidity.setText("Humidity : " + locationsWeather.getMain().getHumidity());


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
