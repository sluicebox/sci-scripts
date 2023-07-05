;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 605)
(include sci.sh)
(use Main)
(use KQ6Room)
(use Polygon)

(public
	rm605 0
)

(instance rm605 of KQ6Room
	(properties
		picture 605
		north 630
		autoLoad 0
	)

	(method (init &tmp [temp0 40])
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 295 93 305 116 246 146 261 129 241 114 137 114 106 120 140 138 99 150 42 150 31 163 54 167 319 167 319 43 255 43 255 79
					yourself:
				)
		)
		(gEgo init: reset: 4 setScale:)
		(if (== gPrevRoomNum 630)
			(gEgo posn: 302 80)
		else
			(gEgo posn: 95 167)
		)
		(super init: &rest)
		(gGame handsOn:)
	)
)

