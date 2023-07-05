;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use TransPlane)
(use DText)
(use Plane)
(use Str)
(use Print)
(use IconBar)
(use Tutorial)
(use Actor)
(use System)

(public
	pqGameControls 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 param2)
	(cond
		((not (IsHiRes)))
		(param1
			(greenLight
				x: (+ (param2 x:) (param2 offX:))
				y: (+ (param2 y:) (param2 offY:))
				cel: 1
			)
			(UpdateScreenItem greenLight)
		)
		(else
			(greenLight mask:)
		)
	)
)

(class LEDCast of Cast
	(properties
		x 0
		y 0
		lastY 0
	)

	(method (init param1 param2 param3)
		(self add: x: param1 y: param2 plane: (pqGameControls plane:))
		(self lastY: y setSize: param3)
	)

	(method (setSize param1)
		(cond
			((== param1 size)
				(return)
			)
			((< param1 size)
				(while (and (!= param1 size) (!= size 0))
					(+= lastY 4)
					((self at: (- size 1)) dispose:)
					(FrameOut)
				)
			)
			(else
				(while (!= param1 size)
					((View new:)
						view: (if (IsHiRes) 10982 else 982)
						loop: 2
						cel: 0
						x: x
						y: lastY
						init: self
					)
					(FrameOut)
					(-= lastY 4)
				)
			)
		)
	)
)

(instance GCDtext of DText
	(properties)

	(method (onMe)
		(return 0)
	)
)

(instance pqGameControls of IconBar
	(properties)

	(method (shouldClose)
		(return 0)
	)

	(method (init)
		(if (not (& (gTheIconBar state:) $0004))
			(gPqFlags set: 40)
		)
		(gTheIconBar disable:)
		(= global119 1)
		(FrameOut)
		(gGame setIntensity: 25)
		(FrameOut)
		(= gGameControls self)
		(= plane controlPlane)
		(self
			add:
				greenLight
				speedBox
				volumeBox
				detailBox
				(iconSave object: gGame selector: #save yourself:)
				(iconRestore object: gGame selector: #restore yourself:)
				(iconRestart object: gGame selector: #restart yourself:)
				(iconQuit object: gGame selector: #quitGame yourself:)
				iconPlay
				iconAbout
				iconGCHelp
				increaseSpeed
				decreaseSpeed
				increaseVolume
				decreaseVolume
				increaseDetail
				decreaseDetail
			helpIconItem: iconGCHelp
			curIcon: iconSave
			state: 2048
		)
		(if (IsHiRes)
			(self add: iconText)
		)
		(super init: &rest)
		(plane
			left: (/ (- 320 (CelWide 9820 0 0)) 2)
			top: (/ (- 153 (CelHigh 9820 0 0)) 2)
			setBitmap: (if (IsHiRes) 10986 else 9820) 0 0 0
		)
	)

	(method (show)
		(super show: &rest)
		(= local4 (Str new:))
		(local4 format: {%d} gScore)
		(if (not local3)
			(= local3 (GCDtext new:))
		)
		(local3
			font: gUserFont
			text: (KString 8 (local4 data:)) ; StrDup
			x: (if (IsHiRes) 154 else 151)
			y: (if (IsHiRes) 125 else 122)
			fore: 22
			back: 254
			skip: 254
			setSize:
			setPri: (+ (GetHighPlanePri) 1)
			init: self
		)
		(Platform 0 2 1)
	)

	(method (dispose)
		(super dispose:)
		(if global119
			(if (gPqFlags test: 40)
				(gPqFlags clear: 40)
				(gTheIconBar enable:)
			)
			(gGame setIntensity: 100)
		)
		(if (gPqFlags test: 40)
			(gTheIconBar enable:)
		else
			(gTheIconBar show: 0)
		)
		(= local0 0)
		(= local1 0)
		(= local2 0)
		(local4 dispose:)
		(= local4 0)
		(if (not (gCurRoom inset:))
			(Platform 0 2 0)
		)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3)
		(= temp1 (= temp2 (= temp3 0)))
		(= temp0 ((gUser curEvent:) new:))
		(while (not (temp0 type:))
			(temp0 localize: plane)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if temp3
							(temp3 dispose:)
							(= temp3 0)
							(FrameOut)
						)
						(Print
							font: 4
							fore: 13
							width: 200
							shadowText: 1
							plane: TransPlane
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(if (== (temp2 modNum:) -1)
									0
								else
									(temp2 modNum:)
								)
							modeless: 2
							init:
						)
						(= temp3 (Print dialog:))
					)
				)
				(temp3
					(temp3 dispose:)
					(= temp3 0)
				)
				(else
					(= temp1 0)
				)
			)
			(FrameOut)
			(temp0 new:)
		)
		(temp0 claimed: 1)
		(if temp3
			(temp3 dispose:)
			(= temp3 0)
			(FrameOut)
		)
		(Print font: 4 width: 0 shadowText: 0 plane: 0 modeless: 0)
		(gGame setCursor: gNormalCursor 1)
	)
)

