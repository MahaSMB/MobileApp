package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity implements
        PokemonInfoFetcher.infoFetchListener {

    // This page should portray details about one particular pokemon
    PokemonInfoFetcher pokemonInfoFetcher;
    JSONManager jsonManager;

    ArrayList<Pokemon> pokeList = new ArrayList<>(0);
    ArrayList<Pokemon> masterPokeList = new ArrayList<>(0);

    TextView tvDetailsPokeID, tvDetailsPokeName;
    ImageView ivDetailsPokeProfile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        tvDetailsPokeID = findViewById(R.id.tvDetailsPokeID);
        tvDetailsPokeName = findViewById(R.id.tvDetailsPokeName);
        ivDetailsPokeProfile = findViewById(R.id.ivDetailsPokeProfile);

        jsonManager = ((MyApp)getApplication()).jsonManager;
        //masterPokeList = ((MyApp)getApplication()).masterPokeList;

        Pokemon capturedPokemon = getIntent().getExtras().getParcelable("pokemon");
        this.setTitle(capturedPokemon.getPokeName());

        String spriteURL =  capturedPokemon.getPokeProfile();
        pokemonInfoFetcher = MyApp.pokemonInfoFetcherRecView;
        Bitmap bitmap =  pokemonInfoFetcher.downloadImage(spriteURL);

        tvDetailsPokeID.setText( String.valueOf( capturedPokemon.getPokeID()));
        tvDetailsPokeName.setText(capturedPokemon.getPokeName());
        ivDetailsPokeProfile.setImageBitmap(bitmap);
        Glide.with(this)
                .load(spriteURL)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.pokeball_background) //placeholder image
                        .error(R.drawable.error_image_foreground)  //error image in case of a loading error
                )
                .into(ivDetailsPokeProfile);

    }

    @Override
    public void infoFetchPokemonJSONObj(String result) {

    }

    @Override
    public void networkingFinishWithBitMapImage(Bitmap bitmap) {

    }

    @Override
    public void networkingFinishWithJSONString(String json) {
//        pokeList = jsonManager.fromJSONtoArrayListOfPokemon(json);
//        // Get the rest of the details for this particular pokemon
//        ArrayList masterPokeList = ((MyApp)getApplication()).jsonManager.fromJSONtoArrayListOfPokemon(json);
//        networkingManager.getPokemon();
    }

    @Override
    public Bitmap getBitmapFromSpriteURL(String spriteURL) {
        return null;
    }


    public void networkingFinishWithBitmapImage(Bitmap bitmapPic) {
        // wimage.setImageBitmap(bitmap);
    }
}