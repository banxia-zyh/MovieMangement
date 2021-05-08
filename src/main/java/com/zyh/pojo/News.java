package com.zyh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/20/0020 15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private int id;
    private String name;
    private String type;
    private String content;
}
