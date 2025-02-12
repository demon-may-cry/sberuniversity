package ru.sberuniversity.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityDTO {
    private Integer number;
    private List<Integer> sequence;
    private Integer sum;
}
