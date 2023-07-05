;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use rgCastle)
(use Kq6IconBar)
(use Print)
(use Conversation)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm750 0
	roomConv 1
	vizHead 2
	vizier 3
	genie 4
	proc750_5 5
	cassima 6
	vizierTimer 7
	tiedUpRightNow 8
	sword 9
)

(local
	[local0 31] = [1 275 161 2 273 161 3 270 161 4 268 160 5 267 159 5 264 156 6 262 157 7 260 157 8 256 158 9 254 158 -1]
	[local31 45] = [7 3 0 0 6 2 4 1 6 3 4 1 6 4 4 1 6 5 4 1 6 6 4 1 6 7 4 1 7 4 1 0 7 0 1 0 7 1 1 0 7 2 2 -1 -32768]
	local76
	local77
	local78
	local79
	local80
	local81
	local82 = 1
	local83
	local84
)

(procedure (proc750_5 param1)
	(if (and argc param1 local81)
		(gTheIconBar
			delete: (gTheIconBar at: 0)
			addToFront: local81
			curIcon: local81
			walkIconItem: local81
		)
		(= local81 0)
		(gGame oldCurIcon: (gTheIconBar at: 0))
	)
	(gGame handsOn:)
	(if (gTheIconBar contains: swordIcon)
		(gTheIconBar disable: 4 5)
	else
		(gTheIconBar disable: 0)
	)
)

(instance rm750 of CastleRoom
	(properties
		noun 2
		picture 750
		style 10
		vanishingY -10000
		autoLoad 0
		minScaleSize 73
		maxScaleSize 102
		minScaleY 139
		maxScaleY 189
	)

	(method (init &tmp temp0 temp1)
		(if (and global100 (== gPrevRoomNum 99) (FileIO fiEXISTS {g})) ; speedRoom
			(gGlobalSound number: 742 setLoop: -1 play:)
			(gEgo get: 31) ; peppermint
		)
		(= temp1 gTheCursor)
		(gGame setCursor: 999 1)
		(if
			(and
				global100
				(== gPrevRoomNum 99) ; speedRoom
				(FileIO fiEXISTS {g})
				(Print
					addText: {Does Jollo have lamp?}
					addButton: 0 {No} 0 12
					addButton: 1 {Yes} 0 26
					init:
				)
			)
			((gInventory at: 25) owner: 750) ; newLamp
		)
		(if
			(and
				global100
				(== gPrevRoomNum 99) ; speedRoom
				(FileIO fiEXISTS {g})
				(Print
					addText: {Does Cassima have dagger?}
					addButton: 0 {No} 0 12
					addButton: 1 {Yes} 0 26
					init:
				)
			)
			((gInventory at: 8) owner: 870) ; dagger
		)
		(gGame setCursor: temp1 1)
		(if (== ((gInventory at: 25) owner:) 750) ; newLamp
			(Load rsSCRIPT 751)
			(LoadMany rsVIEW 717 754)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 -10 319 161 266 157 240 139 251 139 269 152 278 153 259 134 219 130 109 130 48 139 23 145 0 154 0 -10
					yourself:
				)
		)
		(super init: &rest)
		(gFeatures add: door theWindows stairs eachElementDo: #init)
		(gEgo init: actions: egoDoVerb)
		(sword addToPic:)
		(vizier addToPic:)
		(cassima init: setScript: tiedUpRightNow)
		(self setScript: enterRoom)
		(UnLoad 129 750)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(gCurRoom newRoom: 790)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 751)
		(DisposeScript 752)
		(DisposeScript 753)
		(DisposeScript 754)
		(DisposeScript 755)
		(DisposeScript 759)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 751
					normal: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					setLoop: 1
					setPri: 2
					cel: 1
					posn: 275 161
					ignoreHorizon:
					ignoreActors: 1
				)
				(= cycles 2)
			)
			(1
				(if (!= [local0 (+ local80 3)] -1)
					(-- state)
					(gEgo
						cel: [local0 local80]
						x: [local0 (+ local80 1)]
						y: [local0 (+ local80 2)]
					)
					(+= local80 3)
					(= cycles 8)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					oldScaleSignal: 0
					view: 900
					loop: 9
					cel: 7
					setLoop: -1
					setPri: -1
					posn: 241 134
					setScale: Scaler 102 76 189 139
					setSpeed: 6
					setCycle: 0
				)
				(= cycles 2)
				(UnLoad 128 751)
			)
			(3
				(gEgo
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 201 134 self
				)
			)
			(4
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo normal: 0 view: 7500 setLoop: 3 setCycle: 0 looper: 0)
				(= cycles 2)
			)
			(5
				(self setScript: startScr self)
			)
			(6
				(DisposeScript 1005)
				(vizier stopUpd:)
				(if (== ((gInventory at: 25) owner:) gCurRoomNum) ; newLamp
					(genie setScript: 0 view: 703 setLoop: 1 cel: 0)
					(self setScript: (ScriptID 751 0) self) ; jolloGivesLamp
				else
					(genie setScript: continuedWindup)
					(= cycles 2)
				)
			)
			(7
				(if (not (genie script:))
					(genie view: 702 setScript: continuedWindup)
				)
				(proc750_5)
				(if (or (not gHowFast) (not (HaveMouse)))
					(= seconds 15)
				else
					(= seconds 8)
				)
			)
			(8
				(gGame handsOff:)
				(continuedWindup caller: self)
				(= local79 1)
			)
			(9
				(cassima setScript: 0 stopUpd:)
				(gMessager say: 1 0 4 1 self) ; "SEND A BALL OF LIGHT TO FRAZZLE!"
			)
			(10
				(= global106 gEgo)
				(if (!= (gGlobalSound2 number:) 707)
					(gGlobalSound2 number: 707 setLoop: -1 play:)
				)
				(self setScript: (ScriptID 752 0) self genie) ; throwDazzle
			)
			(11
				(gMessager say: 1 0 4 2 self oneOnly: 0) ; "The dazzle ball hits Alexander!"
			)
			(12
				(EgoDead 18) ; "Genie, meenie, minie, moe...Alexander can't be slow!"
			)
		)
	)
)

