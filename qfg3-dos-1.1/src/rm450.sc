;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use Teller)
(use n026)
(use OccasionalCycle)
(use PolyPath)
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
	rm450 0
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
	local8
	local9
	local10
	local11
	local12
	[local13 20] = [0 -7 -8 -9 -3 -12 -20 -65 -25 -26 -38 -39 -47 -48 -42 -49 -40 -59 -58 999]
	[local33 4]
	[local37 3] = [0 -12 999]
	[local40 5] = [0 -13 -14 -15 999]
	[local45 15] = [0 -45 -1 -18 -19 -11 -5 -68 -67 -66 -10 -22 -44 26 999]
	[local60 2]
	[local62 4] = [0 5 6 999]
	[local66 2]
	[local68 3] = [0 7 999]
	[local71 2]
	[local73 4] = [0 58 59 999]
	[local77 2]
)

(instance rm450 of Rm
	(properties
		noun 10
		picture 450
	)

	(method (init)
		(= [local33 0] @local13)
		(= [local33 1] @local40)
		(= [local60 0] @local45)
		(= [local66 0] @local62)
		(= [local71 0] @local68)
		(= [local77 0] @local73)
		(Load rsMESSAGE 450)
		(LoadMany rsVIEW 450 451 423)
		(HandsOn)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 116 136 126 128 173 128 185 141 183 150 142 154 116 152
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 267 189 267 163 290 163 290 142 275 142 253 130 239 122 164 111 160 101 135 101 135 113 67 125 42 125 42 149 77 149 77 163 108 163 108 189
					yourself:
				)
		)
		((ScriptID 42 0) y: 100) ; laibonTalker
		(cond
			((and gNight (IsFlag 50))
				(= local11 7)
			)
			((and (IsFlag 16) (not (IsFlag 163)))
				(= local11 8)
			)
			(
				(and
					(not (== global392 4))
					(== global392 1)
					(gEgo has: 21) ; theSkins
					(gEgo has: 40) ; theRobe
					(gEgo has: 3) ; theFineSpear
					(>= ((gInventory at: 21) amount:) 5) ; theSkins
				)
				(= global392 2)
				(= local11 6)
			)
			((and (IsFlag 29) (not (IsFlag 38)) (== global392 0))
				(= local11 3)
			)
			(
				(and
					(IsFlag 38)
					(not (IsFlag 11))
					(gEgo has: 22) ; theHorn
					(or (== gBaseHeroType 0) (== gBaseHeroType 3)) ; Fighter, Paladin
				)
				(= local11 5)
			)
			((and (not (IsFlag 65)) (IsFlag 38))
				(= global392 1)
				(= local11 4)
			)
			((and (not (IsFlag 74)) (IsFlag 49) (not gNight))
				(= local11 1)
			)
			(else
				(= local11 2)
			)
		)
		(if (not (or (gEgo has: 46) (IsFlag 13) (IsFlag 74))) ; theMagicDrum
			(drum init: stopUpd:)
		)
		(if (not (IsFlag 49))
			(= local11 0)
		)
		(fire setCycle: Fwd init:)
		(trunkLid init: stopUpd:)
		(crack init:)
		(leopardhide init:)
		(shields init:)
		(gLongSong number: 913 setLoop: -1 play: 127)
		(if (and (== local11 7) (IsFlag 50))
			(gLongSong setLoop: -1 number: 400 play:)
		else
			(gLongSong setLoop: -1 number: 450 play:)
		)
		(laibonTell init: (ScriptID 42 1) @local13 @local33 @local37) ; Laibon
		(egoTell init: gEgo @local45 @local60)
		(cond
			((== local11 0)
				(= global392 0)
				(rakeeshTell init: (ScriptID 35 1) @local62 @local66) ; Rakeesh
				(uhuraTell init: native @local68 @local71)
				((ScriptID 34 0) ; uhuraTalker
					x: 196
					y: 10
					textX: -175
					textY: 3
					talkWidth: 140
				)
				((ScriptID 35 0) ; rakeeshTalker
					x: 196
					y: 80
					textX: -175
					textY: 3
					talkWidth: 140
				)
				((ScriptID 42 1) ; Laibon
					view: 451
					x: 80
					y: 116
					setPri: 6
					setScale:
					scaleX: 154
					scaleY: 154
					noun: 4
					init:
				)
				(laibonArm
					setScale:
					scaleX: 154
					scaleY: 154
					init:
					setCycle: Snooze self 1 10 200
				)
				(native
					setScale: 160
					setScale:
					scaleX: 156
					scaleY: 156
					init:
					noun: 1
					stopUpd:
				)
				((ScriptID 35 1) ; Rakeesh
					view: 964
					loop: 3
					cel: 3
					x: 209
					y: 150
					noun: 2
					setScale:
					scaleX: 156
					scaleY: 156
					init:
				)
				(gEgo
					loop: 1
					setScale:
					scaleX: 156
					scaleY: 156
					setHeading: 315
					x: 105
					y: 150
					noun: 3
					init:
					normalize: 7
				)
				(gCurRoom setScript: enterFirstTime)
			)
			((OneOf local11 1 2 3 4 5 6)
				(gCurRoom setScript: enterRoom)
			)
			((== local11 7)
				((ScriptID 42 1) ; Laibon
					view: 453
					x: 216
					y: 109
					setCycle: Snooze self 1 10 150
					setScript: laibonSnoozes
					init:
				)
				(if (IsFlag 50)
					(crack dispose:)
					(hole init: stopUpd:)
					(gEgo
						x: 213
						y: 120
						normalize:
						setScale:
						scaleX: 156
						scaleY: 156
						init:
						code: sneakCheck
					)
				else
					(gGame setScript: enterNormal)
				)
			)
			((== local11 8)
				(yesufuTell init: (ScriptID 39 1) @local73 @local77) ; Yesufu
				(gCurRoom setScript: afterContest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(75 ; openSpell
				(if (gEgo castSpell: 19)
					(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
					(gEgo setScript: (ScriptID 13) 0 trunkLid) ; castOpenScript
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			((and (not (gEgo script:)) (== local11 3) (== local2 5))
				(gEgo setScript: egoExits)
			)
			((and (not (gEgo script:)) (== local11 4) (== local2 4))
				(gEgo setScript: egoExits)
			)
			((and (not local1) (== local11 5) (== local2 4))
				(= local1 1)
				(gMessager say: 4 6 46) ; "Did you indeed bring me the horn of Running Death?"
			)
			(
				(and
					(not (gEgo script:))
					(not (gCurRoom script:))
					(!= local11 7)
					(> (gEgo y:) 170)
				)
				(gCurRoom setScript: egoExits)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (gGame script:)
			(gGame setScript: 0)
		)
		(gLongSong stop:)
		(gLongSong3 stop:)
		(UnLoad 143 450)
		(UnLoad 128 450)
		(UnLoad 128 451)
		(UnLoad 128 423)
		((ScriptID 42 1) setCycle: 0) ; Laibon
		(laibonArm setCycle: 0)
		(LoadMany 0 35 13 12 34 33 42 939 39)
		(if gList
			(gList eachElementDo: #dispose)
		)
		(super dispose:)
	)
)

(instance exitThief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 4 0 0 self) ; "You widen the crack in the wall and make your escape."
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance laibonSnoozes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFx number: 941 play:)
				(= state -1)
				(= seconds (Random 5 15))
			)
		)
	)
)

