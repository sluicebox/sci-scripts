;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 258)
(include sci.sh)
(use Main)
(use eRS)
(use Language)
(use Feature)
(use Motion)
(use Inventory)
(use User)
(use Actor)

(public
	rm258 0
)

(local
	cueCounter
	wrongNumber
	weCheated
	warnCounter
	[cpCode 4]
	[cpTime 4]
	[dest 4]
	theBar
	[departTime 20]
	[cityToState 8] = [9 0 3 9 2 1 9 9]
	[NYcopyProtCode 16] = [900 16053 1010 12415 1120 -31513 1240 -29008 130 -1897 220 14065 340 -5944 440 -9748]
	[ACcopyProtCode 16] = [920 -21641 1030 -7348 1150 23802 1200 -3371 100 -15834 210 -2231 310 26084 410 -22485]
	[McopyProtCode 16] = [950 18734 1050 -9228 1140 -25374 1230 -28538 120 -27849 240 31525 330 -2964 430 29519]
	[LAcopyProtCode 16] = [930 -7324 1040 -18826 1110 12320 1250 -24920 140 -7872 230 -27867 320 -25448 400 -20441]
)

(procedure (FormatTime which theCity &tmp i theTime [str 30])
	(= i (* (Random 0 7) 2))
	(switch theCity
		(1
			(= [cpTime which] [LAcopyProtCode i])
			(= [cpCode which] [LAcopyProtCode (+ i 1)])
		)
		(2
			(= [cpTime which] [McopyProtCode i])
			(= [cpCode which] [McopyProtCode (+ i 1)])
		)
		(4
			(= [cpTime which] [ACcopyProtCode i])
			(= [cpCode which] [ACcopyProtCode (+ i 1)])
		)
		(5
			(= [cpTime which] [NYcopyProtCode i])
			(= [cpCode which] [NYcopyProtCode (+ i 1)])
		)
	)
	(if (or (< [cpTime which] 900) (>= [cpTime which] 1200))
		(StrCpy @str {PM})
	else
		(StrCpy @str {AM})
	)
	(Format ; "%2d:%02d %s"
		@departTime
		258
		7
		(/ [cpTime which] 100)
		(mod [cpTime which] 100)
		@str
		(+
			(/ [cpTime which] 100)
			(LangSwitch 0 (if (< [cpTime which] 900) 12 else 0))
		)
		(mod [cpTime which] 100)
	)
)

