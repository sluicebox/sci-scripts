;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use TargFeature)
(use n026)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm380 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm380 of Rm
	(properties
		noun 5
		picture 380
	)

	(method (doit)
		(if
			(and
				(not (== gCurRoom script))
				(or
					(and
						(not (== (gCurRoom script:) egoEnters))
						(& (gEgo onControl: 1) $0004)
					)
					(< (gEgo y:) 65)
				)
			)
			(gCurRoom setScript: getOut)
		)
		(super doit:)
	)

	(method (init)
		(HandsOff)
		(= global426 0)
		(LoadMany rsSCRIPT 956 991)
		(gEgo x: 164 y: 68 setScale: Scaler 75 50 95 0 init: normalize: 2)
		(super init:)
		(gLongSong number: 380 setLoop: -1 play: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 92 85 92 81 103 60 109 70 115 70 136 140 179 177 184 251 184 293 152 232 110 141 96 133 87 178 80 178 76 227 76 263 69 287 71 319 53 319 1 0 1
					yourself:
				)
		)
		(if (IsFlag 52)
			(= local3 1)
		)
		(if (IsFlag 55)
			(= local3 2)
		)
		(if (IsFlag 148)
			(= local3 3)
		)
		(holes init:)
		(sky init:)
		(switch local3
			(0
				(bat1 setPri: 14 init: stopUpd:)
				(bat2 setPri: 14 init: stopUpd:)
				(bat3 setPri: 14 init: stopUpd:)
				(smallBat setPri: 14 init: stopUpd:)
				(mainVine init:)
				(vine1 init: stopUpd:)
				(vine2 init: stopUpd:)
				(vine3 init: stopUpd:)
				(vine4 init: stopUpd:)
				(vine5 init: stopUpd:)
			)
			(1
				(mainVine init:)
				(gEgo code: ambushChek)
			)
			(2
				(if (not (IsFlag 148))
					(stoneRing setPri: 14 init: approachVerbs: 4 stopUpd:) ; Do
				)
				(smallBat setPri: 14 init: stopUpd: setScript: thankYou)
			)
		)
		(HandsOff)
		(self setScript: egoEnters)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: blastVine 0 theVerb)
				)
			)
			(83 ; forceBoltSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: blastVine 0 theVerb)
				)
			)
			(88 ; lightningBallSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: blastVine 0 theVerb)
				)
			)
			(20 ; theDaggers
				(if (not (gCurRoom script:))
					(++ global426)
					(gCurRoom setScript: blastVine 0 theVerb)
				)
			)
			(33 ; theRocks
				(if (not (gCurRoom script:))
					(gCurRoom setScript: blastVine 0 theVerb)
				)
			)
			(1 ; Look
				(if (not local0)
					(gMessager say: 5 1) ; "Rocks surround a small alcove where vines grow profusely."
				else
					(gMessager say: 5 1 15) ; "The vines which grow here have now retreated into small holes in the ground."
				)
				(return 1)
			)
			(75 ; openSpell
				(gMessager say: 1 6 18) ; "There is nothing to open here."
			)
			(4 ; Do
				(if (and (> ((User curEvent:) y:) 30) (== (grabEgo state:) -1))
					(gCurRoom setScript: getRocks)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(SetFlag 54)
		(if gList
			(gList eachElementDo: #dispose)
		)
		(LoadMany 0 956 991 37)
		(super dispose: &rest)
	)
)

(instance getOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo get: 10 global426) ; theDaggers
				(= seconds 1)
			)
			(1
				(= global426 0)
				(gLongSong2 setLoop: 1)
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance thankYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance savedBatEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 120 110 self)
			)
			(1
				(gMessager say: 1 6 17 0 self) ; "As you approach these rocks, you notice the small meerbat watching for you."
			)
			(2
				(smallBat setCycle: End self)
			)
			(3
				(smallBat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance blastVine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(HandsOff)
				(self setScript: (ScriptID 32 0) self register) ; project
			)
			(1
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwHook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 35) ; theVineFruit
					(self dispose:)
				)
				(HandsOff)
				(gEgo setMotion: PolyPath 90 72 self)
			)
			(1
				(gEgo setMotion: PolyPath 93 89 self)
			)
			(2
				(gEgo view: 8 setLoop: 4 setCycle: End self)
				(gLongSong2 number: 721 setLoop: 1 play: 127)
			)
			(3
				(grapThingy
					x: 95
					y: 79
					setLoop: 6
					setScale:
					init:
					setMotion: JumpTo 165 143 self
				)
			)
			(4
				(mainVine cel: 1)
				(mainVine setScript: vinesTwist)
				(gEgo setCycle: Beg)
				(grapThingy setMotion: JumpTo 95 79 self)
				(gLongSong2 number: 511 setLoop: 1 play: 127)
			)
			(5
				(grapThingy dispose:)
				(gMessager say: 1 6 11 0 self) ; "You retrieve the fruit with your magic grapnel, and place both carefully away in your pack."
			)
			(6
				(gEgo get: 35 solvePuzzle: 256 8 normalize:) ; theVineFruit
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoHacksBat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 55)
				(flutterBackToRock dispose:)
				(gEgo setMotion: PolyPath 104 178 self)
			)
			(1
				(gEgo view: 385 loop: 1 cel: 0 setCycle: End self)
				(gLongSong2 number: 520 setLoop: 1 play: 127)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gMessager say: 1 6 9 0 self) ; "You just killed a defenseless meerbat."
			)
			(4
				(if
					(and
						(== gHeroType 0) ; Fighter
						(not (gEgo has: 16)) ; theDispell
						(gEgo code: ambushChek)
						(mainVine init: setCycle: Beg)
					)
				)
				(gEgo normalize:)
				(smallBat dispose:)
				(SetFlag 52)
				(SetFlag 19)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance flutterBackToRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smallBat loop: 6 cel: 8 setCycle: Beg self)
			)
			(1
				(gLongSong2 number: 383 setLoop: 1 play: 127)
				(smallBat loop: 5 setMotion: JumpTo 79 167 self)
				(gEgo code: egoChek)
			)
			(2
				(smallBat loop: 1 cel: 0)
				(= seconds 30)
			)
			(3
				(gLongSong2 stop:)
				(smallBat loop: 0 setCycle: End self)
			)
			(4
				(smallBat hide:)
				(self dispose:)
			)
		)
	)
)

