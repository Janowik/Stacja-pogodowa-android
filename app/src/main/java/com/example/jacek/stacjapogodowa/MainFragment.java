package com.example.jacek.stacjapogodowa;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    TextView temperatura,wilgotnosc,cisnienie,pm25,data;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        temperatura = (TextView) view.findViewById(R.id.temperatura_txt);
        wilgotnosc = (TextView) view.findViewById(R.id.wilgotnosc_txt_wartosc);
        cisnienie = (TextView) view.findViewById(R.id.cisnienie_txt_wartosc);
        pm25 = (TextView) view.findViewById(R.id.pylki_txt_25_wartosc);
        data = (TextView) view.findViewById(R.id.data_txt);

        //ustawiam wykonywanie AsyncTask co 1s
        Timer timerAsyncTask = new Timer();
        timerAsyncTask.schedule(new TimerTask() {
            @Override
            public void run() {
                new MyAsyncTask().execute();
            }
        },0,1000);
        return view;
    }

    class MyAsyncTask extends AsyncTask<Void, Void, DataJson> {
        @Override
        protected DataJson doInBackground(Void... params) {
            try {
                final String url = "http://stacja-pogodowa.cba.pl/php/returnjson.php?format=json";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                DataJson dataJson = restTemplate.getForObject(url, DataJson.class);
                return dataJson;

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(DataJson dataJson) {
            if(dataJson != null){
                temperatura.setText(dataJson.getTemperatura());
                wilgotnosc.setText(dataJson.getWilgotnosc());
                cisnienie.setText(dataJson.getCisnienie());
                pm25.setText(dataJson.getpm10());
                data.setText(dataJson.getData());
            }

        }
    }
}
