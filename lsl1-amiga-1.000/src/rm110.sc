;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use n940)
(use PolyPath)
(use Polygon)
(use Blk)
(use Feature)
(use LoadMany)
(use Wander)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm110 0
)

(local
	tipCount
	ordered
	tookADrink
	beenToldPrice
	jokeCycles
	jokeNumber
	selection
	pitch
	theta
	saidHello
	clickX
	clickY
)

(procedure (PickAJoke)
	(switch (++ jokeNumber)
		(1
			(Print 110 99 #at 5 5 #mode 0 #dispose) ; "...'cause Thursday's your night in the barrel!"
		)
		(2
			(Print 110 100 #at 5 5 #mode 0 #dispose) ; "...just think of the money he saved!"
		)
		(3
			(Print 110 101 #at 5 5 #mode 0 #dispose) ; "...and there stood the pig and the cow!"
		)
		(4
			(Print 110 102 #at 5 5 #mode 0 #dispose) ; "...dammit Liza, doncha know ya own reflection?"
		)
		(5
			(Print 110 103 #at 5 5 #mode 0 #dispose) ; "...what's the matter, Honey? Ain't you got a vase?"
		)
		(6
			(Print 110 104 #at 5 5 #mode 0 #dispose) ; "...You idiot! I said POSSE!!"
		)
		(7
			(Print 110 105 #at 5 5 #mode 0 #dispose) ; "...nobody can eat THAT much ice cream!"
		)
		(8
			(Print 110 106 #at 5 5 #mode 0 #dispose) ; "...25 bucks, same as in town!"
		)
		(else
			(Print 110 107 #at 5 5 #mode 0 #dispose) ; "...a lotta guys just leave her hanging in a tree somewhere!"
			(= jokeNumber 0)
		)
	)
)

(instance rm110 of LLRoom
	(properties
		picture 110
		north 120
		south 100
	)

	(method (init)
		(LoadMany rsSOUND 110 113 114 115 116 117 118 119)
		(LoadMany rsVIEW 110 112 113 801)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 310 189 310 149 287 142 270 154 116 154 89 130 99 106 129 85 128 77 82 107 72 107 51 126 27 130 12 151 12 189
					yourself:
				)
		)
		(switch gPrevRoomNum
			(120
				(self setScript: sFromStoreroom)
				(if (!= (gTheMusic number:) 110)
					(gTheMusic setLoop: 1)
				)
				(gTheMusic fade: 127 15 5 0)
			)
			(100
				(gTheMusic number: 110 loop: -1 vol: 127 flags: 1 play:)
				(gEgo setPri: -1)
			)
			(140
				(HandsOff)
				(gEgo normal: 0 z: 1000 hide:)
				(gCurRoom setScript: sFromPimp)
			)
			(else
				(gEgo posn: 160 170)
			)
		)
		(gEgo init: actions: egoActions)
		(gEHead actions: egoActions)
		(super init:)
		(jukebox cycleSpeed: global101 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(if (!= (gTheMusic number:) 110)
			(jukebox setCycle: Fwd)
		else
			(jukebox stopUpd:)
		)
		(blondGuy init: stopUpd:)
		(blondHand init: stopUpd:)
		(blondHead cycleSpeed: (+ global101 2) init: setScript: sGuyScript)
		(babe
			cycleSpeed: (+ global101 1)
			init:
			approachVerbs: 3 4 10 11 5 ; Do, Inventory, Zipper, Taste/Smell, Talk
			setScript: sBabeScript
		)
		(babeTop cycleSpeed: (+ global101 1) init: approachVerbs: 3 4 10 11 5) ; Do, Inventory, Zipper, Taste/Smell, Talk
		(ken cycleSpeed: (+ global101 1) init: stopUpd:)
		(kenHead cycleSpeed: (+ global101 1) init: setScript: sKenTalksGirl)
		(dude init: stopUpd:)
		(skinnyMan init: cycleSpeed: global101 setScript: sDudeScript)
		(fatso cycleSpeed: (+ global101 1) init: setScript: sFatsoScript)
		(lefty cycleSpeed: global101 init: stopUpd:)
		(fan cycleSpeed: global101 setCycle: Fwd init:)
		(mooseEyes cycleSpeed: global101 init: setScript: (sDudeScript new:))
		(door
			cycleSpeed: (+ global101 1)
			init:
			stopUpd:
			approachVerbs: 3 4 10 11 ; Do, Inventory, Zipper, Taste/Smell
		)
		(if (!= gPrevRoomNum 140)
			(door stopUpd:)
		)
		(peephole cycleSpeed: global101 stopUpd: init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(stool init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(moose init:)
		(painting init:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(!= (gTheMusic number:) 110)
				(== (gTheMusic prevSignal:) -1)
				(not (jukebox script:))
			)
			(sPlaysong start: 5)
			(jukebox setScript: sPlaysong)
		)
		(if
			(and
				(not jokeCycles)
				(== (gEgo view:) 801)
				(!= (kenHead script:) sTellJoke)
			)
			(kenHead setScript: sTellJoke)
		else
			(-- jokeCycles)
		)
		(cond
			(script)
			((< (gEgo y:) 104)
				(HandsOff)
				(gCurRoom setScript: sToStoreroom)
			)
			((and (gEgo mover:) (== (gEgo view:) 801))
				(if (== (lefty script:) sLeftyServes)
					(gEgo setMotion: 0 x: 208 y: 150)
					(Print 110 0) ; "Don't be so impatient, Larry. Wait until Lefty brings your order."
				else
					(= clickX ((User curEvent:) x:))
					(= clickY ((User curEvent:) y:))
					(HandsOff)
					(self setScript: sGetUp)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 110 1) ; "This is the sleaziest bar you've ever been in."
				(Print 110 2 #at -1 140) ; "(And you've been in quite a few.)"
			)
			(5 ; Talk
				(Print 110 3) ; "Talk to someone in particular."
			)
			(11 ; Taste/Smell
				(Print 110 4) ; "This place HAS no taste!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(switch newRoomNumber
			(140
				(gTheMusic fade: 90 15 5 0)
			)
			(100
				(gTheMusic fade:)
			)
			(120
				(gTheMusic setLoop: -1 fade: 90 15 5 0)
			)
			(160
				(gTheMusic stop:)
			)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sFromPimp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peephole z: 1000)
				(= cycles 1)
			)
			(1
				(if (!= (gTheMusic number:) 110)
					(gTheMusic number: 110 loop: -1 vol: 127 flags: 1 play:)
				else
					(gTheMusic fade: 127 10 5 0)
				)
				(door setCycle: End self)
			)
			(2
				(gEgo
					egoSpeed:
					show:
					z: 0
					normal: 1
					illegalBits: $8000
					x: 319
					y: 145
					setMotion: MoveTo 290 151 self
				)
			)
			(3
				(door setCycle: Beg self)
			)
			(4
				(peephole z: 32)
				(NormalEgo 1)
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: setCycle: End self)
			)
			(1
				(NormalEgo 2)
				(gEgo setMotion: MoveTo (gEgo x:) 154 self)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(kenHead z: 23 setLoop: 5 setScript: sKenTalksGirl)
				(ken setCel: 0)
				(if (not tookADrink)
					(HandsOn)
					(if
						(and
							(!= (CueObj client:) stool)
							((CueObj client:) approachX:)
							(!= (gTheIconBar curIcon:) (ScriptID 0 25)) ; icon0
						)
						(gEgo
							setMotion:
								PolyPath
								((CueObj client:) approachX:)
								(+ (gEgo z:) ((CueObj client:) approachY:))
								CueObj
						)
					else
						(gEgo setMotion: PolyPath clickX clickY)
					)
					(self dispose:)
				else
					(Print 110 5) ; "You feel a little light-headed. You are unsure if you'll be able to walk straight."
					(= tookADrink (Min tookADrink 8))
					(gCurRoom setScript: sWalkDrunk)
				)
			)
		)
	)
)

(instance sWalkDrunk of Script
	(properties)

	(method (doit &tmp i)
		(super doit: &rest)
		(= pitch (* (SinMult theta 1000) tookADrink))
		(= theta (mod (+= theta 5) 360))
		(for ((= i 1)) (<= i 15) ((++ i))
			(gTheMusic send: i 224 pitch)
		)
		(if (and (not register) (< state 2))
			(= register (Random 5 25))
			(gEgo setLoop: (Random 0 3))
		else
			(-- register)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: observeBlocks: drunkCircle setMotion: Wander)
				(= seconds 6)
			)
			(1
				(if (== tookADrink 5)
					(Print 110 6) ; "Boy, are you drunk!"
				)
				(if (-- tookADrink)
					(self init:)
				else
					(gEgo setMotion: 0 setLoop: -1 ignoreBlocks: drunkCircle)
					(Print 110 7) ; "Shaking your head, you finally clear away the cobwebs and are once again able to walk in your standard, studly style."
					(= cycles 1)
				)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sKenTalksGirl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ken setLoop: 7 setCel: 0)
				(kenHead setLoop: 5 setCel: 0)
				(= cycles (Random 24 32))
			)
			(1
				(kenHead setCycle: Fwd)
				(= cycles (Random 24 32))
			)
			(2
				(kenHead setCel: 0 setCycle: 0 stopUpd:)
				(self init:)
			)
		)
	)
)

(instance sTellJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 50 100))
			)
			(1
				(if (== (kenHead loop:) 5)
					(ken setCel: 1)
					(kenHead z: 1000)
				else
					(++ state)
				)
				(= cycles 1)
			)
			(2
				(ken setCel: 2)
				(kenHead z: 23 setLoop: 6)
				(= cycles 1)
			)
			(3
				(kenHead setLoop: 6 setCycle: Fwd)
				(= cycles (Random 43 90))
			)
			(4
				(Print 110 8 #at 5 5 #mode 0 #dispose) ; "...blah, blah, blah, blah, blah..."
				(= seconds 5)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(PickAJoke)
				(kenHead setLoop: 8 setCel: 0 setCycle: End)
				(ken setCel: 3)
				(= seconds 7)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 110 9 #at 5 5 #mode 0 #dispose) ; "Har, har!!"
				(ken setLoop: 9 setCycle: Fwd)
				(kenHead z: 1000)
				(= cycles 20)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ken setLoop: 7 setCel: 2)
				(kenHead z: 23 setLoop: 6 setCel: 0 setCycle: 0 stopUpd:)
				(= cycles 20)
			)
			(8
				(Print 110 10 #at -1 140) ; "(So what was the setup to THAT punch line?)"
				(= jokeCycles (Random 150 250))
				(self dispose:)
			)
		)
	)
)

(instance sSulk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kenHead z: 1000)
				(ken setLoop: 7 setCel: 1)
				(= jokeCycles (Random 400 800))
				(= cycles (Random 123 234))
			)
			(1
				(ken setCel: 2 stopUpd:)
				(kenHead z: 23 setScript: sKenTalksGirl)
			)
		)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 208 150 self)
			)
			(1
				(gEgo
					egoSpeed:
					view: 801
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 1 setCel: 0)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(gEgo userSpeed:)
				(self dispose:)
			)
		)
	)
)

