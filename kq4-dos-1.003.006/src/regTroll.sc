;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 605)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	regTroll 0
)

(synonyms
	(dirt dirt dirt dirt dirt)
	(kiss kiss embrace)
	(troll troll troll troll troll man)
)

(local
	local0
	local1
	local2
	local3
)

(instance trollCaveMusic of Sound
	(properties
		number 66
		priority -1
	)
)

(instance caughtMusic of Sound
	(properties
		number 38
		priority 3
	)
)

(instance trollMusic of Sound
	(properties
		number 37
		priority 2
		loop -1
	)

	(method (play)
		(trollCaveMusic client: 0 stop:)
		(super play: &rest)
	)
)

(instance regTroll of Rgn
	(properties)

	(method (init)
		(if initialized
			(return)
		)
		(= keep 1)
		(if (gEgo has: 3) ; Lantern__unlit
			(Load rsVIEW 967)
		)
		(Load rsVIEW 904)
		(Load rsVIEW 190)
		(super init:)
		(= global189 1)
		(= local2 0)
		(= gTrollChasing 0)
		(= local1 0)
		(= local3 0)
		(trollCaveMusic owner: self init:)
		(trollMusic owner: self init:)
		(caughtMusic owner: self init:)
		(doMusic cue:)
	)

	(method (dispose)
		(if (== keep 0)
			(= global189 0)
			(super dispose:)
		)
	)

	(method (notify param1)
		(switch param1
			(2
				(gEgo view: 904)
				(theLight dispose:)
			)
			(3
				(gEgo view: 967)
				(theLight setLoop: 4 init:)
			)
			(1
				(gEgo view: 967)
				(theLight setLoop: 4 init:)
				(RedrawCast)
				(proc0_22 1)
			)
			(0
				(gEgo view: 904)
				(theLight dispose:)
				(cond
					(local3
						(gEgo dispose:)
						(RedrawCast)
					)
					((& (gEgo onControl: 0) $0002)
						(proc0_22 0)
					)
					(else
						(gEgo dispose:)
						(RedrawCast)
						(Print 605 0) ; "You have let your lantern go out. Death is surely close at hand..."
						(self setScript: gotchaScript)
					)
				)
			)
			(4
				(trollMusic client: 0 stop:)
				(if (IsObject local0)
					(local0 setMotion: 0 setScript: 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== script gotchaScript)
			(return)
		)
		(if (and (not (proc0_22)) (not (& (gEgo onControl: 0) $0002)))
			(gEgo dispose:)
			(RedrawCast)
			(Print 605 1) ; "It's too dark to see!"
			(self setScript: gotchaScript)
			(return)
		)
		(if (and (not (gCast contains: local0)) (== gTrollChasing 1))
			(trollScript changeState: 1)
		)
		(if (not local1)
			(= local1 1)
			(if
				(and
					(not gTrollChasing)
					(< (Random 0 100) 50)
					(!= gCurRoomNum 76)
					(!= gCurRoomNum 73)
				)
				(trollScript start: 0)
				(self setScript: trollScript)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= local1 0)
		(= local3 0)
		(cls)
		(if (and (!= newRoomNumber 77) (!= newRoomNumber 70) (not (gCast contains: local0)))
			(doMusic cue:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(= temp2
				(if (proc0_22)
					(gEgo has: 3) ; Lantern__unlit
				)
			)
			(cond
				((and (gEgo has: 3) (Said '/chandelier,lantern[<oil]>')) ; Lantern__unlit
					(cond
						((Said 'extinguish,(turn<off)')
							(self notify: 0)
						)
						((Said 'light,ignite,(turn<on)')
							(self notify: 1)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '<out[/cave]')
							(Print 605 2) ; "You cannot look outside from here."
						)
						((and temp2 (Said '[<in,at]/cave[<troll,dark]'))
							(Print 605 3) ; "The lantern you are carrying does little good in helping you to see in this dark cave."
						)
						((and temp2 (or (Said '/dirt') (Said '<down')))
							(Print 605 4) ; "The earth floor of the cave is cold and hard."
						)
						((and temp2 (Said '/passageway'))
							(Print 605 5) ; "Passageways lead into the darkness of this frightening cave!"
						)
						((Said '/troll')
							(Print 605 6) ; "You can't SEE the troll! It's too DARK in here!"
						)
						((gInventory saidMe:)
							(event claimed: 0)
						)
						(else
							(Print 605 7) ; "The cave is VERY dark. Try as you might, you cannot peer through the darkness."
							(event claimed: 1)
						)
					)
				)
				((or (Said 'climb/boulder') (Said 'get/boulder'))
					(Print 605 8) ; "It's difficult to see in here."
				)
				((Said 'find/troll')
					(Print 605 6) ; "You can't SEE the troll! It's too DARK in here!"
				)
				((gCast contains: local0)
					(cond
						((Said 'talk/troll')
							(Print 605 9) ; "Conversation is not recommended at this time!"
						)
						((Said 'kill/troll')
							(Print 605 10) ; "You have NO way of killing a vicious troll!"
						)
						((Said 'get,capture/troll')
							(Print 605 11) ; "BE SERIOUS!!"
						)
						((or (Said 'kiss/troll') (Said 'kiss[/!*]'))
							(Print 605 12) ; "Are you sure you're all right?"
						)
						(
							(and
								(Said 'give>')
								(= temp0 (gInventory saidMe:))
								(gEgo has: (gInventory indexOf: temp0))
							)
							(Print 605 13) ; "Trying to give ANYTHING to this nasty troll is not a good idea!!"
						)
					)
				)
			)
		)
	)
)

(instance trollScript of Script
	(properties)

	(method (doit)
		(if
			(and
				(gCast contains: local0)
				(< (self state:) 5)
				(< (gEgo distanceTo: local0) 5)
			)
			(self changeState: 5)
			(return)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local2)
					(= seconds 2)
				)
			)
			(1
				(if
					(and
						(not gTrollChasing)
						(or
							(== gCurRoomNum 71)
							(== gCurRoomNum 72)
							(== gCurRoomNum 74)
							(== gCurRoomNum 75)
						)
					)
					(Print 605 14 #at 200 50 #dispose) ; "GRRRRRRR!!"
					(= gTrollChasing 1)
					((= local0 (Act new:))
						view: 190
						setAvoider: Avoid
						illegalBits: 0
						xStep: 5
						yStep: 2
						init:
						setCycle: Walk
					)
					(switch gCurRoomNum
						(71
							(local0 posn: 230 96)
						)
						(72
							(local0 posn: 190 180)
						)
						(74
							(local0 posn: 73 166)
						)
						(75
							(local0 posn: 107 89)
						)
					)
					(trollCaveMusic client: 0 stop:)
					(trollMusic stop: loop: 1 play:)
				else
					(if (or (!= gTrollChasing 1) (== gCurRoomNum 73))
						(return)
					)
					((= local0 (Act new:))
						view: 190
						setAvoider: Avoid
						setCycle: Walk
						illegalBits: 0
						ignoreActors: 1
						xStep: 6
						yStep: 2
						init:
					)
					(cond
						((<= (gEgo heading:) 90)
							(local0
								posn: (- (gEgo x:) 30) (+ (gEgo y:) 10)
							)
						)
						((<= (gEgo heading:) 180)
							(local0
								posn: (- (gEgo x:) 10) (- (gEgo y:) 30)
							)
						)
						((<= (gEgo heading:) 270)
							(local0
								posn: (+ (gEgo x:) 30) (- (gEgo y:) 10)
							)
						)
						(else
							(local0
								posn: (+ (gEgo x:) 10) (+ (gEgo y:) 30)
							)
						)
					)
					(if (== gCurRoomNum 76)
						(switch (Random 0 1)
							(0
								(local0 xStep: 20 yStep: 4)
								(gSounds eachElementDo: #stop 0)
								(trollMusic loop: 1 play:)
							)
							(1
								(local0 hide:)
								(= local2 1)
								(self changeState: 7)
								(return)
							)
						)
					else
						(trollCaveMusic client: 0 stop:)
						(trollMusic client: 0 stop: loop: 1 play:)
					)
					(RedrawCast)
				)
				(if (not local2)
					(self cue:)
					(return)
				)
			)
			(2
				(if (gCast contains: local0)
					(local0
						moveSpeed: 1
						cycleSpeed: 1
						setMotion: Chase gEgo 55 self
					)
				else
					(self cue:)
				)
			)
			(3
				(Print 605 15 #time 4 #at 200 20 #dispose) ; "Watch out!"
				(self cue:)
			)
			(4
				(if (gCast contains: local0)
					(local0 setMotion: Chase gEgo 4 self)
				else
					(self cue:)
				)
			)
			(5
				(gotchaScript start: 1)
				(gCurRoom setScript: gotchaScript)
			)
		)
	)
)

(instance gotchaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cls)
				(trollCaveMusic client: 0 stop:)
				(trollMusic play:)
				(= seconds 5)
			)
			(1
				(HandsOff)
				(trollCaveMusic client: 0 stop:)
				(trollMusic client: 0 stop:)
				(caughtMusic play:)
				(cls)
				(Print 605 16 #at -1 20) ; "Oh, no! You have been caught by the vicious troll!"
				(= local3 1)
				(regTroll notify: 0)
				(Print 605 17 #at -1 20) ; "Fate be what it may, you are dragged off to meet it."
				(= seconds 4)
			)
			(2
				(= gDeathFlag 1)
			)
		)
	)
)

(instance theLight of Prop
	(properties
		view 967
		loop 4
	)

	(method (init)
		(self
			posn: (gEgo x:) (- (gEgo y:) 3)
			ignoreActors: 1
			setCycle: Fwd
			priority: (- (gEgo priority:) 1)
		)
		(super init:)
	)

	(method (doit)
		(self
			posn: (gEgo x:) (- (gEgo y:) 3)
			priority: (- (gEgo priority:) 1)
		)
		(super doit:)
	)
)

(instance doMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Timer setReal: self 2)
			)
			(1
				(trollCaveMusic loop: 1 playMaybe:)
			)
		)
	)
)

