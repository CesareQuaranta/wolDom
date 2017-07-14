package edu.wol.dom.services;

import java.io.IOException;
import java.util.Collection;

import edu.wol.dom.Phenomen;
import edu.wol.dom.User;
import edu.wol.dom.WolEntity;
import edu.wol.dom.WorldContainer;
import edu.wol.dom.commands.Command;
import edu.wol.dom.space.Position;
import edu.wol.dom.space.Vector3f;

public interface UserInterface<W extends WorldContainer<E, Position>,E extends WolEntity> {
	public User loadUser(String username) throws IOException, Exception;
	public void moveUser(User user,Position pos);
	public void rotateUser(User user,Position newHorizon);
	public void executeUserCommand(User user,Command com) throws IOException, Exception;
	public void addUserListner(User user,UserEventListener listener);
	public void removeUserListner(User user,UserEventListener listener);
	public Collection<Phenomen<E>> getAllPhenomen(long wolID) throws IOException, Exception;
}
