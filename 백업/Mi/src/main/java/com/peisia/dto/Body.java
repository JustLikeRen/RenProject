
package com.peisia.dto;

import lombok.Data;

@Data
public class Body {

    public String dataType;
    public Items items;
    public Integer pageNo;
    public Integer numOfRows;
    public Integer totalCount;

}
