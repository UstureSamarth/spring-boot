package in.app.service;

import in.app.dao.ILoginDao;

public class LoginServiceImpl implements ILoginService {

	private ILoginDao dao;
	
	
	public LoginServiceImpl(ILoginDao dao) {
		super();
		this.dao = dao;
	}


	@Override
	public Boolean login(String username, String password) throws Exception {

		if(username.equals("") || password.equals("") || username.length()==0 || password.length()==0)
			throw new IllegalArgumentException("Provide Credentials");
		Integer result=dao.authenticate(username, password);
		if(result==0)
			return false;
		return true;
	}

}
