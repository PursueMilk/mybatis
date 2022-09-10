package tk.mybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;
}
