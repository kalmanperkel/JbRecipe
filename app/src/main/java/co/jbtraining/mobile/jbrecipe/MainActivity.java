package co.jbtraining.mobile.jbrecipe;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListViewFragment listViewFragment = new ListViewFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isPhone()) {
            fragmentTransaction.add(R.id.maincon, listViewFragment);
        } else {
            fragmentTransaction.add(R.id.listviewCon, listViewFragment);
            RecipeFragment recipeFragment = new RecipeFragment();
            fragmentTransaction.add(R.id.recipeCon, recipeFragment);
        }
        fragmentTransaction.commit();

    }


    public boolean isPhone() {
        boolean isPhone = true;
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.maincon);
        if (layout == null) {
            isPhone = false;
        }

        return isPhone;
    }

    public void changeRecipe(Recipe recipe) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final RecipeFragment recipeFragment = new RecipeFragment();
        recipeFragment.title = recipe.name;
        recipeFragment.body = recipe.body;
        recipeFragment.position = recipe.postition;
        final ListViewFragment listViewFragment = new ListViewFragment();


        if (isPhone()) {


            fragmentTransaction.replace(R.id.maincon, recipeFragment);
        } else {
            fragmentTransaction.replace(R.id.recipeCon, recipeFragment);
        }
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

        ListViewFragment listViewFragment = new ListViewFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isPhone()) {
            fragmentTransaction.replace(R.id.maincon, listViewFragment);
        }
        fragmentTransaction.commit();

    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
