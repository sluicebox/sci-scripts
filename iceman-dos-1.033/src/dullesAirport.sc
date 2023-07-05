;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use n954)
(use Track)
(use Follow)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	dullesAirport 0
)

(instance dullesAirport of Rm
	(properties
		picture 17
		vanishingX 154
		vanishingY 35
	)

	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self setRegions: 302) ; washington
		(Load rsVIEW 204 17 417)
		(gEgo
			view: 204
			posn: 210 175
			init:
			setMotion: MoveTo 210 145
			setScript: keepOutOfAirportScript
		)
		(DirLoop gEgo 0)
		(gIceGlobalSound number: (proc0_5 64) priority: 1 loop: -1 play: planeScript)
		(plane init:)
		(slidingDoor1 init:)
		(slidingDoor2 init:)
		(limo init: hide: setScript: limoScript)
	)

	(method (cue)
		(if script
			(script cue:)
		else
			(self newRoom: 18) ; pentagonFront
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,airport]')
				(Print 17 0) ; "This is the main entrance to Dulles Airport."
			)
			((Said 'look[<at,through,out]/shutter')
				(Print 17 1) ; "Looking through the window, you see part of the city in the distance."
			)
			((Said 'look[<up,down,at][/floor,ceiling,wall]')
				(proc0_36) ; "You see nothing special."
			)
		)
	)
)

(instance keepOutOfAirportScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gEgo onControl: 1) 16384)
			(if (not register)
				(switch (Random 0 3)
					(0
						(Print 17 2) ; "You don't need to enter the airport."
					)
					(1
						(Print 17 3) ; "Your destiny lies in the other direction."
					)
					(2
						(Print 17 4) ; "No time for back-tracking."
					)
					(3
						(Print 17 5) ; "Nothing can be accomplished by going back into the airport."
					)
				)
				(= register 1)
			)
		else
			(= register 0)
		)
	)
)

(instance limoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 14)
			)
			(1
				(limo show: setMotion: MoveTo 139 124 self)
			)
			(2
				(limo stopUpd:)
				(driver init: ignoreControl: -32768 setScript: driverScript)
			)
			(3
				(limo setMotion: MoveTo 370 124 self)
			)
			(4
				(gIceGlobalSound fade: gCurRoom)
				(= seconds 4)
			)
			(5
				(gCurRoom cue:)
			)
		)
	)
)

(instance driverScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(driver setPri: 7 setMotion: MoveTo 219 118 self)
			)
			(1
				(driver setPri: -1 setMotion: MoveTo 222 130 self)
			)
			(2
				(= register 1)
			)
			(3
				(Print 17 6) ; "The driver asks you, "Are you Commander Westland?""
				(driver setScript: waitForResponseScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((< state 2))
			((GoToIfSaid client event client 15 'show,give/id,card' 17 7)
				(= register 0)
			)
			((Said 'show,give/id,card')
				(if (gEgo has: 2) ; ID_Card
					(getEgoIdScript start: 1)
					(driver setScript: getEgoIdScript)
				else
					(Print 17 8) ; "You forgot your id card on the island."
					(gCurRoom setScript: endOfGameScript)
					(driver setScript: driverBackScript)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and register (< (client distanceTo: gEgo) 20))
			(self cue:)
			(gEgo setMotion: 0)
			(= register 0)
		)
	)
)

(instance waitForResponseScript of Script
	(properties)

	(method (handleEvent)
		(cond
			((Said 'yes')
				(driver setScript: getEgoIdScript)
			)
			((Said 'no')
				(driver setScript: driverBackScript)
				(gCurRoom setScript: notWestlandScript)
			)
			((Said 'show,give/id,card')
				(if (gEgo has: 2) ; ID_Card
					(getEgoIdScript start: 1)
					(driver setScript: getEgoIdScript)
				else
					(Print 17 8) ; "You forgot your id card on the island."
					(gCurRoom setScript: endOfGameScript)
					(driver setScript: driverBackScript)
				)
			)
			((Said 'talk/man')
				(Print 17 6) ; "The driver asks you, "Are you Commander Westland?""
			)
		)
	)
)

(instance endOfGameScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(EgoDead 918 0 0 17 9) ; "Since you have lost your ride, you have no alternative other than starting the game over, or restoring a previous save game."
			)
		)
	)
)

