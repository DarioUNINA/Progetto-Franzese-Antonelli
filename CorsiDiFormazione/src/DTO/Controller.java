package CorsiDiFormazione;

public class Controller {
	
	//classi dao

	private HomePage homePage;
	
	public static void main(String[] args) {
		

		
		Controller controller = new Controller();
		
	}
	
	public Controller() {
		
		homePage = new HomePage(this);
		System.out.println("si");
		
	}

}
