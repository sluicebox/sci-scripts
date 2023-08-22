;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use TargActor)
(use n814)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm45 0
)

(local
	local0
	local1
	local2
	[local3 8]
	[local11 50] = [164 22 164 34 117 34 117 23 0 32 0 0 0 32 83 114 101 140 59 221 69 248 59 300 67 173 71 251 81 239 85 300 99 256 141 300 151 203 153 292 165 64 136 157 143 0 0 0 0 0]
	local61
	local62
	local63
	local64
	[local65 10]
	local75
	[local76 31] = [10 100 150 200 225 400 625 750 850 950 1050 2 2 2 2 2 2 2 2 2 2 0 0 0 0 0 0 0 0 0 0]
	local107
	local108
	local109
	local110
	local111
	local112
	local113
	local114
	local115
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (movingBush x:) 25))
	(= temp1 (- (movingBush x:) 25))
	(= temp2 (- (movingBush y:) 9))
	(= temp3 (+ (movingBush y:) 6))
	(= [local3 0] temp0)
	(= [local3 1] temp2)
	(= [local3 2] temp0)
	(= [local3 3] temp3)
	(= [local3 4] temp1)
	(= [local3 5] temp3)
	(= [local3 6] temp1)
	(= [local3 7] temp2)
	(if (& (movingBush onControl: 1) $0002)
		(movingBush ignoreActors: 1)
		(movingBushPoly points: @local3 size: 4)
	else
		(movingBush ignoreActors: 0)
		(movingBushPoly points: @local11 size: 4)
	)
)

(class DeadGoblin of View
	(properties
		noun 1
		whichGoblin 0
	)
)

