;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Interface)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	seenMsg
	cycleTime
)

(instance rm700 of LLRoom
	(properties
		picture 700
		north 710
		east 760
		south 780
	)

	(method (init)
		(LoadMany rsSOUND 710 622 255 194 191 192)
		(gEgo init: normalize: 553)
		(switch gPrevRoomNum
			(750
				(HandsOn)
				(gEgo posn: 117 164 setHeading: 180 edgeHit: 0)
				(SetFlag 49)
			)
			(north
				(HandsOn)
				(gEgo posn: 117 164 setHeading: 180 edgeHit: 0)
				(gTheMusic fade: 80 10 10 0)
			)
			(south
				(self setScript: sFromSouth)
			)
			(east
				(gEgo y: 155)
			)
			(200
				(HandsOff)
				(self setScript: sFromLimo)
			)
			(else
				(self setScript: sFromLimo)
			)
		)
		(super init:)
		(doorman init: approachVerbs: 5 stopUpd:) ; Talk
		(if (!= gPrevRoomNum 750)
			(changeGirl init: approachVerbs: 5 stopUpd:) ; Talk
		)
		(trampSign init:)
		(leftLight init:)
		(rightLight init:)
		(slotSign init:)
		(bird init:)
		(leftNip init:)
		(rightNip init:)
		(centerNip init:)
		(leftRoller init: setCycle: Fwd setScript: sRoll)
		(middleRoller init: setCel: (Random 1 2) setCycle: Fwd)
		(rightRoller init: setCel: 3 setCycle: Fwd)
		(leftNeon init:)
		(rightNeon init:)
		(centerNeon init:)
		(dollars init:)
		(door init: approachVerbs: 3) ; Do
		(ass1 init:)
		(ass2 init:)
		(ass3 init:)
		(breasts1 init:)
		(breasts2 init:)
		(breasts3 init:)
		(girl1 init:)
		(girl2 init:)
		(girl3 init:)
		(burgerStand init:)
		(boardwalk init:)
		(beach init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 221 176 231 172 319 172 319 189 298 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 98 163 84 163 84 161 3 161 3 169 173 169 197 176 216 189 0 189 0 0 319 0 319 151 253 151 253 156 228 161 152 161 148 163 135 163 121 156 121 140 115 140 115 155
					yourself:
				)
		)
		(cond
			((== gPrevRoomNum (gCurRoom north:))
				(gTheMusic fade: 80 10 10 0)
			)
			((!= gPrevRoomNum 200)
				(gTheMusic number: 710 setLoop: -1 flags: 1 play: 80)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 0) ; "Tramp's Casino is a perfect example of the style of architecture exemplified by Frank Lloyd Wrong."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (IsFlag 0) (> (Abs (- gGameTime cycleTime)) 6))
			(= cycleTime gGameTime)
			(Palette palANIMATE 33 48 -1)
			(Palette palANIMATE 227 231 -1)
		)
		(cond
			(script)
			((> (gEgo y:) 185)
				(HandsOff)
				(self setScript: sOcean)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 710)
			(gTheMusic fade: 127 10 10 0)
		else
			(gTheMusic fade:)
		)
		(return
			(if (== script sOcean)
				0
			else
				(super newRoom: newRoomNumber)
			)
		)
	)
)

(instance sRoll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(leftRoller x: 96 y: 48 setLoop: 7)
				(middleRoller dispose:)
				(rightRoller dispose:)
				(= seconds 5)
			)
			(2
				(leftRoller x: 99 y: 51 setLoop: 14)
				(middleRoller init:)
				(rightRoller init:)
				(self init:)
			)
		)
	)
)

(instance sFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 320 220 setMotion: PolyPath 220 180 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sOcean of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 320 220 self)
			)
			(1
				(gCurRoom newRoom: 780)
			)
		)
	)
)

