package exportutil;

import java.util.List;

public interface Exportable {
    List<String> getExportableColumnNames();
    List<String> getExportableColumnValues();
}
