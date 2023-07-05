;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use Game)
(use Actor)
(use System)

(public
	rm111 0
)

(local
	[local0 11]
	[local11 11]
	local22
	local23
	[local24 7] = [-1 110 111 112 113 130 150]
	[local31 7]
)

(procedure (localproc_0 param1 param2 &tmp temp0 [temp1 5] temp6)
	(for ((= temp0 0)) (<= temp0 argc) ((++ temp0))
		(= [temp1 temp0] [param2 temp0])
	)
	(= local23 0)
	(= temp6 (- 160 (/ (CelWide [temp1 0] [temp1 1] [temp1 2]) 2)))
	((= [local11 param1] (View new:))
		name: {credit}
		view: [temp1 0]
		setLoop: [temp1 1]
		cel: [temp1 2]
		x: temp6
		y: local22
		init:
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 [temp1 5] temp6)
	(for ((= temp0 0)) (<= temp0 argc) ((++ temp0))
		(= [temp1 temp0] [param2 temp0])
	)
	(= temp6 (- 160 (/ (CelWide [temp1 0] [temp1 1] [temp1 2]) 2)))
	(if local22
		(= local23 (+ local22 21))
		(= local22 0)
	else
		(+= local23 14)
	)
	((= [local0 param1] (View new:))
		name: {name}
		view: [temp1 0]
		setLoop: [temp1 1]
		cel: [temp1 2]
		x: temp6
		y: local23
		init:
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(if (IsObject [local0 temp0])
			([local0 temp0] dispose:)
			(= [local0 temp0] 0)
		)
		(if (IsObject [local11 temp0])
			([local11 temp0] dispose:)
			(= [local11 temp0] 0)
		)
		(if (IsObject [local31 temp0])
			([local31 temp0] dispose:)
			(= [local31 temp0] 0)
		)
	)
)

(instance rm111 of Rm
	(properties
		picture 112
		style 10
	)

	(method (init &tmp temp0)
		(gEgo view: 111 x: 1000 y: 1000 init:)
		(gMouseDownHandler add: creditScript)
		(gKeyDownHandler add: creditScript)
		(= temp0 [local24 (Random 1 6)])
		(gLongSong number: temp0 setLoop: -1 play: 10 fade: 127 10 30 0)
		(super init:)
		(self setScript: creditScript)
		(gGame setCursor: 996 1)
	)

	(method (cue)
		(gGame setCursor: 999 1)
		(gCurRoom newRoom: 802)
	)
)

