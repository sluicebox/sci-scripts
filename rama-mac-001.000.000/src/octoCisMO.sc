;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7501)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)

(public
	octoCisMO 0
)

(instance octoCisMO of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7401 ; octoMoCistern
				(self addPicObj: faceCistern faceDoor faceCistern)
			)
			(else
				(self addPicObj: faceCistern faceDoor faceCistern)
			)
		)
	)
)

(instance faceDoor of CameraAngle
	(properties
		picture 7502
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToDoor init:)
		(gCurRoom exitN: exitToDoor)
		(super init:)
	)
)

(instance faceCistern of CameraAngle
	(properties
		picture 7501
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(exitToGate init:)
		(gCurRoom exitNW: exitToGate)
		(exitToCistern init:)
		(gCurRoom exitNE: exitToCistern)
		(if (proc1111_24 186)
			(SetFlag 186)
			(octosDancing play:)
			(SetFlag 194)
		)
	)
)

(instance exitToCistern of ExitFeature
	(properties
		nsLeft 510
		nsTop 170
		nsRight 586
		nsBottom 236
		nextRoom 7500
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(= global164 270)
		)
		(super doVerb: theVerb)
	)
)

(instance exitToGate of ExitFeature
	(properties
		nsLeft 204
		nsTop 130
		nsRight 393
		nsBottom 202
		nextRoom 7500
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(= global164 90)
		)
		(super doVerb: theVerb)
	)
)

(instance exitToDoor of ExitFeature
	(properties
		nsLeft 136
		nsTop 125
		nsRight 463
		nsBottom 278
		nextRoom 7401
		exitStyle 256
	)
)

(instance octosDancing of VMDMovie
	(properties
		movieName 7501
	)
)

