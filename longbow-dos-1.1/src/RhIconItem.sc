;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use IconBar)

(class RhIconItem of IconI
	(properties)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (& signal $0020))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 nsTop)
		(= temp1 nsLeft)
		(= temp2 (- nsBottom 2))
		(= temp3 (- nsRight 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)

	(method (onMe param1 &tmp temp0)
		(return
			(if (& signal $0004)
				0
			else
				(super onMe: param1 &rest)
			)
		)
	)
)

