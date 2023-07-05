;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 142)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	proc142_0 0
	proc142_1 1
	proc142_2 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (proc142_0 param1)
	(= local0 param1)
	(eatingArms loop: 4)
	(eatingHead loop: 3)
	(eatingBody cel: 1)
	(= local4 (gEgo script:))
	(gEgo loop: 1 script: 0 setScript: egoEating)
	(if (gEgo has: 4) ; rose | apple | green_apple
		(PutItem 4 0) ; rose | apple | green_apple
		(SetFlag 199)
	)
)

(procedure (proc142_1 param1)
	(= local0 param1)
	(eatingArms loop: 0)
	(eatingHead loop: 2)
	(eatingBody cel: 0)
	(= local4 (gEgo script:))
	(gEgo loop: 1 script: 0 setScript: egoEating)
)

(procedure (proc142_2 param1)
	(= local0 param1)
	(eatingArms loop: 6)
	(eatingBody cel: 0)
	(= local4 (gEgo script:))
	(= local5 1)
	(gEgo loop: 0 script: 0 setScript: egoEating)
	(PutItem 5 0) ; sleeve | elixir
)

(instance eatingArms of Prop
	(properties
		view 43
		cycleSpeed 2
	)
)

(instance eatingHead of Prop
	(properties
		view 43
		loop 2
		cycleSpeed 2
	)
)

(instance eatingBody of View
	(properties
		view 43
		loop 5
	)
)

(instance egoEating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 global80)
				(= local2 (User controls:))
				(= local3 (User canInput:))
				(HandsOff)
				(gEgo hide:)
				(eatingArms posn: (gEgo x:) (gEgo y:) 42 init:)
				(eatingBody posn: (gEgo x:) (gEgo y:) 0 init:)
				(if (not local5)
					(eatingHead posn: (gEgo x:) (gEgo y:) 42 init:)
				)
				(= cycles 2)
			)
			(1
				(eatingArms setCycle: End self)
			)
			(2
				(eatingArms setCycle: Beg self)
			)
			(3
				(if local5
					(self changeState: 7)
				else
					(eatingHead setCycle: Fwd)
					(= seconds 2)
				)
			)
			(4
				(eatingArms setCycle: End self)
			)
			(5
				(eatingArms setCycle: Beg self)
			)
			(6
				(eatingHead setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(eatingArms dispose:)
				(eatingBody dispose:)
				(if (not local5)
					(eatingHead dispose:)
				)
				(gEgo show:)
				(= cycles 2)
			)
			(8
				(= global80 local1)
				(User controls: local2)
				(User canInput: local3)
				(gEgo script: local4)
				(local0 cycles: 1)
				(DisposeScript 142)
			)
		)
	)
)