(instance sToStoreroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 126 82 self)
			)
			(1
				(gCurRoom newRoom: 120)
				(self dispose:)
			)
		)
	)
)

(instance sFromStoreroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 94 100 setMotion: PolyPath 91 110 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 110 11) ; "You rap loudly on the Naugahyde door."
				(= seconds 4)
			)
			(1
				(gTheMusic3 number: 119 loop: 1 vol: 127 flags: 1 play:)
				(peephole setCycle: End self)
			)
			(2
				(Print 110 12 #at 180 55) ; "Yeah. Whatsda passwoid?"
				(= seconds 15)
			)
			(3
				(Print 110 13 #at 180 55) ; "Scram, dog breath!"
				(peephole setCycle: Beg)
				(gTheMusic3 number: 119 loop: 1 vol: 127 flags: 1 play:)
				(self dispose:)
			)
			(4
				(Print 110 14 #at 220 55 #dispose) ; "Come on in!"
				(gTheMusic3 number: 119 loop: 1 vol: 127 flags: 1 play:)
				(peephole setCycle: Beg self)
			)
			(5
				(peephole z: 1000 dispose:)
				(door setCycle: End self)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom setScript: sGoPimp)
				(self dispose:)
			)
		)
	)
)

(instance sGoPimp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 340 141 self)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance sLeftyServes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic3 number: 113 setLoop: 1 flags: 1 play:)
				(if (== (lefty loop:) 7)
					(lefty setCel: 1)
				)
				(= cycles 1)
			)
			(1
				(lefty setLoop: 0 setCycle: End self)
			)
			(2
				(lefty
					setLoop: 1
					setCel: 0
					x: (+ (lefty x:) 30)
					setCycle: CT 7 1 self
				)
			)
			(3
				(gTheMusic3 number: 114 play:)
				(lefty setCycle: CT 11 1 self)
			)
			(4
				(gTheMusic3 number: 115 play:)
				(lefty setCycle: End self)
			)
			(5
				(gTheMusic3 number: 113 play:)
				(lefty
					setLoop: 2
					setCel: 0
					x: (- (lefty x:) 16)
					setCycle: CT 2 1 self
				)
			)
			(6
				(lefty x: (- (lefty x:) 14) setCycle: CT 5 1 self)
			)
			(7
				(gTheMusic3 number: 114 play:)
				(lefty setCycle: CT 11 1 self)
			)
			(8
				(gTheMusic3 number: 115 play:)
				(lefty setCycle: End self)
			)
			(9
				(lefty setLoop: 3 setCel: 0 setCycle: End self)
			)
			(10
				(lefty setLoop: 4 setCycle: Fwd)
				(= seconds (Random 2 3))
			)
			(11
				(gTheMusic3 number: 113 play:)
				(lefty setLoop: 7 setCel: 0 setCycle: End self)
			)
			(12
				(lefty setLoop: 6 setCel: 255 setCycle: Beg self)
			)
			(13
				(Print 110 15 #at 73 42) ; "That'll be $5.00, please."
				(lefty setLoop: 7 setCel: 255)
				(if (< gLarryDollars 5)
					(Print 110 16) ; ""I'm presently a little short," you stammer."
					(Print 110 17 #at 73 42) ; "Yeah, and not just in the financial department, Dead-Beat!" he replies, "I'll teach you to try and stiff ol' Lefty! Come with me!"
					(HandsOff)
					(gCurRoom setScript: sThrowLarry)
				else
					(Print 110 18) ; "You flip five bucks onto the counter."
					(-= gLarryDollars 5)
					(switch ordered
						(0
							(if (gEgo has: 5) ; whiskey
								(++ tookADrink)
								(Print 110 19) ; "Since you can only balance one open glass of whiskey at a time, you toss this one down immediately."
							else
								(Points 52 1)
								(gEgo get: 5) ; whiskey
								(= ordered 999)
								(Print 110 20) ; "You don't drink the whiskey, but instead, decide to carry it with you wherever you go, precariously balanced in an open shot glass."
							)
						)
						(1
							(++ tookADrink)
							(Print 110 21) ; "You delicately sip the wine until it's all gone."
							(Print 110 22) ; "You tell Lefty, "I find this impudent and sassy, with the slightest hint of impertinence.""
							(Print 110 23) ; "He gazes at you longingly and moistens his lips!"
						)
						(2
							(++ tookADrink)
							(Print 110 24) ; "You down the beer in your pseudo-macho style, and slam the mug back on the bar."
						)
					)
					(if (!= ordered 999)
						(switch tookADrink
							(1
								(Print 110 25) ; "Suddenly you feel a little woozy."
							)
							(else
								(Print 110 26) ; "This one tastes even better than the last. Don't you think one more seems like a good idea?"
							)
						)
					)
					(= ordered 0)
					(= cycles 1)
				)
			)
			(14
				(self dispose:)
			)
		)
	)
)

