🌍 Country Search API

Projeto desenvolvido como parte de um desafio técnico com o objetivo de consumir a API pública RestCountries e disponibilizar informações sobre países e suas capitais através de um backend em Java (Spring Boot).

⚠️ Devido ao tempo limitado (1 hora), foi priorizada a construção do backend completo e testado, conforme solicitado.

📋 Descrição do Desafio

Criar uma aplicação que:

1. Pesquise os países utilizando a API:
https://restcountries.com/v3.1/all
2. Exiba a lista com o nome de todos os países em um selectbox.
3. Ao selecionar um país e clicar em pesquisar, mostrar a capital correspondente.
4. Sugerir e exemplificar tipos de testes.

Backend: Java
Frontend: HTML/CSS/Angular ou Javascript (não implementado por limitação de tempo)

🏗️ Arquitetura da Solução

A solução foi implementada com:
Java 17+
Spring Boot
RestTemplate para consumo de API externa
Testes com JUnit 5 e Mockito
Arquitetura em camadas (Controller → Service)

🔗 Integração com API Externa

API utilizada:
https://restcountries.com/

🔎 Listar países
GET https://restcountries.com/v3.1/all?fields=name

🏛 Buscar capital por país
GET https://restcountries.com/v3.1/name/{country}?fields=capital

🚀 Endpoints Disponíveis
📌 Listar todos os países
GET /api/countries

Exemplo de resposta:
[
  "Afghanistan",
  "Albania",
  "Algeria",
  "Brazil",
  "Canada",
  ...
]

📌 Buscar capital de um país
GET /api/countries/{name}/capital

Exemplo: GET /api/countries/Brazil/capital
Resposta: Brasília

🧪 Testes Implementados

Foram implementados testes automatizados com foco em:

1️⃣ Testes Unitários (Service)

Objetivo:

Validar a lógica de negócio isoladamente.
Mockar o RestTemplate.
Testar retorno correto.
Testar país inexistente.

Exemplo:

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CountryService countryService;

    @Test
    void shouldReturnCountryList() {
        // Simulação do retorno da API
        // Validação da lista retornada
    }
}

2️⃣ Testes de Integração (Controller)

Objetivo:

Validar o endpoint REST.
Garantir status HTTP correto.
Validar resposta retornada.

Exemplo:

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    void shouldReturnCapital() throws Exception {
        when(countryService.getCapitalByCountry("Brazil"))
                .thenReturn("Brasília");

        mockMvc.perform(get("/api/countries/Brazil/capital"))
                .andExpect(status().isOk())
                .andExpect(content().string("Brasília"));
    }
}

3️⃣ Testes sugeridos adicionais

Teste para país inexistente
Teste para capital inexistente
Teste de falha na API externa (timeout)
Teste de tratamento de exceções
Testes End-to-End (caso frontend fosse implementado)

▶️ Como Executar o Projeto

1️⃣ Clonar o repositório
git clone <url-do-repositorio>

2️⃣ Executar aplicação
mvn clean spring-boot:run

3️⃣ Executar testes
mvn test

<img width="292" height="306" alt="image" src="https://github.com/user-attachments/assets/94c3d98d-caa0-4cf7-8e37-9ba384e251d6" />




🎯 Estratégia Adotada

Dado o tempo limitado (1 hora), a estratégia foi:

Priorizar backend funcional e testado
Separação clara de responsabilidades
Uso adequado de API externa
Implementação de testes automatizados
Código limpo e organizado

A implementação do frontend seria simples utilizando Angular ou HTML/JS consumindo os endpoints expostos.

🏁 Conclusão

O backend foi implementado com sucesso, atendendo todos os requisitos técnicos do desafio:

✔ Consumo de API externa
✔ Exposição de endpoints REST
✔ Separação em camadas
✔ Testes automatizados
✔ Tratamento básico de erros

O projeto demonstra capacidade de:

Integração com APIs externas
Estruturação de aplicação Spring Boot
Escrita de testes automatizados
Organização e clareza de código
