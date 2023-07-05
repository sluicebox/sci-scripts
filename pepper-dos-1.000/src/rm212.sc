;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use CycleBet)
(use BalloonTalker)
(use ADRoom)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm212 0
	watchManTalker 1
	pughTalker 13
	percyTalker 14
)

(local
	local0
)

(instance rm212 of ADRoom
	(properties
		picture 210
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 207 92 230 99 243 111 264 110 264 102 222 86 206 92
					yourself:
				)
		)
		(super init: &rest)
		(door init: ignoreActors: 1 addToPic:)
		(woodThing init: ignoreActors: 1 addToPic:)
		(gWalkHandler add: barrels gCurRoom)
		(barrels init:)
		(switch gPrevRoomNum
			(610
				(gLongSong number: 216 setLoop: -1 play:)
				(watchMan
					view: 815
					setLoop: 3
					setCycle: Walk
					x: 300
					y: 110
					init:
				)
				(horse init: ignoreActors: 1 addToPic:)
				(driver setPri: 13 init: ignoreActors: 1 addToPic:)
				(carriage
					view: 224
					setLoop: 0
					setCel: 0
					x: 168
					y: 152
					init:
					ignoreActors: 1
					addToPic:
				)
				(imaWench view: 2008 x: 260 y: 155 init: stopUpd:)
				(genPugh view: 2007 x: 168 y: 179 init: stopUpd:)
				(percy view: 228 setLoop: 2 init: stopUpd:)
				((ScriptID 895 1) ; lockjaw
					x: 285
					y: 155
					init:
					actions: ljActions
					view: 217
					setLoop: 5
					cel: 5
					stopUpd:
				)
				(watchManTalker x: 95 y: 90 tailPosn: 4)
				((ScriptID 2018 1) x: 130 y: 115 tailPosn: 1) ; imaText
				(self setScript: abductionScam)
			)
			(200
				((ScriptID 895 0) ; pepper
					x: 249
					y: 109
					init:
					normalize:
					view: 220
					setLoop: 4
					setCel: 0
				)
				(gLongSong number: 213 setLoop: 1 play:)
				(self setScript: pepperBummed)
			)
			(else
				(watchMan view: 815 setLoop: 2 x: 162 y: 142 init:)
				(self setScript: abductionScam)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(abductionScam seconds: 1)
			)
			(6 ; Look
				(super doVerb: theVerb)
			)
			(else
				(abductionScam seconds: 1)
			)
		)
	)

	(method (cue)
		((ScriptID 895 1) setHeading: 90) ; lockjaw
	)

	(method (dispose)
		(gWalkHandler delete: barrels gCurRoom)
		((ScriptID 895 1) actions: 0) ; lockjaw
		(LoadMany 0 971)
		(super dispose:)
	)
)