(instance sBabeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(babe setCel: 0 stopUpd:)
				(babeTop setCel: 0 stopUpd:)
				(= cycles (Random 30 60))
			)
			(1
				(if (Random 0 3)
					(babe setCycle: Fwd)
					(= cycles (Random 40 80))
				else
					(babeTop setCel: 0 setCycle: End self)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sGuyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(blondHead setLoop: 0 setCel: 0)
				(blondHand setPri: 10)
				(= cycles 2)
			)
			(1
				(blondHead stopUpd:)
				(= cycles (Random 75 200))
			)
			(2
				(if (Random 0 1)
					(blondHead setCycle: Fwd)
					(= cycles (Random 15 25))
				else
					(blondHead setLoop: 1 setCel: 0 setCycle: End self)
					(blondHand z: 1000)
				)
			)
			(3
				(if (blondHead cycler:)
					(blondHead setCel: 0 setCycle: 0)
					(self init:)
				else
					(blondHead setLoop: 2 setCycle: Fwd)
					(= seconds (Random 3 5))
				)
			)
			(4
				(blondHead setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(5
				(blondHand z: 17 setPri: 11)
				(self init:)
			)
		)
	)
)

(instance sFatsoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fatso setLoop: 3 setCel: 0)
				(= cycles 2)
			)
			(1
				(fatso stopUpd:)
				(= cycles (Random 75 200))
			)
			(2
				(cond
					((<= (gGame detailLevel:) 2)
						(self init:)
					)
					((not (Random 0 2))
						(fatso setLoop: 3 setCycle: End self)
					)
					(else
						(fatso setLoop: 4 setCycle: CT 4 1)
						(= cycles (Random 5 10))
					)
				)
			)
			(3
				(if (== (fatso loop:) 4)
					(fatso setCycle: End self)
				else
					(self init:)
				)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sDudeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client stopUpd:)
				(= cycles (Random 50 150))
			)
			(1
				(if (<= (gGame detailLevel:) (client detailLevel:))
					(self init:)
				else
					(client setCycle: End)
					(= cycles (Random 6 20))
				)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sThrowLarry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #z 1000)
				(kenHead setScript: 0)
				(gCurRoom style: 6 drawPic: 720)
				(= seconds 3)
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance sPlaysong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register selection)
				(gGame setCursor: 999 1)
				(Animate (gCast elements:) 0)
				(= selection
					(PrintD
						{Lefty's proudly presents for your listening and drinking pleasure:}
						103
						81
						{Taxicab from Hell}
						206
						103
						81
						{I Can Can You}
						320
						103
						81
						{Air For A "G" String}
						410
						103
						81
						{Mantovani's Revenge}
						310
						103
						81
						{"Wedding March"\nby Bloughengrin}
						411
						103
						81
						{Theme from "Bo-Larry"}
						351
						103
						81
						{Prelude to an\nAfternoon of Fawn}
						610
						103
						81
						{That's a Sweet Moon, Honey}
						390
						103
						81
						{Her Albert Has\nSome Iguana Gas}
						510
					)
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				(gTheMusic fade: 0 5 5 1 self)
			)
			(1
				(if register
					(UnLoad 132 register)
				else
					(UnLoad 132 110)
				)
				(gTheMusic2 number: 116 loop: 1 vol: 127 flags: 1 play: self)
			)
			(2
				(sScratchy
					number: 117
					loop: -1
					vol: 127
					flags: 1
					priority: 10
					play:
				)
				(= seconds 3)
			)
			(3
				(client setCycle: Fwd)
				(gTheMusic vol: 127 loop: 1 number: selection play: self)
				(HandsOn)
				(= seconds 3)
			)
			(4
				(sScratchy fade:)
			)
			(5
				(= seconds 3)
			)
			(6
				(sScratchy play:)
				(gTheMusic2 number: 118 play: self)
			)
			(7
				(gTheMusic number: 110 vol: 0 loop: -1 play:)
				(= cycles 1)
			)
			(8
				(client setCycle: Beg)
				(sScratchy fade:)
				(gTheMusic fade: 127 10 5 0)
				(= seconds 3)
			)
			(9
				(UnLoad 132 selection)
				(= selection 0)
				(self start: 0 dispose:)
			)
		)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(5 ; whiskey
						(if (== (gEgo view:) 801)
							(++ tookADrink)
							(gEgo put: 5) ; whiskey
							(Print 110 27) ; "The whiskey burns its way down your throat. You vow to never again buy a "well" brand."
						else
							(Print 110 28) ; "It's not good etiquette to drink standing up."
						)
					)
					(1 ; breathSpray
						(if (== (gEgo view:) 801)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 110 29 #at -1 20 #time 2) ; "Ahhhh."
							(++ gSprayCounter)
							(= gSpraySeconds 600)
							(ClearFlag 20) ; fMouthSmellsBad
							(if (IsFlag 21) ; fNearPerson
								(ClearFlag 21) ; fNearPerson
								(Print 110 30) ; "It's about time!!"
							)
							(if (> gSprayCounter 9)
								(Print 110 31) ; "Since your breath spray is now empty, you toss it away."
								(gEgo put: 1 510) ; breathSpray
								(= gSprayCounter 0)
							)
							(return 1)
						)
					)
				)
			)
		)
	)
)