(instance rm258 of LLRoom
	(properties
		picture 258
	)

	(method (init)
		(super init:)
		(cond
			((IsFlag 46)
				(card y: 97)
				(boardPass init:)
				(SetupExit 1)
				(HandsOn)
			)
			((and (IsFlag 8) (not (gEgo has: 8))) ; Boarding_Pass
				(SetupExit 1)
				(slot init:)
				(dispenser init:)
				(if (not (gEgo has: 7)) ; AeroDork_Gold_Card
					(slot doVerb: 4 7)
				)
			)
			(else
				(HandsOff)
				(Display
					{Out of boarding passes at this time. Please try again in another city!}
					dsCOORD
					144
					75
					dsCOLOR
					gColWhite
					dsWIDTH
					110
					dsFONT
					gSmallFont
				)
				(if (not (gEgo has: 7)) ; AeroDork_Gold_Card
					(gEgo get: 7) ; AeroDork_Gold_Card
				)
				(Delay 15 2 gCurRoom)
			)
		)
	)

	(method (notify theNumber &tmp [temp0 4])
		(switch theNumber
			(-1
				(card init:)
			)
			(-2
				(= weCheated 1)
				(boardPass init:)
			)
			([cpCode theBar]
				(boardPass init:)
			)
			(else
				(= wrongNumber 1)
				(gCurRoom drawPic: (gCurRoom picture:))
				(Display 258 0 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "You have entered an incorrect destination for this airport at this hour. But we still appreciate your selection of AeroDork Airlines."
			)
		)
	)

	(method (handleEvent event)
		(if wrongNumber
			(= wrongNumber 0)
			(event claimed: 1)
			(card init:)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 258 1) ; "You are standing before one of AeroDork Airline's amazing new Automatic Ticket Machines. Just insert your exclusive AeroDork Gold Club membership card into the slot on the left."
			)
			(4 ; Inventory
				(if (== invItem 7) ; AeroDork_Gold_Card
					(TPrint 258 2) ; "Insert your exclusive AeroDork Gold Club membership card into the slot on the left."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(1 ; Walk
				(if (== ((gTheIconBar at: 0) cursor:) (proc0_28 6 6 6 61 6))
					(cond
						((or (IsFlag 46) (gEgo has: 7)) ; AeroDork_Gold_Card
							(gCurRoom newRoom: 250)
						)
						((gCast contains: card)
							(gCurRoom drawPic: (gCurRoom picture:))
							(switch (++ warnCounter)
								(1
									(Display ; "Hey! Take your AeroDork gold card!"
										258
										3
										dsCOORD
										144
										75
										dsCOLOR
										gColWhite
										dsWIDTH
										110
										dsFONT
										gSmallFont
									)
								)
								(2
									(Display ; "Look, you twit. If you wander off and leave that card here I'll see to it that your luggage goes non-stop to Muncie, Indiana!"
										258
										4
										dsCOORD
										144
										75
										dsCOLOR
										gColWhite
										dsWIDTH
										110
										dsFONT
										gSmallFont
									)
								)
								(else
									(Display ; "Fine. I'm ignoring you."
										258
										5
										dsCOORD
										144
										75
										dsCOLOR
										gColWhite
										dsWIDTH
										110
										dsFONT
										gSmallFont
									)
								)
							)
						)
						(else
							(bar1 dispose:)
							(bar2 dispose:)
							(bar3 dispose:)
							(card init:)
						)
					)
				else
					(return 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self newRoom: 250)
	)

	(method (newRoom)
		(if (gCast contains: card)
			(TPrint 258 6) ; "Hey! Don't forget your gold card!"
		else
			(SetupExit 0)
			(super newRoom: &rest)
		)
	)
)

(instance boardPass of Actor
	(properties
		x 164
		y 158
		description {the boarding pass}
		view 258
		loop 1
	)

	(method (init)
		(= view (proc0_28 258 258 258 2581 258))
		(super init:)
		(HandsOff)
		(gCurRoom drawPic: (gCurRoom picture:) 100)
		(if weCheated
			(Display 258 8 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "Oh, it's you, Mr. Hughes! Of course you may have a boarding pass! Right away, Sir!"
		else
			(Display 258 9 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "Please take your boarding pass now."
		)
		(if (not (SetFlag 46))
			(gTheMusic2 number: 257 setLoop: 0 play:)
			(self setPri: 3 setMotion: MoveTo x 178 self)
		else
			(self posn: 164 178 setCel: 255 setPri: 13)
		)
	)

	(method (cue)
		(gTheMusic2 stop:)
		(if (not cel)
			(self setPri: -1 setCycle: End self)
		else
			((Inv at: 8) state: [cityToState [dest theBar]]) ; Boarding_Pass
			(= gAirplaneSeat (+ (* (Random 2 10) 100) (Random 65 70)))
			(HandsOn)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 258 10) ; "Your newly obtained boarding pass is just hanging there, waiting for you to grab it."
			)
			(3 ; Do
				(Points 4)
				(gEgo get: 8) ; Boarding_Pass
				(card init:)
				(ClearFlag 46)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance card of Actor
	(properties
		x 83
		y 107
		description {your AeroDork card}
		view 258
		priority 3
		signal 16
		moveSpeed 10
	)

	(method (init)
		(= view (proc0_28 258 258 258 2581 258))
		(super init:)
		(if (== y 97)
			(gCurRoom drawPic: (gCurRoom picture:) 100)
			(Display 258 11 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "Please take your AeroDork gold card now."
			(gTheMusic2 number: 258 setLoop: 0 play:)
			(self setMotion: MoveTo x 107)
		else
			(Delay 10 1 self)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 258 12) ; "Your AeroDork Gold Card is ready to return to your pocket."
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom drawPic: (gCurRoom picture:) 100)
				(Display 258 13 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "Thank you for flying AeroDork!"
				(gEgo get: 7) ; AeroDork_Gold_Card
				(Delay 5 0 gCurRoom)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue &tmp i)
		(switch (++ cueCounter)
			(1
				(gTheMusic2 number: 258 setLoop: 0 play:)
				(self setMotion: MoveTo x 97 self)
			)
			(2
				(User canInput: 1)
				(gEgo put: 7) ; AeroDork_Gold_Card
				(= [dest 0] 0)
				(= [dest 1] 0)
				(= [dest 2] 0)
				(Display
					{Welcome, Cliff Taurus! Where to today?}
					dsCOORD
					144
					75
					dsCOLOR
					gColWhite
					dsWIDTH
					110
					dsFONT
					gSmallFont
				)
				(= i 0)
				(if (not (IsFlag 9))
					(FormatTime i 5)
					(Display
						{New York}
						dsCOORD
						144
						102
						dsCOLOR
						gColWhite
						dsWIDTH
						120
						dsFONT
						gSmallFont
					)
					(Display
						@departTime
						dsCOORD
						215
						102
						dsCOLOR
						gColWhite
						dsWIDTH
						105
						dsFONT
						gSmallFont
					)
					(= [dest i] 5)
					(++ i)
				)
				(if (not (IsFlag 10))
					(FormatTime i 4)
					(Display
						{Atlantic City}
						dsCOORD
						144
						(+ 102 (* 10 i))
						dsCOLOR
						gColWhite
						dsWIDTH
						120
						dsFONT
						gSmallFont
					)
					(Display
						@departTime
						dsCOORD
						215
						(+ 102 (* 10 i))
						dsCOLOR
						gColWhite
						dsWIDTH
						105
						dsFONT
						gSmallFont
					)
					(= [dest i] 4)
					(++ i)
				)
				(if (not (IsFlag 11))
					(FormatTime i 2)
					(Display
						{Miami}
						dsCOORD
						144
						(+ 102 (* 10 i))
						dsCOLOR
						gColWhite
						dsWIDTH
						120
						dsFONT
						gSmallFont
					)
					(Display
						@departTime
						dsCOORD
						215
						(+ 102 (* 10 i))
						dsCOLOR
						gColWhite
						dsWIDTH
						105
						dsFONT
						gSmallFont
					)
					(= [dest i] 2)
					(++ i)
				)
				(if (not i)
					(FormatTime i 1)
					(Display
						{Los Angeles}
						dsCOORD
						144
						102
						dsCOLOR
						gColWhite
						dsWIDTH
						120
						dsFONT
						gSmallFont
					)
					(Display
						@departTime
						dsCOORD
						210
						102
						dsCOLOR
						gColWhite
						dsWIDTH
						100
						dsFONT
						gSmallFont
					)
					(= [dest i] 1)
					(++ i)
				)
				(if i
					(bar1 init:)
					(if (> i 1)
						(bar2 init:)
						(if (> i 2)
							(bar3 init:)
						)
					)
				)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: 2)
				(self dispose:)
			)
		)
	)
)

(instance slot of Feature
	(properties
		x 80
		y 19
		z -100
		nsTop 91
		nsLeft 63
		nsBottom 148
		nsRight 98
		description {the card slot}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 258 14) ; "Insert your AeroDork Gold card into this slot."
			)
			(4 ; Inventory
				(switch invItem
					(7 ; AeroDork_Gold_Card
						(User canInput: 0)
						(card init:)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dispenser of Feature
	(properties
		x 162
		y 178
		nsTop 171
		nsLeft 120
		nsBottom 186
		nsRight 204
		description {the boarding pass slot}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 258 15) ; "Boarding passes are emitted from this slot."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ATMName of Feature ; UNUSED
	(properties
		x 164
		y 27
		nsTop 15
		nsLeft 57
		nsBottom 40
		nsRight 271
		description {the nameplate}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 258 16) ; "The nameplate says, "AeroDork Airlines.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance screen of Feature ; UNUSED
	(properties
		x 194
		y 110
		nsTop 63
		nsLeft 130
		nsBottom 157
		nsRight 259
		description {the screen}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 258 17) ; "The AeroDork ATM has a touch-sensitive screen."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bar1 of Feature
	(properties
		x 174
		nsLeft 143
		nsRight 205
		description {the destination}
		sightAngle 40
	)

	(method (init)
		(= y (proc0_28 105 105 112 105 105))
		(= nsTop (proc0_28 100 100 107 100 100))
		(= nsBottom (proc0_28 110 110 117 110 110))
		(super init: &rest)
	)

	(method (doVerb theVerb invItem &tmp [str 160])
		(switch theVerb
			(2 ; Look
				(Format ; "Click the hand icon here to select the flight to %s."
					@str
					258
					18
					(switch [dest 0]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
					(switch [dest 0]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(TPrint @str)
			)
			(3 ; Do
				(= theBar 0)
				(gCurRoom drawPic: (gCurRoom picture:) 100)
				(Display 258 19 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "Please enter the five-character Destination Code from your AeroDork Airline Travel Brochure."
				(if (not (HaveMouse))
					(TPrint 258 20 80 {A hint from AL}) ; "You can use your number pad to enter your code. The keys match in position (i.e. the 7 key will press the top left button, etc.). Be sure to use only the numeric key pad, not the cursor keys."
				)
				((ScriptID 20 0) init: 0) ; TTDialer
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bar2 of Feature
	(properties
		x 174
		nsLeft 143
		nsRight 205
		description {the destination}
		sightAngle 40
	)

	(method (init)
		(= y (proc0_28 115 115 122 115 115))
		(= nsTop (proc0_28 110 110 117 110 110))
		(= nsBottom (proc0_28 120 120 127 120 120))
		(super init: &rest)
	)

	(method (doVerb theVerb invItem &tmp [str 160])
		(switch theVerb
			(2 ; Look
				(Format ; "Click the hand icon here to select the flight to %s."
					@str
					258
					18
					(switch [dest 1]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
					(switch [dest 1]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(TPrint @str)
			)
			(3 ; Do
				(= theBar 1)
				(gCurRoom drawPic: (gCurRoom picture:) 100)
				(Display 258 21 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "Please enter the five-character Destination Code from your AeroDork Airline Travel Brochure."
				(if (not (HaveMouse))
					(TPrint 258 20 80 {A hint from AL}) ; "You can use your number pad to enter your code. The keys match in position (i.e. the 7 key will press the top left button, etc.). Be sure to use only the numeric key pad, not the cursor keys."
				)
				((ScriptID 20 0) init: 0) ; TTDialer
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bar3 of Feature
	(properties
		x 174
		nsLeft 143
		nsRight 205
		description {the destination}
		sightAngle 40
	)

	(method (init)
		(= y (proc0_28 125 125 132 125 125))
		(= nsTop (proc0_28 120 120 127 120 120))
		(= nsBottom (proc0_28 130 130 137 130 130))
		(super init: &rest)
	)

	(method (doVerb theVerb invItem &tmp [str 160])
		(switch theVerb
			(2 ; Look
				(Format ; "Click the hand icon here to select the flight to %s."
					@str
					258
					22
					(switch [dest 2]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
					(switch [dest 2]
						(1 {Los Angeles})
						(2 {Miami})
						(4 {Atlantic City})
						(5 {New York})
					)
				)
				(TPrint @str)
			)
			(3 ; Do
				(= theBar 2)
				(gCurRoom drawPic: (gCurRoom picture:) 100)
				(Display 258 23 dsCOORD 144 75 dsCOLOR gColWhite dsWIDTH 110 dsFONT gSmallFont) ; "Please enter the five character Destination Code from your AeroDork Airline Travel Brochure."
				(if (not (HaveMouse))
					(TPrint 258 20 80 {A hint from AL}) ; "You can use your number pad to enter your code. The keys match in position (i.e. the 7 key will press the top left button, etc.). Be sure to use only the numeric key pad, not the cursor keys."
				)
				((ScriptID 20 0) init: 0) ; TTDialer
				(bar1 dispose:)
				(bar2 dispose:)
				(bar3 dispose:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

