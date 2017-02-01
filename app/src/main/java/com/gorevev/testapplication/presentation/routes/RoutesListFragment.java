package com.gorevev.testapplication.presentation.routes;

import android.support.annotation.NonNull;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.IBasePresenter;
import com.gorevev.testapplication.presentation.common.Layout;

import javax.inject.Inject;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Layout(R.layout.fragment_routes)
public class RoutesListFragment extends BaseFragment {

    @Inject
    IRoutesListPresenter presenter;

    @NonNull
    @Override
    protected IBasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject() {
        App.getInstance().getRoutesListComponent(this);
    }
}
