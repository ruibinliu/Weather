package com.ruibin.weather;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Weather {
    private static final HashMap<String, Integer> WEATHER_DAY_ICON_MAP = new HashMap<>();
    private static final HashMap<String, Integer> WEATHER_NIGHT_ICON_MAP = new HashMap<>();
    private static final HashMap<String, String> WIND_DIRECTION_MAP = new HashMap<>();
    private static final HashMap<String, String> WIND_SPEED_MAP = new HashMap<>();

    static {
        WEATHER_DAY_ICON_MAP.put("00", R.mipmap.weather_day_00);
        WEATHER_DAY_ICON_MAP.put("01", R.mipmap.weather_day_01);
        WEATHER_DAY_ICON_MAP.put("02", R.mipmap.weather_day_02);
        WEATHER_DAY_ICON_MAP.put("03", R.mipmap.weather_day_03);
        WEATHER_DAY_ICON_MAP.put("04", R.mipmap.weather_day_04);
        WEATHER_DAY_ICON_MAP.put("05", R.mipmap.weather_day_05);
        WEATHER_DAY_ICON_MAP.put("06", R.mipmap.weather_day_06);
        WEATHER_DAY_ICON_MAP.put("07", R.mipmap.weather_day_07);
        WEATHER_DAY_ICON_MAP.put("08", R.mipmap.weather_day_08);
        WEATHER_DAY_ICON_MAP.put("09", R.mipmap.weather_day_09);
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

        WEATHER_NIGHT_ICON_MAP.put("00", R.mipmap.weather_night_00);
        WEATHER_NIGHT_ICON_MAP.put("01", R.mipmap.weather_night_01);
        WEATHER_NIGHT_ICON_MAP.put("02", R.mipmap.weather_night_02);
        WEATHER_NIGHT_ICON_MAP.put("03", R.mipmap.weather_night_03);
        WEATHER_NIGHT_ICON_MAP.put("04", R.mipmap.weather_night_04);
        WEATHER_NIGHT_ICON_MAP.put("05", R.mipmap.weather_night_05);
        WEATHER_NIGHT_ICON_MAP.put("06", R.mipmap.weather_night_06);
        WEATHER_NIGHT_ICON_MAP.put("07", R.mipmap.weather_night_07);
        WEATHER_NIGHT_ICON_MAP.put("08", R.mipmap.weather_night_08);
        WEATHER_NIGHT_ICON_MAP.put("09", R.mipmap.weather_night_09);
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

    private C c;
    private ForecastList f;

    class C {
        String c1; // 区域 ID
        String c2; // 城市英文名
        String c3; // 城市中文名
        String c4; // 城市所在市英文名
        String c5; // 城市所在市中文名
        String c6; // 城市所在省英文名
        String c7; // 城市所在省中文名
        String c8; // 城市所在国家英文名
        String c9; // 城市所在国家中文名
        String c10; // 城市级别
        String c11; // 城市区号
        String c12; // 邮编
        String c13; // 经度
        String c14; // 纬度
        String c15; // 海拔
        String c16; // 雷达站号

        public String getC1() {
            return c1;
        }

        public String getC2() {
            return c2;
        }

        public String getC3() {
            return c3;
        }

        public String getC4() {
            return c4;
        }

        public String getC5() {
            return c5;
        }

        public String getC6() {
            return c6;
        }

        public String getC7() {
            return c7;
        }

        public String getC8() {
            return c8;
        }

        public String getC9() {
            return c9;
        }

        public String getC10() {
            return c10;
        }

        public String getC11() {
            return c11;
        }

        public String getC12() {
            return c12;
        }

        public String getC13() {
            return c13;
        }

        public String getC14() {
            return c14;
        }

        public String getC15() {
            return c15;
        }

        public String getC16() {
            return c16;
        }
    }

    class ForecastList {
        private String f0; // 预报发布的时间
        private ArrayList<Forecast> f1;

        public String getPublishTime() {
            return f0;
        }

        public ArrayList<Forecast> getForecastList() {
            return f1;
        }
    }

    class Forecast {
        String fa; // 白天天气现象编号
        String fb; // 晚上天气现象编号
        String fc; // 白天天气温度(摄氏度)
        String fd; // 晚上天气温度(摄氏度)
        String fe; // 白天风向编号
        String ff; // 晚上风向编号
        String fg; // 白天风力编号
        String fh; // 晚上风力编号
        String fi; // 日出日落时间(中间用|分割)

        public int getDayWeatherIcon() {
            if (WEATHER_DAY_ICON_MAP.containsKey(fa)) {
                return WEATHER_DAY_ICON_MAP.get(fa);
            } else {
                return R.mipmap.weather_undefined;
            }
        }

        public int getNightWeatherIcon() {
            if (WEATHER_NIGHT_ICON_MAP.containsKey(fb)) {
                return WEATHER_NIGHT_ICON_MAP.get(fb);
            } else {
                return R.mipmap.weather_undefined;
            }
        }

        public boolean isDayForecastAvailable() {
            return !TextUtils.isEmpty(fa);
        }

        public String getDayTemperature() {
            return fc;
        }

        public String getNightTemperature() {
            return fd;
        }

        public String getDayWindDirection() {
            return WIND_DIRECTION_MAP.get(fe);
        }

        public String getNightWindDirection() {
            return WIND_DIRECTION_MAP.get(ff);
        }

        public String getDayWindSpeed() {
            return WIND_SPEED_MAP.get(fg);
        }

        public String getNightWindSpeed() {
            return WIND_SPEED_MAP.get(fh);
        }
    }

    public String getCityName() {
        return c.getC3();
    }

    public String getPublishTime() {
        return f.getPublishTime();
    }

    public ArrayList<Weather.Forecast> getForecastList() {
        return f.getForecastList();
    }
}
