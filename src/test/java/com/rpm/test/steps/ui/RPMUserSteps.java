package com.rpm.test.steps.ui;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;
import java.util.logging.Logger;
import com.rpm.test.page_objects.HomePage;
import com.rpm.test.page_objects.PatientsObject;
import com.rpm.test.questions.ui.ApplicationEnquiryResult;
import com.rpm.test.tasks.ui.common.Login;
import com.rpm.test.tasks.ui.rpm.Case;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.core.pages.ClearContents;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.ClearBy;
import net.serenitybdd.screenplay.actions.ClearElement;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.model.util.EnvironmentVariables;

public class RPMUserSteps extends UIInteractionSteps{

	private static Logger logger = Logger.getLogger(RPMUserSteps.class.getName());
	static EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();

	private Actor appAdmin;
	private HomePage homepage;
	private PatientsObject patObject;
	
	@Before(order = 2)
	public void setup() {
		appAdmin = OnStage.theActor("AA");
	}
	
	@Given("{word} is on Home page of application and login")
	public void user_is_on_home_page_of_application_and_login(String role) {
		appAdmin.assignName(role);
		givenThat(appAdmin).attemptsTo(Login.withAgencyAdminCredentials());
	}
	
	@When("{word} verify dashboard label")
	public void verify_validation_message(String role) {
		givenThat(appAdmin).attemptsTo(Ensure.that("Dashboard Label", ApplicationEnquiryResult.hasDashBoardLabel())
				.isEqualTo("Lets complete patient cases for Ez Digital"));
		waitABit(2000);
	}
	
	@Given("{word} is on Home page of application and login with invalid credentials")
	public void is_on_Home_page_of_application_and_login_with_invalid_credentials(String role) {
		appAdmin.assignName(role);
		givenThat(appAdmin).attemptsTo(Login.withAgencyInvalidAdminCredentials());
	}

	@When("{word} verify error validation message")
	public void verify_error_validation_message(String role) {
		givenThat(appAdmin).attemptsTo(Ensure.that(homepage.INVALID_LOGIN_ERROR_MESSAGE.resolveFor(appAdmin).getTextValue())
				.isEqualTo("Wrong email or password"));
	}
	
	@When("{word} clicks on logout option")
	public void clicks_on_logout_option(String role) {
		givenThat(appAdmin).attemptsTo(Click.on(homepage.DOWN_ARROW));
		givenThat(appAdmin).attemptsTo(Click.on(homepage.LOGOUT));
	}
	
	//verify logo
	@Given("{word} should logout from application and navigate to login screen")
	public void should_logout_from_application_and_navigate_to_login_screen(String role) {
		givenThat(appAdmin).attemptsTo(Ensure.that(homepage.APP_LOGO).isDisplayed());
	}
	
	@Given("{word} continue with case")
	public void continue_with_case(String role) {
		appAdmin.assignName(role);
		givenThat(appAdmin).attemptsTo(Click.on(PatientsObject.SELECT_CASE));
		waitABit(2000);
		givenThat(appAdmin).attemptsTo(Scroll.to(PatientsObject.CONTINUE).andAlignToBottom());
		waitABit(2000);
		givenThat(appAdmin).attemptsTo(Click.on(PatientsObject.CONTINUE));
		waitABit(2000);
	}
	
	@Given("Verify Vitals Data")
	public void Verify_Vitals_Data() {
		givenThat(appAdmin).attemptsTo(Click.on(PatientsObject.TREND));
		waitABit(2000);
		Ensure.that(PatientsObject.STEP_COUNT).isDisplayed();
		waitABit(3000);
	}
	
	@Given("Verify Chart Data")
	public void Verify_Chart_Data() {
		givenThat(appAdmin).attemptsTo(Click.on(PatientsObject.CHART_TAB));
		waitABit(2000);
		givenThat(appAdmin).attemptsTo(Scroll.to(PatientsObject.RECENT_HISTORY).andAlignToBottom());
		List<String> getList = patObject.getRecentHistory();
		int size =  getList.size();
		Ensure.that(size).isNotEqualTo(0);
		waitABit(3000);
	}
	
	@Given("Verify complete documentation")
	public void Verify_complete_documentation() {
		givenThat(appAdmin).attemptsTo(Case.fromUnderlineDetails());
		
	}
}
