;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use eRS)
(use PseudoMouse)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm820 0
)

(local
	[local0 211] = [1 16 27 -1 -1 -1 -1 0 2 16 27 -1 -1 -1 1 3 -1 -1 -1 -1 -1 2 4 -1 -1 -1 -1 -1 3 5 6 -1 -1 -1 -1 4 -1 -1 -1 -1 -1 -1 4 7 -1 -1 -1 -1 -1 6 8 -1 -1 -1 -1 -1 7 9 -1 -1 -1 -1 -1 8 10 -1 -1 -1 -1 -1 9 11 -1 -1 -1 -1 -1 10 12 -1 -1 -1 -1 -1 11 13 -1 -1 -1 -1 -1 12 14 -1 -1 -1 -1 -1 13 15 28 -1 -1 -1 -1 14 28 -1 -1 -1 -1 -1 0 1 17 18 23 27 -1 16 18 23 -1 -1 -1 -1 16 17 19 20 -1 -1 -1 18 20 24 -1 -1 -1 -1 18 19 21 23 -1 -1 -1 20 22 23 -1 -1 -1 -1 21 -1 -1 -1 -1 -1 -1 20 21 -1 -1 -1 -1 -1 19 25 29 -1 -1 -1 -1 24 26 29 -1 -1 -1 -1 25 -1 -1 -1 -1 -1 -1 0 1 16 -1 -1 -1 -1 14 15 -1 -1 -1 -1 -1 24 25 -1 -1 -1 -1 -1 -1]
	[local211 270] = [263 166 -1 -1 -1 -1 -1 -1 -1 284 157 -1 -1 -1 -1 -1 -1 -1 252 137 -1 -1 -1 -1 -1 -1 -1 273 126 -1 -1 -1 -1 -1 -1 -1 253 99 -1 -1 -1 -1 -1 -1 -1 238 85 -1 -1 -1 -1 -1 -1 -1 277 87 185 34 171 28 -1 -1 -1 157 33 50 73 -1 -1 -1 -1 -1 45 95 85 132 -1 -1 -1 -1 -1 107 161 -1 -1 -1 -1 -1 -1 -1 155 142 139 124 103 106 68 81 -1 80 75 169 37 -1 -1 -1 -1 -1 206 56 196 62 -1 -1 -1 -1 -1 184 53 -1 -1 -1 -1 -1 -1 -1 162 65 -1 -1 -1 -1 -1 -1 -1 150 55 147 52 -1 -1 -1 -1 -1 232 180 -1 -1 -1 -1 -1 -1 -1 198 153 -1 -1 -1 -1 -1 -1 -1 177 129 -1 -1 -1 -1 -1 -1 -1 164 134 -1 -1 -1 -1 -1 -1 -1 188 122 -1 -1 -1 -1 -1 -1 -1 197 131 -1 -1 -1 -1 -1 -1 -1 247 110 -1 -1 -1 -1 -1 -1 -1 184 113 -1 -1 -1 -1 -1 -1 -1 133 106 -1 -1 -1 -1 -1 -1 -1 141 103 -1 -1 -1 -1 -1 -1 -1 127 78 -1 -1 -1 -1 -1 -1 -1 270 172 -1 -1 -1 -1 -1 -1 -1 143 51 -1 -1 -1 -1 -1 -1 -1 191 87 -1 -1 -1 -1 -1 -1 -1]
	local481
	local482
)

