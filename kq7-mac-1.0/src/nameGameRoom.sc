;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use ExitButton)
(use n021)
(use Plane)
(use Str)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	nameGameRoom 0
)

(local
	[local0 72] = [84 166 133 117 116 134 151 169 196 188 200 218 199 181 208 224 80 131 102 147 179 150 96 116 162 101 220 86 100 114 129 144 159 174 189 204 105 121 121 105 90 105 106 106 91 106 106 105 122 121 90 90 90 91 106 91 91 122 91 122 91 121 74 74 75 74 73 73 74 74 75 75]
	local72 = 95
	local73 = 62
	[local74 8]
	[local82 36]
	local118
	local119
	[local120 2]
	[local122 6] = [117 135 151 167 184 202]
	[local128 6] = [88 88 88 88 87 89]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(gNormalCursor cel: 0 init:)
	(gCast eachElementDo: #hide)
	(= temp8 (Set new:))
	(= temp0 gCast)
	(= temp3 gThePlane)
	(= gThePlane (Plane new:))
	(gThePlane
		setRect: 0 0 319 199
		back: 0
		picture: -1
		priority: 3000
		init:
		addCast: (= gCast (Cast new:))
	)
	((View new:) view: 985 loop: 0 cel: 0 x: 105 y: 91 init: setPri: 1)
	(for ((= temp1 0)) (< temp1 6) ((++ temp1))
		(= temp5 (ChapSelectView new:))
		(temp5
			x: [local122 temp1]
			y: [local128 temp1]
			loop: 1
			cel: temp1
			priority: 100
			init:
			z: 1000
		)
		(temp8 add: temp5)
	)
	(= temp4 0)
	(= gChapter -1)
	(= temp7 (- (NumCels gNormalCursor) 1))
	(= temp6 (GetTime))
	(while (== gChapter -1)
		(= temp2 ((gUser curEvent:) new:))
		(if (& (temp2 type:) $0004)
			(gKqSound1 number: 13 loop: 1 play:)
			(switch (temp2 message:)
				(49
					(UpdateScreenItem ((gCast at: 1) z: 0 yourself:))
					(= gChapter 0)
				)
				(50
					(UpdateScreenItem ((gCast at: 2) z: 0 yourself:))
					(= gChapter 1)
				)
				(51
					(UpdateScreenItem ((gCast at: 3) z: 0 yourself:))
					(= gChapter 2)
				)
				(52
					(UpdateScreenItem ((gCast at: 4) z: 0 yourself:))
					(= gChapter 3)
				)
				(53
					(UpdateScreenItem ((gCast at: 5) z: 0 yourself:))
					(= gChapter 4)
				)
				(54
					(UpdateScreenItem ((gCast at: 6) z: 0 yourself:))
					(= gChapter 5)
				)
			)
		else
			(OnMeAndLowY init:)
			(temp8 eachElementDo: #perform OnMeAndLowY temp2)
			(cond
				((OnMeAndLowY theObj:)
					(if (> (- (GetTime) temp6) 5)
						(= temp6 (GetTime))
						(if (> (++ temp4) temp7)
							(= temp4 0)
						)
						(SetCursor 999 0 temp4)
					)
					(if (temp2 type:)
						((OnMeAndLowY theObj:) handleEvent: temp2)
					)
				)
				((!= temp4 0)
					(= temp4 0)
					(SetCursor 999 0 0)
				)
			)
			(gCast doit:)
		)
		(FrameOut)
	)
	(= temp9 (= gGameTime (+ gTickOffset (GetTime))))
	(while (< (- gGameTime temp9) 60)
		(= gGameTime (+ gTickOffset (GetTime)))
		(FrameOut)
	)
	(gCast dispose:)
	(gThePlane dispose:)
	(temp8 release: dispose:)
	(= gCast temp0)
	(= gThePlane temp3)
	(gGame handsOff:)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(= temp0 (View new:))
	(temp0 view: 993 loop: 0 cel: 0 x: 94 y: 53 setPri: 500 init:)
	(while 1
		(= temp1 ((gUser curEvent:) new:))
		(if (== (temp1 type:) 1)
			(break)
		)
		(FrameOut)
	)
	(temp0 dispose:)
)

(procedure (localproc_2 param1 &tmp temp0)
	(Str format: {%s%s} gCurSaveDir param1)
)

(instance nameGameRoom of Room
	(properties
		style 14
		exitStyle 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(super init: &rest)
		(gCast eachElementDo: #hide)
		(= temp3 gThePlane)
		(= gThePlane (Plane new:))
		(gThePlane setRect: 0 0 319 199 back: 0 picture: -1 priority: 3000 init:)
		(FrameOut)
		(= global101 1234)
		(= global107 29)
		(= global115 6)
		(= global302 1)
		(= global303 2)
		(= global304 3)
		(= global314 1)
		(= global315 1)
		(= global325 77)
		(= gGem2Position 3)
		(= gGem3Position 1)
		(= global329 -1)
		(= global330 -1)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(= [gRozInventoryIndexes temp0] -1)
			(= [gValInventoryIndexes temp0] -1)
		)
		(= temp2 36)
		(for ((= temp0 0)) (< temp0 temp2) ((++ temp0))
			(= [global127 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
			((gInventory at: temp0) owner: -1 hide:)
		)
		(global108 release:)
		(global124 release:)
		(= gInventoryCount 0)
		(if (> (gGame speedRating:) 165)
			(SetFlag 97)
		else
			(ClearFlag 97)
		)
		(= temp4 (Platform 0 3))
		(gThePlane dispose:)
		(= gThePlane temp3)
		(if temp4
			(gCurRoom setScript: myChapSelect)
		else
			(gCurRoom newRoom: 30)
		)
		(FrameOut)
		(gUser canInput: 1)
		(gGame setCursor: gNormalCursor)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (== (event type:) $0010) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(JOY_NULL
					(event message: KEY_5)
				)
				(JOY_UP
					(event message: KEY_8)
				)
				(JOY_UPRIGHT
					(event message: KEY_9)
				)
				(JOY_RIGHT
					(event message: KEY_6)
				)
				(JOY_DOWNRIGHT
					(event message: KEY_3)
				)
				(JOY_DOWN
					(event message: KEY_2)
				)
				(JOY_DOWNLEFT
					(event message: KEY_1)
				)
				(JOY_LEFT
					(event message: KEY_4)
				)
				(JOY_UPLEFT
					(event message: KEY_7)
				)
			)
		)
		(cond
			((event claimed:)
				(return)
			)
			((== (event type:) evKEYBOARD)
				(event claimed: 1)
				(= temp0 (event message:))
				(= temp2 0)
				(if
					(or
						(and (>= temp0 KEY_a) (<= temp0 KEY_z) (= temp2 1))
						(and (>= temp0 KEY_A) (<= temp0 KEY_Z) (= temp2 1))
						(and (>= temp0 KEY_0) (<= temp0 KEY_9))
					)
					(if temp2
						(if (and (>= temp0 KEY_a) (<= temp0 KEY_z))
							(-= temp0 97)
						else
							(-= temp0 65)
						)
					else
						(= temp0 (+ (-= temp0 47) 25))
					)
					(= temp1 [local82 temp0])
					(gGame setCursor: gTheCursor 1 (temp1 x:) (+ (temp1 y:) 10))
					(temp1 doVerb:)
				else
					(switch temp0
						(JOY_UPLEFT
							(backspace doVerb:)
						)
						(KEY_ESCAPE
							(cancelButton doVerb:)
						)
						(KEY_RETURN
							(doneButton doVerb:)
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
			(else
				(gCast eachElementDo: #handleEvent event)
				(return)
			)
		)
	)

	(method (doVerb))

	(method (dispose)
		(super dispose:)
	)
)

(class ChapSelectView of View
	(properties
		view 985
		loop 1
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(gKqSound1 number: 13 loop: 1 play:)
		(while 1
			(= temp0 ((gUser curEvent:) new:))
			(if (self onMe: temp0)
				(= z 0)
				(UpdateScreenItem self)
			else
				(= z 1000)
				(UpdateScreenItem self)
			)
			(FrameOut)
			(if (== (temp0 type:) 2)
				(if (self onMe: temp0)
					(= gChapter cel)
					(event claimed: 1)
					(return 1)
				)
			else
				(continue)
			)
			(return 0)
		)
	)
)

(instance alphaGameControls of Set ; UNUSED
	(properties)
)

(instance letterCast of Cast ; UNUSED
	(properties)
)

(instance myChapSelect of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 21)
				(localproc_0)
				(SetFlag 8)
				(= cycles 1)
			)
			(1
				(gGame setCursor: gNormalCursor)
				(gCurRoom newRoom: 35) ; chapEndRm
				(self dispose:)
			)
		)
	)
)

(instance facePlate of View ; UNUSED
	(properties
		x 39
		y 26
		priority 50
		fixPriority 1
		view 920
	)

	(method (onMe)
		(return 0)
	)
)

(instance flashScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setPri: 55 hiliteState: 0)
				(UpdateScreenItem client)
				(= ticks 30)
			)
			(1
				(client setPri: 45 hiliteState: 1)
				(UpdateScreenItem client)
				(= ticks 30)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(class LetterIcon of Prop
	(properties
		hiliteState 0
		enabled 1
		value 0
		alphaChar 1
	)

	(method (init)
		(self setPri: 45 ignoreActors: 1)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb &tmp temp0)
		(if (< local118 8)
			(self setScript: (flashScr new:))
			(if alphaChar
				(local119 at: local118 (+ value 65))
			else
				(local119 at: local118 (+ value 48))
			)
			(= temp0
				(if (not local118)
					local72
				else
					(+ ([local74 (- local118 1)] nsRight:) 4)
				)
			)
			((= [local74 local118] (View new:))
				view: view
				setLoop: loop
				cel: 1
				x: temp0
				y: local73
				setPri: 55
				init:
			)
			(gKqSound1 number: 13 loop: 1 play:)
			(++ local118)
		)
	)

	(method (enable param1)
		(if (and argc (not param1))
			(= enabled 0)
			(if hiliteState
				(self hiliteState: 0)
			)
		else
			(= enabled 1)
		)
	)
)

(instance backspace of LetterIcon
	(properties
		x 78
		y 122
		view 907
		loop 10
	)

	(method (doVerb)
		(if (> local118 0)
			(-- local118)
			(self setScript: (flashScr new:))
			(gKqSound1 number: 13 loop: 1 play:)
			([local74 local118] dispose:)
			(local119 at: local118 0)
		)
	)
)

(instance doneButton of LetterIcon
	(properties
		x 137
		y 135
		view 907
		loop 11
	)

	(method (doVerb &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 3])
		(= temp0 (Str newWith: 40 {}))
		(gKqSound1 number: 13 loop: 1 play:)
		(self setScript: (flashScr new:))
		(while 1
			(if script
				(script doit:)
				(if gCuees
					(gCuees eachElementDo: #doit)
					(if (gCuees isEmpty:)
						(gCuees dispose:)
						(= gCuees 0)
					)
				)
			else
				(break)
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
		)
		(if (> (local119 size:) 0)
			(= temp2 0)
			(= temp5 (localproc_2 {kq7cdsg.cat}))
			(if (FileIO fiEXISTS (temp5 data:))
				((= temp1 (File new:))
					name: (temp5 data:)
					open: 1
					read: temp0 2
				)
				(while (!= (proc0_3 temp0 0) -1)
					(temp1 read: temp0 36)
					(if (local119 compare: temp0)
						(= temp2 1)
						(break)
					)
					(temp1 read: temp0 2)
				)
				(temp1 dispose:)
			)
			(if temp2
				(localproc_1)
			else
				(= global305 (proc21_1))
				(SetFlag 21)
				(gGame setCursor: gNormalCursor)
				(gKqMusic1 fade:)
				(localproc_0)
				(SetFlag 8)
				(gCurRoom newRoom: 35) ; chapEndRm
			)
			(temp5 dispose:)
		)
		(temp0 dispose:)
	)
)

(instance cancelButton of LetterIcon
	(properties
		x 217
		y 120
		view 907
		loop 12
	)

	(method (doVerb)
		(gKqSound1 number: 13 loop: 1 play:)
		(self setScript: (flashScr new:))
		(while 1
			(if script
				(script doit:)
				(if gCuees
					(gCuees eachElementDo: #doit)
					(if (gCuees isEmpty:)
						(gCuees dispose:)
						(= gCuees 0)
					)
				)
			else
				(break)
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
		)
		(gCurRoom newRoom: 30)
	)
)

