;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 363)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	humanLairMap 0
)

(instance humanLairMap of AutoMapInset
	(properties
		picture 363
	)

	(method (initItems)
		(bombRm init: insetCast)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(8000 ; HumanRamp
				(param1 posn: 101 207)
			)
			(8010 ; HumanWheelRm
				(param1 posn: 234 209)
			)
			(8020 ; HumanMainHall1
				(param1 posn: 296 179)
			)
			(8030 ; HumanMainHall2
				(param1 posn: 266 164)
			)
			(8040 ; HumanMainHall3
				(param1 posn: 335 200)
			)
			(8050 ; HumanMainHall4
				(param1 posn: 380 219)
			)
			(8100 ; HumanCistern
				(param1 posn: 343 142)
			)
			(8110 ; HumanBombShop
				(param1 posn: 381 156)
			)
			(8115 ; HumanBombCloseUp
				(param1 posn: 381 156)
			)
			(8120 ; HumanBench
				(param1 posn: 421 171)
			)
			(8130 ; HumanBeds
				(param1 posn: 450 183)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

(instance bombRm of AutoMapProp
	(properties
		x 312
		y 127
		view 363
		testFlag 306
	)
)

