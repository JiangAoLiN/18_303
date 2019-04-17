package service;


import domain.Admin;

public interface AdminService {
    public Admin login(Admin admin) throws Exception;

    /**
     * 加密并保存数据
     * @param admin
     * @throws Exception
     */
    public void save(Admin admin) throws Exception;
}
