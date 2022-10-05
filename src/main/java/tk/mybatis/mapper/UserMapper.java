package tk.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.pojo.SysRole;
import tk.mybatis.pojo.SysUser;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户id获取角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);


    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);


    /**
     * 根据主键更新
     *
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);


    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);


    /**
     * 新增用户-获取数据库生成的id
     *
     * @param sysUser
     * @return
     */
    int insert2(SysUser sysUser);


    /**
     * 新增用户-使用selectKey方式
     */
    int insert3(SysUser sysUser);


    /**
     * 多个参数传递
     *
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);


    /**
     * 根据动态条件查询用户信息
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectByUser(SysUser sysUser);


    /**
     * 根据主键更新
     *
     * @param sysUser
     * @return
     */
    int updateByIdSelective(SysUser sysUser);


    /**
     * 根据用户id或用户名查询
     *
     * @param sysUser
     * @return
     */
    SysUser selectByIdOrderUserName(SysUser sysUser);


    /**
     * 根据用户id集合查询
     *
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList(List<Long> idList);


    /**
     * 批量插入用户信息
     *
     * @param userList
     * @return
     */
    int insertList(List<SysUser> userList);


    /**
     * 通过Map更新列
     *
     * @param map
     * @return
     */
    int updateByMap(Map<String, Object> map);


    /**
     * 根据用户的id获取角色对象
     *
     * @param id
     * @return
     */
    SysUser selectUserAndRoleById(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息
     *
     * @param id
     * @return
     */
    SysUser selectUserAndRoleById2(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息
     *
     * @param id
     * @return
     */
    SysUser selectUserAndRoleById3(Long id);


    /**
     * 根据用户id获取用户信息和用户的角色信息，嵌套查询方式
     *
     * @param id
     * @return
     */
    SysUser selectUserAndRoleByIdSelect(Long id);


    /**
     * 获取所有的用户以及对应的所有角色
     *
     * @return
     */
    List<SysUser> selectAllUserAndRoles();


    /**
     * 获取所有的用户以及对应的所有角色以及权限
     *
     * @return
     */
    List<SysUser> selectAllUserAndRoles1();


    /**
     * 通过嵌套查询获取指定用户的信息以及用户的角色和权限信息
     * @param id
     * @return
     */
    SysUser selectAllUserAndRolesSelect(Long id);
}
