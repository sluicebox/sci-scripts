;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use snakes)
(use ForwardCounter)
(use Path)
(use Actor)

(public
	slSqr1 1
	slSqr2 2
	slSqr3 3
	slSqr4 4
	slSqr5 5
	slSqr6 6
	slSqr7 7
	slSqr8 8
	slSqr9 9
	slSqr10 10
	slSqr11 11
	slSqr12 12
	slSqr13 13
	slSqr14 14
	slSqr15 15
	slSqr16 16
	slSqr17 17
	slSqr18 18
	slSqr19 19
	slSqr20 20
	slSqr21 21
	slSqr22 22
	slSqr23 23
	slSqr24 24
	slSqr25 25
	slSqr26 26
	slSqr27 27
	slSqr28 28
	slSqr29 29
	slSqr30 30
	slSqr31 31
	slSqr32 32
	slSqr33 33
	slSqr34 34
	slSqr35 35
	slSqr36 36
	slSqr37 37
	slSqr38 38
	slSqr39 39
	slSqr40 40
	slSqr41 41
	slSqr42 42
	slSqr43 43
	slSqr44 44
	slSqr45 45
	slSqr46 46
	slSqr47 47
	slSqr48 48
	slSqr49 49
	slSqr50 50
	slSqr51 51
	slSqr52 52
	slSqr53 53
	slSqr54 54
	slSqr55 55
	slSqr56 56
	slSqr57 57
	slSqr58 58
	slSqr59 59
	slSqr60 60
	slSqr61 61
	slSqr62 62
	slSqr63 63
	slSqr64 64
	slSqr65 65
	slSqr66 66
	slSqr67 67
	slSqr68 68
	slSqr69 69
	slSqr70 70
	slSqr71 71
	slSqr72 72
	slSqr73 73
	slSqr74 74
	slSqr75 75
	slSqr76 76
	slSqr77 77
	slSqr78 78
	slSqr79 79
	slSqr80 80
	slSqr81 81
	slSqr82 82
	slSqr83 83
	slSqr84 84
	slSqr85 85
	slSqr86 86
	slSqr87 87
	slSqr88 88
	ladder1 89
	ladder2 90
	ladder3 91
	ladder4 92
	ladder5 93
	ladder6 94
	ladder7 95
	snake1 96
	snake2 97
	snake3 98
	snake4 99
	snake5 100
	snake6 101
	snake7 102
	snakeHead1 103
	snakeHead2 104
	snakeHead3 105
	snakeHead4 106
	snakeHead5 107
	snakeHead6 108
	snakeHead7 109
	snakeTail2 110
	snakeTail4 111
	snakeTail6 112
)

(local
	[local0 9] = [167 139 167 155 180 160 190 171 -32768]
	[local9 25] = [241 122 235 131 237 138 251 137 256 130 244 132 245 146 264 147 258 144 250 154 252 164 271 167 -32768]
	[local34 13] = [61 108 59 118 61 131 51 134 28 137 30 153 -32768]
	[local47 17] = [176 63 162 74 126 86 115 100 117 111 138 126 142 137 129 150 -32768]
	[local64 9] = [278 65 262 85 268 96 279 94 -32768]
	[local73 9] = [196 48 200 65 184 80 199 89 -32768]
	[local82 9] = [54 44 59 54 78 58 82 72 -32768]
	[local91 3] = [81 144 -32768]
	[local94 3] = [157 164 -32768]
	[local97 3] = [143 59 -32768]
	[local100 3] = [92 123 -32768]
	[local103 7] = [40 116 36 105 35 82 -32768]
	[local110 3] = [261 46 -32768]
	[local113 3] = [109 40 -32768]
)

(instance slSqr1 of slSqr
	(properties
		nsTop 164
		nsLeft 23
		nsBottom 184
		nsRight 48
		direct 1
		row 1
	)
)

(instance slSqr2 of slSqr
	(properties
		nsTop 164
		nsLeft 49
		nsBottom 184
		nsRight 73
		direct 1
		row 1
	)
)

