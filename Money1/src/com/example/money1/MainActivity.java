package com.example.money1;

import android.*;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.app.AlertDialog;
import android.app.usage.UsageEvents.Event;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	private String userText;
	
	//money variables
	private double totalSpent;
	private double totalGain;
	private double spentOnClothes;
	private double spentOnFood;
	private double spentOnFun;
	private double moneyInBank;
	private double originalBalance;
	
	public void addMoney(View view ) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("How much money would you like to add to your account?");

		// Set up the input
		final EditText input = new EditText(this);
		// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
		input.setInputType(InputType.TYPE_CLASS_TEXT);
		builder.setView(input);

		// Set up the buttons
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		    	userText = input.getText().toString();
		    }
		});
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		        dialog.cancel();
		    }
		});

		builder.show();
		
		System.out.println(userText);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addToTotalSpent(double addition)
	{
		totalSpent = totalSpent + addition;
	}
	
	public void addToTotalGain(double addition)
	{
		totalGain = totalGain + addition;
	}
	
	public double getTotalGain()
	{
		return totalGain;
	}
	
	public void addToClothes(double addition) 
	{
		spentOnClothes = spentOnClothes + addition;
	}
	
	public void addToFood(double addition)
	{
		spentOnFood = spentOnFood + addition;
	}
	
	public void addToFun(double addition)
	{
		spentOnFun = spentOnFun + addition;
	}
	
	public void updateInBank()
	{
		moneyInBank = originalBalance - totalSpent + totalGain;
		System.out.println("" + moneyInBank);
	}

}
