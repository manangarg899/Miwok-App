package com.example.manan.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteControlClient;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.onClick;
import static android.R.attr.privateImeOptions;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompleteListner=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;


    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }

            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }

            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","mossokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter itemAdapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemAdapter);


        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Word word = words.get(position);

               int result = mAudioManager.requestAudioFocus(null, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
               if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                  releaseMediaPlayer();

                   mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAusioResourceId());
                   mediaPlayer.start();
                   mediaPlayer.setOnCompletionListener(mCompleteListner);

               }
           }

        });







    }
    private void releaseMediaPlayer()
    {

        if(mediaPlayer != null)
        {
            mediaPlayer.release();

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);


        }
        mediaPlayer=null;
    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
