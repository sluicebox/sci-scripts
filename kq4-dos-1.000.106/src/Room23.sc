;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
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
	Room23 0
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
	local8
	local9
	local10
	local11
)

(instance Room23 of Rm
	(properties
		picture 23
		north 17
		east 24
		south 29
		west 22
	)

	(method (init)
		(= north 17)
		(= south 29)
		(= east 24)
		(= west 22)
		(= horizon 74)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(if gNight
			(= picture 123)
		)
		(super init:)
		(self setRegions: 508 501 512) ; Forest_Region, waterReg, riverReg
		(Load rsVIEW 17)
		(Load rsVIEW 18)
		(Load rsVIEW 21)
		(Load rsVIEW 21)
		(Load rsVIEW 348)
		(Load rsSOUND 51)
		(Load rsSOUND 80)
		(= local7 (Prop new:))
		(local7
			view: 654
			loop: 0
			cel: 0
			posn: 146 154
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(= local9 (Prop new:))
		(= local10 (Prop new:))
		(= local11 (Prop new:))
		(local9
			isExtra: 1
			view: 654
			loop: 2
			cel: 1
			posn: 75 157
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local10
			isExtra: 1
			view: 654
			loop: 3
			cel: 2
			posn: 101 165
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local11
			isExtra: 1
			view: 654
			loop: 4
			cel: 2
			posn: 224 116
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 1 (gEgo y:))
			)
			(east
				(gEgo x: 318)
				(if (<= (gEgo y:) 109)
					(gEgo y: 100)
				)
			)
			(north
				(gEgo posn: 120 (+ horizon 1))
			)
			(south
				(gEgo x: 106 y: 188)
			)
			(0
				(gEgo x: 180 y: 188)
			)
		)
		(= local6 (gEgo viewer:))
		(if (and (<= (Random 1 100) 50) ((Inv at: 19) ownedBy: 206)) ; Worm
			(= local2 (Act new:))
			(local2
				view: 348
				loop: 2
				cel: 0
				setScript: birdActions
				posn: 275 159
				setCycle: Fwd
				illegalBits: 0
				ignoreActors:
				ignoreHorizon:
				init:
			)
			(gEgo setScript: wormActions)
		)
		(gEgo init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= (= local0 (gEgo onControl:)) local1)
				(== (gCurRoom script:) 0)
			)
			(= local1 local0)
			(gEgo viewer: local6)
			(if (& local0 $0004)
				(self setScript: fallSouth)
			)
			(if (& local0 $1000)
				(self setScript: shortFall)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gTimers eachElementDo: #dispose 192)
		(if ((Inv at: 19) ownedBy: 23) ; Worm
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
					(Print 23 0) ; "You are walking through a forest thick with pine trees. A nearby river rushes westward from the distant mountain range. In the distance, you see a large house."
				)
				((Said 'look/cottage')
					(Print 23 1) ; "It's too far in the distance to see it clearly."
				)
				((Said 'capture,get/earthworm')
					(if (gCast contains: local5)
						(if (< (gEgo distanceTo: local5) 15)
							(LookAt gEgo local5)
							(wormActions changeState: 10)
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 23 2) ; "You can't do that now."
					)
				)
				((Said 'look/crow,crow')
					(event claimed: 0)
				)
				((Said 'look/robin,bird')
					(cond
						((gCast contains: local2)
							(if (== (birdActions state:) 0)
								(Print 23 3) ; "A pretty robin pulls hungrily at a long earthworm."
							else
								(Print 23 4) ; "You see a bird flying away."
							)
						)
						((gCast contains: gRavenActor)
							(event claimed: 0)
						)
						(else
							(Print 23 5) ; "You don't see one here."
						)
					)
				)
				((Said 'talk/robin,bird')
					(if (== (birdActions state:) 0)
						(Print 23 6) ; "Cheep, cheep!"
					else
						(Print 23 7) ; "Not now."
					)
				)
				((Said 'kill/robin,bird')
					(Print 23 8) ; "Not a little robin!"
				)
				((Said 'capture,get,kiss/robin,bird')
					(if
						(or
							(gCast contains: local2)
							(gCast contains: gRavenActor)
						)
						(Print 23 9) ; "You're not close enough."
					else
						(Print 23 5) ; "You don't see one here."
					)
				)
				((Said 'help/robin,bird')
					(Print 23 10) ; "How can you do that, Rosella?"
				)
				((Said 'give')
					(if (gCast contains: local2)
						(Print 23 11) ; "The robin can't understand."
					else
						(Print 23 12) ; "There's no one here."
					)
				)
				((Said 'look/earthworm')
					(cond
						(
							(and
								(gCast contains: local2)
								((Inv at: 19) ownedBy: 206) ; Worm
								(== (birdActions state:) 0)
							)
							(Print 23 3) ; "A pretty robin pulls hungrily at a long earthworm."
						)
						(((Inv at: 19) ownedBy: 23) ; Worm
							(Print 23 13) ; "You see a fat worm wiggling on the ground."
						)
						((gEgo has: 19) ; Worm
							((Inv at: 19) showSelf:) ; Worm
						)
						(else
							(Print 23 5) ; "You don't see one here."
						)
					)
				)
				((Said 'look/dirt')
					(cond
						(((Inv at: 19) ownedBy: 23) ; Worm
							(Print 23 13) ; "You see a fat worm wiggling on the ground."
						)
						(
							(and
								(== (birdActions state:) 0)
								(gCast contains: local2)
							)
							(Print 23 3) ; "A pretty robin pulls hungrily at a long earthworm."
						)
						(else
							(Print 23 14) ; "You see nothing of importance."
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
				((Sound new:) number: 51 loop: 1 play:)
				(gEgo
					viewer: 0
					yStep: 6
					yStep: 6
					illegalBits: 0
					loop: (& (gEgo loop:) $0001)
					setCel: 0
					view: 17
					setCycle: End
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 18) self
				)
			)
			(1
				(gEgo xStep: 2 yStep: 1 view: 18 loop: 0 setCycle: Fwd)
				(gSounds eachElementDo: #dispose)
				((Sound new:) number: 80 loop: 1 play:)
				(= seconds 4)
			)
			(2
				(gEgo view: 21 loop: 2 cel: 4 setCycle: Beg self)
			)
			(3
				(HandsOn)
				(gEgo illegalBits: -32768 setCycle: Walk view: 2)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance shortFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((Sound new:) number: 51 loop: 1 play:)
				(gEgo
					viewer: 0
					view: 17
					loop: (& (gEgo loop:) $0001)
					setCel: 0
					setStep: 6 6
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 11) self
				)
			)
			(1
				(gEgo view: 18 setStep: 2 1 loop: 0 setCycle: Fwd)
				(gSounds eachElementDo: #dispose)
				((Sound new:) number: 80 loop: 1 play:)
				(= seconds 4)
			)
			(2
				(gEgo view: 21 loop: 2 cel: 4 setCycle: Beg self)
			)
			(3
				(gEgo illegalBits: -32768 setCycle: Walk view: 2)
				(HandsOn)
				(gCurRoom setScript: 0)
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
				(gCast contains: local2)
				(< (local2 distanceTo: gEgo) 30)
				(== (local2 loop:) 2)
			)
			(if local3
				(local3 dispose:)
			)
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 (Timer setReal: self 15))
			)
			(1
				(local2 cel: 0 loop: 3 setCycle: End self)
			)
			(2
				(= local5 (Prop new:))
				(local5
					view: 348
					setLoop: 0
					setCycle: Fwd
					ignoreActors:
					posn: (- (local2 x:) 8) (local2 y:)
					init:
				)
				(wormActions changeState: 1)
				(local2
					setPri: 12
					setLoop: 1
					xStep: 7
					yStep: 4
					setMotion: MoveTo 182 51 self
				)
			)
			(3
				(local2 setMotion: MoveTo 20 -6 self)
			)
			(4
				(local2 dispose:)
				(= local2 0)
			)
		)
	)
)

(instance wormActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local4 (Timer setReal: self 12))
				((Inv at: 19) moveTo: 23) ; Worm
			)
			(2
				(local5 dispose:)
				((Inv at: 19) moveTo: 206) ; Worm
			)
			(10
				(HandsOff)
				(local4 dispose:)
				(gEgo view: 21 setCycle: End self)
			)
			(11
				(local5 dispose:)
				(= local5 0)
				(gEgo setCycle: Beg self)
				(gEgo get: 19) ; Worm
				(= global182 1)
				(gGame changeScore: 2)
			)
			(12
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

