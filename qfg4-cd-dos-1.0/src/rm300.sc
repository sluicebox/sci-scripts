;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use GloryRm)
(use DistObj)
(use Teller)
(use DeathIcon)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm300 of GloryRm
	(properties
		noun 26
		picture 300
	)

	(method (init)
		(= local0
			(cond
				((and (not (IsFlag 37)) (not (IsFlag 30))) 1)
				(
					(and
						(IsFlag 37)
						(not gNight)
						(>= gDay 5)
						(not (IsFlag 67))
						(not (IsFlag 48))
						(not (IsFlag 39))
					)
					4
				)
				(
					(and
						(not (IsFlag 43))
						(gEgo has: 19) ; theSword
						(== ((gInventory at: 19) state:) 3) ; theSword
					)
					10
				)
				(
					(and
						(IsFlag 37)
						(IsFlag 67)
						(not gNight)
						(not (IsFlag 39))
						(not (IsFlag 40))
						(not (IsFlag 48))
					)
					5
				)
				(
					(and
						(IsFlag 37)
						gNight
						(not (IsFlag 48))
						(not (IsFlag 39))
						(not (IsFlag 40))
					)
					6
				)
				((and (not (IsFlag 37)) (IsFlag 30) (not (IsFlag 47))) 2)
				((and (not (IsFlag 37)) (IsFlag 47)) 3)
				((and (or (IsFlag 48) (IsFlag 39)) (not (IsFlag 40))) 7)
				((and (IsFlag 37) (not (IsFlag 40)) (>= gDay 5)) 8)
				((and (IsFlag 45) (not (IsFlag 68)) (> gDay global414)) 9)
			)
		)
		(gLongSong number: 300 setLoop: -1 play:)
		(if (IsFlag 70)
			(gEgo init: view: 352 loop: 0 setCel: 10 x: 270 y: 155)
		else
			(gEgo
				init:
				normalize:
				posn: 335 184
				setScaler: Scaler 122 50 189 87
			)
		)
		(gCurRoom
			addObstacle:
				(cond
					((>= gTime 4)
						((Polygon new:)
							type: PContainedAccess
							init: 90 128 90 140 143 140 143 146 115 154 66 154 48 142 35 147 26 147 23 128 13 128 0 141 0 189 302 189 308 184 304 179 289 179 245 135 145 135 169 112 139 112 106 128
							yourself:
						)
					)
					((not (IsFlag 32))
						((Polygon new:)
							type: PContainedAccess
							init: 90 128 90 140 142 140 142 146 115 154 66 154 0 149 0 189 302 189 308 184 304 179 290 178 274 162 212 162 219 145 255 145 245 135 145 135 169 112 139 112 122 128
							yourself:
						)
					)
					(else
						((Polygon new:)
							type: PContainedAccess
							init: 90 128 90 140 141 140 141 147 115 154 66 154 52 160 0 160 0 189 302 189 308 184 304 179 289 179 245 135 145 135 169 112 139 112 124 128
							yourself:
						)
					)
				)
		)
		(self
			addPoly:
				((Polygon new:) init: 243 139 258 160 237 172 222 148 yourself:)
				120
				((Polygon new:) init: 136 110 179 111 163 129 125 116 yourself:)
				50
		)
		(cond
			((IsFlag 32)
				(if (<= gTime 3)
					(burgoMeister
						init:
						posn: 40 154
						loop: 1
						approachX: 72
						approachY: 166
						approachVerbs: 4 2 ; Do, Talk
						setScript: sBurgoIncidental
					)
				)
			)
			((<= gTime 3)
				(burgoMeister
					init:
					approachX: 205
					approachY: 172
					approachVerbs: 4 2 ; Do, Talk
					setCycle: End
				)
				(SetFlag 32)
			)
		)
		(shield init: approachVerbs: 4) ; Do
		(if (IsFlag 43)
			(shield setCel: 1)
		)
		(bedroomDoor init: approachVerbs: 4) ; Do
		(chair init: approachVerbs: 4) ; Do
		(desk init: approachVerbs: 4 42 28 80) ; Do, theToolkit, theLockpick, openSpell
		(cellDoor init: approachVerbs: 4 29 42 28 80) ; Do, theKeyRing, theToolkit, theLockpick, openSpell
		(stairs init: approachVerbs: 4) ; Do
		(spears init: approachVerbs: 4) ; Do
		(burgoWindow init: approachVerbs: 4) ; Do
		(mainDoor init: approachVerbs: 4) ; Do
		(if (IsFlag 70)
			(mainDoor cel: 0)
		)
		(if (OneOf local0 4 5 6)
			(gypsy init: approachVerbs: 4 2 29 42 28 80) ; Do, Talk, theKeyRing, theToolkit, theLockpick, openSpell
		)
		(super init: &rest)
		(heroTeller
			init:
				gEgo
				300
				25
				128
				(switch local0
					(1 16)
					(2 17)
					(4 19)
					(5 20)
					(3 18)
					(6 13)
					(7 21)
					(9 23)
					(else 22)
				)
		)
		(if (OneOf local0 4 5)
			(gEgo actions: (myDist init: gypsy 60 burgoMeister 60 yourself:))
		)
		(if (IsFlag 70)
			(self setScript: sEnterWin)
		else
			(self setScript: sEnterScr)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (!= local3 gTime) (== (= local3 gTime) 0))
			(gCurRoom setScript: sCaughtByBurgo)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; detectMagicSpell
				(if gNight
					(cond
						((and (gCast contains: gypsy) (== (shield cel:) 0))
							(gMessager say: 0 81 61) ; "The gypsy has some form of natural magic. There is also a magical shield on the wall."
						)
						((gCast contains: gypsy)
							(gMessager say: 0 81 54) ; "There is some sort of natural magic around the gypsy. Nothing else here is magical."
						)
						((== (shield cel:) 0)
							(gMessager say: 0 81 60) ; "The shield on the wall radiates protective magic."
						)
						(else
							(gMessager say: 0 81 0) ; "There is no longer any trace of magic here."
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (leaveRoom)
		(if (gCast contains: burgoMeister)
			(switch local0
				(1
					(SetFlag 30)
					(gMessager say: 15 6 17) ; "I must warn you that the townspeople are very suspicious of strangers. Do not offend them."
				)
				(2
					(SetFlag 47)
					(gMessager say: 15 6 18) ; "Stay out of trouble and other people's business and you and I will get along with one another. Otherwise, you will get me angry. I'm sure you don't want to make me angry, do you?"
				)
				(3
					(gMessager say: 15 6 20) ; "Try to avoid getting into trouble. I would not like to have you in my jail, after all."
				)
				(4
					(gMessager say: 15 6 22) ; "It is possible that the gravedigger is still alive. If you are going wandering outside of town, please watch for him."
				)
				(5
					(proc0_17 15 6 24)
				)
				(7
					(gMessager say: 15 6 29) ; "Farewell, and thank you for helping Igor. I did not believe the gypsy was guilty, and I did not want to burn him at the stake."
				)
				(8
					(gMessager say: 15 6 31) ; "Take care of yourself."
				)
				(9
					(gMessager say: 15 6 33) ; "Goodbye, and try not to run into any more ghosts, please."
				)
				(10
					(gMessager say: 15 6 35) ; "Thanks for returning Piotyr's sword. My family's honor shall at last be cleansed."
				)
			)
		)
	)

	(method (newRoom)
		(gLongSong fade: 0)
		(super newRoom: &rest)
	)

	(method (dispose)
		(DisposeScript 9)
		(heroTeller dispose:)
		(super dispose: &rest)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: MoveTo 279 184 self)
			)
			(2
				(mainDoor setCycle: Beg self)
			)
			(3
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 1)
			)
			(4
				(switch local0
					(1
						(gMessager say: 15 6 14 0 self) ; "This is my office. What are you looking for?"
					)
					(2
						(gMessager say: 15 6 15 0 self) ; "Are you just sightseeing, or casing my place?"
					)
					(4
						(SetFlag 67)
						(gMessager say: 15 6 21 0 self) ; "The gravedigger is missing, and the gypsy just happened to be near the front gate when we were searching for Igor. He is suspected of being a Werewolf and having eaten Igor."
					)
					(5
						(proc0_17 15 6 19 self)
					)
					(7
						(gMessager say: 15 6 25 0 self) ; "The gypsy is gone."
					)
					(8
						(gMessager say: 15 6 30 0 self) ; "Greetings, what can I do for you today?"
					)
					(9
						(SetFlag 68)
						(gMessager say: 15 6 32 0 self) ; "Nikolai, the old man, is dead. He wandered out of town yesterday and I found only his tattered remains. He will be missed."
					)
					(else
						(proc0_17 15 6 19 self)
					)
				)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(SetFlag 358)
				(ClearFlag 70)
				(= local1 (gEgo cycleSpeed:))
				(gEgo cycleSpeed: 9 setCycle: Beg self)
			)
			(2
				(gEgo
					normalize: 6
					x: 267
					y: 155
					cycleSpeed: local1
					setScaler: Scaler 122 50 189 87
					setMotion: MoveTo 249 163 self
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLetGypsyOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 31 setLoop: 1 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gMessager say: 11 6 6 0 self) ; "You open the cell door and release the gypsy prisoner."
			)
			(2
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(openDoor init:)
				(gypsy
					z: 0
					posn: 122 117
					setPri: -1
					setLoop: 6 1
					setCycle: Walk
					setScaler: Scaler 118 77 181 112
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(gMessager say: 12 6 7 0 self) ; "I do not understand why you are helping me, but thank you. Our camp is in the northeast corner of the valley."
			)
			(4
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 90 128 90 140 142 140 142 146 115 154 66 154 48 142 37 145 18 145 18 128 13 128 0 141 0 189 302 189 308 184 304 179 290 178 274 162 212 162 219 145 255 145 245 135 145 135 156 124 130 124 130 128
							yourself:
						)
				)
				(gEgo normalize: 1)
				(Palette 2 66 85 50) ; PalIntensity
				(gypsy setMotion: MoveTo 150 141 self)
				(Face gEgo 160 289 self)
			)
			(5 0)
			(6
				(gypsy setMotion: MoveTo 256 157 self)
			)
			(7
				(gypsy
					view: 301
					setLoop: 3 1
					cel: 0
					x: 264
					y: 155
					setCycle: End self
				)
			)
			(8
				(SetFlag 39)
				(gypsy dispose:)
				(gEgo addHonor: 200 solvePuzzle: 515 6 4 normalize: 2)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOutMainDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gCurRoom leaveRoom:)
				(= cycles 1)
			)
			(1
				(mainDoor setCycle: End self)
			)
			(2
				(gLongSong2 number: 960 loop: 1 play:)
				(gEgo setMotion: MoveTo 335 184 self)
			)
			(3
				(gGlory handsOn:)
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sOutWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 70)
				(= local1 (gEgo cycleSpeed:))
				(gEgo
					view: 352
					loop: 0
					cel: 0
					x: 270
					y: 155
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(1
				(gEgo cycleSpeed: local1)
				(gGlory handsOn:)
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sGetShield of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 15 6 34 0 self) ; "That is the sword of my grandfather, Piotyr. I do not know how I can tell, but somehow I am sure of it. He was supposed to have deserted my grandmother. This means Piotyr did not run off. He was killed instead."
			)
			(1
				(shield setCel: 1)
				(SetFlag 43)
				(gEgo addHonor: 250)
				(gEgo solvePuzzle: 529 15 8)
				((gInventory at: 18) state: 1) ; theShield
				((burgoMeister actions:) dispose:)
				((gEgo actions:) dispose:)
				(= cycles 2)
			)
			(2
				(heroTeller init: gEgo 300 25 128 24)
				(burgoTeller init: burgoMeister 300 25 131 24)
				(= cycles 2)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBurgoIncidental of Script
	(properties)

	(method (doit)
		(if (and (gEgo mover:) (!= state 4) (!= state 0))
			(cond
				((< (gEgo x:) 48)
					(burgoMeister setCel: 0)
				)
				((< (gEgo x:) 115)
					(burgoMeister setCel: 1)
				)
				(else
					(burgoMeister setCel: 2)
				)
			)
			(= state 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= seconds 3)
			)
			(1
				1
				(burgoMeister setLoop: 1 1)
				(= seconds (Random 2 8))
			)
			(2
				2
				(burgoMeister
					setCel:
						(if (== (burgoMeister cel:) 3)
							0
						else
							(+ (burgoMeister cel:) 1)
						)
				)
				(if (== (++ local2) 35)
					(= state 3)
				)
				(= cycles 1)
			)
			(3
				3
				(self changeState: 0)
			)
			(4
				4
				(= local2 (= state 0))
				(burgoMeister setLoop: 2 1 setCycle: End self)
			)
		)
	)
)

