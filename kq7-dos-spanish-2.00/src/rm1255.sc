;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1255)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Feature)
(use Actor)

(public
	rm1255 0
)

(local
	local0
)

(instance rm1255 of KQRoom
	(properties)

	(method (init)
		(if (IsFlag 10)
			(self picture: 1255)
		else
			(self picture: 1256)
		)
		(super init:)
		(topGem init:)
		(middleGem init:)
		(bottomGem init:)
		(topRow1 init:)
		(topRow2 init:)
		(topRow3 init:)
		(topRow4 init:)
		(middleRow1 init:)
		(middleRow2 init:)
		(middleRow3 init:)
		(middleRow4 init:)
		(bottomRow1 init:)
		(bottomRow2 init:)
		(bottomRow3 init:)
		(bottomRow4 init:)
		(Load 140 810) ; WAVE
		(gGame handsOn:)
		(proc11_6 1250)
	)

	(method (doit)
		(super doit:)
		(if (and (== gGem1Position 2) (== gGem2Position 2) (== gGem3Position 2))
			(SetFlag 9)
		else
			(ClearFlag 9)
		)
		(cond
			((and (not (IsFlag 37)) (IsFlag 10) (IsFlag 31) (IsFlag 9))
				(gGame handsOff:)
				(gCurRoom newRoom: 1250)
			)
			((and (IsFlag 37) (IsFlag 10) (IsFlag 31) (not (IsFlag 9)))
				(gGame handsOff:)
				(gCurRoom newRoom: 1250)
			)
		)
	)
)

(instance topGem of Prop
	(properties
		x 94
		y 66
		view 12510
	)

	(method (init)
		(super init:)
		(switch gGem1Position
			(0
				(self posn: 94 66)
			)
			(1
				(self posn: 120 68)
			)
			(2
				(self posn: 154 69)
			)
			(3
				(self posn: 184 68)
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch gGem1Position
			(0
				(if (< x local0)
					(self posn: 120 68)
					(= gGem1Position 1)
				)
			)
			(1
				(if (< x local0)
					(self posn: 154 69)
					(= gGem1Position 2)
				else
					(self posn: 94 66)
					(= gGem1Position 0)
				)
			)
			(2
				(if (< x local0)
					(self posn: 184 68)
					(= gGem1Position 3)
				else
					(self posn: 120 68)
					(= gGem1Position 1)
				)
			)
			(3
				(if (> x local0)
					(self posn: 154 69)
					(= gGem1Position 2)
				)
			)
		)
		(gKqSound1 number: 810 setLoop: 1 play:)
	)

	(method (dispose)
		(cond
			((== x 94)
				(= gGem1Position 0)
			)
			((== x 120)
				(= gGem1Position 1)
			)
			((== x 154)
				(= gGem1Position 2)
			)
			((== x 184)
				(= gGem1Position 3)
			)
		)
		(super dispose:)
	)
)

(instance middleGem of Prop
	(properties
		x 94
		y 80
		view 12510
	)

	(method (init)
		(super init:)
		(switch gGem2Position
			(0
				(self posn: 94 80)
			)
			(1
				(self posn: 122 83)
			)
			(2
				(self posn: 154 84)
			)
			(3
				(self posn: 182 84)
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch gGem2Position
			(0
				(if (< x local0)
					(self posn: 122 83)
					(= gGem2Position 1)
				)
			)
			(1
				(if (< x local0)
					(self posn: 154 84)
					(= gGem2Position 2)
				else
					(self posn: 94 80)
					(= gGem2Position 0)
				)
			)
			(2
				(if (< x local0)
					(self posn: 182 84)
					(= gGem2Position 3)
				else
					(self posn: 122 83)
					(= gGem2Position 1)
				)
			)
			(3
				(if (> x local0)
					(self posn: 154 84)
					(= gGem2Position 2)
				)
			)
		)
		(gKqSound1 number: 810 setLoop: 1 play:)
	)

	(method (dispose)
		(cond
			((== x 94)
				(= gGem2Position 0)
			)
			((== x 122)
				(= gGem2Position 1)
			)
			((== x 154)
				(= gGem2Position 2)
			)
			((== x 182)
				(= gGem2Position 3)
			)
		)
		(super dispose:)
	)
)

(instance bottomGem of Prop
	(properties
		x 96
		y 94
		view 12510
	)

	(method (init)
		(super init:)
		(switch gGem3Position
			(0
				(self posn: 96 94)
			)
			(1
				(self posn: 123 97)
			)
			(2
				(self posn: 152 97)
			)
			(3
				(self posn: 181 97)
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch gGem3Position
			(0
				(if (< x local0)
					(self posn: 123 97)
					(= gGem3Position 1)
				)
			)
			(1
				(if (< x local0)
					(self posn: 152 97)
					(= gGem3Position 2)
				else
					(self posn: 96 94)
					(= gGem3Position 0)
				)
			)
			(2
				(if (< x local0)
					(self posn: 181 97)
					(= gGem3Position 3)
				else
					(self posn: 123 97)
					(= gGem3Position 1)
				)
			)
			(3
				(if (> x local0)
					(self posn: 152 97)
					(= gGem3Position 2)
				)
			)
		)
		(gKqSound1 number: 810 setLoop: 1 play:)
	)

	(method (dispose)
		(cond
			((== x 96)
				(= gGem3Position 0)
			)
			((== x 123)
				(= gGem3Position 1)
			)
			((== x 152)
				(= gGem3Position 2)
			)
			((== x 181)
				(= gGem3Position 3)
			)
		)
		(super dispose:)
	)
)

(instance topRow1 of Feature
	(properties
		nsLeft 99
		nsTop 67
		nsRight 113
		nsBottom 77
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(topGem cue:)
			)
		)
	)
)

(instance topRow2 of Feature
	(properties
		nsLeft 125
		nsTop 70
		nsRight 139
		nsBottom 78
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(topGem cue:)
			)
		)
	)
)

