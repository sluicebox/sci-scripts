;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use TargFeature)
(use n026)
(use OccasionalCycle)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	endGame 0
	deWizTalker 1
	deWiz 2
	gargoyle 3
	orb 4
	portal 5
	deMaster 6
	knockGarg 7
	castSpells 8
	zap 9
	deWizTimer 10
	walkOnGarg 11
	blastWiz 12
	touchPortal 13
	touchOrb 14
	blastOrb 15
	egoHit 16
	sFx 17
	pedestal 18
	noticeEgo 19
)

(local
	local0
	local1
	local2
)

(instance endGame of Rgn
	(properties
		modNum 850
		noun 18
	)

	(method (cue)
		(if (== (gEgo script:) walkOnGarg)
			(gTheIconBar disable: 1 5 4)
		)
		(super cue:)
	)

	(method (init)
		(egoActions init: gEgo)
		(gLongSong number: 851 setLoop: -1 play: 127)
		(gEgo
			x: -10
			y: 183
			actions: egoActions
			init:
			setScale: Scaler 92 63 189 130
			normalize:
			ignoreHorizon: 1
		)
		(HandsOn)
		(if (not (== gHeroType 1)) ; Magic User
			(gTheIconBar disable: 6 5 4)
		)
		(super init:)
		(switch gHeroType
			(2 ; Thief
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 270 67 266 76 243 76 238 66 227 66 206 90 180 90 172 74 147 76 147 87 139 92 118 92 112 85 112 80 81 85 104 101 166 94 181 105 128 114 142 121 153 120 162 127 161 139 148 145 162 165 205 167 227 189 301 189 264 167 319 152 319 56 292 59
							yourself:
						)
						((Polygon new:)
							type: PContainedAccess
							init: 0 100 0 189 112 189 104 178 116 176 108 166 88 156 77 158 69 148 52 148 48 144 55 134 45 124 28 121 45 115 35 105
							yourself:
						)
				)
			)
			(1 ; Magic User
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 270 67 266 76 243 76 238 66 227 66 206 90 180 90 172 74 147 76 147 87 139 92 118 92 112 85 112 80 81 85 104 101 166 94 181 105 128 114 142 121 153 120 162 127 161 139 148 145 162 165 205 167 227 189 301 189 264 167 319 152 319 56 292 59
							yourself:
						)
						((Polygon new:)
							type: PContainedAccess
							init: 0 144 0 189 112 189 104 178 116 176 110 171 84 173 72 162 69 148 52 148 48 144
							yourself:
						)
				)
			)
			(else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 206 90 177 90 170 76 151 76 151 92 110 92 108 81 84 85 104 100 166 94 183 104 128 114 142 121 153 120 162 127 161 139 148 145 162 165 205 167 227 189 301 189 264 167 319 152 319 56 282 56 282 135 277 142 253 140 239 107
							yourself:
						)
						((Polygon new:)
							type: PContainedAccess
							init: 0 144 0 189 112 189 104 178 116 176 108 166 88 156 77 158 69 148 52 148 48 144
							yourself:
						)
				)
			)
		)
		(if (not (== gHeroType 2)) ; Thief
			(gargoyle x: 93 y: 174 loop: 0 cel: 0 init:)
		)
		(if (== gHeroType 1) ; Magic User
			(gargoyle view: 853 loop: 1 cel: 0)
		)
		(portal init: stopUpd:)
		(deWiz init: setPri: 12 stopUpd:)
		(orb init: stopUpd:)
		(if (== gHeroType 2) ; Thief
			(pedestal view: 853 x: 217 y: 124)
		)
		(pedestal init: stopUpd:)
		(ledge init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(56 ; theMagicSpear
				(if (not (gCurRoom script:))
					(SetFlag 84)
					(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(20 ; theDaggers
				(if (not (gCurRoom script:))
					(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(33 ; theRocks
				(if (not (gCurRoom script:))
					(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(81 ; flameDartSpell
				(if (not (self script:))
					(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(88 ; lightningBallSpell
				(if (not (self script:))
					(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(83 ; forceBoltSpell
				(if (not (self script:))
					(self setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(80 ; calmSpell
				(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
			)
			(86 ; jugglingLightsSpell
				(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
			)
			(78 ; dazzleSpell
				(gMessager say: 2 6 66 0 0 850) ; "That spell wouldn't help you in your current situation."
			)
			(82 ; fetchSpell
				(gMessager say: 2 6 67 0 0 850) ; "Everything here must be bolted down."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(proc0_15 72 86 -1)
		(super doit:)
	)

	(method (dispose)
		(gEgo changeGait: 0) ; walking
		(if gList
			(gList dispose:)
		)
		(LoadMany 0 851 852 853 854 33)
		(super dispose:)
	)
)

(instance knockGarg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== ((ScriptID 851 2) state:) 0) ; crankUpShield
						(self cue:)
					)
					((== ((ScriptID 852 2) state:) 0) ; crankUpSword
						(self cue:)
					)
					(
						(or
							(not (== (egoHit state:) -1))
							(not (== ((ScriptID 851 2) state:) -1)) ; crankUpShield
							(not (== ((ScriptID 852 2) state:) -1)) ; crankUpSword
						)
						0
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(HandsOff)
				(= local0 1)
				(castSpells dispose:)
				(if (not (gCast contains: (ScriptID 852 5))) ; lightnin2
					(deWiz stopUpd:)
				)
				(gEgo changeGait: 1 setMotion: MoveTo 52 180 self) ; running
			)
			(2
				(gEgo view: 36 cel: 0 setLoop: 0 setCycle: CT 3 1 self)
			)
			(3
				(sFx number: 850 play:)
				(gargoyle view: 871 cel: 0 setCycle: End self)
				(gEgo setCycle: End)
			)
			(4
				(sFx number: 920 play:)
				(ShakeScreen 10)
				(gWalkHandler addToFront: gargoyle)
				(gargoyle stopUpd:)
				(gEgo view: 0 changeGait: 0 normalize:) ; walking
				(if
					(and
						(not (IsFlag 91))
						(gCast contains: deWiz)
						(or
							(not (== ((ScriptID 852 3) state:) -1)) ; chuckSwordAtWiz
							(not (== ((ScriptID 851 3) state:) -1)) ; spearWiz
						)
					)
					(deWiz setScript: castSpells)
				)
				(HandsOn)
				(gTheIconBar disable: 6 4 5)
				(self dispose:)
			)
		)
	)
)

(instance castSpells of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable: 1 4 5)
				(if (not (== gHeroType 1)) ; Magic User
					(gTheIconBar disable: 6)
				)
				(deWiz view: 863 cel: 0 loop: (Random 0 6) setCycle: End self)
			)
			(1
				(deWiz view: 863 loop: 0 setCycle: CT 6 1 self)
			)
			(2
				(sFx number: 13 play:)
				(zap
					setLoop: (Random 0 4)
					x: 186
					y: 60
					setStep: 8 7
					cycleSpeed: 0
					moveSpeed: 0
					setScale:
					init:
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 35) self
				)
				(deWiz setCycle: End)
			)
			(3
				(if (> (zap loop:) 3)
					(zap loop: 10 setCycle: End self)
				else
					(zap loop: 9 setCycle: End self)
				)
			)
			(4
				(zap dispose:)
				(gTheIconBar enable: 1)
				(if (or (IsFlag 91) (IsFlag 84))
					(EgoDead 47 850) ; "Your bones shake, break, rattle, and roll from the power of the Demon Wizard's spell. Maybe you'd best avoid calling attention to yourself in your next life."
				)
				(= state -1)
				(switch global209
					(1
						(= seconds 10)
					)
					(2
						(= seconds 7)
					)
					(3
						(= seconds 5)
					)
				)
			)
		)
	)

	(method (dispose)
		(if (gCast contains: zap)
			(zap dispose:)
		)
		(super dispose:)
	)
)

(instance egoHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(not
						(and
							(== (blastWiz state:) -1)
							(== ((ScriptID 852 3) state:) -1) ; chuckSwordAtWiz
							(== ((ScriptID 851 3) state:) -1) ; spearWiz
						)
					)
					0
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(sFx number: 930 play:)
				(if (gEgo takeDamage: (Random 5 15))
					(gEgo
						view: 29
						loop: 0
						cel: 0
						setMotion: 0
						setCycle: CT 6 1 self
					)
				else
					(EgoDead 47 850) ; "Your bones shake, break, rattle, and roll from the power of the Demon Wizard's spell. Maybe you'd best avoid calling attention to yourself in your next life."
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 0 normalize:)
				(HandsOn)
				(if (not (== gHeroType 1)) ; Magic User
					(gTheIconBar disable: 6 5 4)
				)
				(if (== (blastWiz state:) 0)
					(blastWiz cue:)
				)
				(if (== ((ScriptID 851 3) state:) 0) ; spearWiz
					((ScriptID 851 3) cue:) ; spearWiz
				)
				(if (== (knockGarg state:) 0)
					(knockGarg cue:)
				)
				(if (== ((ScriptID 852 3) state:) 1) ; chuckSwordAtWiz
					((ScriptID 852 3) cue:) ; chuckSwordAtWiz
				)
				(= state -1)
				(self dispose:)
			)
		)
	)
)

(instance blastWiz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(not (== (egoHit state:) -1))
						(== (self client:) (ScriptID 851 2)) ; crankUpShield
						(== (self client:) (ScriptID 852 2)) ; crankUpSword
					)
					0
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(SetFlag 15)
				(self setScript: (ScriptID 32 0) self register) ; project
			)
			(2
				(ClearFlag 15)
				(if
					(not
						(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
						)
					)
					(gEgo normalize:)
				else
					(HandsOff)
				)
				(if (== (egoHit state:) 0)
					(egoHit cue:)
				)
				(if (== ((ScriptID 853 1) state:) 3) ; mageEndScript
					((ScriptID 853 1) seconds: 3) ; mageEndScript
				)
				(if
					(and
						(not
							(if
								(and
									(> (gEgo view:) 17)
									(< (gEgo view:) 21)
								)
							)
						)
						(== gHeroType 1) ; Magic User
					)
					(gTheIconBar enable: 6 8)
				)
				(if (not (== gHeroType 1)) ; Magic User
					(gTheIconBar enable: 8)
				)
				(User controls: 1 input: 1)
				(if (== (gEgo script:) walkOnGarg)
					(gTheIconBar disable: 1 5 4 6)
				)
				(= state -1)
				(self dispose:)
			)
		)
	)
)

(instance deWizTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCast contains: (ScriptID 852 5))) ; lightnin2
					(deWiz setCycle: OccasionalCycle 1 10 1550)
				)
				(switch global209
					(1
						(= seconds 90)
					)
					(2
						(= seconds 60)
					)
					(3
						(= seconds 30)
					)
				)
			)
			(1
				(if (== (self script:) (ScriptID 852 6)) ; orbTempts
					((ScriptID 852 6) dispose:) ; orbTempts
				)
				(deMaster view: 856 loop: 1 setPri: 6 init:)
				(DrawPic (gCurRoom picture:) 9)
				(= seconds 1)
			)
			(2
				(EgoDead 2 850) ; "You died fried by a Thermonuclear Blast from the Demon Master. Next time you need to destroy the Orb a bit faster."
			)
		)
	)
)

