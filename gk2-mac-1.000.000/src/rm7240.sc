;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7240)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Actor)

(public
	rm7240 0
)

(instance rm7240 of ExitRoom
	(properties
		picture 7240
		south 720 ; dungeonRm
	)

	(method (init)
		(super init: &rest)
		(clawMarks1 init:)
		(clawMarks2 init:)
		(clawMarks3 init:)
		(clawMarks4 init:)
		(bar1 init:)
		(bar2 init:)
		(bar3 init:)
		(if (and (== gChapter 6) (not (IsFlag 710)))
			(dove init: setScript: FidgetScript)
		)
		(churchInWindow init:)
	)
)

(instance dove of Prop
	(properties
		modNum 720
		x 268
		y 293
		view 20755
	)

	(method (init)
		(if (IsFlag 712)
			(= view 20724)
			(= x 272)
			(= y 333)
		else
			(= x 268)
			(= y 293)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(= noun
					(cond
						((IsFlag 712) 11)
						((IsFlag 711) 10)
						(else
							(SetFlag 711)
							9
						)
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
				(self setScript: 0)
				(= view 20724)
				(= x 272)
				(= y 333)
				(gEgo put: 75) ; invRoll
				(SetFlag 712)
				(PlayScene 756)
				(self setScript: FidgetScript)
			)
			(else
				(= noun 14)
				(super doVerb: 62)
			)
		)
	)
)

(instance churchInWindow of Feature
	(properties
		nsLeft 74
		nsTop 50
		nsRight 532
		nsBottom 283
		sightAngle 40
		approachX 308
		approachY 297
		x 302
		y 165
	)

	(method (doVerb)
		(if (not (IsFlag 472))
			(SetFlag 472) ; enable "Church Records" in rm711c2d2
			(PlayScene 214)
		else
			(gMessager say: 3 62 0 1 0 7240) ; "(LOOK AT CHURCH THROUGH WINDOW, THOUGHTFUL)That's the church in the square."
		)
	)
)

(instance clawMarks1 of Feature
	(properties
		noun 2
		modNum 720
		nsLeft 24
		nsTop 12
		nsRight 74
		nsBottom 285
		sightAngle 40
		approachX 30
		approachY 254
		x 46
		y 146
	)

	(method (init)
		(if (== gChapter 6)
			(= noun 8)
		)
		(super init: &rest)
	)
)

(instance clawMarks2 of Feature
	(properties
		noun 2
		modNum 720
		nsLeft 534
		nsTop 12
		nsRight 582
		nsBottom 324
		sightAngle 40
		approachX 564
		approachY 264
		x 558
		y 165
	)

	(method (init)
		(if (== gChapter 6)
			(= noun 8)
		)
		(super init: &rest)
	)
)

(instance clawMarks3 of Feature
	(properties
		noun 2
		modNum 720
		nsLeft 74
		nsTop 12
		nsRight 534
		nsBottom 52
		sightAngle 40
		approachX 220
		approachY 48
		x 306
		y 31
	)

	(method (init)
		(if (== gChapter 6)
			(= noun 8)
		)
		(super init: &rest)
	)
)

(instance clawMarks4 of Feature
	(properties
		noun 2
		modNum 720
		nsLeft 18
		nsTop 285
		nsRight 534
		nsBottom 324
		sightAngle 40
		approachX 290
		approachY 304
		x 276
		y 304
	)

	(method (init)
		(if (== gChapter 6)
			(= noun 8)
		)
		(super init: &rest)
	)
)

(instance bar1 of Feature
	(properties
		noun 1
		nsLeft 210
		nsTop 55
		nsRight 222
		nsBottom 283
		sightAngle 40
		approachX 216
		approachY 244
		x 216
		y 170
	)
)

(instance bar2 of Feature
	(properties
		noun 1
		nsLeft 376
		nsTop 55
		nsRight 386
		nsBottom 283
		sightAngle 40
		approachX 384
		approachY 254
		x 380
		y 168
	)
)

(instance bar3 of Feature
	(properties
		noun 1
		nsLeft 76
		nsTop 163
		nsRight 532
		nsBottom 175
		sightAngle 40
		approachX 234
		approachY 170
		x 304
		y 168
	)
)