(instance sFromLimo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(limo init:)
				(gEgo hide:)
				(= ticks 150)
			)
			(1
				(soundFX number: 191 play: self)
				(= ticks 50)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo
					normalize: 553
					x: 107
					y: 177
					setLoop: 3
					show:
					setCel: 0
					setMotion: MoveTo 107 166 self
				)
			)
			(4
				(gEgo setLoop: -1 setHeading: 180 self)
			)
			(5
				(= ticks 60)
			)
			(6
				(soundFX number: 192 play: self)
				(= ticks 100)
			)
			(7
				(gTheMusic number: 710 setLoop: -1 flags: 1 play: 80)
				(soundFX number: 194 play: self)
			)
			(8
				(soundFX client: 0)
				(limo setStep: 1 1 setMotion: MoveTo 87 (limo y:) self)
			)
			(9
				(limo setStep: 3 3 setMotion: MoveTo 65 (limo y:) self)
			)
			(10
				(limo setStep: 4 4 setMotion: MoveTo 50 (limo y:) self)
			)
			(11
				(limo setStep: 5 5 setMotion: MoveTo 35 (limo y:) self)
			)
			(12
				(limo setStep: 6 6 setMotion: MoveTo -95 (limo y:) self)
			)
			(13
				(limo dispose:)
				(gEgo normalize: 553)
				(gTheIconBar enable:)
				(HandsOn)
				(= cycles 1)
			)
			(14
				(soundFX dispose:)
				(if
					(Print ; "Now would be an excellent time for you to save your game, Larry."
						700
						1
						#button
						{Save}
						1
						#button
						{Nah, Why Bother?}
						0
						#title
						{AL says}
						#at
						-1
						28
					)
					(gGame save:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sLimo of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (soundFX prevSignal:) 10) (== (soundFX number:) 194))
			(soundFX prevSignal: 5)
			(self cue:)
		)
	)

	(method (changeState newState &tmp [str 268])
		(switch (= state newState)
			(0
				(gEgo setHeading: 270)
				(doorman setLoop: 0 setCel: 0 setCycle: Osc 1 self)
			)
			(1
				(doorman setLoop: 1 setCel: 0)
				(soundFX number: 255 play: hold: 10)
				(limo
					posn: -100 178
					init:
					approachVerbs: 3 ; Do
					setMotion: MoveTo 70 178 self
				)
			)
			(2
				(soundFX hold: -1)
				(gEgo setHeading: 90 self)
			)
			(3
				(switch gSilvDollars
					(0
						(TPrint 700 2) ; ""It's certainly too bad that I have no silver dollars to tip you," you quip to the unamused fellow."
						(doorman setLoop: 1 setCel: 0 setCycle: End self)
					)
					(1
						(TPrint 700 3) ; "All I have is one silver dollar," you tell the doorman. "Normally, I'm quite the generous tipper!"
						(doorman setLoop: 2 setCel: 0 setCycle: Osc 1 self)
					)
					(else
						(Format @str 700 4 gSilvDollars gSilvDollars) ; "Totally out of character for your cheap self, you decide to give the doorman a generous tip. "Here you are, my good fellow," you quip, "take these %d silver dollars. I'll have no use for them where I'm going!""
						(TPrint @str)
						(doorman setLoop: 2 setCel: 0 setCycle: Osc 1 self)
					)
				)
			)
			(4
				(switch gSilvDollars
					(0
						(Say Doorman 700 5 108 139 self) ; "Yeah, that's what Mr. Lowe says, too."
					)
					(1
						(Say Doorman 700 6 108 139 self) ; "Right."
					)
					(else
						(Say Doorman 700 7 108 139 self) ; "WOW! Come back again, Sir, and soon!"
					)
				)
				(gEgo put: 17 0) ; Silver_Dollar
				(= gSilvDollars 0)
			)
			(5
				(gEgo
					setMotion: PolyPath (limo approachX:) (limo approachY:) self
				)
			)
			(6
				(gEgo setHeading: 180 self)
			)
			(7
				(= ticks 60)
			)
			(8
				(soundFX number: 191 play:)
				(= ticks 50)
			)
			(9
				(gEgo
					setLoop: 2
					setCycle: 0
					setPri: (gEgo priority:)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 6) self
				)
			)
			(10
				(gEgo x: 1000)
				(= ticks 60)
			)
			(11
				(soundFX number: 192 play:)
				(= ticks 50)
			)
			(12
				(= ticks 60)
			)
			(13
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sGirlTalk of Script
	(properties)

	(method (changeState newState &tmp guess num [str 60] saveX saveY)
		(switch (= state newState)
			(0
				(= guess 0)
				(if (not (HaveMouse))
					(= saveX gMouseX)
					(= saveY (- gMouseY 10))
					(gGame setCursor: gTheCursor 1 500 500)
				)
				(while (not (< 0 guess 10000))
					(= str 0)
					(proc0_26)
					(GetInput
						@str
						6
						{"Please enter a number less than 10000, ok?"}
						80
						{Cheri}
					)
					(proc0_27)
					(= guess (ReadNumber @str))
				)
				(if (not (HaveMouse))
					(gGame setCursor: gTheCursor 1 saveX saveY)
				)
				(if (not (gEgo has: 17)) ; Silver_Dollar
					(Say Cheri 700 8 108 139 self) ; "Amazing! What a genius! What a coincidence! Congratulations, Sir! You have correctly guessed the number of which I have been thinking of. Here's your ten `Tramp Casino' lucky souvenir silver dollars."
				else
					(for
						((= num guess))
						(== guess num)
						((= num (Random 1 6900)))
					)
					(Format @str 700 9 num num) ; "Aw, too bad! I was thinking of %d."
					(Say Cheri @str 108 139 self)
				)
			)
			(1
				(if (gEgo has: 17) ; Silver_Dollar
					(Say Cheri 700 10 108 139 self) ; "But feel free to try again any time!"
				else
					(Say Cheri 700 11 108) ; "Please don't confuse them with REAL money!"
					(changeGirl setLoop: 1 setCel: 0 setCycle: Osc 1 self)
					(gEgo get: 17) ; Silver_Dollar
					(= gSilvDollars 10)
				)
			)
			(2
				(changeGirl setLoop: 0)
				(self dispose:)
			)
		)
	)
)

(instance bird of Actor
	(properties
		description {the seagull}
		yStep 5
		view 700
		loop 8
		priority 14
		signal 26640
		illegalBits 0
		xStep 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 12) ; "A lonely seagull flies back and forth, searching for a likely target--you!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd cue:)
	)

	(method (cue &tmp theX theY)
		(= theX (- (Random 0 520) 100))
		(= theY (- (Random 0 150) 50))
		(self setMotion: MoveTo theX theY self)
	)
)

