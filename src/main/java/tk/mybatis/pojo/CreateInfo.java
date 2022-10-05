package tk.mybatis.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 创建信息
 */
@Data
public class CreateInfo {
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;
}
