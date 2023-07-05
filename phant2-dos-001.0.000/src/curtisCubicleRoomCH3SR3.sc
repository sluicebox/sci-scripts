;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4033)
(include sci.sh)
(use Main)
(use n63002)
(use WyntechPhoneRoom)

(public
	curtisCubicleRoomCH3SR3 0
)

(instance curtisCubicleRoomCH3SR3 of WyntechPhoneRoom
	(properties
		exitRoom 4023
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (call param1)
		(switch param1
			(6125
				(if (not (SetFlag 388))
					(= global209 5910)
					(gCurRoom newRoom: exitRoom)
				else
					(self ring:)
					(proc63002_11 4000 6 45 59 1)
					(self hook:)
				)
			)
			(6100
				(if (not (SetFlag 389))
					(= global209 6040)
					(= global211 1)
					(gCurRoom newRoom: exitRoom)
				else
					(self busy:)
				)
			)
			(6992
				(if (not (SetFlag 390))
					(= global209 5940)
					(gCurRoom newRoom: exitRoom)
				else
					(self ring:)
					(proc63002_11 4000 5 45 11 1)
					(self hook:)
				)
			)
			(6120
				(self busy:)
			)
			(3038
				(cond
					((not (SetFlag 391))
						(= global209 5970)
						(gCurRoom newRoom: exitRoom)
					)
					((not (SetFlag 392))
						(= global209 5990)
						(gCurRoom newRoom: exitRoom)
					)
					(else
						(self busy:)
					)
				)
			)
			(6114
				(if (not (SetFlag 393))
					(= global212 (= global211 1))
					(gRoboGary stop: 1)
					(proc63002_7 6010)
					(gCurRoom newRoom: 4083) ; bobCallingRoom
				else
					(self busy:)
				)
			)
			(6996
				(self ring:)
				(proc63002_11 4000 12 45 60 1)
				(self hook:)
			)
			(else
				(super call: param1 &rest)
			)
		)
	)
)

