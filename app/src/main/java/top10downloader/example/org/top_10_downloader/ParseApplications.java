package top10downloader.example.org.top_10_downloader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by work on 26.03.16.
 */
public class ParseApplications {

    private String data;
    private ArrayList<Application> applications;
    private String tagName;
    public Application currentRecord;

    public  ParseApplications(String xmlData) {
        data = xmlData;
        applications = new ArrayList<Application>();
    }


    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean proces(){
        boolean operationStatus = true;
        this.currentRecord = new Application();

        boolean inEntry = false;
        String textValue = "";

        try {
//setup basic xml parser
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
 //setup its input to parse
            xpp.setInput(new StringReader(this.data));
            int eventType = xpp.getEventType();
            while ((eventType != XmlPullParser.END_DOCUMENT)){

                if(eventType == XmlPullParser.START_TAG){
                    this.tagName = xpp.getName();

                    if(this.tagName.equalsIgnoreCase("entry")){
                        inEntry = true;
                        currentRecord = new Application();
                    }

                }
                else if(eventType == XmlPullParser.TEXT){


                    if(this.tagName.equalsIgnoreCase("name")){

                        if (currentRecord != null && currentRecord.getName() == null) {
                            this.currentRecord.setName(xpp.getText());

                        }
                    } else if(this.tagName.equalsIgnoreCase("artist")){

                        if (currentRecord != null && currentRecord.getArtist() == null) {
                            this.currentRecord.setArtist(xpp.getText());

                        }
                    } else if(this.tagName.equalsIgnoreCase("releaseDate")){

                        if (this.currentRecord != null  && currentRecord.getReleaseDate() == null) {

                            this.currentRecord.setReleaseDate(xpp.getText());
                        }
                    } else if(this.tagName.equalsIgnoreCase("image")){

                        if (this.currentRecord != null && currentRecord.getImage() == null) {

                            this.currentRecord.setImage(xpp.getText());
                        }
                    }


                }
                else if(eventType == XmlPullParser.END_TAG){

                    if(this.tagName.equalsIgnoreCase("content") && inEntry == true) {
//                        Log.i("record ", "name is --"+this.currentRecord.getName()+"///image is"+this.currentRecord.getImage());

                        applications.add(this.currentRecord);
                        inEntry = false;
                    }


                }

                eventType = xpp.next();
            }


        }catch (Exception e){
            e.printStackTrace();
            operationStatus = false;
        }

//        for(Application app : applications){
//            Log.i("LOG", "********");
//            Log.i("LOG", app.getName());
//            Log.i("LOG", app.getArtist());
//            Log.i("LOG", app.getReleaseDate());
//            Log.i("LOG", app.getImage());
//
//
//
//        }

        return operationStatus;
    }
}
