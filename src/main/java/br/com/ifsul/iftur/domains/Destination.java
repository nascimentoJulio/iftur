package br.com.ifsul.iftur.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Destination {
    public Long id;
    public String name;
    public String description;
    public String image;
    public String country;
}
