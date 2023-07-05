;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	londonMap 0
)

(instance londonMap of AutoMapInset
	(properties
		picture 355
	)

	(method (initItems)
		(displayRm init: insetCast)
		(biotRm init: insetCast)
		(trashPit init: insetCast)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(3002 ; london_2
				(param1 posn: 107 41)
			)
			(3003 ; london_3
				(param1 posn: 133 62)
			)
			(3004 ; london_4
				(param1 posn: 133 62)
			)
			(3005
				(param1 posn: 133 62)
			)
			(3006
				(param1 posn: 133 62)
			)
			(3007 ; london_7
				(param1 posn: 133 62)
			)
			(3010 ; london_Door_2
				(param1 posn: 133 62)
			)
			(3012
				(param1 posn: 133 62)
			)
			(3008 ; london_8
				(param1 posn: 185 92)
			)
			(3013 ; london_Display_Control
				(param1 posn: 133 62)
			)
			(3014 ; london_Map_Puzzle
				(param1 posn: 133 62)
			)
			(3020 ; london_10
				(param1 posn: 235 128)
			)
			(3021 ; london_11
				(param1 posn: 284 110)
			)
			(3022 ; london_12
				(param1 posn: 333 123)
			)
			(3023 ; london_13
				(param1 posn: 221 174)
			)
			(3024 ; london_14
				(param1 posn: 204 160)
			)
			(3025 ; london_15
				(param1 posn: 197 149)
			)
			(3026 ; london_16
				(param1 posn: 234 170)
			)
			(3027 ; london_17
				(param1 posn: 241 128)
			)
			(3033 ; london_18
				(param1 posn: 241 255)
			)
			(3028
				(param1 posn: 333 123)
			)
			(3029 ; london_WildCard
				(param1 posn: 242 185)
			)
			(3030 ; london_Door_3
				(param1 posn: 333 123)
			)
			(3031
				(param1 posn: 333 123)
			)
			(3032 ; london_Elevator_Cntrl
				(param1 posn: 234 170)
			)
			(3040 ; london_20
				(param1 posn: 228 236)
			)
			(3041 ; london_21
				(param1 posn: 286 226)
			)
			(3042 ; london_22
				(param1 posn: 298 198)
			)
			(3043 ; london_23
				(param1 posn: 329 253)
			)
			(3060 ; london_30
				(param1 posn: 385 105)
			)
			(3062 ; london_32
				(param1 posn: 447 88)
			)
			(3063 ; london_33
				(param1 posn: 439 85)
			)
			(3064 ; london_34
				(param1 posn: 429 87)
			)
			(3065 ; london_35
				(param1 posn: 414 91)
			)
			(3066 ; london_36
				(param1 posn: 414 91)
			)
			(3067 ; london_Crab_Display
				(param1 posn: 447 88)
			)
			(3068 ; london_Mantis_Display
				(param1 posn: 447 88)
			)
			(3069 ; london_Centipede_Display
				(param1 posn: 447 88)
			)
			(3070 ; london_Monitor
				(param1 posn: 430 82)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

(instance displayRm of AutoMapProp
	(properties
		x 134
		y 55
		cel 2
		view 355
		testFlag 264
	)
)

(instance biotRm of AutoMapProp
	(properties
		x 425
		y 93
		cel 1
		view 355
		testFlag 266
	)
)

(instance trashPit of AutoMapProp
	(properties
		x 274
		y 127
		view 355
		testFlag 265
	)
)

