package edu.csueb.android.zoodirectory;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AnimalDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        TextView animalName = findViewById(R.id.animalName);
        ImageView animalImage = findViewById(R.id.animalImage);
        TextView animalDescription = findViewById(R.id.animalDescription);

        Animal animal = (Animal) getIntent().getSerializableExtra("animal");

        if (animal != null) {
            animalName.setText(animal.getName());
            animalImage.setImageResource(animal.getImage());
            animalDescription.setText(animal.getDescription());
        }
    }
}