(instance controlPlane of Plane
	(properties)
)

(instance speedBox of IconI
	(properties
		nsLeft 89
		nsTop 18
		nsRight 113
		nsBottom 116
		x 90
		y 13
		mainView 982
		mainLoop 12
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 9)
			(= x 89)
		)
		(super init: &rest)
		(self nsTop: 18 nsLeft: 89 nsRight: 113 nsBottom: 116)
	)

	(method (select)
		(return 0)
	)

	(method (onMe param1)
		(cond
			((& (param1 type:) $2000)
				(return 0)
			)
			(
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
				(if (not modifiers)
					(= modifiers 1)
					(self highlight: 1)
				)
			)
			(modifiers
				(= modifiers 0)
				(self highlight: 0)
			)
		)
		(return 0)
	)
)

(instance volumeBox of IconI
	(properties
		nsLeft 124
		nsTop 18
		nsRight 148
		nsBottom 116
		x 116
		y 13
		mainView 982
		mainLoop 13
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 9)
		)
		(super init: &rest)
		(self nsTop: 18 nsLeft: 124 nsRight: 148 nsBottom: 116)
	)

	(method (select)
		(return 0)
	)

	(method (onMe param1)
		(cond
			((& (param1 type:) $2000)
				(return 0)
			)
			(
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
				(if (not modifiers)
					(= modifiers 1)
					(self highlight: 1)
				)
			)
			(modifiers
				(= modifiers 0)
				(self highlight: 0)
			)
		)
		(return 0)
	)
)

(instance detailBox of IconI
	(properties
		nsLeft 158
		nsTop 18
		nsRight 182
		nsBottom 116
		x 156
		y 13
		mainView 982
		mainLoop 14
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 9)
		)
		(super init: &rest)
		(self nsTop: 18 nsLeft: 158 nsRight: 182 nsBottom: 116)
	)

	(method (select)
		(return 0)
	)

	(method (onMe param1)
		(cond
			((& (param1 type:) $2000)
				(return 0)
			)
			(
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
				(if (not modifiers)
					(= modifiers 1)
					(self highlight: 1)
				)
			)
			(modifiers
				(= modifiers 0)
				(self highlight: 0)
			)
		)
		(return 0)
	)
)

