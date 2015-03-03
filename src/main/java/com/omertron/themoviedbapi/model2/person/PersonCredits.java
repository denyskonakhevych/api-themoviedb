/*
 *      Copyright (c) 2004-2015 Stuart Boston
 *
 *      This file is part of TheMovieDB API.
 *
 *      TheMovieDB API is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      TheMovieDB API is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with TheMovieDB API.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.omertron.themoviedbapi.model2.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.omertron.themoviedbapi.model2.AbstractJsonMapping;
import java.util.List;

/**
 * @author stuart.boston
 */
public class PersonCredits extends AbstractJsonMapping {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;
    private List<? extends CreditBasic> cast;
    private List<? extends CreditBasic> crew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<? extends CreditBasic> getCast() {
        return cast;
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "media_type",
            defaultImpl = CreditBasic.class
    )
    @JsonSubTypes({
        @JsonSubTypes.Type(value = CreditMovieBasic.class, name = "movie"),
        @JsonSubTypes.Type(value = CreditTVBasic.class, name = "tv")
    })
    @JsonSetter("cast")
    public void setCast(List<? extends CreditBasic> cast) {
        this.cast = cast;
    }

    public List<? extends CreditBasic> getCrew() {
        return crew;
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "media_type",
            defaultImpl = CreditBasic.class
    )
    @JsonSubTypes({
        @JsonSubTypes.Type(value = CreditMovieBasic.class, name = "movie"),
        @JsonSubTypes.Type(value = CreditTVBasic.class, name = "tv")
    })
    @JsonSetter("crew")
    public void setCrew(List<? extends CreditBasic> crew) {
        this.crew = crew;
    }
}
