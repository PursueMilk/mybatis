package tk.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.pojo.SysPrivilege;
import tk.mybatis.pojo.SysRole;
import tk.mybatis.pojo.SysUser;

import java.util.List;

public class RoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectAllRoleAndPrivileges() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roleList = roleMapper.selectAllRoleAndPrivileges();
            System.out.println("角色数" + roleList.size());
            for (SysRole role :roleList) {
                System.out.println("角色名：" + role.getRoleName());
                for (SysPrivilege privilege :role.getPrivilegeList()) {
                    System.out.println("权限名：" + privilege.getPrivilegeName());
                }
            }
        } finally {
            //关闭session
            sqlSession.close();
        }
    }
}