(class LevelIcon of IconI
	(properties)

	(method (onMe param1)
		(cond
			((& (param1 type:) $2000)
				(if
					(and
						(<= nsLeft (param1 x:) nsRight)
						(<= nsTop (param1 y:) nsBottom)
					)
					(return 1)
				else
					(return 0)
				)
			)
			(
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
				(if (not modifiers)
					(= modifiers 1)
					(self highlight: 1)
				)
				(return 1)
			)
			(else
				(if modifiers
					(= modifiers 0)
					(self highlight: 0)
				)
				(return 0)
			)
		)
	)

	(method (levelTest)
		(return 1)
	)

	(method (levelCode)
		(return 1)
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(= modifiers 0)
					(= cel 1)
					(UpdateScreenItem self)
					(FrameOut)
					(= temp3 (+ gTickOffset (GetTime)))
					(= temp4 0)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize: plane)
						(cond
							((super onMe: temp0)
								(if (not cel)
									(= cel 1)
									(UpdateScreenItem self)
									(FrameOut)
								)
								(= gGameTime (+ gTickOffset (GetTime)))
								(if
									(and
										(>= (Abs (- gGameTime temp3)) 4)
										(self levelTest:)
									)
									(= temp4 1)
									(= temp3 (+ gTickOffset (GetTime)))
									(self levelCode: show: 0)
								)
							)
							(cel
								(= cel 0)
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== cel 1)
						(if (and (not temp4) (self levelTest:))
							(self levelCode: show: 0)
						)
						(= cel 0)
						(UpdateScreenItem self)
						(FrameOut)
					)
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Tutorial)
						)
						(cond
							(
								(and
									(== (temp2 nextItem:) self)
									(!=
										(temp2 nextAction:)
										((gTheIconBar helpIconItem:) message:)
									)
								)
								(temp2 cue:)
							)
							((not cel)
								(return 0)
							)
							(else
								(temp2 report:)
								(return 0)
							)
						)
					)
					cel
				)
				(else
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Tutorial)
						)
						(if
							(and
								(== (temp2 nextItem:) self)
								(!=
									(temp2 nextAction:)
									((gTheIconBar helpIconItem:) message:)
								)
							)
							(temp2 cue:)
						else
							(temp2 report:)
							(return 0)
						)
					)
					1
				)
			)
		)
	)
)

(instance increaseSpeed of LevelIcon
	(properties
		noun 3
		modNum 9
		x 89
		y 96
		signal 131
		mainView 982
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
		)
		(super init: &rest)
		(if (not local0)
			(= local0 (LEDCast new:))
			(local0 init: 99 87 (- 15 global112))
			(plane addCast: local0)
		)
	)

	(method (show param1 &tmp [temp0 2])
		(if (or (not argc) (and argc param1))
			(super show: &rest)
		)
		(if local0
			(local0 setSize: (- 15 global112))
		)
	)

	(method (levelTest)
		(return (> global112 0))
	)

	(method (levelCode)
		(gEgo setSpeed: (-- global112))
	)
)

(instance decreaseSpeed of LevelIcon
	(properties
		noun 12
		modNum 9
		x 89
		y 107
		signal 131
		mainView 982
		mainLoop 1
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
		)
		(super init: &rest)
		(if (not local0)
			(= local0 (LEDCast new:))
			(local0 init: 99 87 (- 15 global112))
			(plane addCast: local0)
		)
	)

	(method (show param1 &tmp [temp0 2])
		(if (or (not argc) (and argc param1))
			(super show: &rest)
		)
		(if local0
			(local0 setSize: (- 15 global112))
		)
	)

	(method (levelTest)
		(return (<= global112 14))
	)

	(method (levelCode)
		(gEgo setSpeed: (++ global112))
	)
)

(instance increaseVolume of LevelIcon
	(properties
		noun 2
		modNum 9
		x 124
		y 96
		signal 131
		mainView 982
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
		)
		(super init: &rest)
		(if (not local2)
			(= local2 (LEDCast new:))
			(local2 init: 134 87 (gGame masterVolume:))
			(plane addCast: local2)
		)
	)

	(method (show param1 &tmp [temp0 2])
		(if (or (not argc) (and argc param1))
			(super show: &rest)
		)
		(if local2
			(local2 setSize: (gGame masterVolume:))
		)
	)

	(method (levelTest)
		(return (<= (gGame masterVolume:) 15))
	)

	(method (levelCode)
		(gGame masterVolume: (+ (gGame masterVolume:) 1))
	)
)

