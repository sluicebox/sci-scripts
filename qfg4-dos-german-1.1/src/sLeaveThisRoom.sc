;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 741)
(include sci.sh)
(use Main)
(use DeathIcon)
(use Scaler)
(use PolyPath)
(use Jump)
(use Motion)
(use System)

(public
	sLeaveThisRoom 0
	enterScript 1
	sFallsBoom 2
)

(local
	local0
)

(instance sLeaveThisRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: 0)
				(if (IsFlag 340)
					(gEgo solvePuzzle: 456 15)
					(= seconds 2)
				else
					(gMessager say: 11 4 24 0 self) ; "The exit seems to be magically sealed, solid stone once more. You will need to perform the appropriate ritual to open it again."
				)
			)
			(1
				(if (IsFlag 340)
					(gCurRoom newRoom: 720)
				else
					(gEgo
						setMotion:
							PolyPath
							(gEgo x:)
							(+ (gEgo y:) 10)
							self
					)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (not state)
			(if (< local0 100)
				(Palette 2 66 85 (+= local0 10)) ; PalIntensity
				(FrameOut)
			else
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 75 (+ (gEgo y:) 10))
			)
			(1
				(gEgo normalize: 2)
				(if (IsFlag 340)
					(gCurRoom setScript: (ScriptID 740 2)) ; doRitual
				else
					(gGlory handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFallsBoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 740 1) dispose:) ; torchEff
				(gEgo
					view: 30
					setLoop: 3 1
					setCel: 0
					setSpeed: 6
					setCycle: CT 5 1
					setScaler: Scaler 40 37 175 47
					setMotion: JumpTo 187 125 self
				)
			)
			(1
				(EgoDead 5 740) ; "Apparently that was a little TOO risky for you. Remember hearing that "practice makes perfect?""
			)
		)
	)
)

