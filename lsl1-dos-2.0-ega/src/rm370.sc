;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm370 0
)

(procedure (InitRoomFeas)
	(painting init:)
	(painting2 init:)
	(lightSwitch init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
	(bed init:)
	(pillows init:)
	(flowerBox init:)
	(tree init:)
)

(instance rm370 of LLRoom
	(properties
		lookStr {The Casino Hotel's Penthouse Suite's bedroom is lavishly appointed with the latest in Bill Skirvin art.}
		picture 370
	)

	(method (init)
		(cond
			((== gDebugging 1)
				(SetFlag 6)
			)
			((== gDebugging 2)
				(SetFlag 23)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 128 79 128 14 166 306 166 306 156 283 136 276 136 256 120 232 120 243 134 126 134 126 120 110 120 110 124 80 124 80 120 0 120 0 0 319 0 319 189 0 189
					yourself:
				)
		)
		(switch gPrevRoomNum
			(360
				(if (IsFlag 6)
					(gEgo
						egoSpeed: (+ 3 global101)
						init:
						x: 102
						y: 124
						normal: 0
						view: 381
						setLoop: 5
					)
					(LoadMany rsVIEW 372 371)
					(aEve init:)
					(HandsOff)
					(gCurRoom setScript: sEveDoesLarry)
				else
					(Load rsVIEW 370)
					(LoadMany rsSOUND 370 801)
					(HandsOff)
					(gEgo init:)
					(gCurRoom setScript: sFromLivingroom)
				)
			)
			(375
				(LoadMany rsVIEW 722)
				(LoadMany rsSOUND 700 801)
				(gEgo
					init:
					normal: 0
					view: 370
					setLoop: 2
					setPri: 9
					x: 182
					y: 116
					stopUpd:
				)
				(HandsOff)
				(gCurRoom setScript: sKenSpeaks)
			)
			(else
				(Load rsVIEW 370)
				(LoadMany rsSOUND 370 372 371 801)
				(HandsOff)
				(gEgo init:)
				(gCurRoom setScript: sLeakyDoll)
			)
		)
		(fDoor init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(InitRoomFeas)
		(cond
			((and (IsFlag 23) (IsFlag 29))
				(door init: setLoop: 1 setCel: 0 stopUpd:)
			)
			((and (IsFlag 23) (not (IsFlag 29)))
				(flatDoll init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
				(door init: setLoop: 0 setCel: 3 stopUpd:)
			)
			((and (not (IsFlag 23)) (not (IsFlag 29)))
				(door cycleSpeed: (+ 3 global101) init:)
			)
		)
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((SteppedOn gEgo 2)
				(HandsOff)
				(self setScript: sToLivingroom)
			)
		)
	)
)

(instance sEveDoesLarry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aEve cycleSpeed: (+ 3 global101) setCycle: ForwardCounter 7)
				(gEgo setCycle: Walk setMotion: PolyPath 150 134 self)
			)
			(1
				(aEve stopUpd:)
				(gEgo
					egoSpeed: (+ 2 gLarrySpeed)
					setPri: 12
					posn: 166 100
					view: 371
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(aTowel init:)
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(= seconds 4)
			)
			(6
				(Points 83 25)
				(gCurRoom newRoom: 375)
			)
		)
	)
)

