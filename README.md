# Hotels-CVC
API para o cálculo de cotações dos hotéis retornados pelo broker da CVC. Onde é possivel fazer a busca de um hotel específico ou todos os hotéis em uma cidade passando as informações necessárias para o cotação.

#### Algumas das técnicas utilizadas:
- Utilização de cache para responses do broker e aumento de performance
- Testes unitários
- Filtros para validação de dados vindos do Front-end

## Instruções para teste

Foram criados dois endpoints, com o mesmo corpo de requisição.

#### Corpo das requisições:
```
{
    "checkInDate":"dd/MM/aaaa",
    "checkOutDate":"dd/MM/aaaa",
    "numberOfAdults":0,
    "numberOfChildren":0
}
```

#### Endpoints:

###### Cotação de hotel específico:
```
GET - /quotation/hotel/new/{hotel_id}
```
###### Cotação de todos os hotéis de uma cidade:
```
GET - /quotation/city/new/{city_id}
```

#### Retorno esperado:
```
{
    "id": 5,
    "city": "São Paulo",
    "name": "Hotel Teste 5",
    "rooms": [
        {
            "id": 0,
            "categoryName": "Standard",
            "priceDetail": {
                "totalPrice": 11293.928571428572,
                "pricePerDayAdult": 720.79,
                "pricePerDayChild": 860.36
            }
        }
    ]
}
```
