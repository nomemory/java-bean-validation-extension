package net.andreinc.jbvext.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeActionResponse<T> {
    private T response;
    private long time;
}
