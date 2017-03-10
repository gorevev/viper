package com.gorevev.testapplication.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseActivity;
import com.gorevev.testapplication.presentation._common.Layout;

import butterknife.BindView;
import ru.terrakok.cicerone.Navigator;

@Layout(R.layout.activity_main)
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, IMainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        return App.getInstance().getMainComponent().mainPresenter();
    }

    @Override
    protected Navigator createNavigator() {
        return new MainNavigator(this, R.id.content);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getInstance().getMainComponent().inject(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed(drawer.isDrawerOpen(GravityCompat.START));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.side_menu_item_orders) {
            presenter.showOrders();
        } else if (id == R.id.side_menu_item_search_orders) {
            presenter.showSearchOrders();
        } else if (id == R.id.side_menu_item_logout) {
            presenter.logout();
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void closeSideMenu() {
        drawer.closeDrawer(GravityCompat.START);
    }
}
