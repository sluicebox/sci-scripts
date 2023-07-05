;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	eRS 0
)

(local
	[chargerCoords 7] = [160 64 108 260 19 146 0]
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

(instance controls_Fcontr_les of Controls
	(properties
		name {controls}
	)
)

(class LLRoom of Rm
	(properties)

	(method (init &tmp wide high i theLoop)
		(= number gCurRoomNum)
		(= controls controls_Fcontr_les)
		(if (== ((Inv at: 1) owner:) gCurRoom) ; Battery_Charger
			(= i 0)
			(while (!= [chargerCoords i] 0)
				(if (== [chargerCoords i] gCurRoomNum)
					(if (== ((Inv at: 0) owner:) (Inv at: 1)) ; Camcorder, Battery_Charger
						(= theLoop 4)
					else
						(= theLoop 3)
					)
					((ScriptID 22 3) ; charger
						x: [chargerCoords (++ i)]
						y: [chargerCoords (++ i)]
						setLoop: theLoop
						init:
						approachVerbs: 2 3 4 ; Look, Do, Inventory
					)
					(break)
				else
					(+= i 3)
				)
			)
		)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(cond
			((not (gCast contains: gEgo)) 0)
			(script 0)
			((not ((User alterEgo:) edgeHit:)) 0)
			((OneOf style 11 12 13 14)
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
					(1
						((User alterEgo:) y: 188)
					)
					(4
						((User alterEgo:) x: (- 319 wide))
					)
					(3
						((User alterEgo:) y: (+ horizon high))
					)
					(2
						((User alterEgo:) x: (+ 0 wide))
					)
				)
				((User alterEgo:) edgeHit: 0)
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
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self setScript: lRS 0 nRoom)
			)
		)
	)

	(method (doVerb theVerb &tmp [str 150])
		(if (and (== theVerb 2) lookStr) ; Look
			(Format @str 18 0 lookStr) ; "%s"
			(TPrint @str)
			(return 1)
		else
			(return 0)
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
				(= high
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(switch register
					((client north:)
						(gCurRoom newRoom: register)
					)
					((client south:)
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
								PolyPath
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
								PolyPath
								(- 319 (* (gEgo xStep:) 2))
								(gEgo y:)
								self
						)
					)
					((client west:)
						(SeeIfOffY)
						(gEgo
							x: (- 0 (/ wide 2))
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
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

