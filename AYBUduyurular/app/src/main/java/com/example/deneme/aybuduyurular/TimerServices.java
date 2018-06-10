package com.example.deneme.aybuduyurular;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Fatih Furkan on 28.04.2018.
 */

public class TimerServices extends IntentService {


    String aaa="";
    String aaa1="";
    String aaa2="";
    String aaa3="";
    String arr[] = new String[2];
    String arr1[] = new String[2];
    String arr2[] = new String[2];
    String arr3[] = new String[2];

    String array[] = new String[2];
    String array1[] = new String[2];
    String array2[] = new String[2];
    String array3[] = new String[2];


    ArrayList<String> arraylist;
    public ListView announce;
    public ArrayList<String> announcement;
    public ArrayList<String> links;
    public ListView newsList;
    public ArrayList<String> news;
    public ArrayList<String> links1;
    int connection=0;
    int count=1;

    public TimerServices(){
        super("Timer Service");
      
    }



    @Override
    public void onCreate(){
        super.onCreate();

        Log.v( "timer", "Timer service has started." );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId ){
    super.onStartCommand( intent,flags,startId );
    return START_STICKY;
    }



    @Override
    protected void onHandleIntent(Intent intent){

        // program calısmazken
        arr[0] = "";
        arr[1] = "";
        arr1[0] = "";
        arr1[1] = "";
        arr2[0] = "";
        arr2[1] = "";
        arr3[0] = "";
        arr3[1] = "";

        // program calısırken
        array[0]="";
        array[1]="";
        array1[0]="";
        array1[1]="";
        array2[0]="";
        array2[1]="";
        array3[0]="";
        array3[1]="";

        if(intent == null){


            int j=0;
            boolean time1 = true;
          //  for(int i=0; i<time ; i++){

            while(time1 == true){
                Log.v("timer", "i(null) = " + j++);


                try{
                    Thread.sleep( 3000 );
                }catch (Exception e){

                }

                new AsyncHttpTask().execute( "www.google.com" );

                while (connection == 1){ //baglı degıl
                    try{
                        Thread.sleep( 3000 );
                        new AsyncHttpTask().execute( "www.google.com" );
                    }catch (Exception e){

                    }

                }

                new Description().execute(); // pastane
                new Description1().execute(); // yemek
                new Description2().execute(); // haberler
                new Description3().execute(); // duyurular




                if (!aaa.equals( "" ) && !aaa.equals( null )){


                    if( !array[0].equals( "" )){
                        array[0]=array[1];
                        array[1] = aaa;
                    }

                    if (array[0].equals( "" ) ){
                        array[0] = aaa;
                    }


                    if(!array[1].equals( "" ) && !array[0].equals( array[1] ) ){

                  //  Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa);

                    Intent intent1 = new Intent(this, MainActivity.class);
                    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

                    Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder nb = new NotificationCompat.Builder(this);

                    nb.setContentText( aaa);
                        nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                    nb.setSmallIcon( R.drawable.not );
                    nb.setSound( uri );
                    nb.setColor(Color.parseColor("#3f51b5"));
                    nb.setLights( Color.CYAN, 3000, 3000 );


                    NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
                    nm.notify( 1,nb.build() );

                }

                }


                if (!aaa1.equals( "" ) && !aaa1.equals( null )){


                    if( !array1[0].equals( "" )){
                        array1[0]=array1[1];
                        array1[1] = aaa1;
                    }

                    if (array1[0].equals( "" ) ){
                        array1[0] = aaa1;
                    }


                    if(!array1[1].equals( "" ) && !array1[0].equals( array1[1] ) ){

                        Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa1);

                    Intent intent1 = new Intent(this, MainActivity.class);
                    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                    Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
                    nb.setContentText( aaa1);
                        nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                    nb.setSmallIcon( R.drawable.not );
                    nb.setSound( uri );
                    nb.setColor(Color.parseColor("#3f51b5"));
                    nb.setLights( Color.CYAN, 3000, 3000 );


                    NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
                    nm.notify( 1,nb.build() );

                }

                }


                if (!aaa2.equals( "" ) && !aaa2.equals( null )){


                    if( !array2[0].equals( "" )){
                        array2[0]=array2[1];
                        array2[1] = aaa2;
                    }

                    if (array2[0].equals( "" ) ){
                        array2[0] = aaa2;
                    }


                    if(!array2[1].equals( "" ) && !array2[0].equals( array2[1] ) ){

                        Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa2);

                    Intent intent1 = new Intent(this, MainActivity.class);
                    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                    Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
                    nb.setContentText( aaa2);
                        nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                    nb.setSmallIcon( R.drawable.not );
                    nb.setSound( uri );
                    nb.setColor(Color.parseColor("#3f51b5"));
                    nb.setLights( Color.CYAN, 3000, 3000 );


                    NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
                    nm.notify( 1,nb.build() );

                }

                }


                if (!aaa3.equals( "" ) && !aaa3.equals( null )){


                    if( !array3[0].equals( "" )){
                        array3[0]=array3[1];
                        array3[1] = aaa3;
                    }

                    if (array3[0].equals( "" ) ){
                        array3[0] = aaa3;
                    }


                    if(!array3[1].equals( "" ) && !array3[0].equals( array3[1] ) ){

                        Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa3);

                    Intent intent1 = new Intent(this, MainActivity.class);
                    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                    Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
                    nb.setContentText( aaa3);
                        nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                    nb.setSmallIcon( R.drawable.not );
                    nb.setSound( uri );
                    nb.setColor(Color.parseColor("#3f51b5"));
                    nb.setLights( Color.CYAN, 3000, 3000 );


                    NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
                    nm.notify( 1,nb.build() );

                }

                }


            }
            return;

        }


        int time = intent.getIntExtra( "time",0 );


        boolean time2 = true;
        int i1=0;

        while (time2 == true){

      //  fo
            // r(int i=0; i<time ; i++){
          //  Log.v("timer", "i = " + i1++);

            try{
                Thread.sleep( 3000 );
            }catch (Exception e){

            }

            new AsyncHttpTask().execute( "www.google.com" );
            while (connection == 1){
                try{
                    Thread.sleep( 3000 );
                    new AsyncHttpTask().execute( "www.google.com" );
                }catch (Exception e){

                }

            }


            new Description().execute();
            new Description1().execute();
            new Description2().execute();
            new Description3().execute();




            if (!aaa.equals( "" ) && !aaa.equals( null )){


                if( !arr[0].equals( "" )){
                    arr[0]=arr[1];
                    arr[1] = aaa;
                }

                if (arr[0].equals( "" ) ){
                    arr[0] = aaa;
                }


            Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa);

            if(!arr[1].equals( "" ) && !arr[0].equals( arr[1] ) ){
                Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa);

                Intent intent1 = new Intent(this, MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
                nb.setContentText( aaa);
                nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                nb.setSmallIcon( R.drawable.not );
                nb.setSound( uri );
                nb.setColor(Color.parseColor("#3f51b5"));
                nb.setLights( Color.CYAN, 3000, 3000 );
             //   nb.addAction( R.drawable.not, "Deneme", pIntent );

                NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
                nm.notify( 1,nb.build() );

            }
            }


            if (!aaa1.equals( "" ) && !aaa1.equals( null )){


                if( !arr1[0].equals( "" )){
                    arr1[0]=arr1[1];
                    arr1[1] = aaa1;
                }

                if (arr1[0].equals( "" ) ){
                    arr1[0] = aaa1;
                }


                if(!arr1[1].equals( "" ) && !arr1[0].equals( arr1[1] ) ){
                    Log.v( "asdsdsdsadsdasad", "dsdsasdads" + aaa1 );

                    Intent intent1 = new Intent( this, MainActivity.class );
                    PendingIntent pIntent = PendingIntent.getActivity( this, 0, intent1, 0 );
                    Uri uri = RingtoneManager.getDefaultUri( RingtoneManager.TYPE_NOTIFICATION );
                    NotificationCompat.Builder nb = new NotificationCompat.Builder( this );
                    nb.setContentText( aaa1 );
                    nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                    nb.setSmallIcon( R.drawable.not );
                    nb.setSound( uri );
                    nb.setColor( Color.parseColor( "#3f51b5" ) );
                    nb.setLights( Color.CYAN, 3000, 3000 );


                    NotificationManager nm = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
                    nm.notify( 1, nb.build() );

                }
            }



            if (!aaa2.equals( "" ) && !aaa2.equals( null )){


                if( !arr2[0].equals( "" )){
                    arr2[0]=arr2[1];
                    arr2[1] = aaa2;
                }

                if (arr2[0].equals( "" ) ){
                    arr2[0] = aaa2;
                }




                if(!arr2[1].equals( "" ) && !arr2[0].equals( arr2[1] ) ){
                Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa2);

                Intent intent1 = new Intent(this, MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
                nb.setContentText( aaa2);
                nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                nb.setSmallIcon( R.drawable.not );
                nb.setSound( uri );
                nb.setColor(Color.parseColor("#3f51b5"));
                nb.setLights( Color.CYAN, 3000, 3000 );


                NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
                nm.notify( 1,nb.build() );

            }

            }



            if (!aaa3.equals( "" ) && !aaa3.equals( null )){


                if( !arr3[0].equals( "" )){
                    arr3[0]=arr3[1];
                    arr3[1] = aaa3;
                }

                if (arr3[0].equals( "" ) ){
                    arr3[0] = aaa3;
                }




                if(!arr3[1].equals( "" ) && !arr3[0].equals( arr3[1] ) ){
                Log.v("asdsdsdsadsdasad", "dsdsasdads" + aaa3);

                Intent intent1 = new Intent(this, MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
                nb.setContentText( aaa3);
                nb.setContentTitle( "AYBU DUYURULAR GÜNCELLENDİ!!!" );
                nb.setSmallIcon( R.drawable.not );
                nb.setSound( uri );
                nb.setColor(Color.parseColor("#3f51b5"));
                nb.setLights( Color.CYAN, 3000, 3000 );

                NotificationManager nm = (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
                nm.notify( 1,nb.build() );

            }

            }





        }


    }



    public class AsyncHttpTask extends AsyncTask<String, Void, Integer>{

        protected Integer doInBackground(String... params) {
            Integer result=0;
            try{
                Thread.sleep( 3000 );
                Socket s = new Socket( params[0], 80 );
                s.close();
                result=1;

            }catch (Exception e){
                result =0;
            }
            return  result;
        }

        protected void onPostExecute(Integer result) {
            if(result==1){
                //Toast.makeText( getApplicationContext(),"connected",Toast.LENGTH_SHORT ).show();
                connection=0;
            }
            else{
                //Toast.makeText( getApplicationContext(),"not connected",Toast.LENGTH_SHORT ).show();
                connection =1;
            }
        }
    }


    private class Description extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            arraylist = new ArrayList<String>();
            try {



         //       URL url = new URL("http://ybu.edu.tr/sks");
           //     Document doc = Jsoup.parse(url, 3000);
             //   Element table = doc.select("table").first();
                //  Iterator<Element> ite = table.select("td").iterator();

                URL url = new URL("http://www.genclerpastanesi.com/index.php");
                Document doc = Jsoup.parse(url, 3000);
                Element table = doc.select("ul").first();

                Iterator<Element> ite = table.select("li").iterator();

                ite.next();
                while(ite.hasNext()){
                    //System.out.println("Value 1: " + ite.next().text());
                    arraylist.add(ite.next().text());


                }

                // first one is image, skip it
                // Connect to the Website URL

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
            //  TextView txtdesc = (TextView) findViewById(R.id.desctxt);
            String a="";
            for(int i=0;i<arraylist.size();i++){
                a=a+"\n"+arraylist.get(i).toString();
            }
           // foodList.setText(a);
         aaa =a;
        }
    }


    private class Description1 extends AsyncTask<Void, Void, Void> {
        String desc;
        ArrayList<String> arraylist;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            arraylist = new ArrayList<String>();
            try {



                URL url = new URL("http://ybu.edu.tr/sks");
                Document doc = Jsoup.parse(url, 3000);
                Element table = doc.select("table").first();

                Iterator<Element> ite = table.select("td").iterator();

                ite.next();
                while(ite.hasNext()){
                    //System.out.println("Value 1: " + ite.next().text());
                    arraylist.add(ite.next().text());


                }

                // first one is image, skip it
                // Connect to the Website URL

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
            //  TextView txtdesc = (TextView) findViewById(R.id.desctxt);
            String a="";
            for(int i=0;i<arraylist.size();i++){
                a=a+"\n"+arraylist.get(i).toString();
            }

            aaa1 = a;
        }
    }


    private class Description2  extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params)  {

            try {


                announcement= new ArrayList<String>();

                Document document = Jsoup.connect("http://www.ybu.edu.tr/muhendislik/bilgisayar/").get();
                Element masthead = document.select("div.caContent").first();
                Iterator<Element> ite = masthead.select("div.cncItem").iterator();
                //ite.next();

                while(ite.hasNext()){
                    Element div =ite.next();
                    announcement.add(div.text());

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){

            String a="";
            for(int i=0;i<announcement.size();i++){
                a=a+"\n"+announcement.get(i).toString();
            }
            // foodList.setText(a);
            aaa2 =a;
        }



        }


    private class Description3 extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {

            try {



                news= new ArrayList<String>();

                Document document = Jsoup.connect("http://www.ybu.edu.tr/muhendislik/bilgisayar/").get();
                Element masthead = document.select("div.cnContent").first();
                Iterator<Element> ite = masthead.select("div.cncItem").iterator();


                while(ite.hasNext()){
                    Element div =ite.next();
                    news.add(div.text());

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            String a="";
            for(int i=0;i<news.size();i++){
                a=a+"\n"+news.get(i).toString();
            }

            aaa3 =a;
        }

        }
    }