(instance drunkCircle of Cage
	(properties
		top 150
		left 25
		bottom 185
		right 310
	)
)

(instance jukebox of Prop
	(properties
		x 36
		y 122
		description {the jukebox}
		sightAngle 40
		approachX 58
		approachY 120
		lookStr {Gee, Dad. It's a Wurlitzer!}
		view 110
		priority 4
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(if (== (gEgo view:) 801)
			(if (== theVerb 2) ; Look
				(super doVerb: theVerb)
			else
				(Print 110 32) ; "How can you do that from there?"
			)
		else
			(switch theVerb
				(3 ; Do
					(Print 110 33) ; "True to form, you stick your finger in the coin return slot hoping to find some change. You don't."
				)
				(10 ; Zipper
					(Print 110 34) ; "Over the years, a few coin-operated machines have screwed you, but this is scarcely the time nor the place for you to seek revenge!"
				)
				(11 ; Taste/Smell
					(Print 110 4) ; "This place HAS no taste!"
				)
				(4 ; Inventory
					(switch invItem
						(0 ; wallet
							(HandsOff)
							(Print 110 35) ; "You slip a buck into the juke box, and search for a suitably sleazy selection."
							(-= gLarryDollars 1)
							(jukebox setScript: sPlaysong)
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance blondHead of Prop
	(properties
		x 125
		y 115
		z 17
		description {Ivan's head}
		sightAngle 40
		view 113
		priority 10
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(blondGuy doVerb: theVerb invItem)
	)
)

(instance blondHand of View
	(properties
		x 126
		y 121
		z 17
		description {Ivan's hand}
		sightAngle 40
		view 113
		loop 13
		cel 1
		priority 10
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(blondGuy doVerb: theVerb invItem)
	)
)

(instance blondGuy of Person
	(properties
		x 106
		y 115
		description {Ivan}
		sightAngle 40
		lookStr {Obviously, heavy drinking is not just an obsession with this guy!}
		view 113
		loop 13
		priority 10
		signal 16401
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 110 36) ; "It's not a good idea to pick a fight in a dive like this, Larry!"
			)
			(5 ; Talk
				(Print 110 37) ; "Hey, buddy," you shout to the man at the end of the bar, "is this the only place in this town to find a little action?"
				(Print 110 38) ; "Hardly," he snorts between belts, "ain'cha never heard o' taxicabs?"
			)
			(10 ; Zipper
				(Print 110 39) ; "Larry! That's a good way to get yourself killed in a place like this!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance babeTop of Prop
	(properties
		x 146
		y 125
		z 21
		description {the babe}
		sightAngle 40
		approachX 141
		approachY 154
		view 113
		loop 12
		priority 10
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(babe doVerb: theVerb invItem)
	)
)

(instance babe of Person
	(properties
		x 146
		y 125
		description {the babe}
		sightAngle 40
		approachX 141
		approachY 154
		lookStr {She may not be a great looker, but think of the muscles she must have in that leg!}
		view 113
		loop 11
		priority 10
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 110 40 #at -1 20) ; "SLAP!"
			)
			(11 ; Taste/Smell
				(self doVerb: 3)
			)
			(5 ; Talk
				(Print 110 41) ; "Hi there, lovely leg!" you say casually. "My name's Larry; Larry Laffer."
				(Print 110 42 #at -1 20) ; "Who cares?" she replies sarcastically. "Stop bugging me, or I'll have my boyfriend take care of you when he gets back from the rest room!"
				(Print 110 43 #at -1 140) ; "(Looks like you're operating at your standard level of charm, Larry.)"
			)
			(10 ; Zipper
				(Print 110 44) ; "Yeah, Larry! Smart thinking. Why waste your precious time on small talk?"
				(Print 110 45) ; "Larry, this girl's not interested in a manly man like you. Keep hunting. You'll find someone sooner or later...."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance kenHead of Prop
	(properties
		x 178
		y 128
		z 23
		description {Ken's head}
		sightAngle 40
		view 113
		loop 5
		priority 11
		signal 18448
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(ken doVerb: theVerb invItem)
	)
)

(instance ken of Person
	(properties
		x 178
		y 128
		description {Ken}
		sightAngle 40
		lookStr {A large man sits beside the only woman in Lefty's. He's obviously thrilled with the sound of his own voice.}
		view 113
		loop 7
		priority 10
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 110 46) ; "It's not a good idea to pick a fight in a place like this, Larry!"
			)
			(5 ; Talk
				(cond
					((not (== (gEgo view:) 801))
						(Print 110 47) ; "He has nothing to say, but says it continuously."
					)
					((== (ken script:) sKenTalksGirl)
						(Print 110 48) ; "He's not bothering you now; leave him alone, you big bully!"
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 110 49) ; ""Cram it, clown!" you tell the bore on the stool next to you!"
						(kenHead setScript: sSulk)
					)
				)
			)
			(10 ; Zipper
				(Print 110 39) ; "Larry! That's a good way to get yourself killed in a place like this!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance dude of View
	(properties
		x 236
		y 130
		description {James}
		sightAngle 40
		view 113
		loop 13
		cel 2
		priority 10
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(skinnyMan doVerb: theVerb invItem)
	)
)

(instance skinnyMan of Person
	(properties
		x 237
		y 130
		z 22
		description {James}
		sightAngle 40
		lookStr {A skinny man sits at the bar, talking to his overweight friend.}
		view 113
		loop 10
		cel 2
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 110 46) ; "It's not a good idea to pick a fight in a place like this, Larry!"
			)
			(10 ; Zipper
				(Print 110 50) ; "Larry! Put that thing away!"
				(Print 110 51 #at -1 140) ; "(Besides, he already has a date!)"
			)
			(5 ; Talk
				(Print 110 52) ; "Excuse me," you say to the skinny man, "is by any chance your last name Sprat?"
				(Print 110 53) ; "Buzz off, Jerk!"
				(Print 110 54) ; "He continues to concentrate on his overweight buddy, leaving you with nothing to do but find something else to do."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance fatso of Person
	(properties
		x 263
		y 132
		description {Richard}
		sightAngle 40
		lookStr {An overweight man sits at the bar, talking to his skinny friend.}
		view 113
		loop 3
		cel 5
		priority 10
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 110 46) ; "It's not a good idea to pick a fight in a place like this, Larry!"
			)
			(5 ; Talk
				(Print 110 55) ; "Excuse me, buddy," you say to the overweight man, "but how many stools are under there?"
				(Print 110 56) ; "Jer, er, buzz off, Jerk!"
				(Print 110 57) ; "He continues to concentrate on his underweight buddy, leaving you with nothing to do but find something else to do."
			)
			(10 ; Zipper
				(Print 110 50) ; "Larry! Put that thing away!"
				(Print 110 58 #at -1 140) ; "(Besides, it looks like he's already found a date!)"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lefty of Person
	(properties
		x 201
		y 101
		description {Lefty}
		sightAngle 40
		view 112
	)

	(method (cue)
		(super cue:)
		(Print 110 59) ; "He appears to be perverted, twisted and sick!"
		(Print 110 60 #at -1 140) ; "(You instantly take a liking to him.)"
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (== (gEgo view:) 801))
					(gEgo
						setHeading:
							(GetAngle
								(gEgo x:)
								(gEgo y:)
								(self x:)
								(self y:)
							)
							self
					)
				else
					(self cue:)
				)
			)
			(10 ; Zipper
				(Print 110 61) ; "Larry! Put that thing away! Lefty isn't interested in playing "match me for a drink" with you!"
			)
			(3 ; Do
				(self doVerb: 5)
			)
			(5 ; Talk
				(cond
					((not (== (gEgo view:) 801))
						(Print 110 62) ; "Why not sit down at the bar first?"
					)
					((or ordered (== (lefty script:) sLeftyServes))
						(Print 110 63) ; "Hold on; you haven't got your last order yet!"
					)
					(else
						(if (not saidHello)
							(= saidHello 1)
							(Print 110 64) ; "You greet the bartender with a friendly "Hullo.""
						)
						(gGame setCursor: 999 1)
						(Animate (gCast elements:) 0)
						(= ordered
							(PrintD
								{"What'll it be?" Lefty responds.}
								67
								73
								42
								103
								81
								{A Round}
								5
								81
								{Champagne}
								3
								81
								{ Wine }
								1
								103
								81
								{Light Beer}
								4
								81
								{ Beer }
								2
								81
								{ Whiskey }
								0
							)
						)
						(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
						(switch ordered
							(0
								(Print 110 65) ; ""I'll have a glass of your fine, well whiskey!" you tell Lefty."
								(lefty setScript: sLeftyServes)
							)
							(1
								(Print 110 66) ; ""May I please have a glass of your delicate white zinfandel, sir?" you ask Lefty."
								(Print 110 67) ; "Hey, was that your voice?"
								(lefty setScript: sLeftyServes)
							)
							(2
								(Print 110 68) ; ""Gimme a mug o' beer!" you order Lefty."
								(lefty setScript: sLeftyServes)
							)
							(3
								(Print 110 69 #at 73 42) ; "I ain't sellin' no sissy drinks here," says Lefty. "Try again."
								(= ordered 0)
							)
							(4
								(Print 110 70 #at 73 42) ; "You mean to say you're playing "Leisure Suit Larry," and all you want is LIGHT beer??"
								(= ordered 0)
							)
							(5
								(= ordered 0)
								(cond
									((not beenToldPrice)
										(= beenToldPrice 1)
										(Print 110 71 #at 73 42) ; "Are you sure?" asks Lefty. "It'll cost ya $90.00!"
									)
									((< gLarryDollars 90)
										(Print 110 72) ; "I really want to, Mr. Lefty," you say, "but I just don't have 90 bucks!"
									)
									(else
										(Print 110 73 #at 73 42) ; "Hey, everybody," cries Lefty, "Here comes a round from the last of the big time spenders!"
										(Print 110 74) ; "You pop $90.00 out on the bar in another unsuccessful attempt to buy friendship."
										(-= gLarryDollars 90)
									)
								)
							)
						)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(cond
							((not (== (gEgo view:) 801))
								(Print 110 75) ; "Try sitting at the bar; that usually gets Lefty's attention."
							)
							((< gLarryDollars 10)
								(Print 110 76) ; "You don't have enough money!"
							)
							(else
								(-= gLarryDollars 10)
								(switch (++ tipCount)
									(1
										(Print 110 77 #at 73 42) ; "Double down on eleven."
									)
									(2
										(Print 110 78 #at 73 42) ; "If you're short of money, you could always try gambling at the casino."
									)
									(3
										(Print 110 79 #at 73 42) ; "If you're bored hanging around my place, try hailing a cab outside."
									)
									(4
										(Print 110 80 #at 73 42) ; "Have you telephoned Sierra On-Line lately?"
									)
									(else
										(Print 110 81 #at 73 42) ; "Guys tell me I need to clean my rest room walls."
									)
								)
							)
						)
					)
					(5 ; whiskey
						(if (not (== (gEgo view:) 801))
							(Print 110 75) ; "Try sitting at the bar; that usually gets Lefty's attention."
						else
							(Print 110 82 #at 73 42) ; "No, thanks," Lefty replies. "I don't drink."
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance fan of Prop
	(properties
		x 170
		description {the fan}
		sightAngle 40
		view 110
		loop 3
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(Print 110 83) ; "It's just going around in circles..."
		(Print 110 84) ; "...like your life."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Zipper
				(Print 110 85) ; "Good idea! Sliced meat loaf, anyone?"
			)
			(2 ; Look
				(if (not (== (gEgo view:) 801))
					(gEgo
						setHeading:
							(GetAngle
								(gEgo x:)
								(gEgo y:)
								(self x:)
								(self y:)
							)
							self
					)
				else
					(self cue:)
				)
			)
			(3 ; Do
				(Print 110 86) ; "When you decided to become a swinging guy, this wasn't exactly what you had in mind."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance mooseEyes of Prop
	(properties
		x 269
		y 130
		z 86
		description {the moose's eyes}
		sightAngle 40
		view 110
		loop 2
		cel 3
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(moose doVerb: theVerb invItem)
	)
)

(instance peephole of Prop
	(properties
		x 303
		y 140
		z 32
		description {the peephole}
		sightAngle 40
		approachX 290
		approachY 151
		view 110
		loop 1
		priority 10
		signal 16400
	)

	(method (cue)
		(super cue:)
		(if cel
			(Print 110 87) ; "An eye peers back at you through the peephole in the door."
		else
			(Print 110 88) ; "The peephole is tightly shut."
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (== (gEgo view:) 801))
					(gEgo
						setHeading:
							(GetAngle
								(gEgo x:)
								(gEgo y:)
								(self x:)
								(self y:)
							)
							self
					)
				else
					(self cue:)
				)
			)
			(3 ; Do
				(Print 110 89) ; "The peephole is locked from the inside."
			)
			(else
				(door doVerb: theVerb invItem)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 306
		y 139
		description {the door}
		sightAngle 40
		approachX 290
		approachY 151
		lookStr {You wonder how many naugas had to give their all just to decorate this sleazehole.}
		view 110
		loop 4
		priority 9
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((== (gEgo view:) 801)
						(Print 110 32) ; "How can you do that from there?"
					)
					((self script:)
						(Print 110 90) ; "Patience, Larry; patience!"
					)
					(else
						(self setScript: sDoor)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; graffiti
						(if (== (sDoor state:) 2)
							(HandsOff)
							(Print 110 91) ; ""The password is: `Ken Sent Me'" you whisper through the open peephole."
							(sDoor seconds: 3 state: 3 cue:)
						else
							(Print 110 92) ; "You carefully whisper "Ken Sent Me" to the closed door. Why, you do not know."
						)
					)
					(14 ; hammer
						(Print 110 93) ; "The Naugahyde bounces the hammer back, grazing your scalp but slightly."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(if (== (sDoor state:) 2)
					(Print 110 94) ; ""Does the password have two syllables?" you ask the man on the other side of the peephole."
					(Print 110 95 #at 180 55) ; ""At least," replies the voice through the door."
					(sDoor seconds: 0 cue:)
				else
					(Print 110 96) ; "No one can hear you through the door."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance stool of Feature
	(properties
		x 206
		y 150
		z 13
		nsTop 125
		nsLeft 200
		nsBottom 149
		nsRight 212
		description {the stool}
		sightAngle 40
		approachX 208
		approachY 150
		lookStr {There is a lovely, empty, pink stool just waiting for a lovely, empty, pink rump like yours.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(kenHead setScript: sTellJoke)
				(HandsOff)
				(gCurRoom setScript: sSitDown)
			)
			(11 ; Taste/Smell
				(Print 110 97) ; "Phew!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance moose of Feature
	(properties
		x 272
		y 134
		z 86
		nsTop 24
		nsLeft 246
		nsBottom 73
		nsRight 298
		description {the moosehead}
		sightAngle 40
		lookStr {It's an antique, left over from "King's Quest III."}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if (== (gEgo view:) 801)
					(Print 110 98) ; "Geez, Larry, you MUST be drunk! Talking to a moose, indeed?!"
					(= tookADrink 4)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance painting of Feature
	(properties
		x 171
		y 110
		z 64
		nsTop 29
		nsLeft 129
		nsBottom 63
		nsRight 214
		description {the painting}
		sightAngle 40
		lookStr {You don't know much about art, but you do know what you like!}
	)
)

(instance sScratchy of Sound
	(properties)
)

