;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 316)
(include sci.sh)
(use Main)

(public
	proc316_0 0
	proc316_1 1
)

(procedure (proc316_0 param1 param2 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
		(= temp1 (gInventory at: [param2 temp0]))
		(if (not (temp1 owner:))
			(temp1 owner: param1)
		)
	)
)

(procedure (proc316_1 param1 param2 &tmp temp0)
	(return (and ((= temp0 (gInventory at: param2)) ownedBy: param1) temp0))
)

