;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64021)
(include sci.sh)
(use Main)
(use TPSound)
(use DialogPlane)
(use n64896)
(use Array)
(use System)

(public
	ClickHelp 0
)

(procedure (ClickHelp &tmp oClick oFlags oMsg i nCase nMod nPrevPenalty nCurPenalty nFlag nScore strTitle strText strContinue oHintSound curVolume curSFXVolume)
	(cond
		(
			(and
				(== gnChapter 1)
				(not ((ScriptID 64017 0) test: 14)) ; oFlags
				(oClickThrough1 solvedThrough: 7)
			)
			(= oClick oClickThroughSlugs)
		)
		(
			(and
				(== gnChapter 1)
				(or
					((ScriptID 64017 0) test: 22) ; oFlags
					(and
						(not ((ScriptID 64017 0) test: 23)) ; oFlags
						(== gCurRoomNum 13000) ; roBog
						(oClickThrough1 solvedThrough: 1)
					)
				)
			)
			(= oClick oClickThroughBog)
		)
		(else
			(= oClick
				(switch gnChapter
					(0 0)
					(1 oClickThrough1)
					(2 oClickThrough2)
					(3 oClickThrough3)
					(4 oClickThrough4)
					(5 oClickThrough5)
				)
			)
		)
	)
	(if oClick
		(if (not (oClick bIsInitialized:))
			(oClick init:)
		)
		(= oFlags (oClick oFlagArray:))
		(= oMsg (oClick oMsgArray:))
		(= nMod (oClick nMsgFile:))
	else
		(PrintDebug {Help called for nonexistent level})
		(return)
	)
	(for
		((= i 0))
		(and
			(< i (oFlags size:))
			((ScriptID 64017 0) test: (oFlags at: i)) ; oFlags
		)
		((++ i))
	)
	(if (>= i (oFlags size:))
		(PrintDebug {Help called for level after all flags have been set.})
		(return)
	)
	(= nCase (oMsg at: i))
	(if (and (== gnChapter gnLastHelpLevel) (== nCase gnLastHelpCase))
		(++ gnLastHelpSeq)
	else
		(= gnLastHelpSeq 1)
	)
	(= gnLastHelpLevel gnChapter)
	(= gnLastHelpCase nCase)
	(if (Message msgGET nMod 0 0 nCase gnLastHelpSeq)
		(= oHintSound (TPSound new:))
		(= curVolume gMusicVol)
		(SetMusicVol (MulDiv 35 gMusicVol 100))
		(= curSFXVolume gSFXVol)
		(SetSFXVol (MulDiv 35 gSFXVol 100))
		(oHintSound playMessage: 0 0 nCase gnLastHelpSeq 0 nMod)
		(= strText (MakeMessageText 0 0 nCase gnLastHelpSeq nMod))
		(= strTitle (MakeMessageText 0 0 31 1 0))
		(= strContinue (MakeMessageText 0 0 1 1 0))
		(TextDialog strText strContinue strTitle)
		(oHintSound stop: dispose:)
		(SetMusicVol curVolume)
		(SetSFXVol curSFXVolume)
		(= nFlag (oFlags at: i))
		(= nPrevPenalty ((ScriptID 64017 0) getPenalty: nFlag)) ; oFlags
		(= nScore ((ScriptID 64017 0) getScore: nFlag)) ; oFlags
		(if (Message msgGET nMod 0 0 nCase (+ gnLastHelpSeq 1))
			(= nCurPenalty (Min nScore (+ nPrevPenalty gnLastHelpSeq)))
		else
			(= nCurPenalty nScore)
		)
		(gGame changeScore: (- nPrevPenalty nCurPenalty))
		((ScriptID 64017 0) setPenalty: nFlag nCurPenalty) ; oFlags
	else
		(if (== (-- gnLastHelpSeq) 0)
			(PrintDebug {No help message for case %d in module %d} nCase nMod)
			(return)
		)
		(= oHintSound (TPSound new:))
		(= curVolume gMusicVol)
		(SetMusicVol (MulDiv 35 gMusicVol 100))
		(= curSFXVolume gSFXVol)
		(SetSFXVol (MulDiv 35 gSFXVol 100))
		(oHintSound playMessage: 0 0 nCase gnLastHelpSeq 0 nMod)
		(= strText (MakeMessageText 0 0 nCase gnLastHelpSeq nMod))
		(= strTitle (MakeMessageText 0 0 31 1 0))
		(= strContinue (MakeMessageText 0 0 1 1 0))
		(TextDialog strText strContinue strTitle)
		(oHintSound stop: dispose:)
		(SetMusicVol curVolume)
		(SetSFXVol curSFXVolume)
	)
	(oClick dispose:)
)

