;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use sHRoom8)
(use Talker)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	[local0 2]
	local2
	local3 = 1
	local4 = 1
	local5
)

(instance rm250 of Room
	(properties
		noun 18
		picture 250
		style 14
		exitStyle 13
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 224 86 214 90 250 96 116 159 154 153 242 112 296 128 245 158 319 149 319 109 295 107 282 108 269 103 260 90
					yourself:
				)
		)
		(super init:)
		(Load rsMESSAGE 250)
		(Load rsVIEW 900)
		(gFeatures
			add:
				boxesBehindCounter
				boxesOnCounter
				case1
				case2
				case3
				case4
				cashReg
				hooDooPost
				ingredSign
				powerSign
				shelf1
				shelf2
				shelf3
				shelf4
				smallCase
				vooDooDolls
				garlic
				crocBody
				ouangaBags
				foreJars
				poster
				counterSign
			eachElementDo: #init
		)
		(if (not (IsFlag 358))
			(crocMask init:)
		)
		(willy init: setScript: wipeTheCounter)
		(if (== gPrevRoomNum 50) ; interrogation
			(gEgo
				view: 900
				loop: 1
				setCycle: StopWalk -1
				posn: 171 135
				signal: (| $1000 (gEgo signal:))
				init:
			)
			(willy setScript: wipeTheCounter)
			(shopDoor init:)
		else
			(gGkMusic1
				number: 250
				loop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 5 5 0
			)
			(gCurRoom setScript: egoEnters)
		)
		(= gNarrator shopNarrator)
	)

	(method (dispose)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(= gNarrator GKNarrator)
		(DisposeScript 64939)
		(DisposeScript 920)
		(DisposeScript 51)
		(super dispose:)
	)
)

