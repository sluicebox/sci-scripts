;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use Main)
(use Extra)
(use System)

(public
	proc802_0 0
	proc802_1 1
	proc802_2 2
	proc802_3 3
)

(procedure (proc802_0 param1 param2 &tmp temp0 temp1)
	(= temp0 (if (>= argc 2) param2 else 5))
	(= temp1 (param1 heading:))
	(OnControl
		CONTROL
		(+ (param1 x:) (SinMult temp1 temp0))
		(- (param1 y:) (CosMult temp1 temp0))
	)
)

(procedure (proc802_1 param1 param2) ; UNUSED
	(param1 loop: param2 changeState:)
)

(procedure (proc802_2 param1) ; UNUSED
	(gCast eachElementDo: #perform extraControl param1)
)

(procedure (proc802_3 param1 param2) ; UNUSED
	(return
		(== ((gInventory at: param1) owner:) (if (>= argc 2) gCurRoomNum else param2))
	)
)

(instance extraControl of Code
	(properties)

	(method (doit param1 param2)
		(if (param1 isKindOf: Extra)
			(if param2
				(param1 startExtra:)
			else
				(param1 stopExtra:)
			)
		)
	)
)

