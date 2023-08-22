;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use n104)
(use n105)
(use n106)
(use TargActor)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm93 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12 = 5
	local13
	local14
	local15
	local16
	local17
)

(procedure (localproc_0 &tmp temp0)
	(return
		(or
			(< (= temp0 (gEgo distanceTo: minotaur)) 30)
			(not
				(or
					local10
					local11
					local13
					(gEgo inRect: 0 119 70 145)
					(gEgo inRect: 238 0 330 106)
					(gEgo inRect: 245 66 319 110)
					(and (== gEgoGait 2) (>= [gEgoStats 8] 50) (> temp0 60)) ; sneaking, stealth
					(> temp0 120)
					(== (minotaur script:) minotaurLooks)
					(IsFlag 237)
				)
			)
		)
	)
)

(procedure (localproc_1)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: 0)
	)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 0 131 64 131 64 149 35 165 35 175 3 175 3 187 179 187 179 189 0 189
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 131 154 131 167 69 167 69 154
				yourself:
			)
	)
)

(instance rm93 of Rm
	(properties
		noun 13
		picture 93
		style 8
		horizon 88
	)

	(method (dispose)
		(= global451 0)
		(gLongSong stop:)
		(DisposeScript 964)
		(super dispose: &rest)
	)

	(method (init)
		(NormalEgo)
		(HandsOff)
		(localproc_1)
		(if (IsFlag 238)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 163 299 163 277 126 219 114 219 107 278 107 278 103 180 103 167 48 154 103 77 103 77 116 63 126 0 126
						yourself:
					)
			)
			(= local6 1)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 163 303 163 276 127 221 117 221 107 256 107 256 103 80 103 80 114 63 126 0 126
						yourself:
					)
			)
		)
		(LoadMany rsVIEW 93 550 5 523 510 538 426 524 538)
		(Load rsSOUND 23)
		(Load rsSCRIPT 964)
		(gLongSong priority: 1 number: 23 loop: -1 play:)
		(super init:)
		(onDebris init: setOnMeCheck: 1 256)
		(onRock init: setOnMeCheck: 1 4)
		(onRock2 init: setOnMeCheck: 1 2048)
		(ground init: setOnMeCheck: 1 128)
		(eastCliff init: setOnMeCheck: 1 16)
		(westCliff init: setOnMeCheck: 1 8)
		(leftFort init: setOnMeCheck: 1 32)
		(rightFort init: setOnMeCheck: 1 64)
		(aFunnyBush init: setOnMeCheck: 1 512)
		(gateSign setPri: 5 init: addToPic:)
		(bell setPri: 6 init: stopUpd:)
		(bush init: stopUpd:)
		(if (IsFlag 238)
			(gate
				init:
				setCel: 3
				setPri: 6
				approachVerbs: 4 17 18 ; Do, lockPick, thiefKit
				ignoreActors:
				stopUpd:
			)
		else
			(gate init: setCel: 0 setPri: 6 approachVerbs: 4 stopUpd:) ; Do
		)
		(if (not (IsFlag 237))
			(= global279 480)
			(= global280 186)
			(Load rsVIEW 425)
		)
		(= local13 1)
		(switch gPrevRoomNum
			(89
				(= local5 1)
				(if (not (IsFlag 237))
					(= local8 1)
					(= local7 0)
					(minotaur init: setScript: patrol)
				)
				(self setScript: sEnterFromWest)
			)
			(94
				(if (not (IsFlag 237))
					(= local8 0)
					(= local7 1)
					(minotaur setLoop: 1 init: setScript: patrol)
				)
				(if (IsFlag 238)
					(gEgo posn: 170 98 init: setScript: egoEntersFromNorth)
				else
					(gCurRoom setScript: sClimbDown)
				)
			)
			(480 ; minotaurArena
				(Load rsVIEW 519)
				(Load rsVIEW 426)
				(SetFlag 237)
				(minotaur
					init:
					view: 426
					setLoop: 0
					setCel: 0
					setPri: 8
					posn: 230 145
					approachX: 225
					approachY: 144
					approachVerbs: 4 ; Do
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 265 128 265 141 253 141 253 149 191 149 191 115 207 115 220 118
							yourself:
						)
				)
				(gEgo posn: 230 158 init: setScript: egoEntersFromCombat)
			)
			(else
				(if (not (IsFlag 237))
					(= local8 0)
					(= local7 1)
					(minotaur init: setScript: patrol)
				)
				(self setScript: sEnterFromSouth)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(SetFlag 83)
		(if (== newRoomNumber 480) ; minotaurArena
			(= global279 newRoomNumber)
		else
			(= global279 (= global280 0))
		)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(if (not (IsFlag 83))
			(gMessager say: 13 0 18) ; "Grumble Grumble Grumble. Stupid guard duty, third time this week. Why always me? Grumble Grumble Grumble."
		)
		(if (IsFlag 273)
			(EgoDead 56 57) ; "The brigands were waiting for you to come back. They expected you to make another try for some of their treasure."
		)
	)

	(method (doit)
		(cond
			(script)
			(
				(and
					(not (== (minotaur script:) minotaurLooks))
					(gEgo mover:)
					(not (bush cycler:))
					(& (gEgo onControl: 1) $0002)
				)
				(bush setCycle: End bush)
			)
			((or (== (gEgo edgeHit:) EDGE_BOTTOM) (== (gEgo edgeHit:) EDGE_RIGHT))
				(HandsOff)
				(gCurRoom setScript: sExitSouth)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(if
					(or
						(== (minotaur script:) intoCombat)
						(== (minotaur script:) lookCombat)
						(== (minotaur script:) minotaurLooks)
						(== (gCurRoom script:) dartAtMinotaur)
					)
					(gEgo setMotion: 0)
					(gCurRoom setScript: noEscape)
				else
					(gCurRoom setScript: sExitWest)
				)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: exitNorth)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(16 ; dagger
				(cond
					(
						(or
							(gEgo inRect: 47 141 90 163)
							(gEgo inRect: 0 119 70 145)
							(gEgo inRect: 238 0 330 106)
						)
						(gMessager say: 13 16) ; "You'll have to give yourself room."
					)
					((IsFlag 237)
						(ThrowKnife 0)
					)
					(else
						(if (< (gEgo x:) 160)
							(minotaur targDeltaX: -25)
						else
							(minotaur targDeltaX: 25)
						)
						(ThrowKnife minotaur)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 237)
					(gMessager say: 13 1 0 1) ; "Sheer cliff walls form a narrow box canyon where the brigands have built a fortress. There is a pile of debris where the steep cliff walls meet the fortress."
				else
					(gMessager say: 13 1 0 0) ; "Sheer cliff walls form a narrow box canyon where the brigands have built a fortress. There is a pile of debris where the steep cliff walls meet the fortress."
				)
			)
			(51 ; openSpell
				(cond
					((or local6 (IsFlag 238))
						(gMessager say: 13 51) ; "You waste a spell."
					)
					((== (minotaur script:) patrol)
						(minotaur setScript: intoCombat)
					)
					(else
						(gate setScript: openMess)
					)
				)
			)
			(50 ; detectMagicSpell
				(gMessager say: 13 50) ; "There is no magical aura present."
			)
			(78 ; dazzleSpell
				(cond
					((or (IsFlag 237) local10 local13 local11)
						(gMessager say: 13 78) ; "You waste a spell."
					)
					((CastDazzle gEgo minotaurDazzled)
						(minotaur setScript: minotaurDazzled)
					)
				)
			)
			(81 ; flameDartSpell
				(cond
					(
						(or
							(gEgo inRect: 47 141 90 163)
							(gEgo inRect: 0 119 70 145)
							(gEgo inRect: 238 0 330 106)
						)
						(gMessager say: 13 81) ; "You'll have to give yourself room."
					)
					((IsFlag 237)
						(CastDart 0)
					)
					(else
						(gCurRoom setScript: dartAtMinotaur)
					)
				)
			)
			(80 ; calmSpell
				(cond
					(
						(or
							(IsFlag 237)
							local10
							(== (minotaur script:) minotaurDazzled)
						)
						(gMessager say: 13 80) ; "You waste a spell."
					)
					((and (not local15) (CastCalm gEgo))
						(minotaur setScript: minotaurCalmed)
					)
					(else
						(minotaur setScript: minotaurLooks)
					)
				)
			)
			(52 ; Sleep
				(if (not (IsFlag 237))
					(minotaur setScript: intoCombat)
				else
					(EgoDead 122 123) ; "While you were asleep, something decided to make a meal of you. You're not sure what it was, but you don't really care at this point. You shouldn't go to sleep where the creatures of the night can get you."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance egoActions of Actions ; UNUSED
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 13 1 32) ; "To the Minotaur, you look like a nice meal."
		else
			(return 0)
		)
	)
)