(instance afterContest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 39 1) ; Yesufu
					x: 148
					y: 110
					loop: 2
					setScale:
					scaleX: 156
					scaleY: 156
					noun: 6
					init:
				)
				((ScriptID 42 1) ; Laibon
					view: 451
					x: 80
					y: 116
					setPri: 6
					setScale:
					scaleX: 154
					scaleY: 154
					noun: 4
					init:
				)
				(laibonArm
					setScale:
					scaleX: 154
					scaleY: 154
					init:
					setCycle: Snooze self 1 10 200
				)
				(gEgo
					x: 250
					y: 180
					view: 0
					normalize:
					setScale:
					scaleX: 156
					scaleY: 156
					noun: 3
					init:
					setMotion: PolyPath 140 130 self
				)
			)
			(1
				(= cycles 18)
			)
			(2
				(gMessager say: 4 6 58 0 self) ; "You have proved yourselves to be Warriors of the Simbani. Nimefurahi."
			)
			(3
				(if global406
					(gMessager say: 4 6 64 0 self) ; "Though Yesufu is a brave Warrior, young hero, you have proven yourself to be the winner."
				else
					(gMessager say: 4 6 62 0 self) ; "Though you are very brave, young hero, you were not as skilled as Yesufu. Yesufu has shown himself to be a true Simbani Warrior."
				)
			)
			(4
				(gMessager say: 4 6 59 0 self) ; "You may ask of me what it be that you desire."
			)
			(5
				(cond
					((and (not global406) (IsFlag 30))
						(gEgo get: 46) ; theMagicDrum
						(SetFlag 163)
						(gMessager say: 6 6 60 0 self) ; "During the contest you helped free me from the trap. Asante, Warrior."
					)
					((and (not global406) (not (IsFlag 30)))
						(gMessager say: 6 6 61 0 self) ; "When I was trapped in the contest, you cared more for winning than for helping another in need. You be not worthy to be a Simbani."
					)
					(global406
						(gEgo get: 46) ; theMagicDrum
						(SetFlag 163)
						(self cue:)
					)
				)
			)
			(6
				(cond
					((and (not global406) (IsFlag 30))
						(gCurRoom newRoom: 420)
					)
					((not global406)
						(EgoDead 72) ; "You're well on your way to becoming a hero. (NOT!) Either get a little better at your chosen profession or learn to be nice."
					)
					(else
						(gMessager say: 4 6 63 0 self) ; "What is it that the young hero from far away wishes?"
					)
				)
			)
			(7
				(proc0_13)
				(= seconds 20)
			)
			(8
				(gCurRoom setScript: egoExits)
			)
		)
	)
)