(instance limo of Actor
	(properties
		x 93
		y 180
		description {the limousine}
		approachX 80
		approachY 175
		view 700
		signal 18432
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 13) ; "Your limousine has returned. Or, perhaps, one suspiciously like it!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 118
		y 155
		description {the front door of Tramp's Casino}
		sightAngle 40
		approachX 120
		approachY 157
		view 251
		cycleSpeed 10
		entranceTo 710
		openSnd 622
		closeSnd 622
		moveToX 118
		moveToY 154
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 14) ; "A small bronze plaque over the door reads, "Through these doors pass the greatest people in the world--OUR SUCKERS!""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance doorman of Prop
	(properties
		x 141
		y 162
		description {Brewster}
		sightAngle 40
		approachX 133
		approachY 165
		view 703
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 15) ; "Tramp's Casino thoughtfully provides a doorman to satisfy your every travel need--as long as all you need is for him to summon you a limousine!"
			)
			(3 ; Do
				(self doVerb: 5)
			)
			(5 ; Talk
				(Say Doorman 700 16 108 139 self) ; "May I summon a limousine for you, Sir?"
			)
			(10 ; Zipper
				(Say Doorman 700 17 108) ; "Well, you're a little ugly, but I suppose.... Oh, okay. I get off at midnight!"
			)
			(4 ; Inventory
				(Say Doorman 700 18 108) ; "Thanks for the offer, but we employees of Tramp's NEVER accept gratuities!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(if
			(Print ; "So? Ya wanna limo or not?"
				700
				19
				#button
				{No, thank you}
				0
				#button
				{Yes, please}
				1
				#title
				{Your Friendly Doorman}
			)
			(HandsOff)
			(Say gEgo 700 20) ; "Yes, please... but could you make it back in?"
			(Points 2 132)
			(Say Doorman 700 21 108) ; "No problem," says Brewster. "Just watch this!"
			(gCurRoom setScript: sLimo)
		else
			(Say gEgo 700 22) ; "No, thank you. But I may well come back this way later."
		)
	)
)

