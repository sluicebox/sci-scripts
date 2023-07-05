;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Door)
(use airplaneScript)
(use Interface)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm57 0
)

(local
	seenMessage
)

(instance rm57 of Rm
	(properties
		picture 57
		horizon 1
	)

	(method (init)
		(Load rsVIEW 525)
		(Load rsVIEW 511)
		(super init:)
		(gAddToPics add: aMom aSkater aPerson aMonitor doit:)
		(aPlane setLoop: 2 startX: -100 startY: 14 endX: 555 endY: 14 init:)
		(aDoor
			setLoop: 6
			setPri: 9
			entranceTo: 0
			doorCtrl: 0
			roomCtrl: 0
			init:
			locked: 1
			doorState: 0
			msgLook:
				{This door is controlled by the gentleman behind the counter. He'll unlock it for you if you'll show him a confirmed ticket for the next flight.}
			msgLookLock: {Right now, it's locked up tight!}
			msgLocked:
				{This door is controlled by the gentleman behind the counter. He'll unlock it for you if you'll show him a confirmed ticket for the next flight.}
			msgExcept: {Have the man at the desk open it for you!}
		)
		(aKid1
			setLoop: 2
			setPri: 10
			cycleSpeed: 1
			minPause: 20
			maxPause: 30
			minCycles: 11
			maxCycles: 33
			init:
		)
		(aKid2
			setLoop: 1
			setPri: 10
			cycleSpeed: 2
			minPause: 29
			maxPause: 100
			minCycles: 20
			maxCycles: 30
			init:
		)
		(aSidewalkNorth
			setLoop: 3
			setStep: 1 1
			setPri: 0
			illegalBits: 0
			init:
			setScript: sidewalkNorthScript
		)
		(aSidewalkSouth
			setLoop: 3
			setPri: 0
			setStep: 1 1
			illegalBits: 0
			init:
			setScript: sidewalkSouthScript
		)
		(= gCurrentStatus 8)
		(HandsOff)
		(gEgo
			illegalBits: 0
			setPri: -1
			setLoop: 3
			setCycle: 0
			setStep: 1 1
			posn: 196 233
			setCel: 0
			init:
		)
		(self setRegions: 500 setScript: rm57Script) ; rm500
	)

	(method (dispose)
		(DisposeScript 992)
		(super dispose:)
	)
)

(instance rm57Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl:) $0010)
				(self changeState: 2)
			)
			((& (gEgo onControl:) $0008)
				(if (and (== gCurrentStatus 0) (== seenMessage 0))
					(= seenMessage 1)
					(Print 57 0) ; ""Hey! Stay off that!" shouts the gate attendant."
				)
			)
			(else
				(= seenMessage 0)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if
			(or
				(Said 'give,finger,look/ticket/man,agent')
				(Said 'give,finger,look/agent,man/ticket')
				(Said 'give,finger,look,apply/ticket')
			)
			(cond
				((not (gEgo has: 23)) ; Airline_Ticket
					(DontHave) ; "You don't have it."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 185 140 244 152))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 57 1) ; "Here's my ticket," you say, handing your ticket folder to the gate attendant, "is this Gate #1?"
					(if (== gMissedPlane 1)
						(Print 57 2) ; "It certainly is," he replies, "but this ticket is for a flight that took off 30 seconds ago. Too bad you missed it!"
						(Print (Format @gString 57 3 gTritePhrase)) ; "Oh, well," says the gate attendant. "%s"
					else
						(self changeState: 4)
					)
				)
			)
		)
		(if (and (gEgo inRect: 185 140 244 152) (Said 'talk/man,agent'))
			(Print (Format @gString 57 4 gLaffer)) ; ""Good day, sir," you tell the gate attendant. %s"
			(if (not (gEgo has: 23)) ; Airline_Ticket
				(Print 57 5) ; "May I please purchase a ticket?"
				(Print 57 6) ; "He responds, "Tickets are only available at the front desk.""
			else
				(Print 57 7) ; "How nice for you," he responds. "Are you going to give me your ticket or did you ride that walkway just so we could have this stimulating conversation?"
			)
		)
		(if (Said 'get/pamphlet')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not ((gInventory at: 26) ownedBy: gCurRoomNum)) ; Pamphlet
					(Print 57 8) ; "Nah. One of these is enough!"
				)
				((not (gEgo inRect: 159 140 195 152))
					(NotClose) ; "You're not close enough."
				)
				(else
					(gEgo get: 26) ; Pamphlet
					(gGame changeScore: 11)
					(Print 57 9) ; "That's a good idea. Take a little free reading material to help you wile away your flight time! You grab a brochure from the display and shove it in your pocket, promising to read it when you get to your seat. It seems the perfect choice for a long, boring flight."
				)
			)
		)
		(if (Said 'look>')
			(if (Said '/man,agent')
				(Print 57 10) ; "The man by the window is totally absorbed by the fascinating baggage handlers."
				(Print 57 11) ; "But... behind the counter waits the man you came to see: the gate attendant."
			)
			(if (Said '/buffet')
				(if ((gInventory at: 26) ownedBy: gCurRoomNum) ; Pamphlet
					(Print 57 12) ; "There is a computer terminal that is out of order and a display of religious pamphlets on the left end of the counter."
				else
					(Print 57 13) ; "There is nothing else of interest on the counter."
				)
			)
			(if (Said '/pamphlet')
				(Print 57 14) ; "There is a display on the left end of the counter filled with religious tracts."
			)
			(if (Said '/children,woman')
				(if (> gFilthLevel 4)
					(Print 57 15) ; "That woman looks like she almost screwed herself out of a seat!"
				else
					(Print 57 16) ; "The woman seems quite busy with her children."
				)
			)
			(if (Said '/computer')
				(Print 57 17) ; "All flights are on time."
				(Print 57 18 #at -1 130) ; "(Remember: this IS a fantasy!)"
			)
			(if (Said '[/airport]')
				(Print 57 19) ; "There is an airline attendant waiting behind the counter, and a locked door that you presume leads to the jetway -- and your escape!"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCel: 0 setMotion: MoveTo 186 175 self)
			)
			(1
				(NormalEgo 3)
				(gEgo observeControl: 4 16384)
			)
			(2
				(= gCurrentStatus 8)
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 2
					setCel: 4
					setStep: 1 1
					setMotion: MoveTo 129 234 self
				)
			)
			(3
				(gCurRoom newRoom: 55)
			)
			(4
				(HandsOff)
				(gGame changeScore: 3)
				(Print 57 20) ; "It certainly is," says the gate attendant, "but if you want to take the flight listed on this ticket, you'd better hurry. I've already announced the final boarding call."
				(Print (Format @gString 57 21 gTritePhrase)) ; "The stewardess onboard will give you your seat assignment," says the gate attendant. "%s"
				(aDoor locked: 0 force: 1 open:)
				(SetRgTimer 0 0 0)
				(gEgo setMotion: MoveTo 151 145 self)
			)
			(5
				(gEgo setMotion: MoveTo 151 133 self)
			)
			(6
				(aDoor setCycle: Beg)
				(gEgo
					illegalBits: 0
					setPri: 5
					setMotion: MoveTo 199 133 self
				)
			)
			(7
				(gCurRoom newRoom: 58)
			)
		)
	)
)

