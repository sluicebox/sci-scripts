;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 411)
(include sci.sh)
(use Main)
(use MoveToY)
(use Inertia)
(use SQRoom)
(use Motion)
(use Actor)
(use System)

(public
	rm411 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance rm411 of SQRoom
	(properties
		picture 411
		south 410
		west 406
	)

	(method (init)
		(HandsOff)
		(= local1 (IsFlag 21))
		(if (= local0 (IsFlag 20))
			(blast init:)
		)
		(self setRegions: 700) ; mall
		(switch gPrevRoomNum
			(south
				(self setScript: enterScript 0 south style: 30)
			)
			(else
				(self setScript: enterScript 0 west style: 41)
			)
		)
		(if (and local1 (== gPrevRoomNum west))
			((ScriptID 700 6) init: hide: setScript: egoFollowed) ; sp1
			((ScriptID 700 7) init: hide:) ; sp2
		)
		(gEgo init:)
		(super init:)
		((ScriptID 700 6) show:) ; sp1
		((ScriptID 700 7) show:) ; sp2
	)

	(method (doit)
		(cond
			(script 0)
			((OneOf (gEgo edgeHit:) 1 2)
				(HandsOff)
				(self setScript: stayInScript 0 (gEgo edgeHit:))
			)
			((OneOf (gEgo edgeHit:) 3 4)
				(HandsOff)
				(self setScript: exitScript 0 (gEgo edgeHit:))
			)
			((and local0 (> (gEgo x:) 165) (< 12 (gEgo y:) 140))
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
					((gCurRoom west:)
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
							oldDir: 90
							xOff: 1
						)
						(gEgo
							setHeading: 90
							setCycle: Swim
							x: (+ (/ temp0 2) 1)
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
					(= temp0 270)
				)
				(gEgo setHeading: temp0 self)
			)
			(1
				(if (== register 3)
					(= temp1 (gEgo x:))
					(= temp2 220)
				else
					(= temp1 -30)
					(= temp2 (gEgo y:))
				)
				(gEgo setMotion: MoveTo temp1 temp2 self)
			)
			(2
				(if (== register 3)
					(= temp0 410)
				else
					(= temp0 406)
				)
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
					(= temp0 350)
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
					(= temp0 290)
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
				(< (- (gEgo x:) (client x:)) 82)
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
				(client y: -1000)
				(= seconds (Random 1 4))
			)
			(1
				(if (not local1)
					(= local1 1)
					(SetFlag 21)
				)
				(client
					view: 408
					setLoop: 0
					cel: 0
					setCycle: End
					setStep: 2 2
					x: -34
				)
				(if (== client (ScriptID 700 6)) ; sp1
					(client
						y: (- (gEgo y:) (Random 30 50))
						setMotion: MoveTo 42 (- (gEgo y:) 23) self
					)
				else
					(client
						y: (+ (gEgo y:) (Random 30 50))
						setMotion: MoveTo 32 (+ (gEgo y:) 15) self
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
					(client view: 409 setLoop: 0 cel: 0 setCycle: CT 1 1 self)
					(= local2
						(or
							(not (gEgo mover:))
							(== (gEgo y:) ((gEgo mover:) y:))
						)
					)
				)
			)
			(4
				(= local7 (Max 1 (- (client y:) 4)))
				(= local6 (+ (client x:) 57))
				(= local9 (Min 190 (Max 1 (gEgo y:))))
				(= local8
					(if local2
						(Min (gEgo x:) 319)
					else
						(Random 314 319)
					)
				)
				(if (< (client y:) (gEgo y:))
					(= local4 local7)
					(= local5 local9)
				else
					(= local4 local9)
					(= local5 local7)
				)
				(= local3
					(Graph
						grSAVE_BOX
						(- local4 1)
						(- local6 1)
						(+ local5 1)
						(+ local8 1)
						1
					)
				)
				(Graph grDRAW_LINE local7 local6 local9 local8 global133 1 -1)
				(Graph grREDRAW_BOX (- local4 1) (- local6 1) (+ local5 1) (+ local8 1) 1)
				(= cycles 1)
			)
			(5
				(Graph grRESTORE_BOX local3)
				(Graph grREDRAW_BOX (- local4 1) (- local6 1) (+ local5 1) (+ local8 1) 1)
				(= local3 0)
				(blast cel: 0 posn: local8 local9 setCycle: End)
				(client
					setLoop: 2
					cel: 0
					setCycle: Fwd
					setStep: 2 1
					cycleSpeed: 0
					setMotion: MoveTo -36 (- (client y:) 6) self
				)
				(if local2
					((ScriptID 700 4) inertia: 0) ; eSwimCode
					(gEgo
						view: 409
						setLoop: 4
						cel: 0
						setMotion: 0
						setCycle: Fwd
					)
				)
			)
			(6
				(if local2
					(EgoDead 411 0)
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
					setLoop: 1
					posn: 280 168
					setStep: 1 1
					setMotion: MoveTo 190 130
					cycleSpeed: 1
					setCycle: Fwd
				)
				((ScriptID 700 6) ; sp1
					view: 408
					setLoop: 1
					cel: 0
					setCycle: Fwd
					setStep: 2 2
					posn: 210 (- (gEgo y:) 6)
					setMotion: MoveTo 182 (gEgo y:) self
				)
			)
			(1
				((ScriptID 700 7) cycleSpeed: 2 moveSpeed: 1) ; sp2
				((ScriptID 700 6) ; sp1
					view: 409
					setLoop: 1
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(2
				(= local4 (- (gEgo y:) 4))
				(= local6 (- ((ScriptID 700 6) x:) 57)) ; sp1
				(= local5 (gEgo y:))
				(= local8 (gEgo x:))
				(= local3
					(Graph
						grSAVE_BOX
						(- local4 1)
						(- local8 1)
						(+ local5 1)
						(+ local6 1)
						1
					)
				)
				(Graph grDRAW_LINE local4 local6 local5 local8 global133 1 -1)
				(Graph grREDRAW_BOX (- local4 1) (- local8 1) (+ local5 1) (+ local6 1) 1)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local3)
				(Graph grREDRAW_BOX (- local4 1) (- local8 1) (+ local5 1) (+ local6 1) 1)
				(blast cel: 0 posn: local8 local5 setCycle: End)
				((ScriptID 700 6) ; sp1
					setLoop: 2
					cel: 0
					setCycle: Fwd
					setStep: 2 1
					cycleSpeed: 0
					setStep: 4 3
					setMotion: MoveTo 320 (- ((ScriptID 700 6) y:) 6) ; sp1
				)
				(gEgo view: 409 setLoop: 5 cel: 0 setCycle: Fwd)
				(= cycles 22)
			)
			(4
				(EgoDead 411 1)
			)
		)
	)
)

(instance blast of Prop
	(properties
		view 28
	)
)

