;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)
(use System)

(public
	rm15300 0
)

(instance rm15300 of ScaryRoom
	(properties
		picture 15300
		stepSound 4
		baseView 6000
	)

	(method (init)
		(gEgo init: setScaler: Scaler 75 33 133 96 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(16200
				(gEgo
					normalize: 610
					posn:
						(+ (conservatory approachX:) 5)
						(conservatory approachY:)
				)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(17000
				(gEgo
					normalize: 611
					posn: (- (bedroom approachX:) 5) (bedroom approachY:)
				)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(else
				(gGame handsOn:)
				(gEgo normalize: 613 posn: 140 128)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
		)
		(conservatory init: 4 approachVerbs: 21) ; Exit
		(bedroom init: 2 approachVerbs: 21) ; Exit
		(southExit init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 16200)
				(IsFlag 265)
				(not (IsFlag 3))
				(not (IsFlag 247))
			)
			(SetFlag 247)
			(ClearFlag 52)
		)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 16200)
				(IsFlag 3)
				(not (IsFlag 5))
				(not (IsFlag 264))
			)
			(SetFlag 264)
			(ClearFlag 247)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance bedroom of ExitFeature
	(properties
		nsLeft 155
		nsTop 48
		nsRight 165
		nsBottom 98
		approachX 145
		approachY 98
		x 160
		y 98
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: enterBedroomScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance conservatory of ExitFeature
	(properties
		nsLeft 110
		nsTop 45
		nsRight 130
		nsBottom 100
		approachX 138
		approachY 98
		x 125
		y 98
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: enterConsScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 38
		nsRight 165
		approachX 140
		approachY 130
		nextRoom 15200
	)
)

(instance enterBedroomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(and (== gChapter 1) (IsFlag 53) (not (IsFlag 78)))
						(and (== gChapter 3) (not (IsFlag 324)))
					)
					(gCurRoom newRoom: 17100)
				else
					(gCurRoom newRoom: 17000)
				)
			)
		)
	)
)

(instance enterConsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gChapter 1) (>= global172 3) (not (IsFlag 83)))
					(SetFlag 53)
				)
				(if
					(and
						(== gChapter 1)
						(IsFlag 77)
						(not (IsFlag 78))
						(not (IsFlag 79))
					)
					(SetFlag 78)
					(SetFlag 79)
				)
				(gCurRoom newRoom: 16200)
			)
		)
	)
)

