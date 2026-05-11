# Principio "SOLID"

## Definição

- É um acrônimo poara 5 príncipios fundamentais para o Desenvolvimento de um Software 

## "S" - SRP - Singles Responsibility Principle

- Este princnipio diz que suas classes deve m ser especialistas em realizar uma única tarefa 

## "O" - OCP - Open/Clodes Principle

- Este principio diz que as partes que compoe o Software devem ser fechados para modificações, mas aberto pra extensão
- Ex: Metodo de pagamento está funcionando, então neste codigo devem ser bloqueado modificações, mas pode ter extensões como:  
    - enviar uma mensagem pro cliente quando o pagamento for realizado com sucesso...

## "L" - LSP - Likov Substitution Principle

- Este principio diz que objetos de um tipo base devem ser substituiveis por intancias de um subtipo


## "I" - ISP - Interface Segregation Principle

- Este principio diz que inferfaces com muitas funcionalidades não coesas devem ser dividas em interfaces menores

## "D" - DIP - Dependency Inversion Principle

- Este principio diz que módulos do sistema deve depender de interfaces e não de implementações especificas