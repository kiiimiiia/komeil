package ir.bourna.komeil.DTO.Request;


import ir.bourna.komeil.models.Filter;

import java.util.HashSet;
import java.util.Set;

public class AddSubFilterRequestDTO {
    private Long filterId;
    private Set<Long> subFilters = new HashSet<Long>();

    public Long getFilterId() {
        return filterId;
    }

    public void setFilterId(Long filterId) {
        this.filterId = filterId;
    }

    public Set<Long> getSubFilters() {
        return subFilters;
    }

    public void setSubFilters(Set<Long> subFilters) {
        this.subFilters = subFilters;
    }
}
