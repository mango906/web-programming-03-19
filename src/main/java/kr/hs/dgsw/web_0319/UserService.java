package kr.hs.dgsw.web_0319;

import java.util.List;

public interface UserService {
    List<User> list();

    User view(String name);

    boolean add(User user);

    User update(User user);

    boolean delete(String name);
}
