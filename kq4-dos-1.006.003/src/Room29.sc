;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room29 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance fallSound of Sound
	(properties
		number 51
	)
)

(instance Room29 of Rm
	(properties
		picture 29
	)

	(method (init)
		(= north 23)
		(= south 5)
		(= east 30)
		(= west 28)
		(= horizon 100)
		(= gIndoors 0)
		(gEgo edgeHit: 0)
		(super init:)
		(if gNight
			(gCurRoom overlay: 129)
		)
		(self setRegions: 508) ; Forest_Region
		(if ((Inv at: 19) ownedBy: 206) ; Worm
			(Load rsVIEW 21)
			(Load rsVIEW 348)
		)
		(Load rsVIEW 17)
		(Load rsSOUND 51)
		(switch gPrevRoomNum
			(28
				(if (<= (gEgo y:) 156)
					(gEgo x: 1 y: 150)
				else
					(gEgo x: 1 y: 186)
				)
			)
			(30
				(if (<= (gEgo y:) horizon)
					(gEgo x: 318 y: (+ horizon 1))
				else
					(gEgo x: 318)
				)
			)
			(23
				(gEgo x: 264 y: (+ horizon 2))
			)
			(5
				(gEgo y: 188)
			)
			(0
				(gEgo x: 290 y: 160)
			)
		)
		(if (and (<= (Random 1 100) 50) ((Inv at: 19) ownedBy: 206)) ; Worm
			(= local3 (Act new:))
			(local3
				view: 348
				loop: 2
				cel: 0
				posn: 257 165
				setScript: birdActions
				setCycle: Fwd
				illegalBits: 0
				ignoreActors:
				ignoreHorizon:
				init:
			)
		)
		(gEgo init: view: 2)
		(gCurRoom setScript: wormActions)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= (= local0 (gEgo onControl: 0)) local7)
				(== (gEgo script:) 0)
				(== gNewRoomNum gCurRoomNum)
			)
			(= local7 local0)
			(if (& local0 $0004)
				(gCurRoom west: 0)
				(gEgo setScript: fallSouth)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gTimers eachElementDo: #dispose 84)
		(if ((Inv at: 19) ownedBy: 29) ; Worm
			((Inv at: 19) moveTo: 206) ; Worm
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'look/around')
						(Said 'look/room')
						(Said 'look[<around][/!*]')
					)
					(Print 29 0) ; "You are roaming through a dense forest."
				)
				((Said 'capture,get/earthworm')
					(if (gCast contains: local6)
						(if (< (gEgo distanceTo: local6) 15)
							(LookAt gEgo local6)
							(wormActions changeState: 10)
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 29 1) ; "You can't do that now."
					)
				)
				((Said 'look/crow,crow')
					(event claimed: 0)
				)
				((Said 'look/robin,bird')
					(cond
						((gCast contains: local3)
							(if (== (birdActions state:) 0)
								(Print 29 2) ; "A pretty robin pulls hungrily at a long earthworm."
							else
								(Print 29 3) ; "You see a bird flying away."
							)
						)
						((gCast contains: gRavenActor)
							(event claimed: 0)
						)
						(else
							(Print 29 4) ; "You don't see one here."
						)
					)
				)
				((Said 'talk/robin,bird')
					(if (== (birdActions state:) 0)
						(Print 29 5) ; "Cheep, cheep!"
					else
						(Print 29 6) ; "Not now."
					)
				)
				((Said 'kill/robin,bird')
					(Print 29 7) ; "Not a little robin!"
				)
				((Said 'capture,get,kiss/robin,bird')
					(if
						(or
							(gCast contains: local3)
							(gCast contains: gRavenActor)
						)
						(Print 800 1) ; "You're not close enough."
					else
						(Print 29 4) ; "You don't see one here."
					)
				)
				((Said 'help/robin,bird')
					(Print 29 8) ; "How can you do that, Rosella?"
				)
				((Said 'give')
					(if (gCast contains: local3)
						(Print 29 9) ; "The robin can't understand."
					else
						(Print 29 10) ; "There's no one here."
					)
				)
				((Said 'look/earthworm')
					(cond
						(
							(and
								(gCast contains: local3)
								((Inv at: 19) ownedBy: 206) ; Worm
								(== (birdActions state:) 0)
							)
							(Print 29 2) ; "A pretty robin pulls hungrily at a long earthworm."
						)
						(((Inv at: 19) ownedBy: 29) ; Worm
							(Print 29 11) ; "You see a fat worm wiggling on the ground."
						)
						((gEgo has: 19) ; Worm
							((Inv at: 19) showSelf:) ; Worm
						)
						(else
							(Print 29 4) ; "You don't see one here."
						)
					)
				)
				((Said 'look/dirt')
					(cond
						(((Inv at: 19) ownedBy: 29) ; Worm
							(Print 29 11) ; "You see a fat worm wiggling on the ground."
						)
						((and (== (birdActions state:) 0) (!= local3 0))
							(Print 29 2) ; "A pretty robin pulls hungrily at a long earthworm."
						)
						(else
							(Print 29 12) ; "You see nothing of importance."
						)
					)
				)
			)
		)
	)
)

(instance fallSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fallSound play:)
				(cond
					((> (gEgo x:) 100)
						(= local1 12)
					)
					((>= (gEgo x:) 65)
						(= local1 20)
					)
					(else
						(= local1 30)
					)
				)
				(if (> (+ (gEgo y:) local1) 188)
					(= local2 188)
				else
					(= local2 (+ (gEgo y:) local1))
				)
				(gEgo
					yStep: 6
					yStep: 6
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					setCel: 0
					view: 17
					setCycle: End
					setMotion: MoveTo (gEgo x:) local2 self
				)
			)
			(1
				(gEgo
					xStep: 3
					yStep: 2
					view: 21
					loop: 2
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo view: 21 loop: 2 setCycle: Beg self)
			)
			(3
				(HandsOn)
				(gCurRoom west: 28)
				(gEgo illegalBits: -32768 setCycle: Walk view: 2)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance birdActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gCast contains: local3)
				(< (local3 distanceTo: gEgo) 30)
				(== (local3 loop:) 2)
			)
			(if (gTimers contains: local4)
				(local4 dispose:)
			)
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 (Timer setReal: self 15))
			)
			(1
				(local3 cel: 255 loop: 3 setCycle: End self)
			)
			(2
				(= local6 (Prop new:))
				(local6
					view: 348
					setLoop: 0
					setCycle: Fwd
					ignoreActors:
					posn: (- (local3 x:) 8) (local3 y:)
					init:
				)
				(wormActions changeState: 1)
				(local3
					setPri: 12
					setLoop: 1
					xStep: 7
					yStep: 4
					setMotion: MoveTo 182 51 self
				)
			)
			(3
				(local3 setMotion: MoveTo 20 -6 self)
			)
			(4
				(local3 dispose:)
				(= local3 0)
			)
		)
	)
)

(instance wormActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local5 (Timer setReal: self 10))
				((Inv at: 19) moveTo: 29) ; Worm
			)
			(2
				(local6 dispose:)
				((Inv at: 19) moveTo: 206) ; Worm
			)
			(10
				(local5 dispose:)
				(HandsOff)
				(gEgo view: 21 setMotion: 0 setCycle: End self)
			)
			(11
				(local6 dispose:)
				(= local6 0)
				(gEgo setCycle: Beg self)
				(gEgo get: 19) ; Worm
				(gGame changeScore: 2)
				(= global182 1)
			)
			(12
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

