package pfeffer.oms.inventory.infra;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class SimplePage<T> extends PageImpl<T> {

    @JsonCreator
    public SimplePage(@JsonProperty("data") final List<T> data, @JsonProperty("totalElements") final long totalElements,
                      @JsonProperty("page") final int page, @JsonProperty("size") final int size) {

        super(data, PageRequest.of(page, size), totalElements);
    }

    public SimplePage(final List<T> data, final Pageable pageable, final long totalElements) {
        super(data, pageable, totalElements);
    }

}