(instance notWestlandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(Print 17 10) ; "For the purpose of this game you are, in fact, Commander Westland."
				(gCurRoom setScript: endOfGameScript cue:)
			)
		)
	)
)

(instance driverBackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(driver setLoop: -1 setMotion: MoveTo 219 118 self)
			)
			(1
				(driver setPri: 7 setMotion: MoveTo 147 118 self)
			)
			(2
				(driver setMotion: MoveTo 147 127 self)
			)
			(3
				(driver setLoop: 8 setCel: 0 posn: 145 97 setCycle: End self)
			)
			(4
				(driver y: 0 dispose:)
				(limo cue:)
			)
		)
	)
)

(instance getEgoIdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 17 11) ; ""It is my responsibility to look at your identification, sir," he says."
			)
			(1
				(Print 17 12) ; "You show the driver your military identification card.  He examines it closely, thanks you as he returns it, and says..."
				(User canInput: 1)
				(Print 17 13) ; "Please have a seat, Commander."
				(gGame changeScore: 1)
				(= seconds 1)
			)
			(2
				(gCurRoom setScript: getInLimoScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'show,give/id,card')
				(if (gEgo has: 2) ; ID_Card
					(if (== state 0)
						(self cue:)
					)
				else
					(Print 17 8) ; "You forgot your id card on the island."
					(gCurRoom setScript: endOfGameScript)
					(driver setScript: driverBackScript)
				)
			)
			((Said 'talk')
				(Print 17 14) ; "May I please see your ID, Sir?"
			)
		)
	)
)

(instance getInLimoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 202 133 self
				)
			)
			(1
				(gEgo
					setMotion: MoveTo (- (limo x:) 49) (+ (limo y:) 7) self
				)
				(driver
					illegalBits: 0
					ignoreActors:
					setMotion: Follow gEgo 40
					setLoop: 5
				)
			)
			(2
				(driver setMotion: MoveTo (- (limo x:) 34) (+ (limo y:) 7) self)
			)
			(3
				(driver setLoop: 6 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(gEgo view: 417 setLoop: 7 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(gEgo y: 0 dispose:)
				(driver setCycle: Beg self)
			)
			(6
				(driver
					setLoop: 4
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 222 130 self
				)
			)
			(7
				(driver setScript: driverBackScript)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance limo of Act
	(properties
		y 124
		x -50
		view 17
		loop 2
	)

	(method (init)
		(self setLoop: 2 ignoreControl: -32768 stopUpd: setPri: -1)
		(super init:)
		(if global132
			(wheel1 ignoreControl: -32768 illegalBits: illegalBits init:)
			(wheel2 ignoreControl: -32768 illegalBits: illegalBits init:)
			(flag ignoreControl: -32768 illegalBits: illegalBits init:)
		)
	)

	(method (setMotion)
		(super setMotion: &rest)
		(if global132
			(wheel1 setCycle: Walk setMotion: Track limo -47 6)
			(wheel2 setCycle: Walk setMotion: Track limo 48 6)
			(flag setCycle: Walk setMotion: Track limo -67 -16)
		)
	)

	(method (show)
		(super show:)
		(if global132
			(wheel1 show:)
			(wheel2 show:)
			(flag show:)
		)
	)

	(method (hide)
		(super hide:)
		(if global132
			(wheel1 hide:)
			(wheel2 hide:)
			(flag hide:)
		)
	)

	(method (stopUpd)
		(super stopUpd:)
		(if global132
			(wheel1 stopUpd:)
			(wheel2 stopUpd:)
			(flag stopUpd:)
		)
	)

	(method (startUpd)
		(super startUpd:)
		(if global132
			(wheel1 startUpd:)
			(wheel2 startUpd:)
			(flag startUpd:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'call/cab[/cab]')
				(cond
					((& signal $0008)
						(Print 17 15) ; "Your ride will be here shortly."
					)
					((OneOf (script state:) 3 4)
						(Print 17 16) ; "You missed your ride."
					)
					(else
						(Print 17 17) ; "Use the limo."
					)
				)
			)
			((Said '[/limo,car]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (& (limo signal:) $0008)
							(Print 17 18) ; "You don't see any cars at the moment."
						else
							(Print 17 19) ; "A large black limo with dark windows."
						)
					)
				)
			)
		)
	)
)

