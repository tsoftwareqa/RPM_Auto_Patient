package com.rpm.test.page_objects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class PatientsObject extends PageObject {

	public static Target SELECT_CASE = Target.the("select case")
			.locatedBy("(//span[@class='text-sm'])[2]");
	public static Target CONTINUE = Target.the("continuye")
			.locatedBy("//button[contains(text(),'Continue with case')]");
	public static Target TREND = Target.the("trend")
			.locatedBy("//button[contains(text(),'Trends')]");
	public static Target STEP_COUNT = Target.the("step count")
			.locatedBy("(//span[@class='font-bold text-base'])[1]");
	public static Target CHART_TAB = Target.the("Chart")
			.locatedBy("//button[contains(text(),'Chart')]");
	public static Target RECENT_HISTORY = Target.the("recent history")
			.locatedBy("(//h5[contains(text(),'Recent Medical History')])[2]//following::span[@class='w-fit text-sm font-semibold']");

	public static Target COMPLETE_DOCUMENTATION = Target.the("Complete")
			.locatedBy("//button[contains(text(),'Complete Documentation')]");
	public static Target ENCOUNTER = Target.the("Select Action")
			.locatedBy("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-11u53oe-MuiSelect-select-MuiInputBase-input-MuiOutlinedInput-input'])[1]");
	public static Target ENCOUNTER_TYPE = Target.the("Encounter type")
			.locatedBy("//li[contains(text(),'Follow-Up')]");
	public static Target DIAGNOSIS = Target.the("Diagnosis")
			.locatedBy("//input[@placeholder='Add diagnosis/condition']");
	public static Target ADD_DIAGNOSIS = Target.the("Diagnosis")
			.locatedBy("//span[@class='text-primary font-medium text-sm cursor-pointer w-fit']");
	public static Target PRACTITIONER_FINDING = Target.the("Practitioner")
			.locatedBy("//textarea[@id=':r2:']");
	public static Target ACTION = Target.the("Select Action")
			.locatedBy("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-11u53oe-MuiSelect-select-MuiInputBase-input-MuiOutlinedInput-input'])[2]");
	public static Target SELECT_ACTION = Target.the("Select Action")
			.locatedBy("//li[contains(text(),'No Visit Required')]");
	public static Target URGENCY = Target.the("Select Action")
			.locatedBy("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-11u53oe-MuiSelect-select-MuiInputBase-input-MuiOutlinedInput-input'])[3]");	
	public static Target SELECT_URGENCY = Target.the("urgency")
			.locatedBy("//li[contains(text(),'Low')]");
	public static Target ADDITIONAL_COMMENT = Target.the("Additional comment")
			.locatedBy("//textarea[@id=':r5:']");
	public static Target PREVIEW_DOCUMENTATION = Target.the("Preview")
			.locatedBy("//button[contains(text(),'PREVIEW DOCUMENTATION')]");
	public static Target SIGN_OFF = Target.the("Sign off")
			.locatedBy("//button[contains(text(),'Proceed to Sign off')]");
	public static Target E_SIGN = Target.the("E sign")
			.locatedBy("//button[contains(text(),'ACCEPT ELECTRONIC SIGN')]");
	
	public static Target CROSS_ICON = Target.the("Cross icon")
			.locatedBy("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-lc2yqr-MuiButtonBase-root-MuiIconButton-root']");
	
	public List<String> getRecentHistory() {
		return findAll(RECENT_HISTORY).stream().map(WebElementFacade::getText).collect(Collectors.toList());
	}
}