(instance eventFour of Script
	(properties)

	(method (doit)
		(if (or local0 (== state 4))
			(= local0 0)
			(self changeState: (= state 2))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo normalize:)
				(= seconds 5)
			)
			(2
				(= cycles 250)
			)
			(3
				(gMessager say: 4 6 16 0 self) ; "For what have you come here, friend of Rakeesh?"
				(gEgo addHonor: -10)
			)
			(4 0)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 42 1) ; Laibon
					x: 80
					y: 116
					setPri: 6
					setScale:
					scaleX: 154
					scaleY: 154
					noun: 4
					init:
				)
				(laibonArm
					setScale:
					scaleX: 154
					scaleY: 154
					init:
					setCycle: Snooze self 1 10 200
				)
				(gEgo
					normalize:
					setScale:
					scaleX: 156
					scaleY: 156
					x: 260
					y: 185
					noun: 3
					setMotion: PolyPath 240 140 self
					init:
				)
			)
			(1
				(gEgo setMotion: PolyPath 142 128 self)
			)
			(2
				(if (OneOf local11 4 5 6)
					(gGame setScript: eventFour)
				else
					(gGame setScript: eventsTwoAndThree)
				)
				(self dispose:)
			)
		)
	)
)

(instance eventsTwoAndThree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gEgo code: outCheck setHeading: 315)
				(= seconds 5)
			)
			(1
				(++ local9)
			)
			(2
				(gEgo normalize:)
				(= seconds 30)
			)
			(3
				(cond
					((== local11 3)
						(gMessager say: 4 6 25) ; "The Leopardman prisoner will be guarded at all times. So far, he will not talk and tell us where his village hides. When he does, the Simbani will destroy his village, and return with the Spear of Death."
						(= seconds 10)
					)
					((== local11 1)
						(self cue:)
					)
					((== local10 0)
						(gMessager say: 4 6 16) ; "For what have you come here, friend of Rakeesh?"
						(= seconds 10)
					)
				)
			)
			(4
				(if (== local10 0)
					(gMessager say: 4 6 17 0 self) ; "I be the Laibon of the Simbani. I be a very busy man. I do not have time to watch and listen to you do nothing. Speak or leave."
				else
					(self cue:)
				)
			)
			(5
				(gMessager say: 4 6 21 0 self) ; "Go from here, for you have wasted my time long enough."
			)
			(6
				(gCurRoom setScript: egoExits)
				(self dispose:)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setScript: 0)
				(cond
					((and (== local2 5) (== local11 3))
						(gMessager say: 4 6 25 0 self) ; "The Leopardman prisoner will be guarded at all times. So far, he will not talk and tell us where his village hides. When he does, the Simbani will destroy his village, and return with the Spear of Death."
					)
					(
						(and
							(== local2 4)
							(== local11 4)
							(== gBaseHeroType 0) ; Fighter
							(not (IsFlag 16))
						)
						(gMessager say: 4 6 43 0 self) ; "Before you can wed someone in this tribe, you must be a Warrior of the Simbani. If you seek to buy the prisoner for a bride, you must bring me the horn of Running Death first. When you are initiated as a Simbani Warrior, then you can buy the bride."
					)
					(
						(and
							(== gBaseHeroType 0) ; Fighter
							(gEgo has: 21) ; theSkins
							(gEgo has: 40) ; theRobe
							(gEgo has: 3) ; theFineSpear
							(IsFlag 16)
							(== global392 2)
						)
						(gMessager say: 4 6 40) ; "Do you have the bride price?"
						(self setScript: egoBuysJohari self)
					)
					(
						(and
							(!= gBaseHeroType 0) ; Fighter
							(gEgo has: 21) ; theSkins
							(gEgo has: 40) ; theRobe
							(gEgo has: 3) ; theFineSpear
							(== global392 2)
						)
						(gMessager say: 4 6 40) ; "Do you have the bride price?"
						(self setScript: egoBuysJohari self)
					)
					((and (== local11 5) (not (IsFlag 11)))
						(self setScript: egoGivesHorn)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (and (== local2 4) (== local11 4))
					(gMessager say: 4 6 26 0 self) ; "The bride price of the prisoner is set at five zebra skins, one fine robe, and a fine spear. If you wish such a wife, bring those things to me."
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setMotion: PolyPath 290 220 self)
			)
			(3
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance egoBows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo addHonor: 5)
				(gEgo view: 32 loop: 1 setCycle: End self)
			)
			(1
				(gEgo normalize: 7)
				(= cycles 6)
			)
			(2
				(= local12 1)
				(switch register
					(-1
						(gMessager say: 3 5 1 0 self) ; "You greet the Laibon."
					)
					(-18
						(gMessager say: 3 5 18 0 self) ; "You say habari to the Laibon."
					)
					(-19
						(gMessager say: 3 5 19 0 self) ; "You greet the Laibon again."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance egoBuysJohari of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo drop: 21 5 drop: 40 1 drop: 3 1) ; theSkins, theRobe, theFineSpear
				(= global366 11)
				(gEgo solvePuzzle: 272 3)
				(gEgo solvePuzzle: 274 3)
				(gEgo solvePuzzle: 273 3)
				(gTheIconBar advanceCurIcon:)
				(gEgo setMotion: PolyPath 89 132 self)
			)
			(1
				(laibonArm hide:)
				((ScriptID 42 1) cel: 0 loop: 2 setCycle: End self) ; Laibon
			)
			(2
				(gMessager say: 4 6 29 0 self) ; "You shall find it most interesting to be married to a wildcat. I accept your bride price and the Leopardman prisoner is now your wife."
			)
			(3
				((ScriptID 42 1) setCycle: Beg self) ; Laibon
			)
			(4
				(laibonArm show:)
				(= global392 4)
				((ScriptID 42 1) loop: 0) ; Laibon
				(if (!= client egoExits)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance pickLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 232 140 self)
			)
			(1
				(HandsOn)
				(gLongSong2 number: 311 setLoop: 1 play:)
				(gMessager say: 7 17) ; "The lock opens, but you hear a slight squeak."
				(= local7 1)
				(self dispose:)
			)
		)
	)
)