(instance onDebris of Feature
	(properties
		x 289
		y 60
		noun 6
	)
)

(instance onRock of Feature
	(properties
		x 90
		y 172
		noun 10
	)
)

(instance onRock2 of Feature
	(properties
		x 90
		y 172
		noun 9
	)
)

(instance ground of Feature
	(properties
		x 177
		y 140
		noun 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: pickUpARock)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance eastCliff of Feature
	(properties
		x 303
		y 80
		noun 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (TrySkill 11 65) ; climbing
					(gCurRoom setScript: climbOverRocks)
				else
					(gMessager say: 11 1) ; "This seems like a good place to climb, but you aren't skillful enough to manage it."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance westCliff of Feature
	(properties
		x 28
		y 69
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: climbWestCliff)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftFort of Feature
	(properties
		x 86
		y 52
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 1) ; "Brigands's fortress."
			)
			(4 ; Do
				(= local16 100)
				(if (TrySkill 11 90) ; climbing
					(gCurRoom setScript: sClimbOverWall)
				else
					(gCurRoom setScript: climbFails)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rightFort of Feature
	(properties
		x 224
		y 56
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 1) ; "Brigands's fortress."
			)
			(4 ; Do
				(= local16 235)
				(if (TrySkill 11 90) ; climbing
					(gCurRoom setScript: sClimbOverWall)
				else
					(gCurRoom setScript: climbFails)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aFunnyBush of Feature
	(properties
		x 224
		y 56
		noun 2
	)

	(method (doVerb theVerb invItem)
		(bush doVerb: theVerb invItem &rest)
	)
)

(instance gate of Prop
	(properties
		x 126
		z -100
		noun 4
		approachX 174
		approachY 105
		view 93
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					(
						(and
							(!= (gEgo x:) approachX)
							(!= (gEgo y:) approachY)
						)
						(gEgo setMotion: PolyPath approachX approachY self)
					)
					((IsFlag 238)
						(gEgo setScript: closeGate)
					)
					(local6
						(gCurRoom setScript: openGate)
					)
					(else
						(switch (++ local4)
							(1
								(gMessager say: 4 4 5) ; "Why knock? Use the bell."
							)
							(2
								(gMessager say: 4 4 6) ; "The gate appears to be fastened somehow on the inside. You'll have to force the gate open."
							)
							(else
								(gCurRoom setScript: forceGate)
							)
						)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 238)
					(gMessager say: 4 1 7) ; "Beyond the open gate, you can see a storage area and some buildings."
				else
					(gMessager say: 4 1) ; "The fortress gate -- a very *strong* gate. It appears to be fastened somehow on the other side."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bell of Prop
	(properties
		x 208
		y 77
		noun 1
		approachX 200
		approachY 116
		_approachVerbs 9
		view 93
		loop 1
		priority 6
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(bell setScript: ringBell)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance gateSign of Prop
	(properties
		x 206
		y 59
		view 93
		loop 2
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (gEgo inRect: 150 92 250 140)
					(gMessager say: 3 1 3) ; "The sign reads "Ring bell"."
				else
					(gMessager say: 3 1 4) ; "Step over and get a close look."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bush of Prop
	(properties
		x 38
		y 157
		noun 2
		view 93
		loop 3
		priority 10
		signal 18448
	)

	(method (cue)
		(super cue:)
		(if
			(and
				(not (IsFlag 237))
				(!= (minotaur script:) minotaurLooks)
				(or (!= gEgoGait 2) (<= [gEgoStats 8] 50)) ; sneaking, stealth
			)
			(if local10
				(minotaur setScript: minotaurRises)
			else
				(minotaur setScript: minotaurLooks)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local5
					(gMessager say: 2 1 2) ; "You see a bush that conceals the secret entrance."
				else
					(gMessager say: 2 1 1) ; "The bush sits next to the cliff. There are marks on the ground near the bush."
				)
			)
		)
	)
)

(instance archer1 of Prop
	(properties
		x 280
		y 38
		view 93
		loop 4
		priority 4
		signal 18448
		cycleSpeed 8
	)
)

(instance archer2 of Prop
	(properties
		x 242
		y 39
		view 93
		loop 4
		priority 4
		signal 18448
		cycleSpeed 8
	)
)

(instance archer3 of Prop
	(properties
		x 86
		y 38
		view 93
		loop 5
		priority 4
		signal 18448
		cycleSpeed 8
	)
)

(instance archer4 of Prop
	(properties
		x 27
		y 39
		view 93
		loop 5
		priority 4
		signal 18448
		cycleSpeed 8
	)
)

(instance minotaur of TargActor
	(properties
		x 150
		y 170
		noun 5
		view 425
		priority 13
		signal 18448
		cycleSpeed 10
		illegalBits 0
		xStep 4
		targDeltaX 25
		targDeltaY -15
	)

	(method (init)
		(super init:)
	)

	(method (getHurt param1)
		(HandsOff)
		(= local15 1)
		(-= global280 param1)
		(super getHurt: param1)
	)

	(method (doit &tmp temp0)
		(= temp0 (self script:))
		(cond
			(local17)
			((IsFlag 237))
			(local11)
			(local15
				(if local10
					(self setScript: minotaurGotHurt)
				else
					(self setScript: intoCombat)
				)
			)
			((== temp0 minotaurRises))
			((== temp0 minotaurLooks))
			((localproc_0)
				(if local10
					(self setScript: minotaurRises)
				else
					(self setScript: minotaurLooks)
				)
			)
			(
				(or
					(== temp0 patrol)
					(== temp0 minotaurDazzled)
					(== temp0 minotaurCalmed)
					local10
				))
			(else
				(self setScript: patrol)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(cond
					(
						(or
							(gEgo inRect: 47 141 90 163)
							(gEgo inRect: 0 119 70 145)
							(gEgo inRect: 238 0 330 106)
						)
						(gMessager say: 5 81) ; "You'll have to give yourself room."
					)
					((IsFlag 237)
						(CastDart 0)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: dartAtMinotaur)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 237)
					(gMessager say: 5 1 14) ; "If you've seen one, you've seen them all."
				else
					(gMessager say: 5 1 15) ; "Good ears, but very poor peripheral vision."
				)
			)
			(4 ; Do
				(cond
					(local10
						(gMessager say: 5 4 13 0) ; "As you attempt the search, the sleeping Minotaur awakes, and..."
						(self setScript: minotaurRises)
					)
					((IsFlag 237)
						(if local14
							(gMessager say: 5 4 11) ; "You've got all the loot you're going to find."
						else
							(self setScript: searchMinotaur)
						)
					)
					(else
						(gMessager say: 5 4 7) ; "That's not a good idea."
					)
				)
			)
			(16 ; dagger
				(if (IsFlag 237)
					(gMessager say: 5 16 9) ; "Why bother? He's out for the count."
				else
					(gMessager say: 5 16 8 0 self) ; "OK. Here's your chance."
					(if local10
						(self setScript: minotaurGotHurt)
					else
						(self setScript: intoCombat)
					)
				)
			)
			(12 ; sword
				(if (IsFlag 237)
					(gMessager say: 5 12 9) ; "Why bother? He's out for the count."
				else
					(gMessager say: 5 16 8 0 self) ; "OK. Here's your chance."
					(if local10
						(self setScript: minotaurGotHurt)
					else
						(self setScript: intoCombat)
					)
				)
			)
			(20 ; rock
				(ThrowRock minotaur)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance searchMinotaur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(= local14 1)
				(if
					(and
						(== gCurRoomNum global252)
						(or global250 global251 [global340 6])
					)
					(gMessager say: 5 4 10 0 self) ; "You retrieve your daggers."
				else
					(self cue:)
				)
			)
			(1
				1
				(if
					(and
						(== gCurRoomNum global252)
						(or global250 global251 [global340 6])
					)
					(gEgo get: 6 (+ global250 global251 [global340 6])) ; dagger
					(= [global340 6]
						(= global251 (= global250 (= global252 0)))
					)
				)
				(self cue:)
			)
			(2
				2
				(gMessager say: 5 4 12 0 self) ; "You quickly search the fallen Minotaur and find nothing."
			)
			(3
				3
				(gEgo get: 0 50) ; silver
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pickUpARock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(self cue:)
			)
			(1
				1
				(cond
					((and (< 138 (gEgo x:) 217) (< 103 (gEgo y:) 173))
						(self cue:)
					)
					((< (gEgo x:) 160)
						(gEgo setMotion: PolyPath 73 130 self)
					)
					(else
						(gEgo setMotion: PolyPath 170 130 self)
					)
				)
			)
			(2
				2
				(gEgo get: 10 10) ; rock
				(if (OneOf (gEgo loop:) 0 2 3 4 6)
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(gEgo view: 510 setCel: 0 setCycle: End self)
			)
			(3
				3
				(gEgo setCycle: Beg self)
			)
			(4
				4
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(localproc_1)
				(gate ignoreActors: cycleSpeed: 8 setPri: 4 setCycle: End self)
			)
			(1
				1
				(if (== gPrevRoomNum 480) ; minotaurArena
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 163 299 163 277 126 219 114 219 107 278 107 278 103 180 103 167 48 154 103 77 103 77 116 63 126 0 126
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 265 128 265 141 253 141 253 149 191 149 191 115 207 115 220 118
								yourself:
							)
					)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 163 299 163 277 126 219 114 219 107 278 107 278 103 180 103 167 48 154 103 77 103 77 116 63 126 0 126
								yourself:
							)
					)
				)
				(gate stopUpd:)
				(SetFlag 238)
				(= local6 1)
				(self dispose:)
			)
		)
	)
)

(instance closeGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_1)
				(gate
					ignoreActors: 1
					setCel: 3
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(1
				(if (== gPrevRoomNum 480) ; minotaurArena
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 163 303 163 276 127 221 117 221 107 256 107 256 103 80 103 80 114 63 126 0 126
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 265 128 265 141 253 141 253 149 191 149 191 115 207 115 220 118
								yourself:
							)
					)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 163 303 163 276 127 221 117 221 107 256 107 256 103 80 103 80 114 63 126 0 126
								yourself:
							)
					)
				)
				(ClearFlag 238)
				(gate stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openMess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(= local13 1)
				(= local6 1)
				(= cycles 1)
			)
			(2
				(CastOpen gEgo self)
			)
			(3
				(gMessager say: 13 0 29 0 self) ; "You hear a snick as the hasp on the gate is opened."
			)
			(4
				(lockSound dispose:)
				(= local13 0)
				(NormalEgo)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance minotaurCalmed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(= local13 1)
				(cond
					((> (minotaur x:) 118)
						(minotaur
							view: 425
							setLoop: 1
							moveSpeed: 6
							cycleSpeed: 6
							setStep: 6 2
							setCycle: Fwd
							setMotion: MoveTo 112 (minotaur y:) self
						)
					)
					((< (minotaur x:) 106)
						(minotaur
							view: 425
							setLoop: 0
							moveSpeed: 6
							cycleSpeed: 6
							setStep: 6 2
							setCycle: Fwd
							setMotion: MoveTo 112 (minotaur y:) self
						)
					)
					(else
						(minotaur
							posn: 112 (minotaur y:)
							setMotion: 0
							setCycle: 0
						)
						(self cue:)
					)
				)
			)
			(2
				(minotaur view: 426 setLoop: 1 setCel: 0)
				(= ticks 30)
			)
			(3
				(minotaur cycleSpeed: 15 setCycle: End self)
			)
			(4
				(minotaur setLoop: 2 cel: 0 cycleSpeed: 15 setCycle: End self)
			)
			(5
				(= local10 1)
				(= local13 0)
				(minotaur stopUpd:)
				(= cycles 1)
			)
			(6
				(= ticks 180)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance minotaurRises of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local10 0)
				(minotaur view: 426 setLoop: 1 setCel: 9)
				(= ticks 30)
			)
			(1
				(minotaur cycleSpeed: 9 setCycle: CT 2 -1)
				(= ticks 60)
			)
			(2
				(client setScript: minotaurLooks)
			)
		)
	)
)

