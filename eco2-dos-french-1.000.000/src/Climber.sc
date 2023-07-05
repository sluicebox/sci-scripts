;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Jungle)
(use System)

(public
	Climber 0
)

(class Climber of Script
	(properties
		myColor 0
		from1 0
		from2 0
		from3 0
		from4 0
		from5 0
		from1S 0
		from2S 0
		from3S 0
		from4S 0
		from5S 0
		access1 0
		access2 0
		access3 0
		access4 0
		access5 0
	)

	(method (itsMe param1)
		(return (== myColor param1))
	)

	(method (findClimber param1 &tmp temp0)
		(= temp0
			(if (& param1 (| (| (| (| from1 from2) from3) from4) from5))
				((Jungle climbers:) firstTrue: #itsMe param1)
			else
				((Jungle climbers:)
					firstTrue:
						#itsMe
						(cond
							((& access1 param1) from1)
							((& access2 param1) from2)
							((& access3 param1) from3)
							((& access4 param1) from4)
							((& access5 param1) from5)
						)
				)
			)
		)
		(if (IsObject temp0)
			(client setScript: temp0 self myColor)
		)
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(gDirectionHandler add: self)
		(gTheIconBar walkIconItem: 0)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gTheIconBar walkIconItem: (gTheIconBar at: 0))
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (event type:))
		(= temp2 ((gTheIconBar curIcon:) message:))
		(if (and (& temp1 $0040) (== temp2 3)) ; direction
			(if (== temp2 0)
				(event claimed: 0)
			else
				(gPMouse handleEvent: event)
				(return 1)
			)
		)
		(if
			(and
				(OneOf temp2 4 3)
				(or (== temp1 evMOUSEBUTTON) (and (== temp1 evKEYBOARD) (== (event message:) KEY_RETURN)))
				(not (event modifiers:))
			)
			(event claimed: 1)
			(Jungle climbColor: (= temp0 (OnControl CONTROL (event x:) (event y:))))
			(cond
				((and (== temp2 4) (gCast firstTrue: #onMe event))
					(event claimed: 0)
				)
				((& temp0 (& (~ myColor) $fffe))
					(self findClimber: temp0)
				)
				((== temp0 1)
					(if (== temp2 3)
						(gMessager say: 1 0 1 (Random 1 2) 0 14)
					else
						(gMessager say: 1 0 2 1 0 14) ; "Adam can't leap there. He'll have to climb something closer."
					)
				)
				((== temp2 4)
					(event claimed: 0)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (!= register 999)
					(gGame handsOff:)
					(self
						setScript:
							(switch register
								(from1 from1S)
								(from2 from2S)
								(from3 from3S)
								(from4 from4S)
								(from5 from5S)
							)
							self
					)
				)
			)
			(1
				(if (== myColor (= temp0 (Jungle climbColor:)))
					(Jungle climbColor: 0)
					(gGame handsOn:)
				else
					(self findClimber: temp0)
				)
			)
		)
	)
)

