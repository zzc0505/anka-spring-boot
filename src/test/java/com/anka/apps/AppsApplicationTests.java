package com.anka.apps;

import org.junit.Test;
import org.junit.runner.RunWith;
import tk.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anka.apps.model.CoreUser;
import com.anka.apps.service.CoreUserService;
import com.anka.base.utils.PassSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.anka.apps.mapper")
public class AppsApplicationTests {
	
	@Autowired
	private CoreUserService coreUserService;
	
    @Test
    public void testInsert() throws Exception {
    	CoreUser user = new CoreUser();
    	user.setCrurName("张三");
    	user.setCrurPassword(PassSecurity.getEncode("123456", "ANKA"));
    	user.setCrurSex("1");
    	user.setCrurMobile("13111111111");
    	user.setCrurEmail("zzc0505@qq.com");
    	coreUserService.save(user);
    	System.out.println(user.getCrurUuid());
    }

}

