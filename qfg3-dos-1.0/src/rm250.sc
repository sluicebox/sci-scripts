;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use Teller)
(use OccasionalCycle)
(use Vendor)
(use bazaarR)
(use GloryTalker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm250 0
	beadTalker 1
	fishTalker 2
	ropeTalker 3
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
	[local12 2]
	[local14 11] = [0 -1 -59 -74 -4 -16 -47 -55 -72 -13 999]
	[local25 6] = [0 4 5 6 7 999]
	[local31 6] = [0 16 5 -6 -78 999]
	[local37 6] = [0 -6 -79 5 -54 999]
	[local43 5] = [0 -66 68 69 999]
	[local48 3] = [0 67 999]
	[local51 3] = [0 -66 999]
	[local54 2]
	[local56 2]
	[local58 2]
	[local60 2]
	[local62 3]
	local65
	local66
	local67
)

(procedure (localproc_0)
	(if local6
		(switch local5
			(0
				(gMessager say: 6 6 60) ; "Hey, you deaf or something? You gotta help me."
			)
			(1
				(gMessager say: 6 6 61) ; "Man, don't go away. Ya gotta come here and talk ta me. Don't go away."
			)
			(2
				(gMessager say: 6 6 62) ; "Blondie, ya gotta help another stranger in need. Ain't ya supposed to be some sort of hero?"
			)
			(3
				(gMessager say: 6 6 63) ; "Help me, hero. You're my only hope."
			)
			(4
				(gMessager say: 6 6 64) ; "Some bloody hero! Too busy trying ta stop some stupid war ta help a guy what needs ya. You hero guys make me sick."
			)
			(else
				(gMessager say: 6 6 65) ; "Look at me! Don't be like them. I need ya. Talk ta me, help me!"
			)
		)
		(if (> (++ local5) 6)
			(= local5 0)
		)
		((Timer new:) set: aHarami 8)
	)
)

