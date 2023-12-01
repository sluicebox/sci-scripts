;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33000)
(include sci.sh)
(use Main)
(use n1111)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm33000 0
)

(instance rm33000 of ScaryRoom
	(properties
		picture 33000
		stepSound 4
	)

	(method (init)
		(gEgo init: setScaler: Scaler 179 73 143 81 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gGame handsOn:)
				(gEgo posn: 1000 1000)
				(gUser canInput: 1)
			)
		)
		(fireProp1 init: cycleSpeed: 9 setPri: 1 1 setCycle: Fwd)
		(fireProp2 init: cycleSpeed: 6 setPri: 1 1 setCycle: Fwd)
		(fireProp3 init: cycleSpeed: 8 setCycle: Fwd)
		(super init: &rest)
		(self setScript: chap3MalcolmScr)
	)
)

(instance chap3MalcolmScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 173)
					(DoRobot 3960 50 -39)
				)
				(1
					(DoRobot 3961 126 -2)
				)
				(2
					(gCurRoom newRoom: 33100)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(SetFlag 173)
					(= global115 0)
					(gCurRoom newRoom: 33100)
				)
			)
		)
	)
)

(instance fireProp1 of Prop
	(properties
		x 152
		y 130
		view 33000
		loop 1
	)
)

(instance fireProp2 of Prop
	(properties
		x 148
		y 51
		view 33000
	)
)

(instance fireProp3 of Prop
	(properties
		x 33
		y 80
		view 33000
		loop 2
	)
)

