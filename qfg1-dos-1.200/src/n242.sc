;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 242)
(include sci.sh)
(use wizGame)

(public
	proc242_0 0
)

(procedure (proc242_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
	(switch param2
		(3
			(= temp0 (= temp2 0))
			(= temp1 8)
		)
		(2
			(= temp0 (= temp2 8))
			(= temp1 25)
		)
		(1
			(= temp0 (= temp2 25))
			(= temp1 32)
		)
	)
	(= temp4 0)
	(while (< temp0 temp1)
		(if
			(and
				(= temp3 (proc32_10 temp0))
				(<= (param1 distanceTo: temp3) param3)
			)
			(= temp4 1)
			(break)
		)
		(++ temp0)
	)
	(DisposeScript 242)
	(return temp4)
)

