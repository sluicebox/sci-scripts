;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	honoluluAirportRm 0
)

(instance honoluluAirportRm of Rm
	(properties
		picture 22
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 22 17)
		(gIceGlobalSound number: 84 owner: gGame priority: 1 loop: -1 play:)
		(gEgo init: posn: 190 169 setScript: walkToDriverScript)
		(plane init:)
		(slidingDoor init:)
		(driver init:)
		(doorProp init:)
		(gAddToPics add: alohaSignPic limoPic doit:)
	)

	(method (dispose)
		(gIceGlobalSound fade:)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<around]')
				(Print 22 0) ; "Arriving in "The playground for tourists", it's too bad you're here for serious bussiness."
			)
		)
	)
)

(instance walkToDriverScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (driver x:) 30) (+ (driver y:) 2) self
				)
			)
			(1
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance driver of Act
	(properties
		y 164
		x 60
		view 22
		loop 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk[/man]')
				(Print 22 1) ; "I'm here to pick up Commander Westland," he says. "Are you Commander Westland?"
				(self setScript: driverResponseScript)
			)
		)
	)
)

(instance driverResponseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gCurRoom setScript: newRoomScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'yes')
				(if (== state 0)
					(self setScript: showIdScript self)
				else
					(Print 22 2) ; "Yes what?"
				)
			)
			((Said 'show/id,order')
				(Print 22 3) ; "Please answer the question first."
			)
			((Said 'no')
				(gCurRoom setScript: endOfGameScript 0 1)
			)
		)
	)
)

(instance showIdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 22 4) ; ""May I see your orders please?" He says."
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'show/order') (Said 'yes'))
				(if (gEgo has: 0) ; Envelope
					(Print 22 5) ; "You show the driver your orders from the Pentagon. He looks them over then returns them to you."
					(self cue:)
				else
					(switch (Random 0 1)
						(0
							(Print 22 6) ; "You search frantically but can't seem to find your orders."
						)
						(1
							(Print 22 7) ; "Being aware you're missing the orders, the driver says, "I'm sorry sir, but I can't take you into a classified area without the proper papers.""
						)
					)
					(gCurRoom setScript: endOfGameScript 0 1)
				)
			)
		)
	)
)

(instance endOfGameScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 0)
					(EgoDead 918 0 0 22 8) ; "Don't lie to him, he's only doing his job."
				else
					(EgoDead 918 0 0 22 9) ; "Your orders... don't leave home without them!"
				)
			)
		)
	)
)

(instance newRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(driver setCycle: End self)
			)
			(1
				(driver
					loop: 5
					setPri: (- (doorProp priority:) 1)
					setCycle: End self
				)
				(doorProp show: setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(gCurRoom drawPic: 101 setScript: messageLeavePearlScript)
			)
		)
	)
)

(instance messageLeavePearlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(Print 22 10) ; "You settle back for the short drive to Pearl Harbor."
				(Print 22 11) ; "After passing several security checks, you arrive at the pier where the USS Blackhawk is tied up."
				(HandsOn)
				(gCurRoom newRoom: 23) ; pierRm
			)
		)
	)
)

(instance slidingDoor of Prop
	(properties
		y 171
		x 155
		view 22
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 14 ignoreActors: stopUpd:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			((and (< (= temp0 (gEgo distanceTo: self)) 45) (not cel))
				(self setCycle: End self)
			)
			((and (>= temp0 45) cel)
				(self setCycle: Beg self)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance plane of Act
	(properties
		view 17
		loop 5
	)

	(method (init)
		(super init:)
		(self
			setLoop: loop
			ignoreControl: -32768
			setScript: planeScript
			stopUpd:
		)
	)
)

(instance planeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(plane posn: -5 7 setMotion: MoveTo 340 7 self)
			)
			(2
				(client stopUpd:)
				(= seconds (Random 20 40))
			)
			(3
				(self init: client)
			)
		)
	)
)

(instance alohaSignPic of PV
	(properties
		y 189
		x 289
		view 22
	)
)

(instance limoPic of PV
	(properties
		y 189
		x 34
		view 22
		loop 2
	)
)

(instance doorProp of Prop
	(properties
		y 157
		x 42
		view 22
		loop 3
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd: hide:)
	)

	(method (cue)
		(self hide: stopUpd:)
	)
)

