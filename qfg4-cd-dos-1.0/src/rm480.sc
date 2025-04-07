;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use GloryRm)
(use DistObj)
(use Teller)
(use DeathIcon)
(use GloryTalker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Rev)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm480 0
	boneTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 2] = [500 500]
	local8
)

(instance rm480 of GloryRm
	(properties
		picture 480
		east 593
	)

	(method (init)
		(if (and (== gPrevRoomNum 490) (== global348 4))
			(= global348 5)
		)
		(gGlory handsOff:)
		(if (and (== global348 1) (gEgo has: 26)) ; theHat
			(= global348 2)
		)
		(theHut init: approachVerbs: 4 45) ; Do, theCorn
		(pestle init: setPri: 107 approachVerbs: 4 47 24) ; Do, theBones, theFlask
		(mortar init: approachVerbs: 4 47 24) ; Do, theBones, theFlask
		(theBody init: setPri: 138 approachVerbs: 4 2) ; Do, Talk
		(boneHead init: approachVerbs: 4 2 44) ; Do, Talk, theHat
		(theHat
			init:
			setCel: (if (IsFlag 151) 1 else 0)
			setPri: 170
			approachVerbs: 4 2 44 ; Do, Talk, theHat
		)
		(heroTeller
			init:
				gEgo
				480
				28
				128
				(switch global348
					(0 1)
					(1 1)
					(2 18)
					(3 19)
					(4 20)
					(5 22)
					(6 24)
					(else 26)
				)
		)
		(boneTeller
			init:
				theHat
				480
				28
				169
				(switch global348
					(0 1)
					(1 1)
					(2 18)
					(3 19)
					(4 20)
					(5 22)
					(6 24)
					(else 26)
				)
		)
		(hutPerch init: approachVerbs: 4 45) ; Do, theCorn
		(laserSkull1 init:)
		(gateSkull init:)
		(laserSkull2 init:)
		(threeSkulls init: approachVerbs: 4 46) ; Do, thePiepan
		(fourSkulls init: approachVerbs: 4 46) ; Do, thePiepan
		(treeTop init:)
		(treeTrunk init:)
		(eggRock init:)
		(exitArea init:)
		(cliff init:)
		(if (== gPrevRoomNum 593)
			(self setScript: from593Scr)
		else
			(= local3 1)
			(self setScript: from490Scr)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 247 115 284 138 284 148 261 167 220 175 131 175 131 159 214 141 214 130 195 113 205 96 153 96 136 103 103 105 103 109 166 116 162 133 119 151 53 139 33 118 33 112 112 87 69 73 69 61 36 61 70 87 70 92 12 109 12 126 38 158 59 186 264 186 301 168 311 140 268 114 268 0 319 0 319 189 0 189 0 0 247 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 149 100 191 100 191 108 149 108
					yourself:
				)
		)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 205 137 191 119 199 86 221 89 236 143 319 152 319 189 241 189 202 160
					yourself:
				)
				50
		)
		(if (not (IsFlag 151))
			(= local1
				((Polygon new:)
					init: 63 189 0 0 0 151 134 150 133 171
					yourself:
				)
			)
		)
		(gLongSong number: 491 setLoop: -1 play:)
		(gEgo actions: (heroDist init: theHat 100 yourself:))
		(if (== gPrevRoomNum 593)
			(gGlory save: 1)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and gDebugging (!= local4 global348))
			(SetFlag 336)
			(= local4 global348)
		)
		(cond
			(
				(and
					(> (gEgo x:) 236)
					(< (gEgo y:) 116)
					(!= (self script:) sToForest)
					(!= (self script:) from593Scr)
				)
				(gGlory handsOff:)
				(self setScript: sToForest)
			)
			(
				(and
					(& (gEgo scaleSignal:) $0001)
					(gEgo inRect: 120 129 226 137)
					(!= (gCurRoom script:) from490Scr)
				)
				(gEgo setScale:)
			)
			(
				(and
					(not (gEgo scaler:))
					(gEgo inRect: 120 138 226 146)
					(!= (gCurRoom script:) from490Scr)
				)
				(gEgo setScaler: Scaler 113 45 176 61)
			)
		)
		(cond
			(script)
			((and (not global348) (< (gEgo x:) 230))
				(SetFlag 150)
				(= global348 1)
				(gMessager say: 5 6 13) ; "Go back, or face thy doom."
			)
			(
				(and
					(< (gEgo x:) 230)
					(not local3)
					(OneOf global348 2 6 7 8)
				)
				(= local3 1)
				(switch global348
					(2
						(gMessager say: 5 6 14) ; "So, have you got an excuse for being here, or have ya just come ta keep me company?"
					)
					(6
						(gMessager say: 5 6 18) ; "So, did ya get it? Show me. I won't let you in without it."
					)
					(else
						(proc0_17 5 6 19)
					)
				)
			)
			(
				(and
					(not (IsFlag 151))
					(or (== global348 1) (== global348 0))
					(< (gEgo x:) 142)
					(not local2)
				)
				(= local2 1)
				(gEgo setMotion: 0)
				(gCurRoom setScript: sWarnDanger)
			)
			(
				(and
					(not (IsFlag 151))
					(not (gCast contains: theLaser))
					(< (gEgo x:) 142)
				)
				(theLaser
					init:
					signal: (| (theLaser signal:) $0001)
					setCel: 0
					setLoop: 6 1
					setCycle: CT 7 1
				)
			)
			((and (gCast contains: theLaser) (> (gEgo x:) 142))
				(theLaser setCycle: Beg theLaser)
			)
			((and (not (IsFlag 151)) (local1 onMe: (gEgo x:) (gEgo y:)))
				(gCurRoom setScript: zapEgo)
			)
			((and (> (gEgo x:) 236) (< (gEgo y:) 116))
				(gGlory handsOff:)
				(self setScript: sToForest)
			)
			(
				(or
					(and
						(< (gEgo y:) 69)
						(<= global348 3)
						(<= (theHut x:) 69)
						(not (theHut mover:))
					)
					(and
						(not (IsFlag 432))
						(>= global348 5)
						(<= (theHut x:) 69)
						(not (theHut mover:))
					)
				)
				(theHut
					signal: (| (theHut signal:) $0001)
					setLoop: 5 1
					setCycle: Fwd
					setMotion: MoveTo 124 (theHut y:) theHut
				)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 247 115 284 138 284 148 261 167 220 175 131 175 131 159 214 141 214 130 195 113 205 96 153 96 136 103 103 105 103 109 166 116 162 133 119 151 53 139 33 118 33 112 112 87 69 73 69 61 94 56 94 47 78 47 57 52 6 54 6 58 36 61 70 87 70 92 12 109 12 126 38 158 59 186 264 186 301 168 311 140 268 114 268 0 319 0 319 189 0 189 0 0 247 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 149 100 191 100 191 108 149 108
							yourself:
						)
				)
			)
			((and (>= global348 4) (<= (theHut x:) 69) (< (gEgo y:) 62))
				(gCurRoom setScript: sInHut)
			)
		)
	)

	(method (dispose)
		(if (== global348 5)
			(= global348 6)
		)
		(if local1
			(local1 dispose:)
		)
		(heroTeller dispose:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86 ; flameDartSpell
				(= local5 1)
				(gCurRoom setScript: (ScriptID 32) self 86) ; project
			)
			(88 ; forceBoltSpell
				(= local5 1)
				(gCurRoom setScript: (ScriptID 32) self 88) ; project
			)
			(93 ; lightningBallSpell
				(= local5 1)
				(gCurRoom setScript: (ScriptID 32) self 93) ; project
			)
			(79 ; frostSpell
				(= local5 1)
				(gCurRoom setScript: (ScriptID 32) self 79) ; project
			)
			(81 ; detectMagicSpell
				(gMessager say: 0 81 0) ; "Instant sensory overload! Several of the skulls are magical (particularly the ones with the glowing eyes) and the hut itself is "artifact-level" magic (you know, the kind for which wizards go around challenging each other to magical duels)."
			)
		)
	)

	(method (cue)
		(if local5
			(EgoDead 73 480 970 1) ; "You see the light! Your whole life goes past your eyes in a flash... Or maybe those were just the skulls' laser eyes flash-frying you."
		else
			(theLaser setLoop: 7 1 setCel: 0 setCycle: End theLaser)
		)
	)
)

