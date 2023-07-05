;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use n013)
(use Cursor)
(use Game)
(use System)

(public
	rm371 0
)

(local
	local0
)

(instance rm371 of Room
	(properties
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(gGame handsOff:)
		(ClearFlag 220)
		(= local0 gTheCursor)
		(gGame setCursor: myInvisCursor 1)
		(SetFlag 220)
		(super init:)
		(gGame handsOff:)
		(= gWaitCursor myInvisCursor)
		(gCurRoom setScript: doTheNightmare)
		(gTheIconBar disable: erase:)
		(SetCursor 0)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(gTheIconBar enable:)
		(SetCursor 1)
		(= gWaitCursor local0)
		(ClearFlag 220)
		(gGame setCursor: gWaitCursor 1)
		(gTheIconBar enable:)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(super dispose:)
	)
)

(instance doTheNightmare of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGkMusic1 setLoop: -1 number: 100 play:)
				(= seconds 3)
			)
			(1
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(Palette 2 0 256 100) ; PalIntensity
				(= seconds 3)
			)
			(2
				(if (IsFlag 470)
					(self setScript: flopMovie1 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{1.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {1.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(3
				(if (IsFlag 470)
					(self setScript: flopMovie2 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{2.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {2.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(4
				(if (IsFlag 470)
					(self setScript: flopMovie3 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{MORPH.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {MORPH.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(5
				(cond
					((>= gDay 6)
						(if (IsFlag 470)
							(self setScript: flopMovie4 self)
						else
							(if (== (Platform) 1)
								(ShowMovie
									{TALIS.SEQ}
									7
									(if (IsHiRes) 150 else 0)
									(if (IsHiRes) 135 else 0)
								)
							else
								(ShowMovie 0 {TALIS.AVI}) ; Open
								(ShowMovie 1 0 0 320 200) ; Put
								(ShowMovie 2 2) ; Play
								(ShowMovie 6) ; Close
							)
							(= cycles 1)
						)
					)
					((IsFlag 470)
						(self setScript: flopMovie5 self)
					)
					(else
						(if (== (Platform) 1)
							(ShowMovie
								{OLDTALIS.SEQ}
								7
								(if (IsHiRes) 150 else 0)
								(if (IsHiRes) 135 else 0)
							)
						else
							(ShowMovie 0 {OLDTALIS.AVI}) ; Open
							(ShowMovie 1 0 0 320 200) ; Put
							(ShowMovie 2 2) ; Play
							(ShowMovie 6) ; Close
						)
						(= cycles 1)
					)
				)
			)
			(6
				(if (IsFlag 470)
					(self setScript: flopMovie6 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{BLOOD.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {BLOOD.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(7
				(if (>= gDay 3)
					(if (IsFlag 470)
						(self setScript: flopMovie7 self)
					else
						(if (== (Platform) 1)
							(ShowMovie
								{KNIFE.SEQ}
								7
								(if (IsHiRes) 150 else 0)
								(if (IsHiRes) 135 else 0)
							)
						else
							(ShowMovie 0 {KNIFE.AVI}) ; Open
							(ShowMovie 1 0 0 320 200) ; Put
							(ShowMovie 2 2) ; Play
							(ShowMovie 6) ; Close
						)
						(= cycles 1)
					)
				else
					(self cue:)
				)
			)
			(8
				(if (IsFlag 470)
					(self setScript: flopMovie8 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{PAN1.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {PAN1.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(9
				(if (IsFlag 470)
					(self setScript: flopMovie9 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{SNAKE.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {SNAKE.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(10
				(if (IsFlag 470)
					(self setScript: flopMovie10 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{PAN2.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {PAN2.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(11
				(if (IsFlag 470)
					(self setScript: flopMovie11 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{HANG.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {HANG.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(12
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 0)
				)
				(gCurRoom newRoom: 370)
				(self dispose:)
			)
		)
	)
)

(instance flopMovie1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 110 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 111 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 112 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance flopMovie2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 113 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 114 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 115 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance flopMovie3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 116 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 117 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 118 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 119 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance flopMovie4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 123 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 124 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 125 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 126 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 127 14)
				(= cycles 2)
			)
			(5
				(gCurRoom drawPic: 128 14)
				(= cycles 2)
			)
			(6
				(gCurRoom drawPic: 129 14)
				(= cycles 2)
			)
			(7
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance flopMovie5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 120 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 121 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 122 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance flopMovie6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 130 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 131 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance flopMovie7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 132 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 133 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 134 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 135 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 136 14)
				(= cycles 2)
			)
			(5
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance flopMovie8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 137 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 138 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 139 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 140 14)
				(= cycles 2)
			)
			(4
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance flopMovie9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 141 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 142 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance flopMovie10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 143 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 144 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 145 14)
				(= cycles 2)
			)
			(3
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance flopMovie11 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 146 14)
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 147 14)
				(= cycles 2)
			)
			(2
				(gCurRoom drawPic: 148 14)
				(= cycles 10)
			)
			(3
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

