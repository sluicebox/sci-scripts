;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64934)
(include sci.sh)
(use Main)
(use WriteFeature)
(use Menu)

(class Room of Obj
	(properties
		plane 0
		picture -1
		style -1
		noun 0
		case 0
		modNum -1
		exitStyle -1
		purge 500
		obstacles 0
		number 0
	)

	(method (init)
		(if (| (& state $0100) (& state $0200))
			(if plane
				((plane cast:) add: self)
			else
				(if (& state $0100)
					(gCast add: self)
				)
				(if (& state $0200)
					((gUser orphans:) add: self)
				)
			)
		)
		(= number gCurRoomNum)
		(if (!= picture -1)
			(self drawPic: picture)
		)
	)

	(method (dispose)
		((gUser orphans:) delete: self)
		(gCast delete: self)
		(if plane
			((plane cast:) delete: self flush:)
		)
		(if obstacles
			(obstacles dispose:)
		)
		(= plane (= obstacles 0))
		(super dispose:)
		(return 1)
	)

	(method (addObstacle param1)
		(if (not obstacles)
			(= obstacles (Set new:))
		)
		(obstacles add: param1 &rest)
	)

	(method (cue))

	(method (doVerb theVerb &tmp temp0)
		(if
			(and
				(= temp0 (!= modNum -1))
				(= temp0 (Message msgGET modNum noun theVerb case 1))
			)
			(gMessager say: noun theVerb case 0 0 modNum)
		)
		(return temp0)
	)

	(method (drawPic param1 param2 param3)
		(if plane
			(plane
				drawPic:
					param1
					(cond
						((== style -1) 0)
						((> argc 1) param2)
						(else style)
					)
			)
		else
			(PrintDebug {Attempt to call Room drawpic on room with no plane\n})
			(SetDebug self)
		)
		(if (and (> argc 2) param3)
			(= picture param1)
			(= style param2)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(not (event claimed:))
				(= temp0 (event message:))
				(self doVerb: temp0)
			)
			(event claimed: self)
		)
		(event claimed:)
	)

	(method (newRoom newRoomNumber)
		(= gNewRoomNum newRoomNumber)
	)

	(method (notify))
)

