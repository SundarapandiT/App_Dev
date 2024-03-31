package com.example.rrtvs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ServiceMain extends ComponentActivity {

    private EditText appointmentDateEditText;
    private Calendar calendar;
    private TextView selectedTimeTextView;
    private Button confirmButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicemain);

        appointmentDateEditText = findViewById(R.id.appointment_date);
        calendar = Calendar.getInstance();
        selectedTimeTextView = findViewById(R.id.selected_time);
        confirmButton = findViewById(R.id.confirm_s);
        cancelButton = findViewById(R.id.cancel_s);

        appointmentDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Set click listeners for time buttons
        findViewById(R.id.time1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimeInView("6.00 AM");
            }
        });

        findViewById(R.id.time2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimeInView("7.00 AM");
            }
        });

        findViewById(R.id.time3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimeInView("9.00 AM");
            }
        });

        findViewById(R.id.time4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimeInView("11.00 AM");
            }
        });

        // Add OnClickListener for confirmButton
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceMain.this, Confirmation1.class);
                startActivity(intent);
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateDateInView();
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void updateDateInView() {
        String myFormat = "MM/dd/yy"; // mention the format you need
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        appointmentDateEditText.setText(sdf.format(calendar.getTime()));
    }

    private void updateTimeInView(String selectedTime) {
        Calendar currentTime = Calendar.getInstance();
        String formattedDate = String.format("%02d/%02d/%02d", currentTime.get(Calendar.MONTH) + 1, currentTime.get(Calendar.DAY_OF_MONTH), currentTime.get(Calendar.YEAR));
        selectedTimeTextView.setText(selectedTime + ", " + getDayOfWeek(currentTime.get(Calendar.DAY_OF_WEEK)) + ", " + formattedDate);
    }

    private String getDayOfWeek(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                return "";
        }
    }
}
