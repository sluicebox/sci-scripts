;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3061)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)

(public
	london_31 0
)

(instance london_31 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3062 ; london_32
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(self addPicObj: faceW faceE faceW)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3059
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastExitToLondon30 init:)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3058
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(westExitToLondon32 init:)
		(super init:)
	)
)

(instance eastExitToLondon30 of ExitFeature
	(properties
		nextRoom 3060
	)
)

(instance westExitToLondon32 of ExitFeature
	(properties
		nextRoom 3062
	)
)

