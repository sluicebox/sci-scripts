;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Full)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm370 0
)

(local
	[string 100]
	patience = 2
)

(procedure (HeadLeft whoCares)
	(ferrariHead tLoop: 2 setLoop: 1 setCel: 0 setCycle: End whoCares)
)

(procedure (HeadRight whoCares)
	(ferrariHead tLoop: 0 setLoop: 1 setCel: 4 setCycle: Beg whoCares)
)

(procedure (RightHandUp whoCares)
	(rightHand setCel: 0 setCycle: End whoCares)
)

(procedure (RightHandDown whoCares)
	(rightHand setCel: 2 setCycle: Beg whoCares)
)

(procedure (RightHandSlap howMany whoCares)
	(rightHand setCel: 0 setCycle: Full howMany whoCares)
)

(procedure (LeftHandSwat whoCares)
	(leftHand setCycle: Full 1 whoCares)
)

(instance rm370 of Rm
	(properties
		picture 370
		style 6
	)

	(method (init)
		(LoadMany rsVIEW 360 361 365)
		(super init:)
		(DontMove 1)
		(InitAddToPics upperArm)
		(gEgo view: 371 loop: 0 posn: 115 78 init:)
		(egoEyes init:)
		(ferrariHead init:)
		(if (== gInnState 7)
			(leftHand setLoop: 7 posn: 240 109)
		)
		(leftHand init:)
		(rightHand init:)
		(StartTimer nodTimer 5)
		(StartTimer blinkTimer 3)
		(ClearFlag 2) ; fInMainGame
		(switch gInnState
			(0
				(gCurRoom setScript: meeting1)
			)
			(2
				(gCurRoom setScript: meeting2)
			)
			(5
				(gCurRoom setScript: meeting3)
			)
			(7
				(gCurRoom setScript: meeting4)
			)
		)
	)

	(method (dispose)
		(++ gInnState)
		(DontMove 0)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(SetFlag 2) ; fInMainGame
		(super dispose:)
	)
)

(instance ferrariLaughs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (ferrariHead loop:))
				(ferrariHead
					setLoop: 5
					setCel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(1
				(ferrariHead setLoop: 6 setCel: 0 setCycle: Fwd)
				(= cycles 8)
			)
			(2
				(ferrariHead setLoop: 5 setCel: 3 setCycle: Beg self)
			)
			(3
				(ferrariHead setLoop: register)
				(self dispose:)
			)
		)
	)
)

(instance meeting1 of HandsOffScript
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '/coffee') (Said '//coffee'))
				(self cue:)
			)
			((or (Said '/sling,djinn') (Said '//sling,djinn'))
				(SetFlag 102) ; fDjinnSling
				(self cue:)
			)
			(else
				(event claimed: 1)
				(self changeState: 12)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say ferrariHead self 370 0) ; "If you don't mind me saying so, you look like a man with a mission. I like that in a man."
			)
			(1
				(HeadLeft self)
			)
			(2
				(Say ferrariHead self 370 1 370 2) ; "But perhaps a word of caution. In a city such as Raseir, there are many depths to the problems."
			)
			(3
				(HeadRight self)
			)
			(4
				(RightHandUp)
				(Say ferrariHead self 370 3) ; "You will find that the system is not so bad, once you get used to it."
			)
			(5
				(RightHandDown)
				(Say ferrariHead self 370 4) ; "However, it would be very dangerous to try to alter that system.  You might make enemies."
			)
			(6
				(DontTalk 0)
				(RightHandSlap 1)
				(LeftHandSwat)
				(Say ferrariHead 370 5 370 6) ; "Enough of such morbid thoughts, though. Perhaps we should share a drink in honor of our new relationship."
				(StartTimer questionTimer 30)
			)
			(7
				(questionTimer dispose:)
				(DontTalk 1)
				(RightHandSlap 2)
				(self setScript: ferrariLaughs self)
			)
			(8
				(if (IsFlag 102) ; fDjinnSling
					(Say ferrariHead self 370 7 370 8) ; "A wise choice. I dislike a man who doesn't drink."
				else
					(Say ferrariHead self 370 9) ; "A most prudent decision upon your part."
				)
			)
			(9
				(HeadLeft self)
			)
			(10
				(LeftHandSwat)
				(if (IsFlag 102) ; fDjinnSling
					(Say ferrariHead self 370 10) ; "Wilmer, a drink for our young friend."
				else
					(Say ferrariHead self 370 11) ; "Wilmer, the coffee."
				)
			)
			(11
				(gCurRoom newRoom: 360)
			)
			(12
				(RightHandSlap 1)
				(LeftHandSwat)
				(Say ferrariHead self 370 12) ; "Ah, you are obviously a very busy man, as am I. Perhaps we can talk over drinks another time. I will not detain you longer.  Wilmer, show our friend to the door."
			)
			(13
				(EgoDead ; "As you leave the room, you watch the jovial expression harden to a glare. It is obvious that Signor Ferrari is not used to being ignored. You also find that you are no longer welcome at the Blue Parrot Inn. Since you have no place to spend the night, you are soon arrested for vagrancy. It is hard to be a hero in the bottom of a dungeon."
					0
					369
					3
					#icon
					999
					1
					4
					#title
					{You should have had one for the road}
				)
			)
		)
	)
)

