package LabSD;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import LabSD.User;

@WebService
public interface SOAPI {

	@WebMethod
	public List<User> getUsers();
	
	@WebMethod
	public void addUser(User user);
	
}