(instance sCaughtByBurgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(EgoDead 114 0 0 0 912)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				34 ; Tell About Sword
				(and
					(not (IsFlag 43))
					(gEgo has: 19) ; theSword
					(== ((gInventory at: 19) state:) 3) ; theSword
				)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(34 ; Tell About Sword
				(self clean:)
				(gCurRoom setScript: sGetShield)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance bedroomTeller of Teller
	(properties
		actionVerb 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: burgoMeister)
					(gMessager say: 1 4 112) ; "That's a bad idea with the Burgomeister standing so close!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(11 ; Open Door
				(if (OneOf local0 4 5 6)
					(EgoDead 54 300 970 1) ; "The prisoner was behind the OTHER door! This one led to the Burgomeister's bedroom. In the morning, you and the gypsy are both burned at the stake."
				else
					(EgoDead 111 300 970 1) ; "Of all the buildings in all the little towns, you had to pick this one to rob. Choose your victims more carefully next time; the Burgomeister was not at all pleased when you woke him up."
				)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance myDist of DistObj
	(properties)

	(method (doVerb theVerb)
		(switch (super doVerb: theVerb)
			(gypsy
				(heroTeller verb: 140)
				(heroTeller doVerb: theVerb)
			)
			(else
				(heroTeller verb: 182)
				(heroTeller doVerb: theVerb)
			)
		)
	)
)

(instance burgoTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 65 0)) ; burgoTalker
	)

	(method (showCases)
		(super
			showCases:
				55 ; Adventurers' Guild
				(and (OneOf local0 2 3) (not (IsFlag 183)))
				56 ; Adventurers' Guild
				(and (OneOf local0 2 3) (IsFlag 183))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(55 ; Adventurers' Guild
				(gEgo get: 61) ; guild-key
				(SetFlag 183)
			)
		)
		(super sayMessage: &rest)
	)
)

