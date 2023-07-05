;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8341)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm8341 0
)

(instance rm8341 of ExitRoom
	(properties
		picture 8341
		south 8340 ; rm8340
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance readIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 62 0 1 self 830) ; "(READING SIGN ABOUT SLEIGH RIDE PAINTING, STILL A BIT FREAKED ABOUT HER DREAM AND THE PAINTING)The midnight sleigh rides. Ludwig went on long sleigh rides in the middle of the night, particularly in his later years. It is said that he suffered from insomnia, headaches, and toothaches, and the rides soothed his restlessness. The sight of the king's grand sleigh speeding through the country side of the Alps often startled the peasants and became a superstitious omen of ill fortune."
			)
			(1
				(if (IsFlag 648)
					(self dispose:)
				else
					(gGame changeScore: 1001)
					(gMessager say: 3 62 0 2 self 830) ; "(COMMENTING ON SIGN)I can see why! But what was he doing out there at night?"
				)
			)
			(2
				(SetFlag 648)
				(self dispose:)
			)
		)
	)
)

(instance plaque of GKFeature
	(properties
		nsLeft 20
		nsTop 28
		nsRight 600
		nsBottom 304
	)

	(method (doVerb)
		(gCurRoom setScript: readIt)
	)
)

