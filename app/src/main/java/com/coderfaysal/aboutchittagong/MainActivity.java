package com.coderfaysal.aboutchittagong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView it_recycle;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        it_recycle = findViewById(R.id.it_recycle);

        Chittagong();

        MyAdapter myAdapter = new MyAdapter();
        it_recycle.setAdapter(myAdapter);
        it_recycle.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }



    public void Chittagong(){

        hashMap = new HashMap<>();
        hashMap.put("title", "Chittagong");
        hashMap.put("desc", "Bengali: চট্টগ্রাম, romanized: Chôṭṭôgrām [ˈtʃɔʈːoɡram]), also known as Chatgaon (Bengali: চাটগাঁ, romanized: Chātgã), is the second-largest city in Bangladesh. Home to the Port of Chittagong, it is the busiest port in Bangladesh and the Bay of Bengal.[9] It is the administrative seat of an eponymous division and district. The city is located on the banks of the Karnaphuli River between the Chittagong Hill Tracts and the Bay of Bengal. The Greater Chittagong Area had a population of more than 5.2 million in 2022.[10] In 2020, the city area had a population of more than 3.9 million.[11] The city is home to many large local businesses and plays an important role in the Bangladeshi economy.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "Etymology");
        hashMap.put("desc", "The etymology of Chittagong is uncertain.[17] The port city has been known by various names in history, including Chatigaon, Chatigam, Chattagrama, Islamabad, Chattala, Chaityabhumi and Porto Grande De Bengala. The Bengali word for Chittagong, Chattogram (চট্টগ্রাম), has the suffix (গ্রাম) meaning village in Standard Bengali. A legend dates the name to the spread of Islam when a Muslim lit a chati (lamp) at the top of a hill in the city and called out Azaan for people. The city was renamed Islamabad (City of Islam) during the Mughal era. The name continues to be used in the old city. In April 2018, the Cabinet Division of the Government of Bangladesh decided to change the city's name to Chattogram,[8][19] based on its Bengali spelling and pronunciation; the move was criticized in the Bangladeshi media.[20] Chittagong is also known as Baro Auliyar Desh (Land of twelve Sufi saints).");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "History");
        hashMap.put("desc", "Stone Age fossils and tools unearthed in the region indicate that Chittagong has been inhabited since Neolithic times. It is an ancient port city, with a recorded history dating back to the 4th century BC. Its harbour was mentioned in Ptolemy's world map in the 2nd century as one of the most impressive ports in the East.[12] The region was part of the ancient Bengali Samatata and Harikela kingdoms. The Chandra dynasty once dominated the area and was followed by the Varman dynasty and Deva dynasty.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "Culture");
        hashMap.put("desc", "An inhabitant of Chittagong is called Chittagonian in English.[101] For centuries, the port city has been a melting pot for people from all over the world. Its historic trade networks have left a lasting impact on its language, culture, and cuisine. The Chittagonian language, although identified as a nonstandard dialect of Bengali, is considered to be a separate language by many linguists. The Chittagonian language has many Arabic, Persian, English and Portuguese loanwords.[21] The popular traditional feast of Mezban features the serving of hot beef dish with white rice.[101] Another dish named kala-bhuna of Chittagong, made with traditional spices, mustard oil, and beef through a special cooking style, is also renowned all over Bangladesh.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "Economy");
        hashMap.put("desc", "A substantial share of Bangladesh's national GDP is attributed to Chittagong. The port city contributes 12%[6] of the nation's economy. Chittagong generates for 40% of Bangladesh's industrial output, 80% of its international trade and 50% of its governmental revenue.[79][80] The Chittagong Stock Exchange has more than 700 listed companies, with a market capitalisation of US$32 billion in June 2015.[78] The city is home to many of the country's oldest and largest corporations. The Port of Chittagong handled US$60 billion in annual trade in 2011, ranking 3rd in South Asia after the Port of Mumbai and the Port of Colombo.[9][80] The port is part of the Maritime Silk Road that runs from the Chinese coast via the Suez Canal to the Mediterranean and on to the Upper Adriatic region of Trieste with rail connections to Central and Eastern Europe.");
        arrayList.add(hashMap);


    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.items, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String name = hashMap.get("title");
            String dec = hashMap.get("desc");

            holder.it_name.setText(name);

            holder.click_lay.setOnClickListener(view -> {

                Details.TITLE = name;
                Details.DESC = dec;
                startActivity(new Intent(MainActivity.this, Details.class));

            });

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder{

            LinearLayout click_lay;
            TextView it_name;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                click_lay = itemView.findViewById(R.id.click_lay);
                it_name = itemView.findViewById(R.id.it_name);


            }
        }

    }


}