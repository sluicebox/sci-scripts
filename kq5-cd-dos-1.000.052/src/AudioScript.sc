;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 771)
(include sci.sh)
(use Main)
(use Sync)
(use Actor)
(use System)

(class AudioScript of Script
	(properties
		waitForCue 0
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				waitForCue
				(u>= (& (gTheSync prevCue:) $fff0) (& waitForCue $fff0))
			)
			(= cycles 1)
			(= waitForCue 0)
		)
	)
)

(class MonoAudioProp of Prop
	(properties
		number 0
		audioEndRoom 0
		audioStarted 0
	)

	(method (play param1 param2)
		(if argc
			(= number param1)
			(if (> argc 1)
				(= audioEndRoom param2)
			)
		)
		(if number
			(self setCycle: MouthSync number)
			(gGlobalAudio number: number loop: 1 play:)
		else
			(self dispose:)
		)
		(= audioStarted 1)
	)

	(method (doit)
		(if (and (== (DoAudio audPOSITION) -1) audioStarted audioEndRoom)
			(gCurRoom newRoom: audioEndRoom)
		)
		(super doit: &rest)
	)
)

