package edu.csueb.android.zoodirectory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private Context context;
    private List<Animal> animals;

    public AnimalAdapter(Context context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.animalName.setText(animal.getName());
        holder.animalThumbnail.setImageResource(animal.getThumbnail());

        holder.itemView.setOnClickListener(v -> {
            if (animal.getName().equalsIgnoreCase("Lion") || animal.getName().equalsIgnoreCase("Tiger")) {
                new AlertDialog.Builder(context)
                        .setTitle("Warning")
                        .setMessage("The animal is very scary. Do you want to proceed?")
                        .setPositiveButton("Yes", (dialog, which) -> launchDetailActivity(animal))
                        .setNegativeButton("No", null)
                        .show();
            } else {
                launchDetailActivity(animal);
            }
        });
    }

    private void launchDetailActivity(Animal animal) {
        Intent intent = new Intent(context, AnimalDetailActivity.class);
        intent.putExtra("animal", animal);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView animalThumbnail;
        TextView animalName;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            animalThumbnail = itemView.findViewById(R.id.animalThumbnail);
            animalName = itemView.findViewById(R.id.animalName);
        }
    }
}