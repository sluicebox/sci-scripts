;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
(include sci.sh)
(use Main)
(use Inventory)

(public
	proc806_3 3
	proc806_6 6
)

(procedure (proc806_3) ; UNUSED
	(gFeatures sel_118: &rest sel_119: 110)
	(DisposeScript 806)
)

(procedure (proc806_6 param1 &tmp temp0)
	(if (>= argc 2)
		(= temp0 (Inv sel_64: param1))
		(gTheIconBar sel_179: (gTheIconBar sel_64: 5) sel_217: temp0)
	else
		(= temp0 (gTheIconBar sel_64: param1))
		(gTheIconBar sel_179: temp0)
	)
	(gGame sel_198: (temp0 sel_33:) 1)
	(DisposeScript 806)
)