(instance rm45 of Rm
	(properties
		noun 9
		picture 45
		style 8
		horizon 65
		north 33
	)

	(method (init &tmp temp0)
		(gCurRoom
			addObstacle:
				(topBush type: PBarredAccess init: 169 63 169 80 99 80 99 63 yourself:)
				(twoRocks
					type: PBarredAccess
					init: 234 178 193 178 193 153 215 153 234 164
					yourself:
				)
				(bushRockCombo
					type: PBarredAccess
					init: 0 127 74 127 141 127 141 145 77 164 0 152
					yourself:
				)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 91 134 91 148 99 148 110 0 110
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 202 63 201 13 101 13 88 13 88 67 0 78 0 0 319 0 319 69 319 115 294 115
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 186 91 186 91 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 261 134 261 149 201 149 201 139 217 134
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 244 189 244 174 319 174 319 189
					yourself:
				)
		)
		(super init:)
		(LoadMany rsVIEW 446 445)
		(NormalEgo)
		(HandsOn)
		(gLongSong stop:)
		(goblinMusic play:)
		(if (or (!= gPrevRoomNum 445) global280) ; goblinArena
			(switch global278
				(0
					(if (IsFlag 232)
						(= local63 1)
					)
				)
				(1
					(= local63 1)
					(= local62 1)
				)
				(2
					(= local63 1)
					(= local62 1)
				)
				(3
					(= local63 1)
					(= local62 1)
				)
				(else
					(= local63 1)
					(= local62 1)
				)
			)
		)
		(if (and (not (IsFlag 207)) (not global278))
			(if (OneOf gPrevRoomNum 33 51)
				(movingBush posn: 140 157 init: setScript: bushAttacks)
			else
				(movingBush posn: 277 95 setPri: 5 init: setScript: bushAttacks)
			)
		)
		(goblin1 init: hide:)
		(goblin2 init: hide: setScript: goblin2Leaves)
		(goblin5 init: hide:)
		(if (> gHowFast 0)
			(goblin6 init:)
			(if (> gHowFast 1)
				(goblin3 init: hide: setScript: goblin3Leaves)
				(goblin4 init:)
			)
		)
		(switch gPrevRoomNum
			(33
				(gEgo
					init:
					posn: 178 (+ (gCurRoom horizon:) 1)
					setMotion: MoveTo 178 (+ (gCurRoom horizon:) 20)
				)
			)
			(51
				(self setScript: sEnterFromEast)
			)
			(44
				(self setScript: sEnterFromWest)
			)
			(445 ; goblinArena
				(if global280
					(EgoGait 1 0) ; running
					(gEgo init: posn: 318 108 setMotion: MoveTo 255 108)
				else
					(Load rsVIEW 519)
					(self setScript: sVictorious)
					(switch global278
						(0)
						(1
							(deadGoblin1 init: addToPic:)
						)
						(2
							(deadGoblin2 init: addToPic:)
						)
						(3
							(deadGoblin1 init: addToPic:)
							(deadGoblin5 init: addToPic:)
							(deadGoblin6 init: addToPic:)
						)
						(4
							(deadGoblin1 init: addToPic:)
							(deadGoblin4 init: addToPic:)
							(deadGoblin2 init: addToPic:)
						)
						(5
							(deadGoblin1 init: addToPic:)
							(deadGoblin4 init: addToPic:)
							(deadGoblin5 init: addToPic:)
							(deadGoblin2 init: addToPic:)
						)
						(6
							(deadGoblin1 init: addToPic:)
							(deadGoblin4 init: addToPic:)
							(deadGoblin5 init: addToPic:)
							(deadGoblin6 init: addToPic:)
							(deadGoblin2 init: addToPic:)
						)
						(7
							(deadGoblin1 init: addToPic:)
							(deadGoblin4 init: addToPic:)
							(deadGoblin5 init: addToPic:)
							(deadGoblin6 init: addToPic:)
							(deadGoblin7 init: addToPic:)
							(deadGoblin2 init: addToPic:)
						)
						(else
							(deadGoblin1 init: addToPic:)
							(deadGoblin4 init: addToPic:)
							(deadGoblin5 init: addToPic:)
							(deadGoblin6 init: addToPic:)
							(deadGoblin7 init: addToPic:)
							(deadGoblin8 init: addToPic:)
							(deadGoblin2 init: addToPic:)
							(= global278 7)
						)
					)
				)
			)
			(else
				(gCurRoom setScript: sEnterFromSouth)
			)
		)
		(Load rsSCRIPT 930)
		(Load rsSCRIPT 927)
		(|= global425 $0008)
	)

	(method (dispose)
		(SetFlag 35)
		(if (== gPrevRoomNum 445) ; goblinArena
			(= global279 0)
		)
		(DisposeScript 927)
		(DisposeScript 930)
		(super dispose:)
	)

	(method (doit)
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(gCurRoom setScript: sExitSouth)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(HandsOff)
				(gCurRoom setScript: sExitEast)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(HandsOff)
				(gCurRoom setScript: sExitWest)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (gEgo edgeHit:)
			(SetFlag 232)
			(goblinMusic stop:)
		)
		(cond
			((and (!= global279 445) (== newRoomNumber 445)) ; goblinArena
				(goblinMusic stop:)
				(= global279 445)
				(gEgo setMotion: 0)
				(SetFlag 207)
				(gMessager say: 9 0 14 0 self) ; "The Goblin has a mean look in its eyes. You prepare for battle."
			)
			((IsObject global426)
				(roomTimer setCycle: self 2)
				(global426 dispose:)
			)
			(else
				(roomTimer dispose: delete:)
				(= global425 0)
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (cue)
		(if (IsObject global426)
			(global426 dispose:)
			(roomTimer setCycle: self 2)
		else
			(gCurRoom newRoom: 445) ; goblinArena
		)
	)
)

(instance goblin1 of Actor
	(properties
		x 37
		y 101
		noun 2
		yStep 1
		view 445
		loop 2
		priority 3
		signal 26640
		cycleSpeed 3
		illegalBits 0
		xStep 2
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(if local61
			(= [local65 local75] (Clone goblinAttacks))
			(self posn: 46 85 setScript: [local65 local75] 0 local75)
			(++ local75)
		else
			(self setScript: goblin1Leaves)
		)
	)
)

(instance goblin2 of Actor
	(properties
		x 294
		y 75
		noun 3
		yStep 1
		view 445
		loop 2
		priority 3
		signal 18448
		cycleSpeed 3
		illegalBits 0
		xStep 2
		moveSpeed 3
	)
)

(instance goblin3 of Actor
	(properties
		x 8
		y 79
		noun 4
		yStep 1
		view 445
		loop 2
		priority 3
		signal 26640
		cycleSpeed 3
		illegalBits 0
		xStep 2
		moveSpeed 3
	)
)

