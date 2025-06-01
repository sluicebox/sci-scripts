;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	local0
	[local1 3]
	local4
	local5
)

(instance rm130 of Rm
	(properties
		picture 201
		style 0
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(HandsOn)
		(gEgo
			view: (if (not global204) 0 else 6)
			x:
				(switch gPrevRoomNum
					(128
						(if (<= (gEgo x:) 70) 165 else 237)
					)
					(131 310)
				)
			y:
				(switch gPrevRoomNum
					(128
						(if (<= (gEgo x:) 70) 100 else 95)
					)
					(131
						(if (<= (gEgo y:) 115) 100 else 135)
					)
				)
			init:
		)
		((= local0 (Prop new:))
			view: 92
			loop: 0
			cel: 0
			posn: 286 117
			setPri: 3
			ignoreActors: 1
			init:
			stopUpd:
		)
		((= [local1 0] (Prop new:))
			view: 99
			loop: 1
			cel: 2
			posn: 317 130
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local1 1] (Prop new:))
			view: 99
			loop: 3
			cel: 0
			posn: 176 141
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local1 2] (Prop new:))
			view: 99
			loop: 3
			cel: 1
			posn: 133 173
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local1 0] stopUpd:)
		)
		(if (< global110 30)
			([local1 1] stopUpd:)
			([local1 2] stopUpd:)
		)
		(gRatObj
			name: 2
			setLoop: 3
			illegalBits: 0
			posn: 249 65
			ignoreActors: 1
			init:
			setMotion: MoveTo 400 65 gRatObj
		)
		(= local5 0)
		(gLightObj posn: 127 78 ignoreActors: 1 init: stopUpd:)
		(global115 posn: 226 56 ignoreActors: 1 init: stopUpd:)
	)

	(method (doit)
		(cond
			(global139 0)
			((>= (gEgo x:) 315)
				(gCurRoom newRoom: 131)
			)
			((gEgo inRect: 175 85 250 94)
				(gCurRoom newRoom: 128)
			)
			((gEgo inRect: 0 190 150 200)
				(if (not local4)
					(= local4 1)
					(Print 130 0) ; "You are at a dead end."
					(gEgo setMotion: MoveTo (gEgo x:) 180)
				)
			)
			((and (gEgo inRect: 280 92 290 108) (not local5))
				(= local5 1)
				(if (== (Random 0 4) 3)
					(= global139 1)
					(gEgo setScript: drainPipeScript)
				)
			)
			(else
				(= local5 0)
				(= local4 0)
			)
		)
		(super doit:)
	)
)

(instance drainPipeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 92
					setLoop: 1
					cel: 0
					yStep: 1
					illegalBits: 0
					setMotion: MoveTo 304 110
					setCycle: CT 2 1
				)
				(local0 setCycle: CT 3 1 self)
				(gContinuousMusic stop: number: 24 loop: 1 priority: 12 play:)
			)
			(1
				(gEgo yStep: 3 setMotion: MoveTo 304 115 setCycle: CT 4 1)
				(local0 setCycle: CT 6 1 self)
			)
			(2
				(gEgo setMotion: MoveTo 304 125 setCycle: CT 7 1)
				(local0 setCycle: CT 10 1)
				(Timer setCycle: self 10)
			)
			(3
				(Print 130 1) ; "You step into the path of high pressure water being released from the surface..."
				(Print 130 2) ; "And you're swept into the sewer . Your head hits hard during the fall, rendering you unconscious..."
				(Print 130 3) ; "Unfortunately for you, the sewer does the rest."
				(gEgo dispose:)
				(EgoDead 130 4) ; "You drown in the sewer because of an unfortunate accident. Next time, try to minimize the chance of it happening again."
			)
		)
	)
)

