;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use rCliffs)
(use n913)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm320 0
	dieHard 1
)

(local
	local0
	[local1 28] = [54 54 54 54 54 54 54 54 54 68 68 68 68 68 68 82 82 82 82 82 96 96 96 96 96 96 96 96]
	[local29 28] = [100 114 126 143 155 164 176 188 202 117 131 143 161 173 187 126 140 155 167 179 109 121 136 150 162 175 187 199]
	[local57 28] = [68 68 68 68 68 68 68 68 68 82 82 82 82 82 82 96 96 96 96 96 110 110 110 110 110 110 110 110]
	[local85 28] = [114 126 138 155 164 176 188 202 215 131 143 157 173 187 199 140 155 167 179 191 121 136 150 162 175 187 199 212]
	[local113 28] = [103 117 129 146 158 167 179 191 205 120 134 146 164 176 190 129 143 158 170 182 112 124 139 153 165 178 190 202]
	[local141 28] = [61 61 61 61 61 61 61 61 61 75 75 75 75 75 75 89 89 89 89 89 103 103 103 103 103 103 103 103]
	[local169 28] = [1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 3 3 3 3 3 4 4 4 4 4 4 4 4]
	[local197 28] = [0 1 2 3 4 5 6 7 8 0 1 2 3 4 5 0 1 2 3 4 0 1 2 3 4 5 6 7]
	[local225 28] = [1 0 0 2 0 0 0 0 0 3 0 0 0 0 4 5 0 0 0 0 0 0 0 0 6 0 0 0]
	[local253 32] = [39 39 56 56 56 56 56 56 56 56 73 73 73 73 73 73 73 73 73 90 90 90 90 90 90 107 107 107 107 107 107 107]
	[local285 32] = [54 54 71 71 71 71 71 71 71 71 88 88 88 88 88 88 88 88 88 105 105 105 105 105 98 122 122 122 122 122 122 122]
	[local317 32] = [139 152 102 114 124 137 150 167 182 192 85 98 111 126 140 157 181 194 211 113 130 145 158 171 184 108 121 131 144 158 172 189]
	[local349 32] = [151 168 113 123 136 149 166 181 191 206 97 110 125 139 156 180 193 210 222 129 144 157 170 183 195 120 130 143 157 171 188 200]
	[local381 32] = [1 1 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 5 5 5 5 5 5 5]
	[local413 32] = [0 1 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 8 0 1 2 3 4 5 0 1 2 3 4 5 6]
	[local445 32] = [4 0 0 0 0 4 0 0 0 2 0 0 2 5 0 0 0 0 0 0 2 0 0 4 0 1 0 4 3 5 0 0]
	[local477 31] = [55 55 55 55 55 55 55 55 55 55 70 70 70 70 70 70 70 70 85 85 85 85 85 85 85 85 100 100 100 100 100]
	[local508 31] = [55 55 55 55 55 55 55 55 55 55 70 70 70 70 70 70 70 70 85 85 85 85 85 85 85 85 100 100 100 100 100]
	[local539 31] = [68 68 68 68 68 68 68 68 68 68 83 83 83 83 83 83 83 83 98 98 98 98 98 98 98 98 113 113 113 113 113]
	[local570 31] = [106 113 129 139 146 156 166 178 190 197 111 122 129 142 154 167 181 193 116 126 140 152 166 177 184 194 128 139 153 166 179]
	[local601 31] = [106 113 129 139 146 156 166 178 190 197 111 122 129 142 154 167 181 193 116 126 140 152 166 177 184 194 128 139 153 166 179]
	[local632 31] = [112 124 138 145 155 165 177 189 196 210 121 128 141 153 166 180 192 206 125 135 151 165 176 183 193 200 138 152 165 178 188]
	[local663 31] = [1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 4 4 4 4 4]
	[local694 31] = [0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 0 1 2 3 4]
	[local725 31] = [4 0 1 4 3 6 0 0 4 0 0 4 2 0 0 0 0 0 3 6 0 0 0 4 3 4 5 0 0 0 6]
	[local756 26] = [54 67 67 67 67 62 80 80 80 80 94 94 94 94 94 94 94 108 108 109 109 109 122 119 135 144]
	[local782 26] = [65 78 78 78 78 73 91 91 91 91 105 105 105 105 105 105 105 119 119 120 120 120 133 130 146 155]
	[local808 26] = [168 117 133 150 168 188 101 117 133 150 109 126 143 160 177 194 211 109 126 143 161 227 161 191 161 180]
	[local834 26] = [181 130 146 163 181 201 114 130 146 163 122 139 156 173 190 207 224 122 139 156 174 240 174 204 174 193]
	[local860 26] = [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2]
	[local886 26] = [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0 1 2 3 4 5 6 7 8 9]
	[local912 26] = [0 0 0 0 0 0 0 0 0 -1 0 0 0 0 -1 -1 0 0 0 0 0 0 0 0 -1 0]
	[local938 26] = [0 0 0 0 0 0 0 0 1 2 0 0 0 0 0 0 0 0 0 3 0 4 0 0 0 0]
	[local964 26] = [0 0 0 0 1 3 0 0 0 2 0 0 0 0 0 0 0 0 0 4 0 5 0 0 0 0]
	[local990 26] = [0 0 0 0 1 3 0 0 0 2 0 0 6 0 0 0 0 0 0 4 0 5 0 0 0 0]
	[local1016 4] = [76 77 76 76]
	[local1020 4] = [160 97 190 129]
	[local1024 4] = [97 97 97 97]
	[local1028 4] = [187 124 217 156]
	[local1032 4] = [1 1 1 1]
	[local1036 4] = [2 0 3 1]
	[local1040 4] = [169 106 199 138]
	[local1044 4] = [76 76 76 76]
	[local1048 4] = [0 2 1 3]
	[local1052 4] = [1 0 0 0]
	[local1056 36]
)