(instance topRow3 of Feature
	(properties
		nsLeft 156
		nsTop 69
		nsRight 172
		nsBottom 79
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(topGem cue:)
			)
		)
	)
)

(instance topRow4 of Feature
	(properties
		nsLeft 185
		nsTop 70
		nsRight 201
		nsBottom 81
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(topGem cue:)
			)
		)
	)
)

(instance middleRow1 of Feature
	(properties
		nsLeft 98
		nsTop 81
		nsRight 114
		nsBottom 90
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(middleGem cue:)
			)
		)
	)
)

(instance middleRow2 of Feature
	(properties
		nsLeft 125
		nsTop 83
		nsRight 140
		nsBottom 92
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(middleGem cue:)
			)
		)
	)
)

(instance middleRow3 of Feature
	(properties
		nsLeft 158
		nsTop 84
		nsRight 172
		nsBottom 93
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(middleGem cue:)
			)
		)
	)
)

(instance middleRow4 of Feature
	(properties
		nsLeft 184
		nsTop 84
		nsRight 199
		nsBottom 93
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(middleGem cue:)
			)
		)
	)
)

(instance bottomRow1 of Feature
	(properties
		nsLeft 98
		nsTop 93
		nsRight 117
		nsBottom 105
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(bottomGem cue:)
			)
		)
	)
)

(instance bottomRow2 of Feature
	(properties
		nsLeft 125
		nsTop 97
		nsRight 142
		nsBottom 107
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(bottomGem cue:)
			)
		)
	)
)

(instance bottomRow3 of Feature
	(properties
		nsLeft 156
		nsTop 97
		nsRight 170
		nsBottom 108
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(bottomGem cue:)
			)
		)
	)
)

(instance bottomRow4 of Feature
	(properties
		nsLeft 185
		nsTop 97
		nsRight 202
		nsBottom 107
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(= local0 (event x:))
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(bottomGem cue:)
			)
		)
	)
)