(instance rm250 of Rm
	(properties
		noun 19
		picture 250
		horizon -280
	)

	(method (init)
		(self setRegions: 51) ; bazaarR
		(gEgo
			noun: 2
			normalize:
			edgeHit: EDGE_NONE
			actions: egoTeller
			init:
			setScale: 0
		)
		(HandsOn)
		(switch gPrevRoomNum
			(240
				(= style -32759)
				(self setScript: from240)
			)
			(260
				(= style -32759)
				(= local65 1)
				(self setScript: from260)
			)
			(else
				(gEgo x: 200 y: 110 setHeading: 135)
			)
		)
		(if (or gNight (IsFlag 135))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 236 189 0 189 0 0 36 0 149 69 55 83
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 115 213 135 198 112 315 93 315 45 183 63 116 22 126 0 319 0
						yourself:
					)
			)
		else
			(if (== (gLongSong prevSignal:) -1)
				(gLongSong play:)
			)
			(gLongSong fade: 80 10 5 0)
			(gEgo code: dayCode)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 0 34 0 144 61 154 71 210 109 124 124 238 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 0 319 189 199 119 315 92 315 50 270 47 244 58 188 58 119 23 120 0
						yourself:
					)
			)
		)
		(if (and (not gNight) (not (IsFlag 135)))
			(= [local54 0] @local14)
			(egoTeller init: gEgo @local14 @local54)
			(= [local56 0] @local25)
			(aBeadMaker
				setPri: 1
				setCycle: OccasionalCycle self 1 65 150
				actions: beadTeller
				noun: 1
				approachVerbs: 2 59 10 ; Talk, theRoyals, Money
				init:
			)
			(beadTeller init: aBeadMaker @local25 @local56)
			(beadVendor
				init:
				goods:
					((List new:)
						add:
							((Class_47_1 new: 1)
								price: 95
								denomination: 1
								quantity: 9999
							)
					)
			)
			(= [local58 0] @local31)
			(aFishSeller
				setPri: 9
				setCycle: OccasionalCycle self 1 40 170
				actions: fishTeller
				noun: 3
				approachVerbs: 2 59 10 ; Talk, theRoyals, Money
				init:
			)
			(fishTeller init: aFishSeller @local31 @local58)
			(fishVendor
				init:
				goods:
					((List new:)
						add:
							((Class_47_1 new: 3)
								price: 50
								quantity: 9999
								denomination: 1
							)
					)
			)
			(= [local60 0] @local37)
			(aRopeMaker
				setCycle: OccasionalCycle self 1 55 150
				noun: 4
				actions: ropeTeller
				approachVerbs: 2 59 10 ; Talk, theRoyals, Money
				init:
			)
			(ropeTeller init: aRopeMaker @local37 @local60)
			(ropeVendor
				init:
				goods:
					((List new:)
						add:
							((Class_47_1 new: 4)
								price: 100
								denomination: 1
								quantity: (if (IsFlag 168) 0 else 1)
							)
					)
			)
			(if (and (not (IsFlag 40)) (== local65 1) (> gDay 4))
				(gEgo code: cueCode)
			)
		)
		(if (and (not gNight) (not (IsFlag 135)))
			(beadtent init:)
			(rack_of_beads init:)
			(fishingpoles init:)
			(fishbuckets init:)
			(fishstand init:)
			(fishsticks init:)
			(brassworks init:)
			(ropes init:)
			(ropestand init:)
			(ropehook init:)
		)
		(river init:)
		(moreriver init:)
		(if (and (not gNight) (not (IsFlag 135)))
			(fishA init: addToPic:)
			(fishB init: addToPic:)
			(beadA init: addToPic:)
			(ropeA setPri: 9 init: addToPic:)
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((not (< 5 (gEgo x:) 315))
				(self setScript: sExit)
			)
			((not (< 35 (gEgo y:) 183))
				(self setScript: sExit)
			)
		)
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(switch theVerb
			(1 ; Look
				(gMessager
					say: 19 1 0 (if (or (IsFlag 135) gNight) 0 else 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 40 47)
		(super dispose:)
	)
)

(instance dayCode of Code
	(properties)

	(method (doit)
		(cond
			(
				(and
					(not gNight)
					(gEgo inRect: 193 42 237 65)
					(not local1)
					(not (IsFlag 135))
				)
				(gCurRoom setScript: beadGreet)
				(= local1 1)
			)
			((& (gEgo onControl: 1) $0004)
				(if (and (not gNight) (not local9) (not (IsFlag 135)))
					(gCurRoom setScript: fishGreet)
					(= local9 1)
				)
			)
			((& (gEgo onControl: 1) $0008)
				(if (and (not gNight) (not local10) (not (IsFlag 135)))
					(gCurRoom setScript: ropeGreet)
					(= local10 1)
				)
			)
			((not (& (gEgo onControl: 1) $0004))
				(if local9
					(= local9 0)
				)
			)
			((and (not (& (gEgo onControl: 1) $0008)) local10)
				(= local10 0)
			)
		)
	)
)

(instance beadGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 233 58 self)
			)
			(1
				(Face gEgo aBeadMaker)
				(= cycles 15)
			)
			(2
				(gMessager say: 1 6 1 0 self) ; "Beads! Beads! Very fine beads!"
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance haramiLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo code: dayCode)
				(= local67 0)
				(= local6 0)
				(if (not local66)
					(if local11
						(gMessager say: 6 6 59 0 self) ; "Hey look, if we stand here gabbing, the guards'll walk in and catch us. Meet me around here tonight. Ya just gotta!"
					else
						(gMessager say: 6 6 87 0 self) ; "Hey man, some hero. Be that way. I don't need you. See if I care."
					)
				else
					(self cue:)
				)
			)
			(1
				(aHarami
					view: 950
					setScript: 0
					setCycle: Walk
					setMotion: PolyPath 310 (aHarami y:) self
				)
			)
			(2
				(HandsOn)
				(aHarami dispose:)
				(self dispose:)
			)
		)
	)
)

