
public class User {
	
	private double totalSpent;
	private double totalGain;
	private double spentOnClothes;
	private double spentOnFood;
	private double spentOnFun;
	private double moneyInBank;
	
	public User(double startingAmount)
	{
		totalSpent = 0;
		totalGain = 0;
		spentOnClothes = 0;
		spentOnFood = 0;
		spentOnFun = 0;
		moneyInBank = startingAmount;
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
		moneyInBank = moneyInBank - totalSpent + totalGain;
	}

}
