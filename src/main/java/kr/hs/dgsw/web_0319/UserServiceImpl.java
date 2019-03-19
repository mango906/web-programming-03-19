package kr.hs.dgsw.web_0319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("userid1", "user1", "user1@dgsw.hs.kr"));
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(String id) {
        User found = null;
        for (int i = 0; i < this.userList.size(); i++) {
            found = this.userList.get(i);
            if (found.getId().equals(id))
                return found;
        }
        return null;
    }

    public boolean isIdFounded(String id) {
        for (int i = 0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public User find1(String name) {
        Iterator<User> iterator = this.userList.iterator();
        while (iterator.hasNext()) {
            User found = iterator.next();
            if (found.getName().equals(name)) {
                return found;
            }
        }
        return null;
    }

    public User find2(String name) {
        for (User found : this.userList) {
            if (found.getName().equals(name)) {
                return found;
            }
        }
        return null;
    }

    public String find3(String name) {
        User found = this.userList.stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
        return null;
    }

    @Override
    public boolean add(User user) {
        System.out.println(isIdFounded(user.getId()));
        if (!isIdFounded(user.getId())) {
            return this.userList.add(user);
        }
        return false;
    }

    @Override
    public User update(User user) {
        User found = this.view(user.getId());
        if (found != null)
            found.setName(user.getName());
        found.setEmail(user.getEmail());
        return found;
    }

    @Override
    public boolean delete(String id) {
        User found = this.view(id);
        return this.userList.remove(found);
    }
}
