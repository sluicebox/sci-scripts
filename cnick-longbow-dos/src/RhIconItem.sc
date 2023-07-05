;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use IconBar)

(class RhIconItem of IconI
	(properties
		sel_20 {RhIconItem}
	)

	(method (sel_208 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (& sel_14 $0020))
			(return)
		)
		(= temp4 (if (and argc param1) sel_202 else sel_203))
		(= temp0 sel_6)
		(= temp1 sel_7)
		(= temp2 (- sel_8 2))
		(= temp3 (- sel_9 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- sel_6 2) (- sel_7 2) sel_8 (+ sel_9 3) 1)
	)

	(method (sel_209 param1 &tmp temp0)
		(return
			(if (& sel_14 $0004)
				0
			else
				(super sel_209: param1 &rest)
			)
		)
	)
)