(instance slSqr3 of slSqr
	(properties
		nsTop 164
		nsLeft 74
		nsBottom 184
		nsRight 97
		direct 1
		row 1
	)
)

(instance slSqr4 of slSqr
	(properties
		nsTop 164
		nsLeft 98
		nsBottom 184
		nsRight 120
		direct 1
		row 1
	)
)

(instance slSqr5 of slSqr
	(properties
		nsTop 164
		nsLeft 121
		nsBottom 184
		nsRight 144
		direct 1
		row 1
	)
)

(instance slSqr6 of slSqr
	(properties
		nsTop 164
		nsLeft 145
		nsBottom 184
		nsRight 172
		direct 1
		row 1
	)
)

(instance slSqr7 of slSqr
	(properties
		nsTop 164
		nsLeft 173
		nsBottom 184
		nsRight 195
		direct 1
		row 1
	)
)

(instance slSqr8 of slSqr
	(properties
		nsTop 164
		nsLeft 196
		nsBottom 184
		nsRight 221
		direct 1
		row 1
	)
)

(instance slSqr9 of slSqr
	(properties
		nsTop 164
		nsLeft 222
		nsBottom 184
		nsRight 242
		direct 1
		row 1
	)
)

(instance slSqr10 of slSqr
	(properties
		nsTop 164
		nsLeft 243
		nsBottom 184
		nsRight 270
		direct 1
		row 1
	)
)

(instance slSqr11 of slSqr
	(properties
		nsTop 164
		nsLeft 271
		nsBottom 184
		nsRight 298
		direct 2
		row 1
	)
)

(instance slSqr22 of slSqr
	(properties
		nsTop 145
		nsLeft 23
		nsBottom 163
		nsRight 48
		direct 2
		row 2
	)
)

(instance slSqr21 of slSqr
	(properties
		nsTop 145
		nsLeft 49
		nsBottom 163
		nsRight 73
		row 2
	)
)

(instance slSqr20 of slSqr
	(properties
		nsTop 145
		nsLeft 74
		nsBottom 163
		nsRight 97
		row 2
	)
)

(instance slSqr19 of slSqr
	(properties
		nsTop 145
		nsLeft 98
		nsBottom 163
		nsRight 120
		row 2
	)
)

(instance slSqr18 of slSqr
	(properties
		nsTop 145
		nsLeft 121
		nsBottom 163
		nsRight 144
		row 2
	)
)

(instance slSqr17 of slSqr
	(properties
		nsTop 145
		nsLeft 145
		nsBottom 163
		nsRight 172
		row 2
	)
)

(instance slSqr16 of slSqr
	(properties
		nsTop 145
		nsLeft 173
		nsBottom 163
		nsRight 195
		row 2
	)
)

(instance slSqr15 of slSqr
	(properties
		nsTop 145
		nsLeft 196
		nsBottom 163
		nsRight 221
		row 2
	)
)

(instance slSqr14 of slSqr
	(properties
		nsTop 145
		nsLeft 222
		nsBottom 163
		nsRight 242
		row 2
	)
)

(instance slSqr13 of slSqr
	(properties
		nsTop 145
		nsLeft 243
		nsBottom 163
		nsRight 270
		row 2
	)
)

(instance slSqr12 of slSqr
	(properties
		nsTop 145
		nsLeft 271
		nsBottom 163
		nsRight 298
		row 2
	)
)

(instance slSqr23 of slSqr
	(properties
		nsTop 121
		nsLeft 23
		nsBottom 144
		nsRight 48
		row 3
	)
)

(instance slSqr24 of slSqr
	(properties
		nsTop 121
		nsLeft 49
		nsBottom 144
		nsRight 73
		direct 1
		row 3
	)
)

(instance slSqr25 of slSqr
	(properties
		nsTop 121
		nsLeft 74
		nsBottom 144
		nsRight 97
		direct 1
		row 3
	)
)

(instance slSqr26 of slSqr
	(properties
		nsTop 121
		nsLeft 98
		nsBottom 144
		nsRight 120
		direct 1
		row 3
	)
)

