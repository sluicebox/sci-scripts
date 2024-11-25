;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use CycleBet)
(use smell)
(use BalloonTalker)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
	isaacTalker 1
	goodyTalker 2
	pughTalker 13
	ishTalker 18
)

(local
	local0 = 1
	local1
	local2
)

(instance rm290 of ADRoom
	(properties
		noun 1
		picture 290
		horizon 75
		south 270
		vanishingY -60
	)

	(method (cue)
		(gLongSong number: 290 setLoop: -1 play:)
	)

	(method (init)
		(if (not gAct)
			(= gAct 2)
			(proc875_0)
		)
		(if (not (IsFlag 287))
			(jar setPri: 14 init:)
		)
		(if (IsFlag 290)
			(chair setCel: 0 noun: 33 init: stopUpd:)
		else
			(chair init: stopUpd:)
			(flies setCycle: Fwd setPri: 10 init:)
		)
		(if (and (not (IsFlag 136)) (== gAct 3))
			(isaac init:)
			(ishmael init:)
			(gCurRoom setScript: sDoTaxCartoon)
		)
		(if (and (not (OneOf gPrevRoomNum 291 116)) (not (gCurRoom script:)))
			(gEgo init: normalize: x: 54 y: 148 setHeading: 180)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 71 1 0 1 0 125 53 157 6 178 7 187 89 187 146 149 238 151 257 159 284 152 268 148 257 154 240 147 151 138 106 143 91 150 63 149
					yourself:
				)
		)
		(<<= local0 $000a)
		(switch gPrevRoomNum
			(291
				(= local1 1)
				(self picture: 0)
				(= global114 0)
				(gEgo setHeading: 90 init: normalize:)
				(DrawPic 290 100 1)
				(gCurRoom setScript: sFinishConversation)
			)
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 290 100 1)
				((ScriptID 895 0) init: normalize:) ; pepper
			)
			(else
				(= global114 1)
				(if (not (gCurRoom script:))
					(self setScript: sWalkIn)
				)
			)
		)
		(if
			(and
				(== global114 1)
				(not (IsFlag 110))
				(proc875_1 local0 global204)
				(proc875_1 local0 global206)
				(proc875_1 local0 global208)
			)
			(SetFlag 134)
		)
		(super init: &rest)
		(if (not (== gPrevRoomNum 291))
			(gLongSong number: 290 setLoop: -1 play:)
		)
		(goody approachVerbs: 48 85 70 74 init: setPri: 13) ; Recipe_Card, Talk, Special_Edition, Chocolate
		(bakingPans init: setOnMeCheck: 1 16384)
		(barrel init: setOnMeCheck: 1 8192)
		(basketLT init:)
		(basketRT init:)
		(basketLM init:)
		(basketMid init:)
		(basketLB init:)
		(basketRB init:)
		(box init:)
		(churn init: setOnMeCheck: 1 4096)
		(cookies init: setOnMeCheck: 1 2048)
		(counterTop init: setOnMeCheck: 1 1024)
		(doorJar init:)
		(hangBaskets init: setOnMeCheck: 1 512)
		(loaves init:)
		(outside init:)
		(pitcherMid init:)
		(pitcherTop init:)
		(sacks init:)
		(stackOStuff init:)
		(tins init:)
		(windowl init:)
		(windowr init:)
		(if (OneOf gPrevRoomNum 116 291)
			(self curPic: 290 picture: 290)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((& temp0 $0002)
				(gCurRoom newRoom: 270)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) x: -15 y: 148 loop: 0 cel: 0) ; pepper
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 54 148 self)
			)
			(2
				(gEgo setMotion: MoveTo 77 152 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFinishConversation of Script
	(properties)

	(method (dispose)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= gDictionaryWord 96)
				(cond
					((and global115 (== global116 60))
						(= state 19)
						(gMessager say: global115 85 60 1 4 self global196)
					)
					((and global115 (== global116 38))
						(gMessager say: global115 85 38 1 2 self global196)
					)
					((and global115 global116)
						(= state 21)
						(gMessager say: global115 85 global116 0 self global196)
					)
					(else
						(self dispose:)
					)
				)
			)
			(2
				(gMessager say: global115 85 38 3 4 self global196)
			)
			(3
				(gMessager say: global115 85 38 5 8 self global196)
			)
			(4
				(self dispose:)
			)
			(20
				(= gDictionaryWord 27)
				(gMessager say: global115 85 60 5 self global196)
			)
			(21
				(gMessager say: global115 85 60 6 self global196)
			)
			(22
				(self dispose:)
			)
		)
	)
)

