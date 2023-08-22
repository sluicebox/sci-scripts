;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 209)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm209 0
)

(local
	[local0 4] = [15 16 210 211]
	local4
)

(instance rm209 of Rm
	(properties
		picture 916
		horizon 90
		north 15
		east 15
		south 15
		west 15
	)

	(method (init)
		(= global322 0)
		(self picture: [local0 (mod (+ global314 global315) 4)])
		(switch global314
			(3)
			(4)
			(6)
			(else
				(oasis view: 915 loop: 0 cel: 1 posn: 207 100)
			)
		)
		(super init:)
		(oasis init:)
		(gEgo setPri: -1 illegalBits: -32768 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $0002)
				(= temp0 north)
				(gCurRoom newRoom: temp0)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gEgo ignoreControl: 16384)
				(switch (gEgo edgeHit:)
					(EDGE_TOP
						(-- global315)
					)
					(EDGE_BOTTOM
						(++ global315)
					)
					(EDGE_RIGHT
						(-- global314)
					)
					(EDGE_LEFT
						(++ global314)
					)
				)
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 1) $0200)
				(gEgo view: 26)
			)
			((& (gEgo onControl: 1) $0400)
				(gEgo view: 28)
			)
			(
				(and
					(not (& (gEgo onControl: 1) $0200))
					(not (& (gEgo onControl: 1) $0400))
					(not (== (gEgo view:) 0))
				)
				(gEgo view: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance drink of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance oasis of Prop
	(properties
		y 100
		x 207
		view 915
		cel 1
		priority 10
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 209 0) ; "A small oasis! Its tantalizing water; so sparkling in the desert sun! Graham's hot, thirsty body is irresistibly drawn to it."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local4)
						(++ local4)
						(PrintDC 209 1) ; "Ah! Life-giving water! Nectar of the gods! Graham can now feel renewal flowing through him."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

