;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 406)
(include sci.sh)
(use Main)
(use MoveToY)
(use Inertia)
(use eRS)
(use Sq4Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	rm406 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 999
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance rm406 of SQRoom
	(properties
		picture 406
		east 411
		south 405
	)

	(method (init)
		(HandsOff)
		(if (= local1 (IsFlag 20))
			(LoadMany rsVIEW 408 409 28)
		)
		(Load rsSOUND 105)
		(if (= local0 (IsFlag 19))
			(blast init:)
		)
		(self setRegions: 700) ; mall
		(switch gPrevRoomNum
			(south
				(self setScript: enterScript 0 south style: 10)
			)
			(else
				(self setScript: enterScript 0 east style: 11)
			)
		)
		(if (and local1 (== gPrevRoomNum east))
			((ScriptID 700 6) init: hide: setScript: egoFollowed) ; sp1
			((ScriptID 700 7) init: hide:) ; sp2
		)
		(gEgo setPri: 6 init:)
		(super init:)
		((ScriptID 700 6) show:) ; sp1
		((ScriptID 700 7) show:) ; sp2
		(gFeatures add: theMall dome eachElementDo: #init doit:)
	)

	(method (doit)
		(cond
			((or script local2 (== (gEgo view:) 409))
				(gEgo edgeHit: EDGE_NONE)
			)
			((OneOf (gEgo edgeHit:) 1 4)
				(HandsOff)
				(self setScript: stayInScript 0 (gEgo edgeHit:))
			)
			((OneOf (gEgo edgeHit:) 3 2)
				(HandsOff)
				(self setScript: exitScript 0 (gEgo edgeHit:))
			)
			(
				(and
					local0
					(< (gEgo x:) 155)
					(< 12 (gEgo y:) 140)
					(not (== (gCurRoom script:) stayInScript))
				)
				(if (not ((ScriptID 700 6) script:)) ; sp1
					((ScriptID 700 6) init: setScript: (swimAndShoot new:)) ; sp1
				)
				(if (not ((ScriptID 700 7) script:)) ; sp2
					((ScriptID 700 7) init: setScript: (swimAndShoot new:)) ; sp2
				)
			)
		)
		(super doit: &rest)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch register
					((gCurRoom east:)
						(= temp0
							(CelWide
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						((ScriptID 700 4) ; eSwimCode
							init: gEgo
							inertizing: 1
							inertia: 5
							oldDir: 270
							xOff: -1
						)
						(gEgo
							setHeading: 270
							setCycle: Swim
							x: (- 319 (+ (/ temp0 2) 1))
							y:
								(if (< (gEgo y:) 20)
									20
								else
									(gEgo y:)
								)
						)
						(= cycles 1)
					)
					((gCurRoom south:)
						((ScriptID 700 4) init: gEgo) ; eSwimCode
						(= temp0
							(CelHigh
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						(gEgo
							setCycle: Swim
							x: (gEgo x:)
							y: (+ 189 temp0)
							setMotion: MoveToY (- 189 temp0) self
						)
					)
				)
			)
			(1
				(if (not ((ScriptID 700 6) script:)) ; sp1
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				((ScriptID 700 4) dispose:) ; eSwimCode
				(if (== register 3)
					(= temp0 180)
				else
					(= temp0 90)
				)
				(gEgo setHeading: temp0 self)
			)
			(1
				(if (== register 3)
					(= temp1 (gEgo x:))
					(= temp2 220)
				else
					(= temp1 350)
					(= temp2 (gEgo y:))
				)
				(gEgo setMotion: MoveTo temp1 temp2 self)
			)
			(2
				(if (== register 3)
					(= temp0 405)
				else
					(= temp0 411)
				)
				(gEgo setPri: -1)
				(gCurRoom newRoom: temp0)
			)
		)
	)
)

(instance stayInScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				((gEgo code:) xOff: 0 yOff: 0 inertia: 0)
				(if (== register 1)
					(= temp0 (gEgo x:))
					(= temp1 -30)
				else
					(= temp0 -30)
					(= temp1 (gEgo y:))
				)
				(gEgo setMotion: MoveTo temp0 temp1 self)
			)
			(1
				((gEgo code:) xOff: 0 yOff: 0 inertia: 0)
				(if (== register 1)
					(if (> (gEgo x:) 300)
						(gEgo x: 300)
					)
					(if (< (gEgo x:) 20)
						(gEgo x: 20)
					)
					(Animate (gCast elements:) 0)
					(= temp0 (gEgo x:))
					(= temp1 30)
				else
					(if (> (gEgo y:) 180)
						(gEgo y: 180)
					)
					(if (< (gEgo y:) 20)
						(gEgo y: 20)
					)
					(Animate (gCast elements:) 0)
					(= temp0 30)
					(= temp1 (gEgo y:))
				)
				(gEgo setMotion: MoveTo temp0 temp1 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance swimAndShoot of Script
	(properties)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(< 0 state 3)
				(< (- (client x:) (gEgo x:)) 82)
			)
			(client setMotion: 0 setCycle: 0)
			(= local2 1)
			(self changeState: 3)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client x: 1000)
				(= seconds (Random 1 5))
			)
			(1
				(if (not local1)
					(= local1 1)
					(SetFlag 20)
				)
				(client
					view: 408
					setLoop: 1
					cel: 0
					setCycle: End
					setStep: 2 2
					x: 355
				)
				(if (== client (ScriptID 700 6)) ; sp1
					(client
						y: (- (gEgo y:) (Random 30 50))
						setMotion: MoveTo 278 (- (gEgo y:) 23) self
					)
				else
					(client
						y: (+ (gEgo y:) (Random 30 50))
						setMotion: MoveTo 288 (+ (gEgo y:) 15) self
					)
				)
			)
			(2
				(= cycles 7)
			)
			(3
				(if local3
					(self changeState: (- state 1))
				else
					(= local3 1)
					(client view: 409 setLoop: 1 cel: 0 setCycle: CT 1 1 self)
					(= local2
						(if
							(or
								(not (gEgo mover:))
								(== (gEgo y:) ((gEgo mover:) y:))
							)
							(not
								(and
									(> (gEgo y:) 180)
									((ScriptID 700 4) inertia:) ; eSwimCode
								)
							)
						)
					)
				)
			)
			(4
				(= local8 (Max 2 (- (client y:) 4)))
				(= local7 (Min 318 (- (client x:) 46)))
				(= local10 (Min 188 (Max 2 (gEgo y:))))
				(= local9
					(if local2
						(Max (gEgo x:) 2)
					else
						(Random 2 8)
					)
				)
				(if (< local8 local10)
					(= local5 local8)
					(= local6 local10)
				else
					(= local5 local10)
					(= local6 local8)
				)
				(= local3
					(Graph
						grSAVE_BOX
						(- local5 1)
						(- local9 1)
						(+ local6 1)
						(+ local7 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local8
					local7
					local10
					local9
					(proc0_18 global133 global143)
					1
					-1
				)
				(Graph grREDRAW_BOX (- local5 1) (- local9 1) (+ local6 1) (+ local7 1) 1)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(5
				(Graph grRESTORE_BOX local3)
				(Graph grREDRAW_BOX (- local5 1) (- local9 1) (+ local6 1) (+ local7 1) 1)
				(= local3 0)
				(blast cel: 0 posn: local9 local10 setCycle: End)
				(client
					setLoop: 3
					cel: 0
					setCycle: Fwd
					setStep: 2 1
					cycleSpeed: 6
					setMotion: MoveTo 360 (- (client y:) 6) self
				)
				(if local2
					(HandsOff)
					((ScriptID 700 4) inertia: 0) ; eSwimCode
					(gEgo
						view: 409
						setLoop: 5
						cel: 0
						setMotion: 0
						setCycle: Fwd
					)
				)
			)
			(6
				(if local2
					(EgoDead 8 14) ; "Hint: hitting a moving target is more difficult than hitting a stationary LUMP!"
				else
					(client dispose:)
				)
			)
		)
	)
)

(instance egoFollowed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 7) ; sp2
					view: 408
					setLoop: 0
					posn: 40 168
					setStep: 1 1
					setMotion: MoveTo 130 130
					cycleSpeed: 12
					setCycle: Fwd
				)
				((ScriptID 700 6) ; sp1
					view: 408
					setLoop: 0
					cel: 0
					setCycle: Fwd
					setStep: 2 2
					posn: 110 (- (gEgo y:) 6)
					setMotion: MoveTo 138 (gEgo y:) self
				)
			)
			(1
				((ScriptID 700 7) cycleSpeed: 18 moveSpeed: 1) ; sp2
				((ScriptID 700 6) ; sp1
					view: 409
					setLoop: 0
					cel: 0
					setCycle: CT 1 1 self
				)
				(HandsOff)
			)
			(2
				(= local5 (Max 2 (- ((ScriptID 700 6) y:) 4))) ; sp1
				(= local7 (+ ((ScriptID 700 6) x:) 46)) ; sp1
				(= local6 (Min 188 (gEgo y:)))
				(= local9 (Min 318 (gEgo x:)))
				(= local3
					(Graph
						grSAVE_BOX
						(- local5 1)
						(- local7 1)
						(+ local6 1)
						(+ local9 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local5
					local7
					local6
					local9
					(proc0_18 global133 global143)
					1
					-1
				)
				(Graph grREDRAW_BOX (- local5 1) (- local7 1) (+ local6 1) (+ local9 1) 1)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local3)
				(Graph grREDRAW_BOX (- local5 1) (- local7 1) (+ local6 1) (+ local9 1) 1)
				(blast cel: 0 posn: local9 local6 setCycle: End)
				((ScriptID 700 6) ; sp1
					setLoop: 3
					cel: 0
					setCycle: Fwd
					setStep: 2 1
					cycleSpeed: 6
					setStep: 4 3
					setMotion: MoveTo 0 (- ((ScriptID 700 6) y:) 6) ; sp1
				)
				(gEgo view: 409 setLoop: 4 cel: 0 setCycle: Fwd)
				(= cycles 22)
			)
			(4
				(EgoDead 8 15) ; "Were you looking for trouble? Maybe you thought you could beat them senseless with your pink bunny rabbit?"
			)
		)
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
	)
)

(instance dome of Sq4Feature
	(properties
		x 190
		sightAngle 180
		lookStr 1 ; "The dome is made from hyper-compressed titanium oxide silicates. Or is that transparent cardboard?"
	)

	(method (onMe)
		(return 1)
	)
)

(instance theMall of Sq4Feature
	(properties
		x 110
		y 80
		sightAngle 180
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $0002))
	)
)

(instance aSound of Sound
	(properties)
)