(instance sFromLivingroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 53 122 setMotion: PolyPath 79 125 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sToLivingroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 53 122 self)
			)
			(1
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sClosetDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== (door cel:) 0) (not (IsFlag 23)))
					(= cycles 1)
				else
					(Print 370 0) ; "The closet door is already open."
					(self dispose:)
				)
			)
			(1
				(gEgo view: 808 setLoop: 2 setCel: 0 setCycle: Beg self)
				(SetFlag 23)
			)
			(2
				(gTheMusic3 number: 801 loop: 1 flags: 1 play:)
				(door init: setLoop: 0 setCel: 0 setCycle: End self)
				(Points 66 5)
				(= cycles 1)
			)
			(3
				(if (not (IsFlag 29))
					(flatDoll init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
				)
				(= cycles 1)
			)
			(4
				(NormalEgo 0)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sLeakyDoll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 58))
					(Print 370 1) ; "Walking out of the closet, you clumsily catch your new latex friend on a protruding nail! There's a loud, flatulent sound, and suddenly..."
				)
				(gEgo z: 0 show:)
				(NormalEgo 1)
				(= cycles 1)
			)
			(1
				(sfxPop play:)
				(door setLoop: 1 setCel: 0)
				(= cycles 1)
			)
			(2
				(gTheMusic3 number: 372 loop: -1 flags: 1 play:)
				(aDoll
					cycleSpeed: (+ 1 global101)
					moveSpeed: (+ 1 global101)
					init:
					setCycle: Fwd
					setMotion: MoveTo 33 85
				)
				(gEgo egoSpeed: setMotion: PolyPath 56 119 self)
			)
			(3
				(SetFlag 4)
				(SetFlag 29)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sInflate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 808 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(door setLoop: 1 setCel: 0 stopUpd:)
				(gEgo view: 808 setLoop: 0 setCycle: Beg self)
			)
			(2
				(Print 370 2) ; "You huff, and you puff, and you blow your doll up."
				(sfxInflate flags: 1 play:)
				(NormalEgo)
				(= seconds 3)
			)
			(3
				(Print 370 3) ; "Holding her out at arm's length, you pause to admire your handiwork..."
				(Points 81 5)
				(gCurRoom newRoom: 371)
			)
		)
	)
)