(instance minotaurGotHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local17 1)
				(HandsOff)
				(= local10 0)
				(minotaur view: 426 setLoop: 1 setCel: 9)
				(= ticks 30)
			)
			(1
				(minotaur cycleSpeed: 9 setCycle: CT 2 -1)
				(= ticks 60)
			)
			(2
				(client setScript: intoCombat)
			)
		)
	)
)

(instance noEscape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 0 28 0 self) ; "Before you can escape, the Minotaur is upon you!"
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance dartAtMinotaur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local17 1)
				(HandsOff)
				(gEgo setMotion: 0 setScript: 0)
				(cond
					(local10
						(minotaur targDeltaX: 0)
					)
					((< (gEgo x:) 160)
						(minotaur targDeltaX: -25)
					)
					(else
						(minotaur targDeltaX: 25)
					)
				)
				(CastDart minotaur self)
			)
			(1
				(HandsOff)
				(if (< (gEgo x:) 160)
					(minotaur targDeltaX: -25)
				else
					(minotaur targDeltaX: 25)
				)
				(minotaur setScript: intoCombat)
			)
		)
	)
)

(instance intoCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local17 1)
				(HandsOff)
				(NormalEgo)
				(gEgo setMotion: 0 setScript: 0)
				(if (== (gCurRoom script:) forceGate)
					(gEgo cycleSpeed: local2 moveSpeed: local2)
				)
				(gCurRoom setScript: 0)
				(Face gEgo minotaur)
				(minotaur
					view: 425
					setLoop: 2
					setCel: 0
					setMotion: 0
					cycleSpeed: 8
					setStep: 4 2
					setCycle: End self
				)
			)
			(1
				(= local7 2)
				(if (< (gEgo x:) (minotaur x:))
					(minotaur setCycle: Beg self)
				else
					(= ticks 25)
				)
			)
			(2
				(if (< (gEgo y:) (minotaur y:))
					(minotaur setLoop: 3 setCel: 2)
					(= local7 3)
				)
				(= ticks 25)
			)
			(3
				(HandsOff)
				(= ticks 120)
			)
			(4
				(if (IsObject global426)
					(-- state)
					(= ticks 5)
					(global426 dispose:)
				else
					(gCurRoom newRoom: 480) ; minotaurArena
				)
			)
		)
	)
)

