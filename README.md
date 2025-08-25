# Adapter Pattern - Conversão XML para JSON

## Sobre o padrão Adapter

O padrão de projeto **Adapter** tem como objetivo permitir que interfaces incompatíveis trabalhem juntas. Ele atua como um "adaptador" que converte a interface de uma classe em outra interface esperada pelo cliente, facilitando a reutilização e integração de componentes.

## Objetivo do código

Este código lê dados de um arquivo XML (`dados.xml`), converte seu conteúdo para o formato JSON e salva o resultado em um arquivo `dados.json`. A conversão é feita usando a biblioteca `org.json` localmente, sem depender de sistemas de build como Maven.

## Como rodar

### Pré-requisitos

- Java instalado (JDK 8+)
- Biblioteca `json-20210307.jar` no mesmo diretório do código e arquivos

### Passos

#### Compilar

```bash
# Linux/Mac
javac -cp .:json-20210307.jar Adapter.java

# Windows
javac -cp .;json-20210307.jar Adapter.java

# Linux/Mac
java -cp .:json-20210307.jar Adapter

# Windows
java -cp .;json-20210307.jar Adapter
```


# Erro de importação no VSCode com bibliotecas externas (.jar)

## O que acontece?

No VSCode, ao usar bibliotecas externas como `json-20210307.jar`, você pode ver um erro nas linhas de importação, como:

```java
import org.json.JSONObject;
import org.json.XML;
```

## Como corrigir?
### Passo 1: Coloque o arquivo .jar no diretório do projeto

Certifique-se de que o arquivo json-20210307.jar está no mesmo diretório do seu código fonte.

### Passo 2: Configure o VSCode para reconhecer o .jar

Crie (ou edite) o arquivo .vscode/settings.json no seu projeto com o seguinte conteúdo:
```json
{
  "java.project.referencedLibraries": [
    "json-20210307.jar"
  ]
}
```