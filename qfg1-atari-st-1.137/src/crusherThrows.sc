;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 337)
(include sci.sh)
(use Main)
(use n813)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	crusherThrows 0
	crusherEscorts 1
)

(procedure (localproc_0 param1 &tmp temp0)
	(HandsOff)
	(gCast eachElementDo: #stopUpd)
	((ScriptID 331 7) cycleSpeed: 1 setCycle: End) ; crusher
	(if (<= (gEgo distanceTo: (ScriptID 331 7)) 25) ; crusher
		(if (== (= temp0 (gEgo priority:)) ((ScriptID 331 7) priority:)) ; crusher
			(++ temp0)
		)
		(gEgo
			setPri: temp0
			setLoop: 1
			setCycle: Rev
			cycleSpeed: 1
			moveSpeed: 1
			ignoreActors: 1
			setMotion: MoveTo 125 150 param1
		)
	else
		(param1 cue:)
	)
)

(instance chair of Prop
	(properties
		y 149
		x 75
		view 338
		loop 2
	)
)

(instance crusherThrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 self)
			)
			(1
				(gEgo setCycle: Walk)
				(chair init: ignoreActors: setCycle: End)
				((ScriptID 331 7) ; crusher
					ignoreActors:
					loop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				((ScriptID 331 7) cel: 2) ; crusher
				(= cycles 3)
			)
			(3
				((ScriptID 331 7) setCycle: End self) ; crusher
			)
			(4
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 15)
				(SetFlag 117)
				(AdvanceTime 3)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance crusherEscorts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 self)
			)
			(1
				(gEgo setCycle: Walk)
				(chair init: ignoreActors: cycleSpeed: 1 setCycle: End self)
				((ScriptID 331 7) ; crusher
					ignoreActors:
					setLoop: 1
					setCel: 0
					setCycle: 0
					posn: 98 152
					stopUpd:
				)
			)
			(2
				((ScriptID 331 6) cycleSpeed: 2 setCycle: End self) ; trap
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 15)
				(gCurRoom newRoom: 332)
			)
		)
	)
)

