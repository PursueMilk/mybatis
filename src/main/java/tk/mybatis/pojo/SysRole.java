package tk.mybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private Long id;
    private String roleName;
    private Integer enabled;
    private Long createBy;
    private Date createTime;
}
