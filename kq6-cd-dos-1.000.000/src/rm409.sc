;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 409)
(include sci.sh)
(use Main)
(use rLab)
(use n404)
(use KQ6Room)
(use n913)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm409 0
)

(local
	local0
	local1
)

(instance rm409 of KQ6Room
	(properties
		modNum 400
		noun 2
		picture 400
		style 10
		horizon 135
		south 400
		walkOffEdge 1
		autoLoad 0
	)

	(method (init)
		(if (rLab hiddenDoorOpen:)
			(= local0 54)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 232 144 83 144 26 185 130 185 130 189 0 189 0 0 319 4 319 171 238 171 242 154
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 192 189 192 184 319 184
						yourself:
					)
			)
		else
			(if (rLab seenSecretLatch:)
				(= local0 53)
			else
				(= local0 55)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 0 319 0 319 189 190 189 190 185 266 185 237 161 235 143 86 143 39 185 130 185 130 189
						yourself:
					)
			)
		)
		(super init: &rest)
		(if (== ((ScriptID 30 0) holeCoords:) gCurRoomNum) ; rLab
			(proc404_1)
		)
		((ScriptID 30 0) initCrypt: 1) ; rLab
		(tapestry init:)
		(openDoor init:)
		(door init:)
		(myTorch init:)
		(self setScript: walkIn)
	)

	(method (doit)
		(cond
			((gCurRoom script:))
			((gEgo inRect: 287 167 319 189)
				((ScriptID 30 0) prevEdgeHit: EDGE_RIGHT) ; rLab
				(gCurRoom setScript: walkOut)
			)
			((== (gEgo edgeHit:) 3)
				((ScriptID 30 0) prevEdgeHit: EDGE_BOTTOM) ; rLab
				(gCurRoom setScript: walkOut)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(if (rLab hiddenDoorOpen:)
						(gMessager say: 2 1 54 1 0 400) ; "Alexander is standing in the access room to the minotaur's lair. A tapestry hangs on the east wall. The hidden door to the lair stands open. South leads out into the catacombs' second level."
						1
					else
						(gMessager say: 2 1 53 1 0 400) ; "Alexander is standing in a dead-end room in the catacombs. A tapestry hangs on the east wall, and the only exit lies to the south."
						1
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance tapestry of Prop
	(properties
		x 246
		y 189
		z 100
		noun 18
		modNum 400
		view 400
		loop 5
		priority 5
		signal 26640
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(0
				(if (rLab seenSecretLatch:)
					0
				else
					(gMessager say: 19 0 55 1 0 400) ; "Alexander sees no reason to use that on the bare wall."
				)
			)
			(5 ; Do
				(if (rLab hiddenDoorOpen:)
					(gCurRoom setScript: lookAtTapestry)
				else
					(gCurRoom setScript: liftTapestry)
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
		x 278
		y 189
		z 73
		noun 19
		modNum 400
		approachX 260
		approachY 170
		view 402
		loop 3
		priority 13
		signal 16400
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(if (rLab hiddenDoorOpen:)
			(self cel: 5 stopUpd:)
		else
			(self cel: 0 stopUpd:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; holeInTheWall
				(proc404_0 2)
			)
			(1 ; Look
				(gMessager say: 19 1 local0 1 0 400)
			)
			(5 ; Do
				(gMessager say: 19 5 local0 1 0 400)
			)
			(2 ; Talk
				(cond
					((not (rLab seenSecretLatch:))
						(gMessager say: 19 2 55 1 0 400) ; "Alexander would feel foolish talking to the wall."
					)
					((and (rLab seenSecretLatch:) (not (rLab hiddenDoorOpen:)))
						(gMessager say: 19 2 53 1 0 400) ; "The wall does not respond to Alexander's attempts at communication."
					)
					((and (rLab hiddenDoorOpen:) (not (IsFlag 1)))
						(gMessager say: 19 2 56 1 0 400) ; "Calling through open doorways in the catacombs is probably not a good idea--especially not when that door leads to the minotaur's lair!"
					)
					((IsFlag 1)
						(gMessager say: 19 2 57 1 0 400) ; "The lair is now empty. There's no one here to talk to."
					)
				)
			)
			(else
				(cond
					((not (rLab seenSecretLatch:))
						(gMessager say: 19 0 55 1 0 400) ; "Alexander sees no reason to use that on the bare wall."
					)
					((and (rLab seenSecretLatch:) (not (rLab hiddenDoorOpen:)))
						(gMessager say: 19 0 53 1 0 400) ; "That would have no effect on the wall."
					)
					(else
						(gMessager say: 19 0 54 1 0 400) ; "There is no need to use that on the lair door. It's already open."
					)
				)
			)
		)
	)
)

(instance openDoor of View
	(properties
		x 278
		y 189
		z 73
		noun 19
		modNum 400
		approachX 260
		approachY 170
		view 402
		loop 2
		priority 13
		signal 16400
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(self stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(door doVerb: theVerb &rest)
	)
)

(instance myTorch of View
	(properties
		x 77
		y 141
		z 71
		noun 9
		modNum 400
		view 400
		loop 8
		priority 14
		signal 17
	)

	(method (init)
		(self stopUpd:)
		(super init:)
		(myFlame init:)
		(myFlick init:)
	)
)

(instance myFlame of Prop
	(properties
		x 84
		y 141
		z 95
		noun 9
		modNum 400
		view 400
		loop 2
	)

	(method (init)
		(self setCycle: Fwd checkDetail:)
		(super init:)
	)
)

(instance myFlick of Prop
	(properties
		x 82
		y 50
		modNum 400
		onMeCheck 0
		view 400
		loop 6
		signal 16401
		cycleSpeed 9
	)

	(method (init)
		(self setCycle: RandCycle checkDetail:)
		(super init:)
	)
)

(instance mino of Actor ; UNUSED
	(properties
		x 315
		y 171
		yStep 3
		view 443
		signal 16384
		xStep 5
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
					(4
						(gEgo
							posn: 282 164
							init:
							setMotion: PolyPath 247 164 self
						)
					)
					(1
						(gEgo
							posn: 158 225
							init:
							setMotion: PolyPath 158 187 self
						)
					)
					(else
						(gEgo posn: 160 160 loop: 2 init:)
						(= ticks 6)
					)
				)
			)
			(1
				(= cycles 6)
			)
			(2
				(if (and (== gPrevRoomNum 440) (not (IsFlag 1)))
					(SetFlag 142)
					(gMessager say: 1 0 50 1 self 400) ; "Phew! That was close! Alexander was lucky he wasn't seen."
				else
					(self cue:)
				)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar enable: 6)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
					(3
						(gEgo setMotion: PolyPath (gEgo x:) 250 self)
					)
					(2
						(gEgo setMotion: PolyPath 315 (gEgo y:) self)
					)
				)
			)
			(1
				(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
					(3
						(gCurRoom newRoom: 400) ; LBRoom
					)
					(2
						(gCurRoom newRoom: 440)
					)
				)
			)
		)
	)
)

(instance lookAtTapestry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 235 149 self)
			)
			(1
				(gEgo setHeading: 90)
				(= cycles 6)
			)
			(2
				(gMessager say: 18 5 54 1 self 400) ; "The door to the minotaur's lair is already open, and there's no point in closing it now."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance liftTapestry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 229 146 self)
			)
			(1
				(gEgo setHeading: 90)
				(= cycles 6)
			)
			(2
				(if (rLab seenSecretLatch:)
					(= local1 1)
					(= local0 53)
					(gMessager say: 18 5 53 1 self 400) ; "Hmmm. This tapestry looks familiar...."
				else
					(self cue:)
				)
			)
			(3
				(gEgo
					view: 401
					setLoop: 3
					cel: 0
					normal: 0
					illegalBits: 0
					ignoreActors: 1
					cycleSpeed: 12
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 3)
					setCycle: CT 3 1 self
				)
			)
			(4
				(gEgo cel: 4)
				(tapestry startUpd: cel: 1)
				(= cycles 2)
			)
			(5
				(gEgo cel: 5)
				(tapestry cel: 2)
				(= cycles 2)
			)
			(6
				(if local1
					(gEgo
						setLoop: 4
						cel: 0
						posn: (+ (gEgo x:) 3) (gEgo y:)
						setCycle: CT 5 1 self
					)
				else
					(self cue:)
				)
			)
			(7
				(if local1
					(gEgo cel: 6)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(8
				(if local1
					(gEgo cel: 5)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(9
				(if local1
					(gEgo cel: 4)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(10
				(if local1
					(gEgo cel: 5)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(11
				(if local1
					(gMessager say: 18 5 53 2 self 400) ; "Now let's see...I don't feel anything...."
				else
					(gMessager say: 18 5 55 1 self 400) ; "Alexander does not see anything unusual about or under that tapestry, and the tapestry itself is much too heavy to take."
				)
			)
			(12
				(if local1
					(gEgo cel: 4)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(13
				(if local1
					(gEgo cel: 5)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(14
				(if local1
					(gEgo cel: 4)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(15
				(if local1
					(gGlobalSound4 number: 408 setLoop: 1 play:)
					(gEgo cel: 5)
					(= cycles 6)
				else
					(self cue:)
				)
			)
			(16
				(if local1
					(gMessager say: 18 5 53 3 self 400) ; "AHA! A hidden latch!"
				else
					(self cue:)
				)
			)
			(17
				(if local1
					(gEgo cel: 6)
					(tapestry setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(18
				(if local1
					(gGlobalSound4 number: 909 setLoop: 1 play:)
					(door setCycle: End self)
					(rLab hiddenDoorOpen: 1)
					((gCurRoom obstacles:) dispose:)
					(= local0 54)
				else
					(self cue:)
				)
			)
			(19
				(if local1
					(door dispose:)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 232 144 83 144 26 185 130 185 130 189 0 189 0 0 319 4 319 171 238 171 242 154
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 319 189 192 189 192 184 319 184
								yourself:
							)
					)
					(gMessager say: 18 5 53 4 self 400) ; "Alexander triggers the little latch. A secret door rolls open."
				else
					(self cue:)
				)
			)
			(20
				(if local1
					(gGame givePoints: 1)
					(self cue:)
				else
					(tapestry cel: 1)
					(gEgo setLoop: 3 cel: 5)
					(= cycles 2)
				)
			)
			(21
				(if local1
					(self cue:)
				else
					(tapestry cel: 0)
					(gEgo cel: 4)
					(= cycles 2)
				)
			)
			(22
				(if local1
					(self cue:)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(23
				(gGame handsOn:)
				(tapestry stopUpd:)
				(if local1
					(gEgo
						posn: (- (gEgo x:) 9) (- (gEgo y:) 3)
						reset: 0
					)
				else
					(gEgo
						posn: (- (gEgo x:) 6) (- (gEgo y:) 3)
						reset: 0
					)
				)
				(self dispose:)
			)
		)
	)
)

