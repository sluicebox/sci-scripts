;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
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
	Room48 0
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

(instance Room48 of Rm
	(properties
		picture 48
	)

	(method (init)
		(= north 44)
		(= west 47)
		(= east 45)
		(= south 52)
		(= global591 (= global109 5))
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(= global116 0)
		(gEgo init:)
		(lightning view: 69 loop: 0 cel: 0 posn: 80 10 setScript: flash init:)
		(switch gPrevRoomNum
			(north
				(= global104 2)
				(gEgo
					posn: 112 86
					view: 68
					looper: 0
					setPri: 2
					ignoreControl: 8192
				)
			)
			(south
				(= global104 0)
				(NormalEgo)
				(gEgo
					posn: (gEgo x:) 188
					view: 0
					looper: 0
					setPri: -1
					observeControl: 8192
				)
			)
			(west
				(switch global104
					(0
						(gEgo
							posn: 1 (gEgo y:)
							setStep: 3 2
							observeControl: 8192
							setPri: -1
						)
					)
					(1
						(gEgo
							posn: 1 122
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							looper: (ScriptID 501 1) ; DUNELOOPER
							setPri: 2
						)
					)
					(3
						(= global104 1)
						(gEgo
							posn: 1 122
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							looper: (ScriptID 501 1) ; DUNELOOPER
							setPri: 2
						)
					)
					(2
						(= global104 1)
						(gEgo
							posn: 1 122
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							looper: (ScriptID 501 1) ; DUNELOOPER
							setPri: 2
						)
					)
					(4
						(= global104 2)
						(gEgo
							view: 68
							posn: 1 98
							looper: 0
							ignoreControl: 8192
							setStep: 1 1
							setPri: 2
						)
					)
				)
			)
			(east
				(switch global104
					(0
						(NormalEgo)
						(gEgo
							posn: 318 (gEgo y:)
							observeControl: 8192
							setStep: 3 2
						)
					)
					(1
						(gEgo
							posn: 318 111
							setPri: 2
							setStep: 2 1
							looper: (ScriptID 501 1) ; DUNELOOPER
						)
					)
					(2
						(gEgo
							view: 68
							posn: 318 89
							looper: 0
							setStep: 1 1
							setPri: 2
						)
					)
				)
			)
			(else
				(gEgo view: 0 posn: 160 160)
			)
		)
		(self setRegions: 501) ; regDune
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
				init:
			)
			(= global112 47)
			(= global113 109)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 150)
				)
				(west
					(global111 posn: -40 150)
				)
				(south
					(global111 posn: 213 249)
				)
				(north
					(global111 posn: 47 109)
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		else
			((ScriptID 501 0) notify: 4) ; regDune
		)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 988)
		(NormalEgo)
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
				(gCurRoom newRoom: 44)
			)
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (proc501_2 4)
					(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				)
			)
			((and (== global116 4) (not (& local0 $0004)))
				(gEgo ignoreControl: 4)
				(= global116 0)
			)
			(
				(and
					(& local0 $0002)
					(== global104 0)
					(not gHandsOff)
					(not global116)
				)
				(= global104 1)
				(= global116 2)
				(= global112 (gEgo x:))
				(= global113 (gEgo y:))
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 400)
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
					(== global104 1)
					(not gHandsOff)
					(not global116)
				)
				(= global116 2)
				(= global104 0)
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
					(& local0 $0004)
					(not gHandsOff)
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
					view: 68
					looper: 0
					setStep: 1 1
					setPri: 4
					setMotion: MoveTo local2 local1
				)
			)
			(
				(and
					(== global104 2)
					(& local0 $0004)
					(not gHandsOff)
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
					(!= global104 2)
					(== global116 0)
					(or (proc501_2 global109) (< (gEgo y:) 85))
				)
				(= global104 1)
				(= local1 180)
				(= local2 (gEgo x:))
				(gEgo setPri: 3 posn: (gEgo x:) (+ (gEgo y:) 8))
				(RedrawCast)
				(gEgo
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					xStep: 2
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
				(if (Said 'look,look>')
					(cond
						((Said '[<around,at,in][/area]')
							(Print 48 0) ; "There are fewer rocks and more sand in this area."
						)
						((Said '/rock')
							(Print 48 1) ; "Just another bizarre rock formation pay it no mind."
						)
						((Said '/cavity')
							(Print 48 2) ; "Yes, there's a large hole in the rock formation."
						)
					)
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
				(= cycles 2)
			)
		)
	)
)

