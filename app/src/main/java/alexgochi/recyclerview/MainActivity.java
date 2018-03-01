package alexgochi.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mWordList = new LinkedList<>();
    private int mCount =0;

    private RecyclerView mRecycleView;
    private WordListAdapter mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        for (int i=1; i<=20; i++) {
//            mWordList.addLast("Word" + mCount++);
//            Log.d("WordList", mWordList.getLast());
//        }

        // Get a handle to the RecyclerView.
        mRecycleView = (RecyclerView) findViewById(R.id.recycleview);
        // Create an adapter and supply the data to be displayed.
        mAdpater = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView.
        mRecycleView.setAdapter(mAdpater);
        // Give the RecyclerView a default layout manager.
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        // Add a floating action click handler for creating	new	entries.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                // Add a new word to the end of	the	wordList.
                mWordList.addLast("+ Clicked "+ wordListSize);
                // Notify the adapter, that	the	data has changed so	it can
                // update the RecyclerView to display the data.
                mRecycleView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                mRecycleView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}
