package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

	void start() {

		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		button1.setText("City");
		button2.setText("Weather Condition");
		button3.setText("Min and Max Temp");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// All city keys have the first letter capitalized of each word
		String cityName = Utilities.capitalizeWords("National City");
		WeatherData datum = weatherData.get(cityName);

		if (datum == null) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			String city = JOptionPane.showInputDialog("What city's weather do you want to search up");
			city = Utilities.capitalizeWords(city);
			if (weatherData.containsKey(city)) {
				WeatherData weather = weatherData.get(city);

				JOptionPane.showMessageDialog(null, city + "'s weather is " + weather.weatherSummary
						+ " the overall temperature is " + weather.temperatureF);
			}
		}
		if (e.getSource() == button2) {
			String forecast = JOptionPane.showInputDialog("What weather condition are you looking for");
			ArrayList<String> cities = new ArrayList<String>();
			String theCities = "The cities that have" + forecast + " weather is: \n";
			for (Entry<String, WeatherData> temp : weatherData.entrySet()) {
				if (temp.getValue().weatherSummary.toLowerCase().contains(forecast.toLowerCase())) {
					cities.add(temp.getKey());
				}
				else {
					JOptionPane.showMessageDialog(null, "No weather data for that");
				}
			}
			for (int i = 0; i < cities.size(); i++) {
				theCities += cities.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, theCities);
		}
		if(e.getSource() == button3) {
			ArrayList<String> cities = new ArrayList<String>();
			String minTempAsString = JOptionPane.showInputDialog("What is the minimum temperature you want to have?");
			String maxTempAsString = JOptionPane.showInputDialog("What is the maximum temperature you want to have?");
			Double minTemp = Double.parseDouble(minTempAsString);
			Double maxTemp = Double.parseDouble(maxTempAsString);
			String theCities = "The cities that have thier minimum temperature as " + minTemp + " and the cities that have thier maximum temperature as " + maxTemp + " are: \n";
			for(Entry<String, WeatherData> temp: weatherData.entrySet()) {
				if(temp.getValue().temperatureF < maxTemp && temp.getValue().temperatureF > minTemp) {
					cities.add(temp.getKey());
				}
				
			}
			if(cities.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No weather data available");
			}
			for(int i = 0; i < cities.size(); i++) {
				theCities += cities.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, theCities);
		}
	}
}
