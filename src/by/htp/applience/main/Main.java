package by.htp.applience.main;

import by.htp.applience.controller.Controller;
import by.htp.applience.service.ServiceException;

public class Main {

	public static void main(String[] args) throws ServiceException {
		
		String command;
		String response;
		Controller controller = new Controller();
		
		command = "login login=Vados password=60547";
		response = controller.doAction(command);
		
		command = "findProduct Oven POWER_CONSUMPTION=1000";
		response = controller.doAction(command);
		System.out.println(response);
	}

}
