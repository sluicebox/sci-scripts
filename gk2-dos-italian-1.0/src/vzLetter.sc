;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56514)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)
(use System)

(public
	vzLetter 0
)

(instance vzLetter of ExitRoom
	(properties
		picture 56543
		south 56511 ; vzNightStand
	)

	(method (init)
		(super init: &rest)
		(fGrossLetter init:)
	)

	(method (dispose)
		(gEgo get: 52) ; invGrossbergLetter
		(super dispose: &rest)
	)
)

(instance fGrossLetter of GKFeature
	(properties
		noun 3
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 50 333 48 295 141 275 141 -1 536 -2 536 335)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom setScript: scoreScript)
		else
			(super doVerb: &rest)
		)
	)
)

(instance scoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 62 0 0 self 546) ; "(LOOK AT GROSSBERG'S LETTER, EVEN THOUGH THE LETTER IS IN GERMAN, IT'S BLACKMAIL INTENTIONS ARE CLEAR)If I'm not mistaken, Grossberg was trying to cash in on all the excitement around the missing zoo wolves. VON ZELL must have been the "new business partner" Grossberg told Dorn about. Guess von Zell didn't much care for the idea."
			)
			(1
				(gGame changeScore: 1068)
				(self dispose:)
			)
		)
	)
)

