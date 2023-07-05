;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use brain)
(use eRS)
(use Motion)
(use System)

(public
	rm520 0
)

(instance rm520 of SQRoom
	(properties
		picture 520
		style 10
		north 505
		east 525
		west 515
	)

	(method (init)
		(if (== gPrevRoomNum 505)
			(self
				setScript: fromNorthScript 0 (if (< (gEgo x:) 90) 0 else 1)
			)
		else
			(HandsOn)
		)
		(gEgo init:)
		(self setRegions: 704) ; brain
		(super init:)
		(switch (brain level:)
			(1
				(brain
					makePolygon:
						0
						159
						60
						159
						95
						180
						208
						180
						246
						162
						246
						105
						210
						121
						210
						156
						96
						156
						96
						118
						63
						106
						63
						134
						0
						134
						0
						0
						319
						0
						319
						189
						0
						189
				)
			)
			(2
				(brain
					makePolygon:
						0
						130
						59
						130
						96
						149
						207
						149
						244
						132
						319
						132
						319
						189
						0
						189
				)
				(brain
					makePolygon:
						0
						0
						319
						0
						319
						112
						250
						112
						207
						128
						104
						128
						58
						110
						0
						110
				)
			)
			(3
				(brain
					makePolygon:
						0
						97
						61
						97
						93
						109
						206
						109
						246
						97
						319
						97
						319
						189
						0
						189
				)
				(brain makePolygon: 0 37 78 37 68 75 0 75)
				(brain
					makePolygon: 0 0 319 0 319 24 241 24 206 7 108 7 81 24 0 24
				)
				(brain makePolygon: 319 76 253 76 244 35 319 35)
				(brain
					makePolygon:
						94
						81
						94
						61
						90
						52
						119
						40
						204
						40
						226
						51
						226
						65
						230
						81
						214
						87
						108
						87
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (== (brain level:) 1) (StepOn gEgo 32))
				(brain level: 2)
				(self newRoom: north)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 500 say: 2) ; "This maze of cables, ducts, pipes, and glowing panels gives the super brain computer a sense of being alive..."
			)
			(2 ; Talk
				(gNarrator modNum: 510 say: 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fromNorthScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(if register
					(= temp0 235)
					(= temp1 141)
					(= temp2 235)
					(= temp3 167)
				else
					(= temp0 91)
					(= temp1 144)
					(= temp2 91)
					(= temp3 172)
				)
				(gEgo posn: temp0 temp1 setMotion: MoveTo temp2 temp3 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

