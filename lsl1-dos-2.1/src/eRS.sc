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

(procedure (SeeIfOffX)
	(cond
		((< (gEgo x:) 0)
			(gEgo x: (+ 0 (* (gEgo xStep:) 2)))
		)
		((> (gEgo x:) 319)
			(gEgo x: (- 319 (* (gEgo xStep:) 2)))
		)
	)
)

(procedure (SeeIfOffY)
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

	(method (init &tmp wide high)
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
			((OneOf style 40 41 42 43)
				(= wide
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
				(= high
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
					(EDGE_TOP
						((User alterEgo:) y: 188)
					)
					(EDGE_LEFT
						((User alterEgo:) x: (- 319 wide))
					)
					(EDGE_BOTTOM
						((User alterEgo:) y: (+ horizon high))
					)
					(EDGE_RIGHT
						((User alterEgo:) x: (+ 0 wide))
					)
				)
				((User alterEgo:) edgeHit: EDGE_NONE userSpeed:)
				(HandsOn)
			)
			(else
				(self setScript: eRS 0 gPrevRoomNum)
			)
		)
	)

	(method (doit &tmp nRoom)
		(cond
			(script
				(script doit:)
			)
			((not (gCast contains: gEgo)) 0)
			(
				(= nRoom
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self setScript: lRS 0 nRoom)
			)
		)
	)
)

(instance lRS of Script
	(properties)

	(method (changeState newState &tmp high wide)
		(switch (= state newState)
			(0
				(HandsOff)
				(= wide
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(switch register
					((client north:)
						(gCurRoom newRoom: register)
					)
					((client south:)
						(= high
							(CelHigh
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						(gEgo
							setMotion: PolyPath (gEgo x:) (+ 189 high) self
						)
					)
					((client east:)
						(gEgo
							setMotion: PolyPath (+ 319 wide) (gEgo y:) self
						)
					)
					((client west:)
						(gEgo
							setMotion: PolyPath (- 0 wide) (gEgo y:) self
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

	(method (changeState newState &tmp high wide)
		(switch (= state newState)
			(0
				(= cycles 0)
				(HandsOff)
				(= high
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= wide
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(switch register
					((client north:)
						(SeeIfOffX)
						(gEgo y: (+ (gCurRoom horizon:) (gEgo yStep:)))
						(= cycles 1)
					)
					((client south:)
						(SeeIfOffX)
						(gEgo
							y: (+ 189 high)
							setMotion:
								MoveTo
								(gEgo x:)
								(- 189 (* (gEgo yStep:) 2))
								self
						)
					)
					((client east:)
						(SeeIfOffY)
						(gEgo
							x: (+ 319 (/ wide 2))
							setMotion:
								MoveTo
								(- 319 (+ (* (gEgo xStep:) 2) 10))
								(gEgo y:)
								self
						)
					)
					((client west:)
						(SeeIfOffY)
						(gEgo
							x: (- 0 (/ wide 2))
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
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

