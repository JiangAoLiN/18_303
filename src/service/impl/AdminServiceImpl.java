package service.impl;


import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import domain.Admin;
import org.junit.Test;
import service.AdminService;
import utils.PasswordUtils;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) throws Exception {
        // 此处加密
        String pwd = PasswordUtils.md5(admin.getPassword(),admin.getName());
        // 放回对象中
        admin.setPassword(pwd);
        return dao.login(admin);
    }

    @Override
    public void save(Admin admin) throws Exception {
        // 此处加密
        String pwd = PasswordUtils.md5(admin.getPassword(),admin.getName());
        // 放回对象中
        admin.setPassword(pwd);
        // 调dao来保存
        dao.save(admin);
    }
    @Test
    public void test1() throws Exception {
        AdminService service = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setName("jiang");
        admin.setPassword("1234");

        System.out.println(service.login(admin));
    }

    @Test
    public void test2() throws Exception {
        AdminService service = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setName("rose");
        admin.setPassword("1234");
        admin.setLimits(2);
        service.save(admin);
    }
}
