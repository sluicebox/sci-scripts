;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Motion)
(use Game)
(use User)
(use System)

(public
	eRS 0
	lRS 1
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

(instance controls of Controls
	(properties)
)

(class LLRoom of Rm
	(properties)

	(method (init &tmp temp0 temp1)
		(= number gCurRoomNum)
		(= controls controls)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(cond
			((not (gCast contains: gEgo)) 0)
			(script 0)
			((not (gEgo normal:)) 0)
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
				((User alterEgo:) edgeHit: 0 userSpeed:)
				(proc0_3)
			)
			(else
				(self setScript: eRS 0 gPrevRoomNum)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((not (gCast contains: gEgo)) 0)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self setScript: lRS 0 temp0)
			)
		)
	)
)

(instance lRS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_2)
				(= temp1
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(switch register
					((client north:)
						(gCurRoom newRoom: register)
					)
					((client south:)
						(= temp0
							(CelHigh
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						(gEgo
							setMotion: PolyPath (gEgo x:) (+ 189 temp0) self
						)
					)
					((client east:)
						(gEgo
							setMotion: PolyPath (+ 319 temp1) (gEgo y:) self
						)
					)
					((client west:)
						(gEgo
							setMotion: PolyPath (- 0 temp1) (gEgo y:) self
						)
					)
				)
			)
			(1
				(gEgo hide:)
				(= cycles 2)
			)
			(2
				(gCurRoom setScript: 0 newRoom: register)
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
				(proc0_2)
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
								MoveTo
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
								MoveTo
								(- 319 (+ (* (gEgo xStep:) 2) 10))
								(gEgo y:)
								self
						)
					)
					((client west:)
						(localproc_1)
						(gEgo
							x: (- 0 (/ temp1 2))
							setMotion:
								MoveTo
								(+ 0 (* (gEgo xStep:) 2) 10)
								(gEgo y:)
								self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gEgo userSpeed:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

