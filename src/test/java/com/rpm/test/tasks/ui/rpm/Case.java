package com.rpm.test.tasks.ui.rpm;

import java.util.Map;

import com.rpm.test.page_objects.PatientsObject;
import com.rpm.test.utils.ConvertCucumberDataTable;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class Case extends UIInteractions implements Task {

	
	public static Case fromUnderlineDetails() {
		return new Case();
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Click.on(PatientsObject.COMPLETE_DOCUMENTATION));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.ENCOUNTER));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.ENCOUNTER_TYPE));
		waitABit(1000);
				
		actor.attemptsTo(Enter.keyValues("Condition is good").into(PatientsObject.DIAGNOSIS));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.ADD_DIAGNOSIS));
		waitABit(1000);
		
		actor.attemptsTo(Scroll.to(PatientsObject.PREVIEW_DOCUMENTATION));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Everything is good").into(PatientsObject.PRACTITIONER_FINDING));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.ACTION));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.SELECT_ACTION));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.URGENCY));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.SELECT_URGENCY));
		waitABit(1000);
		
		actor.attemptsTo(Enter.keyValues("Additional Comment is fine").into(PatientsObject.ADDITIONAL_COMMENT));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.PREVIEW_DOCUMENTATION));
		waitABit(3000);
		
		actor.attemptsTo(Scroll.to(PatientsObject.SIGN_OFF));
		waitABit(1000);
		
		actor.attemptsTo(Click.on(PatientsObject.SIGN_OFF));
		waitABit(2000);
		
		actor.attemptsTo(Click.on(PatientsObject.E_SIGN));
		waitABit(4000);
		
		actor.attemptsTo(Click.on(PatientsObject.CROSS_ICON));
		waitABit(2000);
	}

}
