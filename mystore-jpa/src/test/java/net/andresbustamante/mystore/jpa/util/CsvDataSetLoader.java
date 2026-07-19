package net.andresbustamante.mystore.jpa.util;

import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.CsvDataFileLoader;
import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;

/**
 * CSV dataset loader implementation for DBUnit.
 */
public final class CsvDataSetLoader extends AbstractDataSetLoader {

    @Override
    protected IDataSet createDataSet(final Resource resource) throws Exception {
        return new CsvDataFileLoader().loadDataSet(resource.getURL());
    }
}
