;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7909)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use Button)
(use n132)
(use n1111)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoSubwayInsideCar 0
)

(instance octoSubwayInsideCar of Location
	(properties)

	(method (init)
		(proc132_0)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(7908 ; octoSubwaySmall
				(SoundManager fadeMusic: 0 20 10 1 0)
				(ClearFlag 187)
				(if (and (!= (proc70_9 89) -4) (!= (proc70_9 90) -4))
					(proc70_11)
				)
				(self addPicObj: faceMorph faceStation faceMorph)
			)
			(7920 ; octoMorph
				(SetFlag 187)
				(self addPicObj: faceStation faceMorph faceStation)
			)
			(else
				(self addPicObj: faceStation faceMorph faceStation)
			)
		)
	)

	(method (dispose)
		(if (and (not (SoundManager musicNum:)) (== picObj faceStation))
			(SoundManager playMusic: 0 -1 7150)
		)
		(proc132_1)
		(super dispose: &rest)
	)
)

(instance faceMorph of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
		showBlack 1
	)

	(method (init)
		(self showBlack: 1)
		(if (IsFlag 187)
			(exitToMorph init:)
			(gCurRoom exitN: exitToMorph)
			(if
				(and
					(IsFlag 189)
					(!= (proc70_9 89) -1)
					(!= (proc70_9 90) -1)
				)
				(= picture 7944)
				(super init: &rest)
			else
				(= picture 7942)
				(super init: &rest)
			)
			(morphs init: global117)
		else
			(= picture 7933)
			(doorLatch init: global117)
			(super init: &rest)
		)
		(crunchie init: global117)
	)
)

(instance faceStation of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
		showBlack 1
	)

	(method (init)
		(self showBlack: 1)
		(if (proc1111_24 187)
			(exitToStation init:)
			(gCurRoom exitN: exitToStation)
			(= picture 7932)
		else
			(stationDoor init: global117)
			(= picture 7945)
		)
		(super init: &rest)
	)
)

(instance exitToStation of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7908
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToMorph of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7920
	)
)

(instance sTravelling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorCloseSound play: self)
			)
			(1
				(travelling
					view: (if (IsFlag 187) 7912 else 7911)
					cel: 0
					init: global117
					setCycle: End self
				)
				(subwayTravelSnd play:)
			)
			(2
				(travelling dispose:)
				(if (IsFlag 187)
					(doorLatch dispose:)
					(subwayDoor
						view: 7912
						setPri: 100
						x: 132
						y: 13
						cel: 0
						init: global117
					)
					(if
						(and
							(IsFlag 189)
							(!= (proc70_9 89) -1)
							(!= (proc70_9 90) -1)
						)
						(gCurRoom picture: 7944 drawPic: 7944)
					else
						(gCurRoom picture: 7942 drawPic: 7942)
					)
					(self setScript: sMorphArrival self)
				else
					(stationDoor dispose:)
					(subwayDoor
						view: 7911
						setPri: 100
						cel: 0
						x: 144
						y: 0
						init: global117
					)
					(gCurRoom drawPic: 7932)
					(self setScript: sStationArrival self)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMorphArrival of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(subwayDoor cycleSpeed: 4 setCycle: End self)
				(doorCloseSound play:)
			)
			(2
				(morphs init: global117)
				(subwayDoor dispose:)
				(exitToMorph init:)
				(gCurRoom exitN: exitToMorph)
				(self dispose:)
			)
		)
	)
)

(instance sStationArrival of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(subwayDoor cycleSpeed: 4 setCycle: End self)
				(doorCloseSound play:)
			)
			(2
				(subwayDoor dispose:)
				(exitToStation init:)
				(gCurRoom exitN: exitToStation)
				(self dispose:)
			)
		)
	)
)

(instance doorLatch of Button
	(properties
		x 278
		y 262
		loop 3
		view 7913
		upLoop 3
		downLoop 3
	)

	(method (init)
		(self setPri: 10)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(SetFlag 187)
				(gCurRoom setScript: sTravelling)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stationDoor of Button
	(properties
		x 278
		y 262
		loop 3
		view 7915
		upLoop 3
		downLoop 3
	)

	(method (init)
		(= priority 15)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(ClearFlag 187)
				(gCurRoom setScript: sTravelling)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorCloseSound of Sound
	(properties
		number 7920
		flags 5
	)
)

(instance subwayTravelSnd of Sound
	(properties
		number 7925
		flags 5
	)
)

(instance morphs of Prop
	(properties)

	(method (init)
		(= priority (global116 priority:))
		(= cycleSpeed 6)
		(if (and (IsFlag 189) (!= (proc70_9 89) -1) (!= (proc70_9 90) -1))
			(= view 7910)
			(= x 188)
			(= y 156)
		else
			(= view 7909)
			(= x 185)
			(= y 151)
		)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance subwayDoor of Prop
	(properties
		priority 255
	)

	(method (init)
		(super init: global117 &rest)
	)
)

(instance travelling of Prop
	(properties
		priority 255
		x 148
		y 72
		loop 1
	)

	(method (init)
		(= cel 0)
		(super init: global117 &rest)
	)
)

(instance crunchie of View
	(properties
		x 301
		y 254
		loop 1
		view 7913
	)

	(method (init)
		(if (or (== (proc70_9 89) 7909) (== (proc70_9 90) 7909))
			(= priority 255)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(self hide:)
				(= temp0 (if (== (proc70_9 89) 7909) 89 else 90))
				(proc70_1 temp0 1)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

