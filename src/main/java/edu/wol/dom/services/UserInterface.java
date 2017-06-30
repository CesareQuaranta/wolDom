package edu.wol.dom.services;

import edu.wol.dom.User;
import edu.wol.dom.WorldContainer;
import edu.wol.dom.commands.Command;
import edu.wol.dom.space.Position;

public interface UserInterface<W extends WorldContainer<?, ?>> {
	public User loadUser(String username);
	public W loadWol(long ID);
	public void moveUser(User user,Position pos);
	public void rotateUser(User user,Position newHorizon);
	public void executeUserCommand(User user,Command com);
	public void addUserListner(User user,UserEventListener listener);
	public void removeUserListner(User user,UserEventListener listener);
}