(instance lookCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local17 1)
				(HandsOff)
				(NormalEgo)
				(gEgo setMotion: 0 setScript: 0)
				(if (== (gCurRoom script:) forceGate)
					(gEgo cycleSpeed: local2 moveSpeed: local2)
				)
				(gCurRoom setScript: 0)
				(Face gEgo minotaur)
				(if (< (gEgo y:) (minotaur y:))
					(minotaur setLoop: 3 setCel: 2)
					(= local7 3)
				)
				(= ticks 25)
			)
			(1
				(HandsOff)
				(self setScript: noEscape self)
			)
			(2
				(if (IsObject global426)
					(-- state)
					(= ticks 5)
					(global426 dispose:)
				else
					(gCurRoom newRoom: 480) ; minotaurArena
				)
			)
		)
	)
)

(instance minotaurDazzled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 1)
				(if local10
					(minotaur setLoop: 1 setCel: 9 setCycle: CT 2 -1)
				)
			)
			(1
				(minotaur
					view: 425
					setCycle: 0
					setMotion: 0
					setLoop: 4
					setCel: 1
				)
				(= seconds 12)
			)
			(2
				(= local11 0)
				(client setScript: patrol)
			)
		)
	)
)

(instance minotaurSleeps of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (minotaur x:) 112)
					(minotaur
						view: 425
						setLoop: 0
						cycleSpeed: 10
						moveSpeed: 6
						setCycle: Walk
						setMotion: MoveTo 112 169 self
					)
				else
					(minotaur
						view: 425
						setLoop: 1
						cycleSpeed: 10
						moveSpeed: 6
						setCycle: Walk
						setMotion: MoveTo 112 169 self
					)
				)
			)
			(1
				(minotaur
					view: 426
					setLoop: 1
					cel: 0
					cycleSpeed: 14
					setCycle: End self
				)
			)
			(2
				(= local10 1)
				(minotaur
					view: 426
					setLoop: 2
					cel: 0
					cycleSpeed: 14
					setCycle: End self
				)
			)
			(3
				(= local13 0)
				(minotaur stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoEntersFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 170 115 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoEntersFromCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
				(minotaur setPri: 8 addToPic:)
			)
			(1
				(gEgo setPri: 11 setMotion: MoveTo 181 158 self)
			)
			(2
				(gEgo view: 519 setLoop: 0 setCycle: End self)
			)
			(3
				(gMessager say: 13 0 21) ; "I'M BAAD!"
				(HandsOn)
				(gEgo posn: 181 155)
				(NormalEgo 2)
				(self dispose:)
			)
		)
	)
)

