;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use eRS)
(use n027)
(use Print)
(use Inset)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	local0
	local1
	local2
)

(instance rm250 of LBRoom
	(properties
		noun 14
		picture 250
	)

	(method (init &tmp [temp0 50])
		(LoadMany rsVIEW 250 251 252 253 254)
		(LoadMany rsSOUND 300 41 250 252)
		(noise number: 41 flags: 5 play:)
		(super init:)
		(proc0_8 1)
		(gWalkHandler addToFront: gCurRoom)
		(User canInput: 1)
		(laura cel: (if (gEgo wearingGown:) 1 else 0) addToPic:)
		(license init:)
		(if (TimeCheck $0010 1)
			(trash1 init:)
			(trash2 init:)
			(trash3 init:)
			(trash4 init:)
			(trash5 init:)
			(cornerTrash addToPic:)
			(if
				(and
					(not (gEgo wearingGown:))
					(not (gEgo has: 1)) ; claimTicket
					(not (gEgo has: 32)) ; eveningGown
				)
				(ticket init:)
			)
			(DDriver addToPic:)
		else
			(CDriver addToPic:)
		)
		(gGameMusic1 number: 250)
		(win1 init: stopUpd:)
		(win2 init: stopUpd:)
		(win3 init: stopUpd:)
		(win4 init: stopUpd:)
		(win5 init: stopUpd:)
		(gNarrator y: 120)
		(cond
			((and (== gPrevRoomNum 300) (gEgo wearingGown:))
				(self setScript: sACTBREAK)
			)
			((not (gEgo has: 6)) ; pressPass
				(if (gCast contains: trash1)
					(self setScript: sNoPressPassD)
				else
					(self setScript: sNoPressPassC)
				)
			)
			(else
				(self setScript: sHasPressPass)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom)
		(if inset
			(inset dispose:)
		)
		(gWalkHandler delete: gCurRoom)
		(if (gMessager oldIconBarState:)
			(gMessager dispose:)
		)
		(proc0_8 0)
		(super newRoom: &rest)
	)
)

(instance sACTBREAK of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(proc27_2)
				((ScriptID 21 1) doit: 1029) ; dropCluesCode, Charleston
				(win1 setCycle: Fwd)
				(win2 setCycle: Fwd)
				(win3 setCycle: Fwd)
				(win4 setCycle: Fwd)
				(win5 setCycle: Fwd)
				(gGameMusic2 send: 2 224 2400)
				(= cycles 1)
			)
			(1
				(gGameMusic2 send: 2 224 2800)
				(= cycles 1)
			)
			(2
				(gGameMusic2 send: 2 224 3200)
				(= cycles 1)
			)
			(3
				(gGameMusic2 send: 2 224 3600)
				(= cycles 1)
			)
			(4
				(gGameMusic2 send: 2 224 4000)
				(gGameMusic1 number: 300 loop: 1 flags: 1 play: self)
			)
			(5
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(6
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(7
				(gGameMusic2 send: 2 224 1000)
				(= cycles 1)
			)
			(8
				(gGameMusic2 send: 2 224 500)
				(= cycles 1)
			)
			(9
				(gGameMusic2 send: 2 224 0)
				(= cycles 5)
			)
			(10
				(gGameMusic1 fade:)
				(gGameMusic2 fade:)
				(gCurRoom newRoom: 26) ; actBreak
			)
		)
	)
)

(instance sNoPressPassD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 9 1 self) ; "If ya got money, I'll give youse a ride. If yer a reporter, I'll give youse a ride. Otherwise, GET OUTTA MY CAB!"
			)
			(2
				(gMessager say: 1 0 10 1 self) ; "But I AM a member of the Press!"
			)
			(3
				(gMessager say: 1 0 9 2 self) ; "Prove it."
			)
			(4
				(gGame handsOn:)
				(= seconds 15)
			)
			(5
				(gMessager say: 1 0 9 3 self) ; "Let's face it, toots. Youse doesn't have what youse need for a lift in my cab. Beat it!"
			)
			(6
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
		)
	)
)

(instance sNoPressPassC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 1 1 self) ; "I'm sorry, madam. I can only transport you if you have money or if you're a member of the Press."
			)
			(2
				(gMessager say: 1 0 10 1 self) ; "But I AM a member of the Press!"
			)
			(3
				(gMessager say: 1 0 1 2 self) ; "Prove it."
			)
			(4
				(gGame handsOn:)
				(= seconds 15)
			)
			(5
				(gMessager say: 1 0 1 3 self) ; "You clearly don't have what you need for a ride in this vehicle, madam. Good day."
			)
			(6
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
		)
	)
)

