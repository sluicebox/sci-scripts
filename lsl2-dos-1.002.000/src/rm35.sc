;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm35 0
)

(local
	work
	aSpinachDip
	dipHere
	goto95
	aBartender
	aTV
	aGirl1drinking
	aTitFeeler
	aGirl2drinking
	aGirl3drinking
	aManDrinking
	aShip
	aHench
	henchInvited
)

(instance rm35 of Rm
	(properties
		picture 35
		horizon 5
		south 31
	)

	(method (init)
		(Load rsVIEW 315)
		(Load rsVIEW 319)
		(super init:)
		(self setRegions: 300 setScript: rm35Script) ; rm300
		(if ((gInventory at: 13) ownedBy: gCurRoomNum) ; Spinach_Dip
			(= dipHere 1)
			((= aSpinachDip (View new:))
				ignoreActors:
				view: 315
				setLoop: 0
				setCel: 2
				setPri: 4
				posn: 94 79
				stopUpd:
				init:
			)
		else
			(self setRegions: 8) ; rm8
			(= gCurrentHenchView 316)
			(Load rsVIEW 316)
			((= aHench (Act new:))
				view: gCurrentHenchView
				posn: 155 233
				illegalBits: $8000
				setCycle: Walk
				init:
				setScript: henchScript
			)
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 5
			posn: 252 144
			setPri: 11
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 5
			posn: 319 123
			setPri: 11
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 6
			posn: 201 147
			setPri: 11
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 6
			posn: 277 137
			setPri: 11
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 6
			cel: 0
			posn: -7 62
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 4
			cel: 0
			posn: 0 127
			setPri: 11
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 5
			cel: 0
			posn: 39 132
			setPri: 11
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 1
			posn: 165 104
			setPri: 6
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 0
			posn: 165 79
			setPri: 2
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 3
			posn: 200 103
			setPri: 6
			addToPic:
		)
		((View new:)
			view: 315
			ignoreActors:
			loop: 0
			cel: 4
			posn: 227 101
			setPri: 6
			addToPic:
		)
		((= aBartender (Prop new:))
			view: 319
			ignoreActors:
			setLoop: 0
			setPri: 3
			posn: 183 68
			stopUpd:
			init:
		)
		((= aTV (Prop new:))
			view: 315
			ignoreActors:
			setLoop: 7
			setPri: 3
			posn: 162 42
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aGirl1drinking (Extra new:))
			view: 315
			loop: 1
			cel: 0
			posn: 313 100
			setPri: 7
			minPause: 20
			maxPause: 40
			minCycles: 5
			maxCycles: 10
			init:
		)
		((= aTitFeeler (Extra new:))
			view: 315
			loop: 2
			cel: 0
			posn: 121 104
			setPri: 6
			minPause: 20
			maxPause: 30
			minCycles: 5
			maxCycles: 8
			init:
		)
		((= aGirl2drinking (Extra new:))
			view: 315
			loop: 3
			cel: 0
			posn: 19 88
			setPri: 7
			minPause: 22
			maxPause: 50
			minCycles: 7
			maxCycles: 12
			init:
		)
		((= aGirl3drinking (Extra new:))
			view: 315
			loop: 4
			cel: 0
			posn: 66 144
			setPri: 11
			init:
		)
		((= aManDrinking (Extra new:))
			view: 315
			loop: 5
			cel: 0
			posn: 113 147
			setPri: 11
			minPause: 32
			maxPause: 70
			minCycles: 5
			maxCycles: 10
			init:
		)
		((= aShip (Act new:))
			view: 315
			illegalBits: 0
			ignoreActors:
			setLoop: 6
			setCel: 0
			setPri: 0
			setStep: 1 1
			moveSpeed: 1
			posn: 999 998
			init:
			setScript: shipScript
		)
		(NormalEgo)
		(gEgo posn: 157 157 init:)
	)
)

