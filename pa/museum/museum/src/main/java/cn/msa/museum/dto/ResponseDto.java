package cn.msa.museum.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<T> {

    private Integer code = 0;

    private String message = "success";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data = null;

    public ResponseDto(T data) {
        this.data = data;
    }
}
