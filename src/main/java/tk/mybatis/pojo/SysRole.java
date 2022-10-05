package tk.mybatis.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysRole {

    /**
     * 角色包含的权限列表
     */
    private List<SysPrivilege> privilegeList;
    private Long id;
    private String roleName;
    private Integer enabled;
    private CreateInfo createInfo;
}
