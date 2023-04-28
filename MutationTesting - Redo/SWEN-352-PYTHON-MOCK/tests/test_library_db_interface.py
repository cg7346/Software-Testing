import unittest
from unittest.mock import Mock
from library import library_db_interface
from tinydb import TinyDB, Query


class TestLibraryDBInterface(unittest.TestCase):

    def verify_parameters(data, ids_match):
        assertTrue(ids_match)

    def setUp(self):
        self.db_interface = library_db_interface.Library_DB()

    def test_insert_patron_none(self):
        patron_mock = Mock()
        self.db_interface.retrieve_patron = Mock(return_value=None)
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        self.db_interface.db.insert = Mock(return_value=10)
        self.assertNotEqual(type(self.db_interface.insert_patron("")), type(patron_mock))

    #def test_insert_patron_not_in_db(self):
    #    patron_mock = Mock()
    #    self.db_interface.retrieve_patron = Mock(return_value=None)
    #    data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
    #            'borrowed_books': []}
    #    self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
    #    self.db_interface.db.insert = Mock(return_value=10)
    #    self.assertEqual(self.db_interface.insert_patron(patron_mock), 10)

    def test_insert_patron_in_db(self):
        patron_mock = Mock()
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        self.db_interface.retrieve_patron = Mock(return_value=data)
        self.assertEqual(self.db_interface.insert_patron(patron_mock), None)

    def test_get_patron_count(self):
        self.db_interface.db.all = Mock(return_value=[])
        self.assertEqual(self.db_interface.get_patron_count(), 0)

    def test_update_patron(self):
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        db_update_mock = Mock()
        self.db_interface.db.update = db_update_mock
        patron = Mock()
        self.db_interface.update_patron(patron)
        query = Query()
        db_update_mock.assert_called_with(data, query.memberID == patron.get_memberID())

    def test_update_patron_none(self):
        patron_mock = Mock()
        self.db_interface.retrieve_patron = Mock(return_value=None)
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        self.db_interface.db.update_patron = Mock(return_value=None)
        self.assertNotEqual(type(self.db_interface.update_patron("")), type(patron_mock))

    def test_convert_patron_to_db_format(self):
        patron_mock = Mock()

        patron_mock.get_fname = Mock(return_value=1)
        patron_mock.get_lname = Mock(return_value=2)
        patron_mock.get_age = Mock(return_value=3)
        patron_mock.get_memberID = Mock(return_value=4)
        patron_mock.get_borrowed_books = Mock(return_value=5)
        self.assertEqual(self.db_interface.convert_patron_to_db_format(patron_mock),
                         {'fname': 1, 'lname': 2, 'age': 3, 'memberID': 4,
                          'borrowed_books': 5})

    def test_retrieve_patron_none(self):
        patron_mock = Mock()
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        self.assertEqual(self.db_interface.retrieve_patron(patron_mock), None)
    
    def test_get_all_patrons(self):
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.db.all = Mock(return_value=[data])
        self.assertEqual(self.db_interface.get_all_patrons(), [data])
