;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 148)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoZap 0
)

(local
	local0
	local1
)

(instance egoZap of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 148)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(= local1 (ScriptID 215 1)) ; aSpell
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global250 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
				(local0 canFight: 0 action: 11 setCel: 2)
				(= cycles 1)
			)
			(1
				(local1
					setLoop: 7
					cel: 0
					cycleSpeed: 1
					ignoreActors:
					posn: (- (local0 x:) 7) (- (local0 y:) 70)
					setPri: (+ (local0 priority:) 1)
					init:
					setCycle: End self
				)
			)
			(2
				(local1 dispose:)
				(local0 canFight: 1 setCel: 0)
				(self dispose:)
			)
		)
	)
)

