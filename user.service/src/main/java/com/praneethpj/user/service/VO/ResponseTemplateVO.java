package com.praneethpj.user.service.VO;

import com.praneethpj.user.service.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Users user;
    private Department department;
}
