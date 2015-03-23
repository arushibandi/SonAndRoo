package com.example.money1;

public class CityCoordinates {

	public static String getLocation(double x, double y) {
		
		if (isBetween(950,1180,x) && isBetween(0,425,y)) 
			return "at the zoo";
		else if (isBetween(630,860,x) && isBetween(0,140,y))
			return "at football games";
		else if((isBetween(0,560,x) && isBetween(0,115,y)) || (isBetween(0,275,x) && isBetween(0,415,y)))
			return "at the park";
		else if(isBetween(630,860,x) && isBetween(180,430,y))
			return "at school";
		else if(isBetween(340,520,x) && isBetween(215,400,y))
			return "at the office & work";
		else if(isBetween(330,480,x) && isBetween(470,645,y))
			return "on the carnival & fun";
		else if(isBetween(620,875,x) && isBetween(480,650,y))
			return "at the cafe & restaurant";
		else if(isBetween(950,1195,x) && isBetween(480,650,y))
			return "on food & groceries";
		else if(isBetween(430,570,x) && isBetween(650,750,y))
			return "at the ice cream shop";
		else if(isBetween(380,570,x) && isBetween(730,875,y))
			return "on gas";
		else
			return "other";
		
	}	
	
	public static boolean isBetween(double first, double second, double num) {
		if(num>first && num<second)
			return true;
		else
			return false;
	}

}
