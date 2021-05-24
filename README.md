# Operations_Stack_DataStructure
A file contains a set (unspecified number) of equations, each two equations (separated
by the symbol =) are located in one line. we Build an application that reads all lines in this
file and check if each equation is valid or not (see examples below), if both equations
in the line are valid, then convert them to the postfix format, evaluate them, and check
if they have the same value

Valid equation:
2*(2-5)+4-[9*3*(7-2)]
2*(2-5)+4-[9*3*(7-2) // invalid because of [ without close
2*(2-5)4-[9*3*(7-2)] // invalid because of (2-5)4 there is no operator
3*(6-3) = 4 + 6-1 … both equations are valid and the result is True

1. Print the valid equations in the format:
[ Postfix (eq1) = result(eq1)] =? [Postfix (eq2) = result(eq2)] -> False
[ Postfix (eq3) = result(eq3)] =? [Postfix (eq4) = result(eq4)] -> True
[ Postfix (eq7) = result(eq7)] =? [Postfix (eq8) = result(eq8)] -> False
….
2. If a line contains one or two invalid equations, print both equations in the
following format:
Eq5 -> Invalid
Eq6 -> valid -> result (Eq6)
Eq9 -> Invalid
Eq10 -> Invalid
3. Print all input equations to a file, for each one state whether it is valid or not,
and if it is valid, print out the postfix format the result.