(procedure (localproc_0)
	(return
		(switch (gGame printLang:)
			(34 @local964)
			(39 @local990)
			(else @local938)
		)
	)
)

(procedure (localproc_1)
	(return
		(switch (gGame printLang:)
			(34 @local253)
			(39 @local508)
			(else @local1)
		)
	)
)

(procedure (localproc_2)
	(return
		(switch (gGame printLang:)
			(34 @local317)
			(39 @local601)
			(else @local29)
		)
	)
)

(procedure (localproc_3)
	(return
		(switch (gGame printLang:)
			(34 @local349)
			(39 @local632)
			(else @local85)
		)
	)
)

(procedure (localproc_4)
	(return
		(switch (gGame printLang:)
			(34 @local285)
			(39 @local539)
			(else @local57)
		)
	)
)

(procedure (localproc_5)
	(return
		(switch (gGame printLang:)
			(34 @local381)
			(39 @local663)
			(else @local169)
		)
	)
)

(procedure (localproc_6)
	(return
		(switch (gGame printLang:)
			(34 @local413)
			(39 @local694)
			(else @local197)
		)
	)
)

(procedure (localproc_7)
	(return
		(switch (gGame printLang:)
			(34 @local317)
			(39 @local570)
			(else @local113)
		)
	)
)

(procedure (localproc_8)
	(return
		(switch (gGame printLang:)
			(34 @local253)
			(39 @local477)
			(else @local141)
		)
	)
)

(procedure (localproc_9)
	(return
		(switch (gGame printLang:)
			(34 @local445)
			(39 @local725)
			(else @local225)
		)
	)
)

(instance rm320 of CliffRoom
	(properties
		picture 320
		horizon 0
		walkOffEdge 1
	)

	(method (init)
		(gGame handsOff:)
		(if (== gPrevRoomNum 300)
			(self style: 14)
		else
			(self style: -32758)
			(if (!= (gGlobalSound number:) 915)
				(gGlobalSound number: 915 setLoop: -1 play:)
			)
		)
		(LoadMany rsVIEW 322 325)
		(super init: &rest)
		(rCliffs stepDirection: 3)
		(if (IsFlag 123)
			(gCurRoom allRocksOut: 0)
		else
			(gCurRoom constantRocks:)
		)
		(writ x: 230 init: stopUpd:)
		(theRoom init:)
		(gEgo
			view: 301
			normal: 0
			cycleSpeed: 14
			setLoop: 2
			posn: 101 182
			setPri: 10
			init:
			actions: egoStepVerb
		)
		((ScriptID 21 0) notify:) ; rCliffs
		(gDirectionHandler add: self)
		(gGame handsOn:)
	)

	(method (notify)
		(gCurRoom setScript: insetDispose)
	)

	(method (cue param1)
		(switch param1
			(1
				(gEgo signal: 8192)
				(rCliffs cheatCount: 1)
				(gCurRoom setScript: nextCliffUp)
			)
			(0
				(rCliffs cheatCount: 15)
				(gCurRoom setScript: nextCliffDown)
			)
			(-1
				(gCurRoom setScript: downToBeach)
			)
		)
	)
)

