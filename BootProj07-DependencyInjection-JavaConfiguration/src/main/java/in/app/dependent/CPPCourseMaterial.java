package in.app.dependent;

import javax.inject.Named;

@Named("cpp")
public final class CPPCourseMaterial implements ICourseMaterial {

	@Override
	public String courseContent() {
		return "CPP";
	}

	@Override
	public double price() {
		return 3500;
	}

}