(instance shopNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0)
		(= fore
			(switch global180
				(1 54)
				(11 28)
				(12 10)
				(99 7)
				(else 61)
			)
		)
		(switch global180
			(1
				(if
					(and
						(or (== (gEgo view:) 901) (== (gEgo view:) 900))
						(== (gEgo loop:) 8)
					)
					(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
						(= temp0 (+ (gEgo view:) 1000))
					else
						(if (== (gEgo view:) 900)
							(= temp0 (+ (gEgo view:) 1010 (gEgo cel:)))
						else
							(= temp0 (+ (gEgo view:) 1039 (gEgo cel:)))
						)
						(switch (Random 0 2)
							(0 1)
							(1
								(+= temp0 10)
							)
							(2
								(= temp0 (+ (gEgo view:) 1000))
							)
						)
					)
					(= local5 (gEgo cycleSpeed:))
					(gEgo oldCel: (gEgo cel:))
					(gEgo
						talking: 1
						oldView: (gEgo view:)
						oldLoop: (gEgo loop:)
						oldSig: (gEgo signal:)
						setCel: 1
						view: temp0
						setLoop: (gEgo oldCel:)
						ignoreActors:
						cycleSpeed: 8
					)
					(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
						(gEgo setCycle: ForRepeat)
					else
						(gEgo setCycle: Fwd)
					)
				)
			)
			(11
				(if (== (willy script:) wipeTheCounter)
					(wipeTheCounter dispose:)
				)
				(if local4
					(= local2 1)
					(willy
						view: 2501
						loop: 6
						cel: 0
						setCycle: RandCycle (* (param1 size:) 5) 0 1
					)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setLoop: (gEgo oldLoop:)
				setCel: (gEgo oldCel:)
				signal: (gEgo oldSig:)
				cycleSpeed: local5
				setCycle: StopWalk -1
				talking: 0
			)
		)
		(if local2
			(if (or (gEgo script:) (gCurRoom script:))
				(willy view: 2501 loop: 6 setCycle: 0)
			else
				(willy setScript: wipeTheCounter)
			)
			(= local2 0)
		)
		(super dispose:)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 251
					loop: 0
					init:
					posn: 230 86
					setPri: 4
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo
					normalize: 5
					state: (| $0002 (gEgo state:))
					posn: 239 88
					setMotion: MoveTo 245 100 self
				)
				(shopDoor init: cel: 4 setCycle: Beg self)
			)
			(2 0)
			(3
				(if (and (<= 2 gDay 3) (not (IsFlag 60)))
					(client setScript: egoAndCazaunox)
				else
					(gEgo ignoreActors: 1 setMotion: PolyPath 209 121 self)
				)
			)
			(4
				(gEgo setMotion: MoveTo 171 135 self)
			)
			(5
				(Face gEgo willy self)
			)
			(6
				(= cycles 6)
			)
			(7
				(gMessager say: 25 0 3 0 self) ; "Hi."
			)
			(8
				(willy setScript: wipeTheCounter)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoAndCazaunox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 0)
				(gEgo setMotion: PolyPath 209 121 self)
			)
			(1
				(gEgo setMotion: MoveTo 161 146 self)
			)
			(2
				(Face gEgo willy self)
			)
			(3
				(= cycles 6)
			)
			(4
				(gMessager sayRange: 25 0 1 1 2 self) ; "Hello."
			)
			(5
				(shopDoor hide:)
				(lady init: setSpeed: 8 setCycle: End self)
			)
			(6
				(shopDoor setCel: 4 show: setCycle: Beg self)
				(lady
					view: 253
					loop: 5
					cel: 0
					setCycle: Walk
					posn: 245 88
					setMotion: PolyPath 177 134 self
				)
				(gMessager say: 25 0 20 1) ; "(RRCC)Yap! Yap, yap!"
			)
			(7 0)
			(8
				(lady loop: 1 cel: 0)
				(willy loop: 5 cel: 0 setCycle: End self)
			)
			(9
				(= seconds 2)
			)
			(10
				(= local4 1)
				(gMessager sayRange: 25 0 1 3 6 self) ; "(RRCC. ENTERS VOODOO SHOP)Bonjour, Monsieur Walker."
			)
			(11
				(gMessager say: 25 0 1 7 self) ; "(RRCC)Do you think that would help? I do hope you're right. I said three rosaries this morning for Our Lady's intervention."
				(lady view: 252 loop: 2 cel: 0 setCycle: End self)
			)
			(12)
			(13
				(= cycles 2)
			)
			(14
				(gMessager say: 25 0 1 8 self) ; "Rosaries are good, sure enough, but you burn those candles, too, and you're gonna whip any old no sleep gris gris, I tell you for sure."
			)
			(15
				(gMessager say: 25 0 1 9 self) ; "(RRCC)Very well, Mr. Walker. Put them on my account and send them around to my house."
				(lady view: 252 loop: 3 cel: 0 setCycle: End self)
			)
			(16)
			(17
				(if (Random 0 40)
					(= ticks 10)
				else
					(gMessager say: 25 0 20 1 self) ; "(RRCC)Yap! Yap, yap!"
				)
			)
			(18
				(gMessager say: 25 0 1 10 self) ; "(RRCC. GOSSIPING. UPSET.)Oh, and there's another thing! I didn't catch her at it, but I KNOW Mrs. Le Fevre put Stomach Ache Powder in my tea at the last meeting of the Creole Grande Dames. I've been in misery!"
			)
			(19
				(gMessager say: 25 0 1 11 self) ; "You put nine pins heads up in a little box, add a pinch of graveyard dust, and put it under her front porch step."
				(lady view: 252 loop: 4 cel: 0 setCycle: End self)
			)
			(20)
			(21
				(if (Random 0 40)
					(= ticks 10)
				else
					(gMessager say: 25 0 20 1 self) ; "(RRCC)Yap! Yap, yap!"
				)
			)
			(22
				(gMessager say: 25 0 1 12 self) ; "That'll turn the trick back on Mrs. Le Fevre, and SHE'll be the one with the bellyache. I have the pins and the dust right here if you want them."
				(lady view: 252 loop: 2 cel: 0 setCycle: End self)
			)
			(23)
			(24
				(if (Random 0 40)
					(= ticks 10)
				else
					(gMessager say: 25 0 20 1 self) ; "(RRCC)Yap! Yap, yap!"
				)
			)
			(25
				(gMessager sayRange: 25 0 1 13 17 self) ; "(RRCC. PRAYERFUL)If the Blessed Virgin will grant me her protection, I'll be safe from these practitioners of evil!"
			)
			(26
				(lady
					view: 253
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 230 92 self
				)
			)
			(27
				(shopDoor hide:)
				(lady
					posn: 226 86
					view: 2521
					loop: 1
					cel: 0
					setPri: 4
					ignoreActors:
					setCycle: End self
				)
				(willy setScript: wipeTheCounter)
			)
			(28
				(lady
					cel: 1
					view: 253
					setCycle: Walk
					posn: 251 88
					loop: 6
					setPri: 2
					setMotion: MoveTo 270 78 self
				)
				(shopDoor show: cel: 3 setCycle: Beg)
			)
			(29
				(SetFlag 60)
				(gGame handsOn:)
				(lady dispose:)
				(self dispose:)
			)
		)
	)
)