(instance changeGirl of Prop
	(properties
		x 96
		y 162
		description {the casino greeter}
		sightAngle 40
		approachX 103
		approachY 164
		view 702
		signal 16384
	)

	(method (init)
		(super init:)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 23) ; "Tramp's Casino employs a beautiful young woman to greet all its distinguished visitors."
			)
			(3 ; Do
				(Say Cheri 700 24 108) ; "Welcome to Tramp's Casino, young man! I'm here to welcome you because I'm the welcomer, so `Welcome!'"
			)
			(5 ; Talk
				(if (not seenMsg)
					(Say Cheri 700 25 108) ; "Hey fella! Wanna get lucky? Guess the number of which I'm thinking of. You might just win 10 `silver dollars!'"
					(= seenMsg 1)
					(self approachVerbs: 5) ; Talk
				else
					(Points 2 131)
					(self setScript: sGirlTalk)
				)
			)
			(10 ; Zipper
				(Say Cheri 700 26 108) ; "Hey! I may be standing here on this street corner, but I'm not that kind of working girl! Ya want I havta call my boyfriend the bouncer?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance trampSign of Prop
	(properties
		x 120
		y 100
		description {the Tramp sign}
		view 700
		loop 1
		signal 16384
		cycleSpeed 3
		detailLevel 1
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 27) ; "It says you're in front of Tramp's Casino."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance slotSign of Prop
	(properties
		x 74
		y 38
		description {the slot machine sign}
		view 700
		loop 4
		signal 16384
		cycleSpeed 5
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 28) ; "You presume there must be some form of mechanized gambling within."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftLight of Prop
	(properties
		x 67
		y 123
		description {the light}
		view 700
		loop 2
		signal 16384
		cycleSpeed 2
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 29) ; "Ain't neon grand!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rightLight of Prop
	(properties
		x 173
		y 124
		description {the light}
		view 700
		loop 3
		cel 1
		signal 16384
		cycleSpeed 4
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 29) ; "Ain't neon grand!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftNip of Prop
	(properties
		x 43
		y 41
		description {the neon nipples}
		view 700
		loop 6
		signal 16384
		cycleSpeed 1
		detailLevel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (Random 0 1)
					(TPrint 700 30) ; "You really enjoy this part of the game!"
				else
					(TPrint 700 31) ; "You haven't seen neon pasties since the late '60's!"
				)
			)
			(3 ; Do
				(if (Random 0 1)
					(TPrint 700 32) ; "You are desperate for entertainment!"
				else
					(TPrint 700 33) ; "Cheap feel!"
				)
			)
			(5 ; Talk
				(TPrint 700 34) ; "Keep your mouth off those!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rightNip of Prop
	(properties
		x 220
		y 68
		description {the neon nipples}
		view 700
		loop 5
		cel 1
		signal 16384
		cycleSpeed 1
		detailLevel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(leftNip doVerb: theVerb invItem &rest)
	)
)

(instance centerNip of Prop
	(properties
		x 159
		y 27
		description {the neon nipples}
		view 700
		loop 12
		cel 2
		signal 16384
		cycleSpeed 1
		detailLevel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(leftNip doVerb: theVerb invItem &rest)
	)
)

(instance leftRoller of Prop
	(properties
		x 99
		y 51
		description {the slot machine sign}
		view 700
		loop 14
		signal 16384
		cycleSpeed 7
		detailLevel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (Random 0 1)
					(TPrint 700 35) ; "That slot machine NEVER stops on a winner!"
				else
					(TPrint 700 36) ; "That slot machine NEVER stops on a loser!"
				)
			)
			(3 ; Do
				(TPrint 700 37) ; "If it's handles you want to pull, why not go inside?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance middleRoller of Prop
	(properties
		x 110
		y 51
		description {the slot machine sign}
		view 700
		loop 14
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(leftRoller doVerb: theVerb invItem)
	)
)

(instance rightRoller of Prop
	(properties
		x 122
		y 51
		description {the slot machine sign}
		view 700
		loop 14
		cel 3
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(leftRoller doVerb: theVerb invItem)
	)
)

(instance leftNeon of Prop
	(properties
		x 52
		z -56
		description {the neon sign}
		view 700
		loop 9
		signal 16384
		cycleSpeed 5
		detailLevel 5
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 38) ; "How you love gaudy things!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rightNeon of Prop
	(properties
		x 195
		z -70
		description {the neon sign}
		view 700
		loop 10
		signal 16384
		cycleSpeed 4
		detailLevel 5
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 38) ; "How you love gaudy things!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance centerNeon of Prop
	(properties
		x 125
		y 38
		description {the neon sign}
		view 700
		loop 11
		signal 16384
		cycleSpeed 3
		detailLevel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 38) ; "How you love gaudy things!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dollars of Prop
	(properties
		x 121
		y 115
		description {the dollar sign}
		view 700
		loop 13
		signal 16384
		cycleSpeed 9
		detailLevel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 39) ; "The implication here is that a fella could win some money inside this place!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance burgerStand of Feature
	(properties
		x 280
		y 130
		nsTop 111
		nsLeft 241
		nsBottom 149
		nsRight 319
		description {the burger stand}
		sightAngle 40
	)

	(method (init)
		(super init:)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 40) ; "How exciting! There's a restaurant along the Tramp Boardwalk that serves dead cow!"
			)
			(3 ; Do
				(TPrint 700 41) ; "You wouldn't eat there, even if there was a door!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance boardwalk of Feature
	(properties
		x 280
		y 161
		nsTop 150
		nsLeft 241
		nsBottom 173
		nsRight 319
		description {the boardwalk}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 42) ; "The boardwalk leads off to the east, stretching nearly as far as the eye can see."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance beach of Feature
	(properties
		x 183
		y 109
		nsTop 176
		nsLeft 234
		nsBottom 190
		nsRight 320
		description {the beach}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 43) ; "That little strip of sand leads to a precipitous drop, then straight into the Atlantic! Care for a swim?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance breasts1 of Feature
	(properties
		x 42
		y 55
		nsTop 33
		nsLeft 31
		nsBottom 42
		nsRight 53
		description {the lights}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(leftNip doVerb: theVerb invItem)
	)
)

