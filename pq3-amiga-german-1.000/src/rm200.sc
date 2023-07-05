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
		(Load rsVIEW (proc0_20 1971 197 197 197 197))
		(Dmv
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 30 26 26 26 26)
			init:
		)
		(Homicide
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 94 88 88 88 88)
			init:
			stopUpd:
		)
		(Personnel
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 146 166 166 166 166)
			init:
			stopUpd:
		)
		(Tools
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 209 234 234 234 234)
			init:
			stopUpd:
		)
		(Quit
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 307 289 289 289 289)
			init:
			stopUpd:
		)
		(drawFace
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 80 75 75 75 75)
			init:
			hide:
		)
		(cityMap
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 166 203 203 203 203)
			init:
			hide:
		)
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
				(drawFace show: stopUpd:)
				(cityMap show: stopUpd:)
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
							(==
								(event message:)
								(proc0_20 119 100 100 100 100)
							)
							(== (event message:) (proc0_20 87 68 68 68 68))
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
							(==
								(event message:)
								(proc0_20 107 116 116 116 116)
							)
							(== (event message:) (proc0_20 75 84 84 84 84))
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
							(==
								(event message:)
								(proc0_20 109 104 104 104 104)
							)
							(== (event message:) (proc0_20 77 72 72 72 72))
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
							(==
								(event message:)
								(proc0_20 101 113 113 113 113)
							)
							(== (event message:) (proc0_20 69 81 81 81 81))
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
							(==
								(event message:)
								(proc0_20 112 100 100 100 100)
							)
							(== (event message:) (proc0_20 80 68 68 68 68))
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
							(== (event message:) (proc0_20 115 99 99 99 99))
							(== (event message:) (proc0_20 83 67 67 67 67))
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