(instance climbWestCliff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(= register 3)
				(gEgo setPri: 6 setMotion: PolyPath 77 103 self)
			)
			(1
				(gEgo setLoop: 1 setCycle: Fwd setMotion: MoveTo 76 95 self)
			)
			(2
				(gEgo setMotion: MoveTo 85 102 self)
				(if (-- register)
					(= state 0)
				)
			)
			(3
				(gMessager say: 13 0 17) ; "The dirt is too loose for climbing here."
				(NormalEgo)
				(HandsOn)
				(= local13 0)
				(self dispose:)
			)
		)
	)
)

(instance ringBell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(bell setCycle: Fwd)
				(gMessager say: 13 0 30) ; ""DING DING DING DING...." Well, maybe the brigands aren't such inhospitable creatures after all."
				(= seconds 5)
			)
			(1
				(bell setCel: 0)
				(archer1 init: setCycle: End)
				(archer2 init: setCycle: End)
				(archer3 init: setCycle: End)
				(archer4 init: setCycle: End)
				(gMessager say: 13 0 31) ; "Then again, maybe they are."
				(= seconds 4)
			)
			(2
				(EgoDead 15 16) ; "The brigands have an even temperament... all bad! You seem to have a knack for doing the wrong thing."
			)
		)
	)
)

