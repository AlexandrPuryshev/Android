package com.kronos004.weatherpullsimple;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Data.City;
import Data.Weather;
import Data.Wind;

public class MainActivity extends AppCompatActivity {

    protected Button btnLoad;
    protected ListView listInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad     = (Button) findViewById(R.id.btnLoad);
        listInfo     = (ListView) findViewById(R.id.listView);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimplePullXml().execute();
            }
        });

    }


    public class SimplePullXml extends AsyncTask<Context, Void, Void> {
        protected static final String REQUEST_URL = "http://api.openweathermap.org/data/2.5/weather?q=Moscow&mode=xml&appid=44db6a862fba0b067b1930da0d769e98&units=metric";
        Weather weather = new Weather();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Void doInBackground(Context... params) {
            InputStream is = null;
            InputStreamReader reader = null;
            try {
                URL requestUrl = new URL(REQUEST_URL);
                HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
                is = connection.getInputStream();

                if (null != is) {
                    //parse
                    XmlPullParser parser = Xml.newPullParser();
                    reader = new InputStreamReader(is);
                    parser.setInput(reader);

                    City city = new City();
                    Wind wind = new Wind();

                    boolean doJob = true;
                    int event;
                    String name;

                    while (doJob) {
                        event = parser.next();
                        name = parser.getName();

                        if (((event == XmlPullParser.END_TAG) && (name.equalsIgnoreCase("current"))) || (event == XmlPullParser.END_DOCUMENT)) {
                            doJob = false;
                            break;
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("city"))) {
                            city.setName(parser.getAttributeValue(null, "name"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("coord"))) {
                            city.setLongitude(parser.getAttributeValue(null, "lon"));
                            city.setLatitude(parser.getAttributeValue(null, "lat"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("country"))) {
                            city.setCountry(parser.nextText());
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("sun"))) {
                            city.setSunRise(parser.getAttributeValue(null, "rise"));
                            city.setSunSet(parser.getAttributeValue(null, "set"));
                        } else if ((event == XmlPullParser.END_TAG) && (name.equalsIgnoreCase("city"))) {
                            weather.setCity(city);
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("temperature"))) {
                            weather.setTemperature(parser.getAttributeValue(null, "value"));
                            weather.setTemperatureMax(parser.getAttributeValue(null, "min"));
                            weather.setTemperatureMin(parser.getAttributeValue(null, "max"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("humidity"))) {
                            weather.setHumidity(parser.getAttributeValue(null, "value"));
                            weather.setHumidityUnit(parser.getAttributeValue(null, "unit"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("pressure"))) {
                            weather.setPressure(parser.getAttributeValue(null, "value"));
                            weather.setPressureUnit(parser.getAttributeValue(null, "unit"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("pressure"))) {
                            weather.setPressure(parser.getAttributeValue(null, "value"));
                            weather.setPressureUnit(parser.getAttributeValue(null, "unit"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("speed"))) {
                            wind.setSpeed(parser.getAttributeValue(null, "value"));
                            wind.setName(parser.getAttributeValue(null, "name"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("direction"))) {
                            wind.setDirection(parser.getAttributeValue(null, "value"));
                            wind.setDirectionName(parser.getAttributeValue(null, "name"));
                            wind.setCode(parser.getAttributeValue(null, "code"));
                        } else if ((event == XmlPullParser.END_TAG) && (name.equalsIgnoreCase("wind"))) {
                            weather.setWind(wind);
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("clouds"))) {
                            weather.setCloudsName(parser.getAttributeValue(null, "name"));
                            weather.setCloudsValue(parser.getAttributeValue(null, "value"));

                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("visibility"))) {
                            weather.setVisibilityValue(parser.getAttributeValue(null, "value"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("precipitation"))) {
                            weather.setPrecipitationValue(parser.getAttributeValue(null, "mode"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("weather"))) {
                            weather.setWeatherNumber(parser.getAttributeValue(null, "number"));
                            weather.setWeatherValue(parser.getAttributeValue(null, "value"));
                            weather.setWeatherIcon(parser.getAttributeValue(null, "icon"));
                        } else if ((event == XmlPullParser.START_TAG) && (name.equalsIgnoreCase("lastupdate"))) {
                            weather.setLastUpdate(parser.getAttributeValue(null, "value"));
                        }
                    }
                }

            } catch (Exception mfe) {

            } finally {
                try {
                    if (null != is)
                        is.close();
                } catch (Exception e){}
                try {
                    if (null != reader)
                        reader.close();
                } catch (Exception e){}
            }

            return null;
        }

        //BASE_ADAPTER;

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (null != listInfo) {
                listInfo.;
            }
        }
    }
}
