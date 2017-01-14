package package2;

import java.security.acl.Permission;

public interface DAOInterface {
	public void add(persion p);
	public void delete(persion p);
	public persion search(int id);
	public void update(persion p);
}
