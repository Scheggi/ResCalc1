package com.example.rescalc1;

import static java.lang.Math.pow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        //Spinner drop1=findViewById(R.id.drop1);
        //ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
    public void calculate(View view){
        //todo ausgliedern in andere Function
        Map<String, Integer> map_color = new HashMap<String, Integer>();
        map_color.put("schwarz",0);
        map_color.put("braun",1);
        map_color.put("rot",2);
        map_color.put("orange",3);
        map_color.put("gelb",4);
        map_color.put("gruen",5);
        map_color.put("blau",6);
        map_color.put("violett",7);
        map_color.put("grau",8);
        map_color.put("weiss",9);

        //todo ausgliedern in andere Function
        Map<String, Double> map_multi = new HashMap<String, Double>();
        map_multi.put("silber", (double) 0.01);
        map_multi.put("gold", (double) 0.1);
        map_multi.put("schwarz", (double) 1);
        map_multi.put("braun", (double) 10);
        map_multi.put("rot",  (double) 100);
        map_multi.put("orange",(double) 1);
        map_multi.put("gelb",(double) 10);
        map_multi.put("gruen",(double) 100);
        map_multi.put("blau",(double) 1);
        map_multi.put("violett", (double) 10);
        map_multi.put("grau",(double) 100);
        map_multi.put("weiss",(double) 1);

        Map<String, String> map_multi_size = new HashMap<String, String>();
        map_multi_size.put("silber", " Ohm");
        map_multi_size.put("gold", " Ohm");
        map_multi_size.put("schwarz", " Ohm");
        map_multi_size.put("braun", " Ohm");
        map_multi_size.put("rot", " Ohm");
        map_multi_size.put("orange"," k Ohm");
        map_multi_size.put("gelb"," k Ohm");
        map_multi_size.put("gruen"," k Ohm");
        map_multi_size.put("blau"," M Ohm");
        map_multi_size.put("violett", "M Ohm");
        map_multi_size.put("grau"," M Ohm");
        map_multi_size.put("weiss"," G Ohm");

        //todo ausgliedern in andere Function
        Map<String, Double> map_tolerance = new HashMap<String, Double>();
        map_tolerance.put("silber", (double) 10);
        map_tolerance.put("gold", (double) 5);
        map_tolerance.put("braun", (double) 1);
        map_tolerance.put("rot", (double) 2);
        map_tolerance.put("gruen",(double) 0.5);
        map_tolerance.put("blau",(double) 0.25);
        map_tolerance.put("violett", (double) 0.1);
        map_tolerance.put("grau",(double) 0.05);

        //todo ausgliedern in andere Function
        Map<String, Integer> map_temp = new HashMap<String, Integer>();
        map_temp.put("braun", 100);
        map_temp.put("rot", 50);
        map_temp.put("orange",15);
        map_temp.put("gelb",25);
        map_temp.put("blau",10);
        map_temp.put("violett", 5);
        map_temp.put("weiss",1);

        //get colors of ring 1-6
        Spinner drop1=findViewById(R.id.drop1);
        String ring1 = drop1.getSelectedItem().toString();


        Spinner drop2=findViewById(R.id.drop2);
        String ring2 = drop2.getSelectedItem().toString();

        Spinner drop3=findViewById(R.id.drop3);
        String ring3 = drop3.getSelectedItem().toString();

        Spinner drop4=findViewById(R.id.drop4);
        String ring4 = drop4.getSelectedItem().toString();

        Spinner drop5=findViewById(R.id.drop5);
        String ring5 = drop5.getSelectedItem().toString();

        Spinner drop6=findViewById(R.id.drop6);
        String ring6 = drop6.getSelectedItem().toString();

        String none = new String("None");
        Double result = new Double(0.0);

        TextView result_field = findViewById(R.id.result);
        //
        if (ring1.equals(none) || ring2.equals(none) || ring3.equals(none) || ring4.equals(none)){
            result_field.setText("Die Ringe müssen korrekt angegeben werden");
        }
        else if (ring5.equals(none)){
            //just four strings, first 2 number, third multiplikator, forth tolerance
            // get number ob 1,2 ring
            //map string to number
            Double number = new Double(10 * map_color.get(ring1) + map_color.get(ring2));
            number = number * map_multi.get(ring3);

            //String result_final = String.format("Der Widerstand beträgt %1$,.2f %s mit einer Tolernanz von %21$,.2f",number,map_multi_size.get(ring3),map_tolerance.get(ring4));
            String result_final = new String("Der Widerstand beträgt "+Double.toString(number)
                    +map_multi_size.get(ring3).toString()+
                    "mit einer Tolernanz von"+Double.toString(map_tolerance.get(ring4)));
            //%1$,.2f %s mit einer Tolernanz von %21$,.2f",number,map_multi_size.get(ring3),map_tolerance.get(ring4));

            result_field.setText(result_final);

        } else if (ring6.equals(none)){
            // 5 strings, 3 numbers, multi, tolerance
            Double number = new Double(100*map_color.get(ring1)+10*map_color.get(ring2)+map_color.get(ring3));
            number = number * map_multi.get(ring4);
            //String result_final = String.format("Der Widerstand beträgt %s %s mit einer Tolernanz " +
            //        "von %s %",Double.toString(number),map_multi_size.get(ring4).toString(),
            //        Double.toString(map_tolerance.get(ring5)));
            String result_final = new String("Der Widerstand beträgt"+Double.toString(number)+map_multi_size.get(ring4).toString()+
                    "mit einer Tolernanz"+Double.toString(map_tolerance.get(ring5))+"von"
                    +Double.toString(map_tolerance.get(ring5))+"Prozent"
            );
            result_field.setText(result_final);
        }else if (!ring6.equals(none)){
            //all relevant
            // 5 strings, 3 numbers, multi, tolerance
            Double number = new Double(1000*map_color.get(ring1));//+100*map_color.get(ring2)+10*map_color.get(ring3)+map_color.get(ring4));
            number = number * map_multi.get(ring4);
            String result_final = new String("Der Widerstand beträgt"+Double.toString(number)+map_multi_size.get(ring4).toString()+
                    "mit einer Tolernanz"+Double.toString(map_tolerance.get(ring5))+"von"
                    +Double.toString(map_tolerance.get(ring5))+"Prozent und einem Temperaturkoeffizienten von"
                    +Integer.toString(map_temp.get(ring6))
            );
            result_field.setText(result_final);
            //String result_final = String.format("Der Widerstand beträgt %2d %s mit einer Tolernanz " +
            //        "von %2d und Temperaturkoeffizienten von %2d",number,map_multi_size.get(ring5),
            //                map_tolerance.get(ring5),map_temp.get(ring6));
            //result_field.setText(result_final);

        }

    }
}