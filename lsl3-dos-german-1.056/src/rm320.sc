;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n021)
(use AutoDoor)
(use Interface)
(use FileSelector)
(use Extra)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	[local0 501]
	local501
)

(instance rm320 of Rm
	(properties
		picture 320
		south 310
	)

	(method (init)
		(if (= gDollars 500)
			(Load rsVIEW 24)
		)
		(Load rsSOUND 323)
		(super init:)
		(atpDeskStuff init:)
		(atpPencils init:)
		(atpDCHSign init:)
		(atpSign init:)
		(atpFax init:)
		(gAddToPics
			add: atpDeskStuff
			add: atpPencils
			add: atpDCHSign
			add: atpSign
			add: atpFax
			doit:
		)
		(aDoor init: locked: 1)
		(if gEgoIsPatti
			(= gLawyerState 8)
		)
		(if (< gLawyerState 8)
			(aRoger init:)
			(if (> gMachineSpeed 16)
				(aFax init:)
			)
		)
		(self setScript: RoomScript)
		(if (or (== gPrevRoomNum 323) (== gPrevRoomNum 324))
			(gEgo loop: 2 posn: 153 96)
		else
			(gEgo loop: 3 posn: 156 186)
		)
		(if (!= gPrevRoomNum 323)
			(gMusic number: 323 loop: gBgMusicLoops play:)
		)
		(NormalEgo)
		(gEgo init:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (== gLawyerState 2) (== (gEgo edgeHit:) 3))
				(= gLawyerState 3)
			)
			((and (== gLawyerState 6) (== (gEgo edgeHit:) 3))
				(= gLawyerState 7)
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'get,get/palm')
				(Print 320 0) ; "You may need some wood, but this is not the right place to get it."
			)
			((Said '/equipment')
				(Print 320 1) ; "It's for internal use only."
				(Print 320 2 #at -1 144) ; "(Corporate internals, that is!)"
			)
			((Said '/computer')
				(Print 320 3) ; "You've been looking at a computer ever since you started playing this game!"
			)
			((Said '/call,call')
				(Print 320 4) ; "There is a telephone on the desk, but don't get any cute ideas about using it!"
			)
			((Said 'look,look>')
				(cond
					((Said '/palm')
						(Print 320 5) ; "With all the trees on this island, wouldn't you think they'd have enough outside!?"
					)
					((Said '/awning,wall')
						(Print 320 6) ; "You surmise those large initials represent the first letter of the last names of the three partners in this law firm."
					)
					((Said '/burn,burn,ceiling')
						(Print 320 7) ; "A suspended florescent fixture hangs above the receptionist's desk."
					)
					((Said '/buffet,buffet,buffet')
						(Print 320 8) ; "Roger's desk contains a computer terminal, a fax machine and a telephone."
					)
					((Said '/door')
						(cond
							((& (gEgo onControl:) $0008)
								(Print 320 9) ; "You are standing outside the door to Mr. Dewey's private office."
							)
							((& (gEgo onControl:) $0002)
								(Print 320 10) ; "This door leads to Ms. Suzi Cheatem's private office."
							)
							((& (gEgo onControl:) $0010)
								(Print 320 11) ; "This is the door to Mr. Howe's private office."
							)
							(else
								(Print 320 12) ; "There are three doors leading to the private offices of the firm's attorneys, as well as a door to the south leading outside."
							)
						)
					)
					((Said '[/area]')
						(Print 320 13) ; "You are in the offices of the distinguished island legal firm of Dewey, Cheatem, and Howe."
						(if (gCast contains: aRoger)
							(Print 320 14) ; "There is a male receptionist seated at the table."
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 4)
		(switch (= state newState)
			(0)
			(1)
			(2
				(HandsOff)
				(gGame changeScore: 10)
			)
			(3
				(HandsOff)
				(aDoor locked: 0)
				(gEgo illegalBits: 0 setMotion: MoveTo 233 (gEgo y:) self)
			)
			(4
				(gEgo setMotion: MoveTo 233 130 self)
				(if (== gEgoState 11)
					(Format @local0 320 15) ; ""Oh, by the way: Nice outfit, Mr. Laffer! (Hee, hee.)"%"
					(SecretaryScript changeState: 2)
				)
			)
			(5
				(gEgo setMotion: MoveTo 153 93 self)
			)
			(6
				(gEgo setMotion: MoveTo 153 87 self)
			)
			(7
				(if (== gEgoState 11)
					(gCurRoom newRoom: 324)
				else
					(gCurRoom newRoom: 323)
				)
			)
		)
	)
)

(instance SecretaryScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look/man,man,attendant,yes,hardy')
				(Print 320 16) ; "Roger is the executive secretary in charge of faxing and reception here at the legal firm of Dewey, Cheatem & Howe."
			)
			(
				(or
					(Said '/appointment')
					(Said '//appointment')
					(Said 'talk,talk')
				)
				(cond
					((not (& (gEgo onControl:) $0020))
						(NotClose) ; "You're not close enough."
					)
					((and (!= gEgoState 0) (!= gEgoState 11))
						(NotNow) ; "Good idea. You might try that again later."
					)
					((!= local501 0)
						(Print 320 17) ; "The receptionist seems to be busy right now."
					)
					(else
						(User canInput: 0)
						(switch gLawyerState
							(0
								(Print 320 18) ; ""Is there a lawyer available that could help me?" you ask the clerk."
								(Format @local0 320 19) ; ""I'm sorry, sir, but Mr. Dewey is in conference, Ms. Cheatem is taking depositions, and Mr. Howe is in court. Could you please drop by again later?"%"
								(self changeState: 2)
							)
							(1
								(Print 320 20) ; ""Is there a lawyer available that could help me?" you ask the clerk."
								(Format @local0 320 21) ; ""Yes, we have someone available. What specifically do you want, sir? We have all sorts of attorneys here."%"
								(self changeState: 2)
							)
							(2
								(Print 320 22) ; ""Is that deed ready?" you ask the clerk."
								(Format @local0 320 23) ; ""Ms. Cheatem has instructed me to prepare your land deed. I'll have it ready soon. Why don't you come back in a few minutes, Mr. Laffer."%"
								(self changeState: 2)
							)
							(3
								(Print 320 24) ; ""Hi, Roger," you greet the clerk."
								(Format @local0 320 25) ; ""Hello again, Mr. Laffer. I bet I know why you're here!"%"
								(self changeState: 2)
							)
							(4
								(Print 320 26) ; ""I'm back, Roger," you greet the clerk."
								(Format @local0 320 27) ; ""Nice to see you, Mr. Laffer. Did you bring $500.00 with you?"%"
								(self changeState: 2)
							)
							(6
								(Print 320 28) ; ""Is Ms. Cheatem always like that?" you ask Roger."
								(Format @local0 320 29) ; ""Yep! Isn't it nice to meet a woman that's really `into' her work!"%"
								(self changeState: 2)
							)
							(7
								(Print 320 24) ; ""Hi, Roger," you greet the clerk."
								(Format @local0 320 25) ; ""Hello again, Mr. Laffer. I bet I know why you're here!"%"
								(self changeState: 2)
							)
							(8
								(Print 320 30) ; ""Thanks for all your help, Roger," you tell him."
								(Format @local0 320 31) ; ""You're welcome, Mr. Swinging Single!"%"
								(self changeState: 2)
							)
						)
					)
				)
			)
			(
				(and
					(gEgo has: 9) ; Spa_Keycard
					(or
						(Said '/keycard,(card<key,club,membership)')
						(Said '//keycard,(card<key,club,membership)')
					)
				)
				(Print 320 32) ; "Roger, look here. I found a membership card to Fat City in my deed."
				(Format @local0 320 33) ; ""Just keep it, Mr. Laffer. It's the least Ms. Cheatem can do for you!"%"
			)
			((or (Said '/entertainer') (Said '//entertainer'))
				(User canInput: 0)
				(Print 320 34) ; ""Say, Roger. What do you know about that entertainer over at the casino lounge?" you ask him."
				(Format @local0 320 35) ; ""From personal experience, I can verify she's pretty fast -- and I'm not talking about fingering her keyboard!"%"
				(self changeState: 2)
			)
			(
				(or
					(Said '/attorney,attorney,attorney')
					(Said '//attorney,attorney,attorney')
				)
				(User canInput: 0)
				(Format @local0 320 36) ; ""Yes, we have lawyers galore around here. Why do you ask?"%"
				(self changeState: 2)
			)
			(
				(or
					(Said 'yes')
					(Said
						'give,buy,order,use/buck,man,man,attendant,yes,hardy,charge,500,bill,500'
					)
					(Said
						'give,buy,order,use//buck,man,man,attendant,yes,hardy,charge,500,bill,500'
					)
				)
				(cond
					((not (gEgo has: 6)) ; A_Twenty_Dollar_Bill
						(Print 320 37) ; "You have no money."
					)
					((not (& (gEgo onControl:) $0020))
						(NotClose) ; "You're not close enough."
					)
					((and (!= gEgoState 0) (!= gEgoState 11))
						(NotNow) ; "Good idea. You might try that again later."
					)
					((!= local501 0)
						(Print 320 17) ; "The receptionist seems to be busy right now."
					)
					((== gLawyerState 0)
						(User canInput: 0)
						(Format @local0 320 38) ; ""That won't help, sir. There are simply no lawyers available at this time. Why don't you come back later?"%"
						(self changeState: 2)
					)
					((== gLawyerState 1)
						(User canInput: 0)
						(Format @local0 320 39) ; ""That's not necessary, sir. Ms. Cheatem, one of our finest attorneys, is available right now, and remember: here at Dewey, Cheatem and Howe your first consultation is always free of charge."%"
						(self changeState: 2)
					)
					((> gLawyerState 4)
						(User canInput: 0)
						(Format @local0 320 40) ; ""You've paid all you owe. No more money is necessary, Mr. Laffer."%"
						(self changeState: 2)
					)
					((!= gDollars 500)
						(Print 320 41) ; "Too bad, Larry. Ms. Cheatem instructed you to bring $500.00 with you to pay for your next visit, remember? Check your pockets, but you don't have it."
						(Print 320 42 #at -1 144) ; "(Yet.)"
					)
					(else
						(Ok) ; "O.K."
						(= gLawyerState 5)
						(= gDollars 0)
						(gEgo put: 6 -1) ; A_Twenty_Dollar_Bill
						(User canInput: 0)
						(Print 320 43 #icon 24 0 0) ; "Here's the five hundred dollars Ms. Cheatem requested," you tell the receptionist. "May I please meet with her to finalize my divorce now?"
						(Format @local0 320 44) ; ""Why, certainly, Mr. Laffer," replies the receptionist, "walk right in. Ms. Cheatem will be happy to talk with you now."%"
						(RoomScript changeState: 2)
						(self changeState: 2)
					)
				)
			)
			(
				(and
					(gEgo has: 10) ; Divorce_Decree
					(not (gEgo has: 9)) ; Spa_Keycard
					(Said 'look,look,look/decree,document,document')
				)
				(event claimed: 0)
				(return)
			)
			(
				(or
					(Said '/decree,document,(document<decree)')
					(Said '//decree,document,(document<decree)')
				)
				(cond
					((not (& (gEgo onControl:) $0020))
						(NotClose) ; "You're not close enough."
					)
					((and (!= gEgoState 0) (!= gEgoState 11))
						(NotNow) ; "Good idea. You might try that again later."
					)
					((!= local501 0)
						(Print 320 17) ; "The receptionist seems to be busy right now."
					)
					((== gLawyerState 0)
						(User canInput: 0)
						(Printf 320 45 global386 global387) ; ""Excuse me," you say, interrupting the man working at the counter. %s%"
						(Print 320 46) ; "I need a divorce. Is there anyone here that could help me?"
						(Format @local0 320 47) ; ""Good day, sir. Welcome to the legal offices of Dewey, Cheatem and Howe. You've come to the right place, but unfortunately, all of our attorneys are busy right now. Could you please return later when one of them is free?"%"
						(self changeState: 2)
					)
					((== gLawyerState 1)
						(User canInput: 0)
						(Printf 320 48 global386 global387) ; ""Excuse me," you say, interrupting the man working at the counter. %s%"
						(Print 320 49) ; "I'm in desperate need of a divorce. Is there anyone here that could help me?"
						(Format @local0 320 50) ; ""Hello, Mr. Laffer. It's a pleasure to meet you. Certainly, we here at Dewey, Cheatem and Howe would be most proud to satisfy all your legal needs. Currently, Mr. Dewey is in court, and Mr. Howe is taking depositions down at the court hut, but you are in luck: Ms. Cheatem is available. Go right on in; her door is just behind me. I'll tell her you're on your way in."%"
						(RoomScript changeState: 2)
						(self changeState: 2)
					)
					((== gLawyerState 2)
						(User canInput: 0)
						(Print 320 51) ; ""How can I get a divorce around here?" you ask the clerk."
						(Format @local0 320 52) ; ""Ms. Cheatem has given me complete instructions for the preparation of your land deed, but she mentioned nothing about a divorce. Have you paid your fee yet, Mr. Laffer?"%"
						(self changeState: 2)
					)
					((< gLawyerState 6)
						(User canInput: 0)
						(Print 320 53) ; ""Roger, I'd like to get this divorce business all straightened out. When could I meet with Ms. Cheatem again?" you ask."
						(Format @local0 320 54) ; ""You've already had your one (and only) free introductory consultation, Mr. Laffer. Suzi will be happy to meet with you again, but to complete your legal arrangements, you must pay me your $500.00 fee."%"
						(self changeState: 2)
					)
					((< gLawyerState 7)
						(User canInput: 0)
						(Print 320 55) ; ""Now may I get my divorce papers?" you ask Roger."
						(Format @local0 320 56) ; ""Geez, Larry. Give me a little time, will you? Your papers will be ready just as soon as I can prepare them."%"
						(self changeState: 2)
					)
					((> gLawyerState 7)
						(User canInput: 0)
						(Print 320 57) ; "It's nice to see you again, Roger."
						(Format @local0 320 58) ; ""So long, Larry!"%"
						(self changeState: 2)
					)
					(else
						(User canInput: 0)
						(Print 320 59) ; ""Aren't those divorce papers ready yet?" you ask Roger."
						(Format ; ""I'm glad you asked, Mr. Laffer! They're all set. Here you are. And, Ms. Cheatem told me to tell you it was a %s with you!"%"
							@local0
							320
							60
							(if (TestFlag 45)
								{business doing pleasure}
							else
								{pleasure doing business}
							)
							(if (TestFlag 45) {zusammen} else {Gins Gesch\84ft})
						)
						(= gLawyerState 8)
						(gEgo get: 10) ; Divorce_Decree
						(gGame changeScore: 20)
						(self changeState: 2)
					)
				)
			)
			((and (gEgo has: 7) (Said 'look,look/deed,land')) ; Land_Deed
				(event claimed: 0)
				(return)
			)
			((or (Said '//deed,land') (Said '/deed,land'))
				(cond
					((not (& (gEgo onControl:) $0020))
						(NotClose) ; "You're not close enough."
					)
					((and (!= gEgoState 0) (!= gEgoState 11))
						(NotNow) ; "Good idea. You might try that again later."
					)
					((!= local501 0)
						(Print 320 17) ; "The receptionist seems to be busy right now."
					)
					((== gLawyerState 0)
						(User canInput: 0)
						(Printf 320 61 global386 global387) ; ""Excuse me," you say, interrupting the man working at the counter. %s%"
						(Print 320 62) ; "It is my understanding that island custom dictates automatic transference of ownership of any lands in a couple's possession to the husband upon a divorce. I'd like to begin such a proceeding. Is there anyone here that could help me?"
						(Format @local0 320 63) ; ""Good day, sir. Certainly, you've made the right choice by coming to Dewey, Cheatem and Howe! Unfortunately, all of our attorneys are busy at this time. Could you please return in a few minutes?"%"
						(self changeState: 2)
					)
					((== gLawyerState 1)
						(User canInput: 0)
						(Printf 320 64 global386 global387) ; ""Excuse me," you say, interrupting the man working at the counter. %s%"
						(Print 320 65) ; "I'd like to talk to one of your attorneys about a real estate ownership transfer. Is there anyone available to help me?"
						(Format @local0 320 66) ; ""Good day, Mr. Laffer. Certainly Dewey, Cheatem and Howe is the right place for all your legal needs. At this time, Mr. Howe is taking depositions at the court hut and Mr. Dewey is tied up in court. However, Ms. Cheatem is readily available. Just walk through the door immediately behind me. I'll tell her you're here."%"
						(RoomScript changeState: 2)
						(self changeState: 2)
					)
					((< gLawyerState 3)
						(User canInput: 0)
						(Print 320 67) ; ""Is that deed ready?" you ask the clerk."
						(Format @local0 320 68) ; ""Ms. Cheatem has instructed me to prepare your land deed. I'll have it ready soon. Why don't you come back in a few minutes, Mr. Laffer."%"
						(self changeState: 2)
					)
					((> gLawyerState 3)
						(User canInput: 0)
						(Print 320 69) ; "Thanks a lot for that deed, Roger."
						(Format @local0 320 70) ; ""You're welcome, Mr. Laffer. But I bet you didn't come here just to exchange pleasantries with the hired help! How may I help you this time?"%"
						(self changeState: 2)
					)
					(else
						(User canInput: 0)
						(Print 320 71) ; ""Is that land deed ready yet?" you ask the clerk."
						(Format @local0 320 72) ; ""Absolutely, Mr. Laffer. Here it is. But, you know that land is so isolated from the main tourist areas you'll never be able to sell it to a developer. It's nothing but worthless forest land! No one could build a tourist trap there!!"%"
						(= gLawyerState 4)
						(gEgo get: 7) ; Land_Deed
						(gGame changeScore: 20)
						(self changeState: 2)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 2 2)
		(switch (= state newState)
			(0
				(aRoger cycleSpeed: 0 loop: 2 setCel: 0 setCycle: 0)
				(= local501 0)
				(= cycles 0)
				(= seconds (Random 3 6))
			)
			(1
				(if (== local501 0)
					(= local501 (Random 320 327))
				)
				(cond
					((!= local0 0)
						(self changeState: 2)
					)
					((== local501 320)
						(self changeState: 4)
					)
					((== local501 323)
						(self changeState: 6)
					)
					((== local501 321)
						(self changeState: 9)
					)
					(else
						(self changeState: 0)
					)
				)
			)
			(2
				(= local501 322)
				(aRoger loop: 3 setCycle: Fwd)
				(= cycles (Random 11 44))
			)
			(3
				(if (== local0 0)
					(switch (Random 1 5)
						(1
							(Format @local0 320 73) ; ""What are you waiting for? Go on in!"%"
						)
						(2
							(Format @local0 320 74) ; ""Don't you see I'm VERY busy!"%"
						)
						(3
							(Format @local0 320 75) ; ""Did I mention that I've been seeing quite a bit of Passionate Patti?"%"
						)
						(4
							(Format @local0 320 76) ; "He ignores you and returns to work.%"
						)
						(5
							(Format @local0 320 77) ; ""Can't you see I'm busy!"%"
						)
					)
				)
				(if (> (StrLen @local0) 400)
					(PrintSplit
						@local0
						67
						-1
						10
						80
						{Roger says}
						30
						1
						82
						321
						5
						0
					)
				else
					(Print
						@local0
						#at
						-1
						10
						#title
						{Roger says}
						#mode
						1
						#icon
						321
						5
						0
					)
				)
				(User canInput: 1)
				(if (== (RoomScript state:) 2)
					(RoomScript cue:)
				)
				(= local0 0)
				(= cycles 22)
				(= state -1)
			)
			(4
				(aRoger loop: 2 setCycle: Fwd cycleSpeed: 1)
				(= cycles (Random 9 19))
			)
			(5
				(aRoger setCel: 0)
				(= cycles (Random 9 19))
				(if (Random 0 2)
					(= state 3)
				else
					(= state -1)
				)
			)
			(6
				(aRoger cycleSpeed: 2 loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(= cycles (Random 9 19))
			)
			(8
				(aRoger setCycle: Beg self)
				(= state -1)
			)
			(9
				(aRoger cycleSpeed: 1 loop: 0 cel: 0 setCycle: End self)
			)
			(10
				(aRoger cycleSpeed: 1 loop: 1 setCycle: Fwd)
				(= cycles (Random 9 19))
			)
			(11
				(aRoger setCel: 0)
				(= cycles (Random 9 19))
				(if (Random 0 3)
					(= state 9)
				)
			)
			(12
				(aRoger loop: 0 setCel: 255 setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance atpSign of PV
	(properties
		y 125
		x 151
		view 320
		loop 1
		priority 9
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 320 922))
		(super init:)
	)
)

(instance atpDCHSign of PV
	(properties
		y 93
		x 151
		view 320
		priority 9
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 320 922))
		(super init:)
	)
)

(instance atpDeskStuff of PV
	(properties
		y 141
		x 165
		view 320
		loop 2
		priority 12
	)

	(method (init)
		(= view (LangSwitch 320 922))
		(super init:)
	)
)

(instance atpPencils of PV
	(properties
		y 136
		x 105
		view 320
		loop 2
		cel 1
		priority 12
	)

	(method (init)
		(= view (LangSwitch 320 922))
		(super init:)
	)
)

(instance atpFax of PV
	(properties
		y 142
		x 106
		view 320
		loop 4
		priority 12
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 320 922))
		(super init:)
	)
)

(instance aFax of Extra
	(properties
		y 133
		x 106
		view 320
		loop 5
	)

	(method (init)
		(= view (LangSwitch 320 922))
		(super init:)
		(self
			cycleType: 1
			pauseCel: -2
			minPause: 99
			maxPause: 999
			setPri: 12
			isExtra: 1
			ignoreActors:
			startExtra:
		)
	)
)

(instance aRoger of Prop
	(properties
		y 130
		x 146
		view 321
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 12 setScript: SecretaryScript)
	)
)

(instance aDoor of AutoDoor
	(properties
		y 39
		x 153
		view 320
		entranceTo 323
	)

	(method (init)
		(= view (LangSwitch 320 922))
		(super init:)
		(self setLoop: 3 setPri: 5)
	)
)

