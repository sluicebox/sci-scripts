;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use dummyClient)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)

(public
	rm200 0
)

(local
	local0
	local1
	local2 = 1
	[local3 64]
	[local67 64]
	local131
	local132
	local133
	local134
	local135
	local136
	local137
	local138
	local139
	local140
	local141
	local142
	local143
	local144
	local145
	local146
	local147
	local148
	local149
	local150
	local151
	local152
	local153
	local154
	local155
	local156
	[local157 64] = [39 14 5 46 5 12 9 45 9 9 43 43 43 35 14 167 23 12 39 28 45 3 46 27 9 5 30 29 27 27 39 26 39 12 29 45 29 9 27 43 9 9 39 12 43 3 30 43 29 5 6 30 11 9 7 28 70 10 23 10 23 6 6 30]
	[local221 64] = [39 46 5 134 5 12 1 46 43 43 3 46 7 38 38 14 29 23 6 12 3 46 45 27 29 23 10 29 43 31 23 10 5 38 14 45 41 29 29 43 9 9 3 44 27 3 46 11 7 20 6 30 23 10 5 30 76 5 10 29 3 10 23 10]
	[local285 64] = [5 6 4 12 3 12 9 43 5 10 1 134 3 46 3 14 5 6 4 14 11 13 3 30 5 2 4 12 11 23 10 43 7 36 14 45 45 3 4 10 9 45 11 45 3 10 39 26 76 23 12 29 25 7 10 9 9 29 7 24 11 3 30 11]
	[local349 5] = [0 -6 7 6 -7]
	[local354 5] = [0 -2 8 2 -8]
	[local359 5] = [0 2 9 -2 -9]
	[local364 5] = [0 -5 3 5 -3]
	[local369 5] = [0 -1 4 1 -4]
	[local374 5] = [0 3 5 -3 -5]
	[local379 5] = [0 -4 -1 4 1]
	[local384 5] = [0 4 1 -4 -1]
	[local389 5] = [0 1 -4 -1 4]
	local394 = 16
	local395 = -16
	[local396 6] = [4 1 2 8 4 1]
	[local402 10] = [0 64 0 128 0 64 {N} {E} {S} {W}]
	local412
	local413
	[local414 15] = [1 4 8 2 5 12 10 3 13 14 11 7 6 9 15]
	[local429 4] = [71 109 109 71]
	[local433 4] = [52 52 84 84]
)

(procedure (localproc_0 param1 param2 param3)
	(switch local131
		(param1
			(= local154 0)
		)
		(param2
			(= local152 1)
		)
		(param3
			(= local151 1)
		)
	)
)

