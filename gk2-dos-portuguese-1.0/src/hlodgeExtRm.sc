;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use northExit)
(use huntRegion)
(use Scaler)
(use Feature)

(public
	hlodgeExtRm 0
)

(instance hlodgeExtRm of ExitRoom
	(properties
		picture 5003
		east 621 ; hwoods5Rm
		west 606 ; hwoods2Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(621 ; hwoods5Rm
				(gEgo posn: 500 328 heading: 270)
			)
			(else
				(gEgo posn: 50 328 heading: 90)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 53 39 332 247 init:)
		(self setRegions: 499) ; huntRegion
		(super init: &rest)
		(proc499_4)
		(fLodgeDoor init:)
		(fStable init:)
		(gGame handsOn:)
	)
)

(instance fLodgeDoor of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 260 143 305 144 306 239 262 247)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 13 62 0 1 0 600) ; "(CLICK ON HUNTING LODGE DOOR DURING NIGHT HUNT)The door's locked!"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fStable of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 482 152 581 146 582 232 482 232)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 14 62 0 1 0 600) ; "(CLICK ON HORSES IN STABLE DURING NIGHT HUNT)Even if I could figure out how to saddle a horse, I'd never be able to ride it."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance eastExit of ExitFeature ; UNUSED
	(properties
		nsLeft 586
		nsTop 15
		nsRight 640
		nsBottom 334
		x 2000
		y 328
		BAD_SELECTOR 2
	)

	(method (doVerb)
		(gCurRoom newRoom: 621) ; hwoods5Rm
	)
)

(instance westExit of ExitFeature ; UNUSED
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		x 63536
		y 328
		BAD_SELECTOR 6
	)

	(method (doVerb)
		(gCurRoom newRoom: 606) ; hwoods2Rm
	)
)

