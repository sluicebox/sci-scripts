;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 208)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Motion)
(use Actor)
(use System)

(public
	releaseGenie 0
)

(local
	local0
	local1
)

(instance releaseGenie of KQ5Room
	(properties
		picture 225
	)

	(method (init)
		(super init:)
		(HandsOff)
		(= local0 1)
		(= local1 1)
		(if (== global322 200)
			(witch
				view: 451
				loop: 0
				cel: 0
				cycleSpeed: 2
				posn: 150 126
				init:
				setScript: OpenBottle
			)
		else
			(gEgo
				normal: 0
				view: 102
				loop: 0
				cel: 0
				cycleSpeed: 2
				posn: 150 126
				init:
				setScript: OpenBottle
			)
			((gEgo head:) hide:)
		)
		(gGlobalSound number: 109 loop: -1 vol: 127 playBed:)
		(if (not (HaveMouse))
			(gGame setCursor: gTheCursor 1 164 162)
		)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(HandsOn)
		(super dispose:)
	)
)

(instance OpenBottle of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (genie loop:) 4)
				(or
					(and (== local0 1) (== (genie cel:) 3))
					(and (== local1 1) (== (genie cel:) 5))
				)
			)
			(gGlobalSound4 number: 76 loop: 1 vol: 127 play:)
			(if (== (genie cel:) 3)
				(= local0 0)
			)
			(if (== (genie cel:) 5)
				(= local1 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGlobalSound4 number: 75 loop: 1 vol: 127 play:)
				(client setCycle: End self)
			)
			(2
				(client loop: 1 cel: 0 setCycle: End)
				(= cycles 15)
			)
			(3
				(bottle
					view: 414
					loop: 1
					cel: 0
					posn: (+ (client x:) 9) (- (client y:) 2)
					init:
					stopUpd:
				)
				(client loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(client
					setLoop: 3
					cel: 0
					setCycle: Walk
					setMotion: MoveTo (- (bottle x:) 43) (+ (bottle y:) 7) self
				)
				(genie
					view: 400
					loop: 0
					cel: 0
					illegalBits: 0
					posn: (- (bottle x:) 2) (- (bottle y:) 18)
					cycleSpeed: 2
					setCycle: End self
					init:
				)
				(gGlobalSound4 number: 74 loop: 1 vol: 127 play:)
			)
			(5)
			(6
				(gGlobalSound4 stop:)
				(genie loop: 2 setCycle: Fwd)
				(Say 9112 0 1)
				(= seconds 7)
			)
			(7
				(cls)
				(genie loop: 3 cel: 0 setCycle: End self)
			)
			(8
				(gGlobalSound4 number: 73 loop: 1 vol: 127 play:)
				(genie
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (+ (genie x:) 20) (genie y:)
				)
				(client
					view: 414
					loop: 2
					cel: 0
					posn: (- (bottle x:) 1) (- (bottle y:) 19)
					setCycle: End self
				)
			)
			(9
				(client hide:)
				(bottle setCycle: End self)
			)
			(10
				(genie setLoop: 4 cel: 0 setCycle: End self)
			)
			(11
				(if (== global322 200)
					(bottle loop: 3 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(12
				(if (== global322 200)
					(= local0 1)
					(= local1 1)
					(genie setLoop: 4 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(13
				(genie setLoop: 5 cel: 0 setCycle: End self)
			)
			(14
				(= seconds 3)
			)
			(15
				(if (== global322 200)
					(gCurRoom newRoom: gPrevRoomNum)
				else
					(= global330 55)
					(EgoDead 257)
				)
			)
		)
	)
)

(instance genie of Actor
	(properties)
)

(instance witch of Actor
	(properties)
)

(instance bottle of Prop
	(properties
		view 414
	)
)

