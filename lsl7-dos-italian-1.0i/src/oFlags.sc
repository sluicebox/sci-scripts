;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64017)
(include sci.sh)
(use Main)
(use PArray)
(use Flags)

(public
	oFlags 0
)

(class oFlagsClass of Flags
	(properties
		oFlagValues 0
		oScoreFlags 0
	)

	(method (init)
		(= oScoreFlags (Flags new:))
		(oScoreFlags setSize: 314)
		(= oFlagValues (PArray new:))
		(super init: &rest)
	)

	(method (dispose)
		(oScoreFlags dispose:)
		(oFlagValues dispose:)
		(super dispose: &rest)
	)

	(method (unSet param1 &tmp temp0 temp1 temp2)
		(super clear: param1 &rest)
		(for ((= temp0 0)) (< temp0 argc) ((+= temp0 1))
			(= temp1 (oFlagValues at: [param1 temp0]))
			(= temp2 (oScoreFlags test: [param1 temp0]))
			(if (and temp1 temp2)
				(gGame changeScore: (- 0 temp1))
				(oScoreFlags clear: [param1 temp0])
			)
		)
	)

	(method (set param1 &tmp temp0 temp1 temp2 temp3)
		(super set: param1 &rest)
		(for ((= temp0 0)) (< temp0 argc) ((+= temp0 1))
			(if (< [param1 temp0] (oFlagValues size:))
				(= temp2 (oFlagValues at: [param1 temp0]))
				(= temp3 (oScoreFlags test: [param1 temp0]))
				(if (and temp2 (not temp3))
					(gGame changeScore: temp2)
					(oScoreFlags set: [param1 temp0])
				)
			)
		)
	)

	(method (clear param1 &tmp temp0)
		(super clear: param1 &rest)
		(== temp0 0) ; UNINIT
		(while (< temp0 argc) ; UNINIT
			(+= temp0 1) ; UNINIT
		)
	)

	(method (getScore param1)
		(oFlagValues at: param1)
	)
)

(instance oFlags of oFlagsClass
	(properties
		size 314
	)

	(method (init)
		(super init: &rest)
		(oFlagValues
			add:
				0
				5
				1
				5
				2
				1
				3
				1
				4
				5
				5
				14
				6
				8
				7
				14
				8
				4
				9
				11
				10
				7
				11
				9
				12
				1
				13
				1
				14
				6
				15
				1
				16
				1
				17
				2
				18
				2
				19
				2
				20
				1
				21
				1
				22
				2
				23
				1
				24
				8
				25
				6
				26
				1
				27
				10
				28
				25
				29
				10
				30
				5
				31
				12
				32
				5
				33
				3
				34
				20
				35
				5
				36
				4
				37
				4
				38
				12
				39
				13
				40
				11
				41
				5
				42
				2
				43
				5
				44
				2
				45
				25
				46
				3
				47
				1
				48
				3
				49
				2
				50
				11
				51
				11
				52
				11
				53
				11
				54
				11
				55
				3
				56
				15
				57
				3
				58
				13
				59
				2
				60
				11
				61
				1
				62
				10
				63
				2
				64
				1
				65
				15
				66
				10
				67
				15
				68
				4
				69
				9
				70
				3
				71
				3
				72
				11
				73
				1
				74
				1
				75
				1
				76
				1
				77
				1
				78
				1
				79
				13
				80
				11
				81
				6
				82
				1
				83
				1
				84
				8
				85
				14
				86
				4
				87
				11
				88
				6
				89
				25
				90
				1
				91
				2
				92
				12
				93
				4
				94
				4
				95
				9
				96
				3
				97
				4
				98
				6
				99
				6
				100
				7
				101
				2
				102
				1
				103
				25
				104
				8
				105
				2
				106
				7
				107
				17
				108
				1
				109
				1
				110
				1
				111
				4
				112
				2
				113
				25
				114
				1
				115
				25
				116
				2
				117
				1
				118
				2
				119
				3
				120
				5
				121
				6
				122
				2
				123
				1
				124
				20
				125
				6
				126
				3
				127
				25
				128
				11
				129
				2
				130
				4
				131
				23
				132
				13
				133
				2
				134
				6
				135
				2
				136
				1
				137
				1
				138
				1
				139
				1
				140
				9
				141
				7
				142
				2
				143
				2
				144
				2
				145
				1
				146
				1
				147
				2
				148
				1
				149
				1
				150
				15
				151
				9
				152
				10
				153
				2
				154
				3
				155
				7
				156
				2
				157
				2
		)
	)
)

