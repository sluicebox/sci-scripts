;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7212)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Motion)
(use Actor)

(public
	rm7212 0
)

(instance rm7212 of ExitRoom
	(properties
		picture 7212
		south 720 ; dungeonRm
	)

	(method (init)
		(super init: &rest)
		(dungeonWindow init:)
		(clawMarks init:)
		(if (and (== gChapter 6) (not (IsFlag 710)))
			(dove init:)
		)
	)
)

(instance dungeonWindow of GKFeature
	(properties
		nsLeft 206
		nsTop 72
		nsRight 384
		nsBottom 175
		sightAngle 40
		approachX 300
		approachY 189
		x 294
		y 122
		BAD_SELECTOR 7240
	)
)

(instance clawMarks of GKFeature
	(properties
		noun 2
		modNum 720
		nsLeft 58
		nsTop 187
		nsRight 510
		nsBottom 307
		x 284
		y 247
	)

	(method (doVerb theVerb)
		(if (== gChapter 6)
			(= noun 8)
		)
		(super doVerb: theVerb)
	)
)

(instance dove of Prop
	(properties
		modNum 720
		x 120
		y 180
		view 131
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 712)
			(= x 160)
		else
			(= x 120)
		)
		(self setCycle: Fwd)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 712)
						(= noun 11)
					)
					((IsFlag 711)
						(= noun 10)
					)
					(else
						(SetFlag 711)
						(= noun 9)
					)
				)
				(super doVerb: theVerb)
			)
			(30 ; invPillowcase
				(if (IsFlag 712)
					(PlayScene 757)
					(SetFlag 710)
					(gEgo put: 61 get: 77) ; invPillowcase, invDove
					(self dispose:)
				else
					(= noun 12)
					(super doVerb: theVerb)
				)
			)
			(132 ; invRoll
				(PlayScene 756)
				(gEgo put: 75) ; invRoll
				(SetFlag 712)
			)
			(else
				(= noun 14)
				(super doVerb: theVerb)
			)
		)
	)
)

