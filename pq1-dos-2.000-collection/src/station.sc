;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 134)
(include sci.sh)
(use Main)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	station 0
	proc134_2 2
	proc134_3 3
	proc134_4 4
)

(local
	local0
	local1
)

(procedure (proc134_2 param1 &tmp [temp0 2] temp2)
	(= temp2 0)
	(if argc
		(= temp2 param1)
	)
	(gEgo
		loop: 0
		view:
			(switch global206
				(177 178)
				(0 630)
				(1 111)
				(2 631)
			)
		cel: 0
		setCycle: End temp2
	)
)

(procedure (proc134_3 param1 &tmp [temp0 2] temp2)
	(= temp2 0)
	(if argc
		(= temp2 param1)
	)
	(gEgo
		loop: 1
		view:
			(switch global206
				(177 178)
				(0 630)
				(2 631)
				(1 111)
			)
		cel: 0
		setCycle: End temp2
	)
)

(procedure (proc134_4 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 -1)
	(= temp3 (param1 y:))
	(= temp2 (param1 x:))
	(= temp1 (param1 loop:))
	(= temp0 (param1 view:))
	(if (> argc 1)
		(= temp0 param2)
		(if (> argc 2)
			(= temp1 param3)
			(if (> argc 3)
				(= temp2 param4)
				(if (> argc 4)
					(= temp3 param5)
					(if (> argc 5)
						(= temp4 param6)
					)
				)
			)
		)
	)
	(param1
		view: temp0
		setLoop: -1
		setCycle: Walk
		setLoop: Grooper
		setPri: -1
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 0
		cycleSpeed: 6
		moveSpeed: 6
		loop: temp1
		posn: temp2 temp3
		setPri: temp4
	)
)

(class station of Rgn
	(properties
		keep 1
		briefTimedOut 0
		frstWarn 0
		secondWarn 0
	)

	(method (init)
		(super init: &rest)
		(= local0 (gNarrator x:))
		(= local1 (gNarrator y:))
		(gNarrator x: 115)
		(gNarrator y: 20)
		(if (OneOf gCurRoomNum 12 13 18 19)
			(gLongSong number: 120 loop: -1 setVol: 64 play:)
		else
			(gLongSong fade: 0 10 20 1)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 10 11 12 13 14 15 16 17 18 19 20 21 34 35))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gNarrator x: -1)
		(gNarrator y: -1)
		(super dispose: &rest)
	)
)

(class Officer of Actor
	(properties
		oldMover 0
		oldLoop 0
		oldCel 0
		oldCycler 0
		oldSignal 0
		oldScript 0
		oldView 0
		oldAvoider 0
		gabScript 0
		lastPhrase 0
		ignrTimer 0
		saidMessage 0
		willRespond 0
	)

	(method (saveState)
		(= oldMover mover)
		(= oldScript script)
		(= script 0)
	)

	(method (restoreState)
		(= mover oldMover)
		(= script oldScript)
	)

	(method (dispose)
		(if (IsObject gabScript)
			(gabScript dispose:)
		)
		(super dispose: &rest)
	)

	(method (init)
		(super init: &rest)
		(= ignrTimer
			(= saidMessage
				(= lastPhrase
					(= oldAvoider
						(= oldView
							(= oldScript
								(= oldSignal
									(= oldCycler
										(= oldLoop (= oldCel (= oldMover 0)))
									)
								)
							)
						)
					)
				)
			)
		)
		(= willRespond 1)
	)

	(method (turnOnNormal param1 param2 &tmp temp0 temp1)
		(= temp0 view)
		(= temp1 loop)
		(if argc
			(= temp0 param1)
			(if (> argc 1)
				(= temp1 param2)
			)
		)
		(self view: temp0 loop: temp1)
		(= ignrTimer
			(= saidMessage
				(= lastPhrase
					(= oldAvoider
						(= oldView
							(= oldScript
								(= oldSignal
									(= oldCycler
										(= oldLoop (= oldCel (= oldMover 0)))
									)
								)
							)
						)
					)
				)
			)
		)
		(= willRespond 1)
		(proc134_4 self)
	)

	(method (turnOffNormal)
		(= willRespond 0)
	)

	(method (doit)
		(cond
			(
				(or
					(and (self isBlocked:) (not ignrTimer))
					(and (& signal $4000) (not ignrTimer))
				)
				(= ignrTimer 100)
			)
			(ignrTimer
				(if (not (-- ignrTimer))
					(&= signal $fbff)
					(if (& signal $4000)
						(self ignoreActors: 0)
					else
						(= ignrTimer 100)
						(self ignoreActors: 1)
					)
				else
					(super doit: &rest)
				)
			)
			((not willRespond)
				(super doit: &rest)
			)
			(
				(and
					(< (self distanceTo: gEgo) 15)
					(not saidMessage)
					(> (gGame _detailLevel:) 2)
					(not (& signal $0080))
					gabScript
				)
				(= saidMessage 1)
				(self saveState:)
				(self setScript: gabScript)
			)
			((and saidMessage (>= (self distanceTo: gEgo) 30))
				(= saidMessage 0)
			)
			(else
				(super doit: &rest)
			)
		)
	)
)

(instance gab of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client lastPhrase: (mod (+ (client lastPhrase:) 1) 14))
				(gMessager say: 28 0 1 (client lastPhrase:) self 99)
			)
			(1
				(= client 0)
			)
		)
	)
)