(instance sHasPressPass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(cond
					((and (gCast contains: trash1) (not (IsFlag 26)))
						(client setScript: s1stTimeInDirtyTaxi self)
					)
					((gCast contains: trash1)
						(gMessager say: 1 0 7 6 self) ; "Yeah, I'll take youse for a ride if ya got da dough or if ya can prove youse is a reporter."
					)
					((not (gCast contains: trash1))
						(gMessager say: 1 0 8 0 self) ; "Greetings, madam. I can motivate you to your destination if you can prove that you're a reporter or if you have American currency."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance s1stTimeInDirtyTaxi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 7 1 self) ; "My goodness, has this taxi EVER been cleaned?"
			)
			(2
				(gMessager say: 1 0 7 2 self) ; "I cleaned id out two years ago! Ya gotta problem wid dat?"
				(SetFlag 26)
			)
			(3
				(= register 0)
				(switch
					(Print
						addText: 16 0 0 0 ; "You respond to Bob's remark:"
						addButton: 1 15 0 0 1 5 18 ; "No, sir. I LOVE sitting in filth. Will you take me for a ride?"
						addButton: 2 15 0 0 2 5 48 ; "Yes, I have a problem with that! This taxi is a pig sty!"
						init:
					)
					(1
						(gMessager say: 1 0 7 6 self) ; "Yeah, I'll take youse for a ride if ya got da dough or if ya can prove youse is a reporter."
					)
					(2
						(gMessager say: 1 0 7 5 self) ; "Thanks for yer critique of my lifestyle, miss. Now, GET OUTTA MY CAB!"
						(= register 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(= seconds 1)
			)
			(5
				(if (== register 1)
					(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWhereToBud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(if (not (gCast contains: trash1))
					(gMessager say: 5 11 8 0 self) ; "To what location would you like to be motivated, madam?"
				else
					(gMessager say: 4 11 7 0 self) ; "Okay, toots, where can I take youse?"
				)
			)
			(2
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(513
						(= local0 210)
					)
					(515
						(= local0 260)
					)
					(516
						(= local0 240)
					)
					(514
						(= local0 280)
					)
					(518
						(= local0 300)
					)
					(520
						(= local0 300)
					)
					(517
						(= local0 330)
					)
					(519
						(= local2 1)
						(= local0 250)
						(if (not (gCast contains: trash1))
							(gMessager say: 17 14 8 0) ; "You'll have to be more specific, madam. This is a large city."
						else
							(gMessager say: 17 14 7 0) ; "Lady, youse is already IN New York. WHERE does ya want to go? I ain't got all day."
						)
					)
					(-1
						(= local0 250)
					)
					(else
						(= local0 250)
						(if (not (gCast contains: trash1))
							(gMessager say: 12 14 8 0) ; "I'm terribly sorry, madam, but you're not making any sense. Where do you wish to be transported?"
						else
							(gMessager say: 12 14 7 0) ; "You some kinda tourist, lady? I doesn't know what youse is talkin' about. Tell me WHERE ya want to go!"
						)
					)
				)
				(= cycles 1)
			)
			(3
				(cond
					((or (== local0 gPrevRoomNum) (== local0 gCurRoomNum))
						(gGame handsOn:)
						(= cycles 1)
					)
					((not (gCast contains: trash1))
						(self setScript: sDoTakeOffFlight self)
					)
					(else
						(self setScript: sMoveBuildings self)
					)
				)
			)
			(4
				(gTheIconBar enable: 5)
				(if (!= local0 gCurRoomNum)
					(gCurRoom newRoom: local0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoTakeOffFlight of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(win1 setCycle: Fwd)
				(win2 setCycle: Fwd)
				(win3 setCycle: Fwd)
				(win4 setCycle: Fwd)
				(win5 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(gGameMusic1 number: 250 loop: 1 flags: 1 play:)
				(gGame handsOn:)
				(gTheIconBar disable: 5 6 0)
				(= cycles 1)
			)
			(3
				(gGameMusic2 send: 2 224 1000)
				(= cycles 1)
			)
			(4
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(5
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(6
				(gGameMusic2 send: 2 224 4000)
				((ScriptID 1902 13) modeless: 1) ; Rocco
				((ScriptID 1903 14) modeless: 1) ; Bob
				(= register (Random 11 17))
				(cond
					((== register 17)
						(= seconds 8)
					)
					((== register 16)
						(= seconds 8)
					)
					(else
						(gMessager say: 10 0 register 0 self)
					)
				)
			)
			(7
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(8
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(9 0)
			(10
				(win1 setCycle: 0)
				(win2 setCycle: 0)
				(win3 setCycle: 0)
				(win4 setCycle: 0)
				(win5 setCycle: 0)
				(gGameMusic2 send: 2 224 1000)
				(if (== register 16)
					(gMessager say: 10 0 16 0 self) ; "Thanks for travelling with us, madam. Have a pleasant day."
				else
					(= register 0)
					(= cycles 1)
				)
			)
			(11
				(gGameMusic2 send: 2 224 500)
				(= cycles 1)
			)
			(12
				(gGameMusic2 send: 2 224 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if
			(and
				(== (self state:) 9)
				(== (gGameMusic1 number:) 250)
				(== (gGameMusic1 prevSignal:) -1)
			)
			(self cue:)
		)
		(super doit:)
	)
)

(instance sMoveBuildings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(win1 setCycle: Fwd)
				(win2 setCycle: Fwd)
				(win3 setCycle: Fwd)
				(win4 setCycle: Fwd)
				(win5 setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(gGameMusic1 number: 250 loop: 1 flags: 1 play:)
				(gGame handsOn:)
				(gTheIconBar disable: 5 6 0)
				(= cycles 1)
			)
			(2
				(gGameMusic2 send: 2 224 1000)
				(= cycles 1)
			)
			(3
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(4
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(5
				(gGameMusic2 send: 2 224 4000)
				(= seconds (Random 6 10))
			)
			(6 0)
			(7
				(self dispose:)
				(gGameMusic1 fade:)
			)
		)
	)

	(method (doit)
		(if
			(and
				(== (self state:) 6)
				(== (gGameMusic1 number:) 250)
				(== (gGameMusic1 prevSignal:) -1)
			)
			(self cue:)
		)
		(super doit:)
	)
)

(instance laura of View
	(properties
		y 100
		z 75
		view 251
		priority 10
		signal 4113
	)

	(method (doVerb theVerb)
		(if (== theVerb 13) ; Exit Icon
			(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
		else
			(gEgo doVerb: theVerb &rest)
		)
	)
)

(instance DDriver of View
	(properties
		x 232
		y 104
		noun 4
		view 252
		loop 1
		priority 4
		signal 6161
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 1 7 0) ; "Try not to upset this driver. He looks nervous and dangerous."
			)
			(4 ; Do
				(gMessager say: 4 4 7 0) ; "Hey, toots, you can touch me any time! If youse want, I could stop at dis cheap little hotel I know. Da manager's a friend of mine. We could use one of his rooms for a couple hours, if ya know what I mean...."
			)
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(6 ; Ask
				(if local2
					(gCurRoom setScript: sWhereToBud)
				else
					(= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
					(if (<= 512 temp0 665)
						(gMessager say: 11 6 7 0) ; "I knows where it is, but dat's all. I never leaves my taxi, so I never been in dere."
					else
						(gMessager say: 12 6 7 0) ; "Look, lady, I'm paid to DRIVE youse around town, but I DON'T like TALKING to passengers."
					)
				)
			)
			(2 ; Talk
				(gMessager say: 4 2 7 0) ; "I doesn't talks to da passengers."
			)
			(11 ; pressPass
				(gCurRoom setScript: sWhereToBud)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance CDriver of View
	(properties
		x 232
		y 104
		noun 5
		view 252
		priority 4
		signal 6161
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 8 0) ; "The driver is a big, rough-looking guy with a broken nose. Whatever you do, don't touch him."
			)
			(4 ; Do
				(gMessager say: 5 4 8 0) ; "Please don't touch me, madam. I don't know where you've been."
			)
			(6 ; Ask
				(if local2
					(gCurRoom setScript: sWhereToBud)
				else
					(= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
					(if (<= 512 temp0 665)
						(gMessager say: 11 6 8 0) ; "Looks like a nice place, but I live in my taxi, so I don't really know anything about it."
					else
						(gMessager say: 12 6 8 0) ; "I'm terribly sorry, madam, but the Taxi Control Board won't allow me to have a normal conversation with passengers."
					)
				)
			)
			(2 ; Talk
				(gMessager say: 5 2 8 0) ; "I'm terribly sorry, madam, but the Taxi Control Board doesn't allow me to hold long discussions with passengers, except at my own discretion."
			)
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(11 ; pressPass
				(gCurRoom setScript: sWhereToBud)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance win1 of Prop
	(properties
		x 87
		y 96
		noun 6
		view 253
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance win2 of Prop
	(properties
		x 141
		y 97
		noun 6
		view 253
		loop 1
		priority 2
		signal 16401
		cycleSpeed 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance win3 of Prop
	(properties
		x 159
		y 92
		noun 6
		view 254
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance win4 of Prop
	(properties
		x 213
		y 88
		noun 6
		view 254
		loop 1
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance win5 of Prop
	(properties
		x 268
		y 89
		noun 6
		view 254
		loop 2
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inTicket of Inset
	(properties
		view 250
		x 190
		y 154
		disposeNotOnMe 1
		noun 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				((ScriptID 21 0) doit: 770) ; addCluesCode, Laundry Claim Ticket
				(ticket dispose:)
				(inTicket dispose:)
				(gEgo get: -1 1) ; claimTicket
				(SetFlag 27)
			)
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ticket of View
	(properties
		x 149
		y 178
		view 250
		loop 2
		priority 8
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inTicket)
			)
			(4 ; Do
				(gEgo get: 1) ; claimTicket
				(SetFlag 27)
				((ScriptID 21 0) doit: 770) ; addCluesCode, Laundry Claim Ticket
				(self dispose:)
			)
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance license of Feature
	(properties
		x 246
		y 114
		nsTop 99
		nsLeft 219
		nsBottom 130
		nsRight 274
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (gCast contains: trash1)
			(= noun 7)
		else
			(= noun 8)
		)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Trash of View
	(properties
		noun 2
		view 250
		loop 1
		boundryLeft 0
		boundryRight 319
		boundryTop 155
		boundryBottom 189
	)

	(method (init)
		(if (TimeCheck $0010 1)
			(gMouseDownHandler addToFront: self)
			(gKeyDownHandler addToFront: self)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(1 ; Look
				(gMessager say: 3 1 4) ; "There's garbage all over the passenger section of the taxi. Some of it looks very old."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (inBounds)
		(if
			(and
				(> gMouseX boundryLeft)
				(< gMouseX boundryRight)
				(> gMouseY boundryTop)
				(< gMouseY boundryBottom)
			)
		)
	)

	(method (doit)
		(if (and (== local1 self) (self inBounds:))
			(= x gMouseX)
			(= y gMouseY)
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(== (event message:) KEY_RETURN)
					(== (event type:) evKEYBOARD)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(self onMe: event)
				)
				(if (!= local1 self)
					(= local1 self)
					(noise number: 54 loop: 1 flags: 5 play:)
				else
					(= local1 0)
				)
				(event claimed: 1)
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(self onMe: event)
				)
				(noise number: 54 loop: 1 flags: 5 play:)
				(= local1 self)
				(event claimed: 1)
			)
			((and (== (event type:) evMOUSERELEASE) (self onMe: event))
				(= local1 0)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance trash1 of Trash
	(properties
		x 166
		y 176
		cel 2
		signal 16384
	)
)

(instance trash2 of Trash
	(properties
		x 145
		y 163
		cel 3
		signal 16384
	)
)

(instance trash3 of Trash
	(properties
		x 148
		y 181
		cel 4
		signal 16384
	)
)

(instance trash4 of Trash
	(properties
		x 112
		y 174
		cel 5
		signal 16384
	)
)

(instance trash5 of Trash
	(properties
		x 58
		y 174
		signal 16384
	)
)

(instance cornerTrash of View
	(properties
		x 261
		y 189
		noun 2
		view 250
		loop 3
		priority 1
		signal 2064
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 27)
						(gMessager say: 2 4 4) ; "The seat feels sticky and you get a few unidentifiable substances on your hand, otherwise you don't accomplish much by doing this."
					)
					((TimeCheck $0010 1)
						(gMessager say: 2 4 2) ; "Since garbage holds a certain fascination for you, you plunge your hand into the debris."
					)
					((gEgo wearingGown:)
						(gMessager say: 2 4 4) ; "The seat feels sticky and you get a few unidentifiable substances on your hand, otherwise you don't accomplish much by doing this."
					)
					((gEgo has: 0) ; coupon
						(gMessager say: 2 4 4) ; "The seat feels sticky and you get a few unidentifiable substances on your hand, otherwise you don't accomplish much by doing this."
					)
					(else
						(gMessager say: 2 4 4) ; "The seat feels sticky and you get a few unidentifiable substances on your hand, otherwise you don't accomplish much by doing this."
					)
				)
			)
			(1 ; Look
				(gMessager say: 3 1 4) ; "There's garbage all over the passenger section of the taxi. Some of it looks very old."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance noise of Sound
	(properties
		flags 1
	)
)