(instance heroTeller of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				74 ; Tell About Gnome
				(and
					(not (IsFlag 336))
					(OneOf global348 0 1 2)
					(IsFlag 159)
				)
				83 ; Tell About Gnome
				(and
					(not (IsFlag 336))
					(OneOf global348 0 1 2)
					(IsFlag 159)
				)
				75 ; Ask About Useful Thing
				local8
				76 ; Ask About Fry Guys
				local8
				77 ; Ask About "Big B"
				local8
		)
	)

	(method (sayMessage)
		(switch iconValue
			(83 ; Tell About Gnome
				(SetFlag 336)
			)
			(74 ; Tell About Gnome
				(= local8 1)
			)
		)
		(super sayMessage: &rest)
	)
)

(instance boneTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker boneTalker)
	)

	(method (showCases)
		(super showCases: 94 (not (IsFlag 179))) ; Elderbury Pie
	)
)

(instance boneTalker of GloryTalker
	(properties
		x 2
		talkWidth 130
		view 486
		textX 160
		textY 10
	)

	(method (init)
		(if (IsFlag 151)
			(super init: boneMouth boneBust boneEyes boneFrame &rest)
		else
			(super init: boneMouth 0 boneEyes boneFrame &rest)
		)
	)
)

(instance boneFrame of View
	(properties
		x 2
		y -1
		view 486
	)
)