(procedure (localproc_1)
	(= local142 [local396 local131])
	(= local143 [local396 (mod (+ local131 2) 4)])
	(= local141 [local396 (+ local131 1)])
	(= local140 [local396 (- local131 1)])
	(= local146 [local402 local131])
	(= local145 [local402 (+ local131 1)])
	(= local144 [local402 (- local131 1)])
	(= local139 (+ local0 [local349 local131]))
	(= local138 (+ local0 [local354 local131]))
	(= local137 (+ local0 [local359 local131]))
	(= local136 (+ local0 [local364 local131]))
	(= local135 (+ local0 [local369 local131]))
	(= local134 (+ local0 [local374 local131]))
	(= local133 (+ local0 [local379 local131]))
	(= local132 (+ local0 [local384 local131]))
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3)
	(localproc_1)
	(= local154 1)
	(= local153 1)
	(= local152 0)
	(= local151 0)
	(if (< (mod (= temp3 (mod local0 16)) 4) 2)
		(if (== local131 1)
			(= local153 0)
		)
		(if (< (mod temp3 4) 1)
			(localproc_0 1 2 4)
		)
	)
	(if (> (mod temp3 4) 1)
		(if (== local131 3)
			(= local153 0)
		)
		(if (> (mod temp3 4) 2)
			(localproc_0 3 4 2)
		)
	)
	(if (> (/ temp3 4) 1)
		(if (== local131 2)
			(= local153 0)
		)
		(if (> (/ temp3 4) 2)
			(localproc_0 2 3 1)
		)
	)
	(if (< (/ temp3 4) 2)
		(if (== local131 4)
			(= local153 0)
		)
		(if (< (/ temp3 4) 1)
			(localproc_0 4 1 3)
		)
	)
	(if (& [local3 local0] local142)
		(= temp0 0)
	else
		(= temp0 1)
	)
	(if (or local151 (and (not temp0) (& [local3 local0] local141)))
		(= temp1 0)
	else
		(= temp1 1)
	)
	(if (and local152 (or (not temp0) (& [local3 local0] local140)))
		(= temp2 0)
	else
		(= temp2 1)
	)
	(if local153
		(if temp0
			(DrawCel local412 0 2 161 68 15)
		)
		(cond
			((and temp1 (& [local3 local137] local141))
				(DrawCel local412 2 2 245 67 15)
			)
			((and temp1 (& [local3 local137] local145))
				(DrawCel local412 2 5 245 67 15)
			)
		)
		(cond
			((and temp2 (& [local3 (+ local0 local139)] local140))
				(DrawCel local412 1 2 156 68 15)
			)
			((and temp2 (& [local3 (+ local0 local139)] local144))
				(DrawCel local412 1 5 156 68 15)
			)
		)
		(cond
			((and temp0 (& [local3 local137] local142))
				(DrawCel local412 3 2 218 74 15)
			)
			((and temp0 (& [local3 local137] local146))
				(DrawCel local412 6 2 218 74 15)
			)
		)
		(cond
			((and temp0 (& [local3 local139] local142))
				(DrawCel local412 3 2 169 74 15)
			)
			((and temp0 (& [local3 local139] local146))
				(DrawCel local412 6 2 169 74 15)
			)
		)
	)
	(DrawCel local412 0 0 156 48 15)
	(DrawCel local412 0 1 156 83 15)
	(if local153
		(if temp1
			(if (& [local3 (+ local0 local137)] $0020)
				(DrawCel local412 10 2 218 68 15)
			)
			(if (& [local3 local137] $0010)
				(DrawCel local412 12 2 218 83 15)
			)
		)
		(if temp2
			(if (& [local3 local139] $0020)
				(DrawCel local412 11 2 156 68 15)
			)
			(if (& [local3 local139] $0010)
				(DrawCel local412 13 2 156 83 15)
			)
		)
		(if temp0
			(cond
				((& [local3 local138] local142)
					(DrawCel local412 3 2 194 74 15)
				)
				((& [local3 local138] local146)
					(DrawCel local412 6 2 194 74 15)
				)
			)
			(if (& [local3 local138] $0020)
				(DrawCel local412 8 2 186 68 15)
			)
			(if (& [local3 local138] $0010)
				(DrawCel local412 9 2 187 83 15)
			)
			(cond
				((& [local3 local138] local141)
					(DrawCel local412 2 2 217 68 15)
				)
				((& [local3 local138] local145)
					(DrawCel local412 2 5 217 68 15)
				)
			)
			(cond
				((& [local3 local138] local140)
					(DrawCel local412 1 2 184 68 15)
				)
				((& [local3 local138] local144)
					(DrawCel local412 1 2 184 68 15)
				)
			)
		)
	)
	(if local154
		(if temp0
			(if (& [local3 local135] $0020)
				(DrawCel local412 8 1 173 58 15)
				(|= [local67 local135] $0020)
			)
			(if (& [local3 local135] $0010)
				(DrawCel local412 9 1 172 91 15)
				(|= [local67 local135] $0010)
			)
		)
		(if temp1
			(if (& [local3 local134] $0020)
				(DrawCel local412 10 1 228 58 15)
			)
			(if (& [local3 local134] $0010)
				(DrawCel local412 12 1 229 91 15)
			)
			(cond
				((& [local3 local134] local142)
					(DrawCel local412 4 1 228 68 15)
				)
				((& [local3 local134] local146)
					(DrawCel local412 4 4 228 68 15)
				)
			)
		)
		(if temp2
			(if (& [local3 local136] $0020)
				(DrawCel local412 11 1 155 58 15)
			)
			(if (& [local3 local136] $0010)
				(DrawCel local412 13 1 156 91 15)
			)
			(cond
				((& [local3 local136] local142)
					(DrawCel local412 5 1 156 68 15)
				)
				((& [local3 local136] local146)
					(DrawCel local412 5 4 156 68 15)
				)
			)
		)
		(if temp0
			(cond
				((& [local3 local135] local141)
					(DrawCel local412 2 1 227 57 15)
					(|= [local67 local135] local141)
				)
				((& [local3 local135] local145)
					(DrawCel local412 2 4 227 57 15)
				)
			)
			(cond
				((& [local3 local135] local140)
					(DrawCel local412 1 1 166 57 15)
					(|= [local67 local135] local140)
				)
				((& [local3 local135] local144)
					(DrawCel local412 1 4 166 57 15)
				)
			)
			(cond
				((& [local3 local135] local142)
					(DrawCel local412 3 1 186 68 15)
					(|= [local67 local135] local142)
				)
				((& [local3 local135] local146)
					(DrawCel local412 6 1 186 68 15)
				)
			)
		)
	)
	(if (& [local3 local0] $0020)
		(DrawCel local412 8 0 156 48 15)
		(|= [local67 local0] $0020)
	)
	(if (& [local3 local0] $0010)
		(DrawCel local412 9 0 156 101 15)
		(|= [local67 local0] $0010)
	)
	(cond
		((& [local3 local0] local141)
			(DrawCel local412 2 0 242 47 15)
			(|= [local67 local0] local141)
		)
		((& [local3 local0] local145)
			(DrawCel local412 2 3 242 47 15)
		)
		(temp1
			(if (& [local3 local132] $0020)
				(DrawCel local412 10 0 242 48 15)
				(|= [local67 local132] $0020)
			)
			(if (& [local3 local132] $0010)
				(DrawCel local412 12 0 243 101 15)
				(|= [local67 local132] $0010)
			)
			(cond
				((& [local3 local132] local142)
					(DrawCel local412 4 0 243 58 15)
					(|= [local67 local132] local142)
				)
				((& [local3 local132] local146)
					(DrawCel local412 4 3 243 58 15)
				)
			)
		)
	)
	(cond
		((& [local3 local0] local140)
			(DrawCel local412 1 0 155 47 15)
			(|= [local67 local0] local140)
		)
		((& [local3 local0] local144)
			(DrawCel local412 1 3 155 47 15)
		)
		(temp2
			(if (& [local3 local133] $0020)
				(DrawCel local412 11 0 155 48 15)
				(|= [local67 local133] $0020)
			)
			(if (& [local3 local133] $0010)
				(DrawCel local412 13 0 155 101 15)
				(|= [local67 local133] $0010)
			)
			(cond
				((& [local3 local133] local142)
					(DrawCel local412 5 0 156 58 15)
					(|= [local67 local133] local142)
				)
				((& [local3 local133] local146)
					(DrawCel local412 5 3 156 58 15)
				)
			)
		)
	)
	(if (not (& [local3 local0] $0020))
		(DrawCel local412 14 0 156 48 15)
	)
	(if (not (& [local3 local0] $0010))
		(DrawCel local412 15 0 156 101 15)
	)
	(cond
		((& [local3 local0] local142)
			(DrawCel local412 3 0 171 58 15)
			(|= [local67 local0] local142)
		)
		((& [local3 local0] local146)
			(DrawCel local412 6 0 171 58 15)
		)
	)
	(if (!= global114 2)
		(cond
			((== 1 local2)
				(localproc_3)
			)
			((and (== 2 local2) (not global114))
				(localproc_4)
			)
		)
		(switch (/ local0 16)
			(0
				(southMazeDoor show:)
			)
			(1
				(southMazeDoor hide:)
			)
			(2
				(northMazeDoor hide:)
			)
			(3
				(northMazeDoor show:)
			)
		)
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 (/ local0 16))
	(= temp1 (/ (mod local0 16) 4))
	(= temp0 (mod (mod local0 16) 4))
	(= temp3 (+ 76 (* temp0 4) (* temp1 7)))
	(= temp2 (+ (- 75 (* temp4 8)) (* temp0 4)))
	(Graph grFILL_BOX 49 75 55 100 1 0 -1 -1)
	(DrawCel 201 0 0 74 53 13)
	(DrawCel 201 0 1 74 (- 77 (* temp4 8)) 13)
	(DrawCel 201 3 local131 121 54 13)
	(positionIcon x: temp3 y: temp2)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(Graph grFILL_BOX 49 67 94 121 1 0 -1 -1)
	(Graph grUPDATE_BOX 49 67 94 121 1)
	(= temp6 (* (/ local0 16) 16))
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(if [local67 (= temp2 (+ temp6 temp0))]
			(= temp5 (mod [local67 temp2] 16))
			(for
				((= temp1 0))
				(and (!= temp5 [local414 temp1]) (< temp1 15))
				((++ temp1))
			)
			(= temp3 (+ (* (/ temp0 4) 11) 72))
			(= temp4 (+ (* (mod temp0 4) 9) 53))
			(if (< temp1 15)
				(DrawCel 201 4 temp1 temp3 temp4 13)
			)
			(cond
				((& [local67 temp2] $0020)
					(DrawCel 201 7 0 (+ temp3 1) (+ temp4 1) 13)
				)
				((& [local67 temp2] $0010)
					(DrawCel 201 7 1 (+ temp3 1) (+ temp4 1) 13)
				)
			)
		)
	)
	(for ((= temp7 0)) (< temp7 4) ((++ temp7))
		(DrawCel 201 6 temp7 [local429 temp7] [local433 temp7] 13)
	)
	(= temp9 (/ (mod local0 16) 4))
	(= temp8 (mod (- local0 temp6) 4))
	(positionIcon x: (+ 73 (* temp9 11)) y: (+ 53 (* temp8 9)))
	(DrawCel 201 5 local131 121 54 13)
)

