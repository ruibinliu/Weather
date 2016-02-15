package com.ruibin.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Weather mWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        mRecyclerView = (RecyclerView) findViewById(R.id.weather_list);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        new Thread() {
            @Override
            public void run() {
                try {
                    mWeather = WeatherApi.getWeather();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mRecyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(mWeather));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final Weather weather;

        public SimpleItemRecyclerViewAdapter(Weather weather) {
            this.weather = weather;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.weather_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.bind(position);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, NewsDetailActivity.class);
//                    intent.putExtra(NewsDetailFragment.ARG_ITEM_ID, holder.mItem.id);
//
//                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return weather.getForecastList().size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final View mDayLayout;
            public final TextView mTimeView;
            public final ImageView mDayWeatherView;
            public final TextView mDayTemperatureView;
            public final TextView mDayWindDirectionView;
            public final TextView mDayWindSpeedView;
            public final ImageView mNightWeatherView;
            public final TextView mNightTemperatureView;
            public final TextView mNightWindDirectionView;
            public final TextView mNightWindSpeedView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mDayLayout = view.findViewById(R.id.dayLayout);
                mTimeView = (TextView)view.findViewById(R.id.time);
                mDayWeatherView = (ImageView) view.findViewById(R.id.day_weather);
                mDayTemperatureView = (TextView) view.findViewById(R.id.day_temperature);
                mDayWindDirectionView = (TextView) view.findViewById(R.id.day_wind_direction);
                mDayWindSpeedView = (TextView) view.findViewById(R.id.day_wind_speed);
                mNightWeatherView = (ImageView) view.findViewById(R.id.night_weather);
                mNightTemperatureView = (TextView) view.findViewById(R.id.night_temperature);
                mNightWindDirectionView = (TextView) view.findViewById(R.id.night_wind_direction);
                mNightWindSpeedView = (TextView) view.findViewById(R.id.night_wind_speed);
            }

            public void bind(int position) {
                Weather.Forecast item = weather.getForecastList().get(position);

                switch (position % 3) {
                    case 0:
                        mTimeView.setText(R.string.today);
                        break;
                    case 1:
                        mTimeView.setText(R.string.tomorrow);
                        break;
                    case 2:
                        mTimeView.setText(R.string.after);
                        break;
                }

                if (item.isDayForecastAvailable()) {
                    mDayLayout.setVisibility(View.VISIBLE);
                    mDayWeatherView.setImageResource(item.getDayWeatherIcon());
                    mDayTemperatureView.setText(item.getDayTemperature() + "℃");
                    mDayWindDirectionView.setText(item.getDayWindDirection());
                    mDayWindSpeedView.setText(item.getDayWindSpeed());
                } else {
                    mDayLayout.setVisibility(View.GONE);
                }

                mNightWeatherView.setImageResource(item.getNightWeatherIcon());
                mNightTemperatureView.setText(item.getNightTemperature() + "℃");
                mNightWindDirectionView.setText(item.getNightWindDirection());
                mNightWindSpeedView.setText(item.getNightWindSpeed());
            }
        }
    }
}
