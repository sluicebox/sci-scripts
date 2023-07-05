;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 132)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	rm132 0
)

(local
	[local0 3]
	local3
)

(instance rm132 of Rm
	(properties
		picture 200
		style 0
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(gEgo
			view: (if (not global204) 0 else 6)
			x:
				(switch gPrevRoomNum
					(129
						(if (<= (gEgo x:) 200) 80 else 155)
					)
					(131 15)
				)
			y:
				(switch gPrevRoomNum
					(129 95)
					(131
						(if (<= (gEgo y:) 115) 95 else 135)
					)
				)
			init:
		)
		(HandsOn)
		(= local3 0)
		((Prop new:)
			view: 260
			loop: 8
			cel: 1
			posn: 311 182
			setPri: 1
			ignoreActors: 1
			init:
			stopUpd:
		)
		((= [local0 0] (Prop new:))
			view: 99
			loop: 2
			cel: 2
			posn: 210 189
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local0 1] (Prop new:))
			view: 99
			loop: 1
			cel: 2
			posn: 65 124
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local0 2] (Prop new:))
			view: 99
			loop: 2
			cel: 0
			posn: 163 153
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local0 0] stopUpd:)
			([local0 1] stopUpd:)
		)
		(if (< global110 30)
			([local0 2] stopUpd:)
		)
		(gRatObj
			name: 4
			setLoop: 2
			illegalBits: 0
			posn: 70 66
			ignoreActors: 1
			init:
			setMotion: MoveTo -100 66 gRatObj
		)
		(gLightObj posn: 190 78 ignoreActors: 1 init: stopUpd:)
		(global115 posn: 91 54 ignoreActors: 1 init: stopUpd:)
	)

	(method (doit)
		(cond
			(global139 0)
			((<= (gEgo x:) 5)
				(gCurRoom newRoom: 131)
			)
			((gEgo inRect: 70 70 165 94)
				(gCurRoom newRoom: 129)
			)
			((gEgo inRect: 160 190 320 195)
				(if (not local3)
					(= local3 1)
					(Print 132 0) ; "You're at a dead end."
					(gEgo setMotion: MoveTo (gEgo x:) 180)
				)
			)
			(else
				(= local3 0)
			)
		)
		(super doit:)
	)
)