(instance ropeGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 247 145 self)
			)
			(1
				(Face gEgo aRopeMaker)
				(= cycles 15)
			)
			(2
				(if local8
					(switch (mod gDay 6)
						(0
							(gMessager say: 4 6 41 0 self) ; "Good day, young friend. Have you practiced your rope skills lately?"
						)
						(1
							(gMessager say: 4 6 42 0 self) ; "Happy day, young rope user. Have you mastered your rope walking yet?"
						)
						(2
							(gMessager say: 4 6 43 0 self) ; "A fair day for rope play, is it not, young friend?"
						)
						(3
							(gMessager say: 4 6 44 0 self) ; "A thousand greetings, good friend. That rope of yours has been useful, I hope."
						)
						(4
							(gMessager say: 4 6 45 0 self) ; "Greetings, agile one. You should consider buying another rope. After all, ropes do get lonely."
						)
						(5
							(gMessager say: 4 6 46 0 self) ; "Very good day, young friend. Have you hugged your rope today?"
						)
					)
				else
					(switch (mod gDay 6)
						(0
							(gMessager say: 4 6 30 0 self) ; "Greetings of a glorious day! Buy a rope, effendi? All who adventure can sometimes use a rope."
						)
						(1
							(gMessager say: 4 6 31 0 self) ; "A thousand greetings, effendi. Do you need to climb something? A rope can be most handy."
						)
						(2
							(gMessager say: 4 6 26 0 self) ; "Good to see you, effendi. You can always use a spare rope for which to tie things up, can you not?"
						)
						(3
							(gMessager say: 4 6 32 0 self) ; "Greetings! Jumping rope is good for the building of muscles, effendi."
						)
						(4
							(gMessager say: 4 6 33 0 self) ; "Good day again, effendi. A rope is useful in all rooms of the house, you realize."
						)
						(5
							(gMessager say: 4 6 34 0 self) ; "Hail, young adventurer. A rope can save your life if you fall into a deep hole, you know."
						)
					)
				)
			)
			(3
				(if local8
					(self setScript: jumpFlip self)
				else
					(= cycles 1)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fishGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 160 78 self)
			)
			(1
				(Face gEgo aFishSeller)
				(= cycles 15)
			)
			(2
				(switch (mod gDay 6)
					(0
						(gMessager say: 3 6 30 0 self) ; "Fresh fish, effendi. Just out of the river and still writhing in their death throes."
					)
					(1
						(gMessager say: 3 6 31 0 self) ; "Fresh fish! Good day, effendi. Would you not like some fresh fish for supper?"
					)
					(2
						(gMessager say: 3 6 26 0 self) ; "Mostly fresh fish! Very fine dried fish! You be needing the good vitamins to be building your muscles, effendi."
					)
					(3
						(gMessager say: 3 6 32 0 self) ; "Fish, fish, fresh fish! Fine food for the famished, says I."
					)
					(4
						(gMessager say: 3 6 33 0 self) ; "Ah, I see a man who has not had his fish today! Fish will make you feel very fine, effendi."
					)
					(5
						(gMessager say: 3 6 34 0 self) ; "Effendi! You are just in time. I have caught a fine, fresh fish just for you."
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance from240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 30 y: 0 setMotion: PolyPath 155 50 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance from260 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					x: 270
					y: 200
					setHeading: 345
					setMotion: PolyPath 230 172 self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register 0)
				(cond
					((<= (gEgo x:) 5)
						(= register 240)
						(gEgo setMotion: PolyPath -30 (gEgo y:) self)
					)
					((<= (gEgo y:) 35)
						(= register 240)
						(gEgo
							setMotion: PolyPath (- (gEgo x:) 30) -30 self
						)
					)
					((>= (gEgo x:) 315)
						(if (< (gEgo y:) 90)
							(gMessager say: 5 6 86) ; "That road leads to the Liontaur portion of the city. Humans are not permitted there."
							(gEgo
								setMotion:
									PolyPath
									(- (gEgo x:) 30)
									(gEgo y:)
									self
							)
						else
							(= register 260)
							(gEgo setMotion: PolyPath 340 (gEgo y:) self)
						)
					)
					((>= (gEgo y:) 183)
						(= register 260)
						(gEgo
							setMotion: PolyPath (+ (gEgo x:) 35) 250 self
						)
					)
				)
			)
			(1
				(if (!= register 0)
					(gCurRoom newRoom: register)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sMeetHarami of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo code: dayCode setMotion: 0)
				(= [local62 0] @local43)
				(= [local62 1] @local48)
				(haramiTeller init: aHarami @local43 @local62 @local51)
				(aHarami
					view: 950
					loop: 0
					x: 300
					y: (gEgo y:)
					noun: 6
					init:
					setStep: 4 2
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) 25) (gEgo y:) self
				)
			)
			(1
				(Face gEgo aHarami)
				(aHarami
					view: 954
					cel: 0
					loop: 0
					cycleSpeed: 9
					setCycle: End self
				)
				(SetFlag 40)
			)
			(2
				(gMessager say: 6 6 30 0 self) ; "Hey, you! Blondie! Ya gotta help me."
			)
			(3
				(= local6 1)
				(= local67 1)
				((Timer new:) set: aHarami 5)
				(HandsOn)
				(gEgo code: walkCode)
				(self dispose:)
			)
		)
	)
)

