;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 896)
(include sci.sh)
(use Main)
(use PolyPath)
(use Game)
(use User)
(use System)

(local
	local0
	local1
)

(class ADRoom of Rm
	(properties
		style 10
		autoLoad 0
	)

	(method (init &tmp [temp0 2])
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(cond
			((not (gCast contains: gEgo)) 0)
			(script 0)
		)
		(if autoLoad
			(Load rsMESSAGE gCurRoomNum)
			(Lock rsMESSAGE gCurRoomNum 1)
		)
	)

	(method (newRoom newRoomNumber)
		(Lock rsMESSAGE gCurRoomNum 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(= temp0 -1)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(gGame handsOff:)
				(if (== temp0 -1)
					(self setScript: sRW 0 ((User alterEgo:) edgeHit:))
				else
					(self setScript: lRS 0 temp0)
				)
			)
		)
	)
)

(instance lRS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp1
					(/
						(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
						2
					)
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

(instance sRW of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= local0 (= temp0 (gEgo x:)))
				(= local1 (= temp1 (gEgo y:)))
				(= temp3
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp2
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(switch register
					(1
						(+= local1 5)
					)
					(2
						(+= temp0 temp3)
						(-= local0 5)
					)
					(3
						(+= temp1 temp2)
						(-= local1 5)
					)
					(4
						(-= temp0 temp3)
						(+= local0 5)
					)
				)
				(gEgo ignoreActors: 1 setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(3
				(gEgo ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

