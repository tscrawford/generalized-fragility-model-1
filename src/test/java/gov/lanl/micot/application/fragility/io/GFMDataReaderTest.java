package gov.lanl.micot.application.fragility.io;

import com.fasterxml.jackson.databind.JsonNode;
import gov.lanl.micot.application.fragility.core.GeometryObject;
import gov.lanl.micot.application.utilities.asset.PropertyData;
import gov.lanl.micot.application.utilities.gis.HazardField;
import gov.lanl.micot.application.utilities.gis.RasterField;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GFMDataReaderTest extends TestCase {

    GFMDataReader gfmdr = new GFMDataReader();

    public void testGFMDataReaderSingle() throws Exception {

        // single file input test
        String[] fp = new String[1];
        String[] ip = new String[1];
        ip[0] = "ice";
        fp[0] = "test_data/fields/windField_example.asc";
        ArrayList<HazardField> hazardObjects1 = gfmdr.readHazardFile(fp,ip);
        assertTrue(!hazardObjects1.isEmpty());

    }

    public void testGFMDataReaderSingleTiff() throws Exception {

        // single file input test
        String[] fp = new String[1];
        String[] ip = new String[1];
        ip[0] = "ice";
        fp[0] = "test_data/fields/windField_example.tif";
        ArrayList<HazardField> hazardObjects1 = gfmdr.readHazardFile(fp,ip);
        assertTrue(!hazardObjects1.isEmpty());

    }

    public void testGFMDataReaderMultiple() throws Exception {


        // multiple file input test
        String[] fp1 = new String[2];
        String[] ip1 = new String[2];
        ip1[0] = "ice";
        ip1[1] = "wind";
        fp1[0] = "test_data/fields/iceField_example.asc";
        fp1[1] = "test_data/fields/windField_example.asc";

        ArrayList<HazardField> hazardObjects2 = gfmdr.readHazardFile(fp1,ip1);
        assertTrue(!hazardObjects2.isEmpty());

    }

    public void testGFMDataReaderAssets(){
        gfmdr.readGeoJsonFile("test_data/inputs/example_poles.json");
        ArrayList<GeometryObject> dataAssets = gfmdr.getGeometryObjects();
        assertTrue(!dataAssets.isEmpty());

        List<Map<String, PropertyData>> props = gfmdr.getProperties();
        assertTrue(!props.isEmpty());
    }
}