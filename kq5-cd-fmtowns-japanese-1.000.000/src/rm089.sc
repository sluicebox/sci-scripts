;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 89)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use Motion)
(use Actor)
(use System)

(public
	rm089 0
)

(local
	local0
	[local1 9] = [1000 120 114 4 11 24 19 23 30]
	[local10 9] = [1003 120 114 4 11 25 23 31 31]
)

(instance rm089 of KQ5Room
	(properties
		picture 89
	)

	(method (init)
		(super init:)
		(HandsOff)
		(cond
			((== gPrevRoomNum 51)
				(gEgo
					view: 128
					posn: 156 157
					setStep: 1 1
					setCycle: Fwd
					init:
				)
				((gEgo head:) hide:)
				(self setScript: getEaten)
			)
			((== gPrevRoomNum 113) ; hermit4
				(self setRegions: 763 setScript: timedMess) ; cartoonRegion
			)
			(else
				(boat
					posn: 170 201
					setLoop: 0
					setStep: 1 1
					moveSpeed: 1
					setCycle: Fwd
					init:
				)
				(self setScript: crash)
			)
		)
		(gGlobalSound number: 833 loop: 1 vol: 127 play:)
		(smoke1 init:)
		(smoke2 init:)
		(lava1 init:)
		(if (!= (gGame detailLevel:) 3)
			(smoke1 setCycle: 0 stopUpd:)
			(smoke2 setCycle: 0 stopUpd:)
			(lava1 setCycle: 0 stopUpd:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((not local0)
				(++ local0)
				(gEgo setScript: timedMess)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
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
		(super dispose:)
	)
)

(instance timedMess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 411 0 1)
				(proc0_15 (Format @global185 89 0)) ; "A few hours later....."
				(= seconds 8)
			)
			(1
				(proc0_15 0)
				(client setScript: crash)
			)
		)
	)
)

(instance crash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boat
					posn: 170 220
					setLoop: 0
					setStep: 1 1
					moveSpeed: 2
					setCycle: Fwd
					cycleSpeed: 3
					setMotion: MoveTo 156 170 self
					init:
				)
			)
			(1
				(if (not (IsFlag 55))
					(proc762_1 @local1 3090)
				)
				(= cycles 1)
			)
			(2
				(if (not (IsFlag 55))
					(proc762_1 @local10 7036)
				)
				(= cycles 1)
			)
			(3
				(boat
					setLoop: 4
					cel: 0
					setMotion: MoveTo 156 167
					setCycle: End self
				)
				(gGlobalSound3 number: 791 loop: 1 vol: 127 play:)
			)
			(4
				(boat
					setMotion: MoveTo 156 163
					setLoop: 5
					cel: 0
					cycleSpeed: 3
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(5
				(client setScript: 0)
				(gGlobalSound fade:)
				(gCurRoom newRoom: 51)
			)
		)
	)
)

(instance getEaten of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 128
					setLoop: 4
					setCycle: Fwd
					cycleSpeed: 1
					setStep: 1 1
					moveSpeed: 4
					setMotion: MoveTo 156 170 self
				)
			)
			(1
				(killer
					init:
					posn: 147 170
					loop: 10
					cel: 6
					cycleSpeed: 3
					setCycle: Beg self
				)
				(gEgo dispose:)
			)
			(2
				(killer loop: 6 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(3
				(killer loop: 10 cel: 0 setCycle: End self)
			)
			(4
				(= global330 9058)
				(EgoDead 260)
			)
		)
	)
)

(instance cartoon of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(self setScript: crash)
			)
		)
	)
)

(instance boat of Actor
	(properties
		view 620
		cel 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Print 89 1)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance smoke1 of Prop
	(properties
		x 136
		y 10
		view 662
		loop 3
		cel 1
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 3 setCycle: Fwd)
	)
)

(instance smoke2 of Prop
	(properties
		x 185
		y 29
		view 662
		loop 4
		cel 1
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 3 setCycle: Fwd)
	)
)

(instance lava1 of Prop
	(properties
		x 172
		y 84
		view 662
		loop 5
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 3 setCycle: Fwd)
	)
)

(instance killer of Prop
	(properties
		view 620
		loop 8
	)
)

