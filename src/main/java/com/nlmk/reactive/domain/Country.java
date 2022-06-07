package com.nlmk.reactive.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Country {
    @Id
    private Long id;
    private String name;
    private Boolean hot;
}
