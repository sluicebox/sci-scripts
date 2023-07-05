;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 151)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoThrust 0
)

(local
	local0
	local1
)

(instance egoThrust of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 151)
	)

	(method (init)
		(= local0 (ScriptID 213 0)) ; warrior
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global266 0)
				(TrySkill 5 0 0) ; weapon-use
				(= local1 (local0 tryAttack: (local0 opponent:)))
				(if
					(and
						(or (== global332 425) (== global332 465))
						(== ((local0 opponent:) action:) 3)
					)
					(= local1 0)
				)
				(if local1
					(if
						(or
							(== global332 440)
							(== global332 420)
							(== global332 430)
							(== global332 425)
							(== global332 465)
						)
						(= register 3)
					)
					(local0
						getTired: 4
						canFight: 0
						action: 1
						setLoop: register
						setPri: (if (== global332 435) 1 else 9)
						setCel: 1
					)
				)
				(= cycles 8)
			)
			(1
				(if local1
					(= local1 0)
					(local0 doDamage: (local0 opponent:) global250)
					(= global250 0)
				)
				(local0 setPri: 11 setLoop: register setCycle: CT 0 1 self)
			)
			(2
				(= global266 1)
				(self dispose:)
			)
		)
	)
)

