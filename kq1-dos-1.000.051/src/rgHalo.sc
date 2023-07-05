;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 616)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	rgHalo 0
)

(instance rgHalo of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 702)
		(halo
			init:
			hide:
			ignoreHorizon:
			illegalBits: 0
			ignoreActors:
			setCycle: Fwd
		)
		(super init:)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					global124
					(not
						(and
							(== (gEgo view:) 34)
							(or (== (gEgo loop:) 2) (== (gEgo loop:) 3))
						)
					)
				)
				(= temp0 (/ (+ (gEgo nsLeft:) (gEgo nsRight:)) 2))
				(if (gEgo mover:)
					(switch (gEgo loop:)
						(0
							(+= temp0 (gEgo xStep:))
						)
						(1
							(-= temp0 (gEgo xStep:))
						)
					)
				)
				(halo
					posn: temp0 (/ (+ (gEgo nsTop:) (gEgo nsBottom:)) 2)
					setPri: (gEgo priority:)
					show:
				)
			)
			((gCast contains: halo)
				(halo dispose:)
			)
		)
	)
)

(instance halo of Actor
	(properties
		view 702
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/halo,glow,cloud,spell')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 616 0) ; "The fairy godmother's spell is protecting you."
			)
		)
	)
)

