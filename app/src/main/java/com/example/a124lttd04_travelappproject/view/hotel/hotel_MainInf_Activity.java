package com.example.a124lttd04_travelappproject.view.hotel;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.a124lttd04_travelappproject.R;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_Location_Adapter;
import com.example.a124lttd04_travelappproject.adapter.hotel.hotel_CategoryPay_Adapter;
import com.example.a124lttd04_travelappproject.view.flight.plane_VeMayBay_Activity;
import com.example.a124lttd04_travelappproject.view.tour.tour_Tour_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class hotel_MainInf_Activity extends AppCompatActivity {

    private Spinner spinner;
    private hotel_CategoryPay_Adapter categoryPayAdapter;
    private EditText checkInput;
    private EditText checkOutput;
    private MaterialButton button;
    private ImageView img;

    @Override
    public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel_activity_main_inf);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_pay);

        // Đặt mục action_hotel là mặc định
        bottomNavigationView.setSelectedItemId(R.id.action_hotel);

        // Xử lý sự kiện nhấn trên từng mục
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Intent intent = new Intent(hotel_MainInf_Activity.this, hotel_MainHome_Activity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_hotel) {
                    // Nếu là mục Hotel (hoặc hiện tại là Hotel), không cần chuyển activity
                    return true;
                }

                else if (item.getItemId() == R.id.action_plane) {
                    Intent intent = new Intent(hotel_MainInf_Activity.this, plane_VeMayBay_Activity.class);
                    startActivity(intent);
                    return true;
                }

                else if (item.getItemId() == R.id.action_tour) {
                    Intent intent = new Intent(hotel_MainInf_Activity.this, Taikhoan.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        //Spinner
        spinner = findViewById(R.id.spn_room);
        categoryPayAdapter = new hotel_CategoryPay_Adapter(this, R.layout.hotel_item_selected_pay1, getListCategoryPay());
        spinner.setAdapter(categoryPayAdapter);

        //EditText: check_in, check_out
        checkInput = findViewById(R.id.editText_check_in);
        checkOutput = findViewById(R.id.editText_check_out);

        checkInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(checkInput);
            }

            private void showDateDialog(final EditText checkIn) {
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        checkIn.setText(simpleDateFormat.format(calendar.getTime()));  // Đặt ngày vào EditText
                    }
                };
                new DatePickerDialog(hotel_MainInf_Activity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        checkOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(checkOutput);
            }

            private void showDateDialog(final EditText checkIn) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        checkIn.setText(simpleDateFormat.format(calendar.getTime()));  // Đặt ngày vào EditText
                    }
                };
                new DatePickerDialog(hotel_MainInf_Activity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // Button
        button = findViewById(R.id.btn_pay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainInf_Activity.this, hotel_MainActivityPay_Activity.class);
                startActivity(intent);
            }
        });

        img = findViewById(R.id.img_back_Inf);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hotel_MainInf_Activity.this, hotel_MainRoom_Activity.class);
                startActivity(intent);
            }
        });
    }

    private List<hotel_Location_Adapter.model_CategoryPay> getListCategoryPay() {
        List<hotel_Location_Adapter.model_CategoryPay> list = new ArrayList<>();
        list.add(new hotel_Location_Adapter.model_CategoryPay("1 phòng"));
        list.add(new hotel_Location_Adapter.model_CategoryPay("2 phòng"));
        list.add(new hotel_Location_Adapter.model_CategoryPay("3 phòng"));
        return list;
    }
}