(instance decreaseVolume of LevelIcon
	(properties
		noun 13
		modNum 9
		x 124
		y 107
		signal 131
		mainView 982
		mainLoop 1
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
		)
		(super init: &rest)
		(if (not local2)
			(= local2 (LEDCast new:))
			(local2 init: 134 87 (gGame masterVolume:))
			(plane addCast: local2)
		)
	)

	(method (show param1 &tmp [temp0 2])
		(if (or (not argc) (and argc param1))
			(super show: &rest)
		)
		(if local2
			(local2 setSize: (gGame masterVolume:))
		)
	)

	(method (levelTest)
		(return (> (gGame masterVolume:) 0))
	)

	(method (levelCode)
		(gGame masterVolume: (- (gGame masterVolume:) 1))
	)
)

(instance increaseDetail of LevelIcon
	(properties
		noun 1
		modNum 9
		x 158
		y 96
		signal 131
		mainView 982
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
		)
		(super init: &rest)
		(if (not local1)
			(= local1 (LEDCast new:))
			(local1 init: 169 87 (gGame detailLevel:))
			(plane addCast: local1)
		)
	)

	(method (show param1 &tmp [temp0 2])
		(if (or (not argc) (and argc param1))
			(super show: &rest)
		)
		(if local1
			(local1 setSize: (gGame detailLevel:))
		)
	)

	(method (levelTest)
		(return (<= (gGame detailLevel:) 14))
	)

	(method (levelCode)
		(gGame detailLevel: (+ (gGame detailLevel:) 1))
	)
)

(instance decreaseDetail of LevelIcon
	(properties
		noun 11
		modNum 9
		x 158
		y 107
		signal 131
		mainView 982
		mainLoop 1
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
		)
		(super init: &rest)
		(if (not local1)
			(= local1 (LEDCast new:))
			(local1 init: 169 87 (gGame detailLevel:))
			(plane addCast: local1)
		)
	)

	(method (show param1 &tmp [temp0 2])
		(if (or (not argc) (and argc param1))
			(super show: &rest)
		)
		(if local1
			(local1 setSize: (gGame detailLevel:))
		)
	)

	(method (levelTest)
		(return (> (gGame detailLevel:) 0))
	)

	(method (levelCode)
		(gGame detailLevel: (- (gGame detailLevel:) 1))
	)
)

(class GCItem of IconI
	(properties
		offX 0
		offY 0
	)

	(method (onMe param1)
		(cond
			((& (param1 type:) $2000)
				(if
					(and
						(<= nsLeft (param1 x:) nsRight)
						(<= nsTop (param1 y:) nsBottom)
					)
					(return 1)
				else
					(return 0)
				)
			)
			(
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
				(if (not modifiers)
					(= modifiers 1)
					(self highlight: 1)
				)
				(return 1)
			)
			(else
				(if modifiers
					(= modifiers 0)
					(self highlight: 0)
				)
				(localproc_0 0)
				(return 0)
			)
		)
	)
)

(instance iconSave of GCItem
	(properties
		noun 4
		modNum 9
		x 25
		y 18
		signal 195
		mainView 982
		mainLoop 7
		cursorView 999
		helpVerb 9
		offX -12
		offY 3
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 17)
			(= x 26)
		)
		(gGame setCursor: gNormalCursor 1)
		(SetCursor 100 30)
		(super init: &rest)
	)

	(method (onMe)
		(return (and (super onMe: &rest) (localproc_0 1 self)))
	)

	(method (select)
		(if (super select: &rest)
			(gGame setIntensity: 100)
			(= global119 0)
			(return 1)
		)
	)
)

