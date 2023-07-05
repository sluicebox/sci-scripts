;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use System)

(public
	tahitiOcean2 0
)

(instance tahitiOcean2 of Rm
	(properties
		picture 15
		horizon 90
		picAngle 70
	)

	(method (init &tmp temp0)
		(self setRegions: 301 300 308 setScript: dieSoonerScript) ; Water, tahiti, oceanRg
		(gEgo view: 217 init:)
		(= temp0 ((User alterEgo:) edgeHit:))
		(super init:)
		(self
			north: (if (== temp0 3) gPrevRoomNum else number)
			south: (if (== temp0 1) gPrevRoomNum else number)
			east: (if (== temp0 4) gPrevRoomNum else number)
			west: (if (== temp0 2) gPrevRoomNum else number)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/water,room]')
				(Print 15 0) ; "You see nothing but water in all directions."
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber number)
			(= gCurRoomNum -1)
		)
		(self drawPic: number)
		(super newRoom: newRoomNumber)
	)
)

(instance dieSoonerScript of Script
	(properties
		cycles 16
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(((ScriptID 308) script:) cycles: 30) ; oceanRg
			)
		)
	)
)

