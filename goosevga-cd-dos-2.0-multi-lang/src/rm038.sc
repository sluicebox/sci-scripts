;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Avoid)
(use Motion)
(use Game)

(public
	rm038 0
)

(local
	[local0 56] = [3 0 0 0 0 -14256 117 91 125 121 126 124 135 122 148 0 -32620 -14143 107 181 128 170 130 140 129 135 133 140 148 258 -32620 -14233 50 110 106 98 106 90 112 128 117 131 126 140 129 153 129 167 123 181 101 162 95 170 -32717 0]
)

(instance rm038 of Rm
	(properties
		picture 38
		style 0
	)

	(method (init)
		(super init:)
		(HandsOn)
		(if (!= gPrevRoomNum 45) ; mapRoom
			(gEgo loop: 3 posn: 132 130)
		)
		(gEgo setMotion: Freeway (= global75 @local0))
		(gEgo init:)
		(proc0_8 110 132 110 132)
		(= global133 0)
	)

	(method (doit)
		(if (> (gEgo y:) 136)
			(self newRoom: 12)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(!= (event type:) evVERB)
				script
				(!= global130 41)
			)
			(return)
		else
			(event claimed: 1)
			(HandsOff)
			(= global133 1)
			(= global161 1)
			(gEgo setAvoider: (Avoid new:) setMotion: MoveTo 130 137)
		)
	)
)

