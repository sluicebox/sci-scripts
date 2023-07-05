;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm101 0
)

(local
	hisNum1
	hisNum2
	hisNum3
	hisNum4
	hisNum5
	hisNum6
	myNum1
	myNum2
	myNum3
	myNum4
	myNum5
	myNum6
)

(instance rm101 of Rm
	(properties
		picture 101
		south 11
	)

	(method (init)
		(Load rsVIEW 201)
		(Load rsVIEW 203)
		(Load rsVIEW 204)
		(Load rsVIEW 205)
		(if (gEgo has: 2) ; Lottery_Ticket
			(Load rsVIEW 2)
		)
		(super init:)
		(gAddToPics add: aView1 aView2 aView3 doit:)
		(aBigClerk view: 203 setLoop: 7 posn: 223 1042 setPri: 14 init:)
		(aBigMouth
			view: 203
			posn: 223 1042
			setLoop: 9
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(aGuy illegalBits: 0 setCycle: Walk init: setScript: guyScript)
		(aDoll illegalBits: 0 setCycle: Walk init: setScript: dollScript)
		(aReceptionist
			cycleSpeed: 1
			setPri: 9
			ignoreActors:
			init:
			setScript: receptionistScript
		)
		(NormalEgo)
		(aDoorWest stopUpd: init:)
		(aDoorEast stopUpd: init:)
		(aDoorNorth stopUpd: init:)
		(self setScript: rm101Script)
		(if (== gPrevRoomNum 104)
			(gEgo posn: 258 121 loop: 1 init:)
		else
			(gEgo posn: 156 180 init:)
		)
	)
)

(instance rm101Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl:) $0008)
				(gCurRoom newRoom: 11)
			)
			((and (gEgo inRect: 214 80 229 87) (not (guyScript state:)))
				(guyScript changeState: 1)
			)
			((and (gEgo inRect: 91 80 109 87) (not (dollScript state:)))
				(dollScript changeState: 1)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'give,finger,look/ticket')
			(cond
				((gEgo has: 3) ; Cruise_Ticket
					(event claimed: 0)
					(return)
				)
				((not (gEgo has: 2)) ; Lottery_Ticket
					(DontHave) ; "You don't have it."
				)
				((not (gEgo inRect: 134 144 185 152))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 1)
				)
			)
		)
		(if (Said 'look>')
			(if (Said '/door')
				(Print 101 0) ; "Every door here is locked, except the doors leading back to the street. There are signs over the doors."
			)
			(if (Said '/burn')
				(Print 101 1) ; "It's just a modern lighting fixture, not a trapeze upon which she performs!"
			)
			(if (Said '/brick,sign')
				(Print 101 2) ; "The sign over the west door says "The Dating Connection, CLOSED SET.""
				(Print 101 3) ; "The sign over the east door says "Lucky Life Lottery, CLOSED SET.""
				(Print 101 4) ; "The sign over the north door says "Green Room.""
				(Print 101 5) ; "The sign over the south door says "EXIT.""
			)
			(if (Said '/art')
				(Print 101 6) ; "Don't you love modern art."
			)
			(if (Said '/cup')
				(Print 101 7) ; "She has a nice pair of skylights, eh?"
			)
			(if (Said '/woman,skylight,buffet')
				(aBigClerk posn: 223 41 stopUpd:)
				(aBigMouth posn: 223 41)
				(receptionistScript changeState: 5)
				(Timer setReal: aBigClerk 5)
				(Timer setReal: aBigMouth 5)
				(HandsOff)
			)
			(if (Said '[/airport,krod,lobby,building,brick]')
				(Print 101 8) ; "The television studio lobby is lavishly decorated in the latest trend. A receptionist sits in the center of the room. There are doors in every wall."
			)
		)
		(if (Said 'open/door')
			(Print 101 9) ; "The only door you can open is the door you used to enter from the street."
		)
		(if (Said '/reporter')
			(Print 101 10) ; "Guess there must have been a fast-breaking story somewhere else!"
		)
		(if (Said 'talk,ask/woman')
			(if (or (gEgo has: 4) (gEgo has: 6)) ; Million_Dollar_Bill, Wad_O__Dough
				(Print 101 11) ; "Hey babe, I am really rich. Do you want me?"
				(Print 101 12) ; "The only thing I want from you is to leave."
				(Print 101 13 #at -1 130) ; "(Ouch.)"
			else
				(Print (Format @gString 101 14 gLaffer)) ; ""Hello, big, blonde and beautiful," you say. %s"
				(Print 101 15) ; "Hiya," she blurts between bubbles, "kin I helpya?"
			)
		)
		(if (Said 'yes')
			(Print 101 16) ; "Sure you can help me," you tell the girl, "can you get out from behind that counter?"
			(Print 101 17 #at -1 130) ; "(She ignores your feeble attempt at humor.)"
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(receptionistScript changeState: 14)
				(Print 101 18 #icon 2 0 0) ; "Say," you ask the receptionist, "is this lottery ticket any good?"
				(= seconds 4)
			)
			(2
				(= myNum1 (Random 100 999))
				(= myNum2 (Random 100 999))
				(= myNum3 (Random 100 999))
				(= myNum4 (Random 100 999))
				(= myNum5 (Random 100 999))
				(= myNum6 (Random 100 999))
				(Print
					(Format ; "I don't know," she replies, "I've misplaced my glasses! As best I can remember, this week's Lucky Life Lottery Luck-O Buck-O numbers are: %d, %d, %d, %d, %d, and %d. What six numbers do you have?"
						@gString
						101
						19
						myNum1
						myNum2
						myNum3
						myNum4
						myNum5
						myNum6
					)
				)
				(= gString 0)
				(for
					((= hisNum1 0))
					(or (< hisNum1 100) (> hisNum1 999))
					((= hisNum1 (GetNumber {Pick #1})))
				)
				(for
					((= hisNum2 0))
					(or (< hisNum2 100) (> hisNum2 999))
					((= hisNum2 (GetNumber {Pick #2})))
				)
				(for
					((= hisNum3 0))
					(or (< hisNum3 100) (> hisNum3 999))
					((= hisNum3 (GetNumber {Pick #3})))
				)
				(for
					((= hisNum4 0))
					(or (< hisNum4 100) (> hisNum4 999))
					((= hisNum4 (GetNumber {Pick #4})))
				)
				(for
					((= hisNum5 0))
					(or (< hisNum5 100) (> hisNum5 999))
					((= hisNum5 (GetNumber {Pick #5})))
				)
				(for
					((= hisNum6 0))
					(or (< hisNum6 100) (> hisNum6 999))
					((= hisNum6 (GetNumber {Pick #6})))
				)
				(= seconds 3)
			)
			(3
				(if
					(or
						(!= myNum1 hisNum1)
						(!= myNum2 hisNum2)
						(!= myNum3 hisNum3)
						(!= myNum4 hisNum4)
						(!= myNum5 hisNum5)
						(!= myNum6 hisNum6)
					)
					(self changeState: 10)
				else
					(gGame changeScore: 10)
					(Print 101 20) ; "Why, that's correct!" she replies excitedly. "You ARE a lucky guy! The last Lucky Life Lottery show of the season is being taped RIGHT NOW! I'll notify the director that you're here; I'm sure you'll be called immediately."
					(Print 101 21) ; "I'll unlock the door to the green room, so you can wait there."
					(= seconds 2)
					(gEgo put: 2 -1) ; Lottery_Ticket
				)
			)
			(4
				(gEgo setMotion: MoveTo 228 146 self)
			)
			(5
				(Print 101 22) ; "Oh, by the way," says the receptionist, "don't get nervous just because you're on live television and being watched by millions of people!"
				(Print 101 23) ; "She chuckles softly under her breath."
				(gEgo setMotion: MoveTo 228 117 self)
			)
			(6
				(gEgo setMotion: MoveTo 162 82 self)
			)
			(7
				(aDoorNorth setCycle: End self)
			)
			(8
				(gEgo illegalBits: 0 setMotion: MoveTo 162 77 self)
			)
			(9
				(gCurRoom newRoom: 102)
			)
			(10
				(= seconds (= cycles 0))
				(Print 101 24) ; "Well, that's too bad," she replies. "I'm sorry, but you cannot get on the big TV show unless you have all six lucky numbers."
				(Print 101 25) ; "Why don't you try again when you're a winner!"
				(User canControl: 1 canInput: 1)
				(receptionistScript changeState: 0)
			)
		)
	)
)

(instance receptionistScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 0)
				(= seconds (Random 3 7))
			)
			(1
				(aReceptionist setLoop: 4 cel: 0 setCycle: End self)
			)
			(2
				(aReceptionist setLoop: 5 cel: 0 setCycle: End self)
			)
			(3
				(aReceptionist cel: 0 setCycle: End self)
			)
			(4
				(aReceptionist setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(5
				(= seconds (= cycles 0))
				(aReceptionist setLoop: 0)
				(if (> (Random 1 3) 1)
					(self changeState: 0)
				else
					(= seconds (Random 3 7))
				)
			)
			(6
				(aReceptionist setLoop: 2 cel: 0 setCycle: End self)
			)
			(7
				(aReceptionist setLoop: 3 setCycle: Fwd)
				(= seconds (Random 2 4))
			)
			(8
				(aReceptionist setCel: 0)
				(= seconds (Random 3 7))
			)
			(9
				(aReceptionist setLoop: 3 setCycle: Fwd)
				(= seconds (Random 2 4))
			)
			(10
				(aReceptionist setCel: 0)
				(= seconds (Random 3 7))
			)
			(11
				(aReceptionist setLoop: 3 setCycle: Fwd)
				(= seconds (Random 1 3))
			)
			(12
				(aReceptionist setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(13
				(self changeState: 0)
			)
			(14
				(= cycles 0)
				(aReceptionist setLoop: 1 setCycle: Fwd)
				(= seconds (Random 2 4))
			)
			(15
				(aReceptionist setLoop: 0)
			)
		)
	)
)

(instance guyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aDoorWest setCycle: End self)
			)
			(2
				(aGuy posn: 33 117 setMotion: MoveTo 72 118 self)
			)
			(3
				(aGuy setMotion: MoveTo 132 182 self)
				(aDoorWest setCycle: Beg self)
			)
			(4
				(aDoorWest stopUpd:)
			)
			(5
				(aGuy setMotion: MoveTo 132 232 self)
			)
			(6
				(aGuy dispose:)
				(Print 101 26) ; "Hey! Was that somebody famous?"
			)
		)
	)
)

(instance dollScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aDoorEast setCycle: End self)
			)
			(2
				(aDoll posn: 288 117 setMotion: MoveTo 258 118 self)
			)
			(3
				(aDoll setMotion: MoveTo 162 182 self)
				(aDoorEast setCycle: Beg self)
			)
			(4
				(aDoorEast stopUpd:)
			)
			(5
				(aDoll setMotion: MoveTo 162 232)
			)
			(6
				(aDoll dispose:)
				(Print 101 26) ; "Hey! Was that somebody famous?"
			)
		)
	)
)

(instance aBigClerk of Prop
	(properties)

	(method (cue)
		(Print 101 27) ; "You find dull women sexy."
		(Print 101 28 #at 55 155 #width 210) ; "(But then, you find any woman sexy!)"
		(self posn: 223 1042)
	)
)

(instance aBigMouth of Prop
	(properties)

	(method (cue)
		(self posn: 223 1042)
		(HandsOn)
	)
)

(instance aView1 of PV
	(properties
		y 71
		x 51
		view 201
		priority 10
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 71
		x 266
		view 201
		cel 1
		priority 10
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 119
		x 168
		view 203
		loop 6
		priority 10
		signal 16384
	)
)

(instance aGuy of Act
	(properties
		y 1118
		x 33
		view 204
	)
)

(instance aDoll of Act
	(properties
		y 1118
		x 288
		view 205
	)
)

(instance aReceptionist of Prop
	(properties
		y 118
		x 158
		view 203
	)
)

(instance aDoorWest of Prop
	(properties
		y 106
		x 58
		view 201
		loop 1
		priority 7
		signal 16384
	)
)

(instance aDoorEast of Prop
	(properties
		y 106
		x 259
		view 201
		loop 2
		priority 7
		signal 16384
	)
)

(instance aDoorNorth of Prop
	(properties
		y 79
		x 145
		view 201
		loop 3
		priority 4
		signal 16384
	)
)

