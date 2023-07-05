;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7906)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Sound)
(use System)

(public
	octoSubStation 0
	sDomePadUp 1
)

(instance octoSubStation of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7904 ; octoSubDome
				(self addPicObj: faceS faceBig faceDome faceSmall faceS)
				(self setScript: sDomePadUp)
			)
			(7907 ; octoSubwayCarLarge
				(self addPicObj: faceDome faceSmall faceS faceBig faceDome)
			)
			(7908 ; octoSubwaySmall
				(self addPicObj: faceDome faceSmall faceS faceBig faceDome)
			)
			(else
				(self addPicObj: faceS faceBig faceDome faceSmall faceS)
			)
		)
	)
)

(instance faceSmall of CameraAngle
	(properties
		picture 7926
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToSmall init:)
		(gCurRoom exitN: exitToSmall)
		(super init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 7925
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance faceBig of CameraAngle
	(properties
		picture 7928
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToBig init:)
		(gCurRoom exitN: exitToBig)
		(super init:)
	)
)

(instance faceDome of CameraAngle
	(properties
		picture 7927
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToDome init:)
		(gCurRoom exitN: exitToDome)
		(super init:)
	)
)

(instance exitToDome of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 7904
	)
)

(instance exitToSmall of ExitFeature
	(properties
		nsLeft 215
		nsTop 145
		nsRight 321
		nsBottom 201
		nextRoom 7908
	)
)

(instance exitToBig of ExitFeature
	(properties
		nsLeft 236
		nsTop 36
		nsRight 397
		nsBottom 189
		nextRoom 7907
	)
)

(instance sDomePadUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(padUpSnd init: play:)
				(= seconds 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance padUpSnd of Sound
	(properties
		flags 5
		number 7100
	)
)

