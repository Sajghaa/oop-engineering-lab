from abc import ABC, abstractmethod
from decimal import Decimal
from typing import Optional
from shared.exceptions import ValidationError, InsufficientFundsError

class Account(ABC):
    """
    Represents a bank account. This is an abstract entity.
    Invariants: balance >= 0, account_number non-empty.
    """
    def __init__(self, account_number: str, initial_balance: Decimal = Decimal('0')):
        if not account_number or not isinstance(account_number, str):
            raise ValidationError("Account number must be a non-empty string")
        if initial_balance < 0:
            raise ValidationError("Initial balance cannot be negative")
        
        self._account_number = account_number
        self._balance = initial_balance

    @property
    def account_number(self) -> str:
        return self._account_number

    @property
    def balance(self) -> Decimal:
        return self._balance

    def deposit(self, amount: Decimal) -> None:
        """Deposit money – always allowed for positive amounts."""
        if amount <= 0:
            raise ValidationError("Deposit amount must be positive")
        self._balance += amount

    def withdraw(self, amount: Decimal) -> None:
        """Withdraw money – must respect balance."""
        if amount <= 0:
            raise ValidationError("Withdrawal amount must be positive")
        if amount > self._balance:
            raise InsufficientFundsError(self._balance, amount)
        self._balance -= amount

    @abstractmethod
    def apply_monthly_interest(self) -> None:
        """Each account type applies interest differently."""
        pass

    def __eq__(self, other: object) -> bool:
        if not isinstance(other, Account):
            return False
        return self.account_number == other.account_number