(instance smallBatJump of Script
	(properties)

	(method (doit)
		(if (== local0 1)
			(SetFlag 55)
			(if (not (IsFlag 257))
				(gEgo addHonor: 20)
			)
			(gEgo solvePuzzle: 257 8 9)
			(smallBat setCycle: 0)
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 7)
			)
			(1
				(gEgo code: 0)
				(smallBat loop: 2 setCycle: End self)
			)
			(2
				(gLongSong2 number: 383 setLoop: 1 play: 127)
				(smallBat
					setLoop: 4
					setCycle: Fwd
					setMotion: JumpTo 163 147 self
				)
			)
			(3
				(smallBat setMotion: MoveTo 192 126 self)
			)
			(4
				(mainVine setCycle: Fwd)
				(vine4 setPri: (+ (smallBat priority:) 1) setCycle: Fwd)
				(smallBat cycleSpeed: 6 loop: 4 setCycle: End self)
				(gLongSong2 number: 918 setLoop: 1 play: 127)
			)
			(5
				(HandsOn)
				(gLongSong2 number: 382 setLoop: -1 play: 127)
				(if (> (gGame detailLevel:) 2)
					(smallBat setCycle: Fwd)
				else
					(smallBat stopUpd:)
				)
				(= seconds 20)
			)
			(6
				(smallBat setCycle: End self)
			)
			(7
				(vine4 loop: 5 setCycle: End self)
			)
			(8
				(mainVine setCycle: 0)
				(smallBat hide:)
				(gLongSong2 stop:)
				(SetFlag 52)
				(if (not local2)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance ambush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 6)
				(HandsOff)
				(vine1 loop: 2 cel: 5 init: setCycle: Beg)
				(vine2 loop: 3 cel: 5 init: setCycle: Beg)
				(vine3 loop: 2 cel: 5 init: setCycle: Beg)
				(vine4 loop: 3 cel: 4 init: setCycle: Beg)
				(vine5 loop: 2 cel: 5 init: setCycle: Beg)
				(mainVine setLoop: 0 setCycle: Fwd)
				(gLongSong2 number: 918 setLoop: 1 play: 127)
				(gEgo view: 11 setCycle: End self)
			)
			(1
				(vine1 loop: 0 setCycle: Fwd)
				(vine2 loop: 0 setCycle: Fwd)
				(vine3 loop: 0 setCycle: Fwd)
				(vine4 loop: 0 setCycle: Fwd)
				(vine5 loop: 0 setCycle: Fwd)
				(gEgo cycleSpeed: 8 setCycle: ForwardCounter 3 self)
				(gLongSong2 number: 918 setLoop: -1 play: 127)
			)
			(2
				(gEgo view: 6 setCycle: End self)
			)
			(3
				(EgoDead 6 0 386 End) ; "Some hero. First you don't bother to rescue a fellow being in distress, then you walk right into a trap. Maybe you should have studied your hero manuals harder so you wouldn't have to die in vine."
				(self dispose:)
			)
		)
	)
)

