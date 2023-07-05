;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 882)
(include sci.sh)
(use Main)

(public
	proc882_0 0
	proc882_1 1
	proc882_2 2
)

(procedure (proc882_0 param1)
	(gEgo get: 3) ; theKeys
	((gInventory at: 3) state: (| ((gInventory at: 3) state:) param1)) ; theKeys, theKeys
)

(procedure (proc882_1 param1)
	((gInventory at: 3) state: (& ((gInventory at: 3) state:) (~ param1))) ; theKeys, theKeys
	(if (not (& ((gInventory at: 3) state:) $000f)) ; theKeys
		(gEgo put: 3) ; theKeys
	)
)

(procedure (proc882_2 param1)
	(if (or (not (gEgo has: 3)) (not (& ((gInventory at: 3) state:) param1))) ; theKeys, theKeys
		(return 0)
	else
		(return 1)
	)
)

