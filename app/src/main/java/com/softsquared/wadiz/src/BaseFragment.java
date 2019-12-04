package com.softsquared.wadiz.src;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;

import com.softsquared.wadiz.R;

public abstract class BaseFragment extends Fragment {
    public ProgressDialog mProgressDialog;
    public AppCompatDialog progressDialog;
    public void showCustomToast(final Context context, final String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    public void showProgressDialog(Activity activity) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(activity);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}