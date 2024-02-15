package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.idm.utils.Payload;
import io.restassured.path.json.JsonPath;

public class TC {
	JsonPath js = new JsonPath(Payload.getcourses());

	@Test
	public void getCoursePrice() {
		int amount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(amount, 910);
	}

	@Test
	public void getTotalCourseNo() {
		int count = js.getInt("courses.size()");
		Assert.assertEquals(count, 3);
	}

	@Test
	public void getAllCoursesTitle() {
		int count = js.getInt("courses.size()");
		for (int i = 0; i < count; i++) {
			String title = js.getString("courses[" + i + "].title");
			System.out.println("Course title are " + title);
			if (title.equalsIgnoreCase("RPA")) {
				String price = js.getString("courses[" + i + "].price");
				System.out.println("RPA course price is " + price);
				break;
			}

		}
	}

}
