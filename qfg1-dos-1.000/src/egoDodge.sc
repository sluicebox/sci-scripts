;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 154)
(include sci.sh)
(use Main)
(use System)

(public
	egoDodge 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance egoDodge of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 154)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(= local1 (local0 egoShield:))
		(= local2 (local0 egoHand:))
		(= local3 (local0 egosBack:))
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(-- local4)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(TrySkill 7 0 20) ; dodge
				(local0
					getTired: 2
					canFight: 0
					action: (if (== register 0) 5 else 6)
				)
				(if local1
					(switch register
						(0
							(local1 posn: (- (local1 x:) 25) (- (local1 y:) 5))
						)
						(1
							(local1 posn: (+ (local1 x:) 40) (- (local1 y:) 5))
						)
					)
				else
					(switch register
						(0
							(local2 posn: (- (local2 x:) 38) (+ (local2 y:) 5))
						)
						(1
							(local2 posn: (+ (local2 x:) 46) (+ (local2 y:) 5))
						)
					)
				)
				(switch register
					(0
						(local0 posn: (- (local0 x:) 41) (+ (local0 y:) 5))
						(local3 posn: (- (local3 x:) 40) (+ (local3 y:) 5))
					)
					(1
						(local0 posn: (+ (local0 x:) 42) (+ (local0 y:) 5))
						(local3 posn: (+ (local3 x:) 40) (+ (local3 y:) 5))
					)
				)
				(= local4 10)
				(= cycles 7)
			)
			(1
				(local0 posn: (local0 baseX:) (local0 baseY:))
				(if local1
					(local1 posn: (- (local0 baseX:) 74) (local0 baseY:))
				else
					(local2 posn: (- (local0 baseX:) 74) (local0 baseY:))
				)
				(local3 posn: (- (local0 baseX:) 41) (local0 baseY:))
				(self cue:)
			)
			(2
				(= global266 1)
				(if (<= (= cycles local4) 0)
					(self cue:)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

