package tk.mybatis.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysUser {

    /**
     * 用户的角色集合
     */
    private List<SysRole> roleList;
    /**
     * 用户角色
     */
    private SysRole role;
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;
}
