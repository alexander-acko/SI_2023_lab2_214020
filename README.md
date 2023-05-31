# Втора лабораториска вежба по софтверско инженерство

## Александар Атанасоски, 214020

### Control flow graph
![CFG](SILab2_CFG.png)

### Цикломатска комплексност - 11
Според CFG има вкупно N = 28 јазли и E = 37 врски, па цикломатската комплексност ќе се пресмета според следната формула: 
Cyclomate complexity = E - N + 2 = 37 - 28 + 2 = 11

### Тест случаи според критериумот Every branch

| Test case 1: | user == null |
|:---|--------|
| Test case 2: | password == null |
| Test case 3: | email == null |
| Test case 4: | во email не се содржи '@' или '.' |
| Test case 5: | во password нема некој од специјалнните карактери |
| Test case 6: | должината на password е помала од 8 |
| Test case 7: | во password се содржи username |
| Test case 8: | во password има празно место " " |
| Test case 9: | го има email во allUsers |
| Test case 10: | го има username во allUsers |

### Тест случаи според критериумот Multiple condition

Ќе ја воведеме следнава синтакса:
| X: | user==null |
|:---|-------|
| Y: | user.getPassword()==null |
| Z: | user.getEmail()==null |

| XYZ	 | possible test case |	Nodes |
|:-----|---------|--------|
| Txx	| u = null, p = password, e = name@email.com	| 1-2-24 |
| FTx |	u = user, p = null, e = name@email.com	| 1-2-24 |
| FFT |	u = user, p = password, e = null	| 1-2-24 |
| FFF |	u = user, p = password, e = name@email.com	| 1-3-5-… |

### Објаснување на напишаните unit tests
