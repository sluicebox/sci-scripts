;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4512)
(include sci.sh)
(use Main)
(use n63002)
(use WyntechPhoneRoom)
(use PolyEdit)

(public
	tomsCubicleRoomCH2SR1 0
)

(instance tel2view of View
	(properties
		x 100
		y 300
		view 44500
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)
)

(instance tomsCubicleRoomCH2SR1 of WyntechPhoneRoom
	(properties
		exitRoom 4502
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (call param1)
		(switch param1
			(6100
				(tel2view init:)
				(proc63002_11 4500 3 0 5 1)
				(tel2view dispose:)
				(self hook:)
			)
			(6996
				(= global209 4470)
				(SetFlag 227)
				(gCurRoom newRoom: 3312) ; mainOfficeRoomCH2SR1
			)
			(else
				(super call: param1 &rest)
			)
		)
	)
)

