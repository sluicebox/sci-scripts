;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 503)
(include sci.sh)
(use Main)
(use Inset)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	safeDial 0
	safeInside 1
)

(local
	[local0 3] = [5 8 2]
	local3 = 1
	local4
	local5
)

(instance sMoveToZero of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 2 1 self 503) ; "That seems to be the wrong combination."
			)
			(1
				(if (and (== (indicator loop:) 1) (not (indicator cel:)))
					(self cue:)
				else
					(sSafeSound number: 519 loop: -1 play: 30)
					(indicator
						setCycle:
							(if (== (indicator loop:) 1) Beg else End)
							self
					)
				)
			)
			(2
				(sSafeSound stop:)
				(indicator setLoop: 1 cel: 0)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sOpenTheSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 0 1 1 self 503) ; "Adam opens the safe!"
			)
			(1
				(sSafeSound number: 520 loop: 1 play: 127 self)
			)
			(2
				(gCurrentRegionFlags set: 1)
				(gGame handsOn:)
				(gTheIconBar disable: 5 6)
				(safeDial dispose:)
				(DrawPic 888 9)
				(self dispose:)
			)
		)
	)
)

(instance sTakeItAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 10 1 2 3 4 5 6 8 13)
				(gGame points: 2)
				(safeWallet hide:)
				(= ticks 60)
			)
			(1
				(safeMask hide:)
				(= ticks 60)
			)
			(2
				(safeKey hide:)
				(= ticks 60)
			)
			(3
				(safePack hide:)
				(= ticks 60)
			)
			(4
				(safeLetter hide:)
				(= seconds 2)
			)
			(5
				(gMessager say: 1 4 1 1 self 503) ; "Adam takes it all!"
			)
			(6
				(safeInside dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sSpinForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= [local0 local4] (self register:))
					(= local3 0)
				)
				(++ local4)
				(sSafeSound number: 519 loop: -1 play:)
				(indicator setCycle: End self)
			)
			(1
				(if (== (indicator loop:) 1)
					(indicator setLoop: 2 cel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(indicator setLoop: 1 cel: 0)
				(= cycles 1)
			)
			(3
				(cond
					((== register 0)
						(self cue:)
					)
					((<= register 4)
						(indicator setCycle: CT (* 2 register) 1 self)
					)
					((<= register 9)
						(indicator setCycle: End self)
					)
				)
			)
			(4
				(= cycles 1)
			)
			(5
				(cond
					((== register 5)
						(indicator setLoop: 2 cel: 0)
						(= cycles 1)
					)
					((> register 5)
						(indicator
							setLoop: 2
							cel: 0
							setCycle: CT (- (* 2 register) 10) 1 self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(= cycles 1)
			)
			(7
				(sSafeSound stop:)
				(if (== local4 3)
					(if local3
						(self setScript: sOpenTheSafe)
					else
						(= local4 0)
						(= local3 1)
						(self setScript: sMoveToZero self)
					)
				else
					(self cue:)
				)
			)
			(8
				(gGame handsOn:)
				(gTheIconBar disable: 5 6)
				(self dispose:)
			)
		)
	)
)

(instance sSpinBackward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= [local0 local4] register)
					(= local3 0)
				)
				(++ local4)
				(sSafeSound number: 519 loop: -1 play:)
				(if (indicator cel:)
					(indicator setCycle: Beg self)
				else
					(indicator
						setLoop: (if (== (indicator loop:) 1) 2 else 1)
						cel: 9
						setCycle: Beg self
					)
				)
			)
			(1
				(if (== (indicator loop:) 1)
					(self cue:)
				else
					(indicator setLoop: 1 cel: 9 setCycle: Beg self)
				)
			)
			(2
				(cond
					((>= register 5)
						(indicator
							setLoop: 2
							cel: 9
							setCycle: CT (- (* 2 register) 10) -1 self
						)
					)
					((<= register 4)
						(indicator setLoop: 2 cel: 9 setCycle: Beg self)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if (<= register 4)
					(indicator
						setLoop: 1
						cel: 9
						setCycle: CT (* 2 register) -1 self
					)
				else
					(self cue:)
				)
			)
			(4
				(sSafeSound stop:)
				(gGame handsOn:)
				(gTheIconBar disable: 5 6)
				(self dispose:)
			)
		)
	)
)

(instance indicator of Prop
	(properties
		x 155
		y 104
		noun 2
		modNum 503
		view 503
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb)
		(gMessager say: 2 1 0 1 0 503) ; "It's a safe dial."
	)
)

