;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm017 0
)

(instance rm017 of Rm
	(properties
		picture 17
		style 0
		horizon 95
		north 10
		east 18
		south 24
		west 16
		picAngle 75
	)

	(method (init)
		(Load rsVIEW 300)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(9
				(= global126 5)
				(gEgo posn: 19 102)
			)
			(10
				(= global126 5)
				(cond
					((< (gEgo x:) 72)
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 0) 31) 19) 36)
							y: (+ horizon 1)
						)
					)
					((> (gEgo x:) 280)
						(gEgo posn: 316 118 setPri: -1)
					)
					(else
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 83) 15) 36) 117)
							y: 124
							edgeHit: 0
						)
					)
				)
			)
			(16
				(= global126 5)
				(if (and (> (gEgo y:) 116) (< (gEgo y:) 127))
					(gEgo y: 130)
				else
					(gEgo y: (+ (/ (* (- (gEgo y:) 94) 22) 69) 106))
				)
			)
			(18
				(= global126 5)
				(if (> (gEgo y:) 122)
					(gEgo
						y:
							(if (<= (gEgo y:) horizon)
								(+ horizon 1)
							else
								(gEgo y:)
							)
					)
				else
					(gEgo posn: 316 118)
				)
			)
			(24
				(gEgo x: (+ (/ (* (- (gEgo x:) 219) 146) 79) 92))
			)
			(25
				(gEgo x: (+ (/ (* (- (gEgo x:) 58) 38) 18) 280))
			)
			(else
				(gEgo posn: 160 125)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
		(if global131
			(smoke init:)
		else
			(smoke init: addToPic:)
		)
		(gEgo init:)
		(proc0_10 105 180)
		(gAddToPics
			add:
				flower
				((Clone flower) loop: 0 cel: 1 x: 42 y: 190)
				((Clone flower) loop: 0 cel: 2 x: 26 y: 182)
				((Clone flower) loop: 1 cel: 2 x: 217 y: 149)
				((Clone flower) loop: 1 cel: 1 x: 16 y: 189)
				((Clone flower) loop: 1 cel: 1 x: 198 y: 161)
				((Clone flower) loop: 0 cel: 0 x: 76 y: 189)
				((Clone flower) loop: 0 cel: 1 x: 72 y: 184)
				((Clone flower) loop: 0 cel: 2 x: 66 y: 180)
				((Clone flower) loop: 1 cel: 2 x: 67 y: 187)
				((Clone flower) loop: 1 cel: 1 x: 62 y: 182)
				((Clone flower) loop: 1 cel: 1 x: 53 y: 188)
				((Clone flower) loop: 0 cel: 0 x: 124 y: 147)
				((Clone flower) loop: 1 cel: 1 x: 171 y: 146)
				((Clone flower) loop: 1 cel: 2 x: 163 y: 147)
				((Clone flower) loop: 1 cel: 2 x: 95 y: 152)
				((Clone flower) loop: 1 cel: 0 x: 105 y: 147)
				((Clone flower) loop: 1 cel: 0 x: 197 y: 179)
			eachElementDo: #init
			doit:
		)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) 2)
			(if (== global111 60)
				(gGlobalMGSound fade:)
			)
			(gCurRoom newRoom: 18)
		)
		(if (== (gEgo onControl: 1) 8)
			(gCurRoom newRoom: 9)
		)
		(if (== (gEgo onControl: 1) 2)
			(gCurRoom newRoom: 3)
		)
		(if (== (gEgo onControl: 1) 4)
			(gCurRoom newRoom: 10)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 24)
			(= newRoomNumber (if (< (gEgo x:) 260) 24 else 25))
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= global126 35)
		(super dispose:)
	)
)

(instance flower of View
	(properties
		x 39
		y 184
		view 300
	)
)

(instance smoke of Prop
	(properties
		signal 16384
	)

	(method (init)
		(super init:)
		(self
			view: 320
			setLoop: 1
			posn: 208 8
			cycleSpeed: 2
			setPri: 1
			setCycle: Fwd
		)
	)
)