(instance walkOnGarg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(castSpells dispose:)
				(gWalkHandler delete: gargoyle)
				(gEgo setMotion: MoveTo 128 169 self)
			)
			(1
				(if (or (IsFlag 91) (not (gCast contains: deWiz)))
					(self cue:)
				else
					(gMessager say: 3 6 8 0 self 850) ; "Creature of Stone, Hear my command! Capture that human With your cold hand!"
				)
			)
			(2
				(if (or (IsFlag 91) (not (gCast contains: deWiz)))
					(self cue:)
				else
					(gargArm init: setCycle: End self)
				)
			)
			(3
				(if (or (IsFlag 91) (not (gCast contains: deWiz)))
					(self cue:)
				else
					(gMessager say: 2 6 9 0 self 850) ; "The gargoyle's stony hand grabs your legs."
					(deWiz setScript: castSpells)
					(gTheIconBar advanceCurIcon:)
					(gGame setCursor: 941)
				)
			)
			(4
				(if (or (IsFlag 91) (not (gCast contains: deWiz)))
					(self cue:)
				else
					(if (== gHeroType 3) ; Paladin
						(gMessager say: 3 6 14 0 0 850) ; "Come forth, O Lord. By my power and by the forces held in this enchanted staff, I summon thee forth!"
					)
					(deWiz setScript: deWizTimer)
					(gTheIconBar enable: 3 9 8 2)
					(gUser canInput: 1)
				)
			)
			(5
				(if (or (IsFlag 91) (not (gCast contains: deWiz)))
					(self cue:)
				else
					(HandsOff)
					(gargArm setCycle: Beg self)
				)
			)
			(6
				(gargArm dispose:)
				(gEgo setMotion: MoveTo 183 147 self)
			)
			(7
				(= local1 1)
				(HandsOn)
				(gTheIconBar disable: 6 5 4)
				(self dispose:)
			)
		)
	)
)

