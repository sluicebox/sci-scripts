;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use CodeCue)
(use KQ5Room)
(use RandCycle)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm042 0
)

(local
	local0
	[local1 9] = [1028 180 62 3 9 26 24 32 32]
)

(instance rm042 of KQ5Room
	(properties
		picture 42
		south 43
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 824 loop: -1 vol: 127 playBed:)
		(locket setCycle: Fwd cycleSpeed: 3 init:)
		(self setFeatures: egg nest)
		(User canControl: 0 canInput: 1)
		(gGame setCursor: gTheCrownCursor)
		(gTheIconBar enable:)
		(gEgo normal: 0 view: 604 loop: 0 posn: 195 125 init:)
		((gEgo head:) hide:)
		(self setScript: hatch)
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
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance hatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 45)
			)
			(1
				(babyRoc1
					cycleSpeed: (if (== gHowFast 0) 10 else 20)
					setCycle: End self
					init:
				)
				(babyRoc2
					cycleSpeed: (if (== gHowFast 0) 10 else 20)
					setCycle: End self
					init:
				)
			)
			(2
				(gGlobalSound3 number: 789 loop: -1 vol: 127 play:)
			)
			(3
				(babyRoc1 loop: 2 cel: 0 setCycle: End self)
				(babyRoc2 loop: 3 cel: 0 setCycle: End self)
			)
			(4)
			(5
				(gGlobalSound3 stop:)
				(proc762_1 @local1 7025 self)
			)
			(6
				(cls)
				(babyRoc1 dispose: stopUpd:)
				(gEgo hide:)
				(if (== ((gInventory at: 19) owner:) 34) ; Leg_of_Lamb
					(babyRoc2
						loop: 4
						posn: 126 78
						cel: 0
						cycleSpeed: 10
						setCycle: CT 1 1 self
					)
				else
					(HandsOff)
					(babyRoc2
						loop: 4
						posn: 126 78
						cel: 0
						cycleSpeed: 10
						setCycle: End self
					)
					(++ state)
					(gGlobalSound number: 825 loop: -1 vol: 127 playBed:)
				)
			)
			(7
				(gCurRoom newRoom: 43)
			)
			(8
				(babyRoc2 loop: 5 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(9
				(babyRoc2 loop: 6 cel: 0 setCycle: Fwd cycleSpeed: 1)
				(= seconds 3)
			)
			(10
				(babyRoc2 cycleSpeed: 2 setCycle: RandCycle)
				(Say 9116 self)
			)
			(11
				(cls)
				(= global330 494)
				(EgoDead)
			)
		)
	)
)

(instance getLocket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(locket hide:)
				(= cycles 2)
			)
			(2
				(Say 501)
				(locket dispose:)
				(gEgo loop: 0)
			)
			(3
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance egg of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $4000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (>= (hatch state:) 4)
						(Say 495)
					else
						(Say 496)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (>= (hatch state:) 4)
						(Say 502)
					else
						(Say 503)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance locket of Prop
	(properties
		x 185
		y 125
		view 604
		loop 2
		signal 16400
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
					(Say 497)
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo get: 25) ; Locket
					(SetScore 2)
					(HandsOff)
					(gEgo setScript: getLocket)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance babyRoc1 of Actor
	(properties
		x 147
		y 107
		view 606
		priority 2
		signal 16400
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
					(if (>= (hatch state:) 4)
						(Say 498)
						(event claimed: 1)
					)
				)
				(3 ; Do
					(if (not local0)
						(++ local0)
						(Say 504)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance babyRoc2 of Actor
	(properties
		x 153
		y 90
		view 606
		loop 1
		priority 1
		signal 16400
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
					(if (>= (hatch state:) 4)
						(Say 498)
						(event claimed: 1)
					)
				)
				(3 ; Do
					(if (not local0)
						(++ local0)
						(Say 504)
						(event claimed: 1)
					)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(Say 505)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance nest of RFeature
	(properties
		nsBottom 200
		nsRight 320
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
					(if (>= (hatch state:) 4)
						(Say 499)
					else
						(Say 500)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

