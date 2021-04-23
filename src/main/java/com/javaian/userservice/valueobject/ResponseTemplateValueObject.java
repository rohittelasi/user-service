package com.javaian.userservice.valueobject;

import com.javaian.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObject {

    private User user;
    private Department department;
}
