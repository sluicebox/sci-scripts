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
		heading 90
		picture 7926
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToSmall init:)
		(gCurRoom exitN: exitToSmall)
		(super init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 7925
		edgeS 0
		edgeN 0
	)
)

(instance faceBig of CameraAngle
	(properties
		heading 270
		picture 7928
		edgeS 0
		edgeN 0
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
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToDome init:)
		(gCurRoom exitN: exitToDome)
		(super init:)
	)
)

(instance exitToDome of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7904
	)
)

(instance exitToSmall of ExitFeature
	(properties
		nsBottom 201
		nsLeft 215
		nsRight 321
		nsTop 145
		nextRoom 7908
	)
)

(instance exitToBig of ExitFeature
	(properties
		nsBottom 189
		nsLeft 236
		nsRight 397
		nsTop 36
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
		number 7100
		flags 5
	)
)

