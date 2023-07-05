;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 705)
(include sci.sh)
(use Main)
(use Interface)
(use Talker)
(use Actor)
(use System)

(public
	launchBayScript 0
	printGuard 1
)

(instance launchBayScript of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 705)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2])
		(if (< (gEgo x:) 160)
			(= temp0 guardTl)
			(= temp1 guardBustl)
			(= temp2 guardMouthl)
			(= temp3 guardEyesl)
			(= temp4 egoTl)
			(= temp5 egoBustl)
			(= temp6 egoMouthl)
			(= temp7 egoEyesl)
		else
			(= temp0 guardTr)
			(= temp1 guardBustr)
			(= temp2 guardMouthr)
			(= temp3 guardEyesr)
			(= temp4 egoTr)
			(= temp5 egoBustr)
			(= temp6 egoMouthr)
			(= temp7 egoEyesr)
		)
		(if (> (gEgo y:) 120)
			(temp4 nsTop: 1 y: 3)
			(temp0 nsTop: 1 y: 3)
		else
			(temp0 nsTop: 85 y: 96)
			(temp4 nsTop: 85 y: 96)
		)
		(switch (= state newState)
			(0
				(HandsOff)
				(temp0 init: temp1 temp2 temp3 170 10 0 0 self)
			)
			(1
				(temp0 init: temp1 temp2 temp3 170 11 0 1 self)
			)
			(2
				(temp4 init: temp5 temp6 temp7 170 12 0 1 self)
			)
			(3
				(= seconds 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance printGuard of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 705)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2])
		(if (< (gEgo x:) 160)
			(= temp0 guardTl)
			(= temp1 guardBustl)
			(= temp2 guardMouthl)
			(= temp3 guardEyesl)
			(= temp4 egoTl)
			(= temp5 egoBustl)
			(= temp6 egoMouthl)
			(= temp7 egoEyesl)
		else
			(= temp0 guardTr)
			(= temp1 guardBustr)
			(= temp2 guardMouthr)
			(= temp3 guardEyesr)
			(= temp4 egoTr)
			(= temp5 egoBustr)
			(= temp6 egoMouthr)
			(= temp7 egoEyesr)
		)
		(if (> (gEgo y:) 120)
			(temp4 nsTop: 1 y: 3)
			(temp0 nsTop: 1 y: 3)
		else
			(temp0 nsTop: 85 y: 96)
			(temp4 nsTop: 85 y: 96)
		)
		(switch register
			(0
				(switch (= state newState)
					(0
						(HandsOff)
						(Face gEgo client self)
					)
					(1
						(temp4 init: temp5 temp6 temp7 170 0 0 1 self)
					)
					(2
						(temp0 init: temp1 temp2 temp3 170 1 0 1 self)
					)
					(3
						(= seconds 1)
					)
					(4
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(1
				(switch (= state newState)
					(0
						(HandsOff)
						(Face gEgo client self)
					)
					(1
						(temp4 init: temp5 temp6 temp7 170 2 0 1 self)
					)
					(2
						(temp0 init: temp1 temp2 temp3 170 3 0 1 self)
					)
					(3
						(= seconds 1)
					)
					(4
						(Print 705 0) ; "Chills run down your spine as you realize he has no concept of the word son."
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(2
				(switch (= state newState)
					(0
						(HandsOff)
						(Face gEgo client self)
					)
					(1
						(temp0 init: temp1 temp2 temp3 170 4 0 1 self)
					)
					(2
						(= seconds 1)
					)
					(3
						(Print 705 1) ; "You don't even want to begin to imagine what that might be about!"
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(3
				(switch (= state newState)
					(0
						(HandsOff)
						(Face gEgo client self)
					)
					(1
						(temp4 init: temp5 temp6 temp7 170 5 0 1 self)
					)
					(2
						(temp0 init: temp1 temp2 temp3 170 6 0 1 self)
					)
					(3
						(temp4 init: temp5 temp6 temp7 170 7 0 1 self)
					)
					(4
						(= seconds 1)
					)
					(5
						(Print 705 2) ; "You wonder when game designers are ever going to stop using that same old, worn out cliche about people killing you after telling you something secret."
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(4
				(switch (= state newState)
					(0
						(HandsOff)
						(Face gEgo client self)
					)
					(1
						(temp0 init: temp1 temp2 temp3 170 8 0 1 self)
					)
					(2
						(temp4 init: temp5 temp6 temp7 170 9 0 1 self)
					)
					(3
						(= seconds 1)
					)
					(4
						(HandsOn)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance guardTr of Talker
	(properties
		x 120
		y 3
		nsTop 1
		nsLeft 9
		view 504
		loop 1
	)
)

(instance guardBustr of View
	(properties
		view 504
		cel 1
	)
)

(instance guardMouthr of Prop
	(properties
		nsTop 40
		nsLeft 35
		view 504
		loop 5
		cycleSpeed 36
	)
)

(instance guardEyesr of Prop
	(properties
		nsTop 24
		nsLeft 34
		view 504
		loop 3
		cycleSpeed 90
	)
)

(instance guardTl of Talker
	(properties
		x 3
		y 3
		nsTop 1
		nsLeft 228
		view 504
	)
)

(instance guardBustl of View
	(properties
		view 504
		cel 1
	)
)

(instance guardMouthl of Prop
	(properties
		nsTop 40
		nsLeft 19
		view 504
		loop 4
		cycleSpeed 12
	)
)

(instance guardEyesl of Prop
	(properties
		nsTop 24
		nsLeft 13
		view 504
		loop 2
		cycleSpeed 30
	)
)

(instance egoTl of Talker
	(properties
		x 3
		y 3
		nsTop 1
		nsLeft 238
		view 507
	)
)

(instance egoBustl of View
	(properties
		view 507
		cel 1
	)
)

(instance egoMouthl of Prop
	(properties
		nsTop 51
		nsLeft 23
		view 507
		loop 4
		cycleSpeed 12
	)
)

(instance egoEyesl of Prop
	(properties
		nsTop 32
		nsLeft 10
		view 507
		loop 2
		cycleSpeed 30
	)
)

(instance egoTr of Talker
	(properties
		x 120
		y 3
		nsTop 1
		nsLeft 9
		view 507
		loop 1
	)
)

(instance egoBustr of View
	(properties
		view 507
		cel 1
	)
)

(instance egoMouthr of Prop
	(properties
		nsTop 51
		nsLeft 42
		view 507
		loop 4
		cycleSpeed 12
	)
)

(instance egoEyesr of Prop
	(properties
		nsTop 32
		nsLeft 24
		view 507
		loop 3
		cycleSpeed 30
	)
)

