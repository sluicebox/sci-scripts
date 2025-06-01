;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 131)
(include sci.sh)
(use Main)
(use Interface)
(use AutoDoor)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm131 0
)

(local
	local0
	local1
	[local2 5]
)

(instance bainsShot of Sound
	(properties
		number 41
		priority 10
	)
)

(instance rm131 of Rm
	(properties
		picture 76
		style 0
	)

	(method (dispose)
		(DisposeScript 301)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 205) ; sewer
		(super init:)
		((= local0 (AutoDoor new:))
			doorControl: 4096
			entranceTo: 133
			facingLoop: 3
			view: 293
			loop: 0
			posn: 184 82
			setPri: 1
			stopUpd:
			init:
		)
		(gEgo
			view: (if (not global204) 0 else 6)
			x:
				(switch gPrevRoomNum
					(130 10)
					(133 180)
					(132 310)
				)
			y:
				(cond
					((== gPrevRoomNum 133) 85)
					((<= (gEgo y:) 115) 100)
					(else 140)
				)
			init:
		)
		(HandsOn)
		((= [local2 0] (Prop new:))
			view: 99
			loop: 0
			cel: 1
			posn: 319 131
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local2 1] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 237 130
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local2 2] (Prop new:))
			view: 99
			loop: 0
			cel: 1
			posn: 120 131
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local2 3] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 133 173
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local2 4] (Prop new:))
			view: 99
			loop: 0
			cel: 0
			posn: 192 125
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local2 0] stopUpd:)
			([local2 2] stopUpd:)
		)
		(if (< global110 30)
			([local2 1] stopUpd:)
			([local2 3] stopUpd:)
			([local2 4] stopUpd:)
		)
		(gLightObj posn: 167 54 ignoreActors: 1 init: stopUpd:)
		(if global203
			(Load rsVIEW 13)
			(Load rsVIEW 15)
			((= local1 (Act new:))
				view: 13
				posn: 110 100
				loop: 0
				cel: 0
				init:
				setCycle: Walk
				setScript: bainsKillsScript
			)
		)
	)

	(method (doit)
		(cond
			(global139 0)
			((<= (gEgo x:) 5)
				(gCurRoom newRoom: 130)
			)
			((>= (gEgo x:) 315)
				(gCurRoom newRoom: 132)
			)
			((== (local0 doorState:) 2)
				(gEgo heading: 0 setMotion: MoveTo 180 10)
				(gCurRoom newRoom: 133)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '[<around][/(!*,chamber,sewer)]')
						(Print 131 0) ; "You have entered the City of Steelton's underground sewer complex. The dampness and subdued light gives you an eerie feeling..."
						(Print 131 1) ; "There is a door here leading to ???"
					)
					((Said 'look/door')
						(Print 131 2) ; "You wonder what's behind it?"
					)
					((Said 'open/door')
						(Print 131 3) ; "Just walk up to it."
					)
					((Said '*/door')
						(Print 131 4) ; "You don't need to."
					)
				)
			)
		)
	)
)

(instance bainsKillsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setMotion: MoveTo 130 100 self)
				(HandsOff)
			)
			(1
				(local1 view: 15 loop: 0 cel: 0 setCycle: End self)
				(bainsShot play:)
			)
			(2
				(gEgo
					view: 297
					illegalBits: 0
					x: 184
					loop: 3
					setCycle: End self
				)
			)
			(3
				(EgoDead 131 5) ; "Unfortunately, Bains was waiting for you."
			)
		)
	)
)

