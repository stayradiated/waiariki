// Class:    City
// Purpose:  Store city information
// Author:   George Czabania
// Date:     Aug 20 2013

public class City {


  // private variables
  private String name;
  private String country;
  private float population;


  /**
   * CONSTRUCTORS
   */

  // default constructor
  public City () {
    name = "";
    country = "";
    population = 0;
  }

   // alternative constructor
   // @param _name       - name of city
   // @param _country    - name of country
   // @param _population - of city in millionf
  public City (String _name, String _country, float _population) {
    name = _name;
    country = _country;
    population = _population;
  }


  /**
   * MUTATORS
   */

  // @param _name - set the name of city
  public void setName (String _name) {
    name = _name;
  }

  // @param _country - set the name of the country
  public void setCountry (String _country) {
    country = _country;
  }

  // @param _population - set population (in millions)
  public void setPopulation (float _population) {
    population = _population;
  }


  /**
   * ACCESSORS
   */

  // @return name - returns the name of the city
  public String getName () {
    return name;
  }

  // @return country - returns the name of the country
  public String getCountry () {
    return country;
  }

  // @return population - returns the city population (in millions)
  public float getPopulation () {
    return population;
  }


  /**
   * PRINTING
   */

  // print the object details to STDOUT
  public void print () {
    System.out.println();
    System.out.printf("%12s: %s\n", "City", name);
    System.out.printf("%12s: %s\n", "Country", country);
    System.out.printf("%12s: %.2f million\n", "Population", population);
  }

}
