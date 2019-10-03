package com.gabrielsson.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Pizza
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-02T13:16:40.716Z")

public class Pizza   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ingredients")
  @Valid
  private List<Ingredient> ingredients = null;

  public Pizza name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Roma", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Pizza ingredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
    return this;
  }

  public Pizza addIngredientsItem(Ingredient ingredientsItem) {
    if (this.ingredients == null) {
      this.ingredients = new ArrayList<Ingredient>();
    }
    this.ingredients.add(ingredientsItem);
    return this;
  }

  /**
   * Get ingredients
   * @return ingredients
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pizza pizza = (Pizza) o;
    return Objects.equals(this.name, pizza.name) &&
        Objects.equals(this.ingredients, pizza.ingredients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ingredients);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pizza {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

