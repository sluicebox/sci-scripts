;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4230)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk3MusNWCU3 0
)

(instance bk3MusNWCU3 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4248)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit15Butn init: global117)
		(MORPH_315 init:)
	)

	(method (pitch param1)
		(proc1111_6)
		(ClearFlag 312)
		(super pitch: param1 &rest)
	)
)

(instance sStopOcto of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(octoMorph stop: self)
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

(instance exhibit15Butn of ExhibitButton
	(properties
		x 283
		y 277
		view 4259
	)

	(method (init)
		(if (IsFlag 312)
			(octoMorph init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(octoMorph stop: 0 1)
					(ClearFlag 312)
				else
					(octoMorph init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoMorph of RobotPlayer
	(properties
		robot 4266
		robotX 290
		robotY 204
	)
)

(instance MORPH_315 of Feature
	(properties
		noun 46
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 229 287 222 291 203 313 203 319 226 343 237 309 241 287 241 264 230
					yourself:
				)
		)
	)
)

