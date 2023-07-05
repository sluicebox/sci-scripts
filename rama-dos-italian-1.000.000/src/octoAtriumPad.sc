;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7001)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SaveManager)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	octoAtriumPad 0
)

(local
	local0
	[local1 2] = [7011 7012]
	[local3 2] = [7013 7014]
	[local5 2] = [7009 7010]
	[local7 2] = [7036 7037]
	[local9 2] = [7005 7006]
	[local11 2] = [7034 7035]
	[local13 2] = [7017 7018]
	local15
)

(procedure (localproc_0 &tmp temp0)
	(while (== (= temp0 (Random 1 32)) global259)
	)
	(= global259 temp0)
)

(instance octoAtriumPad of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(faceE up: faceUpN)
		(faceMynie up: faceUpN)
		(faceS up: faceUpN)
		(faceMo up: faceUpN)
		(faceRamp up: faceUpN)
		(faceEenie up: faceUpN)
		(faceMeenie up: faceUpN)
		(faceN up: faceUpN)
		(switch gPrevRoomNum
			(7000 ; octoAtriumRamp
				(self
					addPicObj:
						faceE
						faceMynie
						faceS
						faceMo
						faceRamp
						faceEenie
						faceN
						faceMeenie
						faceE
				)
			)
			(7002 ; octoAtriumEenie
				(self
					addPicObj:
						faceMynie
						faceS
						faceMo
						faceRamp
						faceEenie
						faceN
						faceMeenie
						faceE
						faceMynie
				)
			)
			(7004 ; octoAtriumMeenie
				(self
					addPicObj:
						faceMo
						faceRamp
						faceEenie
						faceN
						faceMeenie
						faceE
						faceMynie
						faceS
						faceMo
				)
			)
			(7006 ; octoAtriumMynie
				(self
					addPicObj:
						faceEenie
						faceN
						faceMeenie
						faceE
						faceMynie
						faceS
						faceMo
						faceRamp
						faceEenie
				)
			)
			(7008 ; octoAtriumMo
				(self
					addPicObj:
						faceMeenie
						faceE
						faceMynie
						faceS
						faceMo
						faceRamp
						faceEenie
						faceN
						faceMeenie
				)
			)
			(else
				(self
					addPicObj:
						faceE
						faceMynie
						faceS
						faceMo
						faceRamp
						faceEenie
						faceN
						faceMeenie
						faceE
				)
			)
		)
		(if (== local15 0)
			(gCurRoom setScript: sPadDown)
			(proc201_1 8)
		)
	)

	(method (serialize param1 &tmp temp0)
		(if param1
			(super serialize: param1 0)
			(= local15 (SaveManager readWord:))
			(switch (= temp0 (SaveManager readWord:))
				(180
					(= local0 faceS)
				)
				(135
					(= local0 faceMynie)
				)
				(90
					(= local0 faceE)
				)
				(45
					(= local0 faceMeenie)
				)
				(0
					(= local0 faceN)
				)
				(315
					(= local0 faceEenie)
				)
				(270
					(= local0 faceRamp)
				)
				(225
					(= local0 faceMo)
				)
				(270
					(= local0 faceRamp)
				)
			)
		else
			(super serialize: param1)
			(SaveManager writeWord: local15)
			(SaveManager writeWord: (local0 heading:))
		)
	)

	(method (dispose)
		(= local15 0)
		(super dispose: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 7008
		edgeS 0
	)

	(method (init)
		(if (proc1111_24 181)
			(meenieGate cel: 1 x: 562 y: 132 init: global117)
		)
		(if (proc1111_24 180)
			(eenieGate cel: 0 x: 1 y: 190 init: global117)
		)
		(= local0 self)
		(super init: &rest)
		(padDown_90 init:)
	)
)

(instance faceUpN of CameraAngle
	(properties
		heading 90
		picture 7019
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(outerWheel init: global117)
		(innerWheel init: global117)
		(colorWheel_90_up init:)
		(= down local0)
		(super init: &rest)
	)
)

(instance faceEenie of CameraAngle
	(properties
		heading 315
		edgeS 0
	)

	(method (init)
		(if (IsFlag 180)
			(self picture: [local11 local15])
		else
			(self picture: [local9 local15])
		)
		(= local0 self)
		(exitToEenie init:)
		(gCurRoom exitN: exitToEenie)
		(super init:)
		(padDown_90 init:)
		(theEenieGate init:)
	)
)

