package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kronos.R;

import java.util.ArrayList;

import data.Weather;

public class WeatherAdapter extends BaseAdapter{
    private LayoutInflater layoutInflater;
    ArrayList<Weather> objects;

    public WeatherAdapter(Context context, ArrayList<Weather> items){
        layoutInflater = LayoutInflater.from(context);
        objects = items;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == view){
            view = layoutInflater.inflate(R.layout.item_weather, parent, false);
        }

        Weather weather = objects.get(position);
        ((TextView) view.findViewById(R.id.lblDateTime)).setText(weather.getStringTime());
        ((TextView) view.findViewById(R.id.lblTemerature)).setText(weather.getStringTemperature());
        ((TextView) view.findViewById(R.id.lblHumidity)).setText(weather.getHumidityWithUnit());

        return view;
    }
}