(instance goblin4 of TargActor
	(properties
		x 289
		y 183
		noun 5
		yStep 1
		view 445
		loop 2
		priority 3
		signal 18448
		cycleSpeed 3
		illegalBits 0
		xStep 2
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(if local62
			(= [local65 local75] (Clone goblinAttacks))
			(self show: setScript: [local65 local75] 0 local75)
			(++ local75)
		else
			(self setScript: goblin4Leaves)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(ThrowKnife self gCurRoom)
				(= global280 55)
			)
			(81 ; flameDartSpell
				(CastDart self gCurRoom)
				(= global280 50)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goblin5 of TargActor
	(properties
		y 189
		noun 6
		yStep 1
		view 445
		loop 3
		priority 14
		signal 24592
		cycleSpeed 3
		illegalBits 0
		xStep 2
		moveSpeed 3
	)

	(method (init)
		(super init: &rest)
		(if local63
			(= [local65 local75] (Clone goblinAttacks))
			(self setScript: [local65 local75] 0 local75)
			(++ local75)
		else
			(self setScript: goblin5Leaves)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(ThrowKnife self gCurRoom)
				(= global280 50)
			)
			(81 ; flameDartSpell
				(CastDart self gCurRoom)
				(= global280 45)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goblin6 of Actor
	(properties
		x 284
		y 176
		noun 7
		yStep 1
		view 445
		loop 3
		priority 3
		signal 16400
		cycleSpeed 3
		illegalBits 0
		xStep 2
		moveSpeed 3
	)

	(method (init)
		(super init: &rest)
		(if local64
			(= [local65 local75] (Clone goblinAttacks))
			(self show: setScript: [local65 local75] 0 local75)
			(++ local75)
		else
			(self hide: setHeading: 270 setScript: goblin6Leaves)
		)
	)
)

(instance movingBush of Actor
	(properties
		noun 8
		yStep 1
		view 448
		loop 4
		cycleSpeed 3
		xStep 2
		moveSpeed 3
	)

	(method (doit)
		(super doit:)
		(if
			(and
				local1
				(< (gEgo distanceTo: self) 30)
				(not (gCurRoom script:))
			)
			(= local1 0)
			(gMessager say: 8 0 13 1 gCurRoom) ; "A Goblin steps out of the bush."
		)
	)

	(method (cue)
		(super cue:)
		(gCurRoom cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(self setScript: 0 setMotion: 0 setCel: 0 setLoop: 4)
				(= local1 1)
				(gEgo setMotion: PolyPath x y)
			)
			(12 ; sword
				(goblinMusic stop:)
				(gEgo setMotion: 0)
				(gMessager say: 8 12 0 0 self) ; "A Goblin steps out of the bush."
			)
			(16 ; dagger
				(goblinMusic stop:)
				(gEgo setMotion: 0)
				(gMessager say: 8 12 0 0 self) ; "A Goblin steps out of the bush."
			)
			(81 ; flameDartSpell
				(goblinMusic stop:)
				(gEgo setMotion: 0)
				(gMessager say: 8 12 0 0 self) ; "A Goblin steps out of the bush."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin1 of DeadGoblin
	(properties
		x 98
		y 92
		approachX 95
		approachY 113
		view 446
		cel 1
		priority 6
		signal 26640
		whichGoblin 1
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 4) ; "The only good Goblin is a dead Goblin!"
			)
			(4 ; Do
				(if (not local107)
					(gMessager say: 1 4 4) ; "You find 5 silvers concealed in a pouch. You take the silvers."
					(= local107 1)
					(= local115 1)
					(gEgo setScript: cueItScript)
				else
					(gMessager say: 1 4 3) ; "You've already taken his money."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin2 of DeadGoblin
	(properties
		x 122
		y 156
		approachX 113
		approachY 158
		view 446
		cel 2
		priority 10
		signal 26640
		whichGoblin 2
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init:)
		(bushRockCombo dispose:)
		(bushRockCombo
			type: PBarredAccess
			init: 124 130 124 114 175 114 175 125 170 125 170 137 151 137 151 151 125 151 125 160 0 160 0 130
			yourself:
		)
		(deadGoblin3 init: addToPic:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 5) ; "What's he staring at?"
			)
			(4 ; Do
				(if (not local108)
					(gMessager say: 1 4 5) ; "You find 4 silvers tucked in his tunic. He has no use for the silvers anymore, so into your pocket they go."
					(= local108 1)
					(= local115 1)
					(gEgo setScript: cueItScript)
				else
					(gMessager say: 1 4 3) ; "You've already taken his money."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin3 of DeadGoblin
	(properties
		x 139
		y 132
		approachX 127
		approachY 131
		view 446
		cel 3
		priority 8
		signal 26640
		whichGoblin 3
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 6) ; "Strange place to take a nap."
			)
			(4 ; Do
				(if (not local109)
					(gMessager say: 1 4 6) ; "This poor slob was the big loser at the poker game. He didn't even have lunch money."
					(= local109 1)
				else
					(gMessager say: 1 4 12) ; "He didn't have anything."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin4 of DeadGoblin
	(properties
		x 160
		y 96
		approachX 155
		approachY 99
		view 446
		loop 1
		cel 3
		priority 4
		signal 26640
		whichGoblin 4
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 179 75 179 98 136 98 125 90 125 75
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 7) ; "He's getting a sun tan?"
			)
			(4 ; Do
				(if (not local110)
					(gMessager say: 1 4 7) ; "It's your lucky day! This was the big winner at last night's poker game. You take his 35 silvers."
					(= local110 1)
					(= local115 2)
					(gEgo setScript: cueItScript)
				else
					(gMessager say: 1 4 3) ; "You've already taken his money."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin5 of DeadGoblin
	(properties
		x 221
		y 131
		approachX 190
		approachY 132
		view 446
		loop 1
		priority 4
		signal 26640
		whichGoblin 5
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 261 134 261 149 201 149 201 129 194 129 194 108 194 103 222 103 222 108 244 108 244 122 232 122 232 134
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 8) ; "A good Goblin!"
			)
			(4 ; Do
				(if (not local111)
					(gMessager say: 1 4 8) ; "In this Goblin's left shoe you find 8 silvers. You look around and slip the silvers into your pocket."
					(= local111 1)
					(= local115 3)
					(gEgo setScript: cueItScript)
				else
					(gMessager say: 1 4 3) ; "You've already taken his money."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin6 of DeadGoblin
	(properties
		x 26
		y 139
		approachX 16
		approachY 117
		view 446
		loop 1
		cel 1
		priority 9
		signal 26640
		whichGoblin 6
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 117 41 117 41 127 74 127 74 140 46 140 46 147 0 147
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 9) ; "Does anyone know CPR?"
			)
			(4 ; Do
				(if (not local112)
					(gMessager say: 1 4 9) ; "Clutched in his hand are 4 silvers. You take the money."
					(= local112 1)
					(= local115 4)
					(gEgo setScript: cueItScript)
				else
					(gMessager say: 1 4 3) ; "You've already taken his money."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin7 of DeadGoblin
	(properties
		x 196
		y 184
		approachX 172
		approachY 184
		view 446
		loop 1
		cel 2
		priority 13
		signal 26640
		whichGoblin 7
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init: &rest)
		(twoRocks dispose:)
		(twoRocks
			type: PBarredAccess
			init: 234 179 216 179 216 186 166 186 166 160 189 160 189 153 215 153 215 164 234 164
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 10) ; "Limp as a dishrag."
			)
			(4 ; Do
				(if (not local113)
					(gMessager say: 1 4 10) ; "This guy lost all his dough to a loan shark."
					(= local113 1)
				else
					(gMessager say: 1 4 1) ; "You know he's broke."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGoblin8 of DeadGoblin
	(properties
		x 30
		y 109
		approachX 25
		approachY 109
		view 446
		priority 7
		signal 26640
		whichGoblin 8
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 11) ; "He lost."
			)
			(4 ; Do
				(if (not local114)
					(gMessager say: 1 4 11) ; "The Goblin government lost his paycheck."
					(= local114 1)
				else
					(gMessager say: 1 4 2) ; "He never had any money."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sVictorious of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (gEgo cycleSpeed:))
				(gEgo init: posn: 185 125 setHeading: 180 self)
			)
			(1
				(gEgo
					view: 519
					setLoop: 2
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(if (== global278 1)
					(gMessager say: 9 0 0) ; "Wow! You threw that dead goblin a long way!"
				)
				(NormalEgo)
				(gEgo loop: 2 cycleSpeed: register)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goblin1Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 40))
			)
			(1
				(if (> (gEgo y:) 112)
					(client setMotion: MoveTo 38 86 self)
				else
					(-- state)
					(= cycles 2)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(client
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo -10 86 self
				)
			)
			(4
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin2Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 40))
			)
			(1
				(if (> (gEgo y:) 112)
					(client show: setMotion: MoveTo 283 75 self)
				else
					(-- state)
					(= cycles 2)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(client
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 350 75 self
				)
			)
			(4
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin3Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 40))
			)
			(1
				(if (> (gEgo y:) 112)
					(client
						show:
						illegalBits: 0
						ignoreActors: 1
						setMotion: MoveTo 8 59 self
					)
				else
					(-- state)
					(= cycles 2)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(client setMotion: MoveTo 8 79 self)
			)
			(4
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin4Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 40))
			)
			(1
				(client setMotion: MoveTo 289 164 self)
			)
			(2
				(= seconds 3)
			)
			(3
				(client setMotion: MoveTo 289 183 self)
			)
			(4
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin5Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 40))
			)
			(1
				(client show: setCycle: Walk setMotion: MoveTo 45 189 self)
			)
			(2
				(= seconds 3)
			)
			(3
				(client setMotion: MoveTo -18 189 self)
			)
			(4
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance goblin6Leaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			((= seconds (Random 5 40)))
			(
				(client
					show:
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 239 165 self
				))
			((= seconds 3))
			((client setMotion: MoveTo 306 177 self))
			((client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 160 245 setMotion: MoveTo 160 183 self)
			)
			(1
				(HandsOn)
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
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(gCurRoom newRoom: 62)
			)
		)
	)
)

(instance goblinAttacks of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and register (< (gEgo distanceTo: client) 35))
			(gCurRoom cue:)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setPri: -1
					setAvoider: PAvoider
					setLoop: -1
					setCycle: Walk
					ignoreActors: 0
				)
				(= ticks (Random 200 400))
			)
			(1
				(client show: setMotion: PolyPath (gEgo x:) (gEgo y:))
				(= ticks 120)
			)
			(2
				(= register 1)
				(= state 0)
				(= cycles 2)
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
				(cond
					((< (gEgo y:) 90)
						(= register 85)
					)
					((< (gEgo y:) 115)
						(= register 114)
					)
					(else
						(= register 161)
					)
				)
				(gEgo
					init:
					posn: -25 register
					setMotion: MoveTo 20 register self
				)
			)
			(1
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
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 44)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 51)
			)
		)
	)
)

