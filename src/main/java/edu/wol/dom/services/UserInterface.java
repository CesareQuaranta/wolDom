package edu.wol.dom.services;

import edu.wol.dom.User;
import edu.wol.dom.commands.Command;
import edu.wol.dom.space.Position;

public interface UserInterface {
	public User loadUser(String username);
	public void moveUser(User user,Position pos);
	public void rotateUser(User user,Position newHorizon);
	public void executeUserCommand(User user,Command com);
	public void addUserListner(User user,UserEventListener listener);
	public void removeUserListner(User user,UserEventListener listener);
}
