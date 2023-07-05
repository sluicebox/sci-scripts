;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use LoadMany)
(use Sight)
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
		(self setRegions: 302) ; washington
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
			((Said 'look[<at,around][/room,scene]')
				(Print 22 0) ; "Arriving in "the playground for tourists", it's too bad you're here for serious business."
			)
			((Said 'look/airport')
				(Print 22 1) ; "Honolulu International Airport."
			)
			((Said 'look/car')
				(Print 22 2) ; "Your car, which will carry you to the USS Blackhawk."
			)
			((Said 'open/door')
				(Print 22 3) ; "Your driver will do that for you."
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
			((Said '[/man,driver]>')
				(cond
					((Said 'look')
						(Print 22 4) ; "Your driver, who will take you to the USS Blackhawk."
					)
					((Said 'salute')
						(Print 22 5) ; "He is just a limo driver!"
					)
					((Said 'talk')
						(Print 22 6) ; "I'm here to pick up Commander Westland," he says. "Are you Commander Westland?"
						(self setScript: driverResponseScript)
					)
				)
			)
			((Said 'show/order')
				(Print 22 6) ; "I'm here to pick up Commander Westland," he says. "Are you Commander Westland?"
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
					(Print 22 7) ; "Yes, what?"
				)
			)
			((Said 'show/id,order')
				(Print 22 8) ; "Please answer the question first."
			)
			((Said 'no')
				(gCurRoom setScript: endOfGameScript 0 0)
			)
		)
	)
)

(instance showIdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 22 9) ; ""May I see your orders please," He says."
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
					(Print 22 10) ; "You show the driver your orders from the Pentagon. He looks them over then returns them to you."
					(self cue:)
				else
					(switch (Random 0 1)
						(0
							(Print 22 11) ; "You search frantically but can't seem to find your orders."
						)
						(1
							(Print 22 12) ; "Aware you're missing the orders, the driver says, "I'm sorry, Sir, but I can't take you into a classified area without the proper papers.""
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

	(method (changeState)
		(if register
			(EgoDead 918 0 0 22 13) ; "Your orders... don't leave home without them!"
		else
			(EgoDead 918 0 0 22 14) ; "Don't lie to him, he's only doing his job."
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
				(Print 22 15) ; "You settle back for the short drive to Pearl Harbor."
				(Print 22 16) ; "After passing several security checks, you arrive at the pier where the USS Blackhawk is tied up."
				(Print 22 17) ; "You change into your uniform and stow your personal belongings in preparation for boarding."
				(gEgo put: 6 3) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
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

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((IsOffScreen self))
			((Said 'look[<at][/airplane,airplane,jet]')
				(Print 22 18) ; "Looks like it's about to land."
			)
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