(instance meeting2 of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say ferrariHead self 370 13) ; "I wish to tell you a story, a fable that has a moral."
			)
			(1
				(RightHandUp)
				(HeadLeft self)
			)
			(2
				(Say ferrariHead self 370 14) ; "How you choose to react to this moral is your own life."
			)
			(3
				(RightHandDown)
				(HeadRight self)
			)
			(4
				(Say ferrariHead self 370 15 370 16) ; "As you well know, the old Emir was deposed last year, and his brother took over the Palace."
			)
			(5
				(RightHandUp)
				(LeftHandSwat)
				(Say ferrariHead self 370 17) ; "That has changed with the coming of Khaveen and his master."
			)
			(6
				(RightHandDown)
				(Say ferrariHead self 370 18 370 19) ; "A new order has been established. The weak have perished or fled."
			)
			(7
				(HeadLeft self)
			)
			(8
				(Say ferrariHead self 370 20 370 21) ; "You are strong, but it remains to be seen how adaptable you are."
			)
			(9
				(RightHandSlap 3)
				(HeadRight self)
			)
			(10
				(LeftHandSwat)
				(Say ferrariHead self 370 22) ; "Enough of that for now. I have someone I would like you to meet."
			)
			(11
				(HeadLeft self)
			)
			(12
				(Say ferrariHead self (Format @string 370 23 @gUserName)) ; "Ugarte, I would like to introduce you to %s."
			)
			(13
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance meeting3 of HandsOffScript
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'yes')
				(self changeState: 9)
			)
			((Said 'no')
				(self cue:)
			)
			(else
				(Say ferrariHead 370 24 370 25) ; "A simple Yes or No will suffice."
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(RightHandUp)
				(Say ferrariHead self 370 25) ; "As I have said before, there is no room for amateurs in this city."
			)
			(1
				(RightHandDown)
				(Say ferrariHead self 370 26) ; "They tend to call attention to themselves, and this gives the profession a bad name."
			)
			(2
				(HeadLeft self)
			)
			(3
				(Say ferrariHead self 370 27) ; "If you are as skilled as I have heard, then I might have use for you."
			)
			(4
				(HeadRight self)
			)
			(5
				(DontTalk 0)
				(Say ferrariHead 370 28) ; "However, first you must prove yourself. Are you willing to do for me a small favor?"
			)
			(6
				(DontTalk 1)
				(RightHandUp)
				(Say ferrariHead self 370 29) ; "I confess I am a bit disappointed in you, sir. It seems I expected too much."
			)
			(7
				(RightHandDown)
				(Say ferrariHead self 370 30) ; "Pity. Ah, well, there will be others. Good day, sir."
			)
			(8
				(= gInnState 8)
				(gCurRoom newRoom: 360)
			)
			(9
				(DontTalk 1)
				(Say ferrariHead self 370 31 370 32) ; "I wish you to bring me a small ornament to prove your skills."
			)
			(10
				(RightHandUp)
				(HeadLeft self)
			)
			(11
				(Say ferrariHead self 370 33) ; "I am an admirer of birds, you see."
			)
			(12
				(RightHandDown)
				(HeadRight self)
			)
			(13
				(self setScript: ferrariLaughs self)
			)
			(14
				(LeftHandSwat)
				(Say ferrariHead self 370 34 370 35) ; "The place is the window on your right as you first enter the Fountain Plaza from here."
			)
			(15
				(RightHandSlap 2)
				(Say ferrariHead self 370 36) ; "If you return this to me, I will make you my right-hand man."
			)
			(16
				(HeadLeft self)
			)
			(17
				(Say ferrariHead self 370 37) ; "Wilmer there just does not have quite what it takes to give me what I want."
			)
			(18
				(HeadRight self)
			)
			(19
				(LeftHandSwat)
				(Say ferrariHead self 370 38 370 39) ; "To get past the guards outside, you have only to make the 'sign'."
			)
			(20
				(HeadLeft self)
			)
			(21
				(RightHandUp)
				(Say ferrariHead self 370 40 370 41) ; "However, any other guard you meet will not be so discreet."
			)
			(22
				(RightHandDown)
				(HeadRight self)
			)
			(23
				(Say ferrariHead self 370 42 370 43) ; "Now seems like an excellent time for such a venture."
			)
			(24
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance meeting4 of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say ferrariHead self 370 44) ; "Do you know what we have here?"
			)
			(1
				(RightHandUp)
				(Say ferrariHead self 370 45) ; "The sole reason I came to this desert-driven country."
			)
			(2
				(HeadLeft self)
			)
			(3
				(RightHandDown)
				(Say ferrariHead self 370 46 370 47) ; "For seventeen years, I have sought the black bird."
			)
			(4
				(Say ferrariHead self 370 48) ; "Let me look, let me see."
			)
			(5
				(ferrariHead
					setLoop: 8
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 2 1
				)
				(= cycles 20)
			)
			(6
				(ferrariHead setCycle: End)
				(= cycles 20)
			)
			(7
				(ferrariHead setLoop: 9 setCel: 0 setCycle: CT 2 1)
				(= cycles 12)
			)
			(8
				(ferrariHead setCel: 0 setCycle: End)
				(= cycles 8)
			)
			(9
				(ferrariHead setLoop: 9 setCel: 3 cycleSpeed: 1 setCycle: Beg)
				(= cycles 10)
			)
			(10
				(self setScript: ferrariLaughs self)
			)
			(11
				(RightHandSlap 2)
				(Say ferrariHead self 370 49 370 50) ; "It seems that the joke is upon me."
			)
			(12
				(nodTimer dispose:)
				(blinkTimer dispose:)
				(gEgo setLoop: 2 cycleSpeed: 1 setCycle: End)
				(= cycles 14)
			)
			(13
				(gEgo setCel: 0)
				(HeadLeft self)
			)
			(14
				(StartTimer nodTimer 5)
				(StartTimer blinkTimer 3)
				(gEgo setLoop: 0 setCel: 0)
				(Say ferrariHead self 370 51) ; "There were four of these made. Only one had any value."
			)
			(15
				(RightHandUp)
				(Say ferrariHead self 370 52) ; "It seems that I must continue my search."
			)
			(16
				(RightHandDown)
				(Say ferrariHead self 370 53) ; "If you are interested, I would not be adverse to having such a resourceful and skilled person such as yourself at my side."
			)
			(17
				(RightHandSlap 3)
				(Say ferrariHead self 370 54) ; "If you could but learn to curve those unfortunate heroic tendencies, you would make an excellent partner."
			)
			(18
				(Say ferrariHead self 370 55) ; "Leave me, now. I have a good deal of planning to do."
			)
			(19
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance ferrariHead of Talker
	(properties
		x 184
		y 79
		description {Ferrari}
		lookStr {This is Signor Ferrari.  He is swatting flies with an animal-tail whip.}
		view 375
		talkSpeed 1
		myName '//ferrari,man,senor'
		title {Signor Ferrari:}
		color 2
	)

	(method (init)
		(super init: &rest)
		(= tWindow BotWindow)
	)

	(method (handleEvent event)
		(if (== (event type:) evSAID)
			(event claimed: 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance upperArm of PicView
	(properties
		x 232
		y 118
		noun '/ferrari,(man<fat)'
		description {Ferrari}
		lookStr {This is Signor Ferrari.  He is swatting flies with an animal-tail whip.}
		view 375
		loop 11
	)
)

(instance leftHand of Prop
	(properties
		x 245
		y 111
		noun '/ferrari,(man<fat)'
		description {Ferrari}
		lookStr {This is Signor Ferrari.  He is swatting flies with an animal-tail whip.}
		view 375
		loop 4
		priority 9
		signal 16
	)

	(method (init)
		(super init: &rest)
	)
)

(instance rightHand of Prop
	(properties
		x 144
		y 98
		noun '/ferrari,(man<fat)'
		description {Ferrari}
		lookStr {This is Signor Ferrari.  He is swatting flies with an animal-tail whip.}
		view 375
		loop 3
	)

	(method (init)
		(super init: &rest)
	)
)

(instance egoEyes of Prop
	(properties
		x 124
		y 61
		view 371
		loop 1
		priority 15
		signal 16
	)
)

(instance nodTimer of Timer
	(properties)

	(method (cue)
		(gEgo setCycle: Full (Random 1 3))
		(StartTimer self 10 15)
	)
)

(instance blinkTimer of Timer
	(properties)

	(method (cue)
		(egoEyes setCycle: Full 1)
		(StartTimer self 5 8)
	)
)

(instance questionTimer of Timer
	(properties)

	(method (cue)
		(if (not (-- patience))
			((gCurRoom script:) changeState: 12)
		else
			(Say ferrariHead 370 56) ; "You should answer my question. Would you prefer our famous Raseirish Coffee or a Djinn Sling?"
			(StartTimer self 30)
		)
	)
)