(instance chopVines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				(grabEgo dispose:)
				(gEgo view: 385 loop: 0 cel: 0 setCycle: End self)
				(gLongSong2 number: 520 setLoop: 1 play: 127)
			)
			(1
				(mainVine setScript: vinesGoDown)
				(gEgo setCycle: Beg self)
			)
			(2
				(if (not (gCast contains: smallBat))
					(gEgo code: egoChek)
				)
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance vinesGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(vine1 loop: 2 cel: 0 setCycle: End ignoreActors: 1)
				(vine2 loop: 3 cel: 0 setCycle: End ignoreActors: 1)
				(vine3 loop: 2 cel: 0 setCycle: End ignoreActors: 1)
				(vine4 loop: 3 cel: 0 setCycle: End ignoreActors: 1)
				(vine5 loop: 2 cel: 0 setCycle: End ignoreActors: 1)
				(mainVine loop: 1 cel: 0 setCycle: End self ignoreActors: 1)
				(gLongSong2 number: 918 setLoop: 1 play: 127)
			)
			(1
				(= seconds 1)
			)
			(2
				(vine1 stopUpd:)
				(vine2 stopUpd:)
				(vine3 stopUpd:)
				(vine4 stopUpd:)
				(vine5 stopUpd:)
				(mainVine stopUpd:)
				(if (IsFlag 55)
					(smallBat setScript: flutterBackToRock)
				)
				(self dispose:)
			)
		)
	)
)