(class ClickThrough of Obj
	(properties
		bIsInitialized 0
		nMsgFile 0
		oFlagArray 0
		oMsgArray 0
	)

	(method (add list &tmp i index)
		(for ((= i 0)) (< i argc) ((+= i 2))
			(= index (/ i 2))
			(oFlagArray at: index [list i])
			(oMsgArray at: index [list (+ i 1)])
		)
	)

	(method (init)
		(= bIsInitialized 1)
		(= oFlagArray (IntArray new: 0))
		(= oMsgArray (IntArray new: 0))
	)

	(method (solvedThrough flag &tmp i bWasInitialized nIndex)
		(if bIsInitialized
			(= bWasInitialized 1)
		else
			(= bWasInitialized 0)
			(self init:)
		)
		(if (== (= nIndex (oFlagArray indexOf: flag)) -1)
			(PrintDebug
				{Called solvedThrough on a flag not in this instance of clickThrough}
			)
			(return 1)
		)
		(for ((= i 0)) (<= i nIndex) ((++ i))
			(if (not ((ScriptID 64017 0) test: (oFlagArray at: i))) ; oFlags
				(if (not bWasInitialized)
					(self dispose:)
				)
				(return 0)
			)
		)
		(if (not bWasInitialized)
			(self dispose:)
		)
		(return 1)
	)

	(method (setAllFlagsUpTo flag &tmp i nIndex bWasInitialized)
		(if bIsInitialized
			(= bWasInitialized 1)
		else
			(= bWasInitialized 0)
			(self init:)
		)
		(if (== (= nIndex (oFlagArray indexOf: flag)) -1)
			(PrintDebug
				{Called setAllFlagsUpTo on a flag not in this instance of clickThrough}
			)
			(return)
		)
		(for ((= i 0)) (<= i nIndex) ((++ i))
			((ScriptID 64017 0) set: (oFlagArray at: i)) ; oFlags
		)
		(if (not bWasInitialized)
			(self dispose:)
		)
	)

	(method (dispose)
		(= bIsInitialized 0)
		(oFlagArray dispose:)
		(oMsgArray dispose:)
		(super dispose:)
	)
)

(instance oClickThroughBog of ClickThrough
	(properties
		nMsgFile 101
	)

	(method (init)
		(super init:)
		(self add: 20 10 21 11 22 12 23 13)
	)
)

(instance oClickThroughSlugs of ClickThrough
	(properties
		nMsgFile 101
	)

	(method (init)
		(super init:)
		(self add: 15 19 17 20 18 21 14 22)
	)
)

(instance oClickThrough1 of ClickThrough
	(properties
		nMsgFile 101
	)

	(method (init)
		(super init:)
		(self
			add:
				28
				1
				29
				32
				0
				2
				8
				3
				31
				4
				35
				5
				4
				6
				33
				7
				1
				8
				10
				9
				26
				34
				27
				14
				3
				16
				13
				15
				11
				33
				6
				17
				7
				18
				32
				23
				5
				24
				34
				25
				36
				26
				39
				27
				44
				28
				2
				29
				9
				30
				45
				31
		)
	)
)

(instance oClickThrough2 of ClickThrough
	(properties
		nMsgFile 102
	)

	(method (init)
		(super init:)
		(self
			add:
				65
				1
				66
				37
				78
				2
				68
				33
				56
				3
				57
				4
				67
				5
				76
				6
				49
				36
				73
				35
				74
				34
				72
				7
				75
				8
				108
				9
				109
				10
				110
				40
				80
				11
				91
				12
				55
				13
				93
				32
				60
				14
				90
				38
				87
				15
				83
				16
				84
				39
				59
				17
				53
				18
				95
				19
				62
				20
				96
				21
				97
				22
				94
				23
				50
				24
				51
				25
				64
				26
				48
				27
				47
				28
				54
				29
				111
				30
				112
				31
		)
	)
)

(instance oClickThrough3 of ClickThrough
	(properties
		nMsgFile 103
	)

	(method (init)
		(super init:)
		(self
			add:
				114
				13
				115
				1
				116
				2
				117
				3
				118
				4
				119
				5
				113
				6
				120
				7
				121
				8
				122
				9
				123
				10
				124
				11
		)
	)
)

(instance oClickThrough4 of ClickThrough
	(properties
		nMsgFile 104
	)

	(method (init)
		(super init:)
		(self
			add:
				128
				1
				126
				2
				127
				3
				129
				4
				130
				22
				137
				5
				140
				20
				138
				6
				132
				7
				133
				8
				136
				9
				139
				10
				142
				25
				141
				11
				143
				12
				144
				13
				154
				23
				152
				14
				153
				15
				146
				16
				147
				26
				151
				17
				157
				27
				158
				18
				156
				19
				159
				24
		)
	)
)

(instance oClickThrough5 of ClickThrough
	(properties
		nMsgFile 105
	)

	(method (init)
		(super init:)
		(self
			add:
				179
				1
				180
				2
				181
				3
				183
				4
				189
				5
				195
				6
				177
				7
				178
				8
				188
				9
				160
				46
				196
				10
				203
				11
				207
				24
				206
				23
				208
				25
				169
				26
				162
				29
				209
				48
				171
				27
				205
				13
				204
				12
				163
				14
				164
				15
				200
				16
				165
				17
				166
				18
				201
				19
				161
				20
				174
				21
				202
				22
				172
				28
				210
				47
				173
				30
				176
				31
				211
				32
				212
				49
				218
				33
				219
				34
				221
				35
				213
				37
				217
				36
				220
				38
				222
				39
				226
				40
				227
				41
				228
				42
				229
				43
				230
				44
				231
				45
		)
	)
)

