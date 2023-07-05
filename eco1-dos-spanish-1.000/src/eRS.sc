;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 808)
(include sci.sh)
(use Main)
(use Interface)
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
					(1
						((User alterEgo:) y: 188)
					)
					(4
						((User alterEgo:) x: (- 319 temp0))
					)
					(3
						((User alterEgo:) y: (- (+ horizon temp1) 5))
					)
					(2
						((User alterEgo:) x: (+ 0 temp0))
					)
				)
				((User alterEgo:) edgeHit: 0)
			)
			(else
				(self setScript: eRS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if lookStr
					(if (< 0 lookStr 300)
						(Narrator init: lookStr)
					else
						(Print lookStr)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: (Random 121 124) 0 4)
			)
			(5 ; Talk
				(Narrator init: (Random 130 134) 0 4)
			)
			(3 ; Do
				(Narrator init: (Random 125 129) 0 4)
			)
			(4 ; Inventory
				(Narrator init: (Random 135 139) 0 4)
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

