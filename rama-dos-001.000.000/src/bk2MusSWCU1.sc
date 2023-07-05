;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4124)
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
	bk2MusSWCU1 0
)

(instance bk2MusSWCU1 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4140)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit19Butn init: global117)
		(HELMET_225 init:)
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

(instance exhibit19Butn of ExhibitButton
	(properties
		x 268
		y 275
		view 4159
	)

	(method (init)
		(if (IsFlag 312)
			(helmet init: global117)
		)
		(super init: &rest)
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

(instance helmet of View
	(properties
		x 226
		y 221
		loop 1
		view 4159
	)
)

(instance HELMET_225 of Feature
	(properties
		noun 37
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 242 107 293 77 356 141 353 211 231 209 228 107 265 95
					yourself:
				)
		)
	)
)

