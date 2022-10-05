package tk.mybatis.mapper;

import tk.mybatis.pojo.SysRole;

import javax.management.relation.Role;
import java.util.List;

public interface RoleMapper {
    /**
     * 查询角色的权限信息
     *
     * @return
     */
    List<SysRole> selectAllRoleAndPrivileges();


    /**
     * 根据用户ID获取用户的角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRoleByUserIdChoose(Long userId);


    int updateById(SysRole sysRole);

    SysRole selectById(Long id);
}
