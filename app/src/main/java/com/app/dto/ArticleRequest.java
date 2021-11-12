package com.app.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ArticleRequest {

    @NotBlank(message = "title is mandatory")
    @Size(max = 100, message = "max length - 100 chars")
    private String title;

    @NotBlank(message = "author is mandatory")
    private String author;

    @NotBlank(message = "address is mandatory")
    private String content;

    @NotBlank(message = "date is mandatory")
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}$",
            message = "date is not valid - use format \"yyyy-MM-dd\" ")
    private String datePublishing;

}
