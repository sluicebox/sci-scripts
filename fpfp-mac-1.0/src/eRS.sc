;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use PolyPath)
(use Game)
(use User)
(use System)

(public
	eRS 0
)

(local
	local0
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

(class FPRoom of Rm
	(properties
		horizon 15
		vanishingY -30000
	)

	(method (doVerb theVerb)
		(if (not (super doVerb: theVerb))
			(proc0_6 self theVerb)
		)
	)

	(method (init param1 &tmp temp0 temp1 [temp2 2])
		(if (== gCurPuzzle 9)
			(cond
				(
					(OneOf
						gCurRoomNum
						410
						600
						610
						620
						630
						640
						650
						660
						670
						690
						710
						720
						730
					)
					(ClearFlag 70)
					(gTimers delete: (ScriptID 0 14)) ; gasMaskTimer
				)
				((not (gTimers contains: (ScriptID 0 14))) ; gasMaskTimer
					((ScriptID 0 14) setReal: (ScriptID 0 14) 40) ; gasMaskTimer, gasMaskTimer
				)
			)
		)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (IsFlag 1)
			(PalVary pvUNINIT)
		)
		(if picture
			(self drawPic: picture)
		)
		(if (IsFlag 1)
			(cond
				((OneOf gCurRoomNum 200 210 220 230 235 240 250 260 265 270)
					(PalVary pvINIT 900 0)
				)
				((OneOf gCurRoomNum 300 310 320)
					(PalVary pvINIT 910 0)
				)
				((== gCurRoomNum 500)
					(PalVary pvINIT 920 0)
				)
				((== gCurRoomNum 400)
					(PalVary pvINIT 930 0)
				)
			)
		)
		(if (IsFlag 113)
			(PalVary pvUNINIT)
		)
		(if (and (IsFlag 113) (== gPrevRoomNum 26)) ; actBreak
			(cond
				((== gCurRoomNum 230)
					(PalVary pvINIT 230 0)
				)
				((== gCurRoomNum 250)
					(PalVary pvINIT 250 0)
				)
				((== gCurRoomNum 630)
					(PalVary pvINIT 630 0)
				)
				((== gCurRoomNum 240)
					(PalVary pvINIT 240 0)
				)
			)
		)
		(cond
			((== gCurRoomNum 620)
				(if (!= gPrevRoomNum 610)
					0
				else
					(self setScript: eRS param1 gPrevRoomNum)
				)
			)
			((not (gCast contains: gEgo)) 0)
			(script 0)
			((not ((User alterEgo:) edgeHit:)) 0)
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
					(EDGE_TOP
						((User alterEgo:) y: 188)
					)
					(EDGE_LEFT
						((User alterEgo:) x: (- 319 temp0))
					)
					(EDGE_BOTTOM
						((User alterEgo:) y: (+ horizon temp1))
					)
					(EDGE_RIGHT
						((User alterEgo:) x: (+ 0 temp0))
					)
				)
				((User alterEgo:) edgeHit: EDGE_NONE)
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
		(gTheIconBar disable: 7)
		(super setInset: &rest)
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

