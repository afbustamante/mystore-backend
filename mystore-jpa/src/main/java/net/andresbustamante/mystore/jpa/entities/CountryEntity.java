package net.andresbustamante.mystore.jpa.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "countries", uniqueConstraints = @UniqueConstraint(name = "uc_country_name", columnNames = "name"))
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "countries")
@Immutable
@Getter
@Setter
public class CountryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "region", nullable = false)
    private Short region;

    @OneToMany(mappedBy = "country")
    private Set<CityEntity> cities;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryEntity country)) return false;
        return Objects.equals(id, country.id) && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
