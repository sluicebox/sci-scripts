;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 127)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	rm127 0
)

(local
	[local0 4]
)

(instance rm127 of Rm
	(properties
		picture 200
		style 0
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(gEgo
			view:
				(cond
					(global140
						(if global204 306 else 296)
					)
					(global204 6)
					(else 0)
				)
			x:
				(switch gPrevRoomNum
					(124
						(if (<= (gEgo x:) 200) 80 else 155)
					)
					(126 15)
					(129
						(if (<= (gEgo x:) 85) 190 else 285)
					)
				)
			y:
				(switch gPrevRoomNum
					(124 95)
					(126
						(if (<= (gEgo y:) 115) 95 else 135)
					)
					(129 185)
				)
			init:
		)
		(HandsOn)
		((= [local0 0] (Prop new:))
			view: 99
			loop: 2
			cel: 2
			posn: 210 189
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		((= [local0 1] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 65 124
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		((= [local0 2] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 16 126
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local0 0] stopUpd:)
		)
		(if (< global110 30)
			([local0 1] stopUpd:)
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
			((< (gEgo y:) 155)
				(if (!= global156 -1)
					(cond
						((> global156 60) 0)
						((not global140)
							(Print 127 0) ; "You seem to have made it through the pocket of deadly methane gas."
						)
						(else
							(Print 127 1) ; "You seem to have passed through the deadly gas. You can take off your mask."
						)
					)
					(gEgo view: (if (not global204) 0 else 6))
					(= global140 0)
					(= global156 -1)
				)
			)
			((== global156 -1)
				(= global156 65)
			)
		)
		(cond
			(global139 0)
			((>= (gEgo y:) 190)
				(gCurRoom newRoom: 129)
			)
			((<= (gEgo x:) 5)
				(gCurRoom newRoom: 126)
			)
			((gEgo inRect: 70 70 165 94)
				(gCurRoom newRoom: 124)
			)
		)
		(super doit:)
	)
)