(instance rm35Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(if (== goto95 0)
				(gCurRoom newRoom: 31)
			else
				(Print 35 0) ; "You meet the lovely blond on the ship's stairs, quickly become dear friends, then head for the fantail where she parks her private helicopter. A romantic, moonlight chopper ride across the South Pacific is followed by an intriguing look at her impressive garage door, which looks suspiciously like a mountaintop waterfall."
				(Print 35 1) ; "Later, that night..."
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 95)
			)
		)
		(if (and gHenchOnScreen henchInvited (> (gEgo y:) 146))
			(= henchInvited 0)
			(= gCurrentStatus 23)
			(= goto95 1)
			(gCurRoom south: 95)
			(Print 35 2) ; "Hey, baby," you cry, "wait for me! I think I love ya!"
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and gHenchOnScreen (< (henchScript state:) 5) (Said '/woman>'))
			(cond
				((Said 'talk/')
					(Print (Format @gString 35 3 gLaffer)) ; ""Hi ya, beautiful," you tell her. %s Where'dja get that dress?"
				)
				((Said 'look/')
					(Print 35 4) ; "Too bad she couldn't afford to buy a complete dress!"
				)
				(else
					(Print 35 5) ; "She looks like she has something you need, Larry."
					(Print 35 6 #at -1 152) ; "(And vice versa.)"
				)
			)
		)
		(if (Said 'look>')
			(if (and gHenchOnScreen (Said '/woman'))
				(if (< (henchScript state:) 3)
					(Print 35 7) ; "A beautiful woman is entering the bar, and it looks like she's heading for you, Larry"
				else
					(Print 35 8) ; "BOING!"
				)
			)
			(if (Said '/agent')
				(Print 35 9) ; "He looks extremely bored."
			)
			(if (Said '/buffet,man,woman,children')
				(Print 35 10) ; "All of the tables are occupied by people enjoying themselves."
				(Print 35 11 #at -1 152) ; "(And they don't want to be bothered by you!)"
			)
			(if (Said '/cup,craft')
				(Print 35 12) ; "There's something moving out there!"
				(Print 35 13) ; "Oh, wait. That's just the ship; this room is revolving!"
			)
			(if (Said '/burn')
				(Print 35 14) ; "You've always loved black lights."
			)
			(if (Said '/computer,krod')
				(Print 35 15) ; "Shouldn't you turn off this computer if you're going to watch television?"
			)
			(if (Said '/bottle,bar')
				(if (== gCurrentStatus 1009)
					(Print 35 16) ; "The bartender is looking at you, expecting you to order a drink."
				else
					(Print 35 17) ; "There is a handsome bartender behind the bar and one empty stool in front of it."
				)
				(if dipHere
					(Print 35 18) ; "There is a complimentary bowl of spinach dip at the left end of the bar."
				)
			)
			(if (and dipHere (Said '/bowl,bread'))
				(Print 35 19) ; "The spinach dip resides in a bowl made of sourdough bread, and looks delicious."
			)
			(if (Said '[/airport]')
				(Print 35 20) ; "The ship's revolving nightclub has a television set behind the bar and only one empty stool."
				(if dipHere
					(Print 35 18) ; "There is a complimentary bowl of spinach dip at the left end of the bar."
				)
			)
		)
		(if (Said 'bath[/down,barstool]')
			(cond
				((== gCurrentStatus 1009)
					(YouAre) ; "You are."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(
					(and
						(not (gEgo inRect: 148 103 222 109))
						(not (gEgo inRect: 64 107 285 128))
					)
					(Print 35 21) ; "There's only one seat available to you, Larry: that empty stool at the bar."
				)
				(else
					(self changeState: 1)
				)
			)
		)
		(if (or (Said 'new,(get<up),new[/up]') (Said 'disembark[/barstool]'))
			(cond
				((== gCurrentStatus 0)
					(Print 35 22) ; "You'd better sit down first."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(self changeState: 4)
				)
			)
		)
		(if (Said 'talk/agent')
			(cond
				((== gCurrentStatus 0)
					(Print 35 22) ; "You'd better sit down first."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(Print (Format @gString 35 23 gLaffer)) ; ""Hi," you say to the bartender with a smile. %s"
					(Print 35 24) ; ""Thanks for telling me," he responds sarcastically."
					(Print 35 25 #at -1 152) ; "(Well, that didn't work Larry!)"
				)
			)
		)
		(if (Said 'talk/woman')
			(cond
				((== gCurrentStatus 0)
					(Print 35 22) ; "You'd better sit down first."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(Print (Format @gString 35 26 gLaffer)) ; ""Hi, you bevy of beautiful babes," you say to the women at the bar, flashing your best smile. %s"
					(Print 35 27) ; ""Why don't you join hands and try communicating with the living?" she asks sarcastically."
					(if (> gFilthLevel 10)
						(Print 35 28) ; ""What an asshole," she tells her friend."
					)
				)
			)
		)
		(if (Said 'talk')
			(Print 35 29) ; "There's no one here interested in talking to you. Perhaps you could talk to the bartender."
		)
		(if (or (Said 'give/me/beer') (Said 'buy/beer'))
			(cond
				((== gCurrentStatus 0)
					(Print 35 22) ; "You'd better sit down first."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(Print 35 30) ; "We're all out of that," says the bartender. "Would you like a mixed drink?"
				)
			)
		)
		(if (or (Said 'give/me/drink') (Said 'buy/drink'))
			(cond
				((== gCurrentStatus 0)
					(Print 35 22) ; "You'd better sit down first."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(self changeState: 6)
				)
			)
		)
		(if (and dipHere (Said 'eat/bread'))
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 73 100 106 104))
					(NotClose) ; "You're not close enough."
				)
				(else
					((gInventory at: 13) moveTo: -1) ; Spinach_Dip
					(aSpinachDip dispose:)
					(= dipHere 0)
					(gGame changeScore: -5)
					(Print 35 31 #at 15 -1 #width 280 #draw) ; "Ok. You dip a little sourdough bread into the mayonnaise-rich dip. Say! This is tasty. You ravenously devour the entire bowl, consuming approximately a quart of mayonnaise in the process and blowing your diet for the next month. Geez, Larry; you could have left a little for the other people here!"
				)
			)
		)
		(if (Said 'get/bread')
			(cond
				((== dipHere 0)
					(AlreadyTook) ; "You already took it."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 73 100 106 104))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 35 32) ; "You grab the loaf of french bread filled with spinach, mayonnaise and spices. Umm, good!"
					(gEgo get: 13) ; Spinach_Dip
					(gGame changeScore: 2)
					(aSpinachDip dispose:)
					(= dipHere 0)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= gCurrentStatus 1)
				(HandsOff)
				(Ok) ; "Ok."
				(gEgo setMotion: MoveTo 166 107 self)
			)
			(2
				(gEgo
					view: 104
					ignoreActors:
					illegalBits: 0
					setMotion: 0
					posn: 163 95
					setLoop: 0
					setPri: 6
					cel: 0
					setCycle: End self
				)
			)
			(3
				(= gCurrentStatus 1009)
				(if (and (== dipHere 0) (not (henchScript state:)))
					(henchScript changeState: 1)
				)
				(User canInput: 1)
			)
			(4
				(Ok) ; "Ok."
				(= gCurrentStatus 1)
				(HandsOff)
				(gEgo setLoop: 0 setMotion: 0 setCel: 255 setCycle: Beg self)
			)
			(5
				(gEgo posn: 164 106)
				(NormalEgo 3)
			)
			(6
				(= gCurrentStatus 1000)
				(HandsOff)
				(henchScript changeState: 255)
				(Print 35 33) ; ""Do you have any drinks with parasols and fruit?" you ask the bartender."
				(= seconds 3)
			)
			(7
				(Print 35 34) ; "But, of course," he replies, "allow me to fix you the speciality of the house..."
				(Print 35 35) ; ""Heavy on the pineapple, ok?" you ask."
				(Print 35 36) ; "No problem," he says. "Somehow, I would have guessed that!"
				(aBartender setLoop: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(aBartender setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(9
				(= seconds 2)
			)
			(10
				(aBartender setLoop: 2 cel: 0 cycleSpeed: 0 setCycle: End self)
				(gEgo setLoop: 1 cycleSpeed: 0 cel: 0 setCycle: End)
			)
			(11
				(aBartender stopUpd:)
				(Print 35 37) ; ""Here's to ya," you say to no one in particular."
				(gEgo setLoop: 2 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(12
				(gEgo cycleSpeed: 1 setLoop: 3 cel: 0 setCycle: End self)
			)
			(13
				(gEgo cycleSpeed: 0 setLoop: 4 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(14
				(Print 35 38) ; "Ah, ha! I gotcha, you Vicious Devil-Enemy of the People!!" cries the bartender, subtlely revealing himself as a member of the KGB. "How's that for 'extra pineapple,' you sap?"
				(= seconds 3)
			)
			(15
				(Print 35 39) ; "The bartender's mickey has the desired effect upon your central nervous system. You give the KGB no problems during transit to their local headquarters. We'll drop by there, just to see how you and they are getting along..."
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance shipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aShip
					setCel: (if (aShip cel:) 0 else 1)
					posn: -30 63
					setMotion: MoveTo 333 64 self
				)
			)
			(1
				(= cycles (Random 30 50))
				(= state -1)
			)
		)
	)
)

(instance henchScript of Script
	(properties)

	(method (changeState newState)
		(if (== gCurrentStatus 1000)
			(return)
		)
		(switch (= state newState)
			(1
				(= cycles (Random 50 100))
			)
			(2
				(if (!= gCurrentStatus 1009)
					(-- state)
					(= cycles (Random 50 100))
				else
					(aHench setMotion: MoveTo 157 107 self)
					(Notify 8 1)
					(= gHenchOnScreen 1)
				)
			)
			(3
				(aHench loop: 0)
				(Print 35 40 #draw #at -1 20) ; "Hello, studly," says the beautiful blond, "looking for a good time? Want to go to my place, instead of just hanging around here all alone?"
				(Print 35 41 #at -1 152) ; "(Geez, Larry. A real woman! Talking to you!!)"
				(= seconds 5)
			)
			(4
				(Print 35 42) ; "Come on, sweetheart, let's go someplace more private!"
				(aHench setMotion: MoveTo 155 234 self)
				(= henchInvited 1)
			)
			(5
				(= seconds 10)
			)
			(6
				(aHench dispose:)
				(= gCurrentHenchView 0)
				(= gHenchOnScreen 0)
				(= henchInvited 0)
			)
		)
	)
)

