class BankingException(Exception):

    pass

class InsufficientFundsError(BankingException):
    def __init__(self, balance: float, requested: float):
        self.balance = balance
        self.requested = requested
        super().__init__(f"Insufficient balance: have {balance}, need {requested}")

class AccountNotFoundError(BankingException):
    pass

class ValidationError(BankingException):
    pass