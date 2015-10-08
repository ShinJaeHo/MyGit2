package com.example.new108.mytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by new108 on 2015-10-01.
 */
public class ListActivity extends Activity {
    // 리스트 뷰 선언
    private ListView listView = null;
    private ListViewAdapter listViewAdapter = new ListViewAdapter();
    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // 리스트뷰 객체와 화면 연결
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(listViewAdapter);

        String strJson ="[ {\"_id\":1832015,\"name\":\"Heung-hai\",\"country\":\"KR\",\"coord\":{\"lon\":129.352219,\"lat\":36.112499}},"
                            + "{\"_id\":1832617,\"name\":\"Eisen\",\"country\":\"KR\",\"coord\":{\"lon\":128.930832,\"lat\":35.967499}},"
                            + "{\"_id\":1835447,\"name\":\"Taisen-ri\",\"country\":\"KR\",\"coord\":{\"lon\":126.597717,\"lat\":36.349312}},"
                            + "{\"_id\":1835967,\"name\":\"Jenzan\",\"country\":\"KR\",\"coord\":{\"lon\":128.297501,\"lat\":36.240829}},"
                            + "{\"_id\":1836208,\"name\":\"Songwon\",\"country\":\"KR\",\"coord\":{\"lon\":127.131393,\"lat\":36.915562}},"
                            + "{\"_id\":1838508,\"name\":\"Fuyo\",\"country\":\"KR\",\"coord\":{\"lon\":126.912498,\"lat\":36.28194}},"
                            + "{\"_id\":1839011,\"name\":\"Beolgyo\",\"country\":\"KR\",\"coord\":{\"lon\":127.342934,\"lat\":34.84494}},"
                            + "{\"_id\":1840179,\"name\":\"Kosong\",\"country\":\"KR\",\"coord\":{\"lon\":128.467606,\"lat\":38.378811}},"
                            + "{\"_id\":1842966,\"name\":\"Kijang\",\"country\":\"KR\",\"coord\":{\"lon\":129.213882,\"lat\":35.244171}},"
                            + "{\"_id\":1843585,\"name\":\"Imsil\",\"country\":\"KR\",\"coord\":{\"lon\":127.279442,\"lat\":35.61306}},"
                            + "{\"_id\":1844308,\"name\":\"Hayang\",\"country\":\"KR\",\"coord\":{\"lon\":128.820007,\"lat\":35.91333}},"
                            + "{\"_id\":1847050,\"name\":\"Gaigeturi\",\"country\":\"KR\",\"coord\":{\"lon\":126.318329,\"lat\":33.464439}},"
                            + "{\"_id\":1882056,\"name\":\"Sinhyeon\",\"country\":\"KR\",\"coord\":{\"lon\":128.626663,\"lat\":34.8825}},"
                            + "{\"_id\":1912205,\"name\":\"Ungsang\",\"country\":\"KR\",\"coord\":{\"lon\":129.16861,\"lat\":35.406109}},"
                            + "{\"_id\":6395804,\"name\":\"Sinan\",\"country\":\"KR\",\"coord\":{\"lon\":126.108627,\"lat\":34.826199}},"
                            + "{\"_id\":1835841,\"name\":\"Republic of Korea\",\"country\":\"KR\",\"coord\":{\"lon\":127.5,\"lat\":37}},"
                            + "{\"_id\":1902028,\"name\":\"Kyongsang-namdo\",\"country\":\"KR\",\"coord\":{\"lon\":128.25,\"lat\":35.25}},"
                            + "{\"_id\":1846430,\"name\":\"Changpo\",\"country\":\"KR\",\"coord\":{\"lon\":128.435013,\"lat\":35.381691}},"
                            + "{\"_id\":6901961,\"name\":\"Chidong-gol\",\"country\":\"KR\",\"coord\":{\"lon\":128.338211,\"lat\":35.515518}},"
                            + "{\"_id\":6901967,\"name\":\"Ugok\",\"country\":\"KR\",\"coord\":{\"lon\":128.36235,\"lat\":35.520199}} ]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();


            //List<Locations> list = objectMapper.readValue(strJson, TypeFactory.defaultInstance().constructType(List.class, Locations.class));
            List<Locations> list = objectMapper.readValue(strJson, new TypeReference<List<Locations>>(){});
            listViewAdapter.addItem(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 이 클래스와 data_row_basic.xml 하고 1:1 로 매칭
    private class ViewHolder{
        public TextView txtId;
        public TextView txtName;
        public TextView txtLon;
        public TextView txtLat;
    }

    private class ListViewAdapter extends BaseAdapter{
        private Context context;
        private List<Locations>  listData = new ArrayList<Locations>();

        public void addItem(List<Locations> list){
            listData = list;
        }

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if(convertView == null){
                Log.d("listView", ">>>>convertView == null 일경우");
                viewHolder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.data_row_basic, null);

                viewHolder.txtId = (TextView)convertView.findViewById(R.id.txtId);
                viewHolder.txtName = (TextView)convertView.findViewById(R.id.txtName);
                viewHolder.txtLon = (TextView)convertView.findViewById(R.id.txtLon);
                viewHolder.txtLat = (TextView)convertView.findViewById(R.id.txtLat);

                convertView.setTag(viewHolder);
            } else {
                Log.d("listView", ">>>>convertView 있는경우 ");
                viewHolder = (ViewHolder)convertView.getTag();
            }

            final Locations locations = listData.get(position);
            Log.d("ListView", "getId : " + locations.get_id());
            Log.d("ListView", "getName : " + locations.getName());
            Log.d("ListView", "getLat : " + locations.getCoord().getLat());

            viewHolder.txtId.setText(locations.get_id());
            viewHolder.txtName.setText(locations.getName());
            viewHolder.txtLat.setText("Lat: " + locations.getCoord().getLat());
            viewHolder.txtLon.setText("Lon : " + locations.getCoord().getLon());


//            final LinkedHashMap<String, Object> linkedHashMap = listData.get(position);
//
//            viewHolder.txtId.setText(linkedHashMap.get("_id").toString());
//            viewHolder.txtName.setText(linkedHashMap.get("name").toString());
//            viewHolder.txtLat.setText("Lat: " + ((LinkedHashMap<String, Object>)linkedHashMap.get("coord")).get("lat").toString());
//            viewHolder.txtLon.setText("Lon : " + ((LinkedHashMap<String, Object>) linkedHashMap.get("coord")).get("lon").toString());


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // 1. Toast : id
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Id : " + locations.get_id(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    // 2. 진동 200ms
                    vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(200);

                    // 3. 상세화면 이동  id, name
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), DetailActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("id", locations.get_id());
                    bundle.putString("name", locations.getName());
                    intent.putExtras(bundle);

                    startActivity(intent);

                }
            });


            return convertView;
        }
    }


}