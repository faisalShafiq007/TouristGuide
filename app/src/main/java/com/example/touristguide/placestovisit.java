package com.example.touristguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class placestovisit extends AppCompatActivity {
    TextView one,two,three,four,five,h1,h2,h3,h4,h5;
    ImageView ione,itwo,ithree,ifour,ifive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placestovisit);
        one=findViewById(R.id.textview1);
        two=findViewById(R.id.textview2);
        three=findViewById(R.id.textview3);
        four=findViewById(R.id.textview4);
        five=findViewById(R.id.textview5);
        h1=findViewById(R.id.headingone);
        h2=findViewById(R.id.headingtwo);
        h3=findViewById(R.id.headingthree);
        h4=findViewById(R.id.headingfour);
        getSupportActionBar().setTitle("Places To Visit");
        h5=findViewById(R.id.headingfive);

        ione=findViewById(R.id.imgview1);
        itwo=findViewById(R.id.imgview2);
        ithree=findViewById(R.id.imgview3);
        ifour=findViewById(R.id.imgview4);
        ifive=findViewById(R.id.imgview5);
        Intent i= getIntent();
        final String jagah =i.getStringExtra("place");




                if(TextUtils.equals( jagah,"Naran")){
                   Naran();
                }
                else if(TextUtils.equals( jagah,"Jammu")){
                   Jammu();

                }
                else if(TextUtils.equals( jagah,"Murree")){
                  Muree();

                }
                else if(TextUtils.equals( jagah,"Gilgit")){
                    gilgit();

                }
                else if(TextUtils.equals( jagah,"Gwadar")){
                    gwadar();

                }

            }

    private void gwadar()
    {

        h1.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        h4.setVisibility(View.VISIBLE);
        ifour.setVisibility(View.VISIBLE);
        five.setVisibility(View.VISIBLE);
        h5.setVisibility(View.VISIBLE);
        ifive.setVisibility(View.VISIBLE);


        h1.setText("1) "+"Astola Island");
        one.setText("Astola Island, also known as Jezira Haft Talar Satadip or ‘Island of the Seven Hills’, is a small uninhabited Pakistani island in the Arabian Sea. Also the largest island in Pakistan, it is the epitome of Balochistan’s undermined beauty. It is quite an isolated place, lending great beauty to it.  You can enjoy camping, scuba diving, and fishing here.\n" +
                "A great tourist attraction indeed.");
        ione.setImageResource(R.drawable.gw1);
        h2.setText("2) "+"Ormara Beach");
        two.setText("Ormara Beach lies between Karachi and Gwadar on the Makran Coastal Highway, and is a base of naval operations. At 240 kilometres away from Karachi, driving here takes under 5 hours. Ormara was one of the pit stop for Alexander the great, and one of his generals died here, named ormuz, thus the name Ormara.\n" +
                "It is quite an impressive sight as you get to see various naval carriers from the beach, and is one of the best untouched natural beaches in the country.");
        itwo.setImageResource(R.drawable.gw2);
        h3.setText("3) "+"Hammerhead");
        three.setText("Resembling the shape of the hammerhead whale, this mass of rock was created by the mud volcano that erupted. Majority of the rocks in the Gwadar district were created through the eruption of these volcanos.  Hammerhead provides a spectacular view of the Arabian Sea on its southern side and a breathtaking view of the Gwadar city on its north.");
        ithree.setImageResource(R.drawable.gw3);
        h4.setText("4) "+"The Sphinx");
        four.setText("Ever wondered how it would feel to see the wondrous sphinx in Egypt, up front and not in pictures? Gwadar has its own naturally carved sphinx, located on the top of the range, it exactly resembles the man-made sculpture. Its beauty and wonder has brought about many visitors from all over.");
        ifour.setImageResource(R.drawable.gw4);
        h5.setText("5) "+"Princess of Hope");
        five.setText("Located in the largest national park of Pakistan, Princess of Hope is another one of the major tourist attractions. People believe that the formation was man made however history claims that it was carved in the same way as the sphinx and the hammerhead- through the eruption of the Mud Mountains that covered the regions.\n" +
                "It is shaped like a primitive statue of a female and is quite impressive to see due to its immense size and seemingly man made shape.");
        ifive.setImageResource(R.drawable.gw5);


    }

    private void gilgit() {
        h1.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        h4.setVisibility(View.VISIBLE);
        ifour.setVisibility(View.VISIBLE);
        five.setVisibility(View.VISIBLE);
        h5.setVisibility(View.VISIBLE);
        ifive.setVisibility(View.VISIBLE);


        h1.setText("1) "+"Deosai Plains");
        one.setText("Deosai is located on the boundary of the Karakoram and the Western Himalayas and it is one of the highest plateaus in the world standing at 4100meters and is spread over 3000sq.km. The spectacular scenery is covered with snow for almost 8 months a year so the best time to visit Deosai and its surroundings is July to September.\n" +
                "It is said that Deosai Plains have more than 200 types of different colorful flowers. ");
        ione.setImageResource(R.drawable.g1);
        h2.setText("2) "+ "Rama Meadow");
        two.setText("Rama Meadow is ahead of Rama Village and is almost 11 KM away from Astore district; which is one of the largest districts of Gilgit-Baltistan. The beautiful and serene plain ‘Rama Meadow’ is a must visit place due to its lush greenery and above all the peaceful environment.\n" +
                "If you really want to experience paradise in this world, you should visit Rama Meadows at least once.");
        itwo.setImageResource(R.drawable.g2);
        h3.setText("3) "+"Shangrila resort, Skardu");
        three.setText("In the north of Pakistan, Skardu the significant valley of GB is a perfect amalgam of serenity, beauty, and wilderness. From Deosai to Skardu, the road is full of thrill and by crossing Satpara Lake you can reach to these beautiful resorts.\n" +
                "You can find many food places in Skardu easily. But if you want to make your visit memorable then must try a restaurant in Shangrila rest house that is the best part of this place, which is built in the structure of an aircraft. So you can enjoy food over here.");
        ithree.setImageResource(R.drawable.g3);
        h4.setText("4) "+"Gojal Valley");
        four.setText("Gojal Valley borders with China at Khunjerab and is at 15,397 feet above sea level. The Karakoram Highway (KKH) that connects Pakistan to China also passes through Gojal Valley and then enters China at Khunjerab. The lush green fields and full snow-covered lakes in this valley will convince you to spend your entire life in Gojal and never go back.");
        ifour.setImageResource(R.drawable.g4);
        h5.setText("5) "+"Attabad Lake");
        five.setText("Attabad Lake is a beautiful lake in the ‘Gojal Valley,’ Hunza of northern Pakistan that was created in January 2010 by a landslide dam. The water of this lake is freezing cold and one cannot stand in it even more than 30 seconds.");
        ifive.setImageResource(R.drawable.g5);
    }

    private void Muree() {
        h1.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        h4.setVisibility(View.VISIBLE);
        ifour.setVisibility(View.VISIBLE);
        five.setVisibility(View.VISIBLE);
        h5.setVisibility(View.VISIBLE);
        ifive.setVisibility(View.VISIBLE);


        h1.setText("1) "+"The Mall Road");
        one.setText("First and foremost is Mall Road that is the most famous marketplace in Murree. Here you will find all the unique items of Murree. The road opens till 3 am usually");
        ione.setImageResource(R.drawable.m1);
        h2.setText("2) "+"Bhurban");
        two.setText("Bhurban became the most favorite tourist spot in Murree because of its lush green landscapes along with a pleasant environment that is full of calmness.");
        itwo.setImageResource(R.drawable.m2);
        h3.setText("3) "+"Ghora Gali");
        three.setText("Ghora Gali on the list of visited places of Murree. Many hotels and resorts are there to serve many of the tourists visiting Ghora Gali.");
        ithree.setImageResource(R.drawable.m3);
        h4.setText("4) "+"Nathiagali");
        four.setText(" Nathiagali is situated 35 kilometers from Murree and Abbottabad it is elevated at an altitude of 8400 ft. Further, the Nathiagali offers astonishing views with a backdrop of snow-capped peaks of Kashmir and Kohistan.");
        ifour.setImageResource(R.drawable.m4);
        h5.setText("5) "+"Ayubia");
        five.setText("Next on the list is the Ayubia, it is the most visited spot after Nathiagali. It is the best picnic spot in Murree as it also possesses an Ayubia National Park which is elevated at 1,050 meters.");
        ifive.setImageResource(R.drawable.m5);
    }

    private void Jammu() { one.setVisibility(View.VISIBLE);
        h1.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        h4.setVisibility(View.VISIBLE);
        ifour.setVisibility(View.VISIBLE);

h1.setText("1) "+"Neelum Valley");
one.setText("Tourist attractions are required to be captivating. This one is for sure. You will find blue waters and greenery, as stunning as anything. This is God’s magnificent gift to mankind, fortunately, located in Azad Kashmir, Pakistan.");
ione.setImageResource(R.drawable.j1);
        h2.setText("2) "+"Shounter Lake");
        two.setText("Simply offering everything that speaks of wonderful mother nature. Show up in this area during May to August; the climate is your friend and the facilities provided to reach here are top-notch.");
        itwo.setImageResource(R.drawable.j2);
        h3.setText("3) "+"Red Fort");
        three.setText("It is known to be one of the forts in Pakistan you must visit. This fort is a top zone for archaeologists and travel fanatics who like to glimpse in the history of this region.");
        ithree.setImageResource(R.drawable.j3);
        h4.setText("4) "+"Pir Chinasi");
        four.setText("Situated in the capital of Azad Kashmir, Muzaffarabad, this area is one of the top tourist attractions in Pakistan. Pir Chinsai is an astounding spot to explore. You are on the run for your patience as well as your safety. Despite its alluring location, you always require being very cautious of moving around.");
        ifour.setImageResource(R.drawable.j4);
    }

    private void Naran() {
        one.setVisibility(View.VISIBLE);
        h1.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        h4.setVisibility(View.VISIBLE);
        ifour.setVisibility(View.VISIBLE);
        five.setVisibility(View.VISIBLE);
        h5.setVisibility(View.VISIBLE);
        ifive.setVisibility(View.VISIBLE);

        h1.setText("1) "+"Lake Saif-ul-Malook");
        one.setText("First and foremost is the world famous lake from Pakistan. Saif-ul-Malook which is 9 km in length, 50 ft. in-depth, elevated at 3,224 above the surface and mesmerize anybody due to its immense natural beauty. The lake is surrounded by gigantic mountains that give awe-inspiring views which tourist usually prefer for hiking. The lake enhances its beauty in winter with snowcapped mountains and unforgettable views of glaciers.");

        ione.setImageResource(R.drawable.n1);

        h2.setText("2) "+"Lulusar Lake");
        two.setText("Secondly, it’s wonderful lake in the lap of Kaghan valley, it is at the highest peak in Kaghan Valley with magnificent panoramic views almost elevated at 3410m above the sea level.  Lulusar Lake is the popular tourist spot in the valley after Saif ul Malook and Babusar top. The fresh, clean water of lake can be access by jeep ride, almost 48 km away from Naran. “Hiking” “trekking” “fishing” “rafting” “boating” can be enjoyed there. In other words a perfect picnic spot in Kaghan Valley.");
        itwo.setImageResource(R.drawable.n2);


        h3.setText("3) "+"Shogran ");
        three.setText("While exploring the beauties of Kaghan Valley, one can’t get off without visiting the grassy lawns of Shogran. Shogran became the most favourite place of tourists because of its amazing scenic view along with the delightful climate. Shogran is 7,749 feet above and offers the panoramic views of the whole valley. Visitors love to relax in the atmosphere which is full of serenity and enjoy a hot cup of coffee in cold climate. Additionally, a number of resort and motels are there to accommodate thousands of tourists per year.");
        ithree.setImageResource(R.drawable.n3);

        h4.setText("4) "+"Siri Paye");
        four.setText("Siri Paye is another tourist spot almost 6 km away from Shogran. Well known for its lush green meadows and also holds a small Siri Paye Lake. Tourist loves horse riding over there and it became a preference for the tourist of Naran to visit this richly green carpeted lawn of Siri Paye and take a deep breath in the pure and clear air.");
        ifour.setImageResource(R.drawable.n4);

        h5.setText("5) "+"Babusar Top");
        five.setText("On the third, we have the Lalazar. Lalazar is basically a plateau which is covered with beautiful flowers and pine forest. On the other hand, it’s the Babusar Top that is situated almost 70 Kilometers away from Naran. The tourist observed the cold breeze of the Babusar top in between the giants of Karakorum Mountain Range. One of the best place to visit while exploring Naran Valley.");
        ifive.setImageResource(R.drawable.n5);

    }

}