(class MazeFeat of Feature
	(properties
		handler 0
		myActor 0
		backTrack 0
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			(
				(or
					(event claimed:)
					(event modifiers:)
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(not (self onMe: event))
					(& (event type:) evMOUSERELEASE)
					(and (& (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(myActor mover:)
				)
				(return)
			)
			((== (handler curFeat:) self)
				(gMessager say: 7 0 1 1) ; "You're already here."
			)
			((not (self legalMove:))
				(gMessager say: 7 0 2 1) ; "You can't get there from here."
			)
			(else
				(gGame handsOff:)
				(= temp1 (handler indexOf: self))
				(= temp2 (handler indexOf: (handler curFeat:)))
				(= temp3 (handler dirFlag:))
				(handler dirFlag: (> temp1 temp2))
				(= temp0 (+ (* temp1 9) (* (not (handler dirFlag:)) 9)))
				(if (not (handler dirFlag:))
					(if temp3
						(handler movePtr: (- (handler movePtr:) 1))
					)
					(if (!= [local211 (- (handler movePtr:) 1)] -1)
						(= backTrack 1)
					else
						(while (== [local211 (-- temp0)] -1)
							0
						)
						(handler movePtr: (++ temp0))
					)
				else
					(handler movePtr: (-- temp0))
				)
				(self nextMove:)
			)
		)
		(event claimed: 1)
	)

	(method (nextMove &tmp temp0 temp1)
		(if (handler dirFlag:)
			(handler movePtr: (+ (handler movePtr:) 1))
			(= temp0 [local211 (handler movePtr:)])
			(handler movePtr: (+ (handler movePtr:) 1))
			(= temp1 [local211 (handler movePtr:)])
		else
			(handler movePtr: (- (handler movePtr:) 1))
			(= temp1 [local211 (handler movePtr:)])
			(handler movePtr: (- (handler movePtr:) 1))
			(= temp0 [local211 (handler movePtr:)])
		)
		(myActor setMotion: MoveTo temp0 temp1 self)
	)

	(method (cue &tmp temp0)
		(cond
			(backTrack
				(if (== [local211 (- (handler movePtr:) 1)] -1)
					(= backTrack 0)
					(= temp0 (handler indexOf: self))
					(handler
						movePtr: (+ (* temp0 9) (* (not (handler dirFlag:)) 9))
					)
					(while 1
						(handler movePtr: (- (handler movePtr:) 1))
						(if (!= [local211 (handler movePtr:)] -1)
							(break)
						)
					)
					(handler movePtr: (+ (handler movePtr:) 1))
				)
				(self nextMove:)
			)
			(
				(or
					(and
						(handler dirFlag:)
						(== [local211 (+ (handler movePtr:) 1)] -1)
					)
					(not (handler dirFlag:))
				)
				(handler curFeat: self)
				(gGame handsOn:)
			)
			(else
				(self nextMove:)
			)
		)
	)

	(method (legalMove &tmp temp0)
		(for
			((= temp0 (* (handler indexOf: self) 7)))
			(!= [local0 temp0] -1)
			((++ temp0))
			
			(if (== (handler at: [local0 temp0]) (handler curFeat:))
				(return 1)
			)
		)
		(return 0)
	)

	(method (dispose)
		(= onMeCheck 0)
		(super dispose:)
	)

	(method (showPoly &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 0)
		(for ((= temp1 1)) (< temp1 (onMeCheck size:)) ((++ temp1))
			(= temp2 (Memory memPEEK (+ (onMeCheck points:) temp0)))
			(= temp4 (Memory memPEEK (+ (onMeCheck points:) (+= temp0 2))))
			(= temp3 (Memory memPEEK (+ (onMeCheck points:) (+= temp0 2))))
			(= temp5 (Memory memPEEK (+ (onMeCheck points:) (+= temp0 2))))
			(Graph grDRAW_LINE temp4 temp2 temp5 temp3 14 1 0)
			(Graph grUPDATE_BOX temp4 temp2 (+ temp5 1) (+ temp3 1) 1)
			(-= temp0 2)
			(if (== temp1 1)
				(= temp6 temp2)
				(= temp7 temp4)
			)
		)
		(Graph grDRAW_LINE temp7 temp6 temp5 temp3 14 1 0)
		(Graph grUPDATE_BOX temp7 temp6 (+ temp5 1) (+ temp3 1) 1)
	)
)

(class MazeHandler of EventHandler
	(properties
		curFeat 0
		movePtr 0
		dirFlag 0
	)
)

(instance rm820 of Eco2Room
	(properties
		noun 6
		picture 820
		style 10
		horizon 0
		north 840
		south 800
	)

	(method (init &tmp temp0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 258 173 275 165 267 160 249 167
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 284 170 305 158 292 149 268 160
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 285 153 249 130 223 137 250 157 262 150 271 158
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 262 137 307 113 296 101 246 126
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 279 109 279 93 266 86 244 98 260 109 260 118
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 263 87 232 72 220 78 248 94
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 295 87 243 62 218 45 180 27 165 24 168 33 212 51 223 62 236 67 249 77 282 93
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 165 24 142 25 49 67 40 82 50 92 59 74 153 32 166 31
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 41 85 27 91 73 144 118 130 81 106 51 93
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 75 145 109 172 155 151 121 130
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 156 150 171 145 141 123 65 71 57 82 90 102 94 113 142 141
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 79 80 96 69 92 64 152 36 162 41 173 35 164 33 152 34 82 65 69 72
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 167 39 199 56 189 61 189 68 218 58 171 37
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 198 56 168 41 159 46 182 63
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 170 55 147 66 158 73 182 64
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 166 56 157 50 137 61 149 65
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 245 169 216 180 232 189 259 177
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 236 172 223 164 237 155 213 142 153 163 165 170 195 161 223 178
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 205 144 180 120 169 126 187 140 191 150
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 165 125 153 132 173 144 183 138
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 220 96 180 119 186 126 233 105
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 188 127 199 138 248 117 238 108 200 126 197 122
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 204 78 233 96 232 101 249 116 258 110 244 99 240 92 210 77
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 182 102 155 112 167 124 195 109
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 162 127 153 114 127 99 119 103 147 120 153 132
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 146 109 180 97 171 88 135 102
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 146 97 136 85 162 77 136 74 129 72 112 62 82 79 110 94 129 87 135 101
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 259 173 267 178 284 171 276 166
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 160 48 154 37 119 53 139 58
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 172 87 185 101 216 91 194 79
					yourself:
				)
		)
		(chamber init: setOnMeCheck: 1 16)
		(crevice init: setOnMeCheck: 1 32)
		(lake init:)
		(lake2 init:)
		(ruin init: setOnMeCheck: 1 -256)
		(door init: setOnMeCheck: 1 8)
		(stairway init: setOnMeCheck: 1 130)
		(stella init: setOnMeCheck: 1 64)
		(foliage init: setOnMeCheck: 1 -32768)
		(mazeEgo
			init:
			illegalBits: 0
			setScale:
			scaleX: 42
			scaleY: 42
			setCycle: Walk
		)
		(waterFall init: setCycle: Fwd)
		(gTheDoits add: ruin stella)
		(super init:)
		(= local482 gPMouse)
		(= gPMouse mazePMouse)
		(gGameSound1 number: 820 loop: -1 play:)
		(gGameSound2 number: 365 loop: -1 play:)
		(gMouseDownHandler addToFront: MazeHandler)
		(gKeyDownHandler addToFront: MazeHandler)
		(for ((= temp0 0)) (< temp0 30) ((++ temp0))
			(MazeHandler
				add:
					((MazeFeat new:)
						handler: MazeHandler
						myActor: mazeEgo
						setOnMeCheck: 2 ((gCurRoom obstacles:) at: temp0)
						yourself:
					)
			)
		)
		(if (== gPrevRoomNum 840)
			(MazeHandler curFeat: (MazeHandler at: 14))
			(mazeEgo setPri: 6)
			(self setScript: enterScript)
		else
			(MazeHandler curFeat: (MazeHandler at: 0))
			(mazeEgo posn: 263 166)
			(gGame handsOn:)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(= temp0 (mazeEgo onControl: 1))
		(= temp1 (& (mazeEgo signal:) $0010))
		(cond
			(script 0)
			((& temp0 $0002)
				(gCurRoom newRoom: 800)
			)
			((& temp0 $0004)
				(if (not (gCurrentRegionFlags test: 5))
					(gCurrentRegionFlags set: 5)
					(gGame points: 15)
				)
				(gCurRoom newRoom: 840)
			)
			((& temp0 $4000)
				(= local481 16384)
			)
			((and (& temp0 $0200) (!= local481 512))
				(= local481 512)
				(mazeEgo setPri: (if temp1 -1 else 4))
			)
			((and (& temp0 $0400) (!= local481 1024))
				(= local481 1024)
				(mazeEgo setPri: (if temp1 -1 else 11))
			)
			((and (& temp0 $0800) (!= local481 2048))
				(= local481 2048)
				(mazeEgo setPri: (if temp1 -1 else 11))
			)
			((and (& temp0 $1000) (!= local481 4096))
				(= local481 4096)
				(mazeEgo setPri: (if temp1 6 else 4))
			)
			((and (& temp0 $2000) (!= local481 8192))
				(= local481 8192)
				(mazeEgo setPri: (if temp1 -1 else 9))
			)
			(
				(and
					(& temp0 $8000)
					(!= local481 -32768)
					(or
						(and
							(& (mazeEgo signal:) $0010)
							(== (mazeEgo priority:) 8)
						)
						(not (& (mazeEgo signal:) $0010))
					)
				)
				(= local481 -32768)
				(mazeEgo setPri: 6)
			)
			(
				(and
					(& temp0 $8000)
					(!= local481 -32768)
					(& (mazeEgo signal:) $0010)
				)
				(= local481 -32768)
				(mazeEgo setPri: -1)
			)
		)
		(mazeEgo setSpeed: (gEgo moveSpeed:))
	)

	(method (newRoom newRoomNumber)
		(gGameSound1 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= gPMouse local482)
		(gMouseDownHandler delete: MazeHandler)
		(gKeyDownHandler delete: MazeHandler)
		(MazeHandler dispose:)
		(super dispose:)
	)
)

(instance mazePMouse of PseudoMouse
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (& (event type:) $0040) ; direction
			(= temp0 (gTheIconBar curIcon:))
			(gTheIconBar curIcon: 0)
			(super handleEvent: event)
			(gTheIconBar curIcon: temp0)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mazeEgo posn: 143 49 setMotion: MoveTo 162 65 self)
			)
			(1
				(mazeEgo setPri: 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mazeEgo of Actor
	(properties
		view 0
		signal 8192
	)
)

(instance waterFall of Prop
	(properties
		x 223
		y 3
		noun 11
		view 820
		signal 24576
		detailLevel 2
	)
)

(instance chamber of Feature
	(properties
		x 125
		y 34
		noun 4
		onMeCheck 16
	)
)

(instance stairway of Feature
	(properties
		x 272
		y 168
		noun 9
		onMeCheck 130
	)
)

(instance crevice of Feature
	(properties
		x 46
		y 2
		noun 1
		onMeCheck 32
	)
)

(instance lake of Feature
	(properties
		x 51
		y 14
		noun 2
		nsBottom 20
		nsRight 93
	)
)

(instance lake2 of Feature
	(properties
		x 51
		y 14
		noun 2
		nsLeft 94
		nsBottom 13
		nsRight 146
	)
)

(instance ruin of Feature
	(properties
		x 174
		y 100
		noun 5
		onMeCheck -256
	)

	(method (doit)
		(if (not (IsEcorderFlag 78))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 78))
			(super doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		x 226
		y 168
		noun 8
		onMeCheck 8
	)
)

(instance stella of Feature
	(properties
		y 101
		noun 12
		onMeCheck 64
	)

	(method (doit)
		(if (not (IsEcorderFlag 81))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 81))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foliage of Feature
	(properties
		y 101
		noun 10
		onMeCheck -32768
	)
)

