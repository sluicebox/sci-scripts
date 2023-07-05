;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7401)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use newYorkRegion)
(use n1111)
(use Osc)
(use Feature)
(use Window)
(use Actor)

(public
	octoMoCistern 0
)

(instance octoMoCistern of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7500 ; octoCistern
				(self addPicObj: faceAtrium faceCis faceAtrium)
			)
			(7501 ; octoCisMO
				(self addPicObj: faceAtrium faceCis faceAtrium)
			)
			(else
				(self addPicObj: faceCis faceAtrium faceCis)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(self newRoom: 7501) ; octoCisMO
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 194)
			(= picture 7403)
		else
			(= picture 7408)
		)
		(exitToAtrium init:)
		(gCurRoom exitN: exitToAtrium)
		(super init:)
	)
)

(instance faceCis of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init &tmp temp0)
		(exitToCis init:)
		(gCurRoom exitN: exitToCis)
		(if (proc1111_24 186)
			(= picture 7429)
			(entToCis init:)
			(octosDancing init: global117 setCycle: Osc)
		else
			(= picture 7404)
		)
		(super init: &rest)
	)
)

(instance exitToAtrium of ExitFeature
	(properties
		nsBottom 213
		nsLeft 42
		nsRight 354
		nsTop 128
		nextRoom 7400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: exitCursor)
			)
			(else
				(if (and exitVMD (<= (gGame _detailLevel:) detailLevel))
					(exitVMD play:)
				)
				(gCurRoom newRoom: nextRoom)
			)
		)
	)
)

(instance entToCis of Feature
	(properties
		noun 33
		nsBottom 253
		nsLeft 141
		nsRight 462
		nsTop 126
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToCis of ExitFeature
	(properties
		nsBottom 253
		nsLeft 141
		nsRight 462
		nsTop 126
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(if (IsFlag 186)
					(= nextRoom 7500)
					(= exitStyle 256)
					(super doVerb: theVerb)
				else
					(gGame handsOff:)
					(SoundManager fadeMusic: 0 20 8 1 gCurRoom)
				)
				(proc201_1 14)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octosDancing of Prop
	(properties
		x 298
		y 147
		cycleSpeed 4
		view 7400
	)
)

(instance myHotRect of HotRectangle ; UNUSED
	(properties
		left 50
		right 500
		bottom 200
		top 50
	)

	(method (doit)
		(PrintDebug {Doit})
	)
)

(instance myHotRectSet of HotRectangleSet ; UNUSED
	(properties)
)

