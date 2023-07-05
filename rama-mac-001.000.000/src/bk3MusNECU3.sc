;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4217)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk3MusNECU3 0
)

(instance bk3MusNECU3 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4236)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit20Butn init: global117)
		(PLANET_45 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sFinishSpinning)
		else
			(super pitch: param1 &rest)
		)
	)
)

(instance sFinishSpinning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(octoGlobe stop: 1 self)
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

(instance exhibit20Butn of ExhibitButton
	(properties
		x 187
		y 274
		view 4252
	)

	(method (init)
		(if (IsFlag 312)
			(octoGlobe spin: 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(octoGlobe stop: 0)
					(ClearFlag 312)
				else
					(octoGlobe spin: 1)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoGlobe of SpinningGlobe
	(properties
		robot 4252
		maxFrame 79
		robotX 213
	)
)

(instance PLANET_45 of Feature
	(properties
		noun 55
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 84 243 28 301 0 368 35 387 90 364 147 299 161 253 142 223 91
					yourself:
				)
		)
	)
)

