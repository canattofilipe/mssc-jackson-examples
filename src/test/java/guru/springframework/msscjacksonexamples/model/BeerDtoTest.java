package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest {

  @Autowired ObjectMapper objectMapper;

  @Test
  void testSerializeDto() throws JsonProcessingException {

    BeerDto beerDto = getDto();

    String jsonString = objectMapper.writeValueAsString(beerDto);

    System.out.println(jsonString);
  }

  @Test
  void testDeserialize() throws IOException {

    String json =
        "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123,\"price\":\"12.99\",\"createdDate\":\"2021-02-09T16:22:01-0300\",\"lastUpdatedDate\":\"2021-02-09T16:22:01.54942-03:00\",\"myLocalDate\":\"20210209\",\"beerId\":\"1d890b39-44f2-4f16-b3eb-0deac03779c1\"}\n";

    BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

    System.out.println(beerDto);
  }
}
