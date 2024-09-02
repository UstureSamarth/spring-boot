package in.app.dependent;

import javax.inject.Named;

@Named("java")
public final class JavaCourseMaterial implements ICourseMaterial {

	@Override
	public String courseContent() {
		return "JAVA";
	}

	@Override
	public double price() {
		return 2500;
	}

}
