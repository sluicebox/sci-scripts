;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 364)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	bangkokOutsideMap 0
)

(instance bangkokOutsideMap of AutoMapInset
	(properties
		picture 364
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(2080 ; CPBangkok1
				(param1 posn: 294 176)
			)
			(2081 ; CPBangkok2
				(param1 posn: 273 136)
			)
			(2082 ; CPBangkok3
				(param1 posn: 316 79)
			)
			(4000 ; bkPorch
				(param1 posn: 262 99)
			)
			(4002 ; bkPorchDoor
				(param1 posn: 262 99)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

