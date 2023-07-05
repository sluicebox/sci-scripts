;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Game)
(use User)

(public
	rm78 0
)

(instance rm78 of Rm
	(properties
		picture 78
		east 77
		west 36
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(west 3)
					(east 2)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 315 (proc0_17 158 (gEgo y:) 142))
			)
			(west
				(gEgo posn: 49 88)
			)
			(else
				(gEgo posn: 150 180)
			)
		)
		(gEgo init:)
		(proc0_1)
		(gEgo illegalBits: -32766)
		(light init:)
	)

	(method (doit &tmp temp0)
		(cond
			((& (gEgo onControl: 1) $0040)
				(self newRoom: 36)
			)
			((== (gEgo onControl: 1) 2) 0)
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
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			(
				(or
					(Said 'look,look/hole')
					(Said 'look,look<in/hole')
					(proc0_14 event 32 70 46 84)
				)
				(Print 78 0) ; "The small hole leads to the outside world."
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,cave]')
						(Print 78 1) ; "This is a small cave with a path on one side and a very small hole on the other side."
					)
					((Said '/path')
						(Print 78 2) ; "The path is very steep and narrow."
					)
				)
			)
			((Said 'go,enter,walk,crawl/hole')
				(if (== (gEgo script:) 779)
					(Print 78 3) ; "Go ahead. Walk right in."
				else
					(Print 78 4) ; "You are much too big to fit through that small hole."
				)
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(== (OnControl PRIORITY (event x:) (event y:)) -32768)
				)
				(Print 78 5) ; "These rock formations were slowly created over thousands of years."
			)
			((Said '/stalactite,stalactite>')
				(cond
					((Said 'get,bend')
						(Print 78 6) ; "These are of no use to you, Sir Graham."
					)
					((Said 'look,look')
						(Print 78 5) ; "These rock formations were slowly created over thousands of years."
					)
				)
			)
		)
	)
)

(instance light of NewFeature
	(properties
		x 47
		y 86
		noun '/light,sunlight'
		nsTop 82
		nsLeft 35
		nsBottom 90
		nsRight 60
		description {light}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The light shines through a small hole.}
	)
)

