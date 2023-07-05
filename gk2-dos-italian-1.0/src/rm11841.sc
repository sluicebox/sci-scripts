;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11841)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm11841 0
)

(instance rm11841 of ExitRoom
	(properties
		modNum 1180
		picture 11841
	)

	(method (init)
		(if (== gEgo GabeEgo)
			(= noun 8)
		else
			(= noun 7)
		)
		(super init: &rest)
		(doorLatch init:)
		(theDoor init:)
		(southExit init:)
		(westExit init:)
		(eastExit init:)
	)

	(method (cue)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance doorLatch of GKFeature
	(properties
		modNum 1180
		nsLeft 196
		nsTop 163
		nsRight 266
		nsBottom 313
		x 298
		y 292
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(gMessager say: 7 theVerb 0 0 0 modNum) ; "(LOOK AT FLOOR LATCHES ON BASEMENT DOORS)How quaint! These little latches hold the doors open."
				else
					(gMessager say: 8 theVerb 0 0 0 modNum) ; "(LOOK AT FLOOR LATCHES, BARELY CURIOUS)Interestin' door latches around here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theDoor of GKFeature
	(properties
		modNum 1180
		x 298
		y 171
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 134 47 462 47 462 295 134 295
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(gMessager say: 9 theVerb 0 0 0 modNum) ; "(A BIT SHIVERY)If I started closing these basement doors, I'd never find my way out."
				else
					(gMessager say: 10 theVerb 0 0 0 modNum) ; "(AS IF AN INTERESTING IDEA BUT NOT VERY LOGICAL)Hmmm. I can't think of any reason to be closin' these doors at the moment."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb)
		(if (== gEgo GraceEgo)
			(PlayScene 1906 0 gPrevRoomNum)
		else
			(PlayScene 1907 0 gPrevRoomNum)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 586
		nsTop 15
		nsRight 640
		nsBottom 334
		x 2000
		y 250
		BAD_SELECTOR 2
	)

	(method (doVerb theVerb)
		(southExit doVerb: theVerb)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		x 63536
		y 250
		BAD_SELECTOR 6
	)

	(method (doVerb theVerb)
		(southExit doVerb: theVerb)
	)
)