(instance lockSound of Sound
	(properties
		number 2035
		priority 3
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(gEgo init: posn: 320 250 setMotion: MoveTo 252 182 self)
			)
			(1
				(HandsOn)
				(rm93 cue:)
				(= ticks 250)
			)
			(2
				(= local13 0)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(= ticks 90)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: 91)
			)
		)
	)
)

(instance patrol of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(minotaur moveSpeed: 6 cycleSpeed: 6 setCycle: 0 setStep: 6 2)
				(if local10
					(self changeState: 5)
				else
					(= local13 0)
					(switch local7
						(0
							(self changeState: 10)
						)
						(1
							(self changeState: 14)
						)
						(2
							(if local8
								(self changeState: 17)
							else
								(self changeState: 13)
							)
						)
						(3
							(if local8
								(self changeState: 3)
							else
								(self changeState: 1)
							)
						)
					)
				)
			)
			(1
				(= local8 0)
				(= local7 1)
				(minotaur view: 425 setLoop: 3 setCel: 0)
				(= ticks 5)
			)
			(2
				(self changeState: 14)
			)
			(3
				(= local8 1)
				(= local7 0)
				(minotaur view: 425 setLoop: 3 setCel: 1)
				(= ticks 5)
			)
			(4
				(self changeState: 10)
			)
			(5
				(minotaur cycleSpeed: 12 setCycle: Beg self)
			)
			(6
				(= local10 0)
				(= local7 2)
				(self changeState: 0)
			)
			(10
				(= local8 1)
				(= local7 0)
				(minotaur
					view: 425
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 286 (minotaur y:) self
				)
			)
			(11
				(= local8 0)
				(minotaur setLoop: 2 setCel: 3)
				(= ticks 5)
			)
			(12
				(minotaur setLoop: 2 setCel: 2)
				(= ticks 5)
			)
			(13
				(= local7 1)
				(minotaur view: 425 setLoop: 2 setCel: 1)
				(= ticks 5)
			)
			(14
				(= local8 0)
				(= local7 1)
				(minotaur
					view: 425
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 25 (minotaur y:) self
				)
			)
			(15
				(= local8 1)
				(minotaur setLoop: 2 setCel: 1)
				(= ticks 5)
			)
			(16
				(minotaur setLoop: 2 setCel: 2)
				(= ticks 5)
			)
			(17
				(= local7 0)
				(minotaur view: 425 setLoop: 2 setCel: 3)
				(= ticks 5)
			)
			(18
				(self changeState: 10)
			)
		)
	)
)