(instance boneBust of Prop
	(properties
		y 3
		priority 255
		view 486
		loop 1
	)
)

(instance boneMouth of Prop
	(properties
		x 65
		y 99
		view 486
		loop 2
	)
)

(instance boneEyes of Prop
	(properties
		x 102
		y 76
		view 486
		loop 3
	)
)

(instance from490Scr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 161
					setLoop: 2
					setScaler: Scaler 113 45 176 61
					posn: 208 186
					init:
				)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(2
				(gEgo setLoop: 1)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(3
				(gEgo setLoop: 0)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(4
				(gEgo normalize: setHeading: 315)
				(= cycles 12)
			)
			(5
				(switch global348
					(5
						(gMessager say: 5 6 17 0 self) ; "Well, what have we here? Back in one piece? I sure never expected to see you outside of a quiche again."
					)
					(7
						(gMessager say: 5 6 20 0 self) ; "Guess she liked the pie, or you woulda taken its place."
						(= global348 8)
						(= local3 1)
					)
					(8
						(proc0_17 5 6 21 self)
						(= local3 1)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInHut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (not (theHut cel:))
					(theHut
						signal: (| (theHut signal:) $0001)
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gCurRoom newRoom: 490)
			)
		)
	)
)

(instance sWarnDanger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 5 6 16 0 self) ; "I wouldn't do that if I was you."
			)
			(1
				(theLaser
					signal: (| (theLaser signal:) $0001)
					init:
					setCel: 0
					setLoop: 6 1
					setCycle: CT 7 1 self
				)
			)
			(2
				(theLaser signal: (& (theLaser signal:) $fffe))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance from593Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gEgo moveSpeed:))
				(gEgo
					init:
					setLoop: 2 1
					setCycle: Fwd
					setPri: 64
					setScale:
					scaleX: 80
					scaleY: 80
					setSpeed: global433
					posn: 246 154
					setMotion: MoveTo 267 115 self
				)
			)
			(1
				(gEgo
					setScaler: Scaler 113 45 176 61
					setPri: -1
					normalize:
					setLoop: 2 1
					setMotion: PolyPath 271 122 self
				)
			)
			(2
				(gEgo normalize: setSpeed: register)
				(= cycles (+ (gEgo cycleSpeed:) 2))
			)
			(3
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 17 6 16 0 self) ; "Every sense tingles with the feeling of danger! The eye sockets of the skulls glow with deadly energy. Even the hut looks hungry!"
				else
					(self cue:)
				)
			)
			(4
				(gEgo solvePuzzle: 422 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sToForest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gEgo moveSpeed:))
				(gEgo
					setLoop: 3 1
					setCycle: Fwd
					setPri: 64
					setScale:
					setSpeed: 6
					setMotion: MoveTo 246 154 self
				)
				(if (== global348 1)
					(= global348 2)
					(gMessager say: 5 6 12) ; "Don't come back unless ya got a reason ta be here."
				)
			)
			(1
				(gEgo setSpeed: register)
				(Palette 2 66 85 100) ; PalIntensity
				(gCurRoom newRoom: 593)
			)
		)
	)
)