(instance slSqr27 of slSqr
	(properties
		nsTop 121
		nsLeft 121
		nsBottom 144
		nsRight 144
		direct 1
		row 3
	)
)

(instance slSqr28 of slSqr
	(properties
		nsTop 121
		nsLeft 145
		nsBottom 144
		nsRight 172
		direct 1
		row 3
	)
)

(instance slSqr29 of slSqr
	(properties
		nsTop 121
		nsLeft 173
		nsBottom 144
		nsRight 195
		direct 1
		row 3
	)
)

(instance slSqr30 of slSqr
	(properties
		nsTop 121
		nsLeft 196
		nsBottom 144
		nsRight 221
		direct 1
		row 3
	)
)

(instance slSqr31 of slSqr
	(properties
		nsTop 121
		nsLeft 222
		nsBottom 144
		nsRight 242
		direct 1
		row 3
	)
)

(instance slSqr32 of slSqr
	(properties
		nsTop 121
		nsLeft 243
		nsBottom 144
		nsRight 270
		direct 1
		row 3
	)
)

(instance slSqr33 of slSqr
	(properties
		nsTop 121
		nsLeft 271
		nsBottom 144
		nsRight 298
		direct 2
		row 3
	)
)

(instance slSqr44 of slSqr
	(properties
		nsTop 101
		nsLeft 23
		nsBottom 120
		nsRight 48
		direct 2
		row 4
	)
)

(instance slSqr43 of slSqr
	(properties
		nsTop 101
		nsLeft 49
		nsBottom 120
		nsRight 73
		row 4
	)
)

(instance slSqr42 of slSqr
	(properties
		nsTop 101
		nsLeft 74
		nsBottom 120
		nsRight 97
		row 4
	)
)

(instance slSqr41 of slSqr
	(properties
		nsTop 101
		nsLeft 98
		nsBottom 120
		nsRight 120
		row 4
	)
)

(instance slSqr40 of slSqr
	(properties
		nsTop 101
		nsLeft 121
		nsBottom 120
		nsRight 144
		row 4
	)
)

(instance slSqr39 of slSqr
	(properties
		nsTop 101
		nsLeft 145
		nsBottom 120
		nsRight 172
		row 4
	)
)

(instance slSqr38 of slSqr
	(properties
		nsTop 101
		nsLeft 173
		nsBottom 120
		nsRight 195
		row 4
	)
)

(instance slSqr37 of slSqr
	(properties
		nsTop 101
		nsLeft 196
		nsBottom 120
		nsRight 221
		row 4
	)
)

(instance slSqr36 of slSqr
	(properties
		nsTop 101
		nsLeft 222
		nsBottom 120
		nsRight 242
		row 4
	)
)

(instance slSqr35 of slSqr
	(properties
		nsTop 101
		nsLeft 243
		nsBottom 120
		nsRight 270
		row 4
	)
)

(instance slSqr34 of slSqr
	(properties
		nsTop 101
		nsLeft 271
		nsBottom 120
		nsRight 298
		row 4
	)
)

(instance slSqr45 of slSqr
	(properties
		nsTop 81
		nsLeft 23
		nsBottom 100
		nsRight 48
		row 5
	)
)

(instance slSqr46 of slSqr
	(properties
		nsTop 81
		nsLeft 49
		nsBottom 100
		nsRight 73
		direct 1
		row 5
	)
)

(instance slSqr47 of slSqr
	(properties
		nsTop 81
		nsLeft 74
		nsBottom 100
		nsRight 97
		direct 1
		row 5
	)
)

(instance slSqr48 of slSqr
	(properties
		nsTop 81
		nsLeft 98
		nsBottom 100
		nsRight 120
		direct 1
		row 5
	)
)

(instance slSqr49 of slSqr
	(properties
		nsTop 81
		nsLeft 121
		nsBottom 100
		nsRight 144
		direct 1
		row 5
	)
)

