package com.ruibin.weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Weather {
    private static final HashMap<String, Integer> WEATHER_DAY_ICON_MAP = new HashMap<>();
    private static final HashMap<String, Integer> WEATHER_NIGHT_ICON_MAP = new HashMap<>();
    private static final HashMap<String, String> WIND_DIRECTION_MAP = new HashMap<>();
    private static final HashMap<String, String> WIND_SPEED_MAP = new HashMap<>();

    static {
        WEATHER_DAY_ICON_MAP.put("0", R.mipmap.weather_day_00);
        WEATHER_DAY_ICON_MAP.put("1", R.mipmap.weather_day_01);
        WEATHER_DAY_ICON_MAP.put("2", R.mipmap.weather_day_02);
        WEATHER_DAY_ICON_MAP.put("3", R.mipmap.weather_day_03);
        WEATHER_DAY_ICON_MAP.put("4", R.mipmap.weather_day_04);
        WEATHER_DAY_ICON_MAP.put("5", R.mipmap.weather_day_05);
        WEATHER_DAY_ICON_MAP.put("6", R.mipmap.weather_day_06);
        WEATHER_DAY_ICON_MAP.put("7", R.mipmap.weather_day_07);
        WEATHER_DAY_ICON_MAP.put("8", R.mipmap.weather_day_08);
        WEATHER_DAY_ICON_MAP.put("9", R.mipmap.weather_day_09);
        WEATHER_DAY_ICON_MAP.put("10", R.mipmap.weather_day_10);
        WEATHER_DAY_ICON_MAP.put("11", R.mipmap.weather_day_11);
        WEATHER_DAY_ICON_MAP.put("12", R.mipmap.weather_day_12);
        WEATHER_DAY_ICON_MAP.put("13", R.mipmap.weather_day_13);
        WEATHER_DAY_ICON_MAP.put("14", R.mipmap.weather_day_14);
        WEATHER_DAY_ICON_MAP.put("15", R.mipmap.weather_day_15);
        WEATHER_DAY_ICON_MAP.put("16", R.mipmap.weather_day_16);
        WEATHER_DAY_ICON_MAP.put("17", R.mipmap.weather_day_17);
        WEATHER_DAY_ICON_MAP.put("18", R.mipmap.weather_day_18);
        WEATHER_DAY_ICON_MAP.put("19", R.mipmap.weather_day_19);
        WEATHER_DAY_ICON_MAP.put("20", R.mipmap.weather_day_20);
        WEATHER_DAY_ICON_MAP.put("21", R.mipmap.weather_day_21);
        WEATHER_DAY_ICON_MAP.put("22", R.mipmap.weather_day_22);
        WEATHER_DAY_ICON_MAP.put("23", R.mipmap.weather_day_23);
        WEATHER_DAY_ICON_MAP.put("24", R.mipmap.weather_day_24);
        WEATHER_DAY_ICON_MAP.put("25", R.mipmap.weather_day_25);
        WEATHER_DAY_ICON_MAP.put("26", R.mipmap.weather_day_26);
        WEATHER_DAY_ICON_MAP.put("27", R.mipmap.weather_day_27);
        WEATHER_DAY_ICON_MAP.put("28", R.mipmap.weather_day_28);
        WEATHER_DAY_ICON_MAP.put("29", R.mipmap.weather_day_29);
        WEATHER_DAY_ICON_MAP.put("30", R.mipmap.weather_day_30);
        WEATHER_DAY_ICON_MAP.put("31", R.mipmap.weather_day_31);
        WEATHER_DAY_ICON_MAP.put("53", R.mipmap.weather_day_53);

        WEATHER_NIGHT_ICON_MAP.put("0", R.mipmap.weather_night_00);
        WEATHER_NIGHT_ICON_MAP.put("1", R.mipmap.weather_night_01);
        WEATHER_NIGHT_ICON_MAP.put("2", R.mipmap.weather_night_02);
        WEATHER_NIGHT_ICON_MAP.put("3", R.mipmap.weather_night_03);
        WEATHER_NIGHT_ICON_MAP.put("4", R.mipmap.weather_night_04);
        WEATHER_NIGHT_ICON_MAP.put("5", R.mipmap.weather_night_05);
        WEATHER_NIGHT_ICON_MAP.put("6", R.mipmap.weather_night_06);
        WEATHER_NIGHT_ICON_MAP.put("7", R.mipmap.weather_night_07);
        WEATHER_NIGHT_ICON_MAP.put("8", R.mipmap.weather_night_08);
        WEATHER_NIGHT_ICON_MAP.put("9", R.mipmap.weather_night_09);
        WEATHER_NIGHT_ICON_MAP.put("10", R.mipmap.weather_night_10);
        WEATHER_NIGHT_ICON_MAP.put("11", R.mipmap.weather_night_11);
        WEATHER_NIGHT_ICON_MAP.put("12", R.mipmap.weather_night_12);
        WEATHER_NIGHT_ICON_MAP.put("13", R.mipmap.weather_night_13);
        WEATHER_NIGHT_ICON_MAP.put("14", R.mipmap.weather_night_14);
        WEATHER_NIGHT_ICON_MAP.put("15", R.mipmap.weather_night_15);
        WEATHER_NIGHT_ICON_MAP.put("16", R.mipmap.weather_night_16);
        WEATHER_NIGHT_ICON_MAP.put("17", R.mipmap.weather_night_17);
        WEATHER_NIGHT_ICON_MAP.put("18", R.mipmap.weather_night_18);
        WEATHER_NIGHT_ICON_MAP.put("19", R.mipmap.weather_night_19);
        WEATHER_NIGHT_ICON_MAP.put("20", R.mipmap.weather_night_20);
        WEATHER_NIGHT_ICON_MAP.put("21", R.mipmap.weather_night_21);
        WEATHER_NIGHT_ICON_MAP.put("22", R.mipmap.weather_night_22);
        WEATHER_NIGHT_ICON_MAP.put("23", R.mipmap.weather_night_23);
        WEATHER_NIGHT_ICON_MAP.put("24", R.mipmap.weather_night_24);
        WEATHER_NIGHT_ICON_MAP.put("25", R.mipmap.weather_night_25);
        WEATHER_NIGHT_ICON_MAP.put("26", R.mipmap.weather_night_26);
        WEATHER_NIGHT_ICON_MAP.put("27", R.mipmap.weather_night_27);
        WEATHER_NIGHT_ICON_MAP.put("28", R.mipmap.weather_night_28);
        WEATHER_NIGHT_ICON_MAP.put("29", R.mipmap.weather_night_29);
        WEATHER_NIGHT_ICON_MAP.put("30", R.mipmap.weather_night_30);
        WEATHER_NIGHT_ICON_MAP.put("31", R.mipmap.weather_night_31);
        WEATHER_NIGHT_ICON_MAP.put("53", R.mipmap.weather_night_53);

        WIND_DIRECTION_MAP.put("0", "无持续风向");
        WIND_DIRECTION_MAP.put("1", "东北风");
        WIND_DIRECTION_MAP.put("2", "东风");
        WIND_DIRECTION_MAP.put("3", "东南风");
        WIND_DIRECTION_MAP.put("4", "南风");
        WIND_DIRECTION_MAP.put("5", "西南风");
        WIND_DIRECTION_MAP.put("6", "西风");
        WIND_DIRECTION_MAP.put("7", "西北风");
        WIND_DIRECTION_MAP.put("8", "北风");
        WIND_DIRECTION_MAP.put("9", "旋转风");

        WIND_SPEED_MAP.put("0", "微风(<10千米每小时)");
        WIND_SPEED_MAP.put("1", "3-4级(10~17千米每小时)");
        WIND_SPEED_MAP.put("2", "4-5级(17~25千米每小时)");
        WIND_SPEED_MAP.put("3", "5-6级(25~34千米每小时)");
        WIND_SPEED_MAP.put("4", "6-7级(34~43千米每小时)");
        WIND_SPEED_MAP.put("5", "7-8级(43~54千米每小时)");
        WIND_SPEED_MAP.put("6", "8-9级(54~65千米每小时)");
        WIND_SPEED_MAP.put("7", "9-10级(65~77千米每小时)");
        WIND_SPEED_MAP.put("8", "10-11级(77~89千米每小时)");
        WIND_SPEED_MAP.put("9", "11-12级(89~102千米每小时)");
    }

    private String reason;
    private Result result;
    private String errorCode;

    public Weather() {
    }

    public Weather(JSONObject jsonObject) throws JSONException {
        result = new Result();
        result.data = new Data();
        JSONObject jsonResult = jsonObject.getJSONObject("result");
        JSONObject jsonData = jsonResult.getJSONObject("data");
        JSONArray jsonWeather = jsonData.getJSONArray("weather");
        int length = jsonWeather.length();
        result.data.weather = new Forecast[length];
        for (int i = 0; i < length; i++) {
            JSONObject jsonWeatherObject = jsonWeather.getJSONObject(i);

            result.data.weather[i] = new Forecast();
            result.data.weather[i].date = jsonWeatherObject.getString("date");

            JSONObject jsonInfoObject = jsonWeatherObject.getJSONObject("info");
            result.data.weather[i].info = new Forecast.Info();
            try {
                JSONArray jsonDawnForecast = jsonInfoObject.getJSONArray("dawn");
                result.data.weather[i].info.dawn = new String[jsonDawnForecast.length()];
                result.data.weather[i].info.dawn[0]
                        = jsonDawnForecast.getString(0); // 天气ID
                result.data.weather[i].info.dawn[1]
                        = jsonDawnForecast.getString(1); // 天气文字
                result.data.weather[i].info.dawn[2]
                        = jsonDawnForecast.getString(2); // 气温
                result.data.weather[i].info.dawn[3]
                        = jsonDawnForecast.getString(3); // 风向
                result.data.weather[i].info.dawn[4]
                        = jsonDawnForecast.getString(4); // 风力
            } catch (JSONException e) {
            }
            try {
                JSONArray jsonDayForecast = jsonInfoObject.getJSONArray("day");
                result.data.weather[i].info.day = new String[jsonDayForecast.length()];
                result.data.weather[i].info.day[0]
                        = jsonDayForecast.getString(0); // 天气ID
                result.data.weather[i].info.day[1]
                        = jsonDayForecast.getString(1); // 天气文字
                result.data.weather[i].info.day[2]
                        = jsonDayForecast.getString(2); // 气温
                result.data.weather[i].info.day[3]
                        = jsonDayForecast.getString(3); // 风向
                result.data.weather[i].info.day[4]
                        = jsonDayForecast.getString(4); // 风力
            } catch (JSONException e) {
            }
            try {
                JSONArray jsonNightForecast = jsonInfoObject.getJSONArray("night");
                result.data.weather[i].info.night = new String[jsonNightForecast.length()];
                result.data.weather[i].info.night[0]
                        = jsonNightForecast.getString(0); // 天气ID
                result.data.weather[i].info.night[1]
                        = jsonNightForecast.getString(1); // 天气文字
                result.data.weather[i].info.night[2]
                        = jsonNightForecast.getString(2); // 气温
                result.data.weather[i].info.night[3]
                        = jsonNightForecast.getString(3); // 风向
                result.data.weather[i].info.night[4]
                        = jsonNightForecast.getString(4); // 风力
            } catch (JSONException e) {
            }
        }
    }

    static class Result {
        private Data data;
    }

    class Data {
        private Realtime realtime;
        private Life life;
        private Forecast[] weather;
        private Pm pm25;
        private String date;
        private String isForeign;
    }

    static class Realtime {
        public String city_code;
        public String city_name;
        public String date;
        public String time;
        public String week;
        public String moon;
        public String dataUptime;
        public RealtimeWeather weather;
        public Wind wind;

        class RealtimeWeather {
            int temperature; // 温度
            int humidity; // 湿度
            String info;
            String img;
        }

        static class Wind {
            private String direct; // 风向
            private String power; // 风力
            private String offset;
            private String windspeed;
        }
    }

    /** 生活指数 */
    static class Life {
        public String date;
        public Info info;
    }

    static class Info {
        public String[] chuanyi; // 穿衣指数
        public String[] ganmao; // 感冒指数
        public String[] kongtiao; // 空调指数
        public String[] wuran; // 污染指数
        public String[] xiche; // 洗车指数
        public String[] yundong; // 运动指数
        public String[] ziwaixian; // 紫外线
    }

    static class Forecast {
        public String date;
        public Info info;
        private String week;
        private String nongli;

        static class Info {
            private static final int INDEX_WEATHER_ID = 0;
            private static final int INDEX_WEATHER = 1;
            private static final int INDEX_TEMPERATURE = 2;
            private static final int INDEX_WIND_DIRECTION = 3;
            private static final int INDEX_WIND_SPEED = 4;

            private String[] dawn; // 黎明
            private String[] day; // 天气ID,天气,高温,风向,风力
            private String[] night; // 同上
        }

        public String getDate() {
            return date;
        }

        public String getWeek() {
            return week;
        }

        public String getNongli() {
            return nongli;
        }

        public String getDawnWeatherId() {
            return info.dawn[Info.INDEX_WEATHER_ID];
        }

        public String getDawnWeather() {
            return info.dawn[Info.INDEX_WEATHER];
        }

        public String getDawnTemperature() {
            return info.dawn[Info.INDEX_TEMPERATURE];
        }

        public String getDawnWindDirection() {
            return info.dawn[Info.INDEX_WIND_DIRECTION];
        }

        public String getDawnWindSpeed() {
            return info.dawn[Info.INDEX_WIND_SPEED];
        }

        public String getDayWeatherId() {
            return info.day[Info.INDEX_WEATHER_ID];
        }

        public String getDayWeather() {
            return info.day[Info.INDEX_WEATHER];
        }

        public String getDayTemperature() {
            return info.day[Info.INDEX_TEMPERATURE];
        }

        public String getDayWindDirection() {
            return info.day[Info.INDEX_WIND_DIRECTION];
        }

        public String getDayWindSpeed() {
            return info.day[Info.INDEX_WIND_SPEED];
        }

        public String getNightWeatherId() {
            return info.night[Info.INDEX_WEATHER_ID];
        }

        public String getNightWeather() {
            return info.night[Info.INDEX_WEATHER];
        }

        public String getNightTemperature() {
            return info.night[Info.INDEX_TEMPERATURE];
        }

        public String getNightWindDirection() {
            return info.night[Info.INDEX_WIND_DIRECTION];
        }

        public String getNightWindSpeed() {
            return info.night[Info.INDEX_WIND_SPEED];
        }

        public boolean isDawnAvailable() {
            return info.dawn != null;
        }

        public boolean isDayAvailable() {
            return info.day != null;
        }

        public Integer getDawnWeatherIcon() {
            return WEATHER_DAY_ICON_MAP.get(info.dawn[Info.INDEX_WEATHER_ID]);
        }

        public Integer getDayWeatherIcon() {
            return WEATHER_DAY_ICON_MAP.get(info.day[Info.INDEX_WEATHER_ID]);
        }

        public Integer getNightWeatherIcon() {
            return WEATHER_NIGHT_ICON_MAP.get(info.night[Info.INDEX_WEATHER_ID]);
        }
    }

    static class Pm {
        private String key;
        private String show_desc;
        private Pm25 pm25;
        private String dateTime;
        private String cityName;

        static class Pm25 {
            private int curPm;
            private int pm25;
            private int pm10;
            private int level;
            private String quality;
            private String des;
        }
    }

    public Realtime getWeather() {
        return result.data.realtime;
    }

    public Forecast[] getForecast() {
        return result.data.weather;
    }
}
