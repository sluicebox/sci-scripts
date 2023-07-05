;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4013)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm4013 0
)

(instance rm4013 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4013
		south 400 ; marienRm
	)

	(method (init)
		(super init: &rest)
		(fDoor init:)
		(fWindow init:)
		(gGame handsOn:)
	)
)

(instance fDoor of GKFeature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 397 334 395 55 527 73 527 334)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((== gChapter 5)
						(gMessager say: 34 62 0 0 0 400) ; "(PICKUP, CH 5 CLICK ON CUCKOO CLOCK SHOP, DARK)Don't think I have time for any more shoppin' today."
					)
					((== gChapter 1)
						(gMessager say: 28 62 0 0 0 400) ; "(TRY TO ENTER CLOCK SHOP CH 1)Maybe later. I've got other things on my mind at the moment."
					)
					((not (IsFlag 500))
						(SetFlag 500)
						(gSoundManager stop:)
						(PlayScene 236 0 4020) ; rm4020
					)
					(else
						(gCurRoom newRoom: 4020)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fWindow of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: -1 -1 368 -1 373 334 -1 334)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 27 62 0 0 0 400) ; "(LOOK AT CLOCK SHOP WINDOW)Cuckoo Clocks."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