(instance sPushBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local0 0)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 31
					setLoop: 1 1
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(theBody
					signal: (| (theBody signal:) $0001)
					setLoop: 3 1
					setCycle: End theBody
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo normalize: 7 setSpeed: register)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance zapEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(theLaser
					signal: (| (theLaser signal:) $0001)
					setCycle: End gCurRoom
				)
				(if (not (gEgo takeDamage: 10))
					(gCurRoom setScript: sEgoDies)
				else
					(gEgo
						setLoop: 1 1
						setMotion: JumpTo (+ (gEgo x:) 40) 178 self
					)
				)
			)
			(1
				(gEgo normalize: 1)
				(= ticks 100)
			)
			(2
				(gMessager say: 5 6 24) ; "Heh heh, don't say I didn't warn you!"
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setHeading: 180 self)
			)
			(1
				(gEgo
					view: 995
					setLoop: 0 1
					setCel: 0
					cycleSpeed: global433
					setCycle: End self
				)
			)
			(2
				(EgoDead 73 480 970 1) ; "You see the light! Your whole life goes past your eyes in a flash... Or maybe those were just the skulls' laser eyes flash-frying you."
			)
		)
	)
)

(instance sGiveHat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo drop: 26 1) ; theHat
				(gGlory handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 31
					setLoop: 1 1
					setCel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gEgo solvePuzzle: 426 6)
				(theHat setCel: 1 setPri: 170)
				(SetFlag 151)
				(local1 dispose:)
				(= local1 0)
				(= global348 3)
				((heroTeller stack:) dispose:)
				(heroTeller
					stack: ((intList new:) addToFront: 19)
					curNoun: 19
					rootNoun: 19
				)
				((boneTeller stack:) dispose:)
				(boneTeller
					stack: ((intList new:) addToFront: 19)
					curNoun: 19
					rootNoun: 19
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gMessager say: 5 6 22) ; "Not bad... not bad at all. I can tell by the reflections in your eyes that it gives me character, makes me look mysterious."
				(gEgo normalize: 7 setSpeed: register)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dropCorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo drop: 27 1) ; theCorn
				(gGlory handsOff:)
				(gEgo view: 4 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(= global348 4)
				((heroTeller stack:) dispose:)
				(heroTeller
					stack: ((intList new:) addToFront: 20)
					curNoun: 20
					rootNoun: 20
				)
				((boneTeller stack:) dispose:)
				(boneTeller
					stack: ((intList new:) addToFront: 20)
					curNoun: 20
					rootNoun: 20
				)
				(localCorn x: 58 y: 49 init:)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					view: 0
					setLoop: 6 1
					setCycle: Rev
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(+ (gEgo y:) 10)
						self
				)
			)
			(3
				(gEgo normalize: 6)
				(theHut
					signal: (| (theHut signal:) $0001)
					setLoop: 5 1
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 54 56 self
				)
			)
			(4
				(theHut setLoop: 4 1 setCel: 0 setCycle: End self)
			)
			(5
				(theHut signal: (& (theHut signal:) $fffe))
				(gEgo solvePuzzle: 427 6)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 247 115 284 138 284 148 261 167 220 175 131 175 131 159 214 141 214 130 195 113 205 96 153 96 136 103 103 105 103 109 166 116 162 133 119 151 53 139 33 118 33 112 112 87 69 73 69 61 36 61 70 87 70 92 12 109 12 126 38 158 59 186 264 186 301 168 311 140 268 114 268 0 319 0 319 189 0 189 0 0 247 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 149 100 191 100 191 108 149 108
							yourself:
						)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGrindBones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(pestle signal: (| (pestle signal:) $0001))
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 480
					setPri: (+ (gEgo priority:) 10)
					setLoop: 9 1
					setCel: 0
					setSpeed: 6
					setCycle: CT 1 1 self
				)
				(pestle hide:)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo
					setLoop: 10 1
					setCel: 0
					setCycle: ForwardCounter 3 self
				)
				(pestle
					show:
					signal: (| (pestle signal:) $0001)
					view: 480
					x: (gEgo x:)
					y: (gEgo y:)
					z: -3
					setLoop: 11 1
					setCel: 0
					cycleSpeed: (gEgo cycleSpeed:)
					setScale:
					setPri: 250
					show:
					setCycle: Fwd
				)
			)
			(3
				(pestle setCycle: 0 hide:)
				(gEgo setLoop: 9 1 setCel: 2 setCycle: Beg self)
			)
			(4
				(gEgo solvePuzzle: 431 2)
				(pestle
					setLoop: 8 1
					setCel: 0
					setPri: 107
					x: 153
					y: 122
					z: 20
					scaleX: 128
					scaleY: 128
					show:
				)
				(= cycles 3)
			)
			(5
				(gMessager say: 13 4 111 0 self) ; "You work the pestle back and forth in the mortar. It's hard work, but after a while you manage to grind the bones into a fine bone meal with almost the consistency of flour."
			)
			(6
				(gEgo normalize: 4 setSpeed: register)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance placePie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 4
					setLoop: 1 1
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gEgo solvePuzzle: 432 6)
				(thePie init:)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					view: 0
					setLoop: 1 1
					setCycle: Rev
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(3
				(gEgo normalize: 1)
				(theLaser
					init:
					signal: (| (theLaser signal:) $0001)
					setLoop: 7 1
					setCel: 5
					setCycle: CT 2 -1 self
				)
			)
			(4
				(thePie
					signal: (| (thePie signal:) $0001)
					setCycle: CT 9 1 self
				)
				((gInventory at: 28) ; thePiepan
					maskCel: (| ((gInventory at: 28) maskCel:) $0008) ; thePiepan
				)
			)
			(5
				(thePie setCycle: End self)
				(theLaser setCycle: CT 5 1 theLaser)
			)
			(6
				(thePie signal: (& (thePie signal:) $fffe))
				(gEgo setMotion: MoveTo 121 154 self)
			)
			(7
				(gEgo view: 4 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(8
				(gMessager say: 17 6 29 0 self) ; "The skulls appear to have stopped flashing their lasers. You pick up the pie; it's been cooked to a delicate golden-brown."
			)
			(9
				(thePie dispose:)
				(gEgo setCycle: Beg self)
			)
			(10
				(gMessager say: 5 6 25 0 self) ; "Hey, Birdlegs! Squat!"
			)
			(11
				(if (== (theHut x:) 124)
					(theHut
						signal: (| (theHut signal:) $0001)
						setLoop: 5 1
						illegalBits: 0
						ignoreActors:
						setMotion: MoveTo 54 56 self
					)
				else
					(= ticks 1)
				)
			)
			(12
				(theHut
					setLoop: 4 1
					setCel: 0
					signal: (| (theHut signal:) $0001)
					setCycle: End
				)
				(gEgo
					normalize: 0
					cycleSpeed: register
					setMotion: PolyPath 55 61 self
				)
			)
			(13
				(= global348 7)
				(theHut signal: (& (theHut signal:) $fffe))
				(gCurRoom setScript: sInHut)
			)
		)
	)
)

