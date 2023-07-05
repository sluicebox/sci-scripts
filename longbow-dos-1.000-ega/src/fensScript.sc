;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use RTEyeCycle)
(use Motion)

(public
	fensScript 0
)

(local
	[local0 6] = [1401 0 2 1 1 0]
	[local6 11] = [1401 3 2 1 1 2 2 2 2 2 0]
)

(procedure (localproc_0 param1)
	(Converse 2 param1 999 3 12 1 &rest)
)

(instance fensScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 144)
				(localproc_0 @local0 self) ; "Have you a message from the Prior?"
			)
			(1
				(if notKilled
					((ScriptID 400 2) loop: 2 setCycle: End self) ; sheriff
				else
					(self cue:)
				)
			)
			(2
				(localproc_0 @local6 self) ; "He DEMANDS?! They're MY prisoners! I caught them!"
			)
			(3
				(gEgo setMotion: MoveTo 0 (gEgo y:))
				(self dispose:)
			)
		)
	)
)

