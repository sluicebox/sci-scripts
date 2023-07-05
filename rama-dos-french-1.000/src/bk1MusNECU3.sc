;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4017)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk1MusNECU3 0
)

(local
	local0
)

(instance bk1MusNECU3 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4040)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhbt19Butn init: global117)
		(earth_45 init:)
	)

	(method (pitch)
		(self setScript: sFinishSpinning)
	)
)

(instance sFinishSpinning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (earthGlobe notDone:)
					(earthGlobe stop: 1 self)
				else
					(++ state)
					(= cycles 1)
				)
			)
			(1
				(ClearFlag 312)
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance exhbt19Butn of ExhibitButton
	(properties
		x 208
		y 242
		view 4052
	)

	(method (init)
		(if (IsFlag 312)
			(earthGlobe spin: 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(earthGlobe stop: 0)
					(ClearFlag 312)
				else
					(earthGlobe spin: 1)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance earth_45 of Feature
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
					init: 225 79 247 29 309 4 370 40 388 87 364 144 301 160 250 139
					yourself:
				)
		)
	)
)

(instance earthGlobe of SpinningGlobe
	(properties
		robot 4051
		robotX 214
		maxFrame 79
	)
)

