;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5441)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm5441 0
)

(instance rm5441 of ExitRoom
	(properties
		modNum 540
		picture 5441
	)

	(method (init)
		(super init: &rest)
		(Lock 140 250 1) ; WAVE
		(gGk2Music setLoop: -1 number: 250 play:)
		(fLedgeCU init:)
		(fWoods init:)
		(fSouthExit init:)
		(gGame handsOn:)
	)
)

(instance fLedgeCU of ExitFeature
	(properties
		nextRoomNum 5442 ; rm5442
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1 300 0 211 618 218 617 300)
	)

	(method (setCursor param1)
		(param1 view: 998)
		(param1 loop: 1)
		(param1 cel: 0)
	)
)

(instance fWoods of GKFeature
	(properties
		modNum 540
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 -1 616 -1 616 217 1 211)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 5 62 0 1 0 540) ; "(LOOK AT WOODS FROM WINDOW)I'd hate to get lost out there."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fDriveway of GKFeature ; UNUSED
	(properties
		modNum 540
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 91 81 283 80 285 213 125 212)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 4 62 0 1 0 540) ; "(LOOK OUT LODGE WINDOW TO LODGE DRIVEWAY)That driveway's longer than the street I live on in New Orleans."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		modNum 540
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		exitDir 4
	)

	(method (doVerb)
		(PlayScene 630 0 5411) ; rm5411
	)
)

