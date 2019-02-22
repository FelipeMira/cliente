
Feature: Chamada na api de cliente
    Scenario: Client ira chamar a api GET /cliente
    When  O cliente chama a api /cliente
	Then Valido o codigo de retorno 200