(instance talkToWilly of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(willy setScript: 0 loop: 5 cel: 0 setCycle: End self)
				(Face gEgo willy self)
			)
			(1 0)
			(2
				(= temp0
					(cond
						((<= 7 gDay 10) 19)
						((not (IsFlag 56))
							(SetFlag 56)
							8
						)
						((not (IsFlag 57))
							(SetFlag 57)
							9
						)
						((not (IsFlag 58))
							(SetFlag 58)
							10
						)
						(else
							(switch (Random 0 5)
								(0 11)
								(1 12)
								(2 13)
								(3 14)
								(4 15)
								(5 16)
							)
						)
					)
				)
				(gMessager say: 28 11 temp0 0 self)
			)
			(3
				(willy loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(willy setScript: wipeTheCounter)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wipeTheCounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(willy view: 2501 loop: 2 cel: 0 setPri: -1 setCycle: End self)
			)
			(1
				(willy loop: 3 cel: 0 setCycle: Fwd)
				(= seconds (Random 4 9))
			)
			(2
				(willy loop: 2 cel: 2 setCycle: Beg self)
			)
			(3
				(willy loop: 1 setCycle: End self)
			)
			(4
				(= seconds (Random 3 6))
			)
			(5
				(willy setCycle: Beg self)
			)
			(6
				(self init:)
			)
		)
	)
)