(instance jumpFlip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(aRopeMaker
					setLoop: 0
					cel: 0
					ignoreActors: 1
					setCycle: CT 1 1 self
				)
			)
			(1
				(aRopeMaker
					setPri: 8
					setLoop: 1
					cel: 3
					x: 259
					y: 126
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(2
				(aRopeMaker loop: 2 cel: 0 y: 112)
				(= cycles 2)
			)
			(3
				(aRopeMaker
					setCel: -1
					cel: 1
					y: 86
					setCycle: CT 5 1
					setMotion: JumpTo 259 44 self
				)
			)
			(4
				(aRopeMaker setCycle: CT 8 1 self setMotion: JumpTo 259 53 self)
			)
			(5 0)
			(6
				(aRopeMaker setLoop: 3 setCel: 7 y: 84)
				(= ticks 60)
			)
			(7
				(aRopeMaker setLoop: 3 cel: 0)
				(= cycles 6)
			)
			(8
				(aRopeMaker cel: 1 setCycle: End self)
			)
			(9
				(aRopeMaker cel: 1 setCycle: End self)
			)
			(10
				(aRopeMaker cel: 1 setCycle: End)
				(= seconds 3)
			)
			(11
				(aRopeMaker cel: 1 setCycle: End self)
			)
			(12
				(aRopeMaker
					setLoop: 1
					cel: 0
					x: 260
					y: 84
					setCycle: CT 2 1 self
				)
			)
			(13
				(aRopeMaker setLoop: 7 cel: 0 x: 264 y: 82 setCycle: End self)
			)
			(14
				(aRopeMaker setLoop: 2 cycleSpeed: 17 setCel: 0 x: 259 y: 60)
				(= ticks 10)
			)
			(15
				(aRopeMaker
					cel: 1
					x: 261
					y: 36
					setCycle: CT 5 1
					setMotion: JumpTo 261 21 self
				)
			)
			(16
				(aRopeMaker setCycle: CT 8 1 self setMotion: JumpTo 261 40 self)
			)
			(17 0)
			(18
				(= ticks 8)
			)
			(19
				(aRopeMaker setLoop: 3 cel: 0 x: 259 y: 83 setCycle: End)
				(= ticks 110)
			)
			(20
				(aRopeMaker
					setLoop: 1
					cel: 0
					x: 259
					y: 83
					setCycle: CT 3 1 self
				)
			)
			(21
				(aRopeMaker setMotion: JumpTo 259 126 self)
			)
			(22
				(aRopeMaker cel: 4)
				(= cycles 5)
			)
			(23
				(aRopeMaker setPri: -1 setLoop: 0 cel: 0 cycleSpeed: 8)
				(= seconds 3)
			)
			(24
				(aRopeMaker setCycle: OccasionalCycle self 1 55 150)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cueCode of Code
	(properties)

	(method (doit)
		(if (< (gEgo y:) 100)
			(gCurRoom setScript: sMeetHarami)
		)
	)
)

(instance walkCode of Code
	(properties)

	(method (doit)
		(if (and (or (gEgo mover:) (> local11 2)) (not local66) local67)
			(gCurRoom setScript: haramiLeave)
		)
	)
)

(instance aHarami of Actor
	(properties
		x 186
		y 96
		view 955
		cel 3
		cycleSpeed 5
	)

	(method (cue)
		(if (and (> local11 2) (not (gCurRoom script:)))
			(gCurRoom setScript: haramiLeave)
		else
			(localproc_0)
		)
	)
)

(instance aBeadMaker of Actor
	(properties
		x 220
		y 59
		heading 180
		approachX 233
		approachY 58
		view 246
		signal 16384
		cycleSpeed 3
		detailLevel 3
	)
)

(instance aFishSeller of Actor
	(properties
		x 106
		y 85
		heading 90
		approachX 160
		approachY 78
		view 268
		cycleSpeed 9
		detailLevel 3
	)
)

(instance aRopeMaker of Actor
	(properties
		x 259
		y 126
		heading 270
		approachX 247
		approachY 145
		view 262
		cycleSpeed 9
		detailLevel 3
	)
)

(instance beadTalker of GloryTalker
	(properties
		x 200
		y 90
		view 247
		loop 1
		talkWidth 140
		back 57
		textX -178
		textY 3
		backColor 8
	)

	(method (init)
		(super init: beadBust beadEyes beadMouth &rest)
	)
)

(instance beadMouth of Prop
	(properties
		nsTop 52
		nsLeft 26
		view 247
	)
)

(instance beadEyes of Prop
	(properties
		nsTop 41
		nsLeft 21
		view 247
		loop 2
	)
)

(instance beadBust of View
	(properties
		nsTop 26
		nsLeft 22
		view 247
		loop 3
	)
)

(instance fishTalker of GloryTalker
	(properties
		x 5
		y 90
		view 269
		loop 1
		talkWidth 140
		back 57
		textX 143
		textY 3
		backColor 13
	)

	(method (init)
		(super init: fishBust fishEyes fishMouth &rest)
	)
)

(instance fishMouth of Prop
	(properties
		nsTop 59
		nsLeft 43
		view 269
	)
)

(instance fishEyes of Prop
	(properties
		nsTop 42
		nsLeft 40
		view 269
		loop 2
	)
)

(instance fishBust of View
	(properties
		nsTop 30
		nsLeft 38
		view 269
		loop 3
	)
)

(instance ropeTalker of GloryTalker
	(properties
		x 5
		y 90
		view 263
		loop 1
		talkWidth 140
		back 57
		textX 145
		textY 3
		backColor 13
	)

	(method (init)
		(super init: ropeBust ropeEyes ropeMouth &rest)
	)
)

(instance ropeMouth of Prop
	(properties
		nsTop 60
		nsLeft 46
		view 263
	)
)

(instance ropeEyes of Prop
	(properties
		nsTop 43
		nsLeft 49
		view 263
		loop 2
	)
)

(instance ropeBust of View
	(properties
		nsTop 29
		nsLeft 51
		view 263
		loop 3
	)
)

(instance egoTeller of Teller
	(properties)

	(method (showDialog)
		(= local2 (proc51_1))
		(= local3 (gEgo distanceTo: local2))
		(switch local2
			(aFishSeller
				(if (> local3 65)
					(gMessager say: 5 6 80) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(aBeadMaker
				(if (> local3 35)
					(gMessager say: 5 6 80) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(else
				(if (> local3 45)
					(gMessager say: 5 6 80) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
		)
		(if
			(!=
				(gEgo heading:)
				(GetAngle (gEgo x:) (gEgo y:) (local2 x:) (local2 y:))
			)
			(Face gEgo local2)
		)
		((Timer new:) setCycle: self (+ (gEgo cycleSpeed:) 10))
		(= iconValue 0)
		(return -999)
	)

	(method (cue)
		(= query
			(super
				showDialog:
					-1 ; "Greet"
					-59
					-74 ; "Give Thief Sign"
					(== gHeroType 2) ; Thief
					-55 ; "Train"
					(and local7 (== local2 aRopeMaker) (not (IsFlag 149)))
					-4 ; "Buy Beads"
					(== local2 aBeadMaker)
					-16 ; "Buy Fish"
					(== local2 aFishSeller)
					-47 ; "Buy Rope"
					(== local2 aRopeMaker)
					-72 ; "Agree to Meet"
					(gCast contains: aHarami)
					-13
					(and (== gHeroType 2) (gCast contains: aHarami)) ; Thief
			)
		)
		(= local4 1)
		(if iconValue
			(= query iconValue)
		)
		(egoTeller respond:)
	)

	(method (respond)
		(if (not local4)
			(super respond:)
		else
			(= local4 0)
			(cond
				((not query)
					(return 1)
				)
				((== query -999)
					(return 1)
				)
				((== query 999)
					(self doParent:)
					(return 0)
				)
				((and (< query 0) (not (self doChild: query)))
					(return 1)
				)
			)
			(if (< query 0)
				(= query (- query))
			)
			(gMessager say: (client noun:) 5 query 0)
			(return 1)
		)
	)

	(method (doChild &tmp temp0 temp1)
		(switch query
			(-13
				(gEgo solvePuzzle: 229 8)
				(return query)
			)
			(-1 ; "Greet"
				(cond
					((gCast contains: aHarami)
						(= query 70)
					)
					((== local2 aBeadMaker)
						(= local11 3)
						(= query 8)
					)
					((== local2 aFishSeller)
						(= local11 3)
						(= query 14)
					)
					((== local2 aRopeMaker)
						(= local11 3)
						(= query 81)
					)
				)
			)
			(-59 ; "Say Good-bye"
				(cond
					((gCast contains: aHarami)
						(= local66 1)
						(= local6 0)
						(gMessager say: 2 5 71) ; "You say good-bye to the thief."
						(gCurRoom setScript: haramiLeave)
						(return 0)
					)
					((== local2 aBeadMaker)
						(= local11 3)
						(= query 9)
					)
					((== local2 aFishSeller)
						(= local11 3)
						(= query 15)
					)
					((== local2 aRopeMaker)
						(= local11 3)
						(= query 82)
					)
				)
			)
			(-74 ; "Give Thief Sign"
				(cond
					((gCast contains: aHarami)
						(gEgo solvePuzzle: 229 8)
						(= query 13)
					)
					((== local2 aBeadMaker)
						(= local11 3)
						(= query 10)
					)
					((== local2 aFishSeller)
						(= local11 3)
						(= query 11)
					)
					((== local2 aRopeMaker)
						(= local11 3)
						(gMessager say: 2 5 12) ; "You put your thumb upon your nose with your hand held perpendicular to your face, and fingers outspread. Then you wiggle your fingers while crossing your eyes and patting your belly, just as you were taught in the Famous Adventurers' Correspondence School for Thieves."
						(gCurRoom setScript: jumpFlip)
						(= local8 1)
						(return 0)
					)
				)
			)
			(-4 ; "Buy Beads"
				(= local11 3)
				(if (== ((gInventory at: 0) message:) 59) ; theRoyals
					(gMessager say: 1 6 77) ; "No good money. Go money changer. No sell."
					(return 0)
				else
					(beadVendor purchase:)
				)
				(return 0)
			)
			(-16 ; "Buy Fish"
				(= local11 3)
				(if (== ((gInventory at: 0) message:) 59) ; theRoyals
					(gMessager say: 3 6 77) ; "This is not the money of this land, you will need to go to the money changer first."
					(return 0)
				else
					(fishVendor purchase:)
					(return 0)
				)
			)
			(-47 ; "Buy Rope"
				(= local11 3)
				(if (== ((gInventory at: 0) message:) 59) ; theRoyals
					(gMessager say: 4 6 77) ; "Have you not been told? Only the coin of Tarna can be used in this bazaar. Take your foreign money to the money changer. He can be found near the fruit and leather merchants."
					(return 0)
				else
					(if (IsFlag 168)
						(gMessager say: 5 6 88) ; "Nope, you need no rope!"
					else
						(ropeVendor purchase:)
					)
					(return 0)
				)
			)
			(-55 ; "Train"
				(= local11 3)
				(if
					(or
						(<
							(= temp0
								(+ (* ((gInventory at: 0) amount:) 100) global410) ; theRoyals
							)
							1000
						)
						(== ((gInventory at: 0) message:) 59) ; theRoyals
					)
					(gMessager say: 5 6 83) ; "Sorry, but no money, no training. I've got to make a living somehow."
					(return 0)
				else
					(= temp0 (/ global410 100))
					(= global410 (mod global410 100))
					((gInventory at: 0) ; theRoyals
						amount: (+ (- ((gInventory at: 0) amount:) 50) temp0) ; theRoyals
					)
				)
				(SetFlag 149)
				(if (> (+= [gEgoStats 2] 30) 300) ; agility
					(= [gEgoStats 2] 300) ; agility
				)
				(return 1)
			)
			(-72 ; "Agree to Meet"
				(= local66 1)
				(= local6 0)
				(gMessager say: 2 5 72) ; "You agree to meet with the thief."
				(if (not (IsFlag 230))
					(gEgo addHonor: 30)
				)
				(gEgo solvePuzzle: 230 4)
				(gCurRoom setScript: haramiLeave)
				(return 0)
			)
		)
	)
)

(instance beadTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(= local11 3)
				(gMessager say: 1 6 77) ; "No good money. Go money changer. No sell."
			)
			(10 ; Money
				(beadVendor purchase:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fishTeller of Teller
	(properties)

	(method (doChild)
		(switch query
			(-6
				(switch (mod gDay 6)
					(0
						(= query 17)
					)
					(1
						(= query 18)
					)
					(2
						(= query 19)
					)
					(3
						(= query 20)
					)
					(4
						(= query 21)
					)
					(5
						(= query 22)
					)
				)
			)
			(-78
				(switch (mod gDay 6)
					(0
						(= query 23)
					)
					(1
						(= query 24)
					)
					(2
						(= query 25)
					)
					(3
						(= query 27)
					)
					(4
						(= query 28)
					)
					(5
						(= query 29)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(= local11 3)
				(gMessager say: 3 6 77) ; "This is not the money of this land, you will need to go to the money changer first."
			)
			(10 ; Money
				(fishVendor purchase:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ropeTeller of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -54 local8)
	)

	(method (doChild)
		(switch query
			(-6
				(switch (mod gDay 6)
					(0
						(= query 17)
					)
					(1
						(= query 18)
					)
					(2
						(= query 19)
					)
					(3
						(= query 20)
					)
					(4
						(= query 21)
					)
					(5
						(= query 22)
					)
				)
			)
			(-79
				(switch (mod gDay 6)
					(0
						(= query 48)
					)
					(1
						(= query 49)
					)
					(2
						(= query 50)
					)
					(3
						(= query 51)
					)
					(4
						(= query 52)
					)
					(5
						(= query 53)
					)
				)
			)
			(-54
				(= local7 1)
				(return 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(= local11 3)
				(gMessager say: 4 6 77) ; "Have you not been told? Only the coin of Tarna can be used in this bazaar. Take your foreign money to the money changer. He can be found near the fruit and leather merchants."
			)
			(10 ; Money
				(if (IsFlag 168)
					(gMessager say: 5 6 88) ; "Nope, you need no rope!"
				else
					(ropeVendor purchase:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance haramiTeller of Teller
	(properties)

	(method (showDialog)
		(++ local11)
		(super showDialog: &rest)
	)
)

(instance riverWater of View ; UNUSED
	(properties
		x 16
		y 170
		view 250
	)

	(method (init)
		(if (or gNight (IsFlag 135))
			(super init: &rest)
		)
	)
)

(instance fishA of View
	(properties
		x 62
		y 172
		view 250
		priority 7
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance fishB of View
	(properties
		x 159
		y 120
		view 250
		cel 1
		priority 7
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance beadA of View
	(properties
		x 181
		y 7
		view 250
		loop 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance ropeA of View
	(properties
		x 238
		y 88
		view 250
		loop 1
		cel 1
		priority 10
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance beadVendor of Vendor
	(properties
		noun 1
	)

	(method (transact param1 param2)
		(= local0 self)
		(gEgo get: 20 param2 solvePuzzle: 231 2) ; theBeads
		(proc47_3 param1 param2)
		(gMessager say: 1 6 2 0 self) ; "Good, kattar kherak memnun, effendi."
	)

	(method (bargain &tmp temp0)
		(= temp0 [gEgoStats 13]) ; communication
		(= [gEgoStats 13] 0) ; communication
		(super bargain: &rest)
		(= [gEgoStats 13] temp0) ; communication
	)

	(method (doBargain)
		(gMessager say: 1 6 3 0 self) ; "Very good beads, 95 commons, effendi."
	)
)

(instance fishVendor of Vendor
	(properties
		noun 3
	)

	(method (transact param1 param2)
		(= local0 self)
		(gEgo get: 17 param2) ; theFish
		(proc47_3 param1 param2)
		(gMessager say: 3 6 2 0 self) ; "Thank you, thank you very much, effendi. May you never have a day without fish."
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 3 6 35 0 self) ; "It is a very fine dried fish for such a low price, effendi, but you are a good bargainer, says I."
			)
			(2
				(gMessager say: 3 6 38 0 self) ; "If I sell my fish for such a price, my sister will be very angry. You sell your fish too cheap, says she. But for you, effendi, I will make a deal."
			)
			(3
				(gMessager say: 3 6 39 0 self) ; "You will not find a fresher dried fish in all the city! Surely you can accept this price."
			)
			(4
				(gMessager say: 3 6 40 0 self) ; "People of the bazaar! You charge too much, says this man. I must make a living, says I. Your fish are too small for such a price, says this man. Will nothing please this man?, says I."
			)
			(5
				(gMessager say: 3 6 36 0 self) ; "Ah, alas, effendi. My fish is too fine for so few commons. We cannot come to a deal."
			)
			(6
				(gMessager say: 3 6 37 0 self) ; "No! I work hard to catch and fix these fish. I do not wish to be robbed of them."
			)
			(else
				(self cue:)
			)
		)
	)
)

(instance ropeVendor of Vendor
	(properties
		noun 4
	)

	(method (transact param1 param2)
		(= local0 self)
		(gEgo get: 26 param2 solvePuzzle: 228 8 4) ; theRope
		(proc47_3 param1 param2)
		(SetFlag 168)
		(gMessager say: 4 6 2 0 self) ; "A thousand thanks, effendi. May your rope always be at your service."
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 4 6 35 0 self) ; "I will accept your offer, and you shall own a fine rope."
			)
			(2
				(gMessager say: 4 6 38 0 self) ; "I must support a wife, a son, and two daughters with the sale of this rope. Surely you could afford to pay this much for so fine a rope."
			)
			(3
				(gMessager say: 4 6 39 0 self) ; "The rope will resist both fire and wear, effendi. You cannot find a better one anywhere for this price."
			)
			(4
				(gMessager say: 4 6 40 0 self) ; "This is too fine a rope for so little an offer. However, I will accept this much."
			)
			(5
				(gMessager say: 4 6 36 0 self) ; "I am sorry, effendi, but we cannot come to agreement."
			)
			(6
				(gMessager say: 4 6 37 0 self) ; "You do not need to insult me with such an offer, effendi. I will not bargain."
			)
			(else
				(self cue:)
			)
		)
	)
)

(instance beadtent of Feature
	(properties
		x 195
		y 22
		noun 7
		nsLeft 154
		nsBottom 44
		nsRight 236
		sightAngle 180
	)
)

(instance rack_of_beads of Feature
	(properties
		x 213
		y 20
		noun 8
		nsTop 11
		nsLeft 201
		nsBottom 29
		nsRight 226
		sightAngle 180
	)
)

(instance fishingpoles of Feature
	(properties
		x 60
		y 92
		noun 9
		nsTop 77
		nsLeft 15
		nsBottom 107
		nsRight 105
		sightAngle 180
	)
)

(instance fishbuckets of Feature
	(properties
		x 143
		y 109
		noun 10
		nsTop 104
		nsLeft 131
		nsBottom 114
		nsRight 156
		sightAngle 180
	)
)

(instance fishstand of Feature
	(properties
		x 142
		y 65
		noun 11
		nsTop 64
		nsLeft 115
		nsBottom 90
		nsRight 169
		sightAngle 180
	)
)

(instance fishsticks of Feature
	(properties
		x 175
		y 65
		noun 12
		nsTop 64
		nsLeft 169
		nsBottom 113
		nsRight 182
		sightAngle 180
	)
)

(instance brassworks of Feature
	(properties
		x 259
		y 22
		noun 13
		nsTop 1
		nsLeft 235
		nsBottom 44
		nsRight 283
		sightAngle 180
	)
)

(instance ropes of Feature
	(properties
		x 272
		y 137
		noun 14
		nsTop 123
		nsLeft 235
		nsBottom 152
		nsRight 309
		sightAngle 180
	)
)

(instance ropestand of Feature
	(properties
		x 308
		y 116
		noun 15
		nsTop 89
		nsLeft 299
		nsBottom 143
		nsRight 318
		sightAngle 180
	)
)

(instance ropehook of Feature
	(properties
		x 217
		y 118
		noun 16
		nsTop 114
		nsLeft 209
		nsBottom 122
		nsRight 225
		sightAngle 180
	)
)

(instance river of Feature
	(properties
		x 31
		y 149
		noun 17
		nsTop 109
		nsBottom 189
		nsRight 62
		sightAngle 180
	)
)

(instance moreriver of Feature
	(properties
		x 86
		y 170
		noun 18
		nsTop 152
		nsLeft 61
		nsBottom 189
		nsRight 111
		sightAngle 180
	)
)

