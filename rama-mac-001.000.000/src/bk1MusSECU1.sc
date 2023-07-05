;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4019)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	bk1MusSECU1 0
)

(instance bk1MusSECU1 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4042)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit22Butn init: global117)
		(light_135 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sTurnOffLight)
		else
			(super pitch: param1 &rest)
		)
	)
)

(instance sTurnOffLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(light dispose:)
				(ClearFlag 312)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance light_135 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 145 307 120 326 124 325 213 262 211 263 144
					yourself:
				)
		)
	)
)

(instance exhibit22Butn of ExhibitButton
	(properties
		x 273
		y 218
		view 4053
	)

	(method (init)
		(if (IsFlag 312)
			(light init: global117)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(light dispose:)
					(ClearFlag 312)
				else
					(light init: global117)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance light of View
	(properties
		x 168
		y 94
		view 4053
		loop 1
	)
)

