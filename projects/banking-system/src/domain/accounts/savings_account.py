from decimal import Decimal
from .account import Account

class SavingsAccount(Account):
    def __init__(self, account_number: str, initial_balance: Decimal = Decimal('0'), 
                 interest_rate: Decimal = Decimal('0.02')):
        super().__init__(account_number, initial_balance)
        self.interest_rate = interest_rate

    def apply_monthly_interest(self) -> None:
        interest = self._balance * self.interest_rate / Decimal('12')
        self.deposit(interest)   # reuse deposit logic