(instance grabEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(SetFlag 115)
				(= local2 1)
				(vine3 setCycle: End self)
				(gLongSong2 number: 918 setLoop: 1 play: 127)
			)
			(1
				(gMessager say: 1 6 3 0 self) ; "The vines whip around you and trap your legs, and you burn as the sharp spines inject poison. This is agony."
			)
			(2
				(gEgo
					view: 11
					cycleSpeed: 8
					setCycle: Fwd
					setMotion: MoveTo 115 93
				)
				(HandsOn)
				(gTheIconBar disable: 1 6 5 3 advanceCurIcon:)
				(vine3 setCycle: Fwd)
				(mainVine setCycle: Fwd)
				(gLongSong2 number: 918 setLoop: 1 play: 127)
				(= seconds 1)
			)
			(3
				(if (<= [gEgoStats 16] 1) ; health
					(EgoDead 7 0 386 End) ; "That's another "vine" mess you've gotten yourself into. Your postmortem just got penned by plants, pal."
				)
				(gEgo takeDamage: 1)
				(= seconds 1)
			)
			(4
				(-= state 2)
				(self cue:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 80 self)
			)
			(1
				(= cycles 10)
			)
			(2
				(if (not (IsFlag 54))
					(gMessager say: 1 6 2 0 self) ; "The rocks here form a small alcove where some very interesting looking plants are growing. On the far side, you see some animals watching over the plants. They look like meerkats with wings. They must be meerbats."
				else
					(self cue:)
				)
			)
			(3
				(if (IsFlag 150)
					(gMessager say: 1 6 14 0 self) ; "You sense that there is danger nearby."
				else
					(self cue:)
				)
			)
			(4
				(cond
					((== local3 2)
						(gEgo setScript: savedBatEntrance)
						(HandsOn)
					)
					((and (IsFlag 52) (== gHeroType 0) (not (gEgo has: 16))) ; Fighter, theDispell
						(gEgo code: ambushChek)
						(HandsOn)
					)
					((and (not (IsFlag 52)) (not (IsFlag 55)))
						(bat1 setScript: bat1Hoark)
						(gLongSong2 number: 381 setLoop: 1 play: 127)
						(gEgo code: egoChek)
					)
					(else
						(HandsOn)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance vinesTwist of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mainVine setCycle: End)
				(if (gCast contains: vine1)
					(vine1 setCycle: End)
					(vine2 setCycle: End)
					(vine3 setCycle: End)
					(vine4 setCycle: End)
					(vine5 setCycle: End self)
				)
				(gLongSong2 number: 918 setLoop: 1 play: 127)
			)
			(1
				(mainVine setCycle: Beg)
				(if (gCast contains: vine1)
					(vine1 setCycle: Beg)
					(vine2 setCycle: Beg)
					(vine3 setCycle: Beg)
					(vine5 setCycle: Beg)
				)
				(gLongSong2 number: 918 setLoop: 1 play: 127)
				(= seconds 2)
			)
			(2
				(vine1 stopUpd:)
				(vine2 stopUpd:)
				(vine3 stopUpd:)
				(vine4 stopUpd:)
				(vine5 stopUpd:)
				(mainVine stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance bat1Hoark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bat1 moveSpeed: 1 setLoop: 2 setCycle: End self)
			)
			(1
				(gLongSong2 number: 383 setLoop: 1 play: 127)
				(bat1 setLoop: 4 setCycle: ForwardCounter 3 self)
			)
			(2
				(bat1 setCycle: End self)
			)
			(3
				(gLongSong2 number: 383 setLoop: 1 play: 127)
				(bat1 setMotion: JumpTo 169 132 self)
			)
			(4
				(bat1 setCycle: Beg self)
			)
			(5
				(gLongSong2 number: 383 setLoop: 1 play: 127)
				(mainVine setScript: vinesTwist)
				(bat1 setCycle: Fwd setMotion: MoveTo 214 105 self)
			)
			(6
				(bat1 setMotion: MoveTo 360 110 self)
			)
			(7
				(gLongSong2 number: 383 setLoop: 1 play: 127)
				(bat1 setLoop: 5 setMotion: JumpTo 42 160 self)
			)
			(8
				(bat1 setLoop: 2 setCycle: Beg self)
			)
			(9
				(gLongSong2 number: 381 setLoop: 1 play: 127)
				(bat1 setLoop: 0 setCycle: 0 stopUpd:)
				(HandsOn)
				(if
					(and
						(IsFlag 54)
						(not (IsFlag 55))
						(not (IsFlag 52))
						(not (== local0 1))
					)
					(smallBat setScript: smallBatJump)
				)
				(self dispose:)
			)
		)
	)
)

(instance batsComeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bat1 show: setCycle: Beg self)
			)
			(1
				(bat2 show: setCycle: Beg self)
			)
			(2
				(if (and (gCast contains: smallBat) (not (IsFlag 55)))
					(smallBat show: setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(3
				(bat3 show: setCycle: Beg self)
			)
			(4
				(gLongSong2 number: 381 setLoop: 1 play: 127)
				(= local1 0)
				(= seconds 2)
			)
			(5
				(bat1 stopUpd:)
				(bat2 stopUpd:)
				(bat3 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance theyHide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 381 setLoop: 1 play: 127)
				(bat1 setCycle: End self)
			)
			(1
				(bat1 hide:)
				(if
					(and
						(gCast contains: smallBat)
						(not (== (smallBat script:) flutterBackToRock))
						(not (IsFlag 55))
					)
					(smallBat setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if
					(and
						(gCast contains: smallBat)
						(not (== (smallBat script:) flutterBackToRock))
						(not (IsFlag 55))
					)
					(smallBat hide:)
				)
				(bat3 setCycle: End self)
			)
			(3
				(bat3 hide:)
				(bat2 setCycle: End self)
			)
			(4
				(bat2 hide:)
				(self dispose:)
			)
		)
	)
)

(instance getRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					setMotion: 0
					view: 4
					loop: (mod (gEgo loop:) 2)
					setCycle: End self
				)
				(= register (Narrator y:))
			)
			(1
				(Narrator y: 20)
				(gMessager say: 1 6 19 0 self) ; "You pick up a few good throwing rocks."
				(gEgo get: 23 (Random 2 5)) ; theRocks
			)
			(2
				(Narrator y: register)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance grapThingy of Actor
	(properties
		view 21
		loop 6
		signal 16384
	)
)

