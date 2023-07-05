;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5542)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm5542 0
)

(instance rm5542 of ExitRoom
	(properties
		modNum 543
		picture 5442
	)

	(method (init)
		(super init: &rest)
		(northExit init:)
		(fSouthExit init:)
		(fLedge init:)
		(fGround init:)
		(gGame handsOn:)
	)

	(method (cue)
		(PlayScene 6301 0 570) ; ledgeRm
	)
)

(instance fLedge of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: -1 134 622 135 616 269 -11 269)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 5 theVerb 0 1 0 543) ; "(LOOK AT LEDGE)That ledge runs along the entire face of the building. It's too narrow to walk on, though. Without help."
			)
			(22 ; invRope
				(if (not (IsFlag 668))
					(SetFlag 668)
					(gMessager say: 6 theVerb 0 1 gCurRoom 543) ; "(CLICK ROPE ON LEDGE TO CLIMB OUT)I hate it when I come up with ideas like this."
				else
					(gCurRoom cue:)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance fGround of GKFeature
	(properties
		modNum 540
	)

	(method (init)
		(super init: &rest)
		(self createPoly: -3 -3 616 -2 617 134 -1 133)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 7 62 0 1 0 543) ; "(LOOK AT GROUND FROM PREISS'S WINDOW)That's not a fall I'd care to take."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		modNum 540
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 269 618 269 616 332 -1 332)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 6301 0 5512) ; rm5512
		else
			(super doVerb: &rest)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsTop 15
		nsRight 613
		nsBottom 84
		x 225
		y 63536
		nextRoomNum 5541 ; rm5541
		exitDir 0
	)

	(method (setCursor param1)
		(param1 view: 998)
		(param1 loop: 1)
		(param1 cel: 1)
	)
)

