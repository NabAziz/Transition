package materialdesign.practice.com.recyclerfragment.Interface;

import android.view.View;
import android.widget.TextView;

import materialdesign.practice.com.recyclerfragment.Util.ModelClass;

public interface HolderClickListener {

    void holderClicked(View v, int position);//, ModelClass modelClass, TextView sharedTextView);
}