(instance driver of Act
	(properties
		y 118
		x 147
		view 417
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/driver,man]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 17 20) ; "This is your driver."
					)
				)
			)
		)
	)
)

(instance wheel1 of Act
	(properties
		view 17
		loop 4
	)

	(method (init)
		(self setLoop: 4 ignoreActors: setPri: 8)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/tire,wheel]>')
				(cond
					((not y))
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 17 21) ; "Although a little worn, these tires should be all right for a while, unless this is the limo for the Sierra company Christmas party."
					)
				)
			)
		)
	)
)

(instance wheel2 of Act
	(properties
		view 17
		loop 4
	)

	(method (init)
		(self setLoop: 4 ignoreActors: setPri: 8)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/tire,wheel]>')
				(cond
					((not y))
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 17 21) ; "Although a little worn, these tires should be all right for a while, unless this is the limo for the Sierra company Christmas party."
					)
				)
			)
		)
	)
)

(instance flag of Act
	(properties
		view 17
		loop 3
	)

	(method (init)
		(self setLoop: 3 ignoreActors: setPri: 6)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/flag]>')
				(cond
					((not y))
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 17 22) ; "Old Glory, long may she wave!"
					)
				)
			)
		)
	)
)

(instance slidingDoor1 of Act
	(properties
		y 137
		x 93
		view 17
	)

	(method (init)
		(super init:)
		(self ignoreActors: ignoreControl: -32768 setPri: 10 setLoop: stopUpd:)
		(auxDoor1
			init:
			setLoop:
			ignoreActors:
			ignoreControl: -32768
			setPri: 10
			stopUpd:
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (not (InRect 45 120 170 160 gEgo)) (== x 64))
				(slidingDoor1 setMotion: MoveTo 93 137 self)
				(auxDoor1 setMotion: MoveTo 148 137 auxDoor1)
			)
			((and (InRect 48 124 165 154 gEgo) (== x 93))
				(slidingDoor1 setMotion: MoveTo 64 137 self)
				(auxDoor1 setMotion: MoveTo 177 137 auxDoor1)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look')
						(Print 17 23) ; "Typical sliding doors."
					)
					((Said 'open')
						(Print 17 24) ; "The doors open automatically when you walk near them."
					)
					((Said 'close')
						(Print 17 25) ; "The doors close automatically when you walk away from them."
					)
				)
			)
		)
	)
)

(instance auxDoor1 of Act
	(properties
		y 137
		x 148
		view 17
		loop 1
		priority 10
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance slidingDoor2 of Act
	(properties
		y 137
		x 175
		view 17
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 10 ignoreControl: -32768 setLoop: stopUpd:)
		(auxDoor2
			ignoreActors:
			setPri: 10
			ignoreControl: -32768
			init:
			setLoop:
			stopUpd:
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (not (InRect 120 120 290 160 gEgo)) (== x 146))
				(self setMotion: MoveTo 175 137 self)
				(auxDoor2 setMotion: MoveTo 230 137 auxDoor2)
			)
			((and (InRect 130 124 284 154 gEgo) (== x 175))
				(self setMotion: MoveTo 146 137 self)
				(auxDoor2 setMotion: MoveTo 259 137 auxDoor2)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look')
						(Print 17 23) ; "Typical sliding doors."
					)
					((Said 'open')
						(Print 17 24) ; "The doors open automatically when you walk near them."
					)
					((Said 'close')
						(Print 17 25) ; "The doors close automatically when you walk away from them."
					)
				)
			)
		)
	)
)

(instance auxDoor2 of Act
	(properties
		y 137
		x 230
		view 17
		loop 1
		priority 10
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance plane of Act
	(properties
		yStep 1
		view 17
		loop 5
		signal 2048
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: planeScript)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not (OneOf (script state:) 2 3)))
			((TurnIfSaid self event 'look[<at]/airplane,airplane,jet'))
			((Said 'look[<at][/airplane,airplane,jet]')
				(Print 17 26) ; "Looks like it's about to land."
			)
		)
	)
)

(instance planeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds 3)
			)
			(2
				(plane
					posn: 26 53
					setMotion: MoveTo 300 (+ 60 (Random 0 14)) self
				)
			)
			(3
				(self init: client)
			)
		)
	)
)