(instance minotaurLooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(not
						(or
							(gEgo inRect: 0 119 70 145)
							(gEgo inRect: 238 0 330 106)
							(gEgo inRect: 245 66 319 110)
						)
					)
					(HandsOff)
					(NormalEgo)
					(gEgo setMotion: 0 setScript: 0)
					(if (== (gCurRoom script:) forceGate)
						(gEgo cycleSpeed: local2 moveSpeed: local2)
					)
					(gCurRoom setScript: 0)
					(Face gEgo minotaur)
				)
				(minotaur
					view: 425
					setLoop: 2
					setCel: 0
					setMotion: 0
					cycleSpeed: 8
					setStep: 4 2
					setCycle: End self
				)
			)
			(1
				(= local7 2)
				(if (< (gEgo x:) (minotaur x:))
					(minotaur setCycle: Beg self)
				else
					(= ticks 25)
				)
			)
			(2
				(if (< (gEgo y:) (minotaur y:))
					(minotaur setLoop: 3 setCel: 2)
					(= local7 3)
				)
				(= ticks 25)
			)
			(3
				(if
					(or
						(gEgo inRect: 0 119 70 145)
						(gEgo inRect: 238 0 330 106)
						(gEgo inRect: 245 66 319 110)
					)
					(switch local3
						(1
							(gMessager say: 13 0 22) ; "I've been out here too long. My imagination is taking over."
						)
						(2
							(gMessager say: 13 0 23) ; "What was that noise?"
						)
						(3
							(gMessager say: 13 0 24) ; "Must be those Brigands playing games."
						)
						(4
							(gMessager say: 13 0 25) ; "I guess I'm just getting jumpy."
						)
						(5
							(gMessager say: 13 0 26) ; "Is anyone there?"
						)
						(6
							(gMessager say: 13 0 27) ; "This place is spooky."
						)
					)
					(if (== local3 6)
						(= local3 1)
					else
						(++ local3)
					)
					(HandsOn)
					(client setScript: patrol)
				else
					(= ticks 90)
				)
			)
			(4
				(client setScript: lookCombat)
			)
		)
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(gEgo
					init:
					posn: -10 129
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 28 129 self
				)
			)
			(1
				(rm93 cue:)
				(= ticks 30)
			)
			(2
				(if (and (not (== gEgoGait 2)) (< [gEgoStats 8] 50)) ; sneaking, stealth
					(bush setCycle: End bush)
				)
				(= local13 0)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -35 129 self)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
			)
			(1
				(if (bush cycler:)
					(bush setCycle: 0)
				)
				(if (minotaur mover:)
					(minotaur setMotion: 0 setCycle: 0)
				)
				(if (minotaur script:)
					(minotaur setScript: 0)
				)
				(if (gEgo script:)
					(gEgo setScript: 0)
				)
				(= ticks 90)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: 89)
			)
		)
	)
)

(instance exitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 170 80 self)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
			)
			(1
				(if (minotaur mover:)
					(minotaur setMotion: 0 setCycle: 0)
				)
				(if (minotaur script:)
					(minotaur setScript: 0)
				)
				(if (gEgo script:)
					(gEgo setScript: 0)
				)
				(= ticks 90)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: 94)
			)
		)
	)
)