(instance pepperBummed of Script
	(properties)

	(method (doit)
		(if (and (== (gLongSong prevSignal:) -1) (== (self state:) 3))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(1
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(2
				(gMessager say: 1 0 3 12 self) ; "Don't worry, Lockjaw. I'll save you. I promise!"
			)
			(3)
			(4
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance abductionScam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 610)
					((ScriptID 895 0) x: 249 y: 109 init: normalize:) ; pepper
					(= state 49)
					(self cue:)
				else
					((ScriptID 895 0) ; pepper
						view: 217
						x: 197
						y: 90
						init:
						view: 217
						setLoop: 0
						setCycle: Walk
						setMotion: MoveTo 249 109 self
					)
					((ScriptID 895 1) x: 250 y: 100) ; lockjaw
				)
			)
			(1
				((ScriptID 2000 3) winX: 88 winY: 93 talkWidth: 180 tailPosn: 4) ; PepperTalker
				((ScriptID 895 0) setCel: 5 stopUpd:) ; pepper
				(gMessager say: 1 0 1 1 self) ; "This better work, Lockjaw! If that watchman recognizes either one of us, we're dogmeat!"
			)
			(2
				(gLongSong number: 210 setLoop: -1 play:)
				(watchMan setCycle: Walk setMotion: MoveTo 204 118 self)
			)
			(3
				((ScriptID 2004 0) winX: 141 winY: 107 tailPosn: 4) ; LockjawTalker
				(gMessager say: 1 0 1 2 10 self) ; "You there! Hold it!"
			)
			(4
				(watchMan setMotion: MoveTo 325 110 self)
			)
			(5
				(gLongSong fade:)
				(watchMan dispose:)
				(= ticks 10)
			)
			(6
				(gMessager say: 1 0 2 1 self) ; "All right, so far so good! Just be quiet and make like a baby, Lockjaw."
			)
			(7
				(fourth
					init:
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 208 169 self
				)
				(gLongSong2 number: 919 setLoop: 1 play:)
			)
			(8
				(fourth setScript: catRuns)
				(= seconds 5)
			)
			(9
				((ScriptID 2004 0) winX: 151 winY: 117 tailPosn: 4) ; LockjawTalker
				(gLongSong2 number: 900 setLoop: 1 play:)
				(gMessager say: 1 0 2 2 self) ; "Rrrrr! RRRRRRR! WOOF! WOOF!"
			)
			(10
				((ScriptID 895 0) ; pepper
					view: 217
					setPri: 7
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(11
				((ScriptID 895 0) view: 791 setPri: -1 stopUpd:) ; pepper
				((ScriptID 895 1) ; lockjaw
					x: 248
					y: 110
					view: 217
					setLoop: 4
					setCel: 0
					ignoreActors: 1
					init:
					actions: ljActions
					setCycle: End self
				)
			)
			(12
				(gMessager say: 1 0 2 3 self) ; "Lockjaw! NO!"
			)
			(13
				((ScriptID 895 1) normalize: setMotion: MoveTo 231 135 self) ; lockjaw
				(catRuns dispose:)
				(fourth setLoop: 1 setMotion: MoveTo 250 169 self)
			)
			(14)
			(15
				(gLongSong2 number: 2109 setLoop: 1 play: self)
			)
			(16
				(fourth setMotion: 0 setCycle: 0 setLoop: 3 setCel: 0)
				(= seconds 2)
			)
			(17
				(gLongSong2 number: 953 setLoop: 1 play:)
				(fourth setCycle: End self)
			)
			(18
				(fourth setStep: 7 4 setMotion: MoveTo 420 179)
				(= seconds 2)
			)
			(19
				(gLongSong2 number: 953 setLoop: 1 play:)
				((ScriptID 895 1) ; lockjaw
					view: 226
					x: 278
					y: 165
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(20
				((ScriptID 895 1) setStep: 7 7 setMotion: MoveTo 410 179 self) ; lockjaw
			)
			(21
				(fourth dispose:)
				((ScriptID 895 1) dispose:) ; lockjaw
				(carriage
					init:
					illegalBits: 0
					setLoop: 0
					setCycle: Walk
					setPri: 12
					setMotion: MoveTo 165 158 self
				)
				(gLongSong number: 214 setLoop: 1 play: 0 fade: 127 10 5 0)
			)
			(22
				(carriage
					view: 224
					setLoop: 0
					setCel: 0
					x: 168
					y: 152
					ignoreActors: 1
					addToPic:
				)
				(horse init: ignoreActors: 1 addToPic:)
				(driver init: stopUpd:)
				(fourth
					init:
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 320 158 self
				)
			)
			(23
				((ScriptID 895 1) ; lockjaw
					init:
					actions: ljActions
					setStep: 5 4
					setPri: 14
				)
				(= ticks 120)
				(fourth setMotion: MoveTo 35 158 self)
			)
			(24
				(gLongSong2 number: 2109 setLoop: 1 play:)
			)
			(25
				(gLongSong stop:)
				(gLongSong2 number: 2108 setLoop: 1 play:)
				(= ticks 60)
			)
			(26
				(fourth setMotion: MoveTo -35 158)
				((ScriptID 895 1) ; lockjaw
					x: 168
					y: 135
					view: 217
					setLoop: 4
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(27
				(fourth dispose:)
				(gLongSong2 number: 2110 setLoop: 1 play:)
				((ScriptID 895 1) setCycle: End setMotion: JumpTo 240 158 self) ; lockjaw
			)
			(28
				((ScriptID 895 1) setMotion: JumpTo 285 155 self) ; lockjaw
			)
			(29
				((ScriptID 895 1) setLoop: 5 setCycle: End self) ; lockjaw
			)
			(30
				(sfx number: 2111 setLoop: -1 play:)
				((ScriptID 895 1) setCycle: CycleBet 4 6 -1) ; lockjaw
				(driver setCycle: End self)
			)
			(31
				(carDoor init: setCycle: End self)
				(gLongSong2 number: 2113 setLoop: 1 play:)
			)
			(32
				(driver ignoreActors: 1 addToPic:)
				(carDoor ignoreActors: 1 addToPic:)
				(imaWench init: setCycle: End self)
			)
			(33
				(imaWench
					view: 832
					setCycle: Walk
					setMotion: MoveTo 260 155 self
				)
			)
			(34
				(imaWench view: 228 setLoop: 0 setCel: 0 stopUpd:)
				(genPugh init: setCel: 0 setCycle: End self)
			)
			(35
				(genPugh
					view: 818
					setCycle: Walk
					setMotion: MoveTo 168 179 self
				)
			)
			(36
				(genPugh view: 228 setLoop: 1 stopUpd:)
				(percy init: setCel: 0 setCycle: End self)
				(gLongSong2 number: 2115 setLoop: 1 play:)
			)
			(37
				(= seconds 3)
			)
			(38
				(sfx stop:)
				(gLongSong number: 216 setLoop: -1 play:)
				(percy view: 218 setLoop: 3 cel: 0 setCycle: End self)
			)
			(39
				(percy view: 228 setLoop: 2 stopUpd:)
				(watchMan
					init:
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 300 110 self
				)
			)
			(40
				(watchMan stopUpd:)
				(watchManTalker x: 95 y: 90 tailPosn: 4)
				((ScriptID 2018 1) x: 130 y: 115 tailPosn: 1) ; imaText
				(genPugh view: 2007 setCycle: Fwd)
				(gMessager say: 1 0 2 4 self) ; "Oh, bother, what is it now? Some snot-nosed colonial brat, I suppose. I just had these wheels polished, you know."
			)
			(41
				(genPugh view: 228 setLoop: 1 setCycle: 0 stopUpd:)
				(percy view: 2005 setCycle: Fwd)
				(gMessager say: 1 0 2 5 self) ; "It appears to be a dog, General Pugh, sir."
			)
			(42
				(percy view: 228 setLoop: 2 setCycle: 0 stopUpd:)
				(imaWench view: 2008 setCycle: Fwd)
				(gMessager say: 1 0 2 6 self) ; "A doggie! Oooooh!"
			)
			(43
				(imaWench view: 228 setLoop: 0 setCycle: 0 stopUpd:)
				(gMessager say: 1 0 2 7 self) ; "'Ay! Has anybody seen a strangely clad young girl about? She's a felon, and that dog is her accomplice!"
			)
			(44
				(percy view: 2005 setCycle: Fwd)
				(gMessager say: 1 0 2 8 self) ; "Well that hardly matters, does it, you malodorous fellow. That dog is dead."
			)
			(45
				(percy view: 228 setLoop: 2 setCycle: 0 stopUpd:)
				(gMessager say: 1 0 2 9 self) ; "He is not! He's just stunned, he is!"
			)
			(46
				(percy view: 2005 setCycle: Fwd)
				(gMessager say: 1 0 2 10 self) ; "See here now, man, that dog is stiff as a board!"
			)
			(47
				(percy view: 228 setLoop: 2 setCycle: 0 stopUpd:)
				(gMessager say: 1 0 2 11 self) ; "That dog was stiff before he ever hit your carriage! See there, he's looking at you! Hello, doggie!"
			)
			(48
				(percy view: 2005 setCycle: Fwd)
				(gMessager say: 1 0 2 12 self) ; "He is NOT looking at me because he CAN'T look at me! That dog has perished! He is deceased! Defunct! He is an EX-DOG!"
			)
			(49
				(percy view: 228 setLoop: 2 setCycle: 0 stopUpd:)
				((ScriptID 2004 0) winX: 160 winY: 140 tailPosn: 1) ; LockjawTalker
				(gMessager say: 1 0 2 13 self) ; "Whiiiiine..."
			)
			(50
				(gMessager say: 1 0 2 14 self) ; "See! I told you! I told you!"
			)
			(51
				(percy view: 2005 setCycle: Fwd)
				(gMessager say: 1 0 2 15 self) ; "Oh, why don't you just shut your gob and find this mysterious girl, you fatwit!"
			)
			(52
				(percy view: 228 setLoop: 2 setCycle: 0 stopUpd:)
				(gMessager say: 1 0 2 16 self) ; "Yes, sir! Right away, sir!"
			)
			(53
				(gMessager say: 1 0 2 17 self) ; "Uh-oh! It looks like Pepper's about to get caught! She'd better do something!"
			)
			(54
				(gGame handsOn:)
				((ScriptID 895 0) normalize: setHeading: 180) ; pepper
				(= ticks 10)
			)
			(55
				(SetCursor 160 0)
				(= seconds 15)
			)
			(56
				(if (not local0)
					(gMessager say: 1 0 4 0 self) ; "Hold on now! You, boy! You look familiar!"
				else
					(self cue:)
				)
			)
			(57
				(if (not local0)
					(= global199 1)
					(gCurRoom newRoom: 610)
				else
					(self cue:)
				)
			)
			(58
				(gMessager say: 1 0 3 1 self) ; "Now now, Miss Pugh, you don't want that dog. That dog's an escaped felon, he is."
			)
			(59
				(genPugh view: 2007 setCycle: Fwd)
				(gMessager say: 1 0 3 2 self) ; "See here, you rancid fellow! Since when do lowly watchmen address my Ima? You're not worthy to clean her pony's stable. Don't even look at her!"
			)
			(60
				(genPugh view: 228 setLoop: 1 setCycle: 0 stopUpd:)
				(gMessager say: 1 0 3 3 self) ; "Yes, your Lordship. Sorry, your Lordship. (Like anybody'd WANT to look at her! Brrr, gives me the horrors!)"
			)
			(61
				(watchMan setLoop: 2 setMotion: MoveTo 325 110 self)
			)
			(62
				(watchMan dispose:)
				(imaWench view: 2008 setCycle: Fwd)
				(gMessager say: 1 0 3 4 self) ; "Ooooh, look at him! Isn't him pwecious? Oh, I wuv you, doggie. I'm going to keep you forever and ever. Daddy, help me get the doggie into the carriage!"
			)
			(63
				(imaWench view: 228 setLoop: 0 setCycle: 0 stopUpd:)
				(genPugh view: 2007 setCycle: Fwd)
				(gMessager say: 1 0 3 5 self) ; "But Ima, darling, that creature is infested with fleas, and who knows what else! He'll ruin my beautiful carriage!"
			)
			(64
				(genPugh view: 228 setLoop: 1 setCycle: 0 stopUpd:)
				(imaWench view: 2008 setCycle: Fwd)
				(gMessager say: 1 0 3 6 self) ; "Daddy, I want the doggie."
			)
			(65
				(imaWench view: 228 setLoop: 0 setCycle: 0 stopUpd:)
				(genPugh view: 2007 setCycle: Fwd)
				(gMessager say: 1 0 3 7 self) ; "But, Sweet Pea--"
			)
			(66
				(genPugh view: 228 setLoop: 1 setCycle: 0 stopUpd:)
				(imaWench view: 227 setLoop: 2 setPri: 14 setCycle: End self)
			)
			(67
				(imaWench setCycle: CycleBet 7 10 -1)
				(gMessager say: 1 0 3 8 9 self) ; "I want the doggie! I WANT the DOGGIE!"
			)
			(68
				(genPugh view: 227 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(69
				(genPugh setCycle: CycleBet 7 4 1 self)
			)
			(70
				(genPugh setCycle: Beg self)
			)
			(71
				(genPugh view: 2007 setCycle: Fwd)
				(gMessager say: 1 0 3 10 self) ; "Percy! You heard my daughter! Get the dog into the carriage, you idiot!"
			)
			(72
				(genPugh view: 228 setLoop: 1 stopUpd:)
				(percy view: 2005 setCycle: Fwd)
				(gMessager say: 1 0 3 11 self) ; "Yes sir, General Pugh, sir!"
			)
			(73
				(percy view: 228 setLoop: 2 stopUpd:)
				(imaWench setCycle: Beg self)
			)
			(74
				(imaWench view: 220 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(75
				(= seconds 2)
			)
			(76
				(gLongSong fade:)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance pepperHides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 215 3)
				(= local0 1)
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setMotion: MoveTo 217 99 self
				)
			)
			(1
				((ScriptID 895 0) setHeading: 180) ; pepper
				(= ticks 20)
			)
			(2
				(abductionScam seconds: 1)
				(self dispose:)
			)
		)
	)
)

(instance catRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 919 setLoop: 1 play:)
				(fourth setLoop: 1 setMotion: MoveTo 293 169 self)
			)
			(1
				(gLongSong2 number: 919 setLoop: 1 play:)
				(fourth setLoop: 0 setMotion: MoveTo 208 169 self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance carriage of Actor
	(properties
		x 500
		y 76
		view 222
		signal 16384
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance watchMan of Actor
	(properties
		noun 3
		signal 18432
	)

	(method (doVerb theVerb)
		(if (== theVerb 84) ; Trivia
			(gLongSong2 number: 927 setLoop: 1 play:)
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance fourth of Actor
	(properties
		x 380
		y 169
		view 226
		loop 1
		signal 16384
		illegalBits 0
	)
)

(instance imaWench of Actor
	(properties
		x 204
		y 150
		view 219
		loop 2
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance genPugh of Actor
	(properties
		x 202
		y 148
		view 219
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance percy of Actor
	(properties
		x 209
		y 143
		view 219
		loop 1
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance horse of Prop
	(properties
		x 108
		y 161
		view 218
		loop 1
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance driver of Prop
	(properties
		x 144
		y 192
		z 80
		view 218
		loop 2
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance carDoor of Prop
	(properties
		x 179
		y 197
		z 70
		view 225
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance door of View
	(properties
		x 139
		y 50
		view 210
		loop 1
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance woodThing of View
	(properties
		x 38
		y 96
		view 210
		cel 2
		priority 5
		signal 26641
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance barrels of Feature
	(properties
		x 218
		y 190
		noun 2
		nsTop 47
		nsLeft 206
		nsBottom 99
		nsRight 242
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				((ScriptID 895 0) setScript: pepperHides) ; pepper
			)
			(3 ; Walk
				((ScriptID 895 0) setScript: pepperHides) ; pepper
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance watchManTalker of BalloonTalker
	(properties
		x 30
		y 75
		talkWidth 180
		tailPosn 1
	)

	(method (say)
		(watchMan stopUpd:)
		(super say: &rest)
	)
)

(instance pughTalker of BalloonTalker
	(properties
		x 5
		y 120
		talkWidth 160
		tailPosn 1
	)
)

(instance percyTalker of BalloonTalker
	(properties
		x 33
		y 105
		talkWidth 160
		tailPosn 1
	)
)

(instance sfx of Sound
	(properties)
)

(instance ljActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(super doVerb: theVerb)
			)
			(84 ; Trivia
				(super doVerb: theVerb)
			)
			(else
				(abductionScam seconds: 1)
				(return 1)
			)
		)
	)
)

