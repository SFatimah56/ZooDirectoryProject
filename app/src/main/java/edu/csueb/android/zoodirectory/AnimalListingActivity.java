package edu.csueb.android.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimalListingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listing);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Setup animals data and adapter
        List<Animal> animals = getAnimals();
        adapter = new AnimalAdapter(this, animals);
        recyclerView.setAdapter(adapter);

        // Set OnClickListener for phoneNumber TextView
        TextView phoneNumberTextView = findViewById(R.id.phoneNumber);
        phoneNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace with your actual phone number
                String phoneNumber = getResources().getString(R.string.phone_number_000_0000);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:000-0000"));
                startActivity(intent);
            }
        });
    }

    // Method to populate animals data (replace with your actual data source)
    private List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Lion", "Lions are the second largest cats after tigers. They come in red, yellow, tan, and brown colors. Lions live in prides with an average of 13 members.", R.drawable.lion_thumb, R.drawable.lion));
        animals.add(new Animal("Elephant", "Elephants have great memory, powerful trunks, and great hearing. They hear through their feet. They love to swim and use dirt as protection from the sun.", R.drawable.elephant_thumb, R.drawable.elephant));
        animals.add(new Animal("Giraffe", "Giraffes have multiple stomachs. They sleep 40 minutes a day. They fight with their necks.", R.drawable.giraffe_thumb, R.drawable.giraffe));
        animals.add(new Animal("Zebra", "Each zebra has their own striped pattern. They fight together as a circle. They are endangered.", R.drawable.zebra_thumb, R.drawable.zebra));
        animals.add(new Animal("Tiger", "Tigers are the largest cats in the world. They were voted the world's favorite animal in 2004. They like to swim and hunt alone.", R.drawable.tiger_thumb, R.drawable.tiger));
        return animals;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_information) {
            // Launch ZooInformationActivity when the "Information" menu item is selected
            Intent intent = new Intent(this, ZooInformationActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_uninstall) {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