(instance faceRamp of CameraAngle
	(properties
		heading 270
		picture 7004
		edgeS 0
	)

	(method (init)
		(if (proc1111_24 180)
			(eenieGate cel: 1 x: 561 y: 189 init: global117)
		)
		(= local0 self)
		(exitToRamp init:)
		(gCurRoom exitN: exitToRamp)
		(super init:)
		(theRamps init:)
	)
)

(instance faceMo of CameraAngle
	(properties
		heading 225
		picture 7018
		edgeS 0
	)

	(method (init)
		(= local0 self)
		(self picture: [local13 local15])
		(exitToMo init:)
		(gCurRoom exitN: exitToMo)
		(super init:)
		(theMoGate init:)
		(padDown_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 7016
		edgeS 0
	)

	(method (init)
		(= local0 self)
		(padDown_90 init:)
		(super init: &rest)
	)
)

(instance faceMynie of CameraAngle
	(properties
		heading 135
		picture 7014
		edgeS 0
	)

	(method (init)
		(= local0 self)
		(self picture: [local3 local15])
		(exitToMynie init:)
		(gCurRoom exitN: exitToMynie)
		(super init:)
		(theMynieGate init:)
		(padDown_90 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		edgeS 0
	)

	(method (init)
		(self picture: [local1 local15])
		(if (proc1111_24 181)
			(switch local15
				(0
					(meenieGate y: 142)
				)
				(1
					(meenieGate y: 138)
				)
			)
			(meenieGate cel: 0 x: 1 init: global117)
		)
		(= local0 self)
		(super init: &rest)
		(padDown_90 init:)
	)
)

(instance faceMeenie of CameraAngle
	(properties
		heading 45
		edgeS 0
	)

	(method (init)
		(if (IsFlag 181)
			(self picture: [local7 local15])
		else
			(self picture: [local5 local15])
		)
		(= local0 self)
		(super init: &rest)
		(padDown_90 init:)
		(theMeenieGate init:)
		(exitToMeenie init:)
		(gCurRoom exitN: exitToMeenie)
	)
)

(instance exitToRamp of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7000
	)
)

(instance theRamps of Feature
	(properties
		noun 16
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToEenie of ExitFeature
	(properties
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
		nextRoom 7002
	)
)

(instance theEenieGate of Feature
	(properties
		noun 24
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(if (IsFlag 180)
			(= case 2)
		else
			(= case 1)
		)
		(self setHotspot: 144)
	)
)

(instance exitToMeenie of ExitFeature
	(properties
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
		nextRoom 7004
	)
)

(instance theMeenieGate of Feature
	(properties
		noun 24
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(if (IsFlag 181)
			(= case 2)
		else
			(= case 1)
		)
		(self setHotspot: 144)
	)
)

(instance exitToMynie of ExitFeature
	(properties
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
		nextRoom 7006
	)
)

(instance theMynieGate of Feature
	(properties
		noun 24
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
		case 1
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToMo of ExitFeature
	(properties
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
		nextRoom 7008
	)
)

(instance theMoGate of Feature
	(properties
		noun 24
		nsBottom 202
		nsLeft 234
		nsRight 375
		nsTop 105
		case 2
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance padDown_90 of Feature
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
					init: 6 289 161 250 282 243 410 250 588 290 292 291 6 290
					yourself:
				)
		)
	)
)

(instance colorWheel_90_up of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 76 277 28 311 28 389 77 410 125 410 166 362 240 314 260 273 261 221 238 177 162 179 127 197 72 226 47
					yourself:
				)
		)
	)
)

(instance sPadDown of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local15 1)
				(localproc_0)
				(= seconds 2)
			)
			(1
				(= temp1 (gCurRoom picObj:))
				(temp1 init:)
				(padDownSnd init: play: self)
			)
			(2
				(if (proc1111_24 213)
					(proc1111_31 27)
					(SetFlag 213)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance outerWheel of View
	(properties
		x 176
		y 265
		loop 1
		view 7000
	)

	(method (init)
		(= cel (mod global259 8))
		(super init: &rest)
	)
)

(instance innerWheel of View
	(properties
		x 213
		y 228
		view 7000
	)

	(method (init)
		(= cel (/ global259 8))
		(super init: &rest)
	)
)

(instance eenieGate of View
	(properties
		loop 1
		view 7001
	)
)

(instance meenieGate of View
	(properties
		loop 1
		view 7002
	)
)

(instance padDownSnd of Sound
	(properties
		number 7100
		flags 5
	)
)

