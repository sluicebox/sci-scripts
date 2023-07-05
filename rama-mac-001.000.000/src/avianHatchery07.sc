;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6807)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Actor)

(public
	avianHatchery07 0
)

(instance avianHatchery07 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(faceS up: faceUpS)
		(faceUpS down: faceS)
		(switch gPrevRoomNum
			(6813 ; avianHatchery13
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6804 ; avianHatchery04
				(switch global164
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(else
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
				)
			)
			(6803 ; avianHatchery03
				(switch global164
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(else
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
				)
			)
			(6808
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceE
						(westMural1 init: global117)
						(westMural2 init: global117)
					)
					(else
						(northUpMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceE
						(westMural1 dispose:)
						(westMural2 dispose:)
					)
					(else
						(northUpMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6840
		heading 180
		edgeS 0
	)

	(method (init)
		(boxExit init:)
		(gCurRoom exitN: boxExit)
		(super init:)
	)
)

(instance faceUpS of CameraAngle
	(properties
		picture 6841
		heading 180
		edgeN 0
		edgeE 0
		edgeW 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6842
		heading 270
		edgeN 0
		edgeS 0
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6844
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northColumnExit init:)
		(eastColumnExit init:)
		(gCurRoom exitN: northColumnExit)
		(gCurRoom exitNW: eastColumnExit)
		(super init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6843
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastColumnExit2 init:)
		(gCurRoom exitNE: eastColumnExit2)
		(super init:)
	)
)

(instance northColumnExit of ExitFeature
	(properties
		nsLeft 247
		nsTop 113
		nsRight 408
		nsBottom 225
		nextRoom 6804
	)
)

(instance eastColumnExit of ExitFeature
	(properties
		nsLeft 21
		nsTop 98
		nsRight 176
		nsBottom 265
		nextRoom 6803
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 90)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastColumnExit2 of ExitFeature
	(properties
		nsLeft 468
		nsTop 126
		nsRight 555
		nsBottom 223
		nextRoom 6803
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 180)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxExit of ExitFeature
	(properties
		nsLeft 252
		nsTop 100
		nsRight 340
		nsBottom 268
		nextRoom 6813
	)
)

(instance westMural1 of View
	(properties
		x 260
		y 166
		view 6807
	)
)

(instance westMural2 of View
	(properties
		x 543
		y 47
		view 6807
		cel 1
	)
)

(instance northUpMural of View
	(properties
		x 29
		y 194
		view 6807
		cel 2
	)
)