(instance forceGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(EgoGait 0 0) ; walking
				(gEgo setMotion: MoveTo 157 142 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 13 0 19) ; ""Well, I'll huff, and I'll puff, and I'll smash the gate down," you decide."
				(if (not (IsFlag 237))
					(= seconds 3)
				else
					(= ticks 20)
				)
			)
			(3
				(= local2 (gEgo cycleSpeed:))
				(= local1 (gEgo moveSpeed:))
				(gEgo
					view: 550
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= ticks 120)
			)
			(4
				(gEgo view: 0 setLoop: -1 setHeading: 360 self)
			)
			(5
				(= ticks 20)
			)
			(6
				(gEgo
					view: 5
					setLoop: 3
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 157 109 self
				)
			)
			(7
				(gEgo
					view: 523
					setPri: 8
					setLoop: 0
					setCel: 0
					posn: 156 94
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(8
				(ShakeScreen 1 ssLEFTRIGHT)
				(gEgo moveSpeed: 6 setMotion: MoveTo 156 104 self)
			)
			(9
				(if local10
					(minotaur setScript: minotaurRises)
				)
				(= ticks 20)
			)
			(10
				(gEgo view: 538 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(11
				(= ticks 20)
			)
			(12
				(gEgo view: 538 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13
				(NormalEgo)
				(gEgo setHeading: 180 moveSpeed: local2 cycleSpeed: local1)
				(= ticks 20)
			)
			(14
				(gMessager say: 13 0 20) ; "Boy, that felt good."
				(if local10
					(minotaur setScript: minotaurRises)
				)
				(if (TrySkill 0 60) ; strength
					(self setScript: openGate self)
				else
					(= cycles 2)
				)
			)
			(15
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sClimbOverWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(gEgo
					setMotion: PolyPath local16 103 self
					signal: (| (gEgo signal:) $2000)
				)
			)
			(1
				1
				(gEgo
					view: 517
					posn: local16 71
					setLoop: 0
					cel: 0
					setPri: 15
					setCycle: Fwd
					setMotion: DPath local16 71 local16 41 self
				)
			)
			(2
				(= global279 (= global280 0))
				(gCurRoom newRoom: 94)
			)
		)
	)
)

(instance climbFails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(gEgo
					setMotion: PolyPath local16 103 self
					signal: (| (gEgo signal:) $2000)
				)
			)
			(1
				1
				(gEgo
					view: 517
					posn: local16 71
					setLoop: 0
					cel: 0
					setPri: 6
					setCycle: Fwd
					setMotion: DPath local16 71 local16 51 self
				)
			)
			(2
				2
				(gEgo setCycle: 0 setMotion: 0)
				(= ticks 30)
			)
			(3
				3
				(gEgo setLoop: 0 setCel: 0 setMotion: MoveTo local16 71 self)
			)
			(4
				(gEgo posn: local16 103)
				(NormalEgo 3)
				(gMessager say: 12 4 0 1 self) ; "You're going to have to get a lot better at climbing to get into the fortress."
			)
			(5
				(HandsOn)
			)
		)
	)
)

(instance climbOverRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 (gEgo cycleSpeed:))
				(= local1 (gEgo moveSpeed:))
				(gEgo setMotion: PolyPath 277 126 self)
			)
			(1
				(gEgo setPri: 9 posn: 278 124)
				(= ticks 5)
			)
			(2
				(gMessager say: 13 0 16) ; "You find a good purchase on the rocks to climb."
				(gEgo view: 517 setLoop: 1 setCel: 3 posn: 279 120)
				(= ticks 10)
			)
			(3
				(gEgo setCel: 4 posn: 286 105)
				(= ticks 10)
			)
			(4
				(gEgo setCel: 5 posn: 291 89)
				(= ticks 10)
			)
			(5
				(gEgo setCel: 2 posn: 303 63)
				(= ticks 10)
			)
			(6
				(gEgo
					setCel: 0
					posn: 298 54
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(7
				(= global279 (= global280 0))
				(gEgo cycleSpeed: local2 moveSpeed: local1)
				(HandsOn)
				(gCurRoom newRoom: 94)
			)
		)
	)
)

(instance sClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 (gEgo cycleSpeed:))
				(= local1 (gEgo moveSpeed:))
				(gEgo
					init:
					view: 517
					setLoop: 1
					setCel: 255
					posn: 298 54
					cycleSpeed: 12
					setPri: 8
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(= ticks 15)
			)
			(3
				(gEgo setCel: 2 posn: 303 63)
				(= ticks 15)
			)
			(4
				(gEgo setCel: 5 posn: 291 89)
				(= ticks 15)
			)
			(5
				(gEgo setCel: 4 posn: 286 105)
				(= ticks 15)
			)
			(6
				(gEgo setCel: 3 posn: 279 120)
				(= ticks 15)
			)
			(7
				(NormalEgo)
				(HandsOn)
				(gEgo
					posn: 277 126
					setPri: -1
					cycleSpeed: local2
					moveSpeed: local1
				)
				(self dispose:)
			)
		)
	)
)