(instance touchPortal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 225 120 self)
			)
			(1
				(gEgo view: 31 loop: 0 setCycle: End self)
			)
			(2
				(gEgo dispose:)
				(DrawPic 850 9)
				(= seconds 2)
			)
			(3
				(EgoDead 11 850) ; "As you pass through the open World Gate into the land of Demons, you realize that your visa has expired, and so soon shall you. Next time, shut the door before you explore."
				(self dispose:)
			)
		)
	)
)

(instance touchOrb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 243 141 self)
			)
			(1
				(gEgo view: 31 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo dispose:)
				(DrawPic 850 9)
				(= seconds 2)
			)
			(3
				(EgoDead 12 850) ; "The Orb absorbs your aura... and everything else. Next time, find a way to shield yourself from its effects."
				(self dispose:)
			)
		)
	)
)

(instance knockOrb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(deWizTimer dispose:)
				(if (< (gEgo x:) 100)
					(gEgo
						changeGait: 1 ; running
						setMotion: MoveTo (gEgo x:) 141 self
					)
				else
					(self cue:)
				)
			)
			(1
				(gEgo changeGait: 1 setMotion: MoveTo 243 141 self) ; running
			)
			(2
				(gEgo view: 36 loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(sFx number: 850 play:)
				(orb moveSpeed: 0 setStep: 7 6 setMotion: MoveTo 247 80)
				(gEgo setCycle: End self)
			)
			(4
				(sFx number: 101 play:)
				(orb dispose:)
				(gEgo solvePuzzle: 341 20)
				(DrawPic 850 9)
				(= seconds 2)
			)
			(5
				(if (gCast contains: (ScriptID 852 5)) ; lightnin2
					((ScriptID 852 4) dispose:) ; lightnin1
					((ScriptID 852 5) dispose:) ; lightnin2
				)
				(if (gCast contains: deWiz)
					(deWiz
						setCycle: Walk
						setStep: 6 5
						moveSpeed: 0
						setPri: 14
						setMotion: MoveTo 243 89 self
					)
				else
					(self cue:)
				)
			)
			(6
				(if (gCast contains: deWiz)
					(deWiz hide:)
					(DrawPic 850 9)
					(gEgo solvePuzzle: 340 10)
					(= seconds 2)
				else
					(self cue:)
				)
			)
			(7
				(portal setCycle: End self)
				(sFx number: 831 play:)
			)
			(8
				(portal loop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(9
				(portal dispose:)
				(gEgo normalize:)
				(switch gHeroType
					(0 ; Fighter
						(gMessager say: 2 6 57 0 self 850) ; "You grab the Spear of Death and run for the stairs."
					)
					(3 ; Paladin
						(gMessager say: 2 6 58 0 self 850) ; "You pick up your sword and run for the stairs to return to your friends."
					)
					(else
						(gMessager say: 2 6 3 0 self 850) ; "You run for the stairs to return to your friends."
					)
				)
			)
			(10
				(= cycles 3)
			)
			(11
				(SetFlag 117)
				(gCurRoom newRoom: 830)
			)
		)
	)
)

