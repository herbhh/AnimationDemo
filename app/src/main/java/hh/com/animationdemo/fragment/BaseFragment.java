package hh.com.animationdemo.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import hh.com.animationdemo.MainActivity;

public class BaseFragment extends Fragment {

    protected MainActivity mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = (MainActivity) context;
    }
}
