/*
 *      Copyright (c) 2004-2016 Stuart Boston
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
package com.omertron.themoviedbapi.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.themoviedbapi.model.AbstractJsonMapping;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Stuart
 */
public class TranslationData extends AbstractJsonMapping implements Serializable {

    private static final long serialVersionUID = 100L;

    @JsonProperty("name")
    private String name;
    @JsonProperty("title")
    private String title;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("tagline")
    private String tagline;

    public String getName() {
        return name;
    }

    public TranslationData setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TranslationData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public TranslationData setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public TranslationData setHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getTagline() {
        return tagline;
    }

    public TranslationData setTagline(String tagline) {
        this.tagline = tagline;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TranslationData) {
            final TranslationData other = (TranslationData) obj;
            return new EqualsBuilder()
                    .append(name, other.name)
                    .append(overview, other.overview)
                    .append(homepage, other.homepage)
                    .append(tagline, other.tagline)
                    .isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(overview)
                .append(homepage)
                .append(tagline)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
