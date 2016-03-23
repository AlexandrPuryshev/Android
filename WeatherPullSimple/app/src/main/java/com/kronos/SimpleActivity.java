package com.kronos;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import adapter.WeatherAdapter;
import data.SimpleWeatherForecast;
import data.Weather;

public class SimpleActivity extends AppCompatActivity {
    private static final String URL_STRING = "http://api.openweathermap.org/data/2.5/forecast?q=Yoshkar-Ola&mode=xml&appid=e66a53d8c8057ac9509efef0f5655206";

    private ListView lstView;
    private Button buttonSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        lstView = (ListView) findViewById(R.id.lstSimpleWeather);
        buttonSimple = (Button) findViewById(R.id.buttonSimple);

        buttonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ParseSimpleXML()).execute();
            }
        });
    }

    class ParseSimpleXML extends AsyncTask<Context, Void, Void>{
        private ArrayList<Weather> weatherList;

        @Override
        protected Void doInBackground(Context... params) {
            InputStream is = null;
            try {
                URL url = new URL(URL_STRING);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                is = connection.getInputStream();

                if (null != is) {
                    try{
                        weatherList = new ArrayList<Weather>();
                        Serializer serializer = new Persister();
                        SimpleWeatherForecast weatherForecast = serializer.read(SimpleWeatherForecast.class, is);

//                        for (SimpleWeatherForecast.Forecast.WeatherForecast forecast : weatherForecast.getForecast().getForecasts()){
//                            weatherList.add(new Weather(forecast.getTimeFrom(), forecast.getTimeTo(),
//                                    Double.parseDouble(forecast.getTemperature().getValue()), forecast.getTemperature().getUnit(),
//                                    Integer.parseInt(forecast.getHumidity().getValue()), forecast.getHumidity().getUnit()));
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try{
                    if (null != is){
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (null != lstView && null != weatherList){
                WeatherAdapter adapter = new WeatherAdapter(SimpleActivity.this, weatherList);
                lstView.setAdapter(adapter);
            }
        }
    }
}
