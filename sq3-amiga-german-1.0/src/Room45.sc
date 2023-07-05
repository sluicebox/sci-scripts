;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use regDune)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room45 0
)

(local
	local0
	local1
	local2
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room45 of Rm
	(properties
		picture 45
	)

	(method (init)
		(= north 41)
		(= west 48)
		(= south 49)
		(= east 46)
		(= global591 (= global109 17))
		(self setRegions: 501) ; regDune
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(= global116 0)
		(gEgo init:)
		(lightning view: 69 loop: 4 cel: 0 posn: 218 54 setScript: flash init:)
		(switch gPrevRoomNum
			(41
				(= global104 2)
				(gEgo posn: 165 55 view: 68 setPri: 4 looper: 0 setStep: 1 1)
			)
			(49
				(= global104 0)
				(gEgo view: 0)
				(gEgo posn: (gEgo x:) 188)
			)
			(46
				(switch global104
					(0
						(gEgo posn: 318 (gEgo y:) setStep: 3 2 setPri: -1)
					)
					(3
						(= global104 1)
						(gEgo
							posn: 318 100
							setPri: 4
							setStep: 2 1
							looper: (ScriptID 501 1) ; DUNELOOPER
							ignoreControl: 8192
						)
					)
					(4
						(= global104 2)
						(gEgo
							view: 68
							posn: 318 80
							looper: 0
							setStep: 1 1
							setPri: 4
						)
					)
				)
			)
			(48
				(switch global104
					(0
						(NormalEgo)
						(gEgo view: 0 posn: 1 (gEgo y:))
					)
					(1
						(gEgo
							posn: 1 111
							setPri: 4
							setStep: 2 1
							looper: (ScriptID 501 1) ; DUNELOOPER
							ignoreControl: 8192
						)
					)
					(2
						(gEgo
							view: 68
							posn: 1 89
							looper: 0
							setStep: 1 1
							setPri: 4
						)
					)
				)
			)
			(else
				(gEgo view: 0 posn: 160 160)
			)
		)
		(switch global110
			(1
				(if (== (Random 1 3) 2)
					(= global111 (Actor new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 10))
				)
			)
			(2
				(= global111 (Actor new:))
				(global111 posn: 1000 1000 init:)
				(= global114 3)
			)
		)
		(if (gCast contains: global111)
			(global111
				view: 106
				setCycle: Walk
				observeControl: 2
				posn: 1000 1000
				hide:
				init:
			)
			(= global112 113)
			(= global113 113)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 140)
				)
				(west
					(global111 posn: -40 140)
				)
				(south
					(global111 posn: 160 249)
				)
				(north
					(global111 posn: 113 113)
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		else
			((ScriptID 501 0) notify: 4) ; regDune
		)
	)

	(method (newRoom newRoomNumber)
		(NormalEgo)
		(DisposeScript 988)
		(if
			(and
				(gCast contains: global111)
				(< (gEgo distanceTo: global111) 120)
			)
			(= global110 2)
		)
		(if (not gHandsOff)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(cond
			((& (= local0 (gEgo onControl: 0)) $0008)
				(gCurRoom newRoom: 41)
			)
			((and (== global116 2) (not gHandsOff) (not (& local0 $0002)))
				(= global116 0)
				(if (proc501_2 16)
					(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				)
			)
			((and (== global116 4) (not gHandsOff) (not (& local0 $0004)))
				(= global116 0)
				(gEgo ignoreControl: 4)
			)
			(
				(and
					(& local0 $0002)
					(not gHandsOff)
					(== global104 0)
					(not global116)
				)
				(= global104 1)
				(= global112 (gEgo x:))
				(= global113 (gEgo y:))
				(= global116 2)
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 400)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					xStep: 2
					yStep: 1
					setMotion: MoveTo local2 local1
					setPri: 4
					ignoreControl: 8192
				)
			)
			(
				(and
					(& local0 $0002)
					(not gHandsOff)
					(== global104 1)
					(not global116)
				)
				(= global104 0)
				(= global116 2)
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 0
					xStep: 3
					yStep: 2
					looper: 0
					setMotion: MoveTo local2 local1
					setPri: -1
					observeControl: 8192
					moveSpeed: 0
				)
			)
			(
				(and
					(== global104 1)
					(not gHandsOff)
					(& local0 $0004)
					(not global116)
				)
				(= global116 4)
				(= global104 2)
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 68
					posn: (gEgo x:) (- (gEgo y:) 3)
					observeControl: 4
				)
				(RedrawCast)
				(gEgo
					setStep: 1 1
					looper: 0
					setPri: 4
					setMotion: MoveTo local2 local1
				)
			)
			(
				(and
					(== global104 2)
					(not gHandsOff)
					(& local0 $0004)
					(not global116)
				)
				(= global104 1)
				(= global116 4)
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 -400)
						(= local2 global107)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 82
					posn: (gEgo x:) (- (gEgo y:) 3)
					observeControl: 4
				)
				(RedrawCast)
				(gEgo
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					xStep: 2
					yStep: 1
					setMotion: MoveTo local2 local1
					setPri: 4
					ignoreControl: 8192
				)
			)
			((and (!= global104 2) (== global116 0) (proc501_2 global109))
				(= global104 1)
				(= local1 180)
				(= local2 (gEgo x:))
				(gEgo setPri: 4 posn: (gEgo x:) (+ (gEgo y:) 8))
				(RedrawCast)
				(gEgo
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					xStep: 4
					yStep: 1
					setMotion: MoveTo local2 local1
				)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 5])
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(if (and (Said 'look,look>') (Said '[<around,at,in][/area]'))
					(Print 45 0) ; "You see large sand dunes, but that's about it."
				)
			)
		)
	)
)

(instance flash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 8 30))
			)
			(1
				(lightning cel: 255 setCycle: End self)
			)
			(2
				(lightning cel: 0)
				(= seconds (Random 2 5))
			)
			(3
				(thunder priority: 2 number: (Random 31 32) play: self)
			)
			(4
				(= state -1)
			)
		)
	)
)

