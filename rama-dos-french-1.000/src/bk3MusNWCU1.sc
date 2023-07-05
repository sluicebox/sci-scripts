;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4228)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk3MusNWCU1 0
)

(instance bk3MusNWCU1 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4246)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit13Butn init: global117)
		(REPLEAT_315 init:)
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
				(octoWalrus stop: self)
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

(instance exhibit13Butn of ExhibitButton
	(properties
		x 260
		y 287
		view 4257
	)

	(method (init)
		(if (IsFlag 312)
			(octoWalrus init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(octoWalrus stop: 0 1)
					(ClearFlag 312)
				else
					(octoWalrus init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoWalrus of RobotPlayer
	(properties
		robot 4263
		robotX 246
		robotY 30
	)
)

(instance REPLEAT_315 of Feature
	(properties
		noun 44
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 142 260 73 262 42 292 25 326 42 327 69 408 151 379 200 321 220 258 221 202 192 185 146
					yourself:
				)
		)
	)
)

