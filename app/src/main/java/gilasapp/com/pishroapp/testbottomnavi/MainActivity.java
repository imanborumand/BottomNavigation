package gilasapp.com.pishroapp.testbottomnavi;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    UserFragment userFragment;
    CardFragment cardFragment;
    NotificationFragment notificationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.frame_layout_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_main);
        userFragment = new UserFragment();
        notificationFragment = new NotificationFragment();
        cardFragment = new CardFragment();

        setFragment(cardFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_card:
                        setFragment(cardFragment);
                        return  true;
                    case R.id.item_user:
                        setFragment(userFragment);
                        return true;
                    case R.id.item_notify:
                        setFragment(notificationFragment);
                        return true;
                }
                return false;
            }
        });

    }


    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main,fragment);
        fragmentTransaction.commit();

    }

}
