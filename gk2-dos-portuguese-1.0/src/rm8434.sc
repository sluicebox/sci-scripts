;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8434)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm8434 0
)

(instance rm8434 of ExitRoom
	(properties
		picture 8434
		south 8413 ; rm8413
	)

	(method (init)
		(super init: &rest)
		(water init:)
	)
)

(instance water of GKFeature
	(properties
		nsTop 19
		nsRight 240
		nsBottom 333
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; invLily
				(PlayScene 501)
				(gEgo put: 45) ; invLily
				(SetFlag 405)
				(SetFlag 617)
			)
			(else
				(gCurRoom setScript: nvScript)
			)
		)
	)
)

(instance nvScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 405)
					(gMessager say: 17 62 0 1 self 840) ; "(LOOK AT WATER AFTER SEEING LUDWIG'S FACE IN WATER)I hope I'm not losing my mind."
				else
					(gMessager say: 16 62 0 1 self 840) ; "(LOOK AT WATER WHERE LUDWIG DROWNED)I wonder what it felt like, under there?"
				)
			)
			(1
				(gCurRoom newRoom: 8413)
			)
		)
	)
)

