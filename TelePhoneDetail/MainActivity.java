package com.example.tmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);

        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        String IMEINumber = tm.getDeviceId();
            String subscriberID=tm.getDeviceId();
            String SIMSerialNumber=tm.getSimSerialNumber();
            String networkCountryISO=tm.getNetworkCountryIso();
            String SIMCountryISO=tm.getSimCountryIso();
            String softwareVersion=tm.getDeviceSoftwareVersion();
            String voiceMailNumber=tm.getVoiceMailNumber();

            //Get the phone type
            String strphoneType="";

            int phoneType=tm.getPhoneType();

            switch (phoneType)
            {
                case (TelephonyManager.PHONE_TYPE_CDMA):
                    strphoneType="CDMA";
                    break;
                case (TelephonyManager.PHONE_TYPE_GSM):
                    strphoneType="GSM";
                    break;
                case (TelephonyManager.PHONE_TYPE_NONE):
                    strphoneType="NONE";
                    break;
            }

            //getting information if phone is in roaming
            boolean isRoaming=tm.isNetworkRoaming();

            String info="Phone Details:\n
            info+="\n IMEI Number:"+IMEINumber;
            info+="\n SubscriberID:"+subscriberID;
            info+="\n Sim Serial Number:"+SIMSerialNumber;
            info+="\n Network Country ISO:"+networkCountryISO;
            info+="\n SIM Country ISO:"+SIMCountryISO;
            info+="\n Software Version:"+softwareVersion;
            info+="\n Voice Mail Number:"+voiceMailNumber;
            info+="\n Phone Network Type:"+strphoneType;
            info+="\n In Roaming? :"+isRoaming;

            textView1.setText(info);//displaying the information in the textView


        }
}
