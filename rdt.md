
# Resilience Design Tool (RDT) Input descriptions


These options are specific to RDT data and approximates poles locations along distribution lines.
    
```
-r      RDT proccessing option
-ro     generated poles output path (optional)    
-num    number of scenarios to generate - default is one (optional)
-so     scenario block file output (optional)

```

Example:

``` 
java -jar Fragility.jar -r test_data/inputs/example_rdt.json -i wind -e wind -hf test_data/fields/windField_example.asc -ro RDT_Poles.json -o repsonses.json -so SCENARIOS.json -num 13 
```