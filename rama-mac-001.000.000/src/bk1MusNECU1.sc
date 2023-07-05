;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4015)
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
	bk1MusNECU1 0
)

(instance bk1MusNECU1 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4038)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(if (IsFlag 312)
			(helmet init: global117)
		)
		(exhibit17Butn init: global117)
		(helmet_45 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sTurnOffHelmet)
		else
			(super pitch: param1 &rest)
		)
	)
)

(instance sTurnOffHelmet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(helmet dispose:)
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

(instance exhibit17Butn of ExhibitButton
	(properties
		x 267
		y 279
		view 4059
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(helmet dispose:)
					(ClearFlag 312)
				else
					(helmet init: global117)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance helmet_45 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 236 157 266 106 311 99 348 125 354 187 293 204 262 201 242 192 239 159
					yourself:
				)
		)
	)
)

(instance helmet of View
	(properties
		x 218
		y 236
		view 4059
		loop 1
	)
)