(instance rm200 of Rm
	(properties
		lookStr {You are in an elevator made of stone! A screen shows your position in the elevator maze, and a window allows you to see the portion of the maze in front of you.}
		picture 200
		style 7
	)

	(method (init)
		(LoadMany rsVIEW 201 200)
		(LoadMany rsSOUND 920 922 923 924 925 932 933 937 938)
		(super init: &rest)
		(= local155 gPMouse)
		(= gPMouse 0)
		(levelIndicator init: setCycle: Fwd)
		(flasher init: setCycle: Fwd)
		(leftArrow init:)
		(rightArrow init:)
		(forwardArrow init:)
		(backwardArrow init:)
		(downMover init:)
		(upMover init:)
		(changeButton init:)
		(display init:)
		(railing1 init:)
		(railing2 init:)
		(mach init:)
		(bulb init:)
		(panelLights init:)
		(= local131 1)
		(= local156 global114)
		(= local0 15)
		(cond
			((or (== gPrevRoomNum 280) (== gPrevRoomNum 320))
				(for ((= local1 0)) (< local1 64) ((++ local1))
					(= [local3 local1] [local157 local1])
				)
				(= local412 302)
				(= local147 320)
				(= local148 280)
				(= local149 3)
				(= local150 2)
				(if (== gPrevRoomNum 280)
					(= local0 15)
				else
					(= local0 56)
					(= local131 3)
				)
			)
			((or (== gPrevRoomNum 380) (== gPrevRoomNum 420)) ; rmCode
				(for ((= local1 0)) (< local1 64) ((++ local1))
					(= [local3 local1] [local221 local1])
				)
				(= local412 402)
				(= local147 420)
				(= local148 380)
				(= local149 0)
				(= local150 2)
				(if (== gPrevRoomNum 380) ; rmCode
					(= local0 3)
				else
					(= local0 56)
					(= local131 3)
				)
			)
			(else
				(for ((= local1 0)) (< local1 64) ((++ local1))
					(= [local3 local1] [local285 local1])
				)
				(= local412 202)
				(= local147 220)
				(= local148 180)
				(= local149 2)
				(= local150 0)
				(if (== gPrevRoomNum 220)
					(= local0 48)
					(= local131 3)
				else
					(= local0 11)
				)
			)
		)
		(southMazeDoor x: (+ 91 (* local149 7)) init: hide:)
		(northMazeDoor x: (+ 77 (* local150 7)) init: hide:)
		(localproc_1)
		(localproc_2)
		(for ((= local1 0)) (< local1 64) ((++ local1))
			(= [local67 local1] 0)
		)
		(positionIcon init: setCycle: Fwd)
		(Graph grFILL_BOX 49 67 96 131 1 0 -1 -1)
		(if (== global114 2)
			(positionIcon hide:)
		else
			(localproc_3)
		)
		(controlPanel init:)
		(elevWindow init:)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(if (not (HaveMouse))
			(proc5_9 200 0) ; "You can move through the maze by using these keys: Up arrow - Move forward Down arrow - Move backwards Left arrow - Turn left Right arrow - Turn right Page up - Move up Page down - Move down Space bar - Toggle left display ? - See this message"
		)
		(gMouseDownHandler add: self)
		(gCMusic number: 938 setLoop: 1 play:)
		(Wait 0)
		(Wait 45)
	)

	(method (handleEvent event)
		(cond
			((& (event type:) evMOUSEBUTTON)
				(if (IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
			)
			((& (event type:) $0040) ; direction
				(if (IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
				(switch (event message:)
					(JOY_UPRIGHT
						(upMover doVerb: 3)
					)
					(JOY_DOWNRIGHT
						(downMover doVerb: 3)
					)
					(JOY_LEFT
						(leftArrow doVerb: 3)
					)
					(JOY_RIGHT
						(rightArrow doVerb: 3)
					)
					(JOY_UP
						(forwardArrow doVerb: 3)
					)
					(JOY_DOWN
						(backwardArrow doVerb: 3)
					)
				)
			)
			((== (event type:) evKEYBOARD)
				(switch (event message:)
					(KEY_SPACE
						(changeButton doVerb: 3)
					)
					(KEY_QUESTION
						(proc5_9 200 0) ; "You can move through the maze by using these keys: Up arrow - Move forward Down arrow - Move backwards Left arrow - Turn left Right arrow - Turn right Page up - Move up Page down - Move down Space bar - Toggle left display ? - See this message"
					)
					(else
						(super handleEvent: event &rest)
					)
				)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(= gPMouse local155)
		(super dispose:)
	)

	(method (doit)
		(if (GameIsRestarting)
			(localproc_2)
		)
		(if (!= local156 global114)
			(switch global114
				(2
					(Graph grFILL_BOX 49 67 94 130 1 0 -1 -1)
					(Graph grUPDATE_BOX 49 67 94 130 1)
					(southMazeDoor hide:)
					(northMazeDoor hide:)
					(positionIcon hide:)
				)
				(1
					(if (== local2 2)
						(= local2 1)
						(positionIcon loop: 1)
						(southMazeDoor x: (+ 91 (* local149 7)) y: 88)
						(northMazeDoor x: (+ 77 (* local150 7)) y: 49)
					)
					(positionIcon show:)
					(Graph grFILL_BOX 49 67 94 121 1 0 -1 -1)
					(Graph grUPDATE_BOX 49 67 94 121 1)
					(localproc_2)
				)
				(else
					(localproc_2)
					(positionIcon show:)
				)
			)
			(= local156 global114)
		)
		(super doit: &rest)
	)
)

(instance controlPanel of Feature
	(properties
		x 128
		y 114
		z 58
		nsTop 102
		nsLeft 50
		nsBottom 138
		nsRight 147
		description {elevator control panel}
		sightAngle 180
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 1) ; "The control panel has six colored buttons for moving and turning the elevator car."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elevWindow of Feature
	(properties
		x 154
		y 114
		z 85
		nsTop 45
		nsLeft 155
		nsBottom 112
		nsRight 259
		description {window in the elevator door}
		sightAngle 180
		onMeCheck 128
		lookStr {Through the elevator window, you can see a maze of elevator shafts going off in all directions.}
	)

	(method (init)
		(= lookStr
			(switch local412
				(302 {This is an older section of the elevator maze. The walls are constructed of stone blocks.})
				(402 {Either you've entered a trans-dimensional space warp, or someone has painted the walls of this maze to give you the feeling of travelling through space.})
				(else {This maze is constructed of steel panels.})
			)
		)
		(super init: &rest)
	)
)

(instance leftArrow of Prop
	(properties
		x 81
		y 130
		description {left arrow}
		view 200
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 2) ; "Pushing this button turns the elevator car to the left."
			)
			(3
				(self cel: 0)
				(Animate (gCast elements:) 1)
				(gCMusic2 number: 933 setLoop: 1 play:)
				(if (not (-- local131))
					(= local131 4)
				)
				(localproc_2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(self cel: 1)
	)
)

(instance rightArrow of Prop
	(properties
		x 117
		y 130
		description {right arrow}
		view 200
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 3) ; "Pushing this button turns the elevator car to the right."
			)
			(3
				(self cel: 0)
				(Animate (gCast elements:) 1)
				(gCMusic2 number: 933 setLoop: 1 play:)
				(if (> (++ local131) 4)
					(= local131 1)
				)
				(localproc_2)
				(self cel: 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance forwardArrow of Prop
	(properties
		x 99
		y 112
		description {forward arrow}
		view 200
		loop 2
		cel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 2)
				(Print 200 4) ; "Pushing this button moves the elevator car forward."
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((and (or (self cel: 0) (Animate (gCast elements:) 1)) 0))
			((& [local3 local0] local146)
				(cond
					((== local146 64)
						(gCMusic2 number: 937 setLoop: 1 play:)
						(Wait 0)
						(Wait 45)
						(Print 200 5) ; "You leave the maze through the north exit."
						(gCurRoom newRoom: local147)
					)
					((== local146 128)
						(gCMusic2 number: 937 setLoop: 1 play:)
						(Wait 0)
						(Wait 45)
						(Print 200 6) ; "You leave the maze through the south exit."
						(gCurRoom newRoom: local148)
					)
				)
			)
			((& [local3 local0] local142)
				(gCMusic2 number: 922 setLoop: 1 play:)
				(Wait 0)
				(Wait 10)
				(gCMusic2 number: 920 setLoop: 1 play:)
				(ShakeScreen 2 ssLEFTRIGHT)
				(Print 200 7 #time 5 #dispose #at -1 12) ; "Try as you might, you just can't crash through the wall."
			)
			(else
				(gCMusic2 number: 922 setLoop: 1 play:)
				(+= local0 [local369 local131])
				(localproc_2)
			)
		)
		(self cel: 1)
	)
)

(instance backwardArrow of Prop
	(properties
		x 98
		y 132
		description {back arrow}
		view 200
		loop 3
		cel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 2)
				(Print 200 8) ; "Pushing this button moves the elevator car back."
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((and (or (self cel: 0) (Animate (gCast elements:) 1)) 0))
			((& [local3 local0] (= temp0 [local402 (mod (+ local131 2) 4)]))
				(cond
					((== temp0 64)
						(gCMusic2 number: 937 setLoop: 1 play:)
						(Wait 0)
						(Wait 45)
						(Print 200 5) ; "You leave the maze through the north exit."
						(gCurRoom newRoom: local147)
					)
					((== temp0 128)
						(gCMusic2 number: 937 setLoop: 1 play:)
						(Wait 0)
						(Wait 45)
						(Print 200 6) ; "You leave the maze through the south exit."
						(gCurRoom newRoom: local148)
					)
				)
			)
			((& [local3 local0] local143)
				(gCMusic2 number: 932 setLoop: 1 play:)
				(Wait 0)
				(Wait 10)
				(gCMusic2 number: 920 setLoop: 1 play:)
				(ShakeScreen 2 ssLEFTRIGHT)
				(Print 200 7 #time 5 #dispose #at -1 12) ; "Try as you might, you just can't crash through the wall."
			)
			(else
				(gCMusic2 number: 932 setLoop: 1 play:)
				(+= local0 [local389 local131])
				(localproc_2)
			)
		)
		(self cel: 1)
	)
)

(instance downMover of Prop
	(properties
		x 91
		y 123
		description {down button}
		view 200
		loop 4
		cel 1
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 200 9) ; "Pushing this button moves the elevator car down."
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((and (or (self cel: 0) (Animate (gCast elements:) 1)) 0))
			((and (> local0 15) (& [local3 local0] $0010))
				(gCMusic2 number: 924 setLoop: 1 play:)
				(+= local0 local395)
				(localproc_2)
			)
			(else
				(gCMusic2 number: 924 setLoop: 1 play:)
				(Wait 0)
				(Wait 10)
				(gCMusic2 number: 920 setLoop: 1 play:)
				(ShakeScreen 2 ssUPDOWN)
				(Print 200 10 #time 5 #dispose #at -1 12) ; "Try as you might, you just can't bump through the floor."
			)
		)
		(self cel: 1)
	)
)

(instance upMover of Prop
	(properties
		x 108
		y 123
		description {up button}
		view 200
		loop 5
		cel 1
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 200 11) ; "Pushing this button moves the elevator car up."
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((and (or (self cel: 0) (Animate (gCast elements:) 1)) 0))
			((and (< local0 51) (& [local3 local0] $0020))
				(gCMusic2 number: 923 setLoop: 1 play:)
				(+= local0 local394)
				(localproc_2)
			)
			(else
				(gCMusic2 number: 923 setLoop: 1 play:)
				(Wait 0)
				(Wait 10)
				(gCMusic2 number: 920 setLoop: 1 play:)
				(ShakeScreen 2 ssUPDOWN)
				(Print 200 12 #time 5 #dispose #at -1 12) ; "Try as you might, you just can't bump through the ceiling."
			)
		)
		(self cel: 1)
	)
)

(instance positionIcon of Actor
	(properties
		x 76
		y 51
		view 201
		loop 1
		priority 14
		signal 16
	)
)

(instance northMazeDoor of Actor
	(properties
		y 49
		description {North Door}
		view 201
		loop 2
		cel 1
		priority 13
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 13) ; "This is the north door out of the maze."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southMazeDoor of Actor
	(properties
		y 89
		description {South Door}
		lookStr {This is the south door out of the maze.}
		view 201
		loop 2
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 14) ; "This is the south door out of the maze."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance changeButton of Actor
	(properties
		x 153
		y 127
		description {display mode control}
		view 200
		loop 7
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 3) global114) 0)
			((== theVerb 3)
				(gCMusic number: 925 setLoop: 1 play:)
				(self cel: 1)
				(Animate (gCast elements:) 1)
				(if (not global114)
					(Graph grFILL_BOX 49 67 94 121 1 0 -1 -1)
					(Graph grUPDATE_BOX 49 67 94 121 1)
					(if (== local2 1)
						(= local2 2)
						(positionIcon loop: 8)
						(southMazeDoor x: (+ 76 (* local149 11)) y: 84)
						(northMazeDoor x: (+ 75 (* local150 11)) y: 49)
						(localproc_4)
					else
						(= local2 1)
						(positionIcon loop: 1)
						(southMazeDoor x: (+ 91 (* local149 7)) y: 88)
						(northMazeDoor x: (+ 77 (* local150 7)) y: 49)
						(localproc_3)
					)
					(self cel: 0)
				else
					(proc5_9 200 15) ; "The button doesn't seem to work."
				)
			)
			((and (== theVerb 2) global114)
				(proc5_9 200 16) ; "Out of Order."
			)
			((== theVerb 2)
				(Print 200 17) ; "Pushing this button changes the map display between a three-dimensional grid and a flat map of the current level."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance levelIndicator of Actor
	(properties
		x 242
		y 132
		view 200
		loop 8
		cycleSpeed 18
	)
)

(instance flasher of Actor
	(properties
		x 193
		y 125
		description {flashing light}
		view 200
		loop 6
		cycleSpeed 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 18) ; "The lights on the control panel show that the elevator is working -- always a comfort."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance display of Feature
	(properties
		x 99
		y 165
		z 94
		nsTop 47
		nsLeft 59
		nsBottom 96
		nsRight 139
		description {display screen}
		sightAngle 180
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(cond
				((== global114 2)
					(= lookStr
						{The screen is presently blank}
					)
				)
				((== local2 1)
					(= lookStr
						{This shows your relative position within the four levels of the maze.}
					)
				)
				(else
					(= lookStr
						{This is a diagram of the areas you've visited so far on this level of the maze.}
					)
				)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance railing1 of Feature
	(properties
		x 20
		y 177
		z 56
		nsTop 108
		nsBottom 134
		nsRight 41
		description {left railing}
		sightAngle 180
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 19) ; "You can hold on to these if you tend to become seasick."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance railing2 of Feature
	(properties
		x 297
		y 122
		nsTop 106
		nsLeft 275
		nsBottom 139
		nsRight 319
		description {right railing}
		sightAngle 180
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 19) ; "You can hold on to these if you tend to become seasick."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mach of Feature
	(properties
		x 168
		y 152
		nsTop 139
		nsLeft 59
		nsBottom 165
		nsRight 278
		description {machinery}
		sightAngle 180
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 20) ; "The machinery allows the elevator to turn in any direction and to move through the maze."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bulb of Feature
	(properties
		x 227
		y 165
		z 130
		nsTop 29
		nsLeft 219
		nsBottom 41
		nsRight 235
		description {light bulb}
		sightAngle 180
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 21) ; "This powerful bulb provides enough light to let you see some of the maze outside the elevator car. It's just one more of Dr. Brain's brilliant ideas."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance panelLights of Feature
	(properties
		x 242
		y 126
		nsTop 118
		nsLeft 148
		nsBottom 136
		nsRight 269
		description {panel lights}
		sightAngle 180
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 200 18) ; "The lights on the control panel show that the elevator is working -- always a comfort."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