(instance safeWallet of View
	(properties
		x 183
		y 85
		noun 7
		modNum 503
		view 504
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(safeInside doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance safeMask of View
	(properties
		x 158
		y 85
		noun 6
		modNum 503
		view 504
		loop 1
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(safeInside doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance safeKey of View
	(properties
		x 202
		y 86
		noun 8
		modNum 503
		view 504
		loop 1
		cel 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(safeInside doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance safePack of View
	(properties
		x 198
		y 110
		noun 4
		modNum 503
		view 504
		loop 1
		cel 4
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(safeInside doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance safeLetter of View
	(properties
		x 149
		y 106
		noun 5
		modNum 503
		view 504
		loop 1
		cel 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(safeInside doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance zero of Feature
	(properties
		x 155
		y 62
		noun 3
		modNum 503
		nsTop 58
		nsLeft 145
		nsBottom 70
		nsRight 168
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 0)
			else
				(safeDial setScript: sSpinForward 0 0)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance one of Feature
	(properties
		x 184
		y 70
		noun 3
		modNum 503
		nsTop 64
		nsLeft 177
		nsBottom 79
		nsRight 194
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 1)
			else
				(safeDial setScript: sSpinForward 0 1)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance two of Feature
	(properties
		x 198
		y 89
		noun 3
		modNum 503
		nsTop 83
		nsLeft 188
		nsBottom 100
		nsRight 207
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 2)
			else
				(safeDial setScript: sSpinForward 0 2)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance three of Feature
	(properties
		x 198
		y 111
		noun 3
		modNum 503
		nsTop 106
		nsLeft 188
		nsBottom 122
		nsRight 209
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 3)
			else
				(safeDial setScript: sSpinForward 0 3)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance four of Feature
	(properties
		x 182
		y 131
		noun 3
		modNum 503
		nsTop 127
		nsLeft 172
		nsBottom 140
		nsRight 197
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 4)
			else
				(safeDial setScript: sSpinForward 0 4)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance five of Feature
	(properties
		x 155
		y 139
		noun 3
		modNum 503
		nsTop 132
		nsLeft 143
		nsBottom 148
		nsRight 167
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 5)
			else
				(safeDial setScript: sSpinForward 0 5)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance six of Feature
	(properties
		x 129
		y 131
		noun 3
		modNum 503
		nsTop 126
		nsLeft 122
		nsBottom 146
		nsRight 140
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 6)
			else
				(safeDial setScript: sSpinForward 0 6)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance seven of Feature
	(properties
		x 111
		y 113
		noun 3
		modNum 503
		nsTop 105
		nsLeft 101
		nsBottom 121
		nsRight 121
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 7)
			else
				(safeDial setScript: sSpinForward 0 7)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance eight of Feature
	(properties
		x 111
		y 90
		noun 3
		modNum 503
		nsTop 81
		nsLeft 97
		nsBottom 98
		nsRight 123
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 8)
			else
				(safeDial setScript: sSpinForward 0 8)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance nine of Feature
	(properties
		x 129
		y 68
		noun 3
		modNum 503
		nsTop 61
		nsLeft 116
		nsBottom 77
		nsRight 137
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== local4 1)
				(safeDial setScript: sSpinBackward 0 9)
			else
				(safeDial setScript: sSpinForward 0 9)
			)
		else
			(gMessager say: 3 0 0 1 0 503) ; "The numbers on the safe dial are the usual ones."
		)
	)
)

(instance safeDial of Inset
	(properties
		view 503
		x 85
		y 61
		disposeNotOnMe 1
		modNum 503
		noun 1
	)

	(method (doVerb)
		(gMessager say: 1 0 0 1 0 503) ; "The safe makes Slaughter feel, well... safe."
	)

	(method (init)
		(super init: &rest)
		(indicator setLoop: 1 cel: 0 init:)
		(zero init:)
		(one init:)
		(two init:)
		(three init:)
		(four init:)
		(five init:)
		(six init:)
		(seven init:)
		(eight init:)
		(nine init:)
		(= local4 0)
		(= local3 1)
		(gGame handsOn:)
		(gTheIconBar disable: 5 6)
	)

	(method (doit)
		(super doit:)
		(cond
			((not (self onMe: gMouseX (- gMouseY 10)))
				(if (not local5)
					(gTheCursor loop: 11 cel: 0 init:)
					(= local5 1)
				)
			)
			(local5
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= local5 0)
			)
		)
	)

	(method (dispose)
		(indicator dispose:)
		(zero dispose:)
		(one dispose:)
		(two dispose:)
		(three dispose:)
		(four dispose:)
		(five dispose:)
		(six dispose:)
		(seven dispose:)
		(eight dispose:)
		(nine dispose:)
		(sSafeSound dispose:)
		(super dispose: &rest)
	)
)

(instance safeInside of Inset
	(properties
		view 504
		x 85
		y 61
		disposeNotOnMe 1
		modNum 503
		noun 1
	)

	(method (init)
		(super init: &rest)
		(safeWallet init:)
		(safeMask init:)
		(safeKey init:)
		(safePack init:)
		(safeLetter init:)
	)

	(method (doit)
		(super doit:)
		(cond
			((not (self onMe: gMouseX (- gMouseY 10)))
				(if (not local5)
					(gTheCursor loop: 11 cel: 0 init:)
					(= local5 1)
				)
			)
			(local5
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= local5 0)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(self setScript: sTakeItAll)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(safeWallet dispose:)
		(safeMask dispose:)
		(safeKey dispose:)
		(safePack dispose:)
		(safeLetter dispose:)
		(sSafeSound dispose:)
		(gTheIconBar enable: 5 6)
		(super dispose: &rest)
	)
)

(instance sSafeSound of Sound
	(properties)
)

