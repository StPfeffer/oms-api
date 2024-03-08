package pfeffer.oms.inventory.infra;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@JsonIgnoreProperties({ "pageable", "number", "numberOfElements", "first", "last", "empty" })
public class SimplePage<T> extends PageImpl<T> {

    @JsonCreator
    public SimplePage(@JsonProperty("data") final List<T> data, @JsonProperty("totalElements") final long totalElements,
                      @JsonProperty("page") final int page, @JsonProperty("size") final int size) {

        super(data, PageRequest.of(page, size), totalElements);
    }

}