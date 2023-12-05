package Kodlama.io.Devs.case4.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProgrammingLanguageRequest {

    private String name;
    //Burada son kullanıcıdan bir veri alacağız ve veritabanına ekleyeceğiz.

    //Son kullanıcının bana ürünün "Id"sini söylemesini isteyemem. Id tomatik artıyor.
    //Buradaki olay "Son Kullanıcı"nın veri girmesi.
    //Son kullanıcıdan DATA alıyorsam "REQUEST"
    //Son kullanıcıya DATA dönüyorsam ya da veriyorsam "RESPONSE"
}
