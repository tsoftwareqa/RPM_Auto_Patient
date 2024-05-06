package com.rpm.test.tasks.ui.rpm;

import com.rpm.test.page_objects.ClinicianObject;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class Case extends UIInteractions implements Task {

	
	public static Case fromUnderlineDetails() {
		return new Case();
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Click.on(ClinicianObject.COMPLETE_DOCUMENTATION));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.ENCOUNTER));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.ENCOUNTER_TYPE));
		waitABit(1000);
				
		actor.attemptsTo(Enter.keyValues("Condition is good").into(ClinicianObject.DIAGNOSIS));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.ADD_DIAGNOSIS));
		waitABit(1000);
		
		actor.attemptsTo(Scroll.to(ClinicianObject.PREVIEW_DOCUMENTATION));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Everything is good").into(ClinicianObject.PRACTITIONER_FINDING));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.ACTION));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.SELECT_ACTION));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.URGENCY));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.SELECT_URGENCY));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Additional Comment is fine").into(ClinicianObject.ADDITIONAL_COMMENT));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.PREVIEW_DOCUMENTATION));
		waitABit(3000);
		
		actor.attemptsTo(Scroll.to(ClinicianObject.SIGN_OFF));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(ClinicianObject.SIGN_OFF));
		waitABit(2000);
		
		actor.attemptsTo(Click.on(ClinicianObject.E_SIGN));
		waitABit(4000);
		
		actor.attemptsTo(Click.on(ClinicianObject.CROSS_ICON));
		waitABit(2000);
	}

}