(instance gypsyTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 92 0)) ; gypsyTalker
	)
)

(instance gypsy of Actor
	(properties
		noun 12
		approachX 153
		approachY 124
		x 115
		y 122
		z 50
		fixPriority 1
		view 300
		loop 1
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(gypsyTeller
			init:
				self
				300
				25
				139
				(switch local0
					(4 19)
					(5 20)
					(6 13)
				)
		)
	)

	(method (doVerb theVerb)
		(cellDoor doVerb: theVerb &rest)
	)
)

(instance openDoor of View
	(properties
		approachX 153
		approachY 124
		x 119
		y 118
		z 50
		priority 1
		fixPriority 1
		view 300
		signal 16384
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: 6 1 9) ; "The cell door remains open."
			)
			((== theVerb 4) ; Do
				(gMessager say: 6 4 9) ; "The cell door is already open."
			)
			((== theVerb 29) ; theKeyRing
				(if (gEgo has: 63) ; large-key
					(gMessager say: 6 29 9) ; "The cell door is already unlocked."
				else
					(gMessager say: 6 29 8) ; "None of your keys fits the lock in the cell door."
				)
			)
			((OneOf theVerb 42 28) ; theToolkit, theLockpick
				(gMessager say: 6 4 9) ; "The cell door is already open."
			)
			((== theVerb 80) ; openSpell
				(gMessager say: 6 80 9) ; "The cell door is already unlocked."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shield of View
	(properties
		noun 2
		sightAngle 180
		x 71
		y 87
		view 300
		loop 4
		signal 16384
	)
)

