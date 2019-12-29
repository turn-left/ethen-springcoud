package com.ethen;

import com.ethen.entity.UserEntity;
import com.ethen.repository.UserRepository;
import com.ethen.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class EthenSpringcloudJpaStudyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsertData() {
        List<UserEntity> userList = new LinkedList<>();
        for (int i = 0; i < 2000000; i++) {
            UserEntity userEntity = new UserEntity();
            String name = StringUtil.getName();
            userEntity.setAge(18);
            userEntity.setFirstName(name);
            userEntity.setLastName(name);
            userEntity.setEmail("hiyoyo@sina.com");
            userEntity.setSex(i % 3 == 0 ? "男" : "女");
            userList.add(userEntity);
        }
        userRepository.saveAll(userList);
    }

    @Test
    public void testLoadBigData() {
        List<UserEntity> userList = userRepository.findAll();
        byte[] bytes = userList.toString().getBytes();
        System.err.println("len=>" + bytes.length);
    }

}