(instance creditScript of Script
	(properties)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gLongSong fade: 0 10 30 1 gCurRoom)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) $4005) ; evVERB | evMOUSEKEYBOARD
			(= seconds 0)
			(= cycles 2)
			(= state 17)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState &tmp temp0)
		(localproc_2)
		(if (< state 17)
			(gCurRoom curPic: 0 drawPic: 111)
		)
		(gGame setCursor: 996 1)
		(switch (= state newState)
			(0
				(gGame setCursor: 996)
				(= local22 (- 95 (/ (+ (CelHigh 111 0 0) (CelHigh 112 0 0)) 2)))
				(localproc_0 0 111 0 0)
				(localproc_1 0 112 0 0)
				((= [local31 1] (View new:))
					view: 113
					loop: 0
					cel: 0
					x: 27
					y: 81
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 0
					cel: 1
					x: 307
					y: 148
					init:
				)
				((= [local31 3] (View new:))
					view: 113
					loop: 0
					cel: 1
					x: 281
					y: 143
					init:
				)
				((= [local31 4] (View new:))
					view: 113
					loop: 0
					cel: 2
					x: 243
					y: 156
					init:
				)
				(= seconds 8)
			)
			(1
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 1)
								(CelHigh 112 0 0)
								(CelHigh 112 0 1)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 1)
				(localproc_1 0 112 0 0)
				(localproc_1 1 112 0 1)
				((= [local31 1] (View new:))
					view: 113
					loop: 0
					cel: 4
					x: 151
					y: 205
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 0
					cel: 3
					x: 139
					y: 0
					init:
				)
				(= seconds 8)
			)
			(2
				(= local22 (- 95 (/ (+ (CelHigh 111 0 2) (CelHigh 112 1 0)) 2)))
				(localproc_0 0 111 0 2)
				(localproc_1 0 112 1 0)
				((= [local31 1] (View new:))
					view: 113
					loop: 1
					cel: 1
					x: 273
					y: 161
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 1
					cel: 0
					x: 40
					y: 58
					init:
				)
				(= seconds 8)
			)
			(3
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 3)
								(CelHigh 112 0 3)
								(CelHigh 112 0 2)
								(CelHigh 112 0 4)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 3)
				(localproc_1 0 112 0 3)
				(localproc_1 1 112 0 2)
				(localproc_1 2 112 0 4)
				((= [local31 1] (View new:))
					view: 113
					loop: 1
					cel: 3
					x: 55
					y: 179
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 1
					cel: 2
					x: 257
					y: 92
					init:
				)
				(= seconds 8)
			)
			(4
				(= local22 (- 95 (/ (+ (CelHigh 111 0 4) (CelHigh 112 3 0)) 2)))
				(localproc_0 0 111 0 4)
				(localproc_1 0 112 3 0)
				((= [local31 1] (View new:))
					view: 7
					loop: 1
					cel: 3
					x: 49
					y: 83
					init:
				)
				((= [local31 2] (View new:))
					view: 3
					loop: 2
					cel: 3
					x: 285
					y: 131
					init:
				)
				(= seconds 8)
			)
			(5
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 5)
								(CelHigh 112 1 1)
								(CelHigh 112 1 2)
								(CelHigh 112 1 3)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 5)
				(localproc_1 0 112 1 1)
				(localproc_1 1 112 1 2)
				(localproc_1 2 112 1 3)
				((= [local31 1] (View new:))
					view: 113
					loop: 1
					cel: 4
					x: 167
					y: 90
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 2
					cel: 0
					x: 163
					y: 178
					init:
				)
				(= seconds 8)
			)
			(6
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 6)
								(CelHigh 112 0 0)
								(CelHigh 112 0 1)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 6)
				(localproc_1 0 112 0 0)
				(localproc_1 1 112 0 1)
				((= [local31 1] (View new:))
					view: 113
					loop: 2
					cel: 1
					x: 81
					y: 63
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 2
					cel: 2
					x: 270
					y: 184
					init:
				)
				(= seconds 8)
			)
			(7
				(= local22 (- 95 (/ (+ (CelHigh 111 0 7) (CelHigh 112 0 1)) 2)))
				(localproc_0 0 111 0 7)
				(localproc_1 0 112 0 1)
				((= [local31 1] (View new:))
					view: 113
					loop: 2
					cel: 3
					x: 158
					y: 71
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 2
					cel: 4
					x: 163
					y: 199
					init:
				)
				(= seconds 8)
			)
			(8
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 8)
								(CelHigh 112 0 0)
								(CelHigh 112 0 1)
								(CelHigh 112 0 3)
								(CelHigh 112 0 2)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 8)
				(localproc_1 0 112 0 0)
				(localproc_1 1 112 0 1)
				(localproc_1 2 112 0 3)
				(localproc_1 3 112 0 2)
				((= [local31 1] (View new:))
					view: 113
					loop: 2
					cel: 5
					x: 52
					y: 121
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 2
					cel: 6
					x: 270
					y: 129
					init:
				)
				(= seconds 8)
			)
			(9
				(= local22 (- 95 (/ (+ (CelHigh 111 0 9) (CelHigh 112 5 5)) 2)))
				(localproc_0 0 111 0 9)
				(localproc_1 0 112 5 5)
				((= [local31 1] (View new:))
					view: 113
					loop: 3
					cel: 0
					x: 84
					y: 91
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 3
					cel: 1
					x: 262
					y: 169
					init:
				)
				(= seconds 8)
			)
			(10
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 10)
								(CelHigh 112 0 6)
								(CelHigh 112 0 7)
								(CelHigh 112 0 8)
								(CelHigh 112 0 4)
								(CelHigh 112 0 5)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 10)
				(localproc_1 0 112 0 6)
				(localproc_1 1 112 0 7)
				(localproc_1 2 112 0 8)
				(localproc_1 3 112 0 4)
				(localproc_1 4 112 0 5)
				((= [local31 1] (View new:))
					view: 113
					loop: 3
					cel: 3
					x: 256
					y: 162
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 3
					cel: 2
					x: 47
					y: 54
					init:
				)
				(= seconds 8)
			)
			(11
				(= local22
					(- 95 (/ (+ (CelHigh 111 0 11) (CelHigh 112 4 0)) 2))
				)
				(localproc_0 0 111 0 11)
				(localproc_1 0 112 4 0)
				((= [local31 1] (View new:))
					view: 113
					loop: 3
					cel: 5
					x: 65
					y: 160
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 3
					cel: 4
					x: 184
					y: 76
					init:
				)
				(= seconds 8)
			)
			(12
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 12)
								(CelHigh 112 3 1)
								(CelHigh 112 3 2)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 12)
				(localproc_1 0 112 3 1)
				(localproc_1 1 112 3 2)
				((= [local31 1] (View new:))
					view: 114
					loop: 0
					cel: 0
					x: 71
					y: 151
					init:
				)
				((= [local31 2] (View new:))
					view: 114
					loop: 0
					cel: 1
					x: 244
					y: 82
					init:
				)
				(= seconds 8)
			)
			(13
				(= local22
					(-
						(-
							95
							(/
								(+
									(CelHigh 111 0 13)
									(CelHigh 112 2 0)
									(CelHigh 112 2 1)
									(CelHigh 112 2 2)
									(CelHigh 112 2 3)
									(CelHigh 112 2 4)
									(CelHigh 112 2 5)
									(CelHigh 112 2 6)
									(CelHigh 112 2 7)
									(CelHigh 112 2 8)
									(CelHigh 112 2 9)
								)
								2
							)
						)
						15
					)
				)
				(localproc_0 0 111 0 13)
				(localproc_1 0 112 2 0)
				(localproc_1 1 112 2 1)
				(localproc_1 2 112 2 2)
				(localproc_1 3 112 2 3)
				(localproc_1 4 112 2 4)
				(localproc_1 5 112 2 5)
				(localproc_1 6 112 2 6)
				(localproc_1 7 112 2 7)
				(localproc_1 8 112 2 8)
				(localproc_1 9 112 2 9)
				((= [local31 1] (View new:))
					view: 114
					loop: 0
					cel: 3
					x: 244
					y: 176
					init:
				)
				((= [local31 2] (View new:))
					view: 114
					loop: 0
					cel: 2
					x: 100
					y: 80
					init:
				)
				(= seconds 8)
			)
			(14
				(= local22
					(-
						95
						(/
							(+
								(CelHigh 111 0 14)
								(CelHigh 112 4 0)
								(CelHigh 112 4 1)
								(CelHigh 112 4 2)
								(CelHigh 112 4 3)
								(CelHigh 112 4 4)
								(CelHigh 112 4 5)
								(CelHigh 112 4 6)
								(CelHigh 112 4 7)
								(CelHigh 112 4 8)
							)
							2
						)
					)
				)
				(localproc_0 0 111 0 14)
				(localproc_1 0 112 4 1)
				(localproc_1 1 112 4 2)
				(localproc_1 2 112 4 3)
				(localproc_1 3 112 4 4)
				(localproc_1 4 112 4 5)
				(localproc_1 5 112 4 6)
				(localproc_1 6 112 4 7)
				(localproc_1 7 112 4 8)
				((= [local31 1] (View new:))
					view: 114
					loop: 0
					cel: 6
					x: 299
					y: 89
					init:
				)
				((= [local31 2] (View new:))
					view: 114
					loop: 0
					cel: 4
					x: 47
					y: 200
					init:
				)
				((= [local31 3] (View new:))
					view: 114
					loop: 0
					cel: 5
					x: 295
					y: 38
					init:
				)
				(= seconds 8)
			)
			(15
				(= local22
					(-
						(-
							95
							(/
								(+
									(CelHigh 111 1 0)
									(CelHigh 111 1 1)
									(CelHigh 112 5 0)
									(CelHigh 111 1 2)
									(CelHigh 112 5 1)
								)
								2
							)
						)
						20
					)
				)
				(localproc_0 0 111 1 0)
				(= local22 67)
				(localproc_0 1 111 1 1)
				(localproc_1 0 112 5 0)
				(= local22 112)
				(localproc_0 2 111 1 2)
				(localproc_1 1 112 5 1)
				((= [local31 1] (View new:))
					view: 114
					loop: 1
					cel: 1
					x: 21
					y: 150
					init:
				)
				((= [local31 2] (View new:))
					view: 114
					loop: 0
					cel: 7
					x: 243
					y: 53
					init:
				)
				((= [local31 3] (View new:))
					view: 114
					loop: 1
					cel: 0
					x: 102
					y: 199
					init:
				)
				(= seconds 8)
			)
			(16
				(= local22
					(-
						(-
							95
							(/
								(+
									(CelHigh 111 2 0)
									(CelHigh 111 2 1)
									(CelHigh 112 5 2)
									(CelHigh 111 5 3)
									(CelHigh 111 2 2)
									(CelHigh 111 5 4)
								)
								2
							)
						)
						13
					)
				)
				(localproc_0 0 111 2 0)
				(= local22 75)
				(localproc_0 1 111 2 1)
				(localproc_1 0 112 5 2)
				(localproc_1 1 112 5 3)
				(= local22 145)
				(localproc_0 2 111 2 2)
				(localproc_1 2 112 5 4)
				((= [local31 1] (View new:))
					view: 114
					loop: 1
					cel: 2
					x: 68
					y: 67
					init:
				)
				((= [local31 2] (View new:))
					view: 114
					loop: 1
					cel: 3
					x: 259
					y: 189
					init:
				)
				(= seconds 8)
			)
			(17
				(= local22 (- 65 (/ (CelHigh 111 3 0) 2)))
				(localproc_0 0 111 3 0)
				(localproc_1 0 112 6 0)
				(localproc_1 1 112 6 1)
				(localproc_1 2 112 6 2)
				(localproc_1 3 112 6 3)
				(localproc_1 4 112 7 1)
				(localproc_1 5 112 7 0)
				(localproc_1 6 112 7 3)
				((= [local31 1] (View new:))
					view: 113
					loop: 4
					cel: 1
					x: 56
					y: 64
					init:
				)
				((= [local31 2] (View new:))
					view: 113
					loop: 4
					cel: 0
					x: 297
					y: 186
					init:
				)
				(= seconds 8)
			)
			(18
				(gCurRoom curPic: 0 drawPic: 112)
				(localproc_2)
				(= cycles 1)
			)
			(19
				(self dispose:)
			)
		)
	)
)

