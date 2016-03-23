package com.kronos;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.WeatherAdapter;
import data.Weather;

public class PullActivity extends AppCompatActivity {
    private static final String URL_STRING =
            "http://api.openweathermap.org/data/2.5/forecast?q=Yoshkar-Ola&mode=xml&appid=e66a53d8c8057ac9509efef0f5655206";

    private ListView lstView;
    private Button buttonPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);

        lstView = (ListView) findViewById(R.id.lstPullWeather);
        buttonPull = (Button) findViewById(R.id.buttonPull);

        buttonPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ParsePullXML()).execute();
            }
        });

    }

    class ParsePullXML extends AsyncTask<Context, Void, Void>{
        private ArrayList<Weather> weatherList = new ArrayList<Weather>();

        @Override
        protected Void doInBackground(Context... params) {
            InputStream is = null;
            InputStreamReader isReader = null;
            try{
                URL url = new URL(URL_STRING);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                is = connection.getInputStream();

                if (null != is){
                    XmlPullParser parser = Xml.newPullParser();
                    isReader = new InputStreamReader(is);
                    parser.setInput(isReader);

//                    String weatherTimeFrom = "",
//                            weatherTimeTo = "",
//                            weatherTemperature = "",
//                            weatherTemperatureUnit = "",
//                            weatherHumidity = "",
//                            weatherHumUnit = "";

                    ArrayList<String> weatherData = new ArrayList<String>();
                    String tagName = "";

                    int eventType = parser.getEventType();
                    while (eventType != XmlPullParser.END_DOCUMENT
                            || (eventType != XmlPullParser.END_TAG
                            && !tagName.equalsIgnoreCase("current"))) {

                        tagName = parser.getName();

                        if (eventType == XmlPullParser.START_TAG){
                            if (tagName.equalsIgnoreCase("time")){
                                weatherData.add(0, parser.getAttributeValue(null, "from"));
                                weatherData.add(1, parser.getAttributeValue(null, "to"));

                                //weatherTimeFrom = parser.getAttributeValue(null, "from");
                                //weatherTimeTo = parser.getAttributeValue(null, "to");
                            } else if (tagName.equalsIgnoreCase("temperature")){
                                weatherData.add(2, parser.getAttributeValue(null, "value"));
                                weatherData.add(3, parser.getAttributeValue(null, "unit"));

//                                weatherTemperature = parser.getAttributeValue(null, "value");
//                                weatherTemperatureUnit = parser.getAttributeValue(null, "unit");
                            } else if (tagName.equalsIgnoreCase("humidity")){
                                weatherData.add(4, parser.getAttributeValue(null, "value"));
                                weatherData.add(5, parser.getAttributeValue(null, "unit"));

//                                weatherHumidity = parser.getAttributeValue(null, "value");
//                                weatherHumUnit = parser.getAttributeValue(null, "unit");
                            }
                        } else if (eventType == XmlPullParser.END_TAG){
                            if (tagName.equalsIgnoreCase("time")){
                                weatherList.add(new Weather(weatherData));
                            }
                        }

                        eventType = parser.next();
                    }
                }
            }
            catch (Exception mfe) {

            } finally {
                try {
                    if (null != is)
                        is.close();
                } catch (Exception e){}
                try {
                    if (null != isReader)
                        isReader.close();
                } catch (Exception e){}
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (null != lstView && null != weatherList){
                WeatherAdapter adapter = new WeatherAdapter(PullActivity.this, weatherList);
                lstView.setAdapter(adapter);
            }
        }
    }
}
