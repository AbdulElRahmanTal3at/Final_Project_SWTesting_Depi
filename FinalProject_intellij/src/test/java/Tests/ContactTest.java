package Tests;

import Base.TestBase;
import Pages.ContactUs;
import org.testng.annotations.Test;

public class ContactTest extends TestBase {
    ContactUs contactUs;
//    @Test
//    public void ClickContactUs(){
//        contactUs = new ContactUs(driver);
//        contactUs.navigate();
//        contactUs.ClickOnContactUs();
//    }
    @Test
    public void SumbitContactUs(){
        contactUs = new ContactUs(driver);
        contactUs.navigate();
        contactUs.ClickOnContactUs();
        contactUs.FillName("Abdulrahman");
        contactUs.FillEmail("SWTest@Depi.com");
        contactUs.FillSubject("Service");
        contactUs.FillMessage("ThanksForGoodService");
        contactUs.Sumbit();
        contactUs.ValidAlert("Press OK to proceed!");
    }
}
