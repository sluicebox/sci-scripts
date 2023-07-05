;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 241)
(include sci.sh)
(use wizGame)

(public
	proc241_0 0
)

(procedure (proc241_0 param1 &tmp temp0 temp1 temp2)
	(if (= temp1 (proc32_10 param1))
		(repeat
			(= temp2 (Random 0 7))
			(if (not (proc32_10 temp2))
				(break)
			)
		)
		(proc32_10 temp2 temp1)
		(temp1 listIndex: temp2)
		(proc32_10 param1 0)
		(= temp0 (+ temp2 temp2 temp2))
		(temp1 posn: (proc32_10 (+ 32 temp0)) (proc32_10 (+ 33 temp0)))
	)
	(DisposeScript 241)
)

