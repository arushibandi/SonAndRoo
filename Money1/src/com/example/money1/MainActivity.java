package com.example.money1;

import java.text.DecimalFormat;
import android.*;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.usage.UsageEvents.Event;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.money101.R;

public class MainActivity extends ActionBarActivity {

	
	//money variables
	private double totalSpent;
	private double totalGain;
	private double moneyInBank;
	private double originalBalance;
	private double spentOnClothes;
	private double spentOnFood;
	private double spentOnFun;
	private double spentOnGas;
	private double spentAtPark;
	private double spentOnSports;
	private double spentAtCafe;
	private double spentAtIceCream;
	private double spentAtOffice;
	private double spentAtSchool;
	private double spentOnOther;
	
	//used in the citymap image
	private double tapX;
	private double tapY;
	
	//the user's input
	private String spentInput;
	
	//the user interface temporary variables
	private View v;
	private Context c;
	private double tempAddition;
	private Builder tempBuilder;
	
	//Method executed when button 'Add Money' is clicked
	
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
		    	String userText = input.getText().toString();
		    	System.out.println("pd: " + Double.parseDouble(userText));
		    	addToTotalGain(Double.parseDouble(userText));
		    	updateInBank();
		    }
		});
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		        dialog.cancel();
		    }
		});

		builder.show();
		
	}
	
	//Method executed when button 'Spend Money' is clicked
	
	public void spendMoney(View view) {
		
		v = view;
		c = this;
		
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
		    	spentInput = input.getText().toString();
		    	System.out.println("pd: " + Double.parseDouble(spentInput));
		    	addToTotalSpent(Double.parseDouble(spentInput));
		    	updateInBank();
		    	tempAddition = Double.parseDouble(spentInput);
		    	
		    	AlertDialog.Builder placeBuild = new AlertDialog.Builder(c);
				placeBuild.setMessage("Select the place on the map where you are spending the money.");
				
				placeBuild.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
				    @Override
				    public void onClick(DialogInterface dialog, int which) {
				    	
				    	showLocSpent(v);
				    	
				    }
				});
				
				placeBuild.show();
		    	
		    }
		});
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		        dialog.cancel();
		    }
		});
	
		builder.show();
	
	}
	
	//Displays Account Balance
	public void setBalance() {
		
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtBalance);
	    textView.setText("Balance: " + String.valueOf(df.format(moneyInBank)));

	}
	
	//The following methods display the amount at each location in textViews
	public void setFoodBalance() {
		
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentOnFood);
	    textView.setText("Spent on Food: " + String.valueOf(df.format(spentOnFood)));

	}
	
	public void setClothesBalance() {
		
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentOnClothes);
	    textView.setText("Spent on CLothes: " + String.valueOf(df.format(spentOnClothes)));

	}
	
	public void setFunBalance() {
		
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentonFun);
	    textView.setText("Spent on Fun: " + String.valueOf(df.format(spentOnFun)));

	}
	
	public void setGasBalance() {
		
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentOnGas);
	    textView.setText("Spent on Gas: " + String.valueOf(df.format(spentOnGas)));

	}
	
	public void setWorkBalance() {
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentAtWork);
	    textView.setText("Spent at Work: " + String.valueOf(df.format(spentAtOffice)));
	}
	
	public void setParkBalance() {
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentAtPark);
	    textView.setText("Spent at Park: " + String.valueOf(df.format(spentAtPark)));
	}
	
	public void setIceCreamBalance() {
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentOnIceCream);
	    textView.setText("Spent on IceCream: " + String.valueOf(df.format(spentAtIceCream)));
	}
	
	public void setSportsBalance() {
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentOnSports);
	    textView.setText("Spent on Sports: " + String.valueOf(df.format(spentOnSports)));
	}
	
	public void setCafeBalance() {
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentAtCafe);
	    textView.setText("Spent at Cafe: " + String.valueOf(df.format(spentAtCafe)));
	}
	
	public void setSchoolBalance() {
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentAtSchool);
	    textView.setText("Spent at School: " + String.valueOf(df.format(spentAtSchool)));
	}
	
	public void setOtherBalance() {
		DecimalFormat df = new DecimalFormat("##.00");
	    TextView textView = (TextView) findViewById(R.id.txtSpentOnIceCream);
	    textView.setText("Spent on Other: " + String.valueOf(df.format(spentOnOther)));
	}
	
	//show how much has been spent at a specific location
	
	public void showLocSpent(View view) {
		
		c = this;
		
		ImageView img = (ImageView) findViewById(R.id.citymap);
		
		img.setOnTouchListener(new View.OnTouchListener() {
		
			public boolean onTouch(View v, MotionEvent event) {
	            System.out.println("Touch coordinates : " +
	                        String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
	            System.out.println("Spent at " + CityCoordinates.getLocation(event.getX(), event.getY()));
	            
	            
	            tapX = event.getX();
	            tapY = event.getY();
	            
	            DecimalFormat df = new DecimalFormat("##.00");
	    		Builder builder = new AlertDialog.Builder(c);
	    		builder.setMessage("You have spent this much money " +  CityCoordinates.getLocation(tapX, tapY) + ": $" + df.format(chooseLocation(CityCoordinates.getLocation(tapX, tapY), tempAddition)));
	    		
	    		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
					} 
	 
	    		    
	    		});
	    		
				builder.show();
				tempAddition = 0;
	    		return false;
	            
			
			}

		});
		
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
	
	public double chooseLocation(String name, double addition) {
		
		switch(name) {
			case "on sports":
				setSportsBalance();
				return addToSports(addition);
			case "at the park":
				setParkBalance();
				return addToPark(addition);
			case "at school":
				setSchoolBalance();
				return addAtSchool(addition);
			case "at the office & work":
				setWorkBalance();
				return addToOffice(addition);
			case "on the carnival & fun":
				setFunBalance();
				return addToFun(addition);
			case "at the cafe & restaurant":
				setCafeBalance();
				return addToCafe(addition);
			case "on food & groceries":
				setFoodBalance();
				return addToFood(addition);
			case "at the ice cream shop":
				setIceCreamBalance();
				return addToIceCream(addition);
			case "on gas":
				setGasBalance();
				return addToGas(addition);
			case "on clothes":
				setClothesBalance();
				return addToClothes(addition);
		}
		
		return addition;
		
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
	
	public double addToClothes(double addition) 
	{
		spentOnClothes = spentOnClothes + addition;
		return spentOnClothes;
	}
	
	public double addToFood(double addition)
	{
		spentOnFood = spentOnFood + addition;
		return spentOnFood;
	}
	
	public double addToFun(double addition)
	{
		spentOnFun = spentOnFun + addition;
		return spentOnFun;
	}
	
	public double addToGas(double addition)
	{
		spentOnGas = spentOnGas + addition;
		return spentOnGas;
	}
	
	public double addToPark(double addition)
	{
		spentAtPark = spentAtPark + addition;
		return spentAtPark;
	}
	
	public double addToSports(double addition)
	{
		spentOnSports = spentOnSports + addition;
		return spentOnSports;
	}
	
	public double addToCafe(double addition)
	{
		spentAtCafe = spentAtCafe + addition;
		return spentAtCafe;
	}
	
	public double addToIceCream(double addition)
	{
		spentAtIceCream = spentAtIceCream + addition;
		return spentAtIceCream;
	}
	
	public double addToOffice(double addition)
	{
		spentAtOffice = spentAtOffice + addition;
		return spentAtOffice;
	}
	
	
	public double addAtSchool(double addition)
	{
		spentAtSchool = spentAtSchool + addition;
		return spentAtSchool;
	}
	
	public double addToOther(double addition)
	{
		spentOnOther = spentOnOther + addition;
		return spentOnOther;
	}
	
	public void updateInBank()
	{
		moneyInBank = originalBalance - totalSpent + totalGain;
		System.out.println("MiB" + moneyInBank);
		setBalance();
	}

}