(instance egoOilsChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 232 140 self)
			)
			(1
				(HandsOn)
				(gMessager say: 7 35) ; "You oil the chest's hinges. That should take care of the squeaking."
				(= local5 1)
				(self dispose:)
			)
		)
	)
)

(instance castOpenOnChest of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((not local5)
						(gLongSong2 number: 311 setLoop: 1 play:)
						(if (not local7)
							(= local7 1)
							(gMessager say: 7 75 78) ; "Your Open spell has unlocked the chest, but you heard a slight squeak as the lid settled."
						else
							(gMessager say: 7 75 54) ; "You are surprised by a loud squeak as your spell lifts up the lid."
							(sFx number: 640 play:)
							(trunkLid setCel: 1)
							(gCurRoom setScript: wakeUpChuckSpear 0 56)
							(self dispose:)
						)
					)
					((not local7)
						(= local7 1)
						(gLongSong2 number: 311 setLoop: 1 play:)
						(gMessager say: 7 75 74) ; MISSING MESSAGE
					)
					(else
						(gMessager say: 7 75 53) ; "You quietly open the chest. Inside you find a fine dagger, 700 commons and 60 royals. You place them in your pack."
						(trunkLid setCel: 1)
						(gEgo get: 2) ; theFineDagger
						(+= global410 700)
						((gInventory at: 0) ; theRoyals
							amount: (+ ((gInventory at: 0) amount:) 60) ; theRoyals
						)
						((gInventory at: 0) message: 10) ; theRoyals
					)
				)
			)
			(1
				(HandsOn)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance castOpenOnCrack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_14 220 78)
				(cond
					((== (= temp0 (gEgo castSpell: 19)) 1)
						(gMessager say: 9 6 35) ; "You cast your Open spell at the crack in the wall."
						(self setScript: (ScriptID 13 0) self) ; castOpenScript
					)
					((== temp0 -1)
						(self setScript: (ScriptID 13 0) self) ; castOpenScript
					)
				)
			)
			(1
				(if (== temp0 0) ; UNINIT
					(HandsOn)
					(gEgo normalize:)
					(self dispose:)
				)
				(crack dispose:)
				(hole init: stopUpd:)
				(HandsOn)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance enterFirstTime of Script
	(properties)

	(method (doit)
		(return
			(if (gEgo script:)
				0
			else
				(super doit:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(= cycles 3)
			)
			(1
				1
				(gMessager say: 1 6 1) ; "Habari, Laibon Mkubwa."
				(= cycles 1)
			)
			(2
				2
				((ScriptID 35 1) cycleSpeed: 10 setCycle: Beg self) ; Rakeesh
			)
			(3
				3
				((ScriptID 35 1) setCycle: End self) ; Rakeesh
			)
			(4
				4
				((ScriptID 35 1) stopUpd:) ; Rakeesh
				(laibonArm cycleSpeed: 8 setCycle: End self)
			)
			(5
				5
				(gMessager say: 2 6 1 0 self) ; "Mzuri sana, Laibon Mkubwa. It is good to see you again, great leader of the Simbani people."
			)
			(6
				6
				(proc0_13)
				(gTheIconBar curIcon: (gTheIconBar at: 4))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= ticks 600)
			)
			(7
				7
				(gMessager say: 2 6 2 0 self) ; "Laibon, I have come here to bring peace to your people and the Leopardmen. I have sworn this by my honor."
			)
			(8
				8
				(gMessager say: 4 6 3 0 self) ; "The Leopardmen have always been our enemies. They be sneaky and not to be trusted, for they only travel at night. The worst of all be that they use magic."
			)
			(9
				9
				(= ticks 960)
			)
			(10
				10
				(gEgo cycleSpeed: 6)
				(HandsOff)
				(laibonArm setCycle: End self)
			)
			(11
				11
				(gMessager say: 2 6 4) ; "There are ways to resolve the conflicts between the Simbani and the Leopardmen other than through waging war."
				(laibonArm setCycle: Beg self)
			)
			(12
				12
				(SetFlag 49)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 0 9)
				(= cycles 2)
			)
			(13
				13
				(gMessager say: 9 6 71 0 self) ; "You all walk back to Uhura's hut to rest and discuss things before evening."
			)
			(14
				14
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance laibonPissed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCurRoom script:)
					((gCurRoom script:) dispose:)
				)
				(laibonArm hide:)
				((ScriptID 42 1) view: 451 loop: 2 cel: 0 setCycle: End self) ; Laibon
			)
			(1
				(gEgo
					solvePuzzle: 276 -5
					normalize:
					setMotion: PolyPath 290 190 self
				)
			)
			(2
				(HandsOff)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance wakeUpChuckSpear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(HandsOff)
				(gEgo code: 0 changeGait: 1 setMotion: PolyPath 143 123 self) ; running
				((ScriptID 42 1) view: 453 loop: 1 cycleSpeed: 10 setCycle: End) ; Laibon
			)
			(2
				(gEgo setMotion: PolyPath 120 124 self)
			)
			(3
				(gLongSong2 number: 916 setLoop: 1 play:)
				((ScriptID 42 1) ; Laibon
					view: 453
					loop: 2
					cel: 0
					cycleSpeed: 3
					setCycle: CT 4 1 self
				)
			)
			(4
				((ScriptID 42 1) setCel: 5) ; Laibon
				(spear setStep: 22 2 setMotion: MoveTo 120 81 self init:)
			)
			(5
				(spear dispose:)
				(gLongSong2 number: 920 setLoop: 1 play: self)
			)
			(6
				(gLongSong2 number: 912 play:)
				(gEgo view: 43 loop: 1 setCycle: End self)
			)
			(7
				(EgoDead register 0 455 End)
			)
		)
	)
)

