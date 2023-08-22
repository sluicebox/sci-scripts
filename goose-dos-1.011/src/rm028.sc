;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Game)
(use Actor)

(public
	rm028 0
)

(instance rm028 of Rm
	(properties
		picture 28
		style 0
		horizon 105
		south 35
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 300)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(21
				(gEgo
					x: (+ (/ (* (- (gEgo x:) 149) 20) 26) 177)
					setPri: -1
				)
			)
			(27
				(gEgo y: (+ (/ (* (- (gEgo y:) 117) 75) 71) 113))
			)
			(35
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 86) 45) 1))
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10 75 150)
		(flower init:)
		((Clone flower) loop: 1 cel: 1 x: 190 y: 182 init:)
		((Clone flower) loop: 1 cel: 2 x: 123 y: 172 init:)
		((Clone flower) loop: 2 cel: 1 x: 201 y: 181 init:)
		((Clone flower) loop: 1 cel: 1 x: 135 y: 169 init:)
		((Clone flower) loop: 2 cel: 1 x: 163 y: 107 init:)
		((Clone flower) loop: 2 cel: 2 x: 154 y: 106 init:)
		((Clone flower) loop: 2 cel: 0 x: 145 y: 108 init:)
		((Clone flower) loop: 2 cel: 2 x: 119 y: 108 init:)
		((Clone flower) loop: 2 cel: 1 x: 108 y: 106 init:)
		((Clone flower) loop: 2 cel: 1 x: 90 y: 106 init:)
		((Clone flower) loop: 2 cel: 0 x: 247 y: 105 init:)
		((Clone flower) loop: 2 cel: 2 x: 237 y: 104 init:)
		((Clone flower) loop: 2 cel: 0 x: 230 y: 106 init:)
		((Clone flower) loop: 2 cel: 2 x: 222 y: 107 init:)
		((Clone flower) loop: 2 cel: 1 x: 211 y: 106 init:)
		((Clone flower) loop: 2 cel: 1 x: 262 y: 108 init:)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_LEFT)
				(if (== global111 46)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 27)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(if (== global111 54)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 21)
			)
		)
		(super doit:)
	)
)

(instance flower of View
	(properties
		y 182
		x 208
		view 300
		loop 1
	)
)

