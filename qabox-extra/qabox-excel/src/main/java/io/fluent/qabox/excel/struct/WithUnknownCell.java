package io.fluent.qabox.excel.struct;

import com.poiji.annotation.ExcelUnknownCells;
import lombok.Data;

import java.util.Map;

/**
 *
 */
@Data
@Deprecated
public class WithUnknownCell {
    @ExcelUnknownCells
    private Map<String, String> unknownCells;
}