(instance iconRestore of GCItem
	(properties
		noun 5
		modNum 9
		x 25
		y 34
		signal 195
		mainView 982
		mainLoop 8
		cursorView 999
		helpVerb 9
		offX -12
		offY 3
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 35)
			(= x 26)
		)
		(super init: &rest)
	)

	(method (onMe)
		(return (and (super onMe: &rest) (localproc_0 1 self)))
	)

	(method (select)
		(if (super select: &rest)
			(gGame setIntensity: 100)
			(= global119 0)
			(return 1)
		)
	)
)

(instance iconRestart of GCItem
	(properties
		noun 6
		modNum 9
		x 25
		y 52
		signal 195
		mainView 982
		mainLoop 9
		cursorView 999
		helpVerb 9
		offX -12
		offY 3
	)

	(method (onMe)
		(return (and (super onMe: &rest) (localproc_0 1 self)))
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 53)
			(= x 26)
		)
		(super init: &rest)
	)
)

(instance iconQuit of GCItem
	(properties
		noun 7
		modNum 9
		x 25
		y 74
		signal 195
		mainView 982
		mainLoop 10
		cursorView 999
		helpVerb 9
		offX -12
		offY 3
	)

	(method (onMe)
		(return (and (super onMe: &rest) (localproc_0 1 self)))
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 72)
			(= x 26)
		)
		(super init: &rest)
	)
)

(instance iconAbout of GCItem
	(properties
		noun 8
		modNum 9
		x 24
		y 108
		signal 195
		mainView 982
		mainLoop 4
		cursorView 999
		helpVerb 9
		offX -12
		offY 3
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 124)
			(= x 33)
		)
		(super init: &rest)
	)

	(method (select)
		(super select: &rest)
		(gGame setScript: (ScriptID 8 0)) ; aboutScr
	)
)

(instance iconGCHelp of GCItem
	(properties
		noun 9
		modNum 9
		x 47
		y 106
		signal 131
		message 9
		mainView 982
		mainLoop 5
		cursorView 989
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= x 55)
			(= y 122)
		)
		(self setCursor: 989 0 0)
		(super init: &rest)
	)
)

(instance iconPlay of GCItem
	(properties
		noun 10
		modNum 9
		x 25
		y 88
		signal 195
		mainView 982
		mainLoop 11
		cursorView 999
		helpVerb 9
		offX -12
		offY 3
	)

	(method (onMe)
		(return (and (super onMe: &rest) (localproc_0 1 self)))
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10982)
			(= y 90)
			(= x 26)
		)
		(super init: &rest)
	)
)

(instance iconText of GCItem
	(properties
		noun 17
		modNum 9
		x 73
		y 121
		signal 195
		mainView 982
		mainLoop 15
		maskCel 1
		cursorView 999
		helpVerb 9
	)

	(method (init)
		(if (not (IsHiRes))
			(= mainView 9825)
		)
		(cond
			((& gMsgType $0001)
				(if (IsHiRes)
					(= maskView (= mainView 10987))
				else
					(= maskLoop (= mainLoop 0))
				)
			)
			((IsHiRes)
				(= maskView (= mainView 10982))
			)
			(else
				(= maskLoop (= mainLoop 1))
			)
		)
		(super init: &rest)
	)

	(method (select)
		(super select: &rest)
		(if (& gMsgType $0002)
			(= gMsgType 1)
			(if (IsHiRes)
				(= maskView (= mainView 10987))
			else
				(= maskLoop (= mainLoop 0))
			)
		else
			(= gMsgType 2)
			(if (IsHiRes)
				(= maskView (= mainView 10982))
			else
				(= maskLoop (= mainLoop 1))
			)
		)
		(self show:)
		(return 0)
	)
)

(instance greenLight of IconI
	(properties
		x 1000
		y 1000
		mainView 10982
		mainLoop 6
		mainCel 1
		maskView 10982
		maskLoop 6
	)

	(method (init)
		(self setPri: (+ (GetHighPlanePri) 1))
		(super init: &rest)
	)
)

