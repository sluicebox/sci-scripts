;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4126)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk2MusSWCU3 0
)

(instance bk2MusSWCU3 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4159)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit21Butn init: global117)
		(PLANET_225 init:)
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
				(if (IsFlag 312)
					(mirmicatGlobe stop: 1 self)
					(ClearFlag 312)
				else
					(++ state)
					(= cycles 1)
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(proc1111_6)
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance exhibit21Butn of ExhibitButton
	(properties
		x 208
		y 242
		view 4152
	)

	(method (init)
		(if (IsFlag 312)
			(mirmicatGlobe spin: 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(mirmicatGlobe stop: 0)
					(ClearFlag 312)
				else
					(mirmicatGlobe spin: 1)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirmicatGlobe of SpinningGlobe
	(properties
		robot 4152
		robotX 210
		robotY 4
		maxFrame 80
	)
)

(instance PLANET_225 of Feature
	(properties
		noun 39
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 72 245 24 306 1 363 34 383 89 361 146 299 158 250 137 224 89
					yourself:
				)
		)
	)
)

