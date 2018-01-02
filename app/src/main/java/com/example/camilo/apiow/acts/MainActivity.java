package com.example.camilo.apiow.acts;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camilo.apiow.deserializers.Deserializer;
import com.example.camilo.apiow.R;
import com.example.camilo.apiow.models.Player;
import com.example.camilo.apiow.services.Service;
import com.example.camilo.apiow.utils.CircleTransform;
import com.example.camilo.apiow.utils.Dialog;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView img,marcoImg,rankImgg,star;
    TextView cargando,viewQwon,qwon,won,lost,draw,viewWon, viewLost, viewDraw,viewqc,viewquickhs,viewcomphs,viewcomp,viewRank,viewLevel,username,level,rankk;
    Dialog dialog;
    Retrofit retrofit;
    String nombre, num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Typeface t2 = Typeface.createFromAsset(getAssets(),"fonts/koverwatch.ttf");

        Bundle datos = this.getIntent().getExtras();
        nombre = datos.getString("nombre");
        num = datos.getString("num");

        //VIEW DE CARGA
        dialog = new  Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        cargando = dialog.findViewById(R.id.cargando);
        cargando.setTypeface(t2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();

        //INIT
        controles();
        
        //SET TYPEFACE
        setType();
        
        //ESCONDER VISTAS
        visibilidad(4);

        llamada();
    }

    public void llamada()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Player.class, new Deserializer());

        retrofit = new Retrofit.Builder()
                .baseUrl("http://ow-api.herokuapp.com/profile/pc/")
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();

        Service service = retrofit.create(Service.class);

        Call<Player> playerCall = service.getPlayer(nombre+"-"+num);

        playerCall.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                try{
                    Player player = response.body();


                    //GETEO DATOS
                    String user = player.getUsername();
                    username.setText(user);

                    int lvl = player.getLevel();
                    level.setText(""+lvl);

                    int rank = player.getRank();
                    rankk.setText(""+rank);

                    String comphs = player.getComphs();
                    viewcomphs.setText(comphs);

                    int cantwon = player.getCompwon();
                    won.setText(""+cantwon);

                    int cantlost = player.getComplost();
                    lost.setText(""+cantlost);

                    int cantdraw = player.getCompdraw();
                    draw.setText(""+cantdraw);

                    int quickwon = player.getQuickwon();
                    qwon.setText(""+quickwon);

                    String quickhs = player.getQuickhs();
                    viewquickhs.setText(quickhs);

                    //IMAGEN MARCO
                    String marco_img = player.getMarco_img();
                    Picasso.with(MainActivity.this)
                            .load(marco_img+"png")
                            //.resize(200,150)
                            .fit()
                            .into(marcoImg);

                    //IMAGEN PERFIL
                    String port = player.getPortrait();
                    Picasso.with(MainActivity.this)
                            .load(port)
                            //.resize(160,180)
                            .transform(new CircleTransform())
                            .fit()
                            .into(img);

                    //IMAGEN ESTRELLA
                    String sta = player.getStar_img();
                    Picasso.with(MainActivity.this)
                            .load(sta+"png")
                            .resize(370,170)
                            .into(star);

                    //IMAGEN RANGO
                    String rank_img = player.getRank_img();
                    Picasso.with(MainActivity.this)
                            .load(rank_img)
                            .resize(120,120)
                            .centerCrop()
                            .into(rankImgg);

                    //MOSTRAR VISTAS
                    visibilidad(0);

                    dialog.dismiss();

                }catch(Exception e){
                    username.setVisibility(View.VISIBLE);
                    username.setText("Ese perfil no existe o bien no tiene rango competitivo");
                    dialog.dismiss();

                }

            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                llamada();
            }
        });
    }

    public void visibilidad(int n)
    {
        star.setVisibility(n);
        img.setVisibility(n);
        marcoImg.setVisibility(n);
        rankImgg.setVisibility(n);
        username.setVisibility(n);
        level.setVisibility(n);
        rankk.setVisibility(n);
        viewLevel.setVisibility(n);
        viewRank.setVisibility(n);
        viewcomp.setVisibility(n);
        viewcomphs.setVisibility(n);
        viewquickhs.setVisibility(n);
        viewqc.setVisibility(n);
        viewWon.setVisibility(n);
        viewLost.setVisibility(n);
        viewDraw.setVisibility(n);
        won.setVisibility(n);
        lost.setVisibility(n);
        draw.setVisibility(n);
        viewQwon.setVisibility(n);
        qwon.setVisibility(n);
    }

    public void controles()
    {
        //CASTEOS IMG
        star = findViewById(R.id.star);
        img = findViewById(R.id.img);
        marcoImg = findViewById(R.id.marcoImg);
        rankImgg = findViewById(R.id.rankImg);

        //CASTEOS VIEWS
        username = findViewById(R.id.username);
        level = findViewById(R.id.level);
        rankk = findViewById(R.id.rank);
        viewLevel = findViewById(R.id.viewLevel);
        viewRank = findViewById(R.id.viewRank);
        viewcomp = findViewById(R.id.viewcomp);
        viewcomphs = findViewById(R.id.viewcomphs);
        viewquickhs = findViewById(R.id.viewquickhs);
        viewqc = findViewById(R.id.viewck);
        viewWon = findViewById(R.id.viewWon);
        viewLost = findViewById(R.id.viewLost);
        viewDraw = findViewById(R.id.viewDraw);
        won = findViewById(R.id.won);
        lost = findViewById(R.id.lost);
        draw = findViewById(R.id.draw);
        viewQwon = findViewById(R.id.viewQwon);
        qwon = findViewById(R.id.qwon);
    }

    public void setType()
    {
        //SET TYPEFACE
        final Typeface t2 = Typeface.createFromAsset(getAssets(),"fonts/koverwatch.ttf");
        cargando.setTypeface(t2);
        username.setTypeface(t2);
        level.setTypeface(t2);
        rankk.setTypeface(t2);
        viewLevel.setTypeface(t2);
        viewRank.setTypeface(t2);
        viewcomp.setTypeface(t2);
        viewcomphs.setTypeface(t2);
        viewquickhs.setTypeface(t2);
        viewqc.setTypeface(t2);
        viewWon.setTypeface(t2);
        viewLost.setTypeface(t2);
        viewDraw.setTypeface(t2);
        won.setTypeface(t2);
        lost.setTypeface(t2);
        draw.setTypeface(t2);
        viewQwon.setTypeface(t2);
        qwon.setTypeface(t2);
    }

}
