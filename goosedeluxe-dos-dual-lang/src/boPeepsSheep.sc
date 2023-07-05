;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 423)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	boPeepsSheep 0
)

(local
	[local0 4]
	local4 = 4
	local5
	local6
	local7
)

(instance boPeepsSheep of Prop
	(properties
		x 137
		y 108
		view 45
	)

	(method (init)
		(= local5 (= local6 0))
		(= [local0 0] self)
		(= [local0 1] sheep2)
		(= [local0 2] sheep3)
		(= [local0 3] sheep4)
		(super init:)
		(for ((= local7 1)) (< local7 4) ((++ local7))
			([local0 local7] setLoop: (Random 4 6) init:)
		)
		(self setLoop: 7 setScript: Bleating)
	)

	(method (dispose)
		(for ((= local7 1)) (< local7 4) ((++ local7))
			([local0 local7] dispose:)
		)
		(super dispose:)
	)

	(method (delete)
		(super delete:)
		(if (not (-- local4))
			(DisposeScript 423)
		)
	)
)

(instance Bleating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local6)
					(= local5 [local0 (- (Random 1 4) 1)])
					(= local6 (Random 1 3))
				)
				(if (gCurRoom script:)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(local5 setCycle: End self)
				(gSfx number: 31 play: self)
			)
			(2 0)
			(3
				(local5 setCycle: Beg self)
			)
			(4
				(if (-- local6)
					(= cycles (Random 1 3))
				else
					(= seconds (Random 6 12))
				)
				(= state -1)
			)
		)
	)
)

(instance sheep2 of Prop
	(properties
		x 108
		y 130
		view 45
		signal 16384
	)

	(method (delete)
		(super delete:)
		(if (not (-- local4))
			(DisposeScript 423)
		)
	)
)

(instance sheep3 of Prop
	(properties
		x 173
		y 119
		view 45
	)

	(method (delete)
		(super delete:)
		(if (not (-- local4))
			(DisposeScript 423)
		)
	)
)

(instance sheep4 of Prop
	(properties
		x 55
		y 105
		view 45
	)

	(method (delete)
		(super delete:)
		(if (not (-- local4))
			(DisposeScript 423)
		)
	)
)

