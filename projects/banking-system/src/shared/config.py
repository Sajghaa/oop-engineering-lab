import os
from dotenv import load_dotenv

load_dotenv()

class Config:
    DATABASE_URL = os.getenv("DATABASE_URL", "sqlite:///banking.db")
    LOG_LEVEL = os.getenv("LOG_LEVEL", "INFO")
    INTEREST_CRON = os.getenv("INTEREST_CRON", "0 0 1 * *")   # midnight on day 1