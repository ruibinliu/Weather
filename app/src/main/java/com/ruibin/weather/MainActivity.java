package com.ruibin.weather;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private static SparseArray<Bitmap> mWeatherIconCache = new SparseArray<Bitmap>();

    private RecyclerView mRecyclerView;
    private Weather mWeather;
    private String[] mCityList;
    private int mCurrentCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        mRecyclerView = (RecyclerView) findViewById(R.id.weather_list);
        getWeather();

        if (mCityList == null) {
            mCityList = getResources().getStringArray(R.array.city_list);
            mCurrentCity = 0;
        }

        setTitle(mCityList[mCurrentCity]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_switch_city: {
                switchCity();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchCity() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.switch_city);
        builder.setItems(mCityList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (mCurrentCity == which) return;

                mCurrentCity = which;
                setTitle(mCityList[mCurrentCity]);
                getWeather();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }

    private void getWeather() {
        new Thread() {
            @Override
            public void run() {
                try {
                    mWeather = WeatherApi.getWeather(mCityList[mCurrentCity]);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mRecyclerView.setAdapter(
                                    new SimpleItemRecyclerViewAdapter(mWeather));
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
            return weather.getForecast().length;
        }

        public Weather.Forecast getItem(int position) {
            return weather.getForecast()[position];
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final View mDawnLayout;
            public final View mDayLayout;
            public final TextView mTimeView;

            public final ImageView mDawnWeatherView;
            public final TextView mDawnTemperatureView;
            public final TextView mDawnWindDirectionView;
            public final TextView mDawnWindSpeedView;

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
                mDawnLayout = view.findViewById(R.id.dawnLayout);
                mDayLayout = view.findViewById(R.id.dayLayout);
                mTimeView = (TextView)view.findViewById(R.id.time);
                mDawnWeatherView = (ImageView) view.findViewById(R.id.dawn_weather);
                mDawnTemperatureView = (TextView) view.findViewById(R.id.dawn_temperature);
                mDawnWindDirectionView = (TextView) view.findViewById(R.id.dawn_wind_direction);
                mDawnWindSpeedView = (TextView) view.findViewById(R.id.dawn_wind_speed);
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
                Weather.Forecast item = getItem(position);

                mTimeView.setText(item.getDate());

                bindDawnView(item);
                bindDayView(item);
                bindNightView(item);
            }

            private void bindDawnView(Weather.Forecast item) {
                if (item.isDawnAvailable()) {
                    mDawnLayout.setVisibility(View.VISIBLE);
                    Integer icon = item.getDawnWeatherIcon();
                    if (icon != null) {
                        Bitmap bitmap = mWeatherIconCache.get(icon);
                        if (bitmap == null) {
                            InputStream is = getResources().openRawResource(icon);
                            bitmap = BitmapFactory.decodeStream(is);
                            mWeatherIconCache.put(icon, bitmap);
                        }
                        mDawnWeatherView.setImageBitmap(bitmap);
                    }
                    mDawnWeatherView.setBackgroundColor(Color.WHITE);
                    mDawnTemperatureView.setText(item.getDayTemperature() + "℃");
                    mDawnWindDirectionView.setText(item.getDayWindDirection());
                    mDawnWindSpeedView.setText(item.getDayWindSpeed());
                } else {
                    mDawnLayout.setVisibility(View.GONE);
                }
            }

            private void bindDayView(Weather.Forecast item) {
                if (item.isDayAvailable()) {
                    mDayLayout.setVisibility(View.VISIBLE);
                    Integer icon = item.getDayWeatherIcon();
                    if (icon != null) {
                        Bitmap bitmap = mWeatherIconCache.get(icon);
                        if (bitmap == null) {
                            InputStream is = getResources().openRawResource(icon);
                            bitmap = BitmapFactory.decodeStream(is);
                            mWeatherIconCache.put(icon, bitmap);
                        }
                        mDayWeatherView.setImageBitmap(bitmap);
                    }
                    mDayWeatherView.setBackgroundColor(Color.WHITE);
                    mDayTemperatureView.setText(item.getDayTemperature() + "℃");
                    mDayWindDirectionView.setText(item.getDayWindDirection());
                    mDayWindSpeedView.setText(item.getDayWindSpeed());
                } else {
                    mDayLayout.setVisibility(View.GONE);
                }
            }

            private void bindNightView(Weather.Forecast item) {
                Integer icon = item.getNightWeatherIcon();
                if (icon != null) {
                    Bitmap bitmap = mWeatherIconCache.get(icon);
                    if (bitmap == null) {
                        InputStream is = getResources().openRawResource(icon);
                        bitmap = BitmapFactory.decodeStream(is);
                        mWeatherIconCache.put(icon, bitmap);
                    }
                    mNightWeatherView.setImageBitmap(bitmap);
                }
                mNightWeatherView.setBackgroundColor(Color.WHITE);
                mNightTemperatureView.setText(item.getNightTemperature() + "℃");
                mNightWindDirectionView.setText(item.getNightWindDirection());
                mNightWindSpeedView.setText(item.getNightWindSpeed());
            }
        }
    }
}
