;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 192)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	slitherIn 0
)

(instance slitherIn of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 192)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 47 2) setCycle: Fwd setMotion: MoveTo 228 145 self) ; sentry
			)
			(1
				((ScriptID 47 2) setLoop: 5 cel: 0 setCycle: End self) ; sentry
			)
			(2
				((ScriptID 47 2) view: 149 setLoop: 1 cycleSpeed: 0) ; sentry
				(if (IsFlag 20)
					(ClearFlag 20)
					(gMuleObj setScript: muleBolts)
				else
					(HandsOn)
					(client setScript: (ScriptID 47 3)) ; waitForStrike
				)
			)
		)
	)
)

(instance muleBolts of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 192)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMuleObj
					setMotion:
						MoveTo
						(+ (gMuleObj x:) 2)
						(- (gMuleObj y:) 2)
						self
				)
			)
			(1
				(gMuleObj
					setMotion:
						MoveTo
						(- (gMuleObj x:) 2)
						(- (gMuleObj y:) 2)
						self
				)
			)
			(2
				(gMuleObj yStep: 6 setMotion: MoveTo (gMuleObj x:) 230 self)
			)
			(3
				(clr)
				(= cycles 10)
			)
			(4
				(Print 192 0) ; "Your mule has had the sense to run away from the cobras."
				(HandsOn)
				(= global206 46)
				(SetFlag 118)
				((ScriptID 47 2) setScript: (ScriptID 47 3)) ; sentry, waitForStrike
				(client dispose:)
			)
		)
	)
)

