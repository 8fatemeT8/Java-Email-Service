package com.example.email.dto;

import com.example.email.dto.EmailDto;

public class EmailWithLinkDto extends EmailDto {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