(instance theHut of Actor
	(properties
		x 54
		y 56
		view 480
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(45 ; theCorn
				(hutPerch doVerb: 45)
			)
			(4 ; Do
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== global348 3)
			(gMessager say: 5 6 23) ; "Doesn't like you very much, I guess. Probably blames you for having to fly all the way from Spielburg."
		)
		(self setLoop: 4 1 setCel: 0 signal: (& (theHut signal:) $fffe))
	)
)

(instance thePie of Prop
	(properties
		x 94
		y 152
		view 480
		cel 3
		signal 16384
	)
)

(instance theBody of Prop
	(properties
		noun 4
		approachX 284
		approachY 141
		x 272
		y 139
		z 35
		view 480
		loop 2
		signal 16384
	)

	(method (cue)
		(if local0
			(= local0 0)
			(self setLoop: 2 1 signal: (& (self signal:) $fffe))
		else
			(= local0 1)
			(self setCycle: End self)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sPushBody)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theHat of View
	(properties
		noun 5
		sightAngle 180
		approachX 190
		approachY 175
		x 167
		y 166
		z 30
		priority 170
		fixPriority 1
		view 480
		cel 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setPri: 159)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; theHat
				(gCurRoom setScript: sGiveHat)
			)
			(46 ; thePiepan
				(if
					(and
						(not (& ((gInventory at: 28) maskCel:) $0008)) ; thePiepan
						(& ((gInventory at: 28) maskCel:) $0001) ; thePiepan
						(& ((gInventory at: 28) maskCel:) $0002) ; thePiepan
						(& ((gInventory at: 28) maskCel:) $0004) ; thePiepan
					)
					(gMessager say: 5 6 15) ; "Looking good. Now show it to the head skull over there, and get outta the way fast if ya don't want to add rump roast to Baba's menu for tonight."
					(= global348 7)
					((heroTeller stack:) dispose:)
					(heroTeller
						stack: ((intList new:) addToFront: 26)
						curNoun: 26
						rootNoun: 26
					)
					((boneTeller stack:) dispose:)
					(boneTeller
						stack: ((intList new:) addToFront: 26)
						curNoun: 26
						rootNoun: 26
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theLaser of Prop
	(properties
		x 118
		y 166
		view 480
		signal 16384
		cycleSpeed 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 159)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance pestle of Prop
	(properties
		approachX 153
		approachY 103
		x 153
		y 122
		z 20
		view 480
		loop 8
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(mortar doVerb: theVerb)
			)
		)
	)
)

(instance localCorn of View
	(properties
		view 480
		cel 2
		signal 16384
	)
)

(instance mortar of Feature
	(properties
		noun 13
		nsLeft 155
		nsTop 82
		nsRight 184
		nsBottom 107
		sightAngle 180
		approachX 151
		approachY 103
		x 165
		y 105
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(4 ; Do
				(cond
					((IsFlag 157)
						(ClearFlag 157)
						(SetFlag 158)
						(gCurRoom setScript: sGrindBones)
					)
					((IsFlag 158)
						(gMessager say: 13 4 110) ; "The fine bone meal slips between your fingers. You'll need a container in which to carry it."
					)
					(else
						(gMessager say: 13 4 109) ; "You grind the pestle around in the empty mortar. It's heavy work and you don't seem to be accomplishing anything useful."
					)
				)
			)
			(47 ; theBones
				(gEgo drop: 29 1) ; theBones
				(SetFlag 157)
				(gMessager say: 13 47 0) ; "You put the bones into the huge mortar. Now what?"
			)
			(24 ; theFlask
				(cond
					((IsFlag 157)
						(gMessager say: 13 24 111) ; "The bones are too coarse and knobby to fit in your flask."
					)
					((IsFlag 158)
						(ClearFlag 158)
						(gEgo drop: 9 1) ; theFlask
						(gEgo get: 12) ; theBonemeal
						(gMessager say: 17 6 110) ; "You fill the flask with powdery bone meal from the mortar."
					)
					(else
						(gMessager say: 13 24 109) ; "There's nothing in the mortar."
					)
				)
			)
			(27 ; theBonemeal
				(gMessager say: 13 27 0) ; "You don't need to grind the bone meal any finer."
			)
			(45 ; theCorn
				(gMessager say: 13 45 0) ; "Making corn meal isn't nearly corny enough for Baba Yaga. The mortar would probably break from embarrassment if it were used to grind real food."
			)
			(else
				(gMessager say: 17 6 112) ; "You don't need to grind THAT!"
			)
		)
	)
)

