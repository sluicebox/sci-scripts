;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 808)
(include sci.sh)
(use Main)
(use eRS)
(use StopWalk)
(use Motion)
(use User)
(use System)

(public
	nosePick 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance nosePick of Code
	(properties)

	(method (doit)
		(if
			(and
				(User canControl:)
				(User canInput:)
				(IsObject gCurRoom)
				(gCurRoom isKindOf: SQRoom)
				(not (gCurRoom script:))
				(gEgo normal:)
				(not (& (gEgo signal:) $0008))
				(gEgo isStopped:)
				(IsObject (gEgo cycler:))
				((gEgo cycler:) isKindOf: StopWalk)
				(== (gEgo view:) ((gEgo cycler:) vStopped:))
				(== ((gEgo cycler:) vStopped:) 4)
			)
			(if (!= local0 (GetTime 1)) ; SysTime12
				(= local0 (GetTime 1)) ; SysTime12
				(if (> (++ local1) 120)
					(HandsOff)
					(gCurRoom setScript: nPS)
				)
			)
		else
			(= local1 0)
		)
	)
)

(instance nPS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Load rsVIEW 65)
				(if (!= (gEgo loop:) 2)
					(gEgo setHeading: 180 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= temp0 (Random 0 2))
				(= local3 (gEgo signal:))
				(= local4 (gEgo priority:))
				(= local5 (gEgo illegalBits:))
				(= local6 (gEgo cycleSpeed:))
				(gEgo
					view: 65
					setLoop: temp0
					cycleSpeed: 1
					cel: 0
					setCycle: End self
				)
				(Animate (gCast elements:) 0)
				(if (not temp0)
					(if (< (gEgo y:) 85)
						(= temp1 -20)
					else
						(= temp1 80)
					)
					(= local2
						(proc0_12
							{"So why am I standing around?"#j\a2\e4\de\93\9c\e3\a4\9a\9a\e6\9d\de\8f\e4\e0\8f\e3\f9\fd\e0\de\92\fe\a3}
							67
							100
							(- (gEgo y:) temp1)
							70
							219
						)
					)
				)
			)
			(2
				(if (not (gEgo loop:))
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(3
				(if (not (gEgo loop:))
					(proc0_12 local2)
				)
				(NormalEgo 2 0 4)
				(gEgo
					signal: local3
					priority: local4
					illegalBits: local5
					cycleSpeed: local6
				)
				(= local0 (= start 0))
				(= local1 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

