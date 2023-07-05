;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Main)
(use rLab)
(use n402)
(use n913)
(use Conversation)
(use Scaler)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm405 0
)

(instance myConv of Conversation
	(properties)
)

(instance rm405 of LabRoom
	(properties
		north 400
		west 400
	)

	(method (init)
		(if (IsFlag 1)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 149 148 102 148 83 142 83 152 74 160 0 160 0 0 149 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 172 148 171 0 319 0 319 189 180 189 180 185 294 185 231 142 211 148
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 64 168 54 176 17 185 140 185 140 189 0 189 0 168
						yourself:
					)
			)
		else
			(proc402_2)
		)
		((ScriptID 30 0) labCoords: 117) ; rLab
		(super init: &rest)
		(if (and (not (IsFlag 1)) (!= gPrevRoomNum 400)) ; LBRoom
			(self setScript: closeEntranceDoor)
		else
			(if (!= gPrevRoomNum 400) ; LBRoom
				((ScriptID 30 0) prevEdgeHit: EDGE_TOP) ; rLab
			)
			(gCurRoom setScript: (ScriptID 30 1)) ; walkIn
		)
		((ScriptID 30 0) initCrypt: 2) ; rLab
		((ScriptID 30 7) addToPic:) ; topDoor
		((ScriptID 30 5) addToPic:) ; leftDoor
		((ScriptID 30 9) addToPic:) ; leftWing
		(door addToPic:)
		(lBlock addToPic:)
		(rBlock addToPic:)
	)

	(method (doit)
		(cond
			((gCurRoom script:))
			((== (gEgo edgeHit:) 3)
				((ScriptID 30 0) prevEdgeHit: EDGE_BOTTOM) ; rLab
				(gCurRoom setScript: walkOut)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 1)
					(gMessager say: 2 1 14 1 0 400) ; "Alexander is standing in the catacombs near the portal to the outside world. The portal stands open."
				else
					(gMessager say: 2 1 15 1 0 400) ; "Alexander is standing in the catacombs near the portal to the outside world. Unfortunately, the portal is locked."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 190
		noun 11
		modNum 400
		sightAngle 45
		approachX 160
		approachY 178
		view 400
		priority 15
		signal 16400
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(if (IsFlag 1)
			(self x: 259)
		else
			(self x: 160)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 1))
					(gMessager say: 11 5 15 1 0 400) ; "The door is locked and Alexander can't force his way out. He'll need to conquer the maze-like catacombs to escape."
				else
					(gMessager say: 11 5 14 1 0 400) ; "Alexander doesn't need to manipulate the open door--he can just walk through it."
				)
			)
			(1 ; Look
				(if (IsFlag 1)
					(gMessager say: 11 1 14 1 0 400) ; "The main door to the catacombs has been left open now that the minotaur is dead."
				else
					(gMessager say: 11 1 15 1 0 400) ; "The main door to the catacombs leads to the outside world. Unfortunately, it's locked."
				)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(else
				(if (IsFlag 1)
					(gMessager say: 11 0 14 1 0 400) ; "There's no reason to use that on the open door."
				else
					(gMessager say: 11 0 15 1 0 400) ; "That would have no effect on the locked door."
				)
			)
		)
	)
)

(instance lBlock of View
	(properties
		x 123
		y 189
		noun 6
		modNum 400
		view 408
		loop 1
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(myConv add: 400 6 1 9 1 add: 400 6 1 9 2 init:) ; "The walls of the catacombs are made of massive stone tiles.", "That's the south wall of the room."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rBlock of View
	(properties
		x 273
		y 189
		noun 6
		modNum 400
		view 408
		loop 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(lBlock doVerb: theVerb)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 250 self)
			)
			(1
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance closeEntranceDoor of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 158 250
					normal: 1
					init:
					reset:
					setScale: Scaler 100 99 190 0
					ignoreHorizon:
					setMotion: MoveTo 160 165 self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gGlobalSound4 number: 434 setLoop: 1 play: self)
			)
			(3
				(if (not (IsFlag 1))
					(gMessager say: 1 0 11 0 self 400) ; "The catacombs' entrance door is locked from the outside by the Winged Ones guards."
				else
					(self cue:)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

