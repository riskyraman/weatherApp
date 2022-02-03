package com.exapl.volleyweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Weather extends AppCompatActivity {

    RecyclerView recycler, recycler1;
    private RecyclerViewAdapter recyclerViewAdapter;
    Context context;
    private JSONArray WeatherArrayList;
    private List<Club> clubs;
    TextView tempr, city, textView, humandity, dewpoint, cloud, uvindex, press, wind, visible, sunset1, clear, deg1, sunny;
    ImageView plus;
    LinearLayout linear;
    private List<Club.Club1> clubs1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        recycler = findViewById(R.id.recycler);
        recycler1 = findViewById(R.id.recycler1);
        city = findViewById(R.id.city);
        tempr = findViewById(R.id.tempr);
        textView = findViewById(R.id.textView);
        humandity = findViewById(R.id.humandity);
        dewpoint = findViewById(R.id.dewpoint);
        cloud = findViewById(R.id.cloud);
        uvindex = findViewById(R.id.uvindex);
        plus = findViewById(R.id.plus);
        press = findViewById(R.id.press);
        wind = findViewById(R.id.wind);
        visible = findViewById(R.id.visible);
        sunset1 = findViewById(R.id.sunset1);
        clear = findViewById(R.id.clear);
        deg1 = findViewById(R.id.deg1);
        linear = findViewById(R.id.linear);
        sunny = findViewById(R.id.sunny);
        clubs = new ArrayList<>();

        Method();
        Method1();
//       Method2();


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, hh:mm:ss");
        String datetime = simpleDateFormat.format(calendar.getTime());
        textView.setText(datetime);

        recycler1.setHasFixedSize(true);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(context);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler1.setLayoutManager(layoutManager1);

//       RecyclerViewAdapter1 adapter1 = new RecyclerViewAdapter1(clubs1);

        initializeData1();
//        initializeAdapter1();


        recycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recycler.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, clubs);

//        initializeData();
//        initializeAdapter();


    }


//    private void Method2() {
//        RequestQueue queue = Volley.newRequestQueue(this);
//
//        String url1 ="https://api.openweathermap.org/data/2.5/onecall?lat=33.441792&lon=-94.037689&exclude=hourly&appid=b5f9dddfba50d42096a1f61039be6fda";
//
//// Request a string response from the provided URL.
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d("tag", String.valueOf(response));
//                try {
//                    WeatherArrayList = response.getJSONArray("minutely");
////                    JSONArray daily =response.getJSONArray("minutely");
//                    for(int i=0;i<WeatherArrayList.length();i++) {
//                        JSONObject obj = WeatherArrayList.getJSONObject(i);
////                    JSONObject current = response.getJSONObject("daily");
//                        // JSONObject temp = response.getJSONObject("temp");
////                    for(int i=0;i<WeatherArrayList.length();i++) {
//                        //JSONObject object = WeatherArrayList.getJSONObject(i);
//                        Club.Club1 c = new Club.Club1();
////                        String dt = obj.getString("dt");
////                        System.out.println("DDDDDDDDDDDDDDDDDDDDD   " + dt);
//                        // String max = current.getString("max");
//                        c.setTime(obj.getString("dt"));
////                        m.setName(object.getString("store_name"));
////                        System.out.println("DDDDDDDDDDDDDDDDDDDDD   " + c.getDt());
//                        // c.setTemp(max);
//                         clubs1.add(c);
//
//                    }
//                    // }
//                    recyclerViewAdapter1.notifyDataSetChanged();
//
//                }
//                catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//// Add the request to the RequestQueue.
//        queue.add(jsonObjectRequest);
//        System.out.println(clubs);
//        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,
//                stores);
//        listView.setAdapter(arrayAdapter);*/
//
//        recyclerViewAdapter1 = new RecyclerViewAdapter(Weather.this,clubs);
//        recycler1.setAdapter(recyclerViewAdapter1);
//
//
//
//
//    }



    private void Method1() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url1 = "https://api.openweathermap.org/data/2.5/onecall?lat=33.441792&lon=-94.037689&exclude=hourly&appid=b5f9dddfba50d42096a1f61039be6fda";

// Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("tag", String.valueOf(response));
                try {
                    WeatherArrayList = response.getJSONArray("minutely");
//                    JSONArray daily =response.getJSONArray("minutely");
                    for (int i = 0; i < WeatherArrayList.length(); i++) {
                        JSONObject obj = WeatherArrayList.getJSONObject(i);
//                    JSONObject current = response.getJSONObject("daily");
                        // JSONObject temp = response.getJSONObject("temp");
//                    for(int i=0;i<WeatherArrayList.length();i++) {
                        //JSONObject object = WeatherArrayList.getJSONObject(i);
                        Club c = new Club();
//                        String dt = obj.getString("dt");
//                        System.out.println("DDDDDDDDDDDDDDDDDDDDD   " + dt);
                        // String max = current.getString("max");
                        c.setDt(obj.getString("dt"));
                        c.setSunrise(obj.getString("precipitation"));
//                        m.setName(object.getString("store_name"));
//                        System.out.println("DDDDDDDDDDDDDDDDDDDDD   " + c.getDt());
                        // c.setTemp(max);
                        clubs.add(c);

                    }
                    // }
                    recyclerViewAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
        System.out.println(clubs);
        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                stores);
        listView.setAdapter(arrayAdapter);*/

        recyclerViewAdapter = new RecyclerViewAdapter(Weather.this, clubs);
        recycler.setAdapter(recyclerViewAdapter);


    }


    private void Method() {
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.openweathermap.org/data/2.5/weather?q=noida&appid=b5f9dddfba50d42096a1f61039be6fda&units=metric";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("tag", String.valueOf(response));

                    JSONObject main_object = response.getJSONObject("main");
                    JSONObject main_object4 = response.getJSONObject("sys");
                    JSONObject main_object1 = response.getJSONObject("wind");
                    JSONObject main_object2 = response.getJSONObject("clouds");

//
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);

                    String country = String.valueOf(main_object4.getString("country"));
                    city.setText("Noida "+country);


                    String main = String.valueOf(object.getString("main"));
                    clear.setText(main);

                    String temp = String.valueOf(main_object.getInt("temp"));
                    tempr.setText(temp + " 'c");

                    String temp_min = String.valueOf(main_object.getDouble("temp_min"));
                    uvindex.setText("Min :" + temp_min);

                    String humidity = String.valueOf(main_object.getDouble("humidity"));
                    humandity.setText("Humidity  :" + humidity);

                    String feels_like = String.valueOf(main_object.getDouble("feels_like"));
                    dewpoint.setText("DowPoint  :" + feels_like);

                    String speed = String.valueOf(main_object1.getDouble("speed"));
                    wind.setText(speed);
                    String deg = String.valueOf(main_object1.getDouble("deg"));
                    deg1.setText(deg);

                    String all = String.valueOf(main_object2.getDouble("all"));
                    cloud.setText("Cloud :" + all);

                    String pressure = String.valueOf(main_object.getDouble("pressure"));
                    press.setText(pressure);

                    String sunrise = String.valueOf(main_object4.getDouble("sunrise"));
                    visible.setText("Sunrise" + sunrise);

                    String sunset = String.valueOf(main_object4.getDouble("sunset"));
                    sunset1.setText("Sunset" + sunset);

//                    String nam = String.valueOf(main_object.getString("name"));
//                    city.setText(nam);

//
//                    String visibility = String.valueOf(main_object3.getDouble("visibility"));
//                    visible.setText(visibility);
//
//
////
//                    double temp_int = Double.parseDouble(temp);
//                    double centi = (temp_int - 32) / 1.8000;
//                    centi = Math.round(centi);
//                    int i = (int) centi;
//                    tempr.setText(String.valueOf(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "wrong msg");

            }
        });

        requestQueue.add(jsonObjectRequest);
    }

//
//    private void initializeAdapter1() {
//        RecyclerViewAdapter1 adapter1 = new RecyclerViewAdapter1(clubs1);
//        recycler1.setAdapter(adapter1);
//    }

    private void initializeData1() {
        clubs1 = new ArrayList<Club.Club1>();
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
        clubs1.add(new Club.Club1());
    }

//    private void initializeData() {
//        clubs = new ArrayList<>();
////            clubs.add(new Club(R.drawable.sun,"sun","sunny","min","view","max"));
//            clubs.add(new Club(R.drawable.sun,"Mon","sunny","min","view","max"));
//            clubs.add(new Club(R.drawable.sun,"Tue","sunny","min","view","max"));
//            clubs.add(new Club(R.drawable.sun,"Wed","sunny","min","view","max"));
//            clubs.add(new Club(R.drawable.sun,"Wed","sunny","min","view","max"));
//            clubs.add(new Club(R.drawable.sun,"Wed","sunny","min","view","max"));

//        }
//        private void initializeAdapter() {
//        RecyclerViewAdapter adapter=new RecyclerViewAdapter(context,clubs);
//        recycler.setAdapter(adapter);
//        }


    }


//    class Club {
//        String name;
//        String min;
//        int logoid;
//
//        public Club() {
//
//        }
//
//        Club(int sun, String sun1, String name, String min, String view, String max) {
//            this.name =name;
//            this.min=min;
//            this.logoid = logoid;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getLogoid() {
//            return logoid;
//        }
//
//        public void setLogoid(int logoid) {
//            this.logoid = logoid;
//        }


//    class Club1 {
//        String name1;
//        int logo;
//
//        public Club1() {
//
//        }
//
//        public String getName1() {
//            return name1;
//        }
//
//        public void setName1(String name1) {
//            this.name1 = name1;
//        }
//
//        public int getLogo() {
//            return logo;
//        }
//
//        public void setLogo(int logo) {
//            this.logo = logo;
//        }
//
//        public Club1(String time, int sun, String time1) {
//            this.name1 = name1;
//            this.logo = logo;
//        }
//    }