(class PuzzleBackup of View
	(properties
		lookMsg 0
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(or
					(and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
					(== (event type:) evMOUSEBUTTON)
				)
				(!= (event type:) evVERB)
				(not (event modifiers:))
			)
			(cond
				(
					(and
						(or
							(& (event type:) evMOUSEBUTTON)
							(and
								(& (event type:) evKEYBOARD)
								(== (event message:) KEY_RETURN)
							)
						)
						(self onMe: event)
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					)
					(event claimed: 1)
					(cond
						((gCast contains: puzzle3)
							(gMessager say: 2 1 0 1 0 21) ; "Reading about the Ancient Ones in the "Guidebook to the Land of the Green Isles" may help a puzzled journeyer."
						)
						((gCast contains: puzzle1)
							(gMessager say: 1 1 0 1 0 21) ; "Reading about the Ancient Ones in the "Guidebook to the Land of the Green Isles" may help a puzzled journeyer."
						)
						(else
							(gMessager say: lookMsg 1 0 1 0 21)
						)
					)
				)
				(
					(and
						(or
							(& (event type:) evMOUSEBUTTON)
							(and
								(& (event type:) evKEYBOARD)
								(== (event message:) KEY_RETURN)
							)
						)
						(self onMe: event)
						(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					)
					(event claimed: 1)
					0
				)
				(else
					(super handleEvent: event)
				)
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)
)

(instance puzzle1 of PuzzleInset
	(properties
		x 157
		y 39
		z -45
		view 322
		maxButtons 4
		buttNumber 26
		buttView 322
		lookMsg 1
		puzzNumber 2
	)

	(method (init)
		(self
			maxButtons: (proc913_5 4 5 4 6 4)
			buttTop: @local756
			buttLeft: @local808
			buttRight: @local834
			buttBottom: @local782
			buttLoop: @local860
			buttCel: @local886
			buttX: @local808
			buttY: @local756
			buttVal: (localproc_0)
			buttKill: @local1056
		)
		(super init:)
		(headStone init:)
		(headStoneWords loop: 1 init:)
	)

	(method (dispose)
		(headStone dispose:)
		(headStoneWords dispose:)
		(super dispose:)
		(gEgo view: 301 setLoop: 6 cel: 0)
		(UnLoad 128 3012)
	)
)

(instance puzzle2 of PuzzleInset
	(properties
		x 163
		y 59
		z -28
		view 320
		maxButtons 3
		buttNumber 4
		buttView 323
		lookMsg 3
		puzzNumber 3
	)

	(method (init)
		(self
			buttTop: @local1016
			buttLeft: @local1020
			buttRight: @local1028
			buttBottom: @local1024
			buttLoop: @local1032
			buttCel: @local1036
			buttX: @local1040
			buttY: @local1044
			buttVal: @local1048
			buttKill: @local1052
		)
		(super init:)
		(rollos init: stopUpd:)
	)

	(method (dispose)
		(rollos dispose:)
		(super dispose:)
		(gEgo view: 301 setLoop: 1)
		(UnLoad 128 3012)
	)
)

(instance puzzle3 of PuzzleInset
	(properties
		x 157
		y 39
		z -45
		view 322
		maxButtons 4
		buttNumber 26
		buttView 322
		lookMsg 2
		puzzNumber 4
	)

	(method (init)
		(self
			buttTop: @local756
			buttLeft: @local808
			buttRight: @local834
			buttBottom: @local782
			buttLoop: @local860
			buttCel: @local886
			buttX: @local808
			buttY: @local756
			buttVal: @local912
			buttKill: @local1056
		)
		(super init:)
		(headStone init:)
		(headStoneWords loop: 2 init:)
	)

	(method (dispose)
		(headStone dispose:)
		(headStoneWords dispose:)
		(super dispose:)
		(gEgo view: 301 setLoop: 6 cel: 0)
		(UnLoad 128 3012)
	)
)

(instance puzzle4 of PuzzleInset
	(properties
		x 157
		y 39
		z -45
		view 320
		maxButtons 6
		buttNumber 28
		buttView 324
		lookMsg 5
		puzzNumber 5
	)

	(method (init)
		(self
			buttNumber: (proc913_5 28 32 28 31 28)
			maxButtons: (proc913_5 6 5 6 6 6)
			buttTop: (localproc_1)
			buttLeft: (localproc_2)
			buttRight: (localproc_3)
			buttBottom: (localproc_4)
			buttLoop: (localproc_5)
			buttCel: (localproc_6)
			buttX: (localproc_7)
			buttY: (localproc_8)
			buttVal: (localproc_9)
			buttKill: @local1056
		)
		(super init:)
		(words init: stopUpd:)
	)

	(method (dispose)
		(words dispose:)
		(super dispose:)
		(gEgo view: 301 setLoop: 1)
		(UnLoad 128 3012)
	)
)

(instance words of View
	(properties
		x 211
		y 62
		z -45
		view 324
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(puzzle4 doVerb: theVerb &rest)
	)
)

(instance rollos of View
	(properties
		x 98
		y 66
		z -12
		view 323
		priority 13
		signal 16400
	)
)

(instance headStone of PuzzleBackup
	(properties
		x 150
		y 7
		view 325
		priority 3
		signal 16400
	)

	(method (doVerb theVerb)
		(if (gCast contains: puzzle1)
			(puzzle1 doVerb: theVerb &rest)
		else
			(puzzle3 doVerb: theVerb &rest)
		)
	)
)

(instance headStoneWords of PuzzleBackup
	(properties
		x 148
		y 17
		view 325
		priority 4
		signal 16400
	)

	(method (doVerb theVerb)
		(if (gCast contains: puzzle1)
			(puzzle1 doVerb: theVerb &rest)
		else
			(puzzle3 doVerb: theVerb &rest)
		)
	)
)

(instance theRoom of Feature
	(properties
		noun 3
		nsBottom 190
		nsRight 320
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(SetFlag 59)
				(gCurRoom setScript: dieHard)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance writ of View
	(properties
		y 189
		z 135
		noun 4
		view 326
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(gDirectionHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not ((ScriptID 21 0) puzzleIsUp:)) ; rCliffs
				(or
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(or
					(and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
					(== (event type:) evMOUSEBUTTON)
				)
				(User canInput:)
				(!= (event type:) evVERB)
				(self onMe: event)
				(not (event modifiers:))
			)
			(event claimed: 1)
			(if (or (< (gEgo y:) 110) (> (gEgo y:) 120))
				(gMessager say: 4 1 13 1) ; "There is something etched into the face of the cliff, but Alexander can't see it from where he is."
			else
				(if (== (gEgo loop:) 6)
					(gEgo view: 3012 setLoop: 0 cel: 1)
				else
					(gEgo view: 3012 setLoop: 0 cel: 0)
				)
				(UnLoad 128 301)
				(switch ((ScriptID 21 0) cliffFace:) ; rCliffs
					(0
						(if (IsFlag 123)
							(puzzle1 puzzSolved:)
						else
							(gCurRoom setScript: insetInit 0 puzzle1)
						)
					)
					(1
						(if (IsFlag 124)
							(puzzle2 puzzSolved:)
						else
							(gCurRoom setScript: insetInit 0 puzzle2)
						)
					)
					(2
						(if (IsFlag 125)
							(puzzle3 puzzSolved:)
						else
							(gCurRoom setScript: insetInit 0 puzzle3)
						)
					)
					(3
						(if (IsFlag 126)
							(puzzle4 puzzSolved:)
						else
							(gCurRoom setScript: insetInit 0 puzzle4)
						)
					)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance insetDispose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 6)
			)
			(1
				(if (mod ((ScriptID 21 0) cliffFace:) 2) ; rCliffs
					(gCurRoom flipRocks: 1 callForRocks:)
				else
					(gCurRoom flipRocks: 0 callForRocks:)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nextCliffUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== ((ScriptID 21 0) cliffFace:) 3) ; rCliffs
					(gGlobalSound fade: 0 10 10)
					(gGlobalSound4 stop:)
					(gCurRoom newRoom: 340)
				else
					(gCurRoom dumpRocks:)
					(self cue:)
				)
			)
			(1
				(rCliffs cliffFace: (+ (rCliffs cliffFace:) 1))
				(if (> (rCliffs cliffFace:) 3)
					(rCliffs cliffFace: 3)
				)
				(switch ((ScriptID 21 0) cliffFace:) ; rCliffs
					(1
						(UnLoad 128 322)
						(UnLoad 128 325)
						(if (IsFlag 124)
							(gCurRoom allRocksOut: 1)
						else
							(gCurRoom constantRocks: 1)
						)
						(LoadMany rsVIEW 320 323)
					)
					(2
						(UnLoad 128 320)
						(UnLoad 128 323)
						(if (IsFlag 125)
							(gCurRoom allRocksOut: 0)
						else
							(gCurRoom constantRocks:)
						)
						(LoadMany rsVIEW 322 325)
					)
					(3
						(UnLoad 128 322)
						(UnLoad 128 325)
						(if (IsFlag 126)
							(gCurRoom allRocksOut: 1)
						else
							(gCurRoom constantRocks: 1)
						)
						(LoadMany rsVIEW 320 324)
					)
				)
				(gCurRoom drawPic: 320 14)
				(if (mod ((ScriptID 21 0) cliffFace:) 2) ; rCliffs
					(writ
						loop: (if (== ((ScriptID 21 0) cliffFace:) 1) 1 else 0) ; rCliffs
						x: 90
						stopUpd:
					)
					(gEgo posn: 238 182 setLoop: 6 cel: 0 setPri: 10 show:)
				else
					(writ loop: 0 x: 230 stopUpd:)
					(gEgo posn: 101 182 setLoop: 2 cel: 0 setPri: 10 show:)
				)
				(gGame handsOn:)
				((ScriptID 21 0) notify:) ; rCliffs
				(self dispose:)
			)
		)
	)
)

(instance downToBeach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc21_1)
				(gEgo
					view: 301
					setLoop: 7
					cel: 0
					posn: (+ (gEgo x:) 2) (+ (gEgo y:) 2)
					cycleSpeed: 16
				)
				(= cycles 8)
			)
			(1
				(gEgo cel: 1 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(2
				(gEgo cel: 2 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(3
				(gEgo cel: 3 posn: (gEgo x:) (- (gEgo y:) 1))
				(= cycles 8)
			)
			(4
				(gEgo cel: 4 posn: (- (gEgo x:) 4) (- (gEgo y:) 4))
				(= cycles 8)
			)
			(5
				(gEgo cel: 5 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(6
				(gEgo cel: 6 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(7
				(gEgo
					setLoop: 5
					cel: 0
					cycleSpeed: 12
					posn: (- (gEgo x:) 7) (+ (gEgo y:) 19)
					setCycle: End self
				)
				(rCliffs stepDirection: 1)
			)
			(8
				(gCurRoom dumpRocks:)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance nextCliffDown of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 21 0) cue:) ; rCliffs
				(if (== (rCliffs stepDirection:) 2)
					(= temp0 5)
					(= temp1 18)
					(= temp2 6)
					(rCliffs stepDirection: 1)
				else
					(= temp0 4)
					(= temp1 -19)
					(= temp2 7)
					(rCliffs stepDirection: 2)
				)
				(gEgo
					setLoop: temp0
					cel: 0
					cycleSpeed: 12
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
					setCycle: End self
				)
			)
			(1
				(proc21_1)
				(if (== (rCliffs stepDirection:) 2)
					(= temp0 7)
					(= temp1 -14)
					(= temp2 -6)
				else
					(= temp0 8)
					(= temp1 14)
					(= temp2 -5)
				)
				(gEgo
					view: 301
					setLoop: temp0
					cel: 0
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
					cycleSpeed: 16
				)
				(= cycles 8)
			)
			(2
				(gEgo cel: 1 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(3
				(gEgo cel: 2 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(4
				(if (== (rCliffs stepDirection:) 2)
					(= temp2 0)
				else
					(= temp2 -3)
				)
				(gEgo cel: 3 posn: (gEgo x:) (+ (gEgo y:) temp2))
				(= cycles 8)
			)
			(5
				(if (== (rCliffs stepDirection:) 2)
					(= temp1 -4)
					(= temp2 0)
				else
					(= temp1 4)
					(= temp2 -1)
				)
				(gEgo
					cel: 4
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
				)
				(= cycles 8)
			)
			(6
				(gEgo cel: 5 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(7
				(if (== (rCliffs stepDirection:) 2)
					(= temp2 -2)
				else
					(= temp2 0)
				)
				(gEgo cel: 6 posn: (gEgo x:) (+ (gEgo y:) temp2))
				(= cycles 8)
			)
			(8
				(if (== (rCliffs stepDirection:) 2)
					(= temp0 6)
					(= temp1 -25)
					(= temp2 11)
				else
					(= temp0 1)
					(= temp1 27)
					(= temp2 12)
				)
				(gEgo
					view: 301
					setLoop: temp0
					cel: 0
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
				)
				(= cycles 8)
			)
			(9
				((ScriptID 21 0) cliffFace: (- ((ScriptID 21 0) cliffFace:) 1)) ; rCliffs, rCliffs
				(gCurRoom dumpRocks:)
				(gCurRoom drawPic: 320 13)
				(switch ((ScriptID 21 0) cliffFace:) ; rCliffs
					(0
						(UnLoad 128 320)
						(UnLoad 128 323)
						(LoadMany rsVIEW 322 325)
						(gCurRoom allRocksOut: 0)
						(writ loop: 0 x: 230 stopUpd:)
						(gEgo view: 301 setLoop: 6 cel: 0 posn: 210 4)
					)
					(1
						(UnLoad 128 322)
						(UnLoad 128 325)
						(LoadMany rsVIEW 320 323)
						(gCurRoom allRocksOut: 1)
						(writ
							loop:
								(if (== ((ScriptID 21 0) cliffFace:) 1) ; rCliffs
									1
								else
									0
								)
							x: 90
							stopUpd:
						)
						(gEgo view: 301 setLoop: 1 cel: 0 posn: 127 4)
					)
					(2
						(UnLoad 128 320)
						(UnLoad 128 324)
						(LoadMany rsVIEW 322 325)
						(gCurRoom allRocksOut: 0)
						(writ loop: 0 x: 230 stopUpd:)
						(gEgo view: 301 setLoop: 6 cel: 0 posn: 210 4)
					)
				)
				(= cycles 8)
			)
			(10
				(proc21_1)
				(if (== (rCliffs stepDirection:) 2)
					(= temp0 7)
					(= temp1 1)
					(= temp2 1)
				else
					(= temp0 8)
					(= temp1 1)
					(= temp2 0)
				)
				(gEgo
					view: 301
					setLoop: temp0
					cel: 0
					cycleSpeed: 16
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
				)
				(= cycles 8)
			)
			(11
				(gEgo cel: 1 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(12
				(gEgo cel: 2 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(13
				(if (== (rCliffs stepDirection:) 2)
					(= temp1 1)
					(= temp2 -2)
				else
					(= temp1 0)
					(= temp2 0)
				)
				(gEgo
					cel: 3
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
				)
				(= cycles 8)
			)
			(14
				(if (== (rCliffs stepDirection:) 2)
					(= temp1 -4)
				else
					(= temp1 1)
				)
				(gEgo cel: 4 posn: (+ (gEgo x:) temp1) (gEgo y:))
				(= cycles 8)
			)
			(15
				(if (== (rCliffs stepDirection:) 2)
					(= temp1 0)
				else
					(= temp1 -1)
				)
				(gEgo cel: 5 posn: (+ (gEgo x:) temp1) (gEgo y:))
				(= cycles 8)
			)
			(16
				(if (== (rCliffs stepDirection:) 2)
					(= temp1 0)
				else
					(= temp1 -1)
				)
				(gEgo cel: 6 posn: (+ (gEgo x:) temp1) (gEgo y:))
				(= cycles 8)
			)
			(17
				(if (== (rCliffs stepDirection:) 2)
					(= temp0 6)
					(= temp1 -27)
					(= temp2 13)
				else
					(= temp0 1)
					(= temp1 29)
					(= temp2 12)
				)
				(gEgo
					view: 301
					setLoop: temp0
					cel: 0
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
				)
				(if (== local0 3)
					(self cue:)
				else
					(= seconds 2)
				)
			)
			(18
				(if (< local0 3)
					(++ local0)
					(-= state 9)
				else
					(= local0 0)
				)
				(self cue:)
			)
			(19
				(if (== (rCliffs stepDirection:) 2)
					(= temp0 5)
					(= temp1 18)
					(= temp2 7)
					(rCliffs stepDirection: 3)
				else
					(= temp0 4)
					(= temp1 -19)
					(= temp2 7)
					(rCliffs stepDirection: 4)
				)
				(gEgo
					setLoop: temp0
					cel: 0
					cycleSpeed: 12
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
					setCycle: End self
				)
			)
			(20
				(if (== (gEgo loop:) 4)
					(= temp0 6)
					(= temp1 -15)
					(= temp2 -7)
				else
					(= temp0 1)
					(= temp1 17)
					(= temp2 -7)
				)
				(gEgo
					setLoop: temp0
					cel: 0
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
				)
				(= ticks 4)
			)
			(21
				(gGame handsOn:)
				((ScriptID 21 0) cheatCount: 10) ; rCliffs
				((ScriptID 21 0) notify:) ; rCliffs
				(self dispose:)
			)
		)
	)
)

(instance insetInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 21 0) cue:) ; rCliffs
				(gMessager say: 4 1 12 1 self) ; "Alexander examines the strange etchings in the face of the cliff."
			)
			(1
				(register init:)
				(self dispose:)
			)
		)
	)
)

(instance dieHard of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				((ScriptID 21 0) cue:) ; rCliffs
				(if (< (gEgo loop:) 6)
					(gEgo
						posn: (- (gEgo x:) 8) (- (gEgo y:) 3)
						view: 900
						setLoop: 0
						cel: 0
					)
				else
					(gEgo
						posn: (+ (gEgo x:) 6) (- (gEgo y:) 3)
						view: 900
						setLoop: 1
						cel: 0
					)
				)
				(= cycles 6)
			)
			(1
				(ClearFlag 59)
				(gEgo
					x:
						(if (== (gEgo loop:) 1)
							(- (gEgo x:) 18)
						else
							(+ (gEgo x:) 18)
						)
					y:
						(if (== (gEgo loop:) 1)
							(+ (gEgo y:) 2)
						else
							(+ (gEgo y:) 2)
						)
					view: 4011
					normal: 0
					cycleSpeed: 6
					setLoop: (if (== (gEgo loop:) 1) 1 else 0)
					setCycle: CT 10 1 self
				)
			)
			(2
				(gGlobalSound3 number: 306 setLoop: 1 play: self)
				(gEgo setCycle: End)
			)
			(3
				(gEgo y: 280)
				(= seconds 2)
			)
			(4
				(gGlobalSound3 number: 307 setLoop: 1 play:)
				(ShakeScreen 2 ssLEFTRIGHT)
				(= ticks 4)
			)
			(5
				(gMessager say: 9 3 38 3 self) ; "!!!Do not print this. Comment msg only."
			)
			(6
				(gGlobalSound4 fade: 0 5 5)
				(EgoDead 8) ; "That wasn't a very logical step!"
			)
		)
	)
)

(instance egoStepVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(return 0)
			)
			(5 ; Do
				(return 0)
			)
			(2 ; Talk
				(return 0)
			)
			(else
				(gMessager say: 0 0 64 1 0 899) ; "These steps are awfully precarious! Alexander had better concentrate on what he's doing and try that later!"
				(return 1)
			)
		)
	)
)

