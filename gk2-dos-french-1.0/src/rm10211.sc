;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10211)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm10211 0
)

(local
	local0
)

(instance rm10211 of ExitRoom
	(properties
		picture 10211
		east 1020 ; priestOfficeRm
		south 1020 ; priestOfficeRm
		west 1020 ; priestOfficeRm
	)

	(method (init)
		(super init: &rest)
		(waterBasket init:)
	)
)

(instance sAlreadyHaveWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 10 0 0 self 1020) ; "(CLICK ON WATER BOTTLES AFTER GETTING ONE)I don't need another bottle."
			)
			(1
				(gCurRoom newRoom: 1020) ; priestOfficeRm
				(self dispose:)
			)
		)
	)
)

(instance waterBasket of GKFeature
	(properties
		nsLeft 217
		nsTop 21
		nsRight 435
		nsBottom 316
		sightAngle 40
		x 284
		y 307
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if local0
					(gMessager say: 6 62 0 0 0 1020) ; "(PICKUP, LOOK AT WATER BOTTLES AT ALTOTTING)Mary's water. It looks like they want a donation."
				else
					(gMessager say: 5 62 0 0 0 1020) ; "(PICKUP, LOOK AT WATER BOTTLES AT ALTOTTING)Mary's water. It looks like they want a donation."
				)
				(++ local0)
			)
			(10 ; invGraceWallet
				(if (gEgo has: 62) ; invBottleOfWater
					(gCurRoom setScript: sAlreadyHaveWater)
				else
					(PlayScene 1792)
					(gEgo get: 62) ; invBottleOfWater
					(gCurRoom newRoom: 1020) ; priestOfficeRm
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

