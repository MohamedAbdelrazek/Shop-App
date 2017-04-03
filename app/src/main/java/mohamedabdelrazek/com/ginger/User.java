package mohamedabdelrazek.com.ginger;

import android.graphics.Bitmap;

/**
 * Created by Mohamed AbdelraZek on 4/3/2017.
 */

public class User {
    private Bitmap bmp;

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    public User()
    {

    }

    public User(Bitmap b) {
        bmp = b;

    }

    public Bitmap getBitmap() {
        return bmp;
    }

}
