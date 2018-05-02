package com.seller.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.common.interfaces.BaseInter;
import com.common.utils.ActivityUtil;

public class MainActivity extends ZxingActivity
        implements BaseInter,
        NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    private final static String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
//    private FloatingActionButton floatingActionButton;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initForm();

//        User user = getUserApplication().getSimpleUser();
//        ToastUtil.showShort(getApplicationContext(), user.getUsername());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = getDrawerLayout();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == id_action_setting) {
//            showToastShort("setting");
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_camera:
                doContract();
                break;
            case R.id.nav_contract:
                showContracts();
                break;
            case R.id.nav_mine:
                ActivityUtil.startActivitySimple(this, MineActivity.class);
//                ToastUtil.showShort(this, "mine");
                break;
        }

        getDrawerLayout().closeDrawer(GravityCompat.START);
        return true;
    }

    private void showContracts() {
//        ToastUtil.showShort(this, "contract");
        ActivityUtil.startActivitySimple(MainActivity.this, ContractRecyclerActivity.class);
    }

    @Override
    public void initForm() {
        setDrawerLayout((DrawerLayout) findViewById(R.id.drawer_layout));

        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(getToolbar());

//        setFloatingActionButton((FloatingActionButton) findViewById(id_fab));
//        getFloatingActionButton().setOnClickListener(this);

        setNavigationView((NavigationView) findViewById(R.id.nav_view));
        getNavigationView().setNavigationItemSelectedListener(this);

        setImageButton((ImageButton) findViewById(R.id.imageButton));
        getImageButton().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                doContract();
                break;
            default:
                break;
        }
    }

    private void doContract() {
//        新建合同
        startCaptureActivityRunnable(MainActivity.this);
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }

    public void setNavigationView(NavigationView navigationView) {
        this.navigationView = navigationView;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

}