(instance sidewalkNorthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSidewalkNorth setMotion: MoveTo 192 179 self)
			)
			(1
				(aSidewalkNorth posn: 192 221)
				(self changeState: 0)
			)
		)
	)
)

(instance sidewalkSouthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSidewalkSouth setMotion: MoveTo 135 202 self)
			)
			(1
				(aSidewalkSouth posn: 135 178)
				(self changeState: 0)
			)
		)
	)
)

(instance aMom of PV
	(properties
		y 140
		x 112
		view 525
		priority 10
	)
)

(instance aSkater of PV
	(properties
		y 160
		x 234
		view 525
		cel 1
		priority 11
	)
)

(instance aPerson of PV
	(properties
		y 130
		x 196
		view 525
		cel 3
		priority 10
		signal 16384
	)
)

(instance aMonitor of PV
	(properties
		y 111
		x 197
		view 525
		cel 2
		priority 10
		signal 16384
	)
)

(instance aPlane of Airplane
	(properties)
)

(instance aDoor of Door
	(properties
		y 137
		x 163
		view 525
		msgLook 0
		msgLookLock 18
		msgLocked 38
		msgExcept 59
		msgFunny 82
		msgCloser 102
	)
)

(instance aKid1 of Extra
	(properties
		y 130
		x 92
		view 525
	)
)

(instance aKid2 of Extra
	(properties
		y 139
		x 127
		view 525
	)
)

(instance aSidewalkNorth of Act
	(properties
		y 180
		x 192
		view 525
		cel 3
		signal 16384
	)
)

(instance aSidewalkSouth of Act
	(properties
		y 178
		x 135
		view 525
		cel 3
		signal 16384
	)
)

