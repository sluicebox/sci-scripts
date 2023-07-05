;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 415)
(include sci.sh)
(use Main)
(use System)

(public
	FndBody 0
	proc415_1 1
)

(local
	[local0 174] = [7 36 10 43 5 37 -32768 2 48 10 50 5 46 3 50 -32768 2 48 10 52 5 46 6 51 -32768 2 51 7 44 10 51 5 49 6 52 9 53 -32768 10 52 -32768 10 52 -32768 10 50 -32768 -4096 -32768 2 60 10 63 5 57 3 57 -32768 2 60 10 53 5 57 6 60 -32768 2 64 7 58 10 64 5 60 9 64 -32768 10 65 -32768 10 65 -32768 10 63 -32768 -4096 -32768 -32768 2 49 10 53 5 47 6 52 -32768 2 52 7 45 10 52 5 50 6 53 9 54 -32768 10 52 -32768 10 50 -32768 10 51 -32768 -4096 -32768 -32768 -32768 2 49 7 42 10 49 5 48 6 50 9 51 -32768 10 50 -32768 10 50 -32768 10 48 -32768 -4096 -32768 -32768 -32768 -32768 10 55 -32768 10 55 -32768 10 53 -32768 -4096 -32768 -32768 -32768 -32768 -32768 10 45 -32768 10 43 -32768 -4096]
)

(procedure (proc415_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 50])
	(if (and (== gAct 3) (not global135))
		(= [local0 17] 43)
		(= [local0 59] 52)
		(= [local0 91] 44)
	)
	(= temp0 0)
	(= temp1 1)
	(while (!= temp1 param1)
		(if (== [local0 temp0] -4096)
			(<<= temp1 $0001)
		)
		(++ temp0)
	)
	(= temp2 2)
	(while (<= temp2 gAct)
		(if (== [local0 temp0] -32768)
			(++ temp2)
		)
		(++ temp0)
	)
	(repeat
		(= temp3
			(+ (= temp3 (* (- [local0 temp0] 1) 7)) (/ [local0 (++ temp0)] 16))
		)
		(= temp4 (<< $0001 (mod [local0 temp0] 16)))
		(&= [global225 temp3] (~ temp4))
		(if (== [local0 (++ temp0)] -32768)
			(break)
		)
	)
	(FndBody dispose:)
)

(instance FndBody of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 415)
	)
)