(instance sEnterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 345 126 setMotion: MoveTo 300 126 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goblinMusic of Sound
	(properties
		flags -1
		number 76
		priority 3
		loop -1
	)
)

(instance movingBushPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance topBush of Polygon
	(properties)
)

(instance twoRocks of Polygon
	(properties)
)

(instance bushRockCombo of Polygon
	(properties)
)

(instance bushAttacks of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				register
				(or
					(< (gEgo distanceTo: client) 45)
					(< (goblin5 distanceTo: client) 50)
					(< (goblin1 distanceTo: client) 50)
					(< (goblin4 distanceTo: client) 50)
				)
			)
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(localproc_0)
				(gCurRoom addObstacle: movingBushPoly)
				(= seconds (Random 5 10))
			)
			(2
				(if (> (gEgo distanceTo: client) 65)
					(client
						setCycle: Walk
						setLoop: -1
						setAvoider: PAvoider
						setMotion: PolyPath (gEgo x:) (gEgo y:) self
					)
					(movingBushPoly points: @local11 size: 4)
					(= register 1)
				else
					(-- state)
					(= ticks 30)
				)
			)
			(3
				(localproc_0)
				(client setLoop: 4 setCel: 0 setMotion: 0)
				(= state 1)
				(= register 0)
				(= ticks (Random 90 300))
			)
		)
	)
)

(instance roomTimer of Timer
	(properties)
)

(instance cueItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 510
					setLoop:
						(cond
							((== global279 445) 0)
							((== global279 465) 1)
							(else
								(mod (gEgo loop:) 2)
							)
						)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(switch local115
					(1
						(gEgo get: 0 5) ; silver
					)
					(2
						(gEgo get: 0 35) ; silver
					)
					(3
						(gEgo get: 0 8) ; silver
					)
					(4
						(gEgo get: 0 4) ; silver
					)
				)
				(= cycles 1)
			)
			(3
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

