;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room32 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance Room32 of Rm
	(properties
		picture 32
	)

	(method (init)
		(Load rsVIEW 9)
		(= north 40)
		(= west (= east (= south 31)))
		(= horizon 114)
		(super init:)
		(self setRegions: 504 519) ; Gull_Region, Ocean_Region
		(= local0 (Prop new:))
		(= local1 (Prop new:))
		(= local2 (Prop new:))
		(= local3 (Prop new:))
		(= local4 (View new:))
		(local4 view: 613 loop: 2 cel: 0 posn: 163 62 setPri: 2 init: stopUpd:)
		(local0
			view: 660
			loop: 0
			cel: 1
			posn: 79 81
			ignoreActors:
			setPri: 4
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(local1
			view: 660
			loop: 1
			cel: 2
			posn: 118 92
			ignoreActors:
			setPri: 5
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(local2
			view: 660
			loop: 2
			cel: 0
			posn: 214 93
			ignoreActors:
			setPri: 5
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(local3
			view: 660
			loop: 3
			cel: 3
			posn: 266 86
			ignoreActors:
			setPri: 5
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(if gNight
			(= picture 132)
		)
		(if (>= (gEgo x:) 319)
			(gEgo x: 1)
		)
		(if (<= (gEgo x:) 0)
			(gEgo x: 318)
		)
		(switch gPrevRoomNum
			(41
				(gEgo posn: 226 (+ horizon 1))
			)
			(40
				(gEgo posn: 164 (+ horizon 1))
			)
			(39
				(gEgo posn: 100 (+ horizon 1))
			)
		)
		(if (< (gEgo y:) horizon)
			(gEgo y: (+ horizon (gEgo yStep:) 1))
		)
		(gEgo view: 9 setCycle: Fwd init:)
	)

	(method (newRoom newRoomNumber)
		(if (== (gEgo edgeHit:) 1)
			(cond
				((< (gEgo x:) 115)
					(super newRoom: 39)
				)
				((> (gEgo x:) 198)
					(super newRoom: 41)
				)
				(else
					(super newRoom: 40)
				)
			)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '/tamir')
					(Print 32 0) ; "You see Tamir in the distance."
				)
				((Said '/island')
					(Print 32 1) ; "The small island contains a beautiful white palace. Lush vegetation encircles it."
				)
				((Said '/castle')
					(Print 32 2) ; "The white palace is quite enchanting! (Maybe it IS enchanted). With its tall slender towers, lovely arched windows, and beautiful island setting, the palace radiates goodness, peace, and serenity."
				)
				((Said '/fish')
					(Print 32 3) ; "You don't see any here."
				)
				((Said '[<around][/room]')
					(Print 32 4) ; "As you swim, you notice a splendid white palace on a small island to the north."
				)
			)
		)
	)
)

