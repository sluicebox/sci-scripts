;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 808)
(include sci.sh)
(use Main)
(use Dialog)
(use Talker)
(use PolyPath)
(use Motion)
(use Game)
(use User)
(use System)

(public
	eRS 0
)

(instance controls of Controls
	(properties)
)

(class EcoRoom of Rm
	(properties
		walkOffTop 0
		lookStr 0
	)

	(method (newRoom)
		(HandsOff)
		(super newRoom: &rest)
	)

	(method (init &tmp temp0 temp1 temp2)
		(= number gCurRoomNum)
		(= controls controls)
		(= temp2 0)
		(= gPerspective picAngle)
		(if (and (< gHowFast 1) (>= 43 style 40))
			(= temp2 1)
			(= style
				(switch style
					(12 3)
					(11 2)
					(13 5)
					(14 4)
				)
			)
		)
		(if picture
			(self drawPic: picture)
		)
		(cond
			((not (gCast contains: gEgo)) 0)
			(script 0)
			((or temp2 (OneOf style 11 12 13 14))
				(HandsOn)
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
						(CelHigh
							((User alterEgo:) view:)
							((User alterEgo:) loop:)
							((User alterEgo:) cel:)
						)
					)
				)
				(switch ((User alterEgo:) edgeHit:)
					(EDGE_TOP
						((User alterEgo:) y: 188)
					)
					(EDGE_LEFT
						((User alterEgo:) x: (- 319 temp0))
					)
					(EDGE_BOTTOM
						((User alterEgo:) y: (- (+ horizon temp1) 5))
					)
					(EDGE_RIGHT
						((User alterEgo:) x: (+ 0 temp0))
					)
				)
				((User alterEgo:) edgeHit: EDGE_NONE)
			)
			(else
				(self setScript: eRS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if lookStr
					(if (> lookStr 99)
						(EcoNarrator
							init: (+ global250 1) 0 0 (- lookStr 100) 0 gCurRoomNum
						)
					else
						(EcoNarrator init: global250 0 0 lookStr 0 gCurRoomNum)
					)
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 2 0 0 (Random 21 24) 0 4)
			)
			(2 ; Talk
				(EcoNarrator init: 2 0 0 (Random 30 34) 0 4)
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 (Random 25 29) 0 4)
			)
			(else
				(EcoNarrator init: 2 0 0 (Random 35 39) 0 4)
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
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self setScript: lRS 0 temp0)
			)
		)
	)
)

(instance lRS of Script
	(properties)

	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1)
				(= temp1 35)
				(switch register
					((client north:)
						(if (client walkOffTop:)
							(gEgo
								ignoreHorizon: 1
								setMotion:
									PolyPath
									(gEgo x:)
									(-
										0
										(-
											(gEgo nsBottom:)
											(- (gEgo y:) (gEgo z:))
										)
									)
									self
							)
						else
							(gCurRoom newRoom: register)
						)
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
				(= cycles 1)
			)
			(2
				(gCurRoom setScript: 0 newRoom: register)
			)
		)
	)
)

(instance eRS of Script
	(properties)

	(method (init)
		(gEgo ignoreActors: 1)
		(super init: &rest)
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

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 0)
				(HandsOff)
				(= temp0
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp1 25)
				(switch gPrevRoomNum
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
								nBMT
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
								nBMT
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
								nBMT
								(+ 0 (* (gEgo xStep:) 2))
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
				(HandsOn)
				(gEgo ignoreActors: 0)
				(client notify:)
				(self dispose:)
			)
		)
	)
)

(instance nBMT of MoveTo
	(properties)

	(method (doit)
		(super doit:)
		(if (client isBlocked:)
			(self moveDone:)
		)
	)
)

