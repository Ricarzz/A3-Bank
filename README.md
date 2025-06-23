#  A3Bank – Sistema Bancário em Java

Projeto desenvolvido como parte da disciplina de Programação e Soluções Computacionais (A3), o **A3Bank** simula um sistema bancário funcional com foco em **segurança**, **usabilidade** e **integração com serviços externos** como envio de SMS e e-mail.

---

##  Funcionalidades Principais

- **Login Seguro**
  - Armazenamento de senhas com hash SHA-256
  - Bloqueio de conta após tentativas erradas
  - Recuperação de senha com verificação por e-mail

- **Transferências Bancárias**
  - Validação de dados e confirmação de valor
  - Avisos para valores altos (> R$1.000)
  - Bloqueio automático para operações fora do horário permitido
  - Notificação por SMS usando Twilio

- **Segurança com Denúncias**
  - Alerta ao tentar transferir para contas denunciadas
  - Bloqueio de contas com 5+ denúncias

- **Depósitos**
  - Validação de valor
  - Atualização automática de saldo
  - Registro da transação no histórico

- **Histórico de Transações**
  - Visualização por CPF do cliente

---

##  Tecnologias Utilizadas

- **Java** (backend)
- **MySQL** (banco de dados)
- **Java Swing** (interface gráfica)
- **Twilio API** (envio de SMS)
- **Jakarta Mail API** (envio de e-mails)
- **NetBeans IDE**

---
- ⚠️ Observações

- Dados sensíveis como senhas de banco, tokens Twilio e credenciais de e-mail foram **removidos por segurança**.

