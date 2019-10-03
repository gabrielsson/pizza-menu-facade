/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.gabrielsson.api;

import com.gabrielsson.model.Ingredient;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-02T13:16:40.716Z")

@Api(value = "ingredients", description = "the ingredients API")
public interface IngredientsApi {

    @ApiOperation(value = "Retrieve ingredients", nickname = "ingredientsGet", notes = "Retrieve a list of all available ingredients.", response = Ingredient.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Ingredient.class, responseContainer = "List") })
    @RequestMapping(value = "/ingredients",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Ingredient>> ingredientsGet();

}