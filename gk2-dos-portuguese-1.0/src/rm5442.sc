;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5442)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm5442 0
)

(instance rm5442 of ExitRoom
	(properties
		modNum 540
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
)

(instance fLedge of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 269 0 154 616 159 616 269)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 6 theVerb 0 1 0 540) ; "(LOOK AT LEDGE OUTSIDE WINDOW)There's a ledge under the windows. Too bad it's not a little wider."
			)
			(22 ; invRope
				(gMessager say: 7 theVerb 0 1 0 540) ; "(CLICK ROPE ON LEDGE FROM GABE'S ROOM)That's an interesting idea, but I don't need to go anywhere on this side of the building."
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
		(self createPoly: -2 -5 617 -1 616 156 -1 153)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 9 62 0 1 0 540) ; "(LOOK AT GROUND FROM GABRIEL'S BEDROOM WINDOW)It's a ways down there, innit?"
		else
			(super doVerb: &rest)
		)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		modNum 540
		BAD_SELECTOR 4
	)

	(method (init)
		(super init: &rest)
		(self createPoly: -1 269 617 269 617 333 -2 333)
	)

	(method (doVerb)
		(PlayScene 630 0 5411) ; rm5411
	)
)

(instance northExit of ExitFeature
	(properties
		nsTop 15
		nsRight 613
		nsBottom 84
		x 225
		y 63536
		BAD_SELECTOR 5441
		BAD_SELECTOR 0
	)

	(method (setCursor param1)
		(param1 view: 998)
		(param1 loop: 1)
		(param1 cel: 1)
	)
)

