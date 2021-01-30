package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {

        String json = "{\"id\":\"fdd61f40-1520-4503-b90a-4181cd5481d4\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123,\"price\":12.99,\"createdDate\":\"2021-01-30T11:53:03.028743-03:00\",\"lastUpdatedDate\":\"2021-01-30T11:53:03.028806-03:00\"}\n";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }

}