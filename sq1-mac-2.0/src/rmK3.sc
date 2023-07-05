;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 238)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use User)
(use System)

(public
	rmK3 0
)

(local
	local0
)

(instance rmK3 of SQRoom
	(properties
		picture 38
		style 8
		horizon 125
	)

	(method (init)
		(switch (= local0 ((User alterEgo:) edgeHit:))
			(3
				(gEgo x: (Random 120 200))
				(= north gPrevRoomNum)
			)
			(1
				(gEgo x: (Random 120 200))
				(= south gPrevRoomNum)
			)
			(2
				(gEgo y: 170)
				(= west gPrevRoomNum)
			)
			(4
				(gEgo y: 170)
				(= east gPrevRoomNum)
			)
		)
		(LoadMany rsVIEW 18 420)
		(gEgo init:)
		(self setRegions: 704) ; keronaRegion
		(super init:)
	)

	(method (notify)
		(gEgo setScript: egoDead)
	)
)

(instance egoDead of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((not (User canControl:)) 0)
			((gCurRoom north:)
				(if
					(or
						(> (gEgo y:) 135)
						(< (gEgo x:) 30)
						(> (gEgo x:) 290)
					)
					(HandsOff)
					(gEgo setMotion: MoveTo (gEgo x:) 150 self)
				)
			)
			((gCurRoom south:)
				(if
					(or
						(< (gEgo y:) 170)
						(< (gEgo x:) 30)
						(> (gEgo x:) 290)
					)
					(HandsOff)
					(gEgo setMotion: MoveTo (gEgo x:) 160 self)
				)
			)
			((gCurRoom east:)
				(if
					(or
						(< (gEgo x:) 290)
						(< (gEgo y:) 140)
						(> (gEgo y:) 180)
					)
					(HandsOff)
					(gEgo setMotion: MoveTo 280 (gEgo y:) self)
				)
			)
			(
				(and
					(gCurRoom west:)
					(or
						(> (gEgo x:) 30)
						(< (gEgo y:) 140)
						(> (gEgo y:) 180)
					)
				)
				(HandsOff)
				(gEgo setMotion: MoveTo 30 (gEgo y:) self)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(if (gCurRoom script:)
					(self dispose:)
				else
					(HandsOff)
					(gLongSong number: 810 loop: 1 play:)
					(gEgo
						view: 18
						setLoop: (if (< (gEgo heading:) 180) 0 else 1)
						cel: 0
						setMotion: 0
						cycleSpeed: 5
					)
					(= cycles 24)
				)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(EgoDead
					18
					1
					7
					{Whoa! Those big guys pack a powerful appetite. Did you feel the way that thing just chomped right through your skeletal system? That had to hurt! The grell burps in solitary satisfaction. He doesn't often get nice, warm meals like you.}
				)
			)
		)
	)
)

