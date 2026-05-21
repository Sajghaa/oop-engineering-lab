from decimal import Decimal
from domain.accounts.account import Account
from shared.exceptions import AccountNotFoundError

class DepositMoney:
    """Use case: deposit money into an account."""
    
    def __init__(self, account_repository):
        self.account_repo = account_repository   # dependency injection

    def execute(self, account_number: str, amount: Decimal) -> None:
        account = self.account_repo.find_by_number(account_number)
        if not account:
            raise AccountNotFoundError(f"Account {account_number} not found")
        
        account.deposit(amount)
        self.account_repo.save(account)   # persistence happens here