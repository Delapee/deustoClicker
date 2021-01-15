package es.b04.game.adminTables;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.DefaultListModel;
import es.b04.game.log.User;


public class UserListModel extends DefaultListModel<User> {

	private static final long serialVersionUID = 1619152286982152009L;

	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		
		Enumeration<User> it = this.elements();
		while (it.hasMoreElements()) {
			users.add(it.nextElement());
		}
		
		return users;
	}
}