(instance blastOrb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(deWizTimer dispose:)
				(self setScript: (ScriptID 32 0) self register) ; project
			)
			(1)
			(2
				(sFx number: 520 play:)
				(if (gCast contains: (ScriptID 852 4)) ; lightnin1
					((ScriptID 852 5) dispose:) ; lightnin2
					((ScriptID 852 4) dispose:) ; lightnin1
				)
				(orb moveSpeed: 0 setStep: 7 6 setMotion: MoveTo 247 80 self)
			)
			(3
				(orb dispose:)
				(gEgo solvePuzzle: 341 20)
				(DrawPic 850 9)
				(= seconds 2)
			)
			(4
				(if (gCast contains: deWiz)
					(deWiz
						setCycle: Walk
						setStep: 6 5
						moveSpeed: 0
						setPri: 14
						setMotion: MoveTo 243 89 self
					)
				else
					(self cue:)
				)
			)
			(5
				(if (gCast contains: deWiz)
					(deWiz hide:)
					(DrawPic 850 9)
					(gEgo solvePuzzle: 340 10)
					(= seconds 2)
				else
					(self cue:)
				)
			)
			(6
				(portal setCycle: End self)
				(sFx number: 831 play:)
			)
			(7
				(portal loop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(portal dispose:)
				(gMessager say: 2 6 3 0 self 850) ; "You run for the stairs to return to your friends."
			)
			(9
				(SetFlag 117)
				(gCurRoom newRoom: 830)
			)
		)
	)
)