(instance sKenSpeaks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Print 370 4) ; "Congratulations, Larry!!! You've done it!! You've successfully completed your evening in Lost Wages, lost your virginity, and emerged victorious!"
				(Print 370 5) ; "Of course, your feelings of success are short-lived, since this is where Ken Williams has to tell you about all the wonderful sequels to this game that you now are required to play."
				(Print 370 6) ; "Hey, Ken! Come on out here, and give 'em your pitch..."
				(gTheMusic fade: 0 12 20 1 self)
				(= seconds 8)
			)
			(2
				(= seconds 0)
				(if (not (IsFlag 23))
					(door setCycle: End self)
					(gTheMusic3 number: 801 loop: 1 flags: 1 play:)
				else
					(self cue:)
				)
			)
			(3
				(gTheMusic2 number: 700 vol: 127 loop: -1 flags: 1 play:)
				(aKen
					init:
					cycleSpeed: (+ 4 global101)
					moveSpeed: (+ 4 global101)
					setLoop: 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 178 137 self
				)
			)
			(4
				(Print 370 7 #at -1 20) ; "Ladies and gentlemen... Mr. Ken Williams!"
				(aKen setLoop: 2 setCycle: End self)
			)
			(5
				(kenHead
					cycleSpeed: (* 2 global101)
					init:
					setLoop: 3
					setCycle: ForwardCounter 2 self
				)
			)
			(6
				(Print 370 8 #at -1 20) ; "Hi, folks! As C.E.O. of a Major Software Publisher you might think I'm above pitching products for Al Lowe."
				(kenHead setCycle: ForwardCounter 4 self)
			)
			(7
				(Print 370 9 #at -1 19 #width 280) ; "Boy, would you be wrong! I don't want to be pushy, but in my humble opinion, I think you owe it to yourself to run out to your local 24-hour software store right now and grab yourself a copy of EVERY chapter in the (now seemingly never-ending) saga of Larry; Larry Laffer, Al Lowe's lovable lounge lizard!"
				(kenHead setCycle: ForwardCounter 4 self)
			)
			(8
				(Print 370 10 #at -1 19 #width 280) ; "You would really enjoy `Leisure Suit Larry 2: Looking for Love (In Several Wrong Places)' in which you help Larry abandon his lizard-like ways and find true love on a breathtakingly-beautiful, tropical paradise called `Nontoonyt Island,' in spite of the efforts of the K.G.B. and the evil Dr. Nonookee!"
				(kenHead setCycle: ForwardCounter 4 self)
			)
			(9
				(Print 370 11 #at -1 19 #width 280) ; "Or, you may prefer `Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals' in which you play part of the game as Larry, but also play as Passionate Patti, a woman that is everything Larry is not. (And has everything Larry does not, too!)"
				(kenHead setCycle: ForwardCounter 4 self)
			)
			(10
				(Print 370 12 #at -1 19 #width 280) ; "But, I really hope you select my personal favorite, `Leisure Suit Larry 5: Passionate Patti Does a Little Undercover Work' in which Patti truly comes into her own, helping the F.B.I. clean up the entertainment industry, while Larry must find the sexiest woman in America for his employer, that hot new syndicated television program, `America's Sexiest Home Videos!'"
				(kenHead setCycle: ForwardCounter 4 self)
			)
			(11
				(Print 370 13 #at -1 20) ; "You may wonder why I didn't mention `Leisure Suit Larry 4: The Missing Floppies!'"
				(kenHead setCycle: ForwardCounter 4 self)
			)
			(12
				(Print 370 14 #at -1 20) ; "Me, too. The problem is: we don't know where it is! You know me; if we COULD find it, I'd sell it!"
				(kenHead setCycle: ForwardCounter 2 self)
			)
			(13
				(Print 370 15 #at -1 19 #width 280) ; "So, if you enjoyed this game (and you must have, since you got this far!), give Sierra's Order Desk a call at 800 326-6654 (international customers call 209 683-4468). We'll be happy to sell you any of the Leisure Suit Larry series, or even some of our good games!"
				(kenHead setCycle: ForwardCounter 2 self)
			)
			(14
				(Print 370 16 #at -1 20) ; "Well, enough about me, now let's hear about you..."
				(aKen setLoop: 2 setCycle: CT 2 -1 self)
			)
			(15
				(aKen
					setLoop: 1
					setCel: 3
					setCycle: Walk
					setMotion: PolyPath 52 121 self
				)
			)
			(16
				(Print 370 17 #at -1 20) ; "Oh, wait. I almost forgot to tell you how well you played."
				(aKen setLoop: 0 setCycle: Walk setMotion: PolyPath 80 128 self)
			)
			(17
				(aKen setLoop: 2 setCel: 0)
				(= seconds 3)
			)
			(18
				(aKen setLoop: 2 setCel: 0 setCycle: End self)
			)
			(19
				(kenHead setLoop: 3 setCycle: ForwardCounter 2 self)
			)
			(20
				(Print 370 18 #at -1 20) ; "You played ok, I guess!"
				(kenHead setLoop: 3 setCycle: ForwardCounter 4 self)
			)
			(21
				(Print 370 19 #at -1 20) ; "On behalf of Al and Marg, Ken and Roberta, Oliver and Lisa, Mike and Laura, Bill and Patti, Bob and Jeannine and Ted and Alice..."
				(Print 370 20 #at -1 20) ; "...thanks for playing, and be sure to tell each and every one of your friends to buy their own personal copy of this game."
				(kenHead dispose:)
				(aKen setLoop: 2 setCycle: CT 2 -1 self)
			)
			(22
				(aKen
					setLoop: 1
					setCel: 3
					setCycle: Walk
					setMotion: PolyPath 52 121 self
				)
			)
			(23
				(aKen dispose:)
				(Print 370 21 #at -1 20) ; "Love ya, baby!"
				(SetFlag 46)
				(gCurRoom newRoom: 375)
			)
		)
	)
)

(instance sfxInflate of Sound
	(properties
		flags 1
		number 370
	)
)

(instance sfxPop of Sound
	(properties
		flags 1
		number 371
	)
)

(instance aKen of Actor
	(properties
		x 338
		y 152
		view 722
		signal 16384
	)
)

(instance aEve of Prop
	(properties
		x 198
		y 108
		view 372
		priority 10
		signal 16
	)
)

(instance aDoll of Actor
	(properties
		x 271
		y 98
		yStep 5
		view 373
		xStep 7
	)
)

(instance kenHead of Prop
	(properties
		x 139
		y 143
		view 722
		loop 4
		priority 14
		signal 16400
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== (aKen loop:) 2) (== (aKen cel:) 4))
				(kenHead x: (- (aKen x:) 2) y: (aKen y:) z: 27 species)
			)
			((== (kenHead z:) 27)
				(kenHead z: 1000 species)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 311
		y 150
		description {the closet}
		sightAngle 40
		view 370
		priority 4
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(fDoor doVerb: theVerb invItem)
	)
)

(instance flatDoll of Feature
	(properties
		x 306
		y 155
		z 5
		nsTop 92
		nsLeft 299
		nsBottom 132
		nsRight 313
		description {the inflatable doll}
		sightAngle 40
		approachX 287
		approachY 140
		lookStr {It appears to be an inflatable doll.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 370 22) ; "This is the flattest babe you've ever felt, Larry!"
			)
			(5 ; Talk
				(Print 370 23) ; "There's only one thing she can do with her mouth, Larry."
			)
			(10 ; Zipper
				(Print 370 24) ; "You may want to inflate her first, Larry."
			)
			(11 ; Taste/Smell
				(gCurRoom setScript: sInflate)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fDoor of Feature
	(properties
		x 304
		y 144
		z 15
		nsTop 86
		nsLeft 290
		nsBottom 143
		nsRight 319
		description {the closet}
		sightAngle 40
		approachX 287
		approachY 140
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (door loop:)
					(Print 370 25) ; "The rest of the closet is rather dull compared to the inflatable doll."
				else
					(gCurRoom setScript: sClosetDoor)
				)
			)
			(2 ; Look
				(cond
					((and (door cel:) (not (IsFlag 29)))
						(Print 370 26) ; "You've found a closet full of uninteresting stuff, plus one inflatable doll."
					)
					((and (IsFlag 29) (door cel:))
						(Print 370 25) ; "The rest of the closet is rather dull compared to the inflatable doll."
					)
					((and (IsFlag 29) (IsFlag 23))
						(Print 370 27) ; "Peering into the empty closet brings back sad but dear memories of your latex friend."
					)
					(else
						(Print 370 28) ; ""What's behind that door?" you wonder to yourself."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance painting of Feature
	(properties
		x 28
		y 149
		z 56
		nsTop 68
		nsLeft 3
		nsBottom 118
		nsRight 54
		description {the painting}
		sightAngle 40
		lookStr {Oh, look! A portrait of Jesse Helms!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance painting2 of Feature
	(properties
		x 163
		y 116
		z 55
		nsTop 46
		nsLeft 152
		nsBottom 77
		nsRight 175
		description {the painting}
		sightAngle 40
		lookStr {Oh, that's disgusting. Be glad you don't have a higher-resolution screen!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lightSwitch of Feature
	(properties
		x 277
		y 129
		z 29
		nsTop 96
		nsLeft 274
		nsBottom 105
		nsRight 281
		description {the electrical switch}
		sightAngle 40
		approachX 264
		approachY 127
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 370 29) ; "This switch connects the two legs of a circuit causing current to swiftly flow to the lamp socket on the ceiling of the closet."
				(Print 370 30 #at -1 140) ; "(Of course, nothing happens since the bulb is burned out, but you get the idea!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bed of Feature
	(properties
		x 179
		y 115
		nsTop 99
		nsLeft 136
		nsBottom 131
		nsRight 223
		description {the bed}
		sightAngle 40
		lookStr {Play your cards right and you might get to try this baby out tonight!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 370 31) ; "It feels soft enough for you."
			)
			(10 ; Zipper
				(Print 370 32) ; "You might get to do that later, Larry."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pillows of Feature
	(properties
		x 182
		y 91
		nsTop 84
		nsLeft 146
		nsBottom 98
		nsRight 218
		description {the pillows}
		sightAngle 40
		lookStr {They look soft and fluffy -- just like their owner!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 370 33) ; "They feel soft and fluffy."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance flowerBox of Feature
	(properties
		x 159
		y 169
		nsTop 150
		nsBottom 189
		nsRight 319
		description {the flower box}
		sightAngle 40
		lookStr {What an unusual plant! But how can it grow near all those lights?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 370 34) ; "Ouch! Are all the plants sharp?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 119
		y 61
		nsTop -1
		nsLeft 86
		nsBottom 123
		nsRight 153
		description {the ficus tree}
		sightAngle 40
		lookStr {This tree is the only normal-looking plant around. That's because it's artificial!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 370 35) ; "What did you think? You maybe expected to climb this tree?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aTowel of View
	(properties
		x 153
		y 134
		view 371
		loop 3
		priority 9
		signal 16400
	)
)

