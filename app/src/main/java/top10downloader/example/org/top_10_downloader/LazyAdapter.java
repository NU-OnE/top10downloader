package top10downloader.example.org.top_10_downloader;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by work on 26.03.16.
 */
public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Application> data;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;

    public LazyAdapter(Activity a, ArrayList<Application> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_item, null);

        TextView name = (TextView)vi.findViewById(R.id.name); // title
        TextView author = (TextView)vi.findViewById(R.id.author); // artist name
        TextView date = (TextView)vi.findViewById(R.id.date); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.imageView); // thumb image

        Application alapplication = new Application();
        alapplication = data.get(position);

        // Setting all values in listview
        name.setText(alapplication.getName());
        author.setText(alapplication.getArtist());
        date.setText(alapplication.getReleaseDate());
        imageLoader.DisplayImage(alapplication.getImage(), thumb_image);
        return vi;
    }
}
