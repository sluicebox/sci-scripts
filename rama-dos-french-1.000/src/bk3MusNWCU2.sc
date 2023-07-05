;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4229)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk3MusNWCU2 0
)

(instance bk3MusNWCU2 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4247)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit14aButn init: global117)
		(exhibit14bButn init: global117)
		(OCTO_315 init:)
	)

	(method (pitch param1)
		(proc1111_6)
		(ClearFlag 313)
		(ClearFlag 314)
		(super pitch: param1 &rest)
	)
)

(instance sStopOcto of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 313)
					(octo1 stop: self)
					(ClearFlag 313)
				else
					(octo2 stop: self)
					(ClearFlag 314)
				)
			)
			(1
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

(instance exhibit14aButn of ExhibitButton
	(properties
		x 260
		y 215
		view 4258
	)

	(method (init)
		(if (IsFlag 313)
			(octo1 init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((IsFlag 313)
						(octo1 stop: 0 1)
						(ClearFlag 313)
					)
					((IsFlag 314)
						(octo2 stop: 0 1)
						(ClearFlag 314)
						(octo1 init: 1 play:)
						(SetFlag 313)
					)
					(else
						(octo1 init: 1 play:)
						(SetFlag 313)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exhibit14bButn of ExhibitButton
	(properties
		x 297
		y 215
		loop 1
		view 4258
	)

	(method (init)
		(if (IsFlag 314)
			(octo2 init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((IsFlag 314)
						(octo2 stop: 0 1)
						(ClearFlag 314)
					)
					((IsFlag 313)
						(octo1 stop: 0 1)
						(ClearFlag 313)
						(octo2 init: 1 play:)
						(SetFlag 314)
					)
					(else
						(octo2 init: 1 play:)
						(SetFlag 314)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octo2 of RobotPlayer
	(properties
		robot 4265
		robotX 269
		robotY 114
	)
)

(instance octo1 of RobotPlayer
	(properties
		robot 4264
		robotX 267
		robotY 120
	)
)

(instance OCTO_315 of Feature
	(properties
		noun 45
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 194 256 181 277 125 298 114 320 127 331 160 347 183 404 186 411 203 345 197 309 204 282 200 204 205 178 195
					yourself:
				)
		)
	)
)

