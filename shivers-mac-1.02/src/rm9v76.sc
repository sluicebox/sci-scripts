;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9760)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm9v76 0
)

(local
	local0
	local1
	local2
)

(instance rm9v76 of ShiversRoom
	(properties
		picture 9760
		invView 1
	)

	(method (init)
		(= local0 -1)
		(= local1 0)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(spTopLeft init:)
		(spTopRight init:)
		(spCenter init:)
		(spBottomLeft init:)
		(spBottomRight init:)
		(spSkull init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if (== 1 local1)
			(gSounds stop: 10914)
			(if (> (spSkull cel:) 0)
				(gSounds play: 10923 0 32 0)
			)
			(gSounds play: 10915 0 32 0)
			(= local1 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9750
	)
)

(instance spSkull of ShiversProp
	(properties
		priority 21
		fixPriority 1
		view 9760
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (doVerb)
		(if (and (== (spSkull cel:) 0) (== local0 4))
			(gCurRoom setScript: sSkullOpen)
		)
		(if (> (spSkull cel:) 0)
			(gCurRoom setScript: sSkullClose)
		)
	)
)

(instance vSkullBack of View
	(properties
		x 102
		y 83
		priority 19
		fixPriority 1
		view 9760
		loop 6
	)
)

(instance psInMask of PotSpot
	(properties
		nsLeft 115
		nsTop 57
		nsRight 134
		nsBottom 77
	)
)

(instance spTopLeft of ShiversProp
	(properties
		view 9760
	)

	(method (init)
		(self
			setPri: 15
			createPoly: 40 35 27 23 26 10 30 2 46 1 58 2 67 16 61 31 45 37
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (< local0 0)
			(self loop: 0)
			(= local0 0)
			(= local1 1)
			(gCurRoom setScript: sMaskOpen)
		else
			(= local1 0)
			(gCurRoom setScript: sMaskClose)
		)
	)
)

(instance spTopRight of ShiversProp
	(properties
		view 9760
		loop 1
	)

	(method (init)
		(self
			setPri: 15
			createPoly:
				197
				34
				187
				25
				186
				12
				186
				5
				193
				2
				216
				3
				226
				9
				225
				21
				216
				37
				205
				37
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (< local0 0)
			(self loop: 1)
			(= local1 1)
			(= local0 1)
			(gCurRoom setScript: sMaskOpen)
		else
			(= local1 0)
			(gCurRoom setScript: sMaskClose)
		)
	)
)

(instance spCenter of ShiversProp
	(properties
		view 9760
		loop 4
	)

	(method (init)
		(self
			setPri: 18
			createPoly:
				118
				91
				102
				70
				100
				55
				107
				47
				125
				45
				143
				50
				146
				65
				140
				76
				138
				80
				124
				92
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (< local0 0)
			(self loop: 4)
			(= local1 1)
			(= local0 4)
			(gCurRoom setScript: sMaskOpen)
		else
			(= local1 0)
			(gCurRoom setScript: sMaskClose)
		)
	)
)

(instance spBottomLeft of ShiversProp
	(properties
		view 9760
		loop 2
	)

	(method (init)
		(self
			setPri: 20
			createPoly:
				46
				139
				28
				115
				28
				102
				34
				97
				46
				95
				55
				95
				64
				101
				66
				110
				65
				119
				50
				139
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (< local0 0)
			(self loop: 2)
			(= local1 1)
			(= local0 2)
			(gCurRoom setScript: sMaskOpen)
		else
			(= local1 0)
			(gCurRoom setScript: sMaskClose)
		)
	)
)

(instance spBottomRight of ShiversProp
	(properties
		view 9760
		loop 3
	)

	(method (init)
		(self
			setPri: 20
			createPoly:
				194
				142
				185
				122
				188
				99
				206
				95
				220
				98
				225
				104
				226
				116
				206
				130
				201
				132
				198
				142
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (< local0 0)
			(self loop: 3)
			(= local1 1)
			(= local0 3)
			(gCurRoom setScript: sMaskOpen)
		else
			(= local1 0)
			(gCurRoom setScript: sMaskClose)
		)
	)
)

(instance sMaskOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 10915)
				(cond
					((== local0 0)
						(spTopLeft init: setCycle: End self)
					)
					((== local0 1)
						(spTopRight init: setCycle: End self)
					)
					((== local0 2)
						(spBottomLeft init: setCycle: End self)
					)
					((== local0 3)
						(spBottomRight init: setCycle: End self)
					)
					((== local0 4)
						(spCenter
							init:
							createPoly:
								106
								49
								93
								58
								92
								70
								97
								83
								65
								77
								59
								79
								57
								88
								55
								67
								58
								60
								67
								53
								74
								51
								83
								51
								88
								50
								93
								47
								106
								49
								134
								50
								142
								47
								152
								47
								163
								52
								165
								55
								166
								56
								180
								58
								185
								62
								185
								90
								180
								79
								174
								77
								157
								81
								139
								81
								150
								73
								151
								64
								148
								55
								137
								50
							setCycle: End self
						)
						(spSkull
							show:
							createPoly:
								107
								52
								104
								61
								103
								70
								106
								78
								112
								81
								137
								81
								142
								72
								142
								65
								140
								59
								137
								53
								108
								53
							priority: 21
						)
					)
				)
				(gSounds play: 10914 0 32 0)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMaskClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 0)
				(if (> (spSkull cel:) 0)
					(= local2 1)
					(gSounds play: 10923 0 32 0)
					(spSkull show:)
					(spSkull setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== local2 1)
					(psInMask dispose:)
					(if (!= global106 0)
						(gShiversRoomItem dispose:)
					)
					(vSkullBack hide:)
				)
				(spSkull hide:)
				(gSounds stop: 10914)
				(gSounds play: 10915 0 32 0)
				(cond
					((== local0 0)
						(spTopLeft init: setCycle: Beg self)
					)
					((== local0 1)
						(spTopRight init: setCycle: Beg self)
					)
					((== local0 2)
						(spBottomLeft init: setCycle: Beg self)
					)
					((== local0 3)
						(spBottomRight init: setCycle: Beg self)
					)
					((== local0 4)
						(spCenter init: setCycle: Beg self)
					)
				)
			)
			(2
				(= local0 -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSkullOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_16 148)
				(vSkullBack init: show:)
				(gCurRoom initRoom: 115 134 57 77)
				(psInMask init:)
				(gSounds stop: 10923)
				(gSounds play: 10922 0 32 0)
				(spSkull setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSkullClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 10922)
				(gSounds play: 10923 0 32 0)
				(spSkull setCycle: Beg self)
			)
			(1
				(psInMask dispose:)
				(if (!= global106 0)
					(gShiversRoomItem dispose:)
				)
				(vSkullBack hide:)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