(instance sDoTaxCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 136)
				(= cycles 1)
			)
			(1
				(gMessager say: 27 0 11 1 6 self) ; "Good morning, Ms. Gumdrops."
			)
			(2
				(ishmael setCycle: End self)
			)
			(3
				(jar dispose:)
				(goody view: 290 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(goody setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(isaac setCycle: End)
				(goody setLoop: 1 setCel: 4 setCycle: Beg self)
			)
			(6
				(jar init:)
				(gMessager say: 27 0 11 7 8 self) ; "Um, <gag> they're delicious, ma'am. <Urp...>"
			)
			(7
				(gLongSong number: 291 setLoop: -1 play:)
				(genPugh
					init:
					view: 818
					setCycle: Walk
					setMotion: MoveTo 59 161 self
				)
			)
			(8
				(genPugh stopUpd:)
				(gMessager say: 27 0 11 9 12 self) ; "Out of the way, you little ragamuffins! If you can pay your taxes, MAYBE I won't arrest you for loitering. Hand over all your money."
			)
			(9
				(genPugh setMotion: MoveTo 79 161 self)
			)
			(10
				(genPugh view: 292 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
				(ishmael setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(11)
			(12
				(genPugh setCycle: End self)
				(ishmael setCycle: End self)
			)
			(13)
			(14
				(ishmael setCycle: CycleBet 4 5 -1)
				(genPugh
					view: 818
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 122 148 self
				)
			)
			(15
				(genPugh view: 292 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
				(isaac setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(16)
			(17
				(genPugh setCycle: End self)
				(isaac setCycle: End self)
			)
			(18)
			(19
				(isaac setCycle: CycleBet 5 6 -1)
				(genPugh
					view: 818
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo -10 150 self
				)
			)
			(20
				(genPugh dispose:)
				(gLongSong fade: self)
				(gMessager say: 27 0 11 13 17 self) ; "I can't believe he took our STUFF, James!"
			)
			(21)
			(22
				(gLongSong number: 290 setLoop: -1 play:)
				(isaac
					view: 296
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -10 150 self
				)
			)
			(23
				(isaac dispose:)
				(ishmael
					view: 296
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo -13 145 self
				)
			)
			(24
				(ishmael dispose:)
				((ScriptID 895 0) x: -10 y: 148 init:) ; pepper
				(self setScript: sWalkIn self)
			)
			(25
				(gMessager say: 27 0 11 18 20 self) ; "Uh, Ms. Gumdrops? Aren't those boys a little...unusual looking?"
			)
			(26
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkGoody of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(not (IsFlag 110))
						(not (IsFlag 122))
						(proc875_1 local0 global204)
						(proc875_1 local0 global206)
						(proc875_1 local0 global208)
						(proc875_1 local0 global205)
						(proc875_1 local0 global207)
						(proc875_1 local0 global209)
					)
					(SetFlag 134)
				)
				((ScriptID 2000 3) offX: -3) ; PepperTalker
				(= cycles 1)
			)
			(1
				(cond
					((and (== gAct 5) (IsFlag 289))
						(SetFlag 134)
						(= cycles 1)
					)
					((== gAct 6)
						(gMessager say: 26 85 12 0 self) ; "I'm totally excited, Goody! I'm going to save Lockjaw now!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if (== gAct 6)
					(gGame points: 492 1 handsOn:)
					(self dispose:)
				else
					(self cue:)
				)
			)
			(3
				(if (IsFlag 134)
					(switch gAct
						(2
							(= temp0 10)
						)
						(3
							(= temp0 69)
						)
						(4
							(= temp0 59)
						)
						(5
							(= temp0 59)
						)
						(6
							(= temp0 59)
						)
					)
					(gMessager say: 26 85 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(4
				(cond
					((IsFlag 134)
						(gGame handsOn:)
						(self dispose:)
					)
					((not local1)
						(switch gAct
							(2
								(= temp0 38)
							)
							(3
								(= temp0 39)
							)
							(4
								(= temp0 40)
							)
							(5
								(= temp0 41)
							)
							(6
								(= temp0 41)
							)
						)
						(if (== temp0 38)
							(gMessager say: 26 85 38 0 self) ; "Hello, ma'am. I wonder if you could help me out."
						else
							(gMessager say: 26 85 temp0 0 self)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(if (and (== gAct 3) (not (IsFlag 136)))
					(gGame handsOn:)
					(self dispose:)
				else
					(= global195 11)
					(switch gAct
						(2
							(gGame points: 286 1)
						)
						(3
							(gGame points: 486 1)
						)
						(4
							(gGame points: 487 1)
						)
						(5
							(gGame points: 488 1)
						)
					)
					(= cycles 1)
				)
			)
			(6
				(gCurRoom newRoom: 291)
			)
		)
	)
)

(instance sGiveChocolate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 0)
				(gGame points: 291 2)
				(gEgo put: 35 gCurRoomNum) ; Chocolate
				(= cycles 1)
			)
			(1
				(cond
					((and (IsFlag 290) (IsFlag 287))
						(= register 1)
						(gMessager say: 26 74 52 0 self) ; "Here, Goody, I found some chocolate for you!"
					)
					((and (not (IsFlag 290)) (not (IsFlag 287)))
						(gMessager say: 26 74 49 0 self) ; MISSING MESSAGE
					)
					((IsFlag 290)
						(gMessager say: 26 74 51 0 self) ; MISSING MESSAGE
					)
					((IsFlag 287)
						(gMessager say: 26 74 50 0 self) ; "Here, Goody, I thought you might be able to use this."
					)
				)
			)
			(2
				(if register
					(client setScript: sSheMakesBonBons)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveRecipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setMotion: PolyPath 171 149 self) ; pepper
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(3
				((ScriptID 895 0) setCycle: Beg) ; pepper
				(goody
					view: 292
					x: 221
					y: 155
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(cond
					((and (IsFlag 290) (IsFlag 291))
						(= register 1)
						(gMessager say: 26 129 44 0 self) ; MISSING MESSAGE
					)
					((and (not (IsFlag 290)) (not (IsFlag 291)))
						(gMessager say: 26 129 42 0 self) ; "Goody, I have something for you. I thought you might like it!"
					)
					((IsFlag 290)
						(gMessager say: 26 129 43 0 self) ; "Here, Goody, this is for you!"
					)
					((IsFlag 291)
						(gMessager say: 26 129 68 0 self) ; MISSING MESSAGE
					)
				)
			)
			(5
				(goody setLoop: 3 setCel: 0 setCycle: End self)
				(jar dispose:)
			)
			(6
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(7
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(8
				((ScriptID 895 0) get: 18 put: 17 gCurRoomNum normalize:) ; pepper, Glass_Jar, Recipe_Card
				(goody setLoop: 1 setCel: 0)
				(SetFlag 21)
				(gGame points: 287 3)
				(if register
					(client setScript: sSheMakesBonBons)
				else
					(= cycles 1)
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveFan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 0)
				(gEgo put: 24 gCurRoomNum) ; Tub_Fan
				(gGame points: 290 3)
				(= cycles 1)
			)
			(1
				(cond
					((and (IsFlag 291) (IsFlag 287))
						(= register 1)
						(= local2 48)
					)
					((and (not (IsFlag 291)) (not (IsFlag 287)))
						(= local2 45)
					)
					((IsFlag 291)
						(= local2 51)
					)
					((IsFlag 287)
						(= local2 46)
					)
				)
				(gMessager say: 26 108 local2 1 3 self)
			)
			(2
				((ScriptID 895 0) setMotion: PolyPath 280 155 self) ; pepper
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 292
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(chair setCel: 0 noun: 33)
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setMotion: PolyPath 171 152 self
				)
			)
			(5
				((ScriptID 895 0) setHeading: 90) ; pepper
				(gMessager say: 26 108 local2 4 self)
			)
			(6
				((ScriptID 895 0) normalize:) ; pepper
				(goody
					view: 299
					x: 238
					y: 166
					setLoop: 1
					setCel: 2
					setCycle: End self
				)
			)
			(7
				(goody x: 238 y: 159 setCel: 0 setCycle: End self)
			)
			(8
				(chair dispose:)
				(goody
					view: 293
					x: 234
					y: 153
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(goody setCycle: CycleBet 3 11 3 self)
				(flies setPri: -1 setMotion: MoveTo 11 88)
			)
			(10
				(chair init: addToPic:)
				(goody
					view: 299
					x: 238
					y: 159
					setLoop: 1
					setCel: 2
					setCycle: Beg self
				)
			)
			(11
				(goody x: 238 y: 166 setCycle: Beg self)
			)
			(12
				(switch local2
					(48
						(gMessager say: 26 108 local2 5 7 self) ; "Thank you, lad! I feel SO much better! I'll tell you what, let me make a little treat for you!"
					)
					(46
						(gMessager say: 26 108 local2 5 self) ; "I feel SO much better! You've been so sweet to me, bringing me the recipe and all. If I had some chocolate, I'd bake you a reward!"
					)
					(45
						(gMessager say: 26 108 local2 5 6 self) ; "Oh, my, my, my! I can't wait another minute!"
					)
					(47
						(gMessager say: 26 108 local2 5 self) ; "I feel SO much better! Thank you, lad! You've been so kind, bringing me the chocolate and all. If I had a bonbon recipe, I'd bake some for you!"
					)
				)
			)
			(13
				(if register
					(client setScript: sSheMakesBonBons)
				else
					(= cycles 1)
				)
			)
			(14
				(flies dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSheMakesBonBons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flies dispose:)
				(= cycles 1)
			)
			(1
				(goody
					view: 294
					setPri: 14
					setLoop: 0
					setCel: 2
					setCycle: End self
				)
			)
			(2
				(goody setLoop: 1 setCycle: Walk setMotion: MoveTo 319 170 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(goody setLoop: 3 setMotion: MoveTo 200 170 self)
			)
			(5
				(goody setLoop: 0 setCycle: End self)
				(bowl init: stopUpd:)
			)
			(6
				(goody setLoop: 1 setCycle: Walk setMotion: MoveTo 319 170 self)
			)
			(7
				(goody
					view: 293
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 200 178 self
				)
			)
			(8
				(goody setLoop: 3 setCycle: End self)
			)
			(9
				(goody setLoop: 4 setCycle: End self)
			)
			(10
				(goody setCycle: CycleBet 2 5 -1 setMotion: MoveTo 319 170 self)
			)
			(11
				(goody
					view: 294
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 200 170 self
				)
			)
			(12
				(goody setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(13
				(bowl dispose:)
				(goody setLoop: 4 setCycle: Walk setMotion: MoveTo 319 170 self)
			)
			(14
				(goody view: 302 setLoop: 2 setMotion: MoveTo 195 170 self)
			)
			(15
				(goody setLoop: 1 setCel: 0 setCycle: End self)
			)
			(16
				(bonBons init:)
				(goodyTalker x: 30)
				(gMessager say: 27 0 53 0 self) ; "Here you are, laddie! I hope you enjoy them!"
			)
			(17
				((ScriptID 895 0) setMotion: PolyPath 125 162 self) ; pepper
			)
			(18
				((ScriptID 895 0) ; pepper
					view: 805
					setCel: 0
					setLoop: 4
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(19
				(gGame points: 292 1)
				(gEgo get: 36) ; Bonbons
				(bonBons dispose:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(20
				((ScriptID 895 0) normalize:) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveSpEd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 952 setLoop: -1 play:)
				(gMessager say: 26 70 0 0 self) ; "I think you'll find this pretty interesting, Goody."
			)
			(1
				(gGame points: 289 2 handsOn:)
				(gLongSong fade: gCurRoom)
				(proc875_5)
				(self dispose:)
			)
		)
	)
)

(instance bonBons of View
	(properties
		x 171
		y 145
		view 299
		cel 2
		priority 14
		signal 16
	)
)

(instance flies of Actor
	(properties
		x 227
		y 78
		noun 32
		view 298
	)
)

(instance bowl of View
	(properties
		x 156
		y 144
		view 299
		cel 1
		priority 14
		signal 16400
	)
)

(instance jar of View
	(properties
		x 195
		y 131
		noun 31
		view 299
		priority 14
		signal 16400
	)
)

(instance chair of View
	(properties
		x 240
		y 111
		noun 4
		view 297
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(108 ; Tub_Fan
				(gCurRoom setScript: sGiveFan)
			)
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goody of Actor
	(properties
		x 221
		y 154
		noun 26
		modNum 290
		approachX 171
		approachY 149
		approachDist 5
		view 290
		loop 1
		signal 20480
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(= gDictionaryWord 96)
				(gCurRoom setScript: sTalkGoody)
			)
			(48 ; Recipe_Card
				(gCurRoom setScript: sGiveRecipe)
			)
			(74 ; Chocolate
				(gCurRoom setScript: sGiveChocolate)
			)
			(108 ; Tub_Fan
				(gCurRoom setScript: sGiveFan)
			)
			(70 ; Special_Edition
				(if (not (IsFlag 289))
					(gCurRoom setScript: giveSpEd)
				else
					(gMessager say: 26 70 22) ; "Oh, I've seen quite enough, laddie. I'll be at that rally!"
				)
			)
			((OneOf theVerb 137 143 141 140 139 138 135 136) ; ???, ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 26 94) ; "Oh, my, what's this? Oh, one of Poor Richard's proverbs. That's nice, dear."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance genPugh of Actor
	(properties
		y 140
		view 292
		loop 1
		signal 16384
	)
)

(instance isaac of Actor
	(properties
		x 149
		y 149
		view 291
		signal 16384
	)
)

(instance ishmael of Actor
	(properties
		x 105
		y 161
		view 295
		signal 16384
	)
)

(instance bakingPans of Feature
	(properties
		y 180
		noun 12
		sightAngle 360
	)
)

(instance barrel of Feature
	(properties
		y 170
		noun 3
		sightAngle 360
	)
)

(instance basketLT of Feature
	(properties
		x 148
		y 63
		noun 15
		nsTop 57
		nsLeft 133
		nsBottom 70
		nsRight 163
		sightAngle 360
	)
)

(instance basketRT of Feature
	(properties
		x 209
		y 63
		noun 18
		nsTop 56
		nsLeft 192
		nsBottom 71
		nsRight 226
		sightAngle 360
	)
)

(instance basketLM of Feature
	(properties
		x 122
		y 85
		noun 19
		nsTop 80
		nsLeft 111
		nsBottom 91
		nsRight 133
		sightAngle 360
	)
)

(instance basketMid of Feature
	(properties
		x 225
		y 1
		noun 29
		nsTop 76
		nsLeft 202
		nsBottom 97
		nsRight 248
		sightAngle 360
	)
)

(instance basketLB of Feature
	(properties
		x 122
		y 105
		noun 23
		nsTop 99
		nsLeft 111
		nsBottom 112
		nsRight 134
		sightAngle 360
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 17)
		(super doVerb: theVerb)
	)
)

(instance basketRB of Feature
	(properties
		x 239
		y 106
		noun 21
		nsTop 98
		nsLeft 219
		nsBottom 114
		nsRight 259
		sightAngle 360
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 96)
		(super doVerb: theVerb)
	)
)

(instance box of Feature
	(properties
		x 277
		y 85
		noun 22
		nsTop 78
		nsLeft 261
		nsBottom 92
		nsRight 293
		sightAngle 360
	)
)

(instance churn of Feature
	(properties
		y 180
		noun 5
		sightAngle 360
	)
)

(instance cookies of Feature
	(properties
		y 120
		noun 10
		sightAngle 360
	)
)

(instance counterTop of Feature
	(properties
		y 100
		noun 2
		sightAngle 360
	)
)

(instance doorJar of Feature
	(properties
		x 26
		y 40
		noun 13
		nsTop 28
		nsLeft 17
		nsBottom 52
		nsRight 35
		sightAngle 360
	)
)

(instance hangBaskets of Feature
	(properties
		y 10
		noun 11
		sightAngle 360
	)
)

(instance loaves of Feature
	(properties
		x 196
		y 106
		noun 24
		nsTop 98
		nsLeft 177
		nsBottom 114
		nsRight 216
		sightAngle 360
	)
)

(instance outside of Feature
	(properties
		x 56
		y 112
		noun 7
		nsTop 74
		nsLeft 42
		nsBottom 151
		nsRight 71
		sightAngle 360
	)
)

(instance pitcherMid of Feature
	(properties
		x 151
		y 82
		noun 20
		nsTop 74
		nsLeft 141
		nsBottom 91
		nsRight 162
		sightAngle 360
	)
)

(instance pitcherTop of Feature
	(properties
		x 180
		y 61
		noun 17
		nsTop 53
		nsLeft 170
		nsBottom 70
		nsRight 190
		sightAngle 360
	)
)

(instance sacks of Feature
	(properties
		x 122
		y 127
		noun 8
		nsTop 117
		nsLeft 99
		nsBottom 138
		nsRight 145
		sightAngle 360
	)
)

(instance stackOStuff of Feature
	(properties
		x 117
		y 63
		noun 14
		nsTop 57
		nsLeft 102
		nsBottom 70
		nsRight 132
		sightAngle 360
	)
)

(instance tins of Feature
	(properties
		x 251
		y 63
		noun 16
		nsTop 57
		nsLeft 232
		nsBottom 69
		nsRight 271
		sightAngle 360
	)
)

(instance windowl of Feature
	(properties
		x 14
		y 108
		noun 6
		nsTop 68
		nsBottom 149
		nsRight 29
		sightAngle 360
	)
)

(instance windowr of Feature
	(properties
		x 89
		y 103
		noun 6
		nsTop 78
		nsLeft 82
		nsBottom 128
		nsRight 97
		sightAngle 360
	)
)

(instance isaacTalker of BalloonTalker
	(properties
		x 150
		y 95
		talkWidth 160
	)
)

(instance ishTalker of BalloonTalker
	(properties
		x 110
		y 105
		talkWidth 140
	)
)

(instance goodyTalker of BalloonTalker
	(properties
		x 50
		y 120
		talkWidth 160
		tailPosn 1
	)
)

(instance pughTalker of BalloonTalker
	(properties
		x 70
		y 100
		talkWidth 160
	)
)

