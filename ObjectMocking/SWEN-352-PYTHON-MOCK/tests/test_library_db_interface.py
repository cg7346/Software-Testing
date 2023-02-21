import unittest
from unittest.mock import Mock, call
from library import library_db_interface

class TestLibbraryDBInterface(unittest.TestCase):

    def setUp(self):
        self.db_interface = library_db_interface.Library_DB()