(instance slSqr50 of slSqr
	(properties
		nsTop 81
		nsLeft 145
		nsBottom 100
		nsRight 172
		direct 1
		row 5
	)
)

(instance slSqr51 of slSqr
	(properties
		nsTop 81
		nsLeft 173
		nsBottom 100
		nsRight 195
		direct 1
		row 5
	)
)

(instance slSqr52 of slSqr
	(properties
		nsTop 81
		nsLeft 196
		nsBottom 100
		nsRight 221
		direct 1
		row 5
	)
)

(instance slSqr53 of slSqr
	(properties
		nsTop 81
		nsLeft 222
		nsBottom 100
		nsRight 242
		direct 1
		row 5
	)
)

(instance slSqr54 of slSqr
	(properties
		nsTop 81
		nsLeft 243
		nsBottom 100
		nsRight 270
		direct 1
		row 5
	)
)

(instance slSqr55 of slSqr
	(properties
		nsTop 81
		nsLeft 271
		nsBottom 100
		nsRight 298
		direct 2
		row 5
	)
)

(instance slSqr66 of slSqr
	(properties
		nsTop 61
		nsLeft 23
		nsBottom 80
		nsRight 48
		direct 2
		row 6
	)
)

(instance slSqr65 of slSqr
	(properties
		nsTop 61
		nsLeft 49
		nsBottom 80
		nsRight 73
		row 6
	)
)

(instance slSqr64 of slSqr
	(properties
		nsTop 61
		nsLeft 74
		nsBottom 80
		nsRight 97
		row 6
	)
)

(instance slSqr63 of slSqr
	(properties
		nsTop 61
		nsLeft 98
		nsBottom 80
		nsRight 120
		row 6
	)
)

(instance slSqr62 of slSqr
	(properties
		nsTop 61
		nsLeft 121
		nsBottom 80
		nsRight 144
		row 6
	)
)

(instance slSqr61 of slSqr
	(properties
		nsTop 61
		nsLeft 145
		nsBottom 80
		nsRight 172
		row 6
	)
)

(instance slSqr60 of slSqr
	(properties
		nsTop 61
		nsLeft 173
		nsBottom 80
		nsRight 195
		row 6
	)
)

(instance slSqr59 of slSqr
	(properties
		nsTop 61
		nsLeft 196
		nsBottom 80
		nsRight 221
		row 6
	)
)

(instance slSqr58 of slSqr
	(properties
		nsTop 61
		nsLeft 222
		nsBottom 80
		nsRight 242
		row 6
	)
)

(instance slSqr57 of slSqr
	(properties
		nsTop 61
		nsLeft 243
		nsBottom 80
		nsRight 270
		row 6
	)
)

(instance slSqr56 of slSqr
	(properties
		nsTop 61
		nsLeft 271
		nsBottom 80
		nsRight 298
		row 6
	)
)

(instance slSqr67 of slSqr
	(properties
		nsTop 41
		nsLeft 23
		nsBottom 60
		nsRight 48
		row 7
	)
)

(instance slSqr68 of slSqr
	(properties
		nsTop 41
		nsLeft 49
		nsBottom 60
		nsRight 73
		direct 1
		row 7
	)
)

(instance slSqr69 of slSqr
	(properties
		nsTop 41
		nsLeft 74
		nsBottom 60
		nsRight 97
		direct 1
		row 7
	)
)

(instance slSqr70 of slSqr
	(properties
		nsTop 41
		nsLeft 98
		nsBottom 60
		nsRight 120
		direct 1
		row 7
	)
)

(instance slSqr71 of slSqr
	(properties
		nsTop 41
		nsLeft 121
		nsBottom 60
		nsRight 144
		direct 1
		row 7
	)
)

(instance slSqr72 of slSqr
	(properties
		nsTop 41
		nsLeft 145
		nsBottom 60
		nsRight 172
		direct 1
		row 7
	)
)

(instance slSqr73 of slSqr
	(properties
		nsTop 41
		nsLeft 173
		nsBottom 60
		nsRight 195
		direct 1
		row 7
	)
)

