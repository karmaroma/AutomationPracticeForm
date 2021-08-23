package formTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTest {

    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.startMaximized = true;
    }

    @Test
    void FillFormTest(){
        open("automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("Doe@gmail.com");
        $("#genterWrapper").$(byText("Other")).click();
        /*
          $("[name=gender][value=Other]").parent().click();
          $("#gender-radio-3").parent().click();
          $(byValue("Other")).parent().click();
          $(byText("Other")).click(); // gender
         */

        $("#userNumber").setValue("0002128506");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1917");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
         /*
        $$(".react-datepicker__day--028")
                .filter(not(cssClass(".react-datepicker__day--outside-month"))).first().click();
        $("[aria-label='Choose Thursday, July 28th, 2005']").click();
        $x("//*[contains(@aria-label, 'July 28th, 2005')]").click();
        */
        $("#subjectsInput ").val("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("./img/1.png");
        $("#currentAddress").val("PushkinStreet Kolotushkin House apt.19"); //val = setValue
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("John Doe"),
                text("30 June,1917"),
                text("PushkinStreet Kolotushkin House apt.19"),
                text("1.png"),
                text("NCR Delhi"),
                text("Other"),
                text("Computer Science"),
                text("Doe@gmail.com"),
                text("0002128506")
        );


    }
}
