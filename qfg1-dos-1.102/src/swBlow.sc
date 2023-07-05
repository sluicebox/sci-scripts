;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use rm15)
(use Motion)

(public
	swBlow 0
	swDodge 1
	swParry 2
	knStab 3
	knDodge 4
)

(local
	local0
)

(instance swBlow of KScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 111)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 global348)
				(if (Random 0 1)
					(gEgo setLoop: (+ global348 4))
					(= register 5)
				else
					(gEgo setLoop: (+ global348 2))
					(= register 4)
				)
				(gEgo setCel: 0)
				(= cycles register)
			)
			(1
				(gEgo setCel: 1)
				(if (and (== global348 local0) (>= global344 (Random100)))
					(gKobold getHurt: global345)
				)
				(= cycles 2)
			)
			(2
				(gEgo setCel: (if (== register 5) 2 else 0))
				(= cycles register)
			)
			(3
				(gEgo setLoop: global348 setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance swDodge of KScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 111)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: global348 setCel: register)
				(= cycles 10)
			)
			(1
				(gEgo setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance swParry of KScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 111)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: (+ global348 8) setCel: 0)
				(= cycles 8)
			)
			(1
				(gEgo setLoop: global348)
				(self dispose:)
			)
		)
	)
)

(instance knStab of KScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 111)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 global348)
				(gEgo setLoop: (if global348 5 else 0))
				(gEgo setCel: -1 cel: 0 setCycle: CT 4 1 self)
			)
			(1
				(if (and (== global348 local0) (>= global344 (Random100)))
					(gKobold getHurt: global345)
				)
				(= cycles 4)
			)
			(2
				(gEgo setCycle: End self)
				(= cycles register)
			)
			(3
				(gEgo setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance knDodge of KScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 111)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop:
						(if global348
							(+ register 5)
						else
							register
						)
					setCel: 0
				)
				(= cycles 10)
			)
			(1
				(gEgo setLoop: (if global348 5 else 0))
				(self dispose:)
			)
		)
	)
)