(instance slSqr74 of slSqr
	(properties
		nsTop 41
		nsLeft 196
		nsBottom 60
		nsRight 221
		direct 1
		row 7
	)
)

(instance slSqr75 of slSqr
	(properties
		nsTop 41
		nsLeft 222
		nsBottom 60
		nsRight 242
		direct 1
		row 7
	)
)

(instance slSqr76 of slSqr
	(properties
		nsTop 41
		nsLeft 243
		nsBottom 60
		nsRight 270
		direct 1
		row 7
	)
)

(instance slSqr77 of slSqr
	(properties
		nsTop 41
		nsLeft 271
		nsBottom 60
		nsRight 298
		direct 2
		row 7
	)
)

(instance slSqr88 of slSqr
	(properties
		nsTop 19
		nsLeft 23
		nsBottom 40
		nsRight 48
		direct 1
		row 8
	)
)

(instance slSqr87 of slSqr
	(properties
		nsTop 19
		nsLeft 49
		nsBottom 40
		nsRight 73
		row 8
	)
)

(instance slSqr86 of slSqr
	(properties
		nsTop 19
		nsLeft 74
		nsBottom 40
		nsRight 97
		row 8
	)
)

(instance slSqr85 of slSqr
	(properties
		nsTop 19
		nsLeft 98
		nsBottom 40
		nsRight 120
		row 8
	)
)

(instance slSqr84 of slSqr
	(properties
		nsTop 19
		nsLeft 121
		nsBottom 40
		nsRight 144
		row 8
	)
)

(instance slSqr83 of slSqr
	(properties
		nsTop 19
		nsLeft 145
		nsBottom 40
		nsRight 172
		row 8
	)
)

(instance slSqr82 of slSqr
	(properties
		nsTop 19
		nsLeft 173
		nsBottom 40
		nsRight 195
		row 8
	)
)

(instance slSqr81 of slSqr
	(properties
		nsTop 19
		nsLeft 196
		nsBottom 40
		nsRight 221
		row 8
	)
)

(instance slSqr80 of slSqr
	(properties
		nsTop 19
		nsLeft 222
		nsBottom 40
		nsRight 242
		row 8
	)
)

(instance slSqr79 of slSqr
	(properties
		nsTop 19
		nsLeft 243
		nsBottom 40
		nsRight 270
		row 8
	)
)

(instance slSqr78 of slSqr
	(properties
		nsTop 19
		nsLeft 271
		nsBottom 40
		nsRight 298
		row 8
	)
)

(instance ladder1 of Path
	(properties)

	(method (at param1)
		(return [local91 param1])
	)
)

(instance ladder2 of Path
	(properties)

	(method (at param1)
		(return [local94 param1])
	)
)

(instance ladder3 of Path
	(properties)

	(method (at param1)
		(return [local97 param1])
	)
)

(instance ladder4 of Path
	(properties)

	(method (at param1)
		(return [local100 param1])
	)
)

(instance ladder5 of Path
	(properties)

	(method (at param1)
		(return [local103 param1])
	)
)

(instance ladder6 of Path
	(properties)

	(method (at param1)
		(return [local110 param1])
	)
)

(instance ladder7 of Path
	(properties)

	(method (at param1)
		(return [local113 param1])
	)
)

(instance snake1 of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance snake2 of Path
	(properties)

	(method (at param1)
		(return [local9 param1])
	)
)

(instance snake3 of Path
	(properties)

	(method (at param1)
		(return [local34 param1])
	)
)

(instance snake4 of Path
	(properties)

	(method (at param1)
		(return [local47 param1])
	)
)

(instance snake5 of Path
	(properties)

	(method (at param1)
		(return [local64 param1])
	)
)

(instance snake6 of Path
	(properties)

	(method (at param1)
		(return [local73 param1])
	)
)

(instance snake7 of Path
	(properties)

	(method (at param1)
		(return [local82 param1])
	)
)

