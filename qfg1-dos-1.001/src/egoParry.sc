;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 153)
(include sci.sh)
(use Main)
(use System)

(public
	egoParry 0
)

(local
	local0
	local1
)

(instance egoParry of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 153)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(-- local0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(TrySkill 6 0 20) ; parry
				(local1
					getTired: 1
					canFight: 0
					action: 3
					setLoop: 4
					setCel: 0
					stopUpd:
				)
				(= cycles 1)
				(= local0 10)
			)
			(1
				(local1 setCel: 1)
				(= cycles 7)
			)
			(2
				(local1 setCel: 0)
				(= cycles 1)
			)
			(3
				(local1 posn: (local1 baseX:) (local1 baseY:) setLoop: 2 cel: 0)
				(= global266 1)
				(if (<= (= cycles local0) 0)
					(self cue:)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

