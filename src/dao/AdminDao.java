package dao;

import domain.Admin;

import java.util.List;

public interface AdminDao  {
    // 登陆
    public Admin login(Admin admin) throws Exception;
    public List<Admin> queryAll() throws Exception;
    public void save(Admin admin) throws Exception;
}
