;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm340 of GloryRm
	(properties
		picture 340
	)

	(method (init)
		(= local3
			(cond
				((not (IsFlag 306)) 1)
				((not (IsFlag 254)) 2)
				((not (IsFlag 307)) 3)
				((not (IsFlag 244)) 4)
				((IsFlag 244) 5)
				(else 0)
			)
		)
		(gEgo
			init:
			normalize:
			setScale: 0
			setPri: 130
			view: 341
			setLoop: 5
			cel: 6
			x: 40
			y: 136
		)
		(gLongSong number: 340 setLoop: -1 play:)
		(if (and (not (IsFlag 244)) (OneOf local3 3 4))
			(chiefThief init: setPri: 53 approachVerbs: 4 2 37 36 66) ; Do, Talk, theThrowdagger, theSword, theStatue
		)
		(if (== local3 3)
			(chiefThief posn: 307 117 setCycle: Fwd)
		)
		(if (IsFlag 241)
			(book init: approachVerbs: 4 1) ; Do, Look
		)
		(leftDoor
			init:
			x: (if (IsFlag 243) 17 else 48)
			setPri: 20
			approachVerbs: 4 41 ; Do, theGuildcard
		)
		(rightDoor
			init:
			x: (if (IsFlag 243) 109 else 83)
			setPri: 20
			approachVerbs: 4 41 ; Do, theGuildcard
		)
		(torch1 init: setPri: 55 setCycle: Fwd)
		(torch2 init: setPri: 55 setCycle: Fwd)
		(barrel init: setPri: 120 setLoop: 2 1 approachVerbs: 4) ; Do
		(if (IsFlag 254)
			(secretPassage init: approachVerbs: 4) ; Do
		else
			(secretDoor init: setPri: 64)
		)
		(frame1 init: approachVerbs: 4 42 28) ; Do, theToolkit, theLockpick
		(frame2 init: setPri: 127 approachVerbs: 4 42 28) ; Do, theToolkit, theLockpick
		(mainFrame init: setPri: 120 approachVerbs: 4) ; Do
		(if (== local3 2)
			(= local7
				(cond
					((not (IsFlag 243)) 1)
					((not (IsFlag 242)) 2)
					((not (IsFlag 248)) 3)
					((not (IsFlag 512)) 4)
					((not (IsFlag 513)) 5)
					(else 0)
				)
			)
			(note init: setPri: 121 approachVerbs: 4) ; Do
		)
		(chair init: approachVerbs: 4) ; Do
		(desk init: approachVerbs: 4 28) ; Do, theLockpick
		(safe init: approachVerbs: 4) ; Do
		(stone init: approachVerbs: 4 1) ; Do, Look
		(ladder init: approachVerbs: 4) ; Do
		(sconce1 init: approachVerbs: 4) ; Do
		(sconce2 init: approachVerbs: 4) ; Do
		(bookshelf init: approachVerbs: 4 1) ; Do, Look
		(floorGrate init: approachVerbs: 4) ; Do
		(drain init: approachVerbs: 4) ; Do
		(steps1 init: approachVerbs: 4) ; Do
		(steps2 init: approachVerbs: 4) ; Do
		(barrels1 init: approachVerbs: 4) ; Do
		(barrels2 init: approachVerbs: 4) ; Do
		(crack1 init: approachVerbs: 4) ; Do
		(crack2 init: approachVerbs: 4) ; Do
		(pillar init: approachVerbs: 4) ; Do
		(gTheDoits add: steps1)
		(gTheDoits add: steps2)
		(cond
			((not (IsFlag 243))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 117 134 69 134 69 137 38 137 26 149 65 149 65 171 199 157 225 176 208 183 208 189 319 189 319 163 282 153 260 158 238 154 280 131 314 137 314 128 273 128 249 124 249 122 227 122 260 128 223 153 211 148 211 136 192 130 117 130
							yourself:
						)
				)
			)
			((not (IsFlag 254))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 117 134 91 134 91 112 95 112 95 110 88 110 88 103 52 103 52 112 69 112 69 137 38 137 26 149 65 149 65 171 206 156 227 177 208 183 208 189 319 189 319 163 282 153 260 158 238 154 280 131 314 137 314 128 273 128 249 124 249 122 227 122 260 128 223 153 211 148 211 136 192 130 117 130
							yourself:
						)
				)
			)
			(else
				(secritExit init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 117 134 91 134 91 112 95 112 95 110 88 110 88 103 52 103 52 112 69 112 69 137 38 137 26 149 65 149 65 171 206 156 227 177 208 183 208 189 319 189 319 163 282 153 260 158 238 154 280 131 314 137 314 128 273 128 273 124 319 124 319 122 227 122 260 128 223 153 211 148 211 136 192 130 117 130
							yourself:
						)
				)
			)
		)
		(super init: &rest)
		(if (OneOf local3 3 4)
			(heroTeller
				init:
					gEgo
					340
					35
					128
					(switch local3
						(3 33)
						(4 34)
					)
			)
		)
		(self setScript: sEnterScr)
		(gGlory save: 1)
	)

	(method (notify)
		(gMessager say: 0 8 0) ; "Use of magic is strictly forbidden in Thieves' Guildhalls, as you know. It's considered to be bad form and to interfere with the mental and physical training process of building your skills."
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(gTheDoits delete: steps1)
		(gTheDoits delete: steps2)
		(DisposeScript 341)
		(super dispose: &rest)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local4 (gEgo cycleSpeed:))
				(gEgo cycleSpeed: 9 setCycle: Beg self)
			)
			(1
				(gEgo
					x: 43
					y: 137
					normalize: 1
					cycleSpeed: local4
					setScaler: Scaler 135 77 189 103
					setHeading: 90 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 68 144 self)
			)
			(3
				(if (== local3 1)
					(SetFlag 306)
					(gEgo solvePuzzle: 508 6 4)
					(SetFlag 508)
				)
				(= cycles 1)
			)
			(4
				(if (== local3 1)
					(gMessager say: 32 6 62 0 self) ; "You climb down the ladder into a seedy-looking room. A massive door blocks off a smaller room in the rear. This isn't as dusty as the Adventurers' Guild, and the torches look recently lit."
				else
					(= cycles 1)
				)
			)
			(5
				(if (and (== gHeroType 3) (== local3 1)) ; Paladin
					(gMessager say: 32 6 61 0 self) ; "Behind the innocent-looking surface of this room lies great danger. You sense that traps for the unwary are everywhere!"
				else
					(= cycles 1)
				)
			)
			(6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoorSlide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					view: 31
					loop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(if (== (leftDoor x:) 17)
					(ClearFlag 243)
					(= local0 48)
					(= local1 83)
				else
					(SetFlag 243)
					(= local0 17)
					(= local1 109)
				)
				(leftDoor setLoop: setCel: 0 setMotion: MoveTo local0 120 self)
				(rightDoor setLoop: setCel: 1 setMotion: MoveTo local1 120 self)
				(gEgo setCycle: Beg self)
			)
			(2 0)
			(3 0)
			(4
				(gEgo cycleSpeed: local4 normalize: 7)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 117 134 91 134 91 112 95 112 95 110 88 110 88 103 52 103 52 112 69 112 69 137 38 137 26 149 65 149 65 171 206 156 227 177 208 183 208 189 319 189 319 163 282 153 260 158 238 154 280 131 314 137 314 128 273 128 249 124 249 122 227 122 260 128 223 153 211 148 211 136 192 130 117 130
							yourself:
						)
				)
				(= cycles 2)
			)
			(5
				(gMessager say: 39 41 110 0 self) ; "You slip the guild membership card between the doors, and unlatch the lock. Your Guildcard, don't leave home without it!"
			)
			(6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetOffStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(cond
					(register
						(if (OneOf (gEgo loop:) 7 3 6 0)
							(gEgo setMotion: MoveTo 270 129 self)
						else
							(gEgo setMotion: MoveTo 231 154 self)
						)
					)
					((and (OneOf (gEgo loop:) 6 3 7 1) (IsFlag 509))
						(gEgo setMotion: MoveTo 79 111 self)
					)
					(else
						(gEgo setMotion: MoveTo 80 136 self)
					)
				)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setHeading: 310 self)
			)
			(1
				(gMessager say: 12 28 25 0 self) ; "Ah, that did it! The lock springs open with a satisfying "Snick!""
			)
			(2
				(drawer init: setPri: 174 setCycle: End self)
			)
			(3
				(if (IsFlag 247)
					(= cycles 1)
				else
					(self setScript: sPoisonTrap self)
				)
			)
			(4
				(book init: approachVerbs: 4 1) ; Do, Look
				(= local6 1)
				(SetFlag 241)
				(gEgo
					solvePuzzle: 512 2 4
					get: 24 ; theToolkit
					get: 5 3 ; theThrowdagger
					drop: 13 ; theLockpick
					useSkill: 9 400 ; pick locks
				)
				(SetFlag 512)
				(gMessager say: 12 28 24 0 self) ; "Inside the desk you find a complete (and hardly used) Mark II Thieves' Toolkit. It has all the latest facilities for opening the toughest locks, cracking safes, and disarming mechanical traps. There is one lockpick missing from the set, so you add yours to it."
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPoisonTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gasTrap init: setPri: 200 setCycle: End self)
			)
			(1
				(SetFlag 14)
				(+= global479 20)
				(gasTrap loop: 2 setCycle: End self)
			)
			(2
				(gMessager say: 32 6 106 0 self) ; "Maybe you should have tried disarming the trap on the desk first... you set off a poison trap!"
			)
			(3
				(if (gEgo takeDamage: 30)
					(gasTrap hide:)
					(= cycles 1)
				else
					(EgoDead 3 0 974 1 912)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sBarrelMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(if (and (== (barrel x:) 116) (not (IsFlag 254)))
					(self changeState: 6)
				else
					(= cycles 1)
				)
			)
			(1
				1
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					view: 4
					loop: (if register 1 else 0)
					cel: 0
					x: 153
					y: 130
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(2
				2
				(if register
					(gMessager say: 6 4 18 0 self) ; "You slide the barrel back into place covering the lock mechanism."
				else
					(gMessager say: 6 4 19 0 self) ; "You depress the barrel tap, but nothing comes out. Instead, the barrel slides across the wall to reveal some sort of mechanism."
				)
			)
			(3
				3
				(barrel setLoop:)
				(if register
					(barrel setMotion: MoveTo 132 148 self)
				else
					(barrel setMotion: MoveTo 116 148 self)
				)
			)
			(4
				4
				(gEgo setCycle: Beg self)
			)
			(5
				5
				(gEgo
					normalize:
					cycleSpeed: local4
					posn: (if register 149 else 159) 131
				)
				(if register
					(= state 11)
				)
				(= cycles 1)
			)
			(6
				6
				(gMessager say: 28 6 14 0 self) ; "This is a door unlocking mechanism. To operate it, push each of the tiles until all nine tiles have been set to the correct pattern to open the door."
			)
			(7
				7
				(gGlory handsOn:)
				(if ((ScriptID 341 0) init: show: dispose:) ; barrelPuz
					(= cycles 1)
				else
					(self changeState: 12)
				)
			)
			(8
				8
				(gGlory handsOff:)
				(SetFlag 254)
				(gEgo solvePuzzle: 513 2 4)
				(SetFlag 513)
				(chiefThief
					init:
					setPri: 53
					setLoop: 0 1
					setCycle: Fwd
					approachVerbs: 4 2 37 36 66 ; Do, Talk, theThrowdagger, theSword, theStatue
				)
				(heroTeller init: gEgo 340 35 128 1)
				(secretDoor setMotion: MoveTo 236 52 self)
			)
			(9
				9
				(secretDoor setMotion: MoveTo 294 60 self)
			)
			(10
				10
				(secretDoor dispose:)
				(secretPassage init:)
				(chiefThief setMotion: MoveTo 307 117 self)
			)
			(11
				11
				(gMessager say: 10 6 21 0 self) ; "So... You found my secret passageway. You must excuse me... I am not quite myself any more. Heh, heh, heh."
			)
			(12
				12
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDisarmTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(ClearFlag 182)
				(if (== (CueObj client:) frame1)
					(gMessager say: 35 175 50 0 self) ; "You set up the Thieves' toolkit and try to disarm any traps that may be on the safe."
				else
					(gMessager say: 35 175 50 0 self) ; "You set up the Thieves' toolkit and try to disarm any traps that may be on the safe."
				)
			)
			(1
				1
				(gGlory handsOn:)
				(if ((ScriptID 648 0) init: show: dispose:) ; ticTacPuz
					(DisposeScript 648)
					(if (== (CueObj client:) frame1)
						(SetFlag 308)
					else
						(SetFlag 309)
					)
					(= state 3)
					(gMessager say: 32 6 108 0 self) ; "You have successfully disarmed the safe!"
				else
					(DisposeScript 648)
					(if (IsFlag 182)
						(explosion init: setPri: 128 setCycle: End self)
					else
						(self changeState: 4)
					)
				)
			)
			(2
				2
				(gGlory handsOff:)
				(explosion dispose:)
				(gMessager say: 16 4 3 0 self) ; "You set off a spike trap on the safe! Ouch! You're not sure whether it's safe now or if the trap has rearmed itself."
			)
			(3
				3
				(if (gEgo takeDamage: 5)
					(= cycles 1)
				else
					(EgoDead 3 0 974 1 912)
				)
			)
			(4
				4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(if
					(or
						(and (== (CueObj client:) frame1) (IsFlag 308))
						(and (== (CueObj client:) frame2) (IsFlag 309))
					)
					(self changeState: 3)
				else
					(explosion init: setPri: 128 setCycle: End self)
				)
			)
			(1
				1
				(explosion dispose:)
				(gMessager say: 16 4 3 0 self) ; "You set off a spike trap on the safe! Ouch! You're not sure whether it's safe now or if the trap has rearmed itself."
			)
			(2
				2
				(if (not (gEgo takeDamage: 30))
					(EgoDead 3 0 974 1 912)
				else
					(= cycles 1)
				)
			)
			(3
				3
				(if (== (CueObj client:) frame1)
					(SetFlag 366)
					(+= global154 6)
					(gEgo get: 5 get: 2 useSkill: 250) ; theThrowdagger, theCures, ???
					(gMessager say: 16 42 25 0 self) ; "Using the Mark II Toolkit, you quickly manage to get the safe open. Inside you find six Crowns, a throwing dagger, and a potion labelled "Poison Cure." They seem a fitting reward for your efforts, so you take them."
				else
					(+= global154 5)
					(SetFlag 367)
					(gEgo get: 5 get: 3 useSkill: 250) ; theThrowdagger, theHeals, ???
					(gMessager say: 17 42 25 0 self) ; "You crack the safe using the Mark II Toolkit. You take the Healing Potion, throwing dagger, and five Crowns someone was foolish enough to leave inside."
				)
			)
			(4
				4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== register 3)
					(gEgo setMotion: PolyPath 63 103 self)
				else
					(= cycles 1)
				)
			)
			(1
				(switch register
					(1
						(= cycles 1)
					)
					(2
						(gMessager say: 22 4 45 0 self) ; "You don't see any way to open the safe. It looks as though the knob is missing."
					)
					(3
						(gEgo use: 46) ; theKnob
						(SetFlag 240)
						(gMessager say: 22 1 47 0 self) ; "Now that you've replaced the safe knob, the Filch Safe looks ripe for the cracking (y'know, kind of like a walnut)."
					)
				)
			)
			(2
				(gGlory handsOn:)
				(self setScript: (ScriptID 89 0) self) ; safePuz
			)
			(3
				(gGlory handsOff:)
				(if (IsFlag 248)
					(gEgo get: 5 5 get: 13 useSkill: 400) ; theThrowdagger, theLockpick, ???
					(gMessager say: 22 4 46 0 self) ; "You quickly rifle the opened safe. Unfortunately, it looks as though legions of Thieves' Guild initiates have been here before you as all of the money is gone."
				else
					(= cycles 2)
				)
			)
			(4
				(DisposeScript 89)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChangeThief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gEgo actions:) dispose:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				((chiefThief actions:) dispose:)
				(chiefThief x: 284 y: 117 setLoop: 2 1 setCycle: End self)
			)
			(1
				(chiefThief view: 345 loop: 0 cel: 0 posn: 280 119)
				(secritExit init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 117 134 91 134 91 112 95 112 95 110 88 110 88 103 52 103 52 112 69 112 69 137 38 137 26 149 65 149 65 171 206 156 227 177 208 183 208 189 319 189 319 163 282 153 260 158 238 154 280 131 314 137 314 128 273 128 273 124 319 124 319 122 227 122 260 128 223 153 211 148 211 136 192 130 117 130
							yourself:
						)
				)
				(heroTeller init: gEgo 340 35 128 5)
				(chiefTeller init: chiefThief 340 35 174 34)
				(gEgo use: 43 solvePuzzle: 514 2 4) ; theStatue
				(SetFlag 514)
				(SetFlag 307)
				(= cycles 2)
			)
			(2
				(gMessager say: 10 6 15 0 self) ; "Wonderful! Wonderful! I won't have to scuttle in shadows all the time. I won't have to have unsavory eating practices. Thank you, thank you so very much."
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClawEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(chiefThief setLoop: 1 1 setCycle: End self)
			)
			(1
				(gEgo view: 43 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(EgoDead 1 0 960 1 912)
			)
		)
	)
)