(instance breasts2 of Feature
	(properties
		x 156
		y 20
		nsTop 11
		nsLeft 148
		nsBottom 29
		nsRight 165
		description {the lights}
		sightAngle 40
	)

	(method (doVerb)
		(leftNip doVerb: &rest)
	)
)

(instance breasts3 of Feature
	(properties
		x 214
		y 74
		nsTop 60
		nsLeft 205
		nsBottom 72
		nsRight 224
		description {the rear}
		sightAngle 40
	)

	(method (doVerb)
		(leftNip doVerb: &rest)
	)
)

(instance ass1 of Feature
	(properties
		x 33
		y 62
		nsTop 55
		nsLeft 26
		nsBottom 70
		nsRight 43
		description {the rear}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 44) ; "Tight butts drive you nuts!"
			)
			(3 ; Do
				(TPrint 700 45) ; "It's only a sign, you know!"
			)
			(5 ; Talk
				(TPrint 700 46) ; ""Have you ever heard of `yodeling up the canyon?'" you ask the sign."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ass2 of Feature
	(properties
		x 120
		y 15
		nsLeft 108
		nsBottom 16
		nsRight 133
		sightAngle 40
	)

	(method (doVerb)
		(ass1 doVerb: &rest)
	)
)

(instance ass3 of Feature
	(properties
		x 213
		y 87
		nsTop 80
		nsLeft 204
		nsBottom 95
		nsRight 223
		description {the rear}
		sightAngle 40
	)

	(method (doVerb)
		(ass1 doVerb: &rest)
	)
)

(instance girl1 of Feature
	(properties
		x 34
		y 54
		nsTop 20
		nsLeft 8
		nsBottom 88
		nsRight 61
		description {the girl on the sign}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 47) ; "Sure she's only made of plywood, but doesn't she have a great set of lights?"
			)
			(3 ; Do
				(TPrint 700 48) ; "Touch all you want. She's only a sign!"
			)
			(5 ; Talk
				(TPrint 700 49) ; ""I'm so horny, I'd talk to a sign," you say to yourself."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance girl2 of Feature
	(properties
		x 138
		y 14
		nsLeft 92
		nsBottom 28
		nsRight 185
		description {the girl}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 50) ; "She's in one of your favorite positions... for a sign!"
			)
			(3 ; Do
				(TPrint 700 51) ; ""I'd love to click my cursor on you, Baby," you think."
			)
			(5 ; Talk
				(TPrint 700 52) ; ""Wanna get together somewhere after the game?" you ask the sign."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance girl3 of Feature
	(properties
		x 206
		y 72
		nsTop 39
		nsLeft 180
		nsBottom 105
		nsRight 232
		description {the girl}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 700 53) ; "And you were so afraid you were wasting your money buying this game!"
			)
			(3 ; Do
				(TPrint 700 54) ; ""I'll bet she really likes this," you think."
			)
			(5 ; Talk
				(TPrint 700 55) ; "I'm available tonight," you tell the sign. "At least, I think I am!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Cheri of Talker
	(properties
		nsTop 15
		nsLeft 12
		view 1702
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust girlBust)
		(= eyes girlEyes)
		(= mouth girlMouth)
		(super init: &rest)
	)
)

(instance girlEyes of Prop
	(properties
		nsTop 8
		nsLeft 8
		view 1702
		loop 2
		cycleSpeed 30
	)
)

(instance girlBust of Prop
	(properties
		view 1702
		loop 1
	)
)

(instance girlMouth of Prop
	(properties
		nsTop 33
		nsLeft 30
		view 1702
		cycleSpeed 8
	)
)

(instance Doorman of Talker
	(properties
		nsTop 15
		nsLeft 50
		view 1703
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust manBust)
		(= eyes manEyes)
		(= mouth manMouth)
		(super init: &rest)
	)
)

(instance manBust of Prop
	(properties
		view 1703
		loop 1
	)
)

(instance manEyes of Prop
	(properties
		nsTop 8
		nsLeft 8
		view 1703
		loop 2
		cycleSpeed 30
	)
)

(instance manMouth of Prop
	(properties
		nsTop 31
		nsLeft 11
		view 1703
		cycleSpeed 8
	)
)

(instance soundFX of Sound
	(properties
		flags 1
	)
)

