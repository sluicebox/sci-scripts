;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use regDune)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room47 0
)

(local
	local0
	local1
	local2
	local3
)

(instance tin of View
	(properties)
)

(instance rightArm of Prop
	(properties)
)

(instance leftArm of Prop
	(properties)
)

(instance mouth of Prop
	(properties)
)

(instance Room47 of Rm
	(properties
		picture 47
	)

	(method (init)
		(= east 48)
		(= west 46)
		(= south 51)
		(= global109 13)
		(= local3 5)
		(= global591 (| global109 $0005))
		(super init:)
		(= global116 0)
		(tin
			view: 72
			loop: 2
			cel: 0
			ignoreActors:
			posn: 190 66
			setPri: 0
			init:
			addToPic:
		)
		(rightArm
			view: 72
			ignoreActors:
			loop: 0
			cel: 8
			posn: 209 66
			setPri: 0
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		(leftArm
			view: 72
			ignoreActors:
			loop: 1
			cel: 0
			posn: 170 66
			setPri: 0
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		(mouth
			view: 72
			ignoreActors:
			loop: 3
			cel: 1
			posn: 190 56
			setPri: 1
			cycleSpeed: 2
			setCycle: Fwd
			init:
		)
		(if (not global124)
			(leftArm addToPic:)
			(rightArm cel: 5 addToPic:)
			(mouth addToPic:)
		)
		(gEgo init:)
		(NormalEgo)
		(switch gPrevRoomNum
			(43
				(= global104 4)
				(gEgo posn: 192 72 view: 68 setPri: 2 setStep: 1 1)
			)
			(46
				(switch global104
					(4
						(gEgo posn: 1 90 view: 68 setStep: 1 1 setPri: 2)
					)
					(0
						(gEgo posn: 1 (gEgo y:))
					)
					(3
						(gEgo posn: 1 85 looper: (ScriptID 501 1) setPri: 2) ; DUNELOOPER
					)
					(1
						(gEgo
							posn: 1 (gEgo y:)
							looper: (ScriptID 501 1) ; DUNELOOPER
							setPri: 4
						)
					)
					(2
						(gEgo
							posn: 1 (gEgo y:)
							view: 82
							setStep: 2 1
							setPri: 4
						)
					)
				)
			)
			(48
				(switch global104
					(0
						(gEgo posn: 318 (gEgo y:))
					)
					(1
						(gEgo
							posn: 318 (gEgo y:)
							looper: (ScriptID 501 1) ; DUNELOOPER
							setPri: 4
						)
					)
					(2
						(= global104 4)
						(gEgo
							posn: 318 (gEgo y:)
							view: 68
							setStep: 1 1
							setPri: 2
						)
					)
				)
			)
			(51
				(NormalEgo)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x:) 188)
			)
			(else
				(gEgo posn: 154 174)
			)
		)
		(self setRegions: 501) ; regDune
		(switch global110
			(1
				(if (== (Random 1 3) 2)
					(= global111 (Act new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 10))
				)
			)
			(2
				(= global111 (Act new:))
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
			(= global112 124)
			(= global113 147)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 172)
				)
				(west
					(global111 posn: -40 172)
				)
				(south
					(global111 posn: 160 249)
				)
				(north
					(global111 posn: 124 147)
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		else
			((ScriptID 501 0) notify: 4) ; regDune
		)
	)

	(method (newRoom newRoomNumber)
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
		(= local0 (gEgo onControl: 0))
		(cond
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (or (proc501_2 8) (proc501_2 4))
					(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				)
			)
			((and (== global116 4) (not (& local0 $0004)))
				(= global116 0)
				(gEgo ignoreControl: 4)
			)
			((and (== global116 8) (not (& local0 $0008)))
				(= global116 0)
				(if (proc501_2 4)
					(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				)
			)
			((and (== global116 16) (not (& local0 $0010)))
				(gEgo ignoreControl: 16)
				(= global116 0)
			)
		)
		(switch global104
			(0
				(cond
					((and (& local0 $0002) (not gHandsOff) (not global116))
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
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1) ; DUNELOOPER
							setMotion: MoveTo local2 local1
							setPri: 5
						)
					)
					((and (proc501_2 global109) (== global116 0))
						(= global104 1)
						(= local1 180)
						(= local2 (gEgo x:))
						(gEgo
							setPri: 3
							posn: (gEgo x:) (+ (gEgo y:) 8)
						)
						(RedrawCast)
						(gEgo
							view: 82
							looper: (ScriptID 501 1) ; DUNELOOPER
							xStep: 2
							yStep: 1
							setMotion: MoveTo local2 local1
							setPri: 4
						)
					)
				)
			)
			(1
				(cond
					((and (& local0 $0004) (not gHandsOff) (not global116))
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
							posn: (gEgo x:) (- (gEgo y:) 3)
							observeControl: 4
						)
						(RedrawCast)
						(gEgo
							view: 82
							looper: 0
							setStep: 2 1
							observeControl: 4
							setMotion: MoveTo local2 local1
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
							moveSpeed: 0
						)
					)
					((and (== global116 0) (proc501_2 local3))
						(= local1 180)
						(= local2 (gEgo x:))
						(gEgo
							setPri: 3
							posn: (gEgo x:) (+ (gEgo y:) 8)
						)
						(RedrawCast)
						(gEgo
							view: 82
							looper: (ScriptID 501 1) ; DUNELOOPER
							xStep: 2
							yStep: 1
							setMotion: MoveTo local2 local1
							setPri: 4
						)
					)
				)
			)
			(2
				(cond
					((and (& local0 $0008) (not gHandsOff) (not global116))
						(= global104 3)
						(= global116 8)
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
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1) ; DUNELOOPER
							setMotion: MoveTo local2 local1
							setPri: 2
						)
					)
					((and (& local0 $0004) (not gHandsOff) (not global116))
						(= global116 4)
						(= global104 1)
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
							posn: (gEgo x:) (- (gEgo y:) 3)
							observeControl: 4
						)
						(RedrawCast)
						(gEgo
							view: 82
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1) ; DUNELOOPER
							setMotion: MoveTo local2 local1
							setPri: 5
						)
					)
					((and (== global116 0) (proc501_2 local3))
						(= global104 3)
						(= local1 180)
						(= local2 (gEgo x:))
						(gEgo
							setPri: 2
							posn: (gEgo x:) (+ (gEgo y:) 8)
						)
						(RedrawCast)
						(gEgo
							view: 82
							looper: (ScriptID 501 1) ; DUNELOOPER
							xStep: 2
							yStep: 1
							setMotion: MoveTo local2 local1
							setPri: 2
						)
					)
				)
			)
			(3
				(cond
					((and (& local0 $0010) (not gHandsOff) (not global116))
						(= global116 16)
						(= global104 4)
						(if (IsObject (gEgo mover:))
							0
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
						(gEgo posn: (gEgo x:) (- (gEgo y:) 3))
						(RedrawCast)
						(gEgo
							view: 68
							looper: 0
							setStep: 1 1
							observeControl: 16
							setMotion: MoveTo local2 local1
						)
					)
					((and (& local0 $0008) (not gHandsOff) (not global116))
						(= global116 8)
						(= global104 2)
						(if (IsObject (gEgo mover:))
							0
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
							view: 82
							looper: 0
							setStep: 1 1
							setPri: 3
							setMotion: MoveTo local2 local1
						)
					)
					((and (== global116 0) (proc501_2 local3))
						(= local1 180)
						(= local2 (gEgo x:))
						(gEgo
							setPri: 2
							posn: (gEgo x:) (+ (gEgo y:) 8)
						)
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
			(4
				(cond
					((and (& local0 $0010) (not gHandsOff) (not global116))
						(= global116 16)
						(= global104 3)
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
						(gEgo view: 82 posn: (gEgo x:) (- (gEgo y:) 3))
						(RedrawCast)
						(gEgo
							xStep: 2
							yStep: 1
							looper: (ScriptID 501 1) ; DUNELOOPER
							observeControl: 16
							setMotion: MoveTo local2 local1
							setPri: 2
						)
					)
					((& local0 $0020)
						(gCurRoom newRoom: 43)
					)
				)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 5])
		(if (or (event claimed:) (== gHandsOff 1))
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look,look>')
					(cond
						((Said '[<around,at,in][/area]')
							(Print 47 0) ; "You are startled by the sight of a giant beast just beyond the sand dune to the north."
						)
						(
							(Said
								'/android,monster,alien,mog,appendage,head,lip,beast'
							)
							(Print 47 1) ; "Your fear turns to curiosity as you realize that it is not a real beast but a mechanical creation. Although it still looks dangerous, you can't decide whether to blast off this rock or inspect further the wonders of Phleebhut."
						)
					)
				)
			)
		)
	)
)

(instance duneFall of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 76
					looper: 0
					setStep: 5 5
					setLoop: 0
					setAvoider: Avoid
					setPri: 5
					setMotion: MoveTo 204 170 self
				)
			)
			(1
				(HandsOn)
				(gEgo view: 82 setLoop: -1 setAvoider: 0 setStep: 1 1)
				(= global104 2)
				(gCurRoom setScript: 0)
			)
		)
	)
)