(instance continuedWindup of Script
	(properties)

	(method (init)
		(= local76 (genie x:))
		(= local77 (genie y:))
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== [local31 local78] -32768)
					(= local78 0)
				)
				(genie
					loop: [local31 local78]
					cel: [local31 (+ local78 1)]
					x: (+ [local31 (+ local78 2)] local76)
					y: (+ [local31 (+ local78 3)] local77)
				)
				(-- state)
				(if (and local79 (== (genie loop:) 6))
					(++ state)
				)
				(+= local78 4)
				(= cycles 8)
			)
			(1
				(= local79 0)
				(genie setCycle: Beg self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance startScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(roomConv add: -1 1 0 1 1 init: self) ; "Alexander! Be careful, Alhazred has a sword!"
			)
			(2
				(vizHead cel: 1 forceUpd:)
				(= cycles 4)
			)
			(3
				(roomConv add: -1 1 0 1 2 init: self) ; "Shut up, wench! SHAMIR SHAMAZEL!!! Get in here!"
			)
			(4
				(vizHead cel: 2 forceUpd:)
				(= ticks 60)
			)
			(5
				(self setScript: (ScriptID 752 1) self genie) ; geniePoofIn
			)
			(6
				(vizHead cel: 1 forceUpd:)
				(= cycles 4)
			)
			(7
				(roomConv
					add: -1 1 0 1 3 ; "Here I am, Master!"
					add: -1 1 0 1 4 ; "It's about time, you bumbling fool! How could you let him follow me?"
					add: -1 1 0 1 5 ; "Well, there were the guard dogs, Master, and then...."
					add: -1 1 0 1 6 ; "NEVER MIND!! Just kill him--kill him NOW!"
					init: self
				)
			)
			(8
				(vizHead cel: 2 forceUpd:)
				(= cycles 4)
			)
			(9
				(gMessager say: 1 0 1 7 self) ; "<sigh> As you wish, Master."
			)
			(10
				(genie
					view: 702
					loop: 6
					cel: 0
					cycleSpeed: 7
					setCycle: CT 4 1 self
				)
			)
			(11
				(genie setCycle: Beg self)
			)
			(12
				(roomConv add: -1 1 0 1 8 init: self) ; "RAZZLE DAZZLE, SNAP AND SNAZZLE...."
			)
			(13
				(DisposeScript 1005)
				(DisposeScript 1029)
				(DisposeScript 1012)
				(self dispose:)
			)
		)
	)
)

