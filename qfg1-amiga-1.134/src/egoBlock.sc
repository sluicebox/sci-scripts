;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 152)
(include sci.sh)
(use Main)
(use System)

(public
	egoBlock 0
)

(local
	local0
	local1
)

(instance egoBlock of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 152)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(= local1 (local0 egoShield:))
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
					posn: (local0 baseX:) (+ (local0 baseY:) 5)
					stopUpd:
				)
				(local1 setCel: 2 posn: (+ (local1 x:) 22) (- (local1 y:) 10))
				(= cycles 2)
			)
			(1
				(= cycles 6)
			)
			(2
				(local1 setCel: 0 posn: (- (local0 baseX:) 74) (local0 baseY:))
				(= cycles 4)
			)
			(3
				(local1 stopUpd:)
				(local0 posn: (local0 baseX:) (local0 baseY:))
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

