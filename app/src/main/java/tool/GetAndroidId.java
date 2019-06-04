package tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

public class GetAndroidId {
    @SuppressLint("MissingPermission")
    public static String getId(Context context){
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId().toString();
    }
}
