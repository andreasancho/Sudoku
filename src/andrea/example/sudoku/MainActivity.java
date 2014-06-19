package andrea.example.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface; 
import android.util.Log;

public class MainActivity extends Activity implements OnClickListener{
	private static final String TAG = "Sudoku";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up click listeners for all the buttons
		View continueButton = findViewById(R.id.continue_button); 
		continueButton.setOnClickListener(this);
		View newButton = findViewById(R.id.new_button); 
		newButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button); 
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button); 
		exitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu); 
		MenuInflater inflater = getMenuInflater(); 
		inflater.inflate(R.menu.main_menu, menu); 
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) { 
			case R.id.action_settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
			// More items go here (if any) ... 
			}
			return false;
	}

		
	public void onClick(View v) { 
		switch (v.getId()) {
			case R.id.about_button:
				Intent i = new Intent(this, About.class); 
				startActivity(i);
				break;
			case R.id.new_button: 
				openNewGameDialog(); 
				break;
			case R.id.exit_button: 
				finish();
				break;
	      // More buttons go here (if any) ...
		} 
	}
	
	private void openNewGameDialog() { 
		// The setItems( ) method takes two parameters: 
		//the resource ID of the item list 
		//and a listener that will be called when one of the items is selected.
		new AlertDialog.Builder(this).setTitle(R.string.new_game_title).setItems(R.array.difficulty,new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface, int i) {
			       startGame(i);
			    }
			}).show();
	}
	
	private void startGame(int i) { 
		Log.d(TAG, "clicked on " + i); // Start game here...
	}

}
