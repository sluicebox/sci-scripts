;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64017)
(include sci.sh)
(use Main)
(use PArray)
(use Array)
(use Flags)

(public
	oFlags 0
)

(class oFlagsClass of Flags
	(properties
		oFlagValues 0
		oPointsLost 0
		oScoreFlags 0
	)

	(method (init)
		(= oScoreFlags (Flags new:))
		(oScoreFlags setSize: 233)
		(= oFlagValues (PArray new: 233))
		(= oPointsLost (IntArray new: 233))
		(super init: &rest)
	)

	(method (dispose)
		(oScoreFlags dispose:)
		(oFlagValues dispose:)
		(oPointsLost dispose:)
		(super dispose: &rest)
	)

	(method (setNoScore flag)
		(PrintDebug
			{SetNoScore should be replaced by normal set. djm. tpflags.sc}
		)
		(super set: flag &rest)
	)

	(method (unSet flag &tmp i theScore bScoreGiven)
		(super clear: flag &rest)
		(for ((= i 0)) (< i argc) ((+= i 1))
			(= theScore (oFlagValues at: [flag i]))
			(= bScoreGiven (oScoreFlags test: [flag i]))
			(if (and theScore bScoreGiven)
				(gGame changeScore: (- 0 theScore))
				(oScoreFlags clear: [flag i])
			)
		)
	)

	(method (set flag &tmp i index theScore bScoreGiven)
		(super set: flag &rest)
		(for ((= i 0)) (< i argc) ((+= i 1))
			(if (< [flag i] (oFlagValues size:))
				(= theScore (oFlagValues at: [flag i]))
				(= bScoreGiven (oScoreFlags test: [flag i]))
				(if (and theScore (not bScoreGiven))
					(gGame changeScore: theScore)
					(oScoreFlags set: [flag i])
				)
			)
		)
	)

	(method (getScore flag)
		(oFlagValues at: flag)
	)

	(method (getPenalty flag &tmp i nSize)
		(= nSize (oPointsLost size:))
		(for ((= i 0)) (< i nSize) ((+= i 2))
			(if (== flag (oPointsLost at: i))
				(return (oPointsLost at: (+ i 1)))
			)
		)
		(return 0)
	)

	(method (setPenalty flag n &tmp i nSize)
		(= nSize (oPointsLost size:))
		(for ((= i 0)) (< i nSize) ((+= i 2))
			(if (== flag (oPointsLost at: i))
				(oPointsLost at: (+ i 1) n)
				(return)
			)
		)
		(oPointsLost at: nSize n)
	)
)

(instance oFlags of oFlagsClass
	(properties
		size 233
	)

	(method (init)
		(super init: &rest)
		(oFlagValues
			add:
				0
				1
				1
				1
				2
				2
				3
				3
				4
				1
				5
				1
				6
				12
				7
				3
				8
				8
				9
				6
				10
				5
				11
				9
				36
				1
				15
				5
				17
				21
				18
				3
				27
				4
				32
				5
				33
				5
				34
				5
				19
				6
				20
				3
				21
				3
				23
				15
				29
				3
				31
				2
				44
				20
				45
				5
				47
				2
				48
				2
				49
				1
				50
				1
				51
				2
				52
				5
				53
				15
				54
				12
				55
				1
				56
				8
				57
				2
				58
				15
				59
				2
				60
				2
				62
				2
				63
				6
				64
				9
				75
				12
				76
				11
				78
				1
				80
				3
				82
				4
				108
				2
				65
				2
				66
				6
				67
				11
				68
				2
				70
				3
				73
				11
				74
				11
				72
				11
				91
				2
				90
				8
				87
				17
				88
				2
				84
				2
				95
				12
				96
				12
				97
				15
				94
				8
				98
				2
				99
				1
				100
				1
				101
				1
				102
				1
				103
				1
				104
				1
				105
				1
				106
				1
				107
				1
				111
				20
				112
				5
				115
				1
				118
				12
				119
				4
				113
				1
				120
				3
				121
				25
				122
				10
				124
				15
				123
				15
				125
				5
				126
				4
				152
				5
				127
				7
				128
				2
				129
				3
				130
				5
				131
				3
				132
				6
				133
				2
				134
				4
				136
				25
				142
				3
				143
				20
				144
				8
				153
				12
				155
				2
				146
				20
				147
				2
				151
				25
				157
				2
				158
				2
				156
				18
				159
				5
				162
				5
				161
				4
				163
				2
				164
				14
				165
				2
				166
				15
				167
				17
				168
				4
				171
				2
				172
				2
				173
				4
				174
				15
				176
				11
				177
				2
				178
				11
				179
				13
				180
				2
				184
				1
				185
				1
				186
				1
				187
				1
				190
				2
				191
				2
				192
				2
				193
				2
				195
				2
				196
				5
				200
				5
				201
				5
				202
				5
				214
				5
				213
				1
				211
				4
				212
				1
				217
				25
				215
				20
				218
				6
				219
				5
				221
				2
				222
				5
				223
				7
				227
				5
				229
				11
				231
				18
		)
	)
)

