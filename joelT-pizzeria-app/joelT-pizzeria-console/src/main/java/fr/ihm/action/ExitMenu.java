package fr.ihm.action;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class ExitMenu extends Action {

	@PostConstruct
	public void init() {
		this.setDescription("Sortir");
	}

	@Override
	public void doAction() {
		System.out.println("AU REVOIR :'(");
		fr.console.PizzeriaAdminConsoleApp.Arret = true;
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
