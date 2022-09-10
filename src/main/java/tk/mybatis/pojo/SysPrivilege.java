package tk.mybatis.pojo;

import lombok.Data;

@Data
public class SysPrivilege {
    private Long id;
    private String privilegeName;
    private String privilegeUrl;
}
