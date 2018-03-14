package com.smart.attr;

import java.util.HashSet;
import java.util.Set;

/**
 * 5.4.6 集合类型属性 集合合并
 */
public class Boss {
    private Set favorites = new HashSet();

    public Set getFavorites() {
        return favorites;
    }

    public void setFavorites(Set favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "favorites=" + favorites +
                '}';
    }
}