(instance enterNormal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 42 1) setCycle: Snooze self 1 10 200 noun: 4 init:) ; Laibon
				(gEgo
					x: 234
					y: 172
					setScale:
					init:
					setMotion: PolyPath 143 124 self
				)
			)
			(1
				(gEgo setHeading: 315 normalize: 7)
				(HandsOn)
				(if (== local11 7)
					(gEgo code: sneakCheck)
				)
				(self dispose:)
			)
		)
	)
)

(instance checkOutChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 232 140 self)
			)
			(1
				(if (== local7 0)
					(gMessager say: 7 4 52) ; "The chest is securely locked."
					(HandsOn)
					(self dispose:)
				)
				(= cycles 1)
			)
			(2
				(if (== local5 0)
					(gMessager say: 7 4 54) ; "You are surprised by a loud squeak as you lift up the lid."
					(++ local6)
					(sFx number: 640 play:)
					(if (== local6 2)
						(trunkLid setCel: 1)
						(gCurRoom setScript: wakeUpChuckSpear 0 56)
					)
					(HandsOn)
					(self dispose:)
				)
				(= cycles 1)
			)
			(3
				(trunkLid setCel: 1)
				(= cycles 6)
			)
			(4
				(gMessager say: 7 4 53 0 self) ; "You quietly open the chest. Inside you find a fine dagger, 700 commons and 60 royals. You place them in your pack."
			)
			(5
				(gEgo get: 2) ; theFineDagger
				(+= global410 700)
				((gInventory at: 0) amount: (+ ((gInventory at: 0) amount:) 60)) ; theRoyals, theRoyals
				((gInventory at: 0) message: 10) ; theRoyals
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance hoarkDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 114 122 self)
			)
			(1
				(gMessager say: 5 4 0 0 self) ; "You try to stealthily pick up the Drum of Magic."
			)
			(2
				(if (<= (gEgo trySkill: 8 125) 0) ; sneak
					(gCurRoom setScript: wakeUpChuckSpear 0 34)
				else
					(if (IsFlag 50)
						(SetFlag 74)
					)
					(gEgo get: 46) ; theMagicDrum
					(SetFlag 163)
					(drum dispose:)
					(= global470 gDay)
					(gEgo solvePuzzle: 275 8 4)
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance egoGivesHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 89 132 self)
			)
			(1
				(laibonArm hide:)
				((ScriptID 42 1) loop: 2 setCycle: End) ; Laibon
				(= seconds 3)
			)
			(2
				((ScriptID 42 1) setCycle: Beg self) ; Laibon
			)
			(3
				(gEgo drop: 22 1) ; theHorn
				(SetFlag 11)
				(gEgo solvePuzzle: 271 3 9)
				((ScriptID 42 1) loop: 0) ; Laibon
				(laibonArm show: setCycle: Snooze self 1 20 290)
				(= cycles 1)
			)
			(4
				(gMessager say: 4 6 27 0 self) ; "Tomorrow we shall hold an initiation ritual to see if you are worthy to become a Simbani Warrior."
			)
			(5
				(gMessager say: 4 6 28 0 self) ; "My son Yesufu has given me the dinosaur horn and will soon be initiated as well. We will see who will make the best Simbani Warrior."
			)
			(6
				(gEgo setMotion: PolyPath 290 220 self)
			)
			(7
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 0 9)
				(= cycles 3)
			)
			(8
				((ScriptID 7 4) init: 6 0) ; fixTime
				(= [gEgoStats 18] (gEgo maxMana:)) ; mana
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 16] (gEgo maxHealth:)) ; health
				(gMessager say: 9 6 27 0 self) ; "You go to your hut and rest up for the next day."
			)
			(9
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance getDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 5 register 0 self)
			)
			(1
				(if (not (gEgo has: 46)) ; theMagicDrum
					(gEgo get: 46) ; theMagicDrum
					(SetFlag 163)
				)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance bridePrice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 5 40 0 self) ; "The price I set for the prisoner is high, for I want the husband to value her and not let her escape. Also, I do not want my son Yesufu to wed such a creature. She is an enemy of the Simbani."
			)
			(1
				(if (and (== gBaseHeroType 0) (not (IsFlag 16))) ; Fighter
					(gMessager say: 4 6 41 0 self) ; "Only Warriors of the Simbani may buy this bride. If you are interested in the Leopardman woman, you must become a Simbani Warrior in an initiation ritual."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance moveEgoBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(- (gEgo x:) 10)
						(- (gEgo y:) 20)
						self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance spear of Actor
	(properties
		x 163
		y 81
		view 453
		loop 3
		signal 2048
	)
)

(instance native of Prop
	(properties
		x 250
		y 140
		view 970
		loop 4
		cel 3
		signal 16384
	)
)

(instance fire of Prop
	(properties
		x 148
		y 140
		noun 11
		view 423
		cel 12
		signal 16384
	)
)

(instance hole of View
	(properties
		x 200
		y 64
		noun 12
		view 450
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: exitThief)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance drum of View
	(properties
		x 105
		y 74
		noun 5
		view 450
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local11 7)
					(gCurRoom setScript: hoarkDrum)
				else
					(gMessager say: 4 6 12) ; "You have no right to touch the Drum of Magic. Leave it be! Go from here now!"
					((ScriptID 42 1) setScript: laibonPissed) ; Laibon
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trunkLid of Prop
	(properties
		x 277
		y 126
		noun 7
		view 450
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((!= local11 7)
						(gMessager say: 7 4 73) ; "That wouldn't be wise, with the Laibon watching and all."
					)
					((not (== cel 1))
						(gCurRoom setScript: checkOutChest)
					)
				)
			)
			(-75 ; openSpell
				(cond
					((!= local11 7)
						(gMessager say: 9 6 73) ; "You'd better wait until after dark."
					)
					((not (== cel 1))
						(gCurRoom setScript: castOpenOnChest)
					)
				)
			)
			(17 ; theToolkit
				(if (and (> (gEgo trySkill: 9 75) 0) (== local7 0)) ; pick locks
					(gCurRoom setScript: pickLock)
				else
					(gMessager say: 9 6 74) ; "The chest is already unlocked."
				)
			)
			(35 ; theOil
				(gCurRoom setScript: egoOilsChest)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance laibonArm of Prop
	(properties
		x 59
		y 77
		view 451
		loop 1
		priority 7
		signal 16
	)
)

(instance crack of Feature
	(properties
		x 216
		y 85
		noun 8
		nsTop 68
		nsLeft 206
		nsBottom 103
		nsRight 227
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (gCast contains: hole))
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(75 ; openSpell
				(gCurRoom setScript: castOpenOnCrack)
			)
			(4 ; Do
				(if gNight
					(hole init: stopUpd:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leopardhide of Feature
	(properties
		x 226
		y 54
		noun 13
		nsTop 35
		nsLeft 193
		nsBottom 73
		nsRight 259
		sightAngle 180
	)
)

(instance shields of Feature
	(properties
		x 146
		y 66
		noun 14
		nsTop 33
		nsLeft 124
		nsBottom 99
		nsRight 169
		sightAngle 180
	)
)

(instance laibonTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-20
				(and (> local11 0) (> local8 0))
				-59
				(== local11 8)
				-58
				(== local11 8)
				-12
				(and (< 0 local11 4) (== local8 0))
				-9
				(< local11 4)
				-39
				(< 3 local11 6)
				-47
				(== global392 2)
				-49
				(== global392 2)
				-40
				(< 3 local11 6)
				-25
				(== local11 3)
				-26
				(< 3 local11 6)
				-42
				(and (== gBaseHeroType 0) (< 3 local11 6) (not (IsFlag 16))) ; Fighter
				-7 ; "Simbani"
				(<= local11 1)
				-3
				(< local11 4)
				-38
				(< 3 local11 6)
				-48
				(== global392 4)
				-65
				(IsFlag 74)
				-8
				(< local11 3)
		)
	)

	(method (doChild)
		(= local0 1)
		(switch query
			(-20
				(if (== local3 255)
					(gMessager say: 4 6 37) ; "Mzuri. We have talked well, young hero. We will speak another time. Kwa heri."
					(gCurRoom setScript: egoExits)
					(return 0)
				else
					((ScriptID 42 1) setScript: laibonPissed) ; Laibon
				)
			)
			(-13
				(++ local2)
				(|= local3 $0020)
				(return 1)
			)
			(-12
				(++ local2)
				(|= local3 $0002)
				(++ local8)
				(gEgo solvePuzzle: 269 2)
				(super doChild: query)
			)
			(-9
				(++ local2)
				(|= local3 $0010)
				(return 1)
			)
			(-39
				(++ local2)
				(return 1)
			)
			(-15
				(++ local2)
				(|= local3 $0080)
				(return 1)
			)
			(-49
				(cond
					((and (== gBaseHeroType 0) (not (IsFlag 16))) ; Fighter
						(return (= query -30))
					)
					(
						(and
							(== gBaseHeroType 0) ; Fighter
							(gEgo has: 21) ; theSkins
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 40) ; theRobe
							(== global392 2)
							(IsFlag 16)
						)
						(gEgo setScript: egoBuysJohari)
						(return 0)
					)
					(
						(and
							(!= gBaseHeroType 0) ; Fighter
							(gEgo has: 21) ; theSkins
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 40) ; theRobe
							(== global392 2)
						)
						(gEgo setScript: egoBuysJohari)
					)
				)
			)
			(-14
				(++ local2)
				(|= local3 $0040)
				(return 1)
			)
			(-68
				(return query)
				(gCurRoom newRoom: 420)
			)
			(-40
				(++ local2)
				(gEgo setScript: bridePrice)
				(return 0)
			)
			(-26
				(++ local2)
				(return 1)
			)
			(-42
				(++ local2)
				(return 1)
			)
			(-7 ; "Simbani"
				(|= local3 $0004)
				(return 1)
			)
			(-3
				(++ local2)
				(|= local3 $0001)
				(gEgo solvePuzzle: 270 2)
				(return query)
			)
			(-38
				(++ local2)
				(return 1)
			)
			(-8
				(|= local3 $0008)
				(return 1)
			)
			(else
				(++ local10)
				(return query)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; theHorn
				(if (== local11 5)
					(gCurRoom setScript: egoGivesHorn)
				else
					(gMessager say: 9 6 75) ; "It would be in your best interest to keep that for now."
				)
				(return 1)
			)
			(31 ; theSkins
				(cond
					(
						(and
							(== global392 2)
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 40) ; theRobe
							(!= gBaseHeroType 0) ; Fighter
						)
						(gCurRoom setScript: egoBuysJohari)
					)
					(
						(and
							(== global392 2)
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 40) ; theRobe
							(IsFlag 16)
							(== gBaseHeroType 0) ; Fighter
						)
						(gCurRoom setScript: egoBuysJohari)
					)
					(
						(and
							(== global392 2)
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 40) ; theRobe
							(not (IsFlag 16))
							(== gBaseHeroType 0) ; Fighter
						)
						(gMessager say: 4 6 30) ; "I can not accept your offer, for you have not shown yourself worthy to be a Warrior in this village. Boys may not marry until they become men, and strangers do not marry until they are Simbani."
					)
					(else
						(gMessager say: 4 6 77) ; "Do not trouble me now with such gestures! Come back another time with your gifts!"
					)
				)
				(return 1)
			)
			(51 ; theRobe
				(cond
					(
						(and
							(== global392 2)
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 21) ; theSkins
							(!= gBaseHeroType 0) ; Fighter
						)
						(gCurRoom setScript: egoBuysJohari)
					)
					(
						(and
							(== global392 2)
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 21) ; theSkins
							(IsFlag 16)
							(== gBaseHeroType 0) ; Fighter
						)
						(gCurRoom setScript: egoBuysJohari)
					)
					(
						(and
							(== global392 2)
							(gEgo has: 3) ; theFineSpear
							(gEgo has: 21) ; theSkins
							(not (IsFlag 16))
							(== gBaseHeroType 0) ; Fighter
						)
						(gMessager say: 4 6 30) ; "I can not accept your offer, for you have not shown yourself worthy to be a Warrior in this village. Boys may not marry until they become men, and strangers do not marry until they are Simbani."
					)
					(else
						(gMessager say: 4 6 77) ; "Do not trouble me now with such gestures! Come back another time with your gifts!"
					)
				)
				(return 1)
			)
			(13 ; theFineSpear
				(cond
					(
						(and
							(== global392 2)
							(gEgo has: 40) ; theRobe
							(gEgo has: 21) ; theSkins
							(!= gBaseHeroType 0) ; Fighter
						)
						(gCurRoom setScript: egoBuysJohari)
					)
					(
						(and
							(== global392 2)
							(gEgo has: 40) ; theRobe
							(gEgo has: 21) ; theSkins
							(IsFlag 16)
							(== gBaseHeroType 0) ; Fighter
						)
						(gCurRoom setScript: egoBuysJohari)
					)
					(
						(and
							(== global392 2)
							(gEgo has: 40) ; theRobe
							(gEgo has: 21) ; theSkins
							(not (IsFlag 16))
							(== gBaseHeroType 0) ; Fighter
						)
						(gMessager say: 4 6 30) ; "I can not accept your offer, for you have not shown yourself worthy to be a Warrior in this village. Boys may not marry until they become men, and strangers do not marry until they are Simbani."
					)
					(else
						(gMessager say: 4 6 77) ; "Do not trouble me now with such gestures! Come back another time with your gifts!"
					)
				)
				(return 1)
			)
			(4 ; Do
				(if gNight
					(gCurRoom setScript: wakeUpChuckSpear 0 55)
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

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-45
				(== local11 5)
				-1
				(and (not local12) (or (== local11 0) (== local11 5)))
				-18
				(and
					(not local12)
					(not local9)
					(or (< 0 local11 5) (== local11 6))
				)
				-19
				(and (not local12) local9)
				-11
				(< local11 3)
				-5 ; "Peace"
				(< local11 3)
				-10
				(== local11 0)
				-22
				(< 0 local11 3)
				-44
				(< 2 local11 5)
				-67
				(and (== local11 8) global406)
				-68
				(and (== local11 8) global406)
				-66
				(or (and (== local11 8) global406) (IsFlag 30))
				26
				(== local11 4)
		)
	)

	(method (doChild)
		(= local0 1)
		(switch query
			(-45
				(gCurRoom setScript: 0)
				(gCurRoom setScript: egoGivesHorn)
				(return query)
			)
			(-10
				(gEgo addHonor: -10)
				(return 1)
			)
			(-22
				(gEgo addHonor: 2)
				(gCurRoom setScript: egoExits)
				(return 1)
			)
			(-44
				(if (== local11 4)
					(= local2 4)
				else
					(= local2 5)
				)
				(gEgo addHonor: 2)
				(gMessager say: 3 5 44) ; "You tell the Laibon kwa heri."
				(gEgo setScript: egoExits)
				(return 0)
			)
			(-1
				(gEgo setScript: egoBows 0 query)
				(= local12 0)
				(++ local10)
				(return 0)
			)
			(-18
				(gEgo setScript: egoBows 0 query)
				(= local12 0)
				(++ local10)
				(return 0)
			)
			(-19
				(gEgo setScript: egoBows 0 query)
				(= local12 0)
				(++ local10)
				(return 0)
			)
			(-11
				(++ local10)
			)
			(-5 ; "Peace"
				(gEgo addHonor: 20)
				(++ local10)
			)
			(-67
				(gEgo setScript: getDrum 0 (- 0 query))
				(return 0)
			)
			(-68
				(gEgo setScript: getDrum 0 (- 0 query))
				(return 0)
			)
			(else
				(++ local10)
				(return query)
			)
		)
	)
)