(instance getSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(gEgo
					oldScaleSignal: 0
					view: 900
					loop: 9
					cel: 2
					setPri: -1
					setLoop: -1
					scaleSignal: 1
					scaleX: 96
					scaleY: 96
					cycleSpeed: 6
					moveSpeed: 6
					ignoreActors: 1
					normal: 0
					setCycle: 0
				)
				(= cycles 2)
			)
			(1
				(gGame givePoints: 1)
				(gEgo
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 229 137 self
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo normal: 0 view: 7500 setLoop: 3 setCycle: 0 looper: 0)
				(= cycles 2)
			)
			(4
				(gMessager say: 4 5 8 1 self) ; "In desperation, Alexander fixes upon the only weapon in sight."
			)
			(5
				(gEgo
					normal: 0
					posn: 234 142
					view: 751
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setScale: 0
					setPri: 2
					scaleX: 128
					scaleY: 128
					setCycle: CT 2 1 self
				)
			)
			(6
				(sword dispose:)
				(if global169
					(gCurRoom drawPic: 750 15)
				else
					(gCurRoom drawPic: 750 100)
				)
				(gEgo setCycle: End self)
			)
			(7
				(gEgo
					posn: 205 149
					setLoop: 2
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(8
				(gGlobalSound2 number: 750 setLoop: 1 play:)
				(gEgo
					posn: 195 152
					setLoop: 3
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(9
				(gMessager say: 4 5 8 2 self oneOnly: 0) ; "Zounds! This sword must weigh a ton!"
			)
			(10
				(gTheIconBar enable: 6)
				(= local81 (gTheIconBar at: 0))
				(gTheIconBar
					delete: (gTheIconBar at: 0)
					addToFront: (swordIcon init: cursor: swordCursor yourself:)
					curIcon: swordIcon
					walkIconItem: swordIcon
				)
				(gGame oldCurIcon: swordIcon)
				(DisposeScript 1005)
				(DisposeScript 1029)
				(DisposeScript 1012)
				(DisposeScript 1020)
				(DisposeScript 1001)
				(proc750_5)
				(if (or (not gHowFast) (not (HaveMouse)))
					(= seconds 15)
				else
					(= seconds 8)
				)
			)
			(11
				(proc750_5 1)
				(= cycles 1)
			)
			(12
				(gGame handsOff:)
				(if (== ((gInventory at: 25) owner:) 740) ; newLamp
					(= cycles 2)
				else
					(vizier
						view: 7504
						posn: 120 138
						setLoop: 5
						setStep: 6 6
						setCycle: Walk
						setMotion: MoveTo 189 145 self
					)
				)
			)
			(13
				(gEgo hide:)
				(vizier
					view: 7504
					posn: 203 151
					setLoop: 6
					cel: 0
					setCycle: CT 2 1 self
				)
				(gGlobalSound number: 705 setLoop: 1 play:)
			)
			(14
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 756 setLoop: 1 play: self)
				(vizier setCycle: End self)
			)
			(15)
			(16
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 971 setLoop: 1 play: self)
			)
			(17
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 652 setLoop: 1 play:)
				(vizier
					view: 7513
					setLoop: 0
					cel: 0
					posn: 198 139
					setCycle: End self
				)
			)
			(18
				(gMessager say: 6 23 16 3 self) ; "ALEXANDER! NO!"
			)
			(19
				(vizier setLoop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(20
				(gGlobalSound2 number: 652 setLoop: 1 play:)
				(vizier setCycle: End self)
			)
			(21
				(EgoDead 41) ; "Touche! Alexander should have been on guard."
			)
		)
	)
)

(instance tiedUpRightNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cassima cycleSpeed: 12)
				(= cycles 1)
			)
			(1
				(while (== register (cassima cel:))
					(= register (Random 0 7))
				)
				(if (< register (cassima cel:))
					(cassima setCycle: CT register -1 self)
				else
					(cassima setCycle: CT register 1 self)
				)
			)
			(2
				(if (< ((ScriptID 755 3) state:) 340) ; fightPart1
					(-= state 2)
				)
				(= cycles (Random 10 40))
			)
			(3
				(if (== ((gInventory at: 8) owner:) 870) ; dagger
					(= next untieSelfAndStand)
					(self dispose:)
				else
					((ScriptID 755 3) next: (ScriptID 755 1)) ; fightPart1, noDagger
				)
			)
		)
	)
)

(instance untieSelfAndStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(= cycles 2)
			)
			(1
				(cassima
					view: 782
					loop: register
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(if (< register 4)
					(-- state)
					(++ register)
				)
			)
			(2
				(= next (ScriptID 755 2)) ; cassimaHasDagger
				(self dispose:)
			)
		)
	)
)

