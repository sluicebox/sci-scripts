;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 671)
(include sci.sh)
(use Main)
(use AudioScript)
(use KQ5Room)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	cdEnding2 0
)

(instance cdEnding2 of KQ5Room
	(properties
		picture 217
	)

	(method (init)
		(Load rsSCRIPT 941)
		(Load rsSCRIPT 929)
		(Load rsVIEW 932)
		(LoadMany rsSYNC 5202 5203 5204 5205)
		(super init:)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(theEyes init:)
		(eyelid init:)
		(theMouth init:)
		(self setScript: cartoon)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance cartoon of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(theMouth play: 10122 670)
				(= waitForCue 11524)
			)
			(2
				(= waitForCue 11780)
			)
			(3
				(= waitForCue 12036)
			)
			(4
				(= waitForCue 12548)
			)
			(5
				(= waitForCue 12804)
			)
			(6
				(theMouth setCycle: 0)
				(eyelid setScript: 0)
				(if (not (== (eyelid cel:) 0))
					(eyelid setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(7
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(8
				(gCurRoom newRoom: 670) ; cdEnding
			)
		)
	)
)

(instance eyesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theEyes cel: 0)
				(= seconds (Random 3 7))
			)
			(1
				(theEyes cel: (+ (theEyes cel:) 1))
				(if (NumCels theEyes)
					(= state -1)
				else
					(-- state)
				)
				(= seconds (Random 2 5))
			)
		)
	)
)

(instance bodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (client cycler:)
					(= state 2)
					(= cycles 1)
				else
					(client setCycle: End self)
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance theEyes of Prop
	(properties
		x 213
		y 79
		view 932
		loop 1
		priority 5
		signal 16
	)

	(method (init)
		(super init:)
		(if (== (gGame detailLevel:) 3)
			(self setScript: eyesScript)
		)
	)
)

(instance eyelid of Prop
	(properties
		x 213
		y 79
		view 932
		priority 6
		signal 16
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (== (gGame detailLevel:) 3))
			(switch (Random 1 60)
				(1
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance theMouth of MonoAudioProp
	(properties
		x 212
		y 90
		view 932
		loop 2
		priority 5
		signal 16
		cycleSpeed 2
	)
)

(instance hand of Prop ; UNUSED
	(properties
		x 164
		y 158
		view 932
		loop 3
		priority 11
		signal 16
	)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (and (not (self script:)) (== (gGame detailLevel:) 3))
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

