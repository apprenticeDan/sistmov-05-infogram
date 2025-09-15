package org.sismo.infogram.views;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.sismo.infogram.R;
import org.sismo.infogram.views.fragments.*;

import java.util.Map;
import java.util.function.Supplier;

public class ContainerActivity extends AppCompatActivity {
    private final Map<Integer, Supplier<Fragment>> fragmentMap =
            Map.of(R.id.home_ic, HomeFragment::new,
                   R.id.profile_ic, ProfileFragment::new,
                   R.id.search_ic, SearchFragment::new);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_container);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bnavView = findViewById(R.id.bottom_nav_view);
        bnavView.setOnItemSelectedListener( item -> {
            Supplier<Fragment> supplier = fragmentMap.get(item.getItemId());
            if (supplier != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_frame, supplier.get())
                        .setReorderingAllowed(true)
                        .commit();
                return true;
            }
            return false;
        });

    }
}