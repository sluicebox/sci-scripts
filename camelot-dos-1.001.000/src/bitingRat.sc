;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 172)
(include sci.sh)
(use Main)
(use Interface)
(use EgoLooper)
(use Motion)
(use Actor)
(use System)

(public
	bitingRat 0
)

(procedure (localproc_0)
	(cond
		((== (++ global171) 1)
			(= global167 32000)
		)
		((< (/= global167 2) 2)
			(= global167 2)
		)
	)
	(if (not (IsFlag 182))
		(switch global171
			(1
				(Print 172 0) ; "A rat has bitten you! You may not feel the effects of its poison for a long time, yet the hierophant warned that it means certain death."
			)
			(2
				(Print 172 1) ; "Another rat has bitten you! The poison will now act twice as quickly!"
			)
			(3
				(Print 172 2) ; "You have been bitten yet again! Now your time is truly limited."
			)
			(4
				(= global167 2)
			)
		)
	)
)

(instance bitingRat of Act
	(properties
		yStep 6
		signal 16384
		illegalBits 0
		xStep 12
	)

	(method (init)
		(super init:)
		(self setScript: RatBite)
	)
)

(class RatBite of Script
	(properties
		ratBiting 0
		midPointX 0
		offControlsX 0
		offControlsY 0
		gotoX1 0
		gotoY1 0
		gotoX2 0
		gotoY2 0
		savedIllBits 0
		optCel 0
		optPri -1
		spread 255
		oldEgoCycler 0
	)

	(method (init)
		(super init: &rest)
		(ClearFlag 179)
		(SetFlag 183)
		(= oldEgoCycler (gEgo cycler:))
		(gEgo cycler: 0 looper: 0)
		(if (not offControlsX)
			(self
				offControlsX:
					(cond
						(midPointX
							(gEgo x:)
						)
						((< (gEgo x:) 148)
							(+ (gEgo x:) 20)
						)
						(else
							(- (gEgo x:) 20)
						)
					)
				offControlsY:
					(if midPointX
						(+ (gEgo y:) 15)
					else
						(gEgo y:)
					)
			)
		)
		(cond
			((< (gEgo x:) midPointX)
				(= ratBiting 7)
				(bitingRat
					x:
						(if (> (+ (gEgo x:) 22) (+ midPointX spread))
							(+ midPointX spread)
						else
							(+ (gEgo x:) 22)
						)
					loop: 3
				)
			)
			((and midPointX (> (gEgo x:) midPointX))
				(= ratBiting 6)
				(bitingRat
					x:
						(if (< (- (gEgo x:) 20) (- midPointX spread))
							(- midPointX spread)
						else
							(- (gEgo x:) 20)
						)
					loop: 2
				)
			)
			((< (gEgo x:) 148)
				(= ratBiting 4)
				(bitingRat loop: 0)
			)
			(else
				(= ratBiting 5)
				(bitingRat loop: 1)
			)
		)
		(= savedIllBits (gEgo illegalBits:))
		(self changeState: 1)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 2) (== (gSFX prevSignal:) 10))
			(= seconds 0)
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gSFX number: 67 loop: 1 play:)
				(bitingRat
					view: 420
					cel: optCel
					posn:
						(bitingRat x:)
						(- (gEgo y:) 1)
						(- (gEgo y:) (bitingRat y:))
					setPri: optPri
					setCycle: CT 6 1 self
				)
			)
			(2
				(gEgo setLoop: (if (< (gEgo x:) 150) 0 else 1))
				(bitingRat
					setLoop: ratBiting
					setCycle: Fwd
					posn:
						(+
							(gEgo x:)
							(if (or (== ratBiting 4) (== ratBiting 6))
								-3
							else
								2
							)
						)
						(gEgo y:)
						46
				)
				(if global124
					(= global124 0)
					(gEgo view: 4 cel: 3 setCycle: CT 0 -1)
				)
				(= seconds 4)
			)
			(3
				(gEgo view: 48 cel: 0 setCycle: End self)
			)
			(4
				(bitingRat posn: 500 500 0)
				(gEgo
					setLoop: (+ (gEgo loop:) 2)
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(5
				(gSFX stop: number: (proc0_20 68) play:)
				(gEgo setLoop: (- (gEgo loop:) 2) cel: 0)
				(bitingRat
					setPri: -1
					view: 419
					loop: (+ (gEgo loop:) 2)
					posn:
						(+ (gEgo x:) (if (gEgo loop:) -40 else 40))
						(+ (gEgo y:) 1)
					setCycle: Fwd
				)
				(= cycles 5)
			)
			(6
				(gEgo
					view: (if (< 0 global167 50) 57 else 0)
					setLoop: -1
					cycler: oldEgoCycler
					looper: EgoLooper
					setMotion: MoveTo offControlsX offControlsY
				)
				(bitingRat
					setLoop: -1
					setCycle: Walk
					view: 418
					setMotion: MoveTo gotoX1 gotoY1 self
				)
			)
			(7
				(bitingRat setMotion: MoveTo gotoX2 gotoY2 self)
			)
			(8
				(if
					(and
						(!= (gEgo x:) offControlsX)
						(!= (gEgo y:) offControlsY)
					)
					(gEgo setMotion: MoveTo offControlsX offControlsY self)
				else
					(self cue:)
				)
			)
			(9
				(= ratBiting (= offControlsX (= offControlsY 0)))
				(= optCel 1)
				(= optPri -1)
				(= spread 255)
				(gEgo illegalBits: savedIllBits)
				(localproc_0)
				(bitingRat dispose: delete:)
				(ClearFlag 183)
				(HandsOn)
				(DisposeScript 172)
			)
		)
	)
)

