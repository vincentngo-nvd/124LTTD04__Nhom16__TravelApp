package com.example.a124lttd04_travelappproject.view.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.view.tour.tour_DatVe_ThanhToan_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_ThanhToanThanhCong_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Voucher;

public class hotel_MainActivityPay_Activity extends AppCompatActivity {
    TextView Voucher;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_pay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.img_back_pay);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainActivityPay_Activity.this, hotel_MainInf_Activity.class);
                startActivity(intent);
            }
        });

        Voucher = findViewById(R.id.voucher);
        Voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(hotel_MainActivityPay_Activity.this, hotel_Voucher.class); // Kiểm tra lớp đích
                startActivity(m);
            }
        });

        Button thanhToanThanhCong = findViewById(R.id.thanhtoanthanhcong);
        thanhToanThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainActivityPay_Activity.this, tour_ThanhToanThanhCong_Activity.class);
                startActivity(intent);
            }
        });
    }
}