(instance stoneRing of Prop
	(properties
		x 95
		y 185
		noun 3
		approachX 109
		approachY 163
		view 384
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (stoneRing cel:) 0)
					(gMessager say: 3 1) ; "You see a ring of stones here. In the center of the circle is a glowing stone and some fruit from the venomous vine."
				else
					(gMessager say: 3 1 16) ; "You see a circle of stones."
				)
				(return 1)
			)
			(4 ; Do
				(if (not (gEgo has: 35)) ; theVineFruit
					(gEgo get: 35 solvePuzzle: 256 8) ; theVineFruit
					(if (== (stoneRing cel:) 0)
						(stoneRing setCycle: End)
					)
				)
				(if (not (gEgo has: 34)) ; theOpal
					(gEgo get: 34) ; theOpal
					(if (== (stoneRing cel:) 0)
						(stoneRing setCycle: End)
					)
				)
				(if (not (IsFlag 148))
					(gMessager say: 3 4 10) ; "You pick up the rock which seems to be a glowing opal. You also get the fruit and put them carefully away in your pack."
				else
					(gMessager say: 3 4 20) ; "There is nothing else there."
				)
				(SetFlag 148)
				(return 1)
			)
			(26 ; theDispell
				(if (not (gCurRoom script:))
					(proc0_14 95 180)
					(gCurRoom setScript: (ScriptID 37 0) 0 mainVine) ; castFetchScript
				)
			)
			(-82 ; fetchSpell
				(gMessager say: 1 6 21) ; "You get the items from the ring of stones and put them in your pouch."
				(if (not (gEgo has: 35)) ; theVineFruit
					(gEgo solvePuzzle: 256 8 get: 35) ; theVineFruit
				)
				(if (not (gEgo has: 34)) ; theOpal
					(gEgo get: 34) ; theOpal
				)
				(stoneRing setCel: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smallBat of Actor
	(properties
		x 79
		y 167
		noun 7
		view 383
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; theHealPills
				(if (< (self distanceTo: gEgo) 30)
					(gMessager say: 1 6 5) ; "With no concern for yourself, you heal the poor meerbat of all its wounds."
					(gEgo drop: 12 1 addHonor: 20) ; theHealPills
				else
					(gMessager say: 1 6 12) ; "You are not close enough."
				)
			)
			(11 ; theSword
				(if
					(and
						(not (gEgo script:))
						(== (smallBat script:) flutterBackToRock)
					)
					(gEgo setScript: egoHacksBat)
				)
			)
			(20 ; theDaggers
				(if
					(and
						(not (gEgo script:))
						(== (smallBat script:) flutterBackToRock)
					)
					(gEgo setScript: egoHacksBat)
				else
					(super doVerb: theVerb)
				)
			)
			(12 ; theFineDagger
				(if
					(and
						(not (gEgo script:))
						(== (smallBat script:) flutterBackToRock)
					)
					(gEgo setScript: egoHacksBat)
				)
			)
			(66 ; healingSpell
				(if (IsFlag 55)
					(gMessager say: 1 6 5) ; "With no concern for yourself, you heal the poor meerbat of all its wounds."
					(/= [gEgoStats 17] 2) ; stamina
					(gEgo addHonor: 20)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bat3 of Prop
	(properties
		x 118
		y 184
		noun 6
		view 382
		signal 16384
	)
)

(instance bat2 of Prop
	(properties
		x 58
		y 182
		noun 6
		view 382
		signal 16384
	)
)

(instance bat1 of Actor
	(properties
		x 42
		y 160
		noun 6
		view 382
		signal 16384
	)
)

(instance vine1 of TargProp
	(properties
		x 179
		y 160
		noun 9
		view 380
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(83 ; forceBoltSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(88 ; lightningBallSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(20 ; theDaggers
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(33 ; theRocks
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(4 ; Do
				(if (not (gCurRoom script:))
					(gEgo setMotion: PolyPath 127 95)
				)
			)
			(11 ; theSword
				(gEgo setMotion: PolyPath 127 95)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (getHurt)
		(self setScript: vinesGoDown)
	)
)

(instance vine2 of TargProp
	(properties
		x 112
		y 140
		noun 9
		view 380
		cel 8
		signal 16384
	)

	(method (doVerb theVerb)
		(vine1 doVerb: theVerb)
	)

	(method (getHurt)
		(self setScript: vinesGoDown)
	)
)

(instance vine3 of TargProp
	(properties
		x 115
		y 95
		noun 9
		view 380
		cel 8
		signal 16384
	)

	(method (doit)
		(if
			(and
				(not local0)
				(not local2)
				(< (GetDistance x y (gEgo x:) (gEgo y:) gPerspective) 20)
			)
			(self setScript: grabEgo)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; theDaggers
				(if (== (self script:) grabEgo)
					(gEgo setScript: chopVines)
				else
					(vine1 doVerb: theVerb)
				)
			)
			(11 ; theSword
				(if (== (self script:) grabEgo)
					(gEgo setScript: chopVines)
				else
					(gEgo setMotion: PolyPath 127 95)
				)
			)
			(12 ; theFineDagger
				(if (== (self script:) grabEgo)
					(gEgo setScript: chopVines)
				)
			)
			(81 ; flameDartSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(83 ; forceBoltSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(88 ; lightningBallSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(20 ; theDaggers
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(33 ; theRocks
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(4 ; Do
				(vine1 doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (getHurt)
		(self setScript: vinesGoDown)
	)
)

(instance vine4 of TargProp
	(properties
		x 194
		y 115
		noun 9
		view 380
		cel 8
		signal 16384
	)

	(method (doVerb theVerb)
		(vine1 doVerb: theVerb)
	)

	(method (getHurt)
		(self setScript: vinesGoDown)
	)
)

(instance vine5 of TargProp
	(properties
		x 251
		y 158
		noun 9
		view 380
		cel 8
		signal 16384
	)

	(method (doVerb theVerb)
		(vine1 doVerb: theVerb)
	)

	(method (getHurt)
		(self setScript: vinesGoDown)
	)
)

(instance mainVine of TargProp
	(properties
		x 165
		y 143
		noun 8
		view 381
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(-82 ; fetchSpell
				(gMessager say: 1 6 4) ; "You get the fruit and carefully place it in a safe place in your backpack."
				(gEgo solvePuzzle: 256 8 get: 35) ; theVineFruit
				(self setScript: vinesTwist)
			)
			(82 ; fetchSpell
				(cond
					((gEgo has: 35) ; theVineFruit
						(gMessager say: 1 6 13) ; "You don't need any more fruit."
					)
					((not (gCurRoom script:))
						(proc0_14 165 138)
						(gCurRoom setScript: (ScriptID 37 0) 0 mainVine) ; castFetchScript
					)
				)
			)
			(16 ; theGrapnel
				(cond
					((gEgo has: 35) ; theVineFruit
						(gMessager say: 1 6 13) ; "You don't need any more fruit."
					)
					(
						(and
							(not (vine3 script:))
							(not (gCurRoom script:))
							(not (gEgo has: 35)) ; theVineFruit
						)
						(gCurRoom setScript: throwHook)
					)
				)
			)
			(20 ; theDaggers
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(33 ; theRocks
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(81 ; flameDartSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(83 ; forceBoltSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(88 ; lightningBallSpell
				(if (not (gCurRoom script:))
					(self setScript: blastVine 0 theVerb)
				)
			)
			(4 ; Do
				(if (not (gCurRoom script:))
					(gEgo setMotion: PolyPath 129 95)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (getHurt)
		(self setScript: vinesGoDown)
	)
)

(instance holes of Feature
	(properties
		x 91
		y 172
		noun 2
		nsTop 155
		nsLeft 53
		nsBottom 189
		nsRight 130
		sightAngle 180
	)
)

(instance sky of Feature
	(properties
		x 159
		y 21
		noun 4
		nsBottom 42
		nsRight 319
		sightAngle 180
	)
)

(instance egoChek of Code
	(properties)

	(method (doit)
		(cond
			(
				(and
					(< (gEgo x:) 200)
					(> (gEgo y:) 91)
					(== local1 0)
					(not (bat1 script:))
				)
				(= local1 1)
				(gCurRoom setScript: theyHide)
			)
			((and (== local1 1) (> (gEgo x:) 127) (< (gEgo y:) 91))
				(= local1 0)
				(gCurRoom setScript: batsComeOut)
			)
		)
	)
)

(instance ambushChek of Code
	(properties)

	(method (doit)
		(if (and (not (mainVine script:)) (< (gEgo distanceTo: mainVine) 30))
			(mainVine setScript: ambush)
		)
	)
)

