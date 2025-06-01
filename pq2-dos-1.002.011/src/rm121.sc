;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm121 0
)

(local
	local0
	[local1 4]
	local5
)

(instance rm121 of Rm
	(properties
		picture 70
		style 0
	)

	(method (dispose)
		(downDrainPipe dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(gEgo
			view: (if (not global204) 0 else 6)
			x: (if (== gPrevRoomNum 120) 12 else 310)
			y: (if (<= (gEgo y:) 115) 100 else 140)
			init:
			forceUpd:
		)
		(if (== gPrevRoomNum 122)
			(= global156 -1)
		)
		(HandsOn)
		((= local0 (Prop new:))
			view: 92
			loop: 0
			cel: 0
			posn: 305 115
			setPri: 1
			ignoreActors: 1
			init:
			stopUpd:
		)
		((Prop new:)
			view: 92
			loop: 2
			cel: 3
			posn: 114 116
			setPri: 1
			setCycle: Fwd
			ignoreActors: 1
			init:
		)
		((= [local1 0] (Prop new:))
			view: 99
			loop: 0
			cel: 1
			posn: 319 126
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors:
			init:
		)
		((= [local1 1] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 237 130
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors:
			init:
		)
		((= [local1 2] (Prop new:))
			view: 99
			loop: 0
			cel: 1
			posn: 120 126
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors:
			init:
		)
		((= [local1 3] (Prop new:))
			view: 99
			loop: 0
			cel: 0
			posn: 207 132
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors:
			init:
		)
		(if (< global110 60)
			([local1 0] stopUpd:)
			([local1 1] stopUpd:)
		)
		(if (< global110 30)
			([local1 2] stopUpd:)
			([local1 3] stopUpd:)
		)
		(gRatObj
			name: 7
			posn: 287 57
			setLoop: 2
			ignoreActors: 1
			init:
			setMotion: MoveTo -100 57 gRatObj
		)
		(gLightObj posn: 167 54 ignoreActors: 1 stopUpd: init:)
		(= local5 0)
	)

	(method (doit)
		(cond
			(global139 0)
			((<= (gEgo x:) 5)
				(gCurRoom newRoom: 120)
			)
			((>= (gEgo x:) 315)
				(gCurRoom newRoom: 122)
			)
			((gEgo inRect: 292 92 303 108)
				(if (not local5)
					(= local5 1)
					(if (and (== (Random 0 4) 3) (not global139))
						(= global139 1)
						(gEgo setScript: downDrainPipe)
					)
				)
			)
			(else
				(= local5 0)
			)
		)
		(super doit:)
	)
)

(instance downDrainPipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global139 1)
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
				(= cycles 10)
			)
			(3
				(Print 121 0) ; "You step into the path of high pressure water being released from the surface..."
				(Print 121 1) ; "And you're swept into the sewer . Your head hits hard during the fall, rendering you unconscious..."
				(Print 121 2) ; "Unfortunately for you, the sewer does the rest."
				(EgoDead 121 3) ; "You drown in the sewer because of an unfortunate accident. Next time, try to minimize the chance of it happening again."
			)
		)
	)
)

