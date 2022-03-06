package com.example.back;

import com.example.back.model.Meuble;
import com.example.back.repository.MeubleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExplorationTest {

    @Autowired
    private MeubleRepository meubleRepository;

    @Test
    public void TestCreateMeuble() {
        Meuble meuble1 = new Meuble("table_de_nuit1", "permet de stocker ses affaires1", "99", "dddddd", "dcdscd", "99");
        meubleRepository.saveAll(Arrays.asList(meuble1));
    }

    @Test
    public void TestFindMeubleByName() {
        String meuble_name = "table_de_nuit1";
    //    Meuble meuble = meubleRepository.findByMeuble_name(meuble_name);

    //    assertThat(meuble.getMeuble_name()).isEqualTo(meuble_name);
    }

    @Test
    private void afficherMeuble(Meuble meuble1) {
        System.out.println("== Meuble ==");
        System.out.println("nom : " + meuble1.getMeuble_name());
        System.out.println("prix : " + meuble1.getMeuble_prix());
        System.out.println("type de meuble : " + meuble1.getMeuble_type());
        System.out.println("stock : " + meuble1.getMeuble_stock());
        System.out.println("short info : " + meuble1.getMeuble_short_info());
        System.out.println("meuble info : " + meuble1.getMeuble_info());

    }
}