(instance sKillChief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 244)
				(= [gEgoStats 14] 0) ; honor
				(if (gEgo actions:)
					((gEgo actions:) dispose:)
				)
				(if (chiefThief actions:)
					((chiefThief actions:) dispose:)
				)
				(chiefThief setLoop: 1 1 setCycle: End self)
			)
			(1
				(gMessager say: 32 6 64 0 self) ; "It's been said that there's no honor among thieves. Well, you've certainly proven that true in your own case. The Chief Thief, recently recovered from his shapechanging ordeal, dies instantly beneath your onslaught."
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetKnob of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 4 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(2
				(if
					(or
						(gEgo has: 46) ; theKnob
						(IsFlag 240)
						((gInventory at: 46) chestAmout:) ; theKnob
					)
					(gMessager say: 15 4 27 0 self) ; "That's about it for the floor grate; you don't find anything else interesting there."
				else
					(gEgo get: 46) ; theKnob
					(gMessager say: 15 4 28 0 self) ; "Rummaging around under the floor drain, you find a round knob with a point on one side, which you pick up. (Thieves have had to clean up after themselves since a few unfortunate accidents with maintenance personnel.)"
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookMark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(= cycles 1)
				else
					(gEgo setHeading: 90 self)
				)
			)
			(1
				(if register
					(= cycles 1)
				else
					(gEgo
						view: 4
						setLoop: (if register 1 else 0) 1
						cel: 0
						setCycle: End self
					)
				)
			)
			(2
				(if register
					(= cycles 1)
				else
					(gMessager say: 14 4 0 0 self) ; "On close examination, you find some scratches that might be Thief Marks behind the side drain."
				)
			)
			(3
				(= register
					(if register
						(safeMark
							init:
							posn: 59 90
							moveSpeed: 0
							setStep: 16 16
							setLoop: 0 1
							setPri: 196
							setScaler: Scaler 5 100 90 3
							setMotion: MoveTo 16 77 self
							yourself:
						)
					else
						(grateMark
							init:
							posn: 302 142
							moveSpeed: 0
							setStep: 16 16
							setLoop: 1 1
							setPri: 196
							setScaler: Scaler 5 100 143 7
							setMotion: MoveTo 62 7 self
							yourself:
						)
					)
				)
			)
			(4
				(if (== register safeMark)
					(safeMark setMotion: MoveTo 128 3 self)
				else
					(= cycles 1)
				)
			)
			(5
				(gKeyDownHandler addToFront: register)
				(gMouseDownHandler addToFront: register)
				(gGlory handsOn:)
				(SetFlag 50)
			)
			(6
				(gMouseDownHandler delete: register)
				(gKeyDownHandler delete: register)
				(ClearFlag 50)
				(gGlory handsOff:)
				(if (== register safeMark)
					(safeMark setMotion: MoveTo 16 77 self)
				else
					(grateMark setMotion: MoveTo 302 142 self)
				)
			)
			(7
				(if (== register safeMark)
					(safeMark setMotion: MoveTo 59 90 self)
				else
					(= cycles 1)
				)
			)
			(8
				(register dispose:)
				(if (== register safeMark)
					(= cycles 1)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(9
				(= register 0)
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					view: 341
					setLoop: 5 1
					cel: 0
					x: 40
					y: 136
					cycleSpeed: 9
					setPri: 130
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(gEgo cycleSpeed: local4)
				(gGlory handsOn:)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance sGetCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					view: 31
					loop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(gEgo get: 23 solvePuzzle: 509 2 4) ; theGuildcard
				(SetFlag 509)
				(mainFrame setCel: 1)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo cycleSpeed: local4 normalize: 7)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance posterTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				33 ; Read Note
				(== local7 1)
				41 ; Read Note
				(== local7 2)
				38 ; Read Note
				(== local7 3)
				35 ; Read Note
				(== local7 4)
				34 ; Read Note
				(== local7 5)
				40 ; Take Guild Card
				(not (IsFlag 509))
		)
	)

	(method (sayMessage)
		(if (== iconValue 40) ; Take Guild Card
			(self clean:)
			(gCurRoom setScript: sGetCard)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance deskTeller of Teller
	(properties
		actionVerb 4
	)

	(method (doVerb theVerb)
		(if (IsFlag 241)
			(client doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)

	(method (showCases)
		(super
			showCases:
				75 ; Search for Traps
				(and (not (IsFlag 247)) (not (IsFlag 241)) (IsFlag 242))
				76 ; Pick Lock
				(and (not (IsFlag 241)) (gEgo has: 13)) ; theLockpick
		)
	)

	(method (sayMessage)
		(switch iconValue
			(76 ; Pick Lock
				(self clean:)
				(gCurRoom setScript: sOpenDesk)
			)
			(75 ; Search for Traps
				(SetFlag 247)
				(super sayMessage: &rest) ; You've found a particularly diabolical poison gas trap. Fortunately, it's just like one of those described in the book on traps, so you are able to disarm it.
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance safeTeller of Teller
	(properties
		actionVerb 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== ((CueObj client:) cel:) 0)
					((CueObj client:) setCel: 1)
					(gMessager say: 40 4 37) ; "Ah, you found a hidden safe. Good work."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (showCases)
		(super
			showCases:
				50 ; Disarm Trap
				(and
					(IsFlag 242)
					(gEgo has: 24) ; theToolkit
					(or
						(and
							(== (CueObj client:) frame1)
							(not (IsFlag 308))
							(not (IsFlag 366))
						)
						(and
							(== (CueObj client:) frame2)
							(not (IsFlag 309))
							(not (IsFlag 367))
						)
					)
				)
				49 ; Crack Safe
				(and
					(gEgo has: 24) ; theToolkit
					(or
						(== (CueObj client:) frame1)
						(== (CueObj client:) frame2)
					)
				)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(50 ; Disarm Trap
				(self clean:)
				(gCurRoom setScript: sDisarmTrap)
			)
			(49 ; Crack Safe
				(self clean:)
				(if
					(or
						(and (IsFlag 366) (== (CueObj client:) frame1))
						(and (IsFlag 367) (== (CueObj client:) frame2))
					)
					(gEgo useSkill: 9 100) ; pick locks
					(gMessager say: 16 4 27) ; "You've already cracked this one. There's nothing else in it."
				else
					(gCurRoom setScript: sOpenSafe)
				)
			)
			(78 ; Cover Safe
				(self clean:)
				((CueObj client:) setCel: 0)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance chiefTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 103 0)) ; chiefTalker
	)

	(method (clean)
		(super clean:)
		(if (not (IsFlag 307))
			((ScriptID 103 1) dispose:) ; chiefAntennae
		)
	)
)

(instance heroTeller of Teller
	(properties)

	(method (showCases)
		(super showCases: 100 (IsFlag 389) 101 (IsFlag 71)) ; Tell About Old Man's House, Burgomeister's Office
	)
)

(instance secretDoor of Actor
	(properties
		sightAngle 180
		x 232
		y 54
		view 343
		signal 16385
		xStep 2
	)
)

(instance barrel of Actor
	(properties
		noun 6
		approachX 159
		approachY 131
		x 132
		y 148
		z 50
		view 340
		loop 2
		signal 16385
		moveSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 254)
						(gMessager say: 6 4 27) ; "You don't need to do anything else with the barrel. Don't bungle the job!"
					)
					((IsFlag 241)
						(if (== x 116)
							(gCurRoom setScript: sBarrelMove 0 1)
						else
							(gCurRoom setScript: sBarrelMove 0 0)
						)
					)
					(else
						(gMessager say: 6 4 104) ; "There does seem to be something under this barrel, but you've got no clue of what to do with it."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftDoor of Actor
	(properties
		noun 39
		sightAngle 180
		approachX 105
		approachY 136
		x 48
		y 120
		z 70
		view 340
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 243)
					(gMessager say: 39 1 19) ; "These open doors allow you to pass into and out of the alcove without running into a wooden panel."
				else
					(gMessager say: 39 1 109) ; "The double doors are, of course, locked. This IS a Thieves' Guild, after all!"
				)
			)
			(4 ; Do
				(if (IsFlag 243)
					(gMessager say: 39 4 19) ; "Don't close the doors; you may need to go back into the alcove."
				else
					(gMessager say: 39 4 109) ; "The double doors are locked shut. The lock itself looks sophisticated, but the door has a simple sliding latch. If you had the right tool, you think you could easily slip the latch."
				)
			)
			(41 ; theGuildcard
				(gCurRoom setScript: sDoorSlide)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightDoor of Actor
	(properties
		noun 39
		sightAngle 180
		approachX 105
		approachY 136
		x 83
		y 120
		z 70
		view 340
		cel 1
		signal 16385
	)

	(method (doVerb theVerb)
		(leftDoor doVerb: theVerb &rest)
	)
)

(instance grateMark of Actor
	(properties
		x 62
		y 7
		view 346
		loop 1
		signal 16385
		illegalBits 0
	)

	(method (handleEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON $0020 evKEYBOARD) ; joyUp
			((gCurRoom script:) cue:)
			(event claimed: 1)
			(return 1)
		)
		(return 0)
	)
)

(instance safeMark of Actor
	(properties
		x 128
		y 3
		view 346
		signal 16385
		illegalBits 0
	)

	(method (handleEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON $0020 evKEYBOARD) ; joyUp
			((gCurRoom script:) cue:)
			(event claimed: 1)
			(return 1)
		)
		(return 0)
	)
)

(instance chiefThief of Actor
	(properties
		noun 10
		sightAngle 180
		approachX 258
		approachY 126
		view 347
		signal 16385
	)

	(method (init)
		(if (<= local3 3)
			(= view 347)
			(= x 330)
			(= y 110)
		else
			(= view 345)
			(= x 280)
			(= y 119)
		)
		(super init: &rest)
		(chiefTeller
			init:
				self
				340
				35
				174
				(cond
					((and (<= local3 2) (not (IsFlag 514))) 1)
					((<= local3 2) 5)
					((== local3 3) 33)
					(else 34)
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(cond
					((IsFlag 244)
						(gMessager say: 10 1 113) ; "He doesn't look very active. It may have something to do with the fact that you killed him."
					)
					((IsFlag 514)
						(gMessager say: 10 1 20) ; "This does not look like the type of person your mother would want you hanging around with. Still, it's an improvement over the monster form."
					)
					(else
						(gMessager say: 10 1 8) ; "He looks like a cross between an enormous beetle and an older version of your old buddy, Ugarte."
					)
				)
			)
			((== theVerb 4) ; Do
				(cond
					((IsFlag 244)
						(gMessager say: 10 4 113) ; "You don't earn any guild points for pickpocketing corpses. Stick with the live ones, o.k.?"
					)
					((IsFlag 514)
						(gMessager say: 10 4 20) ; "You reach forward to shake hands with the restored Chief Thief, but he avoids your hand."
					)
					(else
						(gMessager say: 10 4 8) ; "You may have smashed bugs before, but this one would put up a fight!"
					)
				)
			)
			((== theVerb 2) ; Talk
				(if (IsFlag 244)
					(gMessager say: 10 2 113) ; "He must be mad that you murdered him... He's not talking to you at all."
				else
					(super doVerb: theVerb &rest)
				)
			)
			((== theVerb 66) ; theStatue
				(gCurRoom setScript: sChangeThief)
			)
			((OneOf theVerb 37 36) ; theThrowdagger, theSword
				(cond
					((IsFlag 244)
						(super doVerb: theVerb &rest)
					)
					((== view 347)
						(gCurRoom setScript: sClawEgo)
					)
					(else
						(gCurRoom setScript: sKillChief)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frame1 of Prop
	(properties
		noun 16
		sightAngle 180
		x 213
		y 65
		view 340
		loop 3
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(safeTeller init: self 340 35 175)
		(= local5 safeTeller)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28 ; theLockpick
				(if (== ((CueObj client:) cel:) 1)
					(super doVerb: theVerb &rest)
				else
					(super doVerb: 4 &rest)
				)
			)
			(1 ; Look
				(if (== ((CueObj client:) cel:) 1)
					(gMessager say: 40 1 111) ; "You can see a safe hidden behind the picture."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(42 ; theToolkit
				(cond
					((== (CueObj client:) frame1)
						(if (IsFlag 366)
							(gMessager say: 16 42 107) ; "There's nothing left in the safe."
						else
							(if (== ((CueObj client:) cel:) 0)
								((CueObj client:) setCel: 1)
							)
							(self setScript: sOpenSafe)
						)
					)
					((IsFlag 367)
						(gMessager say: 17 42 107) ; "There's nothing left in the safe."
					)
					(else
						(if (== ((CueObj client:) cel:) 0)
							((CueObj client:) setCel: 1)
						)
						(self setScript: sOpenSafe)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frame2 of Prop
	(properties
		noun 17
		sightAngle 180
		approachX 312
		approachY 132
		x 298
		y 69
		view 340
		loop 4
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= actions local5)
	)
)

(instance mainFrame of Prop
	(properties
		noun 20
		approachX 157
		approachY 132
		x 166
		y 99
		view 341
		signal 16385
	)

	(method (init)
		(if (IsFlag 509)
			(= cel 1)
		)
		(super init: &rest)
		(posterTeller init: self 340 35 173)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((and (not (IsFlag 509)) (== local3 2))
						(gMessager say: 20 1 103) ; "This is a Thieves' Guild recruiting poster featuring a sophisticated, worldly Master Thief. Someone has pinned a note to the poster covering the words "Don't Thieve Home Without It!""
					)
					((not (IsFlag 509))
						(gMessager say: 20 1 42) ; "This is a Thieves' Guild recruiting poster featuring a sophisticated, worldly Master Thief."
					)
					((== local3 2)
						(gMessager say: 20 1 43) ; "This is a Thieves' Guild recruiting poster featuring a sophisticated, worldly Master Thief. Someone has pinned a note to the poster covering the words "Don't Thieve Home Without It!""
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance explosion of Prop
	(properties
		view 341
		loop 4
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(if (== (CueObj client:) frame1)
			(= x 217)
			(= y 67)
		else
			(= x 303)
			(= y 77)
		)
	)
)

(instance gasTrap of Prop
	(properties
		x 140
		y 159
		view 344
		loop 1
		signal 16385
	)
)

(instance drawer of Prop
	(properties
		x 193
		y 150
		view 344
		signal 16385
	)
)

(instance torch1 of Prop
	(properties
		noun 26
		x 34
		y 66
		view 340
		loop 1
		signal 16385
	)
)

(instance torch2 of Prop
	(properties
		noun 26
		x 118
		y 67
		view 340
		loop 1
		signal 16385
	)
)

(instance note of View
	(properties
		noun 20
		x 153
		y 60
		view 341
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= actions mainFrame)
	)
)

(instance book of View
	(properties
		noun 36
		approachX 131
		approachY 164
		x 108
		y 241
		z 100
		priority 174
		fixPriority 1
		view 344
		loop 3
		signal 16384
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4) ; Look, Do
			(if (not (IsFlag 239))
				(SetFlag 239)
			)
			(gMessager say: 36 1 0) ; "You leaf through the Chief Thief's Log Book."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chair of Feature
	(properties
		noun 9
		nsLeft 150
		nsTop 137
		nsRight 178
		nsBottom 187
		sightAngle 180
		x 164
		y 162
	)
)

(instance desk of Feature
	(properties
		noun 12
		nsLeft 101
		nsTop 138
		nsRight 205
		nsBottom 187
		sightAngle 180
		approachX 205
		approachY 188
		x 153
		y 162
	)

	(method (init)
		(super init: &rest)
		(deskTeller init: self 340 35 166)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 241)
					(if local6
						(gMessager say: 12 1 72) ; "You've stripped the desk of everything useful."
					else
						(= local6 1)
						(gEgo get: 5 3) ; theThrowdagger
						(gMessager say: 12 1 73) ; "You find three throwing daggers. That's peculiar; you could have sworn you took everything of value last time you were here."
					)
				else
					(gMessager say: 12 1 26) ; "The well-worn oak desk looks as though it could conceal a thousand secrets. Most of the drawers appear to be fakes. The one real drawer is locked."
				)
			)
			(4 ; Do
				(if local6
					(gMessager say: 12 1 72) ; "You've stripped the desk of everything useful."
				else
					(= local6 1)
					(gEgo get: 5 3) ; theThrowdagger
					(gMessager say: 12 1 73) ; "You find three throwing daggers. That's peculiar; you could have sworn you took everything of value last time you were here."
				)
			)
			(28 ; theLockpick
				(if (IsFlag 241)
					(gMessager say: 12 28 23) ; "There's no point to that; you've already sprung the desk's lock."
				else
					(gCurRoom setScript: sOpenDesk)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance safe of Feature
	(properties
		noun 22
		nsLeft 55
		nsTop 72
		nsRight 71
		nsBottom 85
		sightAngle 180
		x 63
		y 78
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 248)
						(gMessager say: 22 1 44) ; "A quick examination reveals that you've already stripped the safe of anything worthwhile."
					)
					((not (IsFlag 240))
						(gMessager say: 22 1 45) ; "This looks like an interesting safe, another fine product of the FILCH Safe Company. But you can't for the life of you figure out how anyone can open a safe with no knob."
					)
					(else
						(gMessager say: 22 1 47) ; "Now that you've replaced the safe knob, the Filch Safe looks ripe for the cracking (y'know, kind of like a walnut)."
					)
				)
			)
			(4 ; Do
				(cond
					((IsFlag 248)
						(gMessager say: 22 4 44) ; "A quick examination reveals that you've already stripped the safe of anything worthwhile."
					)
					((not (IsFlag 240))
						(gCurRoom setScript: sDoSafe 0 2)
					)
					(else
						(gCurRoom setScript: sDoSafe 0 1)
					)
				)
			)
			(78 ; theKnob
				(gCurRoom setScript: sDoSafe 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stone of Feature
	(properties
		nsLeft 49
		nsTop 87
		nsRight 79
		nsBottom 100
		sightAngle 180
		approachX 80
		approachY 110
		x 64
		y 93
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: sLookMark 0 1)
			)
			(4 ; Do
				(gCurRoom setScript: sLookMark 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ladder of Feature
	(properties
		noun 18
		nsLeft 21
		nsTop -1
		nsRight 35
		nsBottom 136
		sightAngle 180
		approachX 43
		approachY 137
		x 28
		y 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sClimbLadder)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sconce1 of Feature
	(properties
		noun 26
		nsLeft 35
		nsTop 62
		nsRight 46
		nsBottom 90
		sightAngle 180
		x 40
		y 76
	)
)

(instance sconce2 of Feature
	(properties
		noun 26
		nsLeft 117
		nsTop 61
		nsRight 129
		nsBottom 92
		sightAngle 180
		x 123
		y 76
	)
)

(instance bookshelf of Feature
	(properties
		noun 8
		nsLeft 91
		nsTop 57
		nsRight 112
		nsBottom 114
		sightAngle 180
		approachX 87
		approachY 111
		x 101
		y 85
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1) ; Do, Look
			(if (not (IsFlag 242))
				(SetFlag 242)
				(gEgo solvePuzzle: 511 2 4)
			)
			(SetFlag 511)
			(super doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance floorGrate of Feature
	(properties
		noun 15
		nsLeft 227
		nsTop 167
		nsRight 299
		nsBottom 189
		sightAngle 180
		approachX 226
		approachY 180
		x 263
		y 178
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetKnob)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drain of Feature
	(properties
		noun 14
		nsLeft 292
		nsTop 142
		nsRight 318
		nsBottom 157
		sightAngle 180
		approachX 274
		approachY 163
		x 305
		y 149
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLookMark 0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steps1 of Feature
	(properties
		noun 29
		nsLeft 54
		nsTop 114
		nsRight 111
		nsBottom 133
		sightAngle 180
		x 82
		y 123
	)

	(method (doit)
		(if
			(and
				(self onMe: gEgo)
				(== (gEgo mover:) 0)
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: sGetOffStairs 0 0)
		)
	)
)

(instance steps2 of Feature
	(properties
		noun 29
		nsLeft 227
		nsTop 133
		nsRight 277
		nsBottom 151
		sightAngle 180
		x 252
		y 142
	)

	(method (doit)
		(if
			(and
				(self onMe: gEgo)
				(== (gEgo mover:) 0)
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: sGetOffStairs 0 1)
		)
	)
)

(instance barrels1 of Feature
	(properties
		noun 7
		nsLeft 204
		nsTop 89
		nsRight 244
		nsBottom 119
		sightAngle 180
		x 224
		y 104
	)
)

(instance barrels2 of Feature
	(properties
		noun 7
		nsLeft 11
		nsTop 137
		nsRight 84
		nsBottom 188
		sightAngle 180
		x 47
		y 162
	)
)

(instance crack1 of Feature
	(properties
		noun 11
		nsLeft 34
		nsTop 10
		nsRight 62
		nsBottom 37
		sightAngle 180
		x 48
		y 23
	)
)

(instance crack2 of Feature
	(properties
		noun 11
		nsLeft 142
		nsTop 25
		nsRight 169
		nsBottom 51
		sightAngle 180
		x 155
		y 38
	)
)

(instance secretPassage of Feature
	(properties
		noun 27
		nsLeft 234
		nsTop 52
		nsRight 295
		nsBottom 123
		sightAngle 180
		x 264
		y 87
	)
)

(instance pillar of Feature
	(properties
		noun 19
		nsLeft 173
		nsTop 28
		nsRight 207
		nsBottom 119
		sightAngle 180
		x 190
		y 73
	)
)

(instance secritExit of Feature
	(properties
		nsLeft 311
		nsTop 119
		nsRight 319
		nsBottom 126
	)

	(method (init)
		(gTheDoits addToFront: self)
		(super init: &rest)
	)

	(method (doit)
		(if (and (self onMe: gEgo) (not (gCurRoom script:)))
			(gCurRoom newRoom: 290)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose: &rest)
	)
)