(instance sword of View
	(properties
		x 210
		y 111
		noun 4
		sightAngle 180
		view 7500
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gCast contains: genie)
					(gMessager say: noun theVerb 7) ; "It looks like Alexander will have to deal with Shamir before he does anything else, and that sword would be rather useless against a genie!"
				else
					(gCurRoom setScript: getSword)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vizier of Actor
	(properties
		x 110
		y 136
		noun 6
		view 7500
		loop 1
		signal 16384
	)

	(method (addToPic)
		(super addToPic: &rest)
		(vizHead init: posn: (- x 2) y 31)
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((and script (== script vizierTimer) (OneOf theVerb 23 1)) ; ???, Look
				(switch theVerb
					(23 0) ; ???
					(1 0) ; Look
				)
			)
			((OneOf theVerb 28 8 5 14 16 10) ; spellBook, dagger, Do, potion, scythe, ???
				(= temp0 (if (gCast contains: genie) 7 else 8))
				(gMessager say: noun theVerb temp0)
			)
			((== theVerb 1) ; Look
				(if (gCast contains: genie)
					(gMessager say: 6 1 7) ; "Alhazred looks confident that his genie will be able to take care of the handsome young interloper once and for all!"
				else
					(gMessager say: 6 1 9) ; "Alhazred handles his sword deftly. He looks quite enraged, and more than ready to avenge himself on the interloping prince who has ruined his dreams of glory!"
				)
			)
			((== theVerb 23) ; ???
				(gGame handsOff:)
				(gGame givePoints: 1)
				(gCurRoom setScript: (ScriptID 755 0)) ; startFight
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vizierTimer of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (and (not script) (not register))
			(if (or (not gHowFast) (not (HaveMouse)))
				(= register 12)
			else
				(= register 6)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not script)
					(= seconds register)
				)
			)
			(1
				(gGame handsOff:)
				(self dispose:)
			)
		)
	)
)

(instance vizHead of View
	(properties
		view 7500
		loop 1
		cel 2
		signal 24576
	)
)

(instance genie of Actor
	(properties
		x 91
		y 147
		noun 5
		view 702
		loop 8
		cel 6
		scaleSignal 1
		scaleX 112
		scaleY 112
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(63 ; mint
				(gEgo put: 23) ; mint
				(gGame handsOff:)
				(script caller: (ScriptID 753 0)) ; giveGenieMint
				(= local79 1)
				((ScriptID 753 0) start: -1) ; giveGenieMint
				(gCurRoom setScript: (ScriptID 753 0)) ; giveGenieMint
			)
			(67 ; peppermint
				(gEgo put: 31) ; peppermint
				(gGame handsOff:)
				(script caller: (ScriptID 753 0)) ; giveGenieMint
				(= local79 1)
				((ScriptID 753 0) start: -1) ; giveGenieMint
				(gCurRoom setScript: (ScriptID 753 0)) ; giveGenieMint
			)
			(92 ; realLamp
				(gGame handsOff:)
				(script caller: (ScriptID 754 0)) ; useLamp
				(= local79 1)
				((ScriptID 754 0) start: -1) ; useLamp
				(gCurRoom setScript: (ScriptID 754 0)) ; useLamp
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cassima of Actor
	(properties
		x 21
		y 161
		noun 7
		view 7820
	)

	(method (cue)
		(super cue:)
		(switch (++ local84)
			(1
				(self
					setLoop: 3
					setCycle: Walk
					posn: 131 160
					setMotion: MoveTo 32 175 self
				)
			)
			(2
				(self setLoop: 4 setCycle: End)
			)
		)
	)

	(method (doVerb theVerb)
		(if local82
			(switch theVerb
				(1 ; Look
					(gMessager say: noun theVerb 17) ; "So this is where Alhazred stashed the real Cassima during the wedding ceremony! She struggles against her bonds, but, thankfully, doesn't seem to be harmed."
				)
				(2 ; Talk
					(if local83
						(gMessager say: noun theVerb 20) ; "Alexander should save Cassima first and worry about wooing her later."
					else
						(++ local83)
						(gMessager say: noun theVerb 19) ; "Don't be afraid, princess."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(switch theVerb
				(1 ; Look
					(gMessager say: noun theVerb 18) ; "The courageous princess is being stalked by the outraged vizier!"
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 3
		onMeCheck 2
	)
)

(instance theWindows of Feature
	(properties
		noun 8
		onMeCheck 8
	)
)

(instance stairs of Feature
	(properties
		noun 9
		onMeCheck 16388
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(super dispose:)
		(gWalkHandler delete: self)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 2 4) ; Look, Talk, ???
			(super doVerb: theVerb)
		else
			(gMessager say: 1 0 0 0 0 0) ; "Alexander is already carrying that."
			(return 1)
		)
	)
)

(instance swordCursor of Cursor
	(properties
		view 7506
	)
)

(instance swordIcon of Kq6IconItem
	(properties
		view 7502
		loop 0
		cel 0
		message 23
		signal 65
		maskView 7502
		maskCel 2
		lowlightColor 19
		hrView 7505
	)

	(method (init &tmp temp0)
		(if
			(= temp0
				(if (and global169 (not (Platform 5)))
					(Platform 6)
				)
			)
			(= maskView 7505)
		)
		(super init: &rest)
	)

	(method (dispose &tmp temp0)
		(super dispose: &rest)
		(if
			(= temp0
				(if (and global169 (not (Platform 5)))
					(Platform 6)
				)
			)
			(= maskLoop 1)
			(= maskView 7502)
		)
	)
)

