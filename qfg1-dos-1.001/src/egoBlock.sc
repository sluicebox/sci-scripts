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
	local2
)

(instance egoBlock of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 152)
	)

	(method (init)
		(= local1 (ScriptID 213 0)) ; warrior
		(= local2 (local1 egoShield:))
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
					posn: (local1 baseX:) (+ (local1 baseY:) 5)
					stopUpd:
				)
				(local2 setCel: 2 posn: (+ (local2 x:) 22) (- (local2 y:) 10))
				(= cycles 2)
				(= local0 10)
			)
			(1
				(= cycles 6)
			)
			(2
				(local2 setCel: 0 posn: (- (local1 baseX:) 74) (local1 baseY:))
				(= cycles 4)
			)
			(3
				(local2 stopUpd:)
				(local1 posn: (local1 baseX:) (local1 baseY:))
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