(instance boneHead of Feature
	(properties
		noun 5
		nsLeft 158
		nsTop 122
		nsRight 172
		nsBottom 139
		sightAngle 180
		approachX 190
		approachY 175
		x 165
		y 130
	)

	(method (doVerb theVerb)
		(theHat doVerb: theVerb)
	)
)

(instance laserSkull1 of Feature
	(properties
		noun 11
		nsLeft 17
		nsTop 84
		nsRight 27
		nsBottom 97
		sightAngle 180
		x 22
		y 90
	)
)

(instance gateSkull of Feature
	(properties
		noun 10
		nsLeft 42
		nsTop 97
		nsRight 50
		nsBottom 106
		sightAngle 180
		x 46
		y 101
	)
)

(instance laserSkull2 of Feature
	(properties
		noun 12
		nsLeft 147
		nsTop 127
		nsRight 158
		nsBottom 139
		sightAngle 180
		x 152
		y 133
	)
)

(instance threeSkulls of Feature
	(properties
		noun 15
		nsLeft 52
		nsTop 110
		nsRight 94
		nsBottom 129
		sightAngle 180
		approachX 121
		approachY 154
		x 73
		y 119
	)

	(method (doVerb theVerb)
		(if gDebugging
			(gCurRoom setScript: placePie)
		else
			(switch theVerb
				(46 ; thePiepan
					(if
						(and
							(not (& ((gInventory at: 28) maskCel:) $0008)) ; thePiepan
							(& ((gInventory at: 28) maskCel:) $0001) ; thePiepan
							(& ((gInventory at: 28) maskCel:) $0002) ; thePiepan
							(& ((gInventory at: 28) maskCel:) $0004) ; thePiepan
						)
						(gCurRoom setScript: placePie)
					else
						(super doVerb: theVerb)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance fourSkulls of Feature
	(properties
		noun 9
		nsLeft 38
		nsTop 140
		nsRight 70
		nsBottom 169
		sightAngle 180
		approachX 121
		approachY 154
		x 54
		y 154
	)

	(method (doVerb theVerb)
		(if (== theVerb 46) ; thePiepan
			(threeSkulls doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance treeTop of Feature
	(properties
		noun 16
		nsLeft 90
		nsTop -1
		nsRight 319
		nsBottom 45
		sightAngle 180
		x 204
		y 22
	)
)

(instance treeTrunk of Feature
	(properties
		noun 16
		nsLeft 168
		nsTop 46
		nsRight 248
		nsBottom 103
		sightAngle 180
		x 208
		y 74
	)
)

(instance eggRock of Feature
	(properties
		noun 7
		nsLeft 209
		nsTop 94
		nsRight 248
		nsBottom 121
		sightAngle 180
		x 228
		y 107
	)
)

(instance exitArea of Feature
	(properties
		noun 8
		nsLeft 302
		nsTop 93
		nsRight 319
		nsBottom 157
		sightAngle 180
		x 310
		y 125
	)
)

(instance cliff of Feature
	(properties
		noun 6
		nsLeft 65
		nsTop 46
		nsRight 155
		nsBottom 69
		sightAngle 180
		x 110
		y 57
	)
)

(instance hutPerch of Feature
	(properties
		noun 30
		nsTop 46
		nsRight 104
		nsBottom 61
		sightAngle 40
		approachX 54
		approachY 57
		x 52
		y 53
	)

	(method (doVerb theVerb)
		(switch theVerb
			(45 ; theCorn
				(gCurRoom setScript: dropCorn)
			)
			(4 ; Do
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance heroDist of DistObj
	(properties)

	(method (doVerb theVerb)
		(switch (super doVerb: theVerb)
			(theHat
				(heroTeller doVerb: theVerb)
			)
		)
	)
)

(instance intList of List
	(properties)

	(method (dispose)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(DisposeClone self)
	)
)

