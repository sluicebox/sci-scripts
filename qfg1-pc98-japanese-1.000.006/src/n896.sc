;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 896)
(include sci.sh)
(use Main)
(use LoadMany)
(use Menu)
(use System)

(public
	proc896_0 0
)

(procedure (proc896_0 param1 &tmp temp0 temp1 temp2)
	(gGame setCursor: gWaitCursor 1)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(if (OneOf param1 2 9 200 202 203 299 600 601)
		(MenuBar hide: state: 0)
	else
		(MenuBar draw:)
	)
	(for ((= temp0 1)) (<= temp0 41) ((++ temp0))
		(= [gInvDropped temp0] 0)
	)
	(clr)
	(LoadMany
		0
		975
		988
		802
		991
		968
		969
		972
		971
		970
		978
		981
		800
		967
		803
		976
		810
		298
		812
		205
		211
		212
		213
		214
		215
		210
		436
		445
		430
		460
		435
		440
		450
		465
		5
		806
		238
		217
		103
		102
		7
		8
		813
		801
		811
		221
		222
		223
		224
		216
		220
		218
		220
		216
		805
		146
		147
		148
		149
		150
		151
		152
		153
		154
		155
		239
		240
		241
		242
		104
		105
		106
		100
		101
		110
		111
		112
		113
		114
		115
		116
		117
		31
		131
		132
		133
		134
		135
		341
		340
		6
		944
		295
	)
	(gMouseHandler release:)
	(gKeyHandler release:)
	(gDirHandler release:)
	(FixTime)
	(if (== param1 600)
		(ClearFlag 328)
		(FixTime 12 0)
		(= gNight 0)
		(= global61 0)
	)
	(if (and (not global332) (!= global273 73))
		(= global272 0)
	)
)

