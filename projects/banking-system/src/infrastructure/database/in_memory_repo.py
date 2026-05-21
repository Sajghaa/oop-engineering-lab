from typing import Dict, Optional
from domain.accounts.account import Account

class InMemoryAccountRepository:
    """For testing or prototyping – not for production."""
    
    def __init__(self):
        self._storage: Dict[str, Account] = {}

    def save(self, account: Account) -> None:
        self._storage[account.account_number] = account

    def find_by_number(self, account_number: str) -> Optional[Account]:
        return self._storage.get(account_number)

    def delete(self, account_number: str) -> None:
        if account_number in self._storage:
            del self._storage[account_number]