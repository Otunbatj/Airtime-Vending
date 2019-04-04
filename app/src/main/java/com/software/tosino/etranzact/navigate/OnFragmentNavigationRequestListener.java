package com.software.tosino.etranzact.navigate;

import android.content.Intent;
import android.support.v4.app.Fragment;

public interface OnFragmentNavigationRequestListener {
    void navigateFragment(Fragment newFragment, Object object);

    void showDialogFragment(Fragment fragment, Fragment targetFragment, int requestCode);

    void navigateActivity(Intent intent, boolean clearTask);
}