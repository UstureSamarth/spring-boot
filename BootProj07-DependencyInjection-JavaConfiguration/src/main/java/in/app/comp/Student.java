package in.app.comp;

import javax.inject.Inject;
import javax.inject.Named;

import in.app.dependent.ICourseMaterial;

@Named
public class Student {

	/*
	 * @Resource(name = "cpp") private ICourseMaterial material;
	 */
	
	@Inject
	@Named(value = "courseID")
	private ICourseMaterial material;

	public void preparation(String examName) {
		System.out.println(material.getClass().getName());
		String content = material.courseContent();
		double price = material.price();
		System.out.println(content + " " + price);
	}
}