(instance burgoMeister of Prop
	(properties
		noun 15
		x 248
		y 161
		view 301
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 32)
			(self setPri: 130)
		else
			(self setPri: 161)
		)
		(burgoTeller
			init:
				burgoMeister
				300
				25
				131
				(switch local0
					(1 16)
					(2 17)
					(4 19)
					(3 18)
					(5 20)
					(7 21)
					(9 23)
					(else 22)
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36 ; theSword
				(if (and (not (IsFlag 43)) (== ((gInventory at: 19) state:) 3)) ; theSword
					(gCurRoom setScript: sGetShield)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mainDoor of Prop
	(properties
		noun 10
		nsLeft 293
		nsTop 71
		nsRight 319
		nsBottom 187
		sightAngle 180
		approachX 279
		approachY 184
		x 305
		y 90
		priority 53
		fixPriority 1
		view 300
		loop 5
		cel 4
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(if (gCast contains: burgoMeister)
			(= heading
				(((ScriptID 49 0) new:) ; doorMat
					init:
						((Polygon new:)
							type: PNearestAccess
							init: 316 175 316 189 306 189 292 175
							yourself:
						)
						6
						0
						4
						sOutMainDoor
					yourself:
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sOutMainDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance bedroomDoor of Feature
	(properties
		noun 1
		nsLeft 5
		nsTop 67
		nsRight 30
		nsBottom 125
		sightAngle 180
		x 17
		y 96
	)

	(method (init)
		(super init: &rest)
		(bedroomTeller init: self 300 25 137 1)
	)
)

(instance chair of Feature
	(properties
		noun 3
		nsLeft 54
		nsTop 88
		nsRight 70
		nsBottom 141
		sightAngle 180
		x 62
		y 114
	)
)

(instance desk of Feature
	(properties
		noun 4
		nsLeft 72
		nsTop 114
		nsRight 128
		nsBottom 152
		sightAngle 180
		approachX 90
		approachY 139
		x 100
		y 150
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if (gCast contains: burgoMeister)
					(super doVerb: theVerb &rest)
				else
					(gMessager say: 11 6 59) ; "The desk is locked."
				)
			)
			((OneOf theVerb 28 42) ; theLockpick, theToolkit
				(cond
					((gCast contains: burgoMeister)
						(gMessager say: 4 4 0) ; "The Burgomeister is watching you."
					)
					((IsFlag 71)
						(gMessager say: 4 42 3) ; "The desk is empty. For some reason, the Burgomeister doesn't seem to think it's secure anymore."
					)
					((== (gEgo trySkill: 9 275) 1) ; pick locks
						(gEgo get: 63 get: 0 7 addHonor: -100) ; large-key, thePurse
						(+= global395 15)
						(SetFlag 71)
						(if (== local0 6)
							(gMessager say: 4 42 5) ; "Jackpot! You open the drawer and find a large key, 7 Crowns, and 15 Kopeks. You put the key on your key ring and the money in your coin purse."
						else
							(SetFlag 10)
							(gMessager say: 4 42 4) ; "Jackpot! You open the drawer and find a large key, 7 Crowns, and 15 Kopeks. You put the key on your key ring and the money in your coin purse."
						)
					)
					(else
						(gMessager say: 4 42 2) ; "This is a tough lock! You need more practice."
					)
				)
			)
			((== theVerb 80) ; openSpell
				(cond
					((gCast contains: burgoMeister)
						(gMessager say: 4 4 0) ; "The Burgomeister is watching you."
					)
					((IsFlag 71)
						(gMessager say: 4 42 3) ; "The desk is empty. For some reason, the Burgomeister doesn't seem to think it's secure anymore."
					)
					((gEgo castSpell: 20)
						(= global441 85)
						(= global442 120)
						(gCurRoom setScript: (ScriptID 13 0) 0 self) ; castOpenScript
					)
				)
			)
			((== theVerb -80) ; openSpell (part 2)
				(gCurRoom setScript: 0)
				(gGlory handsOn:)
				(gEgo get: 63 get: 0 7 addHonor: -100) ; large-key, thePurse
				(+= global395 15)
				(SetFlag 71)
				(if (== local0 6)
					(gMessager say: 4 42 5) ; "Jackpot! You open the drawer and find a large key, 7 Crowns, and 15 Kopeks. You put the key on your key ring and the money in your coin purse."
				else
					(SetFlag 10)
					(gMessager say: 4 42 4) ; "Jackpot! You open the drawer and find a large key, 7 Crowns, and 15 Kopeks. You put the key on your key ring and the money in your coin purse."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cellDoor of Feature
	(properties
		noun 6
		nsLeft 116
		nsTop 71
		nsRight 166
		nsBottom 129
		sightAngle 180
		approachX 153
		approachY 124
		x 141
		y 100
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 28 42) ; theLockpick, theToolkit
				(if (== (gEgo trySkill: 9 300) 1) ; pick locks
					(if (== local0 6)
						(gCurRoom setScript: sLetGypsyOut)
					else
						(gMessager say: 6 4 113) ; "You have no reason to open the cell door at the moment."
					)
				else
					(gMessager say: 4 42 2) ; "This is a tough lock! You need more practice."
				)
			)
			((== theVerb 29) ; theKeyRing
				(if (gEgo has: 63) ; large-key
					(if (== local0 6)
						(gMessager say: 6 29 10) ; "Using the key you found in the Burgomeister's desk, you unlock the cell door."
						(gCurRoom setScript: sLetGypsyOut)
					else
						(gMessager say: 6 4 113) ; "You have no reason to open the cell door at the moment."
					)
				else
					(gMessager say: 6 29 8) ; "None of your keys fits the lock in the cell door."
				)
			)
			((== theVerb 80) ; openSpell
				(if (gEgo castSpell: 20)
					(= global441 121)
					(= global442 96)
					(gCurRoom setScript: (ScriptID 13 0) 0 self) ; castOpenScript
				)
			)
			((== theVerb -80) ; openSpell (part 2)
				(if (== local0 6)
					(gMessager say: 6 80 10) ; "Your Open spell unlocks the cell door."
					(gCurRoom setScript: sLetGypsyOut)
				else
					(gMessager say: 6 4 113) ; "You have no reason to open the cell door at the moment."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		noun 7
		nsTop 123
		nsRight 29
		nsBottom 143
		sightAngle 180
		x 14
		y 133
	)
)

(instance spears of Feature
	(properties
		noun 8
		nsLeft 188
		nsTop 58
		nsRight 233
		nsBottom 131
		sightAngle 180
		approachX 213
		approachY 136
		x 210
		y 94
	)
)

(instance burgoWindow of Feature
	(properties
		noun 9
		nsLeft 261
		nsTop 76
		nsRight 285
		nsBottom 141
		sightAngle 180
		approachX 267
		approachY 155
		x 273
		y 108
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCast contains: burgoMeister)
					(gMessager say: 11 6 58) ; "Climbing out the window right now would make you look a little foolish. Try using the door."
				else
					(gCurRoom setScript: sOutWin)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

