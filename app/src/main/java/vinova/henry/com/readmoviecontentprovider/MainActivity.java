package vinova.henry.com.readmoviecontentprovider;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String AUTHORITY = "vinova.henry.com.hotfilm.provider";
    String BASE_PATH = "movies";
    Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.tv_demo);

        ContentResolver contentResolver = this.getContentResolver();
        @SuppressLint("Recycle") Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        textView.setText(cursor.getString(cursor.getColumnIndex("title")));

    }
}
