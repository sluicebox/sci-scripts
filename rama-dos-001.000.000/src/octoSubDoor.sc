;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7903)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	octoSubDoor 0
	sPadUp 1
)

(instance octoSubDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7904 ; octoSubDome
				(self addPicObj: facePit faceDoor facePit)
				(self setScript: sPadUp)
			)
			(7900 ; octoSubPad
				(self addPicObj: faceDoor facePit faceDoor)
				(self setScript: sPadUp)
			)
			(else
				(self addPicObj: faceDoor facePit faceDoor)
			)
		)
	)
)

(instance facePit of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (== global259 global260)
			(self picture: 7914)
		else
			(self picture: 7915)
		)
		(exitToPit init:)
		(gCurRoom exitN: exitToPit)
		(super init: &rest)
		(pitPad_0 init:)
	)
)

(instance faceDoor of CameraAngle
	(properties
		heading 180
		picture 7916
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToDoor init:)
		(gCurRoom exitNW: exitToDoor)
		(super init: &rest)
		(padDome_180 init:)
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7900
	)
)

(instance exitToDoor of ExitFeature
	(properties
		nsBottom 285
		nsLeft 189
		nsRight 413
		nsTop 122
		nextRoom 7904
	)
)

(instance sPadUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(padUpSnd init: play: self)
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

(instance pitPad_0 of Feature
	(properties
		noun 25
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 255 170 231 288 219 450 234 506 265 469 293 109 293 89 259 187 228
					yourself:
				)
		)
	)
)

(instance padDome_180 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 206 374 207 377 244 217 242 213 206
					yourself:
				)
		)
	)
)

