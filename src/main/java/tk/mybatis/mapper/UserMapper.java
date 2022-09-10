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
     * @param map
     * @return
     */
    int updateByMap(Map<String, Object> map);
}
