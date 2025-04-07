;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use GloryTalker)
(use Interface)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
	sSleepScr 1
	piotyrTalker 2
)

(local
	local0
	local1
	local2
)

(instance rm270 of GloryRm
	(properties
		picture 270
		north 260
		east 280
		west 260
	)

	(method (init)
		(if gDebugging
			(= local0 (GetNumber {Event #?}))
		else
			(= local0
				(cond
					((and gNight (== gPrevRoomNum 650)) 1)
					(
						(and
							gNight
							(== gHeroType 3) ; Paladin
							(== global419 0)
							(!= global420 gDay)
						)
						2
					)
					(
						(and
							gNight
							(== gHeroType 3) ; Paladin
							(not (IsFlag 117))
							(!= global420 gDay)
						)
						3
					)
					(
						(and
							gNight
							(== gHeroType 3) ; Paladin
							(!= global420 gDay)
							(not (IsFlag 62))
							(IsFlag 117)
						)
						4
					)
					(
						(and
							gNight
							(== gHeroType 3) ; Paladin
							(!= global420 gDay)
							(IsFlag 62)
							(not (IsFlag 115))
							(not (IsFlag 43))
						)
						5
					)
					(
						(and
							gNight
							(== gHeroType 3) ; Paladin
							(!= global420 gDay)
							(not (IsFlag 115))
						)
						6
					)
					(
						(and
							gNight
							(== gHeroType 3) ; Paladin
							(!= global420 gDay)
							(IsFlag 115)
						)
						7
					)
					(else 0)
				)
			)
		)
		(gGlory handsOff:)
		(gEgo setScaler: Scaler 126 49 189 47)
		(super init:)
		(if (!= gPrevRoomNum 110) ; dreamer
			(gLongSong number: 790 setLoop: -1 play:)
		)
		(gEgo init: normalize:)
		(= global423 0)
		(if (and gNight (not (== gPrevRoomNum 110))) ; dreamer
			(= local2 1)
			(fSouth init:)
			(gateTeller init: fSouth 270 9 125)
		else
			(gCurRoom south: 290)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 167 55 166 87 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 257 189 273 167 319 167 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 239 93 236 105 189 122 93 108 88 93
					yourself:
				)
		)
		(if (not (IsFlag 115))
			(aStaff init: approachVerbs: 4 ignoreActors: setPri: 108) ; Do
		)
		(fFlowers init: approachVerbs: 4) ; Do
		(fMound init: approachVerbs: 4) ; Do
		(fArchWay init: approachVerbs: 4) ; Do
		(fTreeKnot init: approachVerbs: 4) ; Do
		(fGrass init: approachVerbs: 4) ; Do
		(fTreeLeft init: approachVerbs: 4) ; Do
		(fTreeRight init: approachVerbs: 4) ; Do
		(fBuildings init: approachVerbs: 4) ; Do
		(((ScriptID 6 0) new:) ; eFeatureR
			x: 28
			y: 67
			nsLeft: 0
			nsTop: 0
			nsBottom: 87
			nsRight: 168
			approachX: 91
			approachY: 85
			init:
		)
		((specialEFtr2 new:)
			x: 180
			y: 67
			nsLeft: 168
			nsTop: 0
			nsBottom: 87
			nsRight: 319
			approachX: 251
			approachY: 85
			init:
		)
		(gEgo setScript: sComeOnIn)
	)

	(method (doit)
		(if (and gNight (not local2))
			(= local2 1)
			(fSouth init:)
			(gateTeller init: fSouth 270 9 125)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; calmSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(86 ; flameDartSpell
				(gMessager say: 0 86 0) ; "The feeling of peace that suffuses this area makes it impossible for you to even contemplate violent thoughts."
				(return 1)
			)
			(88 ; forceBoltSpell
				(gMessager say: 0 88 0) ; "The feeling of peace that suffuses this area makes it impossible for you to even contemplate violent thoughts."
				(return 1)
			)
			(79 ; frostSpell
				(gMessager say: 0 79 0) ; "The feeling of peace that suffuses this area makes it impossible for you to even contemplate violent thoughts."
				(return 1)
			)
			(95 ; invisibleSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(91 ; jugglingLightsSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(93 ; lightningBallSpell
				(gMessager say: 0 93 0) ; "The feeling of peace that suffuses this area makes it impossible for you to even contemplate violent thoughts."
				(return 1)
			)
			(80 ; openSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(98 ; resistanceSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(83 ; dazzleSpell
				(gMessager say: 0 83 0) ; "The feeling of peace that suffuses this area makes it impossible for you to even contemplate violent thoughts."
				(return 1)
			)
			(90 ; reversalSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(84 ; zapSpell
				(gMessager say: 0 84 0) ; "The feeling of peace that suffuses this area makes it impossible for you to even contemplate violent thoughts."
				(return 1)
			)
			(87 ; fetchSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(82 ; triggerSpell
				(gMessager say: 0 82 0) ; "The peaceful feelings here prevent you from indulging in a whim that could easily destroy yourself and most of the town of Mordavia. Pity. The results would have been impressive, to say the least."
				(return 1)
			)
			(92 ; summonStaffSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(97 ; protectionSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(96 ; auraSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(11 ; glideSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(102 ; healingSpell
				(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				(return 1)
			)
			(94 ; ritualSpell
				(if gNight
					(gCurRoom setScript: sStaffAnimates)
				else
					(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				)
				(return 1)
			)
			(89 ; levitateSpell
				(if gNight
					(= global423 2)
					(if (gEgo castSpell: 29)
						(gCurRoom setScript: sClimbTheGate)
					else
						(return 0)
					)
				else
					(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
				)
				(return 1)
			)
			(104 ; Sleep all night
				(gCurRoom setScript: (ScriptID 270 1)) ; sSleepScr
			)
			(81 ; detectMagicSpell
				(if (IsFlag 115)
					(gMessager say: 0 81 26) ; "There is still some residual magic in this area, although it is starting to fade now that Erana's Staff no longer protects the town."
				else
					(gMessager say: 8 81 0 0) ; "You sense magic radiating from the staff and protecting this area."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gLongSong fade: 0)
		(DisposeScript 64939)
		(DisposeScript 64991)
		(super dispose:)
	)
)

(instance sClimbTheTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global423 1)
				(gMessager say: 13 4 11 0 self) ; "You use the tree to climb up over the gate and out of town."
			)
			(1
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance sClimbTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== global423 1)
					(gEgo useSkill: 11 200) ; climbing
				)
				(gEgo setMotion: MoveTo (gEgo x:) 210 self)
			)
			(1
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance sSleepScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 141 134 self)
			)
			(1
				(gEgo
					view: 35
					setLoop: 0 1
					setCel: 0
					posn: 171 132
					setCycle: End self
				)
			)
			(2
				(= [gEgoStats 19] (gEgo maxMana:)) ; mana
				(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 17] (gEgo maxHealth:)) ; health
				(if (< global345 10)
					(++ global345)
					(gCurRoom newRoom: 110) ; dreamer
				else
					((ScriptID 7 4) init: 7 51) ; fixTime
					(= seconds 6)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0 posn: 141 134 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTo290Night of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 3 6 10 0 self) ; "The massive gate to this town is securely barred to protect it from things that go bump in the night. You cannot leave the town this way."
			)
			(1
				(gEgo
					setLoop: 2 1
					setCycle: Rev
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 6) self
				)
			)
			(2
				(gEgo normalize:)
				(gateTeller doVerb: 4)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTo260 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 26 47 self)
			)
			(1
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sComeOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch gPrevRoomNum
					(650
						(gEgo setLoop: 6 1 posn: 140 150)
						(pToby init:)
						(pTanya init:)
						(= ticks 12)
					)
					(290
						(gEgo posn: 164 242 setMotion: MoveTo 162 163 self)
					)
					(260
						(gEgo posn: 91 85 setMotion: MoveTo 60 102 self)
					)
					(280
						(gEgo posn: 251 85 setMotion: MoveTo 251 102 self)
					)
					(110 ; dreamer
						(gEgo view: 35 setLoop: 4 1 posn: 171 132)
						(self setScript: sAfterTheDream)
					)
					(else
						(gEgo posn: 91 164)
						(= ticks 12)
					)
				)
			)
			(1
				(cond
					((== gPrevRoomNum 650)
						(gCurRoom setScript: sChildSacrifice)
					)
					((OneOf local0 2 3 4 5 6 7)
						(gCurRoom setScript: sEvent2)
					)
					(else
						(gGlory handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance sAfterTheDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 3)
			)
			(1
				(Palette 2 0 255 100) ; PalIntensity
				((ScriptID 7 4) init: 8) ; fixTime
				(= [gEgoStats 19] (gEgo maxMana:)) ; mana
				(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 17] (gEgo maxHealth:)) ; health
				(gEgo setCycle: 0)
				(= seconds 5)
			)
			(2
				(gateTeller dispose:)
				(fSouth actions: 0)
				(if (fSouth heading:)
					((fSouth heading:) dispose:)
					(fSouth heading: 0)
				)
				(gLongSong number: 790 setLoop: -1 play: 0 fade: 127 10 7 0)
				(= register (gEgo cycleSpeed:))
				(gEgo cycleSpeed: global433 setCycle: End self)
			)
			(3
				(gEgo posn: 141 134 cycleSpeed: register normalize:)
				(if (OneOf global345 7 9 10)
					(gMessager say: 2 6 8 0 self) ; "You wake in a cold sweat. You remember every detail of the nightmare as though it had really happened to you."
				else
					(gMessager say: 2 6 9 0 self) ; "You gradually wake, shaking off the shreds of dreams that cling to your memory."
				)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetFlowers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local1 (gEgo cycleSpeed:))
				(gEgo view: 4 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(sndPullFlowers play:)
				(= seconds 3)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gMessager say: 4 4 14 0 self) ; "You pick some flowers and put them away."
			)
			(4
				(gEgo cycleSpeed: local1 get: 40 normalize:) ; theFlowers
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStaffAnimates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(sndMagic play:)
				(aStaff setLoop: 1 1 setCel: 0 setCycle: Osc 4 self)
			)
			(1
				(aStaff setLoop: 2 1 setCel: 0 setCycle: Osc 6 self)
			)
			(2
				(aStaff setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(3
				(if (> [gEgoStats 35] 0) ; ritualOfReleaseSpell
					(gMessager say: 2 6 20 0 self) ; "You cast the "Ritual of Release.""
				else
					(self cue:)
				)
			)
			(4
				(aStaff setCycle: Beg self)
			)
			(5
				(aStaff setLoop: 0 1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChildSacrifice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gLongSong fade: 0)
				(gLongSong2 number: 110 setLoop: -1 play: 0 fade: 127 10 7 0)
				((ScriptID 7 4) init: 2 15) ; fixTime
				(SetFlag 115)
				(= seconds 2)
			)
			(1
				(gMessager say: 6 6 1 0 self) ; "It feels weird here. Kind of happy and icky. I'm scared."
			)
			(2
				(if (> [gEgoStats 12] 5) ; magic
					(gMessager say: 2 6 20 0 self) ; "You cast the "Ritual of Release.""
				else
					(self changeState: 5)
				)
			)
			(3
				(gEgo
					view: 14
					setLoop: 2 1
					setCel: 0
					posn: (+ (gEgo x:) 7) (gEgo y:)
					setCycle: End self
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(if (> [gEgoStats 12] 5) ; magic
					(gEgo normalize: setLoop: 6 1)
					(self cue:)
				else
					(gMessager say: 5 6 15 0 self) ; "A weird voice sounds in your mind."
				)
			)
			(6
				(sndMagic play:)
				(aStaff setLoop: 1 1 setCel: 0 setCycle: Osc 4 self)
			)
			(7
				(aStaff setLoop: 2 1 setCel: 0 setCycle: Osc 6 self)
			)
			(8
				(aStaff setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(9
				(gMessager say: 5 6 16 0 self) ; "The Sacrifice of Life for Love."
			)
			(10
				(aStaff
					setLoop: 4 1
					setCel: 0
					setPri: 119
					ignoreActors: 1
					ignoreHorizon: 1
					setCycle: 0
					setMotion: MoveTo 212 59 self
				)
			)
			(11
				(gMessager sayRange: 5 6 17 1 2 self) ; "Your love for the child is great."
			)
			(12
				(pToby setLoop: 0 1 setCel: 0 cycleSpeed: 18 setCycle: End self)
			)
			(13
				(gMessager sayRange: 5 6 17 3 9 self) ; "Will you trade your Life to give Life to the child?"
			)
			(14
				(aStaff setCycle: End self)
			)
			(15
				(aStaff setLoop: 5 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(16
				(sndExplosive play:)
				(Palette 2 0 255 500) ; PalIntensity
				(Palette 2 0 255 100) ; PalIntensity
				(aStaff setCel: 4)
				(= ticks 12)
			)
			(17
				(pToby
					setLoop: 2 1
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(18
				(sndLightning play:)
				(pLighting init: setCycle: Osc 1 self)
			)
			(19
				(sndLightning stop:)
				(pLighting hide:)
				(= seconds 2)
			)
			(20
				(pToby setCel: 4 setCycle: CT 7 1 self)
			)
			(21
				(= seconds 5)
			)
			(22
				(pToby hide: dispose:)
				(gMessager say: 5 6 18 0 self) ; "So is the Sacrifice complete! I am again the Staff of Erana."
			)
			(23
				(aStaff setCel: 0 setMotion: JumpTo 167 149 self)
			)
			(24
				(sndThud play:)
				(gEgo normalize: setMotion: MoveTo 152 152 self)
			)
			(25
				(gEgo view: 4 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(26
				(aStaff hide: dispose:)
				(gEgo setCycle: Beg self)
			)
			(27
				(if (!= gHeroType 1) ; Magic User
					(self cue:)
				else
					(gMessager say: 2 6 29 0 self) ; "You feel Erana's Staff become a part of you. Now it is your Staff as well when you choose to summon it."
				)
			)
			(28
				(gEgo normalize: setMotion: PolyPath 199 124 self)
			)
			(29
				(gMessager say: 6 6 19 0 self) ; "I'm sorry, Toby. I didn't protect you too good, did I?"
			)
			(30
				(gCast eachElementDo: #hide)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				(= seconds 2)
			)
			(31
				(gMessager say: 2 6 21 0 self) ; "You take the sobbing child in your arms and carry her to the Inn. You awaken her parents and are overwhelmed by their gratitude and joy. It is long before you manage to escape to the peace of your own room for what is left of the night."
			)
			(32
				(if (!= gHeroType 1) ; Magic User
					(gEgo get: 47) ; theStaff
				else
					(gEgo learn: 32 200) ; summonStaffSpell
				)
				(gEgo solvePuzzle: 450 25)
				(gLongSong2 fade: 0)
				(= seconds 1)
			)
			(33
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance sEvent2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 2 6 22 0 self) ; "A shiver of cold comes over you. You sense no danger, but even so, you find yourself afraid."
			)
			(1
				(gEgo setMotion: PolyPath 91 164 self)
			)
			(2
				(= seconds 3)
			)
			(3
				(pPiotyr init: setCycle: End self)
			)
			(4
				(Face gEgo 144 151 self)
			)
			(5
				(gEgo normalize:)
				(= seconds 1)
			)
			(6
				(= global420 gDay)
				(++ global419)
				(switch local0
					(2
						(gMessager say: 1 6 1 0 self) ; "I am what was once the Paladin Piotyr."
					)
					(3
						(SetFlag 116)
						(gMessager say: 1 6 2 0 self) ; "There is one for whom I weep."
					)
					(4
						(gMessager say: 1 6 4 0 self) ; "There is a spirit most foul which haunts the land."
					)
					(5
						(gMessager say: 1 6 5 0 self) ; "I was the Paladin Piotyr, and my pride was too great."
					)
					(6
						(gMessager say: 1 6 6 0 self) ; "There is a woman who sorrows, whose heart cannot bear the loss of one so dear."
					)
					(7
						(gMessager say: 1 6 7 0 self) ; "You serve two Dark Masters. Their goal is greater Darkness."
					)
				)
			)
			(7
				(pPiotyr setCycle: Beg self)
			)
			(8
				(pPiotyr dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aStaff of Actor
	(properties
		noun 5
		approachX 167
		approachY 126
		x 160
		y 34
		view 271
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				85 ; calmSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				95 ; invisibleSpell
				91 ; jugglingLightsSpell
				93 ; lightningBallSpell
				80 ; openSpell
				98 ; resistanceSpell
				83 ; dazzleSpell
				90 ; reversalSpell
				84 ; zapSpell
				87 ; fetchSpell
				82 ; triggerSpell
				92 ; summonStaffSpell
				97 ; protectionSpell
				96 ; auraSpell
				11 ; glideSpell
				102 ; healingSpell
			)
			(gCurRoom doVerb: theVerb)
		else
			(switch theVerb
				(94 ; ritualSpell
					(if gNight
						(gCurRoom setScript: sStaffAnimates)
					else
						(gMessager say: 2 6 27) ; "You were told that you shouldn't use magic in Mordavia. Someone might see you here."
					)
				)
				(2 ; Talk
					(gMessager say: 5 126 0 0) ; "You hear a voice in your head."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance pLighting of Prop
	(properties
		x 165
		y 123
		priority 163
		fixPriority 1
		view 272
		loop 1
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScaler: Scaler 85 70 120 81)
	)
)

(instance pToby of Prop
	(properties
		x 169
		y 123
		view 272
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScaler: Scaler 85 70 120 81)
	)
)

(instance pTanya of Prop
	(properties
		x 213
		y 122
		view 652
		loop 1
	)
)

(instance pPiotyr of Prop
	(properties
		x 144
		y 151
		view 273
	)
)

(instance fSouth of Feature
	(properties
		noun 3
		nsLeft 129
		nsTop 56
		nsRight 211
		nsBottom 75
		sightAngle 180
		x 170
		y 65
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 67 181 268 181 268 189 67 189
						yourself:
					)
					2
					4
					5
					sTo290Night
				yourself:
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

(instance fMound of Feature
	(properties
		noun 7
		nsLeft 129
		nsTop 56
		nsRight 211
		nsBottom 75
		sightAngle 180
		approachX 165
		approachY 109
		x 170
		y 75
	)

	(method (doVerb theVerb)
		(cond
			(
				(OneOf
					theVerb
					85 ; calmSpell
					86 ; flameDartSpell
					88 ; forceBoltSpell
					79 ; frostSpell
					95 ; invisibleSpell
					91 ; jugglingLightsSpell
					93 ; lightningBallSpell
					80 ; openSpell
					98 ; resistanceSpell
					83 ; dazzleSpell
					90 ; reversalSpell
					84 ; zapSpell
					87 ; fetchSpell
					82 ; triggerSpell
					92 ; summonStaffSpell
					97 ; protectionSpell
					96 ; auraSpell
					11 ; glideSpell
					102 ; healingSpell
				)
				(gCurRoom doVerb: theVerb)
			)
			((== theVerb 1) ; Look
				(if (IsFlag 115)
					(gMessager say: 7 1 26) ; "With Erana's Staff gone, the boulder is now just another large rock formation, although flowers still grow on it... for now."
				else
					(gMessager say: 7 1 25) ; "The huge boulder raises a solitary wooden staff high above the clearing."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fTreeLeft of Feature
	(properties
		noun 13
		sightAngle 40
		approachX 77
		approachY 180
		x 30
		y 95
	)

	(method (doVerb theVerb)
		(cond
			(
				(OneOf
					theVerb
					85 ; calmSpell
					86 ; flameDartSpell
					88 ; forceBoltSpell
					79 ; frostSpell
					95 ; invisibleSpell
					91 ; jugglingLightsSpell
					93 ; lightningBallSpell
					80 ; openSpell
					98 ; resistanceSpell
					83 ; dazzleSpell
					90 ; reversalSpell
					84 ; zapSpell
					87 ; fetchSpell
					82 ; triggerSpell
					92 ; summonStaffSpell
					97 ; protectionSpell
					96 ; auraSpell
					11 ; glideSpell
					102 ; healingSpell
				)
				(gCurRoom doVerb: theVerb)
			)
			((OneOf theVerb 4 33) ; Do, theGrapnel
				(if gNight
					(if (== (gEgo trySkill: 11 200) 1) ; climbing
						(gCurRoom setScript: sClimbTheTree)
					else
						(gMessager say: 13 4 0 0) ; "These trees look too difficult for an unskilled person like yourself to climb."
					)
				else
					(gMessager say: 13 4 28) ; "It's much easier to just walk through the gate."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 160 1 116 13 80 13 61 11 49 26 43 26 29 18 17 25 9 40 18 74 25 90 18 116 29 151 67 189 0 189
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fTreeRight of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 256
		approachY 180
		x 285
		y 95
	)

	(method (doVerb theVerb)
		(cond
			(
				(OneOf
					theVerb
					85 ; calmSpell
					86 ; flameDartSpell
					88 ; forceBoltSpell
					79 ; frostSpell
					95 ; invisibleSpell
					91 ; jugglingLightsSpell
					93 ; lightningBallSpell
					80 ; openSpell
					98 ; resistanceSpell
					83 ; dazzleSpell
					90 ; reversalSpell
					84 ; zapSpell
					87 ; fetchSpell
					82 ; triggerSpell
					92 ; summonStaffSpell
					97 ; protectionSpell
					96 ; auraSpell
					11 ; glideSpell
					102 ; healingSpell
				)
				(gCurRoom doVerb: theVerb)
			)
			((OneOf theVerb 4 33) ; Do, theGrapnel
				(if gNight
					(if (== (gEgo trySkill: 11 200) 1) ; climbing
						(gCurRoom setScript: sClimbTheTree)
					else
						(gMessager say: 13 4 0 0) ; "These trees look too difficult for an unskilled person like yourself to climb."
					)
				else
					(gMessager say: 13 4 28) ; "It's much easier to just walk through the gate."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 319 2 319 189 269 189 293 152 308 106 309 86 304 67 292 46 270 40 263 20 236 26 227 22 218 9 209 9 199 2
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fFlowers of Feature
	(properties
		noun 4
		nsLeft 98
		nsTop 75
		nsRight 227
		nsBottom 114
		sightAngle 180
		approachX 159
		approachY 119
		x 162
		y 94
	)

	(method (doVerb theVerb)
		(cond
			(
				(OneOf
					theVerb
					85 ; calmSpell
					86 ; flameDartSpell
					88 ; forceBoltSpell
					79 ; frostSpell
					95 ; invisibleSpell
					91 ; jugglingLightsSpell
					93 ; lightningBallSpell
					80 ; openSpell
					98 ; resistanceSpell
					83 ; dazzleSpell
					90 ; reversalSpell
					84 ; zapSpell
					87 ; fetchSpell
					82 ; triggerSpell
					92 ; summonStaffSpell
					97 ; protectionSpell
					96 ; auraSpell
					11 ; glideSpell
					102 ; healingSpell
				)
				(gCurRoom doVerb: theVerb)
			)
			((== theVerb 4) ; Do
				(if (gEgo has: 40) ; theFlowers
					(gMessager say: 4 4 13) ; "You already have some flowers."
				else
					(gCurRoom setScript: sGetFlowers)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fArchWay of Feature
	(properties
		noun 10
		nsLeft 10
		nsTop 26
		nsRight 30
		nsBottom 45
		sightAngle 180
		approachX 28
		approachY 52
		x 27
		y 33
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:) type: PNearestAccess init: 49 52 12 71 8 46 yourself:)
					1
					7
					5
					sTo260
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				85 ; calmSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				95 ; invisibleSpell
				91 ; jugglingLightsSpell
				93 ; lightningBallSpell
				80 ; openSpell
				98 ; resistanceSpell
				83 ; dazzleSpell
				90 ; reversalSpell
				84 ; zapSpell
				87 ; fetchSpell
				82 ; triggerSpell
				92 ; summonStaffSpell
				97 ; protectionSpell
				96 ; auraSpell
				11 ; glideSpell
				102 ; healingSpell
			)
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fTreeKnot of Feature
	(properties
		noun 11
		nsLeft 2
		nsTop 86
		nsRight 16
		nsBottom 107
		sightAngle 180
		x 9
		y 96
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				85 ; calmSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				95 ; invisibleSpell
				91 ; jugglingLightsSpell
				93 ; lightningBallSpell
				80 ; openSpell
				98 ; resistanceSpell
				83 ; dazzleSpell
				90 ; reversalSpell
				84 ; zapSpell
				87 ; fetchSpell
				82 ; triggerSpell
				92 ; summonStaffSpell
				97 ; protectionSpell
				96 ; auraSpell
				11 ; glideSpell
				102 ; healingSpell
			)
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fGrass of Feature
	(properties
		noun 12
		sightAngle 180
		approachX 250
		approachY 152
		approachDist 156
		x 93
		y 93
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 93 93 101 105 142 111 162 115 188 115 229 104 233 93 212 73 220 72 243 78 267 92 276 105 271 117 231 137 182 148 123 146 82 133 58 118 54 99 69 85 97 74 127 70
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				85 ; calmSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				95 ; invisibleSpell
				91 ; jugglingLightsSpell
				93 ; lightningBallSpell
				80 ; openSpell
				98 ; resistanceSpell
				83 ; dazzleSpell
				90 ; reversalSpell
				84 ; zapSpell
				87 ; fetchSpell
				82 ; triggerSpell
				92 ; summonStaffSpell
				97 ; protectionSpell
				96 ; auraSpell
				11 ; glideSpell
				102 ; healingSpell
			)
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fBuildings of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 250
		approachY 152
		approachDist 156
		x 158
		y 22
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 49 27 59 12 116 14 158 1 187 1 288 49 190 58 176 51 161 53 149 52 140 58 41 48 40 26
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				85 ; calmSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				95 ; invisibleSpell
				91 ; jugglingLightsSpell
				93 ; lightningBallSpell
				80 ; openSpell
				98 ; resistanceSpell
				83 ; dazzleSpell
				90 ; reversalSpell
				84 ; zapSpell
				87 ; fetchSpell
				82 ; triggerSpell
				92 ; summonStaffSpell
				97 ; protectionSpell
				96 ; auraSpell
				11 ; glideSpell
				102 ; healingSpell
			)
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance specialEFtr2 of Feature
	(properties)

	(method (init)
		(if (not (gCurRoom exitList:))
			(gCurRoom exitList: (List new:))
		)
		((gCurRoom exitList:) add: self)
	)

	(method (onMe param1 param2)
		(if (and (<= nsLeft param1 nsRight) (<= nsTop param2 nsBottom))
			(gGlory handsOff:)
			(if (and approachX approachY)
				(gCurRoom north: 280)
				(gEgo setMotion: ((ScriptID 17) new:) approachX approachY) ; pOffMover
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance gateTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 11 (> [gEgoStats 11] 5) 12 (> [gEgoStats 29] 5)) ; Climb Over Gate, climbing, Levitate Over Gate, levitateSpell
	)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(sTo290Night cue:)
		)
		(return 1)
	)

	(method (sayMessage)
		(switch iconValue
			(11 ; Climb Over Gate
				(if (== (gEgo trySkill: 11 200) 1) ; climbing
					(= global423 1)
					(self clean:)
					(gCurRoom setScript: sClimbTheGate)
				else
					(gMessager say: 9 125 11) ; "You try to climb over the gate, but slip. You'll need more practice to make it over."
					(self clean:)
					(sTo290Night cue:)
				)
			)
			(12 ; Levitate Over Gate
				(gEgo castSpell: 29)
				(= global423 2)
				(self clean:)
				(gCurRoom setScript: sClimbTheGate)
			)
			(else
				(super sayMessage:)
			)
		)
	)
)

(instance piotyrTalker of GloryTalker
	(properties
		x 0
		y -2
		talkWidth 150
		view 296
		textX 140
		textY 20
	)

	(method (init)
		(super init: piotyrMouth 0 piotyrEyes piotyrFrame &rest)
	)
)

(instance piotyrFrame of View
	(properties
		y -2
		view 296
	)
)

(instance piotyrMouth of Prop
	(properties
		nsLeft 62
		nsTop 44
		x 62
		y 44
		view 296
		loop 1
	)
)

(instance piotyrEyes of Prop
	(properties
		nsLeft 63
		nsTop 38
		x 63
		y 38
		view 296
		loop 2
	)
)

(instance sndPullFlowers of Sound
	(properties
		number 967
	)
)

(instance sndMagic of Sound
	(properties
		number 932
	)
)

(instance sndExplosive of Sound
	(properties
		number 971
	)
)

(instance sndLightning of Sound
	(properties
		number 974
		loop -1
	)
)

(instance sndThud of Sound
	(properties
		number 964
	)
)

(instance sndMagic2 of Sound ; UNUSED
	(properties
		number 934
	)
)

(instance sndDisappear of Sound ; UNUSED
	(properties
		number 939
	)
)

