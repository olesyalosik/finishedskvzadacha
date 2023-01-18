# Skvoznaya zadacha
## Notes:
* assume that plain text files must contain one arithmetic(valid or invalid) expression per line, \n xml contains expression inside an "expression" tag and json contains an expression inside a "data" tag \n all types of files contain only expressions
* assume that only file content can be encrypted(so .rar or .zip files cannot be encrypted as input)
* rar compression algorithm is proprietary-only so rar files can only be decompressed
* AES encryption algorithm was used for creating sample file and decryption
* UI using Swing
## Warning: running the program changes content in source files