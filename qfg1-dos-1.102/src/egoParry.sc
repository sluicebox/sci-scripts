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
)

(instance egoParry of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 153)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(TrySkill 6 0 20) ; parry
				(local0
					getTired: 1
					canFight: 0
					action: 3
					setLoop: 4
					setCel: 0
					stopUpd:
				)
				(= cycles 1)
			)
			(1
				(local0 setCel: 1)
				(= cycles 7)
			)
			(2
				(local0 setCel: 0)
				(= cycles 1)
			)
			(3
				(local0 posn: (local0 baseX:) (local0 baseY:) setLoop: 2 cel: 0)
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

