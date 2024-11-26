package com.example.a124lttd04_travelappproject.view.tour;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.Taikhoan;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHome_Activity;
import com.example.a124lttd04_travelappproject.view.hotel.hotel_MainHotel_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class tour_DaDatGanDay extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dadatganday);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.action_tour);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    // Chuyển đến HotelMainHomeActivity
                    Intent homeIntent = new Intent(tour_DaDatGanDay.this, hotel_MainHome_Activity.class);
                    startActivity(homeIntent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    // Chuyển đến HotelMainHotelActivity
                    Intent hotelIntent = new Intent(tour_DaDatGanDay.this, hotel_MainHotel_Activity.class);
                    startActivity(hotelIntent);
                    return true;
                } else if (item.getItemId() == R.id.action_plane) {
                    // Chuyển đến PlaneVeMayBayActivity
                    Intent planeIntent = new Intent(tour_DaDatGanDay.this, plane_VeMayBay_Activity.class);
                    startActivity(planeIntent);
                    return true;
                } else if (item.getItemId() == R.id.action_tour) {
                    // Chuyển đến SettingActivity
                    Intent settingIntent = new Intent(tour_DaDatGanDay.this, Taikhoan.class);
                    startActivity(settingIntent);
                    return true;
                }
                return false;
            }
        });

        TextView textView = findViewById(R.id.textgach);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        setupClickListeners();
    }

    private void setupClickListeners() {

        TextView datVeLai = findViewById(R.id.datvelai);
        datVeLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTourChiTietPageActivity();
            }
        });

        TextView danhGiaSanPham = findViewById(R.id.danhgiasanpham);
        danhGiaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDanhGiaSanPhamPageActivity();
            }
        });
    }

    private void openTourChiTietPageActivity() {
        Intent intent = new Intent(tour_DaDatGanDay.this, tour_ChiTiet_Activity.class);
        startActivity(intent);
    }

    private void openDanhGiaSanPhamPageActivity() {
        Intent intent = new Intent(tour_DaDatGanDay.this, tour_DanhGiaSanPham.class);
        startActivity(intent);
    }
}
