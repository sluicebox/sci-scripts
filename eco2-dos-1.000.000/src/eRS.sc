;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use PolyPath)
(use Game)
(use User)
(use System)

(public
	eRS 0
)

(procedure (localproc_0)
	(cond
		((< (gEgo x:) 0)
			(gEgo x: (+ 0 (* (gEgo xStep:) 2)))
		)
		((> (gEgo x:) 319)
			(gEgo x: (- 319 (* (gEgo xStep:) 2)))
		)
	)
)

(procedure (localproc_1)
	(cond
		((< (gEgo y:) (gCurRoom horizon:))
			(gEgo y: (+ (gCurRoom horizon:) (* (gEgo yStep:) 2)))
		)
		((> (gEgo y:) 189)
			(gEgo y: (- 189 (* (gEgo yStep:) 2)))
		)
	)
)

(class Eco2Room of Rm
	(properties
		horizon 15
		vanishingX 0
		tpX 160
		tpY 160
	)

	(method (init param1 &tmp temp0 temp1 [temp2 2])
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(cond
			((not (gCast contains: gEgo)) 0)
			(script 0)
			((not ((User alterEgo:) edgeHit:))
				(gEgo posn: tpX tpY)
			)
			((OneOf style 11 12 13 14)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User alterEgo:) view:)
								((User alterEgo:) loop:)
								((User alterEgo:) cel:)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(/
							(CelHigh
								((User alterEgo:) view:)
								((User alterEgo:) loop:)
								((User alterEgo:) cel:)
							)
							2
						)
					)
				)
				(switch ((User alterEgo:) edgeHit:)
					(1
						((User alterEgo:) y: 188)
					)
					(4
						((User alterEgo:) x: (- 319 temp0))
					)
					(3
						((User alterEgo:) y: (+ horizon temp1))
					)
					(2
						((User alterEgo:) x: (+ 0 temp0))
					)
				)
				((User alterEgo:) edgeHit: 0)
			)
			(else
				(if (not argc)
					(= param1 0)
				)
				(self setScript: eRS param1 gPrevRoomNum)
			)
		)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((IsFlag 5))
			(script
				(script doit:)
			)
			((!= gCurRoomNum gNewRoomNum) 0)
			((not (gCast contains: gEgo)) 0)
			(
				(switch (= temp0 ((User alterEgo:) edgeHit:))
					(1 north)
					(2 east)
					(3 south)
					(4 west)
				)
				(self setScript: lRS 0 temp0)
			)
		)
	)

	(method (setInset)
		(super setInset: &rest)
		(gTheIconBar disable: 8)
	)
)

(instance lRS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp1
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp0
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(switch register
					(1
						(gCurRoom newRoom: (gCurRoom north:))
					)
					(3
						(gEgo
							setMotion: PolyPath (gEgo x:) (+ 189 temp0) self
						)
						(= register (gCurRoom south:))
					)
					(2
						(gEgo
							setMotion: PolyPath (+ 319 temp1) (gEgo y:) self
						)
						(= register (gCurRoom east:))
					)
					(4
						(gEgo
							setMotion: PolyPath (- 0 temp1) (gEgo y:) self
						)
						(= register (gCurRoom west:))
					)
				)
			)
			(1
				(gEgo hide:)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance eRS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 0)
				(if (gUser canControl:)
					(gGame handsOff:)
				)
				(= temp0
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp1
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(switch register
					((client north:)
						(localproc_0)
						(gEgo y: (+ (gCurRoom horizon:) (gEgo yStep:)))
						(= cycles 1)
					)
					((client south:)
						(localproc_0)
						(gEgo
							y: (+ 189 temp0)
							setMotion:
								PolyPath
								(gEgo x:)
								(- 189 (* (gEgo yStep:) 2))
								self
						)
					)
					((client east:)
						(localproc_1)
						(gEgo
							x: (+ 319 (/ temp1 2))
							setMotion:
								PolyPath
								(- 319 (* (gEgo xStep:) 2))
								(gEgo y:)
								self
						)
					)
					((client west:)
						(localproc_1)
						(gEgo
							x: (- 0 (/ temp1 2))
							setMotion:
								PolyPath
								(+ 0 (* (gEgo xStep:) 2))
								(gEgo y:)
								self
						)
					)
					(else
						(gEgo posn: (gCurRoom tpX:) (gCurRoom tpY:))
						(= cycles 1)
					)
				)
			)
			(1
				(gGame handsOn: 1)
				(self dispose:)
			)
		)
	)
)

