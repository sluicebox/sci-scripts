;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4117)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk2MusNECU3 0
)

(local
	local0
)

(instance bk2MusNECU3 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4162)
		(= local0 0)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit31Butn init: global117)
		(GAME_45 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sStopThing)
		else
			(proc1111_6)
			(super pitch: param1 &rest)
		)
	)
)

(instance sStopThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theMirmGame stop: self 1)
			)
			(1
				(ClearFlag 312)
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(proc1111_6)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance sPlayGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMirmGame init: 0 1 play: self)
			)
			(1
				(ClearFlag 312)
				(= seconds 2)
			)
			(2
				(= local0 (mod (++ local0) 3))
				(proc1111_6)
				(self dispose:)
			)
		)
	)
)

(instance exhibit31Butn of ExhibitButton
	(properties
		x 287
		y 231
		view 4157
	)

	(method (init)
		(if (IsFlag 312)
			(gCurRoom setScript: sPlayGame)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(theMirmGame stop: 0 1)
					(ClearFlag 312)
				else
					(SetFlag 312)
					(gCurRoom setScript: sPlayGame)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theMirmGame of RobotPlayer
	(properties)

	(method (init)
		(switch local0
			(0
				(self robot: 4157 maxFrame: 37 robotX: 254 robotY: 33)
			)
			(1
				(self robot: 4158 maxFrame: 37 robotX: 255 robotY: 34)
			)
			(2
				(self robot: 4159 maxFrame: 37 robotX: 260 robotY: 29)
			)
		)
		(super init: &rest)
	)
)

(instance GAME_45 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 270 128 296 93 322 132 324 175 309 181 283 183 268 176 271 131
					yourself:
				)
		)
	)
)

