package edu.cnm.bootcamp.itajan.helloworldandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import edu.cnm.bootcamp.itajan.helloworldandroid.R;
import edu.cnm.bootcamp.itajan.helloworldandroid.api.models.Image;
import java.util.List;

public class ImageListAdapter extends BaseAdapter {
  private Context context;
  private List<Image> images;

  public ImageListAdapter(Context context, List<Image> images) {
    this.context = context;
    this.images = images;
  }

  @Override
  public int getCount() {
    return (images != null) ? images.size() : 0;
  }

  @Override
  public Object getItem(int position) {
    return (images != null && position < images.size())
        ? images.get(position)
        : null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.image_list_items, parent, false);
    }

    Object item = getItem(position);
    if (item != null) {
      Image image = (Image)item;

      TextView txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
      TextView txtDescription = (TextView)convertView.findViewById(R.id.txtDescription);

      txtTitle.setText(image.getTitle());
      txtTitle.setText(image.getDescription());
    }
    return convertView;
  }
}
