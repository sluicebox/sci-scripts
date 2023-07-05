;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7900)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SaveManager)
(use newYorkRegion)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	octoSubPad 0
)

(local
	local0
	[local1 5] = [0 7905 7937 7938 7906]
	[local6 5] = [0 7901 7935 7936 7902]
	[local11 5] = [0 7903 7904 7903 7904]
	[local16 5] = [0 7907 7908 7907 7908]
	local21
)

(instance octoSubPad of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(faceAbacus up: faceUpN)
		(faceW up: faceUpN)
		(faceE up: faceUpN)
		(faceDoor up: faceUpN)
		(if (== local21 0)
			(if (== global259 global260)
				(= local21 1)
			else
				(= local21 2)
			)
		)
		(switch gPrevRoomNum
			(7903 ; octoSubDoor
				(self addPicObj: faceAbacus faceE faceDoor faceW faceAbacus)
				(gCurRoom setScript: sPadDown)
			)
			(7702
				(= local21 4)
				(self addPicObj: faceDoor faceW faceAbacus faceE faceDoor)
			)
			(7901 ; octoSubAbacus
				(self addPicObj: faceDoor faceW faceAbacus faceE faceDoor)
				(gCurRoom setScript: sPadDown)
			)
			(else
				(= local21 4)
				(self addPicObj: faceDoor faceW faceAbacus faceE faceDoor)
			)
		)
		(proc201_1 19)
	)

	(method (pitch param1)
		(switch param1
			(1
				(self setPicObj: local0)
			)
			(-1
				(self setPicObj: faceUpN)
			)
		)
	)

	(method (serialize param1 &tmp temp0)
		(if param1
			(super serialize: param1 0)
			(= local21 (SaveManager readWord:))
			(switch (= temp0 (SaveManager readWord:))
				(180
					(= local0 faceDoor)
				)
				(90
					(= local0 faceE)
				)
				(270
					(= local0 faceW)
				)
				(0
					(= local0 faceAbacus)
				)
				(else
					(= local0 0)
				)
			)
		else
			(super serialize: param1)
			(SaveManager writeWord: local21)
			(SaveManager writeWord: (local0 heading:))
		)
	)

	(method (dispose)
		(= local21 0)
		(= local0 0)
		(super dispose: &rest)
	)
)

(instance faceUpN of CameraAngle
	(properties
		picture 7910
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= down local0)
		(= heading (down heading:))
		(if (== global259 global260)
			(self picture: 7910)
			(exitToPit init:)
			(gCurRoom exitN: exitToPit)
		else
			(self picture: 7909)
		)
		(super init: &rest)
		(pitUp init:)
	)
)

(instance faceAbacus of CameraAngle
	(properties
		edgeS 0
	)

	(method (init)
		(self picture: [local1 local21])
		(= local0 self)
		(exitToAbacus init:)
		(gCurRoom exitN: exitToAbacus)
		(super init: &rest)
		(padDown_All init:)
	)
)

(instance faceDoor of CameraAngle
	(properties
		heading 180
		edgeS 0
	)

	(method (init)
		(self picture: [local6 local21])
		(= local0 self)
		(exitToDoor init:)
		(gCurRoom exitN: exitToDoor)
		(super init: &rest)
		(padDown_All init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		edgeS 0
	)

	(method (init)
		(= local0 self)
		(self picture: [local16 local21])
		(super init: &rest)
		(padDown_All init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 7904
		heading 270
		edgeS 0
	)

	(method (init)
		(= local0 self)
		(self picture: [local11 local21])
		(super init: &rest)
		(crucifix init: global117)
		(padDown_All init:)
	)
)

(instance exitToAbacus of ExitFeature
	(properties
		nsLeft 227
		nsTop 128
		nsRight 399
		nsBottom 218
		nextRoom 7901
	)
)

(instance exitToDoor of ExitFeature
	(properties
		nsLeft 246
		nsTop 133
		nsRight 357
		nsBottom 215
		nextRoom 7903
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsLeft 224
		nsTop 65
		nsRight 384
		nsBottom 213
		nextRoom 7701
	)
)

(instance sPadDown of Script
	(properties)

	(method (changeState newState param2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== local21 1)
					(= local21 4)
				else
					(= local21 3)
				)
				(= seconds 3)
			)
			(1
				(= param2 (gCurRoom picObj:))
				(param2 init:)
				(spikeSound init: play: self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crucifix of View
	(properties
		noun 78
		x 337
		y 279
		view 7904
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pitUp of Feature
	(properties
		noun 61
		nsLeft 41
		nsTop 19
		nsRight 500
		nsBottom 249
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance padDown_All of Feature
	(properties
		noun 25
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 291 295 267 488 290 107 290
					yourself:
				)
		)
	)
)

(instance spikeSound of Sound
	(properties
		flags 5
		number 7700
	)
)

