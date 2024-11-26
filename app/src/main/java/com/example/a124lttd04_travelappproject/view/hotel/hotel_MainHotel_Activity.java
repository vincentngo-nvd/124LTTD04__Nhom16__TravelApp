package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_Category_Model;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_Category_Adapter;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_ChooseHotel_Hotel_Adapter;
import com.example.a124lttd04_travelappproject.model.hotel.hotel_ChooseHotel_Hotel_Model;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Cart_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_ChiTiet_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class hotel_MainHotel_Activity extends AppCompatActivity {

    private Spinner spinner, spinner2, spinner3;
    private hotel_Category_Adapter categoryAdapter;
    private RecyclerView recyclerView;
    private hotel_ChooseHotel_Hotel_Adapter cgrChoose;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_hotel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_hotel);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    // Chuyển đến HotelMainHomeActivity
                    Intent homeIntent = new Intent(hotel_MainHotel_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(homeIntent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_hotel) {
                    // Chuyển đến HotelMainHotelActivity
                    Intent hotelIntent = new Intent(hotel_MainHotel_Activity.this, hotel_MainHotel_Activity.class);
                    startActivity(hotelIntent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_plane) {
                    // Chuyển đến PlaneVeMayBayActivity
                    Intent planeIntent = new Intent(hotel_MainHotel_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(planeIntent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    // Chuyển đến SettingActivity
                    Intent settingIntent = new Intent(hotel_MainHotel_Activity.this, Taikhoan.class);
                    startActivity(settingIntent);
                    return true;
                }
                return false;
            }
        });

        spinner = findViewById(R.id.spn_category);
        categoryAdapter = new hotel_Category_Adapter(this, R.layout.hotel_item_searchhotel, getListCategory());
        spinner.setAdapter(categoryAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(hotel_MainHotel_Activity.this, categoryAdapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        recyclerView = findViewById(R.id.rcv_choose);
        cgrChoose = new hotel_ChooseHotel_Hotel_Adapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        cgrChoose.setData(getListChooseCategory());
        recyclerView.setAdapter(cgrChoose);

        imageView = findViewById(R.id.img_back_hotel);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainHotel_Activity.this, hotel_MainHome_Activity.class);
                startActivity(intent);
            }
        });

        ImageButton cartButton = findViewById(R.id.cart_button);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCartPageActivity();
            }
        });
    }

    private void openCartPageActivity() {
        Intent intent = new Intent(hotel_MainHotel_Activity.this, tour_Cart_Activity.class);
        startActivity(intent);
    }

    private List<hotel_Category_Model> getListCategory() {
        List<hotel_Category_Model> list = new ArrayList<>();
        list.add(new hotel_Category_Model("Đà Nẵng"));
        list.add(new hotel_Category_Model("Nha Trang"));
        list.add(new hotel_Category_Model("Hội An"));
        list.add(new hotel_Category_Model("Phú Quốc"));
        list.add(new hotel_Category_Model("Ninh Bình"));

        return list;
    }

    private List<hotel_ChooseHotel_Hotel_Model> getListChooseCategory() {
        List<hotel_ChooseHotel_Hotel_Model> list = new ArrayList<>();
        list.add(new hotel_ChooseHotel_Hotel_Model(R.drawable.rating, R.drawable.hotel9, "Hương Xuân , Nha Trang .....", "Boutique Hotel Riverside Danang", "1.102.524 VND"));
        list.add(new hotel_ChooseHotel_Hotel_Model(R.drawable.rating, R.drawable.hotel7, "Hương Xuân , Nha Trang .....", "Khách Sạn Mường Thanh Nha Trang", "1.102.524 VND"));
        list.add(new hotel_ChooseHotel_Hotel_Model(R.drawable.rating, R.drawable.hotel8, "Hương Xuân , Nha Trang .....", "La Beach Hotel", "1.102.524 VND"));
        list.add(new hotel_ChooseHotel_Hotel_Model(R.drawable.rating, R.drawable.hotel_4, "Hương Xuân , Nha Trang .....", "Mikazuki JAPANESE RESORTS & SPA", "1.102.524 VND"));
        list.add(new hotel_ChooseHotel_Hotel_Model(R.drawable.rating, R.drawable.hotel9, "Hương Xuân , Nha Trang .....", "Khách sạn Grand Sunrise Boutique", "1.102.524 VND"));

        return list;
    }


}