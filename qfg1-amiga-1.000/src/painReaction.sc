;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use System)

(public
	painReaction 0
)

(local
	local0
	local1
	local2
	local3
)

(instance painReaction of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 155)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(= local1 ((ScriptID 213 0) egoHand:)) ; warrior
		(= local2 ((ScriptID 213 0) egosBack:)) ; warrior
		(= local3 ((ScriptID 213 0) egoShield:)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(local2 posn: (- (local2 x:) 3) (+ (local2 y:) 5))
				(local0 posn: (- (local0 x:) 3) (+ (local0 y:) 5))
				(if local3
					(local3 posn: (- (local3 x:) 5) (+ (local3 y:) 10))
				else
					(local1 posn: (- (local1 x:) 5) (+ (local1 y:) 10))
				)
				(= cycles 3)
			)
			(1
				(if (IsFlag 248)
					(EgoDead 155 0 80 {What a monster!} 82 516 0 9) ; "It was a tough battle, and you lost. Never fear! All you have to do is restore your game, and... What do you mean, "Restore WHAT game?""
				else
					(local2 posn: (- (local0 baseX:) 41) (local0 baseY:))
					(local0 posn: (local0 baseX:) (local0 baseY:))
					(if local3
						(local3 posn: (- (local0 baseX:) 74) (local0 baseY:))
					else
						(local1 posn: (- (local0 baseX:) 73) (local0 baseY:))
					)
					(= cycles 1)
				)
				(= global266 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

