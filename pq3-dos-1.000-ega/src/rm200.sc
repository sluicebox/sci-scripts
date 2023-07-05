;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm200 0
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp [temp0 75])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 2 dsCOLOR param6 dsWIDTH param5)
)

(instance rm200 of Rm
	(properties
		picture 200
	)

	(method (init)
		(super init:)
		(Load rsVIEW 197)
		(Dmv init:)
		(Homicide init:)
		(Personnel init:)
		(Tools init:)
		(Quit init:)
		(drawFace init: hide:)
		(cityMap init: hide:)
		(gTheIconBar disable:)
		(gGame setCursor: 999)
		(self setScript: runComputer)
		(if (< gPrevRoomNum 100)
			(= global140 gPrevRoomNum)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(script handleEvent: event)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance runComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Dmv show:)
				(Homicide show:)
				(Personnel show:)
				(Tools show:)
				(drawFace hide:)
				(cityMap hide:)
				(gCurRoom style: 0)
				(= cycles 2)
			)
			(1
				(switch global150
					(1
						(if (and (== gDay 5) global143)
							(localproc_0 200 0 10 40 300 global125) ; "Evidence added to case no: 199145"
						)
					)
					(2
						(if (== gDay 6)
							(localproc_0 200 0 10 40 300 global125) ; "Evidence added to case no: 199145"
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance runTools of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Dmv hide:)
				(Homicide hide:)
				(Personnel hide:)
				(Tools hide:)
				(drawFace show:)
				(cityMap show:)
				(self dispose:)
			)
		)
	)
)

(instance Dmv of Prop
	(properties
		x 26
		y 10
		view 197
		priority 15
		signal 6144
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (& signal $0080))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_d)
							(== (event message:) KEY_D)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 204) ; rmDmv
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 204) ; rmDmv
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance Tools of Prop
	(properties
		x 234
		y 10
		view 197
		cel 3
		priority 15
		signal 6144
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (& signal $0080))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_t)
							(== (event message:) KEY_T)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runTools)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runTools)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance Homicide of Prop
	(properties
		x 88
		y 10
		view 197
		cel 1
		priority 15
		signal 6144
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (& signal $0080))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_h)
							(== (event message:) KEY_H)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 203)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 203)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance Personnel of Prop
	(properties
		x 166
		y 10
		view 197
		cel 2
		priority 15
		signal 6144
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (& signal $0080))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_p)
							(== (event message:) KEY_P)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 205) ; rmPersonel
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 205) ; rmPersonel
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance Quit of Prop
	(properties
		x 289
		y 10
		view 197
		cel 4
		priority 15
		signal 6144
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (& signal $0080))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_q)
							(== (event message:) KEY_Q)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(if (not (& (drawFace signal:) $0080))
							(gCurRoom setScript: runComputer)
						else
							(gCurRoom style: 10 newRoom: global140)
						)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(if (not (& (drawFace signal:) $0080))
							(gCurRoom setScript: runComputer)
						else
							(gCurRoom style: 10 newRoom: global140)
						)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance drawFace of Prop
	(properties
		x 75
		y 10
		view 197
		cel 10
		priority 15
		signal 6144
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (& signal $0080))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_d)
							(== (event message:) KEY_D)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 201)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 201)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance cityMap of Prop
	(properties
		x 203
		y 10
		view 197
		cel 11
		priority 15
		signal 6144
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (& signal $0080))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_c)
							(== (event message:) KEY_C)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 202) ; rmMap
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1)
						(Animate (gCast elements:) 0)
						(self loop: 0)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 202) ; rmMap
						(event claimed: 1)
					)
				)
			)
		)
	)
)

