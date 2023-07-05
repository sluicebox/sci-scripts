;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 149)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoDazzle 0
)

(local
	local0
	local1
	local2
)

(instance egoDazzle of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 149)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(= local2 (ScriptID 215 1)) ; aSpell
		(= local1 (local0 egoHand:))
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0 canFight: 0 action: 11)
				(self cue:)
			)
			(1
				(local2
					setLoop: 5
					cel: 0
					setPri: (- (local1 priority:) 1)
					cycleSpeed: 1
					ignoreActors:
					posn: (- (local0 x:) 78) (- (local0 y:) 81)
					init:
					setCycle: End self
				)
			)
			(2
				(local2 dispose:)
				(SetFlag 233)
				(= global251 [gEgoStats 20]) ; dazzleSpell
				(local0 canFight: 1 action: 0)
				(self dispose:)
			)
		)
	)
)