(instance snakeHead1 of Prop
	(properties)

	(method (init)
		(if (== (self view:) 611)
			(self view: 612)
			(gSound3 play: 601 setLoop: -1)
			(++ global452)
		else
			(self view: 611)
		)
		(self
			setPri: 0
			posn: 174 134
			setLoop: 2
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 2 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (== (self view:) 612)
			(-- global452)
		)
		(self dispose:)
	)
)

(instance snakeHead2 of Prop
	(properties)

	(method (init)
		(if (== (self view:) 611)
			(self view: 612)
			(gSound3 play: 601 setLoop: -1)
			(++ global452)
		else
			(self view: 611)
		)
		(self
			setPri: 0
			posn: 283 166
			setLoop: 1
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 3 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (== (self view:) 612)
			(-- global452)
		)
		(self dispose:)
	)
)

(instance snakeTail2 of Prop
	(properties)

	(method (init)
		(gSound4 play: 602 setLoop: -1)
		(++ global453)
		(self
			view: 611
			setPri: 0
			posn: 229 108
			setLoop: 8
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 4 self
		)
		(super init: &rest)
	)

	(method (cue)
		(-- global453)
		(self dispose:)
	)
)

(instance snakeHead3 of Prop
	(properties)

	(method (init)
		(if (== (self view:) 611)
			(self view: 612)
			(++ global452)
			(gSound3 play: 601 setLoop: -1)
		else
			(self view: 611)
		)
		(self
			setPri: 0
			posn: 27 151
			setLoop: 6
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 2 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (== (self view:) 612)
			(-- global452)
		)
		(self dispose:)
	)
)

(instance snakeHead4 of Prop
	(properties)

	(method (init)
		(if (== (self view:) 611)
			(self view: 612)
			(++ global452)
			(gSound3 play: 601 setLoop: -1)
		else
			(self view: 611)
		)
		(self
			setPri: 0
			posn: 174 45
			setLoop: 4
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 3 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (== (self view:) 612)
			(-- global452)
		)
		(self dispose:)
	)
)

(instance snakeTail4 of Prop
	(properties)

	(method (init)
		(++ global453)
		(gSound4 play: 602 setLoop: -1)
		(self
			view: 611
			setPri: 0
			posn: 115 132
			setLoop: 9
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 5 self
		)
		(super init: &rest)
	)

	(method (cue)
		(-- global453)
		(self dispose:)
	)
)

(instance snakeHead5 of Prop
	(properties)

	(method (init)
		(if (== (self view:) 611)
			(self view: 612)
			(++ global452)
			(gSound3 play: 601 setLoop: -1)
		else
			(self view: 611)
		)
		(self
			setPri: 0
			posn: 281 87
			setLoop: 0
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 2 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (== (self view:) 612)
			(-- global452)
		)
		(self dispose:)
	)
)

(instance snakeHead6 of Prop
	(properties)

	(method (init)
		(if (== (self view:) 611)
			(self view: 612)
			(++ global452)
			(gSound3 play: 601 setLoop: -1)
		else
			(self view: 611)
		)
		(self
			setPri: 0
			posn: 206 23
			setLoop: 5
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 3 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (== (self view:) 612)
			(-- global452)
		)
		(self dispose:)
	)
)

(instance snakeTail6 of Prop
	(properties)

	(method (init)
		(++ global453)
		(gSound4 play: 602 setLoop: -1)
		(self
			view: 611
			setPri: 0
			posn: 201 80
			setLoop: 7
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 4 self
		)
		(super init: &rest)
	)

	(method (cue)
		(-- global453)
		(self dispose:)
	)
)

(instance snakeHead7 of Prop
	(properties)

	(method (init)
		(if (== (self view:) 611)
			(self view: 612)
			(++ global452)
			(gSound3 play: 601 setLoop: -1)
		else
			(self view: 611)
		)
		(self
			setPri: 0
			posn: 77 66
			setLoop: 3
			ignoreActors:
			cycleSpeed: 5
			setCycle: ForwardCounter 2 self
		)
		(super init: &rest)
	)

	(method (cue)
		(if (== (self view:) 612)
			(-- global452)
		)
		(self dispose:)
	)
)

