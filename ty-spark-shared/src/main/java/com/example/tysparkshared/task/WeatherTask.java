package com.example.tysparkshared.task;

import static org.apache.spark.sql.functions.desc;

import java.util.List;

import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.springframework.stereotype.Service;

/**
 * Weather Task.
 * 
 * @author tcharass
 *
 */
@Service
public class WeatherTask {

	public List<Double> getMaxTemperatures(SparkSession spark) {
		// Define structure
		StructType weatherStructure = new StructType(
				new StructField[] { new StructField("date", DataTypes.StringType, false, Metadata.empty()),
						new StructField("temperaturemin", DataTypes.DoubleType, false, Metadata.empty()),
						new StructField("temperaturemax", DataTypes.DoubleType, false, Metadata.empty()) });

		String path = getClass().getClassLoader().getResource("rdu-weather-history.csv").getPath();

		return spark.read().format("csv").schema(weatherStructure).option("header", "true").option("delimiter", ";")
				.load(path).map(row -> row.getDouble(2), Encoders.DOUBLE()).distinct().sort(desc("value")).limit(10)
				.collectAsList();
	}

}
