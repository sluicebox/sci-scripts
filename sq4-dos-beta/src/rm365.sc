;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 365)
(include sci.sh)
(use Main)
(use SQRoom)
(use MCyc)
(use Actor)
(use System)

(public
	rm365 0
)

(local
	[local0 125] = [0 0 0 88 0 0 21 110 0 1 46 116 0 2 40 115 0 2 50 126 0 3 52 132 0 4 83 147 0 5 92 151 0 5 96 155 0 6 101 158 0 6 104 161 0 6 108 165 0 7 113 165 0 7 116 164 0 7 118 162 0 7 119 160 0 7 120 158 0 7 120 156 0 7 120 153 0 7 120 150 0 7 119 144 0 7 118 141 0 7 117 138 0 7 116 135 0 7 115 132 0 7 115 129 0 7 115 126 0 7 116 123 0 7 117 120 0 7 118 117 0 0 -100 -100 -32768]
	[local125 117] = [0 7 297 39 0 7 300 40 0 7 302 42 0 7 303 44 0 7 303 46 0 7 303 49 0 7 303 52 0 7 302 55 0 7 301 58 0 7 300 62 0 7 298 66 0 7 296 70 0 7 294 74 0 7 293 78 0 7 292 82 0 7 291 86 0 7 290 90 0 7 289 98 0 7 288 102 0 7 286 105 0 7 282 108 0 7 278 110 0 7 273 111 0 7 269 111 0 7 264 110 0 7 251 107 0 7 247 106 0 7 244 105 0 0 -100 -100 -32768]
	[local242 61] = [1 0 149 37 1 1 162 29 1 2 170 23 1 3 179 22 1 4 190 26 1 5 202 22 2 0 143 59 2 1 157 52 2 2 166 48 2 3 174 45 2 4 182 41 2 5 190 37 2 6 200 34 2 7 210 33 0 0 -100 -100 -32768]
	[local303 14] = [0 1 2 3 4 5 6 7 8 9 10 11 12 13]
)

(instance rm365 of SQRoom
	(properties
		picture 365
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 14) ((++ temp0))
			((= [local303 temp0] (Clone sign1))
				loop: [local242 (* 4 temp0)]
				cel: [local242 (+ (* 4 temp0) 1)]
				x: [local242 (+ (* 4 temp0) 2)]
				y: [local242 (+ (* 4 temp0) 3)]
				init:
			)
		)
		(gLongSong number: 355 vol: 127 loop: -1 playBed:)
		(car init:)
		(super init:)
		(proc0_14 {Space Quest X} global146)
		(self setScript: signScript)
		(car setScript: fly1Script)
	)
)

(instance signScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (< register 14)
					([local303 register] hide:)
					(++ register)
					(self init:)
				else
					(= cycles 1)
				)
			)
			(2
				(for ((= register 0)) (< register 14) ((++ register))
					([local303 register] show:)
				)
				(= register 0)
				(self init:)
			)
		)
	)
)

(instance fly1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: MCyc @local0)
				(= seconds 7)
			)
			(1
				(client setScript: fly2Script)
			)
		)
	)
)

(instance fly2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: MCyc @local125)
				(= seconds 4)
			)
			(1
				(gLongSong fade:)
				(= seconds 2)
			)
			(2
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance car of Prop
	(properties
		x -100
		y -100
		view 365
	)
)

(instance sign1 of Prop
	(properties
		x -100
		y -100
		view 365
		loop 1
	)
)

