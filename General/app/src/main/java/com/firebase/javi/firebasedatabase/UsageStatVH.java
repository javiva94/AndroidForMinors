package com.firebase.javi.firebasedatabase;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.firebase.javi.firebasedatabase.MainActivity.identificador;

public class UsageStatVH extends RecyclerView.ViewHolder {

    private ImageView appIcon;
    private TextView appName;
    private TextView lastTimeUsed;
    private Long totalTime = 0L;
    public Long cuenta =0L;
    public static UsageStatsWrapper valor;


    public UsageStatVH(View itemView) {
        super(itemView);

        appIcon = (ImageView) itemView.findViewById(R.id.icon);
        appName = (TextView) itemView.findViewById(R.id.title);
        lastTimeUsed = (TextView) itemView.findViewById(R.id.last_used);
    }

    public void bindTo(UsageStatsWrapper usageStatsWrapper) {
        appIcon.setImageDrawable(usageStatsWrapper.getAppIcon());
        appName.setText(usageStatsWrapper.getAppName());
        if (usageStatsWrapper.getUsageStats() == null){
            lastTimeUsed.setText(R.string.last_time_used_never);
        }else if (usageStatsWrapper.getUsageStats().getLastTimeUsed() == 0L){
            lastTimeUsed.setText(R.string.last_time_used_never);
        } else{
            lastTimeUsed.setText(App.getApp().getString(R.string.last_time_used,
                    DateUtils.format(usageStatsWrapper)));

            Long minutes = usageStatsWrapper.getUsageStats().getTotalTimeInForeground()/60000;
            Long seconds = (usageStatsWrapper.getUsageStats().getTotalTimeInForeground()%60000)/1000;
            totalTime = minutes;
            valor=usageStatsWrapper;

            if(seconds<10) {
                lastTimeUsed.setText("Total time used: " + String.valueOf(minutes) + ".0" + String.valueOf(seconds)+ " minutes");
            }
            else
                lastTimeUsed.setText("Total time used: " + String.valueOf(minutes) + "."  + String.valueOf(seconds) + " minutes");
        }
        Log.d("Tiempo", String.valueOf(totalTime));
        DatabaseReference databaseUsuarios;
        databaseUsuarios = FirebaseDatabase.getInstance().getReference().child("Usuarios").child(identificador).child("Aplicaciones");
        String id = databaseUsuarios.push().getKey();
        Aplicaciones aplicaciones = new Aplicaciones(appName.getText().toString().trim(),totalTime.toString());
        databaseUsuarios.child(id).setValue(aplicaciones);
        cuenta += totalTime;

    }

}