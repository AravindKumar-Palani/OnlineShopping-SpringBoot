package com.eshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class CommonResponse {

    private String statusCode;
    private String statusMessage;
}
