;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use n013)
(use Game)
(use System)

(public
	openingCartoon 0
)

(instance openingCartoon of Room
	(properties
		picture 99
		style 14
	)

	(method (init)
		(super init:)
		(gTheIconBar disable:)
		(SetCursor 0)
		(self setScript: roomScript)
	)

	(method (dispose)
		(if (and (== (Platform) 1) (not (IsFlag 470)))
			(SetVideoMode 0)
		)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Platform) 1)
					(gGkMusic1
						number: 100
						setLoop: -1
						play:
						setVol: 0
						fade: (gGkMusic1 musicVolume:) 25 10 0
					)
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(1
				(if (and (== (Platform) 1) (not (IsFlag 470)))
					(SetVideoMode 1)
				)
				(Palette 2 0 256 100) ; PalIntensity
				(= seconds 3)
			)
			(2
				(if (== (Platform) 1)
					(cond
						((IsFlag 470)
							(self setScript: flopMovie1 self)
						)
						((== (Platform) 1)
							(ShowMovie
								{1.SEQ}
								7
								(if (IsHiRes) 150 else 0)
								(if (IsHiRes) 135 else 0)
							)
						)
						(else
							(ShowMovie 0 {1.AVI}) ; Open
							(ShowMovie 1 0 0 320 200) ; Put
							(ShowMovie 2 2) ; Play
							(ShowMovie 6) ; Close
						)
					)
				else
					(ShowMovie 0 {INTRO.AVI}) ; Open
					(ShowMovie 1 60 25 200 150) ; Put
					(ShowMovie 2 2) ; Play
					(ShowMovie 6) ; Close
					(= cycles 2)
				)
			)
			(3
				(if (== (Platform) 1)
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
				else
					(gGkMusic1 fade:)
					(SetCursor 1)
					(gCurRoom newRoom: 180) ; creditRm
					(self dispose:)
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
				(if (IsFlag 470)
					(self setScript: flopMovie4 self)
				else
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
					(self cue:)
				)
			)
			(6
				(if (IsFlag 470)
					(self setScript: flopMovie5 self)
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
				(if (IsFlag 470)
					(self setScript: flopMovie6 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{PAN1.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
						(ShowMovie
							{SNAKE.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
						(ShowMovie
							{PAN2.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {PAN1.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
						(ShowMovie 0 {SNAKE.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
						(ShowMovie 0 {PAN2.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= cycles 1)
				)
			)
			(8
				(if (IsFlag 470)
					(self setScript: flopMovie7 self)
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
			(9
				(if (IsFlag 470)
					(self setScript: flopMovie8 self)
				else
					(if (== (Platform) 1)
						(ShowMovie
							{WAKE.SEQ}
							7
							(if (IsHiRes) 150 else 0)
							(if (IsHiRes) 135 else 0)
						)
					else
						(ShowMovie 0 {WAKE.AVI}) ; Open
						(ShowMovie 1 0 0 320 200) ; Put
						(ShowMovie 2 2) ; Play
						(ShowMovie 6) ; Close
					)
					(= seconds 5)
				)
			)
			(10
				(= seconds 2)
			)
			(11
				(gGkMusic1 fade:)
				(SetCursor 1)
				(gCurRoom newRoom: 180) ; creditRm
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
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 111 14)
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 112 14)
				(= ticks 25)
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
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 114 14)
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 115 14)
				(= ticks 25)
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
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 117 14)
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 118 14)
				(= ticks 25)
			)
			(3
				(gCurRoom drawPic: 119 14)
				(= ticks 25)
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
				(gCurRoom drawPic: 120 14)
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 121 14)
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 122 14)
				(= ticks 25)
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

(instance flopMovie5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 130 14)
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 131 14)
				(= ticks 25)
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

(instance flopMovie6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 137 14)
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 138 14)
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 139 14)
				(= ticks 25)
			)
			(3
				(gCurRoom drawPic: 140 14)
				(= ticks 25)
			)
			(4
				(gCurRoom drawPic: 141 14)
				(= ticks 25)
			)
			(5
				(gCurRoom drawPic: 142 14)
				(= ticks 25)
			)
			(6
				(gCurRoom drawPic: 143 14)
				(= ticks 25)
			)
			(7
				(gCurRoom drawPic: 144 14)
				(= ticks 25)
			)
			(8
				(gCurRoom drawPic: 145 14)
				(= ticks 25)
			)
			(9
				(gCurRoom drawPic: 99 14)
				(= ticks 1)
			)
			(10
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
				(gCurRoom drawPic: 146 14)
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 147 14)
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 148 14)
				(= seconds 3)
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

(instance flopMovie8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 149 14)
				(= ticks 25)
			)
			(1
				(gCurRoom drawPic: 150 14)
				(= ticks 25)
			)
			(2
				(gCurRoom drawPic: 151 14)
				(= seconds 3)
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