(instance deSummons of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 6 14 0 self 850) ; "Come forth, O Lord. By my power and by the forces held in this enchanted staff, I summon thee forth!"
			)
			(1
				(deWiz view: 861 loop: 1 cel: 5 setCycle: Beg self)
			)
			(2
				(deWiz loop: 0 setCycle: OccasionalCycle self 1 1 20)
				(gCurRoom setScript: deWizTimer)
			)
		)
	)
)

(instance noticeEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 124)
				(gEgo code: 0)
				(gMessager say: 1 6 5 0 self 850) ; "Behind you, idiot! It's that interfering human!"
			)
			(1
				(deMaster dispose:)
				(DrawPic 850 9)
				(= seconds 1)
			)
			(2
				(deWiz view: 861 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 3 6 6 0 self 850) ; "So, you have escaped from my trap. Perhaps destroying you will be more interesting than I thought."
			)
			(4
				(deWiz view: 863 cel: 0 setCycle: End)
				(gLongSong2 setLoop: 1 number: 13 play:)
				(zap
					setLoop: (Random 0 4)
					x: 186
					y: 60
					setStep: 8 7
					cycleSpeed: 0
					moveSpeed: 0
					setScale:
					init:
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 35) self
				)
			)
			(5
				(if (> (zap loop:) 3)
					(zap loop: 10 setCycle: End self)
				else
					(zap loop: 9 setCycle: End self)
				)
			)
			(6
				(zap dispose:)
				(if (== gHeroType 2) ; Thief
					(EgoDead 47 850 857 End) ; "Your bones shake, break, rattle, and roll from the power of the Demon Wizard's spell. Maybe you'd best avoid calling attention to yourself in your next life."
				)
				(self dispose:)
			)
		)
	)
)

