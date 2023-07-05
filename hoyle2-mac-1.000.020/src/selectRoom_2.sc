;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	selectRoom 0
	proc2_1 1
)

(local
	local0
	local1
)

(procedure (proc2_1)
	(difficulty1 posn: 500 500)
	(difficulty2 posn: 500 500)
	(theTitle2 posn: 500 500)
	(proc0_2)
)

(class GameView of Feature
	(properties
		gameNum 0
		nsRight 0
		nsBottom 0
		nsLeft 0
		nsTop 0
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
				(== (event type:) evMOUSEBUTTON)
			)
			(event claimed: 1)
			(= local0 (- gameNum 100))
			(proc0_1 (if (== (Graph grGET_COLOURS) 16) 602 else 600) 9 2 x y 15)
			(proc0_2)
			(= gNewRoomNum 1)
			(= global337 (+ gameNum (- (* global681 100) 100)))
			(gOptions_sol doit: 1)
		)
	)
)

(instance gameViews of List
	(properties)
)

(instance selectRoom of Rm
	(properties)

	(method (init &tmp temp0 temp1 [temp2 2])
		(KeyMouse allowance: 8)
		(= picture 26)
		(= local1 0)
		(if (== (Graph grGET_COLOURS) 16)
			(= picture 12)
			(= local1 2)
		)
		(= gShowStyle 7)
		(super init:)
		(if (not global686)
			(MenuBar init:)
		)
		(= global686 0)
		(Load rsVIEW 600)
		(Load rsSOUND 212)
		(Load rsSOUND 213)
		(= global638 3)
		(= global639 0)
		(gameViews add:)
		(gGame setCursor: 999)
		(gMainKeyMouseList add: difficulty1 difficulty2)
		(for ((= global301 0)) (< global301 28) ((++ global301))
			(= temp1 (GameView new:))
			(temp1 gameNum: (+ 100 global301))
			(gameViews add: temp1)
			(gMainKeyMouseList add: temp1)
			(temp1
				x: (if (< global301 14) 90 else 240)
				y: (+ (* (mod global301 14) 11) 40)
			)
			(temp1
				nsBottom: (temp1 y:)
				nsTop:
					(-
						(temp1 y:)
						(CelHigh
							(+ 600 local1)
							(mod global301 10)
							(/ global301 10)
						)
					)
				nsLeft:
					(-
						(temp1 x:)
						(/
							(CelWide
								(+ 600 local1)
								(mod global301 10)
								(/ global301 10)
							)
							2
						)
					)
				nsRight:
					(+
						(temp1 x:)
						(/
							(CelWide
								(+ 600 local1)
								(mod global301 10)
								(/ global301 10)
							)
							2
						)
					)
			)
			(proc0_1
				(+ 600 local1)
				(mod global301 10)
				(/ global301 10)
				(if (< global301 14) 90 else 240)
				(+ (* (mod global301 14) 11) 40)
				8
			)
		)
		(difficulty1 loop: 2 cel: (if (== global681 1) 1 else 0) init:)
		(difficulty2 loop: 4 cel: (if (== global681 1) 0 else 1) init:)
		(theTitle init:)
		(theTitle addToPic:)
		(theTitle2 init:)
	)

	(method (handleEvent event)
		(difficulty1 handleEvent: event)
		(difficulty2 handleEvent: event)
		(gameViews eachElementDo: #handleEvent event)
	)

	(method (dispose)
		(gMainKeyMouseList empty:)
		(gameViews eachElementDo: #dispose dispose:)
		(theTitle dispose:)
		(super dispose:)
	)
)

(instance theTitle of View
	(properties
		y 25
		x 160
		view 603
		priority 9
	)

	(method (init)
		(self posn: x y setPri: priority)
		(super init:)
	)
)

(instance theTitle2 of Prop
	(properties
		y 24
		x 160
		view 603
		loop 1
		priority 8
	)

	(method (init)
		(self posn: x y setPri: priority setLoop: loop setCycle: Fwd)
		(super init:)
	)
)

(instance difficulty1 of View
	(properties
		y 10
		x 6
		view 603
		priority 9
	)

	(method (init)
		(self posn: x y setPri: priority)
		(super init:)
		(self forceUpd:)
	)

	(method (handleEvent event)
		(if
			(and
				(event type:)
				(!= (event type:) $0040) ; direction
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			(= cel (= global681 1))
			(difficulty2 cel: 0)
			(self init:)
			(difficulty2 init:)
		)
	)
)

(instance difficulty2 of View
	(properties
		y 10
		x 280
		view 603
		priority 9
	)

	(method (init)
		(self posn: x y setPri: priority)
		(super init:)
		(self forceUpd:)
	)

	(method (handleEvent event)
		(if
			(and
				(event type:)
				(!= (event type:) $0040) ; direction
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			(= cel 1)
			(difficulty1 cel: 0)
			(= global681 4)
			(self init:)
			(difficulty1 init:)
		)
	)
)