(instance rakeeshTell of Teller
	(properties)
)

(instance uhuraTell of Teller
	(properties)
)

(instance yesufuTell of Teller
	(properties)
)

(instance sFx of Sound
	(properties)
)

(instance Snooze of OccasionalCycle
	(properties)

	(method (cycleDone)
		(= cycleDir (- 0 cycleDir))
		(= waitCycles (Random lowerEnd upperEnd))
		(= cycleCnt (GetTime))
	)
)

(instance sneakCheck of Code
	(properties)

	(method (doit)
		(if (!= (gEgo view:) 2)
			(gCurRoom setScript: wakeUpChuckSpear 0 36)
			(gEgo code: 0)
		)
		(if (gEgo inRect: 0 175 320 190)
			(cond
				((and (not (gEgo script:)) local4)
					(EgoDead 76) ; "Don't say you weren't warned. A successful (also known as "an alive") thief rarely makes the same mistake twice. It's amazing how well some of these guards have been trained."
				)
				((not (gEgo script:))
					(gMessager say: 9 6 33) ; "There is a very alert guard just outside the door. You'd better not go that way."
					(= local4 1)
					(gEgo setScript: moveEgoBack)
				)
			)
		)
	)
)

(instance outCheck of Code
	(properties)

	(method (doit)
		(if (gEgo inRect: 200 175 250 190)
			(gCurRoom newRoom: 420)
		)
	)
)

