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
		heading 180
		picture 6840
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
		heading 180
		picture 6841
		edgeW 0
		edgeE 0
		edgeN 0
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6842
		edgeS 0
		edgeN 0
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6844
		edgeS 0
		edgeN 0
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
		edgeS 0
		edgeN 0
	)

	(method (init)
		(eastColumnExit2 init:)
		(gCurRoom exitNE: eastColumnExit2)
		(super init:)
	)
)

(instance northColumnExit of ExitFeature
	(properties
		nsBottom 225
		nsLeft 247
		nsRight 408
		nsTop 113
		nextRoom 6804
	)
)

(instance eastColumnExit of ExitFeature
	(properties
		nsBottom 265
		nsLeft 21
		nsRight 176
		nsTop 98
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
		nsBottom 223
		nsLeft 468
		nsRight 555
		nsTop 126
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
		nsBottom 268
		nsLeft 252
		nsRight 340
		nsTop 100
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
		cel 1
		view 6807
	)
)

(instance northUpMural of View
	(properties
		x 29
		y 194
		cel 2
		view 6807
	)
)

