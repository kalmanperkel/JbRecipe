package co.jbtraining.mobile.jbrecipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class ListViewFragment extends Fragment {


    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list_view, container, false);

        ListView lv = (ListView) v.findViewById(R.id.listView);
        final ArrayList<Recipe> recipes = new ArrayList<>();


        Recipe recipe = new Recipe("Heat canola oil in a very large skillet or wok over medium heat. Add garlic and ginger; cook and stir until fragrant, 1 to 2 minutes. Add ground beef; cook and stir until browned and crumbly, 5 to 7 minutes.\n" +
                "Push ground beef to 1 side of skillet and add white cabbage, red cabbage, carrots, and red bell pepper. Mix vegetables with the beef and cook, stirring occasionally, until vegetables are just tender, 5 to 6 minutes.\n" +
                "Stir soy sauce, sesame oil, and hot sauce into beef-vegetable mixture until well mixed; season with salt and pepper. Serve slaw with fresh cilantro, lime wedge, and more hot sauce.", "Home Style Macaroni and Cheese");

        recipe.postition = "32.056803,34.779255";


        Recipe recipe1 = new Recipe("Combine tea, pineapple, cantaloupe, pear, yogurt, and mint leaves in a blender. Blend until smooth.", "Mighty Melon Green Tea Smoothie");
        recipe1.postition = "32.057594,34.778230";

        Recipe recipe3 = new Recipe("Combine tea, berries, pineapple, banana, lemon juice, mint, and honey in a blender. Blend until smooth.", "Very Berry Tea Smoothie");
        recipe3.postition = "32.057426,34.776980";

        recipes.add(recipe);
        recipes.add(recipe1);
        recipes.add(recipe3);

        final ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, recipes);

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Recipe recipe2 = recipes.get(position);
                MainActivity main = (MainActivity) getActivity();
                main.changeRecipe(recipe2);
                adapter.notifyDataSetChanged();

            }
        });


        return v;


    }

}