(instance zap of Actor
	(properties
		yStep 7
		view 21
		signal 16384
		xStep 8
	)

	(method (init)
		(super init:)
		(SetNowSeen self)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(gEgo onMe: zap)
				(not (IsFlag 82))
				(not (IsFlag 89))
				(not
					(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					)
				)
				(not (castSpells script:))
			)
			(castSpells setScript: egoHit)
		)
	)
)

(instance gargoyle of Prop
	(properties
		x 93
		y 174
		noun 6
		modNum 850
		view 852
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (gEgo has: 5) (not local0)) ; theShield
						(self setScript: knockGarg)
					)
					((and local0 (== (walkOnGarg state:) -1))
						(gEgo setScript: walkOnGarg)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(15 ; theShield
				(if (and (gEgo has: 5) (not local0)) ; theShield
					(self setScript: knockGarg)
				)
			)
			(3 ; Walk
				(if (and local0 (== (walkOnGarg state:) -1))
					(gEgo setScript: walkOnGarg)
				)
			)
			(26 ; theDispell
				(if local0
					(walkOnGarg cue:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deWiz of TargActor
	(properties
		x 187
		y 115
		noun 3
		modNum 850
		view 861
		signal 16384
	)

	(method (dispose)
		(gEgo addHonor: 50)
		(super dispose:)
	)

	(method (getHurt)
		(cond
			((not (IsFlag 124))
				(gCurRoom setScript: noticeEgo)
			)
			((IsFlag 84)
				(if (not (== ((ScriptID 851 3) state:) -1)) ; spearWiz
					((ScriptID 851 3) cue:) ; spearWiz
				else
					(gEgo drop: 45) ; theMagicSpear
					((ScriptID 851 3) start: 2) ; spearWiz
					(if (== (gEgo script:) walkOnGarg)
						(walkOnGarg setScript: (ScriptID 851 3)) ; spearWiz
					else
						(gEgo setScript: (ScriptID 851 3)) ; spearWiz
					)
				)
			)
			((IsFlag 91)
				((ScriptID 852 3) cue:) ; chuckSwordAtWiz
			)
			(
				(==
					(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					)
					1
				)
				((gCurRoom script:) setScript: (ScriptID 853 3)) ; deWizRecoils
			)
			((== gHeroType 1) ; Magic User
				(gMessager say: 3 6 43 0 0 850) ; "Ha! Pitiful human! Your puny effort cannot harm a true master of magic such as I."
			)
			(else
				(gMessager say: 3 6 29 0 0 850) ; "Ha! You think such a thing could harm me? You are a bigger fool than I thought."
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 81 83 88 20 11 33) ; flameDartSpell, forceBoltSpell, lightningBallSpell, theDaggers, theSword, theRocks
				(cond
					((== ((ScriptID 853 2) state:) 11) ; deMageBattle
						(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
					)
					((and (== theVerb 11) (not (== gHeroType 3))) 0) ; theSword, Paladin
					((and (not (gCurRoom script:)) (== theVerb 11)) ; theSword
						(gCurRoom setScript: (ScriptID 852 3)) ; chuckSwordAtWiz
						(if (== (deWiz script:) castSpells)
							(castSpells dispose:)
						)
					)
					((== (gEgo script:) (ScriptID 851 2)) ; crankUpShield
						((ScriptID 851 2) setScript: blastWiz 0 theVerb) ; crankUpShield
					)
					((== (gEgo script:) (ScriptID 852 2)) ; crankUpSword
						((ScriptID 852 2) setScript: (ScriptID 852 3) 0 theVerb) ; crankUpSword, chuckSwordAtWiz
					)
					((not (gEgo script:))
						(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
						(gEgo setScript: blastWiz 0 theVerb)
					)
					(
						(or
							(== (gEgo script:) egoHit)
							(== (gEgo script:) walkOnGarg)
						)
						(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
						(gCurRoom setScript: blastWiz 0 theVerb)
					)
				)
			)
			((== theVerb 56) ; theMagicSpear
				(SetFlag 84)
				(cond
					((== (gEgo script:) walkOnGarg)
						(walkOnGarg
							setScript: (ScriptID 851 3) walkOnGarg theVerb ; spearWiz
						)
					)
					((not (gEgo script:))
						(gEgo setScript: (ScriptID 851 3) 0 theVerb) ; spearWiz
					)
					(else
						(gCurRoom setScript: (ScriptID 851 3) 0 theVerb) ; spearWiz
					)
				)
			)
			((and (== gHeroType 3) (== theVerb 11)) ; Paladin, theSword
				(cond
					((== (gEgo script:) walkOnGarg)
						(walkOnGarg
							setScript: (ScriptID 852 3) walkOnGarg theVerb ; chuckSwordAtWiz
						)
					)
					((not (gEgo script:))
						(gEgo setScript: (ScriptID 852 3) walkOnGarg theVerb) ; chuckSwordAtWiz
					)
				)
			)
			(
				(and
					(== gHeroType 3) ; Paladin
					(== theVerb 4) ; Do
					local0
					(not (== ((ScriptID 852 3) state:) -1)) ; chuckSwordAtWiz
				)
				((ScriptID 852 3) cue:) ; chuckSwordAtWiz
			)
			((== theVerb 26) ; theDispell
				(gMessager say: 3 26 10 0 0 850) ; "You don't expect that wimpy potion to affect a Demon Wizard, do you? It doesn't."
			)
			((== theVerb 16) ; theGrapnel
				(if (not (> (gEgo x:) 290))
					(gMessager say: 2 6 37 0 0 850) ; "You don't have a clear shot from here."
				else
					(gEgo setScript: (ScriptID 854 2)) ; grapDeWiz
				)
			)
			((and (== theVerb 4) (gCast contains: (ScriptID 852 5))) ; Do, lightnin2
				(EgoDead 2 850) ; "You died fried by a Thermonuclear Blast from the Demon Master. Next time you need to destroy the Orb a bit faster."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance portal of Prop
	(properties
		x 246
		y 106
		noun 19
		modNum 850
		view 856
		priority 1
		signal 16405
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and local0 (not (gCast contains: deWiz)))
					(gCurRoom setScript: touchPortal)
				else
					(super doVerb: theVerb)
				)
			)
			(33 ; theRocks
				(gCurRoom doVerb: theVerb)
			)
			(81 ; flameDartSpell
				(gCurRoom doVerb: theVerb)
			)
			(83 ; forceBoltSpell
				(gCurRoom doVerb: theVerb)
			)
			(88 ; lightningBallSpell
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance orb of TargActor
	(properties
		x 267
		y 115
		z 20
		noun 15
		modNum 850
		view 860
		loop 1
		signal 16384
	)

	(method (dispose)
		(gEgo addHonor: 100)
		(super dispose:)
	)

	(method (getHurt)
		(cond
			((gCast contains: deWiz)
				(gMessager say: 2 6 42 0 0 850) ; "Your spell has no affect upon the Orb."
			)
			((== (gCurRoom script:) blastOrb)
				(blastOrb cue:)
			)
			(else
				(deWizTimer dispose:)
				(blastOrb start: 2)
				(gCurRoom setScript: blastOrb)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and local0 local1)
					(gCurRoom setScript: touchOrb)
				else
					(super doVerb: theVerb)
				)
			)
			(15 ; theShield
				(if (== (gEgo script:) (ScriptID 851 2)) ; crankUpShield
					((ScriptID 851 2) dispose:) ; crankUpShield
				)
				(if
					(and
						(not local1)
						(== local0 1)
						(not (== (gEgo script:) walkOnGarg))
					)
					(gEgo setScript: walkOnGarg)
				)
				(if (and (== local0 1) (not (== (gEgo script:) walkOnGarg)))
					(gCurRoom setScript: knockOrb)
				else
					(super doVerb: theVerb)
				)
			)
			(83 ; forceBoltSpell
				(if (== ((ScriptID 853 2) state:) 11) ; deMageBattle
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				else
					(gCurRoom setScript: blastOrb 0 theVerb)
				)
			)
			(88 ; lightningBallSpell
				(if (== ((ScriptID 853 2) state:) 11) ; deMageBattle
					(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
				else
					(gCurRoom setScript: blastOrb 0 theVerb)
				)
			)
			(56 ; theMagicSpear
				(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
			)
			(16 ; theGrapnel
				(gMessager say: 2 6 49 0 0 850) ; "The Demon Wizard's magic is protecting the Orb. You need to take care of him before worrying about the Orb."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deMaster of View
	(properties
		x 210
		y 17
		modNum 850
		view 873
		loop 1
		priority 14
		signal 16405
	)
)

(instance pedestal of TargProp
	(properties
		x 266
		y 139
		noun 16
		modNum 850
		view 860
		signal 20480
	)

	(method (getHurt)
		(orb getHurt:)
	)

	(method (doVerb theVerb)
		(orb doVerb: theVerb)
	)
)

(instance deWizTalker of Talker
	(properties
		x 10
		y 10
		view 862
		loop 1
		talkWidth 260
		back 57
		textX 15
		textY 100
	)

	(method (init)
		(super init: deWizBust deWizEyes deWizMouth &rest)
	)

	(method (doit)
		(self cycle: brows cycle: bubbles)
		(super doit: &rest)
	)

	(method (dispose)
		(brows setCycle: 0 dispose:)
		(bubbles setCycle: 0 dispose:)
		(super dispose:)
	)

	(method (startText)
		(eyes setCycle: Fwd)
		(brows setCycle: Fwd)
		(bubbles setCycle: Fwd)
		(super startText:)
	)
)

(instance brows of Prop
	(properties
		nsTop 32
		nsLeft 28
		view 862
		loop 3
		cycleSpeed 96
	)
)

(instance bubbles of Prop
	(properties
		nsTop 12
		nsLeft 42
		view 862
		loop 4
		cycleSpeed 24
	)
)

(instance deWizMouth of Prop
	(properties
		nsTop 51
		nsLeft 32
		view 862
	)
)

(instance deWizEyes of Prop
	(properties
		nsTop 42
		nsLeft 37
		view 862
		loop 2
	)
)

(instance deWizBust of View
	(properties
		view 862
		loop 1
	)
)

(instance gargArm of Prop
	(properties
		x 122
		y 182
		view 858
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(26 ; theDispell
				(gMessager say: 4 26 10 0 0 850) ; "Unfortunately, the dispel potion only works on living creatures. It has no effect on the gargoyle."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ledge of Feature
	(properties
		x 98
		y 165
		noun 17
		nsTop 150
		nsLeft 74
		nsBottom 181
		nsRight 123
		sightAngle 180
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(not local0)
					(== theVerb 15) ; theShield
					(gCast contains: deWiz)
					(not (== (castSpells script:) egoHit))
				)
				(gEgo setScript: (ScriptID 851 2)) ; crankUpShield
			)
			(
				(and
					(not local0)
					(== theVerb 11) ; theSword
					(== gHeroType 3) ; Paladin
					(gCast contains: deWiz)
					(not (== (castSpells script:) egoHit))
				)
				(gEgo setScript: (ScriptID 852 2)) ; crankUpSword
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