(instance showSomethingNormal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo willy self)
			)
			(1
				(gEgo view: 255 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(willy setScript: 0)
				(if (not (OneOf register 17 42))
					(willy setCel: 0 setLoop: 5 setCycle: End self)
				else
					(+= state 3)
					(= cycles 1)
				)
			)
			(3
				(willy view: 255 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 100)
			)
			(5
				(willy setCycle: Beg self)
			)
			(6
				(cond
					((== register 17)
						(gMessager say: 28 register 7 0 self) ; "(NRCC)Look at the Voodoo paraphernalia around the body in the photograph. Are you sure you can't tell me anything about it?"
					)
					((and gMsgType (Message msgGET 250 28 register 0 1))
						(gMessager say: 28 register 0 0 self)
					)
					(else
						(gMessager say: 28 0 0 0 self) ; "Does this mean anything to you?"
					)
				)
			)
			(7
				(gEgo cel: 7 setCycle: Beg self)
				(if (not (OneOf register 17 42))
					(willy view: 2501 loop: 2 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(8)
			(9
				(willy setScript: wipeTheCounter)
				(gEgo normalize: 1 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showMurderPhotoToWilly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo willy self)
			)
			(1
				(gEgo view: 255 loop: 0 cel: 0 setCycle: End self)
				(willy setScript: 0 loop: 5 cel: 0 setCycle: End self)
			)
			(2 0)
			(3
				(gMessager say: 28 17 6 1 self) ; "Would you mind taking a look at this photograph?"
			)
			(4
				(willy view: 255 loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(gMessager sayRange: 28 17 6 2 3 self) ; "Cabrit sans cor'!"
			)
			(6
				(gEgo cel: 7 setCycle: Beg self)
				(willy setCycle: Beg self)
			)
			(7 0)
			(8
				(gEgo normalize: 7)
				(gMessager sayRange: 28 17 6 4 7 self) ; "Nothing. I didn't say anything like that. You heard me wrong, man."
			)
			(9
				(willy view: 2501 loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(willy setScript: wipeTheCounter)
				(self cue:)
			)
			(11
				(gEgo getPoints: -999 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateWilly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo willy self)
			)
			(1
				(if (not (IsFlag 108))
					(gMessager say: 28 10 4 1 self) ; "Mind if I ask you a few questions?"
				else
					(gMessager say: 28 10 5 1 self) ; "Can I ask you just a few more questions?"
				)
				(willy
					setScript: 0
					view: 2501
					loop: 2
					cel: 3
					setCycle: Beg self
				)
			)
			(2)
			(3
				(= cycles 2)
			)
			(4
				(if (not (IsFlag 108))
					(SetFlag 108)
					(gMessager say: 28 10 4 2 self) ; "Ask what you want. I'll answer what I want."
				else
					(gMessager say: 28 10 5 2 self) ; "Whatever, man."
				)
			)
			(5
				(willy loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gGame handsOn:)
				(= global178 11)
				(gCurRoom newRoom: 50) ; interrogation
				(self dispose:)
			)
		)
	)
)

(instance willyGetYourMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 1)
				(Face gEgo willy self)
			)
			(1
				(gEgo
					view: 254
					setCel: 0
					setLoop: 0
					setSpeed: 10
					setCycle: Osc 1
				)
				(willy setScript: 0 setCel: 0 setLoop: 5 setCycle: End)
				(gMessager say: 28 32 0 1 self) ; "I have a hundred dollars. You still want to sell that crocodile mask?"
			)
			(2
				(gEgo view: 255 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(gMessager say: 28 32 0 2 self) ; "(RRCC. EXCITED)That's a hundred dollars, sure enough! The mask, it's yours, Sir."
			)
			(4
				(willy view: 254 setCel: 0 setLoop: 2 setCycle: CT 4 1 self)
			)
			(5
				(gEgo normalize: 1 900)
				(willy setCycle: End self)
			)
			(6
				(willy
					view: 258
					setCel: 0
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 112 129 self
				)
			)
			(7
				(willy setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(8
				(willy setCel: 0 setLoop: 2 1 setCycle: CT 3 1 self)
			)
			(9
				(gGkSound1 number: 212 setLoop: 1 play:)
				(willy setCycle: End self)
			)
			(10
				(willy
					view: 256
					setCel: 0
					setLoop: 0 1
					setCycle: Walk
					setPri: 86
					setMotion: MoveTo 186 92 self
				)
			)
			(11
				(willy
					view: 257
					setCel: 0
					setLoop: 0 1
					setCycle: Fwd
					setMotion: MoveTo 261 98 self
				)
			)
			(12
				(crocMask hide:)
				(willy view: 256 setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(13
				(willy
					posn: 266 106
					setCel: 0
					setLoop: 2 1
					setCycle: Walk
					setMotion: MoveTo 186 92 self
				)
			)
			(14
				(willy setMotion: MoveTo 138 121 self)
			)
			(15
				(willy
					posn: 137 123
					setCel: 0
					setLoop: 3 1
					setCycle: CT 4 1 self
				)
			)
			(16
				(willy setLoop: 3 1 setCel: 5 setCycle: End self)
				(crocMask
					show:
					view: 256
					setCel: 0
					setLoop: 4
					setPri: 130
					posn: 148 100
				)
			)
			(17
				(gMessager sayRange: 28 32 0 3 4 self) ; "Here you go. Careful it don't bite you, now."
			)
			(18
				(gEgo
					view: 254
					setLoop: 1
					setCel: 0
					get: 21 ; crocMask
					put: 30 ; hundred
					setCycle: CT 3 1 self
				)
			)
			(19
				(crocMask dispose:)
				(gEgo setCycle: End self)
			)
			(20
				(gEgo getPoints: -999 1)
				(gEgo normalize: 1 900)
				(willy view: 2501 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(21
				(gMessager say: 28 32 0 5 self) ; "Don't you go forgettin' your lagniappe--a free bottle of Master Gamblin' Oil."
			)
			(22
				(gEgo view: 251 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(23
				(gMessager sayRange: 28 32 0 6 11 self) ; "The sign said I could get Lady Luck Oil instead."
				(gEgo setCycle: Beg self)
			)
			(24 0)
			(25
				(gEgo normalize: 1)
				(= ticks 10)
			)
			(26
				(gEgo
					posn: 168 133
					view: 251
					setLoop: 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(27
				(gEgo getPoints: -999 1 setCycle: Beg self)
			)
			(28
				(gEgo normalize: 1 get: 22) ; oil
				(SetFlag 358)
				(willy posn: 138 121 setScript: wipeTheCounter)
				(gGame handsOn:)
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
				(gGame handsOff:)
				(shopDoor hide:)
				(gEgo
					posn: 256 92
					view: 251
					loop: 2
					cel: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance willy of Actor
	(properties
		noun 28
		sightAngle 20
		approachX 171
		approachY 135
		x 138
		y 121
		view 2501
		loop 5
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 11 10 31) ; Talk, Ask, crocMask
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 17) ; murderPhoto
				(if (IsFlag 42)
					(gEgo setScript: showSomethingNormal 0 theVerb)
				else
					(SetFlag 42)
					(gEgo setScript: showMurderPhotoToWilly)
				)
			)
			((== theVerb 32) ; hundred
				(gEgo setScript: willyGetYourMask)
			)
			((not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
				(if
					(OneOf
						theVerb
						116 ; BoarMask
						104 ; chamPot
						31 ; crocMask
						129 ; lit_flash
						115 ; lotsCash
						33 ; luckyDog_
						4 ; magGlass
						121 ; BoarGuise
						120 ; WolfGuise
						64 ; collar_
						122 ; BoarRobe or WolfRobe
						73 ; disguise
						74 ; shirt
						114 ; WolfMask
						20 ; lakeScale
						21 ; snakeSkin_
						26 ; musScale
						51 ; twoScales
						22 ; fortScale_
						49 ; phonePage
						46 ; oil
					)
					(if (and gMsgType (Message msgGET 250 28 theVerb 0 1))
						(gMessager say: 28 theVerb 0 0 self)
					else
						(gMessager say: 28 0 0 0 self) ; "Does this mean anything to you?"
					)
				else
					(gEgo setScript: showSomethingNormal 0 theVerb)
				)
			)
			(else
				(switch theVerb
					(11 ; Talk
						(gEgo setScript: talkToWilly)
					)
					(10 ; Ask
						(gEgo setScript: interrogateWilly)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance lady of Actor
	(properties
		x 227
		y 84
		view 252
	)
)

(instance shopDoor of Prop
	(properties
		noun 23
		approachX 254
		approachY 94
		x 227
		y 84
		view 250
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 6 8) ; Open, Operate
	)

	(method (handleEvent)
		(super handleEvent: &rest)
		(if (not (willy script:))
			(willy setScript: wipeTheCounter)
		)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 6) (== theVerb 8)) ; Open, Operate
			(gCurRoom setScript: egoExits)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance crocMask of View
	(properties
		noun 8
		sightAngle 20
		x 284
		y 44
		view 250
	)

	(method (init)
		(super init:)
		(self setPri: 90)
	)
)

(instance boxesBehindCounter of Feature
	(properties
		noun 1
		sightAngle 20
		x 90
		y 80
	)

	(method (init)
		(self createPoly: 80 89 79 79 83 70 92 67 99 68 102 85 88 90)
		(super init:)
	)
)

(instance boxesOnCounter of Feature
	(properties
		noun 1
		sightAngle 20
		x 69
		y 121
	)

	(method (init)
		(self
			createPoly: 64 128 68 127 68 123 48 119 61 114 78 118 82 126 67 132
		)
		(super init:)
	)
)

(instance case1 of Feature
	(properties
		noun 2
		sightAngle 20
		x 216
		y 93
	)

	(method (init)
		(self
			createPoly:
				196
				96
				164
				92
				164
				85
				183
				78
				198
				81
				218
				72
				237
				74
				237
				100
				197
				118
		)
		(super init:)
	)
)

(instance case2 of Feature
	(properties
		noun 3
		sightAngle 20
		x 165
		y 118
	)

	(method (init)
		(self createPoly: 197 119 136 145 137 114 143 111 143 101 165 93 196 97)
		(super init:)
	)
)

(instance case3 of Feature
	(properties
		noun 4
		sightAngle 20
		x 108
		y 133
	)

	(method (init)
		(self
			createPoly:
				136
				145
				71
				145
				66
				134
				82
				127
				82
				121
				71
				116
				100
				106
				136
				112
		)
		(super init:)
	)
)

(instance case4 of Feature
	(properties
		noun 5
		sightAngle 20
		x 47
		y 133
	)

	(method (init)
		(self
			createPoly:
				70
				145
				33
				145
				30
				140
				35
				135
				33
				126
				27
				123
				42
				118
				66
				123
				66
				125
				63
				128
		)
		(super init:)
	)
)

(instance cashReg of Feature
	(properties
		noun 6
		sightAngle 20
		x 132
		y 122
	)

	(method (init)
		(self createPoly: 119 104 125 97 139 91 145 92 145 105 138 110)
		(super init:)
	)
)

(instance hooDooPost of Feature
	(properties
		noun 11
		sightAngle 20
		x 70
		y 82
	)

	(method (init)
		(self createPoly: 77 81 64 84 64 59 74 52 75 48 87 46 88 67 83 70 82 77)
		(super init:)
	)
)

(instance ingredSign of Feature
	(properties
		noun 12
		sightAngle 20
		x 190
		y 126
	)

	(method (init)
		(self createPoly: 176 139 176 123 202 110 202 128)
		(super init:)
	)
)

(instance powerSign of Feature
	(properties
		noun 17
		sightAngle 20
		x 241
		y 99
	)

	(method (init)
		(self createPoly: 228 115 229 98 250 87 250 104)
		(super init:)
	)
)

(instance shelf1 of Feature
	(properties
		noun 19
		sightAngle 20
		x 225
		y 124
	)

	(method (init)
		(self
			createPoly:
				219
				145
				268
				120
				277
				122
				281
				132
				264
				141
				259
				135
				245
				134
				240
				138
				239
				145
		)
		(super init:)
	)
)

(instance shelf2 of Feature
	(properties
		noun 20
		sightAngle 20
		x 135
		y 120
	)

	(method (init)
		(self
			createPoly:
				173
				145
				155
				144
				157
				140
				244
				95
				255
				95
				256
				99
				175
				140
				174
				145
		)
		(super init:)
	)
)

(instance shelf3 of Feature
	(properties
		noun 21
		sightAngle 20
		x 135
		y 35
	)

	(method (init)
		(self createPoly: 173 30 107 49 107 34 161 21 174 22)
		(super init:)
	)
)

(instance shelf4 of Feature
	(properties
		noun 22
		sightAngle 20
		x 135
		y 50
	)

	(method (init)
		(self createPoly: 174 41 174 31 108 49 107 61)
		(super init:)
	)
)

(instance smallCase of Feature
	(properties
		noun 24
		nsLeft 188
		nsTop 50
		nsRight 218
		nsBottom 71
		sightAngle 20
		x 200
		y 65
	)
)

(instance vooDooDolls of Feature
	(properties
		noun 27
		sightAngle 20
		x 135
		y 60
	)

	(method (init)
		(self createPoly: 173 65 108 86 108 60 174 41)
		(super init:)
	)
)

(instance garlic of Feature
	(properties
		noun 10
		sightAngle 20
		x 100
		y 160
	)

	(method (init)
		(self
			createPoly:
				42
				22
				46
				40
				35
				43
				42
				50
				40
				58
				34
				63
				41
				69
				39
				72
				47
				80
				39
				90
				31
				86
				25
				96
				32
				99
				33
				109
				24
				122
				35
				129
				35
				136
				31
				139
				33
				145
				0
				145
				0
				21
		)
		(super init:)
	)
)

(instance crocBody of Feature
	(properties
		noun 7
		sightAngle 20
		x 285
		y 43
	)

	(method (init)
		(self
			createPoly:
				269
				88
				273
				66
				263
				74
				258
				72
				265
				64
				271
				57
				266
				40
				287
				21
				303
				38
				291
				46
				304
				59
				295
				74
				297
				96
				288
				103
				277
				103
				275
				99
				269
				98
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 358)
					(gMessager say: noun theVerb 18 0) ; "And I thought he was funny-looking before!"
				else
					(gMessager say: noun theVerb 17 0) ; "It's a mannequin wearing a crocodile mask."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ouangaBags of Feature
	(properties
		noun 15
		sightAngle 20
		x 110
		y 160
	)

	(method (init)
		(self
			createPoly:
				48
				103
				48
				96
				54
				84
				56
				73
				52
				75
				45
				73
				43
				64
				45
				58
				43
				54
				43
				47
				52
				38
				51
				29
				57
				22
				84
				22
				87
				29
				78
				34
				79
				39
				71
				44
				75
				49
				74
				53
				65
				59
				60
				57
				60
				65
				61
				69
				58
				74
				56
				83
				62
				85
				64
				95
				65
				105
				55
				106
		)
		(super init:)
	)
)

(instance foreJars of Feature
	(properties
		noun 9
		sightAngle 20
		x 237
		y 125
	)

	(method (init)
		(self
			createPoly:
				189
				145
				192
				138
				200
				137
				202
				133
				211
				132
				212
				126
				221
				126
				224
				121
				231
				121
				235
				115
				240
				115
				242
				112
				248
				111
				252
				107
				259
				106
				259
				102
				268
				101
				269
				99
				274
				99
				277
				102
				277
				109
				270
				111
				269
				114
				261
				116
				259
				119
				251
				120
				251
				123
				244
				125
				243
				129
				234
				130
				233
				134
				223
				135
				222
				140
				213
				142
				212
				144
		)
		(super init:)
	)
)

(instance poster of Feature
	(properties
		noun 16
		nsLeft 196
		nsTop 22
		nsRight 221
		nsBottom 46
		sightAngle 20
		x 207
		y 38
	)
)

(instance counterSign of Feature
	(properties
		noun 13
		sightAngle 20
		x 91
		y 102
	)

	(method (init)
		(self createPoly: 82 100 93 94 100 108 91 113)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gEgo getPoints: 140 1)
				(SetFlag 41)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

