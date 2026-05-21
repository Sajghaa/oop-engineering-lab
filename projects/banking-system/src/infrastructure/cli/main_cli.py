from decimal import Decimal
from src.infrastructure.database.in_memory_repo import InMemoryAccountRepository
from src.use_cases.deposit_money import DepositMoney
from src.domain.accounts.savings_account import SavingsAccount

def main():
    # Wire up dependencies
    repo = InMemoryAccountRepository()
    
    # Create an account
    acc = SavingsAccount("SAV-001", Decimal('1000'))
    repo.save(acc)
    
    # Use case
    deposit = DepositMoney(repo)
    deposit.execute("SAV-001", Decimal('500'))
    
    print(f"New balance: {acc.balance}")   # 1500

if __name__ == "__main__":
    main()