;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use Game)

(class MGRoom of Room
	(properties
		edgeE 253
		edgeW 12
		edgeS 148
	)

	(method (dispose)
		(= global301 0)
		(if (<= 41 [global200 gCurRoomNum] 47)
			(switch [global200 gCurRoomNum]
				(41
					(DisposeScript 601)
				)
				(42
					(DisposeScript 602)
				)
				(44
					(DisposeScript 608)
				)
				(45
					(DisposeScript 603)
				)
				(46
					(DisposeScript 609)
				)
				(47
					(DisposeScript 604)
				)
			)
		)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(gGame handsOff:)
		(if gCuees
			(gCuees eachElementDo: #cuee 0 eachElementDo: #dispose release:)
		)
		(super newRoom: newRoomNumber)
	)
)

